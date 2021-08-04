public class CalculadorPrestaciones {
    
    public CalculadorPrestaciones(Empleado empleado){
        
        this.empleado = empleado;
        this.calcularSalarioPromedioMensual(empleado);
        this.calcularSalarioDiario(empleado);
        this.calcularTiempoLaboracion(empleado);
    }
    
     //Propiedades Iniciales:
    private Empleado empleado;
    private double salarioDiario;
    private double salarioPromedioMensual;
    
    private double regaliaPascual;
    private double prestacionCesantia;
    private double prestacionVacacional;
    private double prestacionPreaviso;
    private boolean estadoPreaviso;
    private double tiempoLaboracion[];
    
    //Metodos calculo básicos:
    private void calcularSalarioPromedioMensual(Empleado empleado){
        this.salarioPromedioMensual = empleado.getSalario() / 12;
    }
    
    private void calcularSalarioDiario(Empleado empleado){
        this.salarioDiario = empleado.getSalario() / 23.83;
    }
    
   private void calcularTiempoLaboracion(Empleado empleado){
    
    double[] fechaEntrada = empleado.getFecha_entrada();
    double[] fechaSalida = empleado.getFecha_salida();
    
    double[] fecha = {0,0,0};
    
    // Resta decimal con los días.	 
      if(fechaSalida[0] < fechaEntrada[0]){
          
         fechaSalida[1]= fechaSalida[1] - 1;      
         fecha[0] =  ((fechaSalida[0]+30) - fechaEntrada[0]);
         
       }
       else{
       	     fecha[0] = (fechaSalida[0] - fechaEntrada[0]);
       }
       
       
    // Resta decimal con los meses.	 
       if((fechaSalida[1] < fechaEntrada[1]) ){
            
            fechaSalida[2]= fechaSalida[2] - 1;
            fecha[1] =  (fechaSalida[1]+12) - fechaEntrada[1];
       }
       else{
       	     fecha[1] = (fechaSalida[1] - fechaEntrada[1]);
       }
       
       
    // Resta decimal con los años.	 
       if(((fechaSalida[2] < fechaEntrada[2]) || fechaSalida[2] == fechaEntrada[2]) ){
            
            fecha[2] =  0;
       }
       else{
       	     fecha[2] = (fechaSalida[2] - fechaEntrada[2]);
       }
           
    System.out.println("" + fecha[0]+ " - " + fecha[1]+ " - " +fecha[2]);
       
       
   }
   
    
    public void calculoRegaliaPascual(){}
    public void calculoPrestacionCesantia(){}
    public void calculoPrestacionVacacional(){}
    public void checkEstadoPreaviso(){}
    public void calculoPrestacionPreaviso(){}

}
