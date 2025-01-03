
package iih.en.pv.entplan.d.desc;

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
 * 就诊医保计划 DO 元数据信息
 */
public class EntHpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.pv.entplan.d.EntHpDO";
	public static final String CLASS_DISPALYNAME = "就诊医保计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_ent_hp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_enthp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EntHpDODesc(){
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
		this.setKeyDesc(getId_enthpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_enthpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getNo_hpADesc(tblDesc));
		this.add(getFg_majADesc(tblDesc));
		this.add(getFg_fundpayADesc(tblDesc));
		this.add(getFg_hp_cardADesc(tblDesc));
		this.add(getId_hpkindADesc(tblDesc));
		this.add(getFg_hpspclADesc(tblDesc));
		this.add(getCode_hpkindADesc(tblDesc));
		this.add(getId_hppatcaADesc(tblDesc));
		this.add(getCode_hppatcaADesc(tblDesc));
		this.add(getCode_hpareaADesc(tblDesc));
		this.add(getPersonnoADesc(tblDesc));
		this.add(getCode_hpmedkindADesc(tblDesc));
		this.add(getName_hpADesc(tblDesc));
		this.add(getCode_hpADesc(tblDesc));
		this.add(getName_hpkindADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_enthpCDesc(tblDesc));
		tblDesc.add(getId_enthpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getNo_hpCDesc(tblDesc));
		tblDesc.add(getFg_majCDesc(tblDesc));
		tblDesc.add(getFg_fundpayCDesc(tblDesc));
		tblDesc.add(getFg_hp_cardCDesc(tblDesc));
		tblDesc.add(getId_hpkindCDesc(tblDesc));
		tblDesc.add(getFg_hpspclCDesc(tblDesc));
		tblDesc.add(getCode_hpkindCDesc(tblDesc));
		tblDesc.add(getId_hppatcaCDesc(tblDesc));
		tblDesc.add(getCode_hppatcaCDesc(tblDesc));
		tblDesc.add(getCode_hpareaCDesc(tblDesc));
		tblDesc.add(getPersonnoCDesc(tblDesc));
		tblDesc.add(getCode_hpmedkindCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者就诊医保计划主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enthpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enthp",  getId_enthpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊医保计划主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保卡号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_hp",  getNo_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保卡号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主医保计划标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_majADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_maj",  getFg_majCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("主医保计划标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保基金支付标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_fundpayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_fundpay",  getFg_fundpayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医保基金支付标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否持卡结算属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hp_cardADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hp_card",  getFg_hp_cardCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否持卡结算");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 险种属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hpkind",  getId_hpkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("险种");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特病标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hpspclADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hpspcl",  getFg_hpspclCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("特病标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 险种编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hpkind",  getCode_hpkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("险种编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保身份id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hppatca",  getId_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保身份id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保身份编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hppatcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hppatca",  getCode_hppatcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保身份编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保统筹地区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpareaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hparea",  getCode_hpareaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保统筹地区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPersonnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Personno",  getPersonnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpmedkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hpmedkind",  getCode_hpmedkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hp",  getName_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b3","id_hp=id_hp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hp",  getCode_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a0b3","id_hp=id_hp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 险种名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hpkindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hpkind",  getName_hpkindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("险种名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"BD_HP_KIND a0b4","id_hpkind=id_hpkind","name_hpkind"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者就诊医保计划主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enthpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enthp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者就诊医保计划主键"); 
		return column;
	}
	/**
	 * 获取患者就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊"); 
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
	 * 获取医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划"); 
		return column;
	}
	/**
	 * 获取医保卡号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_hp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保卡号"); 
		return column;
	}
	/**
	 * 获取主医保计划标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_majCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_maj");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("主医保计划标志"); 
		return column;
	}
	/**
	 * 获取医保基金支付标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_fundpayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_fundpay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保基金支付标志"); 
		return column;
	}
	/**
	 * 获取是否持卡结算表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hp_cardCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hp_card");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否持卡结算"); 
		return column;
	}
	/**
	 * 获取险种表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hpkind");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("险种"); 
		return column;
	}
	/**
	 * 获取特病标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hpspclCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hpspcl");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("特病标识"); 
		return column;
	}
	/**
	 * 获取险种编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hpkind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("险种编码"); 
		return column;
	}
	/**
	 * 获取医保身份id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hppatca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保身份id"); 
		return column;
	}
	/**
	 * 获取医保身份编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hppatcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hppatca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保身份编码"); 
		return column;
	}
	/**
	 * 获取医保统筹地区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpareaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hparea");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保统筹地区"); 
		return column;
	}
	/**
	 * 获取个人编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPersonnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Personno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人编号"); 
		return column;
	}
	/**
	 * 获取医疗类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpmedkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hpmedkind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗类别"); 
		return column;
	}
	/**
	 * 获取医保计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划名称"); 
		return column;
	}
	/**
	 * 获取医保计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划编码"); 
		return column;
	}
	/**
	 * 获取险种名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hpkindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hpkind");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("险种名称"); 
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
		defaultValueMap.put("Fg_hp_card",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
