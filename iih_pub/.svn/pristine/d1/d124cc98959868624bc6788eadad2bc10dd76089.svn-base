package iih.bd.pp.hpsrvorca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hpsrvorca.d.desc.HPSrvorcaDODesc;
import java.math.BigDecimal;

/**
 * 医保目录对照 DO数据 
 * 
 */
public class HPSrvorcaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保计划服务或分类主键
	public static final String ID_HPSRVORCA= "Id_hpsrvorca";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//物品
	public static final String ID_MM= "Id_mm";
	//物品基本包装单位
	public static final String MM_UNIT_PKGBASE= "Mm_unit_pkgbase";
	//HIS编码
	public static final String HIS_CODE= "His_code";
	//HIS名称
	public static final String HIS_NAME= "His_name";
	//医保计划下编码
	public static final String CODE= "Code";
	//医保计划下名称
	public static final String NAME= "Name";
	//医保剂型编码
	public static final String CODE_DOSAGE= "Code_dosage";
	//收费类别编码
	public static final String CODE_CA= "Code_ca";
	//收费类别名称
	public static final String NAME_CA= "Name_ca";
	//限制报销条件
	public static final String DES= "Des";
	//通用医保计划目录类型
	public static final String ID_HPSRVTP= "Id_hpsrvtp";
	//通用医保计划目录类型编码
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	//报销比例
	public static final String RATE= "Rate";
	//单价支付上限
	public static final String PRI_MAX= "Pri_max";
	//控制类型
	public static final String EU_HPSRVCTRTP= "Eu_hpsrvctrtp";
	//限制规则
	public static final String ID_RULE= "Id_rule";
	//医院限制报销条件
	public static final String HIS_DES= "His_des";
	//离休二乙最高限价
	public static final String RETIRE_EY_PRI_MAX= "Retire_ey_pri_max";
	//医保项目类别
	public static final String EU_HPSRVTP= "Eu_hpsrvtp";
	//开始时间
	public static final String DT_B= "Dt_b";
	//结束时间
	public static final String DT_E= "Dt_e";
	//普通门诊自付比例
	public static final String RATE_SELF_OEP= "Rate_self_oep";
	//住院自付比例
	public static final String RATE_SELF_IP= "Rate_self_ip";
	//离休自付比例
	public static final String RATE_RETIRE= "Rate_retire";
	//工伤自付比例
	public static final String RATE_INJURY= "Rate_injury";
	//生育自付比例
	public static final String RATE_BIRTH= "Rate_birth";
	//二乙自付比例
	public static final String RATE_EY= "Rate_ey";
	//单位自付比例
	public static final String RATE_UNIT= "Rate_unit";
	//家属子女学生自付比例
	public static final String RATE_FAMILY= "Rate_family";
	//进口差价自付比例
	public static final String RATE_IMPORT_DIFF= "Rate_import_diff";
	//状态
	public static final String EU_STATUS= "Eu_status";
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
	//剂型名称
	public static final String HISDOSAGE_NAME= "Hisdosage_name";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//扩展字段6
	public static final String DEF6= "Def6";
	//医保计划名称
	public static final String HP_NAME= "Hp_name";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//医疗物品标识
	public static final String SRV_FG_MM= "Srv_fg_mm";
	//助记码
	public static final String SRV_MNECODE= "Srv_mnecode";
	//医学单位数值
	public static final String QUAN_MED= "Quan_med";
	//参考价格
	public static final String PRI= "Pri";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品单价
	public static final String MM_PRICE= "Mm_price";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//基本包装单位名称
	public static final String NAME_UNIT_PKGBASE= "Name_unit_pkgbase";
	//物品医保名称
	public static final String MM_HINAME= "Mm_hiname";
	//助记码
	public static final String MM_MNECODE= "Mm_mnecode";
	//医学单位
	public static final String ID_UNIT_MED= "Id_unit_med";
	//名称
	public static final String HPSRVTP_NAME= "Hpsrvtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保计划服务或分类主键
	 * @return String
	 */
	public String getId_hpsrvorca() {
		return ((String) getAttrVal("Id_hpsrvorca"));
	}	
	/**
	 * 医保计划服务或分类主键
	 * @param Id_hpsrvorca
	 */
	public void setId_hpsrvorca(String Id_hpsrvorca) {
		setAttrVal("Id_hpsrvorca", Id_hpsrvorca);
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
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品基本包装单位
	 * @return String
	 */
	public String getMm_unit_pkgbase() {
		return ((String) getAttrVal("Mm_unit_pkgbase"));
	}	
	/**
	 * 物品基本包装单位
	 * @param Mm_unit_pkgbase
	 */
	public void setMm_unit_pkgbase(String Mm_unit_pkgbase) {
		setAttrVal("Mm_unit_pkgbase", Mm_unit_pkgbase);
	}
	/**
	 * HIS编码
	 * @return String
	 */
	public String getHis_code() {
		return ((String) getAttrVal("His_code"));
	}	
	/**
	 * HIS编码
	 * @param His_code
	 */
	public void setHis_code(String His_code) {
		setAttrVal("His_code", His_code);
	}
	/**
	 * HIS名称
	 * @return String
	 */
	public String getHis_name() {
		return ((String) getAttrVal("His_name"));
	}	
	/**
	 * HIS名称
	 * @param His_name
	 */
	public void setHis_name(String His_name) {
		setAttrVal("His_name", His_name);
	}
	/**
	 * 医保计划下编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 医保计划下编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医保计划下名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 医保计划下名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 医保剂型编码
	 * @return String
	 */
	public String getCode_dosage() {
		return ((String) getAttrVal("Code_dosage"));
	}	
	/**
	 * 医保剂型编码
	 * @param Code_dosage
	 */
	public void setCode_dosage(String Code_dosage) {
		setAttrVal("Code_dosage", Code_dosage);
	}
	/**
	 * 收费类别编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	/**
	 * 收费类别编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 收费类别名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	/**
	 * 收费类别名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 限制报销条件
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 限制报销条件
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 通用医保计划目录类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}	
	/**
	 * 通用医保计划目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 通用医保计划目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	/**
	 * 通用医保计划目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 报销比例
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}	
	/**
	 * 报销比例
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 单价支付上限
	 * @return FDouble
	 */
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}	
	/**
	 * 单价支付上限
	 * @param Pri_max
	 */
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	/**
	 * 控制类型
	 * @return String
	 */
	public String getEu_hpsrvctrtp() {
		return ((String) getAttrVal("Eu_hpsrvctrtp"));
	}	
	/**
	 * 控制类型
	 * @param Eu_hpsrvctrtp
	 */
	public void setEu_hpsrvctrtp(String Eu_hpsrvctrtp) {
		setAttrVal("Eu_hpsrvctrtp", Eu_hpsrvctrtp);
	}
	/**
	 * 限制规则
	 * @return String
	 */
	public String getId_rule() {
		return ((String) getAttrVal("Id_rule"));
	}	
	/**
	 * 限制规则
	 * @param Id_rule
	 */
	public void setId_rule(String Id_rule) {
		setAttrVal("Id_rule", Id_rule);
	}
	/**
	 * 医院限制报销条件
	 * @return String
	 */
	public String getHis_des() {
		return ((String) getAttrVal("His_des"));
	}	
	/**
	 * 医院限制报销条件
	 * @param His_des
	 */
	public void setHis_des(String His_des) {
		setAttrVal("His_des", His_des);
	}
	/**
	 * 离休二乙最高限价
	 * @return FDouble
	 */
	public FDouble getRetire_ey_pri_max() {
		return ((FDouble) getAttrVal("Retire_ey_pri_max"));
	}	
	/**
	 * 离休二乙最高限价
	 * @param Retire_ey_pri_max
	 */
	public void setRetire_ey_pri_max(FDouble Retire_ey_pri_max) {
		setAttrVal("Retire_ey_pri_max", Retire_ey_pri_max);
	}
	/**
	 * 医保项目类别
	 * @return Integer
	 */
	public Integer getEu_hpsrvtp() {
		return ((Integer) getAttrVal("Eu_hpsrvtp"));
	}	
	/**
	 * 医保项目类别
	 * @param Eu_hpsrvtp
	 */
	public void setEu_hpsrvtp(Integer Eu_hpsrvtp) {
		setAttrVal("Eu_hpsrvtp", Eu_hpsrvtp);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 普通门诊自付比例
	 * @return FDouble
	 */
	public FDouble getRate_self_oep() {
		return ((FDouble) getAttrVal("Rate_self_oep"));
	}	
	/**
	 * 普通门诊自付比例
	 * @param Rate_self_oep
	 */
	public void setRate_self_oep(FDouble Rate_self_oep) {
		setAttrVal("Rate_self_oep", Rate_self_oep);
	}
	/**
	 * 住院自付比例
	 * @return FDouble
	 */
	public FDouble getRate_self_ip() {
		return ((FDouble) getAttrVal("Rate_self_ip"));
	}	
	/**
	 * 住院自付比例
	 * @param Rate_self_ip
	 */
	public void setRate_self_ip(FDouble Rate_self_ip) {
		setAttrVal("Rate_self_ip", Rate_self_ip);
	}
	/**
	 * 离休自付比例
	 * @return FDouble
	 */
	public FDouble getRate_retire() {
		return ((FDouble) getAttrVal("Rate_retire"));
	}	
	/**
	 * 离休自付比例
	 * @param Rate_retire
	 */
	public void setRate_retire(FDouble Rate_retire) {
		setAttrVal("Rate_retire", Rate_retire);
	}
	/**
	 * 工伤自付比例
	 * @return FDouble
	 */
	public FDouble getRate_injury() {
		return ((FDouble) getAttrVal("Rate_injury"));
	}	
	/**
	 * 工伤自付比例
	 * @param Rate_injury
	 */
	public void setRate_injury(FDouble Rate_injury) {
		setAttrVal("Rate_injury", Rate_injury);
	}
	/**
	 * 生育自付比例
	 * @return FDouble
	 */
	public FDouble getRate_birth() {
		return ((FDouble) getAttrVal("Rate_birth"));
	}	
	/**
	 * 生育自付比例
	 * @param Rate_birth
	 */
	public void setRate_birth(FDouble Rate_birth) {
		setAttrVal("Rate_birth", Rate_birth);
	}
	/**
	 * 二乙自付比例
	 * @return FDouble
	 */
	public FDouble getRate_ey() {
		return ((FDouble) getAttrVal("Rate_ey"));
	}	
	/**
	 * 二乙自付比例
	 * @param Rate_ey
	 */
	public void setRate_ey(FDouble Rate_ey) {
		setAttrVal("Rate_ey", Rate_ey);
	}
	/**
	 * 单位自付比例
	 * @return FDouble
	 */
	public FDouble getRate_unit() {
		return ((FDouble) getAttrVal("Rate_unit"));
	}	
	/**
	 * 单位自付比例
	 * @param Rate_unit
	 */
	public void setRate_unit(FDouble Rate_unit) {
		setAttrVal("Rate_unit", Rate_unit);
	}
	/**
	 * 家属子女学生自付比例
	 * @return FDouble
	 */
	public FDouble getRate_family() {
		return ((FDouble) getAttrVal("Rate_family"));
	}	
	/**
	 * 家属子女学生自付比例
	 * @param Rate_family
	 */
	public void setRate_family(FDouble Rate_family) {
		setAttrVal("Rate_family", Rate_family);
	}
	/**
	 * 进口差价自付比例
	 * @return FDouble
	 */
	public FDouble getRate_import_diff() {
		return ((FDouble) getAttrVal("Rate_import_diff"));
	}	
	/**
	 * 进口差价自付比例
	 * @param Rate_import_diff
	 */
	public void setRate_import_diff(FDouble Rate_import_diff) {
		setAttrVal("Rate_import_diff", Rate_import_diff);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}	
	/**
	 * 状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
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
	 * 剂型名称
	 * @return String
	 */
	public String getHisdosage_name() {
		return ((String) getAttrVal("Hisdosage_name"));
	}	
	/**
	 * 剂型名称
	 * @param Hisdosage_name
	 */
	public void setHisdosage_name(String Hisdosage_name) {
		setAttrVal("Hisdosage_name", Hisdosage_name);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	/**
	 * 医保计划名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
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
	 * 医疗物品标识
	 * @return FBoolean
	 */
	public FBoolean getSrv_fg_mm() {
		return ((FBoolean) getAttrVal("Srv_fg_mm"));
	}	
	/**
	 * 医疗物品标识
	 * @param Srv_fg_mm
	 */
	public void setSrv_fg_mm(FBoolean Srv_fg_mm) {
		setAttrVal("Srv_fg_mm", Srv_fg_mm);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getSrv_mnecode() {
		return ((String) getAttrVal("Srv_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Srv_mnecode
	 */
	public void setSrv_mnecode(String Srv_mnecode) {
		setAttrVal("Srv_mnecode", Srv_mnecode);
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
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 物品单价
	 * @return FDouble
	 */
	public FDouble getMm_price() {
		return ((FDouble) getAttrVal("Mm_price"));
	}	
	/**
	 * 物品单价
	 * @param Mm_price
	 */
	public void setMm_price(FDouble Mm_price) {
		setAttrVal("Mm_price", Mm_price);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
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
	 * 物品医保名称
	 * @return String
	 */
	public String getMm_hiname() {
		return ((String) getAttrVal("Mm_hiname"));
	}	
	/**
	 * 物品医保名称
	 * @param Mm_hiname
	 */
	public void setMm_hiname(String Mm_hiname) {
		setAttrVal("Mm_hiname", Mm_hiname);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMm_mnecode() {
		return ((String) getAttrVal("Mm_mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mm_mnecode
	 */
	public void setMm_mnecode(String Mm_mnecode) {
		setAttrVal("Mm_mnecode", Mm_mnecode);
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
	 * 名称
	 * @return String
	 */
	public String getHpsrvtp_name() {
		return ((String) getAttrVal("Hpsrvtp_name"));
	}	
	/**
	 * 名称
	 * @param Hpsrvtp_name
	 */
	public void setHpsrvtp_name(String Hpsrvtp_name) {
		setAttrVal("Hpsrvtp_name", Hpsrvtp_name);
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
		return "Id_hpsrvorca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_hp_srvorca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HPSrvorcaDODesc.class);
	}
	
}