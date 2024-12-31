
package iih.pe.pwf.pepsninfodo.d.desc;

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
 * 体检分检个人基本资料显示 DO 元数据信息
 */
public class PePsnInfoDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pwf.pepsninfodo.d.PePsnInfoDO";
	public static final String CLASS_DISPALYNAME = "体检分检个人基本资料显示";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pepsnbinfo";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PePsnInfoDODesc(){
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
		this.setKeyDesc(getId_pepsnbinfoADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getName_psnADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getId_marryADesc(tblDesc));
		this.add(getDt_birthADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getSexADesc(tblDesc));
		this.add(getSd_sex_psnADesc(tblDesc));
		this.add(getMarriedADesc(tblDesc));
		this.add(getMobiADesc(tblDesc));
		this.add(getIdcodeADesc(tblDesc));
		this.add(getPhoADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getName_setADesc(tblDesc));
		this.add(getPe_timesADesc(tblDesc));
		this.add(getCard_peADesc(tblDesc));
		this.add(getDt_peADesc(tblDesc));
		this.add(getPestatusADesc(tblDesc));
		this.add(getId_pecorpapptADesc(tblDesc));
		this.add(getPe_corp_statusADesc(tblDesc));
		this.add(getId_pecorpbinfoADesc(tblDesc));
		this.add(getName_corpADesc(tblDesc));
		this.add(getRmk_peADesc(tblDesc));
		this.add(getPe_codeADesc(tblDesc));
		this.add(getId_pediroomADesc(tblDesc));
		this.add(getRoom_curADesc(tblDesc));
		this.add(getName_roomADesc(tblDesc));
		this.add(getCode_roomADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getName_psnCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getId_marryCDesc(tblDesc));
		tblDesc.add(getDt_birthCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getSexCDesc(tblDesc));
		tblDesc.add(getSd_sex_psnCDesc(tblDesc));
		tblDesc.add(getMarriedCDesc(tblDesc));
		tblDesc.add(getMobiCDesc(tblDesc));
		tblDesc.add(getIdcodeCDesc(tblDesc));
		tblDesc.add(getPhoCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getName_setCDesc(tblDesc));
		tblDesc.add(getPe_timesCDesc(tblDesc));
		tblDesc.add(getCard_peCDesc(tblDesc));
		tblDesc.add(getDt_peCDesc(tblDesc));
		tblDesc.add(getPestatusCDesc(tblDesc));
		tblDesc.add(getId_pecorpapptCDesc(tblDesc));
		tblDesc.add(getPe_corp_statusCDesc(tblDesc));
		tblDesc.add(getId_pecorpbinfoCDesc(tblDesc));
		tblDesc.add(getName_corpCDesc(tblDesc));
		tblDesc.add(getRmk_peCDesc(tblDesc));
		tblDesc.add(getPe_codeCDesc(tblDesc));
		tblDesc.add(getId_pediroomCDesc(tblDesc));
		tblDesc.add(getRoom_curCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检客户主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnbinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnbinfo",  getId_pepsnbinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检客户主键标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
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
	private IAttrDesc getName_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn",  getName_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_marryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_marry",  getId_marryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth",  getDt_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex",  getSexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_psn",  getSd_sex_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚否属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarriedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Married",  getMarriedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚否");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mobi",  getMobiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身份证号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idcode",  getIdcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("身份证号码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 照片属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPhoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pho",  getPhoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Object);
		attrDesc.setLabel("照片");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检套餐名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_setADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_set",  getName_setCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检套餐名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_timesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_times",  getPe_timesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检流程号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_pe",  getCard_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检流程号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_pe",  getDt_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("体检时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPestatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pestatus",  getPestatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体检状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 团体预约ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecorpapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecorpappt",  getId_pecorpapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团体预约ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 团体体检状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_corp_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_corp_status",  getPe_corp_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团体体检状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检单位ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecorpbinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecorpbinfo",  getId_pecorpbinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检单位ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 团体名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_corpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_corp",  getName_corpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("团体名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检登记备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRmk_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rmk_pe",  getRmk_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检登记备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检唯一号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPe_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pe_code",  getPe_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检唯一号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检诊室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pediroomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pediroom",  getId_pediroomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检诊室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当前诊室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRoom_curADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Room_cur",  getRoom_curCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当前诊室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊间名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_roomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_room",  getName_roomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊间名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_diroom a0b2","id_pediroom=id_pediroom","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊间编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_roomADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_room",  getCode_roomCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊间编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_bd_diroom a0b2","id_pediroom=id_pediroom","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检客户主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnbinfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检客户主键标识"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取性别标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别标识"); 
		return column;
	}
	/**
	 * 获取婚姻标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_marryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_marry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻标识"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_psn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取婚否表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarriedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Married");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚否"); 
		return column;
	}
	/**
	 * 获取电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mobi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电话"); 
		return column;
	}
	/**
	 * 获取身份证号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("身份证号码"); 
		return column;
	}
	/**
	 * 获取照片表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPhoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pho");
		column.setLength(0);
        column.setSqlType(Types.BLOB);
		column.setNullable(true);
		column.setLabel("照片"); 
		return column;
	}
	/**
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取体检套餐名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_setCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_set");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检套餐名称"); 
		return column;
	}
	/**
	 * 获取体检次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_timesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_times");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检次数"); 
		return column;
	}
	/**
	 * 获取体检流程号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_pe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检流程号"); 
		return column;
	}
	/**
	 * 获取体检时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_pe");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检时间"); 
		return column;
	}
	/**
	 * 获取体检状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPestatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pestatus");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体检状态"); 
		return column;
	}
	/**
	 * 获取团体预约ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecorpapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecorpappt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团体预约ID"); 
		return column;
	}
	/**
	 * 获取团体体检状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_corp_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_corp_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团体体检状态"); 
		return column;
	}
	/**
	 * 获取体检单位ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecorpbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecorpbinfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检单位ID"); 
		return column;
	}
	/**
	 * 获取团体名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_corpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_corp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("团体名称"); 
		return column;
	}
	/**
	 * 获取体检登记备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRmk_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rmk_pe");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检登记备注"); 
		return column;
	}
	/**
	 * 获取体检唯一号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPe_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pe_code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检唯一号"); 
		return column;
	}
	/**
	 * 获取体检诊室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pediroomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pediroom");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检诊室"); 
		return column;
	}
	/**
	 * 获取当前诊室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRoom_curCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Room_cur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当前诊室"); 
		return column;
	}
	/**
	 * 获取诊间名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_roomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_room");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊间名称"); 
		return column;
	}
	/**
	 * 获取诊间编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_roomCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_room");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊间编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pepsnbinfo");
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
