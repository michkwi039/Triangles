/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.triangles.model;

/**
 * An interface used when checking if triangle is possible to make
 *
 * @param <T> type of data that you want to check
 * @author Anggmar
 * @version 1.1
 */
@FunctionalInterface
public interface Checker<T> {

    /**
     * A method used when checking if triangle is possible to make
     *
     * @param a first side of triangle
     * @param b second side of triangle
     * @param c third side of triangle
     * @return true if it is possible to make triangle from this sides
     */
    boolean check(T a, T b, T c);
}
