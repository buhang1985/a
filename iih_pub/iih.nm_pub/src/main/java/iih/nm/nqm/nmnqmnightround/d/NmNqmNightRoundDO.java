package iih.nm.nqm.nmnqmnightround.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmnightround.d.desc.NmNqmNightRoundDODesc;
import java.math.BigDecimal;

/**
 * 夜查房 DO数据 
 * 
 */
public class NmNqmNightRoundDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//夜查房主键
	public static final String ID_NQM_ROUNDS= "Id_nqm_rounds";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//查房时间
	public static final String DT_ROUNDS= "Dt_rounds";
	//查房人员id
	public static final String ID_NUR= "Id_nur";
	//护理单元id
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//科室id
	public static final String ID_DEP= "Id_dep";
	//值班护士id
	public static final String ID_DUTY_NUR= "Id_duty_nur";
	//值班护士名称
	public static final String NAME_DUTYNUR= "Name_dutynur";
	//病人总数
	public static final String COUNT_PAT= "Count_pat";
	//危重人数
	public static final String COUNT_CRISER= "Count_criser";
	//特级护理人数
	public static final String COUNT_SUPERCARE= "Count_supercare";
	//一级护理人数
	public static final String COUNT_FIRSTCARE= "Count_firstcare";
	//新入患者人数
	public static final String COUNT_NEWPAT= "Count_newpat";
	//术前人数
	public static final String COUNT_PREOPER= "Count_preoper";
	//术后人数
	public static final String COUNT_POSTOPER= "Count_postoper";
	//输血人数
	public static final String COUNT_BLOODTRANS= "Count_bloodtrans";
	//化疗人数
	public static final String COUNT_CHEMO= "Count_chemo";
	//非计划拔管低风险人数
	public static final String COUNT_UEXLOWRISK= "Count_uexlowrisk";
	//非计划拔管中风险人数
	public static final String COUNT_UEXMEDRISK= "Count_uexmedrisk";
	//非计划性拔管高风险人数
	public static final String COUNT_UEXHIGHRISK= "Count_uexhighrisk";
	//深V血栓低风险人数
	public static final String COUNT_THROMBUSLOW= "Count_thrombuslow";
	//深V血栓中风险人数
	public static final String COUNT_THROMBUSMED= "Count_thrombusmed";
	//深V血栓高风险人数
	public static final String COUNT_THROMBUSHIGH= "Count_thrombushigh";
	//压疮低风险人数
	public static final String COUNT_PRESSURELOW= "Count_pressurelow";
	//压疮中风险人数
	public static final String COUNT_PRESSUREMED= "Count_pressuremed";
	//压疮高风险人数
	public static final String COUNT_PRESSUREHIGH= "Count_pressurehigh";
	//意外因素低风险人数
	public static final String COUNT_ACCIDENTSLOW= "Count_accidentslow";
	//意外因素中风险人数
	public static final String COUNT_ACCIDENTSMED= "Count_accidentsmed";
	//意外因素高风险人数
	public static final String COUNT_ACCIDENTSHIGH= "Count_accidentshigh";
	//急危患者落实情况
	public static final String CRITICALSITUATION= "Criticalsituation";
	//高危患者落实情况
	public static final String SERIOUSSITUATION= "Serioussituation";
	//住院大于30天患者情况
	public static final String PATSITUATION= "Patsituation";
	//住院大于30天患者人数
	public static final String PATSITUATNUM= "Patsituatnum";
	//存在问题
	public static final String EXISTPROBLEM= "Existproblem";
	//整改措施
	public static final String MEND_MEAS= "Mend_meas";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	//扩展字段2
	public static final String CTRL2= "Ctrl2";
	//扩展字段3
	public static final String CTRL3= "Ctrl3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员姓名
	public static final String NAME_NUR= "Name_nur";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//人员姓名
	public static final String NAME_DUTY= "Name_duty";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 夜查房主键
	 * @return String
	 */
	public String getId_nqm_rounds() {
		return ((String) getAttrVal("Id_nqm_rounds"));
	}	
	/**
	 * 夜查房主键
	 * @param Id_nqm_rounds
	 */
	public void setId_nqm_rounds(String Id_nqm_rounds) {
		setAttrVal("Id_nqm_rounds", Id_nqm_rounds);
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
	 * 查房时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rounds() {
		return ((FDateTime) getAttrVal("Dt_rounds"));
	}	
	/**
	 * 查房时间
	 * @param Dt_rounds
	 */
	public void setDt_rounds(FDateTime Dt_rounds) {
		setAttrVal("Dt_rounds", Dt_rounds);
	}
	/**
	 * 查房人员id
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 查房人员id
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 护理单元id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 值班护士id
	 * @return String
	 */
	public String getId_duty_nur() {
		return ((String) getAttrVal("Id_duty_nur"));
	}	
	/**
	 * 值班护士id
	 * @param Id_duty_nur
	 */
	public void setId_duty_nur(String Id_duty_nur) {
		setAttrVal("Id_duty_nur", Id_duty_nur);
	}
	/**
	 * 值班护士名称
	 * @return String
	 */
	public String getName_dutynur() {
		return ((String) getAttrVal("Name_dutynur"));
	}	
	/**
	 * 值班护士名称
	 * @param Name_dutynur
	 */
	public void setName_dutynur(String Name_dutynur) {
		setAttrVal("Name_dutynur", Name_dutynur);
	}
	/**
	 * 病人总数
	 * @return Integer
	 */
	public Integer getCount_pat() {
		return ((Integer) getAttrVal("Count_pat"));
	}	
	/**
	 * 病人总数
	 * @param Count_pat
	 */
	public void setCount_pat(Integer Count_pat) {
		setAttrVal("Count_pat", Count_pat);
	}
	/**
	 * 危重人数
	 * @return Integer
	 */
	public Integer getCount_criser() {
		return ((Integer) getAttrVal("Count_criser"));
	}	
	/**
	 * 危重人数
	 * @param Count_criser
	 */
	public void setCount_criser(Integer Count_criser) {
		setAttrVal("Count_criser", Count_criser);
	}
	/**
	 * 特级护理人数
	 * @return Integer
	 */
	public Integer getCount_supercare() {
		return ((Integer) getAttrVal("Count_supercare"));
	}	
	/**
	 * 特级护理人数
	 * @param Count_supercare
	 */
	public void setCount_supercare(Integer Count_supercare) {
		setAttrVal("Count_supercare", Count_supercare);
	}
	/**
	 * 一级护理人数
	 * @return Integer
	 */
	public Integer getCount_firstcare() {
		return ((Integer) getAttrVal("Count_firstcare"));
	}	
	/**
	 * 一级护理人数
	 * @param Count_firstcare
	 */
	public void setCount_firstcare(Integer Count_firstcare) {
		setAttrVal("Count_firstcare", Count_firstcare);
	}
	/**
	 * 新入患者人数
	 * @return Integer
	 */
	public Integer getCount_newpat() {
		return ((Integer) getAttrVal("Count_newpat"));
	}	
	/**
	 * 新入患者人数
	 * @param Count_newpat
	 */
	public void setCount_newpat(Integer Count_newpat) {
		setAttrVal("Count_newpat", Count_newpat);
	}
	/**
	 * 术前人数
	 * @return Integer
	 */
	public Integer getCount_preoper() {
		return ((Integer) getAttrVal("Count_preoper"));
	}	
	/**
	 * 术前人数
	 * @param Count_preoper
	 */
	public void setCount_preoper(Integer Count_preoper) {
		setAttrVal("Count_preoper", Count_preoper);
	}
	/**
	 * 术后人数
	 * @return Integer
	 */
	public Integer getCount_postoper() {
		return ((Integer) getAttrVal("Count_postoper"));
	}	
	/**
	 * 术后人数
	 * @param Count_postoper
	 */
	public void setCount_postoper(Integer Count_postoper) {
		setAttrVal("Count_postoper", Count_postoper);
	}
	/**
	 * 输血人数
	 * @return Integer
	 */
	public Integer getCount_bloodtrans() {
		return ((Integer) getAttrVal("Count_bloodtrans"));
	}	
	/**
	 * 输血人数
	 * @param Count_bloodtrans
	 */
	public void setCount_bloodtrans(Integer Count_bloodtrans) {
		setAttrVal("Count_bloodtrans", Count_bloodtrans);
	}
	/**
	 * 化疗人数
	 * @return Integer
	 */
	public Integer getCount_chemo() {
		return ((Integer) getAttrVal("Count_chemo"));
	}	
	/**
	 * 化疗人数
	 * @param Count_chemo
	 */
	public void setCount_chemo(Integer Count_chemo) {
		setAttrVal("Count_chemo", Count_chemo);
	}
	/**
	 * 非计划拔管低风险人数
	 * @return Integer
	 */
	public Integer getCount_uexlowrisk() {
		return ((Integer) getAttrVal("Count_uexlowrisk"));
	}	
	/**
	 * 非计划拔管低风险人数
	 * @param Count_uexlowrisk
	 */
	public void setCount_uexlowrisk(Integer Count_uexlowrisk) {
		setAttrVal("Count_uexlowrisk", Count_uexlowrisk);
	}
	/**
	 * 非计划拔管中风险人数
	 * @return Integer
	 */
	public Integer getCount_uexmedrisk() {
		return ((Integer) getAttrVal("Count_uexmedrisk"));
	}	
	/**
	 * 非计划拔管中风险人数
	 * @param Count_uexmedrisk
	 */
	public void setCount_uexmedrisk(Integer Count_uexmedrisk) {
		setAttrVal("Count_uexmedrisk", Count_uexmedrisk);
	}
	/**
	 * 非计划性拔管高风险人数
	 * @return Integer
	 */
	public Integer getCount_uexhighrisk() {
		return ((Integer) getAttrVal("Count_uexhighrisk"));
	}	
	/**
	 * 非计划性拔管高风险人数
	 * @param Count_uexhighrisk
	 */
	public void setCount_uexhighrisk(Integer Count_uexhighrisk) {
		setAttrVal("Count_uexhighrisk", Count_uexhighrisk);
	}
	/**
	 * 深V血栓低风险人数
	 * @return Integer
	 */
	public Integer getCount_thrombuslow() {
		return ((Integer) getAttrVal("Count_thrombuslow"));
	}	
	/**
	 * 深V血栓低风险人数
	 * @param Count_thrombuslow
	 */
	public void setCount_thrombuslow(Integer Count_thrombuslow) {
		setAttrVal("Count_thrombuslow", Count_thrombuslow);
	}
	/**
	 * 深V血栓中风险人数
	 * @return Integer
	 */
	public Integer getCount_thrombusmed() {
		return ((Integer) getAttrVal("Count_thrombusmed"));
	}	
	/**
	 * 深V血栓中风险人数
	 * @param Count_thrombusmed
	 */
	public void setCount_thrombusmed(Integer Count_thrombusmed) {
		setAttrVal("Count_thrombusmed", Count_thrombusmed);
	}
	/**
	 * 深V血栓高风险人数
	 * @return Integer
	 */
	public Integer getCount_thrombushigh() {
		return ((Integer) getAttrVal("Count_thrombushigh"));
	}	
	/**
	 * 深V血栓高风险人数
	 * @param Count_thrombushigh
	 */
	public void setCount_thrombushigh(Integer Count_thrombushigh) {
		setAttrVal("Count_thrombushigh", Count_thrombushigh);
	}
	/**
	 * 压疮低风险人数
	 * @return Integer
	 */
	public Integer getCount_pressurelow() {
		return ((Integer) getAttrVal("Count_pressurelow"));
	}	
	/**
	 * 压疮低风险人数
	 * @param Count_pressurelow
	 */
	public void setCount_pressurelow(Integer Count_pressurelow) {
		setAttrVal("Count_pressurelow", Count_pressurelow);
	}
	/**
	 * 压疮中风险人数
	 * @return Integer
	 */
	public Integer getCount_pressuremed() {
		return ((Integer) getAttrVal("Count_pressuremed"));
	}	
	/**
	 * 压疮中风险人数
	 * @param Count_pressuremed
	 */
	public void setCount_pressuremed(Integer Count_pressuremed) {
		setAttrVal("Count_pressuremed", Count_pressuremed);
	}
	/**
	 * 压疮高风险人数
	 * @return Integer
	 */
	public Integer getCount_pressurehigh() {
		return ((Integer) getAttrVal("Count_pressurehigh"));
	}	
	/**
	 * 压疮高风险人数
	 * @param Count_pressurehigh
	 */
	public void setCount_pressurehigh(Integer Count_pressurehigh) {
		setAttrVal("Count_pressurehigh", Count_pressurehigh);
	}
	/**
	 * 意外因素低风险人数
	 * @return Integer
	 */
	public Integer getCount_accidentslow() {
		return ((Integer) getAttrVal("Count_accidentslow"));
	}	
	/**
	 * 意外因素低风险人数
	 * @param Count_accidentslow
	 */
	public void setCount_accidentslow(Integer Count_accidentslow) {
		setAttrVal("Count_accidentslow", Count_accidentslow);
	}
	/**
	 * 意外因素中风险人数
	 * @return Integer
	 */
	public Integer getCount_accidentsmed() {
		return ((Integer) getAttrVal("Count_accidentsmed"));
	}	
	/**
	 * 意外因素中风险人数
	 * @param Count_accidentsmed
	 */
	public void setCount_accidentsmed(Integer Count_accidentsmed) {
		setAttrVal("Count_accidentsmed", Count_accidentsmed);
	}
	/**
	 * 意外因素高风险人数
	 * @return Integer
	 */
	public Integer getCount_accidentshigh() {
		return ((Integer) getAttrVal("Count_accidentshigh"));
	}	
	/**
	 * 意外因素高风险人数
	 * @param Count_accidentshigh
	 */
	public void setCount_accidentshigh(Integer Count_accidentshigh) {
		setAttrVal("Count_accidentshigh", Count_accidentshigh);
	}
	/**
	 * 急危患者落实情况
	 * @return String
	 */
	public String getCriticalsituation() {
		return ((String) getAttrVal("Criticalsituation"));
	}	
	/**
	 * 急危患者落实情况
	 * @param Criticalsituation
	 */
	public void setCriticalsituation(String Criticalsituation) {
		setAttrVal("Criticalsituation", Criticalsituation);
	}
	/**
	 * 高危患者落实情况
	 * @return String
	 */
	public String getSerioussituation() {
		return ((String) getAttrVal("Serioussituation"));
	}	
	/**
	 * 高危患者落实情况
	 * @param Serioussituation
	 */
	public void setSerioussituation(String Serioussituation) {
		setAttrVal("Serioussituation", Serioussituation);
	}
	/**
	 * 住院大于30天患者情况
	 * @return String
	 */
	public String getPatsituation() {
		return ((String) getAttrVal("Patsituation"));
	}	
	/**
	 * 住院大于30天患者情况
	 * @param Patsituation
	 */
	public void setPatsituation(String Patsituation) {
		setAttrVal("Patsituation", Patsituation);
	}
	/**
	 * 住院大于30天患者人数
	 * @return Integer
	 */
	public Integer getPatsituatnum() {
		return ((Integer) getAttrVal("Patsituatnum"));
	}	
	/**
	 * 住院大于30天患者人数
	 * @param Patsituatnum
	 */
	public void setPatsituatnum(Integer Patsituatnum) {
		setAttrVal("Patsituatnum", Patsituatnum);
	}
	/**
	 * 存在问题
	 * @return String
	 */
	public String getExistproblem() {
		return ((String) getAttrVal("Existproblem"));
	}	
	/**
	 * 存在问题
	 * @param Existproblem
	 */
	public void setExistproblem(String Existproblem) {
		setAttrVal("Existproblem", Existproblem);
	}
	/**
	 * 整改措施
	 * @return String
	 */
	public String getMend_meas() {
		return ((String) getAttrVal("Mend_meas"));
	}	
	/**
	 * 整改措施
	 * @param Mend_meas
	 */
	public void setMend_meas(String Mend_meas) {
		setAttrVal("Mend_meas", Mend_meas);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ctrl2
	 */
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ctrl3
	 */
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
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
	 * 人员姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	/**
	 * 人员姓名
	 * @param Name_duty
	 */
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
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
		return "Id_nqm_rounds";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_NIGHTROUND";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmNightRoundDODesc.class);
	}
	
}