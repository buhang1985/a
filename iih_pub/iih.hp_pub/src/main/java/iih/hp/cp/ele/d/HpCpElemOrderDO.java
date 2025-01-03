package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemOrderDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_医嘱 DO数据 
 * 
 */
public class HpCpElemOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//元素医嘱ID
	public static final String ID_ELE_ORDER= "Id_ele_order";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//自定义服务标识
	public static final String FG_CTM= "Fg_ctm";
	//医疗服务类型ID
	public static final String ID_SRVTP= "Id_srvtp";
	//医疗服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//长临标志
	public static final String FG_LONG= "Fg_long";
	//给药标志
	public static final String ID_ROUTE= "Id_route";
	//单次剂量
	public static final String DOSAGE= "Dosage";
	//剂量单位
	public static final String ID_CUR= "Id_cur";
	//使用频次
	public static final String ID_FREQ= "Id_freq";
	//出院带药标识
	public static final String FG_PRES_OUTP= "Fg_pres_outp";
	//医疗物品
	public static final String ID_MM= "Id_mm";
	//物品编码
	public static final String CODE_MM= "Code_mm";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//在院整领
	public static final String FG_WHOLEPACK= "Fg_wholepack";
	//总量_当前包装
	public static final String QUAN_CUR= "Quan_cur";
	//总量单位ID_当前包装
	public static final String ID_UNIT_CUR= "Id_unit_cur";
	//领药方式ID
	public static final String ID_DRUG_DELIVERY_METHOD= "Id_drug_delivery_method";
	//领药方式SD
	public static final String SD_DRUG_DELIVERY_METHOD= "Sd_drug_delivery_method";
	//加急标志
	public static final String FG_URGENT= "Fg_urgent";
	//不计费类型id
	public static final String ID_NODISPENSE= "Id_nodispense";
	//不计费类型sd
	public static final String SD_NODISPENSE= "Sd_nodispense";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//物资药房
	public static final String ID_DEP_WH= "Id_dep_wh";
	//物品规格
	public static final String SPEC= "Spec";
	//嘱托内容
	public static final String DES_OR= "Des_or";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//医嘱天数
	public static final String DAYS_OR= "Days_or";
	//服务名称
	public static final String ID_SRV_NAME= "Id_srv_name";
	//名称
	public static final String ID_SRVTP_NAME= "Id_srvtp_name";
	//用法名称
	public static final String ID_ROUTE_NAME= "Id_route_name";
	//用法编码
	public static final String ID_ROUTE_CODE= "Id_route_code";
	//助记码
	public static final String ID_ROUTE_MNECODE= "Id_route_mnecode";
	//计量单位名称
	public static final String ID_CUR_NAME= "Id_cur_name";
	//计量单位编码
	public static final String ID_CUR_CODE= "Id_cur_code";
	//频次名称
	public static final String ID_FREQ_NAME= "Id_freq_name";
	//频次编码
	public static final String ID_FREQ_CODE= "Id_freq_code";
	//频次周期下次数
	public static final String FREQCT= "Freqct";
	//频次周期类型编码
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	//频次周期数
	public static final String FREQUNITCT= "Frequnitct";
	//备用医嘱标识
	public static final String FREQ_FG_PRNOR= "Freq_fg_prnor";
	//长临标识
	public static final String FREQ_FG_LONG= "Freq_fg_long";
	//计量单位名称
	public static final String NAME_UNIT_CUR= "Name_unit_cur";
	//名称
	public static final String NAME_DRUG_DELIVERY_METHOD= "Name_drug_delivery_method";
	//名称
	public static final String NAME_NODISPENSE= "Name_nodispense";
	//名称
	public static final String NAME_DEP_MP= "Name_dep_mp";
	//名称
	public static final String NAME_DEP_WH= "Name_dep_wh";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 元素医嘱ID
	 * @return String
	 */
	public String getId_ele_order() {
		return ((String) getAttrVal("Id_ele_order"));
	}	
	/**
	 * 元素医嘱ID
	 * @param Id_ele_order
	 */
	public void setId_ele_order(String Id_ele_order) {
		setAttrVal("Id_ele_order", Id_ele_order);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
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
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 自定义服务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ctm() {
		return ((FBoolean) getAttrVal("Fg_ctm"));
	}	
	/**
	 * 自定义服务标识
	 * @param Fg_ctm
	 */
	public void setFg_ctm(FBoolean Fg_ctm) {
		setAttrVal("Fg_ctm", Fg_ctm);
	}
	/**
	 * 医疗服务类型ID
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 医疗服务类型ID
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医疗服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医疗服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 长临标志
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标志
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 给药标志
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 给药标志
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 单次剂量
	 * @return FDouble
	 */
	public FDouble getDosage() {
		return ((FDouble) getAttrVal("Dosage"));
	}	
	/**
	 * 单次剂量
	 * @param Dosage
	 */
	public void setDosage(FDouble Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getId_cur() {
		return ((String) getAttrVal("Id_cur"));
	}	
	/**
	 * 剂量单位
	 * @param Id_cur
	 */
	public void setId_cur(String Id_cur) {
		setAttrVal("Id_cur", Id_cur);
	}
	/**
	 * 使用频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 使用频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
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
	 * 在院整领
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}	
	/**
	 * 在院整领
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
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
	 * 总量单位ID_当前包装
	 * @return String
	 */
	public String getId_unit_cur() {
		return ((String) getAttrVal("Id_unit_cur"));
	}	
	/**
	 * 总量单位ID_当前包装
	 * @param Id_unit_cur
	 */
	public void setId_unit_cur(String Id_unit_cur) {
		setAttrVal("Id_unit_cur", Id_unit_cur);
	}
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_drug_delivery_method() {
		return ((String) getAttrVal("Id_drug_delivery_method"));
	}	
	/**
	 * 领药方式ID
	 * @param Id_drug_delivery_method
	 */
	public void setId_drug_delivery_method(String Id_drug_delivery_method) {
		setAttrVal("Id_drug_delivery_method", Id_drug_delivery_method);
	}
	/**
	 * 领药方式SD
	 * @return String
	 */
	public String getSd_drug_delivery_method() {
		return ((String) getAttrVal("Sd_drug_delivery_method"));
	}	
	/**
	 * 领药方式SD
	 * @param Sd_drug_delivery_method
	 */
	public void setSd_drug_delivery_method(String Sd_drug_delivery_method) {
		setAttrVal("Sd_drug_delivery_method", Sd_drug_delivery_method);
	}
	/**
	 * 加急标志
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 不计费类型id
	 * @return String
	 */
	public String getId_nodispense() {
		return ((String) getAttrVal("Id_nodispense"));
	}	
	/**
	 * 不计费类型id
	 * @param Id_nodispense
	 */
	public void setId_nodispense(String Id_nodispense) {
		setAttrVal("Id_nodispense", Id_nodispense);
	}
	/**
	 * 不计费类型sd
	 * @return String
	 */
	public String getSd_nodispense() {
		return ((String) getAttrVal("Sd_nodispense"));
	}	
	/**
	 * 不计费类型sd
	 * @param Sd_nodispense
	 */
	public void setSd_nodispense(String Sd_nodispense) {
		setAttrVal("Sd_nodispense", Sd_nodispense);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 物资药房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	/**
	 * 物资药房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
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
	 * 嘱托内容
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 嘱托内容
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
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
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getId_srv_name() {
		return ((String) getAttrVal("Id_srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Id_srv_name
	 */
	public void setId_srv_name(String Id_srv_name) {
		setAttrVal("Id_srv_name", Id_srv_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getId_srvtp_name() {
		return ((String) getAttrVal("Id_srvtp_name"));
	}	
	/**
	 * 名称
	 * @param Id_srvtp_name
	 */
	public void setId_srvtp_name(String Id_srvtp_name) {
		setAttrVal("Id_srvtp_name", Id_srvtp_name);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getId_route_name() {
		return ((String) getAttrVal("Id_route_name"));
	}	
	/**
	 * 用法名称
	 * @param Id_route_name
	 */
	public void setId_route_name(String Id_route_name) {
		setAttrVal("Id_route_name", Id_route_name);
	}
	/**
	 * 用法编码
	 * @return String
	 */
	public String getId_route_code() {
		return ((String) getAttrVal("Id_route_code"));
	}	
	/**
	 * 用法编码
	 * @param Id_route_code
	 */
	public void setId_route_code(String Id_route_code) {
		setAttrVal("Id_route_code", Id_route_code);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getId_route_mnecode() {
		return ((String) getAttrVal("Id_route_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Id_route_mnecode
	 */
	public void setId_route_mnecode(String Id_route_mnecode) {
		setAttrVal("Id_route_mnecode", Id_route_mnecode);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getId_cur_name() {
		return ((String) getAttrVal("Id_cur_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Id_cur_name
	 */
	public void setId_cur_name(String Id_cur_name) {
		setAttrVal("Id_cur_name", Id_cur_name);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getId_cur_code() {
		return ((String) getAttrVal("Id_cur_code"));
	}	
	/**
	 * 计量单位编码
	 * @param Id_cur_code
	 */
	public void setId_cur_code(String Id_cur_code) {
		setAttrVal("Id_cur_code", Id_cur_code);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getId_freq_name() {
		return ((String) getAttrVal("Id_freq_name"));
	}	
	/**
	 * 频次名称
	 * @param Id_freq_name
	 */
	public void setId_freq_name(String Id_freq_name) {
		setAttrVal("Id_freq_name", Id_freq_name);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getId_freq_code() {
		return ((String) getAttrVal("Id_freq_code"));
	}	
	/**
	 * 频次编码
	 * @param Id_freq_code
	 */
	public void setId_freq_code(String Id_freq_code) {
		setAttrVal("Id_freq_code", Id_freq_code);
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
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit_cur() {
		return ((String) getAttrVal("Name_unit_cur"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_unit_cur
	 */
	public void setName_unit_cur(String Name_unit_cur) {
		setAttrVal("Name_unit_cur", Name_unit_cur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_drug_delivery_method() {
		return ((String) getAttrVal("Name_drug_delivery_method"));
	}	
	/**
	 * 名称
	 * @param Name_drug_delivery_method
	 */
	public void setName_drug_delivery_method(String Name_drug_delivery_method) {
		setAttrVal("Name_drug_delivery_method", Name_drug_delivery_method);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nodispense() {
		return ((String) getAttrVal("Name_nodispense"));
	}	
	/**
	 * 名称
	 * @param Name_nodispense
	 */
	public void setName_nodispense(String Name_nodispense) {
		setAttrVal("Name_nodispense", Name_nodispense);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}	
	/**
	 * 名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
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
		return "Id_ele_order";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_ORDER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemOrderDODesc.class);
	}
	
}