package iih.bd.srv.mrtplstblsec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtplstblsec.d.desc.MrTplSTblSecItmDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录模板智能表格段落项目 DO数据 
 * 
 */
public class MrTplSTblSecItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTPLSTBSECITM= "Id_mrtplstbsecitm";
	public static final String ID_MRTPLSTBSEC= "Id_mrtplstbsec";
	public static final String SORTNO= "Sortno";
	public static final String FG_SRV= "Fg_srv";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_DE= "Id_de";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String FG_VALUE1= "Fg_value1";
	public static final String FG_SRV1= "Fg_srv1";
	public static final String ID_SRV1= "Id_srv1";
	public static final String ID_DE1= "Id_de1";
	public static final String NAME1= "Name1";
	public static final String DES1= "Des1";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtplstbsecitm() {
		return ((String) getAttrVal("Id_mrtplstbsecitm"));
	}	
	public void setId_mrtplstbsecitm(String Id_mrtplstbsecitm) {
		setAttrVal("Id_mrtplstbsecitm", Id_mrtplstbsecitm);
	}
	public String getId_mrtplstbsec() {
		return ((String) getAttrVal("Id_mrtplstbsec"));
	}	
	public void setId_mrtplstbsec(String Id_mrtplstbsec) {
		setAttrVal("Id_mrtplstbsec", Id_mrtplstbsec);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getFg_srv() {
		return ((FBoolean) getAttrVal("Fg_srv"));
	}	
	public void setFg_srv(FBoolean Fg_srv) {
		setAttrVal("Fg_srv", Fg_srv);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public FBoolean getFg_value1() {
		return ((FBoolean) getAttrVal("Fg_value1"));
	}	
	public void setFg_value1(FBoolean Fg_value1) {
		setAttrVal("Fg_value1", Fg_value1);
	}
	public FBoolean getFg_srv1() {
		return ((FBoolean) getAttrVal("Fg_srv1"));
	}	
	public void setFg_srv1(FBoolean Fg_srv1) {
		setAttrVal("Fg_srv1", Fg_srv1);
	}
	public String getId_srv1() {
		return ((String) getAttrVal("Id_srv1"));
	}	
	public void setId_srv1(String Id_srv1) {
		setAttrVal("Id_srv1", Id_srv1);
	}
	public String getId_de1() {
		return ((String) getAttrVal("Id_de1"));
	}	
	public void setId_de1(String Id_de1) {
		setAttrVal("Id_de1", Id_de1);
	}
	public String getName1() {
		return ((String) getAttrVal("Name1"));
	}	
	public void setName1(String Name1) {
		setAttrVal("Name1", Name1);
	}
	public String getDes1() {
		return ((String) getAttrVal("Des1"));
	}	
	public void setDes1(String Des1) {
		setAttrVal("Des1", Des1);
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
		return "Id_mrtplstbsecitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtpl_stbsec_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTplSTblSecItmDODesc.class);
	}
	
}