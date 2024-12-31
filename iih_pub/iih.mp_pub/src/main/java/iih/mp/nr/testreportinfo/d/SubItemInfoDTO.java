package iih.mp.nr.testreportinfo.d;

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
	 * 检验子项简称
	 * @return String
	 */
	public String getItemnameen() {
		return ((String) getAttrVal("Itemnameen"));
	}
	/**
	 * 检验子项简称
	 * @param Itemnameen
	 */
	public void setItemnameen(String Itemnameen) {
		setAttrVal("Itemnameen", Itemnameen);
	}
	/**
	 * 检验子项全称
	 * @return String
	 */
	public String getItemnamecn() {
		return ((String) getAttrVal("Itemnamecn"));
	}
	/**
	 * 检验子项全称
	 * @param Itemnamecn
	 */
	public void setItemnamecn(String Itemnamecn) {
		setAttrVal("Itemnamecn", Itemnamecn);
	}
	/**
	 * 检验结果
	 * @return String
	 */
	public String getItemvaluepq() {
		return ((String) getAttrVal("Itemvaluepq"));
	}
	/**
	 * 检验结果
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
	 * 检验值
	 * @return String
	 */
	public String getItemvaluestandsc() {
		return ((String) getAttrVal("Itemvaluestandsc"));
	}
	/**
	 * 检验值
	 * @param Itemvaluestandsc
	 */
	public void setItemvaluestandsc(String Itemvaluestandsc) {
		setAttrVal("Itemvaluestandsc", Itemvaluestandsc);
	}
	/**
	 * 备注/说明
	 * @return String
	 */
	public String getReportmemo() {
		return ((String) getAttrVal("Reportmemo"));
	}
	/**
	 * 备注/说明
	 * @param Reportmemo
	 */
	public void setReportmemo(String Reportmemo) {
		setAttrVal("Reportmemo", Reportmemo);
	}
	/**
	 * 范围信息
	 * @return FArrayList
	 */
	public FArrayList getRangeinfo() {
		return ((FArrayList) getAttrVal("Rangeinfo"));
	}
	/**
	 * 范围信息
	 * @param Rangeinfo
	 */
	public void setRangeinfo(FArrayList Rangeinfo) {
		setAttrVal("Rangeinfo", Rangeinfo);
	}
	/**
	 * 高低值判断编码
	 * @return String
	 */
	public String getNormalflag() {
		return ((String) getAttrVal("Normalflag"));
	}
	/**
	 * 高低值判断编码
	 * @param Normalflag
	 */
	public void setNormalflag(String Normalflag) {
		setAttrVal("Normalflag", Normalflag);
	}
	/**
	 * 高低值判断内容
	 * @return String
	 */
	public String getNormalflagname() {
		return ((String) getAttrVal("Normalflagname"));
	}
	/**
	 * 高低值判断内容
	 * @param Normalflagname
	 */
	public void setNormalflagname(String Normalflagname) {
		setAttrVal("Normalflagname", Normalflagname);
	}
	/**
	 * 危险值判断编码
	 * @return String
	 */
	public String getWarnflag() {
		return ((String) getAttrVal("Warnflag"));
	}
	/**
	 * 危险值判断编码
	 * @param Warnflag
	 */
	public void setWarnflag(String Warnflag) {
		setAttrVal("Warnflag", Warnflag);
	}
	/**
	 * 危险值判断内容
	 * @return String
	 */
	public String getWarnflagname() {
		return ((String) getAttrVal("Warnflagname"));
	}
	/**
	 * 危险值判断内容
	 * @param Warnflagname
	 */
	public void setWarnflagname(String Warnflagname) {
		setAttrVal("Warnflagname", Warnflagname);
	}
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
}