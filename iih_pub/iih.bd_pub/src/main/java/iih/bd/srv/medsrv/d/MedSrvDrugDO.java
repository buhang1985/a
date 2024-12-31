package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvDrugDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务药品属性 DO数据 
 * 
 */
public class MedSrvDrugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务药品属性主键标识
	public static final String ID_SRVDRUG= "Id_srvdrug";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属医疗服务
	public static final String ID_SRV= "Id_srv";
	//药品剂型
	public static final String ID_DOSAGE= "Id_dosage";
	//药品剂型编码
	public static final String SD_DOSAGE= "Sd_dosage";
	//药理分类
	public static final String ID_PHARM= "Id_pharm";
	//药理分类编码
	public static final String SD_PHARM= "Sd_pharm";
	//毒麻标识
	public static final String FG_POIS= "Fg_pois";
	//毒麻分类
	public static final String ID_POIS= "Id_pois";
	//毒麻分类编码
	public static final String SD_POIS= "Sd_pois";
	//抗菌药标识
	public static final String FG_ANTI= "Fg_anti";
	//抗菌药分类
	public static final String ID_ANTI= "Id_anti";
	//抗菌药分类编码
	public static final String SD_ANTI= "Sd_anti";
	//适应症
	public static final String INDICA= "Indica";
	//禁忌症
	public static final String CONSTR= "Constr";
	//用量与用法
	public static final String USAGE= "Usage";
	//不良反应
	public static final String REACT= "React";
	//注意事项
	public static final String PRECAUT= "Precaut";
	//药品相互作用
	public static final String INTERACT= "Interact";
	//药品类型
	public static final String ID_MMTP= "Id_mmtp";
	//药品类型编码
	public static final String SD_MMTP= "Sd_mmtp";
	//高危药品标识
	public static final String FG_HIGHRISK= "Fg_highrisk";
	//抗肿瘤药物分类
	public static final String ID_ANTDRUGCA= "Id_antdrugca";
	//抗肿瘤药物分类编码
	public static final String SD_ANTDRUGCA= "Sd_antdrugca";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//编码
	public static final String DS_CODE= "Ds_code";
	//名称
	public static final String DS_NAME= "Ds_name";
	//名称
	public static final String NAME_PHARM= "Name_pharm";
	//名称
	public static final String NAME_POIS= "Name_pois";
	//名称
	public static final String NAME_ANTI= "Name_anti";
	//药品类型名称
	public static final String NAME_MMTP= "Name_mmtp";
	//抗肿瘤药物分类名称
	public static final String NAME_ANTDRUGCA= "Name_antdrugca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务药品属性主键标识
	 * @return String
	 */
	public String getId_srvdrug() {
		return ((String) getAttrVal("Id_srvdrug"));
	}	
	/**
	 * 医疗服务药品属性主键标识
	 * @param Id_srvdrug
	 */
	public void setId_srvdrug(String Id_srvdrug) {
		setAttrVal("Id_srvdrug", Id_srvdrug);
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
	 * 药品剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}	
	/**
	 * 药品剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 药品剂型编码
	 * @return String
	 */
	public String getSd_dosage() {
		return ((String) getAttrVal("Sd_dosage"));
	}	
	/**
	 * 药品剂型编码
	 * @param Sd_dosage
	 */
	public void setSd_dosage(String Sd_dosage) {
		setAttrVal("Sd_dosage", Sd_dosage);
	}
	/**
	 * 药理分类
	 * @return String
	 */
	public String getId_pharm() {
		return ((String) getAttrVal("Id_pharm"));
	}	
	/**
	 * 药理分类
	 * @param Id_pharm
	 */
	public void setId_pharm(String Id_pharm) {
		setAttrVal("Id_pharm", Id_pharm);
	}
	/**
	 * 药理分类编码
	 * @return String
	 */
	public String getSd_pharm() {
		return ((String) getAttrVal("Sd_pharm"));
	}	
	/**
	 * 药理分类编码
	 * @param Sd_pharm
	 */
	public void setSd_pharm(String Sd_pharm) {
		setAttrVal("Sd_pharm", Sd_pharm);
	}
	/**
	 * 毒麻标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pois() {
		return ((FBoolean) getAttrVal("Fg_pois"));
	}	
	/**
	 * 毒麻标识
	 * @param Fg_pois
	 */
	public void setFg_pois(FBoolean Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
	}
	/**
	 * 毒麻分类
	 * @return String
	 */
	public String getId_pois() {
		return ((String) getAttrVal("Id_pois"));
	}	
	/**
	 * 毒麻分类
	 * @param Id_pois
	 */
	public void setId_pois(String Id_pois) {
		setAttrVal("Id_pois", Id_pois);
	}
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}	
	/**
	 * 毒麻分类编码
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 抗菌药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_anti() {
		return ((FBoolean) getAttrVal("Fg_anti"));
	}	
	/**
	 * 抗菌药标识
	 * @param Fg_anti
	 */
	public void setFg_anti(FBoolean Fg_anti) {
		setAttrVal("Fg_anti", Fg_anti);
	}
	/**
	 * 抗菌药分类
	 * @return String
	 */
	public String getId_anti() {
		return ((String) getAttrVal("Id_anti"));
	}	
	/**
	 * 抗菌药分类
	 * @param Id_anti
	 */
	public void setId_anti(String Id_anti) {
		setAttrVal("Id_anti", Id_anti);
	}
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getSd_anti() {
		return ((String) getAttrVal("Sd_anti"));
	}	
	/**
	 * 抗菌药分类编码
	 * @param Sd_anti
	 */
	public void setSd_anti(String Sd_anti) {
		setAttrVal("Sd_anti", Sd_anti);
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
	 * 禁忌症
	 * @return String
	 */
	public String getConstr() {
		return ((String) getAttrVal("Constr"));
	}	
	/**
	 * 禁忌症
	 * @param Constr
	 */
	public void setConstr(String Constr) {
		setAttrVal("Constr", Constr);
	}
	/**
	 * 用量与用法
	 * @return String
	 */
	public String getUsage() {
		return ((String) getAttrVal("Usage"));
	}	
	/**
	 * 用量与用法
	 * @param Usage
	 */
	public void setUsage(String Usage) {
		setAttrVal("Usage", Usage);
	}
	/**
	 * 不良反应
	 * @return String
	 */
	public String getReact() {
		return ((String) getAttrVal("React"));
	}	
	/**
	 * 不良反应
	 * @param React
	 */
	public void setReact(String React) {
		setAttrVal("React", React);
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
	 * 药品相互作用
	 * @return String
	 */
	public String getInteract() {
		return ((String) getAttrVal("Interact"));
	}	
	/**
	 * 药品相互作用
	 * @param Interact
	 */
	public void setInteract(String Interact) {
		setAttrVal("Interact", Interact);
	}
	/**
	 * 药品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	/**
	 * 药品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 药品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	/**
	 * 药品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 高危药品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}	
	/**
	 * 高危药品标识
	 * @param Fg_highrisk
	 */
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
	/**
	 * 抗肿瘤药物分类
	 * @return String
	 */
	public String getId_antdrugca() {
		return ((String) getAttrVal("Id_antdrugca"));
	}	
	/**
	 * 抗肿瘤药物分类
	 * @param Id_antdrugca
	 */
	public void setId_antdrugca(String Id_antdrugca) {
		setAttrVal("Id_antdrugca", Id_antdrugca);
	}
	/**
	 * 抗肿瘤药物分类编码
	 * @return String
	 */
	public String getSd_antdrugca() {
		return ((String) getAttrVal("Sd_antdrugca"));
	}	
	/**
	 * 抗肿瘤药物分类编码
	 * @param Sd_antdrugca
	 */
	public void setSd_antdrugca(String Sd_antdrugca) {
		setAttrVal("Sd_antdrugca", Sd_antdrugca);
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
	 * 编码
	 * @return String
	 */
	public String getDs_code() {
		return ((String) getAttrVal("Ds_code"));
	}	
	/**
	 * 编码
	 * @param Ds_code
	 */
	public void setDs_code(String Ds_code) {
		setAttrVal("Ds_code", Ds_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDs_name() {
		return ((String) getAttrVal("Ds_name"));
	}	
	/**
	 * 名称
	 * @param Ds_name
	 */
	public void setDs_name(String Ds_name) {
		setAttrVal("Ds_name", Ds_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pharm() {
		return ((String) getAttrVal("Name_pharm"));
	}	
	/**
	 * 名称
	 * @param Name_pharm
	 */
	public void setName_pharm(String Name_pharm) {
		setAttrVal("Name_pharm", Name_pharm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pois() {
		return ((String) getAttrVal("Name_pois"));
	}	
	/**
	 * 名称
	 * @param Name_pois
	 */
	public void setName_pois(String Name_pois) {
		setAttrVal("Name_pois", Name_pois);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_anti() {
		return ((String) getAttrVal("Name_anti"));
	}	
	/**
	 * 名称
	 * @param Name_anti
	 */
	public void setName_anti(String Name_anti) {
		setAttrVal("Name_anti", Name_anti);
	}
	/**
	 * 药品类型名称
	 * @return String
	 */
	public String getName_mmtp() {
		return ((String) getAttrVal("Name_mmtp"));
	}	
	/**
	 * 药品类型名称
	 * @param Name_mmtp
	 */
	public void setName_mmtp(String Name_mmtp) {
		setAttrVal("Name_mmtp", Name_mmtp);
	}
	/**
	 * 抗肿瘤药物分类名称
	 * @return String
	 */
	public String getName_antdrugca() {
		return ((String) getAttrVal("Name_antdrugca"));
	}	
	/**
	 * 抗肿瘤药物分类名称
	 * @param Name_antdrugca
	 */
	public void setName_antdrugca(String Name_antdrugca) {
		setAttrVal("Name_antdrugca", Name_antdrugca);
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
		return "Id_srvdrug";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_drug";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvDrugDODesc.class);
	}
	
}