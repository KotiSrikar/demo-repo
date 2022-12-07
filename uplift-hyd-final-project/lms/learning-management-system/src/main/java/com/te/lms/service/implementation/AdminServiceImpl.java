package com.te.lms.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.te.lms.dto.BatchDto;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.SkillsDto;
import com.te.lms.dto.TechnologiesDto;
import com.te.lms.dto.UpdateMentorDto;
import com.te.lms.email.Password;
import com.te.lms.entity.AppUser;
import com.te.lms.entity.Batch;
import com.te.lms.entity.Mentor;
import com.te.lms.entity.Roles;
import com.te.lms.entity.Skills;
import com.te.lms.entity.Technologies;
import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.BatchRepository;
import com.te.lms.repository.MentorRepository;
import com.te.lms.repository.RolesRepository;
import com.te.lms.repository.SkillsRepository;
import com.te.lms.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final MentorRepository mentorRepository;
	private final BatchRepository batchRepository;
	private final RolesRepository rolesRepository;
	private final AppUserRepository appUserRepository;
	private final SkillsRepository skillsRepository;

	@Override
	public Optional<String> register(MentorDto mentorDto) {

		Mentor mentor = new Mentor();
		Password password = new Password();

		BeanUtils.copyProperties(mentorDto, mentor);

		List<Skills> skills = Lists.newArrayList();

		for (SkillsDto skillsDto : mentorDto.getSkillsDto()) {
			Skills skillsEntity = new Skills();
			BeanUtils.copyProperties(skillsDto, skillsEntity);
			skills.add(skillsEntity);
			skillsEntity.setMentor(mentor);
		}

		mentor.setSkills(skills);

		Optional<Roles> optionalRole = rolesRepository.findByRoleName("ROLE_MENTOR");
		if (optionalRole.isPresent()) {
			AppUser appUser = AppUser.builder().username(mentor.getEmployeeId()).password(password.passwordGenerator())
					.roles(Lists.newArrayList()).build();

			appUser.getRoles().add(optionalRole.get());
			Roles roles = Roles.builder().roleName("ROLE_MENTOR").appUser(Lists.newArrayList()).build();
			roles.getAppUser().add(appUser);
			appUserRepository.save(appUser);
			mentorRepository.save(mentor);
			return Optional
					.ofNullable("username :" + appUser.getUsername() + "\n" + "password :" + appUser.getPassword());
		}

		return Optional.ofNullable(mentor.getEmployeeId());
	}

	@Override
	public Optional<String> createBatch(BatchDto batchDto) {

		Batch batch = new Batch();
		BeanUtils.copyProperties(batchDto, batch);

		List<Technologies> technologies = Lists.newArrayList();

		Optional<Mentor> mentorName = mentorRepository.findByMentorName(batchDto.getMentorName());
		Mentor mentor = mentorName.get();
		batch.setMentor(mentor);
		mentorName.get().setBatch(batch);

		for (TechnologiesDto technologiesDto : batchDto.getTechnologiesDto()) {
			Technologies technologiesEntity = new Technologies();
			BeanUtils.copyProperties(technologiesDto, technologiesEntity);
			technologies.add(technologiesEntity);
			technologiesEntity.getBatch().add(batch);
		}

		batch.setTechnologies(technologies);

		batchRepository.save(batch);

		return Optional.ofNullable(batchDto.getBatchId());
	}

	@Override
	public Optional<Boolean> updateMentor(UpdateMentorDto updateMentorDto, String empId) {

		Optional<Mentor> mentorFromDB = mentorRepository.findById(empId);

		if (mentorFromDB.isPresent()) {
			Mentor mentor = mentorFromDB.get();
			mentor.setEmailId(updateMentorDto.getEmailId());
			mentor.setMentorName(updateMentorDto.getMentorName());
			
			List<Skills> skills = mentor.getSkills();
			List<Skills> skills2 = Lists.newArrayList() ;

			if(skills!=null) {
				for(SkillsDto skillsDto : updateMentorDto.getSkillsDto()) {
					Skills skillsEntity = new Skills();
					BeanUtils.copyProperties(skillsDto, skillsEntity);
					skills2.add(skillsEntity);
					skillsEntity.setMentor(mentor);
				}
				
				mentor.setSkills(skills2);
			}
	 
			mentorRepository.save(mentor);
		}

		return null;
	}

}
