
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
 * 优惠卷 DO 元数据信息
 */
public class BlCpnDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.inc.blcpnin.d.BlCpnDO";
	public static final String CLASS_DISPALYNAME = "优惠卷";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_cpn";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_cpn";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlCpnDODesc(){
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
		this.setKeyDesc(getId_cpnADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_cpninADesc(tblDesc));
		this.add(getId_cpnADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_cpncaADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getId_cpninADesc(tblDesc));
		this.add(getFg_issADesc(tblDesc));
		this.add(getDt_issADesc(tblDesc));
		this.add(getId_emp_issADesc(tblDesc));
		this.add(getId_pat_ownADesc(tblDesc));
		this.add(getFg_usedADesc(tblDesc));
		this.add(getCode_orgADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getCode_cpncaADesc(tblDesc));
		this.add(getName_cpncaADesc(tblDesc));
		this.add(getEu_cpntpADesc(tblDesc));
		this.add(getCoderule_cpnADesc(tblDesc));
		this.add(getCode_cpninADesc(tblDesc));
		this.add(getCode_emp_issADesc(tblDesc));
		this.add(getName_emp_issADesc(tblDesc));
		this.add(getName_pat_ownADesc(tblDesc));
		this.add(getCode_pat_ownADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_cpnCDesc(tblDesc));
		tblDesc.add(getId_cpnCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_cpncaCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getId_cpninCDesc(tblDesc));
		tblDesc.add(getFg_issCDesc(tblDesc));
		tblDesc.add(getDt_issCDesc(tblDesc));
		tblDesc.add(getId_emp_issCDesc(tblDesc));
		tblDesc.add(getId_pat_ownCDesc(tblDesc));
		tblDesc.add(getFg_usedCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 优惠券主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cpnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cpn",  getId_cpnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优惠券主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 优惠卷编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code",  getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优惠卷编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优惠卷入库单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cpninADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cpnin",  getId_cpninCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优惠卷入库单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发放标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_issADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_iss",  getFg_issCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("发放标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发放日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_issADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_iss",  getDt_issCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("发放日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发放人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_issADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_iss",  getId_emp_issCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发放人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 持有人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pat_ownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat_own",  getId_pat_ownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("持有人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 已使用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_usedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_used",  getFg_usedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("已使用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_org",  getCode_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a1b2","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a1b2","id_org=id_org","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_cpnca a1b4","id_cpnca=id_cpnca","code"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_cpnca a1b4","id_cpnca=id_cpnca","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_cpnca a1b4","id_cpnca=id_cpnca","eu_cpntp"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * (单码优惠券)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCoderule_cpnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Coderule_cpn",  getCoderule_cpnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("(单码优惠券)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_cpnca a1b4","id_cpnca=id_cpnca","coderule_cpn"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入库单编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_cpninADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_cpnin",  getCode_cpninCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入库单编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bl_cpn_in a1b5","id_cpnin=id_cpnin","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emp_issADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp_iss",  getCode_emp_issCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b6","id_emp_iss=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_issADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_iss",  getName_emp_issCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b6","id_emp_iss=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pat_ownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat_own",  getName_pat_ownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a1b7","id_pat_own=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_pat_ownADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_pat_own",  getCode_pat_ownCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a1b7","id_pat_own=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取优惠券主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cpnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cpn");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("优惠券主键"); 
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
	 * 获取优惠卷编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优惠卷编码"); 
		return column;
	}
	/**
	 * 获取优惠卷入库单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cpninCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cpnin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优惠卷入库单"); 
		return column;
	}
	/**
	 * 获取发放标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_issCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_iss");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发放标志"); 
		return column;
	}
	/**
	 * 获取发放日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_issCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_iss");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发放日期"); 
		return column;
	}
	/**
	 * 获取发放人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_issCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_iss");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发放人员"); 
		return column;
	}
	/**
	 * 获取持有人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pat_ownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat_own");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("持有人"); 
		return column;
	}
	/**
	 * 获取已使用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_usedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_used");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("已使用标志"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
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
	 * 获取(单码优惠券)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCoderule_cpnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Coderule_cpn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("(单码优惠券)编码"); 
		return column;
	}
	/**
	 * 获取入库单编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_cpninCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_cpnin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入库单编码"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emp_issCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp_iss");
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
	private IColumnDesc getName_emp_issCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_iss");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pat_ownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat_own");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_pat_ownCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_pat_own");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_cpn");
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
