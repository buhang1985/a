
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
 * 患者医保计划 DO 元数据信息
 */
public class PiPatHpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pi.reg.pat.d.PiPatHpDO";
	public static final String CLASS_DISPALYNAME = "患者医保计划";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pi_pat_hp";
	public static final String TABLE_ALIAS_NAME = "a4";
	public static final String PRIMARYKEY_FIELDNAME="Id_pathp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PiPatHpDODesc(){
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
		this.setKeyDesc(getId_pathpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_patADesc(tblDesc));
		this.add(getId_pathpADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getNo_hpADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getFg_deftADesc(tblDesc));
		this.add(getMode_hpADesc(tblDesc));
		this.add(getDt_bADesc(tblDesc));
		this.add(getDt_eADesc(tblDesc));
		this.add(getFg_actADesc(tblDesc));
		this.add(getHp_codeADesc(tblDesc));
		this.add(getHp_nameADesc(tblDesc));
		this.add(getFg_reqhpcodeADesc(tblDesc));
		this.add(getModehp_codeADesc(tblDesc));
		this.add(getModehp_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pathpCDesc(tblDesc));
		tblDesc.add(getId_pathpCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getNo_hpCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getFg_deftCDesc(tblDesc));
		tblDesc.add(getMode_hpCDesc(tblDesc));
		tblDesc.add(getDt_bCDesc(tblDesc));
		tblDesc.add(getDt_eCDesc(tblDesc));
		tblDesc.add(getFg_actCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 患者医保计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pathpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pathp",  getId_pathpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者医保计划ID");
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
	 * 医保证件号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_hp",  getNo_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保证件号码");
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
	 * 默认标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_deftADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_deft",  getFg_deftCDesc(tblDesc), this);
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
	 * 医保计划有效方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMode_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mode_hp",  getMode_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划有效方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 有效日期开始属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_b",  getDt_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("有效日期开始");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 有效日期结束属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_e",  getDt_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("有效日期结束");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_act",  getFg_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_code",  getHp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a4b1","id_hp=id_hp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hp_name",  getHp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a4b1","id_hp=id_hp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保号码必填标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_reqhpcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_reqhpcode",  getFg_reqhpcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医保号码必填标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_hp a4b1","id_hp=id_hp","fg_reqhpcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModehp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modehp_code",  getModehp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a4b2","mode_hp=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModehp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modehp_name",  getModehp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a4b2","mode_hp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取患者医保计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pathpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pathp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者医保计划ID"); 
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
	 * 获取医保证件号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_hp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保证件号码"); 
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
	 * 获取默认标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_deftCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_deft");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("默认标志"); 
		return column;
	}
	/**
	 * 获取医保计划有效方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMode_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mode_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划有效方式"); 
		return column;
	}
	/**
	 * 获取有效日期开始表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_b");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效日期开始"); 
		return column;
	}
	/**
	 * 获取有效日期结束表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_e");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("有效日期结束"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_act");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
		return column;
	}
	/**
	 * 获取医保计划编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划编码"); 
		return column;
	}
	/**
	 * 获取医保计划名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划名称"); 
		return column;
	}
	/**
	 * 获取医保号码必填标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_reqhpcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_reqhpcode");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保号码必填标志"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModehp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modehp_code");
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
	private IColumnDesc getModehp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modehp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
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
