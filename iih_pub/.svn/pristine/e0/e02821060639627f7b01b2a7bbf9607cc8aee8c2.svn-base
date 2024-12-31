package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务 DO数据 
 * 
 */
public class MedSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务主键标识
	public static final String ID_SRV= "Id_srv";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务分类
	public static final String ID_SRVCA= "Id_srvca";
	//服务编码
	public static final String CODE= "Code";
	//服务分类内编码
	public static final String SRVCA_INNERCODE= "Srvca_innercode";
	//服务名称
	public static final String NAME= "Name";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//简称
	public static final String SHORTNAME= "Shortname";
	//服务描述
	public static final String DES= "Des";
	//备注
	public static final String NOTE= "Note";
	//医学单位
	public static final String ID_UNIT_MED= "Id_unit_med";
	//医学单位数值
	public static final String QUAN_MED= "Quan_med";
	//频次_默认
	public static final String ID_FREQ= "Id_freq";
	//用法默认
	public static final String ID_ROUTE= "Id_route";
	//用法要求默认
	public static final String ID_ROUTEDES= "Id_routedes";
	//煎法_默认
	public static final String ID_BOIL= "Id_boil";
	//煎法要求_默认
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
	//服务套项目单选限制标识
	public static final String FG_SETRADIO= "Fg_setradio";
	//服务套开立方式
	public static final String ID_SETORD= "Id_setord";
	//服务套开立方式编码
	public static final String SD_SETORD= "Sd_setord";
	//可使用标识_门诊
	public static final String FG_USE_OP= "Fg_use_op";
	//预住院标志
	public static final String FG_USE_PIP= "Fg_use_pip";
	//可使用标识_住院
	public static final String FG_USE_IP= "Fg_use_ip";
	//急诊流水标志
	public static final String FG_USE_ER= "Fg_use_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//可使用标识_体检
	public static final String FG_USE_PE= "Fg_use_pe";
	//可使用标识_家庭
	public static final String FG_USE_FM= "Fg_use_fm";
	//物品绑定时机_门诊
	public static final String ID_MMBIND_OP= "Id_mmbind_op";
	//物品绑定时机_住院
	public static final String ID_MMBIND_IP= "Id_mmbind_ip";
	//物品绑定时机_急诊
	public static final String ID_MMBIND_ER= "Id_mmbind_er";
	//物品绑定时机_体检
	public static final String ID_MMBIND_PE= "Id_mmbind_pe";
	//物品绑定时机_家庭
	public static final String ID_MMBIND_FM= "Id_mmbind_fm";
	//物品绑定时机编码_门诊
	public static final String SD_MMBIND_OP= "Sd_mmbind_op";
	//物品绑定时机编码_住院
	public static final String SD_MMBIND_IP= "Sd_mmbind_ip";
	//物品绑定时机编码_急诊
	public static final String SD_MMBIND_ER= "Sd_mmbind_er";
	//物品绑定时机编码_体检
	public static final String SD_MMBIND_PE= "Sd_mmbind_pe";
	//物品绑定时机编码_家庭
	public static final String SD_MMBIND_FM= "Sd_mmbind_fm";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//价格描述
	public static final String DES_PRI= "Des_pri";
	//门诊账单项
	public static final String INCCA_OP= "Incca_op";
	//住院账单项
	public static final String INCCA_IP= "Incca_ip";
	//收费分类
	public static final String ID_PRITP= "Id_pritp";
	//收费分类编码
	public static final String SD_PRITP= "Sd_pritp";
	//集成平台服务分类
	public static final String ID_IEMSGCA= "Id_iemsgca";
	//集成平台服务分类编码
	public static final String SD_IEMSGCA= "Sd_iemsgca";
	//国家药物基本目录标识
	public static final String FG_NEDRUGLIST= "Fg_nedruglist";
	//是否多次执行
	public static final String ISMULEXEC= "Ismulexec";
	//是否多量开单
	public static final String ISMULDOSE= "Ismuldose";
	//套明细必选数量
	public static final String SETITMCHKNUM= "Setitmchknum";
	//总量开单方式
	public static final String ID_TOTALOPENMODE= "Id_totalopenmode";
	//总量开单方式编码
	public static final String SD_TOTALOPENMODE= "Sd_totalopenmode";
	//默认次数
	public static final String TIMES= "Times";
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
	//对照编码7
	public static final String CODE_REL7= "Code_rel7";
	//对照编码6
	public static final String CODE_REL6= "Code_rel6";
	//对照编码8
	public static final String CODE_REL8= "Code_rel8";
	//对照编码9
	public static final String CODE_REL9= "Code_rel9";
	//对照编码10
	public static final String CODE_REL10= "Code_rel10";
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
	//门诊允许加急
	public static final String FG_URGENT_OP= "Fg_urgent_op";
	//住院允许加急
	public static final String FG_URGENT_IP= "Fg_urgent_ip";
	//急诊流水允许加急
	public static final String FG_URGENT_ER= "Fg_urgent_er";
	//体检允许加急
	public static final String FG_URGENT_PE= "Fg_urgent_pe";
	//家庭允许加急
	public static final String FG_URGENT_FM= "Fg_urgent_fm";
	//唯一码管理标识
	public static final String FG_IDMGMT= "Fg_idmgmt";
	//是否绑定
	public static final String FG_BINDING= "Fg_binding";
	//参考价
	public static final String PRI_REAL= "Pri_real";
	//当前批准文号/注册号(计算字段)
	public static final String APPRNO= "Apprno";
	//生产厂家(计算字段)
	public static final String SUP_NAME= "Sup_name";
	//门诊核算体系
	public static final String ID_ACC_MZ= "Id_acc_mz";
	//住院核算体系
	public static final String ID_ACC_ZY= "Id_acc_zy";
	//共用核算体系
	public static final String ID_ACC_GY= "Id_acc_gy";
	//物品主键
	public static final String ID_MM= "Id_mm";
	//费用项目启用标识
	public static final String FG_ACTIVE_BL= "Fg_active_bl";
	//急诊抢救允许加急
	public static final String FG_URGENT_ER1= "Fg_urgent_er1";
	//急诊留观允许加急
	public static final String FG_URGENT_ER2= "Fg_urgent_er2";
	//门诊默认加急
	public static final String FG_URGENT_DEF_OP= "Fg_urgent_def_op";
	//住院默认加急
	public static final String FG_URGENT_DEF_IP= "Fg_urgent_def_ip";
	//急诊流水默认加急
	public static final String FG_URGENT_DEF_ER= "Fg_urgent_def_er";
	//急诊抢救默认加急
	public static final String FG_URGENT_DEF_ER1= "Fg_urgent_def_er1";
	//急诊留观默认加急
	public static final String FG_URGENT_DEF_ER2= "Fg_urgent_def_er2";
	//体检默认加急
	public static final String FG_URGENT_DEF_PE= "Fg_urgent_def_pe";
	//家庭默认加急
	public static final String FG_URGENT_DEF_FM= "Fg_urgent_def_fm";
	//名称
	public static final String SRVTP_NAME= "Srvtp_name";
	//编码
	public static final String SRVTP_CODE= "Srvtp_code";
	//服务分类编码
	public static final String SRVCA_CODE= "Srvca_code";
	//服务分类名称
	public static final String SRVCA_NAME= "Srvca_name";
	//默认服务类型
	public static final String ID_SRVTP_CA= "Id_srvtp_ca";
	//默认服务类型编码
	public static final String CODE_SRVTP_CA= "Code_srvtp_ca";
	//计量单位编码
	public static final String MED_CODE= "Med_code";
	//计量单位名称
	public static final String MED_NAME= "Med_name";
	//频次编码
	public static final String FREQ_CODE= "Freq_code";
	//频次名称
	public static final String FREQ_NAME= "Freq_name";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//频次周期下次数
	public static final String FREQCT= "Freqct";
	//备用医嘱标识
	public static final String FG_PRNOR= "Fg_prnor";
	//频次周期类型编码
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	//频次周期数
	public static final String FREQUNITCT= "Frequnitct";
	//用法编码
	public static final String ROUTE_CODE= "Route_code";
	//用法名称
	public static final String ROUTE_NAME= "Route_name";
	//助记码
	public static final String ROUTE_MNECODE= "Route_mnecode";
	//用法要求编码
	public static final String ROUTEDES_CODE= "Routedes_code";
	//用法要求
	public static final String ROUTEDES_NAME= "Routedes_name";
	//助记码
	public static final String ROUTEDES_MNECODE= "Routedes_mnecode";
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
	//编码
	public static final String PRIMD_CODE= "Primd_code";
	//名称
	public static final String PRIMD_NAME= "Primd_name";
	//编码
	public static final String SETORD_CODE= "Setord_code";
	//名称
	public static final String SETORD_NAME= "Setord_name";
	//编码
	public static final String OP_CODE= "Op_code";
	//名称
	public static final String OP_NAME= "Op_name";
	//编码
	public static final String IP_CODE= "Ip_code";
	//名称
	public static final String IP_NAME= "Ip_name";
	//编码
	public static final String ER_CODE= "Er_code";
	//名称
	public static final String ER_NAME= "Er_name";
	//编码
	public static final String PE_CODE= "Pe_code";
	//名称
	public static final String PENAME= "Pename";
	//编码
	public static final String FM_CODE= "Fm_code";
	//名称
	public static final String FM_NAME= "Fm_name";
	//门诊票据项目名称
	public static final String INCCAITMOP_NAME= "Inccaitmop_name";
	//住院票据项目名称
	public static final String INCCAITMIP_NAME= "Inccaitmip_name";
	//名称
	public static final String NAME_PRITP= "Name_pritp";
	//编码
	public static final String CODE_PRITP= "Code_pritp";
	//集成平台服务分类名称
	public static final String IEMSGCA_NAME= "Iemsgca_name";
	//总量开单方式名称
	public static final String TOTALOPENMODE_NAME= "Totalopenmode_name";
	//门诊核算项目编码
	public static final String CODE_MZ_ACCSUB= "Code_mz_accsub";
	//门诊核算项目名称
	public static final String NAME_MZ_ACCSUB= "Name_mz_accsub";
	//门诊核算体系主键
	public static final String ID_ACCOUNT_MZ= "Id_account_mz";
	//住院核算项目编码
	public static final String CODE_ZY_ACCSUB= "Code_zy_accsub";
	//住院核算项目名称
	public static final String NAME_ZY_ACCSUB= "Name_zy_accsub";
	//住院核算体系主键
	public static final String ID_ACCOUNT_ZY= "Id_account_zy";
	//共用核算项目编码
	public static final String CODE_GY_ACCSUB= "Code_gy_accsub";
	//共用核算项目名称
	public static final String NAME_GY_ACCSUB= "Name_gy_accsub";
	//共用核算体系主键
	public static final String ID_ACCOUNT_GY= "Id_account_gy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务主键标识
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务主键标识
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 服务编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 服务分类内编码
	 * @return String
	 */
	public String getSrvca_innercode() {
		return ((String) getAttrVal("Srvca_innercode"));
	}	
	/**
	 * 服务分类内编码
	 * @param Srvca_innercode
	 */
	public void setSrvca_innercode(String Srvca_innercode) {
		setAttrVal("Srvca_innercode", Srvca_innercode);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 服务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 医学单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 医学单位数值
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	/**
	 * 医学单位数值
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 频次_默认
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 频次_默认
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 用法默认
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法默认
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求默认
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求默认
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法_默认
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法_默认
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求_默认
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求_默认
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
	 * 服务套项目单选限制标识
	 * @return FBoolean
	 */
	public FBoolean getFg_setradio() {
		return ((FBoolean) getAttrVal("Fg_setradio"));
	}	
	/**
	 * 服务套项目单选限制标识
	 * @param Fg_setradio
	 */
	public void setFg_setradio(FBoolean Fg_setradio) {
		setAttrVal("Fg_setradio", Fg_setradio);
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
	 * 可使用标识_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_use_op() {
		return ((FBoolean) getAttrVal("Fg_use_op"));
	}	
	/**
	 * 可使用标识_门诊
	 * @param Fg_use_op
	 */
	public void setFg_use_op(FBoolean Fg_use_op) {
		setAttrVal("Fg_use_op", Fg_use_op);
	}
	/**
	 * 预住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 预住院标志
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 可使用标识_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_ip() {
		return ((FBoolean) getAttrVal("Fg_use_ip"));
	}	
	/**
	 * 可使用标识_住院
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
	 * 可使用标识_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pe() {
		return ((FBoolean) getAttrVal("Fg_use_pe"));
	}	
	/**
	 * 可使用标识_体检
	 * @param Fg_use_pe
	 */
	public void setFg_use_pe(FBoolean Fg_use_pe) {
		setAttrVal("Fg_use_pe", Fg_use_pe);
	}
	/**
	 * 可使用标识_家庭
	 * @return FBoolean
	 */
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	/**
	 * 可使用标识_家庭
	 * @param Fg_use_fm
	 */
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
	}
	/**
	 * 物品绑定时机_门诊
	 * @return String
	 */
	public String getId_mmbind_op() {
		return ((String) getAttrVal("Id_mmbind_op"));
	}	
	/**
	 * 物品绑定时机_门诊
	 * @param Id_mmbind_op
	 */
	public void setId_mmbind_op(String Id_mmbind_op) {
		setAttrVal("Id_mmbind_op", Id_mmbind_op);
	}
	/**
	 * 物品绑定时机_住院
	 * @return String
	 */
	public String getId_mmbind_ip() {
		return ((String) getAttrVal("Id_mmbind_ip"));
	}	
	/**
	 * 物品绑定时机_住院
	 * @param Id_mmbind_ip
	 */
	public void setId_mmbind_ip(String Id_mmbind_ip) {
		setAttrVal("Id_mmbind_ip", Id_mmbind_ip);
	}
	/**
	 * 物品绑定时机_急诊
	 * @return String
	 */
	public String getId_mmbind_er() {
		return ((String) getAttrVal("Id_mmbind_er"));
	}	
	/**
	 * 物品绑定时机_急诊
	 * @param Id_mmbind_er
	 */
	public void setId_mmbind_er(String Id_mmbind_er) {
		setAttrVal("Id_mmbind_er", Id_mmbind_er);
	}
	/**
	 * 物品绑定时机_体检
	 * @return String
	 */
	public String getId_mmbind_pe() {
		return ((String) getAttrVal("Id_mmbind_pe"));
	}	
	/**
	 * 物品绑定时机_体检
	 * @param Id_mmbind_pe
	 */
	public void setId_mmbind_pe(String Id_mmbind_pe) {
		setAttrVal("Id_mmbind_pe", Id_mmbind_pe);
	}
	/**
	 * 物品绑定时机_家庭
	 * @return String
	 */
	public String getId_mmbind_fm() {
		return ((String) getAttrVal("Id_mmbind_fm"));
	}	
	/**
	 * 物品绑定时机_家庭
	 * @param Id_mmbind_fm
	 */
	public void setId_mmbind_fm(String Id_mmbind_fm) {
		setAttrVal("Id_mmbind_fm", Id_mmbind_fm);
	}
	/**
	 * 物品绑定时机编码_门诊
	 * @return String
	 */
	public String getSd_mmbind_op() {
		return ((String) getAttrVal("Sd_mmbind_op"));
	}	
	/**
	 * 物品绑定时机编码_门诊
	 * @param Sd_mmbind_op
	 */
	public void setSd_mmbind_op(String Sd_mmbind_op) {
		setAttrVal("Sd_mmbind_op", Sd_mmbind_op);
	}
	/**
	 * 物品绑定时机编码_住院
	 * @return String
	 */
	public String getSd_mmbind_ip() {
		return ((String) getAttrVal("Sd_mmbind_ip"));
	}	
	/**
	 * 物品绑定时机编码_住院
	 * @param Sd_mmbind_ip
	 */
	public void setSd_mmbind_ip(String Sd_mmbind_ip) {
		setAttrVal("Sd_mmbind_ip", Sd_mmbind_ip);
	}
	/**
	 * 物品绑定时机编码_急诊
	 * @return String
	 */
	public String getSd_mmbind_er() {
		return ((String) getAttrVal("Sd_mmbind_er"));
	}	
	/**
	 * 物品绑定时机编码_急诊
	 * @param Sd_mmbind_er
	 */
	public void setSd_mmbind_er(String Sd_mmbind_er) {
		setAttrVal("Sd_mmbind_er", Sd_mmbind_er);
	}
	/**
	 * 物品绑定时机编码_体检
	 * @return String
	 */
	public String getSd_mmbind_pe() {
		return ((String) getAttrVal("Sd_mmbind_pe"));
	}	
	/**
	 * 物品绑定时机编码_体检
	 * @param Sd_mmbind_pe
	 */
	public void setSd_mmbind_pe(String Sd_mmbind_pe) {
		setAttrVal("Sd_mmbind_pe", Sd_mmbind_pe);
	}
	/**
	 * 物品绑定时机编码_家庭
	 * @return String
	 */
	public String getSd_mmbind_fm() {
		return ((String) getAttrVal("Sd_mmbind_fm"));
	}	
	/**
	 * 物品绑定时机编码_家庭
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
	public String getIncca_op() {
		return ((String) getAttrVal("Incca_op"));
	}	
	/**
	 * 门诊账单项
	 * @param Incca_op
	 */
	public void setIncca_op(String Incca_op) {
		setAttrVal("Incca_op", Incca_op);
	}
	/**
	 * 住院账单项
	 * @return String
	 */
	public String getIncca_ip() {
		return ((String) getAttrVal("Incca_ip"));
	}	
	/**
	 * 住院账单项
	 * @param Incca_ip
	 */
	public void setIncca_ip(String Incca_ip) {
		setAttrVal("Incca_ip", Incca_ip);
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
	 * 集成平台服务分类
	 * @return String
	 */
	public String getId_iemsgca() {
		return ((String) getAttrVal("Id_iemsgca"));
	}	
	/**
	 * 集成平台服务分类
	 * @param Id_iemsgca
	 */
	public void setId_iemsgca(String Id_iemsgca) {
		setAttrVal("Id_iemsgca", Id_iemsgca);
	}
	/**
	 * 集成平台服务分类编码
	 * @return String
	 */
	public String getSd_iemsgca() {
		return ((String) getAttrVal("Sd_iemsgca"));
	}	
	/**
	 * 集成平台服务分类编码
	 * @param Sd_iemsgca
	 */
	public void setSd_iemsgca(String Sd_iemsgca) {
		setAttrVal("Sd_iemsgca", Sd_iemsgca);
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
	 * 是否多次执行
	 * @return FBoolean
	 */
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}	
	/**
	 * 是否多次执行
	 * @param Ismulexec
	 */
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}
	/**
	 * 是否多量开单
	 * @return FBoolean
	 */
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}	
	/**
	 * 是否多量开单
	 * @param Ismuldose
	 */
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
	/**
	 * 套明细必选数量
	 * @return Integer
	 */
	public Integer getSetitmchknum() {
		return ((Integer) getAttrVal("Setitmchknum"));
	}	
	/**
	 * 套明细必选数量
	 * @param Setitmchknum
	 */
	public void setSetitmchknum(Integer Setitmchknum) {
		setAttrVal("Setitmchknum", Setitmchknum);
	}
	/**
	 * 总量开单方式
	 * @return String
	 */
	public String getId_totalopenmode() {
		return ((String) getAttrVal("Id_totalopenmode"));
	}	
	/**
	 * 总量开单方式
	 * @param Id_totalopenmode
	 */
	public void setId_totalopenmode(String Id_totalopenmode) {
		setAttrVal("Id_totalopenmode", Id_totalopenmode);
	}
	/**
	 * 总量开单方式编码
	 * @return String
	 */
	public String getSd_totalopenmode() {
		return ((String) getAttrVal("Sd_totalopenmode"));
	}	
	/**
	 * 总量开单方式编码
	 * @param Sd_totalopenmode
	 */
	public void setSd_totalopenmode(String Sd_totalopenmode) {
		setAttrVal("Sd_totalopenmode", Sd_totalopenmode);
	}
	/**
	 * 默认次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}	
	/**
	 * 默认次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
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
	 * 对照编码7
	 * @return String
	 */
	public String getCode_rel7() {
		return ((String) getAttrVal("Code_rel7"));
	}	
	/**
	 * 对照编码7
	 * @param Code_rel7
	 */
	public void setCode_rel7(String Code_rel7) {
		setAttrVal("Code_rel7", Code_rel7);
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
	 * 对照编码8
	 * @return String
	 */
	public String getCode_rel8() {
		return ((String) getAttrVal("Code_rel8"));
	}	
	/**
	 * 对照编码8
	 * @param Code_rel8
	 */
	public void setCode_rel8(String Code_rel8) {
		setAttrVal("Code_rel8", Code_rel8);
	}
	/**
	 * 对照编码9
	 * @return String
	 */
	public String getCode_rel9() {
		return ((String) getAttrVal("Code_rel9"));
	}	
	/**
	 * 对照编码9
	 * @param Code_rel9
	 */
	public void setCode_rel9(String Code_rel9) {
		setAttrVal("Code_rel9", Code_rel9);
	}
	/**
	 * 对照编码10
	 * @return String
	 */
	public String getCode_rel10() {
		return ((String) getAttrVal("Code_rel10"));
	}	
	/**
	 * 对照编码10
	 * @param Code_rel10
	 */
	public void setCode_rel10(String Code_rel10) {
		setAttrVal("Code_rel10", Code_rel10);
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
	 * 门诊允许加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_op() {
		return ((FBoolean) getAttrVal("Fg_urgent_op"));
	}	
	/**
	 * 门诊允许加急
	 * @param Fg_urgent_op
	 */
	public void setFg_urgent_op(FBoolean Fg_urgent_op) {
		setAttrVal("Fg_urgent_op", Fg_urgent_op);
	}
	/**
	 * 住院允许加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_ip() {
		return ((FBoolean) getAttrVal("Fg_urgent_ip"));
	}	
	/**
	 * 住院允许加急
	 * @param Fg_urgent_ip
	 */
	public void setFg_urgent_ip(FBoolean Fg_urgent_ip) {
		setAttrVal("Fg_urgent_ip", Fg_urgent_ip);
	}
	/**
	 * 急诊流水允许加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_er() {
		return ((FBoolean) getAttrVal("Fg_urgent_er"));
	}	
	/**
	 * 急诊流水允许加急
	 * @param Fg_urgent_er
	 */
	public void setFg_urgent_er(FBoolean Fg_urgent_er) {
		setAttrVal("Fg_urgent_er", Fg_urgent_er);
	}
	/**
	 * 体检允许加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_pe() {
		return ((FBoolean) getAttrVal("Fg_urgent_pe"));
	}	
	/**
	 * 体检允许加急
	 * @param Fg_urgent_pe
	 */
	public void setFg_urgent_pe(FBoolean Fg_urgent_pe) {
		setAttrVal("Fg_urgent_pe", Fg_urgent_pe);
	}
	/**
	 * 家庭允许加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_fm() {
		return ((FBoolean) getAttrVal("Fg_urgent_fm"));
	}	
	/**
	 * 家庭允许加急
	 * @param Fg_urgent_fm
	 */
	public void setFg_urgent_fm(FBoolean Fg_urgent_fm) {
		setAttrVal("Fg_urgent_fm", Fg_urgent_fm);
	}
	/**
	 * 唯一码管理标识
	 * @return FBoolean
	 */
	public FBoolean getFg_idmgmt() {
		return ((FBoolean) getAttrVal("Fg_idmgmt"));
	}	
	/**
	 * 唯一码管理标识
	 * @param Fg_idmgmt
	 */
	public void setFg_idmgmt(FBoolean Fg_idmgmt) {
		setAttrVal("Fg_idmgmt", Fg_idmgmt);
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
	 * 参考价
	 * @return FDouble
	 */
	public FDouble getPri_real() {
		return ((FDouble) getAttrVal("Pri_real"));
	}	
	/**
	 * 参考价
	 * @param Pri_real
	 */
	public void setPri_real(FDouble Pri_real) {
		setAttrVal("Pri_real", Pri_real);
	}
	/**
	 * 当前批准文号/注册号(计算字段)
	 * @return String
	 */
	public String getApprno() {
		return ((String) getAttrVal("Apprno"));
	}	
	/**
	 * 当前批准文号/注册号(计算字段)
	 * @param Apprno
	 */
	public void setApprno(String Apprno) {
		setAttrVal("Apprno", Apprno);
	}
	/**
	 * 生产厂家(计算字段)
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 生产厂家(计算字段)
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 门诊核算体系
	 * @return String
	 */
	public String getId_acc_mz() {
		return ((String) getAttrVal("Id_acc_mz"));
	}	
	/**
	 * 门诊核算体系
	 * @param Id_acc_mz
	 */
	public void setId_acc_mz(String Id_acc_mz) {
		setAttrVal("Id_acc_mz", Id_acc_mz);
	}
	/**
	 * 住院核算体系
	 * @return String
	 */
	public String getId_acc_zy() {
		return ((String) getAttrVal("Id_acc_zy"));
	}	
	/**
	 * 住院核算体系
	 * @param Id_acc_zy
	 */
	public void setId_acc_zy(String Id_acc_zy) {
		setAttrVal("Id_acc_zy", Id_acc_zy);
	}
	/**
	 * 共用核算体系
	 * @return String
	 */
	public String getId_acc_gy() {
		return ((String) getAttrVal("Id_acc_gy"));
	}	
	/**
	 * 共用核算体系
	 * @param Id_acc_gy
	 */
	public void setId_acc_gy(String Id_acc_gy) {
		setAttrVal("Id_acc_gy", Id_acc_gy);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 费用项目启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active_bl() {
		return ((FBoolean) getAttrVal("Fg_active_bl"));
	}	
	/**
	 * 费用项目启用标识
	 * @param Fg_active_bl
	 */
	public void setFg_active_bl(FBoolean Fg_active_bl) {
		setAttrVal("Fg_active_bl", Fg_active_bl);
	}
	/**
	 * 急诊抢救允许加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_er1() {
		return ((FBoolean) getAttrVal("Fg_urgent_er1"));
	}	
	/**
	 * 急诊抢救允许加急
	 * @param Fg_urgent_er1
	 */
	public void setFg_urgent_er1(FBoolean Fg_urgent_er1) {
		setAttrVal("Fg_urgent_er1", Fg_urgent_er1);
	}
	/**
	 * 急诊留观允许加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_er2() {
		return ((FBoolean) getAttrVal("Fg_urgent_er2"));
	}	
	/**
	 * 急诊留观允许加急
	 * @param Fg_urgent_er2
	 */
	public void setFg_urgent_er2(FBoolean Fg_urgent_er2) {
		setAttrVal("Fg_urgent_er2", Fg_urgent_er2);
	}
	/**
	 * 门诊默认加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_def_op() {
		return ((FBoolean) getAttrVal("Fg_urgent_def_op"));
	}	
	/**
	 * 门诊默认加急
	 * @param Fg_urgent_def_op
	 */
	public void setFg_urgent_def_op(FBoolean Fg_urgent_def_op) {
		setAttrVal("Fg_urgent_def_op", Fg_urgent_def_op);
	}
	/**
	 * 住院默认加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_def_ip() {
		return ((FBoolean) getAttrVal("Fg_urgent_def_ip"));
	}	
	/**
	 * 住院默认加急
	 * @param Fg_urgent_def_ip
	 */
	public void setFg_urgent_def_ip(FBoolean Fg_urgent_def_ip) {
		setAttrVal("Fg_urgent_def_ip", Fg_urgent_def_ip);
	}
	/**
	 * 急诊流水默认加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_def_er() {
		return ((FBoolean) getAttrVal("Fg_urgent_def_er"));
	}	
	/**
	 * 急诊流水默认加急
	 * @param Fg_urgent_def_er
	 */
	public void setFg_urgent_def_er(FBoolean Fg_urgent_def_er) {
		setAttrVal("Fg_urgent_def_er", Fg_urgent_def_er);
	}
	/**
	 * 急诊抢救默认加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_def_er1() {
		return ((FBoolean) getAttrVal("Fg_urgent_def_er1"));
	}	
	/**
	 * 急诊抢救默认加急
	 * @param Fg_urgent_def_er1
	 */
	public void setFg_urgent_def_er1(FBoolean Fg_urgent_def_er1) {
		setAttrVal("Fg_urgent_def_er1", Fg_urgent_def_er1);
	}
	/**
	 * 急诊留观默认加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_def_er2() {
		return ((FBoolean) getAttrVal("Fg_urgent_def_er2"));
	}	
	/**
	 * 急诊留观默认加急
	 * @param Fg_urgent_def_er2
	 */
	public void setFg_urgent_def_er2(FBoolean Fg_urgent_def_er2) {
		setAttrVal("Fg_urgent_def_er2", Fg_urgent_def_er2);
	}
	/**
	 * 体检默认加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_def_pe() {
		return ((FBoolean) getAttrVal("Fg_urgent_def_pe"));
	}	
	/**
	 * 体检默认加急
	 * @param Fg_urgent_def_pe
	 */
	public void setFg_urgent_def_pe(FBoolean Fg_urgent_def_pe) {
		setAttrVal("Fg_urgent_def_pe", Fg_urgent_def_pe);
	}
	/**
	 * 家庭默认加急
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent_def_fm() {
		return ((FBoolean) getAttrVal("Fg_urgent_def_fm"));
	}	
	/**
	 * 家庭默认加急
	 * @param Fg_urgent_def_fm
	 */
	public void setFg_urgent_def_fm(FBoolean Fg_urgent_def_fm) {
		setAttrVal("Fg_urgent_def_fm", Fg_urgent_def_fm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	/**
	 * 名称
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}	
	/**
	 * 编码
	 * @param Srvtp_code
	 */
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getSrvca_code() {
		return ((String) getAttrVal("Srvca_code"));
	}	
	/**
	 * 服务分类编码
	 * @param Srvca_code
	 */
	public void setSrvca_code(String Srvca_code) {
		setAttrVal("Srvca_code", Srvca_code);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}	
	/**
	 * 服务分类名称
	 * @param Srvca_name
	 */
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
	}
	/**
	 * 默认服务类型
	 * @return String
	 */
	public String getId_srvtp_ca() {
		return ((String) getAttrVal("Id_srvtp_ca"));
	}	
	/**
	 * 默认服务类型
	 * @param Id_srvtp_ca
	 */
	public void setId_srvtp_ca(String Id_srvtp_ca) {
		setAttrVal("Id_srvtp_ca", Id_srvtp_ca);
	}
	/**
	 * 默认服务类型编码
	 * @return String
	 */
	public String getCode_srvtp_ca() {
		return ((String) getAttrVal("Code_srvtp_ca"));
	}	
	/**
	 * 默认服务类型编码
	 * @param Code_srvtp_ca
	 */
	public void setCode_srvtp_ca(String Code_srvtp_ca) {
		setAttrVal("Code_srvtp_ca", Code_srvtp_ca);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getMed_code() {
		return ((String) getAttrVal("Med_code"));
	}	
	/**
	 * 计量单位编码
	 * @param Med_code
	 */
	public void setMed_code(String Med_code) {
		setAttrVal("Med_code", Med_code);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getMed_name() {
		return ((String) getAttrVal("Med_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Med_name
	 */
	public void setMed_name(String Med_name) {
		setAttrVal("Med_name", Med_name);
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
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}	
	/**
	 * 频次周期下次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 备用医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prnor() {
		return ((FBoolean) getAttrVal("Fg_prnor"));
	}	
	/**
	 * 备用医嘱标识
	 * @param Fg_prnor
	 */
	public void setFg_prnor(FBoolean Fg_prnor) {
		setAttrVal("Fg_prnor", Fg_prnor);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 频次周期数
	 * @return Integer
	 */
	public Integer getFrequnitct() {
		return ((Integer) getAttrVal("Frequnitct"));
	}	
	/**
	 * 频次周期数
	 * @param Frequnitct
	 */
	public void setFrequnitct(Integer Frequnitct) {
		setAttrVal("Frequnitct", Frequnitct);
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
	 * 用法要求编码
	 * @return String
	 */
	public String getRoutedes_code() {
		return ((String) getAttrVal("Routedes_code"));
	}	
	/**
	 * 用法要求编码
	 * @param Routedes_code
	 */
	public void setRoutedes_code(String Routedes_code) {
		setAttrVal("Routedes_code", Routedes_code);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	/**
	 * 用法要求
	 * @param Routedes_name
	 */
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getRoutedes_mnecode() {
		return ((String) getAttrVal("Routedes_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Routedes_mnecode
	 */
	public void setRoutedes_mnecode(String Routedes_mnecode) {
		setAttrVal("Routedes_mnecode", Routedes_mnecode);
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
	 * 编码
	 * @return String
	 */
	public String getPrimd_code() {
		return ((String) getAttrVal("Primd_code"));
	}	
	/**
	 * 编码
	 * @param Primd_code
	 */
	public void setPrimd_code(String Primd_code) {
		setAttrVal("Primd_code", Primd_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPrimd_name() {
		return ((String) getAttrVal("Primd_name"));
	}	
	/**
	 * 名称
	 * @param Primd_name
	 */
	public void setPrimd_name(String Primd_name) {
		setAttrVal("Primd_name", Primd_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSetord_code() {
		return ((String) getAttrVal("Setord_code"));
	}	
	/**
	 * 编码
	 * @param Setord_code
	 */
	public void setSetord_code(String Setord_code) {
		setAttrVal("Setord_code", Setord_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSetord_name() {
		return ((String) getAttrVal("Setord_name"));
	}	
	/**
	 * 名称
	 * @param Setord_name
	 */
	public void setSetord_name(String Setord_name) {
		setAttrVal("Setord_name", Setord_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOp_code() {
		return ((String) getAttrVal("Op_code"));
	}	
	/**
	 * 编码
	 * @param Op_code
	 */
	public void setOp_code(String Op_code) {
		setAttrVal("Op_code", Op_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOp_name() {
		return ((String) getAttrVal("Op_name"));
	}	
	/**
	 * 名称
	 * @param Op_name
	 */
	public void setOp_name(String Op_name) {
		setAttrVal("Op_name", Op_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIp_code() {
		return ((String) getAttrVal("Ip_code"));
	}	
	/**
	 * 编码
	 * @param Ip_code
	 */
	public void setIp_code(String Ip_code) {
		setAttrVal("Ip_code", Ip_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIp_name() {
		return ((String) getAttrVal("Ip_name"));
	}	
	/**
	 * 名称
	 * @param Ip_name
	 */
	public void setIp_name(String Ip_name) {
		setAttrVal("Ip_name", Ip_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getEr_code() {
		return ((String) getAttrVal("Er_code"));
	}	
	/**
	 * 编码
	 * @param Er_code
	 */
	public void setEr_code(String Er_code) {
		setAttrVal("Er_code", Er_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getEr_name() {
		return ((String) getAttrVal("Er_name"));
	}	
	/**
	 * 名称
	 * @param Er_name
	 */
	public void setEr_name(String Er_name) {
		setAttrVal("Er_name", Er_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 编码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPename() {
		return ((String) getAttrVal("Pename"));
	}	
	/**
	 * 名称
	 * @param Pename
	 */
	public void setPename(String Pename) {
		setAttrVal("Pename", Pename);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getFm_code() {
		return ((String) getAttrVal("Fm_code"));
	}	
	/**
	 * 编码
	 * @param Fm_code
	 */
	public void setFm_code(String Fm_code) {
		setAttrVal("Fm_code", Fm_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFm_name() {
		return ((String) getAttrVal("Fm_name"));
	}	
	/**
	 * 名称
	 * @param Fm_name
	 */
	public void setFm_name(String Fm_name) {
		setAttrVal("Fm_name", Fm_name);
	}
	/**
	 * 门诊票据项目名称
	 * @return String
	 */
	public String getInccaitmop_name() {
		return ((String) getAttrVal("Inccaitmop_name"));
	}	
	/**
	 * 门诊票据项目名称
	 * @param Inccaitmop_name
	 */
	public void setInccaitmop_name(String Inccaitmop_name) {
		setAttrVal("Inccaitmop_name", Inccaitmop_name);
	}
	/**
	 * 住院票据项目名称
	 * @return String
	 */
	public String getInccaitmip_name() {
		return ((String) getAttrVal("Inccaitmip_name"));
	}	
	/**
	 * 住院票据项目名称
	 * @param Inccaitmip_name
	 */
	public void setInccaitmip_name(String Inccaitmip_name) {
		setAttrVal("Inccaitmip_name", Inccaitmip_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pritp() {
		return ((String) getAttrVal("Name_pritp"));
	}	
	/**
	 * 名称
	 * @param Name_pritp
	 */
	public void setName_pritp(String Name_pritp) {
		setAttrVal("Name_pritp", Name_pritp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_pritp() {
		return ((String) getAttrVal("Code_pritp"));
	}	
	/**
	 * 编码
	 * @param Code_pritp
	 */
	public void setCode_pritp(String Code_pritp) {
		setAttrVal("Code_pritp", Code_pritp);
	}
	/**
	 * 集成平台服务分类名称
	 * @return String
	 */
	public String getIemsgca_name() {
		return ((String) getAttrVal("Iemsgca_name"));
	}	
	/**
	 * 集成平台服务分类名称
	 * @param Iemsgca_name
	 */
	public void setIemsgca_name(String Iemsgca_name) {
		setAttrVal("Iemsgca_name", Iemsgca_name);
	}
	/**
	 * 总量开单方式名称
	 * @return String
	 */
	public String getTotalopenmode_name() {
		return ((String) getAttrVal("Totalopenmode_name"));
	}	
	/**
	 * 总量开单方式名称
	 * @param Totalopenmode_name
	 */
	public void setTotalopenmode_name(String Totalopenmode_name) {
		setAttrVal("Totalopenmode_name", Totalopenmode_name);
	}
	/**
	 * 门诊核算项目编码
	 * @return String
	 */
	public String getCode_mz_accsub() {
		return ((String) getAttrVal("Code_mz_accsub"));
	}	
	/**
	 * 门诊核算项目编码
	 * @param Code_mz_accsub
	 */
	public void setCode_mz_accsub(String Code_mz_accsub) {
		setAttrVal("Code_mz_accsub", Code_mz_accsub);
	}
	/**
	 * 门诊核算项目名称
	 * @return String
	 */
	public String getName_mz_accsub() {
		return ((String) getAttrVal("Name_mz_accsub"));
	}	
	/**
	 * 门诊核算项目名称
	 * @param Name_mz_accsub
	 */
	public void setName_mz_accsub(String Name_mz_accsub) {
		setAttrVal("Name_mz_accsub", Name_mz_accsub);
	}
	/**
	 * 门诊核算体系主键
	 * @return String
	 */
	public String getId_account_mz() {
		return ((String) getAttrVal("Id_account_mz"));
	}	
	/**
	 * 门诊核算体系主键
	 * @param Id_account_mz
	 */
	public void setId_account_mz(String Id_account_mz) {
		setAttrVal("Id_account_mz", Id_account_mz);
	}
	/**
	 * 住院核算项目编码
	 * @return String
	 */
	public String getCode_zy_accsub() {
		return ((String) getAttrVal("Code_zy_accsub"));
	}	
	/**
	 * 住院核算项目编码
	 * @param Code_zy_accsub
	 */
	public void setCode_zy_accsub(String Code_zy_accsub) {
		setAttrVal("Code_zy_accsub", Code_zy_accsub);
	}
	/**
	 * 住院核算项目名称
	 * @return String
	 */
	public String getName_zy_accsub() {
		return ((String) getAttrVal("Name_zy_accsub"));
	}	
	/**
	 * 住院核算项目名称
	 * @param Name_zy_accsub
	 */
	public void setName_zy_accsub(String Name_zy_accsub) {
		setAttrVal("Name_zy_accsub", Name_zy_accsub);
	}
	/**
	 * 住院核算体系主键
	 * @return String
	 */
	public String getId_account_zy() {
		return ((String) getAttrVal("Id_account_zy"));
	}	
	/**
	 * 住院核算体系主键
	 * @param Id_account_zy
	 */
	public void setId_account_zy(String Id_account_zy) {
		setAttrVal("Id_account_zy", Id_account_zy);
	}
	/**
	 * 共用核算项目编码
	 * @return String
	 */
	public String getCode_gy_accsub() {
		return ((String) getAttrVal("Code_gy_accsub"));
	}	
	/**
	 * 共用核算项目编码
	 * @param Code_gy_accsub
	 */
	public void setCode_gy_accsub(String Code_gy_accsub) {
		setAttrVal("Code_gy_accsub", Code_gy_accsub);
	}
	/**
	 * 共用核算项目名称
	 * @return String
	 */
	public String getName_gy_accsub() {
		return ((String) getAttrVal("Name_gy_accsub"));
	}	
	/**
	 * 共用核算项目名称
	 * @param Name_gy_accsub
	 */
	public void setName_gy_accsub(String Name_gy_accsub) {
		setAttrVal("Name_gy_accsub", Name_gy_accsub);
	}
	/**
	 * 共用核算体系主键
	 * @return String
	 */
	public String getId_account_gy() {
		return ((String) getAttrVal("Id_account_gy"));
	}	
	/**
	 * 共用核算体系主键
	 * @param Id_account_gy
	 */
	public void setId_account_gy(String Id_account_gy) {
		setAttrVal("Id_account_gy", Id_account_gy);
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
		return "Id_srv";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvDODesc.class);
	}
	
}