package iih.pe.phm.pehmriskdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskRangeDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素分级定义 DO数据 
 * 
 */
public class PeHmRiskRangeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康危险因素范围定义主键标识
	public static final String ID_RISKRANGE= "Id_riskrange";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//序号
	public static final String SORTNO= "Sortno";
	//等级
	public static final String LEVEL_RANGE= "Level_range";
	//提示
	public static final String HINT= "Hint";
	//低值
	public static final String VALUE_LOW= "Value_low";
	//高值
	public static final String VALUE_HIGH= "Value_high";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康危险因素范围定义主键标识
	 * @return String
	 */
	public String getId_riskrange() {
		return ((String) getAttrVal("Id_riskrange"));
	}	
	/**
	 * 健康危险因素范围定义主键标识
	 * @param Id_riskrange
	 */
	public void setId_riskrange(String Id_riskrange) {
		setAttrVal("Id_riskrange", Id_riskrange);
	}
	/**
	 * 健康危险因素目录ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 健康危险因素目录ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
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
	 * 等级
	 * @return Integer
	 */
	public Integer getLevel_range() {
		return ((Integer) getAttrVal("Level_range"));
	}	
	/**
	 * 等级
	 * @param Level_range
	 */
	public void setLevel_range(Integer Level_range) {
		setAttrVal("Level_range", Level_range);
	}
	/**
	 * 提示
	 * @return String
	 */
	public String getHint() {
		return ((String) getAttrVal("Hint"));
	}	
	/**
	 * 提示
	 * @param Hint
	 */
	public void setHint(String Hint) {
		setAttrVal("Hint", Hint);
	}
	/**
	 * 低值
	 * @return FDouble
	 */
	public FDouble getValue_low() {
		return ((FDouble) getAttrVal("Value_low"));
	}	
	/**
	 * 低值
	 * @param Value_low
	 */
	public void setValue_low(FDouble Value_low) {
		setAttrVal("Value_low", Value_low);
	}
	/**
	 * 高值
	 * @return FDouble
	 */
	public FDouble getValue_high() {
		return ((FDouble) getAttrVal("Value_high"));
	}	
	/**
	 * 高值
	 * @param Value_high
	 */
	public void setValue_high(FDouble Value_high) {
		setAttrVal("Value_high", Value_high);
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
		return "Id_riskrange";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_riskrange";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmRiskRangeDODesc.class);
	}
	
}