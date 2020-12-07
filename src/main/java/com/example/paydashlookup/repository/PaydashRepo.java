package com.example.paydashlookup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.paydashlookup.model.PayDashDto;

public interface PaydashRepo extends CrudRepository<PayDashDto, String>{
	@Query(value = "SELECT msisdn  FROM smsmsglog WHERE msisdn='306906571281' ",nativeQuery = true )
    List<String> getMsisdn();

}
