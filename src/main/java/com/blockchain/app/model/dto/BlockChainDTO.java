package com.blockchain.app.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BlockChainDTO {

	
    private String size;
	
	private String number;
	
	private String timestamp;
	
	private String nonce;
	
	private String gasLimit;
	
	private String hash;
}
