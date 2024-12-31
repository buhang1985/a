package iih.bd.pp.pripat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.pripat.d.desc.PriPatSrvOrCaDODesc;
import java.math.BigDecimal;

/**
 * 患者价格分类服务或分类 DO数据 
 * 
 */
public class PriPatSrvOrCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者价格分类服务或分类主键
	public static final String ID_PRIPATSRVORCA= "Id_pripatsrvorca";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//价格分类
	public static final String ID_PRIPAT= "Id_pripat";
	//服务分类或项目
	public static final String EU_SRVORCA= "Eu_srvorca";
	//服务分类
	public static final String ID_SRVCA= "Id_srvca";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//价格比例模式
	public static final String EU_PI_PRIRATEMD= "Eu_pi_priratemd";
	//价格
	public static final String PRI= "Pri";
	//价格系数
	public static final String RATE= "Rate";
	//开始日期
	public static final String DT_B= "Dt_b";
	//结束日期
	public static final String DT_E= "Dt_e";
	//备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//患者价格分类名称
	public static final String PRIPAT_NAME= "Pripat_name";
	//服务分类
	public static final String SRVCA_NAME= "Srvca_name";
	//服务项目
	public static final String SRV_NAME= "Srv_name";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//标准价格
	public static final String PRI_STD= "Pri_std";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者价格分类服务或分类主键
	 * @return String
	 */
	public String getId_pripatsrvorca() {
		return ((String) getAttrVal("Id_pripatsrvorca"));
	}	
	/**
	 * 患者价格分类服务或分类主键
	 * @param Id_pripatsrvorca
	 */
	public void setId_pripatsrvorca(String Id_pripatsrvorca) {
		setAttrVal("Id_pripatsrvorca", Id_pripatsrvorca);
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
	 * 价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	/**
	 * 价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 服务分类或项目
	 * @return Integer
	 */
	public Integer getEu_srvorca() {
		return ((Integer) getAttrVal("Eu_srvorca"));
	}	
	/**
	 * 服务分类或项目
	 * @param Eu_srvorca
	 */
	public void setEu_srvorca(Integer Eu_srvorca) {
		setAttrVal("Eu_srvorca", Eu_srvorca);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 价格比例模式
	 * @return Integer
	 */
	public Integer getEu_pi_priratemd() {
		return ((Integer) getAttrVal("Eu_pi_priratemd"));
	}	
	/**
	 * 价格比例模式
	 * @param Eu_pi_priratemd
	 */
	public void setEu_pi_priratemd(Integer Eu_pi_priratemd) {
		setAttrVal("Eu_pi_priratemd", Eu_pi_priratemd);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}	
	/**
	 * 价格系数
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 患者价格分类名称
	 * @return String
	 */
	public String getPripat_name() {
		return ((String) getAttrVal("Pripat_name"));
	}	
	/**
	 * 患者价格分类名称
	 * @param Pripat_name
	 */
	public void setPripat_name(String Pripat_name) {
		setAttrVal("Pripat_name", Pripat_name);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}	
	/**
	 * 服务分类
	 * @param Srvca_name
	 */
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务项目
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 标准价格
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}	
	/**
	 * 标准价格
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
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
		return "Id_pripatsrvorca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pri_pat_srvorca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriPatSrvOrCaDODesc.class);
	}
	
}