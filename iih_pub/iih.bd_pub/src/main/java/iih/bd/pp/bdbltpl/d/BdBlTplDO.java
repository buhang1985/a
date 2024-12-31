package iih.bd.pp.bdbltpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdbltpl.d.desc.BdBlTplDODesc;
import java.math.BigDecimal;

/**
 * 自定义费用模板 DO数据 
 * 
 */
public class BdBlTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//自定义费用模板主键
	public static final String ID_BLTPL= "Id_bltpl";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//模板描述
	public static final String DES= "Des";
	//费用模板所属类型编码
	public static final String SD_OWTP= "Sd_owtp";
	//费用模板所属类型ID
	public static final String ID_OWTP= "Id_owtp";
	//费用模板类型编码
	public static final String SD_BLTPLTP= "Sd_bltpltp";
	//费用模板类型ID
	public static final String ID_BLTPLTP= "Id_bltpltp";
	//责任科室
	public static final String ID_DEP= "Id_dep";
	//责任人
	public static final String ID_EMP= "Id_emp";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//五笔
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//所属类型编码
	public static final String OWTP_CODE= "Owtp_code";
	//所属类型名称
	public static final String OWTP_NAME= "Owtp_name";
	//费用模板类型编码
	public static final String BLTPLTP_CODE= "Bltpltp_code";
	//费用模板类型名称
	public static final String BLTPLTP_NAME= "Bltpltp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 自定义费用模板主键
	 * @return String
	 */
	public String getId_bltpl() {
		return ((String) getAttrVal("Id_bltpl"));
	}	
	/**
	 * 自定义费用模板主键
	 * @param Id_bltpl
	 */
	public void setId_bltpl(String Id_bltpl) {
		setAttrVal("Id_bltpl", Id_bltpl);
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
	 * 模板描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 模板描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 费用模板所属类型编码
	 * @return String
	 */
	public String getSd_owtp() {
		return ((String) getAttrVal("Sd_owtp"));
	}	
	/**
	 * 费用模板所属类型编码
	 * @param Sd_owtp
	 */
	public void setSd_owtp(String Sd_owtp) {
		setAttrVal("Sd_owtp", Sd_owtp);
	}
	/**
	 * 费用模板所属类型ID
	 * @return String
	 */
	public String getId_owtp() {
		return ((String) getAttrVal("Id_owtp"));
	}	
	/**
	 * 费用模板所属类型ID
	 * @param Id_owtp
	 */
	public void setId_owtp(String Id_owtp) {
		setAttrVal("Id_owtp", Id_owtp);
	}
	/**
	 * 费用模板类型编码
	 * @return String
	 */
	public String getSd_bltpltp() {
		return ((String) getAttrVal("Sd_bltpltp"));
	}	
	/**
	 * 费用模板类型编码
	 * @param Sd_bltpltp
	 */
	public void setSd_bltpltp(String Sd_bltpltp) {
		setAttrVal("Sd_bltpltp", Sd_bltpltp);
	}
	/**
	 * 费用模板类型ID
	 * @return String
	 */
	public String getId_bltpltp() {
		return ((String) getAttrVal("Id_bltpltp"));
	}	
	/**
	 * 费用模板类型ID
	 * @param Id_bltpltp
	 */
	public void setId_bltpltp(String Id_bltpltp) {
		setAttrVal("Id_bltpltp", Id_bltpltp);
	}
	/**
	 * 责任科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 责任科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 责任人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 责任人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
	 * 所属类型编码
	 * @return String
	 */
	public String getOwtp_code() {
		return ((String) getAttrVal("Owtp_code"));
	}	
	/**
	 * 所属类型编码
	 * @param Owtp_code
	 */
	public void setOwtp_code(String Owtp_code) {
		setAttrVal("Owtp_code", Owtp_code);
	}
	/**
	 * 所属类型名称
	 * @return String
	 */
	public String getOwtp_name() {
		return ((String) getAttrVal("Owtp_name"));
	}	
	/**
	 * 所属类型名称
	 * @param Owtp_name
	 */
	public void setOwtp_name(String Owtp_name) {
		setAttrVal("Owtp_name", Owtp_name);
	}
	/**
	 * 费用模板类型编码
	 * @return String
	 */
	public String getBltpltp_code() {
		return ((String) getAttrVal("Bltpltp_code"));
	}	
	/**
	 * 费用模板类型编码
	 * @param Bltpltp_code
	 */
	public void setBltpltp_code(String Bltpltp_code) {
		setAttrVal("Bltpltp_code", Bltpltp_code);
	}
	/**
	 * 费用模板类型名称
	 * @return String
	 */
	public String getBltpltp_name() {
		return ((String) getAttrVal("Bltpltp_name"));
	}	
	/**
	 * 费用模板类型名称
	 * @param Bltpltp_name
	 */
	public void setBltpltp_name(String Bltpltp_name) {
		setAttrVal("Bltpltp_name", Bltpltp_name);
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
		return "Id_bltpl";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_bltpl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdBlTplDODesc.class);
	}
	
}