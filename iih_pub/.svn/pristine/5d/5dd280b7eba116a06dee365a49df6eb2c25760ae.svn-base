package iih.pi.reg.pat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.reg.pat.d.desc.PiPatContDODesc;
import java.math.BigDecimal;

/**
 * 患者联系人 DO数据 
 * 
 */
public class PiPatContDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者联系人主键
	public static final String ID_PATCONT= "Id_patcont";
	//患者主键
	public static final String ID_PAT= "Id_pat";
	//联系人类型
	public static final String ID_CONTTP= "Id_conttp";
	//联系人类型编码
	public static final String SD_CONTTP= "Sd_conttp";
	//亲属身份
	public static final String ID_FMROLE= "Id_fmrole";
	//亲属身份编码
	public static final String SD_FMROLE= "Sd_fmrole";
	//联系人名称
	public static final String NAME= "Name";
	//联系人电话
	public static final String CONTTEL= "Conttel";
	//联系人地址
	public static final String CONTADDR= "Contaddr";
	//邮政编码
	public static final String ZIP= "Zip";
	//序号
	public static final String SORTNO= "Sortno";
	//联系人证件类型
	public static final String ID_CONT= "Id_cont";
	//联系人证件类型编码
	public static final String SD_CONT= "Sd_cont";
	//联系人证件号码
	public static final String CONTID= "Contid";
	//监护人标记
	public static final String FG_GUARDIAN= "Fg_guardian";
	//IE平台传输标志（计算列）
	public static final String FG_IEUSE= "Fg_ieuse";
	//编码
	public static final String CONTTP_CODE= "Conttp_code";
	//名称
	public static final String CONTTP_NAME= "Conttp_name";
	//亲属身份名称
	public static final String NAME_FMROLE= "Name_fmrole";
	//名称
	public static final String CONTNAME= "Contname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者联系人主键
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}	
	/**
	 * 患者联系人主键
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 联系人类型
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}	
	/**
	 * 联系人类型
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人类型编码
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}	
	/**
	 * 联系人类型编码
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 亲属身份
	 * @return String
	 */
	public String getId_fmrole() {
		return ((String) getAttrVal("Id_fmrole"));
	}	
	/**
	 * 亲属身份
	 * @param Id_fmrole
	 */
	public void setId_fmrole(String Id_fmrole) {
		setAttrVal("Id_fmrole", Id_fmrole);
	}
	/**
	 * 亲属身份编码
	 * @return String
	 */
	public String getSd_fmrole() {
		return ((String) getAttrVal("Sd_fmrole"));
	}	
	/**
	 * 亲属身份编码
	 * @param Sd_fmrole
	 */
	public void setSd_fmrole(String Sd_fmrole) {
		setAttrVal("Sd_fmrole", Sd_fmrole);
	}
	/**
	 * 联系人名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 联系人名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getConttel() {
		return ((String) getAttrVal("Conttel"));
	}	
	/**
	 * 联系人电话
	 * @param Conttel
	 */
	public void setConttel(String Conttel) {
		setAttrVal("Conttel", Conttel);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getContaddr() {
		return ((String) getAttrVal("Contaddr"));
	}	
	/**
	 * 联系人地址
	 * @param Contaddr
	 */
	public void setContaddr(String Contaddr) {
		setAttrVal("Contaddr", Contaddr);
	}
	/**
	 * 邮政编码
	 * @return String
	 */
	public String getZip() {
		return ((String) getAttrVal("Zip"));
	}	
	/**
	 * 邮政编码
	 * @param Zip
	 */
	public void setZip(String Zip) {
		setAttrVal("Zip", Zip);
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
	 * 联系人证件类型
	 * @return String
	 */
	public String getId_cont() {
		return ((String) getAttrVal("Id_cont"));
	}	
	/**
	 * 联系人证件类型
	 * @param Id_cont
	 */
	public void setId_cont(String Id_cont) {
		setAttrVal("Id_cont", Id_cont);
	}
	/**
	 * 联系人证件类型编码
	 * @return String
	 */
	public String getSd_cont() {
		return ((String) getAttrVal("Sd_cont"));
	}	
	/**
	 * 联系人证件类型编码
	 * @param Sd_cont
	 */
	public void setSd_cont(String Sd_cont) {
		setAttrVal("Sd_cont", Sd_cont);
	}
	/**
	 * 联系人证件号码
	 * @return String
	 */
	public String getContid() {
		return ((String) getAttrVal("Contid"));
	}	
	/**
	 * 联系人证件号码
	 * @param Contid
	 */
	public void setContid(String Contid) {
		setAttrVal("Contid", Contid);
	}
	/**
	 * 监护人标记
	 * @return FBoolean
	 */
	public FBoolean getFg_guardian() {
		return ((FBoolean) getAttrVal("Fg_guardian"));
	}	
	/**
	 * 监护人标记
	 * @param Fg_guardian
	 */
	public void setFg_guardian(FBoolean Fg_guardian) {
		setAttrVal("Fg_guardian", Fg_guardian);
	}
	/**
	 * IE平台传输标志（计算列）
	 * @return FBoolean
	 */
	public FBoolean getFg_ieuse() {
		return ((FBoolean) getAttrVal("Fg_ieuse"));
	}	
	/**
	 * IE平台传输标志（计算列）
	 * @param Fg_ieuse
	 */
	public void setFg_ieuse(FBoolean Fg_ieuse) {
		setAttrVal("Fg_ieuse", Fg_ieuse);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getConttp_code() {
		return ((String) getAttrVal("Conttp_code"));
	}	
	/**
	 * 编码
	 * @param Conttp_code
	 */
	public void setConttp_code(String Conttp_code) {
		setAttrVal("Conttp_code", Conttp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getConttp_name() {
		return ((String) getAttrVal("Conttp_name"));
	}	
	/**
	 * 名称
	 * @param Conttp_name
	 */
	public void setConttp_name(String Conttp_name) {
		setAttrVal("Conttp_name", Conttp_name);
	}
	/**
	 * 亲属身份名称
	 * @return String
	 */
	public String getName_fmrole() {
		return ((String) getAttrVal("Name_fmrole"));
	}	
	/**
	 * 亲属身份名称
	 * @param Name_fmrole
	 */
	public void setName_fmrole(String Name_fmrole) {
		setAttrVal("Name_fmrole", Name_fmrole);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getContname() {
		return ((String) getAttrVal("Contname"));
	}	
	/**
	 * 名称
	 * @param Contname
	 */
	public void setContname(String Contname) {
		setAttrVal("Contname", Contname);
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
		return "Id_patcont";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_cont";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatContDODesc.class);
	}
	
}