package iih.nm.nqm.dto.nqmcsexceldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 指标评分项目DTO DTO数据 
 * 
 */
public class NqmKpiitmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 指标评分项目id
	 * @return String
	 */
	public String getId_nqm_kpi_itm() {
		return ((String) getAttrVal("Id_nqm_kpi_itm"));
	}
	/**
	 * 指标评分项目id
	 * @param Id_nqm_kpi_itm
	 */
	public void setId_nqm_kpi_itm(String Id_nqm_kpi_itm) {
		setAttrVal("Id_nqm_kpi_itm", Id_nqm_kpi_itm);
	}
	/**
	 * 标准指标id
	 * @return String
	 */
	public String getId_nqm_kpi() {
		return ((String) getAttrVal("Id_nqm_kpi"));
	}
	/**
	 * 标准指标id
	 * @param Id_nqm_kpi
	 */
	public void setId_nqm_kpi(String Id_nqm_kpi) {
		setAttrVal("Id_nqm_kpi", Id_nqm_kpi);
	}
	/**
	 * 评分项id
	 * @return String
	 */
	public String getId_nqm_chkitm() {
		return ((String) getAttrVal("Id_nqm_chkitm"));
	}
	/**
	 * 评分项id
	 * @param Id_nqm_chkitm
	 */
	public void setId_nqm_chkitm(String Id_nqm_chkitm) {
		setAttrVal("Id_nqm_chkitm", Id_nqm_chkitm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 分值
	 * @return FDouble
	 */
	public FDouble getValue() {
		return ((FDouble) getAttrVal("Value"));
	}
	/**
	 * 分值
	 * @param Value
	 */
	public void setValue(FDouble Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 权重
	 * @return FDouble
	 */
	public FDouble getWi() {
		return ((FDouble) getAttrVal("Wi"));
	}
	/**
	 * 权重
	 * @param Wi
	 */
	public void setWi(FDouble Wi) {
		setAttrVal("Wi", Wi);
	}
	/**
	 * 百分比
	 * @return FDouble
	 */
	public FDouble getPct() {
		return ((FDouble) getAttrVal("Pct"));
	}
	/**
	 * 百分比
	 * @param Pct
	 */
	public void setPct(FDouble Pct) {
		setAttrVal("Pct", Pct);
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
}