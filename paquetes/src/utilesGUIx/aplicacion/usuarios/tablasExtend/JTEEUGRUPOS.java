/*
* JTEEUGRUPOS.java
*
* Creado el 31/3/2009
 */
package utilesGUIx.aplicacion.usuarios.tablasExtend;

import ListDatos.*;
import ListDatos.estructuraBD.*;
import utilesGUIx.JGUIxConfigGlobalModelo;
import utilesGUIx.aplicacion.usuarios.tablas.JTUGRUPOS;

public class JTEEUGRUPOS extends JTUGRUPOS {

    private static final long serialVersionUID = 1L;
    public static String[] masCaption = JGUIxConfigGlobalModelo.getInstancia().getTextosForms().getCaptions(msCTabla, masNombres);

    /**
     * Crea una instancia de la clase intermedia para la tabla UGRUPOS
     * incluyendole el servidor de datos
     */
    public JTEEUGRUPOS(IServerServidorDatos poServidorDatos) {
        super();
        moList = new JListDatos(poServidorDatos, msCTabla, masNombres, malTipos, malCamposPrincipales, masCaption, malTamanos);
        moList.addListener(this);
        moList.getFields().get(0).setActualizarValorSiNulo(JFieldDef.mclActualizarUltMasUno);
    }

    public static boolean getPasarCache() {
        return false;
    }

    public static JTEEUGRUPOS getTabla(final String psCODIGOGRUPO, final IServerServidorDatos poServer) throws Exception {
        JTEEUGRUPOS loTabla = new JTEEUGRUPOS(poServer);
        if (getPasarCache()) {
            loTabla.recuperarTodosNormalCache();
            loTabla.moList.getFiltro().addCondicion(
                    JListDatosFiltroConj.mclAND,
                    JListDatos.mclTIgual,
                    malCamposPrincipales,
                    new String[]{psCODIGOGRUPO});
            loTabla.moList.filtrar();
        } else {
            loTabla.recuperarFiltradosNormal(new JListDatosFiltroElem(
                    JListDatos.mclTIgual, malCamposPrincipales, new String[]{psCODIGOGRUPO}), false);
        }
        return loTabla;
    }

}
