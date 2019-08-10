package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT!");
		
		return true;
	}

	public void goSleep() {
		System.out.println(getClass() + ": I'm goint to sleep now...");
	}
}
