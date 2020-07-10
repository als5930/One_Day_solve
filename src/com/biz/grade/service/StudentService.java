package com.biz.grade.service;

import java.util.List;

import com.biz.grade.domain.StudentVO;

/*
 * 파일을 읽어서 list에 담기
 * 학생정보를 입력받아 list에담기
 * list에 담긴 학생정보를 파일에 저장하기
 */
public interface StudentService {
	public void loadStudent();

	public boolean inputStudent();

	public void saveStudent();

	public void StudentList();

	public List<StudentVO> getStudentList();
	}
