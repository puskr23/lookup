package com.example.paydashlookup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.paydashlookup.api.PaydashApi;
import com.example.paydashlookup.repository.PaydashRepo;


@SpringBootApplication
public class PaydashLookupApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaydashLookupApplication.class, args);
	}
	@Component
	class Runner implements CommandLineRunner {
		@Autowired
		PaydashRepo repo;
		@Autowired
		PaydashApi api;

		
		
	@Override
	public void run(String... args) throws Exception
	{
		try (PrintWriter writer = new PrintWriter(new File("C:\\Users\\ponam\\Downloads\\csv\\pd.csv"))) {

		      StringBuilder sb = new StringBuilder();
		      sb.append("Number,");
		      sb.append(',');
		      sb.append("Operator");
		      sb.append('\n');

		List<String> phone=repo.getMsisdn();
		for(String number:phone)
		{
		  System.out.println("Number="+number);
		  String op=api.getOperator(number);
		  System.out.println("Operator="+op);
		  System.out.println("===================================");
		  sb.append(number);
	      sb.append(',');
	      sb.append(op);
	      sb.append('\n');
		  
		   
		}
		
		 writer.write(sb.toString());

	      System.out.println("done!");

	    } catch (FileNotFoundException e) {
	      System.out.println(e.getMessage());
		
	}

}

}
}
