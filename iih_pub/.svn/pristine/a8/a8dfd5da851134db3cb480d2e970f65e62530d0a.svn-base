package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.desc.OrTplNItmDODesc;
import iih.bd.srv.ortpl.dto.ortmplcareldto.d.OrtmplSetDTO;

import java.math.BigDecimal;

/**
 * 医嘱模板明细 DO数据 
 * 
 */
public class OrTplNItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱模板项目主键标识
	public static final String ID_ORTMPLITM= "Id_ortmplitm";
	//序号
	public static final String SORTNO= "Sortno";
	//医嘱模板项目类型
	public static final String EU_ORTPLITMTP= "Eu_ortplitmtp";
	//医嘱模板
	public static final String ID_ORTMPL= "Id_ortmpl";
	//服务
	public static final String ID_SRV= "Id_srv";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//用法
	public static final String ID_ROUTE= "Id_route";
	//要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//煎法
	public static final String ID_BOIL= "Id_boil";
	//中医要求
	public static final String ID_BOILDES= "Id_boildes";
	//频次
	public static final String ID_FREQ= "Id_freq";
	//医学单位
	public static final String ID_UNIT_MED= "Id_unit_med";
	//医学单位数值
	public static final String QUAN_MED= "Quan_med";
	//关联物品
	public static final String ID_MM= "Id_mm";
	//跟随标识
	public static final String FG_SYNC= "Fg_sync";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//是否编辑
	public static final String FG_EDIT= "Fg_edit";
	//套id
	public static final String ID_SRV_SET= "Id_srv_set";
	//标识一个模板(计算使用)
	public static final String IDENTICAL_ORTMPL= "Identical_ortmpl";
	//嘱托
	public static final String DES_OR= "Des_or";
	//价格
	public static final String PRICE= "Price";
	//使用天数
	public static final String DAYS_OR= "Days_or";
	//草药付数
	public static final String ORDERS= "Orders";
	//总量
	public static final String QUAN_TOTAL_MEDU= "Quan_total_medu";
	//总量单位id
	public static final String ID_TOTAL_MEDU= "Id_total_medu";
	//医保类别id
	public static final String ID_HP= "Id_hp";
	//模板的服务是否被停用
	public static final String FG_ACTIVE= "Fg_active";
	//模板项目不可用的原因描述信息
	public static final String DESCRIPTION= "Description";
	//是否被选中
	public static final String FG_CHECKED= "Fg_checked";
	//治疗医疗单的开单模式
	public static final String OPDIAGTREATTMPLOROPENMODE= "Opdiagtreattmploropenmode";
	//套内项目临床标识
	public static final String FG_CLINICAL= "Fg_clinical";
	//默认次数
	public static final String TIMES= "Times";
	//标本类型ID
	public static final String ID_SAMPTP= "Id_samptp";
	//标本类型编码
	public static final String SD_SAMPTP= "Sd_samptp";
	//自费标识
	public static final String FG_SELFPAY= "Fg_selfpay";
	//付数无关标志
	public static final String FG_NOTHINGWITHORDERS= "Fg_nothingwithorders";
	//发药科室
	public static final String ID_DEPT_WH= "Id_dept_wh";
	//参照的计算主键
	public static final String IDSRVIDMM= "Idsrvidmm";
	//关联医嘱id（护嘱的需求）
	public static final String ID_OR_REL= "Id_or_rel";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//备注
	public static final String DES= "Des";
	//开始时间
	public static final String DT_EFFE= "Dt_effe";
	//是否代煎
	public static final String FG_BOIL= "Fg_boil";
	//在院整领标识
	public static final String FG_WHOLEPACK= "Fg_wholepack";
	//领药方式ID
	public static final String ID_DRUGDELIVERYMETHOD= "Id_drugdeliverymethod";
	//领药方式编码
	public static final String SD_DRUGDELIVERYMETHOD= "Sd_drugdeliverymethod";
	//领药方式名称
	public static final String NAME_DRUGDELIVERYMETHOD= "Name_drugdeliverymethod";
	//当前剂量
	public static final String QUAN_MEDU_CUR= "Quan_medu_cur";
	//当前剂量单位
	public static final String ID_MEDU_CUR= "Id_medu_cur";
	//当前换算系数
	public static final String FACTOR_CUR= "Factor_cur";
	//换算系数
	public static final String FACTOR_MB= "Factor_mb";
	//超量开单原因id
	public static final String ID_EXCESSIVE_REASON= "Id_excessive_reason";
	//超量开单原因sd
	public static final String SD_EXCESSIVE_REASON= "Sd_excessive_reason";
	//超量开单原因名称
	public static final String NAME_EXCESSIVE_REASON= "Name_excessive_reason";
	//皮试标志
	public static final String FG_SKINTEST= "Fg_skintest";
	//服务编码
	public static final String ORTPLNITM_SRV_CODE= "Ortplnitm_srv_code";
	//服务名称
	public static final String ORTPLNITM_SRV_NAME= "Ortplnitm_srv_name";
	//自定义服务名称标志
	public static final String FG_CTM= "Fg_ctm";
	//是否多次执行
	public static final String ISMULEXEC= "Ismulexec";
	//是否多量开单
	public static final String ISMULDOSE= "Ismuldose";
	//总量开单方式编码
	public static final String SD_TOTALOPENMODE= "Sd_totalopenmode";
	//名称
	public static final String ORTPLNITM_SRVTP_NAME= "Ortplnitm_srvtp_name";
	//用法编码
	public static final String ORTPLNITM_ROUTE_CODE= "Ortplnitm_route_code";
	//用法名称
	public static final String ORTPLNITM_ROUTE_NAME= "Ortplnitm_route_name";
	//医疗要求
	public static final String ORTPLNITM_ROUTEDES_NAME= "Ortplnitm_routedes_name";
	//医疗要求编码
	public static final String ORTPLNITM_ROUTEDES_CODE= "Ortplnitm_routedes_code";
	//煎法编码
	public static final String ORTPLNITM_BOIL_CODE= "Ortplnitm_boil_code";
	//煎法名称
	public static final String ORTPLNITM_BOIL_NAME= "Ortplnitm_boil_name";
	//煎法要求编码
	public static final String ORTPLNITM_BOILDES_CODE= "Ortplnitm_boildes_code";
	//煎法要求
	public static final String ORTPLNITM_BOILDES_NAME= "Ortplnitm_boildes_name";
	//频次编码
	public static final String ORTPLNITM_FREQ_CODE= "Ortplnitm_freq_code";
	//频次名称
	public static final String ORTPLNITM_FREQ_NAME= "Ortplnitm_freq_name";
	//计量单位编码
	public static final String ORTPLNITM_UNIT_CODE= "Ortplnitm_unit_code";
	//计量单位名称
	public static final String ORTPLNITM_UNIT_NAME= "Ortplnitm_unit_name";
	//物品编码
	public static final String ORTPLNITM_MM_CODE= "Ortplnitm_mm_code";
	//物品名称
	public static final String ORTPLNITM_MM_NAME= "Ortplnitm_mm_name";
	//物品规格
	public static final String ORTPLNITM_MM_SPEC= "Ortplnitm_mm_spec";
	//草药制剂类型
	public static final String ID_HERBPREPARATIONTP= "Id_herbpreparationtp";
	//草药制剂类型编码(0饮片；1配方颗粒)
	public static final String SD_HERBPREPARATIONTP= "Sd_herbpreparationtp";
	//编码
	public static final String ORTPLNITM_MP_CODE= "Ortplnitm_mp_code";
	//名称
	public static final String ORTPLNITM_MP_NAME= "Ortplnitm_mp_name";
	//总量单位名称
	public static final String NAME_TOTAL_MEDU= "Name_total_medu";
	//医保计划名称
	public static final String NAME_HP= "Name_hp";
	//名称
	public static final String ORTPLNITM_SAMPTP_NAME= "Ortplnitm_samptp_name";
	//名称
	public static final String NAME_DEPT_WH= "Name_dept_wh";
	//编码
	public static final String CODE_DEPT_WH= "Code_dept_wh";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 套项目dto
	 * @return OrtmplSetDTO
	 */
	public OrtmplSetDTO getOrtmplSetDTO() {
		return ((OrtmplSetDTO) getAttrVal("OrtmplSetDTO"));
	}	
	/**
	 * 套项目dto
	 * @param OrtmplSetDTO
	 */
	public void setOrtmplSetDTO(OrtmplSetDTO OrtmplSetDTO) {
		setAttrVal("OrtmplSetDTO", OrtmplSetDTO);
	}
	
	/**
	 * 医嘱模板项目主键标识
	 * @return String
	 */
	public String getId_ortmplitm() {
		return ((String) getAttrVal("Id_ortmplitm"));
	}	
	/**
	 * 医嘱模板项目主键标识
	 * @param Id_ortmplitm
	 */
	public void setId_ortmplitm(String Id_ortmplitm) {
		setAttrVal("Id_ortmplitm", Id_ortmplitm);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 医嘱模板项目类型
	 * @return Integer
	 */
	public Integer getEu_ortplitmtp() {
		return ((Integer) getAttrVal("Eu_ortplitmtp"));
	}	
	/**
	 * 医嘱模板项目类型
	 * @param Eu_ortplitmtp
	 */
	public void setEu_ortplitmtp(Integer Eu_ortplitmtp) {
		setAttrVal("Eu_ortplitmtp", Eu_ortplitmtp);
	}
	/**
	 * 医嘱模板
	 * @return String
	 */
	public String getId_ortmpl() {
		return ((String) getAttrVal("Id_ortmpl"));
	}	
	/**
	 * 医嘱模板
	 * @param Id_ortmpl
	 */
	public void setId_ortmpl(String Id_ortmpl) {
		setAttrVal("Id_ortmpl", Id_ortmpl);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 中医要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 中医要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
	 * 关联物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 关联物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 跟随标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sync() {
		return ((FBoolean) getAttrVal("Fg_sync"));
	}	
	/**
	 * 跟随标识
	 * @param Fg_sync
	 */
	public void setFg_sync(FBoolean Fg_sync) {
		setAttrVal("Fg_sync", Fg_sync);
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
	 * 是否编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	/**
	 * 是否编辑
	 * @param Fg_edit
	 */
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
	}
	/**
	 * 套id
	 * @return String
	 */
	public String getId_srv_set() {
		return ((String) getAttrVal("Id_srv_set"));
	}	
	/**
	 * 套id
	 * @param Id_srv_set
	 */
	public void setId_srv_set(String Id_srv_set) {
		setAttrVal("Id_srv_set", Id_srv_set);
	}
	/**
	 * 标识一个模板(计算使用)
	 * @return String
	 */
	public String getIdentical_ortmpl() {
		return ((String) getAttrVal("Identical_ortmpl"));
	}	
	/**
	 * 标识一个模板(计算使用)
	 * @param Identical_ortmpl
	 */
	public void setIdentical_ortmpl(String Identical_ortmpl) {
		setAttrVal("Identical_ortmpl", Identical_ortmpl);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 使用天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}	
	/**
	 * 使用天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 草药付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}	
	/**
	 * 草药付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}	
	/**
	 * 总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	/**
	 * 总量单位id
	 * @return String
	 */
	public String getId_total_medu() {
		return ((String) getAttrVal("Id_total_medu"));
	}	
	/**
	 * 总量单位id
	 * @param Id_total_medu
	 */
	public void setId_total_medu(String Id_total_medu) {
		setAttrVal("Id_total_medu", Id_total_medu);
	}
	/**
	 * 医保类别id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保类别id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 模板的服务是否被停用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 模板的服务是否被停用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 模板项目不可用的原因描述信息
	 * @return String
	 */
	public String getDescription() {
		return ((String) getAttrVal("Description"));
	}	
	/**
	 * 模板项目不可用的原因描述信息
	 * @param Description
	 */
	public void setDescription(String Description) {
		setAttrVal("Description", Description);
	}
	/**
	 * 是否被选中
	 * @return FBoolean
	 */
	public FBoolean getFg_checked() {
		return ((FBoolean) getAttrVal("Fg_checked"));
	}	
	/**
	 * 是否被选中
	 * @param Fg_checked
	 */
	public void setFg_checked(FBoolean Fg_checked) {
		setAttrVal("Fg_checked", Fg_checked);
	}
	/**
	 * 治疗医疗单的开单模式
	 * @return String
	 */
	public String getOpdiagtreattmploropenmode() {
		return ((String) getAttrVal("Opdiagtreattmploropenmode"));
	}	
	/**
	 * 治疗医疗单的开单模式
	 * @param Opdiagtreattmploropenmode
	 */
	public void setOpdiagtreattmploropenmode(String Opdiagtreattmploropenmode) {
		setAttrVal("Opdiagtreattmploropenmode", Opdiagtreattmploropenmode);
	}
	/**
	 * 套内项目临床标识
	 * @return FBoolean
	 */
	public FBoolean getFg_clinical() {
		return ((FBoolean) getAttrVal("Fg_clinical"));
	}	
	/**
	 * 套内项目临床标识
	 * @param Fg_clinical
	 */
	public void setFg_clinical(FBoolean Fg_clinical) {
		setAttrVal("Fg_clinical", Fg_clinical);
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
	 * 标本类型ID
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}	
	/**
	 * 标本类型ID
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}	
	/**
	 * 标本类型编码
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}	
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 付数无关标志
	 * @return FBoolean
	 */
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}	
	/**
	 * 付数无关标志
	 * @param Fg_nothingwithorders
	 */
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	/**
	 * 发药科室
	 * @return String
	 */
	public String getId_dept_wh() {
		return ((String) getAttrVal("Id_dept_wh"));
	}	
	/**
	 * 发药科室
	 * @param Id_dept_wh
	 */
	public void setId_dept_wh(String Id_dept_wh) {
		setAttrVal("Id_dept_wh", Id_dept_wh);
	}
	/**
	 * 参照的计算主键
	 * @return String
	 */
	public String getIdsrvidmm() {
		return ((String) getAttrVal("Idsrvidmm"));
	}	
	/**
	 * 参照的计算主键
	 * @param Idsrvidmm
	 */
	public void setIdsrvidmm(String Idsrvidmm) {
		setAttrVal("Idsrvidmm", Idsrvidmm);
	}
	/**
	 * 关联医嘱id（护嘱的需求）
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}	
	/**
	 * 关联医嘱id（护嘱的需求）
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
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
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 是否代煎
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 是否代煎
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 在院整领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}	
	/**
	 * 在院整领标识
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_drugdeliverymethod() {
		return ((String) getAttrVal("Id_drugdeliverymethod"));
	}	
	/**
	 * 领药方式ID
	 * @param Id_drugdeliverymethod
	 */
	public void setId_drugdeliverymethod(String Id_drugdeliverymethod) {
		setAttrVal("Id_drugdeliverymethod", Id_drugdeliverymethod);
	}
	/**
	 * 领药方式编码
	 * @return String
	 */
	public String getSd_drugdeliverymethod() {
		return ((String) getAttrVal("Sd_drugdeliverymethod"));
	}	
	/**
	 * 领药方式编码
	 * @param Sd_drugdeliverymethod
	 */
	public void setSd_drugdeliverymethod(String Sd_drugdeliverymethod) {
		setAttrVal("Sd_drugdeliverymethod", Sd_drugdeliverymethod);
	}
	/**
	 * 领药方式名称
	 * @return String
	 */
	public String getName_drugdeliverymethod() {
		return ((String) getAttrVal("Name_drugdeliverymethod"));
	}	
	/**
	 * 领药方式名称
	 * @param Name_drugdeliverymethod
	 */
	public void setName_drugdeliverymethod(String Name_drugdeliverymethod) {
		setAttrVal("Name_drugdeliverymethod", Name_drugdeliverymethod);
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
	 * 当前换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_cur() {
		return ((FDouble) getAttrVal("Factor_cur"));
	}	
	/**
	 * 当前换算系数
	 * @param Factor_cur
	 */
	public void setFactor_cur(FDouble Factor_cur) {
		setAttrVal("Factor_cur", Factor_cur);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	/**
	 * 换算系数
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 超量开单原因id
	 * @return String
	 */
	public String getId_excessive_reason() {
		return ((String) getAttrVal("Id_excessive_reason"));
	}	
	/**
	 * 超量开单原因id
	 * @param Id_excessive_reason
	 */
	public void setId_excessive_reason(String Id_excessive_reason) {
		setAttrVal("Id_excessive_reason", Id_excessive_reason);
	}
	/**
	 * 超量开单原因sd
	 * @return String
	 */
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}	
	/**
	 * 超量开单原因sd
	 * @param Sd_excessive_reason
	 */
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
	}
	/**
	 * 超量开单原因名称
	 * @return String
	 */
	public String getName_excessive_reason() {
		return ((String) getAttrVal("Name_excessive_reason"));
	}	
	/**
	 * 超量开单原因名称
	 * @param Name_excessive_reason
	 */
	public void setName_excessive_reason(String Name_excessive_reason) {
		setAttrVal("Name_excessive_reason", Name_excessive_reason);
	}
	/**
	 * 皮试标志
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	/**
	 * 皮试标志
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getOrtplnitm_srv_code() {
		return ((String) getAttrVal("Ortplnitm_srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Ortplnitm_srv_code
	 */
	public void setOrtplnitm_srv_code(String Ortplnitm_srv_code) {
		setAttrVal("Ortplnitm_srv_code", Ortplnitm_srv_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getOrtplnitm_srv_name() {
		return ((String) getAttrVal("Ortplnitm_srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Ortplnitm_srv_name
	 */
	public void setOrtplnitm_srv_name(String Ortplnitm_srv_name) {
		setAttrVal("Ortplnitm_srv_name", Ortplnitm_srv_name);
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
	 * 名称
	 * @return String
	 */
	public String getOrtplnitm_srvtp_name() {
		return ((String) getAttrVal("Ortplnitm_srvtp_name"));
	}	
	/**
	 * 名称
	 * @param Ortplnitm_srvtp_name
	 */
	public void setOrtplnitm_srvtp_name(String Ortplnitm_srvtp_name) {
		setAttrVal("Ortplnitm_srvtp_name", Ortplnitm_srvtp_name);
	}
	/**
	 * 用法编码
	 * @return String
	 */
	public String getOrtplnitm_route_code() {
		return ((String) getAttrVal("Ortplnitm_route_code"));
	}	
	/**
	 * 用法编码
	 * @param Ortplnitm_route_code
	 */
	public void setOrtplnitm_route_code(String Ortplnitm_route_code) {
		setAttrVal("Ortplnitm_route_code", Ortplnitm_route_code);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getOrtplnitm_route_name() {
		return ((String) getAttrVal("Ortplnitm_route_name"));
	}	
	/**
	 * 用法名称
	 * @param Ortplnitm_route_name
	 */
	public void setOrtplnitm_route_name(String Ortplnitm_route_name) {
		setAttrVal("Ortplnitm_route_name", Ortplnitm_route_name);
	}
	/**
	 * 医疗要求
	 * @return String
	 */
	public String getOrtplnitm_routedes_name() {
		return ((String) getAttrVal("Ortplnitm_routedes_name"));
	}	
	/**
	 * 医疗要求
	 * @param Ortplnitm_routedes_name
	 */
	public void setOrtplnitm_routedes_name(String Ortplnitm_routedes_name) {
		setAttrVal("Ortplnitm_routedes_name", Ortplnitm_routedes_name);
	}
	/**
	 * 医疗要求编码
	 * @return String
	 */
	public String getOrtplnitm_routedes_code() {
		return ((String) getAttrVal("Ortplnitm_routedes_code"));
	}	
	/**
	 * 医疗要求编码
	 * @param Ortplnitm_routedes_code
	 */
	public void setOrtplnitm_routedes_code(String Ortplnitm_routedes_code) {
		setAttrVal("Ortplnitm_routedes_code", Ortplnitm_routedes_code);
	}
	/**
	 * 煎法编码
	 * @return String
	 */
	public String getOrtplnitm_boil_code() {
		return ((String) getAttrVal("Ortplnitm_boil_code"));
	}	
	/**
	 * 煎法编码
	 * @param Ortplnitm_boil_code
	 */
	public void setOrtplnitm_boil_code(String Ortplnitm_boil_code) {
		setAttrVal("Ortplnitm_boil_code", Ortplnitm_boil_code);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getOrtplnitm_boil_name() {
		return ((String) getAttrVal("Ortplnitm_boil_name"));
	}	
	/**
	 * 煎法名称
	 * @param Ortplnitm_boil_name
	 */
	public void setOrtplnitm_boil_name(String Ortplnitm_boil_name) {
		setAttrVal("Ortplnitm_boil_name", Ortplnitm_boil_name);
	}
	/**
	 * 煎法要求编码
	 * @return String
	 */
	public String getOrtplnitm_boildes_code() {
		return ((String) getAttrVal("Ortplnitm_boildes_code"));
	}	
	/**
	 * 煎法要求编码
	 * @param Ortplnitm_boildes_code
	 */
	public void setOrtplnitm_boildes_code(String Ortplnitm_boildes_code) {
		setAttrVal("Ortplnitm_boildes_code", Ortplnitm_boildes_code);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getOrtplnitm_boildes_name() {
		return ((String) getAttrVal("Ortplnitm_boildes_name"));
	}	
	/**
	 * 煎法要求
	 * @param Ortplnitm_boildes_name
	 */
	public void setOrtplnitm_boildes_name(String Ortplnitm_boildes_name) {
		setAttrVal("Ortplnitm_boildes_name", Ortplnitm_boildes_name);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getOrtplnitm_freq_code() {
		return ((String) getAttrVal("Ortplnitm_freq_code"));
	}	
	/**
	 * 频次编码
	 * @param Ortplnitm_freq_code
	 */
	public void setOrtplnitm_freq_code(String Ortplnitm_freq_code) {
		setAttrVal("Ortplnitm_freq_code", Ortplnitm_freq_code);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getOrtplnitm_freq_name() {
		return ((String) getAttrVal("Ortplnitm_freq_name"));
	}	
	/**
	 * 频次名称
	 * @param Ortplnitm_freq_name
	 */
	public void setOrtplnitm_freq_name(String Ortplnitm_freq_name) {
		setAttrVal("Ortplnitm_freq_name", Ortplnitm_freq_name);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getOrtplnitm_unit_code() {
		return ((String) getAttrVal("Ortplnitm_unit_code"));
	}	
	/**
	 * 计量单位编码
	 * @param Ortplnitm_unit_code
	 */
	public void setOrtplnitm_unit_code(String Ortplnitm_unit_code) {
		setAttrVal("Ortplnitm_unit_code", Ortplnitm_unit_code);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getOrtplnitm_unit_name() {
		return ((String) getAttrVal("Ortplnitm_unit_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Ortplnitm_unit_name
	 */
	public void setOrtplnitm_unit_name(String Ortplnitm_unit_name) {
		setAttrVal("Ortplnitm_unit_name", Ortplnitm_unit_name);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getOrtplnitm_mm_code() {
		return ((String) getAttrVal("Ortplnitm_mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Ortplnitm_mm_code
	 */
	public void setOrtplnitm_mm_code(String Ortplnitm_mm_code) {
		setAttrVal("Ortplnitm_mm_code", Ortplnitm_mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getOrtplnitm_mm_name() {
		return ((String) getAttrVal("Ortplnitm_mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Ortplnitm_mm_name
	 */
	public void setOrtplnitm_mm_name(String Ortplnitm_mm_name) {
		setAttrVal("Ortplnitm_mm_name", Ortplnitm_mm_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getOrtplnitm_mm_spec() {
		return ((String) getAttrVal("Ortplnitm_mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Ortplnitm_mm_spec
	 */
	public void setOrtplnitm_mm_spec(String Ortplnitm_mm_spec) {
		setAttrVal("Ortplnitm_mm_spec", Ortplnitm_mm_spec);
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
	 * 编码
	 * @return String
	 */
	public String getOrtplnitm_mp_code() {
		return ((String) getAttrVal("Ortplnitm_mp_code"));
	}	
	/**
	 * 编码
	 * @param Ortplnitm_mp_code
	 */
	public void setOrtplnitm_mp_code(String Ortplnitm_mp_code) {
		setAttrVal("Ortplnitm_mp_code", Ortplnitm_mp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOrtplnitm_mp_name() {
		return ((String) getAttrVal("Ortplnitm_mp_name"));
	}	
	/**
	 * 名称
	 * @param Ortplnitm_mp_name
	 */
	public void setOrtplnitm_mp_name(String Ortplnitm_mp_name) {
		setAttrVal("Ortplnitm_mp_name", Ortplnitm_mp_name);
	}
	/**
	 * 总量单位名称
	 * @return String
	 */
	public String getName_total_medu() {
		return ((String) getAttrVal("Name_total_medu"));
	}	
	/**
	 * 总量单位名称
	 * @param Name_total_medu
	 */
	public void setName_total_medu(String Name_total_medu) {
		setAttrVal("Name_total_medu", Name_total_medu);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOrtplnitm_samptp_name() {
		return ((String) getAttrVal("Ortplnitm_samptp_name"));
	}	
	/**
	 * 名称
	 * @param Ortplnitm_samptp_name
	 */
	public void setOrtplnitm_samptp_name(String Ortplnitm_samptp_name) {
		setAttrVal("Ortplnitm_samptp_name", Ortplnitm_samptp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept_wh() {
		return ((String) getAttrVal("Name_dept_wh"));
	}	
	/**
	 * 名称
	 * @param Name_dept_wh
	 */
	public void setName_dept_wh(String Name_dept_wh) {
		setAttrVal("Name_dept_wh", Name_dept_wh);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dept_wh() {
		return ((String) getAttrVal("Code_dept_wh"));
	}	
	/**
	 * 编码
	 * @param Code_dept_wh
	 */
	public void setCode_dept_wh(String Code_dept_wh) {
		setAttrVal("Code_dept_wh", Code_dept_wh);
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
		return "Id_ortmplitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_ortmpl_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrTplNItmDODesc.class);
	}
	
}