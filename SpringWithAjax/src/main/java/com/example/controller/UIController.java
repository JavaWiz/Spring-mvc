package com.example.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Times;

@Controller
public class UIController {

	@RequestMapping(value = "ajaxcall", method = RequestMethod.GET)
	public String getdata() {
		return "ajaxcall";
	}

	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public @ResponseBody
	String getTime(@RequestParam String name) {
		String result = "Time for " + name + " is " + new Date().toString();
		return result;
	}

	@RequestMapping(value = "json_time", method = RequestMethod.GET)
	public @ResponseBody
	Times getTimeInJson(@RequestParam String name) {
		Times time = new Times();
		time.setName(name);
		time.setTime(new Date().toString());

		return time;
	}
	
	@RequestMapping(value = "requestHeaderInfo", method = RequestMethod.GET)
	public String getPage(){
		return "reqHeaderInfo";
	}
	
	@RequestMapping(value = "reqHeaderInfo", method = RequestMethod.GET)
	@ResponseBody
    public String requestHeaderInfo(
            @RequestHeader(value="Accept") String accept,
            @RequestHeader(value="Accept-Language") String acceptLanguage,
            @RequestHeader(value="User-Agent", defaultValue="foo") String userAgent
            ) {
		/*JSONObject json = new JSONObject();
		json.put("accept",accept);
        json.put("acceptLanguage", acceptLanguage);
        json.put("userAgent", userAgent);
        String jsonString =json.toString();*/       
        return "accept: " + accept+", acceptLanguage: " + acceptLanguage+", userAgent: " + userAgent;
        
    }
	
	@RequestMapping(value="getInfo", method = RequestMethod.GET)
	public @ResponseBody void generateReport(
	        HttpServletRequest request, 
	        HttpServletResponse response) {
		
		try {
			response.getWriter().println("Ranjan");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}