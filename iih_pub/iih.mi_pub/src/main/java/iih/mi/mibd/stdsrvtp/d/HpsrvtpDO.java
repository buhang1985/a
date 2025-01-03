package iih.mi.mibd.stdsrvtp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mibd.stdsrvtp.d.desc.HpsrvtpDODesc;
import java.math.BigDecimal;

/**
 * 医保计划下医保目录等级对照 DO数据 
 * 
 */
public class HpsrvtpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保计划医保目录等级对照主键
	public static final String ID_HPSRVTPVSIIH= "Id_hpsrvtpvsiih";
	//机构
	public static final String ID_ORG= "Id_org";
	//医保计划下的医保目录等级
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	//通用报销等级
	public static final String SD_STD_HPSRVTP= "Sd_std_hpsrvtp";
	//备注
	public static final String NOTE= "Note";
	//名称
	public static final String NAME= "Name";
	//助记码
	public static final String MNECODE= "Mnecode";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔
	public static final String WBCODE= "Wbcode";
	//启用状态
	public static final String ACTIVESTATE= "Activestate";
	//编码
	public static final String CODE= "Code";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保计划医保目录等级对照主键
	 * @return String
	 */
	public String getId_hpsrvtpvsiih() {
		return ((String) getAttrVal("Id_hpsrvtpvsiih"));
	}	
	/**
	 * 医保计划医保目录等级对照主键
	 * @param Id_hpsrvtpvsiih
	 */
	public void setId_hpsrvtpvsiih(String Id_hpsrvtpvsiih) {
		setAttrVal("Id_hpsrvtpvsiih", Id_hpsrvtpvsiih);
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
	 * 医保计划下的医保目录等级
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	/**
	 * 医保计划下的医保目录等级
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 通用报销等级
	 * @return Integer
	 */
	public Integer getSd_std_hpsrvtp() {
		return ((Integer) getAttrVal("Sd_std_hpsrvtp"));
	}	
	/**
	 * 通用报销等级
	 * @param Sd_std_hpsrvtp
	 */
	public void setSd_std_hpsrvtp(Integer Sd_std_hpsrvtp) {
		setAttrVal("Sd_std_hpsrvtp", Sd_std_hpsrvtp);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 启用状态
	 * @return Integer
	 */
	public Integer getActivestate() {
		return ((Integer) getAttrVal("Activestate"));
	}	
	/**
	 * 启用状态
	 * @param Activestate
	 */
	public void setActivestate(Integer Activestate) {
		setAttrVal("Activestate", Activestate);
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
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
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
		return "Id_hpsrvtpvsiih";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_hpsrvtp_vs_stdhpsrvtp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpsrvtpDODesc.class);
	}
	
}