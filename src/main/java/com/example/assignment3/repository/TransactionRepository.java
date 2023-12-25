package com.example.assignment3.repository;

import com.example.assignment3.Transaction;
import com.example.assignment3.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
     Optional<List<Transaction>> findByStatus(TransactionStatus transactionStatus);
}
