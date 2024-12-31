package iih.ci.mr.nu.pipesliprisk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.pipesliprisk.d.desc.PipeSlipRiskDODesc;
import java.math.BigDecimal;

/**
 * 管道滑脱风险患者信息 DO数据 
 * 
 */
public class PipeSlipRiskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PIPESLIPRISK= "Id_pipesliprisk";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String NAME_SEX= "Name_sex";
	public static final String ID_NURSE= "Id_nurse";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String DT_EVALUATE= "Dt_evaluate";
	public static final String ID_AGERANGE= "Id_agerange";
	public static final String SD_AGERANGE= "Sd_agerange";
	public static final String SCORE_AGERANGE= "Score_agerange";
	public static final String ID_AWARENESS= "Id_awareness";
	public static final String SD_AWARENESS= "Sd_awareness";
	public static final String SCORE_AWARENESS= "Score_awareness";
	public static final String ID_MIND= "Id_mind";
	public static final String SD_MIND= "Sd_mind";
	public static final String SCORE_MIND= "Score_mind";
	public static final String ID_ACTIVITY= "Id_activity";
	public static final String SD_ACTIVITY= "Sd_activity";
	public static final String SCORE_ACTIVITY= "Score_activity";
	public static final String ID_PIPE_FIRSTTP= "Id_pipe_firsttp";
	public static final String SD_PIPE_FIRSTTP= "Sd_pipe_firsttp";
	public static final String PIPE_FIRSTOTHER= "Pipe_firstother";
	public static final String ID_PIPE_SECONDTP= "Id_pipe_secondtp";
	public static final String SD_PIPE_SECONDTP= "Sd_pipe_secondtp";
	public static final String PIPE_SECONDOTHER= "Pipe_secondother";
	public static final String ID_PIPE_THIRDTP= "Id_pipe_thirdtp";
	public static final String SD_PIPE_THIRDTP= "Sd_pipe_thirdtp";
	public static final String PIPE_THIRDOTHER= "Pipe_thirdother";
	public static final String SCORE_PIPETP= "Score_pipetp";
	public static final String ID_PAIN= "Id_pain";
	public static final String SD_PAIN= "Sd_pain";
	public static final String SCORE_PAIN= "Score_pain";
	public static final String ID_COMMUNICAT= "Id_communicat";
	public static final String SD_COMMUNICAT= "Sd_communicat";
	public static final String SCORE_COMMUNICAT= "Score_communicat";
	public static final String ID_NURSMEASURE= "Id_nursmeasure";
	public static final String SD_NURSMEASURE= "Sd_nursmeasure";
	public static final String SCORE_TOTAL= "Score_total";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NURSE= "Name_nurse";
	public static final String NAME_AGERANGE= "Name_agerange";
	public static final String NAME_AWARENESS= "Name_awareness";
	public static final String NAME_MIND= "Name_mind";
	public static final String NAME_ACTIVITY= "Name_activity";
	public static final String NAME_PIPE_FIRSTTP= "Name_pipe_firsttp";
	public static final String NAME_PIPE_SECONDTP= "Name_pipe_secondtp";
	public static final String NAME_PIPE_THIRDTP= "Name_pipe_thirdtp";
	public static final String NAME_PAIN= "Name_pain";
	public static final String NAME_COMMUNICAT= "Name_communicat";
	public static final String NAME_NURSMEASURE= "Name_nursmeasure";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pipesliprisk() {
		return ((String) getAttrVal("Id_pipesliprisk"));
	}	
	public void setId_pipesliprisk(String Id_pipesliprisk) {
		setAttrVal("Id_pipesliprisk", Id_pipesliprisk);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_diagnosis() {
		return ((String) getAttrVal("Id_diagnosis"));
	}	
	public void setId_diagnosis(String Id_diagnosis) {
		setAttrVal("Id_diagnosis", Id_diagnosis);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getId_nurse() {
		return ((String) getAttrVal("Id_nurse"));
	}	
	public void setId_nurse(String Id_nurse) {
		setAttrVal("Id_nurse", Id_nurse);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public FDateTime getDt_evaluate() {
		return ((FDateTime) getAttrVal("Dt_evaluate"));
	}	
	public void setDt_evaluate(FDateTime Dt_evaluate) {
		setAttrVal("Dt_evaluate", Dt_evaluate);
	}
	public String getId_agerange() {
		return ((String) getAttrVal("Id_agerange"));
	}	
	public void setId_agerange(String Id_agerange) {
		setAttrVal("Id_agerange", Id_agerange);
	}
	public String getSd_agerange() {
		return ((String) getAttrVal("Sd_agerange"));
	}	
	public void setSd_agerange(String Sd_agerange) {
		setAttrVal("Sd_agerange", Sd_agerange);
	}
	public Integer getScore_agerange() {
		return ((Integer) getAttrVal("Score_agerange"));
	}	
	public void setScore_agerange(Integer Score_agerange) {
		setAttrVal("Score_agerange", Score_agerange);
	}
	public String getId_awareness() {
		return ((String) getAttrVal("Id_awareness"));
	}	
	public void setId_awareness(String Id_awareness) {
		setAttrVal("Id_awareness", Id_awareness);
	}
	public String getSd_awareness() {
		return ((String) getAttrVal("Sd_awareness"));
	}	
	public void setSd_awareness(String Sd_awareness) {
		setAttrVal("Sd_awareness", Sd_awareness);
	}
	public Integer getScore_awareness() {
		return ((Integer) getAttrVal("Score_awareness"));
	}	
	public void setScore_awareness(Integer Score_awareness) {
		setAttrVal("Score_awareness", Score_awareness);
	}
	public String getId_mind() {
		return ((String) getAttrVal("Id_mind"));
	}	
	public void setId_mind(String Id_mind) {
		setAttrVal("Id_mind", Id_mind);
	}
	public String getSd_mind() {
		return ((String) getAttrVal("Sd_mind"));
	}	
	public void setSd_mind(String Sd_mind) {
		setAttrVal("Sd_mind", Sd_mind);
	}
	public Integer getScore_mind() {
		return ((Integer) getAttrVal("Score_mind"));
	}	
	public void setScore_mind(Integer Score_mind) {
		setAttrVal("Score_mind", Score_mind);
	}
	public String getId_activity() {
		return ((String) getAttrVal("Id_activity"));
	}	
	public void setId_activity(String Id_activity) {
		setAttrVal("Id_activity", Id_activity);
	}
	public String getSd_activity() {
		return ((String) getAttrVal("Sd_activity"));
	}	
	public void setSd_activity(String Sd_activity) {
		setAttrVal("Sd_activity", Sd_activity);
	}
	public Integer getScore_activity() {
		return ((Integer) getAttrVal("Score_activity"));
	}	
	public void setScore_activity(Integer Score_activity) {
		setAttrVal("Score_activity", Score_activity);
	}
	public String getId_pipe_firsttp() {
		return ((String) getAttrVal("Id_pipe_firsttp"));
	}	
	public void setId_pipe_firsttp(String Id_pipe_firsttp) {
		setAttrVal("Id_pipe_firsttp", Id_pipe_firsttp);
	}
	public String getSd_pipe_firsttp() {
		return ((String) getAttrVal("Sd_pipe_firsttp"));
	}	
	public void setSd_pipe_firsttp(String Sd_pipe_firsttp) {
		setAttrVal("Sd_pipe_firsttp", Sd_pipe_firsttp);
	}
	public String getPipe_firstother() {
		return ((String) getAttrVal("Pipe_firstother"));
	}	
	public void setPipe_firstother(String Pipe_firstother) {
		setAttrVal("Pipe_firstother", Pipe_firstother);
	}
	public String getId_pipe_secondtp() {
		return ((String) getAttrVal("Id_pipe_secondtp"));
	}	
	public void setId_pipe_secondtp(String Id_pipe_secondtp) {
		setAttrVal("Id_pipe_secondtp", Id_pipe_secondtp);
	}
	public String getSd_pipe_secondtp() {
		return ((String) getAttrVal("Sd_pipe_secondtp"));
	}	
	public void setSd_pipe_secondtp(String Sd_pipe_secondtp) {
		setAttrVal("Sd_pipe_secondtp", Sd_pipe_secondtp);
	}
	public String getPipe_secondother() {
		return ((String) getAttrVal("Pipe_secondother"));
	}	
	public void setPipe_secondother(String Pipe_secondother) {
		setAttrVal("Pipe_secondother", Pipe_secondother);
	}
	public String getId_pipe_thirdtp() {
		return ((String) getAttrVal("Id_pipe_thirdtp"));
	}	
	public void setId_pipe_thirdtp(String Id_pipe_thirdtp) {
		setAttrVal("Id_pipe_thirdtp", Id_pipe_thirdtp);
	}
	public String getSd_pipe_thirdtp() {
		return ((String) getAttrVal("Sd_pipe_thirdtp"));
	}	
	public void setSd_pipe_thirdtp(String Sd_pipe_thirdtp) {
		setAttrVal("Sd_pipe_thirdtp", Sd_pipe_thirdtp);
	}
	public String getPipe_thirdother() {
		return ((String) getAttrVal("Pipe_thirdother"));
	}	
	public void setPipe_thirdother(String Pipe_thirdother) {
		setAttrVal("Pipe_thirdother", Pipe_thirdother);
	}
	public Integer getScore_pipetp() {
		return ((Integer) getAttrVal("Score_pipetp"));
	}	
	public void setScore_pipetp(Integer Score_pipetp) {
		setAttrVal("Score_pipetp", Score_pipetp);
	}
	public String getId_pain() {
		return ((String) getAttrVal("Id_pain"));
	}	
	public void setId_pain(String Id_pain) {
		setAttrVal("Id_pain", Id_pain);
	}
	public String getSd_pain() {
		return ((String) getAttrVal("Sd_pain"));
	}	
	public void setSd_pain(String Sd_pain) {
		setAttrVal("Sd_pain", Sd_pain);
	}
	public Integer getScore_pain() {
		return ((Integer) getAttrVal("Score_pain"));
	}	
	public void setScore_pain(Integer Score_pain) {
		setAttrVal("Score_pain", Score_pain);
	}
	public String getId_communicat() {
		return ((String) getAttrVal("Id_communicat"));
	}	
	public void setId_communicat(String Id_communicat) {
		setAttrVal("Id_communicat", Id_communicat);
	}
	public String getSd_communicat() {
		return ((String) getAttrVal("Sd_communicat"));
	}	
	public void setSd_communicat(String Sd_communicat) {
		setAttrVal("Sd_communicat", Sd_communicat);
	}
	public Integer getScore_communicat() {
		return ((Integer) getAttrVal("Score_communicat"));
	}	
	public void setScore_communicat(Integer Score_communicat) {
		setAttrVal("Score_communicat", Score_communicat);
	}
	public String getId_nursmeasure() {
		return ((String) getAttrVal("Id_nursmeasure"));
	}	
	public void setId_nursmeasure(String Id_nursmeasure) {
		setAttrVal("Id_nursmeasure", Id_nursmeasure);
	}
	public String getSd_nursmeasure() {
		return ((String) getAttrVal("Sd_nursmeasure"));
	}	
	public void setSd_nursmeasure(String Sd_nursmeasure) {
		setAttrVal("Sd_nursmeasure", Sd_nursmeasure);
	}
	public Integer getScore_total() {
		return ((Integer) getAttrVal("Score_total"));
	}	
	public void setScore_total(Integer Score_total) {
		setAttrVal("Score_total", Score_total);
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
	public String getName_nurse() {
		return ((String) getAttrVal("Name_nurse"));
	}	
	public void setName_nurse(String Name_nurse) {
		setAttrVal("Name_nurse", Name_nurse);
	}
	public String getName_agerange() {
		return ((String) getAttrVal("Name_agerange"));
	}	
	public void setName_agerange(String Name_agerange) {
		setAttrVal("Name_agerange", Name_agerange);
	}
	public String getName_awareness() {
		return ((String) getAttrVal("Name_awareness"));
	}	
	public void setName_awareness(String Name_awareness) {
		setAttrVal("Name_awareness", Name_awareness);
	}
	public String getName_mind() {
		return ((String) getAttrVal("Name_mind"));
	}	
	public void setName_mind(String Name_mind) {
		setAttrVal("Name_mind", Name_mind);
	}
	public String getName_activity() {
		return ((String) getAttrVal("Name_activity"));
	}	
	public void setName_activity(String Name_activity) {
		setAttrVal("Name_activity", Name_activity);
	}
	public String getName_pipe_firsttp() {
		return ((String) getAttrVal("Name_pipe_firsttp"));
	}	
	public void setName_pipe_firsttp(String Name_pipe_firsttp) {
		setAttrVal("Name_pipe_firsttp", Name_pipe_firsttp);
	}
	public String getName_pipe_secondtp() {
		return ((String) getAttrVal("Name_pipe_secondtp"));
	}	
	public void setName_pipe_secondtp(String Name_pipe_secondtp) {
		setAttrVal("Name_pipe_secondtp", Name_pipe_secondtp);
	}
	public String getName_pipe_thirdtp() {
		return ((String) getAttrVal("Name_pipe_thirdtp"));
	}	
	public void setName_pipe_thirdtp(String Name_pipe_thirdtp) {
		setAttrVal("Name_pipe_thirdtp", Name_pipe_thirdtp);
	}
	public String getName_pain() {
		return ((String) getAttrVal("Name_pain"));
	}	
	public void setName_pain(String Name_pain) {
		setAttrVal("Name_pain", Name_pain);
	}
	public String getName_communicat() {
		return ((String) getAttrVal("Name_communicat"));
	}	
	public void setName_communicat(String Name_communicat) {
		setAttrVal("Name_communicat", Name_communicat);
	}
	public String getName_nursmeasure() {
		return ((String) getAttrVal("Name_nursmeasure"));
	}	
	public void setName_nursmeasure(String Name_nursmeasure) {
		setAttrVal("Name_nursmeasure", Name_nursmeasure);
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
		return "Id_pipesliprisk";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_PIPESLIPRISK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PipeSlipRiskDODesc.class);
	}
	
}