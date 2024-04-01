package com.wolfcode.MpesadarajaApi.repository;

import com.wolfcode.MpesadarajaApi.entity.StkPushEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StkPushRepository extends JpaRepository<StkPushEntries,Long> {

}
