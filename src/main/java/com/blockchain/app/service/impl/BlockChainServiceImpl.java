package com.blockchain.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.app.model.dto.BlockChainDTO;
import com.blockchain.app.model.entity.BlockChainEntity;
import com.blockchain.app.model.response.BlockChainResponse;
import com.blockchain.app.repository.BlockChainRepository;
import com.blockchain.app.service.BlockChainService;
import com.blockchain.app.service.thirdparty.ThirdPartyCall;



@Service
public class BlockChainServiceImpl implements BlockChainService{
	
	
	@Autowired
	BlockChainRepository blockChainRepository;

	@Override
	public BlockChainEntity saveBlockChain() {
		
		BlockChainDTO blockChainDTO =
				new ThirdPartyCall().getBlocks();
		
		ModelMapper modelMapper = createMapper();
		BlockChainEntity blockChainEntity = modelMapper.map(blockChainDTO, BlockChainEntity.class);

	  blockChainRepository.save(blockChainEntity);
	
	 return blockChainEntity;
	
	}
	
	
	private ModelMapper createMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return modelMapper;
	}


	@Override
	public List<BlockChainResponse> getBlockChainResponse() {
		
		List<BlockChainEntity> blockChainEntities = blockChainRepository.findAll();
		
		List<BlockChainResponse> blockChainResponses = new ArrayList<>();
		
		
		
		ModelMapper modelMapper = createMapper();

		
		blockChainEntities.forEach(
				blockChainEntity -> {
					
					BlockChainResponse response = modelMapper.map(blockChainEntity, BlockChainResponse.class);
					
					blockChainResponses.add(response);
				});
		
		return blockChainResponses;
	}


	@Override
	public Map<Long, BlockChainResponse> getBlockChainResponses() {

       List<BlockChainEntity> blockChainEntities = blockChainRepository.findAll();
				
	   Map<Long, BlockChainResponse> blockChain = new HashMap<>();
		
		ModelMapper modelMapper = createMapper();

		
		blockChainEntities.forEach(
				blockChainEntity -> {
					
		BlockChainResponse response = modelMapper.map(blockChainEntity, BlockChainResponse.class);
					
		blockChain.put(response.getId(), response);
				});
		
		return blockChain;
	}

}
