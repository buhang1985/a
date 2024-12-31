package iih.mp.orm.surginsmtmrtpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.orm.surginsmtmrtpl.d.desc.SurgInsmtMrtplItemDODesc;
import java.math.BigDecimal;

/**
 * 手术器械模板明细 DO数据 
 * 
 */
public class SurgInsmtMrtplItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//手术器械模板明细ID主键
	public static final String ID_MOMTITM= "Id_momtitm";
	//手术器械模板
	public static final String ID_MOMT= "Id_momt";
	//手术器械
	public static final String ID_MMOM= "Id_mmom";
	//数量
	public static final String QRY_NEED= "Qry_need";
	//序号
	public static final String SORTNO= "Sortno";
	//手术器械
	public static final String MMOM_NAME= "Mmom_name";
	//物品编码
	public static final String MMOM_CODE= "Mmom_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 手术器械模板明细ID主键
	 * @return String
	 */
	public String getId_momtitm() {
		return ((String) getAttrVal("Id_momtitm"));
	}	
	/**
	 * 手术器械模板明细ID主键
	 * @param Id_momtitm
	 */
	public void setId_momtitm(String Id_momtitm) {
		setAttrVal("Id_momtitm", Id_momtitm);
	}
	/**
	 * 手术器械模板
	 * @return String
	 */
	public String getId_momt() {
		return ((String) getAttrVal("Id_momt"));
	}	
	/**
	 * 手术器械模板
	 * @param Id_momt
	 */
	public void setId_momt(String Id_momt) {
		setAttrVal("Id_momt", Id_momt);
	}
	/**
	 * 手术器械
	 * @return String
	 */
	public String getId_mmom() {
		return ((String) getAttrVal("Id_mmom"));
	}	
	/**
	 * 手术器械
	 * @param Id_mmom
	 */
	public void setId_mmom(String Id_mmom) {
		setAttrVal("Id_mmom", Id_mmom);
	}
	/**
	 * 数量
	 * @return Integer
	 */
	public Integer getQry_need() {
		return ((Integer) getAttrVal("Qry_need"));
	}	
	/**
	 * 数量
	 * @param Qry_need
	 */
	public void setQry_need(Integer Qry_need) {
		setAttrVal("Qry_need", Qry_need);
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
	 * 手术器械
	 * @return String
	 */
	public String getMmom_name() {
		return ((String) getAttrVal("Mmom_name"));
	}	
	/**
	 * 手术器械
	 * @param Mmom_name
	 */
	public void setMmom_name(String Mmom_name) {
		setAttrVal("Mmom_name", Mmom_name);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMmom_code() {
		return ((String) getAttrVal("Mmom_code"));
	}	
	/**
	 * 物品编码
	 * @param Mmom_code
	 */
	public void setMmom_code(String Mmom_code) {
		setAttrVal("Mmom_code", Mmom_code);
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
		return "Id_momtitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_ORM_MM_TMPL_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SurgInsmtMrtplItemDODesc.class);
	}
	
}