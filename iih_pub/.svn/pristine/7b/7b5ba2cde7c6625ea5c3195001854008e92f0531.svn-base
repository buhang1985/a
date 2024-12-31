
package iih.bl.inc.blcpnin.d.desc;

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
 * 优惠券_入库单 DO 元数据信息
 */
public class BlCpnInDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.inc.blcpnin.d.BlCpnInDO";
	public static final String CLASS_DISPALYNAME = "优惠券_入库单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_cpn_in";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_cpnin";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlCpnInDODesc(){
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
		this.setKeyDesc(getId_cpninADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_cpninADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_cpncaADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getId_emp_entryADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getNum_bADesc(tblDesc));
		this.add(getNum_eADesc(tblDesc));
		this.add(getCode_cpn_bADesc(tblDesc));
		this.add(getCode_cpn_eADesc(tblDesc));
		this.add(getCode_cpncaADesc(tblDesc));
		this.add(getName_cpncaADesc(tblDesc));
		this.add(getEu_cpntpADesc(tblDesc));
		this.add(getCode_emp_entryADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cpninCDesc(tblDesc));
		tblDesc.add(getId_cpninCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_cpncaCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getId_emp_entryCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getNum_bCDesc(tblDesc));
		tblDesc.add(getNum_eCDesc(tblDesc));
		tblDesc.add(getCode_cpn_bCDesc(tblDesc));
		tblDesc.add(getCode_cpn_eCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 优惠券入库单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cpninADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cpnin",  getId_cpninCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优惠券入库单主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 优惠卷分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cpncaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cpnca",  getId_cpncaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优惠卷分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入库单编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入库单编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 制单人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_entry",  getId_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("制单人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 制单时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("制单时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_b",  getNum_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("开始号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_e",  getNum_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("结束号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始劵编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cpn_bADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cpn_b",  getCode_cpn_bCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开始劵编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结束劵编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cpn_eADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cpn_e",  getCode_cpn_eCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结束劵编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优惠券分类的编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cpncaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cpnca",  getCode_cpncaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优惠券分类的编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cpnca a0b4","id_cpnca=id_cpnca","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优惠券分类的名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cpncaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cpnca",  getName_cpncaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优惠券分类的名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cpnca a0b4","id_cpnca=id_cpnca","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优惠券类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_cpntpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_cpntp",  getEu_cpntpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("优惠券类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cpnca a0b4","id_cpnca=id_cpnca","eu_cpntp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emp_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp_entry",  getCode_emp_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_entry=id_psndoc","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_entry=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取优惠券入库单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cpninCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cpnin");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("优惠券入库单主键"); 
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
	 * 获取优惠卷分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cpncaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cpnca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优惠卷分类"); 
		return column;
	}
	/**
	 * 获取入库单编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入库单编码"); 
		return column;
	}
	/**
	 * 获取制单人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_entry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("制单人"); 
		return column;
	}
	/**
	 * 获取制单时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("制单时间"); 
		return column;
	}
	/**
	 * 获取开始号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_b");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("开始号"); 
		return column;
	}
	/**
	 * 获取结束号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_e");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("结束号"); 
		return column;
	}
	/**
	 * 获取开始劵编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cpn_bCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cpn_b");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开始劵编码"); 
		return column;
	}
	/**
	 * 获取结束劵编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cpn_eCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cpn_e");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结束劵编码"); 
		return column;
	}
	/**
	 * 获取优惠券分类的编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cpncaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cpnca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优惠券分类的编码"); 
		return column;
	}
	/**
	 * 获取优惠券分类的名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cpncaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cpnca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优惠券分类的名称"); 
		return column;
	}
	/**
	 * 获取优惠券类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_cpntpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_cpntp");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("优惠券类型"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emp_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp_entry");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
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
		iBDDataInfoFldMap.put("id","Id_cpnin");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("code","Code");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap(){
	}
	
}
