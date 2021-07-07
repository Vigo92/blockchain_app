package com.blockchain.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "block_chain")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlockChainEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String size;
	
	private String number;
	
	private String timestamp;
	
	private String nonce;
	
	private String gasLimit;
	
	private String hash;

}
