
package iih.ci.mr.nu.babyhandover.d.desc;

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
 * 新生儿交接记录 DO 元数据信息
 */
public class BabyhandoverrecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.babyhandover.d.BabyhandoverrecordDO";
	public static final String CLASS_DISPALYNAME = "新生儿交接记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_babyhand_reco";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_babyhandreco";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BabyhandoverrecordDODesc(){
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
		this.setKeyDesc(getId_babyhandrecoADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_babyhandADesc(tblDesc));
		this.add(getId_babyhandrecoADesc(tblDesc));
		this.add(getId_babyhandADesc(tblDesc));
		this.add(getEnumbirthADesc(tblDesc));
		this.add(getHeightADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getHeadsizeADesc(tblDesc));
		this.add(getBustADesc(tblDesc));
		this.add(getId_skincolorADesc(tblDesc));
		this.add(getSd_skincolorADesc(tblDesc));
		this.add(getHeartrateADesc(tblDesc));
		this.add(getBreatheADesc(tblDesc));
		this.add(getMuscular_tensionADesc(tblDesc));
		this.add(getThroat_reflectionADesc(tblDesc));
		this.add(getGenitalADesc(tblDesc));
		this.add(getAnusADesc(tblDesc));
		this.add(getLimbsADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_skincolorADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_babyhandrecoCDesc(tblDesc));
		tblDesc.add(getId_babyhandrecoCDesc(tblDesc));
		tblDesc.add(getId_babyhandCDesc(tblDesc));
		tblDesc.add(getEnumbirthCDesc(tblDesc));
		tblDesc.add(getHeightCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getHeadsizeCDesc(tblDesc));
		tblDesc.add(getBustCDesc(tblDesc));
		tblDesc.add(getId_skincolorCDesc(tblDesc));
		tblDesc.add(getSd_skincolorCDesc(tblDesc));
		tblDesc.add(getHeartrateCDesc(tblDesc));
		tblDesc.add(getBreatheCDesc(tblDesc));
		tblDesc.add(getMuscular_tensionCDesc(tblDesc));
		tblDesc.add(getThroat_reflectionCDesc(tblDesc));
		tblDesc.add(getGenitalCDesc(tblDesc));
		tblDesc.add(getAnusCDesc(tblDesc));
		tblDesc.add(getLimbsCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 新生儿交接记录Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_babyhandrecoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_babyhandreco",  getId_babyhandrecoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新生儿交接记录Id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿交接基本信息Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_babyhandADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_babyhand",  getId_babyhandCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新生儿交接基本信息Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出生出院类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnumbirthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enumbirth",  getEnumbirthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("出生出院类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height",  getHeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 头围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeadsizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Headsize",  getHeadsizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("头围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胸围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBustADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bust",  getBustCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胸围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肤色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skincolor",  getId_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肤色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skincolor",  getSd_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心率属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeartrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heartrate",  getHeartrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心率");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreatheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breathe",  getBreatheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMuscular_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Muscular_tension",  getMuscular_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 喉反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getThroat_reflectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Throat_reflection",  getThroat_reflectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("喉反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生殖器属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGenitalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Genital",  getGenitalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生殖器");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肛门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAnusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Anus",  getAnusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肛门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 四肢属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLimbsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Limbs",  getLimbsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("四肢");
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
	 * 肤色名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skincolorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skincolor",  getName_skincolorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肤色名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_skincolor=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取新生儿交接记录Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_babyhandrecoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_babyhandreco");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("新生儿交接记录Id"); 
		return column;
	}
	/**
	 * 获取新生儿交接基本信息Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_babyhandCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_babyhand");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新生儿交接基本信息Id"); 
		return column;
	}
	/**
	 * 获取出生出院类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnumbirthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enumbirth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("出生出院类型"); 
		return column;
	}
	/**
	 * 获取身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("身长"); 
		return column;
	}
	/**
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取头围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeadsizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Headsize");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("头围"); 
		return column;
	}
	/**
	 * 获取胸围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBustCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bust");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胸围"); 
		return column;
	}
	/**
	 * 获取肤色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skincolor");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色"); 
		return column;
	}
	/**
	 * 获取肤色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skincolor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色编码"); 
		return column;
	}
	/**
	 * 获取心率表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeartrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heartrate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心率"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreatheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breathe");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取肌张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMuscular_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Muscular_tension");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力"); 
		return column;
	}
	/**
	 * 获取喉反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getThroat_reflectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Throat_reflection");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("喉反射"); 
		return column;
	}
	/**
	 * 获取生殖器表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGenitalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Genital");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生殖器"); 
		return column;
	}
	/**
	 * 获取肛门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAnusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Anus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肛门"); 
		return column;
	}
	/**
	 * 获取四肢表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLimbsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Limbs");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("四肢"); 
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
	 * 获取肤色名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skincolorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skincolor");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肤色名称"); 
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
