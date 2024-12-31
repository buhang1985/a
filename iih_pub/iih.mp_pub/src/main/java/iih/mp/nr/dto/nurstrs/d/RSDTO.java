package iih.mp.nr.dto.nurstrs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护士站滚屏 DTO数据 
 * 
 */
public class RSDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 滚屏ID
	 * @return String
	 */
	public String getId_rs() {
		return ((String) getAttrVal("Id_rs"));
	}
	/**
	 * 滚屏ID
	 * @param Id_rs
	 */
	public void setId_rs(String Id_rs) {
		setAttrVal("Id_rs", Id_rs);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 刷新间隔
	 * @return Integer
	 */
	public Integer getTime_refresh() {
		return ((Integer) getAttrVal("Time_refresh"));
	}
	/**
	 * 刷新间隔
	 * @param Time_refresh
	 */
	public void setTime_refresh(Integer Time_refresh) {
		setAttrVal("Time_refresh", Time_refresh);
	}
	/**
	 * 切换间隔
	 * @return Integer
	 */
	public Integer getTime_switch() {
		return ((Integer) getAttrVal("Time_switch"));
	}
	/**
	 * 切换间隔
	 * @param Time_switch
	 */
	public void setTime_switch(Integer Time_switch) {
		setAttrVal("Time_switch", Time_switch);
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
	 * 是否含备注
	 * @return FBoolean
	 */
	public FBoolean getFg_note() {
		return ((FBoolean) getAttrVal("Fg_note"));
	}
	/**
	 * 是否含备注
	 * @param Fg_note
	 */
	public void setFg_note(FBoolean Fg_note) {
		setAttrVal("Fg_note", Fg_note);
	}
	/**
	 * 备注信息
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注信息
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 滚屏卡信息集合
	 * @return FArrayList
	 */
	public FArrayList getArraycard() {
		return ((FArrayList) getAttrVal("Arraycard"));
	}
	/**
	 * 滚屏卡信息集合
	 * @param Arraycard
	 */
	public void setArraycard(FArrayList Arraycard) {
		setAttrVal("Arraycard", Arraycard);
	}
}