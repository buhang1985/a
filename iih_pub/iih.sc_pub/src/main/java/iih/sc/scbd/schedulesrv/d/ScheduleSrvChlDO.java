package iih.sc.scbd.schedulesrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvChlDODesc;
import java.math.BigDecimal;

/**
 * 排版服务渠道 DO数据 
 * 
 */
public class ScheduleSrvChlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCSRVCHL= "Id_scsrvchl";
	public static final String ID_SCSRV= "Id_scsrv";
	public static final String ID_SCCHL= "Id_scchl";
	public static final String SCPOLNO= "Scpolno";
	public static final String CODE_SCCHL= "Code_scchl";
	public static final String NAME_SCCHL= "Name_scchl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scsrvchl() {
		return ((String) getAttrVal("Id_scsrvchl"));
	}	
	public void setId_scsrvchl(String Id_scsrvchl) {
		setAttrVal("Id_scsrvchl", Id_scsrvchl);
	}
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}	
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	public Integer getScpolno() {
		return ((Integer) getAttrVal("Scpolno"));
	}	
	public void setScpolno(Integer Scpolno) {
		setAttrVal("Scpolno", Scpolno);
	}
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}	
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}	
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
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
		return "Id_scsrvchl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_srv_chl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScheduleSrvChlDODesc.class);
	}
	
}