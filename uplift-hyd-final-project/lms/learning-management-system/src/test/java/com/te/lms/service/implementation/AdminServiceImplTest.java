package com.te.lms.service.implementation;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.MentorRepository;
import com.te.lms.repository.RolesRepository;

class AdminServiceImplTest {

	@Mock
	private RolesRepository rolesRepository;
	
	@Mock
	private AppUserRepository appUserRepository;
	
	@Mock
	private MentorRepository mentorRepository;
	
	@InjectMocks
	private AdminServiceImpl adminServiceImpl;
	
	@Test
	 public void deleteRegister() {
		
	}

}
