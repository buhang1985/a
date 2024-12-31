
package iih.nmr.pkuf.healthedu.d.desc;

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
 * 健康教育计划执行单项 DO 元数据信息
 */
public class HealtheduItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.healthedu.d.HealtheduItmDO";
	public static final String CLASS_DISPALYNAME = "健康教育计划执行单项";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_HEALTHEDUITM";
	public static final String TABLE_ALIAS_NAME = "a0b10";
	public static final String PRIMARYKEY_FIELDNAME="Id_healthedu_itm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HealtheduItmDODesc(){
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
		this.setKeyDesc(getId_healthedu_itmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_healtheduADesc(tblDesc));
		this.add(getId_healthedu_itmADesc(tblDesc));
		this.add(getId_healtheduADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getDt_datetimeADesc(tblDesc));
		this.add(getId_healthedu_planADesc(tblDesc));
		this.add(getSd_healthedu_planADesc(tblDesc));
		this.add(getName_healthedu_planADesc(tblDesc));
		this.add(getId_guide_objADesc(tblDesc));
		this.add(getSd_guide_objADesc(tblDesc));
		this.add(getId_edu_wayADesc(tblDesc));
		this.add(getSd_edu_wayADesc(tblDesc));
		this.add(getId_evaluateADesc(tblDesc));
		this.add(getSd_evaluateADesc(tblDesc));
		this.add(getId_evaluate_nurseADesc(tblDesc));
		this.add(getId_health_edu_parADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getName_guide_objADesc(tblDesc));
		this.add(getName_edu_wayADesc(tblDesc));
		this.add(getName_evaluateADesc(tblDesc));
		this.add(getName_eval_nurseADesc(tblDesc));
		this.add(getName_edu_parADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_healthedu_itmCDesc(tblDesc));
		tblDesc.add(getId_healthedu_itmCDesc(tblDesc));
		tblDesc.add(getId_healtheduCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getDt_datetimeCDesc(tblDesc));
		tblDesc.add(getId_healthedu_planCDesc(tblDesc));
		tblDesc.add(getSd_healthedu_planCDesc(tblDesc));
		tblDesc.add(getName_healthedu_planCDesc(tblDesc));
		tblDesc.add(getId_guide_objCDesc(tblDesc));
		tblDesc.add(getSd_guide_objCDesc(tblDesc));
		tblDesc.add(getId_edu_wayCDesc(tblDesc));
		tblDesc.add(getSd_edu_wayCDesc(tblDesc));
		tblDesc.add(getId_evaluateCDesc(tblDesc));
		tblDesc.add(getSd_evaluateCDesc(tblDesc));
		tblDesc.add(getId_evaluate_nurseCDesc(tblDesc));
		tblDesc.add(getId_health_edu_parCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康教育项主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_healthedu_itmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_healthedu_itm",  getId_healthedu_itmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育项主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康教育属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_healtheduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_healthedu",  getId_healtheduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
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
	private IAttrDesc getDt_datetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_datetime",  getDt_datetimeCDesc(tblDesc), this);
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
	 * 健康教育计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_healthedu_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_healthedu_plan",  getId_healthedu_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康教育计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_healthedu_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_healthedu_plan",  getSd_healthedu_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康教育计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_healthedu_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_healthedu_plan",  getName_healthedu_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 指导对象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_guide_objADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_guide_obj",  getId_guide_objCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指导对象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 指导对象编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_guide_objADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_guide_obj",  getSd_guide_objCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指导对象编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_edu_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_edu_way",  getId_edu_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 教育方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_edu_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_edu_way",  getSd_edu_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评价效果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_evaluateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_evaluate",  getId_evaluateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价效果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评价效果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_evaluateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_evaluate",  getSd_evaluateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价效果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评价护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_evaluate_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_evaluate_nurse",  getId_evaluate_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 教育计划父级ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_health_edu_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_health_edu_par",  getId_health_edu_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育计划父级ID");
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
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b10b3","id_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 指导对象属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_guide_objADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_guide_obj",  getName_guide_objCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("指导对象");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10b5","id_guide_obj=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_edu_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_edu_way",  getName_edu_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10b6","id_edu_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评价效果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_evaluateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_evaluate",  getName_evaluateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价效果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10b7","id_evaluate=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评价护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eval_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eval_nurse",  getName_eval_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评价护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b10b8","id_evaluate_nurse=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育项目分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_edu_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_edu_par",  getName_edu_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育项目分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10b9","id_health_edu_par=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康教育项主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_healthedu_itmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_healthedu_itm");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康教育项主键"); 
		return column;
	}
	/**
	 * 获取健康教育表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_healtheduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_healthedu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康教育"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取日期时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_datetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_datetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期时间"); 
		return column;
	}
	/**
	 * 获取健康教育计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_healthedu_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_healthedu_plan");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康教育计划"); 
		return column;
	}
	/**
	 * 获取健康教育计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_healthedu_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_healthedu_plan");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康教育计划编码"); 
		return column;
	}
	/**
	 * 获取健康教育计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_healthedu_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_healthedu_plan");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康教育计划"); 
		return column;
	}
	/**
	 * 获取指导对象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_guide_objCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_guide_obj");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指导对象"); 
		return column;
	}
	/**
	 * 获取指导对象编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_guide_objCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_guide_obj");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指导对象编码"); 
		return column;
	}
	/**
	 * 获取教育方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_edu_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_edu_way");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育方式"); 
		return column;
	}
	/**
	 * 获取教育方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_edu_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_edu_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育方式编码"); 
		return column;
	}
	/**
	 * 获取评价效果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_evaluateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_evaluate");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价效果"); 
		return column;
	}
	/**
	 * 获取评价效果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_evaluateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_evaluate");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价效果编码"); 
		return column;
	}
	/**
	 * 获取评价护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_evaluate_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_evaluate_nurse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价护士"); 
		return column;
	}
	/**
	 * 获取教育计划父级ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_health_edu_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_health_edu_par");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育计划父级ID"); 
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
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取指导对象表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_guide_objCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_guide_obj");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("指导对象"); 
		return column;
	}
	/**
	 * 获取教育方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_edu_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_edu_way");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育方式"); 
		return column;
	}
	/**
	 * 获取评价效果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_evaluateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_evaluate");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价效果"); 
		return column;
	}
	/**
	 * 获取评价护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eval_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eval_nurse");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评价护士"); 
		return column;
	}
	/**
	 * 获取教育项目分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_edu_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_edu_par");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育项目分类"); 
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
	}
	
}
