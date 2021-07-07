package com.blockchain.app.service.thirdparty;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import com.blockchain.app.model.dto.BlockChainDTO;
import com.blockchain.app.model.dto.PostingRequest;

public class ThirdPartyCall {

	private CloseableHttpClient closeableHttpClient;
	private HttpPost httpPost;
	private CloseableHttpResponse closeableHttpResponse;
	private JSONObject jsonObject;
	private StringEntity stringEntity;

	@Value("${eth_get_block_by_number}")
	private String endpoint;

	{
		closeableHttpClient = HttpClients.createDefault();
	}

	public 	BlockChainDTO getBlocks() {

	    BlockChainDTO blockChain = null;
		try {
			//httpPost = new HttpPost(endpoint);
			httpPost = new HttpPost("https://mainnet.infura.io/v3/9d1b5930f82f479d89cf87310d59b51b");
			Object[] params = { "latest", true };
			PostingRequest postingRequest = PostingRequest.builder().id(0).jsonrpc("2.0").method("eth_getBlockByNumber")
					.params(params).build();

			jsonObject = new JSONObject(postingRequest);

			stringEntity = new StringEntity(jsonObject.toString());

			httpPost.setEntity(stringEntity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
			closeableHttpResponse = closeableHttpClient.execute(httpPost);
			
		    //httpEntity = closeableHttpResponse.getEntity();
		    		    
		    String json_string = EntityUtils.toString(closeableHttpResponse.getEntity());
		    JSONObject temp1 = new JSONObject(json_string);
		    JSONObject jsonObjects = temp1.getJSONObject("result");
		    
		    String size = jsonObjects.getString("size");
		    String gasLimit = jsonObjects.getString("gasLimit");
		    String hash = jsonObjects.getString("hash");
		    String nonce = jsonObjects.getString("nonce");
		    String number = jsonObjects.getString("number");
		    String timeStamp = jsonObjects.getString("timestamp");

		    
		     blockChain = BlockChainDTO.builder()
		    		.size(size).gasLimit(gasLimit).hash(hash).nonce(nonce)
		    		.number(number).timestamp(timeStamp).build();
		    
		    System.out.println(blockChain);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blockChain;
	}
	
//    public static void main(String [] args) {
//    	
//    	ThirdPartyCall thirdPartyCall = new ThirdPartyCall();
//    	
//    	thirdPartyCall.getBlocks();
//    }

}
