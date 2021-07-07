package com.blockchain.app.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostingRequest {

	
	private int id;
	private String jsonrpc;
	private String method;
	private Object [] params;
	
	
}
