package iih.pmp.pay.ord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.ord.d.desc.OrdDODesc;
import java.math.BigDecimal;

/**
 * 订单 DO数据 
 * 
 */
public class OrdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORD= "Id_ord";
	public static final String ORD_NO= "Ord_no";
	public static final String CODE= "Code";
	public static final String ORD_STATUS= "Ord_status";
	public static final String DT_ORD= "Dt_ord";
	public static final String AMOUNT= "Amount";
	public static final String AMOUNT_BK= "Amount_bk";
	public static final String ID_CHL= "Id_chl";
	public static final String SD_CHL= "Sd_chl";
	public static final String ID_SCENE= "Id_scene";
	public static final String SD_SCENE= "Sd_scene";
	public static final String SPBILL_CREATE_IP= "Spbill_create_ip";
	public static final String DT_PAY= "Dt_pay";
	public static final String SUBJECT= "Subject";
	public static final String BODY= "Body";
	public static final String ID_EMP_OP= "Id_emp_op";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CHECK_RST= "Check_rst";
	public static final String DEVICEINFO= "Deviceinfo";
	public static final String TRADETYPE= "Tradetype";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_BIZSCENE= "Id_bizscene";
	public static final String SD_BIZSCENE= "Sd_bizscene";
	public static final String ID_PRI_PM= "Id_pri_pm";
	public static final String NAME_CHL= "Name_chl";
	public static final String NAME_SCENE= "Name_scene";
	public static final String NAME_EMP= "Name_emp";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_PAT= "Code_pat";
	public static final String NAME_BIZSCENE= "Name_bizscene";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ord() {
		return ((String) getAttrVal("Id_ord"));
	}	
	public void setId_ord(String Id_ord) {
		setAttrVal("Id_ord", Id_ord);
	}
	public String getOrd_no() {
		return ((String) getAttrVal("Ord_no"));
	}	
	public void setOrd_no(String Ord_no) {
		setAttrVal("Ord_no", Ord_no);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public Integer getOrd_status() {
		return ((Integer) getAttrVal("Ord_status"));
	}	
	public void setOrd_status(Integer Ord_status) {
		setAttrVal("Ord_status", Ord_status);
	}
	public FDateTime getDt_ord() {
		return ((FDateTime) getAttrVal("Dt_ord"));
	}	
	public void setDt_ord(FDateTime Dt_ord) {
		setAttrVal("Dt_ord", Dt_ord);
	}
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	public FDouble getAmount_bk() {
		return ((FDouble) getAttrVal("Amount_bk"));
	}	
	public void setAmount_bk(FDouble Amount_bk) {
		setAttrVal("Amount_bk", Amount_bk);
	}
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}	
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}	
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	public String getId_scene() {
		return ((String) getAttrVal("Id_scene"));
	}	
	public void setId_scene(String Id_scene) {
		setAttrVal("Id_scene", Id_scene);
	}
	public String getSd_scene() {
		return ((String) getAttrVal("Sd_scene"));
	}	
	public void setSd_scene(String Sd_scene) {
		setAttrVal("Sd_scene", Sd_scene);
	}
	public String getSpbill_create_ip() {
		return ((String) getAttrVal("Spbill_create_ip"));
	}	
	public void setSpbill_create_ip(String Spbill_create_ip) {
		setAttrVal("Spbill_create_ip", Spbill_create_ip);
	}
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}	
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	public String getSubject() {
		return ((String) getAttrVal("Subject"));
	}	
	public void setSubject(String Subject) {
		setAttrVal("Subject", Subject);
	}
	public String getBody() {
		return ((String) getAttrVal("Body"));
	}	
	public void setBody(String Body) {
		setAttrVal("Body", Body);
	}
	public String getId_emp_op() {
		return ((String) getAttrVal("Id_emp_op"));
	}	
	public void setId_emp_op(String Id_emp_op) {
		setAttrVal("Id_emp_op", Id_emp_op);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public Integer getCheck_rst() {
		return ((Integer) getAttrVal("Check_rst"));
	}	
	public void setCheck_rst(Integer Check_rst) {
		setAttrVal("Check_rst", Check_rst);
	}
	public String getDeviceinfo() {
		return ((String) getAttrVal("Deviceinfo"));
	}	
	public void setDeviceinfo(String Deviceinfo) {
		setAttrVal("Deviceinfo", Deviceinfo);
	}
	public String getTradetype() {
		return ((String) getAttrVal("Tradetype"));
	}	
	public void setTradetype(String Tradetype) {
		setAttrVal("Tradetype", Tradetype);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_bizscene() {
		return ((String) getAttrVal("Id_bizscene"));
	}	
	public void setId_bizscene(String Id_bizscene) {
		setAttrVal("Id_bizscene", Id_bizscene);
	}
	public String getSd_bizscene() {
		return ((String) getAttrVal("Sd_bizscene"));
	}	
	public void setSd_bizscene(String Sd_bizscene) {
		setAttrVal("Sd_bizscene", Sd_bizscene);
	}
	public String getId_pri_pm() {
		return ((String) getAttrVal("Id_pri_pm"));
	}	
	public void setId_pri_pm(String Id_pri_pm) {
		setAttrVal("Id_pri_pm", Id_pri_pm);
	}
	public String getName_chl() {
		return ((String) getAttrVal("Name_chl"));
	}	
	public void setName_chl(String Name_chl) {
		setAttrVal("Name_chl", Name_chl);
	}
	public String getName_scene() {
		return ((String) getAttrVal("Name_scene"));
	}	
	public void setName_scene(String Name_scene) {
		setAttrVal("Name_scene", Name_scene);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	public String getName_bizscene() {
		return ((String) getAttrVal("Name_bizscene"));
	}	
	public void setName_bizscene(String Name_bizscene) {
		setAttrVal("Name_bizscene", Name_bizscene);
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
		return "Id_ord";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_ord";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdDODesc.class);
	}
	
}