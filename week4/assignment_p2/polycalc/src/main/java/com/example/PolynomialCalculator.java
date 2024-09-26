package com.example;

import java.util.LinkedList;
import java.util.ListIterator;

// Class representing a Term of a Polynomial
class Term {
    public int coefficient;
    public int power;

    // Constructor
    public Term(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    @Override
    public String toString() {
        if (coefficient == 0) {
            return "";
        }
        if (power == 0) {
            return String.valueOf(coefficient);
        }
        if (power == 1) {
            return coefficient + "x";
        }
        return coefficient + "x^" + power;
    }
}

// Class representing a Polynomial as a LinkedList of Terms
class Polynomial {
    private LinkedList<Term> terms;

    // Constructor to create a polynomial from a single term
    public Polynomial(Term term) {
        terms = new LinkedList<>();
        if (term.coefficient != 0) {
            terms.add(term);
        }
    }

    // Method to add another polynomial to this polynomial
    public void add(Polynomial other) {
        ListIterator<Term> thisIter = terms.listIterator();
        ListIterator<Term> otherIter = other.terms.listIterator();

        while (otherIter.hasNext()) {
            Term otherTerm = otherIter.next();
            boolean termAdded = false;

            // Iterate over this polynomial's terms to add correctly
            while (thisIter.hasNext()) {
                Term thisTerm = thisIter.next();
                if (thisTerm.power == otherTerm.power) {
                    // If powers are the same, combine coefficients
                    thisTerm.coefficient += otherTerm.coefficient;
                    if (thisTerm.coefficient == 0) {
                        thisIter.remove();  // Remove if coefficient becomes zero
                    }
                    termAdded = true;
                    break;
                } else if (thisTerm.power < otherTerm.power) {
                    // If we passed the correct spot, insert it before the current term
                    thisIter.previous();
                    thisIter.add(otherTerm);
                    termAdded = true;
                    break;
                }
            }

            // If we finished iterating through 'this' and didn't find a spot, add to the end
            if (!termAdded) {
                thisIter.add(otherTerm);
            }
        }
    }

    // Method to multiply two polynomials
    public Polynomial multiply(Polynomial other) {
        Polynomial result = new Polynomial(new Term(0, 0));  // Start with an empty polynomial

        for (Term thisTerm : terms) {
            for (Term otherTerm : other.terms) {
                int newCoefficient = thisTerm.coefficient * otherTerm.coefficient;
                int newPower = thisTerm.power + otherTerm.power;
                result.add(new Polynomial(new Term(newCoefficient, newPower)));
            }
        }

        return result;
    }

    // Method to print the polynomial
    public void print() {
        if (terms.isEmpty()) {
            System.out.println("0");
            return;
        }

        boolean first = true;
        for (Term term : terms) {
            if (!first && term.coefficient > 0) {
                System.out.print(" + ");
            } else if (term.coefficient < 0) {
                System.out.print(" - ");
            } else if (!first) {
                System.out.print(" ");
            }
            System.out.print(term.toString().replace("-", ""));
            first = false;
        }
        System.out.println();
    }
}

public class PolynomialCalculator {
    public static void main(String[] args) {
        // Create polynomial p: -10 + (-x) + 9x^7 + 5x^10
        Polynomial p = new Polynomial(new Term(-10, 0));
        p.add(new Polynomial(new Term(-1, 1)));
        p.add(new Polynomial(new Term(9, 7)));
        p.add(new Polynomial(new Term(5, 10)));

        // Display polynomial p
        System.out.print("p(x) = ");
        p.print();

        // Compute p(x) * p(x)
        Polynomial q = p.multiply(p);

        // Display result of p(x) * p(x)
        System.out.print("p(x) * p(x) = ");
        q.print();
    }
}
