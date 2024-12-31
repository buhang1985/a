package iih.mkr.std.valdomain.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.std.valdomain.d.desc.ValDomainDODesc;
import java.math.BigDecimal;

/**
 * 值域 DO数据 
 * 
 */
public class ValDomainDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//值域主键
	public static final String ID_VD= "Id_vd";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//序号
	public static final String SORTNO= "Sortno";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//国家编码
	public static final String CD_STD= "Cd_std";
	//版本号
	public static final String VER= "Ver";
	//数据集分类
	public static final String ID_SETCA= "Id_setca";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//描述
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//数据集分类名称
	public static final String NAME_SETCA= "Name_setca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 值域主键
	 * @return String
	 */
	public String getId_vd() {
		return ((String) getAttrVal("Id_vd"));
	}	
	/**
	 * 值域主键
	 * @param Id_vd
	 */
	public void setId_vd(String Id_vd) {
		setAttrVal("Id_vd", Id_vd);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 国家编码
	 * @return String
	 */
	public String getCd_std() {
		return ((String) getAttrVal("Cd_std"));
	}	
	/**
	 * 国家编码
	 * @param Cd_std
	 */
	public void setCd_std(String Cd_std) {
		setAttrVal("Cd_std", Cd_std);
	}
	/**
	 * 版本号
	 * @return String
	 */
	public String getVer() {
		return ((String) getAttrVal("Ver"));
	}	
	/**
	 * 版本号
	 * @param Ver
	 */
	public void setVer(String Ver) {
		setAttrVal("Ver", Ver);
	}
	/**
	 * 数据集分类
	 * @return String
	 */
	public String getId_setca() {
		return ((String) getAttrVal("Id_setca"));
	}	
	/**
	 * 数据集分类
	 * @param Id_setca
	 */
	public void setId_setca(String Id_setca) {
		setAttrVal("Id_setca", Id_setca);
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
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
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
	 * 数据集分类名称
	 * @return String
	 */
	public String getName_setca() {
		return ((String) getAttrVal("Name_setca"));
	}	
	/**
	 * 数据集分类名称
	 * @param Name_setca
	 */
	public void setName_setca(String Name_setca) {
		setAttrVal("Name_setca", Name_setca);
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
		return "Id_vd";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_VD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ValDomainDODesc.class);
	}
	
}