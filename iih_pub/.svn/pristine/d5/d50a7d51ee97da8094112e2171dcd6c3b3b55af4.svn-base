package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.inpatient.d.desc.EntIpntSrvDODesc;
import java.math.BigDecimal;

/**
 * 入院通知单服务项目 DO数据 
 * 
 */
public class EntIpntSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTIPNTSRV= "Id_entipntsrv";
	public static final String ID_ENT_IPNT= "Id_ent_ipnt";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_FREQ= "Id_freq";
	public static final String ID_USEAGE= "Id_useage";
	public static final String SD_USEAGE= "Sd_useage";
	public static final String DESC_USEAGENOTE= "Desc_useagenote";
	public static final String QUAN= "Quan";
	public static final String NOTE= "Note";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entipntsrv() {
		return ((String) getAttrVal("Id_entipntsrv"));
	}	
	public void setId_entipntsrv(String Id_entipntsrv) {
		setAttrVal("Id_entipntsrv", Id_entipntsrv);
	}
	public String getId_ent_ipnt() {
		return ((String) getAttrVal("Id_ent_ipnt"));
	}	
	public void setId_ent_ipnt(String Id_ent_ipnt) {
		setAttrVal("Id_ent_ipnt", Id_ent_ipnt);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	public String getId_useage() {
		return ((String) getAttrVal("Id_useage"));
	}	
	public void setId_useage(String Id_useage) {
		setAttrVal("Id_useage", Id_useage);
	}
	public String getSd_useage() {
		return ((String) getAttrVal("Sd_useage"));
	}	
	public void setSd_useage(String Sd_useage) {
		setAttrVal("Sd_useage", Sd_useage);
	}
	public String getDesc_useagenote() {
		return ((String) getAttrVal("Desc_useagenote"));
	}	
	public void setDesc_useagenote(String Desc_useagenote) {
		setAttrVal("Desc_useagenote", Desc_useagenote);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_entipntsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_ipnt_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntIpntSrvDODesc.class);
	}
	
}