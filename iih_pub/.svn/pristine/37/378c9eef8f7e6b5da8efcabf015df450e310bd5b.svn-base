
package iih.pi.overview.overview.d.desc;

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
 * 患者过敏史 DO 元数据信息
 */
public class PiPatAlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.overview.overview.d.PiPatAlDO";
	public static final String CLASS_DISPALYNAME = "患者过敏史";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_al";
	public static final String TABLE_ALIAS_NAME = "a5";
	public static final String PRIMARYKEY_FIELDNAME="Id_patal";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatAlDODesc(){
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
		this.setKeyDesc(getId_patalADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_patalADesc(tblDesc));
		this.add(getSd_datasrcADesc(tblDesc));
		this.add(getId_datasrcADesc(tblDesc));
		this.add(getDt_actADesc(tblDesc));
		this.add(getSd_ymd_actADesc(tblDesc));
		this.add(getId_ymd_actADesc(tblDesc));
		this.add(getSd_altpADesc(tblDesc));
		this.add(getId_altpADesc(tblDesc));
		this.add(getName_altpADesc(tblDesc));
		this.add(getDes_altpADesc(tblDesc));
		this.add(getId_alclaADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getId_mmADesc(tblDesc));
		this.add(getSd_alclaADesc(tblDesc));
		this.add(getName_alclaADesc(tblDesc));
		this.add(getDes_alclaADesc(tblDesc));
		this.add(getId_aldegADesc(tblDesc));
		this.add(getSd_aldegADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCode_srvADesc(tblDesc));
		this.add(getName_srvADesc(tblDesc));
		this.add(getMm_codeADesc(tblDesc));
		this.add(getMm_nameADesc(tblDesc));
		this.add(getAldeg_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patalCDesc(tblDesc));
		tblDesc.add(getId_patalCDesc(tblDesc));
		tblDesc.add(getSd_datasrcCDesc(tblDesc));
		tblDesc.add(getId_datasrcCDesc(tblDesc));
		tblDesc.add(getDt_actCDesc(tblDesc));
		tblDesc.add(getSd_ymd_actCDesc(tblDesc));
		tblDesc.add(getId_ymd_actCDesc(tblDesc));
		tblDesc.add(getSd_altpCDesc(tblDesc));
		tblDesc.add(getId_altpCDesc(tblDesc));
		tblDesc.add(getName_altpCDesc(tblDesc));
		tblDesc.add(getDes_altpCDesc(tblDesc));
		tblDesc.add(getId_alclaCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getId_mmCDesc(tblDesc));
		tblDesc.add(getSd_alclaCDesc(tblDesc));
		tblDesc.add(getName_alclaCDesc(tblDesc));
		tblDesc.add(getDes_alclaCDesc(tblDesc));
		tblDesc.add(getId_aldegCDesc(tblDesc));
		tblDesc.add(getSd_aldegCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者过敏史ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patal",  getId_patalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者过敏史ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_datasrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_datasrc",  getSd_datasrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数据来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_datasrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_datasrc",  getId_datasrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数据来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_act",  getDt_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期精度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ymd_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ymd_act",  getSd_ymd_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("日期精度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期精度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ymd_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ymd_act",  getId_ymd_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("日期精度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_altpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_altp",  getSd_altpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_altpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_altp",  getId_altpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 过敏类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_altpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_altp",  getName_altpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏类型描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_altpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_altp",  getDes_altpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏类型描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_alclaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_alcla",  getId_alclaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 物品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mm",  getId_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 过敏原编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_alclaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_alcla",  getSd_alclaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏原编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_alclaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_alcla",  getName_alclaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏分类描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_alclaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_alcla",  getDes_alclaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏分类描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏严重程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aldegADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aldeg",  getId_aldegCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏严重程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 过敏严重程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_aldegADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_aldeg",  getSd_aldegCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏严重程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_srv",  getCode_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a5b5","id_srv=id_srv","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_srv a5b5","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_code",  getMm_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a5b4","id_mm=id_mm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMm_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mm_name",  getMm_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_MM a5b4","id_mm=id_mm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAldeg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Aldeg_name",  getAldeg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a5b3","id_aldeg=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者过敏史ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patal");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者过敏史ID"); 
		return column;
	}
	/**
	 * 获取数据来源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_datasrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_datasrc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源编码"); 
		return column;
	}
	/**
	 * 获取数据来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_datasrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_datasrc");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("数据来源"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_act");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取日期精度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ymd_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ymd_act");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("日期精度编码"); 
		return column;
	}
	/**
	 * 获取日期精度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ymd_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ymd_act");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("日期精度"); 
		return column;
	}
	/**
	 * 获取过敏类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_altpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_altp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏类型编码"); 
		return column;
	}
	/**
	 * 获取过敏类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_altpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_altp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏类型"); 
		return column;
	}
	/**
	 * 获取过敏类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_altpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_altp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏类型名称"); 
		return column;
	}
	/**
	 * 获取过敏类型描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_altpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_altp");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏类型描述"); 
		return column;
	}
	/**
	 * 获取过敏分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_alclaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_alcla");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏分类"); 
		return column;
	}
	/**
	 * 获取服务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务"); 
		return column;
	}
	/**
	 * 获取物品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品"); 
		return column;
	}
	/**
	 * 获取过敏原编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_alclaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_alcla");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏原编码"); 
		return column;
	}
	/**
	 * 获取过敏分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_alclaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_alcla");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏分类名称"); 
		return column;
	}
	/**
	 * 获取过敏分类描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_alclaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_alcla");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏分类描述"); 
		return column;
	}
	/**
	 * 获取过敏严重程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aldegCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aldeg");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏严重程度"); 
		return column;
	}
	/**
	 * 获取过敏严重程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_aldegCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_aldeg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏严重程度编码"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_srv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
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
	 * 获取物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品编码"); 
		return column;
	}
	/**
	 * 获取物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMm_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mm_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("物品名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAldeg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Aldeg_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
