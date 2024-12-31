package iih.ei.std.d.v1.en.aptidbyaptcode.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 预约编码获取预约ID出参 DTO数据 
 * 
 */
public class AptIdByAptCodeResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约编码获取预约ID
	 * @return String
	 */
	public FArrayList getAptidbyaptcode() {
		return ((FArrayList) getAttrVal("Aptidbyaptcode"));
	}	
	/**
	 * 预约编码获取预约ID
	 * @param Aptidbyaptcode
	 */
	public void setAptidbyaptcode(FArrayList Aptidbyaptcode) {
		setAttrVal("Aptidbyaptcode", Aptidbyaptcode);
	}
}