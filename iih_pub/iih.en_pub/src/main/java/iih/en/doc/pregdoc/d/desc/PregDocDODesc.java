
package iih.en.doc.pregdoc.d.desc;

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
 * 产科建档 DO 元数据信息
 */
public class PregDocDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.doc.pregdoc.d.PregDocDO";
	public static final String CLASS_DISPALYNAME = "产科建档";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_doc_preg";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pregdoc";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PregDocDODesc(){
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
		this.setKeyDesc(getId_pregdocADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_pregdocADesc(tblDesc));
		this.add(getId_entdocADesc(tblDesc));
		this.add(getId_admdiv_husbADesc(tblDesc));
		this.add(getSd_admdiv_husbADesc(tblDesc));
		this.add(getFg_born_hereADesc(tblDesc));
		this.add(getD_last_menstADesc(tblDesc));
		this.add(getD_expectADesc(tblDesc));
		this.add(getDt_apptADesc(tblDesc));
		this.add(getId_emp_apptADesc(tblDesc));
		this.add(getDt_docADesc(tblDesc));
		this.add(getId_emp_docADesc(tblDesc));
		this.add(getEu_statusADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getDt_cancADesc(tblDesc));
		this.add(getId_emp_cancADesc(tblDesc));
		this.add(getPregdocstatADesc(tblDesc));
		this.add(getId_patcontADesc(tblDesc));
		this.add(getName_entdocADesc(tblDesc));
		this.add(getName_admdiv_husbADesc(tblDesc));
		this.add(getName_emp_apptADesc(tblDesc));
		this.add(getName_emp_docADesc(tblDesc));
		this.add(getName_emp_cancADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pregdocCDesc(tblDesc));
		tblDesc.add(getId_pregdocCDesc(tblDesc));
		tblDesc.add(getId_entdocCDesc(tblDesc));
		tblDesc.add(getId_admdiv_husbCDesc(tblDesc));
		tblDesc.add(getSd_admdiv_husbCDesc(tblDesc));
		tblDesc.add(getFg_born_hereCDesc(tblDesc));
		tblDesc.add(getD_last_menstCDesc(tblDesc));
		tblDesc.add(getD_expectCDesc(tblDesc));
		tblDesc.add(getDt_apptCDesc(tblDesc));
		tblDesc.add(getId_emp_apptCDesc(tblDesc));
		tblDesc.add(getDt_docCDesc(tblDesc));
		tblDesc.add(getId_emp_docCDesc(tblDesc));
		tblDesc.add(getEu_statusCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getDt_cancCDesc(tblDesc));
		tblDesc.add(getId_emp_cancCDesc(tblDesc));
		tblDesc.add(getPregdocstatCDesc(tblDesc));
		tblDesc.add(getId_patcontCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 产科建档主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pregdocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pregdoc",  getId_pregdocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产科建档主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 档案主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entdocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entdoc",  getId_entdocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("档案主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配偶户籍主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_admdiv_husbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_admdiv_husb",  getId_admdiv_husbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配偶户籍主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 配偶户籍编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_admdiv_husbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_admdiv_husb",  getSd_admdiv_husbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("配偶户籍编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 本院分娩属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_born_hereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_born_here",  getFg_born_hereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("本院分娩");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 末次月经日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_last_menstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_last_menst",  getD_last_menstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("末次月经日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预产期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getD_expectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("D_expect",  getD_expectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("预产期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_appt",  getDt_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("预约日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_appt",  getId_emp_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 建档日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_doc",  getDt_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("建档日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建档人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_doc",  getId_emp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建档人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 档案状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_status",  getEu_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("档案状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("完成日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_canc",  getDt_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("取消日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_canc",  getId_emp_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取消人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 产妇状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPregdocstatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pregdocstat",  getPregdocstatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("产妇状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者联系人主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcont",  getId_patcontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者联系人主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 建档描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_entdocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_entdoc",  getName_entdocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建档描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_doc a0b8","id_entdoc=id_entdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行政区划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_admdiv_husbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_admdiv_husb",  getName_admdiv_husbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行政区划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_adminarea a0b2","id_admdiv_husb=id_adminarea","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约人名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_appt",  getName_emp_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约人名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_appt=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 建档人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_docADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_doc",  getName_emp_docCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("建档人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","id_emp_doc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_canc",  getName_emp_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b9","id_emp_canc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取产科建档主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pregdocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pregdoc");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("产科建档主键"); 
		return column;
	}
	/**
	 * 获取档案主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entdocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entdoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("档案主键"); 
		return column;
	}
	/**
	 * 获取配偶户籍主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_admdiv_husbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_admdiv_husb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配偶户籍主键"); 
		return column;
	}
	/**
	 * 获取配偶户籍编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_admdiv_husbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_admdiv_husb");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("配偶户籍编码"); 
		return column;
	}
	/**
	 * 获取本院分娩表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_born_hereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_born_here");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("本院分娩"); 
		return column;
	}
	/**
	 * 获取末次月经日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_last_menstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_last_menst");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("末次月经日期"); 
		return column;
	}
	/**
	 * 获取预产期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getD_expectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"D_expect");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预产期"); 
		return column;
	}
	/**
	 * 获取预约日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_appt");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约日期"); 
		return column;
	}
	/**
	 * 获取预约人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_appt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约人"); 
		return column;
	}
	/**
	 * 获取建档日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_doc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("建档日期"); 
		return column;
	}
	/**
	 * 获取建档人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_doc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建档人"); 
		return column;
	}
	/**
	 * 获取档案状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_status");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("档案状态"); 
		return column;
	}
	/**
	 * 获取完成日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("完成日期"); 
		return column;
	}
	/**
	 * 获取取消日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_canc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取消日期"); 
		return column;
	}
	/**
	 * 获取取消人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_canc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取消人"); 
		return column;
	}
	/**
	 * 获取产妇状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPregdocstatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pregdocstat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("产妇状况"); 
		return column;
	}
	/**
	 * 获取患者联系人主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者联系人主键"); 
		return column;
	}
	/**
	 * 获取建档描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_entdocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_entdoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建档描述"); 
		return column;
	}
	/**
	 * 获取行政区划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_admdiv_husbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_admdiv_husb");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行政区划名称"); 
		return column;
	}
	/**
	 * 获取预约人名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_appt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约人名称"); 
		return column;
	}
	/**
	 * 获取建档人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_docCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_doc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("建档人姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_canc");
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
	}
	
}
