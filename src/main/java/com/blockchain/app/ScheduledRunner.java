package com.blockchain.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.blockchain.app.service.BlockChainService;



@Configuration
@EnableScheduling
public class ScheduledRunner {
	
	
	@Autowired
	BlockChainService blockChainService;
	
	
	
	@Scheduled(fixedRate = 30000)
	public void saveToDb() {
		
        System.out.println("Starting scheduler");
		blockChainService.saveBlockChain();
        System.out.println("Saved successfuly!");
    }

}
