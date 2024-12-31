package iih.bd.srv.reportcardtplstream.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.reportcardtplstream.d.desc.ReportcardtplstreamDesc;
import java.math.BigDecimal;

/**
 * 报卡模板流 DO数据 
 * 
 */
public class Reportcardtplstream extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RCM_TPL_FS= "Id_rcm_tpl_fs";
	public static final String ID_BD_RCM_TPL= "Id_bd_rcm_tpl";
	public static final String FS= "Fs";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rcm_tpl_fs() {
		return ((String) getAttrVal("Id_rcm_tpl_fs"));
	}	
	public void setId_rcm_tpl_fs(String Id_rcm_tpl_fs) {
		setAttrVal("Id_rcm_tpl_fs", Id_rcm_tpl_fs);
	}
	public String getId_bd_rcm_tpl() {
		return ((String) getAttrVal("Id_bd_rcm_tpl"));
	}	
	public void setId_bd_rcm_tpl(String Id_bd_rcm_tpl) {
		setAttrVal("Id_bd_rcm_tpl", Id_bd_rcm_tpl);
	}
	public byte[] getFs() {
		return ((byte[]) getAttrVal("Fs"));
	}	
	public void setFs(byte[] Fs) {
		setAttrVal("Fs", Fs);
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
		return "Id_rcm_tpl_fs";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_rcm_tpl_fs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ReportcardtplstreamDesc.class);
	}
	
}