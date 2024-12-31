package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者管家医技预约查询DTO DTO数据 
 * 
 */
public class PisPhkMtAppQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 当前科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 当前科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 当前科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 是否门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}
	/**
	 * 是否门诊
	 * @param Fg_op
	 */
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	/**
	 * 是否自动过滤
	 * @return String
	 */
	public String getFg_autofilter() {
		return ((String) getAttrVal("Fg_autofilter"));
	}
	/**
	 * 是否自动过滤
	 * @param Fg_autofilter
	 */
	public void setFg_autofilter(String Fg_autofilter) {
		setAttrVal("Fg_autofilter", Fg_autofilter);
	}
	/**
	 * 过滤项目id
	 * @return String
	 */
	public String getId_srv_filter() {
		return ((String) getAttrVal("Id_srv_filter"));
	}
	/**
	 * 过滤项目id
	 * @param Id_srv_filter
	 */
	public void setId_srv_filter(String Id_srv_filter) {
		setAttrVal("Id_srv_filter", Id_srv_filter);
	}
	/**
	 * 过滤项目名称
	 * @return String
	 */
	public String getName_srv_filter() {
		return ((String) getAttrVal("Name_srv_filter"));
	}
	/**
	 * 过滤项目名称
	 * @param Name_srv_filter
	 */
	public void setName_srv_filter(String Name_srv_filter) {
		setAttrVal("Name_srv_filter", Name_srv_filter);
	}
	/**
	 * 过滤科室id
	 * @return String
	 */
	public String getId_dep_filter() {
		return ((String) getAttrVal("Id_dep_filter"));
	}
	/**
	 * 过滤科室id
	 * @param Id_dep_filter
	 */
	public void setId_dep_filter(String Id_dep_filter) {
		setAttrVal("Id_dep_filter", Id_dep_filter);
	}
	/**
	 * 过滤科室名称
	 * @return String
	 */
	public String getName_dep_filter() {
		return ((String) getAttrVal("Name_dep_filter"));
	}
	/**
	 * 过滤科室名称
	 * @param Name_dep_filter
	 */
	public void setName_dep_filter(String Name_dep_filter) {
		setAttrVal("Name_dep_filter", Name_dep_filter);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 是否已预约
	 * @return String
	 */
	public String getFg_apted() {
		return ((String) getAttrVal("Fg_apted"));
	}
	/**
	 * 是否已预约
	 * @param Fg_apted
	 */
	public void setFg_apted(String Fg_apted) {
		setAttrVal("Fg_apted", Fg_apted);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 查询类型
	 * @return String
	 */
	public String getQrytype() {
		return ((String) getAttrVal("Qrytype"));
	}
	/**
	 * 查询类型
	 * @param Qrytype
	 */
	public void setQrytype(String Qrytype) {
		setAttrVal("Qrytype", Qrytype);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getAppno() {
		return ((String) getAttrVal("Appno"));
	}
	/**
	 * 申请单号
	 * @param Appno
	 */
	public void setAppno(String Appno) {
		setAttrVal("Appno", Appno);
	}
	/**
	 * 输入年月
	 * @return String
	 */
	public String getYearmonth() {
		return ((String) getAttrVal("Yearmonth"));
	}
	/**
	 * 输入年月
	 * @param Yearmonth
	 */
	public void setYearmonth(String Yearmonth) {
		setAttrVal("Yearmonth", Yearmonth);
	}
	/**
	 * 末次月经时间
	 * @return FDate
	 */
	public FDate getD_last_menst() {
		return ((FDate) getAttrVal("D_last_menst"));
	}
	/**
	 * 末次月经时间
	 * @param D_last_menst
	 */
	public void setD_last_menst(FDate D_last_menst) {
		setAttrVal("D_last_menst", D_last_menst);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
}