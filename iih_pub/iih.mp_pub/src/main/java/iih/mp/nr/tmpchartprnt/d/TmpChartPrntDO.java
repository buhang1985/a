package iih.mp.nr.tmpchartprnt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.tmpchartprnt.d.desc.TmpChartPrntDODesc;
import java.math.BigDecimal;

/**
 * 体温单打印记录 DO数据 
 * 
 */
public class TmpChartPrntDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体温单打印记录
	public static final String ID_TEMPCHART_PRNT= "Id_tempchart_prnt";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//序号
	public static final String SORTNO= "Sortno";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//结束日期
	public static final String DT_END= "Dt_end";
	//打印人
	public static final String ID_EMP_PRNT= "Id_emp_prnt";
	//打印科室
	public static final String ID_DEP_PRNT= "Id_dep_prnt";
	//打印时间
	public static final String DT_PRNT= "Dt_prnt";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体温单打印记录
	 * @return String
	 */
	public String getId_tempchart_prnt() {
		return ((String) getAttrVal("Id_tempchart_prnt"));
	}	
	/**
	 * 体温单打印记录
	 * @param Id_tempchart_prnt
	 */
	public void setId_tempchart_prnt(String Id_tempchart_prnt) {
		setAttrVal("Id_tempchart_prnt", Id_tempchart_prnt);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 打印人
	 * @return String
	 */
	public String getId_emp_prnt() {
		return ((String) getAttrVal("Id_emp_prnt"));
	}	
	/**
	 * 打印人
	 * @param Id_emp_prnt
	 */
	public void setId_emp_prnt(String Id_emp_prnt) {
		setAttrVal("Id_emp_prnt", Id_emp_prnt);
	}
	/**
	 * 打印科室
	 * @return String
	 */
	public String getId_dep_prnt() {
		return ((String) getAttrVal("Id_dep_prnt"));
	}	
	/**
	 * 打印科室
	 * @param Id_dep_prnt
	 */
	public void setId_dep_prnt(String Id_dep_prnt) {
		setAttrVal("Id_dep_prnt", Id_dep_prnt);
	}
	/**
	 * 打印时间
	 * @return FDateTime
	 */
	public FDateTime getDt_prnt() {
		return ((FDateTime) getAttrVal("Dt_prnt"));
	}	
	/**
	 * 打印时间
	 * @param Dt_prnt
	 */
	public void setDt_prnt(FDateTime Dt_prnt) {
		setAttrVal("Dt_prnt", Dt_prnt);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_tempchart_prnt";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_tmpchart_prnt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TmpChartPrntDODesc.class);
	}
	
}