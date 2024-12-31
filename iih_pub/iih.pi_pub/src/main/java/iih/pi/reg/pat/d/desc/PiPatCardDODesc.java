
package iih.pi.reg.pat.d.desc;

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
 * 患者卡信息 DO 元数据信息
 */
public class PiPatCardDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.reg.pat.d.PiPatCardDO";
	public static final String CLASS_DISPALYNAME = "患者卡信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_card";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_patcard";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatCardDODesc(){
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
		this.setKeyDesc(getId_patcardADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_patcardADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getSd_patcardtpADesc(tblDesc));
		this.add(getId_patcardtpADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getFg_defADesc(tblDesc));
		this.add(getId_cardADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
		this.add(getFg_actADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getCard_srcADesc(tblDesc));
		this.add(getEu_cardcgmdADesc(tblDesc));
		this.add(getPatcardtp_codeADesc(tblDesc));
		this.add(getPatcardtp_nameADesc(tblDesc));
		this.add(getSd_patcardtp_udiADesc(tblDesc));
		this.add(getCard_codeADesc(tblDesc));
		this.add(getEu_cardsuADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_patcardCDesc(tblDesc));
		tblDesc.add(getId_patcardCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getSd_patcardtpCDesc(tblDesc));
		tblDesc.add(getId_patcardtpCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getFg_defCDesc(tblDesc));
		tblDesc.add(getId_cardCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		tblDesc.add(getFg_actCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getCard_srcCDesc(tblDesc));
		tblDesc.add(getEu_cardcgmdCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者卡ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcard",  getId_patcardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者卡类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcardtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcardtp",  getId_patcardtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者卡编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 默认标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_defADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_def",  getFg_defCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("默认标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊卡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_card",  getId_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊卡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有效开始日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_b",  getDt_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("有效开始日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效结束日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e",  getDt_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("有效结束日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_act",  getFg_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡来源属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_srcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_src",  getCard_srcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("卡来源");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卡费记账方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_cardcgmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cardcgmd",  getEu_cardcgmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卡费记账方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者卡类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatcardtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patcardtp_code",  getPatcardtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_cardtp a3b1","id_patcardtp=id_cardtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者卡类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPatcardtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Patcardtp_name",  getPatcardtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_cardtp a3b1","id_patcardtp=id_cardtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者卡类型性质编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patcardtp_udiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_patcardtp_udi",  getSd_patcardtp_udiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者卡类型性质编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat_cardtp a3b1","id_patcardtp=id_cardtp","sd_patcardtp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊卡编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCard_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Card_code",  getCard_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊卡编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_card a3b3","id_card=id_card","code"});
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
		attrDesc.setRefTblInfos(new String[]{"pi_card a3b3","id_card=id_card","eu_cardsu"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者卡ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcard");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者卡ID"); 
		return column;
	}
	/**
	 * 获取患者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者"); 
		return column;
	}
	/**
	 * 获取患者卡类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patcardtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_patcardtp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡类型编码"); 
		return column;
	}
	/**
	 * 获取患者卡类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcardtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcardtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡类型"); 
		return column;
	}
	/**
	 * 获取患者卡编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡编号"); 
		return column;
	}
	/**
	 * 获取默认标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_defCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_def");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认标志"); 
		return column;
	}
	/**
	 * 获取就诊卡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_card");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊卡"); 
		return column;
	}
	/**
	 * 获取有效开始日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效开始日期"); 
		return column;
	}
	/**
	 * 获取有效结束日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效结束日期"); 
		return column;
	}
	/**
	 * 获取使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_act");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("使用标志"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取卡来源表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_srcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_src");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("卡来源"); 
		return column;
	}
	/**
	 * 获取卡费记账方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cardcgmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cardcgmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卡费记账方式"); 
		return column;
	}
	/**
	 * 获取患者卡类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatcardtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patcardtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡类型编码"); 
		return column;
	}
	/**
	 * 获取患者卡类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPatcardtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Patcardtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡类型名称"); 
		return column;
	}
	/**
	 * 获取患者卡类型性质编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patcardtp_udiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_patcardtp_udi");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者卡类型性质编码"); 
		return column;
	}
	/**
	 * 获取就诊卡编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCard_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Card_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊卡编号"); 
		return column;
	}
	/**
	 * 获取就诊卡状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cardsuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cardsu");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("就诊卡状态"); 
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
