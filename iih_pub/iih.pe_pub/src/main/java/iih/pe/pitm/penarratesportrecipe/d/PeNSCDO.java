package iih.pe.pitm.penarratesportrecipe.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.penarratesportrecipe.d.desc.PeNSCDODesc;
import java.math.BigDecimal;

/**
 * 体检叙述型运动处方 DO数据 
 * 
 */
public class PeNSCDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检叙述型运动处方主键标识
	public static final String ID_PENSC= "Id_pensc";
	//体检叙述型运动处方分类父D
	public static final String ID_PENSCCA= "Id_penscca";
	//处方编码
	public static final String CODE= "Code";
	//处方名称
	public static final String NAME= "Name";
	//序号
	public static final String SORTNO= "Sortno";
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
	 * 体检叙述型运动处方主键标识
	 * @return String
	 */
	public String getId_pensc() {
		return ((String) getAttrVal("Id_pensc"));
	}	
	/**
	 * 体检叙述型运动处方主键标识
	 * @param Id_pensc
	 */
	public void setId_pensc(String Id_pensc) {
		setAttrVal("Id_pensc", Id_pensc);
	}
	/**
	 * 体检叙述型运动处方分类父D
	 * @return String
	 */
	public String getId_penscca() {
		return ((String) getAttrVal("Id_penscca"));
	}	
	/**
	 * 体检叙述型运动处方分类父D
	 * @param Id_penscca
	 */
	public void setId_penscca(String Id_penscca) {
		setAttrVal("Id_penscca", Id_penscca);
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
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_pensc";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pensc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeNSCDODesc.class);
	}
	
}