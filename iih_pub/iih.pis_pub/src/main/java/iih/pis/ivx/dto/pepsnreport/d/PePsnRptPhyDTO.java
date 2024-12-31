package iih.pis.ivx.dto.pepsnreport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检报告-科室结果 DTO数据 
 * 
 */
public class PePsnRptPhyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 个人预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 结果ID
	 * @return String
	 */
	public String getId_perst() {
		return ((String) getAttrVal("Id_perst"));
	}
	/**
	 * 结果ID
	 * @param Id_perst
	 */
	public void setId_perst(String Id_perst) {
		setAttrVal("Id_perst", Id_perst);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}
	/**
	 * 体检项目ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 结果
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}
	/**
	 * 结果
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
	}
	/**
	 * 阳性标识
	 * @return String
	 */
	public String getFg_posi() {
		return ((String) getAttrVal("Fg_posi"));
	}
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(String Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
	}
	/**
	 * 异常标识
	 * @return String
	 */
	public String getFg_abn() {
		return ((String) getAttrVal("Fg_abn"));
	}
	/**
	 * 异常标识
	 * @param Fg_abn
	 */
	public void setFg_abn(String Fg_abn) {
		setAttrVal("Fg_abn", Fg_abn);
	}
	/**
	 * 小结
	 * @return String
	 */
	public String getSumup() {
		return ((String) getAttrVal("Sumup"));
	}
	/**
	 * 小结
	 * @param Sumup
	 */
	public void setSumup(String Sumup) {
		setAttrVal("Sumup", Sumup);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}
	/**
	 * 项目名称
	 * @param Name_itm
	 */
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 检查医生
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}
	/**
	 * 检查医生
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 检查时间
	 * @return String
	 */
	public String getTime_check() {
		return ((String) getAttrVal("Time_check"));
	}
	/**
	 * 检查时间
	 * @param Time_check
	 */
	public void setTime_check(String Time_check) {
		setAttrVal("Time_check", Time_check);
	}
}