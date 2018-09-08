/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos;

import java.util.Scanner;
/**
 *
 * @author House
 */
public class MetodosNumericos11 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double xl, xu, tolerancia, xr = 0, xrAnt = 0;
        int contadorIteraciones = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce xl, xu y la distancia a la que quieres aproximar: ");
        xl =  input.nextDouble();
        xu = input.nextDouble();
        tolerancia =input.nextDouble();
        int toleranciaInt = (int)((Math.log((xu-xl)/tolerancia))/Math.log(2));
        System.out.println("El numero de iteraciones que se ocupara es: "+toleranciaInt);
        long startTime = System.nanoTime();
        for (int i = 0; i < toleranciaInt; i++) {
            xr = (xl + xu) / 2;
            double fxrfxl = evaluarEnF(xr) * evaluarEnF(xl);
            System.out.println("El valor de fxrfxl es: "+fxrfxl);
            double resul = fxrfxl < 0 ? (xu = xr) : (xl = xr);
            xrAnt = xr;
            contadorIteraciones++;
        }
        System.out.println("======================================Finalizado======================================");
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("======================================Finalizado======================================");
        System.out.println("El valor de la raiz es = "+xr+"\nSe alcanzó el nivel de tolerancia ("+tolerancia+") en la iteración:"+contadorIteraciones);
        //System.out.println("El error relativo porcentual aproximado es: "+errorPorcentualAprox);
        System.out.println("El tiempo de ejecucion fue: "+totalTime/Math.pow(10, 9)+" segundos");
        //Se alcanzó el nivel de tolerancia ("+tolerancia+") en la iteración:"+contadorIteraciones
    }
    public static double evaluarEnF(double evaluador){     
        return Math.pow(evaluador, 2)+(1/evaluador)-6;
    }
}
