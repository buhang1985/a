package iih.mi.mc.mimctactics.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mc.mimctactics.d.desc.MiMcTacticsParaDesc;
import java.math.BigDecimal;

/**
 * 医保策略库参数 DO数据 
 * 
 */
public class MiMcTacticsPara extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医保策略库主键
	public static final String ID_HPTACTICS= "Id_hptactics";
	//医保策略库下参数主键
	public static final String ID_HPTACTICSPARA= "Id_hptacticspara";
	//参数
	public static final String ID_PARAMSET= "Id_paramset";
	//参数编码
	public static final String PARAMCODE= "Paramcode";
	//参数名称
	public static final String PARAMNAME= "Paramname";
	//参数描述
	public static final String REMARK= "Remark";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医保策略库主键
	 * @return String
	 */
	public String getId_hptactics() {
		return ((String) getAttrVal("Id_hptactics"));
	}	
	/**
	 * 医保策略库主键
	 * @param Id_hptactics
	 */
	public void setId_hptactics(String Id_hptactics) {
		setAttrVal("Id_hptactics", Id_hptactics);
	}
	/**
	 * 医保策略库下参数主键
	 * @return String
	 */
	public String getId_hptacticspara() {
		return ((String) getAttrVal("Id_hptacticspara"));
	}	
	/**
	 * 医保策略库下参数主键
	 * @param Id_hptacticspara
	 */
	public void setId_hptacticspara(String Id_hptacticspara) {
		setAttrVal("Id_hptacticspara", Id_hptacticspara);
	}
	/**
	 * 参数
	 * @return String
	 */
	public String getId_paramset() {
		return ((String) getAttrVal("Id_paramset"));
	}	
	/**
	 * 参数
	 * @param Id_paramset
	 */
	public void setId_paramset(String Id_paramset) {
		setAttrVal("Id_paramset", Id_paramset);
	}
	/**
	 * 参数编码
	 * @return String
	 */
	public String getParamcode() {
		return ((String) getAttrVal("Paramcode"));
	}	
	/**
	 * 参数编码
	 * @param Paramcode
	 */
	public void setParamcode(String Paramcode) {
		setAttrVal("Paramcode", Paramcode);
	}
	/**
	 * 参数名称
	 * @return String
	 */
	public String getParamname() {
		return ((String) getAttrVal("Paramname"));
	}	
	/**
	 * 参数名称
	 * @param Paramname
	 */
	public void setParamname(String Paramname) {
		setAttrVal("Paramname", Paramname);
	}
	/**
	 * 参数描述
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 参数描述
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
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
		return "Id_hptacticspara";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_mc_tactics_para";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiMcTacticsParaDesc.class);
	}
	
}