package MemberDB;
import java.sql.ResultSet;

public class MemberController {
	
	   
	  
	   MemberDAO memberDAO; 
	   
	   
	   public MemberController() {
		   
		 memberDAO = new MemberDAOImp();
	   }
	   
	   public ResultSet create(Member member) {
		  return memberDAO.create(member);
	   }

	   public ResultSet update(Member member){
		   return memberDAO.update(member);
	   }
	   

	   public void delete(Member member){
		   memberDAO.delete(member);
	   }
	   
	   public Member moveFirst(){
		   return memberDAO.moveFirst();
	   }
	   
	   public Member moveLast(){
		   return memberDAO.moveLast();
	   }
	   
	   public Member moveNext(){
		   return memberDAO.moveNext();
	   }
	   
	   
	   public Member movePrevious(){
		return memberDAO.movePrevious();
	   }
	   
	   public Member getCurrent(){
		 return memberDAO.getCurrent();
	   }
	   
	   
	}