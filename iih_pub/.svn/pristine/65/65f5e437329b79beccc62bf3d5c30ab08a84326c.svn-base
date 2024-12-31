package iih.pe.pqn.peevalchrorisk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalchrorisk.d.desc.PeChroRstDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病风险因素-检查结果 DO数据 
 * 
 */
public class PeChroRstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病风险因素结果主键标识
	public static final String ID_PECHRORISKRST= "Id_pechroriskrst";
	//体检慢性病风险因素ID
	public static final String ID_PECHRORISK= "Id_pechrorisk";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//体检结果异常标识
	public static final String MARK= "Mark";
	//编码
	public static final String CODE_RST= "Code_rst";
	//名称
	public static final String NAME_RST= "Name_rst";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病风险因素结果主键标识
	 * @return String
	 */
	public String getId_pechroriskrst() {
		return ((String) getAttrVal("Id_pechroriskrst"));
	}	
	/**
	 * 体检慢性病风险因素结果主键标识
	 * @param Id_pechroriskrst
	 */
	public void setId_pechroriskrst(String Id_pechroriskrst) {
		setAttrVal("Id_pechroriskrst", Id_pechroriskrst);
	}
	/**
	 * 体检慢性病风险因素ID
	 * @return String
	 */
	public String getId_pechrorisk() {
		return ((String) getAttrVal("Id_pechrorisk"));
	}	
	/**
	 * 体检慢性病风险因素ID
	 * @param Id_pechrorisk
	 */
	public void setId_pechrorisk(String Id_pechrorisk) {
		setAttrVal("Id_pechrorisk", Id_pechrorisk);
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
	 * 体检结果异常标识
	 * @return String
	 */
	public String getMark() {
		return ((String) getAttrVal("Mark"));
	}	
	/**
	 * 体检结果异常标识
	 * @param Mark
	 */
	public void setMark(String Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_rst() {
		return ((String) getAttrVal("Code_rst"));
	}	
	/**
	 * 编码
	 * @param Code_rst
	 */
	public void setCode_rst(String Code_rst) {
		setAttrVal("Code_rst", Code_rst);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rst() {
		return ((String) getAttrVal("Name_rst"));
	}	
	/**
	 * 名称
	 * @param Name_rst
	 */
	public void setName_rst(String Name_rst) {
		setAttrVal("Name_rst", Name_rst);
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
		return "Id_pechroriskrst";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_pechrorst";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroRstDODesc.class);
	}
	
}