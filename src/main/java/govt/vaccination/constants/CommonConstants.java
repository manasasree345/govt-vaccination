package govt.vaccination.constants;

public interface CommonConstants {
	public interface ResponseStatus {
		String SUCCESS = "Success";
		String FAIL = "Fail";
		String SERVER_UNDER_MAINTANANCE = "Server is under maintenance,please try again!!!";
	}
	
	public interface Gender{
		String MALE ="MALE";
		String FEMALE = "FEMALE";
	}
	
	
	public interface Vaccindose{
		String firstdose ="firstdose";
		String seconddose = "seconddose";
	}
	
	public interface User{
		String SAVE = "User Saved Successfully";

		String UPDATE = " User Updated Successfully";

		String RECORDFOUND = "User Found  ";

		String RECORDNOTFOUND = "User NotFound ";

		String LISTNOTFOUND = " User List Not Found";

		String  LISTFOUND = "UserList Found";
		String  EMAILEXISTS = "Email or Password number Exists";
		String  ERROR = "Error while saving the user";
	
	}
	
	

	
}
