package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvBloodDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务血液属性 DO数据 
 * 
 */
public class MedSrvBloodDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//血液属性主键
	public static final String ID_SRV_BLOOD= "Id_srv_blood";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//血液成分分类
	public static final String ID_BLOODCA= "Id_bloodca";
	//血液成分分类编码
	public static final String SD_BLOODCA= "Sd_bloodca";
	//血液成分(暂不用)
	public static final String ID_BLOODTYPE= "Id_bloodtype";
	//血液成分编码(暂不用)
	public static final String SD_BLOODTYPE= "Sd_bloodtype";
	//输血目的
	public static final String ID_PPSS= "Id_ppss";
	//输血目的编码
	public static final String SD_PPSS= "Sd_ppss";
	//配血检验
	public static final String FG_MATCHTEST= "Fg_matchtest";
	//输血审批起始量
	public static final String APPROVELIMITNUM= "Approvelimitnum";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//血液成分分类名称
	public static final String NAME_BLOODCA= "Name_bloodca";
	//输血目的名称
	public static final String NAME_PPSS= "Name_ppss";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 血液属性主键
	 * @return String
	 */
	public String getId_srv_blood() {
		return ((String) getAttrVal("Id_srv_blood"));
	}	
	/**
	 * 血液属性主键
	 * @param Id_srv_blood
	 */
	public void setId_srv_blood(String Id_srv_blood) {
		setAttrVal("Id_srv_blood", Id_srv_blood);
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
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 血液成分分类
	 * @return String
	 */
	public String getId_bloodca() {
		return ((String) getAttrVal("Id_bloodca"));
	}	
	/**
	 * 血液成分分类
	 * @param Id_bloodca
	 */
	public void setId_bloodca(String Id_bloodca) {
		setAttrVal("Id_bloodca", Id_bloodca);
	}
	/**
	 * 血液成分分类编码
	 * @return String
	 */
	public String getSd_bloodca() {
		return ((String) getAttrVal("Sd_bloodca"));
	}	
	/**
	 * 血液成分分类编码
	 * @param Sd_bloodca
	 */
	public void setSd_bloodca(String Sd_bloodca) {
		setAttrVal("Sd_bloodca", Sd_bloodca);
	}
	/**
	 * 血液成分(暂不用)
	 * @return String
	 */
	public String getId_bloodtype() {
		return ((String) getAttrVal("Id_bloodtype"));
	}	
	/**
	 * 血液成分(暂不用)
	 * @param Id_bloodtype
	 */
	public void setId_bloodtype(String Id_bloodtype) {
		setAttrVal("Id_bloodtype", Id_bloodtype);
	}
	/**
	 * 血液成分编码(暂不用)
	 * @return String
	 */
	public String getSd_bloodtype() {
		return ((String) getAttrVal("Sd_bloodtype"));
	}	
	/**
	 * 血液成分编码(暂不用)
	 * @param Sd_bloodtype
	 */
	public void setSd_bloodtype(String Sd_bloodtype) {
		setAttrVal("Sd_bloodtype", Sd_bloodtype);
	}
	/**
	 * 输血目的
	 * @return String
	 */
	public String getId_ppss() {
		return ((String) getAttrVal("Id_ppss"));
	}	
	/**
	 * 输血目的
	 * @param Id_ppss
	 */
	public void setId_ppss(String Id_ppss) {
		setAttrVal("Id_ppss", Id_ppss);
	}
	/**
	 * 输血目的编码
	 * @return String
	 */
	public String getSd_ppss() {
		return ((String) getAttrVal("Sd_ppss"));
	}	
	/**
	 * 输血目的编码
	 * @param Sd_ppss
	 */
	public void setSd_ppss(String Sd_ppss) {
		setAttrVal("Sd_ppss", Sd_ppss);
	}
	/**
	 * 配血检验
	 * @return FBoolean
	 */
	public FBoolean getFg_matchtest() {
		return ((FBoolean) getAttrVal("Fg_matchtest"));
	}	
	/**
	 * 配血检验
	 * @param Fg_matchtest
	 */
	public void setFg_matchtest(FBoolean Fg_matchtest) {
		setAttrVal("Fg_matchtest", Fg_matchtest);
	}
	/**
	 * 输血审批起始量
	 * @return FDouble
	 */
	public FDouble getApprovelimitnum() {
		return ((FDouble) getAttrVal("Approvelimitnum"));
	}	
	/**
	 * 输血审批起始量
	 * @param Approvelimitnum
	 */
	public void setApprovelimitnum(FDouble Approvelimitnum) {
		setAttrVal("Approvelimitnum", Approvelimitnum);
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
	 * 血液成分分类名称
	 * @return String
	 */
	public String getName_bloodca() {
		return ((String) getAttrVal("Name_bloodca"));
	}	
	/**
	 * 血液成分分类名称
	 * @param Name_bloodca
	 */
	public void setName_bloodca(String Name_bloodca) {
		setAttrVal("Name_bloodca", Name_bloodca);
	}
	/**
	 * 输血目的名称
	 * @return String
	 */
	public String getName_ppss() {
		return ((String) getAttrVal("Name_ppss"));
	}	
	/**
	 * 输血目的名称
	 * @param Name_ppss
	 */
	public void setName_ppss(String Name_ppss) {
		setAttrVal("Name_ppss", Name_ppss);
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
		return "Id_srv_blood";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_SRV_BLOOD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvBloodDODesc.class);
	}
	
}