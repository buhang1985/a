package iih.pe.pqn.pediabmodel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelSexDODesc;
import java.math.BigDecimal;

/**
 * 健康评估模型_糖尿病_性别 DO数据 
 * 
 */
public class PeDiabModelSexDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//糖尿病模型性别主键标识
	public static final String ID_PEDIABMODELSEX= "Id_pediabmodelsex";
	//糖尿病模型ID
	public static final String ID_PEDIABMODEL= "Id_pediabmodel";
	//性别
	public static final String SEXLIMIT= "Sexlimit";
	//评分
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 糖尿病模型性别主键标识
	 * @return String
	 */
	public String getId_pediabmodelsex() {
		return ((String) getAttrVal("Id_pediabmodelsex"));
	}	
	/**
	 * 糖尿病模型性别主键标识
	 * @param Id_pediabmodelsex
	 */
	public void setId_pediabmodelsex(String Id_pediabmodelsex) {
		setAttrVal("Id_pediabmodelsex", Id_pediabmodelsex);
	}
	/**
	 * 糖尿病模型ID
	 * @return String
	 */
	public String getId_pediabmodel() {
		return ((String) getAttrVal("Id_pediabmodel"));
	}	
	/**
	 * 糖尿病模型ID
	 * @param Id_pediabmodel
	 */
	public void setId_pediabmodel(String Id_pediabmodel) {
		setAttrVal("Id_pediabmodel", Id_pediabmodel);
	}
	/**
	 * 性别
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 评分
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
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
		return "Id_pediabmodelsex";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pediabmodelsex";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDiabModelSexDODesc.class);
	}
	
}