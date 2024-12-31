
package iih.bd.fc.entpwfmr.d.desc;

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
 * 医疗记录计划 DO 元数据信息
 */
public class BdEntpWfMrDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.fc.entpwfmr.d.BdEntpWfMrDO";
	public static final String CLASS_DISPALYNAME = "医疗记录计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_entp_wf_mr";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_entpwfmr";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BdEntpWfMrDODesc(){
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
		this.setKeyDesc(getId_entpwfmrADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_entpwfmrADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entp_wfADesc(tblDesc));
		this.add(getId_mrtplADesc(tblDesc));
		this.add(getSd_reqrtimeADesc(tblDesc));
		this.add(getId_reqrtimeADesc(tblDesc));
		this.add(getReqrtiemADesc(tblDesc));
		this.add(getReqr_duraADesc(tblDesc));
		this.add(getEr_recuremrADesc(tblDesc));
		this.add(getSd_frequnitADesc(tblDesc));
		this.add(getId_frequnitADesc(tblDesc));
		this.add(getFreqcnADesc(tblDesc));
		this.add(getConti_strADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getEntpwf_codeADesc(tblDesc));
		this.add(getEntpwf_nameADesc(tblDesc));
		this.add(getMrtpl_codeADesc(tblDesc));
		this.add(getMrtpl_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_entpwfmrCDesc(tblDesc));
		tblDesc.add(getId_entpwfmrCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entp_wfCDesc(tblDesc));
		tblDesc.add(getId_mrtplCDesc(tblDesc));
		tblDesc.add(getSd_reqrtimeCDesc(tblDesc));
		tblDesc.add(getId_reqrtimeCDesc(tblDesc));
		tblDesc.add(getReqrtiemCDesc(tblDesc));
		tblDesc.add(getReqr_duraCDesc(tblDesc));
		tblDesc.add(getEr_recuremrCDesc(tblDesc));
		tblDesc.add(getSd_frequnitCDesc(tblDesc));
		tblDesc.add(getId_frequnitCDesc(tblDesc));
		tblDesc.add(getFreqcnCDesc(tblDesc));
		tblDesc.add(getConti_strCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 就诊类型流程下医疗记录计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entpwfmrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entpwfmr",  getId_entpwfmrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型流程下医疗记录计划");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型流程主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entp_wfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entp_wf",  getId_entp_wfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型流程主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtpl",  getId_mrtplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 完成时间要求类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reqrtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reqrtime",  getSd_reqrtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("完成时间要求类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成时间要求类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reqrtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reqrtime",  getId_reqrtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("完成时间要求类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成时间要求间隔开始数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReqrtiemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reqrtiem",  getReqrtiemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("完成时间要求间隔开始数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成时间要求间隔数期间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReqr_duraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reqr_dura",  getReqr_duraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("完成时间要求间隔数期间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录执行周期方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEr_recuremrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Er_recuremr",  getEr_recuremrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医疗记录执行周期方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周期频率_单位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_frequnitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_frequnit",  getSd_frequnitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("周期频率_单位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周期频率_单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_frequnitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_frequnit",  getId_frequnitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("周期频率_单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周期频率_次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFreqcnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Freqcn",  getFreqcnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("周期频率_次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 触发条件范式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getConti_strADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Conti_str",  getConti_strCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("触发条件范式");
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
	 * 流程编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntpwf_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entpwf_code",  getEntpwf_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流程编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp_wf a0b3","id_entp_wf=id_entpwf","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEntpwf_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Entpwf_name",  getEntpwf_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流程名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp_wf a0b3","id_entp_wf=id_entpwf","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtpl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtpl_code",  getMrtpl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b4","id_mrtpl=id_mrtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtpl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtpl_name",  getMrtpl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b4","id_mrtpl=id_mrtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取就诊类型流程下医疗记录计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entpwfmrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entpwfmr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型流程下医疗记录计划"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取就诊类型流程主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entp_wfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entp_wf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型流程主键"); 
		return column;
	}
	/**
	 * 获取医疗记录模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板"); 
		return column;
	}
	/**
	 * 获取完成时间要求类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reqrtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reqrtime");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("完成时间要求类型编码"); 
		return column;
	}
	/**
	 * 获取完成时间要求类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reqrtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reqrtime");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("完成时间要求类型"); 
		return column;
	}
	/**
	 * 获取完成时间要求间隔开始数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReqrtiemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reqrtiem");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("完成时间要求间隔开始数"); 
		return column;
	}
	/**
	 * 获取完成时间要求间隔数期间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReqr_duraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reqr_dura");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("完成时间要求间隔数期间"); 
		return column;
	}
	/**
	 * 获取医疗记录执行周期方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEr_recuremrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Er_recuremr");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医疗记录执行周期方式"); 
		return column;
	}
	/**
	 * 获取周期频率_单位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_frequnitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_frequnit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("周期频率_单位编码"); 
		return column;
	}
	/**
	 * 获取周期频率_单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_frequnitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_frequnit");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("周期频率_单位"); 
		return column;
	}
	/**
	 * 获取周期频率_次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFreqcnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Freqcn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("周期频率_次数"); 
		return column;
	}
	/**
	 * 获取触发条件范式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getConti_strCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Conti_str");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("触发条件范式"); 
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
	 * 获取流程编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntpwf_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entpwf_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流程编码"); 
		return column;
	}
	/**
	 * 获取流程名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEntpwf_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Entpwf_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流程名称"); 
		return column;
	}
	/**
	 * 获取医疗记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtpl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtpl_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtpl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtpl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型名称"); 
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
