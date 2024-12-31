package iih.ci.mrqc.cimrrecalladd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.cimrrecalladd.d.desc.CiMrRecallAddDODesc;
import java.math.BigDecimal;

/**
 * 病历召回新增 DO数据 
 * 
 */
public class CiMrRecallAddDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_RCAD= "Id_mr_rcad";
	public static final String ID_MR_RECALL= "Id_mr_recall";
	public static final String ID_MRCACTM= "Id_mrcactm";
	public static final String ID_MRTP= "Id_mrtp";
	public static final String FG_OP= "Fg_op";
	public static final String NAME_MRCACTM= "Name_mrcactm";
	public static final String MRTP_NAME= "Mrtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_rcad() {
		return ((String) getAttrVal("Id_mr_rcad"));
	}	
	public void setId_mr_rcad(String Id_mr_rcad) {
		setAttrVal("Id_mr_rcad", Id_mr_rcad);
	}
	public String getId_mr_recall() {
		return ((String) getAttrVal("Id_mr_recall"));
	}	
	public void setId_mr_recall(String Id_mr_recall) {
		setAttrVal("Id_mr_recall", Id_mr_recall);
	}
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}	
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	public String getName_mrcactm() {
		return ((String) getAttrVal("Name_mrcactm"));
	}	
	public void setName_mrcactm(String Name_mrcactm) {
		setAttrVal("Name_mrcactm", Name_mrcactm);
	}
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
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
		return "Id_mr_rcad";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_rcad";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrRecallAddDODesc.class);
	}
	
}