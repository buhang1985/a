package iih.ci.ord.dto.dtlastblcalparam.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 计算首日执行次数的入参 DTO数据 
 * 
 */
public class DtLastBlCalParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊类型（必填）
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型（必填）
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 出院带药标识，默认false
	 * @return String
	 */
	public String getFg_pres_outp() {
		return ((String) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识，默认false
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(String Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 频次(必填)
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次(必填)
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 开始时间（必填）
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 开始时间（必填）
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 首日执行次数（可为空，空为0）
	 * @return Integer
	 */
	public Integer getTimes_firday_mp() {
		return ((Integer) getAttrVal("Times_firday_mp"));
	}
	/**
	 * 首日执行次数（可为空，空为0）
	 * @param Times_firday_mp
	 */
	public void setTimes_firday_mp(Integer Times_firday_mp) {
		setAttrVal("Times_firday_mp", Times_firday_mp);
	}
	/**
	 * 长临标识（必填）
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识（必填）
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
}