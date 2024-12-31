
package iih.sc.apt.scaptappl.d.desc;

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
 * 计划排班_预约_申请单明细 DO 元数据信息
 */
public class ScAptApplItmDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.apt.scaptappl.d.ScAptApplItmDO";
	public static final String CLASS_DISPALYNAME = "计划排班_预约_申请单明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_apt_appl_itm";
	public static final String TABLE_ALIAS_NAME = "a2";
	public static final String PRIMARYKEY_FIELDNAME="Id_aptapplitm";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScAptApplItmDODesc(){
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
		this.setKeyDesc(getId_aptapplitmADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_aptapplADesc(tblDesc));
		this.add(getId_aptapplitmADesc(tblDesc));
		this.add(getId_aptapplADesc(tblDesc));
		this.add(getApplyno_orADesc(tblDesc));
		this.add(getApplynoADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getCode_orADesc(tblDesc));
		this.add(getContent_orADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getFg_blADesc(tblDesc));
		this.add(getDt_effe_orADesc(tblDesc));
		this.add(getFg_hpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aptapplitmCDesc(tblDesc));
		tblDesc.add(getId_aptapplitmCDesc(tblDesc));
		tblDesc.add(getId_aptapplCDesc(tblDesc));
		tblDesc.add(getApplyno_orCDesc(tblDesc));
		tblDesc.add(getApplynoCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getCode_orCDesc(tblDesc));
		tblDesc.add(getContent_orCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getFg_blCDesc(tblDesc));
		tblDesc.add(getDt_effe_orCDesc(tblDesc));
		tblDesc.add(getFg_hpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 申请单明细id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptapplitmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptapplitm",  getId_aptapplitmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单明细id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约申请id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptapplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptappl",  getId_aptapplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约申请id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 合单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApplyno_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Applyno_or",  getApplyno_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("合单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱申请号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApplynoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Applyno",  getApplynoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱申请号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约申请描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约申请描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_or",  getCode_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContent_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content_or",  getContent_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗服务id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗服务id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 紧急标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("紧急标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否已付费属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_blADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bl",  getFg_blCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否已付费");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_effe_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_effe_or",  getDt_effe_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("医嘱开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_hp",  getFg_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医保标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取申请单明细id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptapplitmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptapplitm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单明细id"); 
		return column;
	}
	/**
	 * 获取预约申请id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptapplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptappl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约申请id"); 
		return column;
	}
	/**
	 * 获取合单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApplyno_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Applyno_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("合单号"); 
		return column;
	}
	/**
	 * 获取医嘱申请号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApplynoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Applyno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱申请号"); 
		return column;
	}
	/**
	 * 获取预约申请描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约申请描述"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取医嘱编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱编号"); 
		return column;
	}
	/**
	 * 获取医嘱内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContent_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content_or");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱内容"); 
		return column;
	}
	/**
	 * 获取医疗服务id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗服务id"); 
		return column;
	}
	/**
	 * 获取紧急标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("紧急标志"); 
		return column;
	}
	/**
	 * 获取是否已付费表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_blCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bl");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否已付费"); 
		return column;
	}
	/**
	 * 获取医嘱开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_effe_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_effe_or");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱开始时间"); 
		return column;
	}
	/**
	 * 获取医保标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_hp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保标志"); 
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
