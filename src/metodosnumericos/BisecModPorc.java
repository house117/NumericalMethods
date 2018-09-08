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
public class BisecModPorc {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double xl, xu, tolerancia, xr = 0, xrOld = 0;
        int iter = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce xl, y luego xu:");
        xl =  input.nextDouble();
        System.out.println("Introduce xu:");
        xu = input.nextDouble();
        System.out.println("Intruduce el valor de tolerancia admitido:");
        tolerancia =input.nextDouble();
        int toleranciaInt = (int)((Math.log((xu-xl)/tolerancia))/Math.log(2));
        //int toleranciaInt = (int)tolerancia;
        System.out.println("El numero de iteraciones que se ocupara es: "+toleranciaInt);
        /*for(int i=0; i<toleranciaInt; i++){
            System.out.println("Holaaa");   
        }*/
        iter = 0;
        xr = 0;
        double errorAbsoluto = 100;
                long startTime = System.nanoTime();

        do{
            xrOld = xr;
            xr = (xl+xu)/2;         
            iter=iter+1;
            double fl = evaluarEnF(xl);
            double fr = evaluarEnF(xr);
            System.out.println("Valor xr es: "+xr);
            if(xr!=0){
                System.out.println("xr dif de cero");          
                errorAbsoluto = Math.abs((xr-xrOld)/xr)*100;
                System.out.println("El error absoluto es: "+errorAbsoluto);
            }
            double test = fl*fr;
            System.out.println("El varor de test es: "+test);
            if(test<0){
                xu = xr;
            }else if(test>0){
                xl=xr;
                fl = fr;
            }else{
                errorAbsoluto=0;
            }
        }while(errorAbsoluto>tolerancia || iter<=toleranciaInt);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("======================================Finalizado======================================");
        System.out.println("El valor de la raiz es = "+xr+"\nSe alcanzó el nivel de tolerancia ("+tolerancia+") en la iteración:"+iter);
       // System.out.println("El error relativo porcentual aproximado es: "+errorPorcentualAprox);
        System.out.println("El tiempo de ejecucion fue: "+totalTime/Math.pow(10, 9)+" segundos");
    }
    public static double evaluarEnF(double evaluador){     
        //return Math.pow(evaluador, 2)+(1/evaluador)-6;
        //return Math.pow(evaluador, 10)-1;
         //       return Math.pow(evaluador, 4)-8*Math.pow(evaluador, 3)-35*Math.pow(evaluador, 2)+450*evaluador-1001;
         return 1-(Math.pow(20, 2/(9.81*Math.pow((3*evaluador+(Math.pow(evaluador, 2)/2)), 3))))*(3+evaluador);

    }
}
