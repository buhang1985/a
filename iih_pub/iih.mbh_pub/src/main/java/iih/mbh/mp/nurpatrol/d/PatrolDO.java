package iih.mbh.mp.nurpatrol.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mbh.mp.nurpatrol.d.desc.PatrolDODesc;
import java.math.BigDecimal;

/**
 * 护理巡房 DO数据 
 * 
 */
public class PatrolDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//护士巡房主键ID
	public static final String ID_PATROL= "Id_patrol";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者床号
	public static final String NAME_BED= "Name_bed";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//巡房次数
	public static final String NUM_VISIT= "Num_visit";
	//备注内容
	public static final String NOTE= "Note";
	//记录护士
	public static final String ID_EMP_NUR= "Id_emp_nur";
	//记录科室
	public static final String ID_DEP= "Id_dep";
	//记录时间
	public static final String DT_PATROL= "Dt_patrol";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//巡房类型id
	public static final String ID_PATROL_TYPE= "Id_patrol_type";
	//巡房类型编码
	public static final String SD_PATROL_TYPE= "Sd_patrol_type";
	//患者去向id
	public static final String ID_PATGOING= "Id_patgoing";
	//患者去向sd
	public static final String SD_PATGOING= "Sd_patgoing";
	//患者体位id
	public static final String ID_PATPOS= "Id_patpos";
	//患者体位sd
	public static final String SD_PATPOS= "Sd_patpos";
	//保护性约束id
	public static final String ID_PROCON= "Id_procon";
	//保护性约束sd
	public static final String SD_PROCON= "Sd_procon";
	//护理等级id
	public static final String ID_LEVEL_NUR= "Id_level_nur";
	//护理等级sd
	public static final String SD_LEVEL_NUR= "Sd_level_nur";
	//记录护士
	public static final String NAME_NUR= "Name_nur";
	//科室名称
	public static final String NAME_DEP= "Name_dep";
	//巡房类型名称
	public static final String NAME_PATROL_TYPE= "Name_patrol_type";
	//病人去向
	public static final String NAME_PATGOING= "Name_patgoing";
	//患者体位名称
	public static final String NAME_PATPOS= "Name_patpos";
	//保护性约束名称
	public static final String NAME_PROCON= "Name_procon";
	//护理等级
	public static final String NAME_NURLEVEL= "Name_nurlevel";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 护士巡房主键ID
	 * @return String
	 */
	public String getId_patrol() {
		return ((String) getAttrVal("Id_patrol"));
	}	
	/**
	 * 护士巡房主键ID
	 * @param Id_patrol
	 */
	public void setId_patrol(String Id_patrol) {
		setAttrVal("Id_patrol", Id_patrol);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 患者床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 巡房次数
	 * @return Integer
	 */
	public Integer getNum_visit() {
		return ((Integer) getAttrVal("Num_visit"));
	}	
	/**
	 * 巡房次数
	 * @param Num_visit
	 */
	public void setNum_visit(Integer Num_visit) {
		setAttrVal("Num_visit", Num_visit);
	}
	/**
	 * 备注内容
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注内容
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 记录护士
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	/**
	 * 记录护士
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 记录科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 记录科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_patrol() {
		return ((FDateTime) getAttrVal("Dt_patrol"));
	}	
	/**
	 * 记录时间
	 * @param Dt_patrol
	 */
	public void setDt_patrol(FDateTime Dt_patrol) {
		setAttrVal("Dt_patrol", Dt_patrol);
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
	 * 巡房类型id
	 * @return String
	 */
	public String getId_patrol_type() {
		return ((String) getAttrVal("Id_patrol_type"));
	}	
	/**
	 * 巡房类型id
	 * @param Id_patrol_type
	 */
	public void setId_patrol_type(String Id_patrol_type) {
		setAttrVal("Id_patrol_type", Id_patrol_type);
	}
	/**
	 * 巡房类型编码
	 * @return String
	 */
	public String getSd_patrol_type() {
		return ((String) getAttrVal("Sd_patrol_type"));
	}	
	/**
	 * 巡房类型编码
	 * @param Sd_patrol_type
	 */
	public void setSd_patrol_type(String Sd_patrol_type) {
		setAttrVal("Sd_patrol_type", Sd_patrol_type);
	}
	/**
	 * 患者去向id
	 * @return String
	 */
	public String getId_patgoing() {
		return ((String) getAttrVal("Id_patgoing"));
	}	
	/**
	 * 患者去向id
	 * @param Id_patgoing
	 */
	public void setId_patgoing(String Id_patgoing) {
		setAttrVal("Id_patgoing", Id_patgoing);
	}
	/**
	 * 患者去向sd
	 * @return String
	 */
	public String getSd_patgoing() {
		return ((String) getAttrVal("Sd_patgoing"));
	}	
	/**
	 * 患者去向sd
	 * @param Sd_patgoing
	 */
	public void setSd_patgoing(String Sd_patgoing) {
		setAttrVal("Sd_patgoing", Sd_patgoing);
	}
	/**
	 * 患者体位id
	 * @return String
	 */
	public String getId_patpos() {
		return ((String) getAttrVal("Id_patpos"));
	}	
	/**
	 * 患者体位id
	 * @param Id_patpos
	 */
	public void setId_patpos(String Id_patpos) {
		setAttrVal("Id_patpos", Id_patpos);
	}
	/**
	 * 患者体位sd
	 * @return String
	 */
	public String getSd_patpos() {
		return ((String) getAttrVal("Sd_patpos"));
	}	
	/**
	 * 患者体位sd
	 * @param Sd_patpos
	 */
	public void setSd_patpos(String Sd_patpos) {
		setAttrVal("Sd_patpos", Sd_patpos);
	}
	/**
	 * 保护性约束id
	 * @return String
	 */
	public String getId_procon() {
		return ((String) getAttrVal("Id_procon"));
	}	
	/**
	 * 保护性约束id
	 * @param Id_procon
	 */
	public void setId_procon(String Id_procon) {
		setAttrVal("Id_procon", Id_procon);
	}
	/**
	 * 保护性约束sd
	 * @return String
	 */
	public String getSd_procon() {
		return ((String) getAttrVal("Sd_procon"));
	}	
	/**
	 * 保护性约束sd
	 * @param Sd_procon
	 */
	public void setSd_procon(String Sd_procon) {
		setAttrVal("Sd_procon", Sd_procon);
	}
	/**
	 * 护理等级id
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}	
	/**
	 * 护理等级id
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 护理等级sd
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}	
	/**
	 * 护理等级sd
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 记录护士
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 记录护士
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 巡房类型名称
	 * @return String
	 */
	public String getName_patrol_type() {
		return ((String) getAttrVal("Name_patrol_type"));
	}	
	/**
	 * 巡房类型名称
	 * @param Name_patrol_type
	 */
	public void setName_patrol_type(String Name_patrol_type) {
		setAttrVal("Name_patrol_type", Name_patrol_type);
	}
	/**
	 * 病人去向
	 * @return String
	 */
	public String getName_patgoing() {
		return ((String) getAttrVal("Name_patgoing"));
	}	
	/**
	 * 病人去向
	 * @param Name_patgoing
	 */
	public void setName_patgoing(String Name_patgoing) {
		setAttrVal("Name_patgoing", Name_patgoing);
	}
	/**
	 * 患者体位名称
	 * @return String
	 */
	public String getName_patpos() {
		return ((String) getAttrVal("Name_patpos"));
	}	
	/**
	 * 患者体位名称
	 * @param Name_patpos
	 */
	public void setName_patpos(String Name_patpos) {
		setAttrVal("Name_patpos", Name_patpos);
	}
	/**
	 * 保护性约束名称
	 * @return String
	 */
	public String getName_procon() {
		return ((String) getAttrVal("Name_procon"));
	}	
	/**
	 * 保护性约束名称
	 * @param Name_procon
	 */
	public void setName_procon(String Name_procon) {
		setAttrVal("Name_procon", Name_procon);
	}
	/**
	 * 护理等级
	 * @return String
	 */
	public String getName_nurlevel() {
		return ((String) getAttrVal("Name_nurlevel"));
	}	
	/**
	 * 护理等级
	 * @param Name_nurlevel
	 */
	public void setName_nurlevel(String Name_nurlevel) {
		setAttrVal("Name_nurlevel", Name_nurlevel);
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
		return "Id_patrol";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mb_patrol";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatrolDODesc.class);
	}
	
}