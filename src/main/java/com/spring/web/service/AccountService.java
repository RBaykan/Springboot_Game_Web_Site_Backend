package com.spring.web.service;

import java.util.List;

import com.spring.web.entityDTO.AccountDTO;
import com.spring.web.entityDTO.Login;


public interface AccountService {

	List<AccountDTO> getAccounts();
	
	AccountDTO getAccount(Long id);
	
	AccountDTO createAccount(AccountDTO accountDTO);
	
	public void delete(Long id);
	
	public AccountDTO update(Long id, AccountDTO accountDTO);
	
	public Login signin(Login login);
	
	AccountDTO getAccountDTO(String username);
	
	
	
	
}
