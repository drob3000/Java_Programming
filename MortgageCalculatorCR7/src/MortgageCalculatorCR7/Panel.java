/*
 * Author: Dan Roberts, University of Phoenix Copyright 2012
 * Current Release Date: Monday March 12, 2012
 * Version: 1.1.0
 * Submitted for PRG421 Java Programming II | course at the University of Phoenix
 * Scope: 
 * Creates the pie chart
 */
package MortgageCalculatorCR7;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;


public class Panel extends JFrame {

    public Panel(double interest, int years, float totalInterest, float totalPayments) {
        super("Interest Rate of " + interest + "% " + " the term is " + years + " years");
        setSize(410, 435);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        Chart pie = new Chart(2);

        pie.addSlice(Color.blue, totalInterest);
        pie.addSlice(Color.green, totalPayments);

        pane.add(pie);
        setContentPane(pane);
        setVisible(true);

    }
}
