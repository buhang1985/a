package iih.ci.ord.ordsrvmm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import java.math.BigDecimal;

/**
 * 医嘱服务项目物品 DO数据 
 * 
 */
public class OrdSrvMmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱服务物品主键标识
	public static final String ID_ORSRVMM= "Id_orsrvmm";
	//医嘱服务项目
	public static final String ID_ORSRV= "Id_orsrv";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//物品编码
	public static final String CODE_MM= "Code_mm";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//当前包装单位
	public static final String ID_PGKU_CUR= "Id_pgku_cur";
	//参考价_当前包装
	public static final String PRICE_PGKU_CUR= "Price_pgku_cur";
	//总量_当前包装
	public static final String QUAN_CUR= "Quan_cur";
	//基本包装单位
	public static final String ID_PGKU_BASE= "Id_pgku_base";
	//单次数量_分子
	public static final String QUAN_NUM_BASE= "Quan_num_base";
	//单次数量_分母
	public static final String QUAN_DEN_BASE= "Quan_den_base";
	//床边剩余量_医学单位
	public static final String QUAN_BED_MEDU= "Quan_bed_medu";
	//换算系数
	public static final String FACTOR= "Factor";
	//换算系数_医疗基本
	public static final String FACTOR_MB= "Factor_mb";
	//药品剂型
	public static final String ID_DOSAGE= "Id_dosage";
	//药品剂型编码
	public static final String SD_DOSAGE= "Sd_dosage";
	//药理分类
	public static final String ID_PHARM= "Id_pharm";
	//药理分类编码
	public static final String SD_PHARM= "Sd_pharm";
	//价值分类
	public static final String ID_VAL= "Id_val";
	//价值分类编码
	public static final String SD_VAL= "Sd_val";
	//毒麻分类
	public static final String ID_POIS= "Id_pois";
	//毒麻分类编码
	public static final String SD_POIS= "Sd_pois";
	//抗菌药分类
	public static final String ID_ANTI= "Id_anti";
	//抗菌药分类编码
	public static final String SD_ANTI= "Sd_anti";
	//物品类型
	public static final String ID_MMTP= "Id_mmtp";
	//物品类型编码
	public static final String SD_MMTP= "Sd_mmtp";
	//抗精神分类编码
	public static final String ID_ANTIPSY= "Id_antipsy";
	//抗精神分类
	public static final String SD_ANTIPSY= "Sd_antipsy";
	//OTC标识
	public static final String FG_OTC= "Fg_otc";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//床边余量_在途
	public static final String QUAN_BED_TRANSIT= "Quan_bed_transit";
	//领量可用天数（门诊用）
	public static final String DAYS_AVAILABLE= "Days_available";
	//包装单位取整模式
	public static final String ID_MUPKGUTP= "Id_mupkgutp";
	//包装单位取整模式编码
	public static final String SD_MUPKGUTP= "Sd_mupkgutp";
	//药品服务id
	public static final String ID_SRV= "Id_srv";
	//当前剂量
	public static final String QUAN_MEDU_CUR= "Quan_medu_cur";
	//当前剂量单位
	public static final String ID_MEDU_CUR= "Id_medu_cur";
	//当前剂量转换系数
	public static final String FACTOR_CUR= "Factor_cur";
	//物品规格
	public static final String SPEC= "Spec";
	//适应症
	public static final String INDICA= "Indica";
	//禁忌症
	public static final String CONSTR= "Constr";
	//不良反应
	public static final String REACT= "React";
	//草药制剂类型
	public static final String ID_HERBPREPARATIONTP= "Id_herbpreparationtp";
	//草药制剂类型编码(0饮片；1配方颗粒)
	public static final String SD_HERBPREPARATIONTP= "Sd_herbpreparationtp";
	//计量单位名称
	public static final String NAME_PGKU_CUR= "Name_pgku_cur";
	//基本计量单位名称
	public static final String NAME_PGKU_BASE= "Name_pgku_base";
	//编码
	public static final String DS_CODE= "Ds_code";
	//名称
	public static final String DS_NAME= "Ds_name";
	//编码
	public static final String PA_CODE= "Pa_code";
	//名称
	public static final String PA_NAME= "Pa_name";
	//编码
	public static final String VAL_CODE= "Val_code";
	//名称
	public static final String VAL_NAME= "Val_name";
	//编码
	public static final String POIS_CODE= "Pois_code";
	//名称
	public static final String POIS_NAME= "Pois_name";
	//编码
	public static final String ANTI_CODE= "Anti_code";
	//名称
	public static final String ANTI_NAME= "Anti_name";
	//当前剂量单位
	public static final String NAME_UNIT_CUR= "Name_unit_cur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱服务物品主键标识
	 * @return String
	 */
	public String getId_orsrvmm() {
		return ((String) getAttrVal("Id_orsrvmm"));
	}	
	/**
	 * 医嘱服务物品主键标识
	 * @param Id_orsrvmm
	 */
	public void setId_orsrvmm(String Id_orsrvmm) {
		setAttrVal("Id_orsrvmm", Id_orsrvmm);
	}
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 当前包装单位
	 * @return String
	 */
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}	
	/**
	 * 当前包装单位
	 * @param Id_pgku_cur
	 */
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	/**
	 * 参考价_当前包装
	 * @return FDouble
	 */
	public FDouble getPrice_pgku_cur() {
		return ((FDouble) getAttrVal("Price_pgku_cur"));
	}	
	/**
	 * 参考价_当前包装
	 * @param Price_pgku_cur
	 */
	public void setPrice_pgku_cur(FDouble Price_pgku_cur) {
		setAttrVal("Price_pgku_cur", Price_pgku_cur);
	}
	/**
	 * 总量_当前包装
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	/**
	 * 总量_当前包装
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_pgku_base() {
		return ((String) getAttrVal("Id_pgku_base"));
	}	
	/**
	 * 基本包装单位
	 * @param Id_pgku_base
	 */
	public void setId_pgku_base(String Id_pgku_base) {
		setAttrVal("Id_pgku_base", Id_pgku_base);
	}
	/**
	 * 单次数量_分子
	 * @return Integer
	 */
	public Integer getQuan_num_base() {
		return ((Integer) getAttrVal("Quan_num_base"));
	}	
	/**
	 * 单次数量_分子
	 * @param Quan_num_base
	 */
	public void setQuan_num_base(Integer Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	/**
	 * 单次数量_分母
	 * @return Integer
	 */
	public Integer getQuan_den_base() {
		return ((Integer) getAttrVal("Quan_den_base"));
	}	
	/**
	 * 单次数量_分母
	 * @param Quan_den_base
	 */
	public void setQuan_den_base(Integer Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	/**
	 * 床边剩余量_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_bed_medu() {
		return ((FDouble) getAttrVal("Quan_bed_medu"));
	}	
	/**
	 * 床边剩余量_医学单位
	 * @param Quan_bed_medu
	 */
	public void setQuan_bed_medu(FDouble Quan_bed_medu) {
		setAttrVal("Quan_bed_medu", Quan_bed_medu);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 换算系数_医疗基本
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	/**
	 * 换算系数_医疗基本
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
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
	 * 抗精神分类编码
	 * @return String
	 */
	public String getId_antipsy() {
		return ((String) getAttrVal("Id_antipsy"));
	}	
	/**
	 * 抗精神分类编码
	 * @param Id_antipsy
	 */
	public void setId_antipsy(String Id_antipsy) {
		setAttrVal("Id_antipsy", Id_antipsy);
	}
	/**
	 * 抗精神分类
	 * @return String
	 */
	public String getSd_antipsy() {
		return ((String) getAttrVal("Sd_antipsy"));
	}	
	/**
	 * 抗精神分类
	 * @param Sd_antipsy
	 */
	public void setSd_antipsy(String Sd_antipsy) {
		setAttrVal("Sd_antipsy", Sd_antipsy);
	}
	/**
	 * OTC标识
	 * @return FBoolean
	 */
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}	
	/**
	 * OTC标识
	 * @param Fg_otc
	 */
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
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
	 * 床边余量_在途
	 * @return FDouble
	 */
	public FDouble getQuan_bed_transit() {
		return ((FDouble) getAttrVal("Quan_bed_transit"));
	}	
	/**
	 * 床边余量_在途
	 * @param Quan_bed_transit
	 */
	public void setQuan_bed_transit(FDouble Quan_bed_transit) {
		setAttrVal("Quan_bed_transit", Quan_bed_transit);
	}
	/**
	 * 领量可用天数（门诊用）
	 * @return Integer
	 */
	public Integer getDays_available() {
		return ((Integer) getAttrVal("Days_available"));
	}	
	/**
	 * 领量可用天数（门诊用）
	 * @param Days_available
	 */
	public void setDays_available(Integer Days_available) {
		setAttrVal("Days_available", Days_available);
	}
	/**
	 * 包装单位取整模式
	 * @return String
	 */
	public String getId_mupkgutp() {
		return ((String) getAttrVal("Id_mupkgutp"));
	}	
	/**
	 * 包装单位取整模式
	 * @param Id_mupkgutp
	 */
	public void setId_mupkgutp(String Id_mupkgutp) {
		setAttrVal("Id_mupkgutp", Id_mupkgutp);
	}
	/**
	 * 包装单位取整模式编码
	 * @return String
	 */
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}	
	/**
	 * 包装单位取整模式编码
	 * @param Sd_mupkgutp
	 */
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}
	/**
	 * 药品服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 药品服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 当前剂量
	 * @return FDouble
	 */
	public FDouble getQuan_medu_cur() {
		return ((FDouble) getAttrVal("Quan_medu_cur"));
	}	
	/**
	 * 当前剂量
	 * @param Quan_medu_cur
	 */
	public void setQuan_medu_cur(FDouble Quan_medu_cur) {
		setAttrVal("Quan_medu_cur", Quan_medu_cur);
	}
	/**
	 * 当前剂量单位
	 * @return String
	 */
	public String getId_medu_cur() {
		return ((String) getAttrVal("Id_medu_cur"));
	}	
	/**
	 * 当前剂量单位
	 * @param Id_medu_cur
	 */
	public void setId_medu_cur(String Id_medu_cur) {
		setAttrVal("Id_medu_cur", Id_medu_cur);
	}
	/**
	 * 当前剂量转换系数
	 * @return String
	 */
	public String getFactor_cur() {
		return ((String) getAttrVal("Factor_cur"));
	}	
	/**
	 * 当前剂量转换系数
	 * @param Factor_cur
	 */
	public void setFactor_cur(String Factor_cur) {
		setAttrVal("Factor_cur", Factor_cur);
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
	 * 草药制剂类型编码(0饮片；1配方颗粒)
	 * @return String
	 */
	public String getSd_herbpreparationtp() {
		return ((String) getAttrVal("Sd_herbpreparationtp"));
	}	
	/**
	 * 草药制剂类型编码(0饮片；1配方颗粒)
	 * @param Sd_herbpreparationtp
	 */
	public void setSd_herbpreparationtp(String Sd_herbpreparationtp) {
		setAttrVal("Sd_herbpreparationtp", Sd_herbpreparationtp);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_pgku_cur() {
		return ((String) getAttrVal("Name_pgku_cur"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_pgku_cur
	 */
	public void setName_pgku_cur(String Name_pgku_cur) {
		setAttrVal("Name_pgku_cur", Name_pgku_cur);
	}
	/**
	 * 基本计量单位名称
	 * @return String
	 */
	public String getName_pgku_base() {
		return ((String) getAttrVal("Name_pgku_base"));
	}	
	/**
	 * 基本计量单位名称
	 * @param Name_pgku_base
	 */
	public void setName_pgku_base(String Name_pgku_base) {
		setAttrVal("Name_pgku_base", Name_pgku_base);
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
	 * 编码
	 * @return String
	 */
	public String getPa_code() {
		return ((String) getAttrVal("Pa_code"));
	}	
	/**
	 * 编码
	 * @param Pa_code
	 */
	public void setPa_code(String Pa_code) {
		setAttrVal("Pa_code", Pa_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPa_name() {
		return ((String) getAttrVal("Pa_name"));
	}	
	/**
	 * 名称
	 * @param Pa_name
	 */
	public void setPa_name(String Pa_name) {
		setAttrVal("Pa_name", Pa_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getVal_code() {
		return ((String) getAttrVal("Val_code"));
	}	
	/**
	 * 编码
	 * @param Val_code
	 */
	public void setVal_code(String Val_code) {
		setAttrVal("Val_code", Val_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getVal_name() {
		return ((String) getAttrVal("Val_name"));
	}	
	/**
	 * 名称
	 * @param Val_name
	 */
	public void setVal_name(String Val_name) {
		setAttrVal("Val_name", Val_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPois_code() {
		return ((String) getAttrVal("Pois_code"));
	}	
	/**
	 * 编码
	 * @param Pois_code
	 */
	public void setPois_code(String Pois_code) {
		setAttrVal("Pois_code", Pois_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPois_name() {
		return ((String) getAttrVal("Pois_name"));
	}	
	/**
	 * 名称
	 * @param Pois_name
	 */
	public void setPois_name(String Pois_name) {
		setAttrVal("Pois_name", Pois_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnti_code() {
		return ((String) getAttrVal("Anti_code"));
	}	
	/**
	 * 编码
	 * @param Anti_code
	 */
	public void setAnti_code(String Anti_code) {
		setAttrVal("Anti_code", Anti_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnti_name() {
		return ((String) getAttrVal("Anti_name"));
	}	
	/**
	 * 名称
	 * @param Anti_name
	 */
	public void setAnti_name(String Anti_name) {
		setAttrVal("Anti_name", Anti_name);
	}
	/**
	 * 当前剂量单位
	 * @return String
	 */
	public String getName_unit_cur() {
		return ((String) getAttrVal("Name_unit_cur"));
	}	
	/**
	 * 当前剂量单位
	 * @param Name_unit_cur
	 */
	public void setName_unit_cur(String Name_unit_cur) {
		setAttrVal("Name_unit_cur", Name_unit_cur);
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
		return "Id_orsrvmm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_srv_mm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdSrvMmDODesc.class);
	}
	
}