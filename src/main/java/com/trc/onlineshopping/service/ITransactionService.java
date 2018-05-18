package com.trc.onlineshopping.service;

import java.util.List;

import com.trc.onlineshopping.domain.Transaction;

public interface ITransactionService {

	
	 public Transaction getTransactionByID(final long transid);
	 
	 public List<Transaction> getAllTransactions();
	  
	 public Transaction saveTransaction(final Transaction transaction);
	 
	// public dummyMethod();
}
