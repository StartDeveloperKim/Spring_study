package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForMemberDao {
	private static MemberDao memberDao;
	
	public static void main(String[] args) throws WrongIdPasswordException {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);
		
		memberDao = ctx.getBean(MemberDao.class);
		
		ChangePasswordService cps = 
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			cps.changePassword("ktw@naver.com", "0000", "1234");
			System.out.println("암호를 변경했습니다.");
		} catch (MemberNotFoundException e) {
            System.out.println("회원 데이터가 존재하지 않습니다.");
		} catch (WrongIdPasswordException e) {
			 System.out.println("암호가 올바르지 않습니다.");
		}
		
		selectAll();
		/*
		 * selectAll(); updateMember(); insertMember();
		 */
		
		ctx.close();

	}

	private static void selectAll() {
		System.out.println("----- selectAll");
		int total = memberDao.count();
		System.out.println("전체 데이터: " + total);
		List<Member> members = (List<Member>) memberDao.selectAll();
		for (Member m : members) {
			System.out.println(m.getId() + ":" + m.getEmail() + ":" + m.getName());
		}
	}
	
	private static void updateMember() throws WrongIdPasswordException {
		System.out.println("----- updateMember");
		Member member = memberDao.selectByEmail("ktw@naver.com");
		String oldPw = member.getPassword();
		String newPw = Double.toHexString(Math.random());
		member.changePassword(oldPw, newPw);

		memberDao.update(member);
		System.out.println("암호 변경: " + oldPw + " > " + newPw);
		
	}
	
	private static DateTimeFormatter formatter = 
			DateTimeFormatter.ofPattern("MMddHHmmss");
	
	private static void insertMember() {
		System.out.println("----- insertMember");

		String prefix = formatter.format(LocalDateTime.now());
		Date now = new Date();
		Member member = new Member(prefix + "@test.com", 
				prefix, prefix, now);
		memberDao.insert(member);
		System.out.println(member.getId() + " 데이터 추가");
	}



}
