package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.Fee;
import com.Fawadkhan.hms.Entity.Payment;
import com.Fawadkhan.hms.Repository.FeeRepository;
import com.Fawadkhan.hms.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final FeeRepository feeRepository;

    public PaymentService(
            PaymentRepository paymentRepository,
            FeeRepository feeRepository) {

        this.paymentRepository = paymentRepository;
        this.feeRepository = feeRepository;
    }

    // =========================
    // CREATE PAYMENT
    // =========================
    public Payment createPayment(Payment payment) {

        // 1. Fee check
        Fee fee = feeRepository.findById(
                payment.getFee().getId()
        ).orElseThrow(() ->
                new RuntimeException("Fee not found"));

        // 2. Payment amount check
        if (payment.getAmount() <= 0) {

            throw new RuntimeException(
                    "Payment amount must be greater than 0");
        }

        // 3. Remaining amount
        Double remaining = fee.getRemainingAmount();

        // 4. Check over payment
        if (payment.getAmount() > remaining) {

            throw new RuntimeException(
                    "Payment exceeds remaining fee amount");
        }

        // 5. Calculate paid amount
        Double newPaidAmount =
                fee.getPaidAmount() + payment.getAmount();

        // 6. Calculate remaining
        Double newRemainingAmount =
                fee.getAmount() - newPaidAmount;

        // 7. Update Fee
        fee.setPaidAmount(newPaidAmount);

        fee.setRemainingAmount(newRemainingAmount);

        // 8. Update status
        if (newPaidAmount == 0) {

            fee.setStatus("UNPAID");

        } else if (newPaidAmount < fee.getAmount()) {

            fee.setStatus("PARTIAL");

        } else {

            fee.setStatus("PAID");
        }

        // 9. Save Fee
        feeRepository.save(fee);

        // 10. Set correct Fee
        payment.setFee(fee);

        // 11. Save Payment
        return paymentRepository.save(payment);
    }

    // =========================
    // GET ALL
    // =========================
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // =========================
    // GET BY ID
    // =========================
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    // =========================
    // UPDATE
    // =========================
    public Payment updatePayment(
            Long id,
            Payment payment) {

        Payment existingPayment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Payment not found"));

        existingPayment.setPaymentDate(
                payment.getPaymentDate()
        );

        existingPayment.setPaymentMethod(
                payment.getPaymentMethod()
        );

        existingPayment.setTransactionId(
                payment.getTransactionId()
        );

        existingPayment.setStatus(
                payment.getStatus()
        );

        return paymentRepository.save(existingPayment);
    }

    // =========================
    // DELETE PAYMENT
    // =========================
    public void deletePayment(Long id) {

        // 1. Find payment
        Payment payment =
                paymentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Payment not found"));

        // 2. Get Fee
        Fee fee = payment.getFee();

        // 3. Subtract payment
        Double newPaidAmount =
                fee.getPaidAmount() - payment.getAmount();

        // 4. Calculate remaining
        Double newRemainingAmount =
                fee.getAmount() - newPaidAmount;

        // 5. Update Fee
        fee.setPaidAmount(newPaidAmount);

        fee.setRemainingAmount(newRemainingAmount);

        // 6. Update status
        if (newPaidAmount == 0) {

            fee.setStatus("UNPAID");

        } else if (newPaidAmount < fee.getAmount()) {

            fee.setStatus("PARTIAL");

        } else {

            fee.setStatus("PAID");
        }

        // 7. Save Fee
        feeRepository.save(fee);

        // 8. Delete Payment
        paymentRepository.deleteById(id);
    }
}