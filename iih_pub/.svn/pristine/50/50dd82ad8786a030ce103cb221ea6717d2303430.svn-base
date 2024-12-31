
package iih.pe.pitm.pefoodcomp.d.desc;

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
 * 体检食物成份表 DO 元数据信息
 */
public class PeFoodCompDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.pitm.pefoodcomp.d.PeFoodCompDO";
	public static final String CLASS_DISPALYNAME = "体检食物成份表";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_itm_pefoodcomp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pefoodcomp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeFoodCompDODesc(){
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
		this.setKeyDesc(getId_pefoodcompADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pefoodcompADesc(tblDesc));
		this.add(getId_pefoodcomp_parADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getFoodcaADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getAliasADesc(tblDesc));
		this.add(getEatableADesc(tblDesc));
		this.add(getEnergyADesc(tblDesc));
		this.add(getWaterADesc(tblDesc));
		this.add(getProteinADesc(tblDesc));
		this.add(getFatADesc(tblDesc));
		this.add(getFiberADesc(tblDesc));
		this.add(getCarbohydrateADesc(tblDesc));
		this.add(getVitamin_aADesc(tblDesc));
		this.add(getVitamin_b1ADesc(tblDesc));
		this.add(getVitamin_b2ADesc(tblDesc));
		this.add(getFolic_acidADesc(tblDesc));
		this.add(getVitamin_eADesc(tblDesc));
		this.add(getNaADesc(tblDesc));
		this.add(getCaADesc(tblDesc));
		this.add(getFeADesc(tblDesc));
		this.add(getVitamin_cADesc(tblDesc));
		this.add(getCholesterolADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_pefoodcompCDesc(tblDesc));
		tblDesc.add(getId_pefoodcompCDesc(tblDesc));
		tblDesc.add(getId_pefoodcomp_parCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getFoodcaCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getAliasCDesc(tblDesc));
		tblDesc.add(getEatableCDesc(tblDesc));
		tblDesc.add(getEnergyCDesc(tblDesc));
		tblDesc.add(getWaterCDesc(tblDesc));
		tblDesc.add(getProteinCDesc(tblDesc));
		tblDesc.add(getFatCDesc(tblDesc));
		tblDesc.add(getFiberCDesc(tblDesc));
		tblDesc.add(getCarbohydrateCDesc(tblDesc));
		tblDesc.add(getVitamin_aCDesc(tblDesc));
		tblDesc.add(getVitamin_b1CDesc(tblDesc));
		tblDesc.add(getVitamin_b2CDesc(tblDesc));
		tblDesc.add(getFolic_acidCDesc(tblDesc));
		tblDesc.add(getVitamin_eCDesc(tblDesc));
		tblDesc.add(getNaCDesc(tblDesc));
		tblDesc.add(getCaCDesc(tblDesc));
		tblDesc.add(getFeCDesc(tblDesc));
		tblDesc.add(getVitamin_cCDesc(tblDesc));
		tblDesc.add(getCholesterolCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检食物成份表主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pefoodcompADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pefoodcomp",  getId_pefoodcompCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检食物成份表主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检食物成份表表父ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pefoodcomp_parADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pefoodcomp_par",  getId_pefoodcomp_parCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检食物成份表表父ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFoodcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Foodca",  getFoodcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属类别");
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
	 * 食物名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("食物名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 别名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAliasADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Alias",  getAliasCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("别名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可食部分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEatableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eatable",  getEatableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("可食部分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 能量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Energy",  getEnergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("能量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 水分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWaterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Water",  getWaterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("水分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 蛋白质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProteinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Protein",  getProteinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("蛋白质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脂肪属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fat",  getFatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("脂肪");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 膳食纤维属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFiberADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fiber",  getFiberCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("膳食纤维");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 碳水化合物属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCarbohydrateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Carbohydrate",  getCarbohydrateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("碳水化合物");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维他命A属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVitamin_aADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vitamin_a",  getVitamin_aCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维他命A");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维他命B1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVitamin_b1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vitamin_b1",  getVitamin_b1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维他命B1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维他命B2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVitamin_b2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vitamin_b2",  getVitamin_b2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维他命B2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 叶酸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFolic_acidADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Folic_acid",  getFolic_acidCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("叶酸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维他命E属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVitamin_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vitamin_e",  getVitamin_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维他命E");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 钠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Na",  getNaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("钠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 钙属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ca",  getCaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("钙");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 铁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fe",  getFeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("铁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 维他命C属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVitamin_cADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Vitamin_c",  getVitamin_cCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("维他命C");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胆固醇属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCholesterolADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cholesterol",  getCholesterolCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("胆固醇");
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
	 * 获取体检食物成份表主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pefoodcompCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pefoodcomp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检食物成份表主键标识"); 
		return column;
	}
	/**
	 * 获取体检食物成份表表父ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pefoodcomp_parCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pefoodcomp_par");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检食物成份表表父ID"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFoodcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Foodca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属类别"); 
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
	 * 获取食物名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("食物名称"); 
		return column;
	}
	/**
	 * 获取别名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAliasCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Alias");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("别名"); 
		return column;
	}
	/**
	 * 获取可食部分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEatableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eatable");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("可食部分"); 
		return column;
	}
	/**
	 * 获取能量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEnergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Energy");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("能量"); 
		return column;
	}
	/**
	 * 获取水分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWaterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Water");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("水分"); 
		return column;
	}
	/**
	 * 获取蛋白质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProteinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Protein");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("蛋白质"); 
		return column;
	}
	/**
	 * 获取脂肪表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fat");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("脂肪"); 
		return column;
	}
	/**
	 * 获取膳食纤维表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFiberCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fiber");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("膳食纤维"); 
		return column;
	}
	/**
	 * 获取碳水化合物表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCarbohydrateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Carbohydrate");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("碳水化合物"); 
		return column;
	}
	/**
	 * 获取维他命A表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVitamin_aCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vitamin_a");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维他命A"); 
		return column;
	}
	/**
	 * 获取维他命B1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVitamin_b1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vitamin_b1");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维他命B1"); 
		return column;
	}
	/**
	 * 获取维他命B2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVitamin_b2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vitamin_b2");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维他命B2"); 
		return column;
	}
	/**
	 * 获取叶酸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFolic_acidCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Folic_acid");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("叶酸"); 
		return column;
	}
	/**
	 * 获取维他命E表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVitamin_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vitamin_e");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维他命E"); 
		return column;
	}
	/**
	 * 获取钠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Na");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("钠"); 
		return column;
	}
	/**
	 * 获取钙表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ca");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("钙"); 
		return column;
	}
	/**
	 * 获取铁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fe");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("铁"); 
		return column;
	}
	/**
	 * 获取维他命C表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVitamin_cCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Vitamin_c");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("维他命C"); 
		return column;
	}
	/**
	 * 获取胆固醇表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCholesterolCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cholesterol");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("胆固醇"); 
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
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pefoodcomp");
		iBDDataInfoFldMap.put("pid","Id_pefoodcomp_par");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("name","Name");
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
