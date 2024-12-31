
package iih.bl.cc.ebs.dg.desc;

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
 * IIH(EBS)对接中间表   DO 元数据信息
 */
public class MpIFaceMidDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.mpifacemid.d.MpIFaceMidDO";
	public static final String CLASS_DISPALYNAME = "IIH(EBS)对接中间表  ";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "IIH_INV_EBS_MEDIC_IFACE";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Iface_id";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MpIFaceMidDODesc(){
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
		this.setKeyDesc(getIface_idADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getIface_idADesc(tblDesc));
		this.add(getIface_batch_idADesc(tblDesc));
		this.add(getLine_numADesc(tblDesc));
		this.add(getHospital_codeADesc(tblDesc));
		this.add(getOp_ip_flagADesc(tblDesc));
		this.add(getCharge_dateADesc(tblDesc));
		this.add(getItem_numberADesc(tblDesc));
		this.add(getItem_descADesc(tblDesc));
		this.add(getCharge_dept_nameADesc(tblDesc));
		this.add(getCharge_deptADesc(tblDesc));
		this.add(getExecute_dept_nameADesc(tblDesc));
		this.add(getWard_snADesc(tblDesc));
		this.add(getWard_sn_nameADesc(tblDesc));
		this.add(getGroup_noADesc(tblDesc));
		this.add(getGroup_nameADesc(tblDesc));
		this.add(getDeliver_qtyADesc(tblDesc));
		this.add(getDeliver_uom_codeADesc(tblDesc));
		this.add(getRetail_priceADesc(tblDesc));
		this.add(getSync_dateADesc(tblDesc));
		this.add(getProcess_flagADesc(tblDesc));
		this.add(getProcess_dateADesc(tblDesc));
		this.add(getWindow_noADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getIface_idCDesc(tblDesc));
		tblDesc.add(getIface_idCDesc(tblDesc));
		tblDesc.add(getIface_batch_idCDesc(tblDesc));
		tblDesc.add(getLine_numCDesc(tblDesc));
		tblDesc.add(getHospital_codeCDesc(tblDesc));
		tblDesc.add(getOp_ip_flagCDesc(tblDesc));
		tblDesc.add(getCharge_dateCDesc(tblDesc));
		tblDesc.add(getItem_numberCDesc(tblDesc));
		tblDesc.add(getItem_descCDesc(tblDesc));
		tblDesc.add(getCharge_dept_nameCDesc(tblDesc));
		tblDesc.add(getCharge_deptCDesc(tblDesc));
		tblDesc.add(getExecute_dept_nameCDesc(tblDesc));
		tblDesc.add(getWard_snCDesc(tblDesc));
		tblDesc.add(getWard_sn_nameCDesc(tblDesc));
		tblDesc.add(getGroup_noCDesc(tblDesc));
		tblDesc.add(getGroup_nameCDesc(tblDesc));
		tblDesc.add(getDeliver_qtyCDesc(tblDesc));
		tblDesc.add(getDeliver_uom_codeCDesc(tblDesc));
		tblDesc.add(getRetail_priceCDesc(tblDesc));
		tblDesc.add(getSync_dateCDesc(tblDesc));
		tblDesc.add(getProcess_flagCDesc(tblDesc));
		tblDesc.add(getProcess_dateCDesc(tblDesc));
		tblDesc.add(getWindow_noCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 中间表主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIface_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Iface_id",  getIface_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中间表主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 子自增列属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIface_batch_idADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Iface_batch_id",  getIface_batch_idCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("子自增列");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLine_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Line_num",  getLine_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_code",  getHospital_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊住院标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOp_ip_flagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Op_ip_flag",  getOp_ip_flagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊住院标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计费日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_date",  getCharge_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计费日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 费用编码(药品编码)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItem_numberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Item_number",  getItem_numberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("费用编码(药品编码)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getItem_descADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Item_desc",  getItem_descCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开单科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_dept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_dept_name",  getCharge_dept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开单科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开单科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCharge_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Charge_dept",  getCharge_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开单科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 执行科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExecute_dept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Execute_dept_name",  getExecute_dept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("执行科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWard_snADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ward_sn",  getWard_snCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWard_sn_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ward_sn_name",  getWard_sn_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药房编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGroup_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Group_no",  getGroup_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药房编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药房名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGroup_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Group_name",  getGroup_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药房名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeliver_qtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deliver_qty",  getDeliver_qtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeliver_uom_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deliver_uom_code",  getDeliver_uom_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 单价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRetail_priceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Retail_price",  getRetail_priceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("单价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上传日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSync_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sync_date",  getSync_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("上传日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProcess_flagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Process_flag",  getProcess_flagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("接收标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 接收日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProcess_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Process_date",  getProcess_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("接收日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 窗口号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWindow_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Window_no",  getWindow_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("窗口号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取中间表主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIface_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Iface_id");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("中间表主键"); 
		return column;
	}
	/**
	 * 获取子自增列表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIface_batch_idCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Iface_batch_id");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("子自增列"); 
		return column;
	}
	/**
	 * 获取行号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLine_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Line_num");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行号"); 
		return column;
	}
	/**
	 * 获取医院编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院编码"); 
		return column;
	}
	/**
	 * 获取门诊住院标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOp_ip_flagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Op_ip_flag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊住院标志"); 
		return column;
	}
	/**
	 * 获取计费日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计费日期"); 
		return column;
	}
	/**
	 * 获取费用编码(药品编码)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItem_numberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Item_number");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("费用编码(药品编码)"); 
		return column;
	}
	/**
	 * 获取药品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getItem_descCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Item_desc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品名称"); 
		return column;
	}
	/**
	 * 获取开单科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_dept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_dept_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开单科室名称"); 
		return column;
	}
	/**
	 * 获取开单科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCharge_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Charge_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开单科室编码"); 
		return column;
	}
	/**
	 * 获取执行科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExecute_dept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Execute_dept_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("执行科室编码"); 
		return column;
	}
	/**
	 * 获取病区编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWard_snCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ward_sn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区编码"); 
		return column;
	}
	/**
	 * 获取病区名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWard_sn_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ward_sn_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区名称"); 
		return column;
	}
	/**
	 * 获取药房编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGroup_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Group_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药房编码"); 
		return column;
	}
	/**
	 * 获取药房名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGroup_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Group_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药房名称"); 
		return column;
	}
	/**
	 * 获取数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeliver_qtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deliver_qty");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量"); 
		return column;
	}
	/**
	 * 获取单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeliver_uom_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deliver_uom_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("单位"); 
		return column;
	}
	/**
	 * 获取单价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRetail_priceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Retail_price");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("单价"); 
		return column;
	}
	/**
	 * 获取上传日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSync_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sync_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上传日期"); 
		return column;
	}
	/**
	 * 获取接收标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProcess_flagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Process_flag");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("接收标志"); 
		return column;
	}
	/**
	 * 获取接收日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProcess_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Process_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("接收日期"); 
		return column;
	}
	/**
	 * 获取窗口号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWindow_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Window_no");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("窗口号"); 
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
