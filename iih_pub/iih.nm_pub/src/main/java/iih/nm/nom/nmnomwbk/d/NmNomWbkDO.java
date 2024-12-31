package iih.nm.nom.nmnomwbk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nmnomwbk.d.desc.NmNomWbkDODesc;
import java.math.BigDecimal;

/**
 * 护士长手册 DO数据 
 * 
 */
public class NmNomWbkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//手册主键
	public static final String ID_NOM_WBK= "Id_nom_wbk";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//手册名称
	public static final String NAME= "Name";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//所属类型外键
	public static final String ID_OWNTP= "Id_owntp";
	//所属类型编码
	public static final String SD_OWNTP= "Sd_owntp";
	//描述
	public static final String DES= "Des";
	//创建时间1
	public static final String DT_REG= "Dt_reg";
	//创建人员
	public static final String ID_REG_PSN= "Id_reg_psn";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//所属类型
	public static final String NAME_OWNTP= "Name_owntp";
	//人员
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 手册主键
	 * @return String
	 */
	public String getId_nom_wbk() {
		return ((String) getAttrVal("Id_nom_wbk"));
	}	
	/**
	 * 手册主键
	 * @param Id_nom_wbk
	 */
	public void setId_nom_wbk(String Id_nom_wbk) {
		setAttrVal("Id_nom_wbk", Id_nom_wbk);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 手册名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 手册名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 所属类型外键
	 * @return String
	 */
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	/**
	 * 所属类型外键
	 * @param Id_owntp
	 */
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owntp
	 */
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 创建时间1
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 创建时间1
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 创建人员
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 创建人员
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
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
	 * 所属类型
	 * @return String
	 */
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	/**
	 * 所属类型
	 * @param Name_owntp
	 */
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	/**
	 * 人员
	 * @return String
	 */
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	/**
	 * 人员
	 * @param Name_reg_psn
	 */
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_nom_wbk";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_WBK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNomWbkDODesc.class);
	}
	
}