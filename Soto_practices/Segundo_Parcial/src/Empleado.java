public class Empleado {
    
//    private String nombre;
//    private String cedula; 
    private double salario;
    
    //FORMATO DE ENTRADA (DÍA-MES-AÑO)
    private double fecha_entrada[];
    private double fecha_salida[];
    
    public Empleado(){
        
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario > 0){
           this.salario = salario;
        }
    }

    public double[] getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(double[] fecha_entrada) {
        
        for(double fech : fecha_entrada ){
            if(fech < 0){
                this.fecha_entrada[0] = 0;
                this.fecha_entrada[1] = 0;
                this.fecha_entrada[2] = 0;
            }
            else{
                this.fecha_entrada = fecha_entrada;
            }
        }     
    }

    public double[] getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(double[] fecha_salida) {
        
        for(double fech : fecha_salida ){
            if(fech < 0){
                this.fecha_salida[0] = 0;
                this.fecha_salida[1] = 0;
                this.fecha_salida[2] = 0;
            }
            else{
                this.fecha_salida = fecha_salida;
            }
        } 
    }
    
}
