
package iih.pis.ivx.pisivxnews.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 微信服务-文章 DO 元数据信息
 */
public class PisivxArticleDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pis.ivx.pisivxnews.d.PisivxArticleDO";
	public static final String CLASS_DISPALYNAME = "微信服务-文章";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pis_ivx_article";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pisivxarticle";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PisivxArticleDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_pisivxarticleADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pisivxnewsADesc(tblDesc));
		this.add(getId_pisivxarticleADesc(tblDesc));
		this.add(getId_pisivxnewsADesc(tblDesc));
		this.add(getTitleADesc(tblDesc));
		this.add(getDigestADesc(tblDesc));
		this.add(getPicurlADesc(tblDesc));
		this.add(getFg_showpicADesc(tblDesc));
		this.add(getContentADesc(tblDesc));
		this.add(getSourceurlADesc(tblDesc));
		this.add(getCreateuserADesc(tblDesc));
		this.add(getCreatetimeADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_pisivxarticleCDesc(tblDesc));
		tblDesc.add(getId_pisivxarticleCDesc(tblDesc));
		tblDesc.add(getId_pisivxnewsCDesc(tblDesc));
		tblDesc.add(getTitleCDesc(tblDesc));
		tblDesc.add(getDigestCDesc(tblDesc));
		tblDesc.add(getPicurlCDesc(tblDesc));
		tblDesc.add(getFg_showpicCDesc(tblDesc));
		tblDesc.add(getContentCDesc(tblDesc));
		tblDesc.add(getSourceurlCDesc(tblDesc));
		tblDesc.add(getCreateuserCDesc(tblDesc));
		tblDesc.add(getCreatetimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 微信文章主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxarticleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxarticle",  getId_pisivxarticleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信文章主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 微信新闻ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pisivxnewsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pisivxnews",  getId_pisivxnewsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("微信新闻ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文章标题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Title",  getTitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文章标题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摘要属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDigestADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Digest",  getDigestCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摘要");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文章图片地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPicurlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Picurl",  getPicurlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文章图片地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否在正文显示封面图片属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_showpicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_showpic",  getFg_showpicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否在正文显示封面图片");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 正文属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content",  getContentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("正文");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原文地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSourceurlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sourceurl",  getSourceurlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原文地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreateuserADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createuser",  getCreateuserCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文章创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createtime",  getCreatetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("文章创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取微信文章主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxarticleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxarticle");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("微信文章主键标识"); 
		return column;
	}
	/**
	 * 获取微信新闻ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pisivxnewsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pisivxnews");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("微信新闻ID"); 
		return column;
	}
	/**
	 * 获取文章标题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Title");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文章标题"); 
		return column;
	}
	/**
	 * 获取摘要表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDigestCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Digest");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摘要"); 
		return column;
	}
	/**
	 * 获取文章图片地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPicurlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Picurl");
		column.setLength(120);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文章图片地址"); 
		return column;
	}
	/**
	 * 获取是否在正文显示封面图片表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_showpicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_showpic");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否在正文显示封面图片"); 
		return column;
	}
	/**
	 * 获取正文表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content");
		column.setLength(3000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("正文"); 
		return column;
	}
	/**
	 * 获取原文地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSourceurlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sourceurl");
		column.setLength(120);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原文地址"); 
		return column;
	}
	/**
	 * 获取创建者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreateuserCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createuser");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建者"); 
		return column;
	}
	/**
	 * 获取文章创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("文章创建时间"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pisivxarticle");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
