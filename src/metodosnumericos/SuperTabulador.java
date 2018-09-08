/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos;

/**
 *
 * @author House
 */
public class SuperTabulador {
    public static void main(String[] args) {
        for(int i=-10; i<10; i++){
            double y = evaluarEnF(i);
            System.out.println("f(x) = "+y);
        }
    }
    public static double evaluarEnF(double evaluador){     
        //return Math.pow(evaluador, 2)+(1/evaluador)-6;
        return Math.pow(evaluador, 10)-1;
    }
}
