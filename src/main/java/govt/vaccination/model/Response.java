package govt.vaccination.model;


public class Response {
	private Object data;
	private Status status;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	
	
	public static class Status{
		private String success;
		private String message;
		public String getSuccess() {
			return success;
		}
		public void setSuccess(String success) {
			this.success = success;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

		
	}



	

}
