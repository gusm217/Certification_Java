package com.java_app.certification.modules.students.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_app.certification.modules.students.dto.VerifyIfHasCertificationDTO;
import com.java_app.certification.modules.students.useCases.VerifyIfHasCertificationUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

	@PostMapping("/verifyIfHasCertification")
	public String verifyIfHasCertification(@RequestBody VerifyIfHasCertificationDTO verifyIfHasCertificationDTO) {

		var result = this.verifyIfHasCertificationUseCase.execute(verifyIfHasCertificationDTO);
		if(result) {
			return "Usuário já fez a prova";
		}

		return "Usuário pode fazer a prova";
	}
}
