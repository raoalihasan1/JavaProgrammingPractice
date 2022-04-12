public class Checker{

  public static void main(String[] args){
    // Create Three Customers
    CheckableCustomer cc1 =new CheckableCustomer("id23","Ann",1000);
    CheckableCustomer cc2 =new CheckableCustomer("1234","Ben",1200);
    CheckableCustomer cc3 =new CheckableCustomer("id232","Camile",10000);

    System.out.println(cc1.getName()+"'s id is "+checkValidity(cc1));
    System.out.println(cc2.getName()+"'s id is "+checkValidity(cc2));
    System.out.println(cc3.getName()+"'s id is "+checkValidity(cc3));
  }


  // Receives Any Checkable Object
  private static String checkValidity(Checkable objectIn) {
    if(objectIn.check()){
      return "valid";
    }
    else{
      return "invalid";
    }
  }

}