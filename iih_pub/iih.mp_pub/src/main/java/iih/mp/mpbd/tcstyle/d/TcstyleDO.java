package iih.mp.mpbd.tcstyle.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.tcstyle.d.desc.TcstyleDODesc;
import java.math.BigDecimal;

/**
 * 体温单样式 DO数据 
 * 
 */
public class TcstyleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体温单样式ID
	public static final String ID_TC_STY= "Id_tc_sty";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//样式名称
	public static final String NAME= "Name";
	//样式编码
	public static final String CODE= "Code";
	//优先级
	public static final String SORTNO= "Sortno";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//config配置
	public static final String XML_CONFIG= "Xml_config";
	//svg配置
	public static final String XML_SVG= "Xml_svg";
	//初始配置
	public static final String XML_INIT= "Xml_init";
	//所属类型ID
	public static final String ID_OWNTP= "Id_owntp";
	//所属类型编码
	public static final String SD_OWNTP= "Sd_owntp";
	//所属分类
	public static final String EU_STYCA= "Eu_styca";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//拼音码
	public static final String PYCODE= "Pycode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//所属类型名称
	public static final String NAME_OWNTP= "Name_owntp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体温单样式ID
	 * @return String
	 */
	public String getId_tc_sty() {
		return ((String) getAttrVal("Id_tc_sty"));
	}	
	/**
	 * 体温单样式ID
	 * @param Id_tc_sty
	 */
	public void setId_tc_sty(String Id_tc_sty) {
		setAttrVal("Id_tc_sty", Id_tc_sty);
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
	 * 样式名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 样式名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 样式编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 样式编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 优先级
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * config配置
	 * @return byte[]
	 */
	public byte[] getXml_config() {
		return ((byte[]) getAttrVal("Xml_config"));
	}	
	/**
	 * config配置
	 * @param Xml_config
	 */
	public void setXml_config(byte[] Xml_config) {
		setAttrVal("Xml_config", Xml_config);
	}
	/**
	 * svg配置
	 * @return byte[]
	 */
	public byte[] getXml_svg() {
		return ((byte[]) getAttrVal("Xml_svg"));
	}	
	/**
	 * svg配置
	 * @param Xml_svg
	 */
	public void setXml_svg(byte[] Xml_svg) {
		setAttrVal("Xml_svg", Xml_svg);
	}
	/**
	 * 初始配置
	 * @return byte[]
	 */
	public byte[] getXml_init() {
		return ((byte[]) getAttrVal("Xml_init"));
	}	
	/**
	 * 初始配置
	 * @param Xml_init
	 */
	public void setXml_init(byte[] Xml_init) {
		setAttrVal("Xml_init", Xml_init);
	}
	/**
	 * 所属类型ID
	 * @return String
	 */
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	/**
	 * 所属类型ID
	 * @param Id_owntp
	 */
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owntp
	 */
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	/**
	 * 所属分类
	 * @return Integer
	 */
	public Integer getEu_styca() {
		return ((Integer) getAttrVal("Eu_styca"));
	}	
	/**
	 * 所属分类
	 * @param Eu_styca
	 */
	public void setEu_styca(Integer Eu_styca) {
		setAttrVal("Eu_styca", Eu_styca);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 所属类型名称
	 * @return String
	 */
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	/**
	 * 所属类型名称
	 * @param Name_owntp
	 */
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
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
		return "Id_tc_sty";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_tc_sty";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TcstyleDODesc.class);
	}
	
}