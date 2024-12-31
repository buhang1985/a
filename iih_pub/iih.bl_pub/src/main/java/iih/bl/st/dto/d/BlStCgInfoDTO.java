package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlStCgInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算主键
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 结算主键
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 结算编码
	 * @return String
	 */
	public String getCode_stoep() {
		return ((String) getAttrVal("Code_stoep"));
	}
	/**
	 * 结算编码
	 * @param Code_stoep
	 */
	public void setCode_stoep(String Code_stoep) {
		setAttrVal("Code_stoep", Code_stoep);
	}
	/**
	 * 项目序号
	 * @return String
	 */
	public String getSrvno() {
		return ((String) getAttrVal("Srvno"));
	}
	/**
	 * 项目序号
	 * @param Srvno
	 */
	public void setSrvno(String Srvno) {
		setAttrVal("Srvno", Srvno);
	}
	/**
	 * 处方序号
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方序号
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * HIS项目代码
	 * @return String
	 */
	public String getCode_his() {
		return ((String) getAttrVal("Code_his"));
	}
	/**
	 * HIS项目代码
	 * @param Code_his
	 */
	public void setCode_his(String Code_his) {
		setAttrVal("Code_his", Code_his);
	}
	/**
	 * HIS项目名称
	 * @return String
	 */
	public String getName_his() {
		return ((String) getAttrVal("Name_his"));
	}
	/**
	 * HIS项目名称
	 * @param Name_his
	 */
	public void setName_his(String Name_his) {
		setAttrVal("Name_his", Name_his);
	}
	/**
	 * 医保项目代码
	 * @return String
	 */
	public String getCode_srv_hp() {
		return ((String) getAttrVal("Code_srv_hp"));
	}
	/**
	 * 医保项目代码
	 * @param Code_srv_hp
	 */
	public void setCode_srv_hp(String Code_srv_hp) {
		setAttrVal("Code_srv_hp", Code_srv_hp);
	}
	/**
	 * 医保项目名称
	 * @return String
	 */
	public String getName_srv_hp() {
		return ((String) getAttrVal("Name_srv_hp"));
	}
	/**
	 * 医保项目名称
	 * @param Name_srv_hp
	 */
	public void setName_srv_hp(String Name_srv_hp) {
		setAttrVal("Name_srv_hp", Name_srv_hp);
	}
	/**
	 * 项目类别
	 * @return String
	 */
	public String getType_srv() {
		return ((String) getAttrVal("Type_srv"));
	}
	/**
	 * 项目类别
	 * @param Type_srv
	 */
	public void setType_srv(String Type_srv) {
		setAttrVal("Type_srv", Type_srv);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}
	/**
	 * 剂型
	 * @param Dosage
	 */
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getCompany() {
		return ((String) getAttrVal("Company"));
	}
	/**
	 * 单位
	 * @param Company
	 */
	public void setCompany(String Company) {
		setAttrVal("Company", Company);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 数量
	 * @return Integer
	 */
	public Integer getQuan() {
		return ((Integer) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(Integer Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 项目总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 项目总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getUsage() {
		return ((String) getAttrVal("Usage"));
	}
	/**
	 * 用法
	 * @param Usage
	 */
	public void setUsage(String Usage) {
		setAttrVal("Usage", Usage);
	}
	/**
	 * 单次用量
	 * @return String
	 */
	public String getSingle() {
		return ((String) getAttrVal("Single"));
	}
	/**
	 * 单次用量
	 * @param Single
	 */
	public void setSingle(String Single) {
		setAttrVal("Single", Single);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getPackaging() {
		return ((String) getAttrVal("Packaging"));
	}
	/**
	 * 包装单位
	 * @param Packaging
	 */
	public void setPackaging(String Packaging) {
		setAttrVal("Packaging", Packaging);
	}
	/**
	 * 最小包装
	 * @return String
	 */
	public String getMinpackaging() {
		return ((String) getAttrVal("Minpackaging"));
	}
	/**
	 * 最小包装
	 * @param Minpackaging
	 */
	public void setMinpackaging(String Minpackaging) {
		setAttrVal("Minpackaging", Minpackaging);
	}
	/**
	 * 换算率
	 * @return String
	 */
	public String getConversion() {
		return ((String) getAttrVal("Conversion"));
	}
	/**
	 * 换算率
	 * @param Conversion
	 */
	public void setConversion(String Conversion) {
		setAttrVal("Conversion", Conversion);
	}
	/**
	 * 天数
	 * @return String
	 */
	public String getDays() {
		return ((String) getAttrVal("Days"));
	}
	/**
	 * 天数
	 * @param Days
	 */
	public void setDays(String Days) {
		setAttrVal("Days", Days);
	}
	/**
	 * 处方日期/时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 处方日期/时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 收费类别
	 * @return String
	 */
	public String getType_fee() {
		return ((String) getAttrVal("Type_fee"));
	}
	/**
	 * 收费类别
	 * @param Type_fee
	 */
	public void setType_fee(String Type_fee) {
		setAttrVal("Type_fee", Type_fee);
	}
	/**
	 * 收费等级
	 * @return String
	 */
	public String getLevel_fee() {
		return ((String) getAttrVal("Level_fee"));
	}
	/**
	 * 收费等级
	 * @param Level_fee
	 */
	public void setLevel_fee(String Level_fee) {
		setAttrVal("Level_fee", Level_fee);
	}
	/**
	 * 就诊科别代码
	 * @return String
	 */
	public String getCode_category() {
		return ((String) getAttrVal("Code_category"));
	}
	/**
	 * 就诊科别代码
	 * @param Code_category
	 */
	public void setCode_category(String Code_category) {
		setAttrVal("Code_category", Code_category);
	}
	/**
	 * 就诊科别名称
	 * @return String
	 */
	public String getName_category() {
		return ((String) getAttrVal("Name_category"));
	}
	/**
	 * 就诊科别名称
	 * @param Name_category
	 */
	public void setName_category(String Name_category) {
		setAttrVal("Name_category", Name_category);
	}
	/**
	 * 本院科别名称
	 * @return String
	 */
	public String getName_category_court() {
		return ((String) getAttrVal("Name_category_court"));
	}
	/**
	 * 本院科别名称
	 * @param Name_category_court
	 */
	public void setName_category_court(String Name_category_court) {
		setAttrVal("Name_category_court", Name_category_court);
	}
	/**
	 * 医师姓名
	 * @return String
	 */
	public String getName_physician() {
		return ((String) getAttrVal("Name_physician"));
	}
	/**
	 * 医师姓名
	 * @param Name_physician
	 */
	public void setName_physician(String Name_physician) {
		setAttrVal("Name_physician", Name_physician);
	}
}