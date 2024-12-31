
package iih.bl.cg.blwardrefund.d.desc;

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
 * 退费单明细项目 DO 元数据信息
 */
public class BlRefundItemDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.cg.blwardrefund.d.BlRefundItemDO";
	public static final String CLASS_DISPALYNAME = "退费单明细项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_rfd_itm";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_rfditm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlRefundItemDODesc(){
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
		this.setKeyDesc(getId_rfditmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_rfditmADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_rfdapADesc(tblDesc));
		this.add(getId_rfdcancADesc(tblDesc));
		this.add(getId_rfdchkADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getEu_rfditmtpADesc(tblDesc));
		this.add(getQuanADesc(tblDesc));
		this.add(getId_cgipADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getSd_su_rdfitmADesc(tblDesc));
		this.add(getSd_rfdaptpADesc(tblDesc));
		this.add(getId_su_rdfitmADesc(tblDesc));
		this.add(getId_rfdaptpADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_rfditmCDesc(tblDesc));
		tblDesc.add(getId_rfditmCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_rfdapCDesc(tblDesc));
		tblDesc.add(getId_rfdcancCDesc(tblDesc));
		tblDesc.add(getId_rfdchkCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getEu_rfditmtpCDesc(tblDesc));
		tblDesc.add(getQuanCDesc(tblDesc));
		tblDesc.add(getId_cgipCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getSd_su_rdfitmCDesc(tblDesc));
		tblDesc.add(getSd_rfdaptpCDesc(tblDesc));
		tblDesc.add(getId_su_rdfitmCDesc(tblDesc));
		tblDesc.add(getId_rfdaptpCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 退费明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rfditmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rfditm",  getId_rfditmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 退费申请单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rfdapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rfdap",  getId_rfdapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费申请单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 撤消操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rfdcancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rfdcanc",  getId_rfdcancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("撤消操作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费确认单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rfdchkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rfdchk",  getId_rfdchkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费确认单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费项目号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("退费项目号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费项目类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_rfditmtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_rfditmtp",  getEu_rfditmtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("退费项目类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan",  getQuanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("退费数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费记账明细属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cgipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cgip",  getId_cgipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费记账明细");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 项目描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("项目描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 退费单项目状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_rdfitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_rdfitm",  getSd_su_rdfitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费单项目状态编码");
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
	 * 退费单项目状态ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_rdfitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_rdfitm",  getId_su_rdfitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退费单项目状态ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 活动标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("活动标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取退费明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rfditmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rfditm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("退费明细主键"); 
		return column;
	}
	/**
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
		return column;
	}
	/**
	 * 获取就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊"); 
		return column;
	}
	/**
	 * 获取退费申请单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rfdapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rfdap");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费申请单"); 
		return column;
	}
	/**
	 * 获取撤消操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rfdcancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rfdcanc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("撤消操作"); 
		return column;
	}
	/**
	 * 获取退费确认单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rfdchkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rfdchk");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费确认单"); 
		return column;
	}
	/**
	 * 获取退费项目号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("退费项目号"); 
		return column;
	}
	/**
	 * 获取退费项目类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_rfditmtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_rfditmtp");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("退费项目类型"); 
		return column;
	}
	/**
	 * 获取退费数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("退费数量"); 
		return column;
	}
	/**
	 * 获取退费记账明细表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cgipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cgip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费记账明细"); 
		return column;
	}
	/**
	 * 获取退费医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费医嘱"); 
		return column;
	}
	/**
	 * 获取项目描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("项目描述"); 
		return column;
	}
	/**
	 * 获取退费单项目状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_rdfitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_rdfitm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费单项目状态编码"); 
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
	 * 获取退费单项目状态ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_rdfitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_rdfitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退费单项目状态ID"); 
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
	 * 获取活动标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("活动标志"); 
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
