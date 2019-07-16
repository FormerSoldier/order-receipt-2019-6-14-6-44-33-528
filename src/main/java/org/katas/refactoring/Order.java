package org.katas.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String customerAddres;
    List<LineItem> lineItems;

    public Order(String customerName, String customerAddres, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddres = customerAddres;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddres() {
        return customerAddres;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
