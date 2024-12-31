package iih.cssd.dpus.dto.dfpappsend.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发放查询条件 DTO数据 
 * 
 */
public class SendCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发放状态
	 * @return Integer
	 */
	public Integer getEu_send() {
		return ((Integer) getAttrVal("Eu_send"));
	}
	/**
	 * 发放状态
	 * @param Eu_send
	 */
	public void setEu_send(Integer Eu_send) {
		setAttrVal("Eu_send", Eu_send);
	}
	/**
	 * 请领科室ID
	 * @return String
	 */
	public String getId_dep_app() {
		return ((String) getAttrVal("Id_dep_app"));
	}
	/**
	 * 请领科室ID
	 * @param Id_dep_app
	 */
	public void setId_dep_app(String Id_dep_app) {
		setAttrVal("Id_dep_app", Id_dep_app);
	}
	/**
	 * 请领科室名称
	 * @return String
	 */
	public String getName_dep_app() {
		return ((String) getAttrVal("Name_dep_app"));
	}
	/**
	 * 请领科室名称
	 * @param Name_dep_app
	 */
	public void setName_dep_app(String Name_dep_app) {
		setAttrVal("Name_dep_app", Name_dep_app);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}