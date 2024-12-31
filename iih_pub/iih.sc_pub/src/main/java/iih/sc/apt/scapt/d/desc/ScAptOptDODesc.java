
package iih.sc.apt.scapt.d.desc;

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
 * 计划排班_预约_手术 DO 元数据信息
 */
public class ScAptOptDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.apt.scapt.d.ScAptOptDO";
	public static final String CLASS_DISPALYNAME = "计划排班_预约_手术";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_apt_opt";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_aptopt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScAptOptDODesc(){
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
		this.setKeyDesc(getId_aptoptADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_aptADesc(tblDesc));
		this.add(getId_aptoptADesc(tblDesc));
		this.add(getId_aptADesc(tblDesc));
		this.add(getSd_paatmd_optADesc(tblDesc));
		this.add(getId_paatmd_optADesc(tblDesc));
		this.add(getId_entpADesc(tblDesc));
		this.add(getId_enADesc(tblDesc));
		this.add(getId_optADesc(tblDesc));
		this.add(getId_dep_belongADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getFg_arriveADesc(tblDesc));
		this.add(getId_mp_optADesc(tblDesc));
		this.add(getId_aptapplADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aptoptCDesc(tblDesc));
		tblDesc.add(getId_aptoptCDesc(tblDesc));
		tblDesc.add(getId_aptCDesc(tblDesc));
		tblDesc.add(getSd_paatmd_optCDesc(tblDesc));
		tblDesc.add(getId_paatmd_optCDesc(tblDesc));
		tblDesc.add(getId_entpCDesc(tblDesc));
		tblDesc.add(getId_enCDesc(tblDesc));
		tblDesc.add(getId_optCDesc(tblDesc));
		tblDesc.add(getId_dep_belongCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getFg_arriveCDesc(tblDesc));
		tblDesc.add(getId_mp_optCDesc(tblDesc));
		tblDesc.add(getId_aptapplCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 预约手术属性ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptoptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptopt",  getId_aptoptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约手术属性ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apt",  getId_aptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术预约模式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_paatmd_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_paatmd_opt",  getSd_paatmd_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术预约模式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术预约模式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_paatmd_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_paatmd_opt",  getId_paatmd_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术预约模式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entp",  getId_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_en",  getId_enCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术台属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opt",  getId_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术台");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术所属科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_belongADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_belong",  getId_dep_belongCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术所属科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预约手术签到标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_arriveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_arrive",  getFg_arriveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("预约手术签到标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术执行属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mp_optADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mp_opt",  getId_mp_optCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术执行");
		attrDesc.setNullable(true);
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
	 * 获取预约手术属性ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptoptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptopt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约手术属性ID"); 
		return column;
	}
	/**
	 * 获取预约表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约"); 
		return column;
	}
	/**
	 * 获取手术预约模式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_paatmd_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_paatmd_opt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术预约模式编码"); 
		return column;
	}
	/**
	 * 获取手术预约模式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_paatmd_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_paatmd_opt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术预约模式"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_en");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊"); 
		return column;
	}
	/**
	 * 获取手术台表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术台"); 
		return column;
	}
	/**
	 * 获取手术所属科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_belongCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_belong");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术所属科室"); 
		return column;
	}
	/**
	 * 获取手术医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术医嘱"); 
		return column;
	}
	/**
	 * 获取预约手术签到标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_arriveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_arrive");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约手术签到标志"); 
		return column;
	}
	/**
	 * 获取手术执行表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mp_optCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mp_opt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术执行"); 
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
