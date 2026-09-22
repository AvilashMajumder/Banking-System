package com.banking.transactionservice.repository;

import com.banking.transactionservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    // List<Transaction> findBySenderAccountNumberOrderByCreatedAtDesc(String accountNumber);

    // Modified to get both sender and receiver transaction history
    @Query("""
    SELECT t
    FROM Transaction t
    WHERE t.senderAccountNumber = :accountNumber
       OR t.receiverAccountNumber = :accountNumber
    ORDER BY t.createdAt DESC
""")
    List<Transaction> findTransactionHistory(
            @Param("accountNumber") String accountNumber);
}
