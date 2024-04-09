package com.paymentmicroservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.paymentmicroservice.dto.TransactionDto;
import com.paymentmicroservice.dto.TransactionResponseDto;


@FeignClient(name="http://BANK-SERVICE/bankapi/transaction")
public interface BankFeign {
	
	@PostMapping("/via/phone-numbers")
	public TransactionResponseDto fundTransferThroughPhoneNos(@RequestBody TransactionDto transferBalanceUsingPhone);

}
