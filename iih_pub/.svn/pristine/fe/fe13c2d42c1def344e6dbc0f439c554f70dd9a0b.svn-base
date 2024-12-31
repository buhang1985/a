package iih.hp.cp.hpcp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.hpcp.d.desc.HpCpFileDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划文件 DO数据 
 * 
 */
public class HpCpFileDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CP_FILE= "Id_cp_file";
	public static final String ID_CP= "Id_cp";
	public static final String FILECONTENT= "Filecontent";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cp_file() {
		return ((String) getAttrVal("Id_cp_file"));
	}	
	public void setId_cp_file(String Id_cp_file) {
		setAttrVal("Id_cp_file", Id_cp_file);
	}
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	public byte[] getFilecontent() {
		return ((byte[]) getAttrVal("Filecontent"));
	}	
	public void setFilecontent(byte[] Filecontent) {
		setAttrVal("Filecontent", Filecontent);
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
		return "Id_cp_file";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_cp_file";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpFileDODesc.class);
	}
	
}