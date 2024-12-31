package iih.pe.phm.peexerciseplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.peexerciseplan.d.desc.PeExercisePlanDtlDODesc;
import java.math.BigDecimal;

/**
 * 体检运动计划运动量 DO数据 
 * 
 */
public class PeExercisePlanDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检运动计划明细主键标识
	public static final String ID_PEEXERCISEPLANDTL= "Id_peexerciseplandtl";
	//体检运动处方ID
	public static final String ID_PEEXERCISEPLAN= "Id_peexerciseplan";
	//运动频率
	public static final String FRQ= "Frq";
	//运动时长
	public static final String DU= "Du";
	//displaynam5
	public static final String NAME5= "Name5";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检运动计划明细主键标识
	 * @return String
	 */
	public String getId_peexerciseplandtl() {
		return ((String) getAttrVal("Id_peexerciseplandtl"));
	}	
	/**
	 * 体检运动计划明细主键标识
	 * @param Id_peexerciseplandtl
	 */
	public void setId_peexerciseplandtl(String Id_peexerciseplandtl) {
		setAttrVal("Id_peexerciseplandtl", Id_peexerciseplandtl);
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
	 * 运动频率
	 * @return Integer
	 */
	public Integer getFrq() {
		return ((Integer) getAttrVal("Frq"));
	}	
	/**
	 * 运动频率
	 * @param Frq
	 */
	public void setFrq(Integer Frq) {
		setAttrVal("Frq", Frq);
	}
	/**
	 * 运动时长
	 * @return Integer
	 */
	public Integer getDu() {
		return ((Integer) getAttrVal("Du"));
	}	
	/**
	 * 运动时长
	 * @param Du
	 */
	public void setDu(Integer Du) {
		setAttrVal("Du", Du);
	}
	/**
	 * displaynam5
	 * @return String
	 */
	public String getName5() {
		return ((String) getAttrVal("Name5"));
	}	
	/**
	 * displaynam5
	 * @param Name5
	 */
	public void setName5(String Name5) {
		setAttrVal("Name5", Name5);
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
		return "Id_peexerciseplandtl";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_peexerciseplandtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeExercisePlanDtlDODesc.class);
	}
	
}