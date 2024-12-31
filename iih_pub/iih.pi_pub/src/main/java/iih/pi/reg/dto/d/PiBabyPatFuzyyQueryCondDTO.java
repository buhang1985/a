package iih.pi.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 新生儿模糊查询条件 DTO数据 
 * 
 */
public class PiBabyPatFuzyyQueryCondDTO extends BaseDTO {
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 母亲证件号
	 * @return String
	 */
	public String getMum_id() {
		return ((String) getAttrVal("Mum_id"));
	}
	/**
	 * 母亲证件号
	 * @param Mum_id
	 */
	public void setMum_id(String Mum_id) {
		setAttrVal("Mum_id", Mum_id);
	}
	/**
	 * 母亲电话号码
	 * @return String
	 */
	public String getMum_tel() {
		return ((String) getAttrVal("Mum_tel"));
	}
	/**
	 * 母亲电话号码
	 * @param Mum_tel
	 */
	public void setMum_tel(String Mum_tel) {
		setAttrVal("Mum_tel", Mum_tel);
	}
}