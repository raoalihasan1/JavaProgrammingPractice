import java.text.DecimalFormat;

public class Visit {

	private Customer theCustomer;
	public double serviceExpense;
	public double productExpense;
	private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

	Visit(String customerName){
		theCustomer = new Customer(customerName);
	}

	public Customer getCustomer(){
		return theCustomer;
	}

	public double getServiceExpense(){
		return serviceExpense;
	}

	public void setServiceExpense(double ex){
		serviceExpense = ex;
	}

	public double getProductExpense(){
		return productExpense;
	}

	public void setProductExpense(double ex){
		productExpense = ex;
	}

	public double getTotalExpense(){
		if(theCustomer.isMember()){
			double serviceDiscount = new DiscountRate().getServiceDiscountRate(theCustomer.getMemberType());
			double productDiscount = new DiscountRate().getProductDiscountRate(theCustomer.getMemberType());
			return ((1 - serviceDiscount) * serviceExpense + (1 - productDiscount) * productExpense);
		} else {
			return serviceExpense + productExpense;
		}
	}

	public String toString(boolean isMember){
		if(isMember){
			return getCustomer().getMemberType() + " Member";
		} else {
			return "Non-Member";
		}
	}

	public static void main(String[] args) {

		Visit newCustomer = new Visit("Ali Hasan");
		newCustomer.getCustomer().setMember(true);
		newCustomer.getCustomer().setMemberType("Gold");
		newCustomer.setServiceExpense(10.75);
		newCustomer.setProductExpense(8.20);
		System.out.println("--------------------\nCustomer Name: " + newCustomer.getCustomer().getName());
		System.out.println("Membership Status: " + newCustomer.toString(newCustomer.getCustomer().isMember()));
		System.out.println("Total Expense Is: $" + decimalFormat.format(newCustomer.getTotalExpense()));

		Visit newCustomer2 = new Visit("Steve");
		newCustomer2.setServiceExpense(10.75);
		newCustomer2.setProductExpense(8.20);
		System.out.println("--------------------\nCustomer Name: " + newCustomer2.getCustomer().getName());
		System.out.println("Membership Status: " + newCustomer2.toString(newCustomer2.getCustomer().isMember()));
		System.out.println("Total Expense Is: $" + decimalFormat.format(newCustomer2.getTotalExpense()));

		Visit newCustomer3 = new Visit("Matthew");
		newCustomer3.getCustomer().setMember(true);
		newCustomer3.getCustomer().setMemberType("Silver");
		newCustomer3.setServiceExpense(10.75);
		newCustomer3.setProductExpense(8.20);
		System.out.println("--------------------\nCustomer Name: " + newCustomer3.getCustomer().getName());
		System.out.println("Membership Status: " + newCustomer3.toString(newCustomer3.getCustomer().isMember()));
		System.out.println("Total Expense Is: $" + decimalFormat.format(newCustomer3.getTotalExpense()));

		Visit newCustomer4 = new Visit("John");
		newCustomer4.getCustomer().setMember(true);
		newCustomer4.getCustomer().setMemberType("Premium");
		newCustomer4.setServiceExpense(10.75);
		newCustomer4.setProductExpense(8.20);
		System.out.println("--------------------\nCustomer Name: " + newCustomer4.getCustomer().getName());
		System.out.println("Membership Status: " + newCustomer4.toString(newCustomer4.getCustomer().isMember()));
		System.out.println("Total Expense Is: $" + decimalFormat.format(newCustomer4.getTotalExpense()) + "\n--------------------");

	}

}