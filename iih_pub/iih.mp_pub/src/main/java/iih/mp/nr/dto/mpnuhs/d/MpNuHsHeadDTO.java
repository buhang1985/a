package iih.mp.nr.dto.mpnuhs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 交接班信息 DTO数据 
 * 
 */
public class MpNuHsHeadDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交接班记录ID
	 * @return String
	 */
	public String getId_nuhs() {
		return ((String) getAttrVal("Id_nuhs"));
	}
	/**
	 * 交接班记录ID
	 * @param Id_nuhs
	 */
	public void setId_nuhs(String Id_nuhs) {
		setAttrVal("Id_nuhs", Id_nuhs);
	}
	/**
	 * 患者信息
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 患者信息
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
	/**
	 * 白班统计信息
	 * @return FArrayList
	 */
	public FArrayList getSummary_day() {
		return ((FArrayList) getAttrVal("Summary_day"));
	}
	/**
	 * 白班统计信息
	 * @param Summary_day
	 */
	public void setSummary_day(FArrayList Summary_day) {
		setAttrVal("Summary_day", Summary_day);
	}
	/**
	 * 夜班统计信息
	 * @return FArrayList
	 */
	public FArrayList getSummary_night() {
		return ((FArrayList) getAttrVal("Summary_night"));
	}
	/**
	 * 夜班统计信息
	 * @param Summary_night
	 */
	public void setSummary_night(FArrayList Summary_night) {
		setAttrVal("Summary_night", Summary_night);
	}
	/**
	 * 夜班2统计信息
	 * @return FArrayList
	 */
	public FArrayList getSummary_night2() {
		return ((FArrayList) getAttrVal("Summary_night2"));
	}
	/**
	 * 夜班2统计信息
	 * @param Summary_night2
	 */
	public void setSummary_night2(FArrayList Summary_night2) {
		setAttrVal("Summary_night2", Summary_night2);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 交接班记录SV
	 * @return FDateTime
	 */
	public FDateTime getNuhs_sv() {
		return ((FDateTime) getAttrVal("Nuhs_sv"));
	}
	/**
	 * 交接班记录SV
	 * @param Nuhs_sv
	 */
	public void setNuhs_sv(FDateTime Nuhs_sv) {
		setAttrVal("Nuhs_sv", Nuhs_sv);
	}
	
	/**
	 * 统计信息
	 * @return FArrayList
	 */
	public FArrayList getSummary() {
		return ((FArrayList) getAttrVal("Summary"));
	}
	/**
	 * 统计信息
	 * @param Summary_day
	 */
	public void setSummary(FArrayList Summary) {
		setAttrVal("Summary", Summary);
	}
}