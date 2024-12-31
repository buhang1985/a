package iih.mp.nr.hdvview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.hdvview.d.desc.MpHdvSumDODesc;
import java.math.BigDecimal;

/**
 * 交班汇总 DO数据 
 * 
 */
public class MpHdvSumDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//交班报告汇总
	public static final String ID_HDV_SUM= "Id_hdv_sum";
	//交班报告
	public static final String ID_HDV= "Id_hdv";
	//指标
	public static final String ID_VS_TAGT= "Id_vs_tagt";
	//汇总值
	public static final String VAL= "Val";
	//系统计算值
	public static final String VAL_AUTO= "Val_auto";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//指标编码
	public static final String CODE_VS_TAGT= "Code_vs_tagt";
	//指标名称
	public static final String NAME_VS_TAGT= "Name_vs_tagt";
	//简称
	public static final String NAME_SHORT= "Name_short";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 交班报告汇总
	 * @return String
	 */
	public String getId_hdv_sum() {
		return ((String) getAttrVal("Id_hdv_sum"));
	}	
	/**
	 * 交班报告汇总
	 * @param Id_hdv_sum
	 */
	public void setId_hdv_sum(String Id_hdv_sum) {
		setAttrVal("Id_hdv_sum", Id_hdv_sum);
	}
	/**
	 * 交班报告
	 * @return String
	 */
	public String getId_hdv() {
		return ((String) getAttrVal("Id_hdv"));
	}	
	/**
	 * 交班报告
	 * @param Id_hdv
	 */
	public void setId_hdv(String Id_hdv) {
		setAttrVal("Id_hdv", Id_hdv);
	}
	/**
	 * 指标
	 * @return String
	 */
	public String getId_vs_tagt() {
		return ((String) getAttrVal("Id_vs_tagt"));
	}	
	/**
	 * 指标
	 * @param Id_vs_tagt
	 */
	public void setId_vs_tagt(String Id_vs_tagt) {
		setAttrVal("Id_vs_tagt", Id_vs_tagt);
	}
	/**
	 * 汇总值
	 * @return Integer
	 */
	public Integer getVal() {
		return ((Integer) getAttrVal("Val"));
	}	
	/**
	 * 汇总值
	 * @param Val
	 */
	public void setVal(Integer Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 系统计算值
	 * @return Integer
	 */
	public Integer getVal_auto() {
		return ((Integer) getAttrVal("Val_auto"));
	}	
	/**
	 * 系统计算值
	 * @param Val_auto
	 */
	public void setVal_auto(Integer Val_auto) {
		setAttrVal("Val_auto", Val_auto);
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
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
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
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	/**
	 * 指标编码
	 * @return String
	 */
	public String getCode_vs_tagt() {
		return ((String) getAttrVal("Code_vs_tagt"));
	}	
	/**
	 * 指标编码
	 * @param Code_vs_tagt
	 */
	public void setCode_vs_tagt(String Code_vs_tagt) {
		setAttrVal("Code_vs_tagt", Code_vs_tagt);
	}
	/**
	 * 指标名称
	 * @return String
	 */
	public String getName_vs_tagt() {
		return ((String) getAttrVal("Name_vs_tagt"));
	}	
	/**
	 * 指标名称
	 * @param Name_vs_tagt
	 */
	public void setName_vs_tagt(String Name_vs_tagt) {
		setAttrVal("Name_vs_tagt", Name_vs_tagt);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getName_short() {
		return ((String) getAttrVal("Name_short"));
	}	
	/**
	 * 简称
	 * @param Name_short
	 */
	public void setName_short(String Name_short) {
		setAttrVal("Name_short", Name_short);
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
		return "Id_hdv_sum";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_hdv_sum";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpHdvSumDODesc.class);
	}
	
}