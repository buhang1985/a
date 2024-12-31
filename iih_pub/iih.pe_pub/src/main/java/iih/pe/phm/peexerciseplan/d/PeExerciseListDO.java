package iih.pe.phm.peexerciseplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.peexerciseplan.d.desc.PeExerciseListDODesc;
import java.math.BigDecimal;

/**
 * 体检运动计划适宜运动列表 DO数据 
 * 
 */
public class PeExerciseListDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检运动计划运动列表主键标识
	public static final String ID_PEEXERCISELIST= "Id_peexerciselist";
	//体检运动处方ID
	public static final String ID_PEEXERCISEPLAN= "Id_peexerciseplan";
	//体检运动种类ID
	public static final String ID_PEEXERCISE= "Id_peexercise";
	//编码
	public static final String CODE_EX= "Code_ex";
	//名称
	public static final String NAME_EX= "Name_ex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检运动计划运动列表主键标识
	 * @return String
	 */
	public String getId_peexerciselist() {
		return ((String) getAttrVal("Id_peexerciselist"));
	}	
	/**
	 * 体检运动计划运动列表主键标识
	 * @param Id_peexerciselist
	 */
	public void setId_peexerciselist(String Id_peexerciselist) {
		setAttrVal("Id_peexerciselist", Id_peexerciselist);
	}
	/**
	 * 体检运动处方ID
	 * @return String
	 */
	public String getId_peexerciseplan() {
		return ((String) getAttrVal("Id_peexerciseplan"));
	}	
	/**
	 * 体检运动处方ID
	 * @param Id_peexerciseplan
	 */
	public void setId_peexerciseplan(String Id_peexerciseplan) {
		setAttrVal("Id_peexerciseplan", Id_peexerciseplan);
	}
	/**
	 * 体检运动种类ID
	 * @return String
	 */
	public String getId_peexercise() {
		return ((String) getAttrVal("Id_peexercise"));
	}	
	/**
	 * 体检运动种类ID
	 * @param Id_peexercise
	 */
	public void setId_peexercise(String Id_peexercise) {
		setAttrVal("Id_peexercise", Id_peexercise);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_ex() {
		return ((String) getAttrVal("Code_ex"));
	}	
	/**
	 * 编码
	 * @param Code_ex
	 */
	public void setCode_ex(String Code_ex) {
		setAttrVal("Code_ex", Code_ex);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ex() {
		return ((String) getAttrVal("Name_ex"));
	}	
	/**
	 * 名称
	 * @param Name_ex
	 */
	public void setName_ex(String Name_ex) {
		setAttrVal("Name_ex", Name_ex);
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
		return "Id_peexerciselist";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_peexerciselist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeExerciseListDODesc.class);
	}
	
}