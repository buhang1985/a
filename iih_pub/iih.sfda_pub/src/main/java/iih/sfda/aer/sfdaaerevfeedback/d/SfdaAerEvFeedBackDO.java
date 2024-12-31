package iih.sfda.aer.sfdaaerevfeedback.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevfeedback.d.desc.SfdaAerEvFeedBackDODesc;
import java.math.BigDecimal;

/**
 * 事件上报反馈 DO数据 
 * 
 */
public class SfdaAerEvFeedBackDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//反馈主键
	public static final String ID_AER_EV_FB= "Id_aer_ev_fb";
	//事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//主题
	public static final String THEME= "Theme";
	//反馈内容
	public static final String CONTENT= "Content";
	//序号
	public static final String SORTNO= "Sortno";
	//反馈者
	public static final String ID_PSN_FB= "Id_psn_fb";
	//发起时间
	public static final String DT_FB= "Dt_fb";
	//扩展字段1
	public static final String EXT1= "Ext1";
	//扩展字段2
	public static final String EXT2= "Ext2";
	//扩展字段3
	public static final String EXT3= "Ext3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 反馈主键
	 * @return String
	 */
	public String getId_aer_ev_fb() {
		return ((String) getAttrVal("Id_aer_ev_fb"));
	}	
	/**
	 * 反馈主键
	 * @param Id_aer_ev_fb
	 */
	public void setId_aer_ev_fb(String Id_aer_ev_fb) {
		setAttrVal("Id_aer_ev_fb", Id_aer_ev_fb);
	}
	/**
	 * 事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
	}
	/**
	 * 主题
	 * @return String
	 */
	public String getTheme() {
		return ((String) getAttrVal("Theme"));
	}	
	/**
	 * 主题
	 * @param Theme
	 */
	public void setTheme(String Theme) {
		setAttrVal("Theme", Theme);
	}
	/**
	 * 反馈内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	/**
	 * 反馈内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
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
	 * 反馈者
	 * @return String
	 */
	public String getId_psn_fb() {
		return ((String) getAttrVal("Id_psn_fb"));
	}	
	/**
	 * 反馈者
	 * @param Id_psn_fb
	 */
	public void setId_psn_fb(String Id_psn_fb) {
		setAttrVal("Id_psn_fb", Id_psn_fb);
	}
	/**
	 * 发起时间
	 * @return FDateTime
	 */
	public FDateTime getDt_fb() {
		return ((FDateTime) getAttrVal("Dt_fb"));
	}	
	/**
	 * 发起时间
	 * @param Dt_fb
	 */
	public void setDt_fb(FDateTime Dt_fb) {
		setAttrVal("Dt_fb", Dt_fb);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getExt1() {
		return ((String) getAttrVal("Ext1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ext1
	 */
	public void setExt1(String Ext1) {
		setAttrVal("Ext1", Ext1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getExt2() {
		return ((String) getAttrVal("Ext2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ext2
	 */
	public void setExt2(String Ext2) {
		setAttrVal("Ext2", Ext2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getExt3() {
		return ((String) getAttrVal("Ext3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ext3
	 */
	public void setExt3(String Ext3) {
		setAttrVal("Ext3", Ext3);
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
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
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
		return "Id_aer_ev_fb";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_FEEDBACK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvFeedBackDODesc.class);
	}
	
}