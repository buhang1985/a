package iih.bd.mm.supplier.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.supplier.d.desc.SupplierDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_供应商与厂商 DO数据 
 * 
 */
public class SupplierDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//供应商与厂商主键
	public static final String ID_SUP= "Id_sup";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//供应商与厂商编码
	public static final String CODE= "Code";
	//供应商与厂商名称
	public static final String NAME= "Name";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//输入符
	public static final String INSTR= "Instr";
	//供应商与厂商描述
	public static final String DES= "Des";
	//是否生产厂商标志
	public static final String FG_FAC= "Fg_fac";
	//是否供应商标志
	public static final String FG_SUP= "Fg_sup";
	//供应商与厂商产品范围
	public static final String MMRANGE= "Mmrange";
	//供应商与厂商地址
	public static final String ADDR= "Addr";
	//供应商与厂商电话
	public static final String TEL= "Tel";
	//供应商与厂商邮编
	public static final String POSTCODE= "Postcode";
	//供应商与厂商联系人
	public static final String LINKMAN= "Linkman";
	//药品标志
	public static final String FG_MM= "Fg_mm";
	//高值耗材标志
	public static final String FG_HIGHVAL= "Fg_highval";
	//低值耗材标志
	public static final String FG_LOWVAL= "Fg_lowval";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 供应商与厂商主键
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 供应商与厂商主键
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
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
	 * 供应商与厂商编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 供应商与厂商编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 输入符
	 * @return String
	 */
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	/**
	 * 输入符
	 * @param Instr
	 */
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
	}
	/**
	 * 供应商与厂商描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 供应商与厂商描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 是否生产厂商标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fac() {
		return ((FBoolean) getAttrVal("Fg_fac"));
	}	
	/**
	 * 是否生产厂商标志
	 * @param Fg_fac
	 */
	public void setFg_fac(FBoolean Fg_fac) {
		setAttrVal("Fg_fac", Fg_fac);
	}
	/**
	 * 是否供应商标志
	 * @return FBoolean
	 */
	public FBoolean getFg_sup() {
		return ((FBoolean) getAttrVal("Fg_sup"));
	}	
	/**
	 * 是否供应商标志
	 * @param Fg_sup
	 */
	public void setFg_sup(FBoolean Fg_sup) {
		setAttrVal("Fg_sup", Fg_sup);
	}
	/**
	 * 供应商与厂商产品范围
	 * @return String
	 */
	public String getMmrange() {
		return ((String) getAttrVal("Mmrange"));
	}	
	/**
	 * 供应商与厂商产品范围
	 * @param Mmrange
	 */
	public void setMmrange(String Mmrange) {
		setAttrVal("Mmrange", Mmrange);
	}
	/**
	 * 供应商与厂商地址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}	
	/**
	 * 供应商与厂商地址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 供应商与厂商电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 供应商与厂商电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 供应商与厂商邮编
	 * @return String
	 */
	public String getPostcode() {
		return ((String) getAttrVal("Postcode"));
	}	
	/**
	 * 供应商与厂商邮编
	 * @param Postcode
	 */
	public void setPostcode(String Postcode) {
		setAttrVal("Postcode", Postcode);
	}
	/**
	 * 供应商与厂商联系人
	 * @return String
	 */
	public String getLinkman() {
		return ((String) getAttrVal("Linkman"));
	}	
	/**
	 * 供应商与厂商联系人
	 * @param Linkman
	 */
	public void setLinkman(String Linkman) {
		setAttrVal("Linkman", Linkman);
	}
	/**
	 * 药品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 药品标志
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 高值耗材标志
	 * @return FBoolean
	 */
	public FBoolean getFg_highval() {
		return ((FBoolean) getAttrVal("Fg_highval"));
	}	
	/**
	 * 高值耗材标志
	 * @param Fg_highval
	 */
	public void setFg_highval(FBoolean Fg_highval) {
		setAttrVal("Fg_highval", Fg_highval);
	}
	/**
	 * 低值耗材标志
	 * @return FBoolean
	 */
	public FBoolean getFg_lowval() {
		return ((FBoolean) getAttrVal("Fg_lowval"));
	}	
	/**
	 * 低值耗材标志
	 * @param Fg_lowval
	 */
	public void setFg_lowval(FBoolean Fg_lowval) {
		setAttrVal("Fg_lowval", Fg_lowval);
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
		return "Id_sup";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_SUP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SupplierDODesc.class);
	}
	
}