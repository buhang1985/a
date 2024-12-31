
package iih.en.pv.enres.d.desc;

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
 * 就诊事件 DO 元数据信息
 */
public class EnEvtDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.pv.enres.d.EnEvtDO";
	public static final String CLASS_DISPALYNAME = "就诊事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "EN_ENT_EVT";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_entevt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EnEvtDODesc(){
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
		this.setKeyDesc(getId_entevtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_entevtADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_erpreADesc(tblDesc));
		this.add(getSd_entevtADesc(tblDesc));
		this.add(getShort_desADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getDt_evtADesc(tblDesc));
		this.add(getId_emp_recADesc(tblDesc));
		this.add(getDt_insertADesc(tblDesc));
		this.add(getVal_oldADesc(tblDesc));
		this.add(getVal_newADesc(tblDesc));
		this.add(getName_emp_recADesc(tblDesc));
		this.add(getCode_emp_recADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_entevtCDesc(tblDesc));
		tblDesc.add(getId_entevtCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_erpreCDesc(tblDesc));
		tblDesc.add(getSd_entevtCDesc(tblDesc));
		tblDesc.add(getShort_desCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getDt_evtCDesc(tblDesc));
		tblDesc.add(getId_emp_recCDesc(tblDesc));
		tblDesc.add(getDt_insertCDesc(tblDesc));
		tblDesc.add(getVal_oldCDesc(tblDesc));
		tblDesc.add(getVal_newCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 就诊事件id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entevtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entevt",  getId_entevtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊事件id");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预检id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_erpreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_erpre",  getId_erpreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预检id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_entevtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_entevt",  getSd_entevtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 简述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getShort_desADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Short_des",  getShort_desCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("简述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_evtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_evt",  getDt_evtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("事件时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记录人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_rec",  getId_emp_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记录人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 记录时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_insertADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_insert",  getDt_insertCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("记录时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 旧数据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_old",  getVal_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("旧数据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新数据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getVal_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Val_new",  getVal_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新数据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记录人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_rec",  getName_emp_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记录人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b2","id_emp_rec=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 记录人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emp_recADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp_rec",  getCode_emp_recCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("记录人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b2","id_emp_rec=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取就诊事件id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entevtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entevt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("就诊事件id"); 
		return column;
	}
	/**
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取预检id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_erpreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_erpre");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预检id"); 
		return column;
	}
	/**
	 * 获取事件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_entevtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_entevt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件类型"); 
		return column;
	}
	/**
	 * 获取简述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getShort_desCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Short_des");
		column.setLength(128);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("简述"); 
		return column;
	}
	/**
	 * 获取描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(512);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("描述"); 
		return column;
	}
	/**
	 * 获取事件时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_evtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_evt");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("事件时间"); 
		return column;
	}
	/**
	 * 获取记录人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_rec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记录人"); 
		return column;
	}
	/**
	 * 获取记录时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_insertCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_insert");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("记录时间"); 
		return column;
	}
	/**
	 * 获取旧数据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_old");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("旧数据"); 
		return column;
	}
	/**
	 * 获取新数据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getVal_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Val_new");
		column.setLength(256);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新数据"); 
		return column;
	}
	/**
	 * 获取记录人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_rec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记录人员姓名"); 
		return column;
	}
	/**
	 * 获取记录人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emp_recCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp_rec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("记录人员编码"); 
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
