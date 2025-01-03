package iih.nm.nom.nmnomwbkitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nmnomwbkitm.d.desc.NmNomWbkItmDODesc;
import java.math.BigDecimal;

/**
 * 护士长手册模板 DO数据 
 * 
 */
public class NmNomWbkItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//护士长手册主键
	public static final String ID_NOM_WBK_ITM= "Id_nom_wbk_itm";
	//护士长手册外键
	public static final String ID_NOM_WBK= "Id_nom_wbk";
	//护士长工作手册分类
	public static final String ID_NOM_WBK_CA= "Id_nom_wbk_ca";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//手册名称
	public static final String NAME= "Name";
	//手册类型id
	public static final String ID_WBKTP= "Id_wbktp";
	//手册类型
	public static final String SD_WBKTP= "Sd_wbktp";
	//手册内容
	public static final String CONTENT= "Content";
	//提前预警天数
	public static final String EARLY_DAY= "Early_day";
	//报表路径
	public static final String URLRPT= "Urlrpt";
	//序号
	public static final String SORTNO= "Sortno";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//截止日期
	public static final String DT_END= "Dt_end";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//分类名称
	public static final String NAME_NOM_WBK_CA= "Name_nom_wbk_ca";
	//名称
	public static final String NAME_WBKTP= "Name_wbktp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 护士长手册主键
	 * @return String
	 */
	public String getId_nom_wbk_itm() {
		return ((String) getAttrVal("Id_nom_wbk_itm"));
	}	
	/**
	 * 护士长手册主键
	 * @param Id_nom_wbk_itm
	 */
	public void setId_nom_wbk_itm(String Id_nom_wbk_itm) {
		setAttrVal("Id_nom_wbk_itm", Id_nom_wbk_itm);
	}
	/**
	 * 护士长手册外键
	 * @return String
	 */
	public String getId_nom_wbk() {
		return ((String) getAttrVal("Id_nom_wbk"));
	}	
	/**
	 * 护士长手册外键
	 * @param Id_nom_wbk
	 */
	public void setId_nom_wbk(String Id_nom_wbk) {
		setAttrVal("Id_nom_wbk", Id_nom_wbk);
	}
	/**
	 * 护士长工作手册分类
	 * @return String
	 */
	public String getId_nom_wbk_ca() {
		return ((String) getAttrVal("Id_nom_wbk_ca"));
	}	
	/**
	 * 护士长工作手册分类
	 * @param Id_nom_wbk_ca
	 */
	public void setId_nom_wbk_ca(String Id_nom_wbk_ca) {
		setAttrVal("Id_nom_wbk_ca", Id_nom_wbk_ca);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 手册名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 手册名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 手册类型id
	 * @return String
	 */
	public String getId_wbktp() {
		return ((String) getAttrVal("Id_wbktp"));
	}	
	/**
	 * 手册类型id
	 * @param Id_wbktp
	 */
	public void setId_wbktp(String Id_wbktp) {
		setAttrVal("Id_wbktp", Id_wbktp);
	}
	/**
	 * 手册类型
	 * @return String
	 */
	public String getSd_wbktp() {
		return ((String) getAttrVal("Sd_wbktp"));
	}	
	/**
	 * 手册类型
	 * @param Sd_wbktp
	 */
	public void setSd_wbktp(String Sd_wbktp) {
		setAttrVal("Sd_wbktp", Sd_wbktp);
	}
	/**
	 * 手册内容
	 * @return byte[]
	 */
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}	
	/**
	 * 手册内容
	 * @param Content
	 */
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 提前预警天数
	 * @return Integer
	 */
	public Integer getEarly_day() {
		return ((Integer) getAttrVal("Early_day"));
	}	
	/**
	 * 提前预警天数
	 * @param Early_day
	 */
	public void setEarly_day(Integer Early_day) {
		setAttrVal("Early_day", Early_day);
	}
	/**
	 * 报表路径
	 * @return String
	 */
	public String getUrlrpt() {
		return ((String) getAttrVal("Urlrpt"));
	}	
	/**
	 * 报表路径
	 * @param Urlrpt
	 */
	public void setUrlrpt(String Urlrpt) {
		setAttrVal("Urlrpt", Urlrpt);
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
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 截止日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 截止日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 分类名称
	 * @return String
	 */
	public String getName_nom_wbk_ca() {
		return ((String) getAttrVal("Name_nom_wbk_ca"));
	}	
	/**
	 * 分类名称
	 * @param Name_nom_wbk_ca
	 */
	public void setName_nom_wbk_ca(String Name_nom_wbk_ca) {
		setAttrVal("Name_nom_wbk_ca", Name_nom_wbk_ca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_wbktp() {
		return ((String) getAttrVal("Name_wbktp"));
	}	
	/**
	 * 名称
	 * @param Name_wbktp
	 */
	public void setName_wbktp(String Name_wbktp) {
		setAttrVal("Name_wbktp", Name_wbktp);
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
		return "Id_nom_wbk_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_WBK_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNomWbkItmDODesc.class);
	}
	
}