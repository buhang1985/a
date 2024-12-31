
package iih.bd.fc.mdwfmp.d.desc;

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
 * 医嘱流向执行参数 DO 元数据信息
 */
public class MdWfMpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.fc.mdwfmp.d.MdWfMpDO";
	public static final String CLASS_DISPALYNAME = "医嘱流向执行参数";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "md_wf_mp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_wfmp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MdWfMpDODesc(){
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
		this.setKeyDesc(getId_wfmpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_wfmpADesc(tblDesc));
		this.add(getId_wfADesc(tblDesc));
		this.add(getSd_wfmparguADesc(tblDesc));
		this.add(getId_wfmparguADesc(tblDesc));
		this.add(getValADesc(tblDesc));
		this.add(getSd_opADesc(tblDesc));
		this.add(getId_opADesc(tblDesc));
		this.add(getParam_codeADesc(tblDesc));
		this.add(getParam_nameADesc(tblDesc));
		this.add(getOp_codeADesc(tblDesc));
		this.add(getOp_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_wfmpCDesc(tblDesc));
		tblDesc.add(getId_wfmpCDesc(tblDesc));
		tblDesc.add(getId_wfCDesc(tblDesc));
		tblDesc.add(getSd_wfmparguCDesc(tblDesc));
		tblDesc.add(getId_wfmparguCDesc(tblDesc));
		tblDesc.add(getValCDesc(tblDesc));
		tblDesc.add(getSd_opCDesc(tblDesc));
		tblDesc.add(getId_opCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱流向执行参数主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wfmpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wfmp",  getId_wfmpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向执行参数主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱流向属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wf",  getId_wfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱流向");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 参数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_wfmparguADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_wfmpargu",  getSd_wfmparguCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数编码");
		attrDesc.setNullable(true);
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
	private IAttrDesc getId_wfmparguADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wfmpargu",  getId_wfmparguCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 参数值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val",  getValCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运算逻辑编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_op",  getSd_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("运算逻辑编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 运算逻辑属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_op",  getId_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("运算逻辑");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 参数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getParam_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Param_code",  getParam_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_wfmpargu=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参数名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getParam_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Param_name",  getParam_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b2","id_wfmpargu=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参数编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Op_code",  getOp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_op=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 参数名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Op_name",  getOp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("参数名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_op=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱流向执行参数主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfmpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wfmp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向执行参数主键"); 
		return column;
	}
	/**
	 * 获取医嘱流向表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wf");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱流向"); 
		return column;
	}
	/**
	 * 获取参数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_wfmparguCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_wfmpargu");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数编码"); 
		return column;
	}
	/**
	 * 获取参数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wfmparguCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wfmpargu");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数"); 
		return column;
	}
	/**
	 * 获取参数值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数值"); 
		return column;
	}
	/**
	 * 获取运算逻辑编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("运算逻辑编码"); 
		return column;
	}
	/**
	 * 获取运算逻辑表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("运算逻辑"); 
		return column;
	}
	/**
	 * 获取参数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getParam_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Param_code");
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
	private IColumnDesc getParam_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Param_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数名称"); 
		return column;
	}
	/**
	 * 获取参数编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Op_code");
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
	private IColumnDesc getOp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Op_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("参数名称"); 
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
