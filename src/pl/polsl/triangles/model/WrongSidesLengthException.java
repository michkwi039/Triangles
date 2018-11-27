/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.model;

/**
 * Exception thrown when from given sides it is impossible to make triangle
 *
 * @author Anggmar
 * @version 1.1
 */
public class WrongSidesLengthException extends Exception {

    /**
     * basic constructor that prints the cause of exception
     */
    public WrongSidesLengthException() {
        System.out.println("Wrong length of sides");
    }
}
