package iih.pis.ivx.pisivxnews.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxnews.d.desc.PisivxNewsDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-新闻 DO数据 
 * 
 */
public class PisivxNewsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信新闻主键标识
	public static final String ID_PISIVXNEWS= "Id_pisivxnews";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//第一条文章标题
	public static final String FIRSTTITLE= "Firsttitle";
	//文章条数 
	public static final String ARTICLECOUNT= "Articlecount";
	//创建者
	public static final String CREATEUSER= "Createuser";
	//新闻创建时间
	public static final String CREATETIME= "Createtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信新闻主键标识
	 * @return String
	 */
	public String getId_pisivxnews() {
		return ((String) getAttrVal("Id_pisivxnews"));
	}	
	/**
	 * 微信新闻主键标识
	 * @param Id_pisivxnews
	 */
	public void setId_pisivxnews(String Id_pisivxnews) {
		setAttrVal("Id_pisivxnews", Id_pisivxnews);
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
	 * 第一条文章标题
	 * @return String
	 */
	public String getFirsttitle() {
		return ((String) getAttrVal("Firsttitle"));
	}	
	/**
	 * 第一条文章标题
	 * @param Firsttitle
	 */
	public void setFirsttitle(String Firsttitle) {
		setAttrVal("Firsttitle", Firsttitle);
	}
	/**
	 * 文章条数 
	 * @return Integer
	 */
	public Integer getArticlecount() {
		return ((Integer) getAttrVal("Articlecount"));
	}	
	/**
	 * 文章条数 
	 * @param Articlecount
	 */
	public void setArticlecount(Integer Articlecount) {
		setAttrVal("Articlecount", Articlecount);
	}
	/**
	 * 创建者
	 * @return String
	 */
	public String getCreateuser() {
		return ((String) getAttrVal("Createuser"));
	}	
	/**
	 * 创建者
	 * @param Createuser
	 */
	public void setCreateuser(String Createuser) {
		setAttrVal("Createuser", Createuser);
	}
	/**
	 * 新闻创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatetime() {
		return ((FDateTime) getAttrVal("Createtime"));
	}	
	/**
	 * 新闻创建时间
	 * @param Createtime
	 */
	public void setCreatetime(FDateTime Createtime) {
		setAttrVal("Createtime", Createtime);
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
		return "Id_pisivxnews";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_news";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxNewsDODesc.class);
	}
	
}