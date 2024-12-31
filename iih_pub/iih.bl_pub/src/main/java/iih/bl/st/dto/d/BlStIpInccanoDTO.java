package iih.bl.st.dto.d;

import xap.mw.core.data.BaseDTO;

public class BlStIpInccanoDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * 住院发票号
	 * */
	public String getIncno(){
		return ((String) getAttrVal("Incno"));
	}
	public void setIncno(String Incno){
		setAttrVal("Incno", Incno);
	}
	
	/**
	 * 住院押金条号
	 * */
	public String getPayno(){
		return ((String) getAttrVal("Payno"));
	}
	public void setPayno(String Payno){
		setAttrVal("Payno", Payno);
	}
	
}
