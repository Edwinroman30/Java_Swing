public class CalculadorPrestaciones {
    
    public CalculadorPrestaciones(Empleado empleado){
        
        this.empleado = empleado;
        this.calcularSalarioPromedioMensual(empleado);
        this.calcularSalarioDiario(empleado);
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
    private void calcularSalarioPromedioMensual(Empleado emp){
        this.salarioPromedioMensual = emp.getSalario() / 12;
    }
    
    private void calcularSalarioDiario(Empleado emp){
        this.salarioDiario = emp.getSalario() / 23.83;
    }
    
   private void calcularTiempoLaboracion(){}
   
    
    public void calculoRegaliaPascual(){}
    public void calculoPrestacionCesantia(){}
    public void calculoPrestacionVacacional(){}
    public void checkEstadoPreaviso(){}
    public void calculoPrestacionPreaviso(){}

}
