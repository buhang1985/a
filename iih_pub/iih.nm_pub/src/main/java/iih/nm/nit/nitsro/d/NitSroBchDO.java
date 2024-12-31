package iih.nm.nit.nitsro.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitsro.d.desc.NitSroBchDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_实习单位_实习年月 DO数据 
 * 
 */
public class NitSroBchDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//批次主键标识
	public static final String ID_NIT_SRO_BCH= "Id_nit_sro_bch";
	//实习单位外键
	public static final String ID_NIT_SRO= "Id_nit_sro";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//实习年月
	public static final String NAME= "Name";
	//批次编号
	public static final String CODE= "Code";
	//年份
	public static final String YEAR= "Year";
	//学历id
	public static final String ID_EDUCATION= "Id_education";
	//学历
	public static final String SD_EDUCATION= "Sd_education";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//截止日期
	public static final String DT_END= "Dt_end";
	//负责人
	public static final String NAME_HEAD= "Name_head";
	//负责人电话
	public static final String TEL_HEAD= "Tel_head";
	//联系人
	public static final String NAME_CONTACT= "Name_contact";
	//联系人电话
	public static final String TEL_CONTACT= "Tel_contact";
	//登记人
	public static final String ID_EMP_REG= "Id_emp_reg";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//描述
	public static final String DES= "Des";
	//实习人数
	public static final String COUNT_PSN= "Count_psn";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//实习单位
	public static final String NAME_NIT_SRO= "Name_nit_sro";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//集团名称
	public static final String NAME_GRP= "Name_grp";
	//名称
	public static final String NAME_EDUCATE= "Name_educate";
	//登记人姓名
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 批次主键标识
	 * @return String
	 */
	public String getId_nit_sro_bch() {
		return ((String) getAttrVal("Id_nit_sro_bch"));
	}	
	/**
	 * 批次主键标识
	 * @param Id_nit_sro_bch
	 */
	public void setId_nit_sro_bch(String Id_nit_sro_bch) {
		setAttrVal("Id_nit_sro_bch", Id_nit_sro_bch);
	}
	/**
	 * 实习单位外键
	 * @return String
	 */
	public String getId_nit_sro() {
		return ((String) getAttrVal("Id_nit_sro"));
	}	
	/**
	 * 实习单位外键
	 * @param Id_nit_sro
	 */
	public void setId_nit_sro(String Id_nit_sro) {
		setAttrVal("Id_nit_sro", Id_nit_sro);
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
	 * 实习年月
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 实习年月
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 批次编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 批次编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 年份
	 * @return Integer
	 */
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	/**
	 * 年份
	 * @param Year
	 */
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	/**
	 * 学历id
	 * @return String
	 */
	public String getId_education() {
		return ((String) getAttrVal("Id_education"));
	}	
	/**
	 * 学历id
	 * @param Id_education
	 */
	public void setId_education(String Id_education) {
		setAttrVal("Id_education", Id_education);
	}
	/**
	 * 学历
	 * @return String
	 */
	public String getSd_education() {
		return ((String) getAttrVal("Sd_education"));
	}	
	/**
	 * 学历
	 * @param Sd_education
	 */
	public void setSd_education(String Sd_education) {
		setAttrVal("Sd_education", Sd_education);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 负责人
	 * @return String
	 */
	public String getName_head() {
		return ((String) getAttrVal("Name_head"));
	}	
	/**
	 * 负责人
	 * @param Name_head
	 */
	public void setName_head(String Name_head) {
		setAttrVal("Name_head", Name_head);
	}
	/**
	 * 负责人电话
	 * @return String
	 */
	public String getTel_head() {
		return ((String) getAttrVal("Tel_head"));
	}	
	/**
	 * 负责人电话
	 * @param Tel_head
	 */
	public void setTel_head(String Tel_head) {
		setAttrVal("Tel_head", Tel_head);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getName_contact() {
		return ((String) getAttrVal("Name_contact"));
	}	
	/**
	 * 联系人
	 * @param Name_contact
	 */
	public void setName_contact(String Name_contact) {
		setAttrVal("Name_contact", Name_contact);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getTel_contact() {
		return ((String) getAttrVal("Tel_contact"));
	}	
	/**
	 * 联系人电话
	 * @param Tel_contact
	 */
	public void setTel_contact(String Tel_contact) {
		setAttrVal("Tel_contact", Tel_contact);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	/**
	 * 登记人
	 * @param Id_emp_reg
	 */
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	 * 实习人数
	 * @return Integer
	 */
	public Integer getCount_psn() {
		return ((Integer) getAttrVal("Count_psn"));
	}	
	/**
	 * 实习人数
	 * @param Count_psn
	 */
	public void setCount_psn(Integer Count_psn) {
		setAttrVal("Count_psn", Count_psn);
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
	 * 实习单位
	 * @return String
	 */
	public String getName_nit_sro() {
		return ((String) getAttrVal("Name_nit_sro"));
	}	
	/**
	 * 实习单位
	 * @param Name_nit_sro
	 */
	public void setName_nit_sro(String Name_nit_sro) {
		setAttrVal("Name_nit_sro", Name_nit_sro);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_educate() {
		return ((String) getAttrVal("Name_educate"));
	}	
	/**
	 * 名称
	 * @param Name_educate
	 */
	public void setName_educate(String Name_educate) {
		setAttrVal("Name_educate", Name_educate);
	}
	/**
	 * 登记人姓名
	 * @return String
	 */
	public String getName_emp_reg() {
		return ((String) getAttrVal("Name_emp_reg"));
	}	
	/**
	 * 登记人姓名
	 * @param Name_emp_reg
	 */
	public void setName_emp_reg(String Name_emp_reg) {
		setAttrVal("Name_emp_reg", Name_emp_reg);
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
		return "Id_nit_sro_bch";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_SRO_BCH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitSroBchDODesc.class);
	}
	
}