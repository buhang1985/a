package iih.pe.pwf.dto.morphtestreportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验子项信息 DTO数据 
 * 
 */
public class SubItemInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验项编码
	 * @return String
	 */
	public String getLabitemcode() {
		return ((String) getAttrVal("Labitemcode"));
	}
	/**
	 * 检验项编码
	 * @param Labitemcode
	 */
	public void setLabitemcode(String Labitemcode) {
		setAttrVal("Labitemcode", Labitemcode);
	}
	/**
	 * 显示序号
	 * @return String
	 */
	public String getDisplayorder() {
		return ((String) getAttrVal("Displayorder"));
	}
	/**
	 * 显示序号
	 * @param Displayorder
	 */
	public void setDisplayorder(String Displayorder) {
		setAttrVal("Displayorder", Displayorder);
	}
	/**
	 * 检验子项编码
	 * @return String
	 */
	public String getItemcode() {
		return ((String) getAttrVal("Itemcode"));
	}
	/**
	 * 检验子项编码
	 * @param Itemcode
	 */
	public void setItemcode(String Itemcode) {
		setAttrVal("Itemcode", Itemcode);
	}
	/**
	 * 检验子项名称
	 * @return String
	 */
	public String getItemname() {
		return ((String) getAttrVal("Itemname"));
	}
	/**
	 * 检验子项名称
	 * @param Itemname
	 */
	public void setItemname(String Itemname) {
		setAttrVal("Itemname", Itemname);
	}
	/**
	 * 检验结果值
	 * @return String
	 */
	public String getItemvaluepq() {
		return ((String) getAttrVal("Itemvaluepq"));
	}
	/**
	 * 检验结果值
	 * @param Itemvaluepq
	 */
	public void setItemvaluepq(String Itemvaluepq) {
		setAttrVal("Itemvaluepq", Itemvaluepq);
	}
	/**
	 * 检验结果单位
	 * @return String
	 */
	public String getItemunitpq() {
		return ((String) getAttrVal("Itemunitpq"));
	}
	/**
	 * 检验结果单位
	 * @param Itemunitpq
	 */
	public void setItemunitpq(String Itemunitpq) {
		setAttrVal("Itemunitpq", Itemunitpq);
	}
	/**
	 * 参考标准信息
	 * @return FArrayList
	 */
	public FArrayList getRefstdinfo() {
		return ((FArrayList) getAttrVal("Refstdinfo"));
	}
	/**
	 * 参考标准信息
	 * @param Refstdinfo
	 */
	public void setRefstdinfo(FArrayList Refstdinfo) {
		setAttrVal("Refstdinfo", Refstdinfo);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getMemo() {
		return ((String) getAttrVal("Memo"));
	}
	/**
	 * 备注
	 * @param Memo
	 */
	public void setMemo(String Memo) {
		setAttrVal("Memo", Memo);
	}
}