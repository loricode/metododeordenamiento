
public class Nodo {
private  String codigo;
   private String nombreApe;
   private boolean estado;
   private int prioridad;
   private String fecha;
   private Nodo siguiente;
   private Nodo anterior;
   
   public Nodo(){
      codigo="";
      nombreApe="";
      estado=false;
      prioridad=0;
      siguiente=null;
      anterior=null;
   }

   public Nodo(String codigo, String nombreApe, boolean estado, int prioridad, String fecha) {
      this.codigo = codigo;
      this.nombreApe = nombreApe;
      this.estado = estado;
      this.prioridad = prioridad;
      this.fecha = fecha;
   }

   
   
   
   public String getCodigo() {
      return codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public String getNombreApe() {
      return nombreApe;
   }

   public void setNombreApe(String nombreApe) {
      this.nombreApe = nombreApe;
   }

   public boolean isEstado() {
      return estado;
   }

   public void setEstado(boolean estado) {
      this.estado = estado;
   }

   public int getPrioridad() {
      return prioridad;
   }

   public void setPrioridad(int prioridad) {
      this.prioridad = prioridad;
   }

   public String getFecha() {
      return fecha;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public Nodo getSiguiente() {
      return siguiente;
   }

   public void setSiguiente(Nodo siguiente) {
      this.siguiente = siguiente;
   }

   public Nodo getAnterior() {
      return anterior;
   }

   public void setAnterior(Nodo anterior) {
      this.anterior = anterior;
   }
   
      
}
