
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
 * 患者月经史 DO 元数据信息
 */
public class PiPatMhDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.overview.overview.d.PiPatMhDO";
	public static final String CLASS_DISPALYNAME = "患者月经史";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "PI_PAT_MH";
	public static final String TABLE_ALIAS_NAME = "a15";
	public static final String PRIMARYKEY_FIELDNAME="Id_patmh";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatMhDODesc(){
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
		this.setKeyDesc(getId_patmhADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_patmhADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getSd_datasrcADesc(tblDesc));
		this.add(getId_datasrcADesc(tblDesc));
		this.add(getAge_1stADesc(tblDesc));
		this.add(getPeriADesc(tblDesc));
		this.add(getCycleADesc(tblDesc));
		this.add(getAge_mpADesc(tblDesc));
		this.add(getFg_mpADesc(tblDesc));
		this.add(getFg_surgmpADesc(tblDesc));
		this.add(getSd_bleedtpADesc(tblDesc));
		this.add(getFg_dysADesc(tblDesc));
		this.add(getId_degdysADesc(tblDesc));
		this.add(getSd_degdysADesc(tblDesc));
		this.add(getFg_disoADesc(tblDesc));
		this.add(getId_bleedtpADesc(tblDesc));
		this.add(getDegdys_codeADesc(tblDesc));
		this.add(getDegdys_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patmhCDesc(tblDesc));
		tblDesc.add(getId_patmhCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getSd_datasrcCDesc(tblDesc));
		tblDesc.add(getId_datasrcCDesc(tblDesc));
		tblDesc.add(getAge_1stCDesc(tblDesc));
		tblDesc.add(getPeriCDesc(tblDesc));
		tblDesc.add(getCycleCDesc(tblDesc));
		tblDesc.add(getAge_mpCDesc(tblDesc));
		tblDesc.add(getFg_mpCDesc(tblDesc));
		tblDesc.add(getFg_surgmpCDesc(tblDesc));
		tblDesc.add(getSd_bleedtpCDesc(tblDesc));
		tblDesc.add(getFg_dysCDesc(tblDesc));
		tblDesc.add(getId_degdysCDesc(tblDesc));
		tblDesc.add(getSd_degdysCDesc(tblDesc));
		tblDesc.add(getFg_disoCDesc(tblDesc));
		tblDesc.add(getId_bleedtpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者月经史ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patmhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patmh",  getId_patmhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者月经史ID");
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
	 * 初潮年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAge_1stADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_1st",  getAge_1stCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("初潮年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 月经经期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPeriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Peri",  getPeriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("月经经期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 月经周期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCycleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cycle",  getCycleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("月经周期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绝经年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAge_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age_mp",  getAge_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("绝经年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绝经标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mp",  getFg_mpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("绝经标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术绝经标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_surgmpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_surgmp",  getFg_surgmpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("手术绝经标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血量类别代码编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bleedtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bleedtp",  getSd_bleedtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血量类别代码编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 痛经标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_dysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_dys",  getFg_dysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("痛经标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 痛经程度id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_degdysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_degdys",  getId_degdysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("痛经程度id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 痛经程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_degdysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_degdys",  getSd_degdysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("痛经程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 月经异常标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_disoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_diso",  getFg_disoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("月经异常标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出血量类别代码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bleedtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bleedtp",  getId_bleedtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出血量类别代码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDegdys_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Degdys_code",  getDegdys_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a15b2","id_degdys=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDegdys_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Degdys_name",  getDegdys_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a15b2","id_degdys=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者月经史ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patmhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patmh");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者月经史ID"); 
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
	 * 获取初潮年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_1stCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_1st");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("初潮年龄"); 
		return column;
	}
	/**
	 * 获取月经经期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPeriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Peri");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("月经经期"); 
		return column;
	}
	/**
	 * 获取月经周期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCycleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cycle");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("月经周期"); 
		return column;
	}
	/**
	 * 获取绝经年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAge_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age_mp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("绝经年龄"); 
		return column;
	}
	/**
	 * 获取绝经标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("绝经标志"); 
		return column;
	}
	/**
	 * 获取手术绝经标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_surgmpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_surgmp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术绝经标志"); 
		return column;
	}
	/**
	 * 获取出血量类别代码编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bleedtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bleedtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出血量类别代码编码"); 
		return column;
	}
	/**
	 * 获取痛经标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_dysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_dys");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("痛经标志"); 
		return column;
	}
	/**
	 * 获取痛经程度id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_degdysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_degdys");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("痛经程度id"); 
		return column;
	}
	/**
	 * 获取痛经程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_degdysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_degdys");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("痛经程度编码"); 
		return column;
	}
	/**
	 * 获取月经异常标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_disoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_diso");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("月经异常标志"); 
		return column;
	}
	/**
	 * 获取出血量类别代码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bleedtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bleedtp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出血量类别代码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDegdys_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Degdys_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDegdys_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Degdys_name");
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
