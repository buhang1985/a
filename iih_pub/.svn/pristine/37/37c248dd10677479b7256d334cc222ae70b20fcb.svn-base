
package iih.nm.nhr.nmnhrschedrp.d.desc;

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
 * 替班申请明细 DO 元数据信息
 */
public class NhrSchedRpItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpItmDO";
	public static final String CLASS_DISPALYNAME = "替班申请明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nm_sched_rp_itm";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_nhr_sched_rp_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NhrSchedRpItmDODesc(){
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
		this.setKeyDesc(getId_nhr_sched_rp_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_nhr_sched_rpADesc(tblDesc));
		this.add(getId_nhr_sched_rp_itmADesc(tblDesc));
		this.add(getId_nhr_sched_rpADesc(tblDesc));
		this.add(getId_nhr_si_apy_oldADesc(tblDesc));
		this.add(getId_nhr_si_apy_newADesc(tblDesc));
		this.add(getId_nhr_si_rp_oldADesc(tblDesc));
		this.add(getId_nhr_si_rp_newADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getApy_old_nameADesc(tblDesc));
		this.add(getApy_new_nameADesc(tblDesc));
		this.add(getRp_old_nameADesc(tblDesc));
		this.add(getRp_new_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nhr_sched_rp_itmCDesc(tblDesc));
		tblDesc.add(getId_nhr_sched_rp_itmCDesc(tblDesc));
		tblDesc.add(getId_nhr_sched_rpCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_apy_oldCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_apy_newCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_rp_oldCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_rp_newCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 替班申请明细主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_sched_rp_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_sched_rp_itm",  getId_nhr_sched_rp_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班申请明细主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 替班申请主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_sched_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_sched_rp",  getId_nhr_sched_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班申请主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请人原班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_apy_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_apy_old",  getId_nhr_si_apy_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人原班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请人新班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_apy_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_apy_new",  getId_nhr_si_apy_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人新班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班人原班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_rp_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_rp_old",  getId_nhr_si_rp_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人原班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班人新班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_rp_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_rp_new",  getId_nhr_si_rp_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人新班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 申请人原班名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApy_old_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apy_old_name",  getApy_old_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人原班名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a1b3","id_nhr_si_apy_old=id_nhr_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请人新班名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApy_new_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apy_new_name",  getApy_new_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人新班名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a1b4","id_nhr_si_apy_new=id_nhr_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 替班人原班次名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRp_old_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rp_old_name",  getRp_old_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人原班次名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a1b5","id_nhr_si_rp_old=id_nhr_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 替班人新班次名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRp_new_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rp_new_name",  getRp_new_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人新班次名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a1b6","id_nhr_si_rp_new=id_nhr_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取替班申请明细主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_sched_rp_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_sched_rp_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("替班申请明细主键"); 
		return column;
	}
	/**
	 * 获取替班申请主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_sched_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_sched_rp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班申请主键"); 
		return column;
	}
	/**
	 * 获取申请人原班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_apy_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_apy_old");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人原班次"); 
		return column;
	}
	/**
	 * 获取申请人新班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_apy_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_apy_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人新班次"); 
		return column;
	}
	/**
	 * 获取替班人原班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_rp_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_rp_old");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人原班次"); 
		return column;
	}
	/**
	 * 获取替班人新班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_rp_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_rp_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人新班次"); 
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
	 * 获取申请人原班名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApy_old_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apy_old_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人原班名称"); 
		return column;
	}
	/**
	 * 获取申请人新班名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApy_new_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apy_new_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人新班名称"); 
		return column;
	}
	/**
	 * 获取替班人原班次名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRp_old_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rp_old_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人原班次名称"); 
		return column;
	}
	/**
	 * 获取替班人新班次名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRp_new_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rp_new_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人新班次名称"); 
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
