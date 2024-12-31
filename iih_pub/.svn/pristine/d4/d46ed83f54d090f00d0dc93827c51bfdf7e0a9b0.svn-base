package iih.pe.phm.pehmriskdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmriskdef.d.desc.PeHmRiskSrvItmDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素-体检结果关系定义 DO数据 
 * 
 */
public class PeHmRiskSrvItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康危险因素体检结果关系定义主键标识
	public static final String ID_PEHMRISKSRVITM= "Id_pehmrisksrvitm";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//健康危险因素目录ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//编码
	public static final String CODE_ITEM= "Code_item";
	//名称
	public static final String NAME_ITEM= "Name_item";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康危险因素体检结果关系定义主键标识
	 * @return String
	 */
	public String getId_pehmrisksrvitm() {
		return ((String) getAttrVal("Id_pehmrisksrvitm"));
	}	
	/**
	 * 健康危险因素体检结果关系定义主键标识
	 * @param Id_pehmrisksrvitm
	 */
	public void setId_pehmrisksrvitm(String Id_pehmrisksrvitm) {
		setAttrVal("Id_pehmrisksrvitm", Id_pehmrisksrvitm);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
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
	 * 编码
	 * @return String
	 */
	public String getCode_item() {
		return ((String) getAttrVal("Code_item"));
	}	
	/**
	 * 编码
	 * @param Code_item
	 */
	public void setCode_item(String Code_item) {
		setAttrVal("Code_item", Code_item);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_item() {
		return ((String) getAttrVal("Name_item"));
	}	
	/**
	 * 名称
	 * @param Name_item
	 */
	public void setName_item(String Name_item) {
		setAttrVal("Name_item", Name_item);
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
		return "Id_pehmrisksrvitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pehmrisksrvitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmRiskSrvItmDODesc.class);
	}
	
}