package iih.pe.pwf.testrptinfo.d;

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
	 * 箭头标识
	 * @return String
	 */
	public String getMarkarrow() {
		return ((String) getAttrVal("Markarrow"));
	}
	/**
	 * 箭头标识
	 * @param Markarrow
	 */
	public void setMarkarrow(String Markarrow) {
		setAttrVal("Markarrow", Markarrow);
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
	 * 参考范围类型编码
	 * @return String
	 */
	public String getReferrangecode() {
		return ((String) getAttrVal("Referrangecode"));
	}
	/**
	 * 参考范围类型编码
	 * @param Referrangecode
	 */
	public void setReferrangecode(String Referrangecode) {
		setAttrVal("Referrangecode", Referrangecode);
	}
	/**
	 * 参考范围文本说明
	 * @return String
	 */
	public String getReferrangetext() {
		return ((String) getAttrVal("Referrangetext"));
	}
	/**
	 * 参考范围文本说明
	 * @param Referrangetext
	 */
	public void setReferrangetext(String Referrangetext) {
		setAttrVal("Referrangetext", Referrangetext);
	}
	/**
	 * 参考范围值单位
	 * @return String
	 */
	public String getReferrangeunit() {
		return ((String) getAttrVal("Referrangeunit"));
	}
	/**
	 * 参考范围值单位
	 * @param Referrangeunit
	 */
	public void setReferrangeunit(String Referrangeunit) {
		setAttrVal("Referrangeunit", Referrangeunit);
	}
	/**
	 * 参考范围低值
	 * @return String
	 */
	public String getReferrangelowvalue() {
		return ((String) getAttrVal("Referrangelowvalue"));
	}
	/**
	 * 参考范围低值
	 * @param Referrangelowvalue
	 */
	public void setReferrangelowvalue(String Referrangelowvalue) {
		setAttrVal("Referrangelowvalue", Referrangelowvalue);
	}
	/**
	 * 参考范围高值
	 * @return String
	 */
	public String getReferrangehighvalue() {
		return ((String) getAttrVal("Referrangehighvalue"));
	}
	/**
	 * 参考范围高值
	 * @param Referrangehighvalue
	 */
	public void setReferrangehighvalue(String Referrangehighvalue) {
		setAttrVal("Referrangehighvalue", Referrangehighvalue);
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
	 * 危险范围类型编码
	 * @return String
	 */
	public String getDangerrangecode() {
		return ((String) getAttrVal("Dangerrangecode"));
	}
	/**
	 * 危险范围类型编码
	 * @param Dangerrangecode
	 */
	public void setDangerrangecode(String Dangerrangecode) {
		setAttrVal("Dangerrangecode", Dangerrangecode);
	}
	/**
	 * 危险范围文本说明
	 * @return String
	 */
	public String getDangerrangetext() {
		return ((String) getAttrVal("Dangerrangetext"));
	}
	/**
	 * 危险范围文本说明
	 * @param Dangerrangetext
	 */
	public void setDangerrangetext(String Dangerrangetext) {
		setAttrVal("Dangerrangetext", Dangerrangetext);
	}
	/**
	 * 危险范围值单位
	 * @return String
	 */
	public String getDangerrangeunit() {
		return ((String) getAttrVal("Dangerrangeunit"));
	}
	/**
	 * 危险范围值单位
	 * @param Dangerrangeunit
	 */
	public void setDangerrangeunit(String Dangerrangeunit) {
		setAttrVal("Dangerrangeunit", Dangerrangeunit);
	}
	/**
	 * 危险范围低值
	 * @return String
	 */
	public String getDangerrangelowvalue() {
		return ((String) getAttrVal("Dangerrangelowvalue"));
	}
	/**
	 * 危险范围低值
	 * @param Dangerrangelowvalue
	 */
	public void setDangerrangelowvalue(String Dangerrangelowvalue) {
		setAttrVal("Dangerrangelowvalue", Dangerrangelowvalue);
	}
	/**
	 * 危险范围高值
	 * @return String
	 */
	public String getDangerrangehighvalue() {
		return ((String) getAttrVal("Dangerrangehighvalue"));
	}
	/**
	 * 危险范围高值
	 * @param Dangerrangehighvalue
	 */
	public void setDangerrangehighvalue(String Dangerrangehighvalue) {
		setAttrVal("Dangerrangehighvalue", Dangerrangehighvalue);
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