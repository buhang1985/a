
package iih.ci.mr.nu.babybirrecord.d.desc;

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
 * 婴儿护理记录表 DO 元数据信息
 */
public class BabyBirRecordDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.babybirrecord.d.BabyBirRecordDO";
	public static final String CLASS_DISPALYNAME = "婴儿护理记录表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_baby_record";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_babyrecord";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BabyBirRecordDODesc(){
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
		this.setKeyDesc(getId_babyrecordADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_babyinfoADesc(tblDesc));
		this.add(getId_babyrecordADesc(tblDesc));
		this.add(getId_babyinfoADesc(tblDesc));
		this.add(getIdiographADesc(tblDesc));
		this.add(getHeartrateADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getTotal_scoreADesc(tblDesc));
		this.add(getId_typesADesc(tblDesc));
		this.add(getSd_typesADesc(tblDesc));
		this.add(getId_mus_tensionADesc(tblDesc));
		this.add(getSd_mus_tensionADesc(tblDesc));
		this.add(getMus_tension_scoreADesc(tblDesc));
		this.add(getId_stim_resADesc(tblDesc));
		this.add(getSd_stim_resADesc(tblDesc));
		this.add(getStim_res_scoreADesc(tblDesc));
		this.add(getId_skin_colorADesc(tblDesc));
		this.add(getSd_skin_colorADesc(tblDesc));
		this.add(getSkin_color_scoreADesc(tblDesc));
		this.add(getScore_mus_tensionADesc(tblDesc));
		this.add(getScore_stim_resADesc(tblDesc));
		this.add(getScore_skin_colorADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_idographADesc(tblDesc));
		this.add(getName_typesADesc(tblDesc));
		this.add(getName_mus_tensionADesc(tblDesc));
		this.add(getName_stim_resADesc(tblDesc));
		this.add(getName_skin_colorADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_babyrecordCDesc(tblDesc));
		tblDesc.add(getId_babyrecordCDesc(tblDesc));
		tblDesc.add(getId_babyinfoCDesc(tblDesc));
		tblDesc.add(getIdiographCDesc(tblDesc));
		tblDesc.add(getHeartrateCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getTotal_scoreCDesc(tblDesc));
		tblDesc.add(getId_typesCDesc(tblDesc));
		tblDesc.add(getSd_typesCDesc(tblDesc));
		tblDesc.add(getId_mus_tensionCDesc(tblDesc));
		tblDesc.add(getSd_mus_tensionCDesc(tblDesc));
		tblDesc.add(getMus_tension_scoreCDesc(tblDesc));
		tblDesc.add(getId_stim_resCDesc(tblDesc));
		tblDesc.add(getSd_stim_resCDesc(tblDesc));
		tblDesc.add(getStim_res_scoreCDesc(tblDesc));
		tblDesc.add(getId_skin_colorCDesc(tblDesc));
		tblDesc.add(getSd_skin_colorCDesc(tblDesc));
		tblDesc.add(getSkin_color_scoreCDesc(tblDesc));
		tblDesc.add(getScore_mus_tensionCDesc(tblDesc));
		tblDesc.add(getScore_stim_resCDesc(tblDesc));
		tblDesc.add(getScore_skin_colorCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 婴儿护理记录id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_babyrecordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_babyrecord",  getId_babyrecordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿护理记录id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婴儿信息id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_babyinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_babyinfo",  getId_babyinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婴儿信息id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdiographADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idiograph",  getIdiographCDesc(tblDesc), this);
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
	private IAttrDesc getBreathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath",  getBreathCDesc(tblDesc), this);
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
	 * 总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_score",  getTotal_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_typesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_types",  getId_typesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产时类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产时类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_typesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_types",  getSd_typesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产时类别编码");
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
	private IAttrDesc getId_mus_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mus_tension",  getId_mus_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肌张力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mus_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mus_tension",  getSd_mus_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMus_tension_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mus_tension_score",  getMus_tension_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("肌张力得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 刺激反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stim_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stim_res",  getId_stim_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("刺激反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 刺激反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stim_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stim_res",  getSd_stim_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("刺激反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 刺激反应得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStim_res_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stim_res_score",  getStim_res_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("刺激反应得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤颜色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_color",  getId_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤颜色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤颜色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_color",  getSd_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤颜色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤颜色得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSkin_color_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Skin_color_score",  getSkin_color_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤颜色得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_mus_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_mus_tension",  getScore_mus_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("肌张力分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 刺激反应分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_stim_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_stim_res",  getScore_stim_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("刺激反应分数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤颜色分数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_skin_color",  getScore_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤颜色分数");
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
	 * 签名姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_idographADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_idograph",  getName_idographCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b7","idiograph=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产时类别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_typesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_types",  getName_typesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产时类别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b9","id_types=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mus_tensionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mus_tension",  getName_mus_tensionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b5","id_mus_tension=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 刺激反应名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stim_resADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stim_res",  getName_stim_resCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("刺激反应名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b6","id_stim_res=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skin_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin_color",  getName_skin_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a1b8","id_skin_color=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取婴儿护理记录id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_babyrecordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_babyrecord");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("婴儿护理记录id"); 
		return column;
	}
	/**
	 * 获取婴儿信息id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_babyinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_babyinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婴儿信息id"); 
		return column;
	}
	/**
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdiographCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idiograph");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
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
	private IColumnDesc getBreathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("总分"); 
		return column;
	}
	/**
	 * 获取产时类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_typesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_types");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产时类别"); 
		return column;
	}
	/**
	 * 获取产时类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_typesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_types");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产时类别编码"); 
		return column;
	}
	/**
	 * 获取肌张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mus_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mus_tension");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力"); 
		return column;
	}
	/**
	 * 获取肌张力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mus_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mus_tension");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力编码"); 
		return column;
	}
	/**
	 * 获取肌张力得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMus_tension_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mus_tension_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("肌张力得分"); 
		return column;
	}
	/**
	 * 获取刺激反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stim_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stim_res");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("刺激反应"); 
		return column;
	}
	/**
	 * 获取刺激反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stim_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stim_res");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("刺激反应编码"); 
		return column;
	}
	/**
	 * 获取刺激反应得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStim_res_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stim_res_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("刺激反应得分"); 
		return column;
	}
	/**
	 * 获取皮肤颜色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_color");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤颜色"); 
		return column;
	}
	/**
	 * 获取皮肤颜色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤颜色编码"); 
		return column;
	}
	/**
	 * 获取皮肤颜色得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSkin_color_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Skin_color_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤颜色得分"); 
		return column;
	}
	/**
	 * 获取肌张力分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_mus_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_mus_tension");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("肌张力分数"); 
		return column;
	}
	/**
	 * 获取刺激反应分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_stim_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_stim_res");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("刺激反应分数"); 
		return column;
	}
	/**
	 * 获取皮肤颜色分数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_skin_color");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤颜色分数"); 
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
	 * 获取签名姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_idographCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_idograph");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名姓名"); 
		return column;
	}
	/**
	 * 获取产时类别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_typesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_types");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产时类别名称"); 
		return column;
	}
	/**
	 * 获取肌张力名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mus_tensionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mus_tension");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力名称"); 
		return column;
	}
	/**
	 * 获取刺激反应名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stim_resCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stim_res");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("刺激反应名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skin_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin_color");
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
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
}
