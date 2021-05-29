package com.poppytait.coinwalletapi;

import com.poppytait.coinwalletapi.model.User;
import com.poppytait.coinwalletapi.model.Wallet;
import com.poppytait.coinwalletapi.repository.IUserRepository;
import com.poppytait.coinwalletapi.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class CoinwalletapiApplication implements CommandLineRunner {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IWalletRepository walletRepository;

	public static void main(String[] args) {
		SpringApplication.run(CoinwalletapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("1", "poppytait@gmail.com", "Poppy", "Tait"));
		userRepository.save(new User("2", "benny@gmail.com", "Benny", "Johnson"));
		walletRepository.save(new Wallet("11", "1", new BigDecimal("999.00")));
		walletRepository.save(new Wallet("22", "2", new BigDecimal("888.00")));
	}
}
