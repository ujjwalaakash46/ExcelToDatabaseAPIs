package project.dto;

public class ResponseDto {
	String meassage;
	Object data;
	
	public ResponseDto(String meassage, Object data) {
		this.meassage = meassage;
		this.data = data;
	}

	public String getMeassage() {
		return meassage;
	}

	public void setMeassage(String meassage) {
		this.meassage = meassage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
