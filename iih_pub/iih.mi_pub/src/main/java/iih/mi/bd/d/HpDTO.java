package iih.mi.bd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保产品DTO DTO数据 
 * 
 */
public class HpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保产品主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
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
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 可用预交金标志
	 * @return FBoolean
	 */
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}
	/**
	 * 可用预交金标志
	 * @param Fg_prepay
	 */
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	/**
	 * 持卡结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cardst() {
		return ((FBoolean) getAttrVal("Fg_cardst"));
	}
	/**
	 * 持卡结算标志
	 * @param Fg_cardst
	 */
	public void setFg_cardst(FBoolean Fg_cardst) {
		setAttrVal("Fg_cardst", Fg_cardst);
	}
	/**
	 * 医保记账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}
	/**
	 * 医保记账标志
	 * @param Fg_hpcg
	 */
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 工厂实例
	 * @return String
	 */
	public String getFactoryinst() {
		return ((String) getAttrVal("Factoryinst"));
	}
	/**
	 * 工厂实例
	 * @param Factoryinst
	 */
	public void setFactoryinst(String Factoryinst) {
		setAttrVal("Factoryinst", Factoryinst);
	}
	/**
	 * webservice调用超时时长(秒)
	 * @return String
	 */
	public String getWsinvoketimeouts() {
		return ((String) getAttrVal("Wsinvoketimeouts"));
	}
	/**
	 * webservice调用超时时长(秒)
	 * @param Wsinvoketimeouts
	 */
	public void setWsinvoketimeouts(String Wsinvoketimeouts) {
		setAttrVal("Wsinvoketimeouts", Wsinvoketimeouts);
	}
	/**
	 * webservice调用地址
	 * @return String
	 */
	public String getWsinvokeurl() {
		return ((String) getAttrVal("Wsinvokeurl"));
	}
	/**
	 * webservice调用地址
	 * @param Wsinvokeurl
	 */
	public void setWsinvokeurl(String Wsinvokeurl) {
		setAttrVal("Wsinvokeurl", Wsinvokeurl);
	}
	/**
	 * webservice调用用户名
	 * @return String
	 */
	public String getWsinvokeusername() {
		return ((String) getAttrVal("Wsinvokeusername"));
	}
	/**
	 * webservice调用用户名
	 * @param Wsinvokeusername
	 */
	public void setWsinvokeusername(String Wsinvokeusername) {
		setAttrVal("Wsinvokeusername", Wsinvokeusername);
	}
	/**
	 * 第三方数据源
	 * @return String
	 */
	public String getDatasourcename() {
		return ((String) getAttrVal("Datasourcename"));
	}
	/**
	 * 第三方数据源
	 * @param Datasourcename
	 */
	public void setDatasourcename(String Datasourcename) {
		setAttrVal("Datasourcename", Datasourcename);
	}
	/**
	 * 定点医疗机构编码
	 * @return String
	 */
	public String getDesigmicode() {
		return ((String) getAttrVal("Desigmicode"));
	}
	/**
	 * 定点医疗机构编码
	 * @param Desigmicode
	 */
	public void setDesigmicode(String Desigmicode) {
		setAttrVal("Desigmicode", Desigmicode);
	}
	/**
	 * 定点医疗机构名称
	 * @return String
	 */
	public String getDesigminame() {
		return ((String) getAttrVal("Desigminame"));
	}
	/**
	 * 定点医疗机构名称
	 * @param Desigminame
	 */
	public void setDesigminame(String Desigminame) {
		setAttrVal("Desigminame", Desigminame);
	}
	/**
	 * 患者来源
	 * @return String
	 */
	public String getId_patsource() {
		return ((String) getAttrVal("Id_patsource"));
	}
	/**
	 * 患者来源
	 * @param Id_patsource
	 */
	public void setId_patsource(String Id_patsource) {
		setAttrVal("Id_patsource", Id_patsource);
	}
	/**
	 * 患者来源编码
	 * @return String
	 */
	public String getSd_patsource() {
		return ((String) getAttrVal("Sd_patsource"));
	}
	/**
	 * 患者来源编码
	 * @param Sd_patsource
	 */
	public void setSd_patsource(String Sd_patsource) {
		setAttrVal("Sd_patsource", Sd_patsource);
	}
	/**
	 * 医疗机构级别代码
	 * @return String
	 */
	public String getHoslevel_code() {
		return ((String) getAttrVal("Hoslevel_code"));
	}
	/**
	 * 医疗机构级别代码
	 * @param Hoslevel_code
	 */
	public void setHoslevel_code(String Hoslevel_code) {
		setAttrVal("Hoslevel_code", Hoslevel_code);
	}
	/**
	 * 医疗机构级别名称
	 * @return String
	 */
	public String getHoslevel_name() {
		return ((String) getAttrVal("Hoslevel_name"));
	}
	/**
	 * 医疗机构级别名称
	 * @param Hoslevel_name
	 */
	public void setHoslevel_name(String Hoslevel_name) {
		setAttrVal("Hoslevel_name", Hoslevel_name);
	}
	/**
	 * 就医地地区编码
	 * @return String
	 */
	public String getMeddistcode() {
		return ((String) getAttrVal("Meddistcode"));
	}
	/**
	 * 就医地地区编码
	 * @param Meddistcode
	 */
	public void setMeddistcode(String Meddistcode) {
		setAttrVal("Meddistcode", Meddistcode);
	}
	/**
	 * 住院医保结算导出路径
	 * @return String
	 */
	public String getIpstexppath() {
		return ((String) getAttrVal("Ipstexppath"));
	}
	/**
	 * 住院医保结算导出路径
	 * @param Ipstexppath
	 */
	public void setIpstexppath(String Ipstexppath) {
		setAttrVal("Ipstexppath", Ipstexppath);
	}
	/**
	 * 住院医保结算导入路径
	 * @return String
	 */
	public String getIpstimppath() {
		return ((String) getAttrVal("Ipstimppath"));
	}
	/**
	 * 住院医保结算导入路径
	 * @param Ipstimppath
	 */
	public void setIpstimppath(String Ipstimppath) {
		setAttrVal("Ipstimppath", Ipstimppath);
	}
}