package iih.pe.pwf.perstimg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstimg.d.desc.PeRstImgDODesc;
import java.math.BigDecimal;

/**
 * 体检结果文档附件 DO数据 
 * 
 */
public class PeRstImgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果文档主键标识
	public static final String ID_PERSTIMG= "Id_perstimg";
	//体检结果主键
	public static final String ID_PERST= "Id_perst";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//文档描述
	public static final String DOC_DESC= "Doc_desc";
	//序号
	public static final String SORTNO= "Sortno";
	//文档类型
	public static final String DOCTP= "Doctp";
	//检查时间
	public static final String DT_EXAM= "Dt_exam";
	//报告时间
	public static final String DT_REPORT= "Dt_report";
	//原始文档
	public static final String DOCS= "Docs";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//pdf格式文件
	public static final String PDF= "Pdf";
	//患者编码
	public static final String PATCODE= "Patcode";
	//就诊次数
	public static final String TIMES_INHOS= "Times_inhos";
	//申请单号
	public static final String NO_APPLY= "No_apply";
	//系统编码
	public static final String CODE_SYS= "Code_sys";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果文档主键标识
	 * @return String
	 */
	public String getId_perstimg() {
		return ((String) getAttrVal("Id_perstimg"));
	}	
	/**
	 * 体检结果文档主键标识
	 * @param Id_perstimg
	 */
	public void setId_perstimg(String Id_perstimg) {
		setAttrVal("Id_perstimg", Id_perstimg);
	}
	/**
	 * 体检结果主键
	 * @return String
	 */
	public String getId_perst() {
		return ((String) getAttrVal("Id_perst"));
	}	
	/**
	 * 体检结果主键
	 * @param Id_perst
	 */
	public void setId_perst(String Id_perst) {
		setAttrVal("Id_perst", Id_perst);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 文档描述
	 * @return String
	 */
	public String getDoc_desc() {
		return ((String) getAttrVal("Doc_desc"));
	}	
	/**
	 * 文档描述
	 * @param Doc_desc
	 */
	public void setDoc_desc(String Doc_desc) {
		setAttrVal("Doc_desc", Doc_desc);
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
	 * 文档类型
	 * @return Integer
	 */
	public Integer getDoctp() {
		return ((Integer) getAttrVal("Doctp"));
	}	
	/**
	 * 文档类型
	 * @param Doctp
	 */
	public void setDoctp(Integer Doctp) {
		setAttrVal("Doctp", Doctp);
	}
	/**
	 * 检查时间
	 * @return String
	 */
	public String getDt_exam() {
		return ((String) getAttrVal("Dt_exam"));
	}	
	/**
	 * 检查时间
	 * @param Dt_exam
	 */
	public void setDt_exam(String Dt_exam) {
		setAttrVal("Dt_exam", Dt_exam);
	}
	/**
	 * 报告时间
	 * @return String
	 */
	public String getDt_report() {
		return ((String) getAttrVal("Dt_report"));
	}	
	/**
	 * 报告时间
	 * @param Dt_report
	 */
	public void setDt_report(String Dt_report) {
		setAttrVal("Dt_report", Dt_report);
	}
	/**
	 * 原始文档
	 * @return byte[]
	 */
	public byte[] getDocs() {
		return ((byte[]) getAttrVal("Docs"));
	}	
	/**
	 * 原始文档
	 * @param Docs
	 */
	public void setDocs(byte[] Docs) {
		setAttrVal("Docs", Docs);
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
	 * pdf格式文件
	 * @return String
	 */
	public String getPdf() {
		return ((String) getAttrVal("Pdf"));
	}	
	/**
	 * pdf格式文件
	 * @param Pdf
	 */
	public void setPdf(String Pdf) {
		setAttrVal("Pdf", Pdf);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}	
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_inhos() {
		return ((Integer) getAttrVal("Times_inhos"));
	}	
	/**
	 * 就诊次数
	 * @param Times_inhos
	 */
	public void setTimes_inhos(Integer Times_inhos) {
		setAttrVal("Times_inhos", Times_inhos);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_apply() {
		return ((String) getAttrVal("No_apply"));
	}	
	/**
	 * 申请单号
	 * @param No_apply
	 */
	public void setNo_apply(String No_apply) {
		setAttrVal("No_apply", No_apply);
	}
	/**
	 * 系统编码
	 * @return String
	 */
	public String getCode_sys() {
		return ((String) getAttrVal("Code_sys"));
	}	
	/**
	 * 系统编码
	 * @param Code_sys
	 */
	public void setCode_sys(String Code_sys) {
		setAttrVal("Code_sys", Code_sys);
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
		return "Id_perstimg";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstimg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstImgDODesc.class);
	}
	
}