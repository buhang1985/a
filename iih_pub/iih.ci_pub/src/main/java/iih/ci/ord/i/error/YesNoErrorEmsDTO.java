package iih.ci.ord.i.error;

import java.util.List;

public class YesNoErrorEmsDTO extends ErrorEmsDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public YesNoErrorEmsDTO(String code_or,String name_or,List<String> msgList) {
		super( code_or,name_or, msgList);
		this.setError_level("B");
	}
	public YesNoErrorEmsDTO(String code_or,String name_or,String msg) {
		super( code_or,name_or, msg);
		this.setError_level("B");
	}
}
