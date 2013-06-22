/*
 * Author: Dan Roberts, University of Phoenix Copyright 2012
 * Current Release Date: Monday March 12, 2012
 * Version: 1.1.0
 * Submitted for PRG421 Java Programming II | course at the University of Phoenix
 * Scope: 
 * Calculation class to calculate the mortgage data and amortization loop
 */
package MortgageCalculatorCR7;

import java.text.NumberFormat;

public class AmortizationSchedule {

    public String[] colNames = {"Period", "Payment", "Principal", "Interest", "Balance"};
    int numOfColumns = 5;
    double principal;
    double interest;
    double monthlyInterest;
    double balance = 0;
    double payment = 0;
    double curInterest = 0;
    double curPrincipal = 0;
    double totalPayments = 0;
    double totalPrincipal = 0;
    double totalInterest = 0;
    int years;
    int period;
    int numberPayments;
    Object[][] colData;
    String strPrincipal;
    String strTotal;
    String strPayment = "";
    String strCurPrincipal = "";
    String strCurInterest = "";
    String strBalance = "";
    String strTotalPrincipal = "";
    String strTotalInterest = "";
    String strTotalPayments = "";
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    String loanPrincipal;
    String loanInterest;
    String term;
    String totalPaid;
    String Principal;
    String Interest;

    public void createAmortization() { //performs the calculations and loop for atmortization
        monthlyInterest = (interest / 100) / 12;
        numberPayments = years * 12;
        colData = new Object[numberPayments][numOfColumns];

        payment = (principal * monthlyInterest) / (1 - Math.pow((1 + monthlyInterest), -numberPayments));

        balance = principal;

        for (period = 1; period <= numberPayments; period++) {
            curInterest = balance * monthlyInterest;

            if (period == numberPayments) {
                payment = balance + curInterest;
            }

            curPrincipal = payment - curInterest;
            balance -= curPrincipal;

            // String formatting of the loop output
            strPayment = currency.format(payment);
            strCurPrincipal = currency.format(curPrincipal);
            strCurInterest = currency.format(curInterest);
            strBalance = currency.format(balance);


            colData[period - 1][0] = period;
            colData[period - 1][1] = strPayment;
            colData[period - 1][2] = strCurPrincipal;
            colData[period - 1][3] = strCurInterest;
            colData[period - 1][4] = strBalance;

            totalPayments += payment;
            totalPrincipal += curPrincipal;
            totalInterest += curInterest;

        }
        // String formatting of the output data
        strPrincipal = currency.format(principal);
        strTotalPrincipal = currency.format(totalPrincipal);
        strTotalInterest = currency.format(totalInterest);
        strTotalPayments = currency.format(totalPayments);



        loanPrincipal = "the loan principal is: " + strPrincipal + "\n";
        loanInterest = "the loan interest is: " + interest + " % " + "\n";
        term = "the term of the loan is: " + years + " Years" + "\n";
        totalPaid = "the total paid of full term is: " + strTotalPayments + "\n";
        Principal = "the total principal to full term is: " + strTotalPrincipal + "\n";
        Interest = "the total interest paid to full term is: " + strTotalInterest;

        Panel myChart = new Panel(interest, years, (float) totalInterest, (float) totalPayments);

    }
}
