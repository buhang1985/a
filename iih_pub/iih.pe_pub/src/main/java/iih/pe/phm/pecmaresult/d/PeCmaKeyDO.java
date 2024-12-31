package iih.pe.phm.pecmaresult.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pecmaresult.d.desc.PeCmaKeyDODesc;
import java.math.BigDecimal;

/**
 * 健康评估自测问卷结果 DO数据 
 * 
 */
public class PeCmaKeyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//自测问卷答案主键标识
	public static final String ID_PECMAKEY= "Id_pecmakey";
	//自测问卷记录ID
	public static final String ID_PECMA= "Id_pecma";
	//问卷选项ID
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	//自由录入结果
	public static final String RST= "Rst";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 自测问卷答案主键标识
	 * @return String
	 */
	public String getId_pecmakey() {
		return ((String) getAttrVal("Id_pecmakey"));
	}	
	/**
	 * 自测问卷答案主键标识
	 * @param Id_pecmakey
	 */
	public void setId_pecmakey(String Id_pecmakey) {
		setAttrVal("Id_pecmakey", Id_pecmakey);
	}
	/**
	 * 自测问卷记录ID
	 * @return String
	 */
	public String getId_pecma() {
		return ((String) getAttrVal("Id_pecma"));
	}	
	/**
	 * 自测问卷记录ID
	 * @param Id_pecma
	 */
	public void setId_pecma(String Id_pecma) {
		setAttrVal("Id_pecma", Id_pecma);
	}
	/**
	 * 问卷选项ID
	 * @return String
	 */
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	/**
	 * 问卷选项ID
	 * @param Id_peqakeydef
	 */
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
	}
	/**
	 * 自由录入结果
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}	
	/**
	 * 自由录入结果
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
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
		return "Id_pecmakey";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_cmakey";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCmaKeyDODesc.class);
	}
	
}