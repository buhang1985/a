
package iih.bd.pp.patcadup.d.desc;

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
 * 患者分类重复收费项目 DO 元数据信息
 */
public class BdPatcaDupItmPriDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.pp.patcadup.d.BdPatcaDupItmPriDO";
	public static final String CLASS_DISPALYNAME = "患者分类重复收费项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_patca_dup_itm_pri";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_patcadupitmri";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdPatcaDupItmPriDODesc(){
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
		this.setKeyDesc(getId_patcadupitmriADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_patcadupitmriADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patcaADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
		this.add(getFg_entp_opADesc(tblDesc));
		this.add(getFg_entp_ipADesc(tblDesc));
		this.add(getFg_entp_erADesc(tblDesc));
		this.add(getFg_entp_peADesc(tblDesc));
		this.add(getFg_entp_fmADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_use_pipADesc(tblDesc));
		this.add(getFg_use_er1ADesc(tblDesc));
		this.add(getFg_use_er2ADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patcadupitmriCDesc(tblDesc));
		tblDesc.add(getId_patcadupitmriCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patcaCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		tblDesc.add(getFg_entp_opCDesc(tblDesc));
		tblDesc.add(getFg_entp_ipCDesc(tblDesc));
		tblDesc.add(getFg_entp_peCDesc(tblDesc));
		tblDesc.add(getFg_entp_fmCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_use_pipCDesc(tblDesc));
		tblDesc.add(getFg_entp_erCDesc(tblDesc));
		tblDesc.add(getFg_use_er1CDesc(tblDesc));
		tblDesc.add(getFg_use_er2CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 处理重复收费项目主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcadupitmriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcadupitmri",  getId_patcadupitmriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理重复收费项目主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patca",  getId_patcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("BDMODE,URC");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开始日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_b",  getDt_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开始日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e",  getDt_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结束日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适用范围_门诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_op",  getFg_entp_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("适用范围_门诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适用范围_住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_ip",  getFg_entp_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("适用范围_住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	
	/**
	 * 适用范围_体检属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_pe",  getFg_entp_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("适用范围_体检");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 适用范围_家庭属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_fmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_fm",  getFg_entp_fmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("适用范围_家庭");
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
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
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
	 * 可使用标识_预住院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_pipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_pip",  getFg_use_pipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标识_预住院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	
	/**
	 * 可使用标识_急诊流水属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_entp_erADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_entp_er",  getFg_entp_erCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标识_急诊流水");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标识_急诊抢救属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_er1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_er1",  getFg_use_er1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标识_急诊抢救");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可使用标识_急诊留观属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_use_er2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_use_er2",  getFg_use_er2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("可使用标识_急诊留观");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_srv",  getName_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b5","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取处理重复收费项目主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcadupitmriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcadupitmri");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("处理重复收费项目主键"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取患者分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者分类"); 
		return column;
	}
	/**
	 * 获取服务id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务id"); 
		return column;
	}
	/**
	 * 获取开始日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始日期时间"); 
		return column;
	}
	/**
	 * 获取结束日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束日期时间"); 
		return column;
	}
	/**
	 * 获取适用范围_门诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_op");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("适用范围_门诊"); 
		return column;
	}
	/**
	 * 获取适用范围_住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_ip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("适用范围_住院"); 
		return column;
	}
	
	/**
	 * 获取适用范围_体检表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_pe");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("适用范围_体检"); 
		return column;
	}
	/**
	 * 获取适用范围_家庭表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_fmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_fm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("适用范围_家庭"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	 * 获取可使用标识_预住院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_pipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_pip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标识_预住院"); 
		return column;
	}
	/**
	 * 获取可使用标识_急诊流水表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_entp_erCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_entp_er");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("适用范围_急诊"); 
		return column;
	}
	/**
	 * 获取可使用标识_急诊抢救表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_er1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_er1");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标识_急诊抢救"); 
		return column;
	}
	/**
	 * 获取可使用标识_急诊留观表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_use_er2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_use_er2");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("可使用标识_急诊留观"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
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
		defaultValueMap.put("Fg_use_pip",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_use_er1",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_use_er2",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
