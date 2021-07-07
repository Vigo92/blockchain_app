package com.blockchain.app.service;

import java.util.List;
import java.util.Map;

import com.blockchain.app.model.entity.BlockChainEntity;
import com.blockchain.app.model.response.BlockChainResponse;

public interface BlockChainService {

	
	public BlockChainEntity saveBlockChain();
	
	List<BlockChainResponse> getBlockChainResponse();
	
	Map<Long,BlockChainResponse> getBlockChainResponses();


}
