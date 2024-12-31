package iih.pe.pwf.pereportbi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pereportbi.d.desc.PeReportBiDODesc;
import java.math.BigDecimal;

/**
 * 体检报告二进制格式 DO数据 
 * 
 */
public class PeReportBiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检报告二进制主键标识
	public static final String ID_PEREPORTBI= "Id_pereportbi";
	//体检个人预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//PDF格式
	public static final String FMT_PDF= "Fmt_pdf";
	//JPEG格式
	public static final String FMT_JPEG= "Fmt_jpeg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//PDF格式base64
	public static final String FMT_PDF_BASE64= "Fmt_pdf_base64";
	//JPEG格式base64
	public static final String FMT_JPEG_BASE64= "Fmt_jpeg_base64";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检报告二进制主键标识
	 * @return String
	 */
	public String getId_pereportbi() {
		return ((String) getAttrVal("Id_pereportbi"));
	}	
	/**
	 * 体检报告二进制主键标识
	 * @param Id_pereportbi
	 */
	public void setId_pereportbi(String Id_pereportbi) {
		setAttrVal("Id_pereportbi", Id_pereportbi);
	}
	/**
	 * 体检个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检个人预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * PDF格式
	 * @return byte[]
	 */
	public byte[] getFmt_pdf() {
		return ((byte[]) getAttrVal("Fmt_pdf"));
	}	
	/**
	 * PDF格式
	 * @param Fmt_pdf
	 */
	public void setFmt_pdf(byte[] Fmt_pdf) {
		setAttrVal("Fmt_pdf", Fmt_pdf);
	}
	/**
	 * JPEG格式
	 * @return byte[]
	 */
	public byte[] getFmt_jpeg() {
		return ((byte[]) getAttrVal("Fmt_jpeg"));
	}	
	/**
	 * JPEG格式
	 * @param Fmt_jpeg
	 */
	public void setFmt_jpeg(byte[] Fmt_jpeg) {
		setAttrVal("Fmt_jpeg", Fmt_jpeg);
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
	 * PDF格式base64
	 * @return String
	 */
	public String getFmt_pdf_base64() {
		return ((String) getAttrVal("Fmt_pdf_base64"));
	}	
	/**
	 * PDF格式base64
	 * @param Fmt_pdf_base64
	 */
	public void setFmt_pdf_base64(String Fmt_pdf_base64) {
		setAttrVal("Fmt_pdf_base64", Fmt_pdf_base64);
	}
	/**
	 * JPEG格式base64
	 * @return String
	 */
	public String getFmt_jpeg_base64() {
		return ((String) getAttrVal("Fmt_jpeg_base64"));
	}	
	/**
	 * JPEG格式base64
	 * @param Fmt_jpeg_base64
	 */
	public void setFmt_jpeg_base64(String Fmt_jpeg_base64) {
		setAttrVal("Fmt_jpeg_base64", Fmt_jpeg_base64);
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
		return "Id_pereportbi";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_pereportbi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeReportBiDODesc.class);
	}
	
}