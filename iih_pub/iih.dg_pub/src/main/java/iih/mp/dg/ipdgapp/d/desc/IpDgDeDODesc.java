
package iih.mp.dg.ipdgapp.d.desc;

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
 * 住院药品发放 DO 元数据信息
 */
public class IpDgDeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.ipdgapp.d.IpDgDeDO";
	public static final String CLASS_DISPALYNAME = "住院药品发放";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_ip_de";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgipde";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public IpDgDeDODesc(){
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
		this.setKeyDesc(getId_dgipdeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_dgipdeADesc(tblDesc));
		this.add(getId_dgipapADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getCode_dgipdeADesc(tblDesc));
		this.add(getCode_dgipapADesc(tblDesc));
		this.add(getId_outADesc(tblDesc));
		this.add(getMm_out_codeADesc(tblDesc));
		this.add(getDt_mm_out_confADesc(tblDesc));
		this.add(getId_dep_apADesc(tblDesc));
		this.add(getId_dgtpADesc(tblDesc));
		this.add(getSd_dgtpADesc(tblDesc));
		this.add(getId_emp_dpADesc(tblDesc));
		this.add(getDt_dpADesc(tblDesc));
		this.add(getEn_checkADesc(tblDesc));
		this.add(getId_emp_checkADesc(tblDesc));
		this.add(getDt_checkADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgipdeCDesc(tblDesc));
		tblDesc.add(getId_dgipdeCDesc(tblDesc));
		tblDesc.add(getId_dgipapCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getCode_dgipdeCDesc(tblDesc));
		tblDesc.add(getCode_dgipapCDesc(tblDesc));
		tblDesc.add(getId_outCDesc(tblDesc));
		tblDesc.add(getMm_out_codeCDesc(tblDesc));
		tblDesc.add(getDt_mm_out_confCDesc(tblDesc));
		tblDesc.add(getId_dep_apCDesc(tblDesc));
		tblDesc.add(getId_dgtpCDesc(tblDesc));
		tblDesc.add(getSd_dgtpCDesc(tblDesc));
		tblDesc.add(getId_emp_dpCDesc(tblDesc));
		tblDesc.add(getDt_dpCDesc(tblDesc));
		tblDesc.add(getEn_checkCDesc(tblDesc));
		tblDesc.add(getId_emp_checkCDesc(tblDesc));
		tblDesc.add(getDt_checkCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 住院药品发放主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgipdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgipde",  getId_dgipdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院药品发放主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院药品请领主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgipapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgipap",  getId_dgipapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院药品请领主键");
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
	 * 摆药单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dgipdeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dgipde",  getCode_dgipdeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摆药单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dgipapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dgipap",  getCode_dgipapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出入库单据主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_out",  getId_outCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出入库单据主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_out_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_out_code",  getMm_out_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出库单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出库时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_mm_out_confADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_mm_out_conf",  getDt_mm_out_confCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出库时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发放部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_ap",  getId_dep_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发放部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发放类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgtp",  getId_dgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发放类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发放类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dgtp",  getSd_dgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发放类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发药人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_dpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_dp",  getId_emp_dpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发药人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发放日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_dpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_dp",  getDt_dpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("发放日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEn_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("En_check",  getEn_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("审核状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_check",  getId_emp_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_checkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_check",  getDt_checkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核时间");
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
	 * 获取住院药品发放主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgipdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgipde");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院药品发放主键"); 
		return column;
	}
	/**
	 * 获取住院药品请领主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgipapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgipap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院药品请领主键"); 
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
	 * 获取摆药单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dgipdeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dgipde");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摆药单号"); 
		return column;
	}
	/**
	 * 获取请领单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dgipapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dgipap");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领单号"); 
		return column;
	}
	/**
	 * 获取出入库单据主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_out");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出入库单据主键"); 
		return column;
	}
	/**
	 * 获取出库单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_out_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_out_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出库单号"); 
		return column;
	}
	/**
	 * 获取出库时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_mm_out_confCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_mm_out_conf");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出库时间"); 
		return column;
	}
	/**
	 * 获取发放部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发放部门"); 
		return column;
	}
	/**
	 * 获取发放类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发放类型"); 
		return column;
	}
	/**
	 * 获取发放类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dgtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发放类型编码"); 
		return column;
	}
	/**
	 * 获取发药人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_dpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_dp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发药人"); 
		return column;
	}
	/**
	 * 获取发放日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_dpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_dp");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发放日期时间"); 
		return column;
	}
	/**
	 * 获取审核状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEn_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"En_check");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("审核状态"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_check");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_checkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_check");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
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
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
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
