
package iih.bd.srv.qcmraddrule.d.desc;

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
 * 病历新建规则前提 DO 元数据信息
 */
public class QcmraddpreruleDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO";
	public static final String CLASS_DISPALYNAME = "病历新建规则前提";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_qc_add_prerule";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_prerule";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public QcmraddpreruleDODesc(){
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
		this.setKeyDesc(getId_preruleADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_ruleADesc(tblDesc));
		this.add(getId_preruleADesc(tblDesc));
		this.add(getId_ruleADesc(tblDesc));
		this.add(getId_mrcactmADesc(tblDesc));
		this.add(getId_mrtpADesc(tblDesc));
		this.add(getFg_must_existADesc(tblDesc));
		this.add(getTip_textADesc(tblDesc));
		this.add(getRemarkADesc(tblDesc));
		this.add(getCode_mrcactmADesc(tblDesc));
		this.add(getName_mrcactmADesc(tblDesc));
		this.add(getCode_mrtpADesc(tblDesc));
		this.add(getName_mrtpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_preruleCDesc(tblDesc));
		tblDesc.add(getId_preruleCDesc(tblDesc));
		tblDesc.add(getId_ruleCDesc(tblDesc));
		tblDesc.add(getId_mrcactmCDesc(tblDesc));
		tblDesc.add(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getFg_must_existCDesc(tblDesc));
		tblDesc.add(getTip_textCDesc(tblDesc));
		tblDesc.add(getRemarkCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 前提条件id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_prerule",  getId_preruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("前提条件id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 规则id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rule",  getId_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("规则id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 自定义类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrcactmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrcactm",  getId_mrcactmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自定义类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 模板类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp",  getId_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("模板类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否必须存在属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_must_existADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_must_exist",  getFg_must_existCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否必须存在");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提示内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTip_textADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tip_text",  getTip_textCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提示内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mrcactmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mrcactm",  getCode_mrcactmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrca_ctm a1b3","id_mrcactm=id_mrcactm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrcactmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrcactm",  getName_mrcactmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrca_ctm a1b3","id_mrcactm=id_mrcactm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mrtp",  getCode_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a1b4","id_mrtp=id_mrtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mrtp",  getName_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a1b4","id_mrtp=id_mrtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取前提条件id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_prerule");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("前提条件id"); 
		return column;
	}
	/**
	 * 获取规则id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rule");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("规则id"); 
		return column;
	}
	/**
	 * 获取自定义类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrcactmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrcactm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自定义类别"); 
		return column;
	}
	/**
	 * 获取模板类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("模板类别"); 
		return column;
	}
	/**
	 * 获取是否必须存在表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_must_existCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_must_exist");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否必须存在"); 
		return column;
	}
	/**
	 * 获取提示内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTip_textCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tip_text");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提示内容"); 
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
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mrcactmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mrcactm");
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
	private IColumnDesc getName_mrcactmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrcactm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取医疗记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mrtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mrtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型名称"); 
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
