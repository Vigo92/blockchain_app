package com.blockchain.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.app.model.response.BlockChainResponse;
import com.blockchain.app.service.BlockChainService;

@RestController
@RequestMapping("api/v1")
public class BlockChainController {
	
	
	
	
	@Autowired
	private BlockChainService blockChainService;
	
	
	@GetMapping(path = "chains", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<BlockChainResponse>> getBlocks(){
		
		List<BlockChainResponse> blockChainResponses = blockChainService.getBlockChainResponse();
		
		
		
		return new ResponseEntity<List<BlockChainResponse>>(blockChainResponses, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping(path = "chain", produces = {MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Map<Long,BlockChainResponse>> getBlock(){
		
		Map<Long,BlockChainResponse> blockChainResponses = blockChainService.getBlockChainResponses();
		
		return new ResponseEntity<Map<Long,BlockChainResponse>>(blockChainResponses, HttpStatus.OK);
		
		
	}
	
	
	

}
