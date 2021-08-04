public class Test {
    
    public static void main(String[] args) {
        
        double[] fechaEntrada = {1.0, 08.0, 2001.0};
        double[] fechaSalida = {31.0, 03.0, 2012.0};
        
        Empleado emple = new Empleado();
        emple.setSalario(30400);
        emple.setFechaEntrada(fechaEntrada);
        emple.setFechaSalida(fechaSalida);

        CalculadorPrestaciones cp = new CalculadorPrestaciones(emple);
        
        System.out.println(cp.getSalarioPromedioMensual());
        System.out.println(cp.getSalarioDiario());
        //Si pone un true fue que le preavisaron por lo cual no le pagaran.
        cp.checkEstadoPreaviso(false);
        
        System.out.println(cp.getPrestacionPreaviso());
        cp.calculoPrestacionCesantia();
        System.out.println(cp.getPrestacionCesantia());

        cp.calculoPrestacionVacacional();
        System.out.println(cp.getPrestacionVacacional());
        
        cp.calculoRegaliaPascual();
        System.out.println(cp.getRegaliaPascual());
        
    }
    
}
