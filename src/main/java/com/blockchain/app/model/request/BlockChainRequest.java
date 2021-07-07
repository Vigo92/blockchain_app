package com.blockchain.app.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlockChainRequest {

	
  
	private String jsonrpc;
    
	private String method;
	
	private String params;
	
	private int id; 
	
}
