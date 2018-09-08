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
public class BiseccionPorx {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double xl, xu, tolerancia, xr = 0, xrAnt = 0;
        double valorReal = 1.5140547367340582;
        int contadorIteraciones = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce xl, y luego xu:");
        xl =  input.nextDouble();
        xu = input.nextDouble();
        System.out.println("Intruduce el valor de tolerancia admitido:");
        tolerancia = 0.5*Math.pow(10, 2-input.nextDouble());
        double errorPorcentualAprox = 100;
        long startTime = System.nanoTime();
        double errorVerdadero = 100;
        double xr2 = 0;
        System.out.println("PRUEBA DE ERROR: "+evaluarEnF(0.8767242431640625));
        while(errorPorcentualAprox > tolerancia ){
            xr = (2*xl+xu)/3;
            xr2 = (xl + 2*xu)/3;
            double fxrfxl = evaluarEnF(xr)*evaluarEnF(xl);
            /*System.out.println("El valor de xl es: "+xl);
            System.out.println("El valor de xu es: "+xu);
            System.out.println("El valor de xr es: "+xr);
            System.out.println("El valor de fxrfxl es: "+fxrfxl);*/

            double resul = fxrfxl<0?(xu=xr):(xl=xr);
            
            errorPorcentualAprox = Math.abs((xr-xrAnt)/xr)*100;
            if (errorPorcentualAprox < 0) errorPorcentualAprox *= -1;
            errorVerdadero = valorReal-xr;
            if(fxrfxl == 0) errorPorcentualAprox = tolerancia;
            xrAnt = xr;
            System.out.println("Iteración"+contadorIteraciones+"----------------------------");
            System.out.println("Raíz:"+xr);
            System.out.println("Ea: "+errorPorcentualAprox);
            System.out.println("Et "+errorVerdadero);
            contadorIteraciones++;
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("======================================Finalizado======================================");
        System.out.println("El valor de la raiz es = "+xr+"\nSe alcanzó el nivel de tolerancia ("+tolerancia+") en la iteración:"+(contadorIteraciones));
        System.out.println("El error relativo porcentual aproximado es: "+errorPorcentualAprox);
        System.out.println("El error verdadero es: "+errorVerdadero);
        System.out.println("El tiempo de ejecucion fue: "+totalTime/Math.pow(10, 9)+" segundos");
    }
    public static double evaluarEnF(double evaluador){     
        //return Math.pow(evaluador, 2)+(1/evaluador)-6;
         //       return Math.pow(evaluador, 10)-1;
         //f(x)=-0.5x^(2)+2.5x+4.5
         //return -0.5*Math.pow(evaluador, 2)+2.5*evaluador+4.5;
           //      return Math.pow(evaluador, 4)-8*Math.pow(evaluador, 3)-35*Math.pow(evaluador, 2)+450*evaluador-1001;
           //return Math.pow(evaluador, 2)-Math.sin(evaluador);
           //return Math.log(Math.pow(evaluador, 2))-0.7;
           //return Math.pow(evaluador, 2)*Math.abs(Math.cos(Math.sqrt(evaluador)))-5;
                    return 1-(Math.pow(20, 2)/(9.81*Math.pow((3*evaluador+(Math.pow(evaluador, 2)/2)), 3)))*(3+evaluador);

    }
}
