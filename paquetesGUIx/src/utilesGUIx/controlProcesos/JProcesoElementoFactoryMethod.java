/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilesGUIx.controlProcesos;

import utilesGUI.procesar.IProcesoAccion;

/**
 *
 * @author eduardo
 */
public class JProcesoElementoFactoryMethod implements IProcesoElementoFactoryMethod{

    public IProcesoElemento getProcesoElemento(IProcesoAccion poProceso, boolean pbConMostrarForm, JProcesoManejador poManejador) {
        return new JProcesoElemento(poProceso, pbConMostrarForm, poManejador);
    }
    
}
