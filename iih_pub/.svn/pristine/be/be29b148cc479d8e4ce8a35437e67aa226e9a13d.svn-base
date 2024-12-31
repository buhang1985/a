
package iih.pi.card.card.d.desc;

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
 * 患者就诊卡 DO 元数据信息
 */
public class PiCardDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.card.card.d.PiCardDO";
	public static final String CLASS_DISPALYNAME = "患者就诊卡";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_card";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_card";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiCardDODesc(){
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
		this.setKeyDesc(getId_cardADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_cardADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patcardtpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getInnercodeADesc(tblDesc));
		this.add(getEu_cardsuADesc(tblDesc));
		this.add(getId_emp_entryADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getFg_getADesc(tblDesc));
		this.add(getId_emp_getADesc(tblDesc));
		this.add(getDt_getADesc(tblDesc));
		this.add(getFg_cancADesc(tblDesc));
		this.add(getId_emp_cancADesc(tblDesc));
		this.add(getDt_cancADesc(tblDesc));
		this.add(getDes_cancADesc(tblDesc));
		this.add(getFg_passwordADesc(tblDesc));
		this.add(getPasswordADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_patcardtpADesc(tblDesc));
		this.add(getSd_patcardtpADesc(tblDesc));
		this.add(getName_emp_entryADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cardCDesc(tblDesc));
		tblDesc.add(getId_cardCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patcardtpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getInnercodeCDesc(tblDesc));
		tblDesc.add(getEu_cardsuCDesc(tblDesc));
		tblDesc.add(getId_emp_entryCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getFg_getCDesc(tblDesc));
		tblDesc.add(getId_emp_getCDesc(tblDesc));
		tblDesc.add(getDt_getCDesc(tblDesc));
		tblDesc.add(getFg_cancCDesc(tblDesc));
		tblDesc.add(getId_emp_cancCDesc(tblDesc));
		tblDesc.add(getDt_cancCDesc(tblDesc));
		tblDesc.add(getDes_cancCDesc(tblDesc));
		tblDesc.add(getFg_passwordCDesc(tblDesc));
		tblDesc.add(getPasswordCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 就诊卡主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card",  getId_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊卡主键");
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
	 * 机构属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("机构");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊卡类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcardtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcardtp",  getId_patcardtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊卡类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊卡编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊卡编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊卡物理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInnercodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Innercode",  getInnercodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊卡物理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊卡状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_cardsuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cardsu",  getEu_cardsuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("就诊卡状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 录入人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_entry",  getId_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 录入时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("录入时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 领出标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_getADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_get",  getFg_getCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("领出标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 当前领用人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_getADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_get",  getId_emp_getCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前领用人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前领用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_getADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_get",  getDt_getCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("当前领用时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注销标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_canc",  getFg_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("注销标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注销人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_canc",  getId_emp_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注销人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 注销时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_canc",  getDt_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("注销时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 注销原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_canc",  getDes_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("注销原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡密标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_passwordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_password",  getFg_passwordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("卡密标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 密码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPasswordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Password",  getPasswordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("密码");
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
	 * 患者卡类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patcardtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_patcardtp",  getName_patcardtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_cardtp a0b2","id_patcardtp=id_cardtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者卡类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patcardtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_patcardtp",  getSd_patcardtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_cardtp a0b2","id_patcardtp=id_cardtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_entry",  getName_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_entry=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取就诊卡主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("就诊卡主键"); 
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
	 * 获取机构表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("机构"); 
		return column;
	}
	/**
	 * 获取就诊卡类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcardtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcardtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊卡类型"); 
		return column;
	}
	/**
	 * 获取就诊卡编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊卡编号"); 
		return column;
	}
	/**
	 * 获取就诊卡物理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInnercodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Innercode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊卡物理编码"); 
		return column;
	}
	/**
	 * 获取就诊卡状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cardsuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cardsu");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("就诊卡状态"); 
		return column;
	}
	/**
	 * 获取录入人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_entry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入人"); 
		return column;
	}
	/**
	 * 获取录入时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("录入时间"); 
		return column;
	}
	/**
	 * 获取领出标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_getCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_get");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("领出标志"); 
		return column;
	}
	/**
	 * 获取当前领用人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_getCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_get");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前领用人"); 
		return column;
	}
	/**
	 * 获取当前领用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_getCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_get");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("当前领用时间"); 
		return column;
	}
	/**
	 * 获取注销标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_canc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("注销标志"); 
		return column;
	}
	/**
	 * 获取注销人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_canc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注销人"); 
		return column;
	}
	/**
	 * 获取注销时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_canc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("注销时间"); 
		return column;
	}
	/**
	 * 获取注销原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_canc");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("注销原因"); 
		return column;
	}
	/**
	 * 获取卡密标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_passwordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_password");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("卡密标志"); 
		return column;
	}
	/**
	 * 获取密码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPasswordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Password");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("密码"); 
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
	 * 获取患者卡类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patcardtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_patcardtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡类型名称"); 
		return column;
	}
	/**
	 * 获取患者卡类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patcardtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_patcardtp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡类型编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_entry");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_card");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
