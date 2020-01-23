package com.javawiz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javawiz.form.model.Contact;
import com.javawiz.form.model.RequestForm;
import com.javawiz.form.model.Response;

@Controller
public class TableController {
	
	private static List<Contact> contacts = new ArrayList<Contact>();
	 
    static {
        contacts.add(new Contact("Barack", "Obama", "barack.o@whitehouse.com", "147-852-965"));
        contacts.add(new Contact("George", "Bush", "george.b@whitehouse.com", "785-985-652"));
        contacts.add(new Contact("Bill", "Clinton", "bill.c@whitehouse.com", "236-587-412"));
        contacts.add(new Contact("Ronald", "Reagan", "ronald.r@whitehouse.com", "369-852-452"));
    }
    
    @RequestMapping("table")
    public String getPage(Model model){
    	model.addAttribute("contacts", contacts);
		return "table";
    }
    
    @RequestMapping(value = "postData", method = RequestMethod.POST)
    @ResponseBody
    public Response getData(@RequestBody RequestForm form){
    	System.out.println("Controller hit");
    	
    	for (int i = 0; i < form.getMappingId().size(); i++) {
			System.out.println(form.getMappingId().get(i) +"\t" +form.getFirstnames().get(i));
			
		}
    	Response response = new Response();
    	response.setResponse("Success");
		return response;
    }
}
