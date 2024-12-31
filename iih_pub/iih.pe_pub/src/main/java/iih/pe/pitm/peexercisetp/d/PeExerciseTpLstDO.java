package iih.pe.pitm.peexercisetp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.peexercisetp.d.desc.PeExerciseTpLstDODesc;
import java.math.BigDecimal;

/**
 * 体检运动类别明细 DO数据 
 * 
 */
public class PeExerciseTpLstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检运动类别明细主键标识
	public static final String ID_PEEXERCISETPLST= "Id_peexercisetplst";
	//体检运动类别ID
	public static final String ID_PEEXERCISETP= "Id_peexercisetp";
	//体检运动种类ID
	public static final String ID_PEEXERCISE= "Id_peexercise";
	//编码
	public static final String CODE_EXERCISE= "Code_exercise";
	//名称
	public static final String NAME_EXERCISE= "Name_exercise";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检运动类别明细主键标识
	 * @return String
	 */
	public String getId_peexercisetplst() {
		return ((String) getAttrVal("Id_peexercisetplst"));
	}	
	/**
	 * 体检运动类别明细主键标识
	 * @param Id_peexercisetplst
	 */
	public void setId_peexercisetplst(String Id_peexercisetplst) {
		setAttrVal("Id_peexercisetplst", Id_peexercisetplst);
	}
	/**
	 * 体检运动类别ID
	 * @return String
	 */
	public String getId_peexercisetp() {
		return ((String) getAttrVal("Id_peexercisetp"));
	}	
	/**
	 * 体检运动类别ID
	 * @param Id_peexercisetp
	 */
	public void setId_peexercisetp(String Id_peexercisetp) {
		setAttrVal("Id_peexercisetp", Id_peexercisetp);
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
	public String getCode_exercise() {
		return ((String) getAttrVal("Code_exercise"));
	}	
	/**
	 * 编码
	 * @param Code_exercise
	 */
	public void setCode_exercise(String Code_exercise) {
		setAttrVal("Code_exercise", Code_exercise);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_exercise() {
		return ((String) getAttrVal("Name_exercise"));
	}	
	/**
	 * 名称
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
		return "Id_peexercisetplst";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peexercisetplst";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeExerciseTpLstDODesc.class);
	}
	
}