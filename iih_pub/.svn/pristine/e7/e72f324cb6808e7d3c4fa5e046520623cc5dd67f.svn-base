package iih.pe.phm.pechrodise.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pechrodise.d.desc.PeChroDiseScDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病风险评估结果运动处方 DO数据 
 * 
 */
public class PeChroDiseScDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病评估运动处方主键标识
	public static final String ID_PECHRODISESC= "Id_pechrodisesc";
	//体检慢性病评估ID
	public static final String ID_PECHRODISE= "Id_pechrodise";
	//体检叙述型运动处方ID
	public static final String ID_PENSC= "Id_pensc";
	//运动目的
	public static final String GOAL= "Goal";
	//运动项目
	public static final String PROGRAM= "Program";
	//运动强度
	public static final String STRENGTH= "Strength";
	//运动时间
	public static final String DURATION= "Duration";
	//运动频率
	public static final String FREQUENCY= "Frequency";
	//注意事项
	public static final String ATTENTION= "Attention";
	//处方编码
	public static final String CODE= "Code";
	//处方名称
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病评估运动处方主键标识
	 * @return String
	 */
	public String getId_pechrodisesc() {
		return ((String) getAttrVal("Id_pechrodisesc"));
	}	
	/**
	 * 体检慢性病评估运动处方主键标识
	 * @param Id_pechrodisesc
	 */
	public void setId_pechrodisesc(String Id_pechrodisesc) {
		setAttrVal("Id_pechrodisesc", Id_pechrodisesc);
	}
	/**
	 * 体检慢性病评估ID
	 * @return String
	 */
	public String getId_pechrodise() {
		return ((String) getAttrVal("Id_pechrodise"));
	}	
	/**
	 * 体检慢性病评估ID
	 * @param Id_pechrodise
	 */
	public void setId_pechrodise(String Id_pechrodise) {
		setAttrVal("Id_pechrodise", Id_pechrodise);
	}
	/**
	 * 体检叙述型运动处方ID
	 * @return String
	 */
	public String getId_pensc() {
		return ((String) getAttrVal("Id_pensc"));
	}	
	/**
	 * 体检叙述型运动处方ID
	 * @param Id_pensc
	 */
	public void setId_pensc(String Id_pensc) {
		setAttrVal("Id_pensc", Id_pensc);
	}
	/**
	 * 运动目的
	 * @return String
	 */
	public String getGoal() {
		return ((String) getAttrVal("Goal"));
	}	
	/**
	 * 运动目的
	 * @param Goal
	 */
	public void setGoal(String Goal) {
		setAttrVal("Goal", Goal);
	}
	/**
	 * 运动项目
	 * @return String
	 */
	public String getProgram() {
		return ((String) getAttrVal("Program"));
	}	
	/**
	 * 运动项目
	 * @param Program
	 */
	public void setProgram(String Program) {
		setAttrVal("Program", Program);
	}
	/**
	 * 运动强度
	 * @return String
	 */
	public String getStrength() {
		return ((String) getAttrVal("Strength"));
	}	
	/**
	 * 运动强度
	 * @param Strength
	 */
	public void setStrength(String Strength) {
		setAttrVal("Strength", Strength);
	}
	/**
	 * 运动时间
	 * @return String
	 */
	public String getDuration() {
		return ((String) getAttrVal("Duration"));
	}	
	/**
	 * 运动时间
	 * @param Duration
	 */
	public void setDuration(String Duration) {
		setAttrVal("Duration", Duration);
	}
	/**
	 * 运动频率
	 * @return String
	 */
	public String getFrequency() {
		return ((String) getAttrVal("Frequency"));
	}	
	/**
	 * 运动频率
	 * @param Frequency
	 */
	public void setFrequency(String Frequency) {
		setAttrVal("Frequency", Frequency);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAttention() {
		return ((String) getAttrVal("Attention"));
	}	
	/**
	 * 注意事项
	 * @param Attention
	 */
	public void setAttention(String Attention) {
		setAttrVal("Attention", Attention);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 处方编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 处方名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_pechrodisesc";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pechrodisesc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDiseScDODesc.class);
	}
	
}