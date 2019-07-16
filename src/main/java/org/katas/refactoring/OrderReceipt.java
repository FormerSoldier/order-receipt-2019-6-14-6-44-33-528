package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeaders(output);
        printNameAndAddress(output);
        printsLineItem(output);

        return output.toString();
    }


    private void printHeaders(StringBuilder output){
        output.append("======Printing Orders======\n");
    }

    private void printNameAndAddress(StringBuilder output){
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
    }

    private void printsLineItem(StringBuilder output){
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }
        printStateTax(output, totSalesTx);
        printTotalAmount(output,tot);

    }

    private void printStateTax(StringBuilder output, double totSalesTx){
        output.append("Sales Tax").append('\t').append(totSalesTx);
    }

    private void printTotalAmount(StringBuilder output, double tot){
        output.append("Total Amount").append('\t').append(tot);
    }
}