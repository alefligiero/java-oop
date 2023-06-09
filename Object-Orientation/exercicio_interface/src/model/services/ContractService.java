package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		for (int i = 1; i <= months; i++) {
			Double amount = contract.getTotalValue() / months;
			amount += onlinePaymentService.interest(amount, i);
			amount += onlinePaymentService.paymentFee(amount);
			LocalDate dueDate = contract.getDate().plusMonths(i);
			contract.getInstallments().add(new Installment(dueDate, amount));
		}
	}
}
