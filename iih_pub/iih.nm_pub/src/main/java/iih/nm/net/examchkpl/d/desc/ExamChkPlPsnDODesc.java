
package iih.nm.net.examchkpl.d.desc;

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
 * 考核计划参与人员 DO 元数据信息
 */
public class ExamChkPlPsnDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.net.examchkpl.d.ExamChkPlPsnDO";
	public static final String CLASS_DISPALYNAME = "考核计划参与人员";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_EXAM_CHK_PL_PSN";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_exam_chk_pl_psn";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ExamChkPlPsnDODesc(){
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
		this.setKeyDesc(getId_exam_chk_pl_psnADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_exam_chk_plADesc(tblDesc));
		this.add(getId_exam_chk_pl_psnADesc(tblDesc));
		this.add(getId_exam_chk_plADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_net_meetADesc(tblDesc));
		this.add(getFg_applyADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getJob_noADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_meetADesc(tblDesc));
		this.add(getCode_meetADesc(tblDesc));
		this.add(getDt_beginADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_exam_chk_pl_psnCDesc(tblDesc));
		tblDesc.add(getId_exam_chk_pl_psnCDesc(tblDesc));
		tblDesc.add(getId_exam_chk_plCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_net_meetCDesc(tblDesc));
		tblDesc.add(getFg_applyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 考核人员主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_exam_chk_pl_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_exam_chk_pl_psn",  getId_exam_chk_pl_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考核人员主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考核计划外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_exam_chk_plADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_exam_chk_pl",  getId_exam_chk_plCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考核计划外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
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
	 * 场次主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_net_meetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_net_meet",  getId_net_meetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("场次主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否报名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_applyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_apply",  getFg_applyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否报名");
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
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b2","id_nur=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b2","id_nur=id_nur","id_psndoc"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 工号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJob_noADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Job_no",  getJob_noCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a1b2","id_nur=id_nur","job_no"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b3","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_meetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_meet",  getName_meetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_net_meet a1b6","id_net_meet=id_net_meet","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_meetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_meet",  getCode_meetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_net_meet a1b6","id_net_meet=id_net_meet","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_begin",  getDt_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_net_meet a1b6","id_net_meet=id_net_meet","dt_begin"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_net_meet a1b6","id_net_meet=id_net_meet","dt_end"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取考核人员主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_exam_chk_pl_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_exam_chk_pl_psn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考核人员主键"); 
		return column;
	}
	/**
	 * 获取考核计划外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_exam_chk_plCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_exam_chk_pl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考核计划外键"); 
		return column;
	}
	/**
	 * 获取人员外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员外键"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
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
	 * 获取场次主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_net_meetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_net_meet");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("场次主键"); 
		return column;
	}
	/**
	 * 获取是否报名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_applyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_apply");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否报名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员id"); 
		return column;
	}
	/**
	 * 获取工号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJob_noCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Job_no");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工号"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_meetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_meet");
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
	private IColumnDesc getCode_meetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_meet");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("结束时间"); 
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
