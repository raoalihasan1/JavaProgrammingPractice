public class CheckableCustomer extends Customer implements Checkable{

	CheckableCustomer(String id, String name, double limit){
		super(id, name, limit);
	}

	public boolean check(){
		if(this.getCustomerId().length() == 4 && this.getCustomerId().charAt(0) == 'i' && this.getCustomerId().charAt(1) == 'd'){
			return true;
		}
		return false;
	}

}
