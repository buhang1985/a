package iih.nm.net.examquatt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examquatt.d.desc.ExamQuAttDODesc;
import java.math.BigDecimal;

/**
 * 附件 DO数据 
 * 
 */
public class ExamQuAttDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QU_ATT= "Id_qu_att";
	public static final String ID_QU= "Id_qu";
	public static final String ID_QU_ANS= "Id_qu_ans";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String SERIAL_NO= "Serial_no";
	public static final String EU_TYPE= "Eu_type";
	public static final String ATT_ADD= "Att_add";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qu_att() {
		return ((String) getAttrVal("Id_qu_att"));
	}	
	public void setId_qu_att(String Id_qu_att) {
		setAttrVal("Id_qu_att", Id_qu_att);
	}
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}	
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
	}
	public String getId_qu_ans() {
		return ((String) getAttrVal("Id_qu_ans"));
	}	
	public void setId_qu_ans(String Id_qu_ans) {
		setAttrVal("Id_qu_ans", Id_qu_ans);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getSerial_no() {
		return ((String) getAttrVal("Serial_no"));
	}	
	public void setSerial_no(String Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	public Integer getEu_type() {
		return ((Integer) getAttrVal("Eu_type"));
	}	
	public void setEu_type(Integer Eu_type) {
		setAttrVal("Eu_type", Eu_type);
	}
	public String getAtt_add() {
		return ((String) getAttrVal("Att_add"));
	}	
	public void setAtt_add(String Att_add) {
		setAttrVal("Att_add", Att_add);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_qu_att";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_QU_ATT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamQuAttDODesc.class);
	}
	
}