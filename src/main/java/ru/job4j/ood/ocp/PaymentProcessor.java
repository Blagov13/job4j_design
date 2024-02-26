package ru.job4j.ood.ocp;

public class PaymentProcessor {
  /*  Нарушение OCP: при добавлении нового типа
    платежа, нужно будет изменять метод processPayment*/
    public void processPayment(String paymentType) {
        if (paymentType.equals("CreditCard")) {
            return;
            // обработка платежа по кредитной карте
        } else if (paymentType.equals("PayPal")) {
            return;
            // обработка платежа через PayPal
        }
    }
}
