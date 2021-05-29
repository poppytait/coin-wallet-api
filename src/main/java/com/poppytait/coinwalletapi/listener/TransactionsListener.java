package com.poppytait.coinwalletapi.listener;

import com.poppytait.coinwalletapi.model.Transaction;
import com.poppytait.coinwalletapi.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class TransactionsListener extends AbstractMongoEventListener<Transaction> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public TransactionsListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Transaction> event) {
        if (Integer.parseInt(event.getSource().getId()) < 1) {
            event.getSource().setId(String.valueOf(sequenceGeneratorService.generateSequence(Transaction.SEQUENCE_NAME)));
        }
    }
}