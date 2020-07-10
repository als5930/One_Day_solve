package com.biz.grade.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.grade.confug.DBContract.STUDENT;
import com.biz.grade.confug.Lines;
import com.biz.grade.domain.StudentVO;

public class StudentServiceImpV1 implements StudentService

{

	private List<StudentVO> studentList;

	private Scanner sc;

	private String fileName;

	
	
	
	
	public StudentServiceImpV1()

	{

		studentList = new ArrayList<StudentVO>();

		sc = new Scanner(System.in);

		fileName = "src/com/biz/grade/exec/data/student.txt";

	}
	@Override
	public List<StudentVO> getStudentList() {
		// TODO Auto-generated method stub
		return studentList;
	}
	
	
	public StudentVO getStudent(String st_num) {
		
		StudentVO studentVO =null;
		for(StudentVO stVO : studentList) {
			//3. 매개변수로 받은 st_num가 학생정보에서 나타나는지 검사
			//4.만약 있으면 해당하는 학생 정보를 studentVO에 복사하고
			//5. 반복문 종료
			if(stVO.getNum().equals(st_num)) {
				studentVO=stVO;
				break;
			}	
			//6. 만약 studentList에서 해당학번을 못찾으면 반복문은 끝까지 진행할것이다
		}
		
		/*
		 * 7. 만약 중간에 if, break를 만나고
		 */
		return studentVO;
		
	}
	
	
	@Override

	public boolean inputStudent()

	{

		StudentVO stuVO = new StudentVO();

		int intNum = 0;

		System.out.print("학번 : ");

		String st_num = sc.nextLine();

		if (st_num.equalsIgnoreCase("end"))

			return false;

		// ==================================================

		try {
			intNum = Integer.valueOf(st_num);
		}

		catch (Exception e) {
			return true;
		}

		if (intNum < 1 || intNum > 99999)

		{

			System.out.println("학번은 1 ~ 99999까지의 숫자만 가능");

			return true;

		}

		st_num = String.format("%05d", intNum);

		stuVO.setNum(st_num);

		// ==================================================

		System.out.print("이름 입력 : ");

		st_num = sc.nextLine();

		stuVO.setName(st_num);

		// ==================================================

		System.out.print("학과 입력 : ");

		st_num = sc.nextLine();

		stuVO.setDept(st_num);

		// ==================================================

		System.out.print("학년 입력 : ");

		st_num = sc.nextLine();

		intNum = Integer.valueOf(st_num);

		if (intNum < 0 || intNum > 4)

		{

			System.out.println("학년은 1-4학년 까지만 입력가능");

			return true;

		}

		stuVO.setGtade(intNum);

		// ==================================================

		System.out.print("전화번호 입력(000-0000-000)형식 : ");

		st_num = sc.nextLine();

		stuVO.setTel(st_num);

		// ==================================================

		studentList.add(stuVO);

		return true;

	}

	public void listStudent()

	{

		System.out.println(Lines.dLins);

		System.out.println("학생 명부 리스트");

		System.out.println(Lines.dLins);

		System.out.println("학번\t|이름\t|학과\t|학년\t|전화번호\t|");

		System.out.println(Lines.sLins);

		for (StudentVO i : studentList)

		{

			System.out.printf("%s\t|", i.getNum());

			System.out.printf("%s\t|", i.getName());

			System.out.printf("%s\t|", i.getDept());

			System.out.printf("%s\t|", i.getGtade());

			System.out.printf("%s\t|\n", i.getTel());

			System.out.println();

		}

	}

	@Override

	public void loadStudent()

	{

		FileReader fileReader = null;

		BufferedReader buffer = null;

		try

		{

			fileReader = new FileReader(this.fileName);

			buffer = new BufferedReader(fileReader);

			String reader;

			while (true)

			{

				reader = buffer.readLine();

				if (reader == null)

					break;

				String[] students = reader.split(":");

				StudentVO vo = new StudentVO();

				vo.setNum(students[STUDENT.ST_NUM]);

				vo.setName(students[STUDENT.ST_NAME]);

				vo.setDept(students[STUDENT.ST_DEPT]);

				vo.setGtade(Integer.valueOf(students[STUDENT.ST_GRADE]));

				vo.setDept(students[STUDENT.ST_TEL]);

				studentList.add(vo);

				this.saveStudent();

			}

		}

		catch (FileNotFoundException e) {
			System.out.println("학생정보 파일 열기 오류");
		}

		catch (IOException e) {
			System.out.println("학생정보 파일 읽기 오류");
		}

	}

	@Override

	public void saveStudent()

	{

		// FileWriter fileWriter = null;

		PrintWriter pWriter = null;

		try

		{

			// fileWriter = new FileWriter(this.fileName);

			pWriter = new PrintWriter(new FileWriter(this.fileName), true); // 내부의 Writer buffer에 기록

			for (StudentVO vo : studentList)

			{

				pWriter.printf("%s:", vo.getNum());

				pWriter.printf("%s:", vo.getName());

				pWriter.printf("%s:", vo.getDept());

				pWriter.printf("%d:", vo.getGtade());

				pWriter.printf("%s:", vo.getTel());

			}

			pWriter.flush(); // Writer buffer에 기록된 값을 파일에 저장

			pWriter.close();

		}

		catch (IOException e)

		{

			e.printStackTrace();

		}

	}

	@Override
	public void StudentList() {
		// TODO Auto-generated method stub

	}



}