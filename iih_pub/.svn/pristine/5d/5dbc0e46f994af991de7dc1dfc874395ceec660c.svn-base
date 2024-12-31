package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvRisDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务检查属性 DO数据 
 * 
 */
public class MedSrvRisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务检查主键标识
	public static final String ID_SRVOBS= "Id_srvobs";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//检查类型
	public static final String ID_OBSTP= "Id_obstp";
	//检查类型编码
	public static final String SD_OBSTP= "Sd_obstp";
	//身体部位
	public static final String ID_BODY= "Id_body";
	//身体部位编码
	public static final String SD_BODY= "Sd_body";
	//部位可修改标识
	public static final String FG_BODY_UPDATE= "Fg_body_update";
	//身体体位
	public static final String ID_POS= "Id_pos";
	//身体体位编码
	public static final String SD_POS= "Sd_pos";
	//注意事项
	public static final String NOTE= "Note";
	//医疗服务项目
	public static final String ID_SRV= "Id_srv";
	//是否可床边执行
	public static final String IF_MP_BED= "If_mp_bed";
	//体位可录入标识
	public static final String FG_POS= "Fg_pos";
	//检查分组
	public static final String ID_OBSGROUP= "Id_obsgroup";
	//检查分组编码
	public static final String SD_OBSGROUP= "Sd_obsgroup";
	//检查分组名称
	public static final String OBSGROUP= "Obsgroup";
	//适用性别
	public static final String FIT_SEX= "Fit_sex";
	//编码
	public static final String OBSTP_CODE= "Obstp_code";
	//名称
	public static final String OBSTP_NAME= "Obstp_name";
	//名称
	public static final String NAME_BODY= "Name_body";
	//名称
	public static final String NAME_POS= "Name_pos";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//名称
	public static final String NAME_OBSGROUP= "Name_obsgroup";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务检查主键标识
	 * @return String
	 */
	public String getId_srvobs() {
		return ((String) getAttrVal("Id_srvobs"));
	}	
	/**
	 * 医疗服务检查主键标识
	 * @param Id_srvobs
	 */
	public void setId_srvobs(String Id_srvobs) {
		setAttrVal("Id_srvobs", Id_srvobs);
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
	 * 检查类型
	 * @return String
	 */
	public String getId_obstp() {
		return ((String) getAttrVal("Id_obstp"));
	}	
	/**
	 * 检查类型
	 * @param Id_obstp
	 */
	public void setId_obstp(String Id_obstp) {
		setAttrVal("Id_obstp", Id_obstp);
	}
	/**
	 * 检查类型编码
	 * @return String
	 */
	public String getSd_obstp() {
		return ((String) getAttrVal("Sd_obstp"));
	}	
	/**
	 * 检查类型编码
	 * @param Sd_obstp
	 */
	public void setSd_obstp(String Sd_obstp) {
		setAttrVal("Sd_obstp", Sd_obstp);
	}
	/**
	 * 身体部位
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}	
	/**
	 * 身体部位
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}
	/**
	 * 身体部位编码
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}	
	/**
	 * 身体部位编码
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 部位可修改标识
	 * @return FBoolean
	 */
	public FBoolean getFg_body_update() {
		return ((FBoolean) getAttrVal("Fg_body_update"));
	}	
	/**
	 * 部位可修改标识
	 * @param Fg_body_update
	 */
	public void setFg_body_update(FBoolean Fg_body_update) {
		setAttrVal("Fg_body_update", Fg_body_update);
	}
	/**
	 * 身体体位
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}	
	/**
	 * 身体体位
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	/**
	 * 身体体位编码
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}	
	/**
	 * 身体体位编码
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 注意事项
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 医疗服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 是否可床边执行
	 * @return FBoolean
	 */
	public FBoolean getIf_mp_bed() {
		return ((FBoolean) getAttrVal("If_mp_bed"));
	}	
	/**
	 * 是否可床边执行
	 * @param If_mp_bed
	 */
	public void setIf_mp_bed(FBoolean If_mp_bed) {
		setAttrVal("If_mp_bed", If_mp_bed);
	}
	/**
	 * 体位可录入标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pos() {
		return ((FBoolean) getAttrVal("Fg_pos"));
	}	
	/**
	 * 体位可录入标识
	 * @param Fg_pos
	 */
	public void setFg_pos(FBoolean Fg_pos) {
		setAttrVal("Fg_pos", Fg_pos);
	}
	/**
	 * 检查分组
	 * @return String
	 */
	public String getId_obsgroup() {
		return ((String) getAttrVal("Id_obsgroup"));
	}	
	/**
	 * 检查分组
	 * @param Id_obsgroup
	 */
	public void setId_obsgroup(String Id_obsgroup) {
		setAttrVal("Id_obsgroup", Id_obsgroup);
	}
	/**
	 * 检查分组编码
	 * @return String
	 */
	public String getSd_obsgroup() {
		return ((String) getAttrVal("Sd_obsgroup"));
	}	
	/**
	 * 检查分组编码
	 * @param Sd_obsgroup
	 */
	public void setSd_obsgroup(String Sd_obsgroup) {
		setAttrVal("Sd_obsgroup", Sd_obsgroup);
	}
	/**
	 * 检查分组名称
	 * @return String
	 */
	public String getObsgroup() {
		return ((String) getAttrVal("Obsgroup"));
	}	
	/**
	 * 检查分组名称
	 * @param Obsgroup
	 */
	public void setObsgroup(String Obsgroup) {
		setAttrVal("Obsgroup", Obsgroup);
	}
	/**
	 * 适用性别
	 * @return Integer
	 */
	public Integer getFit_sex() {
		return ((Integer) getAttrVal("Fit_sex"));
	}	
	/**
	 * 适用性别
	 * @param Fit_sex
	 */
	public void setFit_sex(Integer Fit_sex) {
		setAttrVal("Fit_sex", Fit_sex);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getObstp_code() {
		return ((String) getAttrVal("Obstp_code"));
	}	
	/**
	 * 编码
	 * @param Obstp_code
	 */
	public void setObstp_code(String Obstp_code) {
		setAttrVal("Obstp_code", Obstp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getObstp_name() {
		return ((String) getAttrVal("Obstp_name"));
	}	
	/**
	 * 名称
	 * @param Obstp_name
	 */
	public void setObstp_name(String Obstp_name) {
		setAttrVal("Obstp_name", Obstp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_body() {
		return ((String) getAttrVal("Name_body"));
	}	
	/**
	 * 名称
	 * @param Name_body
	 */
	public void setName_body(String Name_body) {
		setAttrVal("Name_body", Name_body);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pos() {
		return ((String) getAttrVal("Name_pos"));
	}	
	/**
	 * 名称
	 * @param Name_pos
	 */
	public void setName_pos(String Name_pos) {
		setAttrVal("Name_pos", Name_pos);
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
	/**
	 * 名称
	 * @return String
	 */
	public String getName_obsgroup() {
		return ((String) getAttrVal("Name_obsgroup"));
	}	
	/**
	 * 名称
	 * @param Name_obsgroup
	 */
	public void setName_obsgroup(String Name_obsgroup) {
		setAttrVal("Name_obsgroup", Name_obsgroup);
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
		return "Id_srvobs";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_obs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvRisDODesc.class);
	}
	
}