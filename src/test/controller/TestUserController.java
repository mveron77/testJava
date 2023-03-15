package com.test.java.testJava.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.test.java.testJava.model.request.UserDetailsRequest;
import com.test.java.testJava.repository.UserRepository;
import com.test.java.testJava.service.impl.UserServiceImpl;
import com.test.java.testJava.utils.JwtTokenUtil;

@ExtendWith(MockitoExtension.class)
public class TestUserController {
	@InjectMocks
	private UserController userController = new UserController();
	
	@Mock
	private UserRepository userRepository;
	
	static UserDetailsRequest createInvalidPwdReq= new UserDetailsRequest();
    static UserDetailsRequest createInvalidEmailReq = new UserDetailsRequest();
    static UserDetailsRequest createValidReq = new UserDetailsRequest();
	
    static final String EMAIL = "nlastName@domain.com";
    static final String PWD = "nlastName123";
    static final String EMAIL_FALSE = "nlastname.com";
    static final String PWD_FALSE = "nlastname123";
    
    @BeforeAll
    static void setUp() {
        createValidReq.setName("name");
        createValidReq.setLastName("fake");
        createValidReq.setPassword(PWD);
        createValidReq.setEmail(EMAIL);
        
        createInvalidEmailReq.setName("name");
        createInvalidEmailReq.setLastName("fake");
        createInvalidEmailReq.setEmail(EMAIL_FALSE);
        createInvalidEmailReq.setPassword(PWD);
        
        createInvalidPwdReq.setName("name");
        createInvalidPwdReq.setLastName("fake");
        createInvalidPwdReq.setEmail(EMAIL);
        createInvalidPwdReq.setPassword(PWD_FALSE);
    }
    
    @Test
    void register_ok() throws Exception {

        ResponseEntity<?> res = userController.createUser(createValidReq);

        Assertions.assertNotNull(res);
		Assertions.assertEquals(res.getStatusCode().value(),200);
    }
    
    @Test
    void register_errorEmail() throws Exception {
		 ResponseEntity<?> res = userController.createUser(createInvalidEmailReq);
		 Assertions.assertNotNull(res);
		 Assertions.assertEquals(res.getStatusCode().value(),400);
    }
    
    @Test
    void register_errorPwd() throws Exception {
		 ResponseEntity<?> res = userController.createUser(createInvalidPwdReq);
		 Assertions.assertNotNull(res);
		 Assertions.assertEquals(res.getStatusCode().value(),400);
    }

	
}
