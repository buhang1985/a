package iih.bd.mm.materialnames.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.materialnames.d.desc.MaterialNamesDODesc;
import java.math.BigDecimal;

/**
 * 药品通用名目录 DO数据 
 * 
 */
public class MaterialNamesDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//药品通用名主键标识
	public static final String ID_MATERIALNAME= "Id_materialname";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//药品类别
	public static final String ID_SRVTP= "Id_srvtp";
	//药品类别编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//药品分类
	public static final String ID_SRVCA= "Id_srvca";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//简称
	public static final String SHORTNAME= "Shortname";
	//服务描述
	public static final String DES= "Des";
	//默认剂量
	public static final String QUAN_DOSAGE= "Quan_dosage";
	//默认剂量单位
	public static final String ID_UNIT_MED= "Id_unit_med";
	//默认频次
	public static final String ID_FREQ= "Id_freq";
	//默认用法
	public static final String ID_ROUTE= "Id_route";
	//默认用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//默认煎法
	public static final String ID_BOIL= "Id_boil";
	//默认煎法要求
	public static final String ID_BOILDES= "Id_boildes";
	//定价模式
	public static final String ID_PRIMD= "Id_primd";
	//定价模式编码
	public static final String SD_PRIMD= "Sd_primd";
	//参考价格
	public static final String PRI= "Pri";
	//自定义服务名称标志
	public static final String FG_CTM= "Fg_ctm";
	//医嘱可开立标识
	public static final String FG_OR= "Fg_or";
	//医疗物品标识
	public static final String FG_MM= "Fg_mm";
	//费用标识
	public static final String FG_BL= "Fg_bl";
	//划价方式
	public static final String EU_BLMD= "Eu_blmd";
	//服务套标识
	public static final String FG_SET= "Fg_set";
	//服务套开立方式
	public static final String ID_SETORD= "Id_setord";
	//服务套开立方式编码
	public static final String SD_SETORD= "Sd_setord";
	//门诊可使用标识
	public static final String FG_USE_OP= "Fg_use_op";
	//预住院可使用标识
	public static final String FG_USE_PIP= "Fg_use_pip";
	//住院可使用标识
	public static final String FG_USE_IP= "Fg_use_ip";
	//急诊流水标志
	public static final String FG_USE_ER= "Fg_use_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//体检可使用标识
	public static final String FG_USE_PE= "Fg_use_pe";
	//家庭可使用标识
	public static final String FG_USE_FM= "Fg_use_fm";
	//门诊绑定时机
	public static final String ID_MMBIND_OP= "Id_mmbind_op";
	//门诊绑定时机编码
	public static final String SD_MMBIND_OP= "Sd_mmbind_op";
	//住院绑定时机
	public static final String ID_MMBIND_IP= "Id_mmbind_ip";
	//住院绑定时机编码
	public static final String SD_MMBIND_IP= "Sd_mmbind_ip";
	//急诊绑定时机
	public static final String ID_MMBIND_ER= "Id_mmbind_er";
	//急诊绑定时机编码
	public static final String SD_MMBIND_ER= "Sd_mmbind_er";
	//体检绑定时机
	public static final String ID_MMBIND_PE= "Id_mmbind_pe";
	//体检绑定时机编码
	public static final String SD_MMBIND_PE= "Sd_mmbind_pe";
	//家庭绑定时机
	public static final String ID_MMBIND_FM= "Id_mmbind_fm";
	//家庭绑定时机编码
	public static final String SD_MMBIND_FM= "Sd_mmbind_fm";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//价格描述
	public static final String DES_PRI= "Des_pri";
	//门诊账单项
	public static final String ID_INCCA_OP= "Id_incca_op";
	//住院账单项
	public static final String ID_INCCA_IP= "Id_incca_ip";
	//收费分类
	public static final String ID_PRITP= "Id_pritp";
	//收费分类编码
	public static final String SD_PRITP= "Sd_pritp";
	//对照编码1
	public static final String CODE_REL1= "Code_rel1";
	//对照编码2
	public static final String CODE_REL2= "Code_rel2";
	//对照编码3
	public static final String CODE_REL3= "Code_rel3";
	//对照编码4
	public static final String CODE_REL4= "Code_rel4";
	//对照编码5
	public static final String CODE_REL5= "Code_rel5";
	//对照编码6
	public static final String CODE_REL6= "Code_rel6";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//国家药物基本目录标识
	public static final String FG_NEDRUGLIST= "Fg_nedruglist";
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
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//药品类型
	public static final String ID_MMTP= "Id_mmtp";
	//药品类型编码
	public static final String SD_MMTP= "Sd_mmtp";
	//住院核算体系
	public static final String ID_ACCOUNT_ZY= "Id_account_zy";
	//门诊核算体系
	public static final String ID_ACCOUNT_MZ= "Id_account_mz";
	//共有核算体系
	public static final String ID_ACCOUNT_GY= "Id_account_gy";
	//高危药品标识
	public static final String FG_HIGHRISK= "Fg_highrisk";
	//是否绑定
	public static final String FG_BINDING= "Fg_binding";
	//抗肿瘤药物分类
	public static final String ID_ANTDRUGCA= "Id_antdrugca";
	//抗肿瘤药物分类编码
	public static final String SD_ANTDRUGCA= "Sd_antdrugca";
	//药品类型名称
	public static final String SRVTP_NAME= "Srvtp_name";
	//药品类型编码
	public static final String SRVTP_CODE= "Srvtp_code";
	//药品分类编码
	public static final String SRVCA_CODE= "Srvca_code";
	//药品分类名称
	public static final String SRVCA_NAME= "Srvca_name";
	//药品分类内部编码
	public static final String SRVCA_INNERCODE= "Srvca_innercode";
	//默认剂量单位编码
	public static final String UNIT_MED_CODE= "Unit_med_code";
	//默认剂量单位名称
	public static final String UNIT_MED_NAME= "Unit_med_name";
	//频次编码
	public static final String FREQ_CODE= "Freq_code";
	//频次名称
	public static final String FREQ_NAME= "Freq_name";
	//长临标识
	public static final String FREQ_FG_LONG= "Freq_fg_long";
	//频次周期下次数
	public static final String FREQ_FREQCT= "Freq_freqct";
	//备用医嘱标识
	public static final String FREQ_FG_PRNOR= "Freq_fg_prnor";
	//频次周期类型编码
	public static final String FREQ_SD_FREQUNITCT= "Freq_sd_frequnitct";
	//频次周期数
	public static final String FREQ_FREQUNITCT= "Freq_frequnitct";
	//用法编码
	public static final String ROUTE_CODE= "Route_code";
	//用法名称
	public static final String ROUTE_NAME= "Route_name";
	//助记码
	public static final String ROUTE_MNECODE= "Route_mnecode";
	//默认用法要求编码
	public static final String ROUTEDES_CODE= "Routedes_code";
	//默认用法要求名称
	public static final String ROUTEDES_NAME= "Routedes_name";
	//煎法编码
	public static final String BOIL_CODE= "Boil_code";
	//煎法名称
	public static final String BOIL_NAME= "Boil_name";
	//助记码
	public static final String BOIL_MNECODE= "Boil_mnecode";
	//煎法要求编码
	public static final String BOILDES_CODE= "Boildes_code";
	//煎法要求
	public static final String BOILDES_NAME= "Boildes_name";
	//助记码
	public static final String BOILDES_MNECODE= "Boildes_mnecode";
	//定价模式编码
	public static final String PRIMD_CODE= "Primd_code";
	//定价模式名称
	public static final String PRIMD_NAME= "Primd_name";
	//服务套开立方式编码
	public static final String SETORD_CODE= "Setord_code";
	//服务套开立方式名称
	public static final String SETORD_NAME= "Setord_name";
	//门诊绑定时机编码
	public static final String MMBIND_OP_CODE= "Mmbind_op_code";
	//门诊绑定时机名称
	public static final String MMBIND_OP_NAME= "Mmbind_op_name";
	//住院绑定时机编码
	public static final String MMBIND_IP_CODE= "Mmbind_ip_code";
	//住院绑定时机名称
	public static final String MMBIND_IP_NAME= "Mmbind_ip_name";
	//急诊绑定时机编码
	public static final String MMBIND_ER_CODE= "Mmbind_er_code";
	//急诊绑定时机名称
	public static final String MMBIND_ER_NAME= "Mmbind_er_name";
	//体检绑定时机编码
	public static final String MMBIND_PE_CODE= "Mmbind_pe_code";
	//体检绑定时机名称
	public static final String MMBIND_PE_NAME= "Mmbind_pe_name";
	//家庭绑定时机编码
	public static final String MMBIND_FM_CODE= "Mmbind_fm_code";
	//家庭绑定时机名称
	public static final String MMBIND_FM_NAME= "Mmbind_fm_name";
	//门诊账单项名称
	public static final String INCCA_OP_NAME= "Incca_op_name";
	//住院账单项名称
	public static final String INCCA_IP_NAME= "Incca_ip_name";
	//收费分类名称
	public static final String PRITP_NAME= "Pritp_name";
	//收费分类编码
	public static final String PRITP_CODE= "Pritp_code";
	//药品剂型编码
	public static final String DOSAGE_CODE= "Dosage_code";
	//药品剂型名称
	public static final String DOSAGE_NAME= "Dosage_name";
	//药理分类名称
	public static final String PHARM_NAME= "Pharm_name";
	//药理分类编码
	public static final String PHARM_CODE= "Pharm_code";
	//毒麻分类名称
	public static final String POIS_NAME= "Pois_name";
	//毒麻分类编码
	public static final String POIS_CODE= "Pois_code";
	//抗菌药分类名称
	public static final String ANTI_NAME= "Anti_name";
	//抗菌药分类编码
	public static final String ANTI_CODE= "Anti_code";
	//药品类型名称
	public static final String MMTP_NAME= "Mmtp_name";
	//编码
	public static final String CODE_ZY_ACCSUB= "Code_zy_accsub";
	//名称
	public static final String NAME_ZY_ACCSUB= "Name_zy_accsub";
	//核算体系主键
	public static final String ID_ACC_ZY= "Id_acc_zy";
	//编码
	public static final String CODE_MZ_ACCSUB= "Code_mz_accsub";
	//名称
	public static final String NAME_MZ_ACCSUB= "Name_mz_accsub";
	//核算体系主键
	public static final String ID_ACC_MZ= "Id_acc_mz";
	//编码
	public static final String CODE_GY_ACCSUB= "Code_gy_accsub";
	//名称
	public static final String NAME_GY_ACCSUB= "Name_gy_accsub";
	//核算体系主键
	public static final String ID_ACC_GY= "Id_acc_gy";
	//抗肿瘤药物分类名称
	public static final String NAME_ANTDRUGCA= "Name_antdrugca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 药品通用名主键标识
	 * @return String
	 */
	public String getId_materialname() {
		return ((String) getAttrVal("Id_materialname"));
	}	
	/**
	 * 药品通用名主键标识
	 * @param Id_materialname
	 */
	public void setId_materialname(String Id_materialname) {
		setAttrVal("Id_materialname", Id_materialname);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 药品类别
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 药品类别
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 药品类别编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 药品类别编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 药品分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 药品分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 服务描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 服务描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 默认剂量
	 * @return FDouble
	 */
	public FDouble getQuan_dosage() {
		return ((FDouble) getAttrVal("Quan_dosage"));
	}	
	/**
	 * 默认剂量
	 * @param Quan_dosage
	 */
	public void setQuan_dosage(FDouble Quan_dosage) {
		setAttrVal("Quan_dosage", Quan_dosage);
	}
	/**
	 * 默认剂量单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	/**
	 * 默认剂量单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 默认频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 默认频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 默认用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 默认用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 默认用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 默认用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 默认煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 默认煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 默认煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 默认煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 定价模式编码
	 * @return String
	 */
	public String getSd_primd() {
		return ((String) getAttrVal("Sd_primd"));
	}	
	/**
	 * 定价模式编码
	 * @param Sd_primd
	 */
	public void setSd_primd(String Sd_primd) {
		setAttrVal("Sd_primd", Sd_primd);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 参考价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 自定义服务名称标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ctm() {
		return ((FBoolean) getAttrVal("Fg_ctm"));
	}	
	/**
	 * 自定义服务名称标志
	 * @param Fg_ctm
	 */
	public void setFg_ctm(FBoolean Fg_ctm) {
		setAttrVal("Fg_ctm", Fg_ctm);
	}
	/**
	 * 医嘱可开立标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}	
	/**
	 * 医嘱可开立标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 医疗物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 医疗物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}	
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 服务套开立方式
	 * @return String
	 */
	public String getId_setord() {
		return ((String) getAttrVal("Id_setord"));
	}	
	/**
	 * 服务套开立方式
	 * @param Id_setord
	 */
	public void setId_setord(String Id_setord) {
		setAttrVal("Id_setord", Id_setord);
	}
	/**
	 * 服务套开立方式编码
	 * @return String
	 */
	public String getSd_setord() {
		return ((String) getAttrVal("Sd_setord"));
	}	
	/**
	 * 服务套开立方式编码
	 * @param Sd_setord
	 */
	public void setSd_setord(String Sd_setord) {
		setAttrVal("Sd_setord", Sd_setord);
	}
	/**
	 * 门诊可使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_op() {
		return ((FBoolean) getAttrVal("Fg_use_op"));
	}	
	/**
	 * 门诊可使用标识
	 * @param Fg_use_op
	 */
	public void setFg_use_op(FBoolean Fg_use_op) {
		setAttrVal("Fg_use_op", Fg_use_op);
	}
	/**
	 * 预住院可使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 预住院可使用标识
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 住院可使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_ip() {
		return ((FBoolean) getAttrVal("Fg_use_ip"));
	}	
	/**
	 * 住院可使用标识
	 * @param Fg_use_ip
	 */
	public void setFg_use_ip(FBoolean Fg_use_ip) {
		setAttrVal("Fg_use_ip", Fg_use_ip);
	}
	/**
	 * 急诊流水标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er() {
		return ((FBoolean) getAttrVal("Fg_use_er"));
	}	
	/**
	 * 急诊流水标志
	 * @param Fg_use_er
	 */
	public void setFg_use_er(FBoolean Fg_use_er) {
		setAttrVal("Fg_use_er", Fg_use_er);
	}
	/**
	 * 急诊抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 急诊抢救标志
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_use_er2
	 */
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	/**
	 * 体检可使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pe() {
		return ((FBoolean) getAttrVal("Fg_use_pe"));
	}	
	/**
	 * 体检可使用标识
	 * @param Fg_use_pe
	 */
	public void setFg_use_pe(FBoolean Fg_use_pe) {
		setAttrVal("Fg_use_pe", Fg_use_pe);
	}
	/**
	 * 家庭可使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	/**
	 * 家庭可使用标识
	 * @param Fg_use_fm
	 */
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
	}
	/**
	 * 门诊绑定时机
	 * @return String
	 */
	public String getId_mmbind_op() {
		return ((String) getAttrVal("Id_mmbind_op"));
	}	
	/**
	 * 门诊绑定时机
	 * @param Id_mmbind_op
	 */
	public void setId_mmbind_op(String Id_mmbind_op) {
		setAttrVal("Id_mmbind_op", Id_mmbind_op);
	}
	/**
	 * 门诊绑定时机编码
	 * @return String
	 */
	public String getSd_mmbind_op() {
		return ((String) getAttrVal("Sd_mmbind_op"));
	}	
	/**
	 * 门诊绑定时机编码
	 * @param Sd_mmbind_op
	 */
	public void setSd_mmbind_op(String Sd_mmbind_op) {
		setAttrVal("Sd_mmbind_op", Sd_mmbind_op);
	}
	/**
	 * 住院绑定时机
	 * @return String
	 */
	public String getId_mmbind_ip() {
		return ((String) getAttrVal("Id_mmbind_ip"));
	}	
	/**
	 * 住院绑定时机
	 * @param Id_mmbind_ip
	 */
	public void setId_mmbind_ip(String Id_mmbind_ip) {
		setAttrVal("Id_mmbind_ip", Id_mmbind_ip);
	}
	/**
	 * 住院绑定时机编码
	 * @return String
	 */
	public String getSd_mmbind_ip() {
		return ((String) getAttrVal("Sd_mmbind_ip"));
	}	
	/**
	 * 住院绑定时机编码
	 * @param Sd_mmbind_ip
	 */
	public void setSd_mmbind_ip(String Sd_mmbind_ip) {
		setAttrVal("Sd_mmbind_ip", Sd_mmbind_ip);
	}
	/**
	 * 急诊绑定时机
	 * @return String
	 */
	public String getId_mmbind_er() {
		return ((String) getAttrVal("Id_mmbind_er"));
	}	
	/**
	 * 急诊绑定时机
	 * @param Id_mmbind_er
	 */
	public void setId_mmbind_er(String Id_mmbind_er) {
		setAttrVal("Id_mmbind_er", Id_mmbind_er);
	}
	/**
	 * 急诊绑定时机编码
	 * @return String
	 */
	public String getSd_mmbind_er() {
		return ((String) getAttrVal("Sd_mmbind_er"));
	}	
	/**
	 * 急诊绑定时机编码
	 * @param Sd_mmbind_er
	 */
	public void setSd_mmbind_er(String Sd_mmbind_er) {
		setAttrVal("Sd_mmbind_er", Sd_mmbind_er);
	}
	/**
	 * 体检绑定时机
	 * @return String
	 */
	public String getId_mmbind_pe() {
		return ((String) getAttrVal("Id_mmbind_pe"));
	}	
	/**
	 * 体检绑定时机
	 * @param Id_mmbind_pe
	 */
	public void setId_mmbind_pe(String Id_mmbind_pe) {
		setAttrVal("Id_mmbind_pe", Id_mmbind_pe);
	}
	/**
	 * 体检绑定时机编码
	 * @return String
	 */
	public String getSd_mmbind_pe() {
		return ((String) getAttrVal("Sd_mmbind_pe"));
	}	
	/**
	 * 体检绑定时机编码
	 * @param Sd_mmbind_pe
	 */
	public void setSd_mmbind_pe(String Sd_mmbind_pe) {
		setAttrVal("Sd_mmbind_pe", Sd_mmbind_pe);
	}
	/**
	 * 家庭绑定时机
	 * @return String
	 */
	public String getId_mmbind_fm() {
		return ((String) getAttrVal("Id_mmbind_fm"));
	}	
	/**
	 * 家庭绑定时机
	 * @param Id_mmbind_fm
	 */
	public void setId_mmbind_fm(String Id_mmbind_fm) {
		setAttrVal("Id_mmbind_fm", Id_mmbind_fm);
	}
	/**
	 * 家庭绑定时机编码
	 * @return String
	 */
	public String getSd_mmbind_fm() {
		return ((String) getAttrVal("Sd_mmbind_fm"));
	}	
	/**
	 * 家庭绑定时机编码
	 * @param Sd_mmbind_fm
	 */
	public void setSd_mmbind_fm(String Sd_mmbind_fm) {
		setAttrVal("Sd_mmbind_fm", Sd_mmbind_fm);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 价格描述
	 * @return String
	 */
	public String getDes_pri() {
		return ((String) getAttrVal("Des_pri"));
	}	
	/**
	 * 价格描述
	 * @param Des_pri
	 */
	public void setDes_pri(String Des_pri) {
		setAttrVal("Des_pri", Des_pri);
	}
	/**
	 * 门诊账单项
	 * @return String
	 */
	public String getId_incca_op() {
		return ((String) getAttrVal("Id_incca_op"));
	}	
	/**
	 * 门诊账单项
	 * @param Id_incca_op
	 */
	public void setId_incca_op(String Id_incca_op) {
		setAttrVal("Id_incca_op", Id_incca_op);
	}
	/**
	 * 住院账单项
	 * @return String
	 */
	public String getId_incca_ip() {
		return ((String) getAttrVal("Id_incca_ip"));
	}	
	/**
	 * 住院账单项
	 * @param Id_incca_ip
	 */
	public void setId_incca_ip(String Id_incca_ip) {
		setAttrVal("Id_incca_ip", Id_incca_ip);
	}
	/**
	 * 收费分类
	 * @return String
	 */
	public String getId_pritp() {
		return ((String) getAttrVal("Id_pritp"));
	}	
	/**
	 * 收费分类
	 * @param Id_pritp
	 */
	public void setId_pritp(String Id_pritp) {
		setAttrVal("Id_pritp", Id_pritp);
	}
	/**
	 * 收费分类编码
	 * @return String
	 */
	public String getSd_pritp() {
		return ((String) getAttrVal("Sd_pritp"));
	}	
	/**
	 * 收费分类编码
	 * @param Sd_pritp
	 */
	public void setSd_pritp(String Sd_pritp) {
		setAttrVal("Sd_pritp", Sd_pritp);
	}
	/**
	 * 对照编码1
	 * @return String
	 */
	public String getCode_rel1() {
		return ((String) getAttrVal("Code_rel1"));
	}	
	/**
	 * 对照编码1
	 * @param Code_rel1
	 */
	public void setCode_rel1(String Code_rel1) {
		setAttrVal("Code_rel1", Code_rel1);
	}
	/**
	 * 对照编码2
	 * @return String
	 */
	public String getCode_rel2() {
		return ((String) getAttrVal("Code_rel2"));
	}	
	/**
	 * 对照编码2
	 * @param Code_rel2
	 */
	public void setCode_rel2(String Code_rel2) {
		setAttrVal("Code_rel2", Code_rel2);
	}
	/**
	 * 对照编码3
	 * @return String
	 */
	public String getCode_rel3() {
		return ((String) getAttrVal("Code_rel3"));
	}	
	/**
	 * 对照编码3
	 * @param Code_rel3
	 */
	public void setCode_rel3(String Code_rel3) {
		setAttrVal("Code_rel3", Code_rel3);
	}
	/**
	 * 对照编码4
	 * @return String
	 */
	public String getCode_rel4() {
		return ((String) getAttrVal("Code_rel4"));
	}	
	/**
	 * 对照编码4
	 * @param Code_rel4
	 */
	public void setCode_rel4(String Code_rel4) {
		setAttrVal("Code_rel4", Code_rel4);
	}
	/**
	 * 对照编码5
	 * @return String
	 */
	public String getCode_rel5() {
		return ((String) getAttrVal("Code_rel5"));
	}	
	/**
	 * 对照编码5
	 * @param Code_rel5
	 */
	public void setCode_rel5(String Code_rel5) {
		setAttrVal("Code_rel5", Code_rel5);
	}
	/**
	 * 对照编码6
	 * @return String
	 */
	public String getCode_rel6() {
		return ((String) getAttrVal("Code_rel6"));
	}	
	/**
	 * 对照编码6
	 * @param Code_rel6
	 */
	public void setCode_rel6(String Code_rel6) {
		setAttrVal("Code_rel6", Code_rel6);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 国家药物基本目录标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nedruglist() {
		return ((FBoolean) getAttrVal("Fg_nedruglist"));
	}	
	/**
	 * 国家药物基本目录标识
	 * @param Fg_nedruglist
	 */
	public void setFg_nedruglist(FBoolean Fg_nedruglist) {
		setAttrVal("Fg_nedruglist", Fg_nedruglist);
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
	 * 住院核算体系
	 * @return String
	 */
	public String getId_account_zy() {
		return ((String) getAttrVal("Id_account_zy"));
	}	
	/**
	 * 住院核算体系
	 * @param Id_account_zy
	 */
	public void setId_account_zy(String Id_account_zy) {
		setAttrVal("Id_account_zy", Id_account_zy);
	}
	/**
	 * 门诊核算体系
	 * @return String
	 */
	public String getId_account_mz() {
		return ((String) getAttrVal("Id_account_mz"));
	}	
	/**
	 * 门诊核算体系
	 * @param Id_account_mz
	 */
	public void setId_account_mz(String Id_account_mz) {
		setAttrVal("Id_account_mz", Id_account_mz);
	}
	/**
	 * 共有核算体系
	 * @return String
	 */
	public String getId_account_gy() {
		return ((String) getAttrVal("Id_account_gy"));
	}	
	/**
	 * 共有核算体系
	 * @param Id_account_gy
	 */
	public void setId_account_gy(String Id_account_gy) {
		setAttrVal("Id_account_gy", Id_account_gy);
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
	 * 是否绑定
	 * @return FBoolean
	 */
	public FBoolean getFg_binding() {
		return ((FBoolean) getAttrVal("Fg_binding"));
	}	
	/**
	 * 是否绑定
	 * @param Fg_binding
	 */
	public void setFg_binding(FBoolean Fg_binding) {
		setAttrVal("Fg_binding", Fg_binding);
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
	 * 药品类型名称
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	/**
	 * 药品类型名称
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	/**
	 * 药品类型编码
	 * @return String
	 */
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}	
	/**
	 * 药品类型编码
	 * @param Srvtp_code
	 */
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	/**
	 * 药品分类编码
	 * @return String
	 */
	public String getSrvca_code() {
		return ((String) getAttrVal("Srvca_code"));
	}	
	/**
	 * 药品分类编码
	 * @param Srvca_code
	 */
	public void setSrvca_code(String Srvca_code) {
		setAttrVal("Srvca_code", Srvca_code);
	}
	/**
	 * 药品分类名称
	 * @return String
	 */
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}	
	/**
	 * 药品分类名称
	 * @param Srvca_name
	 */
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
	}
	/**
	 * 药品分类内部编码
	 * @return String
	 */
	public String getSrvca_innercode() {
		return ((String) getAttrVal("Srvca_innercode"));
	}	
	/**
	 * 药品分类内部编码
	 * @param Srvca_innercode
	 */
	public void setSrvca_innercode(String Srvca_innercode) {
		setAttrVal("Srvca_innercode", Srvca_innercode);
	}
	/**
	 * 默认剂量单位编码
	 * @return String
	 */
	public String getUnit_med_code() {
		return ((String) getAttrVal("Unit_med_code"));
	}	
	/**
	 * 默认剂量单位编码
	 * @param Unit_med_code
	 */
	public void setUnit_med_code(String Unit_med_code) {
		setAttrVal("Unit_med_code", Unit_med_code);
	}
	/**
	 * 默认剂量单位名称
	 * @return String
	 */
	public String getUnit_med_name() {
		return ((String) getAttrVal("Unit_med_name"));
	}	
	/**
	 * 默认剂量单位名称
	 * @param Unit_med_name
	 */
	public void setUnit_med_name(String Unit_med_name) {
		setAttrVal("Unit_med_name", Unit_med_name);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}	
	/**
	 * 频次编码
	 * @param Freq_code
	 */
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}	
	/**
	 * 频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFreq_fg_long() {
		return ((FBoolean) getAttrVal("Freq_fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Freq_fg_long
	 */
	public void setFreq_fg_long(FBoolean Freq_fg_long) {
		setAttrVal("Freq_fg_long", Freq_fg_long);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreq_freqct() {
		return ((Integer) getAttrVal("Freq_freqct"));
	}	
	/**
	 * 频次周期下次数
	 * @param Freq_freqct
	 */
	public void setFreq_freqct(Integer Freq_freqct) {
		setAttrVal("Freq_freqct", Freq_freqct);
	}
	/**
	 * 备用医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFreq_fg_prnor() {
		return ((FBoolean) getAttrVal("Freq_fg_prnor"));
	}	
	/**
	 * 备用医嘱标识
	 * @param Freq_fg_prnor
	 */
	public void setFreq_fg_prnor(FBoolean Freq_fg_prnor) {
		setAttrVal("Freq_fg_prnor", Freq_fg_prnor);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getFreq_sd_frequnitct() {
		return ((String) getAttrVal("Freq_sd_frequnitct"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Freq_sd_frequnitct
	 */
	public void setFreq_sd_frequnitct(String Freq_sd_frequnitct) {
		setAttrVal("Freq_sd_frequnitct", Freq_sd_frequnitct);
	}
	/**
	 * 频次周期数
	 * @return Integer
	 */
	public Integer getFreq_frequnitct() {
		return ((Integer) getAttrVal("Freq_frequnitct"));
	}	
	/**
	 * 频次周期数
	 * @param Freq_frequnitct
	 */
	public void setFreq_frequnitct(Integer Freq_frequnitct) {
		setAttrVal("Freq_frequnitct", Freq_frequnitct);
	}
	/**
	 * 用法编码
	 * @return String
	 */
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}	
	/**
	 * 用法编码
	 * @param Route_code
	 */
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	/**
	 * 用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getRoute_mnecode() {
		return ((String) getAttrVal("Route_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Route_mnecode
	 */
	public void setRoute_mnecode(String Route_mnecode) {
		setAttrVal("Route_mnecode", Route_mnecode);
	}
	/**
	 * 默认用法要求编码
	 * @return String
	 */
	public String getRoutedes_code() {
		return ((String) getAttrVal("Routedes_code"));
	}	
	/**
	 * 默认用法要求编码
	 * @param Routedes_code
	 */
	public void setRoutedes_code(String Routedes_code) {
		setAttrVal("Routedes_code", Routedes_code);
	}
	/**
	 * 默认用法要求名称
	 * @return String
	 */
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	/**
	 * 默认用法要求名称
	 * @param Routedes_name
	 */
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	/**
	 * 煎法编码
	 * @return String
	 */
	public String getBoil_code() {
		return ((String) getAttrVal("Boil_code"));
	}	
	/**
	 * 煎法编码
	 * @param Boil_code
	 */
	public void setBoil_code(String Boil_code) {
		setAttrVal("Boil_code", Boil_code);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	/**
	 * 煎法名称
	 * @param Boil_name
	 */
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getBoil_mnecode() {
		return ((String) getAttrVal("Boil_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Boil_mnecode
	 */
	public void setBoil_mnecode(String Boil_mnecode) {
		setAttrVal("Boil_mnecode", Boil_mnecode);
	}
	/**
	 * 煎法要求编码
	 * @return String
	 */
	public String getBoildes_code() {
		return ((String) getAttrVal("Boildes_code"));
	}	
	/**
	 * 煎法要求编码
	 * @param Boildes_code
	 */
	public void setBoildes_code(String Boildes_code) {
		setAttrVal("Boildes_code", Boildes_code);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	/**
	 * 煎法要求
	 * @param Boildes_name
	 */
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getBoildes_mnecode() {
		return ((String) getAttrVal("Boildes_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Boildes_mnecode
	 */
	public void setBoildes_mnecode(String Boildes_mnecode) {
		setAttrVal("Boildes_mnecode", Boildes_mnecode);
	}
	/**
	 * 定价模式编码
	 * @return String
	 */
	public String getPrimd_code() {
		return ((String) getAttrVal("Primd_code"));
	}	
	/**
	 * 定价模式编码
	 * @param Primd_code
	 */
	public void setPrimd_code(String Primd_code) {
		setAttrVal("Primd_code", Primd_code);
	}
	/**
	 * 定价模式名称
	 * @return String
	 */
	public String getPrimd_name() {
		return ((String) getAttrVal("Primd_name"));
	}	
	/**
	 * 定价模式名称
	 * @param Primd_name
	 */
	public void setPrimd_name(String Primd_name) {
		setAttrVal("Primd_name", Primd_name);
	}
	/**
	 * 服务套开立方式编码
	 * @return String
	 */
	public String getSetord_code() {
		return ((String) getAttrVal("Setord_code"));
	}	
	/**
	 * 服务套开立方式编码
	 * @param Setord_code
	 */
	public void setSetord_code(String Setord_code) {
		setAttrVal("Setord_code", Setord_code);
	}
	/**
	 * 服务套开立方式名称
	 * @return String
	 */
	public String getSetord_name() {
		return ((String) getAttrVal("Setord_name"));
	}	
	/**
	 * 服务套开立方式名称
	 * @param Setord_name
	 */
	public void setSetord_name(String Setord_name) {
		setAttrVal("Setord_name", Setord_name);
	}
	/**
	 * 门诊绑定时机编码
	 * @return String
	 */
	public String getMmbind_op_code() {
		return ((String) getAttrVal("Mmbind_op_code"));
	}	
	/**
	 * 门诊绑定时机编码
	 * @param Mmbind_op_code
	 */
	public void setMmbind_op_code(String Mmbind_op_code) {
		setAttrVal("Mmbind_op_code", Mmbind_op_code);
	}
	/**
	 * 门诊绑定时机名称
	 * @return String
	 */
	public String getMmbind_op_name() {
		return ((String) getAttrVal("Mmbind_op_name"));
	}	
	/**
	 * 门诊绑定时机名称
	 * @param Mmbind_op_name
	 */
	public void setMmbind_op_name(String Mmbind_op_name) {
		setAttrVal("Mmbind_op_name", Mmbind_op_name);
	}
	/**
	 * 住院绑定时机编码
	 * @return String
	 */
	public String getMmbind_ip_code() {
		return ((String) getAttrVal("Mmbind_ip_code"));
	}	
	/**
	 * 住院绑定时机编码
	 * @param Mmbind_ip_code
	 */
	public void setMmbind_ip_code(String Mmbind_ip_code) {
		setAttrVal("Mmbind_ip_code", Mmbind_ip_code);
	}
	/**
	 * 住院绑定时机名称
	 * @return String
	 */
	public String getMmbind_ip_name() {
		return ((String) getAttrVal("Mmbind_ip_name"));
	}	
	/**
	 * 住院绑定时机名称
	 * @param Mmbind_ip_name
	 */
	public void setMmbind_ip_name(String Mmbind_ip_name) {
		setAttrVal("Mmbind_ip_name", Mmbind_ip_name);
	}
	/**
	 * 急诊绑定时机编码
	 * @return String
	 */
	public String getMmbind_er_code() {
		return ((String) getAttrVal("Mmbind_er_code"));
	}	
	/**
	 * 急诊绑定时机编码
	 * @param Mmbind_er_code
	 */
	public void setMmbind_er_code(String Mmbind_er_code) {
		setAttrVal("Mmbind_er_code", Mmbind_er_code);
	}
	/**
	 * 急诊绑定时机名称
	 * @return String
	 */
	public String getMmbind_er_name() {
		return ((String) getAttrVal("Mmbind_er_name"));
	}	
	/**
	 * 急诊绑定时机名称
	 * @param Mmbind_er_name
	 */
	public void setMmbind_er_name(String Mmbind_er_name) {
		setAttrVal("Mmbind_er_name", Mmbind_er_name);
	}
	/**
	 * 体检绑定时机编码
	 * @return String
	 */
	public String getMmbind_pe_code() {
		return ((String) getAttrVal("Mmbind_pe_code"));
	}	
	/**
	 * 体检绑定时机编码
	 * @param Mmbind_pe_code
	 */
	public void setMmbind_pe_code(String Mmbind_pe_code) {
		setAttrVal("Mmbind_pe_code", Mmbind_pe_code);
	}
	/**
	 * 体检绑定时机名称
	 * @return String
	 */
	public String getMmbind_pe_name() {
		return ((String) getAttrVal("Mmbind_pe_name"));
	}	
	/**
	 * 体检绑定时机名称
	 * @param Mmbind_pe_name
	 */
	public void setMmbind_pe_name(String Mmbind_pe_name) {
		setAttrVal("Mmbind_pe_name", Mmbind_pe_name);
	}
	/**
	 * 家庭绑定时机编码
	 * @return String
	 */
	public String getMmbind_fm_code() {
		return ((String) getAttrVal("Mmbind_fm_code"));
	}	
	/**
	 * 家庭绑定时机编码
	 * @param Mmbind_fm_code
	 */
	public void setMmbind_fm_code(String Mmbind_fm_code) {
		setAttrVal("Mmbind_fm_code", Mmbind_fm_code);
	}
	/**
	 * 家庭绑定时机名称
	 * @return String
	 */
	public String getMmbind_fm_name() {
		return ((String) getAttrVal("Mmbind_fm_name"));
	}	
	/**
	 * 家庭绑定时机名称
	 * @param Mmbind_fm_name
	 */
	public void setMmbind_fm_name(String Mmbind_fm_name) {
		setAttrVal("Mmbind_fm_name", Mmbind_fm_name);
	}
	/**
	 * 门诊账单项名称
	 * @return String
	 */
	public String getIncca_op_name() {
		return ((String) getAttrVal("Incca_op_name"));
	}	
	/**
	 * 门诊账单项名称
	 * @param Incca_op_name
	 */
	public void setIncca_op_name(String Incca_op_name) {
		setAttrVal("Incca_op_name", Incca_op_name);
	}
	/**
	 * 住院账单项名称
	 * @return String
	 */
	public String getIncca_ip_name() {
		return ((String) getAttrVal("Incca_ip_name"));
	}	
	/**
	 * 住院账单项名称
	 * @param Incca_ip_name
	 */
	public void setIncca_ip_name(String Incca_ip_name) {
		setAttrVal("Incca_ip_name", Incca_ip_name);
	}
	/**
	 * 收费分类名称
	 * @return String
	 */
	public String getPritp_name() {
		return ((String) getAttrVal("Pritp_name"));
	}	
	/**
	 * 收费分类名称
	 * @param Pritp_name
	 */
	public void setPritp_name(String Pritp_name) {
		setAttrVal("Pritp_name", Pritp_name);
	}
	/**
	 * 收费分类编码
	 * @return String
	 */
	public String getPritp_code() {
		return ((String) getAttrVal("Pritp_code"));
	}	
	/**
	 * 收费分类编码
	 * @param Pritp_code
	 */
	public void setPritp_code(String Pritp_code) {
		setAttrVal("Pritp_code", Pritp_code);
	}
	/**
	 * 药品剂型编码
	 * @return String
	 */
	public String getDosage_code() {
		return ((String) getAttrVal("Dosage_code"));
	}	
	/**
	 * 药品剂型编码
	 * @param Dosage_code
	 */
	public void setDosage_code(String Dosage_code) {
		setAttrVal("Dosage_code", Dosage_code);
	}
	/**
	 * 药品剂型名称
	 * @return String
	 */
	public String getDosage_name() {
		return ((String) getAttrVal("Dosage_name"));
	}	
	/**
	 * 药品剂型名称
	 * @param Dosage_name
	 */
	public void setDosage_name(String Dosage_name) {
		setAttrVal("Dosage_name", Dosage_name);
	}
	/**
	 * 药理分类名称
	 * @return String
	 */
	public String getPharm_name() {
		return ((String) getAttrVal("Pharm_name"));
	}	
	/**
	 * 药理分类名称
	 * @param Pharm_name
	 */
	public void setPharm_name(String Pharm_name) {
		setAttrVal("Pharm_name", Pharm_name);
	}
	/**
	 * 药理分类编码
	 * @return String
	 */
	public String getPharm_code() {
		return ((String) getAttrVal("Pharm_code"));
	}	
	/**
	 * 药理分类编码
	 * @param Pharm_code
	 */
	public void setPharm_code(String Pharm_code) {
		setAttrVal("Pharm_code", Pharm_code);
	}
	/**
	 * 毒麻分类名称
	 * @return String
	 */
	public String getPois_name() {
		return ((String) getAttrVal("Pois_name"));
	}	
	/**
	 * 毒麻分类名称
	 * @param Pois_name
	 */
	public void setPois_name(String Pois_name) {
		setAttrVal("Pois_name", Pois_name);
	}
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getPois_code() {
		return ((String) getAttrVal("Pois_code"));
	}	
	/**
	 * 毒麻分类编码
	 * @param Pois_code
	 */
	public void setPois_code(String Pois_code) {
		setAttrVal("Pois_code", Pois_code);
	}
	/**
	 * 抗菌药分类名称
	 * @return String
	 */
	public String getAnti_name() {
		return ((String) getAttrVal("Anti_name"));
	}	
	/**
	 * 抗菌药分类名称
	 * @param Anti_name
	 */
	public void setAnti_name(String Anti_name) {
		setAttrVal("Anti_name", Anti_name);
	}
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getAnti_code() {
		return ((String) getAttrVal("Anti_code"));
	}	
	/**
	 * 抗菌药分类编码
	 * @param Anti_code
	 */
	public void setAnti_code(String Anti_code) {
		setAttrVal("Anti_code", Anti_code);
	}
	/**
	 * 药品类型名称
	 * @return String
	 */
	public String getMmtp_name() {
		return ((String) getAttrVal("Mmtp_name"));
	}	
	/**
	 * 药品类型名称
	 * @param Mmtp_name
	 */
	public void setMmtp_name(String Mmtp_name) {
		setAttrVal("Mmtp_name", Mmtp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_zy_accsub() {
		return ((String) getAttrVal("Code_zy_accsub"));
	}	
	/**
	 * 编码
	 * @param Code_zy_accsub
	 */
	public void setCode_zy_accsub(String Code_zy_accsub) {
		setAttrVal("Code_zy_accsub", Code_zy_accsub);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_zy_accsub() {
		return ((String) getAttrVal("Name_zy_accsub"));
	}	
	/**
	 * 名称
	 * @param Name_zy_accsub
	 */
	public void setName_zy_accsub(String Name_zy_accsub) {
		setAttrVal("Name_zy_accsub", Name_zy_accsub);
	}
	/**
	 * 核算体系主键
	 * @return String
	 */
	public String getId_acc_zy() {
		return ((String) getAttrVal("Id_acc_zy"));
	}	
	/**
	 * 核算体系主键
	 * @param Id_acc_zy
	 */
	public void setId_acc_zy(String Id_acc_zy) {
		setAttrVal("Id_acc_zy", Id_acc_zy);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_mz_accsub() {
		return ((String) getAttrVal("Code_mz_accsub"));
	}	
	/**
	 * 编码
	 * @param Code_mz_accsub
	 */
	public void setCode_mz_accsub(String Code_mz_accsub) {
		setAttrVal("Code_mz_accsub", Code_mz_accsub);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mz_accsub() {
		return ((String) getAttrVal("Name_mz_accsub"));
	}	
	/**
	 * 名称
	 * @param Name_mz_accsub
	 */
	public void setName_mz_accsub(String Name_mz_accsub) {
		setAttrVal("Name_mz_accsub", Name_mz_accsub);
	}
	/**
	 * 核算体系主键
	 * @return String
	 */
	public String getId_acc_mz() {
		return ((String) getAttrVal("Id_acc_mz"));
	}	
	/**
	 * 核算体系主键
	 * @param Id_acc_mz
	 */
	public void setId_acc_mz(String Id_acc_mz) {
		setAttrVal("Id_acc_mz", Id_acc_mz);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_gy_accsub() {
		return ((String) getAttrVal("Code_gy_accsub"));
	}	
	/**
	 * 编码
	 * @param Code_gy_accsub
	 */
	public void setCode_gy_accsub(String Code_gy_accsub) {
		setAttrVal("Code_gy_accsub", Code_gy_accsub);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_gy_accsub() {
		return ((String) getAttrVal("Name_gy_accsub"));
	}	
	/**
	 * 名称
	 * @param Name_gy_accsub
	 */
	public void setName_gy_accsub(String Name_gy_accsub) {
		setAttrVal("Name_gy_accsub", Name_gy_accsub);
	}
	/**
	 * 核算体系主键
	 * @return String
	 */
	public String getId_acc_gy() {
		return ((String) getAttrVal("Id_acc_gy"));
	}	
	/**
	 * 核算体系主键
	 * @param Id_acc_gy
	 */
	public void setId_acc_gy(String Id_acc_gy) {
		setAttrVal("Id_acc_gy", Id_acc_gy);
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
		return "Id_materialname";
	}
	
	@Override
	public String getTableName() {	  
		return "default";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MaterialNamesDODesc.class);
	}
	
}