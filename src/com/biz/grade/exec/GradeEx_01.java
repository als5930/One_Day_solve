package com.biz.grade.exec;

import java.util.Scanner;

import com.biz.grade.confug.DBContract;
import com.biz.grade.confug.Lines;
import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceImpV1;
import com.biz.grade.service.StudentService;
import com.biz.grade.service.StudentServiceImpV1;


public class GradeEx_01 {

	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		StudentService stService =new StudentServiceImpV1();
		ScoreService scService =new ScoreServiceImpV1();
		
		//stService.loadStudent();
		
		while(true) {
			
			System.out.println(Lines.dLins);
			System.out.println("빛고을 대학 학사관리 시스템 V1");
			System.out.println(Lines.dLins);
			System.out.println("1. 학생정보 등록");
			System.out.println("2. 학생정보 출력");
			System.out.println("3. 학생성적 등록");
			System.out.println("4. 성적일람표 출력");
			
			System.out.println("QUIT.업무종료");
			System.out.println(Lines.dLins);
			System.out.println("업무선택 >>");
			
			String stMenu =scan.nextLine();
			if(stMenu.equals("QUIT")) {
				break;
			}
			int intMenu =0;
			try {
				intMenu =Integer.valueOf(stMenu);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("메뉴는 숫자로만 선택 할수 있음");
				continue;
			}
			if(intMenu ==DBContract.MENU.학생정보등록) {
				if(!stService.inputStudent()) {
					break;
				}
			}else if(intMenu ==DBContract.MENU.학생리스트출력) {
				stService.StudentList();
			}else if(intMenu ==DBContract.MENU.성적등록) {
				//1 inputScore()호출하여 코드를 수행하고
				//2. inputScore()가 true를 return하면 계속 반복하고
				//3. inputScore()가 false를 return하면 
				while(scService.inputScore());
				
			}else if(intMenu ==DBContract.MENU.성적일람표) {
				scService.scoreList();
			}
			
			System.out.println("업무종료");
			System.out.println(" 야 퇴근이다");
		}
		
		}
	
	
}
