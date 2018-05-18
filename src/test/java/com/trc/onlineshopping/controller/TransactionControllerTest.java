package com.trc.onlineshopping.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.trc.onlineshopping.domain.Transaction;

import com.trc.onlineshopping.service.ITransactionService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionController.class, secure = false)
public class TransactionControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	@Qualifier("transactionService")
	private ITransactionService transactionService;

	@MockBean
	@Qualifier("someOthertransactionService")
	private SomeOthertransactionService someOthertransactionService;
	
	/*
	 * @MockBean private Transaction transaction;
	

	
	  @InjectMocks private TransactionController transactionController;
	  */

	

/*	@BeforeClass
	public static void setUp() {
		System.out.println("setUp callled");
	}*/

	@Test
	public void shouldGetTransaction() throws Exception {
		System.out.println("testOne called");
		Transaction transaction = new Transaction(123, "axis", "4004", "john", "987");
		when(transactionService.getTransactionByID(Mockito.anyLong())).thenReturn(transaction);
	
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/payment/transaction/53452384")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Transaction "+result.getResponse().getContentAsString());
		
		/*String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K
		// Students","steps":["Learn Maven","Import Project","First Example","Second
		// Example"]}

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);*/

		
		
		verify(transactionService, times(1)).getTransactionByID(53452384);
		/*assertEquals("Returned user should come from the service", transaction, transaction);

		mvc.perform(get("/payment/transaction/12").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andDo(print());
*/
	}

}
