/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos;
 //       return Math.exp(-x)-x;
 //
// Java program for implementation of 
// Newton Raphson Method for solving 
// equations
import java.util.Scanner;



public class NewtonRaphson {
    public static void main(String[] args) {
        double x0,root,givenError,error;
        boolean flag=true;
        int i=1;
        Scanner sc = new Scanner(System.in);
        double valorReal = 1.5140547367340582;

        System.out.print("Enter value for x0 : ");
        x0 = sc.nextDouble();
        int cont=0;
        givenError=0.0000000001;
        double errorVerdadero = 100;
        while(flag){
            root = x0 - (F(x0)/Fprime_X(x0));
            error = Math.abs((root-x0)/root)*100;
            errorVerdadero = valorReal-root;

            System.out.println("Iteration : "+ i++);
            System.out.println("Root:"+root);
            System.out.println("ErrorPorc:"+error);
            System.out.println("ErrorTrue: "+errorVerdadero);
            x0 = root;
            cont++;
            if(givenError>error || cont>=10)
            {
                    flag=false;
            }
        }
    }
            
    public static double F(double x){
                    return 1-(Math.pow(20, 2)/(9.81*Math.pow((3*x+(Math.pow(x, 2)/2)), 3)))*(3+x);
    }
    
                
    public static double Fprime_X(double x){
          return ((101.93*Math.pow(x, 2)+611.62*x+1100.91)/(Math.pow(x, 4)*Math.pow(0.5*x+3, 4)))+1;
    }
    
    
}
