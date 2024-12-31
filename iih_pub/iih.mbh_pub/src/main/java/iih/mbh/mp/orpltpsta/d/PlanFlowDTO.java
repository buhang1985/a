package iih.mbh.mp.orpltpsta.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行计划流向 DTO数据 
 * 
 */
public class PlanFlowDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行计划
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 计划状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 计划状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 闭环
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 闭环
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 当前闭环状态ID
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}
	/**
	 * 当前闭环状态ID
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 闭环状态名称
	 * @return String
	 */
	public String getName_orpltpsta() {
		return ((String) getAttrVal("Name_orpltpsta"));
	}
	/**
	 * 闭环状态名称
	 * @param Name_orpltpsta
	 */
	public void setName_orpltpsta(String Name_orpltpsta) {
		setAttrVal("Name_orpltpsta", Name_orpltpsta);
	}
	/**
	 * 当前闭环序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 当前闭环序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 下一闭环状态
	 * @return String
	 */
	public String getId_next() {
		return ((String) getAttrVal("Id_next"));
	}
	/**
	 * 下一闭环状态
	 * @param Id_next
	 */
	public void setId_next(String Id_next) {
		setAttrVal("Id_next", Id_next);
	}
	/**
	 * 下一闭环状态名称
	 * @return String
	 */
	public String getName_next() {
		return ((String) getAttrVal("Name_next"));
	}
	/**
	 * 下一闭环状态名称
	 * @param Name_next
	 */
	public void setName_next(String Name_next) {
		setAttrVal("Name_next", Name_next);
	}
	/**
	 * 功能节点名称
	 * @return String
	 */
	public String getName_func() {
		return ((String) getAttrVal("Name_func"));
	}
	/**
	 * 功能节点名称
	 * @param Name_func
	 */
	public void setName_func(String Name_func) {
		setAttrVal("Name_func", Name_func);
	}
	/**
	 * 功能节点编码
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 功能节点编码
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 处理类名
	 * @return String
	 */
	public String getClassname() {
		return ((String) getAttrVal("Classname"));
	}
	/**
	 * 处理类名
	 * @param Classname
	 */
	public void setClassname(String Classname) {
		setAttrVal("Classname", Classname);
	}
	/**
	 * 计划闭环状态
	 * @return String
	 */
	public String getId_mp_sta() {
		return ((String) getAttrVal("Id_mp_sta"));
	}
	/**
	 * 计划闭环状态
	 * @param Id_mp_sta
	 */
	public void setId_mp_sta(String Id_mp_sta) {
		setAttrVal("Id_mp_sta", Id_mp_sta);
	}
	/**
	 * 是否当前状态
	 * @return FBoolean
	 */
	public FBoolean getFg_current() {
		return ((FBoolean) getAttrVal("Fg_current"));
	}
	/**
	 * 是否当前状态
	 * @param Fg_current
	 */
	public void setFg_current(FBoolean Fg_current) {
		setAttrVal("Fg_current", Fg_current);
	}
	/**
	 * PDA执行类型
	 * @return Integer
	 */
	public Integer getEu_pdamp() {
		return ((Integer) getAttrVal("Eu_pdamp"));
	}
	/**
	 * PDA执行类型
	 * @param Eu_pdamp
	 */
	public void setEu_pdamp(Integer Eu_pdamp) {
		setAttrVal("Eu_pdamp", Eu_pdamp);
	}
	/**
	 * 是否已执行
	 * @return FBoolean
	 */
	public FBoolean getFg_execd() {
		return ((FBoolean) getAttrVal("Fg_execd"));
	}
	/**
	 * 是否已执行
	 * @param Fg_execd
	 */
	public void setFg_execd(FBoolean Fg_execd) {
		setAttrVal("Fg_execd", Fg_execd);
	}
	/**
	 * 定义态闭环ID
	 * @return String
	 */
	public String getId_orpltpsta_def() {
		return ((String) getAttrVal("Id_orpltpsta_def"));
	}
	/**
	 * 定义态闭环ID
	 * @param Id_orpltpsta_def
	 */
	public void setId_orpltpsta_def(String Id_orpltpsta_def) {
		setAttrVal("Id_orpltpsta_def", Id_orpltpsta_def);
	}
	/**
	 * 定义态闭环名称
	 * @return String
	 */
	public String getName_orpltpsta_def() {
		return ((String) getAttrVal("Name_orpltpsta_def"));
	}
	/**
	 * 定义态闭环名称
	 * @param Name_orpltpsta_def
	 */
	public void setName_orpltpsta_def(String Name_orpltpsta_def) {
		setAttrVal("Name_orpltpsta_def", Name_orpltpsta_def);
	}
	/**
	 * 是否PDA执行
	 * @return String
	 */
	public FBoolean getFg_pdamp() {
		return ((FBoolean) getAttrVal("Fg_pdamp"));
	}
	/**
	 * 是否PDA执行
	 * @param Fg_pdamp
	 */
	public void setFg_pdamp(FBoolean Fg_pdamp) {
		setAttrVal("Fg_pdamp", Fg_pdamp);
	}
	/**
	 * 闭环状态关联关系
	 * @return String
	 */
	public String getId_cl() {
		return ((String) getAttrVal("Id_cl"));
	}
	/**
	 * 闭环状态关联关系
	 * @param Id_cl
	 */
	public void setId_cl(String Id_cl) {
		setAttrVal("Id_cl", Id_cl);
	}
}