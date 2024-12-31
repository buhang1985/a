package iih.mp.mpbd.mprscarditm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mprscarditm.d.desc.MpRsCardItmSrvDODesc;
import java.math.BigDecimal;

/**
 * 滚屏卡服务内容 DO数据 
 * 
 */
public class MpRsCardItmSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//滚屏卡服务ID
	public static final String ID_RS_CARD_ITM_SRV= "Id_rs_card_itm_srv";
	//滚屏卡明细ID
	public static final String ID_RS_CARD_ITM= "Id_rs_card_itm";
	//服务ID
	public static final String ID_SRV= "Id_srv";
	//频次ID
	public static final String ID_FREQ= "Id_freq";
	//医嘱用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//滚屏服务名称
	public static final String NAME_RS_SRV= "Name_rs_srv";
	//滚屏服务编码
	public static final String CODE_RS_SRV= "Code_rs_srv";
	//频次名称
	public static final String NAME_FREQ= "Name_freq";
	//医疗要求
	public static final String NAME_ROUTEDES= "Name_routedes";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 滚屏卡服务ID
	 * @return String
	 */
	public String getId_rs_card_itm_srv() {
		return ((String) getAttrVal("Id_rs_card_itm_srv"));
	}	
	/**
	 * 滚屏卡服务ID
	 * @param Id_rs_card_itm_srv
	 */
	public void setId_rs_card_itm_srv(String Id_rs_card_itm_srv) {
		setAttrVal("Id_rs_card_itm_srv", Id_rs_card_itm_srv);
	}
	/**
	 * 滚屏卡明细ID
	 * @return String
	 */
	public String getId_rs_card_itm() {
		return ((String) getAttrVal("Id_rs_card_itm"));
	}	
	/**
	 * 滚屏卡明细ID
	 * @param Id_rs_card_itm
	 */
	public void setId_rs_card_itm(String Id_rs_card_itm) {
		setAttrVal("Id_rs_card_itm", Id_rs_card_itm);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 频次ID
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 频次ID
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 医嘱用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 滚屏服务名称
	 * @return String
	 */
	public String getName_rs_srv() {
		return ((String) getAttrVal("Name_rs_srv"));
	}	
	/**
	 * 滚屏服务名称
	 * @param Name_rs_srv
	 */
	public void setName_rs_srv(String Name_rs_srv) {
		setAttrVal("Name_rs_srv", Name_rs_srv);
	}
	/**
	 * 滚屏服务编码
	 * @return String
	 */
	public String getCode_rs_srv() {
		return ((String) getAttrVal("Code_rs_srv"));
	}	
	/**
	 * 滚屏服务编码
	 * @param Code_rs_srv
	 */
	public void setCode_rs_srv(String Code_rs_srv) {
		setAttrVal("Code_rs_srv", Code_rs_srv);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}	
	/**
	 * 频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 医疗要求
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}	
	/**
	 * 医疗要求
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
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
		return "Id_rs_card_itm_srv";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_RS_CARD_ITM_SRV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpRsCardItmSrvDODesc.class);
	}
	
}