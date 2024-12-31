package iih.cssd.dpus.dto.dfprev.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消毒包接收人员科室 DTO数据 
 * 
 */
public class RevQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 识别码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}
	/**
	 * 识别码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 接收状态
	 * @return Integer
	 */
	public Integer getEu_rev_sta() {
		return ((Integer) getAttrVal("Eu_rev_sta"));
	}
	/**
	 * 接收状态
	 * @param Eu_rev_sta
	 */
	public void setEu_rev_sta(Integer Eu_rev_sta) {
		setAttrVal("Eu_rev_sta", Eu_rev_sta);
	}
	/**
	 * 开始时间
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 消毒包ID串
	 * @return String
	 */
	public String getId_dfps() {
		return ((String) getAttrVal("Id_dfps"));
	}
	/**
	 * 消毒包ID串
	 * @param Id_dfps
	 */
	public void setId_dfps(String Id_dfps) {
		setAttrVal("Id_dfps", Id_dfps);
	}
}