
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
 * 患者个人史 DO 元数据信息
 */
public class PiPatPsnDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.overview.overview.d.PiPatPsnDO";
	public static final String CLASS_DISPALYNAME = "患者个人史";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "PI_PAT_PSN";
	public static final String TABLE_ALIAS_NAME = "a16";
	public static final String PRIMARYKEY_FIELDNAME="Id_patpsn";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatPsnDODesc(){
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
		this.setKeyDesc(getId_patpsnADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_patpsnADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getSd_datasrcADesc(tblDesc));
		this.add(getId_smokstaADesc(tblDesc));
		this.add(getSd_smokstaADesc(tblDesc));
		this.add(getSmokfreqADesc(tblDesc));
		this.add(getSmokstartageADesc(tblDesc));
		this.add(getFg_smokoutADesc(tblDesc));
		this.add(getSmokoutageADesc(tblDesc));
		this.add(getId_drinkstaADesc(tblDesc));
		this.add(getSd_drinkstaADesc(tblDesc));
		this.add(getDrinkfreqADesc(tblDesc));
		this.add(getDrinkstartageADesc(tblDesc));
		this.add(getFg_drinkoutADesc(tblDesc));
		this.add(getDrinkoutageADesc(tblDesc));
		this.add(getSmokesta_nameADesc(tblDesc));
		this.add(getDrinksta_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patpsnCDesc(tblDesc));
		tblDesc.add(getId_patpsnCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getSd_datasrcCDesc(tblDesc));
		tblDesc.add(getId_smokstaCDesc(tblDesc));
		tblDesc.add(getSd_smokstaCDesc(tblDesc));
		tblDesc.add(getSmokfreqCDesc(tblDesc));
		tblDesc.add(getSmokstartageCDesc(tblDesc));
		tblDesc.add(getFg_smokoutCDesc(tblDesc));
		tblDesc.add(getSmokoutageCDesc(tblDesc));
		tblDesc.add(getId_drinkstaCDesc(tblDesc));
		tblDesc.add(getSd_drinkstaCDesc(tblDesc));
		tblDesc.add(getDrinkfreqCDesc(tblDesc));
		tblDesc.add(getDrinkstartageCDesc(tblDesc));
		tblDesc.add(getFg_drinkoutCDesc(tblDesc));
		tblDesc.add(getDrinkoutageCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者个人史ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patpsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patpsn",  getId_patpsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者个人史ID");
		attrDesc.setNullable(false);
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
	 * 数据来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_datasrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_datasrc",  getSd_datasrcCDesc(tblDesc), this);
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
	 * 吸烟状况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_smokstaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_smoksta",  getId_smokstaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸烟状况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吸烟状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_smokstaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_smoksta",  getSd_smokstaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸烟状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吸烟频率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSmokfreqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Smokfreq",  getSmokfreqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吸烟频率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始吸烟年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSmokstartageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Smokstartage",  getSmokstartageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开始吸烟年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 戒烟标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_smokoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_smokout",  getFg_smokoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("戒烟标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 戒烟年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSmokoutageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Smokoutage",  getSmokoutageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("戒烟年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮酒状况id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drinkstaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drinksta",  getId_drinkstaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮酒状况id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 饮酒状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drinkstaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drinksta",  getSd_drinkstaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮酒状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮酒频率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrinkfreqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drinkfreq",  getDrinkfreqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮酒频率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始饮酒年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrinkstartageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drinkstartage",  getDrinkstartageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开始饮酒年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 戒酒标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_drinkoutADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_drinkout",  getFg_drinkoutCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("戒酒标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 戒酒年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrinkoutageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drinkoutage",  getDrinkoutageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("戒酒年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSmokesta_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Smokesta_name",  getSmokesta_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a16b1","id_smoksta=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrinksta_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drinksta_name",  getDrinksta_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a16b2","id_drinksta=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者个人史ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patpsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patpsn");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者个人史ID"); 
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
	 * 获取数据来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_datasrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_datasrc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数据来源"); 
		return column;
	}
	/**
	 * 获取吸烟状况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_smokstaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_smoksta");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸烟状况id"); 
		return column;
	}
	/**
	 * 获取吸烟状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_smokstaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_smoksta");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸烟状况编码"); 
		return column;
	}
	/**
	 * 获取吸烟频率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSmokfreqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Smokfreq");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吸烟频率"); 
		return column;
	}
	/**
	 * 获取开始吸烟年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSmokstartageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Smokstartage");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开始吸烟年龄"); 
		return column;
	}
	/**
	 * 获取戒烟标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_smokoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_smokout");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("戒烟标志"); 
		return column;
	}
	/**
	 * 获取戒烟年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSmokoutageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Smokoutage");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("戒烟年龄"); 
		return column;
	}
	/**
	 * 获取饮酒状况id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drinkstaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drinksta");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮酒状况id"); 
		return column;
	}
	/**
	 * 获取饮酒状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drinkstaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drinksta");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮酒状况编码"); 
		return column;
	}
	/**
	 * 获取饮酒频率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrinkfreqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drinkfreq");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮酒频率"); 
		return column;
	}
	/**
	 * 获取开始饮酒年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrinkstartageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drinkstartage");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开始饮酒年龄"); 
		return column;
	}
	/**
	 * 获取戒酒标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_drinkoutCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_drinkout");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("戒酒标志"); 
		return column;
	}
	/**
	 * 获取戒酒年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrinkoutageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drinkoutage");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("戒酒年龄"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSmokesta_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Smokesta_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrinksta_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drinksta_name");
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
