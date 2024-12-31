
package iih.cssd.dpp.dfpcln.d.desc;

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
 * 包清洗 DO 元数据信息
 */
public class CssdDfpClnDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.cssd.dpp.dfpcln.d.CssdDfpClnDO";
	public static final String CLASS_DISPALYNAME = "包清洗";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CSSD_DFP_CLN";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_dfp_cln";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CssdDfpClnDODesc(){
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
		this.setKeyDesc(getId_dfp_clnADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_dfp_clnADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_pkgcleanADesc(tblDesc));
		this.add(getSd_pkgcleanADesc(tblDesc));
		this.add(getId_dfp_instrADesc(tblDesc));
		this.add(getId_dfp_relADesc(tblDesc));
		this.add(getBatchADesc(tblDesc));
		this.add(getRec_no_barADesc(tblDesc));
		this.add(getSd_clnproADesc(tblDesc));
		this.add(getId_clnproADesc(tblDesc));
		this.add(getDt_clnADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getId_depADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_pkgcleanADesc(tblDesc));
		this.add(getName_dfp_instrADesc(tblDesc));
		this.add(getName_clnproADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
		this.add(getName_depADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_dfp_clnCDesc(tblDesc));
		tblDesc.add(getId_dfp_clnCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_pkgcleanCDesc(tblDesc));
		tblDesc.add(getSd_pkgcleanCDesc(tblDesc));
		tblDesc.add(getId_dfp_instrCDesc(tblDesc));
		tblDesc.add(getId_dfp_relCDesc(tblDesc));
		tblDesc.add(getBatchCDesc(tblDesc));
		tblDesc.add(getRec_no_barCDesc(tblDesc));
		tblDesc.add(getSd_clnproCDesc(tblDesc));
		tblDesc.add(getId_clnproCDesc(tblDesc));
		tblDesc.add(getDt_clnCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getId_depCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 消毒包清洗主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dfp_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dfp_cln",  getId_dfp_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消毒包清洗主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 清洗类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pkgcleanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pkgclean",  getId_pkgcleanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pkgcleanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pkgclean",  getSd_pkgcleanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗机属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dfp_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dfp_instr",  getId_dfp_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗机");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗机关系ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dfp_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dfp_rel",  getId_dfp_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗机关系ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗批次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBatchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Batch",  getBatchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗批次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 扫码条码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRec_no_barADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rec_no_bar",  getRec_no_barCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("扫码条码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗程序SD属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_clnproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_clnpro",  getSd_clnproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗程序SD");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗程序ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_clnproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_clnpro",  getId_clnproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗程序ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_clnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cln",  getDt_clnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("清洗时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清洗科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep",  getId_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗科室");
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
	 * 清洗类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pkgcleanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pkgclean",  getName_pkgcleanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_pkgclean=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗机属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dfp_instrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dfp_instr",  getName_dfp_instrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗机");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"CSSD_INSTR a0b6","id_dfp_instr=id_instr","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗程序名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_clnproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_clnpro",  getName_clnproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗程序名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_clnpro=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b9","id_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 清洗科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_depADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep",  getName_depCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("清洗科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b10","id_dep=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取消毒包清洗主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dfp_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dfp_cln");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("消毒包清洗主键"); 
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
	 * 获取清洗类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pkgcleanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pkgclean");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗类型ID"); 
		return column;
	}
	/**
	 * 获取清洗类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pkgcleanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pkgclean");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗类型编码"); 
		return column;
	}
	/**
	 * 获取清洗机表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dfp_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dfp_instr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗机"); 
		return column;
	}
	/**
	 * 获取清洗机关系ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dfp_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dfp_rel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗机关系ID"); 
		return column;
	}
	/**
	 * 获取清洗批次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBatchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Batch");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗批次"); 
		return column;
	}
	/**
	 * 获取扫码条码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRec_no_barCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rec_no_bar");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("扫码条码"); 
		return column;
	}
	/**
	 * 获取清洗程序SD表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_clnproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_clnpro");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗程序SD"); 
		return column;
	}
	/**
	 * 获取清洗程序ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_clnproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_clnpro");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗程序ID"); 
		return column;
	}
	/**
	 * 获取清洗时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_clnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cln");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清洗时间"); 
		return column;
	}
	/**
	 * 获取清洗人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗人"); 
		return column;
	}
	/**
	 * 获取清洗科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗科室"); 
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
	 * 获取清洗类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pkgcleanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pkgclean");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗类型名称"); 
		return column;
	}
	/**
	 * 获取清洗机表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dfp_instrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dfp_instr");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗机"); 
		return column;
	}
	/**
	 * 获取清洗程序名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_clnproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_clnpro");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗程序名称"); 
		return column;
	}
	/**
	 * 获取清洗人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗人"); 
		return column;
	}
	/**
	 * 获取清洗科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_depCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("清洗科室"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
