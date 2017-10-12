package com.epayments.response;

import java.util.List;
import java.util.concurrent.CompletionException;

import com.epayments.response.Info.InfoType;
import com.epayments.util.ServiceUtil;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * The type Response to client.
 *
 * @author Kalidass Mahalingam
 */
public class ResponseToClient {

    /**
     * Instantiates a new Response to client.
     */
    public ResponseToClient() {
    }

    /**
     * Object to client json node.
     *
     * @param obj the obj
     *
     * @return the json node
     */
    public static JsonNode objectToClient(Object obj) {
		Response<Object> response = new Response<>();
		response.setStatus(new Info(InfoType.INFO_OK));
		response.setPayLoad(obj);
		return ServiceUtil.toJson(response);
	}

    /**
     * List to client json node.
     *
     * @param list the list
     *
     * @return the json node
     */
    public static JsonNode listToClient(List<? extends Object> list) {
		try {
			Response<Object> response = new Response<>();
			response.setStatus(new Info(InfoType.INFO_OK));
			response.setPayLoad(list);
			return ServiceUtil.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CompletionException(e);
		}
	}

    /**
     * Object to client json node.
     *
     * @param obj    the obj
     * @param status the status
     *
     * @return the json node
     */
    public static JsonNode objectToClient(Object obj, Status status) {
		try {
			Response<Object> response = new Response<>();
			response.setStatus(status);
			response.setPayLoad(obj);
			return ServiceUtil.toJson(response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CompletionException(e);
		}
	}



}
