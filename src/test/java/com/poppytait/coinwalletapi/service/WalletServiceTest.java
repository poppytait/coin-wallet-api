package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.exception.WalletNotFoundException;
import com.poppytait.coinwalletapi.model.Wallet;
import com.poppytait.coinwalletapi.repository.IWalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @Captor
    ArgumentCaptor<Wallet> walletArgumentCaptor;

    @Mock
    IWalletRepository repository;

    @InjectMocks
    WalletService service;

    Wallet wallet = new Wallet("1", "user1", new BigDecimal(100));

    @Test
    void shouldGetWallet() throws WalletNotFoundException {
        when(repository.findById("1")).thenReturn(Optional.of(wallet));

        Wallet actualWallet = service.getWallet("1");

        assertEquals(wallet, actualWallet);
    }

    @Test
    void shouldThrowExceptionWhenGetWallet() {
        when(repository.findById("5")).thenReturn(Optional.empty());

        assertThrows(WalletNotFoundException.class, () -> {
            service.getWallet("5");
        });
    }


    @Test
    void shouldUpdateBalance() throws Exception {
        when(repository.findById("1")).thenReturn(Optional.of(wallet));
        service.updateBalance("1", new BigDecimal(100));

        verify(repository).save(walletArgumentCaptor.capture());

        Wallet walletCaptorValue = walletArgumentCaptor.getValue();
        assertEquals(walletCaptorValue.getBalance(), new BigDecimal(200));
    }
}