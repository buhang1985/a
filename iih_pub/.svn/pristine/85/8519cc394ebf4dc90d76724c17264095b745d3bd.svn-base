package iih.sc.sch.scsch.d;

import iih.sc.sch.scsch.d.desc.ScSchEnDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 计划排班_排班_就诊 DO数据 
 * 
 */
public class ScSchEnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//排班就诊主键
	public static final String ID_SCHEN= "Id_schen";
	//排班
	public static final String ID_SCH= "Id_sch";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String SD_ENTP= "Sd_entp";
	//对应号源池编号
	public static final String SCPOLCN= "Scpolcn";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊类型名称
	public static final String NAME_ENTP= "Name_entp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 排班就诊主键
	 * @return String
	 */
	public String getId_schen() {
		return ((String) getAttrVal("Id_schen"));
	}	
	/**
	 * 排班就诊主键
	 * @param Id_schen
	 */
	public void setId_schen(String Id_schen) {
		setAttrVal("Id_schen", Id_schen);
	}
	/**
	 * 排班
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Sd_entp
	 */
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
	}
	/**
	 * 对应号源池编号
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	/**
	 * 对应号源池编号
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
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
		return "Id_schen";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_sch_en";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScSchEnDODesc.class);
	}
	
}