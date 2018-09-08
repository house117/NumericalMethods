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
public class MetodosNumericosFalsaPosicionMejorado {
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
        System.out.println("Intruduce el valor de tolerancia admitido:");
        tolerancia = input.nextDouble()/*0.5*Math.pow(10, 2-input.nextDouble())*/;
        double errorPorcentualAprox= 100;
        ModFalsePos(xl, xu, tolerancia, xrAnt, xr, contadorIteraciones, errorPorcentualAprox);
        /*while(errorPorcentualAprox > tolerancia){
            xr = xu-((evaluarEnF(xu)*(xl-xu))/(evaluarEnF(xl)-evaluarEnF(xu)));
            double fxrfxl = evaluarEnF(xr)*evaluarEnF(xl);
            System.out.println("El valor de xl es: "+xl);
            System.out.println("El valor de xu es: "+xu);
            System.out.println("El valor de xr es: "+xr);
            double resul = fxrfxl<0?(xu=xr):(xl=xr);
            System.out.println("El valor de fxrfxl es: "+fxrfxl);
            errorPorcentualAprox =  Math.abs((xr-xrAnt)/xr)*100;
            System.out.println("El error porc aprox es: "+errorPorcentualAprox);
            if (errorPorcentualAprox < 0) errorPorcentualAprox *= -1;
            if(fxrfxl == 0) errorPorcentualAprox = tolerancia;
            xrAnt = xr;
            contadorIteraciones++;
        }*/
        
        
    }
    public static void ModFalsePos(double xl,double xu,double es,double imax,double xr,int iter,double errorPorcentualAprox){
        iter =0;
        imax = 1000;
        double fr;
        double xrOld;
        double test;
        double fl = evaluarEnF(xl);
        double fu = evaluarEnF(xu);
        int iu=0, il=0;
        long startTime = System.nanoTime();
        do{
            xrOld = xr;
            xr = xu - fu* (xl - xu)/(fl-fu);
            System.out.println("El valor de xr es : "+xr);
            fr = evaluarEnF(xr);
            iter = iter+1;
            if(xr != 0){
                errorPorcentualAprox = Math.abs((xr-xrOld)/xr)*100;
                System.out.println("El error porcentual aprox es:"+errorPorcentualAprox);
            }
            test = fl *fr;
            if(test<0){
                xu=xr;
                fu=evaluarEnF(xu);
                iu=0;
                il = il+1;
                if(il>=2){
                    fl=fl/2;
                    il = 0;
                }
            }else if(test>0){
                xl = xr;
                fl = evaluarEnF(xl);
                il = 0;
                iu=iu+1;
                if(iu>=2){
                    fu=fu/2;
                    iu = 0;
                }
            }else if(xr==0){
                System.out.println("ENTRO AL IF MALDITO");
                    errorPorcentualAprox = 0;
                }
        }while(errorPorcentualAprox > es && iter<=10);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("La raiz es = "+xr);
        System.out.println("======================================Finalizado======================================");
        System.out.println("El valor de la raiz es = "+xr+"\nSe alcanzó el nivel de tolerancia ("+es+") en la iteración:"+iter);
        System.out.println("El error relativo porcentual aproximado es: "+errorPorcentualAprox);
        System.out.println("El tiempo de ejecucion fue: "+totalTime/Math.pow(10, 9)+" segundos");
    }
    public static double evaluarEnF(double evaluador){     
        //return Math.pow(evaluador, 2)+(1/evaluador)-6;
        //return Math.pow(evaluador, 10)-1;
        //return Math.pow(evaluador, 4)-8*Math.pow(evaluador, 3)-35*Math.pow(evaluador, 2)+450*evaluador-1001;
                                    return 1-(Math.pow(20, 2)/(9.81*Math.pow((3*evaluador+(Math.pow(evaluador, 2)/2)), 3)))*(3+evaluador);

    }
}
