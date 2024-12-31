package iih.pis.ivx.pisivxwordnet.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxwordnet.d.desc.PisIvxWordNetDODesc;
import java.math.BigDecimal;

/**
 * 微信语言识别词网 DO数据 
 * 
 */
public class PisIvxWordNetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务词网主键标识
	public static final String ID_PISIVXWORDNET= "Id_pisivxwordnet";
	//微信服务词网父ID
	public static final String ID_PISIVXWORDNET_PAR= "Id_pisivxwordnet_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//分类
	public static final String GRP= "Grp";
	//同义词标识
	public static final String FG_SYNSET= "Fg_synset";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_PAR= "Code_par";
	//名称
	public static final String NAME_PAR= "Name_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务词网主键标识
	 * @return String
	 */
	public String getId_pisivxwordnet() {
		return ((String) getAttrVal("Id_pisivxwordnet"));
	}	
	/**
	 * 微信服务词网主键标识
	 * @param Id_pisivxwordnet
	 */
	public void setId_pisivxwordnet(String Id_pisivxwordnet) {
		setAttrVal("Id_pisivxwordnet", Id_pisivxwordnet);
	}
	/**
	 * 微信服务词网父ID
	 * @return String
	 */
	public String getId_pisivxwordnet_par() {
		return ((String) getAttrVal("Id_pisivxwordnet_par"));
	}	
	/**
	 * 微信服务词网父ID
	 * @param Id_pisivxwordnet_par
	 */
	public void setId_pisivxwordnet_par(String Id_pisivxwordnet_par) {
		setAttrVal("Id_pisivxwordnet_par", Id_pisivxwordnet_par);
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
	 * 分类
	 * @return Integer
	 */
	public Integer getGrp() {
		return ((Integer) getAttrVal("Grp"));
	}	
	/**
	 * 分类
	 * @param Grp
	 */
	public void setGrp(Integer Grp) {
		setAttrVal("Grp", Grp);
	}
	/**
	 * 同义词标识
	 * @return FBoolean
	 */
	public FBoolean getFg_synset() {
		return ((FBoolean) getAttrVal("Fg_synset"));
	}	
	/**
	 * 同义词标识
	 * @param Fg_synset
	 */
	public void setFg_synset(FBoolean Fg_synset) {
		setAttrVal("Fg_synset", Fg_synset);
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
	 * 编码
	 * @return String
	 */
	public String getCode_par() {
		return ((String) getAttrVal("Code_par"));
	}	
	/**
	 * 编码
	 * @param Code_par
	 */
	public void setCode_par(String Code_par) {
		setAttrVal("Code_par", Code_par);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	/**
	 * 名称
	 * @param Name_par
	 */
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
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
		return "Id_pisivxwordnet";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_wordnet";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxWordNetDODesc.class);
	}
	
}