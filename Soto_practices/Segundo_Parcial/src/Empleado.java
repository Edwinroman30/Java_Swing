public class Empleado {
    
//    private String nombre;
//    private String cedula; 
      private double salario;
    
    //FORMATO DE ENTRADA (DÍA-MES-AÑO)
    private double fechaEntrada[];
    private double fechaSalida[];
    
    public Empleado(){     }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario > 0){
           this.salario = salario;
        }
    }

    public double[] getFechaEntrada() {
        return this.fechaEntrada;
    }

    public void setFechaEntrada(double[] fecha_entrada) {
        
        for(double fech : fecha_entrada ){
            if(fech < 0){
                this.fechaEntrada[0] = 0;
                this.fechaEntrada[1] = 0;
                this.fechaEntrada[2] = 0;
            }
            else{
                this.fechaEntrada = fecha_entrada;
            }
        }     
    }

    public double[] getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(double[] fecha_salida) {
        
        for(double fech : fecha_salida ){
            if(fech < 0){
                this.fechaSalida[0] = 0;
                this.fechaSalida[1] = 0;
                this.fechaSalida[2] = 0;
            }
            else{
                this.fechaSalida = fecha_salida;
            }
        } 
    }
    
}
