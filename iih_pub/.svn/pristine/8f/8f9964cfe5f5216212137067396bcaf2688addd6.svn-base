
package iih.en.pv.enres.d.desc;

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
 * 患者授权 DO 元数据信息
 */
public class EnAuthDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.pv.enres.d.EnAuthDO";
	public static final String CLASS_DISPALYNAME = "患者授权";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "EN_ENT_AUTH";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_entauth";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnAuthDODesc(){
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
		this.setKeyDesc(getId_entauthADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_entauthADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_dep_fromADesc(tblDesc));
		this.add(getId_emp_fromADesc(tblDesc));
		this.add(getId_dep_toADesc(tblDesc));
		this.add(getId_emp_toADesc(tblDesc));
		this.add(getDt_beginADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getReasonADesc(tblDesc));
		this.add(getId_emp_endADesc(tblDesc));
		this.add(getCode_dep_fromADesc(tblDesc));
		this.add(getName_dep_fromADesc(tblDesc));
		this.add(getCode_emp_fromADesc(tblDesc));
		this.add(getName_emp_fromADesc(tblDesc));
		this.add(getCode_dep_tpADesc(tblDesc));
		this.add(getName_dep_toADesc(tblDesc));
		this.add(getCode_emp_toADesc(tblDesc));
		this.add(getName_emp_toADesc(tblDesc));
		this.add(getCode_emp_endADesc(tblDesc));
		this.add(getName_emp_endADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_entauthCDesc(tblDesc));
		tblDesc.add(getId_entauthCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_dep_fromCDesc(tblDesc));
		tblDesc.add(getId_emp_fromCDesc(tblDesc));
		tblDesc.add(getId_dep_toCDesc(tblDesc));
		tblDesc.add(getId_emp_toCDesc(tblDesc));
		tblDesc.add(getDt_beginCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getReasonCDesc(tblDesc));
		tblDesc.add(getId_emp_endCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者授权id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entauthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entauth",  getId_entauthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者授权id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_from",  getId_dep_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_from",  getId_emp_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 目标科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_to",  getId_dep_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 目标医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_to",  getId_emp_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 截止时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("截止时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 授权原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reason",  getReasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("授权原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停止医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_end",  getId_emp_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("停止医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_from",  getCode_dep_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b2","id_dep_from=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_from",  getName_dep_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b2","id_dep_from=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emp_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp_from",  getCode_emp_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_from=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_fromADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_from",  getName_emp_fromCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_from=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_dep_tpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_dep_tp",  getCode_dep_tpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b4","id_dep_to=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_to",  getName_dep_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b4","id_dep_to=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emp_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp_to",  getCode_emp_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_to=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 目标科室姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_toADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_to",  getName_emp_toCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("目标科室姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_to=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停止医生编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emp_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp_end",  getCode_emp_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("停止医生编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_end=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 停止医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_end",  getName_emp_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("停止医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_end=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者授权id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entauthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entauth");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者授权id"); 
		return column;
	}
	/**
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取患者科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_from");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者科室"); 
		return column;
	}
	/**
	 * 获取患者医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_from");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者医生"); 
		return column;
	}
	/**
	 * 获取目标科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_to");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标科室"); 
		return column;
	}
	/**
	 * 获取目标医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_to");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标医生"); 
		return column;
	}
	/**
	 * 获取开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始时间"); 
		return column;
	}
	/**
	 * 获取截止时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("截止时间"); 
		return column;
	}
	/**
	 * 获取授权原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("授权原因"); 
		return column;
	}
	/**
	 * 获取停止医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_end");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("停止医生"); 
		return column;
	}
	/**
	 * 获取患者科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_from");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者科室编码"); 
		return column;
	}
	/**
	 * 获取患者科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_from");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者科室名称"); 
		return column;
	}
	/**
	 * 获取患者医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emp_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp_from");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者医生编码"); 
		return column;
	}
	/**
	 * 获取患者医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_fromCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_from");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者医生姓名"); 
		return column;
	}
	/**
	 * 获取目标科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_dep_tpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_dep_tp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标科室编码"); 
		return column;
	}
	/**
	 * 获取目标科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_to");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标科室名称"); 
		return column;
	}
	/**
	 * 获取目标科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emp_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp_to");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标科室编码"); 
		return column;
	}
	/**
	 * 获取目标科室姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_toCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_to");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("目标科室姓名"); 
		return column;
	}
	/**
	 * 获取停止医生编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emp_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp_end");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("停止医生编码"); 
		return column;
	}
	/**
	 * 获取停止医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_end");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("停止医生姓名"); 
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
