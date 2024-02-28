package com.istanify.accounting.repository;

import com.istanify.accounting.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
