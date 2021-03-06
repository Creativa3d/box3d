/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilesAndroid.util;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.util.Log;
import android.view.*;

import java.io.IOException;
import java.util.List;

import utiles.JDateEdu;
import utiles.JDepuracion;



// ----------------------------------------------------------------------

public class CameraPreview extends Activity {
    private Preview mPreview;
    private Camera mCamera;
    public static Camera.PictureCallback moCallBack;
    public static int mlResolWidth;
    public static int mlResolHeight;
    public static boolean mbActivarPictureSize=true;

    private JDateEdu moImagenCapturada = new  JDateEdu();
//    int numberOfCameras;
//    int cameraCurrentlyLocked;
//
//    // The first rear facing camera
//    int defaultCameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide the window title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create a RelativeLayout container that will hold a SurfaceView,
        // and set it as the content of our activity.
        mPreview = new Preview(this,mlResolWidth,mlResolHeight,mbActivarPictureSize);
        setContentView(mPreview);
        mPreview.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
            	synchronized(this){
	            	try {
						if(JDateEdu.diff(JDateEdu.mclSegundos, new JDateEdu(), moImagenCapturada)>1.5 ){
							moImagenCapturada=new JDateEdu();
						    mCamera.autoFocus(new Camera.AutoFocusCallback() {
						        public void onAutoFocus(boolean arg0, Camera arg1) {
						            mCamera.takePicture(null, null, new Camera.PictureCallback() {
						                public void onPictureTaken(byte[] arg0, Camera arg1) {
						                    moCallBack.onPictureTaken(arg0, arg1);
						                    cerrarCamara();
						                    CameraPreview.this.finish();
						                }
						            });
						        }
						    });
						}
					} catch (Exception e) {
						JDepuracion.anadirTexto(getClass().getName(), e);
					}
            	}
            }
        } );
    }

    private void cerrarCamara(){
        // Because the Camera object is a shared resource, it's very
        // important to release it when the activity is paused.
        if (mCamera != null) {
            mPreview.setCamera(null);
            mCamera.release();
            mCamera = null;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        // Open the default i.e. the first rear facing camera.
        mCamera = Camera.open();
//        cameraCurrentlyLocked = defaultCameraId;
        mPreview.setCamera(mCamera);
    }

    @Override
    protected void onPause() {
        super.onPause();
        cerrarCamara();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cerrarCamara();
    }    
}
/**
 * A simple wrapper around a Camera and a SurfaceView that renders a centered preview of the Camera
 * to the surface. We need to center the SurfaceView because not all devices have cameras that
 * support preview sizes at the same aspect ratio as the device's display.
 */
class Preview extends ViewGroup implements SurfaceHolder.Callback {
    private final String TAG = "Preview";

    private SurfaceView mSurfaceView;
    private SurfaceHolder mHolder;
    private Size mPreviewSize;
    private Size mPictureSize;
    private List<Size> mSupportedPreviewSizes;
    private List<Size> mSupportedPictureSizes;
    private Camera mCamera;
    private int mlResolWidth;
    private int mlResolHeight;
    private final boolean mbActivarPictureSize;
    
    Preview(Context context, int plWidth, int plHeight, boolean pbActivarPictureSize) {
        super(context);
        mbActivarPictureSize=pbActivarPictureSize;

        mSurfaceView = new SurfaceView(context);
        addView(mSurfaceView);

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = mSurfaceView.getHolder();
        mHolder.addCallback(this);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mlResolWidth=plWidth;
        mlResolHeight=plHeight;
    }

    public void setCamera(Camera camera) {
        mCamera = camera;
        if (mCamera != null) {
            mSupportedPreviewSizes = mCamera.getParameters().getSupportedPreviewSizes();
            mSupportedPictureSizes = mCamera.getParameters().getSupportedPictureSizes();
            requestLayout();
        }
    }

    public void switchCamera(Camera camera) {
       setCamera(camera);
       try {
           camera.setPreviewDisplay(mHolder);
       } catch (IOException exception) {
           Log.e(TAG, "IOException caused by setPreviewDisplay()", exception);
       }
       Camera.Parameters parameters = camera.getParameters();
       try {
           parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
       } catch (Throwable exception) {
           Log.e(TAG, "IOException caused by setPreviewSize()", exception);
       }
       requestLayout();

       camera.setParameters(parameters);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // We purposely disregard child measurements because act as a
        // wrapper to a SurfaceView that centers the camera preview instead
        // of stretching it.
        final int width = resolveSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        final int height = resolveSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);

        if (mSupportedPreviewSizes != null) {
            mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSizes, width, height);
        }
        if (mSupportedPictureSizes != null && mlResolWidth>0 && mlResolHeight>0) {
            mPictureSize = getOptimalPreviewSize(mSupportedPictureSizes, mlResolWidth, mlResolHeight);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed && getChildCount() > 0) {
            final View child = getChildAt(0);

            final int width = r - l;
            final int height = b - t;

            int previewWidth = width;
            int previewHeight = height;
            if (mPreviewSize != null) {
                previewWidth = mPreviewSize.width;
                previewHeight = mPreviewSize.height;
            }

            // Center the child SurfaceView within the parent.
            if (width * previewHeight > height * previewWidth) {
                final int scaledChildWidth = previewWidth * height / previewHeight;
                child.layout((width - scaledChildWidth) / 2, 0,
                        (width + scaledChildWidth) / 2, height);
            } else {
                final int scaledChildHeight = previewHeight * width / previewWidth;
                child.layout(0, (height - scaledChildHeight) / 2,
                        width, (height + scaledChildHeight) / 2);
            }
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, acquire the camera and tell it where
        // to draw.
        try {
            if (mCamera != null) {
                mCamera.setPreviewDisplay(holder);
            }
        } catch (IOException exception) {
            Log.e(TAG, "IOException caused by setPreviewDisplay()", exception);
        }
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // Surface will be destroyed when we return, so stop the preview.
        if (mCamera != null) {
            mCamera.stopPreview();
        }
    }


    private Size getOptimalPreviewSize(List<Size> sizes, int w, int h) {
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if (sizes == null) return null;

        Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        // Try to find an size match aspect ratio and size
        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }

        // Cannot find the one match the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // Now that the size is known, set up the camera parameters and begin
        // the preview.
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
        if(mbActivarPictureSize && mPictureSize!=null && mPictureSize.width>0){
            parameters.setPictureSize(mPictureSize.width, mPictureSize.height);
        }
        
        requestLayout();

        mCamera.setParameters(parameters);
        mCamera.startPreview();
    }

}