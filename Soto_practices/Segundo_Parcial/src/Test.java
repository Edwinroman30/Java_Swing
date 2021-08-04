public class Test {
    
    public static void main(String[] args) {
        
        double[] fechaEntrada = {16.0, 04.0, 2016.0};
        double[] fechaSalida = {09.0, 08.0, 2021.0};
        
        Empleado emple = new Empleado();
        emple.setSalario(30400);
        emple.setFechaEntrada(fechaEntrada);
        emple.setFechaSalida(fechaSalida);

        CalculadorPrestaciones cp = new CalculadorPrestaciones(emple);
        
        System.out.println(cp.getSalarioDiario());
        System.out.println(cp.getSalarioPromedioMensual());

        //System.out.println();

    }
    
}
