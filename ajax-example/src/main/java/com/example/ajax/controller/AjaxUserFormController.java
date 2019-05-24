package com.example.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ajax.model.JsonResponse;
import com.example.ajax.model.User;

@Controller
public class AjaxUserFormController {
	private List<User> userList = new ArrayList<User>();
	
	@RequestMapping("ajaxUserForm")
	public String getPage(){
		return "ajaxUserForm";
	}
	
	@RequestMapping(value="/addAjaxUser",method=RequestMethod.POST)
    public @ResponseBody JsonResponse addUser(@RequestBody User user, BindingResult result ){
            JsonResponse res = new JsonResponse();
            ValidationUtils.rejectIfEmpty(result, "name", "Name can not be empty.");
            ValidationUtils.rejectIfEmpty(result, "education", "Educatioan not be empty");
            if(!result.hasErrors()){
            		userList.add(user);
                    res.setStatus("SUCCESS");
                    res.setResult(userList);
            }else{
                    res.setStatus("FAIL");
                    res.setResult(result.getAllErrors());
            }

            return res;
    }
}
