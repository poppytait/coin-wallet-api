package com.poppytait.coinwalletapi.service;

import com.poppytait.coinwalletapi.exception.IdenticalSenderAndDestinationException;
import com.poppytait.coinwalletapi.exception.InsufficientAmountException;
import com.poppytait.coinwalletapi.exception.InsufficientFundsException;
import com.poppytait.coinwalletapi.exception.WalletNotFoundException;
import com.poppytait.coinwalletapi.model.Transaction;
import com.poppytait.coinwalletapi.model.TransactionRequest;
import com.poppytait.coinwalletapi.model.Wallet;
import com.poppytait.coinwalletapi.repository.ITransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    private final IWalletService walletService;
    private final ITransactionRepository transactionRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public TransactionService(IWalletService walletService, ITransactionRepository transactionRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.walletService = walletService;
        this.transactionRepository = transactionRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    @Transactional
    public void makeTransaction(TransactionRequest request) throws WalletNotFoundException, InsufficientFundsException, IdenticalSenderAndDestinationException, InsufficientAmountException {
        Wallet sourceWallet = walletService.getWallet(request.getSourceWalletId());

        if (sourceWallet.getId().equals(request.getDestinationWalletId())) {
            throw new IdenticalSenderAndDestinationException(sourceWallet.getId(), request.getDestinationWalletId());
        }

        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InsufficientAmountException();
        }

        if (sourceWallet.getBalance().compareTo(request.getAmount()) >= 0) {
            walletService.updateBalance(sourceWallet.getId(), request.getAmount().multiply(new BigDecimal(-1)));
            walletService.updateBalance(request.getDestinationWalletId(), request.getAmount());

            String id = String.valueOf(sequenceGeneratorService.generateSequence(Transaction.SEQUENCE_NAME));
            Transaction transaction = new Transaction(id, request.getSourceWalletId(), request.getDestinationWalletId(), request.getAmount(), request.getSentAt(), request.getReference());

            transactionRepository.save(transaction);
        } else {
            throw new InsufficientFundsException(sourceWallet.getId(), sourceWallet.getBalance(), request.getAmount());
        }
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}
