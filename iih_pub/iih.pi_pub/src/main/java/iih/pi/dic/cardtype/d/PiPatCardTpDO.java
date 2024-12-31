package iih.pi.dic.cardtype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.dic.cardtype.d.desc.PiPatCardTpDODesc;
import java.math.BigDecimal;

/**
 * 患者卡类型 DO数据 
 * 
 */
public class PiPatCardTpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者卡类型ID
	public static final String ID_CARDTP= "Id_cardtp";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//患者卡类型性质
	public static final String ID_PATCARDTP= "Id_patcardtp";
	//患者卡类型性质编码
	public static final String SD_PATCARDTP= "Sd_patcardtp";
	//患者卡类型编码
	public static final String CODE= "Code";
	//患者卡类型名称
	public static final String NAME= "Name";
	//患者卡类型描述
	public static final String DES= "Des";
	//卡费记账方式
	public static final String EU_CARDCGMD= "Eu_cardcgmd";
	//费用服务
	public static final String ID_SRV= "Id_srv";
	//押金金额
	public static final String AMT= "Amt";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//拼音
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//办卡时是否写卡
	public static final String FG_WRITECARD= "Fg_writecard";
	//写卡方式
	public static final String EU_WRITETP= "Eu_writetp";
	//卡密标志
	public static final String FG_PASSWORD= "Fg_password";
	//减免收费次数
	public static final String FREE_TIMES= "Free_times";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String PATCARDTP_NAME= "Patcardtp_name";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者卡类型ID
	 * @return String
	 */
	public String getId_cardtp() {
		return ((String) getAttrVal("Id_cardtp"));
	}	
	/**
	 * 患者卡类型ID
	 * @param Id_cardtp
	 */
	public void setId_cardtp(String Id_cardtp) {
		setAttrVal("Id_cardtp", Id_cardtp);
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
	 * 患者卡类型性质
	 * @return String
	 */
	public String getId_patcardtp() {
		return ((String) getAttrVal("Id_patcardtp"));
	}	
	/**
	 * 患者卡类型性质
	 * @param Id_patcardtp
	 */
	public void setId_patcardtp(String Id_patcardtp) {
		setAttrVal("Id_patcardtp", Id_patcardtp);
	}
	/**
	 * 患者卡类型性质编码
	 * @return String
	 */
	public String getSd_patcardtp() {
		return ((String) getAttrVal("Sd_patcardtp"));
	}	
	/**
	 * 患者卡类型性质编码
	 * @param Sd_patcardtp
	 */
	public void setSd_patcardtp(String Sd_patcardtp) {
		setAttrVal("Sd_patcardtp", Sd_patcardtp);
	}
	/**
	 * 患者卡类型编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 患者卡类型编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 患者卡类型名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者卡类型名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 患者卡类型描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 患者卡类型描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 卡费记账方式
	 * @return String
	 */
	public String getEu_cardcgmd() {
		return ((String) getAttrVal("Eu_cardcgmd"));
	}	
	/**
	 * 卡费记账方式
	 * @param Eu_cardcgmd
	 */
	public void setEu_cardcgmd(String Eu_cardcgmd) {
		setAttrVal("Eu_cardcgmd", Eu_cardcgmd);
	}
	/**
	 * 费用服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 费用服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 押金金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 押金金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 办卡时是否写卡
	 * @return FBoolean
	 */
	public FBoolean getFg_writecard() {
		return ((FBoolean) getAttrVal("Fg_writecard"));
	}	
	/**
	 * 办卡时是否写卡
	 * @param Fg_writecard
	 */
	public void setFg_writecard(FBoolean Fg_writecard) {
		setAttrVal("Fg_writecard", Fg_writecard);
	}
	/**
	 * 写卡方式
	 * @return String
	 */
	public String getEu_writetp() {
		return ((String) getAttrVal("Eu_writetp"));
	}	
	/**
	 * 写卡方式
	 * @param Eu_writetp
	 */
	public void setEu_writetp(String Eu_writetp) {
		setAttrVal("Eu_writetp", Eu_writetp);
	}
	/**
	 * 卡密标志
	 * @return FBoolean
	 */
	public FBoolean getFg_password() {
		return ((FBoolean) getAttrVal("Fg_password"));
	}	
	/**
	 * 卡密标志
	 * @param Fg_password
	 */
	public void setFg_password(FBoolean Fg_password) {
		setAttrVal("Fg_password", Fg_password);
	}
	/**
	 * 减免收费次数
	 * @return Integer
	 */
	public Integer getFree_times() {
		return ((Integer) getAttrVal("Free_times"));
	}	
	/**
	 * 减免收费次数
	 * @param Free_times
	 */
	public void setFree_times(Integer Free_times) {
		setAttrVal("Free_times", Free_times);
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
	 * 名称
	 * @return String
	 */
	public String getPatcardtp_name() {
		return ((String) getAttrVal("Patcardtp_name"));
	}	
	/**
	 * 名称
	 * @param Patcardtp_name
	 */
	public void setPatcardtp_name(String Patcardtp_name) {
		setAttrVal("Patcardtp_name", Patcardtp_name);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
		return "Id_cardtp";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_cardtp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatCardTpDODesc.class);
	}
	
}