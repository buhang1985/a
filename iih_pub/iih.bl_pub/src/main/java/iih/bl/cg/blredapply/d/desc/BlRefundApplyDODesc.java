
package iih.bl.cg.blredapply.d.desc;

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
 * 退费申请单 DO 元数据信息
 */
public class BlRefundApplyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.cg.blredapply.d.BlRefundApplyDO";
	public static final String CLASS_DISPALYNAME = "退费申请单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_rfd_ap";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_rfdap";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlRefundApplyDODesc(){
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
		this.setKeyDesc(getId_rfdapADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_rfdapADesc(tblDesc));
		this.add(getCode_rfdapADesc(tblDesc));
		this.add(getId_dep_apADesc(tblDesc));
		this.add(getId_emp_apADesc(tblDesc));
		this.add(getDt_apADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getFg_cancADesc(tblDesc));
		this.add(getId_rfdaptpADesc(tblDesc));
		this.add(getSd_rfdaptpADesc(tblDesc));
		this.add(getFg_auditADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_rfdapCDesc(tblDesc));
		tblDesc.add(getId_rfdapCDesc(tblDesc));
		tblDesc.add(getCode_rfdapCDesc(tblDesc));
		tblDesc.add(getId_dep_apCDesc(tblDesc));
		tblDesc.add(getId_emp_apCDesc(tblDesc));
		tblDesc.add(getDt_apCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getFg_cancCDesc(tblDesc));
		tblDesc.add(getId_rfdaptpCDesc(tblDesc));
		tblDesc.add(getSd_rfdaptpCDesc(tblDesc));
		tblDesc.add(getFg_auditCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 退费申请主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rfdapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rfdap",  getId_rfdapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费申请主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_rfdapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_rfdap",  getCode_rfdapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费申请部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_ap",  getId_dep_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费申请部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 退费申请人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_ap",  getId_emp_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费申请人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 退费申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ap",  getDt_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("退费申请时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费理由属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费理由");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 撤消标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_canc",  getFg_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("撤消标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费单类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rfdaptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rfdaptp",  getId_rfdaptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费单类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费单类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rfdaptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rfdaptp",  getSd_rfdaptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费单类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否审核属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_audit",  getFg_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否审核");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取退费申请主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rfdapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rfdap");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退费申请主键"); 
		return column;
	}
	/**
	 * 获取退费申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_rfdapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_rfdap");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费申请单号"); 
		return column;
	}
	/**
	 * 获取退费申请部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费申请部门"); 
		return column;
	}
	/**
	 * 获取退费申请人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费申请人"); 
		return column;
	}
	/**
	 * 获取退费申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ap");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退费申请时间"); 
		return column;
	}
	/**
	 * 获取退费理由表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费理由"); 
		return column;
	}
	/**
	 * 获取撤消标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_canc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("撤消标志"); 
		return column;
	}
	/**
	 * 获取退费单类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rfdaptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rfdaptp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费单类型ID"); 
		return column;
	}
	/**
	 * 获取退费单类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rfdaptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rfdaptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费单类型编码"); 
		return column;
	}
	/**
	 * 获取是否审核表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_audit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否审核"); 
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
