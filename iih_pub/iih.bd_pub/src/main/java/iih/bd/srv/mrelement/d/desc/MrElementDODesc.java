
package iih.bd.srv.mrelement.d.desc;

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
 * 病历元素 DO 元数据信息
 */
public class MrElementDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.mrelement.d.MrElementDO";
	public static final String CLASS_DISPALYNAME = "病历元素";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mr_de";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mr_de";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MrElementDODesc(){
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
		this.setKeyDesc(getId_mr_deADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mr_deADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getSd_mrdetpADesc(tblDesc));
		this.add(getId_mrdetpADesc(tblDesc));
		this.add(getKeywordsADesc(tblDesc));
		this.add(getPycodeADesc(tblDesc));
		this.add(getWbcodeADesc(tblDesc));
		this.add(getMnecodeADesc(tblDesc));
		this.add(getId_deADesc(tblDesc));
		this.add(getId_dgADesc(tblDesc));
		this.add(getOrder_indexADesc(tblDesc));
		this.add(getId_mraetADesc(tblDesc));
		this.add(getId_mratermgrpADesc(tblDesc));
		this.add(getText_tipADesc(tblDesc));
		this.add(getText_labelADesc(tblDesc));
		this.add(getText_backgroundADesc(tblDesc));
		this.add(getText_cascadeADesc(tblDesc));
		this.add(getText_visibleADesc(tblDesc));
		this.add(getFg_editADesc(tblDesc));
		this.add(getFg_encryptADesc(tblDesc));
		this.add(getFg_deleteADesc(tblDesc));
		this.add(getFg_borderADesc(tblDesc));
		this.add(getFg_hideADesc(tblDesc));
		this.add(getLg_maxADesc(tblDesc));
		this.add(getLg_minADesc(tblDesc));
		this.add(getText_unitADesc(tblDesc));
		this.add(getNu_digitADesc(tblDesc));
		this.add(getNu_maxADesc(tblDesc));
		this.add(getNu_minADesc(tblDesc));
		this.add(getFg_sqlADesc(tblDesc));
		this.add(getText_sqlADesc(tblDesc));
		this.add(getSu_desADesc(tblDesc));
		this.add(getNe_desADesc(tblDesc));
		this.add(getDt_formatADesc(tblDesc));
		this.add(getOut_styleADesc(tblDesc));
		this.add(getOut_formatADesc(tblDesc));
		this.add(getFg_qsADesc(tblDesc));
		this.add(getName_sourceADesc(tblDesc));
		this.add(getName_propertyADesc(tblDesc));
		this.add(getFg_quoteADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getRef_nameADesc(tblDesc));
		this.add(getRef_codeADesc(tblDesc));
		this.add(getActivemethodADesc(tblDesc));
		this.add(getIs_many_selectADesc(tblDesc));
		this.add(getIs_vertical_layoutADesc(tblDesc));
		this.add(getFormat_strADesc(tblDesc));
		this.add(getNu_placeholderADesc(tblDesc));
		this.add(getFg_underlineADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getCode_orgADesc(tblDesc));
		this.add(getCode_grpADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getCode_mrdetpADesc(tblDesc));
		this.add(getName_mrdetpADesc(tblDesc));
		this.add(getCode_deADesc(tblDesc));
		this.add(getName_deADesc(tblDesc));
		this.add(getCode_dgADesc(tblDesc));
		this.add(getName_dgADesc(tblDesc));
		this.add(getCode_mraetADesc(tblDesc));
		this.add(getName_mraetADesc(tblDesc));
		this.add(getCode_mratermgrpADesc(tblDesc));
		this.add(getName_mratermgrpADesc(tblDesc));
		this.add(getCode_out_styleADesc(tblDesc));
		this.add(getName_out_styleADesc(tblDesc));
		this.add(getCode_out_formatADesc(tblDesc));
		this.add(getName_out_formatADesc(tblDesc));
		this.add(getCode_createADesc(tblDesc));
		this.add(getName_createADesc(tblDesc));
		this.add(getName_modifyADesc(tblDesc));
		this.add(getCode_modifyADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mr_deCDesc(tblDesc));
		tblDesc.add(getId_mr_deCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getSd_mrdetpCDesc(tblDesc));
		tblDesc.add(getId_mrdetpCDesc(tblDesc));
		tblDesc.add(getKeywordsCDesc(tblDesc));
		tblDesc.add(getPycodeCDesc(tblDesc));
		tblDesc.add(getWbcodeCDesc(tblDesc));
		tblDesc.add(getMnecodeCDesc(tblDesc));
		tblDesc.add(getId_deCDesc(tblDesc));
		tblDesc.add(getId_dgCDesc(tblDesc));
		tblDesc.add(getOrder_indexCDesc(tblDesc));
		tblDesc.add(getId_mraetCDesc(tblDesc));
		tblDesc.add(getId_mratermgrpCDesc(tblDesc));
		tblDesc.add(getText_tipCDesc(tblDesc));
		tblDesc.add(getText_labelCDesc(tblDesc));
		tblDesc.add(getText_backgroundCDesc(tblDesc));
		tblDesc.add(getText_cascadeCDesc(tblDesc));
		tblDesc.add(getText_visibleCDesc(tblDesc));
		tblDesc.add(getFg_editCDesc(tblDesc));
		tblDesc.add(getFg_encryptCDesc(tblDesc));
		tblDesc.add(getFg_deleteCDesc(tblDesc));
		tblDesc.add(getFg_borderCDesc(tblDesc));
		tblDesc.add(getFg_hideCDesc(tblDesc));
		tblDesc.add(getLg_maxCDesc(tblDesc));
		tblDesc.add(getLg_minCDesc(tblDesc));
		tblDesc.add(getText_unitCDesc(tblDesc));
		tblDesc.add(getNu_digitCDesc(tblDesc));
		tblDesc.add(getNu_maxCDesc(tblDesc));
		tblDesc.add(getNu_minCDesc(tblDesc));
		tblDesc.add(getFg_sqlCDesc(tblDesc));
		tblDesc.add(getText_sqlCDesc(tblDesc));
		tblDesc.add(getSu_desCDesc(tblDesc));
		tblDesc.add(getNe_desCDesc(tblDesc));
		tblDesc.add(getDt_formatCDesc(tblDesc));
		tblDesc.add(getOut_styleCDesc(tblDesc));
		tblDesc.add(getOut_formatCDesc(tblDesc));
		tblDesc.add(getFg_qsCDesc(tblDesc));
		tblDesc.add(getName_sourceCDesc(tblDesc));
		tblDesc.add(getName_propertyCDesc(tblDesc));
		tblDesc.add(getFg_quoteCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getRef_nameCDesc(tblDesc));
		tblDesc.add(getRef_codeCDesc(tblDesc));
		tblDesc.add(getActivemethodCDesc(tblDesc));
		tblDesc.add(getIs_many_selectCDesc(tblDesc));
		tblDesc.add(getIs_vertical_layoutCDesc(tblDesc));
		tblDesc.add(getFormat_strCDesc(tblDesc));
		tblDesc.add(getNu_placeholderCDesc(tblDesc));
		tblDesc.add(getFg_underlineCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_de",  getId_mr_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
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
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC,BCR");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mrdetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mrdetp",  getSd_mrdetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素类型主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrdetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrdetp",  getId_mrdetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型主键");
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
	private IAttrDesc getKeywordsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Keywords",  getKeywordsCDesc(tblDesc), this);
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
	 * 拼音码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPycodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pycode",  getPycodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拼音码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 五笔码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWbcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wbcode",  getWbcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("五笔码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 助记码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMnecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mnecode",  getMnecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("助记码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据元ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_de",  getId_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据元ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数据组ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dg",  getId_dgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据组ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排序序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrder_indexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Order_index",  getOrder_indexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("排序序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mraetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mraet",  getId_mraetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 分组id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mratermgrpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mratermgrp",  getId_mratermgrpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分组id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 提示文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_tipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_tip",  getText_tipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提示文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 标签文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_labelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_label",  getText_labelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("标签文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 背景文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_backgroundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_background",  getText_backgroundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("背景文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 简单级联值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_cascadeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_cascade",  getText_cascadeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("简单级联值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可见表达式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_visibleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_visible",  getText_visibleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可见表达式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否可编辑属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_editADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_edit",  getFg_editCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否可编辑");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否加密属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_encryptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_encrypt",  getFg_encryptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否加密");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否可删除属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_deleteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_delete",  getFg_deleteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否可删除");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否显示边框属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_borderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_border",  getFg_borderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否显示边框");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否可隐藏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hide",  getFg_hideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否可隐藏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大长度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLg_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lg_max",  getLg_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最大长度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小长度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLg_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Lg_min",  getLg_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("最小长度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_unitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_unit",  getText_unitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小数位数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNu_digitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nu_digit",  getNu_digitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("小数位数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNu_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nu_max",  getNu_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最大值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最小值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNu_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nu_min",  getNu_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最小值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值域是否为sql属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_sqlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sql",  getFg_sqlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("值域是否为sql");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值域SQL语句属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getText_sqlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Text_sql",  getText_sqlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值域SQL语句");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肯定前缀属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSu_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Su_des",  getSu_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肯定前缀");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 否定前缀属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNe_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ne_des",  getNe_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("否定前缀");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 时间格式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_formatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_format",  getDt_formatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("时间格式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输出类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_styleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_style",  getOut_styleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输出类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输出格式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOut_formatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Out_format",  getOut_formatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输出格式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否为源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_qsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_qs",  getFg_qsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否为源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sourceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_source",  getName_sourceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 属性名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_propertyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_property",  getName_propertyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("属性名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否为引用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_quoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_quote",  getFg_quoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否为引用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参照名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_name",  getRef_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参照名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参照编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRef_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ref_code",  getRef_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参照编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 激活方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getActivemethodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Activemethod",  getActivemethodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("激活方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否多选属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_many_selectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_many_select",  getIs_many_selectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否多选");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 纵向布局属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_vertical_layoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_vertical_layout",  getIs_vertical_layoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("纵向布局");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 格式字符串属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFormat_strADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Format_str",  getFormat_strCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("格式字符串");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 占位符个数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNu_placeholderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nu_placeholder",  getNu_placeholderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("占位符个数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 下划线属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_underlineADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_underline",  getFg_underlineCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("下划线");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b6","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_org",  getCode_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b6","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_grp",  getCode_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b5","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b5","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 元素类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mrdetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mrdetp",  getCode_mrdetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("元素类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_mrdetp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrdetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrdetp",  getName_mrdetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_mrdetp=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_de a0b3","id_de=id_de","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_de a0b3","id_de=id_de","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_dg a0b4","id_dg=id_dg","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_dg a0b4","id_dg=id_dg","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mraetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mraet",  getCode_mraetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_et a0b9","id_mraet=id_mraet","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mraetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mraet",  getName_mraetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_et a0b9","id_mraet=id_mraet","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mratermgrpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mratermgrp",  getCode_mratermgrpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_termgrp a0b10","id_mratermgrp=id_mratermgrp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mratermgrpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mratermgrp",  getName_mratermgrpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_termgrp a0b10","id_mratermgrp=id_mratermgrp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_out_styleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_out_style",  getCode_out_styleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","out_style=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_styleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_style",  getName_out_styleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","out_style=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_out_formatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_out_format",  getCode_out_formatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","out_format=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_out_formatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_out_format",  getName_out_formatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","out_format=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_create",  getCode_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","createdby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_create",  getName_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b8","createdby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_modifyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_modify",  getName_modifyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b7","modifiedby=id_user","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_modifyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_modify",  getCode_modifyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_user a0b7","modifiedby=id_user","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_de");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取元素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素编码"); 
		return column;
	}
	/**
	 * 获取元素名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素名称"); 
		return column;
	}
	/**
	 * 获取元素描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素描述"); 
		return column;
	}
	/**
	 * 获取元素类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mrdetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mrdetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素类型编码"); 
		return column;
	}
	/**
	 * 获取元素类型主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrdetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrdetp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素类型主键"); 
		return column;
	}
	/**
	 * 获取关键字表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKeywordsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Keywords");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关键字"); 
		return column;
	}
	/**
	 * 获取拼音码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPycodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pycode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拼音码"); 
		return column;
	}
	/**
	 * 获取五笔码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWbcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wbcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("五笔码"); 
		return column;
	}
	/**
	 * 获取助记码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMnecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mnecode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("助记码"); 
		return column;
	}
	/**
	 * 获取数据元ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_de");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据元ID"); 
		return column;
	}
	/**
	 * 获取数据组ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据组ID"); 
		return column;
	}
	/**
	 * 获取排序序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrder_indexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Order_index");
		column.setLength(10);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("排序序号"); 
		return column;
	}
	/**
	 * 获取事件id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mraetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mraet");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件id"); 
		return column;
	}
	/**
	 * 获取分组id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mratermgrpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mratermgrp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分组id"); 
		return column;
	}
	/**
	 * 获取提示文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_tipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_tip");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提示文本"); 
		return column;
	}
	/**
	 * 获取标签文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_labelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_label");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("标签文本"); 
		return column;
	}
	/**
	 * 获取背景文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_backgroundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_background");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("背景文本"); 
		return column;
	}
	/**
	 * 获取简单级联值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_cascadeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_cascade");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("简单级联值"); 
		return column;
	}
	/**
	 * 获取可见表达式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_visibleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_visible");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可见表达式"); 
		return column;
	}
	/**
	 * 获取是否可编辑表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_editCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_edit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否可编辑"); 
		return column;
	}
	/**
	 * 获取是否加密表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_encryptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_encrypt");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否加密"); 
		return column;
	}
	/**
	 * 获取是否可删除表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_deleteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_delete");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否可删除"); 
		return column;
	}
	/**
	 * 获取是否显示边框表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_borderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_border");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否显示边框"); 
		return column;
	}
	/**
	 * 获取是否可隐藏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hide");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否可隐藏"); 
		return column;
	}
	/**
	 * 获取最大长度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLg_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lg_max");
		column.setLength(10);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最大长度"); 
		return column;
	}
	/**
	 * 获取最小长度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLg_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Lg_min");
		column.setLength(10);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最小长度"); 
		return column;
	}
	/**
	 * 获取单位文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_unitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_unit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位文本"); 
		return column;
	}
	/**
	 * 获取小数位数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNu_digitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nu_digit");
		column.setLength(4);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("小数位数"); 
		return column;
	}
	/**
	 * 获取最大值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNu_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nu_max");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最大值"); 
		return column;
	}
	/**
	 * 获取最小值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNu_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nu_min");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最小值"); 
		return column;
	}
	/**
	 * 获取值域是否为sql表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_sqlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sql");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("值域是否为sql"); 
		return column;
	}
	/**
	 * 获取值域SQL语句表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getText_sqlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Text_sql");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值域SQL语句"); 
		return column;
	}
	/**
	 * 获取肯定前缀表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSu_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Su_des");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肯定前缀"); 
		return column;
	}
	/**
	 * 获取否定前缀表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNe_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ne_des");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("否定前缀"); 
		return column;
	}
	/**
	 * 获取时间格式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_formatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_format");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("时间格式"); 
		return column;
	}
	/**
	 * 获取输出类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_styleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_style");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输出类型"); 
		return column;
	}
	/**
	 * 获取输出格式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOut_formatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Out_format");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输出格式"); 
		return column;
	}
	/**
	 * 获取是否为源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_qsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_qs");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否为源"); 
		return column;
	}
	/**
	 * 获取源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sourceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_source");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("源名称"); 
		return column;
	}
	/**
	 * 获取属性名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_propertyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_property");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("属性名称"); 
		return column;
	}
	/**
	 * 获取是否为引用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_quoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_quote");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否为引用"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取参照名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参照名称"); 
		return column;
	}
	/**
	 * 获取参照编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRef_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ref_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参照编码"); 
		return column;
	}
	/**
	 * 获取激活方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getActivemethodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Activemethod");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("激活方式"); 
		return column;
	}
	/**
	 * 获取是否多选表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_many_selectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_many_select");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否多选"); 
		return column;
	}
	/**
	 * 获取纵向布局表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_vertical_layoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_vertical_layout");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("纵向布局"); 
		return column;
	}
	/**
	 * 获取格式字符串表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFormat_strCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Format_str");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("格式字符串"); 
		return column;
	}
	/**
	 * 获取占位符个数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNu_placeholderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nu_placeholder");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("占位符个数"); 
		return column;
	}
	/**
	 * 获取下划线表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_underlineCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_underline");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("下划线"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_grp");
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
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取元素类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mrdetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mrdetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("元素类型编码"); 
		return column;
	}
	/**
	 * 获取类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrdetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrdetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("类型名称"); 
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
	 * 获取事件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mraetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mraet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件编码"); 
		return column;
	}
	/**
	 * 获取事件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mraetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mraet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mratermgrpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mratermgrp");
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
	private IColumnDesc getName_mratermgrpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mratermgrp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_out_styleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_out_style");
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
	private IColumnDesc getName_out_styleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_style");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_out_formatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_out_format");
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
	private IColumnDesc getName_out_formatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_out_format");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_create");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_create");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_modifyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_modify");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户名称"); 
		return column;
	}
	/**
	 * 获取用户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_modifyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_modify");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用户编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_mrtplentity");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
		iBDDataInfoFldMap.put("id_group","Id_grp");
		iBDDataInfoFldMap.put("pycode","Pycode");
		iBDDataInfoFldMap.put("wbcode","Wbcode");
		iBDDataInfoFldMap.put("mnecode","Instr");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
