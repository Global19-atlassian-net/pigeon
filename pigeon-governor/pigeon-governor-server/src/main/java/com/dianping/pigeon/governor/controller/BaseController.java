package com.dianping.pigeon.governor.controller;

import javax.servlet.http.HttpServletRequest;

import com.dianping.pigeon.governor.util.IPUtils;

/**
 * 
 * @author chenchongze
 *
 */
public class BaseController {

	public void verifyIdentity(int userId) throws Exception{
		
		if(userId != 3){
			throw new Exception(String.format("User id %d is not system level", userId));
		}
		
	}
	
	public void verifyIdentity(HttpServletRequest request, int userId) throws Exception{
		
		String ip = IPUtils.getUserIP(request);
		if(!"0:0:0:0:0:0:0:1%0".equals(ip)){
			throw new Exception("You have no privilege.");
		}
		
		verifyIdentity(userId);
		
	}
}
