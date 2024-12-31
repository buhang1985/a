package iih.nm.nqm.nqmcssty.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmcssty.d.desc.NqmCsStyItmDODesc;
import java.math.BigDecimal;

/**
 * 检查表样式列属性 DO数据 
 * 
 */
public class NqmCsStyItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//唯一标识
	public static final String ID_NQM_CS_STY_ITM= "Id_nqm_cs_sty_itm";
	//检查样式
	public static final String ID_NQM_CS_STY= "Id_nqm_cs_sty";
	//质量标注样式id
	public static final String ID_CS_STYLE= "Id_cs_style";
	//质量标准样式编码
	public static final String SD_CS_STYLE= "Sd_cs_style";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//序号
	public static final String SORTNO= "Sortno";
	//列id
	public static final String ID_COLUMN= "Id_column";
	//列编码
	public static final String SD_COLUMN= "Sd_column";
	//列标题
	public static final String CAPTION_COLUMN= "Caption_column";
	//列宽
	public static final String WIDTH_COLUMN= "Width_column";
	//列类型id
	public static final String ID_COLUMNTP= "Id_columntp";
	//列类型编码
	public static final String SD_COLUMNTP= "Sd_columntp";
	//垂直对齐方式
	public static final String VERTICAL= "Vertical";
	//水平对齐方式
	public static final String HORIZONTAL= "Horizontal";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//列是否可编辑
	public static final String FG_EDITABLE= "Fg_editable";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//质量标准样式名称
	public static final String NAME_CS_STYLE= "Name_cs_style";
	//名称
	public static final String NAME_COLUMN= "Name_column";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 唯一标识
	 * @return String
	 */
	public String getId_nqm_cs_sty_itm() {
		return ((String) getAttrVal("Id_nqm_cs_sty_itm"));
	}	
	/**
	 * 唯一标识
	 * @param Id_nqm_cs_sty_itm
	 */
	public void setId_nqm_cs_sty_itm(String Id_nqm_cs_sty_itm) {
		setAttrVal("Id_nqm_cs_sty_itm", Id_nqm_cs_sty_itm);
	}
	/**
	 * 检查样式
	 * @return String
	 */
	public String getId_nqm_cs_sty() {
		return ((String) getAttrVal("Id_nqm_cs_sty"));
	}	
	/**
	 * 检查样式
	 * @param Id_nqm_cs_sty
	 */
	public void setId_nqm_cs_sty(String Id_nqm_cs_sty) {
		setAttrVal("Id_nqm_cs_sty", Id_nqm_cs_sty);
	}
	/**
	 * 质量标注样式id
	 * @return String
	 */
	public String getId_cs_style() {
		return ((String) getAttrVal("Id_cs_style"));
	}	
	/**
	 * 质量标注样式id
	 * @param Id_cs_style
	 */
	public void setId_cs_style(String Id_cs_style) {
		setAttrVal("Id_cs_style", Id_cs_style);
	}
	/**
	 * 质量标准样式编码
	 * @return String
	 */
	public String getSd_cs_style() {
		return ((String) getAttrVal("Sd_cs_style"));
	}	
	/**
	 * 质量标准样式编码
	 * @param Sd_cs_style
	 */
	public void setSd_cs_style(String Sd_cs_style) {
		setAttrVal("Sd_cs_style", Sd_cs_style);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	 * 列id
	 * @return String
	 */
	public String getId_column() {
		return ((String) getAttrVal("Id_column"));
	}	
	/**
	 * 列id
	 * @param Id_column
	 */
	public void setId_column(String Id_column) {
		setAttrVal("Id_column", Id_column);
	}
	/**
	 * 列编码
	 * @return String
	 */
	public String getSd_column() {
		return ((String) getAttrVal("Sd_column"));
	}	
	/**
	 * 列编码
	 * @param Sd_column
	 */
	public void setSd_column(String Sd_column) {
		setAttrVal("Sd_column", Sd_column);
	}
	/**
	 * 列标题
	 * @return String
	 */
	public String getCaption_column() {
		return ((String) getAttrVal("Caption_column"));
	}	
	/**
	 * 列标题
	 * @param Caption_column
	 */
	public void setCaption_column(String Caption_column) {
		setAttrVal("Caption_column", Caption_column);
	}
	/**
	 * 列宽
	 * @return Integer
	 */
	public Integer getWidth_column() {
		return ((Integer) getAttrVal("Width_column"));
	}	
	/**
	 * 列宽
	 * @param Width_column
	 */
	public void setWidth_column(Integer Width_column) {
		setAttrVal("Width_column", Width_column);
	}
	/**
	 * 列类型id
	 * @return Integer
	 */
	public Integer getId_columntp() {
		return ((Integer) getAttrVal("Id_columntp"));
	}	
	/**
	 * 列类型id
	 * @param Id_columntp
	 */
	public void setId_columntp(Integer Id_columntp) {
		setAttrVal("Id_columntp", Id_columntp);
	}
	/**
	 * 列类型编码
	 * @return String
	 */
	public String getSd_columntp() {
		return ((String) getAttrVal("Sd_columntp"));
	}	
	/**
	 * 列类型编码
	 * @param Sd_columntp
	 */
	public void setSd_columntp(String Sd_columntp) {
		setAttrVal("Sd_columntp", Sd_columntp);
	}
	/**
	 * 垂直对齐方式
	 * @return Integer
	 */
	public Integer getVertical() {
		return ((Integer) getAttrVal("Vertical"));
	}	
	/**
	 * 垂直对齐方式
	 * @param Vertical
	 */
	public void setVertical(Integer Vertical) {
		setAttrVal("Vertical", Vertical);
	}
	/**
	 * 水平对齐方式
	 * @return Integer
	 */
	public Integer getHorizontal() {
		return ((Integer) getAttrVal("Horizontal"));
	}	
	/**
	 * 水平对齐方式
	 * @param Horizontal
	 */
	public void setHorizontal(Integer Horizontal) {
		setAttrVal("Horizontal", Horizontal);
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
	 * 列是否可编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_editable() {
		return ((FBoolean) getAttrVal("Fg_editable"));
	}	
	/**
	 * 列是否可编辑
	 * @param Fg_editable
	 */
	public void setFg_editable(FBoolean Fg_editable) {
		setAttrVal("Fg_editable", Fg_editable);
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
	 * 质量标准样式名称
	 * @return String
	 */
	public String getName_cs_style() {
		return ((String) getAttrVal("Name_cs_style"));
	}	
	/**
	 * 质量标准样式名称
	 * @param Name_cs_style
	 */
	public void setName_cs_style(String Name_cs_style) {
		setAttrVal("Name_cs_style", Name_cs_style);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_column() {
		return ((String) getAttrVal("Name_column"));
	}	
	/**
	 * 名称
	 * @param Name_column
	 */
	public void setName_column(String Name_column) {
		setAttrVal("Name_column", Name_column);
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
		return "Id_nqm_cs_sty_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_CS_STY_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmCsStyItmDODesc.class);
	}
	
}