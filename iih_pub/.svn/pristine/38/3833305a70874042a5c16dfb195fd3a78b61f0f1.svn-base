
package iih.pe.por.pecoupon.d.desc;

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
 * 体检卷项目 DO 元数据信息
 */
public class PeCouponCatlogDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.por.pecoupon.d.PeCouponCatlogDO";
	public static final String CLASS_DISPALYNAME = "体检卷项目";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_or_pecouponcatlog";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_pecouponcatlog";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeCouponCatlogDODesc(){
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
		this.setKeyDesc(getId_pecouponcatlogADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_pecouponADesc(tblDesc));
		this.add(getId_pecouponcatlogADesc(tblDesc));
		this.add(getId_pesrvbcatlogADesc(tblDesc));
		this.add(getId_pecouponADesc(tblDesc));
		this.add(getPriADesc(tblDesc));
		this.add(getQtyADesc(tblDesc));
		this.add(getCode_catlogADesc(tblDesc));
		this.add(getName_catlogADesc(tblDesc));
		this.add(getPrice_catlogADesc(tblDesc));
		this.add(getMax_discountADesc(tblDesc));
		this.add(getSexlimitADesc(tblDesc));
		this.add(getFg_enfantADesc(tblDesc));
		this.add(getFg_pregnentADesc(tblDesc));
		this.add(getFg_marriedADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pecouponcatlogCDesc(tblDesc));
		tblDesc.add(getId_pecouponcatlogCDesc(tblDesc));
		tblDesc.add(getId_pesrvbcatlogCDesc(tblDesc));
		tblDesc.add(getId_pecouponCDesc(tblDesc));
		tblDesc.add(getPriCDesc(tblDesc));
		tblDesc.add(getQtyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检卷项目主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecouponcatlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecouponcatlog",  getId_pecouponcatlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检卷项目主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检项目ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesrvbcatlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesrvbcatlog",  getId_pesrvbcatlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检项目ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检卷ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pecouponADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pecoupon",  getId_pecouponCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检卷ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPriADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pri",  getPriCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQtyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Qty",  getQtyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("数量");
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
	private IAttrDesc getCode_catlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_catlog",  getCode_catlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_catlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_catlog",  getName_catlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基础价格属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPrice_catlogADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Price_catlog",  getPrice_catlogCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("基础价格");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","price"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最大折扣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMax_discountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Max_discount",  getMax_discountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("最大折扣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","max_discount"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别适用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexlimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sexlimit",  getSexlimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("性别适用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","sexlimit"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 儿童禁用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_enfantADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_enfant",  getFg_enfantCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("儿童禁用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","fg_enfant"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 孕妇禁用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pregnentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pregnent",  getFg_pregnentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("孕妇禁用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","fg_pregnent"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 未婚禁用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_marriedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_married",  getFg_marriedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("未婚禁用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_itm_pesrvbcatlog a1b2","id_pesrvbcatlog=id_pesrvbcatlog","fg_married"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检卷项目主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecouponcatlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecouponcatlog");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检卷项目主键标识"); 
		return column;
	}
	/**
	 * 获取体检项目ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesrvbcatlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesrvbcatlog");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检项目ID"); 
		return column;
	}
	/**
	 * 获取体检卷ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pecouponCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pecoupon");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检卷ID"); 
		return column;
	}
	/**
	 * 获取价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPriCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pri");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("价格"); 
		return column;
	}
	/**
	 * 获取数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQtyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Qty");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("数量"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_catlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_catlog");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_catlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_catlog");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取基础价格表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPrice_catlogCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Price_catlog");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("基础价格"); 
		return column;
	}
	/**
	 * 获取最大折扣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMax_discountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Max_discount");
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("最大折扣"); 
		return column;
	}
	/**
	 * 获取性别适用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexlimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sexlimit");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("性别适用"); 
		return column;
	}
	/**
	 * 获取儿童禁用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_enfantCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_enfant");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("儿童禁用"); 
		return column;
	}
	/**
	 * 获取孕妇禁用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pregnentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pregnent");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("孕妇禁用"); 
		return column;
	}
	/**
	 * 获取未婚禁用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_marriedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_married");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("未婚禁用"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pecouponcatlog");
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
