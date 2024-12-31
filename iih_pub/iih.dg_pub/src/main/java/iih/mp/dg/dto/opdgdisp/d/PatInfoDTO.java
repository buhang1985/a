package iih.mp.dg.dto.opdgdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊患者信息v2 DTO数据 
 * 
 */
public class PatInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 交费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bl() {
		return ((FDateTime) getAttrVal("Dt_bl"));
	}
	/**
	 * 交费时间
	 * @param Dt_bl
	 */
	public void setDt_bl(FDateTime Dt_bl) {
		setAttrVal("Dt_bl", Dt_bl);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 患者排队号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 患者排队号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 接受状态
	 * @return String
	 */
	public String getSd_status_acpt() {
		return ((String) getAttrVal("Sd_status_acpt"));
	}
	/**
	 * 接受状态
	 * @param Sd_status_acpt
	 */
	public void setSd_status_acpt(String Sd_status_acpt) {
		setAttrVal("Sd_status_acpt", Sd_status_acpt);
	}
	/**
	 * 是否已发药
	 * @return FBoolean
	 */
	public FBoolean getFg_dispensed() {
		return ((FBoolean) getAttrVal("Fg_dispensed"));
	}
	/**
	 * 是否已发药
	 * @param Fg_dispensed
	 */
	public void setFg_dispensed(FBoolean Fg_dispensed) {
		setAttrVal("Fg_dispensed", Fg_dispensed);
	}
}