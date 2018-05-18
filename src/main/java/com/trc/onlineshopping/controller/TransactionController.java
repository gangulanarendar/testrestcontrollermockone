package com.trc.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trc.onlineshopping.domain.Transaction;

import com.trc.onlineshopping.service.ITransactionService;

@RestController
@RequestMapping("/payment")
public class TransactionController {
	
	@Autowired
	@Qualifier("transactionService")
	private ITransactionService transactionService;
	
	@Autowired
	@Qualifier("someOthertransactionService")
	private SomeOthertransactionService someOthertransactionService;
	
	@RequestMapping(value="/transaction/{transid}")
	public Transaction getTransactionById(@PathVariable final long transid)
	{
		
		Transaction transaction= transactionService.getTransactionByID(transid);
		
		String str=someOthertransactionService.test();
		
		transaction.setCarHolderName(str);
		
		return transaction;
	}

}
