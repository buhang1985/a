package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvSaniDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务卫材属性 DO数据 
 * 
 */
public class MedSrvSaniDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务卫材属性主键标识
	public static final String ID_SRVSANI= "Id_srvsani";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属医疗服务
	public static final String ID_SRV= "Id_srv";
	//耗材分类
	public static final String ID_SANITP= "Id_sanitp";
	//耗材分类编码
	public static final String SD_SANITP= "Sd_sanitp";
	//卫材价值分类
	public static final String ID_SANIVALUETP= "Id_sanivaluetp";
	//卫材价值分类编码
	public static final String SD_SANIVALUETP= "Sd_sanivaluetp";
	//适应症
	public static final String INDICA= "Indica";
	//使用用法
	public static final String USAGE= "Usage";
	//禁忌
	public static final String CONSTR= "Constr";
	//注意事项
	public static final String PRECAUT= "Precaut";
	//当前批准文号/注册号
	public static final String APPRNO= "Apprno";
	//生产厂家
	public static final String SUP_NAME= "Sup_name";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//耗材分类
	public static final String NAME_SANITP= "Name_sanitp";
	//卫材价值分类
	public static final String NAME_VALUETYPE= "Name_valuetype";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务卫材属性主键标识
	 * @return String
	 */
	public String getId_srvsani() {
		return ((String) getAttrVal("Id_srvsani"));
	}	
	/**
	 * 医疗服务卫材属性主键标识
	 * @param Id_srvsani
	 */
	public void setId_srvsani(String Id_srvsani) {
		setAttrVal("Id_srvsani", Id_srvsani);
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
	 * 所属医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 所属医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 耗材分类
	 * @return String
	 */
	public String getId_sanitp() {
		return ((String) getAttrVal("Id_sanitp"));
	}	
	/**
	 * 耗材分类
	 * @param Id_sanitp
	 */
	public void setId_sanitp(String Id_sanitp) {
		setAttrVal("Id_sanitp", Id_sanitp);
	}
	/**
	 * 耗材分类编码
	 * @return String
	 */
	public String getSd_sanitp() {
		return ((String) getAttrVal("Sd_sanitp"));
	}	
	/**
	 * 耗材分类编码
	 * @param Sd_sanitp
	 */
	public void setSd_sanitp(String Sd_sanitp) {
		setAttrVal("Sd_sanitp", Sd_sanitp);
	}
	/**
	 * 卫材价值分类
	 * @return String
	 */
	public String getId_sanivaluetp() {
		return ((String) getAttrVal("Id_sanivaluetp"));
	}	
	/**
	 * 卫材价值分类
	 * @param Id_sanivaluetp
	 */
	public void setId_sanivaluetp(String Id_sanivaluetp) {
		setAttrVal("Id_sanivaluetp", Id_sanivaluetp);
	}
	/**
	 * 卫材价值分类编码
	 * @return String
	 */
	public String getSd_sanivaluetp() {
		return ((String) getAttrVal("Sd_sanivaluetp"));
	}	
	/**
	 * 卫材价值分类编码
	 * @param Sd_sanivaluetp
	 */
	public void setSd_sanivaluetp(String Sd_sanivaluetp) {
		setAttrVal("Sd_sanivaluetp", Sd_sanivaluetp);
	}
	/**
	 * 适应症
	 * @return String
	 */
	public String getIndica() {
		return ((String) getAttrVal("Indica"));
	}	
	/**
	 * 适应症
	 * @param Indica
	 */
	public void setIndica(String Indica) {
		setAttrVal("Indica", Indica);
	}
	/**
	 * 使用用法
	 * @return String
	 */
	public String getUsage() {
		return ((String) getAttrVal("Usage"));
	}	
	/**
	 * 使用用法
	 * @param Usage
	 */
	public void setUsage(String Usage) {
		setAttrVal("Usage", Usage);
	}
	/**
	 * 禁忌
	 * @return String
	 */
	public String getConstr() {
		return ((String) getAttrVal("Constr"));
	}	
	/**
	 * 禁忌
	 * @param Constr
	 */
	public void setConstr(String Constr) {
		setAttrVal("Constr", Constr);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getPrecaut() {
		return ((String) getAttrVal("Precaut"));
	}	
	/**
	 * 注意事项
	 * @param Precaut
	 */
	public void setPrecaut(String Precaut) {
		setAttrVal("Precaut", Precaut);
	}
	/**
	 * 当前批准文号/注册号
	 * @return String
	 */
	public String getApprno() {
		return ((String) getAttrVal("Apprno"));
	}	
	/**
	 * 当前批准文号/注册号
	 * @param Apprno
	 */
	public void setApprno(String Apprno) {
		setAttrVal("Apprno", Apprno);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 生产厂家
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 耗材分类
	 * @return String
	 */
	public String getName_sanitp() {
		return ((String) getAttrVal("Name_sanitp"));
	}	
	/**
	 * 耗材分类
	 * @param Name_sanitp
	 */
	public void setName_sanitp(String Name_sanitp) {
		setAttrVal("Name_sanitp", Name_sanitp);
	}
	/**
	 * 卫材价值分类
	 * @return String
	 */
	public String getName_valuetype() {
		return ((String) getAttrVal("Name_valuetype"));
	}	
	/**
	 * 卫材价值分类
	 * @param Name_valuetype
	 */
	public void setName_valuetype(String Name_valuetype) {
		setAttrVal("Name_valuetype", Name_valuetype);
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
		return "Id_srvsani";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_sani";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvSaniDODesc.class);
	}
	
}