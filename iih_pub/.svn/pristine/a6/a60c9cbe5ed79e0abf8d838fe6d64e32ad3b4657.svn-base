package iih.mp.ot.deptmp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ot.deptmp.d.desc.MpOrPrTmpDtDODesc;
import java.math.BigDecimal;

/**
 * 通用医技科室模板明细 DO数据 
 * 
 */
public class MpOrPrTmpDtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORPRTMPDT= "Id_orprtmpdt";
	public static final String ID_ORPRTMP= "Id_orprtmp";
	public static final String ID_SRV= "Id_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String QUAN= "Quan";
	public static final String ID_UNIT= "Id_unit";
	public static final String PRI= "Pri";
	public static final String SRV_NAME= "Srv_name";
	public static final String NAME_UNIT= "Name_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orprtmpdt() {
		return ((String) getAttrVal("Id_orprtmpdt"));
	}	
	public void setId_orprtmpdt(String Id_orprtmpdt) {
		setAttrVal("Id_orprtmpdt", Id_orprtmpdt);
	}
	public String getId_orprtmp() {
		return ((String) getAttrVal("Id_orprtmp"));
	}	
	public void setId_orprtmp(String Id_orprtmp) {
		setAttrVal("Id_orprtmp", Id_orprtmp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
		return "Id_orprtmpdt";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_OR_PR_TMP_DT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOrPrTmpDtDODesc.class);
	}
	
}