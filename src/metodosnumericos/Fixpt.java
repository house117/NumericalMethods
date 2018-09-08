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
public class Fixpt {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double x0, tolerancia;
                Scanner input = new Scanner(System.in);

        System.out.println("Ingresa x0:");
        x0 = input.nextDouble();
        System.out.println("Ingresa la tolerancia: ");
        tolerancia = 0.5*Math.pow(10, 2-input.nextDouble());
        Fixpt(x0, tolerancia, 100, 0, 100);
    }
    public static void Fixpt(double x0, double es, int imax, int iter, double ea){
        double xr = x0;
        iter =  0;
        double valorReal = 1.5140547367340582;
        double errorVerdadero = 100;

        double xrold;
        do{
            xrold = xr;
            //System.out.println("El valor de x0 es:"+x0);
           xr = evaluarEnF(xrold);
            System.out.println("El valor de xr es: "+xr);
           iter++;
           if(xr !=  0){
               ea = Math.abs((xr-xrold)/xr)*100;
           }
            errorVerdadero = valorReal-xr;
        }while(ea > es && iter<=imax );
        System.out.println("La raiz es: "+xr);
                System.out.println("El error relativo porcentual aproximado es: "+ea);

                    System.out.println("El error verdadero es: "+errorVerdadero);

    }
    public static double evaluarEnF(double evaluador){     
        //return Math.pow(evaluador, 2)+(1/evaluador)-6;
        //return Math.pow(evaluador, 10)-1;
        //return Math.pow(evaluador, 4)-8*Math.pow(evaluador, 3)-35*Math.pow(evaluador, 2)+450*evaluador-1001;
          //      return (-Math.pow(evaluador, 4)+8*Math.pow(evaluador, 3)+35*Math.pow(evaluador, 2)+1001)/450;
                    return 1-(Math.pow(20, 2)/(9.81*Math.pow((3*evaluador+(Math.pow(evaluador, 2)/2)), 3)))*(3+evaluador);

          //return ((101.93*Math.pow(evaluador, 2)+611.62*evaluador+1100.91)/(Math.pow(evaluador, 4)*Math.pow(0.5*evaluador+3, 4)))+1;
    }
}
