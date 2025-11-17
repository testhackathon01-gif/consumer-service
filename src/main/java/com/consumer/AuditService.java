package com.consumer;

import com.app.finance.PricingUtility;
import com.app.invoicing.InvoiceGenerator;

/**
 * A service in the consumer project demonstrating the use of multiple
 * classes imported from the 'orderpurchase-1.0.0.jar' dependency.
 */
public class AuditService {
    private final PricingUtility pricingUtility = new PricingUtility();
    private final InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    public void printTaxAndInvoiceInfo(double subtotal) {
        System.out.println("\n[5] Calling AuditService (using dependency JAR)");

        // Call method from PricingUtility (JAR)
        double currentTaxRate = pricingUtility.getTaxRate();
        if(currentTaxRate > 1){
            System.out.println("-> Value is as expected ");
        }else{
            System.out.println("-> value is not expected ");
        }
        System.out.println("-> Audit Check: Current tax rate from JAR is " + (currentTaxRate * 100) + "%.");

        // Call method from InvoiceGenerator (JAR)
        double totalWithTax = invoiceGenerator.calculateTotalWithTax(subtotal);

        // NOTE: The InvoiceGenerator's tax calculation is flawed due to the hardcoded
        // 5% rate in PricingUtility, which might not be the desired rate for invoicing.
        System.out.println("-> Audit Check: Total for subtotal $" + subtotal + " with tax is $" + totalWithTax);
        double totalCalculateValue = pricingUtility.calculateDiscount(2, 3);
        System.out.println("-> Audit Check: Total for value $" + totalCalculateValue);
    }
}