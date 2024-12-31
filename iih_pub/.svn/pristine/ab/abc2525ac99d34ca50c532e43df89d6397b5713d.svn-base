package iih.ems.embd.eminfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.embd.eminfo.d.desc.EmsInfoDODesc;
import java.math.BigDecimal;

/**
 * 设备基本信息 DO数据 
 * 
 */
public class EmsInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//设备主键
	public static final String ID_EM= "Id_em";
	//设备名称
	public static final String NAME= "Name";
	//设备编码
	public static final String CODE= "Code";
	//设备分类
	public static final String ID_EMCA= "Id_emca";
	//设备分类树内码
	public static final String EMCA_INRCODE= "Emca_inrcode";
	//规格
	public static final String SPECS= "Specs";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//最新单价
	public static final String CURR_PRICE= "Curr_price";
	//国标码
	public static final String NATION_CODE= "Nation_code";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNSCODE= "Mnscode";
	//设备大类管理类别
	public static final String ID_EMTP= "Id_emtp";
	//设备大类管理类别编码
	public static final String SD_EMTP= "Sd_emtp";
	//卫生局设备编码
	public static final String LEAD_CODE= "Lead_code";
	//是否折旧
	public static final String FG_DE= "Fg_de";
	//是否有效
	public static final String FG_VALID= "Fg_valid";
	//折旧方式
	public static final String ID_DE= "Id_de";
	//折旧年限
	public static final String DE_YEAR= "De_year";
	//是否计量
	public static final String FG_GAUGE= "Fg_gauge";
	//是否附加设备(附件)
	public static final String FG_APPEND= "Fg_append";
	//保管等级
	public static final String ID_STOR_LEVEL= "Id_stor_level";
	//保管等级编码
	public static final String SD_STOR_LEVEL= "Sd_stor_level";
	//库存上限
	public static final String MOST_NUM= "Most_num";
	//库存下限
	public static final String LOWEST_NUM= "Lowest_num";
	//品牌名称
	public static final String BRAND_NAME= "Brand_name";
	//英文名
	public static final String ENGLISH_NAME= "English_name";
	//是否自制
	public static final String FG_SELF= "Fg_self";
	//计量仪器分类
	public static final String ID_GECA= "Id_geca";
	//保养周期（天）
	public static final String UPKEEP_CYC= "Upkeep_cyc";
	//计量周期（天）
	public static final String GAUGE_CYC= "Gauge_cyc";
	//是否固定资产
	public static final String FG_FIXED= "Fg_fixed";
	//是否急救设备
	public static final String FG_AIDEM= "Fg_aidem";
	//是否特殊设备
	public static final String FG_ISSPECIAL= "Fg_isspecial";
	//设备检测周期
	public static final String TEST_CYC= "Test_cyc";
	//是否房屋
	public static final String FG_HOUSES= "Fg_houses";
	//型号
	public static final String MODEL= "Model";
	//是否压力容器
	public static final String FG_PRESSURE= "Fg_pressure";
	//是否放射设备
	public static final String FG_RADIOLOGY= "Fg_radiology";
	//卫生部编码
	public static final String MOH_CODE= "Moh_code";
	//政府编码
	public static final String GOVER_CODE= "Gover_code";
	//是否试用设备
	public static final String FG_TESTEM= "Fg_testem";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//名称
	public static final String NAME_CA= "Name_ca";
	//编码
	public static final String CODE_CA= "Code_ca";
	//包装单位类型名称
	public static final String NAME_UNIT= "Name_unit";
	//包装单位类型编码
	public static final String CODE_UNIT= "Code_unit";
	//名称
	public static final String NAME_EMTP= "Name_emtp";
	//折旧名称
	public static final String NAME_DE= "Name_de";
	//折旧编码
	public static final String CODE_DE= "Code_de";
	//名称
	public static final String NAME_SL= "Name_sl";
	//名称
	public static final String NAME_GE= "Name_ge";
	//编码
	public static final String CODE_GE= "Code_ge";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 设备主键
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备主键
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 设备名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 设备编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 设备分类
	 * @return String
	 */
	public String getId_emca() {
		return ((String) getAttrVal("Id_emca"));
	}	
	/**
	 * 设备分类
	 * @param Id_emca
	 */
	public void setId_emca(String Id_emca) {
		setAttrVal("Id_emca", Id_emca);
	}
	/**
	 * 设备分类树内码
	 * @return String
	 */
	public String getEmca_inrcode() {
		return ((String) getAttrVal("Emca_inrcode"));
	}	
	/**
	 * 设备分类树内码
	 * @param Emca_inrcode
	 */
	public void setEmca_inrcode(String Emca_inrcode) {
		setAttrVal("Emca_inrcode", Emca_inrcode);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpecs() {
		return ((String) getAttrVal("Specs"));
	}	
	/**
	 * 规格
	 * @param Specs
	 */
	public void setSpecs(String Specs) {
		setAttrVal("Specs", Specs);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 最新单价
	 * @return FDouble
	 */
	public FDouble getCurr_price() {
		return ((FDouble) getAttrVal("Curr_price"));
	}	
	/**
	 * 最新单价
	 * @param Curr_price
	 */
	public void setCurr_price(FDouble Curr_price) {
		setAttrVal("Curr_price", Curr_price);
	}
	/**
	 * 国标码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	/**
	 * 国标码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
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
	public String getMnscode() {
		return ((String) getAttrVal("Mnscode"));
	}	
	/**
	 * 助记码
	 * @param Mnscode
	 */
	public void setMnscode(String Mnscode) {
		setAttrVal("Mnscode", Mnscode);
	}
	/**
	 * 设备大类管理类别
	 * @return String
	 */
	public String getId_emtp() {
		return ((String) getAttrVal("Id_emtp"));
	}	
	/**
	 * 设备大类管理类别
	 * @param Id_emtp
	 */
	public void setId_emtp(String Id_emtp) {
		setAttrVal("Id_emtp", Id_emtp);
	}
	/**
	 * 设备大类管理类别编码
	 * @return String
	 */
	public String getSd_emtp() {
		return ((String) getAttrVal("Sd_emtp"));
	}	
	/**
	 * 设备大类管理类别编码
	 * @param Sd_emtp
	 */
	public void setSd_emtp(String Sd_emtp) {
		setAttrVal("Sd_emtp", Sd_emtp);
	}
	/**
	 * 卫生局设备编码
	 * @return String
	 */
	public String getLead_code() {
		return ((String) getAttrVal("Lead_code"));
	}	
	/**
	 * 卫生局设备编码
	 * @param Lead_code
	 */
	public void setLead_code(String Lead_code) {
		setAttrVal("Lead_code", Lead_code);
	}
	/**
	 * 是否折旧
	 * @return FBoolean
	 */
	public FBoolean getFg_de() {
		return ((FBoolean) getAttrVal("Fg_de"));
	}	
	/**
	 * 是否折旧
	 * @param Fg_de
	 */
	public void setFg_de(FBoolean Fg_de) {
		setAttrVal("Fg_de", Fg_de);
	}
	/**
	 * 是否有效
	 * @return FBoolean
	 */
	public FBoolean getFg_valid() {
		return ((FBoolean) getAttrVal("Fg_valid"));
	}	
	/**
	 * 是否有效
	 * @param Fg_valid
	 */
	public void setFg_valid(FBoolean Fg_valid) {
		setAttrVal("Fg_valid", Fg_valid);
	}
	/**
	 * 折旧方式
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 折旧方式
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 折旧年限
	 * @return Integer
	 */
	public Integer getDe_year() {
		return ((Integer) getAttrVal("De_year"));
	}	
	/**
	 * 折旧年限
	 * @param De_year
	 */
	public void setDe_year(Integer De_year) {
		setAttrVal("De_year", De_year);
	}
	/**
	 * 是否计量
	 * @return FBoolean
	 */
	public FBoolean getFg_gauge() {
		return ((FBoolean) getAttrVal("Fg_gauge"));
	}	
	/**
	 * 是否计量
	 * @param Fg_gauge
	 */
	public void setFg_gauge(FBoolean Fg_gauge) {
		setAttrVal("Fg_gauge", Fg_gauge);
	}
	/**
	 * 是否附加设备(附件)
	 * @return FBoolean
	 */
	public FBoolean getFg_append() {
		return ((FBoolean) getAttrVal("Fg_append"));
	}	
	/**
	 * 是否附加设备(附件)
	 * @param Fg_append
	 */
	public void setFg_append(FBoolean Fg_append) {
		setAttrVal("Fg_append", Fg_append);
	}
	/**
	 * 保管等级
	 * @return String
	 */
	public String getId_stor_level() {
		return ((String) getAttrVal("Id_stor_level"));
	}	
	/**
	 * 保管等级
	 * @param Id_stor_level
	 */
	public void setId_stor_level(String Id_stor_level) {
		setAttrVal("Id_stor_level", Id_stor_level);
	}
	/**
	 * 保管等级编码
	 * @return String
	 */
	public String getSd_stor_level() {
		return ((String) getAttrVal("Sd_stor_level"));
	}	
	/**
	 * 保管等级编码
	 * @param Sd_stor_level
	 */
	public void setSd_stor_level(String Sd_stor_level) {
		setAttrVal("Sd_stor_level", Sd_stor_level);
	}
	/**
	 * 库存上限
	 * @return Integer
	 */
	public Integer getMost_num() {
		return ((Integer) getAttrVal("Most_num"));
	}	
	/**
	 * 库存上限
	 * @param Most_num
	 */
	public void setMost_num(Integer Most_num) {
		setAttrVal("Most_num", Most_num);
	}
	/**
	 * 库存下限
	 * @return Integer
	 */
	public Integer getLowest_num() {
		return ((Integer) getAttrVal("Lowest_num"));
	}	
	/**
	 * 库存下限
	 * @param Lowest_num
	 */
	public void setLowest_num(Integer Lowest_num) {
		setAttrVal("Lowest_num", Lowest_num);
	}
	/**
	 * 品牌名称
	 * @return String
	 */
	public String getBrand_name() {
		return ((String) getAttrVal("Brand_name"));
	}	
	/**
	 * 品牌名称
	 * @param Brand_name
	 */
	public void setBrand_name(String Brand_name) {
		setAttrVal("Brand_name", Brand_name);
	}
	/**
	 * 英文名
	 * @return String
	 */
	public String getEnglish_name() {
		return ((String) getAttrVal("English_name"));
	}	
	/**
	 * 英文名
	 * @param English_name
	 */
	public void setEnglish_name(String English_name) {
		setAttrVal("English_name", English_name);
	}
	/**
	 * 是否自制
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	/**
	 * 是否自制
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 计量仪器分类
	 * @return String
	 */
	public String getId_geca() {
		return ((String) getAttrVal("Id_geca"));
	}	
	/**
	 * 计量仪器分类
	 * @param Id_geca
	 */
	public void setId_geca(String Id_geca) {
		setAttrVal("Id_geca", Id_geca);
	}
	/**
	 * 保养周期（天）
	 * @return Integer
	 */
	public Integer getUpkeep_cyc() {
		return ((Integer) getAttrVal("Upkeep_cyc"));
	}	
	/**
	 * 保养周期（天）
	 * @param Upkeep_cyc
	 */
	public void setUpkeep_cyc(Integer Upkeep_cyc) {
		setAttrVal("Upkeep_cyc", Upkeep_cyc);
	}
	/**
	 * 计量周期（天）
	 * @return Integer
	 */
	public Integer getGauge_cyc() {
		return ((Integer) getAttrVal("Gauge_cyc"));
	}	
	/**
	 * 计量周期（天）
	 * @param Gauge_cyc
	 */
	public void setGauge_cyc(Integer Gauge_cyc) {
		setAttrVal("Gauge_cyc", Gauge_cyc);
	}
	/**
	 * 是否固定资产
	 * @return FBoolean
	 */
	public FBoolean getFg_fixed() {
		return ((FBoolean) getAttrVal("Fg_fixed"));
	}	
	/**
	 * 是否固定资产
	 * @param Fg_fixed
	 */
	public void setFg_fixed(FBoolean Fg_fixed) {
		setAttrVal("Fg_fixed", Fg_fixed);
	}
	/**
	 * 是否急救设备
	 * @return FBoolean
	 */
	public FBoolean getFg_aidem() {
		return ((FBoolean) getAttrVal("Fg_aidem"));
	}	
	/**
	 * 是否急救设备
	 * @param Fg_aidem
	 */
	public void setFg_aidem(FBoolean Fg_aidem) {
		setAttrVal("Fg_aidem", Fg_aidem);
	}
	/**
	 * 是否特殊设备
	 * @return FBoolean
	 */
	public FBoolean getFg_isspecial() {
		return ((FBoolean) getAttrVal("Fg_isspecial"));
	}	
	/**
	 * 是否特殊设备
	 * @param Fg_isspecial
	 */
	public void setFg_isspecial(FBoolean Fg_isspecial) {
		setAttrVal("Fg_isspecial", Fg_isspecial);
	}
	/**
	 * 设备检测周期
	 * @return Integer
	 */
	public Integer getTest_cyc() {
		return ((Integer) getAttrVal("Test_cyc"));
	}	
	/**
	 * 设备检测周期
	 * @param Test_cyc
	 */
	public void setTest_cyc(Integer Test_cyc) {
		setAttrVal("Test_cyc", Test_cyc);
	}
	/**
	 * 是否房屋
	 * @return FBoolean
	 */
	public FBoolean getFg_houses() {
		return ((FBoolean) getAttrVal("Fg_houses"));
	}	
	/**
	 * 是否房屋
	 * @param Fg_houses
	 */
	public void setFg_houses(FBoolean Fg_houses) {
		setAttrVal("Fg_houses", Fg_houses);
	}
	/**
	 * 型号
	 * @return String
	 */
	public String getModel() {
		return ((String) getAttrVal("Model"));
	}	
	/**
	 * 型号
	 * @param Model
	 */
	public void setModel(String Model) {
		setAttrVal("Model", Model);
	}
	/**
	 * 是否压力容器
	 * @return FBoolean
	 */
	public FBoolean getFg_pressure() {
		return ((FBoolean) getAttrVal("Fg_pressure"));
	}	
	/**
	 * 是否压力容器
	 * @param Fg_pressure
	 */
	public void setFg_pressure(FBoolean Fg_pressure) {
		setAttrVal("Fg_pressure", Fg_pressure);
	}
	/**
	 * 是否放射设备
	 * @return FBoolean
	 */
	public FBoolean getFg_radiology() {
		return ((FBoolean) getAttrVal("Fg_radiology"));
	}	
	/**
	 * 是否放射设备
	 * @param Fg_radiology
	 */
	public void setFg_radiology(FBoolean Fg_radiology) {
		setAttrVal("Fg_radiology", Fg_radiology);
	}
	/**
	 * 卫生部编码
	 * @return String
	 */
	public String getMoh_code() {
		return ((String) getAttrVal("Moh_code"));
	}	
	/**
	 * 卫生部编码
	 * @param Moh_code
	 */
	public void setMoh_code(String Moh_code) {
		setAttrVal("Moh_code", Moh_code);
	}
	/**
	 * 政府编码
	 * @return String
	 */
	public String getGover_code() {
		return ((String) getAttrVal("Gover_code"));
	}	
	/**
	 * 政府编码
	 * @param Gover_code
	 */
	public void setGover_code(String Gover_code) {
		setAttrVal("Gover_code", Gover_code);
	}
	/**
	 * 是否试用设备
	 * @return FBoolean
	 */
	public FBoolean getFg_testem() {
		return ((FBoolean) getAttrVal("Fg_testem"));
	}	
	/**
	 * 是否试用设备
	 * @param Fg_testem
	 */
	public void setFg_testem(FBoolean Fg_testem) {
		setAttrVal("Fg_testem", Fg_testem);
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
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	/**
	 * 名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	/**
	 * 编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 包装单位类型名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 包装单位类型名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 包装单位类型编码
	 * @return String
	 */
	public String getCode_unit() {
		return ((String) getAttrVal("Code_unit"));
	}	
	/**
	 * 包装单位类型编码
	 * @param Code_unit
	 */
	public void setCode_unit(String Code_unit) {
		setAttrVal("Code_unit", Code_unit);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_emtp() {
		return ((String) getAttrVal("Name_emtp"));
	}	
	/**
	 * 名称
	 * @param Name_emtp
	 */
	public void setName_emtp(String Name_emtp) {
		setAttrVal("Name_emtp", Name_emtp);
	}
	/**
	 * 折旧名称
	 * @return String
	 */
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	/**
	 * 折旧名称
	 * @param Name_de
	 */
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	/**
	 * 折旧编码
	 * @return String
	 */
	public String getCode_de() {
		return ((String) getAttrVal("Code_de"));
	}	
	/**
	 * 折旧编码
	 * @param Code_de
	 */
	public void setCode_de(String Code_de) {
		setAttrVal("Code_de", Code_de);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sl() {
		return ((String) getAttrVal("Name_sl"));
	}	
	/**
	 * 名称
	 * @param Name_sl
	 */
	public void setName_sl(String Name_sl) {
		setAttrVal("Name_sl", Name_sl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ge() {
		return ((String) getAttrVal("Name_ge"));
	}	
	/**
	 * 名称
	 * @param Name_ge
	 */
	public void setName_ge(String Name_ge) {
		setAttrVal("Name_ge", Name_ge);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_ge() {
		return ((String) getAttrVal("Code_ge"));
	}	
	/**
	 * 编码
	 * @param Code_ge
	 */
	public void setCode_ge(String Code_ge) {
		setAttrVal("Code_ge", Code_ge);
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
		return "Id_em";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_info";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsInfoDODesc.class);
	}
	
}