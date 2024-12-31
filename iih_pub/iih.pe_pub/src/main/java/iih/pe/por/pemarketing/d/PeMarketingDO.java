package iih.pe.por.pemarketing.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pemarketing.d.desc.PeMarketingDODesc;
import java.math.BigDecimal;

/**
 * 体检市场营销活动 DO数据 
 * 
 */
public class PeMarketingDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检市场营销活动主键标识
	public static final String ID_PEMARKETING= "Id_pemarketing";
	//体检市场营销活动父ID
	public static final String ID_PEMARKETING_PAR= "Id_pemarketing_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//活动名称
	public static final String NAME= "Name";
	//活动代码
	public static final String CODE= "Code";
	//活动开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//活动截止日期
	public static final String DT_END= "Dt_end";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//活动内容
	public static final String ACTIVITY= "Activity";
	//负责人
	public static final String OFFICIAL= "Official";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检市场营销活动主键标识
	 * @return String
	 */
	public String getId_pemarketing() {
		return ((String) getAttrVal("Id_pemarketing"));
	}	
	/**
	 * 体检市场营销活动主键标识
	 * @param Id_pemarketing
	 */
	public void setId_pemarketing(String Id_pemarketing) {
		setAttrVal("Id_pemarketing", Id_pemarketing);
	}
	/**
	 * 体检市场营销活动父ID
	 * @return String
	 */
	public String getId_pemarketing_par() {
		return ((String) getAttrVal("Id_pemarketing_par"));
	}	
	/**
	 * 体检市场营销活动父ID
	 * @param Id_pemarketing_par
	 */
	public void setId_pemarketing_par(String Id_pemarketing_par) {
		setAttrVal("Id_pemarketing_par", Id_pemarketing_par);
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
	 * 活动名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 活动名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 活动代码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 活动代码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 活动开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 活动开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 活动截止日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 活动截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 活动内容
	 * @return String
	 */
	public String getActivity() {
		return ((String) getAttrVal("Activity"));
	}	
	/**
	 * 活动内容
	 * @param Activity
	 */
	public void setActivity(String Activity) {
		setAttrVal("Activity", Activity);
	}
	/**
	 * 负责人
	 * @return String
	 */
	public String getOfficial() {
		return ((String) getAttrVal("Official"));
	}	
	/**
	 * 负责人
	 * @param Official
	 */
	public void setOfficial(String Official) {
		setAttrVal("Official", Official);
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
		return "Id_pemarketing";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pemarketing";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeMarketingDODesc.class);
	}
	
}