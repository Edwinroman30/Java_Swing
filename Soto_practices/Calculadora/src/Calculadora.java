
public class Calculadora {
    
//    private double num1;
//    private double num2;
    
//Con netbeans crear una calculadora:
//- Debe crear una clase llamada Calculadora que contenga los metodos: sumar, restar, multiplicar y dividir que retornen el resultado.
//- Crear una clase llamada GUI que contenga dos cajas de textos para la entrada de los datos. Un boton para cada operacion y un label para el resultado.
//Recuerde utilizar la clase Calculadora para recibir los datos y retornar el resultado.
//Nota: Debe entregar el archivo comprimido del proyecto de Netbeans en un archivo .zip.
    
    
    public Calculadora(){
        //DO SOMETHING
        
    }
    
    public double sumar(double num1, double num2){
        return (num1+num2);
    }
    
    public double restar(double num1, double num2){
        return (num1-num2);
    }
    
    public double multiplicar(double num1, double num2){
        return (num1*num2);
    }
    

    public double dividir(double num1, double num2){
        if(num2 == 0){
            return 0;
        }
        else{
            return (num1/num2);
        }
    }
    
}
