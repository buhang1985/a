
package iih.mp.orm.surgappconfirm.d.desc;

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
 * 手术用品确认 DO 元数据信息
 */
public class SurgImConfDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.orm.surgappconfirm.d.SurgImConfDO";
	public static final String CLASS_DISPALYNAME = "手术用品确认";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mp_orm_sug_im";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_apopimcf";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public SurgImConfDODesc(){
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
		this.setKeyDesc(getId_apopimcfADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_apopcfADesc(tblDesc));
		this.add(getId_apopimcfADesc(tblDesc));
		this.add(getId_apopcfADesc(tblDesc));
		this.add(getId_mmomADesc(tblDesc));
		this.add(getId_omcaADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getQuan_curADesc(tblDesc));
		this.add(getFg_prclnADesc(tblDesc));
		this.add(getId_emp_prADesc(tblDesc));
		this.add(getDt_prclnADesc(tblDesc));
		this.add(getQuan_prADesc(tblDesc));
		this.add(getFg_afclnADesc(tblDesc));
		this.add(getId_emp_afADesc(tblDesc));
		this.add(getDt_afclnADesc(tblDesc));
		this.add(getQuan_afADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getInstrument_codeADesc(tblDesc));
		this.add(getInstrument_nameADesc(tblDesc));
		this.add(getInstrument_specADesc(tblDesc));
		this.add(getInstrumentca_codeADesc(tblDesc));
		this.add(getInstrumentca_nameADesc(tblDesc));
		this.add(getSrv_codeADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getEmp_pr_codeADesc(tblDesc));
		this.add(getEmp_pr_nameADesc(tblDesc));
		this.add(getEmp_af_codeADesc(tblDesc));
		this.add(getEmp_af_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_apopimcfCDesc(tblDesc));
		tblDesc.add(getId_apopimcfCDesc(tblDesc));
		tblDesc.add(getId_apopcfCDesc(tblDesc));
		tblDesc.add(getId_mmomCDesc(tblDesc));
		tblDesc.add(getId_omcaCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getQuan_curCDesc(tblDesc));
		tblDesc.add(getFg_prclnCDesc(tblDesc));
		tblDesc.add(getId_emp_prCDesc(tblDesc));
		tblDesc.add(getDt_prclnCDesc(tblDesc));
		tblDesc.add(getQuan_prCDesc(tblDesc));
		tblDesc.add(getFg_afclnCDesc(tblDesc));
		tblDesc.add(getId_emp_afCDesc(tblDesc));
		tblDesc.add(getDt_afclnCDesc(tblDesc));
		tblDesc.add(getQuan_afCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 手术用品确认主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apopimcfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apopimcf",  getId_apopimcfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品确认主键标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术申请单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apopcfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apopcf",  getId_apopcfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术申请单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术用品属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mmomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mmom",  getId_mmomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术用品分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_omcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_omca",  getId_omcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊疗项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_cur",  getQuan_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前清点标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prclnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prcln",  getFg_prclnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("术前清点标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前清点人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_prADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_pr",  getId_emp_prCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前清点人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 清点时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_prclnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_prcln",  getDt_prclnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("清点时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前清点数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_prADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_pr",  getQuan_prCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前清点数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后清点标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_afclnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_afcln",  getFg_afclnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("术后清点标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后清点人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_afADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_af",  getId_emp_afCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后清点人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后清点时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_afclnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_afcln",  getDt_afclnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("术后清点时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后清点数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_afADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_af",  getQuan_afCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后清点数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术用品物品编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstrument_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Instrument_code",  getInstrument_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品物品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_orm_mm a4b2","id_mmom=id_mmom","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术用品物品名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstrument_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Instrument_name",  getInstrument_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_orm_mm a4b2","id_mmom=id_mmom","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术用品物品规格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstrument_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Instrument_spec",  getInstrument_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品物品规格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"mp_orm_mm a4b2","id_mmom=id_mmom","spec"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术用品分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstrumentca_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Instrumentca_code",  getInstrumentca_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"MP_ORM_MMCA a4b3","id_omca=id_omca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术用品分类名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInstrumentca_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Instrumentca_name",  getInstrumentca_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术用品分类名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"MP_ORM_MMCA a4b3","id_omca=id_omca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_code",  getSrv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a4b7","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a4b7","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前清点人人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_pr_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_pr_code",  getEmp_pr_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前清点人人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a4b4","id_emp_pr=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前清点人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_pr_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_pr_name",  getEmp_pr_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前清点人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a4b4","id_emp_pr=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后清点人人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_af_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_af_code",  getEmp_af_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后清点人人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a4b5","id_emp_af=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后清点人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmp_af_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_af_name",  getEmp_af_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后清点人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a4b5","id_emp_af=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取手术用品确认主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apopimcfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apopimcf");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品确认主键标识"); 
		return column;
	}
	/**
	 * 获取手术申请单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apopcfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apopcf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术申请单ID"); 
		return column;
	}
	/**
	 * 获取手术用品表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mmomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mmom");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品"); 
		return column;
	}
	/**
	 * 获取手术用品分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_omcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_omca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品分类"); 
		return column;
	}
	/**
	 * 获取诊疗项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗项目"); 
		return column;
	}
	/**
	 * 获取数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_cur");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("数量"); 
		return column;
	}
	/**
	 * 获取术前清点标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prclnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prcln");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术前清点标志"); 
		return column;
	}
	/**
	 * 获取术前清点人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_prCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_pr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前清点人"); 
		return column;
	}
	/**
	 * 获取清点时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_prclnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_prcln");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("清点时间"); 
		return column;
	}
	/**
	 * 获取术前清点数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_prCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_pr");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前清点数量"); 
		return column;
	}
	/**
	 * 获取术后清点标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_afclnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_afcln");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术后清点标志"); 
		return column;
	}
	/**
	 * 获取术后清点人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_afCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_af");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后清点人"); 
		return column;
	}
	/**
	 * 获取术后清点时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_afclnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_afcln");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术后清点时间"); 
		return column;
	}
	/**
	 * 获取术后清点数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_afCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_af");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后清点数量"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取手术用品物品编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstrument_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Instrument_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品物品编码"); 
		return column;
	}
	/**
	 * 获取手术用品物品名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstrument_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Instrument_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品物品名称"); 
		return column;
	}
	/**
	 * 获取手术用品物品规格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstrument_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Instrument_spec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品物品规格"); 
		return column;
	}
	/**
	 * 获取手术用品分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstrumentca_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Instrumentca_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品分类编码"); 
		return column;
	}
	/**
	 * 获取手术用品分类名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInstrumentca_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Instrumentca_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术用品分类名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_code");
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
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取术前清点人人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_pr_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_pr_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前清点人人员编码"); 
		return column;
	}
	/**
	 * 获取术前清点人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_pr_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_pr_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前清点人姓名"); 
		return column;
	}
	/**
	 * 获取术后清点人人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_af_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_af_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后清点人人员编码"); 
		return column;
	}
	/**
	 * 获取术后清点人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_af_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_af_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后清点人姓名"); 
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
