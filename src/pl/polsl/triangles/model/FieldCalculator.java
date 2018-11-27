/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.model;

/**
 * Class that contains method that can calculate fields of triangles
 *
 * @author Anggmar
 * @version 1.2
 */
public class FieldCalculator {

    //lambda expression for checking if triangle is possible to make
    Checker<Double> sides = (a, b, c) -> a + b <= c || a + c <= b || b + c <= a;

    /**
     * Calculates field of triangle that was given to it
     *
     * @param a lenght of first side of triangle
     * @param b lenght of second side of triangle
     * @param c lenght of third side of triangle
     * @return field of given triangle
     * @exception WrongSidesLengthException if from given sides it is impossible
     * to make triangle
     */
    public Double calculate(Double a, Double b, Double c) throws WrongSidesLengthException {
        if (a <= 0 || b <= 0 || c <= 0) {//if length of side is lower than 0 you can't make triangle
            throw new WrongSidesLengthException();
        }
        if (sides.check(a, b, c)) {//checks if triangle is possible to make
            throw new WrongSidesLengthException();
        }
        Double halfField = (a + b + c) / 2; //contains half the sum of all sides of triangle
        Double tField = new Double(Math.sqrt(halfField * (halfField - a) * (halfField - b) * (halfField - c)));//field that contains field of a triangle
        return tField;
    }
}
