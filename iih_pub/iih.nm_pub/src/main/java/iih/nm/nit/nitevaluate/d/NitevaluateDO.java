package iih.nm.nit.nitevaluate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitevaluate.d.desc.NitevaluateDODesc;
import java.math.BigDecimal;

/**
 * 实习总评 DO数据 
 * 
 */
public class NitevaluateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//实习总评id
	public static final String ID_NIT_PRAC_RPT= "Id_nit_prac_rpt";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//实习进修生外键
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	//实习评语
	public static final String REVIEWS= "Reviews";
	//建议及改善要点
	public static final String IMPROVE= "Improve";
	//评定人
	public static final String ID_PSN_REG= "Id_psn_reg";
	//评定时间
	public static final String DT_REG= "Dt_reg";
	//是否评定
	public static final String FG_ASS= "Fg_ass";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NIT_PRAC_NAME= "Nit_prac_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 实习总评id
	 * @return String
	 */
	public String getId_nit_prac_rpt() {
		return ((String) getAttrVal("Id_nit_prac_rpt"));
	}	
	/**
	 * 实习总评id
	 * @param Id_nit_prac_rpt
	 */
	public void setId_nit_prac_rpt(String Id_nit_prac_rpt) {
		setAttrVal("Id_nit_prac_rpt", Id_nit_prac_rpt);
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
	 * 实习进修生外键
	 * @return String
	 */
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}	
	/**
	 * 实习进修生外键
	 * @param Id_nit_psninfo
	 */
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
	}
	/**
	 * 实习评语
	 * @return String
	 */
	public String getReviews() {
		return ((String) getAttrVal("Reviews"));
	}	
	/**
	 * 实习评语
	 * @param Reviews
	 */
	public void setReviews(String Reviews) {
		setAttrVal("Reviews", Reviews);
	}
	/**
	 * 建议及改善要点
	 * @return String
	 */
	public String getImprove() {
		return ((String) getAttrVal("Improve"));
	}	
	/**
	 * 建议及改善要点
	 * @param Improve
	 */
	public void setImprove(String Improve) {
		setAttrVal("Improve", Improve);
	}
	/**
	 * 评定人
	 * @return String
	 */
	public String getId_psn_reg() {
		return ((String) getAttrVal("Id_psn_reg"));
	}	
	/**
	 * 评定人
	 * @param Id_psn_reg
	 */
	public void setId_psn_reg(String Id_psn_reg) {
		setAttrVal("Id_psn_reg", Id_psn_reg);
	}
	/**
	 * 评定时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 评定时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 是否评定
	 * @return FBoolean
	 */
	public FBoolean getFg_ass() {
		return ((FBoolean) getAttrVal("Fg_ass"));
	}	
	/**
	 * 是否评定
	 * @param Fg_ass
	 */
	public void setFg_ass(FBoolean Fg_ass) {
		setAttrVal("Fg_ass", Fg_ass);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 姓名
	 * @return String
	 */
	public String getNit_prac_name() {
		return ((String) getAttrVal("Nit_prac_name"));
	}	
	/**
	 * 姓名
	 * @param Nit_prac_name
	 */
	public void setNit_prac_name(String Nit_prac_name) {
		setAttrVal("Nit_prac_name", Nit_prac_name);
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
		return "Id_nit_prac_rpt";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRAC_RPT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitevaluateDODesc.class);
	}
	
}