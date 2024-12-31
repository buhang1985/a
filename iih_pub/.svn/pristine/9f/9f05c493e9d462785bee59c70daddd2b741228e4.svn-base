
package iih.bd.srv.emrterm.d.desc;

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
 * 病历事件组件关系 DO 元数据信息
 */
public class EmrEtCompRelDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.emrterm.d.EmrEtCompRelDO";
	public static final String CLASS_DISPALYNAME = "病历事件组件关系";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mra_etcomp_rel";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mraetcomprel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EmrEtCompRelDODesc(){
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
		this.setKeyDesc(getId_mraetcomprelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_mraetcomprelADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_mraetADesc(tblDesc));
		this.add(getId_mracompADesc(tblDesc));
		this.add(getId_mrtermsysADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getComp_nameADesc(tblDesc));
		this.add(getComp_cfg_maxADesc(tblDesc));
		this.add(getComp_cfg_minADesc(tblDesc));
		this.add(getComp_cfg_descADesc(tblDesc));
		this.add(getXgrid_cfg_maxADesc(tblDesc));
		this.add(getXgrid_cfg_minADesc(tblDesc));
		this.add(getXgrid_cfg_descADesc(tblDesc));
		this.add(getMr_mraet_codeADesc(tblDesc));
		this.add(getMr_mraet_nameADesc(tblDesc));
		this.add(getMr_mracomp_codeADesc(tblDesc));
		this.add(getMr_mracomp_nameADesc(tblDesc));
		this.add(getMr_sys_nameADesc(tblDesc));
		this.add(getMr_sys_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mraetcomprelCDesc(tblDesc));
		tblDesc.add(getId_mraetcomprelCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_mraetCDesc(tblDesc));
		tblDesc.add(getId_mracompCDesc(tblDesc));
		tblDesc.add(getId_mrtermsysCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getComp_nameCDesc(tblDesc));
		tblDesc.add(getComp_cfg_maxCDesc(tblDesc));
		tblDesc.add(getComp_cfg_minCDesc(tblDesc));
		tblDesc.add(getComp_cfg_descCDesc(tblDesc));
		tblDesc.add(getXgrid_cfg_maxCDesc(tblDesc));
		tblDesc.add(getXgrid_cfg_minCDesc(tblDesc));
		tblDesc.add(getXgrid_cfg_descCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 病历事件组件关系主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mraetcomprelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mraetcomprel",  getId_mraetcomprelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历事件组件关系主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历术语事件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mraetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mraet",  getId_mraetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历术语事件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病历术语组件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mracompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mracomp",  getId_mracompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历术语组件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病历术语体系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtermsysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtermsys",  getId_mrtermsysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历术语体系");
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
	 * 组件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comp_name",  getComp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组件配置_大屏幕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComp_cfg_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comp_cfg_max",  getComp_cfg_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件配置_大屏幕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组件配置_小屏幕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComp_cfg_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comp_cfg_min",  getComp_cfg_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件配置_小屏幕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组件配置_描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComp_cfg_descADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Comp_cfg_desc",  getComp_cfg_descCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件配置_描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 列表控件配置_大屏幕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXgrid_cfg_maxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xgrid_cfg_max",  getXgrid_cfg_maxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("列表控件配置_大屏幕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 列表控件配置_小屏幕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXgrid_cfg_minADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xgrid_cfg_min",  getXgrid_cfg_minCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("列表控件配置_小屏幕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 列表控件配置描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getXgrid_cfg_descADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Xgrid_cfg_desc",  getXgrid_cfg_descCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("列表控件配置描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_mraet_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_mraet_code",  getMr_mraet_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_et a0b2","id_mraet=id_mraet","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_mraet_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_mraet_name",  getMr_mraet_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_et a0b2","id_mraet=id_mraet","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_mracomp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_mracomp_code",  getMr_mracomp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_comp a0b3","id_mracomp=id_mracomp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_mracomp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_mracomp_name",  getMr_mracomp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mra_comp a0b3","id_mracomp=id_mracomp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_sys_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_sys_name",  getMr_sys_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_mrtermsys=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_sys_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_sys_code",  getMr_sys_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_mrtermsys=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取病历事件组件关系主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mraetcomprelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mraetcomprel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病历事件组件关系主键标识"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取病历术语事件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mraetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mraet");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历术语事件"); 
		return column;
	}
	/**
	 * 获取病历术语组件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mracompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mracomp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历术语组件"); 
		return column;
	}
	/**
	 * 获取病历术语体系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtermsysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtermsys");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历术语体系"); 
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
	 * 获取组件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comp_name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件名称"); 
		return column;
	}
	/**
	 * 获取组件配置_大屏幕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComp_cfg_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comp_cfg_max");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件配置_大屏幕"); 
		return column;
	}
	/**
	 * 获取组件配置_小屏幕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComp_cfg_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comp_cfg_min");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件配置_小屏幕"); 
		return column;
	}
	/**
	 * 获取组件配置_描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getComp_cfg_descCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Comp_cfg_desc");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件配置_描述"); 
		return column;
	}
	/**
	 * 获取列表控件配置_大屏幕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXgrid_cfg_maxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xgrid_cfg_max");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("列表控件配置_大屏幕"); 
		return column;
	}
	/**
	 * 获取列表控件配置_小屏幕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXgrid_cfg_minCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xgrid_cfg_min");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("列表控件配置_小屏幕"); 
		return column;
	}
	/**
	 * 获取列表控件配置描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getXgrid_cfg_descCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Xgrid_cfg_desc");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("列表控件配置描述"); 
		return column;
	}
	/**
	 * 获取事件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_mraet_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_mraet_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件编码"); 
		return column;
	}
	/**
	 * 获取事件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_mraet_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_mraet_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件名称"); 
		return column;
	}
	/**
	 * 获取组件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_mracomp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_mracomp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件编码"); 
		return column;
	}
	/**
	 * 获取组件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_mracomp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_mracomp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组件名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_sys_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_sys_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_sys_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_sys_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
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
