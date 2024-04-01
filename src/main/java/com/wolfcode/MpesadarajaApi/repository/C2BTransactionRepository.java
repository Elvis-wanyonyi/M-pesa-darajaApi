package com.wolfcode.MpesadarajaApi.repository;

import com.wolfcode.MpesadarajaApi.entity.C2BEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface C2BTransactionRepository extends JpaRepository<C2BEntries,Long> {

}
