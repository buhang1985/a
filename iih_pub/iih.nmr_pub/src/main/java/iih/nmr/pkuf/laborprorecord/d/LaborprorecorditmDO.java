package iih.nmr.pkuf.laborprorecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.laborprorecord.d.desc.LaborprorecorditmDODesc;
import java.math.BigDecimal;

/**
 * 产程观察记录 DO数据 
 * 
 */
public class LaborprorecorditmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//产程观察护理记录单项ID
	public static final String ID_LABORPRORECORDITM= "Id_laborprorecorditm";
	//产程观察护理记录单ID
	public static final String ID_PUERPERAINFO= "Id_puerperainfo";
	//日期时间
	public static final String DT_DATETIME= "Dt_datetime";
	//胎心率
	public static final String RATE_FHR= "Rate_fhr";
	//收缩压
	public static final String INT_SBP= "Int_sbp";
	//舒张压
	public static final String INT_DBP= "Int_dbp";
	//浓度
	public static final String NUM_CONCENTRATION= "Num_concentration";
	//滴速
	public static final String NUM_SPEED= "Num_speed";
	//先露
	public static final String PRESENTATION= "Presentation";
	//先露位置
	public static final String PRESENTATION_POSITION= "Presentation_position";
	//先露高低
	public static final String NUM_HIGHLOW= "Num_highlow";
	//阵缩间隔时间
	public static final String DT_CONTRA_CTINU= "Dt_contra_ctinu";
	//阵缩持续时间
	public static final String DT_CONTRA_INTERVAL= "Dt_contra_interval";
	//疼痛分
	public static final String SCORE_PAIN= "Score_pain";
	//宫缩
	public static final String UTERINE_CONTRACTION= "Uterine_contraction";
	//宫颈扩张
	public static final String NUM_CVLDILA= "Num_cvldila";
	//宫颈硬度
	public static final String CERVICAL_THICKNESS= "Cervical_thickness";
	//胎方位
	public static final String ID_POSITIONOFFETUS= "Id_positionoffetus";
	//胎方位编码
	public static final String SD_POSITIONOFFETUS= "Sd_positionoffetus";
	//胎膜
	public static final String FETAL_MEMBRANES= "Fetal_membranes";
	//检查方式
	public static final String ID_EXMMETHOD= "Id_exmmethod";
	//检查方式编码
	public static final String SD_EXMMETHOD= "Sd_exmmethod";
	//检查阴道
	public static final String VAGINA_EXAM= "Vagina_exam";
	//检查肛门
	public static final String ANAL_EXAM= "Anal_exam";
	//娩出标记
	public static final String ID_FETAL_DELIVERY= "Id_fetal_delivery";
	//娩出标记编码
	public static final String SD_FETAL_DELIVERY= "Sd_fetal_delivery";
	//观察及处置
	public static final String DES_OBSERVEHANDLE= "Des_observehandle";
	//签名
	public static final String ID_SIGN= "Id_sign";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_POSI= "Name_posi";
	//名称
	public static final String NAME_EXMMETHOD= "Name_exmmethod";
	//名称
	public static final String NAME_FETAL_DELIVERY= "Name_fetal_delivery";
	//姓名
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 产程观察护理记录单项ID
	 * @return String
	 */
	public String getId_laborprorecorditm() {
		return ((String) getAttrVal("Id_laborprorecorditm"));
	}	
	/**
	 * 产程观察护理记录单项ID
	 * @param Id_laborprorecorditm
	 */
	public void setId_laborprorecorditm(String Id_laborprorecorditm) {
		setAttrVal("Id_laborprorecorditm", Id_laborprorecorditm);
	}
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
	 * 日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_datetime() {
		return ((FDateTime) getAttrVal("Dt_datetime"));
	}	
	/**
	 * 日期时间
	 * @param Dt_datetime
	 */
	public void setDt_datetime(FDateTime Dt_datetime) {
		setAttrVal("Dt_datetime", Dt_datetime);
	}
	/**
	 * 胎心率
	 * @return FDouble
	 */
	public FDouble getRate_fhr() {
		return ((FDouble) getAttrVal("Rate_fhr"));
	}	
	/**
	 * 胎心率
	 * @param Rate_fhr
	 */
	public void setRate_fhr(FDouble Rate_fhr) {
		setAttrVal("Rate_fhr", Rate_fhr);
	}
	/**
	 * 收缩压
	 * @return Integer
	 */
	public Integer getInt_sbp() {
		return ((Integer) getAttrVal("Int_sbp"));
	}	
	/**
	 * 收缩压
	 * @param Int_sbp
	 */
	public void setInt_sbp(Integer Int_sbp) {
		setAttrVal("Int_sbp", Int_sbp);
	}
	/**
	 * 舒张压
	 * @return Integer
	 */
	public Integer getInt_dbp() {
		return ((Integer) getAttrVal("Int_dbp"));
	}	
	/**
	 * 舒张压
	 * @param Int_dbp
	 */
	public void setInt_dbp(Integer Int_dbp) {
		setAttrVal("Int_dbp", Int_dbp);
	}
	/**
	 * 浓度
	 * @return FDouble
	 */
	public FDouble getNum_concentration() {
		return ((FDouble) getAttrVal("Num_concentration"));
	}	
	/**
	 * 浓度
	 * @param Num_concentration
	 */
	public void setNum_concentration(FDouble Num_concentration) {
		setAttrVal("Num_concentration", Num_concentration);
	}
	/**
	 * 滴速
	 * @return Integer
	 */
	public Integer getNum_speed() {
		return ((Integer) getAttrVal("Num_speed"));
	}	
	/**
	 * 滴速
	 * @param Num_speed
	 */
	public void setNum_speed(Integer Num_speed) {
		setAttrVal("Num_speed", Num_speed);
	}
	/**
	 * 先露
	 * @return String
	 */
	public String getPresentation() {
		return ((String) getAttrVal("Presentation"));
	}	
	/**
	 * 先露
	 * @param Presentation
	 */
	public void setPresentation(String Presentation) {
		setAttrVal("Presentation", Presentation);
	}
	/**
	 * 先露位置
	 * @return String
	 */
	public String getPresentation_position() {
		return ((String) getAttrVal("Presentation_position"));
	}	
	/**
	 * 先露位置
	 * @param Presentation_position
	 */
	public void setPresentation_position(String Presentation_position) {
		setAttrVal("Presentation_position", Presentation_position);
	}
	/**
	 * 先露高低
	 * @return String
	 */
	public String getNum_highlow() {
		return ((String) getAttrVal("Num_highlow"));
	}	
	/**
	 * 先露高低
	 * @param Num_highlow
	 */
	public void setNum_highlow(String Num_highlow) {
		setAttrVal("Num_highlow", Num_highlow);
	}
	/**
	 * 阵缩间隔时间
	 * @return String
	 */
	public String getDt_contra_ctinu() {
		return ((String) getAttrVal("Dt_contra_ctinu"));
	}	
	/**
	 * 阵缩间隔时间
	 * @param Dt_contra_ctinu
	 */
	public void setDt_contra_ctinu(String Dt_contra_ctinu) {
		setAttrVal("Dt_contra_ctinu", Dt_contra_ctinu);
	}
	/**
	 * 阵缩持续时间
	 * @return String
	 */
	public String getDt_contra_interval() {
		return ((String) getAttrVal("Dt_contra_interval"));
	}	
	/**
	 * 阵缩持续时间
	 * @param Dt_contra_interval
	 */
	public void setDt_contra_interval(String Dt_contra_interval) {
		setAttrVal("Dt_contra_interval", Dt_contra_interval);
	}
	/**
	 * 疼痛分
	 * @return Integer
	 */
	public Integer getScore_pain() {
		return ((Integer) getAttrVal("Score_pain"));
	}	
	/**
	 * 疼痛分
	 * @param Score_pain
	 */
	public void setScore_pain(Integer Score_pain) {
		setAttrVal("Score_pain", Score_pain);
	}
	/**
	 * 宫缩
	 * @return String
	 */
	public String getUterine_contraction() {
		return ((String) getAttrVal("Uterine_contraction"));
	}	
	/**
	 * 宫缩
	 * @param Uterine_contraction
	 */
	public void setUterine_contraction(String Uterine_contraction) {
		setAttrVal("Uterine_contraction", Uterine_contraction);
	}
	/**
	 * 宫颈扩张
	 * @return FDouble
	 */
	public FDouble getNum_cvldila() {
		return ((FDouble) getAttrVal("Num_cvldila"));
	}	
	/**
	 * 宫颈扩张
	 * @param Num_cvldila
	 */
	public void setNum_cvldila(FDouble Num_cvldila) {
		setAttrVal("Num_cvldila", Num_cvldila);
	}
	/**
	 * 宫颈硬度
	 * @return String
	 */
	public String getCervical_thickness() {
		return ((String) getAttrVal("Cervical_thickness"));
	}	
	/**
	 * 宫颈硬度
	 * @param Cervical_thickness
	 */
	public void setCervical_thickness(String Cervical_thickness) {
		setAttrVal("Cervical_thickness", Cervical_thickness);
	}
	/**
	 * 胎方位
	 * @return String
	 */
	public String getId_positionoffetus() {
		return ((String) getAttrVal("Id_positionoffetus"));
	}	
	/**
	 * 胎方位
	 * @param Id_positionoffetus
	 */
	public void setId_positionoffetus(String Id_positionoffetus) {
		setAttrVal("Id_positionoffetus", Id_positionoffetus);
	}
	/**
	 * 胎方位编码
	 * @return String
	 */
	public String getSd_positionoffetus() {
		return ((String) getAttrVal("Sd_positionoffetus"));
	}	
	/**
	 * 胎方位编码
	 * @param Sd_positionoffetus
	 */
	public void setSd_positionoffetus(String Sd_positionoffetus) {
		setAttrVal("Sd_positionoffetus", Sd_positionoffetus);
	}
	/**
	 * 胎膜
	 * @return String
	 */
	public String getFetal_membranes() {
		return ((String) getAttrVal("Fetal_membranes"));
	}	
	/**
	 * 胎膜
	 * @param Fetal_membranes
	 */
	public void setFetal_membranes(String Fetal_membranes) {
		setAttrVal("Fetal_membranes", Fetal_membranes);
	}
	/**
	 * 检查方式
	 * @return String
	 */
	public String getId_exmmethod() {
		return ((String) getAttrVal("Id_exmmethod"));
	}	
	/**
	 * 检查方式
	 * @param Id_exmmethod
	 */
	public void setId_exmmethod(String Id_exmmethod) {
		setAttrVal("Id_exmmethod", Id_exmmethod);
	}
	/**
	 * 检查方式编码
	 * @return String
	 */
	public String getSd_exmmethod() {
		return ((String) getAttrVal("Sd_exmmethod"));
	}	
	/**
	 * 检查方式编码
	 * @param Sd_exmmethod
	 */
	public void setSd_exmmethod(String Sd_exmmethod) {
		setAttrVal("Sd_exmmethod", Sd_exmmethod);
	}
	/**
	 * 检查阴道
	 * @return Integer
	 */
	public Integer getVagina_exam() {
		return ((Integer) getAttrVal("Vagina_exam"));
	}	
	/**
	 * 检查阴道
	 * @param Vagina_exam
	 */
	public void setVagina_exam(Integer Vagina_exam) {
		setAttrVal("Vagina_exam", Vagina_exam);
	}
	/**
	 * 检查肛门
	 * @return Integer
	 */
	public Integer getAnal_exam() {
		return ((Integer) getAttrVal("Anal_exam"));
	}	
	/**
	 * 检查肛门
	 * @param Anal_exam
	 */
	public void setAnal_exam(Integer Anal_exam) {
		setAttrVal("Anal_exam", Anal_exam);
	}
	/**
	 * 娩出标记
	 * @return String
	 */
	public String getId_fetal_delivery() {
		return ((String) getAttrVal("Id_fetal_delivery"));
	}	
	/**
	 * 娩出标记
	 * @param Id_fetal_delivery
	 */
	public void setId_fetal_delivery(String Id_fetal_delivery) {
		setAttrVal("Id_fetal_delivery", Id_fetal_delivery);
	}
	/**
	 * 娩出标记编码
	 * @return String
	 */
	public String getSd_fetal_delivery() {
		return ((String) getAttrVal("Sd_fetal_delivery"));
	}	
	/**
	 * 娩出标记编码
	 * @param Sd_fetal_delivery
	 */
	public void setSd_fetal_delivery(String Sd_fetal_delivery) {
		setAttrVal("Sd_fetal_delivery", Sd_fetal_delivery);
	}
	/**
	 * 观察及处置
	 * @return String
	 */
	public String getDes_observehandle() {
		return ((String) getAttrVal("Des_observehandle"));
	}	
	/**
	 * 观察及处置
	 * @param Des_observehandle
	 */
	public void setDes_observehandle(String Des_observehandle) {
		setAttrVal("Des_observehandle", Des_observehandle);
	}
	/**
	 * 签名
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * 签名
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
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
	 * 名称
	 * @return String
	 */
	public String getName_posi() {
		return ((String) getAttrVal("Name_posi"));
	}	
	/**
	 * 名称
	 * @param Name_posi
	 */
	public void setName_posi(String Name_posi) {
		setAttrVal("Name_posi", Name_posi);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_exmmethod() {
		return ((String) getAttrVal("Name_exmmethod"));
	}	
	/**
	 * 名称
	 * @param Name_exmmethod
	 */
	public void setName_exmmethod(String Name_exmmethod) {
		setAttrVal("Name_exmmethod", Name_exmmethod);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_fetal_delivery() {
		return ((String) getAttrVal("Name_fetal_delivery"));
	}	
	/**
	 * 名称
	 * @param Name_fetal_delivery
	 */
	public void setName_fetal_delivery(String Name_fetal_delivery) {
		setAttrVal("Name_fetal_delivery", Name_fetal_delivery);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 姓名
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_laborprorecorditm";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_LABREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(LaborprorecorditmDODesc.class);
	}
	
}