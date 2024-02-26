package ru.job4j.ood.ocp;

public class PaymentProcessor {
  /*  Нарушение OCP: при добавлении нового типа
    платежа, нужно будет изменять метод processPayment*/
    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Credit card payment");
        } else if (paymentType.equals("PayPal")) {
            System.out.println("PayPal payment");
        } else {
            System.out.println("Unsupported payment type");
        }
    }
}
