
import javax.swing.JOptionPane;


public class ExamenListaDobleEnlazada {

  
   public static void main(String[] args) {
       Lista obj=new Lista();
      int opc=0;
      
      do{
         opc=Byte.parseByte(JOptionPane.showInputDialog(
                 "//**// MENU PRINCIPAL //**//\n"
                 + "1. Registrar En La Lista\n"
                 + "2. Mostrar Lista Aux\n"
                 + "3. Elimnar Nodos Prioridad \n"
                 + "4. Mostrar Lista Ascendente\n "
                 + "5. Mostrar Por Prioridad\n"
                 + "6. Salir\n"
                 + "(: Elige La Opcion :)"));
         
    switch(opc){
           case 1:
            // obj.agregarNodo();
              break;
           case 2:
               obj.mostrarListaAscendentemente();
              break;
           case 3:
             obj.eliminarPorPrioridadCatidad();
              break;
           case 4:
             obj.mostrarListaOrdenada();
              
              break;
           case 5:
             int p = Integer.parseInt(JOptionPane.showInputDialog("digite la prioridad"));
               obj.mostrarPorFecha(p);
             break;
         case 6:
              opc=6;
              break;
         default:
            JOptionPane.showMessageDialog(null, "opcion invalida x)");
            break;
      } 
         
      }while(opc!=6);
      System.exit(0);
      
   }
   
}
