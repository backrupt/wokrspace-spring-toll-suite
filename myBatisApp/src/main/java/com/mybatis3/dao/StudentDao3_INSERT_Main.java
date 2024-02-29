package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDao3_INSERT_Main {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudentBySequence(Dto)--------------------------");
		int insertRowCount = studentDao.insertStudentBySequence(Student.builder()
													.studId(2)
													.name("test1")
													.email("test1@naver.com")
													.phone("010-1111-1111")
													.dob(new Date())
													.build());	
		System.out.println(">>> dao return insertRowCount:"+insertRowCount);
		System.out.println("---------insertStudentBySequenceReturnPrimaryKey---------------");
		/*
		int insertPrimaryKey = studentDao.insertStudentBySequenceReturnPrimaryKey(Student.builder()
													.name("test2")
													.email("test2@naver.com")
													.phone("010-2222-2222")
													.dob(new Date())
													.build());
		*/	
		Student insertStudent = Student.builder()
				.studId(90000000)
				.name("test2")
				.email("test2@naver.com")
				.phone("010-2222-2222")
				.dob(new Date())
				.build();
		System.out.println(insertStudent.getStudId());
		System.out.println(insertStudent);
		insertRowCount = studentDao.insertStudentBySequenceReturnPrimaryKey(insertStudent);
		System.out.println(">>> insertRowCount :"+insertRowCount);
		System.out.println(">>> Student[Dto]     primary key:"+insertStudent.getStudId());
		System.out.println(insertStudent);
		
		
		
	}
}
