package com.spring.web.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.web.entity.Account;

import com.spring.web.entityDTO.AccountDTO;
import com.spring.web.entityDTO.Login;
import com.spring.web.exception.AccountNotFound;
import com.spring.web.mapper.AccountMapper;
import com.spring.web.repository.AccountRepository;
import com.spring.web.service.AccountService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository repository;
	
	

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		// TODO Auto-generated  stub
		Account account = AccountMapper.AccountDTOToAccount(accountDTO);
		Account savedAccount = repository.save(account);
		
		return AccountMapper.AccountToAccountDTO(savedAccount);
	}

	@Override
	public AccountDTO getAccount(Long id) {
		
		Account account = repository.findById(id)
				.orElseThrow(() -> new AccountNotFound("Account not found by id:" + id));
		
		return AccountMapper.AccountToAccountDTO(account);
	}

	@Override
	public List<AccountDTO> getAccounts() {
		
		List<Account> accounts = repository.findAll();
		return accounts.stream().map(
				(account) -> AccountMapper.AccountToAccountDTO(account)
				).collect(Collectors.toList());
				
	}
	
	@Override
	public void delete(Long id) {
		
		Account account = repository.findById(id)
				.orElseThrow(() -> new AccountNotFound("Account not found by id:" + id));
		
		repository.delete(account);
		
	}
	
	
	@Override
	public AccountDTO update(Long id, AccountDTO accountDTO) {
		Account account = repository.findById(id)
				.orElseThrow(() -> new AccountNotFound("Account not found by id:" + id));
		
		
		
		account.setFirstname(accountDTO.getFirstname());
		account.setLastname(accountDTO.getLastname());
		account.setUsername(accountDTO.getUsername());
		account.setPassword(accountDTO.getPassword());
		account.setEmail(accountDTO.getEmail());
		account.setRoles(accountDTO.getRoles());
		
		 repository.save(account);
		
	
		
		return 	AccountMapper.AccountToAccountDTO(account);
	}
	
	public Login signin(Login login) {
		
		System.out.println(login.getUsername());
		
		Optional<Account> optional = repository.findByUsername(login.getUsername());
		Account account = optional.get();
		
		if(login.getUsername().equals(account.getUsername())) {
			if(login.getPassword().equals(account.getPassword())) {
				return login;
			}else {
				return null;
			}
			
		}else {
			return null;
		}
		
		
	
	}
	
	@Override
	public AccountDTO getAccountDTO(String username) {
		
		Optional<Account> op = repository.findByUsername(username);
		
		return AccountMapper.AccountToAccountDTO(op.get());
	}
	
	


}
