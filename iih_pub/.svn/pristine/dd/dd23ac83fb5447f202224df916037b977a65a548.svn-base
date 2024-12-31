
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
 * 住院药品请领 DO 元数据信息
 */
public class IpDgApDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.dg.ipdgapp.d.IpDgApDO";
	public static final String CLASS_DISPALYNAME = "住院药品请领";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_dg_ip_ap";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dgipap";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public IpDgApDODesc(){
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
		this.setKeyDesc(getId_dgipapADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_dgipapADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_dep_apADesc(tblDesc));
		this.add(getId_dgtpADesc(tblDesc));
		this.add(getSd_dgtpADesc(tblDesc));
		this.add(getDispenseADesc(tblDesc));
		this.add(getDisp_timeADesc(tblDesc));
		this.add(getId_aptypeADesc(tblDesc));
		this.add(getSd_aptypeADesc(tblDesc));
		this.add(getId_dep_whADesc(tblDesc));
		this.add(getCode_dgipapADesc(tblDesc));
		this.add(getBk_reasonADesc(tblDesc));
		this.add(getId_dgapADesc(tblDesc));
		this.add(getSd_dgapADesc(tblDesc));
		this.add(getId_dgpresstADesc(tblDesc));
		this.add(getEn_checkADesc(tblDesc));
		this.add(getId_emp_checkADesc(tblDesc));
		this.add(getDt_checkADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_shetpADesc(tblDesc));
		this.add(getEu_shetpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dgipapCDesc(tblDesc));
		tblDesc.add(getId_dgipapCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_dep_apCDesc(tblDesc));
		tblDesc.add(getId_dgtpCDesc(tblDesc));
		tblDesc.add(getSd_dgtpCDesc(tblDesc));
		tblDesc.add(getDispenseCDesc(tblDesc));
		tblDesc.add(getDisp_timeCDesc(tblDesc));
		tblDesc.add(getId_aptypeCDesc(tblDesc));
		tblDesc.add(getSd_aptypeCDesc(tblDesc));
		tblDesc.add(getId_dep_whCDesc(tblDesc));
		tblDesc.add(getCode_dgipapCDesc(tblDesc));
		tblDesc.add(getBk_reasonCDesc(tblDesc));
		tblDesc.add(getId_dgapCDesc(tblDesc));
		tblDesc.add(getSd_dgapCDesc(tblDesc));
		tblDesc.add(getId_dgpresstCDesc(tblDesc));
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
	 * 住院药品请领主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgipapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgipap",  getId_dgipapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院药品请领主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 请领部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_ap",  getId_dep_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgtp",  getId_dgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dgtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dgtp",  getSd_dgtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDispenseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dispense",  getDispenseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisp_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disp_time",  getDisp_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请领日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领单类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptype",  getId_aptypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领单类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领单类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_aptypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_aptype",  getSd_aptypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领单类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 库房属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_whADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_wh",  getId_dep_whCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("库房");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 退药原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBk_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bk_reason",  getBk_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("退药原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请领状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgap",  getId_dgapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请领状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请领状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dgapADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dgap",  getSd_dgapCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("请领状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处方执行状态主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dgpresstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dgpresst",  getId_dgpresstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处方执行状态主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 药单名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_shetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_shetp",  getName_shetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药单名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_dg_shetp a0b9","id_aptype=id_dgshetp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药单类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_shetpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shetp",  getEu_shetpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("药单类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_dg_shetp a0b9","id_aptype=id_dgshetp","eu_shetp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取住院药品请领主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgipapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgipap");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院药品请领主键标识"); 
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
	 * 获取请领部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领部门"); 
		return column;
	}
	/**
	 * 获取请领类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领类型"); 
		return column;
	}
	/**
	 * 获取请领类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dgtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dgtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领类型编码"); 
		return column;
	}
	/**
	 * 获取请领人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDispenseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dispense");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领人"); 
		return column;
	}
	/**
	 * 获取请领日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisp_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disp_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请领日期时间"); 
		return column;
	}
	/**
	 * 获取请领单类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptype");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领单类型"); 
		return column;
	}
	/**
	 * 获取请领单类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_aptypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_aptype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领单类型编码"); 
		return column;
	}
	/**
	 * 获取库房表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_whCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_wh");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("库房"); 
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
	 * 获取退药原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBk_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bk_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("退药原因"); 
		return column;
	}
	/**
	 * 获取请领状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请领状态"); 
		return column;
	}
	/**
	 * 获取请领状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dgapCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dgap");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("请领状态编码"); 
		return column;
	}
	/**
	 * 获取处方执行状态主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dgpresstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dgpresst");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处方执行状态主键"); 
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
	 * 获取药单名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_shetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_shetp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药单名称"); 
		return column;
	}
	/**
	 * 获取药单类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_shetpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shetp");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("药单类型"); 
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
	
}
