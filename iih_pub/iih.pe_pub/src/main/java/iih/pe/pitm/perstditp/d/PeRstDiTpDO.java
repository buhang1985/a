package iih.pe.pitm.perstditp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstditp.d.desc.PeRstDiTpDODesc;
import java.math.BigDecimal;

/**
 * 体检诊断目录定义 DO数据 
 * 
 */
public class PeRstDiTpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检诊断目录主键标识
	public static final String ID_PERSTDITP= "Id_perstditp";
	//体检诊断目录父ID
	public static final String ID_PERSTDITP_PAR= "Id_perstditp_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//诊断目录编码
	public static final String CODE= "Code";
	//诊断目录名称
	public static final String NAME= "Name";
	//次序
	public static final String SORTNO= "Sortno";
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
	//诊断目录编码
	public static final String CODE_DITP= "Code_ditp";
	//诊断目录名称
	public static final String NAME_DITP= "Name_ditp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检诊断目录主键标识
	 * @return String
	 */
	public String getId_perstditp() {
		return ((String) getAttrVal("Id_perstditp"));
	}	
	/**
	 * 体检诊断目录主键标识
	 * @param Id_perstditp
	 */
	public void setId_perstditp(String Id_perstditp) {
		setAttrVal("Id_perstditp", Id_perstditp);
	}
	/**
	 * 体检诊断目录父ID
	 * @return String
	 */
	public String getId_perstditp_par() {
		return ((String) getAttrVal("Id_perstditp_par"));
	}	
	/**
	 * 体检诊断目录父ID
	 * @param Id_perstditp_par
	 */
	public void setId_perstditp_par(String Id_perstditp_par) {
		setAttrVal("Id_perstditp_par", Id_perstditp_par);
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
	 * 诊断目录编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 诊断目录编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 诊断目录名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 诊断目录名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 诊断目录编码
	 * @return String
	 */
	public String getCode_ditp() {
		return ((String) getAttrVal("Code_ditp"));
	}	
	/**
	 * 诊断目录编码
	 * @param Code_ditp
	 */
	public void setCode_ditp(String Code_ditp) {
		setAttrVal("Code_ditp", Code_ditp);
	}
	/**
	 * 诊断目录名称
	 * @return String
	 */
	public String getName_ditp() {
		return ((String) getAttrVal("Name_ditp"));
	}	
	/**
	 * 诊断目录名称
	 * @param Name_ditp
	 */
	public void setName_ditp(String Name_ditp) {
		setAttrVal("Name_ditp", Name_ditp);
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
		return "Id_perstditp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstditp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstDiTpDODesc.class);
	}
	
}