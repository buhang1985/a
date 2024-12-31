package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 口腔预约简要信息DTO DTO数据 
 * 
 */
public class AptOralBriefDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 诊间
	 * @return String
	 */
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}
	/**
	 * 诊间
	 * @param Room
	 */
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apt() {
		return ((FDateTime) getAttrVal("Dt_apt"));
	}
	/**
	 * 预约时间
	 * @param Dt_apt
	 */
	public void setDt_apt(FDateTime Dt_apt) {
		setAttrVal("Dt_apt", Dt_apt);
	}
}