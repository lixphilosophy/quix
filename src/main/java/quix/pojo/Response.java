package quix.pojo;

public class Response {
	
	private boolean success = true;
	private String errMsg;
	private String redirectUrl;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	
}
