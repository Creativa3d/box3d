/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paquetesguifx;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * {@link DragResizer} can be used to add mouse listeners to a {@link Region}
 * and make it resizable by the user by clicking and dragging the border in the
 * same way as a window.
 * <p>
 * Only height resizing is currently implemented. Usage: <pre>DragResizer.makeResizable(myAnchorPane);</pre>
 * 
 * @author atill
 * 
 */
public class DragResizer {
    
    /**
     * The margin around the control that a user can click in to start resizing
     * the region.
     */
    private static final int RESIZE_MARGIN = 5;

    private final Region region;

    private double y;
    private double x;
    
    private boolean initMinHeight;
    private boolean initMinWidth;
    
    private Cursor dragging;
    
    private DragResizer(Region aRegion) {
        region = aRegion;
    }

    public static void makeResizable(Region region) {
        final DragResizer resizer = new DragResizer(region);
        
        region.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizer.mousePressed(event);
            }});
        region.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizer.mouseDragged(event);
            }});
        region.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizer.mouseOver(event);
            }});
        region.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resizer.mouseReleased(event);
            }});
    }

    protected void mouseReleased(MouseEvent event) {
        dragging = null;
        region.setCursor(Cursor.DEFAULT);
    }

    protected void mouseOver(MouseEvent event) {
        if(isInDraggableZoneXMax(event) || dragging==Cursor.W_RESIZE) {
            region.setCursor(Cursor.W_RESIZE);
        }else if(isInDraggableZoneYMax(event) || dragging==Cursor.S_RESIZE) {
            region.setCursor(Cursor.S_RESIZE);
        }
        else {
            region.setCursor(Cursor.DEFAULT);
        }
    }

    protected boolean isInDraggableZoneYMax(MouseEvent event) {
        return 
                event.getY() > (region.getHeight() - RESIZE_MARGIN);
    }    
    protected boolean isInDraggableZoneXMax(MouseEvent event) {
        return  event.getX() > (region.getWidth()- RESIZE_MARGIN);
    }

    protected void mouseDragged(MouseEvent event) {
        if(dragging==null) {
            return;
        }
        
        
        if(dragging==Cursor.S_RESIZE){
            double mousey = event.getY();

            double newHeight = region.getMinHeight() + (mousey - y);

            region.setMinHeight(newHeight);
            region.setPrefHeight(newHeight);

            y = mousey;
        } else         if(dragging==Cursor.W_RESIZE){
            double mousex = event.getX();

            double newWidth = region.getMinWidth()+ (mousex - x);

            region.setMinWidth(newWidth);
            region.setPrefWidth(newWidth);

            x = mousex;
        }
    }

    protected void mousePressed(MouseEvent event) {
        
        // ignore clicks outside of the draggable margin
        if(isInDraggableZoneYMax(event)) {
            dragging = Cursor.S_RESIZE;

            // make sure that the minimum height is set to the current height once,
            // setting a min height that is smaller than the current height will
            // have no effect
            if (!initMinHeight) {
                region.setMinHeight(region.getHeight());
                initMinHeight = true;
            }

            y = event.getY();
        } else if(isInDraggableZoneXMax(event)) {
            dragging = Cursor.W_RESIZE;

            // make sure that the minimum height is set to the current height once,
            // setting a min height that is smaller than the current height will
            // have no effect
            if (!initMinWidth) {
                region.setMinWidth(region.getWidth());
                initMinWidth = true;
            }

            x = event.getX();
        }
        
        
    }
}
