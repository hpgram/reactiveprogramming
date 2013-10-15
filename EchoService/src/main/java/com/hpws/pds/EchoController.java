package com.hpws.pds;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/reactiveprogramming")
public class EchoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EchoController.class);
	
	
	@RequestMapping(value = "/sendecho", method = RequestMethod.POST)
	public @ResponseBody Result echo(@RequestBody Map<String,String> body)  throws Exception  {
		
		String target = body.get("target");
		String message = body.get("message");
		
		logger.debug("Received POST request:" + target + " message: " + message);

		Result r = new Result();
		r.setStatus("ack");
		r.setMessage(target + " said: " + message);
		
	    return r;
	}	
	
	@RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
	public @ResponseBody String healthcheck()  throws Exception  {
		
		return "Good";
		
	}
	
}
