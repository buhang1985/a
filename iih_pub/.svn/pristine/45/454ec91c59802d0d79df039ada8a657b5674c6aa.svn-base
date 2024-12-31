package iih.pis.ivx.pisivxnews.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxnews.d.desc.PisivxArticleDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-文章 DO数据 
 * 
 */
public class PisivxArticleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信文章主键标识
	public static final String ID_PISIVXARTICLE= "Id_pisivxarticle";
	//微信新闻ID
	public static final String ID_PISIVXNEWS= "Id_pisivxnews";
	//文章标题
	public static final String TITLE= "Title";
	//摘要
	public static final String DIGEST= "Digest";
	//文章图片地址
	public static final String PICURL= "Picurl";
	//是否在正文显示封面图片
	public static final String FG_SHOWPIC= "Fg_showpic";
	//正文
	public static final String CONTENT= "Content";
	//原文地址
	public static final String SOURCEURL= "Sourceurl";
	//创建者
	public static final String CREATEUSER= "Createuser";
	//文章创建时间
	public static final String CREATETIME= "Createtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信文章主键标识
	 * @return String
	 */
	public String getId_pisivxarticle() {
		return ((String) getAttrVal("Id_pisivxarticle"));
	}	
	/**
	 * 微信文章主键标识
	 * @param Id_pisivxarticle
	 */
	public void setId_pisivxarticle(String Id_pisivxarticle) {
		setAttrVal("Id_pisivxarticle", Id_pisivxarticle);
	}
	/**
	 * 微信新闻ID
	 * @return String
	 */
	public String getId_pisivxnews() {
		return ((String) getAttrVal("Id_pisivxnews"));
	}	
	/**
	 * 微信新闻ID
	 * @param Id_pisivxnews
	 */
	public void setId_pisivxnews(String Id_pisivxnews) {
		setAttrVal("Id_pisivxnews", Id_pisivxnews);
	}
	/**
	 * 文章标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	/**
	 * 文章标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 摘要
	 * @return String
	 */
	public String getDigest() {
		return ((String) getAttrVal("Digest"));
	}	
	/**
	 * 摘要
	 * @param Digest
	 */
	public void setDigest(String Digest) {
		setAttrVal("Digest", Digest);
	}
	/**
	 * 文章图片地址
	 * @return String
	 */
	public String getPicurl() {
		return ((String) getAttrVal("Picurl"));
	}	
	/**
	 * 文章图片地址
	 * @param Picurl
	 */
	public void setPicurl(String Picurl) {
		setAttrVal("Picurl", Picurl);
	}
	/**
	 * 是否在正文显示封面图片
	 * @return FBoolean
	 */
	public FBoolean getFg_showpic() {
		return ((FBoolean) getAttrVal("Fg_showpic"));
	}	
	/**
	 * 是否在正文显示封面图片
	 * @param Fg_showpic
	 */
	public void setFg_showpic(FBoolean Fg_showpic) {
		setAttrVal("Fg_showpic", Fg_showpic);
	}
	/**
	 * 正文
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	/**
	 * 正文
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 原文地址
	 * @return String
	 */
	public String getSourceurl() {
		return ((String) getAttrVal("Sourceurl"));
	}	
	/**
	 * 原文地址
	 * @param Sourceurl
	 */
	public void setSourceurl(String Sourceurl) {
		setAttrVal("Sourceurl", Sourceurl);
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
	 * 文章创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatetime() {
		return ((FDateTime) getAttrVal("Createtime"));
	}	
	/**
	 * 文章创建时间
	 * @param Createtime
	 */
	public void setCreatetime(FDateTime Createtime) {
		setAttrVal("Createtime", Createtime);
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
		return "Id_pisivxarticle";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_article";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxArticleDODesc.class);
	}
	
}