
package iih.mi.mc.mimctactics.d.desc;

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
 * 医保策略库参数 DO 元数据信息
 */
public class MiMcTacticsParaDesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mi.mc.mimctactics.d.MiMcTacticsPara";
	public static final String CLASS_DISPALYNAME = "医保策略库参数";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mi_mc_tactics_para";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_hptacticspara";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MiMcTacticsParaDesc(){
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
		this.setKeyDesc(getId_hptacticsparaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_hptacticsADesc(tblDesc));
		this.add(getId_hptacticsADesc(tblDesc));
		this.add(getId_hptacticsparaADesc(tblDesc));
		this.add(getId_paramsetADesc(tblDesc));
		this.add(getParamcodeADesc(tblDesc));
		this.add(getParamnameADesc(tblDesc));
		this.add(getRemarkADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_hptacticsparaCDesc(tblDesc));
		tblDesc.add(getId_hptacticsCDesc(tblDesc));
		tblDesc.add(getId_hptacticsparaCDesc(tblDesc));
		tblDesc.add(getId_paramsetCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医保策略库主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hptacticsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hptactics",  getId_hptacticsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保策略库主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保策略库下参数主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hptacticsparaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hptacticspara",  getId_hptacticsparaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保策略库下参数主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_paramsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_paramset",  getId_paramsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setExtTag("URC,BDMODE");
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 参数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getParamcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paramcode",  getParamcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_paramtmplset a1b2","id_paramset=id_paramtmplset","paramcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参数名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getParamnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paramname",  getParamnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_paramtmplset a1b2","id_paramset=id_paramtmplset","paramname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参数描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remark",  getRemarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_paramtmplset a1b2","id_paramset=id_paramtmplset","remark"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医保策略库主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hptacticsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hptactics");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保策略库主键"); 
		return column;
	}
	/**
	 * 获取医保策略库下参数主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hptacticsparaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hptacticspara");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保策略库下参数主键"); 
		return column;
	}
	/**
	 * 获取参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_paramsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_paramset");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数"); 
		return column;
	}
	/**
	 * 获取参数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getParamcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paramcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数编码"); 
		return column;
	}
	/**
	 * 获取参数名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getParamnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paramname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数名称"); 
		return column;
	}
	/**
	 * 获取参数描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remark");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数描述"); 
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
