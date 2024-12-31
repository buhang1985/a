
package iih.ci.mrqc.cimrrecallrecord.d.desc;

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
 * 病历召回记录 DO 元数据信息
 */
public class CiMrRecallRecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mrqc.cimrrecallrecord.d.CiMrRecallRecordDO";
	public static final String CLASS_DISPALYNAME = "病历召回记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_mr_rcre";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mr_rcre";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiMrRecallRecordDODesc(){
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
		this.setKeyDesc(getId_mr_rcreADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mr_rcreADesc(tblDesc));
		this.add(getId_mr_recallADesc(tblDesc));
		this.add(getId_mrADesc(tblDesc));
		this.add(getName_mrADesc(tblDesc));
		this.add(getFg_upADesc(tblDesc));
		this.add(getFg_deADesc(tblDesc));
		this.add(getFg_opADesc(tblDesc));
		this.add(getDt_submitADesc(tblDesc));
		this.add(getName_docADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mr_rcreCDesc(tblDesc));
		tblDesc.add(getId_mr_rcreCDesc(tblDesc));
		tblDesc.add(getId_mr_recallCDesc(tblDesc));
		tblDesc.add(getId_mrCDesc(tblDesc));
		tblDesc.add(getName_mrCDesc(tblDesc));
		tblDesc.add(getFg_upCDesc(tblDesc));
		tblDesc.add(getFg_deCDesc(tblDesc));
		tblDesc.add(getFg_opCDesc(tblDesc));
		tblDesc.add(getDt_submitCDesc(tblDesc));
		tblDesc.add(getName_docCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_rcreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_rcre",  getId_mr_rcreCDesc(tblDesc), this);
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
	 * 病历召回主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_recallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_recall",  getId_mr_recallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历召回主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr",  getId_mrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mr",  getName_mrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否修改属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_upADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_up",  getFg_upCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否修改");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否删除属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_deADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_de",  getFg_deCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否删除");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否已经操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_op",  getFg_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否已经操作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_submitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_submit",  getDt_submitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("业务时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_doc",  getName_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_rcreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_rcre");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主键"); 
		return column;
	}
	/**
	 * 获取病历召回主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_recallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_recall");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历召回主键"); 
		return column;
	}
	/**
	 * 获取医疗记录主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录主键"); 
		return column;
	}
	/**
	 * 获取医疗记录名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录名称"); 
		return column;
	}
	/**
	 * 获取是否修改表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_upCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_up");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否修改"); 
		return column;
	}
	/**
	 * 获取是否删除表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_deCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_de");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否删除"); 
		return column;
	}
	/**
	 * 获取是否已经操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_op");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否已经操作"); 
		return column;
	}
	/**
	 * 获取业务时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_submitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_submit");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("业务时间"); 
		return column;
	}
	/**
	 * 获取医生名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_doc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生名称"); 
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
