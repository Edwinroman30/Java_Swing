public class CalculadorPrestaciones {
    
    public CalculadorPrestaciones(Empleado empleado){
        
        this.empleado = empleado;
        this.calcularSalarioPromedioMensual(empleado);
        this.calcularSalarioDiario();
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
    
    private void calcularSalarioDiario(){
        this.salarioDiario = this.salarioPromedioMensual / 23.83;
    }
    
    private void calcularTiempoLaboracion(Empleado empleado){
    
    double[] fechaEntrada = empleado.getFechaEntrada();
    double[] fechaSalida = empleado.getFechaSalida();
    
    double[] fecha_final = {0,0,0};
    
    // Resta decimal con los días.	 
      if(fechaSalida[0] < fechaEntrada[0]){
          
         fechaSalida[1]= fechaSalida[1] - 1;      
         fecha_final[0] =  ((fechaSalida[0]+30) - fechaEntrada[0]);
         
       }
       else{
       	     fecha_final[0] = (fechaSalida[0] - fechaEntrada[0]);
       }
       
       
    // Resta decimal con los meses.	 
       if((fechaSalida[1] < fechaEntrada[1]) ){
            
            fechaSalida[2]= fechaSalida[2] - 1;
            fecha_final[1] =  (fechaSalida[1]+12) - fechaEntrada[1];
       }
       else{
       	     fecha_final[1] = (fechaSalida[1] - fechaEntrada[1]);
       }
       
       
    // Resta decimal con los años.	 
       if(((fechaSalida[2] < fechaEntrada[2]) || fechaSalida[2] == fechaEntrada[2]) ){
            
            fecha_final[2] =  0;
       }
       else{
       	     fecha_final[2] = (fechaSalida[2] - fechaEntrada[2]);
       }
    
        this.tiempoLaboracion = fecha_final;
   }
   
    public void checkEstadoPreaviso(boolean checkPreaviso){
    
        if(checkPreaviso == false){
            //DO SOMETHING
            this.calculoPrestacionPreaviso();
        }
    }

    private void calculoPrestacionPreaviso(){
        
        for(int i=0; i<1; i++){
            if(this.tiempoLaboracion[2] >= 1){
                this.prestacionPreaviso = (this.salarioDiario * 28);
                break;
            }
            
            if((this.tiempoLaboracion[1] >= 6) && (this.tiempoLaboracion[1] <= 11)){
                this.prestacionPreaviso = (this.salarioDiario * 14);
                break;
            }
            
            if(this.tiempoLaboracion[1] >= 3 && this.tiempoLaboracion[1] <= 5){
                this.prestacionPreaviso = (this.salarioDiario * 7);
                break;
            }
        }
        
    }

    public void calculoPrestacionCesantia(){
    
        //Escala anual:
        for(int i=0; i<1; i++){
            if(this.tiempoLaboracion[2] >= 5){
                this.prestacionCesantia = (this.tiempoLaboracion[2] * 23);
                break;
            }
            
            if(this.tiempoLaboracion[2] > 1 && this.tiempoLaboracion[2] < 5){
                this.prestacionCesantia = (this.tiempoLaboracion[2] * 21);
                break;
            }
                    
        }
        
        //Escala mensuales:
        for(int i=0; i<1; i++){
            if(this.tiempoLaboracion[1] >= 6 && this.tiempoLaboracion[1] <= 11){
                this.prestacionCesantia = this.prestacionCesantia + 13;
                break;
            }
            
            if(this.tiempoLaboracion[2] >= 3 && this.tiempoLaboracion[2] <= 5){
                this.prestacionCesantia = this.prestacionCesantia + 6;
                break;
            }                   
        }
        
        //Luego de determinar y addicionar los años y sus fracciones ahora realizar, terminar el calculo.
        this.prestacionCesantia = (this.prestacionCesantia * this.salarioDiario);
              
    }

    public void calculoPrestacionVacacional(){
        
      for(int i=0; i<1; i++){
        //Escala anual:
            if(this.tiempoLaboracion[2] > 5){
                this.prestacionVacacional += 18;
                break;
            }
            
            if(this.tiempoLaboracion[2] >= 1 && this.tiempoLaboracion[2] <=5){
                this.prestacionVacacional += 14;
                break;
            }
            
        //Mensual
        
            if(this.tiempoLaboracion[1] >= 5 && this.tiempoLaboracion[1] <=5.99){
                this.prestacionVacacional += 6;
                break;
            }
            
            if(this.tiempoLaboracion[1] >= 6 && this.tiempoLaboracion[1] <=6.99){
                this.prestacionVacacional += 7;
                break;
            }
            
            if(this.tiempoLaboracion[1] >= 7 && this.tiempoLaboracion[1] <=7.99){
                this.prestacionVacacional += 8;
                break;
            }
            
            if(this.tiempoLaboracion[1] >= 8 && this.tiempoLaboracion[1] <=8.99){
                this.prestacionVacacional += 9;
                break;
            } 
            
            if(this.tiempoLaboracion[1] >= 9 && this.tiempoLaboracion[1] <=9.99){
                this.prestacionVacacional += 10;
                break;
            }
            
            if(this.tiempoLaboracion[1] >= 10 && this.tiempoLaboracion[1] <=10.99){
                this.prestacionVacacional += 11;
                break;
            } 
            
            if(this.tiempoLaboracion[1] >= 11 && this.tiempoLaboracion[1] <=11.99){
                this.prestacionVacacional += 12;
                break;
            } 
   
      }
      
      //CALCULO SEGUN LA ESCALA
       this.prestacionVacacional = this.prestacionVacacional * this.salarioDiario;

    }

    
    public void calculoRegaliaPascual(){
   
        this.regaliaPascual = (empleado.getSalario() * empleado.getFechaSalida()[1]) / 12;
    }

    
    //GETTERS AND SETTERS
    public double getSalarioDiario() {
        return this.salarioDiario;
    }

    public double getSalarioPromedioMensual() {
        return this.salarioPromedioMensual;
    }

    public double getPrestacionPreaviso() {
        return this.prestacionPreaviso;
    }
    
    public double getPrestacionCesantia() {
        return this.prestacionCesantia;
    }

    public double getPrestacionVacacional() {
        return prestacionVacacional;
    }

    public double getRegaliaPascual() {
        return regaliaPascual;
    }

}
