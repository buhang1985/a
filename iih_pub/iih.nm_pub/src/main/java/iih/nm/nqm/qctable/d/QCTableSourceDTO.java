package iih.nm.nqm.qctable.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质量检查表数据源 DTO数据 
 * 
 */
public class QCTableSourceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 * @return String
	 */
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}
	/**
	 * ID
	 * @param Id_source
	 */
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
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
	 * 元素编码
	 * @return String
	 */
	public String getIcode_tm() {
		return ((String) getAttrVal("Icode_tm"));
	}
	/**
	 * 元素编码
	 * @param Icode_tm
	 */
	public void setIcode_tm(String Icode_tm) {
		setAttrVal("Icode_tm", Icode_tm);
	}
	/**
	 * 分值
	 * @return FDouble
	 */
	public FDouble getSource() {
		return ((FDouble) getAttrVal("Source"));
	}
	/**
	 * 分值
	 * @param Source
	 */
	public void setSource(FDouble Source) {
		setAttrVal("Source", Source);
	}
	/**
	 * 是否为叶子节点
	 * @return FBoolean
	 */
	public FBoolean getFg_child() {
		return ((FBoolean) getAttrVal("Fg_child"));
	}
	/**
	 * 是否为叶子节点
	 * @param Fg_child
	 */
	public void setFg_child(FBoolean Fg_child) {
		setAttrVal("Fg_child", Fg_child);
	}
	/**
	 * 父级
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 父级
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 采集类型
	 * @return Integer
	 */
	public Integer getEu_colltp() {
		return ((Integer) getAttrVal("Eu_colltp"));
	}
	/**
	 * 采集类型
	 * @param Eu_colltp
	 */
	public void setEu_colltp(Integer Eu_colltp) {
		setAttrVal("Eu_colltp", Eu_colltp);
	}
	/**
	 * 选择类型
	 * @return Integer
	 */
	public Integer getEu_seltp() {
		return ((Integer) getAttrVal("Eu_seltp"));
	}
	/**
	 * 选择类型
	 * @param Eu_seltp
	 */
	public void setEu_seltp(Integer Eu_seltp) {
		setAttrVal("Eu_seltp", Eu_seltp);
	}
	/**
	 * 组内评分类型
	 * @return Integer
	 */
	public Integer getEu_gradetp() {
		return ((Integer) getAttrVal("Eu_gradetp"));
	}
	/**
	 * 组内评分类型
	 * @param Eu_gradetp
	 */
	public void setEu_gradetp(Integer Eu_gradetp) {
		setAttrVal("Eu_gradetp", Eu_gradetp);
	}
	/**
	 * 是否选择
	 * @return FBoolean
	 */
	public FBoolean getFg_select() {
		return ((FBoolean) getAttrVal("Fg_select"));
	}
	/**
	 * 是否选择
	 * @param Fg_select
	 */
	public void setFg_select(FBoolean Fg_select) {
		setAttrVal("Fg_select", Fg_select);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 下限值
	 * @return FDouble
	 */
	public FDouble getMinval() {
		return ((FDouble) getAttrVal("Minval"));
	}
	/**
	 * 下限值
	 * @param Minval
	 */
	public void setMinval(FDouble Minval) {
		setAttrVal("Minval", Minval);
	}
	/**
	 * 上限值
	 * @return FDouble
	 */
	public FDouble getMaxval() {
		return ((FDouble) getAttrVal("Maxval"));
	}
	/**
	 * 上限值
	 * @param Maxval
	 */
	public void setMaxval(FDouble Maxval) {
		setAttrVal("Maxval", Maxval);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return FDouble
	 */
	public FDouble getDef2() {
		return ((FDouble) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(FDouble Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 平铺选中项id 
	 * @return String
	 */
	public String getTailid() {
		return ((String) getAttrVal("Tailid"));
	}
	/**
	 * 平铺选中项id 
	 * @param Tailid
	 */
	public void setTailid(String Tailid) {
		setAttrVal("Tailid", Tailid);
	}
	/**
	 * 平铺选中项
	 * @return String
	 */
	public String getTailvalue() {
		return ((String) getAttrVal("Tailvalue"));
	}
	/**
	 * 平铺选中项
	 * @param Tailvalue
	 */
	public void setTailvalue(String Tailvalue) {
		setAttrVal("Tailvalue", Tailvalue);
	}
	/**
	 * 平铺列表
	 * @return FArrayList
	 */
	public FArrayList getTailitemlist() {
		return ((FArrayList) getAttrVal("Tailitemlist"));
	}
	/**
	 * 平铺列表
	 * @param Tailitemlist
	 */
	public void setTailitemlist(FArrayList Tailitemlist) {
		setAttrVal("Tailitemlist", Tailitemlist);
	}
}