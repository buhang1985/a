
package iih.ci.mr.nu.babycare.d.desc;

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
 * 新生儿护理记录 DO 元数据信息
 */
public class BabyNurRecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.babycare.d.BabyNurRecDO";
	public static final String CLASS_DISPALYNAME = "新生儿护理记录";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_BABYNURREC";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_nur_rec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BabyNurRecDODesc(){
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
		this.setKeyDesc(getId_nur_recADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_babyADesc(tblDesc));
		this.add(getId_nur_recADesc(tblDesc));
		this.add(getId_babyADesc(tblDesc));
		this.add(getDt_recADesc(tblDesc));
		this.add(getSuck_timeADesc(tblDesc));
		this.add(getFecesADesc(tblDesc));
		this.add(getPeeADesc(tblDesc));
		this.add(getId_funicleADesc(tblDesc));
		this.add(getSd_funicleADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getHeadADesc(tblDesc));
		this.add(getEu_vomitADesc(tblDesc));
		this.add(getObser_treatADesc(tblDesc));
		this.add(getName_psn_signADesc(tblDesc));
		this.add(getId_psn_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_funicleADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nur_recCDesc(tblDesc));
		tblDesc.add(getId_nur_recCDesc(tblDesc));
		tblDesc.add(getId_babyCDesc(tblDesc));
		tblDesc.add(getDt_recCDesc(tblDesc));
		tblDesc.add(getSuck_timeCDesc(tblDesc));
		tblDesc.add(getFecesCDesc(tblDesc));
		tblDesc.add(getPeeCDesc(tblDesc));
		tblDesc.add(getId_funicleCDesc(tblDesc));
		tblDesc.add(getSd_funicleCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getHeadCDesc(tblDesc));
		tblDesc.add(getEu_vomitCDesc(tblDesc));
		tblDesc.add(getObser_treatCDesc(tblDesc));
		tblDesc.add(getName_psn_signCDesc(tblDesc));
		tblDesc.add(getId_psn_signCDesc(tblDesc));
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
	private IAttrDesc getId_nur_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_rec",  getId_nur_recCDesc(tblDesc), this);
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
	 * 新生儿信息属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_babyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_baby",  getId_babyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新生儿信息");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 日期时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rec",  getDt_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("日期时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 母乳吸吮次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSuck_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Suck_time",  getSuck_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("母乳吸吮次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFecesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Feces",  getFecesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("大便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPeeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pee",  getPeeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("小便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_funicleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_funicle",  getId_funicleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脐带编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_funicleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_funicle",  getSd_funicleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin",  getId_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 头属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Head",  getHeadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("头");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呕吐属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_vomitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_vomit",  getEu_vomitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呕吐");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情观察及处理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getObser_treatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Obser_treat",  getObser_treatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情观察及处理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn_sign",  getName_psn_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 签名人ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psn_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psn_sign",  getId_psn_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名人ID");
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
	 * 脐带属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_funicleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_funicle",  getName_funicleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_funicle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin",  getName_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b7","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取唯一标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_rec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("唯一标识"); 
		return column;
	}
	/**
	 * 获取新生儿信息表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_babyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_baby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新生儿信息"); 
		return column;
	}
	/**
	 * 获取日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rec");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期时间"); 
		return column;
	}
	/**
	 * 获取母乳吸吮次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSuck_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Suck_time");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("母乳吸吮次数"); 
		return column;
	}
	/**
	 * 获取大便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFecesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Feces");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("大便"); 
		return column;
	}
	/**
	 * 获取小便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPeeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pee");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("小便"); 
		return column;
	}
	/**
	 * 获取脐带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_funicleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_funicle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带"); 
		return column;
	}
	/**
	 * 获取脐带编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_funicleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_funicle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带编码"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤编码"); 
		return column;
	}
	/**
	 * 获取头表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Head");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("头"); 
		return column;
	}
	/**
	 * 获取呕吐表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_vomitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_vomit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呕吐"); 
		return column;
	}
	/**
	 * 获取病情观察及处理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getObser_treatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Obser_treat");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情观察及处理"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取签名人ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psn_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psn_sign");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名人ID"); 
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
	 * 获取脐带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_funicleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_funicle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带"); 
		return column;
	}
	/**
	 * 获取皮肤名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤名称"); 
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
