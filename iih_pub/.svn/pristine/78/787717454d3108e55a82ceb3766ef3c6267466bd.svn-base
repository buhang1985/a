package iih.bd.mm.meterial.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_基本信息 DO数据 
 * 
 */
public class MeterialDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗物品主键
	public static final String ID_MM= "Id_mm";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//物品类型
	public static final String ID_MMTP= "Id_mmtp";
	//物品类型编码
	public static final String SD_MMTP= "Sd_mmtp";
	//物品分类
	public static final String ID_MMCA= "Id_mmca";
	//物品编码
	public static final String CODE= "Code";
	//物品名称
	public static final String NAME= "Name";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//物品描述
	public static final String DES= "Des";
	//物品规格
	public static final String SPEC= "Spec";
	//基本包装单位
	public static final String ID_UNIT_PKGBASE= "Id_unit_pkgbase";
	//零售包装单位
	public static final String ID_UNIT_PKGSP= "Id_unit_pkgsp";
	//基本包装单位名称
	public static final String NAME_UNIT_PKGBASE= "Name_unit_pkgbase";
	//零售包装单位名称
	public static final String NAME_UNIT_PKGSP= "Name_unit_pkgsp";
	//换算系数_零基
	public static final String FACTOR_SB= "Factor_sb";
	//换算系数_医基
	public static final String FACTOR_MB= "Factor_mb";
	//服务项目外键
	public static final String ID_SRV= "Id_srv";
	//ddd值
	public static final String DDD= "Ddd";
	//ddd单位
	public static final String ID_UNIT_DDD= "Id_unit_ddd";
	//条形码
	public static final String BARCODE= "Barcode";
	//启用状态
	public static final String FG_ACTIVE= "Fg_active";
	//停发标志
	public static final String FG_OUT= "Fg_out";
	//医保名称(废弃)
	public static final String HINAME= "Hiname";
	//化学名称
	public static final String CHEMISTRYNAME= "Chemistryname";
	//零售价计算方式
	public static final String ID_PRIMODE= "Id_primode";
	//零售价计算方式编码
	public static final String SD_PRIMODE= "Sd_primode";
	//零售价
	public static final String PRICE= "Price";
	//进价_零售单位
	public static final String PRICE_IN= "Price_in";
	//生产厂家主键
	public static final String ID_SUP= "Id_sup";
	//生产厂家名称
	public static final String SUP_NAME= "Sup_name";
	//当前批准文号/注册号
	public static final String APPRNO= "Apprno";
	//进口分类
	public static final String ID_ABRD= "Id_abrd";
	//进口分类编码
	public static final String SD_ABRD= "Sd_abrd";
	//价值分类
	public static final String ID_VAL= "Id_val";
	//价值分类编码
	public static final String SD_VAL= "Sd_val";
	//适应症
	public static final String INDICA= "Indica";
	//禁忌症
	public static final String CONSTR= "Constr";
	//不良反应
	public static final String REACT= "React";
	//药品相互作用
	public static final String INTERACT= "Interact";
	//用量与用法
	public static final String USAGE= "Usage";
	//注意事项
	public static final String PRECAUT= "Precaut";
	//预住院取整模式
	public static final String ID_PIPMUTP= "Id_pipmutp";
	//预住院取整模式编码
	public static final String SD_PIPMUTP= "Sd_pipmutp";
	//包装单位住院取整模式
	public static final String ID_MUPKGUTP= "Id_mupkgutp";
	//包装单位住院取整模式编码
	public static final String SD_MUPKGUTP= "Sd_mupkgutp";
	//包装单位门诊取整模式
	public static final String ID_OPMUTP= "Id_opmutp";
	//包装单位门诊取整模式编码
	public static final String SD_OPMUTP= "Sd_opmutp";
	//包装单位急诊流水取整模式
	public static final String ID_ERMUTP= "Id_ermutp";
	//包装单位急诊流水取整模式编码
	public static final String SD_ERMUTP= "Sd_ermutp";
	//包装单位急诊抢救取整模式
	public static final String ID_ER1MUTP= "Id_er1mutp";
	//包装单位急诊抢救取整模式编码
	public static final String SD_ER1MUTP= "Sd_er1mutp";
	//包装单位急诊留观取整模式
	public static final String ID_ER2MUTP= "Id_er2mutp";
	//包装单位急诊留观取整模式编码
	public static final String SD_ER2MUTP= "Sd_er2mutp";
	//物品有效期限
	public static final String VALID_CN= "Valid_cn";
	//有效期限单位
	public static final String ID_VALIDU= "Id_validu";
	//有效期限单位编码
	public static final String SD_VALIDU= "Sd_validu";
	//售价管理模式
	public static final String ID_PAP= "Id_pap";
	//售价管理模式编码
	public static final String SD_PAP= "Sd_pap";
	//本物品计算加成率
	public static final String RATE_PAP= "Rate_pap";
	//重量单位
	public static final String ID_UNIT_WEIGHT= "Id_unit_weight";
	//重量
	public static final String FACTOR_WB= "Factor_wb";
	//基本体积单位
	public static final String ID_UNIT_VOLBASE= "Id_unit_volbase";
	//换算系数_体基
	public static final String FACTOR_VB= "Factor_vb";
	//皮试标志
	public static final String FG_SKIN= "Fg_skin";
	//皮试类型
	public static final String ID_SKINCA= "Id_skinca";
	//皮试类型编码
	public static final String SD_SKINCA= "Sd_skinca";
	//皮试项目
	public static final String ID_SRVSKIN= "Id_srvskin";
	//皮试药品
	public static final String ID_MMSKIN= "Id_mmskin";
	//患者使用标志
	public static final String FG_PAT= "Fg_pat";
	//默认物品出库方式
	public static final String ID_OUTMODE= "Id_outmode";
	//默认物品出库方式编码
	public static final String SD_OUTMODE= "Sd_outmode";
	//是否批次管理
	public static final String FG_BATCH= "Fg_batch";
	//是否价格管理
	public static final String FG_PRICE= "Fg_price";
	//收费出库标识
	public static final String FG_CHARGE= "Fg_charge";
	//OTC标志
	public static final String FG_OTC= "Fg_otc";
	//产地
	public static final String PLACE= "Place";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//药品剂型
	public static final String DOSAGE_NAME= "Dosage_name";
	//毒麻分类
	public static final String POIS_CNAME= "Pois_cname";
	//抗菌药分类
	public static final String ANTI_NAME= "Anti_name";
	//打印名称
	public static final String PRINTNAME= "Printname";
	//英文名称
	public static final String ENGNAME= "Engname";
	//GMP标识
	public static final String FG_GMP= "Fg_gmp";
	//基本药物标识(废弃)
	public static final String FG_ESSDG= "Fg_essdg";
	//批次混发标识
	public static final String FG_BATCHMIX= "Fg_batchmix";
	//默认用法
	public static final String ID_ROUTE= "Id_route";
	//默认用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//默认频次
	public static final String ID_FREQ= "Id_freq";
	//默认剂量
	public static final String QUAN_MED= "Quan_med";
	//默认剂量单位
	public static final String ID_UNIT_MED= "Id_unit_med";
	//默认煎法
	public static final String ID_BOIL= "Id_boil";
	//默认煎法要求
	public static final String ID_BOILDES= "Id_boildes";
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
	//家床可使用标识
	public static final String FG_USE_FM= "Fg_use_fm";
	//基本药物范围
	public static final String ID_BASEDRUGRANGE= "Id_basedrugrange";
	//基本药物范围编码
	public static final String SD_BASEDRUGRANGE= "Sd_basedrugrange";
	//OA请领标识
	public static final String FG_OA_APPLYRECEIVE= "Fg_oa_applyreceive";
	//用药最大天数
	public static final String USEDRUG_NUM= "Usedrug_num";
	//储存条件串
	public static final String ID_STORECONDS= "Id_storeconds";
	//储存条件编码串
	public static final String SD_STORECONDS= "Sd_storeconds";
	//草药制剂类型
	public static final String ID_HERBPREPARATIONTP= "Id_herbpreparationtp";
	//草药制剂类型编码
	public static final String SD_HERBPREPARATIONTP= "Sd_herbpreparationtp";
	//是否效期管理
	public static final String FG_EFFECTIVE= "Fg_effective";
	//医院ddd值
	public static final String DDD2= "Ddd2";
	//医院ddd单位
	public static final String ID_UNIT_DDD2= "Id_unit_ddd2";
	//监管编码
	public static final String CODE_REGU= "Code_regu";
	//药品本位码
	public static final String CODE_ID= "Code_id";
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
	//辅助用药标志
	public static final String FG_ASSIS= "Fg_assis";
	//中标药品标志
	public static final String FG_BID= "Fg_bid";
	//对应价表
	public static final String ID_SRVPRI= "Id_srvpri";
	//重点监控标志
	public static final String FG_KEYMONITOR= "Fg_keymonitor";
	//是否可收费
	public static final String FG_CHARGEABLE= "Fg_chargeable";
	//耗材存储条件
	public static final String ID_STOR_CON= "Id_stor_con";
	//耗材存储条件编码
	public static final String SD_STOR_CON= "Sd_stor_con";
	//采购计划停用标志
	public static final String FG_STOP_MMPO= "Fg_stop_mmpo";
	//调拨单停用标志
	public static final String FG_STOP_MMTR= "Fg_stop_mmtr";
	//物品分组名称
	public static final String MMGRP_NAME= "Mmgrp_name";
	//库存分类
	public static final String ID_STCA= "Id_stca";
	//库存分类编码
	public static final String SD_STCA= "Sd_stca";
	//集团名称
	public static final String GRP_NAME= "Grp_name";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//物品类型名称
	public static final String MMTP_NAME= "Mmtp_name";
	//基本分类名称
	public static final String MMCA_NAME= "Mmca_name";
	//物品分类编码
	public static final String MMCA_CODE= "Mmca_code";
	//基本包装单位名称
	public static final String PKGBASE_NAME= "Pkgbase_name";
	//基本包装单位编码
	public static final String PKGBASE_CODE= "Pkgbase_code";
	//零售包装单位名称
	public static final String PKGSP_NAME= "Pkgsp_name";
	//零售包装单位编码
	public static final String PKGSP_CODE= "Pkgsp_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//医学单位
	public static final String SRV_ID_UNIT_MED= "Srv_id_unit_med";
	//ddd值计量单位编码
	public static final String DDDUNIT_CODE= "Dddunit_code";
	//ddd值计量单位名称
	public static final String DDDUNIT_NAME= "Dddunit_name";
	//名称
	public static final String PRIMODE_NAME= "Primode_name";
	//供应商与厂商名称
	public static final String FACTORY_NAME= "Factory_name";
	//进口分类名称
	public static final String ABRD_NAME= "Abrd_name";
	//价值分类名称
	public static final String VAL_NAME= "Val_name";
	//预住院取整模式名称
	public static final String NAME_PIPMUTP= "Name_pipmutp";
	//包装单位取整模式名称
	public static final String MUPKGUTP_NAME= "Mupkgutp_name";
	//包装单位门诊取整模式
	public static final String OPMUTP_NAME= "Opmutp_name";
	//包装单位急诊流水取整模式名称
	public static final String ERMUTP_NAME= "Ermutp_name";
	//包装单位急诊流水取整模编码
	public static final String ERMUTP_CODE= "Ermutp_code";
	//包装单位急诊抢救取整模式名称
	public static final String ER1MUTP_NAME= "Er1mutp_name";
	//包装单位急诊抢救取整模式编码
	public static final String ER1MUTP_CODE= "Er1mutp_code";
	//包装单位急诊留观取整模式名称
	public static final String ER2MUTP_NAME= "Er2mutp_name";
	//包装单位急诊留观取整模式编码
	public static final String ER2MUTP_CODE= "Er2mutp_code";
	//有效期限名称
	public static final String VALIDU_NAME= "Validu_name";
	//加成计算率名称
	public static final String PAP_NAME= "Pap_name";
	//重量单位编码
	public static final String WEIGHT_CODE= "Weight_code";
	//重量单位名称
	public static final String WEIGHT_NAME= "Weight_name";
	//体积单位名称
	public static final String VOLBASE_NAME= "Volbase_name";
	//体积单位编码
	public static final String VOLBASE_CODE= "Volbase_code";
	//皮试类型名称
	public static final String SKINCA_NAME= "Skinca_name";
	//皮试项目名称
	public static final String SRVSKIN_NAME= "Srvskin_name";
	//皮试项目编码
	public static final String SRVSKIN_CODE= "Srvskin_code";
	//皮试物品编码
	public static final String MMSKIN_CODE= "Mmskin_code";
	//皮试物品名称
	public static final String MMSKIN_NAME= "Mmskin_name";
	//出库方式名称
	public static final String OUTMODE_NAME= "Outmode_name";
	//默认用法名称
	public static final String ROUTE_NAME= "Route_name";
	//默认用法编码
	public static final String ROUTE_CODE= "Route_code";
	//默认用法要求名称
	public static final String ROUTEDES_NAME= "Routedes_name";
	//默认用法要求编码
	public static final String ROUTEDES_CODE= "Routedes_code";
	//默认频次名称
	public static final String FREQ_NAME= "Freq_name";
	//默认频次编码
	public static final String FREQ_CODE= "Freq_code";
	//频次周期类型编码
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	//频次周期类型
	public static final String ID_FREQUNITCT= "Id_frequnitct";
	//频次周期数
	public static final String FREQUNITCT= "Frequnitct";
	//频次周期下次数
	public static final String FREQCT= "Freqct";
	//备用医嘱标识
	public static final String FG_PRNOR= "Fg_prnor";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//默认剂量单位名称
	public static final String UNIT_MED_NAME= "Unit_med_name";
	//默认剂量单位编码
	public static final String UNIT_MED_CODE= "Unit_med_code";
	//默认煎法编码
	public static final String BOIL_CODE= "Boil_code";
	//默认煎法名称
	public static final String BOIL_NAME= "Boil_name";
	//默认煎法要求编码
	public static final String BOILDES_CODE= "Boildes_code";
	//默认煎法要求名称
	public static final String BOILDES_NAME= "Boildes_name";
	//基本药物范围名称
	public static final String BASEDRUGRANGE_NAME= "Basedrugrange_name";
	//储存条件名称
	public static final String NAME_STORECONDS= "Name_storeconds";
	//草药制剂类型名称
	public static final String HERBPREPARATIONTP_NAME= "Herbpreparationtp_name";
	//医院ddd单位名称
	public static final String NAME_DDD2= "Name_ddd2";
	//服务名称
	public static final String PRI_NAME= "Pri_name";
	//参考价格
	public static final String PRI= "Pri";
	//名称
	public static final String NAME_STOR_CON= "Name_stor_con";
	//库存分类名称
	public static final String STCA_NAME= "Stca_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	/**
	 * 物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	/**
	 * 物品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	/**
	 * 物品分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 物品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 物品名称
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
	 * 物品描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 物品描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 物品规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
	/**
	 * 零售包装单位
	 * @return String
	 */
	public String getId_unit_pkgsp() {
		return ((String) getAttrVal("Id_unit_pkgsp"));
	}	
	/**
	 * 零售包装单位
	 * @param Id_unit_pkgsp
	 */
	public void setId_unit_pkgsp(String Id_unit_pkgsp) {
		setAttrVal("Id_unit_pkgsp", Id_unit_pkgsp);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgbase() {
		return ((String) getAttrVal("Name_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位名称
	 * @param Name_unit_pkgbase
	 */
	public void setName_unit_pkgbase(String Name_unit_pkgbase) {
		setAttrVal("Name_unit_pkgbase", Name_unit_pkgbase);
	}
	/**
	 * 零售包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}	
	/**
	 * 零售包装单位名称
	 * @param Name_unit_pkgsp
	 */
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
	}
	/**
	 * 换算系数_零基
	 * @return FDouble
	 */
	public FDouble getFactor_sb() {
		return ((FDouble) getAttrVal("Factor_sb"));
	}	
	/**
	 * 换算系数_零基
	 * @param Factor_sb
	 */
	public void setFactor_sb(FDouble Factor_sb) {
		setAttrVal("Factor_sb", Factor_sb);
	}
	/**
	 * 换算系数_医基
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	/**
	 * 换算系数_医基
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 服务项目外键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目外键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * ddd值
	 * @return FDouble
	 */
	public FDouble getDdd() {
		return ((FDouble) getAttrVal("Ddd"));
	}	
	/**
	 * ddd值
	 * @param Ddd
	 */
	public void setDdd(FDouble Ddd) {
		setAttrVal("Ddd", Ddd);
	}
	/**
	 * ddd单位
	 * @return String
	 */
	public String getId_unit_ddd() {
		return ((String) getAttrVal("Id_unit_ddd"));
	}	
	/**
	 * ddd单位
	 * @param Id_unit_ddd
	 */
	public void setId_unit_ddd(String Id_unit_ddd) {
		setAttrVal("Id_unit_ddd", Id_unit_ddd);
	}
	/**
	 * 条形码
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}	
	/**
	 * 条形码
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	/**
	 * 启用状态
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用状态
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 停发标志
	 * @return FBoolean
	 */
	public FBoolean getFg_out() {
		return ((FBoolean) getAttrVal("Fg_out"));
	}	
	/**
	 * 停发标志
	 * @param Fg_out
	 */
	public void setFg_out(FBoolean Fg_out) {
		setAttrVal("Fg_out", Fg_out);
	}
	/**
	 * 医保名称(废弃)
	 * @return String
	 */
	public String getHiname() {
		return ((String) getAttrVal("Hiname"));
	}	
	/**
	 * 医保名称(废弃)
	 * @param Hiname
	 */
	public void setHiname(String Hiname) {
		setAttrVal("Hiname", Hiname);
	}
	/**
	 * 化学名称
	 * @return String
	 */
	public String getChemistryname() {
		return ((String) getAttrVal("Chemistryname"));
	}	
	/**
	 * 化学名称
	 * @param Chemistryname
	 */
	public void setChemistryname(String Chemistryname) {
		setAttrVal("Chemistryname", Chemistryname);
	}
	/**
	 * 零售价计算方式
	 * @return String
	 */
	public String getId_primode() {
		return ((String) getAttrVal("Id_primode"));
	}	
	/**
	 * 零售价计算方式
	 * @param Id_primode
	 */
	public void setId_primode(String Id_primode) {
		setAttrVal("Id_primode", Id_primode);
	}
	/**
	 * 零售价计算方式编码
	 * @return String
	 */
	public String getSd_primode() {
		return ((String) getAttrVal("Sd_primode"));
	}	
	/**
	 * 零售价计算方式编码
	 * @param Sd_primode
	 */
	public void setSd_primode(String Sd_primode) {
		setAttrVal("Sd_primode", Sd_primode);
	}
	/**
	 * 零售价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 零售价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 进价_零售单位
	 * @return FDouble
	 */
	public FDouble getPrice_in() {
		return ((FDouble) getAttrVal("Price_in"));
	}	
	/**
	 * 进价_零售单位
	 * @param Price_in
	 */
	public void setPrice_in(FDouble Price_in) {
		setAttrVal("Price_in", Price_in);
	}
	/**
	 * 生产厂家主键
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 生产厂家主键
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 生产厂家名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
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
	 * 进口分类
	 * @return String
	 */
	public String getId_abrd() {
		return ((String) getAttrVal("Id_abrd"));
	}	
	/**
	 * 进口分类
	 * @param Id_abrd
	 */
	public void setId_abrd(String Id_abrd) {
		setAttrVal("Id_abrd", Id_abrd);
	}
	/**
	 * 进口分类编码
	 * @return String
	 */
	public String getSd_abrd() {
		return ((String) getAttrVal("Sd_abrd"));
	}	
	/**
	 * 进口分类编码
	 * @param Sd_abrd
	 */
	public void setSd_abrd(String Sd_abrd) {
		setAttrVal("Sd_abrd", Sd_abrd);
	}
	/**
	 * 价值分类
	 * @return String
	 */
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}	
	/**
	 * 价值分类
	 * @param Id_val
	 */
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	/**
	 * 价值分类编码
	 * @return String
	 */
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}	
	/**
	 * 价值分类编码
	 * @param Sd_val
	 */
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
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
	 * 预住院取整模式
	 * @return String
	 */
	public String getId_pipmutp() {
		return ((String) getAttrVal("Id_pipmutp"));
	}	
	/**
	 * 预住院取整模式
	 * @param Id_pipmutp
	 */
	public void setId_pipmutp(String Id_pipmutp) {
		setAttrVal("Id_pipmutp", Id_pipmutp);
	}
	/**
	 * 预住院取整模式编码
	 * @return String
	 */
	public String getSd_pipmutp() {
		return ((String) getAttrVal("Sd_pipmutp"));
	}	
	/**
	 * 预住院取整模式编码
	 * @param Sd_pipmutp
	 */
	public void setSd_pipmutp(String Sd_pipmutp) {
		setAttrVal("Sd_pipmutp", Sd_pipmutp);
	}
	/**
	 * 包装单位住院取整模式
	 * @return String
	 */
	public String getId_mupkgutp() {
		return ((String) getAttrVal("Id_mupkgutp"));
	}	
	/**
	 * 包装单位住院取整模式
	 * @param Id_mupkgutp
	 */
	public void setId_mupkgutp(String Id_mupkgutp) {
		setAttrVal("Id_mupkgutp", Id_mupkgutp);
	}
	/**
	 * 包装单位住院取整模式编码
	 * @return String
	 */
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}	
	/**
	 * 包装单位住院取整模式编码
	 * @param Sd_mupkgutp
	 */
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}
	/**
	 * 包装单位门诊取整模式
	 * @return String
	 */
	public String getId_opmutp() {
		return ((String) getAttrVal("Id_opmutp"));
	}	
	/**
	 * 包装单位门诊取整模式
	 * @param Id_opmutp
	 */
	public void setId_opmutp(String Id_opmutp) {
		setAttrVal("Id_opmutp", Id_opmutp);
	}
	/**
	 * 包装单位门诊取整模式编码
	 * @return String
	 */
	public String getSd_opmutp() {
		return ((String) getAttrVal("Sd_opmutp"));
	}	
	/**
	 * 包装单位门诊取整模式编码
	 * @param Sd_opmutp
	 */
	public void setSd_opmutp(String Sd_opmutp) {
		setAttrVal("Sd_opmutp", Sd_opmutp);
	}
	/**
	 * 包装单位急诊流水取整模式
	 * @return String
	 */
	public String getId_ermutp() {
		return ((String) getAttrVal("Id_ermutp"));
	}	
	/**
	 * 包装单位急诊流水取整模式
	 * @param Id_ermutp
	 */
	public void setId_ermutp(String Id_ermutp) {
		setAttrVal("Id_ermutp", Id_ermutp);
	}
	/**
	 * 包装单位急诊流水取整模式编码
	 * @return String
	 */
	public String getSd_ermutp() {
		return ((String) getAttrVal("Sd_ermutp"));
	}	
	/**
	 * 包装单位急诊流水取整模式编码
	 * @param Sd_ermutp
	 */
	public void setSd_ermutp(String Sd_ermutp) {
		setAttrVal("Sd_ermutp", Sd_ermutp);
	}
	/**
	 * 包装单位急诊抢救取整模式
	 * @return String
	 */
	public String getId_er1mutp() {
		return ((String) getAttrVal("Id_er1mutp"));
	}	
	/**
	 * 包装单位急诊抢救取整模式
	 * @param Id_er1mutp
	 */
	public void setId_er1mutp(String Id_er1mutp) {
		setAttrVal("Id_er1mutp", Id_er1mutp);
	}
	/**
	 * 包装单位急诊抢救取整模式编码
	 * @return String
	 */
	public String getSd_er1mutp() {
		return ((String) getAttrVal("Sd_er1mutp"));
	}	
	/**
	 * 包装单位急诊抢救取整模式编码
	 * @param Sd_er1mutp
	 */
	public void setSd_er1mutp(String Sd_er1mutp) {
		setAttrVal("Sd_er1mutp", Sd_er1mutp);
	}
	/**
	 * 包装单位急诊留观取整模式
	 * @return String
	 */
	public String getId_er2mutp() {
		return ((String) getAttrVal("Id_er2mutp"));
	}	
	/**
	 * 包装单位急诊留观取整模式
	 * @param Id_er2mutp
	 */
	public void setId_er2mutp(String Id_er2mutp) {
		setAttrVal("Id_er2mutp", Id_er2mutp);
	}
	/**
	 * 包装单位急诊留观取整模式编码
	 * @return String
	 */
	public String getSd_er2mutp() {
		return ((String) getAttrVal("Sd_er2mutp"));
	}	
	/**
	 * 包装单位急诊留观取整模式编码
	 * @param Sd_er2mutp
	 */
	public void setSd_er2mutp(String Sd_er2mutp) {
		setAttrVal("Sd_er2mutp", Sd_er2mutp);
	}
	/**
	 * 物品有效期限
	 * @return Integer
	 */
	public Integer getValid_cn() {
		return ((Integer) getAttrVal("Valid_cn"));
	}	
	/**
	 * 物品有效期限
	 * @param Valid_cn
	 */
	public void setValid_cn(Integer Valid_cn) {
		setAttrVal("Valid_cn", Valid_cn);
	}
	/**
	 * 有效期限单位
	 * @return String
	 */
	public String getId_validu() {
		return ((String) getAttrVal("Id_validu"));
	}	
	/**
	 * 有效期限单位
	 * @param Id_validu
	 */
	public void setId_validu(String Id_validu) {
		setAttrVal("Id_validu", Id_validu);
	}
	/**
	 * 有效期限单位编码
	 * @return String
	 */
	public String getSd_validu() {
		return ((String) getAttrVal("Sd_validu"));
	}	
	/**
	 * 有效期限单位编码
	 * @param Sd_validu
	 */
	public void setSd_validu(String Sd_validu) {
		setAttrVal("Sd_validu", Sd_validu);
	}
	/**
	 * 售价管理模式
	 * @return String
	 */
	public String getId_pap() {
		return ((String) getAttrVal("Id_pap"));
	}	
	/**
	 * 售价管理模式
	 * @param Id_pap
	 */
	public void setId_pap(String Id_pap) {
		setAttrVal("Id_pap", Id_pap);
	}
	/**
	 * 售价管理模式编码
	 * @return String
	 */
	public String getSd_pap() {
		return ((String) getAttrVal("Sd_pap"));
	}	
	/**
	 * 售价管理模式编码
	 * @param Sd_pap
	 */
	public void setSd_pap(String Sd_pap) {
		setAttrVal("Sd_pap", Sd_pap);
	}
	/**
	 * 本物品计算加成率
	 * @return FDouble
	 */
	public FDouble getRate_pap() {
		return ((FDouble) getAttrVal("Rate_pap"));
	}	
	/**
	 * 本物品计算加成率
	 * @param Rate_pap
	 */
	public void setRate_pap(FDouble Rate_pap) {
		setAttrVal("Rate_pap", Rate_pap);
	}
	/**
	 * 重量单位
	 * @return String
	 */
	public String getId_unit_weight() {
		return ((String) getAttrVal("Id_unit_weight"));
	}	
	/**
	 * 重量单位
	 * @param Id_unit_weight
	 */
	public void setId_unit_weight(String Id_unit_weight) {
		setAttrVal("Id_unit_weight", Id_unit_weight);
	}
	/**
	 * 重量
	 * @return FDouble
	 */
	public FDouble getFactor_wb() {
		return ((FDouble) getAttrVal("Factor_wb"));
	}	
	/**
	 * 重量
	 * @param Factor_wb
	 */
	public void setFactor_wb(FDouble Factor_wb) {
		setAttrVal("Factor_wb", Factor_wb);
	}
	/**
	 * 基本体积单位
	 * @return String
	 */
	public String getId_unit_volbase() {
		return ((String) getAttrVal("Id_unit_volbase"));
	}	
	/**
	 * 基本体积单位
	 * @param Id_unit_volbase
	 */
	public void setId_unit_volbase(String Id_unit_volbase) {
		setAttrVal("Id_unit_volbase", Id_unit_volbase);
	}
	/**
	 * 换算系数_体基
	 * @return FDouble
	 */
	public FDouble getFactor_vb() {
		return ((FDouble) getAttrVal("Factor_vb"));
	}	
	/**
	 * 换算系数_体基
	 * @param Factor_vb
	 */
	public void setFactor_vb(FDouble Factor_vb) {
		setAttrVal("Factor_vb", Factor_vb);
	}
	/**
	 * 皮试标志
	 * @return FBoolean
	 */
	public FBoolean getFg_skin() {
		return ((FBoolean) getAttrVal("Fg_skin"));
	}	
	/**
	 * 皮试标志
	 * @param Fg_skin
	 */
	public void setFg_skin(FBoolean Fg_skin) {
		setAttrVal("Fg_skin", Fg_skin);
	}
	/**
	 * 皮试类型
	 * @return String
	 */
	public String getId_skinca() {
		return ((String) getAttrVal("Id_skinca"));
	}	
	/**
	 * 皮试类型
	 * @param Id_skinca
	 */
	public void setId_skinca(String Id_skinca) {
		setAttrVal("Id_skinca", Id_skinca);
	}
	/**
	 * 皮试类型编码
	 * @return String
	 */
	public String getSd_skinca() {
		return ((String) getAttrVal("Sd_skinca"));
	}	
	/**
	 * 皮试类型编码
	 * @param Sd_skinca
	 */
	public void setSd_skinca(String Sd_skinca) {
		setAttrVal("Sd_skinca", Sd_skinca);
	}
	/**
	 * 皮试项目
	 * @return String
	 */
	public String getId_srvskin() {
		return ((String) getAttrVal("Id_srvskin"));
	}	
	/**
	 * 皮试项目
	 * @param Id_srvskin
	 */
	public void setId_srvskin(String Id_srvskin) {
		setAttrVal("Id_srvskin", Id_srvskin);
	}
	/**
	 * 皮试药品
	 * @return String
	 */
	public String getId_mmskin() {
		return ((String) getAttrVal("Id_mmskin"));
	}	
	/**
	 * 皮试药品
	 * @param Id_mmskin
	 */
	public void setId_mmskin(String Id_mmskin) {
		setAttrVal("Id_mmskin", Id_mmskin);
	}
	/**
	 * 患者使用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pat() {
		return ((FBoolean) getAttrVal("Fg_pat"));
	}	
	/**
	 * 患者使用标志
	 * @param Fg_pat
	 */
	public void setFg_pat(FBoolean Fg_pat) {
		setAttrVal("Fg_pat", Fg_pat);
	}
	/**
	 * 默认物品出库方式
	 * @return String
	 */
	public String getId_outmode() {
		return ((String) getAttrVal("Id_outmode"));
	}	
	/**
	 * 默认物品出库方式
	 * @param Id_outmode
	 */
	public void setId_outmode(String Id_outmode) {
		setAttrVal("Id_outmode", Id_outmode);
	}
	/**
	 * 默认物品出库方式编码
	 * @return String
	 */
	public String getSd_outmode() {
		return ((String) getAttrVal("Sd_outmode"));
	}	
	/**
	 * 默认物品出库方式编码
	 * @param Sd_outmode
	 */
	public void setSd_outmode(String Sd_outmode) {
		setAttrVal("Sd_outmode", Sd_outmode);
	}
	/**
	 * 是否批次管理
	 * @return FBoolean
	 */
	public FBoolean getFg_batch() {
		return ((FBoolean) getAttrVal("Fg_batch"));
	}	
	/**
	 * 是否批次管理
	 * @param Fg_batch
	 */
	public void setFg_batch(FBoolean Fg_batch) {
		setAttrVal("Fg_batch", Fg_batch);
	}
	/**
	 * 是否价格管理
	 * @return FBoolean
	 */
	public FBoolean getFg_price() {
		return ((FBoolean) getAttrVal("Fg_price"));
	}	
	/**
	 * 是否价格管理
	 * @param Fg_price
	 */
	public void setFg_price(FBoolean Fg_price) {
		setAttrVal("Fg_price", Fg_price);
	}
	/**
	 * 收费出库标识
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}	
	/**
	 * 收费出库标识
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * OTC标志
	 * @return FBoolean
	 */
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}	
	/**
	 * OTC标志
	 * @param Fg_otc
	 */
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	/**
	 * 产地
	 * @return String
	 */
	public String getPlace() {
		return ((String) getAttrVal("Place"));
	}	
	/**
	 * 产地
	 * @param Place
	 */
	public void setPlace(String Place) {
		setAttrVal("Place", Place);
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
	 * 药品剂型
	 * @return String
	 */
	public String getDosage_name() {
		return ((String) getAttrVal("Dosage_name"));
	}	
	/**
	 * 药品剂型
	 * @param Dosage_name
	 */
	public void setDosage_name(String Dosage_name) {
		setAttrVal("Dosage_name", Dosage_name);
	}
	/**
	 * 毒麻分类
	 * @return String
	 */
	public String getPois_cname() {
		return ((String) getAttrVal("Pois_cname"));
	}	
	/**
	 * 毒麻分类
	 * @param Pois_cname
	 */
	public void setPois_cname(String Pois_cname) {
		setAttrVal("Pois_cname", Pois_cname);
	}
	/**
	 * 抗菌药分类
	 * @return String
	 */
	public String getAnti_name() {
		return ((String) getAttrVal("Anti_name"));
	}	
	/**
	 * 抗菌药分类
	 * @param Anti_name
	 */
	public void setAnti_name(String Anti_name) {
		setAttrVal("Anti_name", Anti_name);
	}
	/**
	 * 打印名称
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}	
	/**
	 * 打印名称
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
	}
	/**
	 * 英文名称
	 * @return String
	 */
	public String getEngname() {
		return ((String) getAttrVal("Engname"));
	}	
	/**
	 * 英文名称
	 * @param Engname
	 */
	public void setEngname(String Engname) {
		setAttrVal("Engname", Engname);
	}
	/**
	 * GMP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_gmp() {
		return ((FBoolean) getAttrVal("Fg_gmp"));
	}	
	/**
	 * GMP标识
	 * @param Fg_gmp
	 */
	public void setFg_gmp(FBoolean Fg_gmp) {
		setAttrVal("Fg_gmp", Fg_gmp);
	}
	/**
	 * 基本药物标识(废弃)
	 * @return FBoolean
	 */
	public FBoolean getFg_essdg() {
		return ((FBoolean) getAttrVal("Fg_essdg"));
	}	
	/**
	 * 基本药物标识(废弃)
	 * @param Fg_essdg
	 */
	public void setFg_essdg(FBoolean Fg_essdg) {
		setAttrVal("Fg_essdg", Fg_essdg);
	}
	/**
	 * 批次混发标识
	 * @return FBoolean
	 */
	public FBoolean getFg_batchmix() {
		return ((FBoolean) getAttrVal("Fg_batchmix"));
	}	
	/**
	 * 批次混发标识
	 * @param Fg_batchmix
	 */
	public void setFg_batchmix(FBoolean Fg_batchmix) {
		setAttrVal("Fg_batchmix", Fg_batchmix);
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
	 * 默认剂量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	/**
	 * 默认剂量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
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
	 * 家床可使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_use_fm() {
		return ((FBoolean) getAttrVal("Fg_use_fm"));
	}	
	/**
	 * 家床可使用标识
	 * @param Fg_use_fm
	 */
	public void setFg_use_fm(FBoolean Fg_use_fm) {
		setAttrVal("Fg_use_fm", Fg_use_fm);
	}
	/**
	 * 基本药物范围
	 * @return String
	 */
	public String getId_basedrugrange() {
		return ((String) getAttrVal("Id_basedrugrange"));
	}	
	/**
	 * 基本药物范围
	 * @param Id_basedrugrange
	 */
	public void setId_basedrugrange(String Id_basedrugrange) {
		setAttrVal("Id_basedrugrange", Id_basedrugrange);
	}
	/**
	 * 基本药物范围编码
	 * @return String
	 */
	public String getSd_basedrugrange() {
		return ((String) getAttrVal("Sd_basedrugrange"));
	}	
	/**
	 * 基本药物范围编码
	 * @param Sd_basedrugrange
	 */
	public void setSd_basedrugrange(String Sd_basedrugrange) {
		setAttrVal("Sd_basedrugrange", Sd_basedrugrange);
	}
	/**
	 * OA请领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_oa_applyreceive() {
		return ((FBoolean) getAttrVal("Fg_oa_applyreceive"));
	}	
	/**
	 * OA请领标识
	 * @param Fg_oa_applyreceive
	 */
	public void setFg_oa_applyreceive(FBoolean Fg_oa_applyreceive) {
		setAttrVal("Fg_oa_applyreceive", Fg_oa_applyreceive);
	}
	/**
	 * 用药最大天数
	 * @return Integer
	 */
	public Integer getUsedrug_num() {
		return ((Integer) getAttrVal("Usedrug_num"));
	}	
	/**
	 * 用药最大天数
	 * @param Usedrug_num
	 */
	public void setUsedrug_num(Integer Usedrug_num) {
		setAttrVal("Usedrug_num", Usedrug_num);
	}
	/**
	 * 储存条件串
	 * @return String
	 */
	public String getId_storeconds() {
		return ((String) getAttrVal("Id_storeconds"));
	}	
	/**
	 * 储存条件串
	 * @param Id_storeconds
	 */
	public void setId_storeconds(String Id_storeconds) {
		setAttrVal("Id_storeconds", Id_storeconds);
	}
	/**
	 * 储存条件编码串
	 * @return String
	 */
	public String getSd_storeconds() {
		return ((String) getAttrVal("Sd_storeconds"));
	}	
	/**
	 * 储存条件编码串
	 * @param Sd_storeconds
	 */
	public void setSd_storeconds(String Sd_storeconds) {
		setAttrVal("Sd_storeconds", Sd_storeconds);
	}
	/**
	 * 草药制剂类型
	 * @return String
	 */
	public String getId_herbpreparationtp() {
		return ((String) getAttrVal("Id_herbpreparationtp"));
	}	
	/**
	 * 草药制剂类型
	 * @param Id_herbpreparationtp
	 */
	public void setId_herbpreparationtp(String Id_herbpreparationtp) {
		setAttrVal("Id_herbpreparationtp", Id_herbpreparationtp);
	}
	/**
	 * 草药制剂类型编码
	 * @return String
	 */
	public String getSd_herbpreparationtp() {
		return ((String) getAttrVal("Sd_herbpreparationtp"));
	}	
	/**
	 * 草药制剂类型编码
	 * @param Sd_herbpreparationtp
	 */
	public void setSd_herbpreparationtp(String Sd_herbpreparationtp) {
		setAttrVal("Sd_herbpreparationtp", Sd_herbpreparationtp);
	}
	/**
	 * 是否效期管理
	 * @return FBoolean
	 */
	public FBoolean getFg_effective() {
		return ((FBoolean) getAttrVal("Fg_effective"));
	}	
	/**
	 * 是否效期管理
	 * @param Fg_effective
	 */
	public void setFg_effective(FBoolean Fg_effective) {
		setAttrVal("Fg_effective", Fg_effective);
	}
	/**
	 * 医院ddd值
	 * @return FDouble
	 */
	public FDouble getDdd2() {
		return ((FDouble) getAttrVal("Ddd2"));
	}	
	/**
	 * 医院ddd值
	 * @param Ddd2
	 */
	public void setDdd2(FDouble Ddd2) {
		setAttrVal("Ddd2", Ddd2);
	}
	/**
	 * 医院ddd单位
	 * @return String
	 */
	public String getId_unit_ddd2() {
		return ((String) getAttrVal("Id_unit_ddd2"));
	}	
	/**
	 * 医院ddd单位
	 * @param Id_unit_ddd2
	 */
	public void setId_unit_ddd2(String Id_unit_ddd2) {
		setAttrVal("Id_unit_ddd2", Id_unit_ddd2);
	}
	/**
	 * 监管编码
	 * @return String
	 */
	public String getCode_regu() {
		return ((String) getAttrVal("Code_regu"));
	}	
	/**
	 * 监管编码
	 * @param Code_regu
	 */
	public void setCode_regu(String Code_regu) {
		setAttrVal("Code_regu", Code_regu);
	}
	/**
	 * 药品本位码
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}	
	/**
	 * 药品本位码
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
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
	 * 辅助用药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_assis() {
		return ((FBoolean) getAttrVal("Fg_assis"));
	}	
	/**
	 * 辅助用药标志
	 * @param Fg_assis
	 */
	public void setFg_assis(FBoolean Fg_assis) {
		setAttrVal("Fg_assis", Fg_assis);
	}
	/**
	 * 中标药品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bid() {
		return ((FBoolean) getAttrVal("Fg_bid"));
	}	
	/**
	 * 中标药品标志
	 * @param Fg_bid
	 */
	public void setFg_bid(FBoolean Fg_bid) {
		setAttrVal("Fg_bid", Fg_bid);
	}
	/**
	 * 对应价表
	 * @return String
	 */
	public String getId_srvpri() {
		return ((String) getAttrVal("Id_srvpri"));
	}	
	/**
	 * 对应价表
	 * @param Id_srvpri
	 */
	public void setId_srvpri(String Id_srvpri) {
		setAttrVal("Id_srvpri", Id_srvpri);
	}
	/**
	 * 重点监控标志
	 * @return FBoolean
	 */
	public FBoolean getFg_keymonitor() {
		return ((FBoolean) getAttrVal("Fg_keymonitor"));
	}	
	/**
	 * 重点监控标志
	 * @param Fg_keymonitor
	 */
	public void setFg_keymonitor(FBoolean Fg_keymonitor) {
		setAttrVal("Fg_keymonitor", Fg_keymonitor);
	}
	/**
	 * 是否可收费
	 * @return FBoolean
	 */
	public FBoolean getFg_chargeable() {
		return ((FBoolean) getAttrVal("Fg_chargeable"));
	}	
	/**
	 * 是否可收费
	 * @param Fg_chargeable
	 */
	public void setFg_chargeable(FBoolean Fg_chargeable) {
		setAttrVal("Fg_chargeable", Fg_chargeable);
	}
	/**
	 * 耗材存储条件
	 * @return String
	 */
	public String getId_stor_con() {
		return ((String) getAttrVal("Id_stor_con"));
	}	
	/**
	 * 耗材存储条件
	 * @param Id_stor_con
	 */
	public void setId_stor_con(String Id_stor_con) {
		setAttrVal("Id_stor_con", Id_stor_con);
	}
	/**
	 * 耗材存储条件编码
	 * @return String
	 */
	public String getSd_stor_con() {
		return ((String) getAttrVal("Sd_stor_con"));
	}	
	/**
	 * 耗材存储条件编码
	 * @param Sd_stor_con
	 */
	public void setSd_stor_con(String Sd_stor_con) {
		setAttrVal("Sd_stor_con", Sd_stor_con);
	}
	/**
	 * 采购计划停用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_stop_mmpo() {
		return ((FBoolean) getAttrVal("Fg_stop_mmpo"));
	}	
	/**
	 * 采购计划停用标志
	 * @param Fg_stop_mmpo
	 */
	public void setFg_stop_mmpo(FBoolean Fg_stop_mmpo) {
		setAttrVal("Fg_stop_mmpo", Fg_stop_mmpo);
	}
	/**
	 * 调拨单停用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_stop_mmtr() {
		return ((FBoolean) getAttrVal("Fg_stop_mmtr"));
	}	
	/**
	 * 调拨单停用标志
	 * @param Fg_stop_mmtr
	 */
	public void setFg_stop_mmtr(FBoolean Fg_stop_mmtr) {
		setAttrVal("Fg_stop_mmtr", Fg_stop_mmtr);
	}
	/**
	 * 物品分组名称
	 * @return String
	 */
	public String getMmgrp_name() {
		return ((String) getAttrVal("Mmgrp_name"));
	}	
	/**
	 * 物品分组名称
	 * @param Mmgrp_name
	 */
	public void setMmgrp_name(String Mmgrp_name) {
		setAttrVal("Mmgrp_name", Mmgrp_name);
	}
	/**
	 * 库存分类
	 * @return String
	 */
	public String getId_stca() {
		return ((String) getAttrVal("Id_stca"));
	}	
	/**
	 * 库存分类
	 * @param Id_stca
	 */
	public void setId_stca(String Id_stca) {
		setAttrVal("Id_stca", Id_stca);
	}
	/**
	 * 库存分类编码
	 * @return String
	 */
	public String getSd_stca() {
		return ((String) getAttrVal("Sd_stca"));
	}	
	/**
	 * 库存分类编码
	 * @param Sd_stca
	 */
	public void setSd_stca(String Sd_stca) {
		setAttrVal("Sd_stca", Sd_stca);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 集团名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 物品类型名称
	 * @return String
	 */
	public String getMmtp_name() {
		return ((String) getAttrVal("Mmtp_name"));
	}	
	/**
	 * 物品类型名称
	 * @param Mmtp_name
	 */
	public void setMmtp_name(String Mmtp_name) {
		setAttrVal("Mmtp_name", Mmtp_name);
	}
	/**
	 * 基本分类名称
	 * @return String
	 */
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	/**
	 * 基本分类名称
	 * @param Mmca_name
	 */
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	/**
	 * 物品分类编码
	 * @return String
	 */
	public String getMmca_code() {
		return ((String) getAttrVal("Mmca_code"));
	}	
	/**
	 * 物品分类编码
	 * @param Mmca_code
	 */
	public void setMmca_code(String Mmca_code) {
		setAttrVal("Mmca_code", Mmca_code);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getPkgbase_name() {
		return ((String) getAttrVal("Pkgbase_name"));
	}	
	/**
	 * 基本包装单位名称
	 * @param Pkgbase_name
	 */
	public void setPkgbase_name(String Pkgbase_name) {
		setAttrVal("Pkgbase_name", Pkgbase_name);
	}
	/**
	 * 基本包装单位编码
	 * @return String
	 */
	public String getPkgbase_code() {
		return ((String) getAttrVal("Pkgbase_code"));
	}	
	/**
	 * 基本包装单位编码
	 * @param Pkgbase_code
	 */
	public void setPkgbase_code(String Pkgbase_code) {
		setAttrVal("Pkgbase_code", Pkgbase_code);
	}
	/**
	 * 零售包装单位名称
	 * @return String
	 */
	public String getPkgsp_name() {
		return ((String) getAttrVal("Pkgsp_name"));
	}	
	/**
	 * 零售包装单位名称
	 * @param Pkgsp_name
	 */
	public void setPkgsp_name(String Pkgsp_name) {
		setAttrVal("Pkgsp_name", Pkgsp_name);
	}
	/**
	 * 零售包装单位编码
	 * @return String
	 */
	public String getPkgsp_code() {
		return ((String) getAttrVal("Pkgsp_code"));
	}	
	/**
	 * 零售包装单位编码
	 * @param Pkgsp_code
	 */
	public void setPkgsp_code(String Pkgsp_code) {
		setAttrVal("Pkgsp_code", Pkgsp_code);
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
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getSrv_id_unit_med() {
		return ((String) getAttrVal("Srv_id_unit_med"));
	}	
	/**
	 * 医学单位
	 * @param Srv_id_unit_med
	 */
	public void setSrv_id_unit_med(String Srv_id_unit_med) {
		setAttrVal("Srv_id_unit_med", Srv_id_unit_med);
	}
	/**
	 * ddd值计量单位编码
	 * @return String
	 */
	public String getDddunit_code() {
		return ((String) getAttrVal("Dddunit_code"));
	}	
	/**
	 * ddd值计量单位编码
	 * @param Dddunit_code
	 */
	public void setDddunit_code(String Dddunit_code) {
		setAttrVal("Dddunit_code", Dddunit_code);
	}
	/**
	 * ddd值计量单位名称
	 * @return String
	 */
	public String getDddunit_name() {
		return ((String) getAttrVal("Dddunit_name"));
	}	
	/**
	 * ddd值计量单位名称
	 * @param Dddunit_name
	 */
	public void setDddunit_name(String Dddunit_name) {
		setAttrVal("Dddunit_name", Dddunit_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPrimode_name() {
		return ((String) getAttrVal("Primode_name"));
	}	
	/**
	 * 名称
	 * @param Primode_name
	 */
	public void setPrimode_name(String Primode_name) {
		setAttrVal("Primode_name", Primode_name);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Factory_name
	 */
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
	}
	/**
	 * 进口分类名称
	 * @return String
	 */
	public String getAbrd_name() {
		return ((String) getAttrVal("Abrd_name"));
	}	
	/**
	 * 进口分类名称
	 * @param Abrd_name
	 */
	public void setAbrd_name(String Abrd_name) {
		setAttrVal("Abrd_name", Abrd_name);
	}
	/**
	 * 价值分类名称
	 * @return String
	 */
	public String getVal_name() {
		return ((String) getAttrVal("Val_name"));
	}	
	/**
	 * 价值分类名称
	 * @param Val_name
	 */
	public void setVal_name(String Val_name) {
		setAttrVal("Val_name", Val_name);
	}
	/**
	 * 预住院取整模式名称
	 * @return String
	 */
	public String getName_pipmutp() {
		return ((String) getAttrVal("Name_pipmutp"));
	}	
	/**
	 * 预住院取整模式名称
	 * @param Name_pipmutp
	 */
	public void setName_pipmutp(String Name_pipmutp) {
		setAttrVal("Name_pipmutp", Name_pipmutp);
	}
	/**
	 * 包装单位取整模式名称
	 * @return String
	 */
	public String getMupkgutp_name() {
		return ((String) getAttrVal("Mupkgutp_name"));
	}	
	/**
	 * 包装单位取整模式名称
	 * @param Mupkgutp_name
	 */
	public void setMupkgutp_name(String Mupkgutp_name) {
		setAttrVal("Mupkgutp_name", Mupkgutp_name);
	}
	/**
	 * 包装单位门诊取整模式
	 * @return String
	 */
	public String getOpmutp_name() {
		return ((String) getAttrVal("Opmutp_name"));
	}	
	/**
	 * 包装单位门诊取整模式
	 * @param Opmutp_name
	 */
	public void setOpmutp_name(String Opmutp_name) {
		setAttrVal("Opmutp_name", Opmutp_name);
	}
	/**
	 * 包装单位急诊流水取整模式名称
	 * @return String
	 */
	public String getErmutp_name() {
		return ((String) getAttrVal("Ermutp_name"));
	}	
	/**
	 * 包装单位急诊流水取整模式名称
	 * @param Ermutp_name
	 */
	public void setErmutp_name(String Ermutp_name) {
		setAttrVal("Ermutp_name", Ermutp_name);
	}
	/**
	 * 包装单位急诊流水取整模编码
	 * @return String
	 */
	public String getErmutp_code() {
		return ((String) getAttrVal("Ermutp_code"));
	}	
	/**
	 * 包装单位急诊流水取整模编码
	 * @param Ermutp_code
	 */
	public void setErmutp_code(String Ermutp_code) {
		setAttrVal("Ermutp_code", Ermutp_code);
	}
	/**
	 * 包装单位急诊抢救取整模式名称
	 * @return String
	 */
	public String getEr1mutp_name() {
		return ((String) getAttrVal("Er1mutp_name"));
	}	
	/**
	 * 包装单位急诊抢救取整模式名称
	 * @param Er1mutp_name
	 */
	public void setEr1mutp_name(String Er1mutp_name) {
		setAttrVal("Er1mutp_name", Er1mutp_name);
	}
	/**
	 * 包装单位急诊抢救取整模式编码
	 * @return String
	 */
	public String getEr1mutp_code() {
		return ((String) getAttrVal("Er1mutp_code"));
	}	
	/**
	 * 包装单位急诊抢救取整模式编码
	 * @param Er1mutp_code
	 */
	public void setEr1mutp_code(String Er1mutp_code) {
		setAttrVal("Er1mutp_code", Er1mutp_code);
	}
	/**
	 * 包装单位急诊留观取整模式名称
	 * @return String
	 */
	public String getEr2mutp_name() {
		return ((String) getAttrVal("Er2mutp_name"));
	}	
	/**
	 * 包装单位急诊留观取整模式名称
	 * @param Er2mutp_name
	 */
	public void setEr2mutp_name(String Er2mutp_name) {
		setAttrVal("Er2mutp_name", Er2mutp_name);
	}
	/**
	 * 包装单位急诊留观取整模式编码
	 * @return String
	 */
	public String getEr2mutp_code() {
		return ((String) getAttrVal("Er2mutp_code"));
	}	
	/**
	 * 包装单位急诊留观取整模式编码
	 * @param Er2mutp_code
	 */
	public void setEr2mutp_code(String Er2mutp_code) {
		setAttrVal("Er2mutp_code", Er2mutp_code);
	}
	/**
	 * 有效期限名称
	 * @return String
	 */
	public String getValidu_name() {
		return ((String) getAttrVal("Validu_name"));
	}	
	/**
	 * 有效期限名称
	 * @param Validu_name
	 */
	public void setValidu_name(String Validu_name) {
		setAttrVal("Validu_name", Validu_name);
	}
	/**
	 * 加成计算率名称
	 * @return String
	 */
	public String getPap_name() {
		return ((String) getAttrVal("Pap_name"));
	}	
	/**
	 * 加成计算率名称
	 * @param Pap_name
	 */
	public void setPap_name(String Pap_name) {
		setAttrVal("Pap_name", Pap_name);
	}
	/**
	 * 重量单位编码
	 * @return String
	 */
	public String getWeight_code() {
		return ((String) getAttrVal("Weight_code"));
	}	
	/**
	 * 重量单位编码
	 * @param Weight_code
	 */
	public void setWeight_code(String Weight_code) {
		setAttrVal("Weight_code", Weight_code);
	}
	/**
	 * 重量单位名称
	 * @return String
	 */
	public String getWeight_name() {
		return ((String) getAttrVal("Weight_name"));
	}	
	/**
	 * 重量单位名称
	 * @param Weight_name
	 */
	public void setWeight_name(String Weight_name) {
		setAttrVal("Weight_name", Weight_name);
	}
	/**
	 * 体积单位名称
	 * @return String
	 */
	public String getVolbase_name() {
		return ((String) getAttrVal("Volbase_name"));
	}	
	/**
	 * 体积单位名称
	 * @param Volbase_name
	 */
	public void setVolbase_name(String Volbase_name) {
		setAttrVal("Volbase_name", Volbase_name);
	}
	/**
	 * 体积单位编码
	 * @return String
	 */
	public String getVolbase_code() {
		return ((String) getAttrVal("Volbase_code"));
	}	
	/**
	 * 体积单位编码
	 * @param Volbase_code
	 */
	public void setVolbase_code(String Volbase_code) {
		setAttrVal("Volbase_code", Volbase_code);
	}
	/**
	 * 皮试类型名称
	 * @return String
	 */
	public String getSkinca_name() {
		return ((String) getAttrVal("Skinca_name"));
	}	
	/**
	 * 皮试类型名称
	 * @param Skinca_name
	 */
	public void setSkinca_name(String Skinca_name) {
		setAttrVal("Skinca_name", Skinca_name);
	}
	/**
	 * 皮试项目名称
	 * @return String
	 */
	public String getSrvskin_name() {
		return ((String) getAttrVal("Srvskin_name"));
	}	
	/**
	 * 皮试项目名称
	 * @param Srvskin_name
	 */
	public void setSrvskin_name(String Srvskin_name) {
		setAttrVal("Srvskin_name", Srvskin_name);
	}
	/**
	 * 皮试项目编码
	 * @return String
	 */
	public String getSrvskin_code() {
		return ((String) getAttrVal("Srvskin_code"));
	}	
	/**
	 * 皮试项目编码
	 * @param Srvskin_code
	 */
	public void setSrvskin_code(String Srvskin_code) {
		setAttrVal("Srvskin_code", Srvskin_code);
	}
	/**
	 * 皮试物品编码
	 * @return String
	 */
	public String getMmskin_code() {
		return ((String) getAttrVal("Mmskin_code"));
	}	
	/**
	 * 皮试物品编码
	 * @param Mmskin_code
	 */
	public void setMmskin_code(String Mmskin_code) {
		setAttrVal("Mmskin_code", Mmskin_code);
	}
	/**
	 * 皮试物品名称
	 * @return String
	 */
	public String getMmskin_name() {
		return ((String) getAttrVal("Mmskin_name"));
	}	
	/**
	 * 皮试物品名称
	 * @param Mmskin_name
	 */
	public void setMmskin_name(String Mmskin_name) {
		setAttrVal("Mmskin_name", Mmskin_name);
	}
	/**
	 * 出库方式名称
	 * @return String
	 */
	public String getOutmode_name() {
		return ((String) getAttrVal("Outmode_name"));
	}	
	/**
	 * 出库方式名称
	 * @param Outmode_name
	 */
	public void setOutmode_name(String Outmode_name) {
		setAttrVal("Outmode_name", Outmode_name);
	}
	/**
	 * 默认用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	/**
	 * 默认用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 默认用法编码
	 * @return String
	 */
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}	
	/**
	 * 默认用法编码
	 * @param Route_code
	 */
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
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
	 * 默认频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}	
	/**
	 * 默认频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 默认频次编码
	 * @return String
	 */
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}	
	/**
	 * 默认频次编码
	 * @param Freq_code
	 */
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
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
	 * 频次周期类型
	 * @return String
	 */
	public String getId_frequnitct() {
		return ((String) getAttrVal("Id_frequnitct"));
	}	
	/**
	 * 频次周期类型
	 * @param Id_frequnitct
	 */
	public void setId_frequnitct(String Id_frequnitct) {
		setAttrVal("Id_frequnitct", Id_frequnitct);
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
	 * 默认煎法编码
	 * @return String
	 */
	public String getBoil_code() {
		return ((String) getAttrVal("Boil_code"));
	}	
	/**
	 * 默认煎法编码
	 * @param Boil_code
	 */
	public void setBoil_code(String Boil_code) {
		setAttrVal("Boil_code", Boil_code);
	}
	/**
	 * 默认煎法名称
	 * @return String
	 */
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	/**
	 * 默认煎法名称
	 * @param Boil_name
	 */
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	/**
	 * 默认煎法要求编码
	 * @return String
	 */
	public String getBoildes_code() {
		return ((String) getAttrVal("Boildes_code"));
	}	
	/**
	 * 默认煎法要求编码
	 * @param Boildes_code
	 */
	public void setBoildes_code(String Boildes_code) {
		setAttrVal("Boildes_code", Boildes_code);
	}
	/**
	 * 默认煎法要求名称
	 * @return String
	 */
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	/**
	 * 默认煎法要求名称
	 * @param Boildes_name
	 */
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	/**
	 * 基本药物范围名称
	 * @return String
	 */
	public String getBasedrugrange_name() {
		return ((String) getAttrVal("Basedrugrange_name"));
	}	
	/**
	 * 基本药物范围名称
	 * @param Basedrugrange_name
	 */
	public void setBasedrugrange_name(String Basedrugrange_name) {
		setAttrVal("Basedrugrange_name", Basedrugrange_name);
	}
	/**
	 * 储存条件名称
	 * @return String
	 */
	public String getName_storeconds() {
		return ((String) getAttrVal("Name_storeconds"));
	}	
	/**
	 * 储存条件名称
	 * @param Name_storeconds
	 */
	public void setName_storeconds(String Name_storeconds) {
		setAttrVal("Name_storeconds", Name_storeconds);
	}
	/**
	 * 草药制剂类型名称
	 * @return String
	 */
	public String getHerbpreparationtp_name() {
		return ((String) getAttrVal("Herbpreparationtp_name"));
	}	
	/**
	 * 草药制剂类型名称
	 * @param Herbpreparationtp_name
	 */
	public void setHerbpreparationtp_name(String Herbpreparationtp_name) {
		setAttrVal("Herbpreparationtp_name", Herbpreparationtp_name);
	}
	/**
	 * 医院ddd单位名称
	 * @return String
	 */
	public String getName_ddd2() {
		return ((String) getAttrVal("Name_ddd2"));
	}	
	/**
	 * 医院ddd单位名称
	 * @param Name_ddd2
	 */
	public void setName_ddd2(String Name_ddd2) {
		setAttrVal("Name_ddd2", Name_ddd2);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getPri_name() {
		return ((String) getAttrVal("Pri_name"));
	}	
	/**
	 * 服务名称
	 * @param Pri_name
	 */
	public void setPri_name(String Pri_name) {
		setAttrVal("Pri_name", Pri_name);
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
	 * 名称
	 * @return String
	 */
	public String getName_stor_con() {
		return ((String) getAttrVal("Name_stor_con"));
	}	
	/**
	 * 名称
	 * @param Name_stor_con
	 */
	public void setName_stor_con(String Name_stor_con) {
		setAttrVal("Name_stor_con", Name_stor_con);
	}
	/**
	 * 库存分类名称
	 * @return String
	 */
	public String getStca_name() {
		return ((String) getAttrVal("Stca_name"));
	}	
	/**
	 * 库存分类名称
	 * @param Stca_name
	 */
	public void setStca_name(String Stca_name) {
		setAttrVal("Stca_name", Stca_name);
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
		return "Id_mm";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MeterialDODesc.class);
	}
	
}