package com.Bankapp.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Bankapp.entity.account;

public interface accountrepos extends JpaRepository<account, Long>{

}
