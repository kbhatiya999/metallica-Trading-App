package com.tango.metallica.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tango.metallica.trade.enitity.Logs;


public interface LogsRepo extends JpaRepository<Logs, Integer> {

}
