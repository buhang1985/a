package iih.pe.pqn.peevalchrodef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrodef.d.desc.PeChroExerciseDefDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病运动处方定义 DO数据 
 * 
 */
public class PeChroExerciseDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病运动处方定义主键标识
	public static final String ID_PECHROEXERCISEDEF= "Id_pechroexercisedef";
	//体检慢性病定义ID
	public static final String ID_PEEVALCHRODEF= "Id_peevalchrodef";
	//体检叙述型运动处方ID
	public static final String ID_PENSC= "Id_pensc";
	//处方编码
	public static final String CODE_EXERCISE= "Code_exercise";
	//处方名称
	public static final String NAME_EXERCISE= "Name_exercise";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病运动处方定义主键标识
	 * @return String
	 */
	public String getId_pechroexercisedef() {
		return ((String) getAttrVal("Id_pechroexercisedef"));
	}	
	/**
	 * 体检慢性病运动处方定义主键标识
	 * @param Id_pechroexercisedef
	 */
	public void setId_pechroexercisedef(String Id_pechroexercisedef) {
		setAttrVal("Id_pechroexercisedef", Id_pechroexercisedef);
	}
	/**
	 * 体检慢性病定义ID
	 * @return String
	 */
	public String getId_peevalchrodef() {
		return ((String) getAttrVal("Id_peevalchrodef"));
	}	
	/**
	 * 体检慢性病定义ID
	 * @param Id_peevalchrodef
	 */
	public void setId_peevalchrodef(String Id_peevalchrodef) {
		setAttrVal("Id_peevalchrodef", Id_peevalchrodef);
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
	 * 处方编码
	 * @return String
	 */
	public String getCode_exercise() {
		return ((String) getAttrVal("Code_exercise"));
	}	
	/**
	 * 处方编码
	 * @param Code_exercise
	 */
	public void setCode_exercise(String Code_exercise) {
		setAttrVal("Code_exercise", Code_exercise);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName_exercise() {
		return ((String) getAttrVal("Name_exercise"));
	}	
	/**
	 * 处方名称
	 * @param Name_exercise
	 */
	public void setName_exercise(String Name_exercise) {
		setAttrVal("Name_exercise", Name_exercise);
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
		return "Id_pechroexercisedef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pechroexercisedef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroExerciseDefDODesc.class);
	}
	
}