package iih.ci.mrm.dto.mrmprintdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案打印DTO DTO数据 
 * 
 */
public class MrmPrintDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案主键
	 * @return String
	 */
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}
	/**
	 * 病案主键
	 * @param Id_amr
	 */
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 复印份数
	 * @return Integer
	 */
	public Integer getCopies() {
		return ((Integer) getAttrVal("Copies"));
	}
	/**
	 * 复印份数
	 * @param Copies
	 */
	public void setCopies(Integer Copies) {
		setAttrVal("Copies", Copies);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getTotal() {
		return ((FDouble) getAttrVal("Total"));
	}
	/**
	 * 金额
	 * @param Total
	 */
	public void setTotal(FDouble Total) {
		setAttrVal("Total", Total);
	}
	/**
	 * 复印页数
	 * @return Integer
	 */
	public Integer getCopynum() {
		return ((Integer) getAttrVal("Copynum"));
	}
	/**
	 * 复印页数
	 * @param Copynum
	 */
	public void setCopynum(Integer Copynum) {
		setAttrVal("Copynum", Copynum);
	}
	/**
	 * 当前时间
	 * @return FDateTime
	 */
	public FDateTime getDt_now() {
		return ((FDateTime) getAttrVal("Dt_now"));
	}
	/**
	 * 当前时间
	 * @param Dt_now
	 */
	public void setDt_now(FDateTime Dt_now) {
		setAttrVal("Dt_now", Dt_now);
	}
	/**
	 * 输出模板表主键
	 * @return String
	 */
	public String getId_bd_mrm_pt() {
		return ((String) getAttrVal("Id_bd_mrm_pt"));
	}
	/**
	 * 输出模板表主键
	 * @param Id_bd_mrm_pt
	 */
	public void setId_bd_mrm_pt(String Id_bd_mrm_pt) {
		setAttrVal("Id_bd_mrm_pt", Id_bd_mrm_pt);
	}
	/**
	 * 文件系统编号
	 * @return String
	 */
	public String getCode_file() {
		return ((String) getAttrVal("Code_file"));
	}
	/**
	 * 文件系统编号
	 * @param Code_file
	 */
	public void setCode_file(String Code_file) {
		setAttrVal("Code_file", Code_file);
	}
}