package com.trc.onlineshopping.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trc.onlineshopping.domain.Transaction;

@Component("transactionService")
public class TransactionService implements ITransactionService {
	
	

	@Override
	public Transaction getTransactionByID(long transid) {
		
		  return new Transaction(100, "axis", "4004", "abc", "123");
	}

	@Override
	public List<Transaction> getAllTransactions() {
	
		return null;
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		
		return null;
	}

}
