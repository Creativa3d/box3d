/*
 * IEjecutar.java
 *
 * Created on 9 de septiembre de 2004, 15:17
 */
package utilesGUIx.formsGenericos.boton;

import utilesGUIx.ActionEventCZ;


/**Interfaz para ejecutar la funcion asociada al boton*/
public interface IEjecutar {

  /**
   * Accion
   * @param e evento
   * @param plIndex indice de los datos
   * @throws Exception error
   */
  public void actionPerformed(ActionEventCZ e, int plIndex) throws Exception;
}
