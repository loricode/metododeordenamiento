
import javax.swing.JOptionPane;


public class Lista {
  private Nodo cabeza;
    public int tamanio;
    public Nodo vector[];
   public Lista(){
      cabeza=null;
      tamanio=0;
      vector=null;
   }
   
      public boolean buscar(String referencia){
      
        Nodo aux = cabeza;
       
        boolean encontrado = false;
       
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia.equals(aux.getFecha())){
                
                encontrado = true;
            }
            else{
               
                aux = aux.getSiguiente();
            }
        }
       
        return encontrado;
    }
      
      public String caja(String men){
         return JOptionPane.showInputDialog(men);
      }
   
   
   
   
   public void agregarNodo(){
      String cod=caja("digite el codigo");
      String nomA=caja("nombre y apellido ");
      boolean estado = true;
      int p = Integer.parseInt(caja("prioridad"
              + "\n0. alta"
              + "\n1. media"
              + "\n2. baja"));
     String fecha =caja("fecha en aaa-mm-dd");
       boolean bandera = buscar(fecha);
     if(bandera){
        JOptionPane.showMessageDialog(null, "misma fecha error");
        agregarNodo();
        
     
     } else{
     
        Nodo nodo = new Nodo();
        nodo.setCodigo(cod);
        nodo.setNombreApe(nomA);
        nodo.setEstado(estado);
        nodo.setPrioridad(p);
        nodo.setFecha(fecha);
    
        
        Nodo ultimo;
      if(nodo!=null){
         if(cabeza==null){
           nodo.setAnterior(null);
           cabeza=nodo;
        
      }else{
         ultimo=cabeza;
         while(ultimo.getSiguiente()!=null )
            ultimo=ultimo.getSiguiente();
            ultimo.setSiguiente(nodo);
            nodo.setAnterior(ultimo);
         
      }
    }   
        
 }
 }
   
 public void mostrarListaOrdenada(){
    ordenarPaciente();
    Nodo aux;
   aux=cabeza;
   String cadena="Lista\n";
   while (aux != null) {
      cadena+= "codigo: "+aux.getCodigo()+"\n";
      cadena+= "nombre: "+aux.getNombreApe()+"\n";
      cadena+= "estado: "+aux.isEstado()+"\n";
      cadena+= "prioridad: "+aux.getPrioridad()+"\n";
      cadena+= "fecha: "+aux.getFecha()+"\n";
      aux = aux.getSiguiente();
      
   }
   JOptionPane.showMessageDialog(null, cadena);
}
 
 
 public void mostrarPorFecha(int p){
    ordenarPaciente();
    Nodo aux;
   aux=cabeza;
   String cadena="Lista\n";
   while (aux != null) {
     if(aux.getPrioridad()==p){
      cadena+= "Codigo: "+aux.getCodigo()+"\n";
      cadena+= "Nombre: "+aux.getNombreApe()+"\n";
      cadena+= "Estado: "+aux.isEstado()+"\n";
      cadena+= "Prioridad: "+aux.getPrioridad()+"\n";
      cadena+= "Pecha: "+aux.getFecha()+"\n";    
     } 
      
    
      aux = aux.getSiguiente();
      
   }
   JOptionPane.showMessageDialog(null, cadena);
}
 
   
   
  public void mostrarListaAscendentemente(){
    copiar();
    ordenamientoShell();  
   
   String cadena="Lista\n";
   for(int i=0;i<vector.length; i++) {
      cadena+= "Codigo: "+vector[i].getCodigo()+"\n";
      cadena+= "Nombre: "+vector[i].getNombreApe()+"\n";
      cadena+= "Estado: "+vector[i].isEstado()+"\n";
      cadena+= "Prioridad: "+vector[i].getPrioridad()+"\n";
      cadena+= "Fecha: "+vector[i].getFecha()+"\n";
     }
   
   JOptionPane.showMessageDialog(null, cadena);
}   
     
   
        
  public void copiar(){
  int i=0;
     vector = new Nodo[tamanio];
     Nodo aux=cabeza;
     while(aux!=null){
        if(aux.getPrioridad()==0){
        Nodo nodo = new Nodo(
        aux.getCodigo(),
        aux.getNombreApe(),
        aux.isEstado(),
        aux.getPrioridad(),
        aux.getFecha()
        );    
        
        vector[i] = aux;
        i++;    
        }
     
       
        aux=aux.getSiguiente();
         
     }
  }
  
  
   public void Cambiar(int p1, int p2){
     Nodo nodo;
     nodo=vector[p1];
     vector[p1]=vector[p2];
     vector[p2]=nodo;
     
   }
   
      
  public void ordenamientoShell(){
     int i,j,d;
     d=(vector.length)/2;
     while(d>=1){
        for(i=d;i<vector.length;i++){
           j=i;
           while(j-d>=0){
              if(vector[j-d].getCodigo().compareTo(vector[j].getCodigo())> 0){
                 Cambiar(j-d, j);
                 j=j-d;
              }
              else
                 break;
           }
        }
        d=d/2;
        
     }
   
   }
  
  
 public void eliminarPorPrioridadCatidad(){
    int cant0=0;
    int cant1=0, cant2=0;
    Nodo aux;
   aux=cabeza;
   String cadena="Cantidad segun prioridad\n"
                 + "elige por prioridad a eliminar";
   while (aux != null) {
     if(aux.getPrioridad()==0){
        cant0++;
     }
     
     if(aux.getPrioridad()==1){
        cant1++;
     }
     
     if(aux.getPrioridad()==2){
       cant2++; 
     }
      
      aux = aux.getSiguiente();
      
   }
   int p =Integer.parseInt(JOptionPane.showInputDialog(null, cadena
           + "\n alta: "+cant0
           + "\n media: "+cant1
           + "\n baja: "+cant2));
   
   eliminar((buscar(p)));
}  
 
    
public void eliminar(Nodo per){
   Nodo ant;
   Nodo sig;
   if(per!=null){
      ant = per.getAnterior();
      sig = per.getSiguiente();
      if(per==cabeza)
         cabeza=sig;
      if(ant!=null)
         ant.setSiguiente(sig);
      if(sig!=null)
         sig.setAnterior(ant);
         per.setSiguiente(null);
         per.setAnterior(null);
   }
}
 
 
 public Nodo buscar(int p){
      Nodo nodo;
      nodo=cabeza;
      while(nodo!=null){
         if(nodo.getPrioridad()==p)
            break;
         else
            nodo=nodo.getSiguiente();
      }
      
      return nodo;
   }
  
  
public void ordenarPaciente(){
   Nodo pi;
   
   Nodo pj;
   pi=cabeza;
   while(pi!=null){
      pj=pi.getSiguiente();
      while(pj!=null){
         if(pi.getPrioridad()>pj.getPrioridad())
          cambiarNodo(pi,pj);
         pj=pj.getSiguiente();
         
      }
      pi=pi.getSiguiente();
   }
   
}


protected void cambiarNodo(Nodo n1, Nodo n2){
   Nodo aux = new Nodo();
   copiarNodo(aux,n1);
   copiarNodo(n1,n2);
   copiarNodo(n2,aux);
   
}


protected  void copiarNodo(Nodo n1,Nodo n2){
   
 n1.setCodigo(n2.getCodigo());
 n1.setNombreApe(n2.getNombreApe());
 n1.setEstado(n2.isEstado());
 n1.setPrioridad(n2.getPrioridad());
 n1.setFecha(n2.getFecha());
   
}  
}
