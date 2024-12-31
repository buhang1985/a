package iih.bd.mm.srvprirel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.srvprirel.d.desc.MmSrvPriRelDODesc;
import java.math.BigDecimal;

/**
 * 物品服务对应价表 DO数据 
 * 
 */
public class MmSrvPriRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务价格关系主键
	public static final String ID_REL= "Id_rel";
	//物品服务
	public static final String ID_SRVMM= "Id_srvmm";
	//价表服务
	public static final String ID_SRVPRI= "Id_srvpri";
	//备注
	public static final String DES= "Des";
	//物品
	public static final String ID_MM= "Id_mm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务价格关系主键
	 * @return String
	 */
	public String getId_rel() {
		return ((String) getAttrVal("Id_rel"));
	}	
	/**
	 * 服务价格关系主键
	 * @param Id_rel
	 */
	public void setId_rel(String Id_rel) {
		setAttrVal("Id_rel", Id_rel);
	}
	/**
	 * 物品服务
	 * @return String
	 */
	public String getId_srvmm() {
		return ((String) getAttrVal("Id_srvmm"));
	}	
	/**
	 * 物品服务
	 * @param Id_srvmm
	 */
	public void setId_srvmm(String Id_srvmm) {
		setAttrVal("Id_srvmm", Id_srvmm);
	}
	/**
	 * 价表服务
	 * @return String
	 */
	public String getId_srvpri() {
		return ((String) getAttrVal("Id_srvpri"));
	}	
	/**
	 * 价表服务
	 * @param Id_srvpri
	 */
	public void setId_srvpri(String Id_srvpri) {
		setAttrVal("Id_srvpri", Id_srvpri);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
		return "Id_rel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mmpri_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MmSrvPriRelDODesc.class);
	}
	
}