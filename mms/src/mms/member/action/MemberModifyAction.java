package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberModifyService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberModifyAction implements Action{

	@Override
	public void execute(Scanner sc){
		// TODO Auto-generated method stub
		ConsoleUtil cu = new ConsoleUtil();
		String name = cu.getName("¼öÁ¤ÇÒ",sc);
		MemberModifyService memberModiftyService = new MemberModifyService();
		
		Member oldMember = memberModiftyService.getOldMember(name);
		
		Member updateMember = cu.getUpdateMember(sc, oldMember);
		
		boolean isModifySuccess = memberModiftyService.modifyMember(updateMember);
		
		if(isModifySuccess){
			cu.printModifySuccessMessage(updateMember);
		}else
			cu.printModifyFailMesaage(updateMember);
	}
}
