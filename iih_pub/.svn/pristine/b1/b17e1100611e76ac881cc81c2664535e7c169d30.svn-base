
package iih.ci.mr.nu.antencare.d.desc;

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
 * 检查记录 DO 元数据信息
 */
public class InspRecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.antencare.d.InspRecDO";
	public static final String CLASS_DISPALYNAME = "检查记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_NU_INSPREC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_rec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public InspRecDODesc(){
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
		this.setKeyDesc(getId_recADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_antADesc(tblDesc));
		this.add(getId_recADesc(tblDesc));
		this.add(getId_antADesc(tblDesc));
		this.add(getDropsyADesc(tblDesc));
		this.add(getPresentatADesc(tblDesc));
		this.add(getProteinADesc(tblDesc));
		this.add(getChangemeaADesc(tblDesc));
		this.add(getGest_weeksADesc(tblDesc));
		this.add(getDbp_recADesc(tblDesc));
		this.add(getFetal_lieADesc(tblDesc));
		this.add(getSbp_recADesc(tblDesc));
		this.add(getFetal_heartADesc(tblDesc));
		this.add(getWeight_recADesc(tblDesc));
		this.add(getFundal_heightADesc(tblDesc));
		this.add(getAbd_girthADesc(tblDesc));
		this.add(getFerrohemeADesc(tblDesc));
		this.add(getDt_recADesc(tblDesc));
		this.add(getDue_date_recADesc(tblDesc));
		this.add(getId_rec_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_rec_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_recCDesc(tblDesc));
		tblDesc.add(getId_recCDesc(tblDesc));
		tblDesc.add(getId_antCDesc(tblDesc));
		tblDesc.add(getDropsyCDesc(tblDesc));
		tblDesc.add(getPresentatCDesc(tblDesc));
		tblDesc.add(getProteinCDesc(tblDesc));
		tblDesc.add(getChangemeaCDesc(tblDesc));
		tblDesc.add(getGest_weeksCDesc(tblDesc));
		tblDesc.add(getDbp_recCDesc(tblDesc));
		tblDesc.add(getFetal_lieCDesc(tblDesc));
		tblDesc.add(getSbp_recCDesc(tblDesc));
		tblDesc.add(getFetal_heartCDesc(tblDesc));
		tblDesc.add(getWeight_recCDesc(tblDesc));
		tblDesc.add(getFundal_heightCDesc(tblDesc));
		tblDesc.add(getAbd_girthCDesc(tblDesc));
		tblDesc.add(getFerrohemeCDesc(tblDesc));
		tblDesc.add(getDt_recCDesc(tblDesc));
		tblDesc.add(getDue_date_recCDesc(tblDesc));
		tblDesc.add(getId_rec_signCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 唯一标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rec",  getId_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("唯一标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记信息主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_antADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ant",  getId_antCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记信息主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 浮肿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDropsyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dropsy",  getDropsyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("浮肿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 先露属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPresentatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Presentat",  getPresentatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("先露");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 尿蛋白属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProteinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Protein",  getProteinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("尿蛋白");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情变化级护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChangemeaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Changemea",  getChangemeaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情变化级护理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 孕周属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGest_weeksADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Gest_weeks",  getGest_weeksCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("孕周");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压(记录)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDbp_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dbp_rec",  getDbp_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压(记录)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFetal_lieADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fetal_lie",  getFetal_lieCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压(记录)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSbp_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sbp_rec",  getSbp_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压(记录)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎心属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFetal_heartADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fetal_heart",  getFetal_heartCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎心");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重(记录)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_rec",  getWeight_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体重(记录)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宫高属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFundal_heightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fundal_height",  getFundal_heightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("宫高");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 腹围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAbd_girthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Abd_girth",  getAbd_girthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("腹围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血红素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFerrohemeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ferroheme",  getFerrohemeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血红素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记录日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rec",  getDt_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("记录日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约日期(记录)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDue_date_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Due_date_rec",  getDue_date_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("预约日期(记录)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记录签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rec_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rec_sign",  getId_rec_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记录签名");
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rec_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rec_sign",  getName_rec_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b2","id_rec_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取唯一标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("唯一标识"); 
		return column;
	}
	/**
	 * 获取登记信息主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_antCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ant");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记信息主键"); 
		return column;
	}
	/**
	 * 获取浮肿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDropsyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dropsy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("浮肿"); 
		return column;
	}
	/**
	 * 获取先露表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPresentatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Presentat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("先露"); 
		return column;
	}
	/**
	 * 获取尿蛋白表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProteinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Protein");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("尿蛋白"); 
		return column;
	}
	/**
	 * 获取病情变化级护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChangemeaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Changemea");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情变化级护理措施"); 
		return column;
	}
	/**
	 * 获取孕周表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGest_weeksCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Gest_weeks");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("孕周"); 
		return column;
	}
	/**
	 * 获取舒张压(记录)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDbp_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dbp_rec");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压(记录)"); 
		return column;
	}
	/**
	 * 获取胎位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFetal_lieCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fetal_lie");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎位"); 
		return column;
	}
	/**
	 * 获取收缩压(记录)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSbp_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sbp_rec");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压(记录)"); 
		return column;
	}
	/**
	 * 获取胎心表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFetal_heartCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fetal_heart");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎心"); 
		return column;
	}
	/**
	 * 获取体重(记录)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_rec");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体重(记录)"); 
		return column;
	}
	/**
	 * 获取宫高表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFundal_heightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fundal_height");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("宫高"); 
		return column;
	}
	/**
	 * 获取腹围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAbd_girthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Abd_girth");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("腹围"); 
		return column;
	}
	/**
	 * 获取血红素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFerrohemeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ferroheme");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血红素"); 
		return column;
	}
	/**
	 * 获取记录日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rec");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记录日期"); 
		return column;
	}
	/**
	 * 获取预约日期(记录)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDue_date_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Due_date_rec");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约日期(记录)"); 
		return column;
	}
	/**
	 * 获取记录签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rec_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rec_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记录签名"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rec_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rec_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
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
