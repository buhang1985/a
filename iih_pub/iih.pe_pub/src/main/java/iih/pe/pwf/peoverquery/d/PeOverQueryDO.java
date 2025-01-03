package iih.pe.pwf.peoverquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.peoverquery.d.desc.PeOverQueryDODesc;
import java.math.BigDecimal;

/**
 * 体检报告核对名单检索 DO数据 
 * 
 */
public class PeOverQueryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检报告核对检索主键标识
	public static final String ID_PEOVERQUERY= "Id_peoverquery";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//结束日期
	public static final String DT_END= "Dt_end";
	//过滤分类
	public static final String FILTERCA= "Filterca";
	//团体ID
	public static final String ID_CORP= "Id_corp";
	//客户姓名
	public static final String NAME_PSN= "Name_psn";
	//体检状态
	public static final String FILTEROVAL= "Filteroval";
	//体检编码
	public static final String PE_CODE= "Pe_code";
	//电话
	public static final String MOB= "Mob";
	//团体预约单ID
	public static final String ID_CORPAPPT= "Id_corpappt";
	//团体分组ID
	public static final String ID_CORPGRP= "Id_corpgrp";
	//体检登记类型
	public static final String FILTERCACHKTP= "Filtercachktp";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检诊室ID
	public static final String ID_DEP= "Id_dep";
	//体检科室ID
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//单位编码
	public static final String CODE_CORP= "Code_corp";
	//单位名称
	public static final String NAME_CORP= "Name_corp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检报告核对检索主键标识
	 * @return String
	 */
	public String getId_peoverquery() {
		return ((String) getAttrVal("Id_peoverquery"));
	}	
	/**
	 * 体检报告核对检索主键标识
	 * @param Id_peoverquery
	 */
	public void setId_peoverquery(String Id_peoverquery) {
		setAttrVal("Id_peoverquery", Id_peoverquery);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 过滤分类
	 * @return Integer
	 */
	public Integer getFilterca() {
		return ((Integer) getAttrVal("Filterca"));
	}	
	/**
	 * 过滤分类
	 * @param Filterca
	 */
	public void setFilterca(Integer Filterca) {
		setAttrVal("Filterca", Filterca);
	}
	/**
	 * 团体ID
	 * @return String
	 */
	public String getId_corp() {
		return ((String) getAttrVal("Id_corp"));
	}	
	/**
	 * 团体ID
	 * @param Id_corp
	 */
	public void setId_corp(String Id_corp) {
		setAttrVal("Id_corp", Id_corp);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 体检状态
	 * @return Integer
	 */
	public Integer getFilteroval() {
		return ((Integer) getAttrVal("Filteroval"));
	}	
	/**
	 * 体检状态
	 * @param Filteroval
	 */
	public void setFilteroval(Integer Filteroval) {
		setAttrVal("Filteroval", Filteroval);
	}
	/**
	 * 体检编码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检编码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 团体预约单ID
	 * @return String
	 */
	public String getId_corpappt() {
		return ((String) getAttrVal("Id_corpappt"));
	}	
	/**
	 * 团体预约单ID
	 * @param Id_corpappt
	 */
	public void setId_corpappt(String Id_corpappt) {
		setAttrVal("Id_corpappt", Id_corpappt);
	}
	/**
	 * 团体分组ID
	 * @return String
	 */
	public String getId_corpgrp() {
		return ((String) getAttrVal("Id_corpgrp"));
	}	
	/**
	 * 团体分组ID
	 * @param Id_corpgrp
	 */
	public void setId_corpgrp(String Id_corpgrp) {
		setAttrVal("Id_corpgrp", Id_corpgrp);
	}
	/**
	 * 体检登记类型
	 * @return Integer
	 */
	public Integer getFiltercachktp() {
		return ((Integer) getAttrVal("Filtercachktp"));
	}	
	/**
	 * 体检登记类型
	 * @param Filtercachktp
	 */
	public void setFiltercachktp(Integer Filtercachktp) {
		setAttrVal("Filtercachktp", Filtercachktp);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检诊室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 体检诊室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 体检科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 体检科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_corp() {
		return ((String) getAttrVal("Code_corp"));
	}	
	/**
	 * 单位编码
	 * @param Code_corp
	 */
	public void setCode_corp(String Code_corp) {
		setAttrVal("Code_corp", Code_corp);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}	
	/**
	 * 单位名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
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
		return "Id_peoverquery";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeOverQueryDODesc.class);
	}
	
}