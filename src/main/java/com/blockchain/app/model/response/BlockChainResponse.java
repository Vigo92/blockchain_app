package com.blockchain.app.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BlockChainResponse {

	
	
		private Long id;
		
	    private String size;
		
		private String number;
		
		private String timestamp;
		
		private String nonce;
		
		private String gasLimit;
		
		private String hash;
}
