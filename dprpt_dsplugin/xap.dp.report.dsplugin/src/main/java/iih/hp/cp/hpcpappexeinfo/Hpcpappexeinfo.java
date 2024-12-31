package iih.hp.cp.hpcpappexeinfo;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床路径执行信息 DTO数据 
 * 
 */
public class Hpcpappexeinfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 路径执行主键
	 * @return String
	 */
	public String getId_cpapp() {
		return ((String) getAttrVal("Id_cpapp"));
	}
	/**
	 * 路径执行主键
	 * @param Id_cpapp
	 */
	public void setId_cpapp(String Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
	}
	/**
	 * 路径主键
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}
	/**
	 * 路径主键
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	/**
	 * 元素主键
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}
	/**
	 * 元素主键
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 元素名称
	 * @return String
	 */
	public String getEle_name() {
		return ((String) getAttrVal("Ele_name"));
	}
	/**
	 * 元素名称
	 * @param Ele_name
	 */
	public void setEle_name(String Ele_name) {
		setAttrVal("Ele_name", Ele_name);
	}
	/**
	 * 元素类型
	 * @return String
	 */
	public String getEletp_code() {
		return ((String) getAttrVal("Eletp_code"));
	}
	/**
	 * 元素类型
	 * @param Eletp_code
	 */
	public void setEletp_code(String Eletp_code) {
		setAttrVal("Eletp_code", Eletp_code);
	}
	/**
	 * 父元素
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 父元素
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 父元素名称
	 * @return String
	 */
	public String getParent_name() {
		return ((String) getAttrVal("Parent_name"));
	}
	/**
	 * 父元素名称
	 * @param Parent_name
	 */
	public void setParent_name(String Parent_name) {
		setAttrVal("Parent_name", Parent_name);
	}
	/**
	 * 计划阶段
	 * @return String
	 */
	public String getId_ele_stage() {
		return ((String) getAttrVal("Id_ele_stage"));
	}
	/**
	 * 计划阶段
	 * @param Id_ele_stage
	 */
	public void setId_ele_stage(String Id_ele_stage) {
		setAttrVal("Id_ele_stage", Id_ele_stage);
	}
	/**
	 * 计划阶段名称
	 * @return String
	 */
	public String getStage_name() {
		return ((String) getAttrVal("Stage_name"));
	}
	/**
	 * 计划阶段名称
	 * @param Stage_name
	 */
	public void setStage_name(String Stage_name) {
		setAttrVal("Stage_name", Stage_name);
	}
	/**
	 * 阶段进入时间
	 * @return String
	 */
	public String getDt_enter() {
		return ((String) getAttrVal("Dt_enter"));
	}
	/**
	 * 阶段进入时间
	 * @param Dt_enter
	 */
	public void setDt_enter(String Dt_enter) {
		setAttrVal("Dt_enter", Dt_enter);
	}
	/**
	 * 阶段退出时间
	 * @return String
	 */
	public String getDt_exit() {
		return ((String) getAttrVal("Dt_exit"));
	}
	/**
	 * 阶段退出时间
	 * @param Dt_exit
	 */
	public void setDt_exit(String Dt_exit) {
		setAttrVal("Dt_exit", Dt_exit);
	}
	/**
	 * 已执行标识
	 * @return String
	 */
	public String getFg_exe() {
		return ((String) getAttrVal("Fg_exe"));
	}
	/**
	 * 已执行标识
	 * @param Fg_exe
	 */
	public void setFg_exe(String Fg_exe) {
		setAttrVal("Fg_exe", Fg_exe);
	}
	/**
	 * 结构数据标识
	 * @return FBoolean
	 */
	public FBoolean getFg_top() {
		return ((FBoolean) getAttrVal("Fg_top"));
	}
	/**
	 * 结构数据标识
	 * @param Fg_top
	 */
	public void setFg_top(FBoolean Fg_top) {
		setAttrVal("Fg_top", Fg_top);
	}
	/**
	 * 复选框不显示标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nobox() {
		return ((FBoolean) getAttrVal("Fg_nobox"));
	}
	/**
	 * 复选框不显示标识
	 * @param Fg_nobox
	 */
	public void setFg_nobox(FBoolean Fg_nobox) {
		setAttrVal("Fg_nobox", Fg_nobox);
	}
	/**
	 * 执行角色
	 * @return String
	 */
	public String getExerole_name() {
		return ((String) getAttrVal("Exerole_name"));
	}
	/**
	 * 执行角色
	 * @param Exerole_name
	 */
	public void setExerole_name(String Exerole_name) {
		setAttrVal("Exerole_name", Exerole_name);
	}
	/**
	 * 当前层次下序号
	 * @return String
	 */
	public String getSerialno() {
		return ((String) getAttrVal("Serialno"));
	}
	/**
	 * 当前层次下序号
	 * @param Serialno
	 */
	public void setSerialno(String Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	/**
	 * json串
	 * @return String
	 */
	public String getJsonstr() {
		return ((String) getAttrVal("Jsonstr"));
	}
	/**
	 * json串
	 * @param Jsonstr
	 */
	public void setJsonstr(String Jsonstr) {
		setAttrVal("Jsonstr", Jsonstr);
	}
	/**
	 * json串2
	 * @return String
	 */
	public String getJsonstr2() {
		return ((String) getAttrVal("Jsonstr2"));
	}
	/**
	 * json串2
	 * @param Jsonstr2
	 */
	public void setJsonstr2(String Jsonstr2) {
		setAttrVal("Jsonstr2", Jsonstr2);
	}
}