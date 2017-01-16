package com.apollo.recorder.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.recorder.model.User;
import com.apollo.recorder.service.UserService;

@RestController
public class RecordController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/record/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> recordValue(@PathVariable(value = "userName", required = true) final String userName,
	    final HttpServletRequest request) {
	System.out.println(String.format("The request is served by recorder app with address : %s:%s for user : %s",
		request.getLocalAddr(), request.getLocalPort(), userName));
	return new ResponseEntity<>(userService.saveUpdateUser(userName), HttpStatus.OK);
    }

    @RequestMapping(value = "/")
    public String home() {
	return "Ping service";
    }

}
