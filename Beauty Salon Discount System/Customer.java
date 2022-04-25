public class Customer {

	private String Name;
	private boolean Member;
	private String memberType;

	Customer(String customerName){
		Name = customerName;
	}

	public String getName(){
		return Name;
	}

	public boolean isMember(){
		return Member;
	}

	public void setMember(boolean areMember){
		Member = areMember;
	}

	public String getMemberType(){
		return memberType;
	}

	public void setMemberType(String typeOfMember){
		memberType = typeOfMember;
	}

}