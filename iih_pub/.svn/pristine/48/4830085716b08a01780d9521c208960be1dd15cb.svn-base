
package iih.bd.srv.qcconreject.d.desc;

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
 * 病历内容互斥项目 DO 元数据信息
 */
public class QcconrejectitemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.qcconreject.d.QcconrejectitemDO";
	public static final String CLASS_DISPALYNAME = "病历内容互斥项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mrqc_con_reject_item";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_item";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public QcconrejectitemDODesc(){
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
		this.setKeyDesc(getId_itemADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_rejectADesc(tblDesc));
		this.add(getId_itemADesc(tblDesc));
		this.add(getId_rejectADesc(tblDesc));
		this.add(getId_segmentADesc(tblDesc));
		this.add(getId_elementADesc(tblDesc));
		this.add(getKey_wordADesc(tblDesc));
		this.add(getTip_textADesc(tblDesc));
		this.add(getReject_ruleADesc(tblDesc));
		this.add(getRemarkADesc(tblDesc));
		this.add(getName_dgADesc(tblDesc));
		this.add(getCode_dgADesc(tblDesc));
		this.add(getCode_deADesc(tblDesc));
		this.add(getName_deADesc(tblDesc));
		this.add(getCd_stdADesc(tblDesc));
		this.add(getCode_ruleADesc(tblDesc));
		this.add(getName_ruleADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_itemCDesc(tblDesc));
		tblDesc.add(getId_itemCDesc(tblDesc));
		tblDesc.add(getId_rejectCDesc(tblDesc));
		tblDesc.add(getId_segmentCDesc(tblDesc));
		tblDesc.add(getId_elementCDesc(tblDesc));
		tblDesc.add(getKey_wordCDesc(tblDesc));
		tblDesc.add(getTip_textCDesc(tblDesc));
		tblDesc.add(getReject_ruleCDesc(tblDesc));
		tblDesc.add(getRemarkCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 排斥项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_itemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_item",  getId_itemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排斥项目");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 质控id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rejectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reject",  getId_rejectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("质控id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 段落编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_segmentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_segment",  getId_segmentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("段落编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 元素编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_elementADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_element",  getId_elementCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 关键字属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKey_wordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Key_word",  getKey_wordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关键字");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 冲突提示文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTip_textADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tip_text",  getTip_textCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("冲突提示文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排斥规则属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReject_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reject_rule",  getReject_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排斥规则");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remark",  getRemarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据组名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dg",  getName_dgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据组名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dg a2b2","id_segment=id_dg","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据组编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dg",  getCode_dgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据组编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dg a2b2","id_segment=id_dg","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_de",  getCode_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_de a2b3","id_element=id_de","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_de",  getName_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_de a2b3","id_element=id_de","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 国际编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCd_stdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cd_std",  getCd_stdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("国际编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_de a2b3","id_element=id_de","cd_std"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rule",  getCode_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b4","reject_rule=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rule",  getName_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a2b4","reject_rule=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取排斥项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_itemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_item");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("排斥项目"); 
		return column;
	}
	/**
	 * 获取质控id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rejectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reject");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("质控id"); 
		return column;
	}
	/**
	 * 获取段落编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_segmentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_segment");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("段落编码"); 
		return column;
	}
	/**
	 * 获取元素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_elementCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_element");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素编码"); 
		return column;
	}
	/**
	 * 获取关键字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKey_wordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Key_word");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关键字"); 
		return column;
	}
	/**
	 * 获取冲突提示文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTip_textCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tip_text");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("冲突提示文本"); 
		return column;
	}
	/**
	 * 获取排斥规则表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReject_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reject_rule");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排斥规则"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remark");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取数据组名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据组名称"); 
		return column;
	}
	/**
	 * 获取数据组编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据组编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_de");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_de");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取国际编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCd_stdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cd_std");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("国际编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rule");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rule");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
	}
	
}
