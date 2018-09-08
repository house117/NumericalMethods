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
public class MetodosNumericosToleranciaPorc {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double xl, xu, tolerancia, xr = 0, xrAnt = 0;
        int contadorIteraciones = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce xl, y luego xu:");
        xl =  input.nextDouble();
        xu = input.nextDouble();
        System.out.println("Intruduce el valor de tolerancia admitido (en porcentaje):");
        tolerancia = input.nextDouble();//0.5*Math.pow(10, 2-input.nextDouble());
        double errorPorcentualAprox = 100;
                long startTime = System.nanoTime();

        while(errorPorcentualAprox > tolerancia){
            xr = (xl+xu)/2;
            double fxrfxl = evaluarEnF(xr)*evaluarEnF(xl);
                        
            System.out.println("El valor de xl es: "+xl);
            System.out.println("El valor de xu es: "+xu);
            System.out.println("El valor de xr es: "+xr);
            System.out.println("El valor de fxrfxl es: "+fxrfxl);
            double resul = fxrfxl<0?(xu=xr):(xl=xr);

            errorPorcentualAprox = Math.abs((xr-xrAnt)/xr)*100;
            System.out.println("El error porc aprox es: "+errorPorcentualAprox);
            if (errorPorcentualAprox < 0) errorPorcentualAprox *= -1;
            if(fxrfxl == 0) errorPorcentualAprox = tolerancia;
            xrAnt = xr;
            contadorIteraciones++;
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("======================================Finalizado======================================");
        System.out.println("El valor de la raiz es = "+xr+"\nSe alcanzó el nivel de tolerancia ("+tolerancia+") en la iteración:"+contadorIteraciones);
        System.out.println("El error relativo porcentual aproximado es: "+errorPorcentualAprox);
        System.out.println("El tiempo de ejecucion fue: "+totalTime/Math.pow(10, 9)+" segundos");
    }
    public static double evaluarEnF(double evaluador){     
        //return Math.pow(evaluador, 2)+(1/evaluador)-6;
        return Math.pow(evaluador, 10)-1;
    }
}
