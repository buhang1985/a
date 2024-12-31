package iih.nmr.pkuf.laborprorecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.laborprorecord.d.desc.PuerperainfoDODesc;
import java.math.BigDecimal;

/**
 * 产程观察患者信息 DO数据 
 * 
 */
public class PuerperainfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//产程观察护理记录单ID
	public static final String ID_PUERPERAINFO= "Id_puerperainfo";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//姓名
	public static final String NAME_PAT= "Name_pat";
	//年龄
	public static final String AGE= "Age";
	//床号
	public static final String NAME_BED= "Name_bed";
	//住院号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//入院时间
	public static final String DT_ENTRY= "Dt_entry";
	//分娩病区
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//分娩科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//妊娠次数
	public static final String NUM_GESTATION= "Num_gestation";
	//生产次数
	public static final String NUM_PRODUCE= "Num_produce";
	//宫底
	public static final String NUM_FUNDUS= "Num_fundus";
	//胎儿估计大小
	public static final String SIZE_FETUS= "Size_fetus";
	//产前检查
	public static final String EU_PRODUCE= "Eu_produce";
	//产程开始时间
	public static final String DT_PUERBEGAIN= "Dt_puerbegain";
	//主诊断
	public static final String DI_MAJ= "Di_maj";
	//孕产次
	public static final String TIMES_DELIVERY= "Times_delivery";
	//预产期
	public static final String DT_PRENATAL= "Dt_prenatal";
	//孕周
	public static final String WEEK_PREGNANCY= "Week_pregnancy";
	//过去妊娠摘要
	public static final String PAST_GESTATION= "Past_gestation";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_DEP_PHY= "Code_dep_phy";
	//名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//编码
	public static final String CODE_DEP_NUR= "Code_dep_nur";
	//名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 产程观察护理记录单ID
	 * @return String
	 */
	public String getId_puerperainfo() {
		return ((String) getAttrVal("Id_puerperainfo"));
	}	
	/**
	 * 产程观察护理记录单ID
	 * @param Id_puerperainfo
	 */
	public void setId_puerperainfo(String Id_puerperainfo) {
		setAttrVal("Id_puerperainfo", Id_puerperainfo);
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
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 分娩病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 分娩病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 分娩科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 分娩科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 妊娠次数
	 * @return Integer
	 */
	public Integer getNum_gestation() {
		return ((Integer) getAttrVal("Num_gestation"));
	}	
	/**
	 * 妊娠次数
	 * @param Num_gestation
	 */
	public void setNum_gestation(Integer Num_gestation) {
		setAttrVal("Num_gestation", Num_gestation);
	}
	/**
	 * 生产次数
	 * @return Integer
	 */
	public Integer getNum_produce() {
		return ((Integer) getAttrVal("Num_produce"));
	}	
	/**
	 * 生产次数
	 * @param Num_produce
	 */
	public void setNum_produce(Integer Num_produce) {
		setAttrVal("Num_produce", Num_produce);
	}
	/**
	 * 宫底
	 * @return String
	 */
	public String getNum_fundus() {
		return ((String) getAttrVal("Num_fundus"));
	}	
	/**
	 * 宫底
	 * @param Num_fundus
	 */
	public void setNum_fundus(String Num_fundus) {
		setAttrVal("Num_fundus", Num_fundus);
	}
	/**
	 * 胎儿估计大小
	 * @return FDouble
	 */
	public FDouble getSize_fetus() {
		return ((FDouble) getAttrVal("Size_fetus"));
	}	
	/**
	 * 胎儿估计大小
	 * @param Size_fetus
	 */
	public void setSize_fetus(FDouble Size_fetus) {
		setAttrVal("Size_fetus", Size_fetus);
	}
	/**
	 * 产前检查
	 * @return Integer
	 */
	public Integer getEu_produce() {
		return ((Integer) getAttrVal("Eu_produce"));
	}	
	/**
	 * 产前检查
	 * @param Eu_produce
	 */
	public void setEu_produce(Integer Eu_produce) {
		setAttrVal("Eu_produce", Eu_produce);
	}
	/**
	 * 产程开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_puerbegain() {
		return ((FDateTime) getAttrVal("Dt_puerbegain"));
	}	
	/**
	 * 产程开始时间
	 * @param Dt_puerbegain
	 */
	public void setDt_puerbegain(FDateTime Dt_puerbegain) {
		setAttrVal("Dt_puerbegain", Dt_puerbegain);
	}
	/**
	 * 主诊断
	 * @return String
	 */
	public String getDi_maj() {
		return ((String) getAttrVal("Di_maj"));
	}	
	/**
	 * 主诊断
	 * @param Di_maj
	 */
	public void setDi_maj(String Di_maj) {
		setAttrVal("Di_maj", Di_maj);
	}
	/**
	 * 孕产次
	 * @return String
	 */
	public String getTimes_delivery() {
		return ((String) getAttrVal("Times_delivery"));
	}	
	/**
	 * 孕产次
	 * @param Times_delivery
	 */
	public void setTimes_delivery(String Times_delivery) {
		setAttrVal("Times_delivery", Times_delivery);
	}
	/**
	 * 预产期
	 * @return FDate
	 */
	public FDate getDt_prenatal() {
		return ((FDate) getAttrVal("Dt_prenatal"));
	}	
	/**
	 * 预产期
	 * @param Dt_prenatal
	 */
	public void setDt_prenatal(FDate Dt_prenatal) {
		setAttrVal("Dt_prenatal", Dt_prenatal);
	}
	/**
	 * 孕周
	 * @return String
	 */
	public String getWeek_pregnancy() {
		return ((String) getAttrVal("Week_pregnancy"));
	}	
	/**
	 * 孕周
	 * @param Week_pregnancy
	 */
	public void setWeek_pregnancy(String Week_pregnancy) {
		setAttrVal("Week_pregnancy", Week_pregnancy);
	}
	/**
	 * 过去妊娠摘要
	 * @return String
	 */
	public String getPast_gestation() {
		return ((String) getAttrVal("Past_gestation"));
	}	
	/**
	 * 过去妊娠摘要
	 * @param Past_gestation
	 */
	public void setPast_gestation(String Past_gestation) {
		setAttrVal("Past_gestation", Past_gestation);
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
	 * 编码
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}	
	/**
	 * 编码
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 编码
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_puerperainfo";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_PPINFO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PuerperainfoDODesc.class);
	}
	
}