package cl.madduck.ynab.scanner.santander.dao;

import com.google.gson.annotations.SerializedName;

public class LoginResult {

	@SerializedName("Result")
	private Result result;
	
	@SerializedName("ErrorCode")
	private String errorCode;
	
	@SerializedName("ErrorDescription")
	private String errorDescription;
	
	@SerializedName("UserErrorDescription")
	private String userErrorDescription;
	
	@SerializedName("Status")
	private int status;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getUserErrorDescription() {
		return userErrorDescription;
	}

	public void setUserErrorDescription(String userErrorDescription) {
		this.userErrorDescription = userErrorDescription;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public class Result {
		@SerializedName("KEY")
		private String key;
		@SerializedName("STATUS")
		private String status;
		@SerializedName("DESCRIPCION")
		private String descripcion;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

	}
}
