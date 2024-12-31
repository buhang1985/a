
package iih.mp.ne.transfusion.d.desc;

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
 * 输血记录体征测量 DO 元数据信息
 */
public class NeBtrVtDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.mp.ne.transfusion.d.NeBtrVtDO";
	public static final String CLASS_DISPALYNAME = "输血记录体征测量";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MP_NE_BTR_VT";
	public static final String TABLE_ALIAS_NAME = "a3";
	public static final String PRIMARYKEY_FIELDNAME="Id_nebtrvt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NeBtrVtDODesc(){
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
		this.setKeyDesc(getId_nebtrvtADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.setFKeyDesc(getId_nebtrADesc(tblDesc));
		this.add(getId_nebtrvtADesc(tblDesc));
		this.add(getId_nebtrADesc(tblDesc));
		this.add(getDt_vtADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getFg_temsheetADesc(tblDesc));
		this.add(getId_srvADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getValcountADesc(tblDesc));
		this.add(getValueADesc(tblDesc));
		this.add(getFg_posADesc(tblDesc));
		this.add(getId_vt_posADesc(tblDesc));
		this.add(getSd_vt_posADesc(tblDesc));
		this.add(getFg_auxADesc(tblDesc));
		this.add(getId_vt_auxADesc(tblDesc));
		this.add(getSd_vt_auxADesc(tblDesc));
		this.add(getValue1ADesc(tblDesc));
		this.add(getValue2ADesc(tblDesc));
		this.add(getValue3ADesc(tblDesc));
		this.add(getSrv_nameADesc(tblDesc));
		this.add(getSrv_codeADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nebtrvtCDesc(tblDesc));
		tblDesc.add(getId_nebtrvtCDesc(tblDesc));
		tblDesc.add(getId_nebtrCDesc(tblDesc));
		tblDesc.add(getDt_vtCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getFg_temsheetCDesc(tblDesc));
		tblDesc.add(getId_srvCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getValcountCDesc(tblDesc));
		tblDesc.add(getValueCDesc(tblDesc));
		tblDesc.add(getFg_posCDesc(tblDesc));
		tblDesc.add(getId_vt_posCDesc(tblDesc));
		tblDesc.add(getSd_vt_posCDesc(tblDesc));
		tblDesc.add(getFg_auxCDesc(tblDesc));
		tblDesc.add(getId_vt_auxCDesc(tblDesc));
		tblDesc.add(getSd_vt_auxCDesc(tblDesc));
		tblDesc.add(getValue1CDesc(tblDesc));
		tblDesc.add(getValue2CDesc(tblDesc));
		tblDesc.add(getValue3CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体征测量项目主标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nebtrvtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nebtrvt",  getId_nebtrvtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体征测量项目主标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血记录id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nebtrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nebtr",  getId_nebtrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血记录id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 测量时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_vtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_vt",  getDt_vtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("测量时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温单标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_temsheetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_temsheet",  getFg_temsheetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("体温单标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务项目属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_srvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_srv",  getId_srvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务项目");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 显示名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("显示名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值个数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValcountADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Valcount",  getValcountCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("值个数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value",  getValueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pos",  getFg_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_vt_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vt_pos",  getId_vt_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_vt_posADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vt_pos",  getSd_vt_posCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 启用辅助措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_auxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_aux",  getFg_auxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用辅助措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 辅助措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_vt_auxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vt_aux",  getId_vt_auxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辅助措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 辅助措施编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_vt_auxADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vt_aux",  getSd_vt_auxCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("辅助措施编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value1",  getValue1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value2",  getValue2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 值3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getValue3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Value3",  getValue3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("值3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_name",  getSrv_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a3b4","id_srv=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrv_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srv_code",  getSrv_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a3b4","id_srv=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体征测量项目主标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nebtrvtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nebtrvt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体征测量项目主标识"); 
		return column;
	}
	/**
	 * 获取输血记录id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nebtrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nebtr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血记录id"); 
		return column;
	}
	/**
	 * 获取测量时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_vtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_vt");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("测量时间"); 
		return column;
	}
	/**
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取体温单标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_temsheetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_temsheet");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体温单标志"); 
		return column;
	}
	/**
	 * 获取服务项目表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_srvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_srv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务项目"); 
		return column;
	}
	/**
	 * 获取显示名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("显示名称"); 
		return column;
	}
	/**
	 * 获取值个数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValcountCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Valcount");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("值个数"); 
		return column;
	}
	/**
	 * 获取值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值"); 
		return column;
	}
	/**
	 * 获取启用部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pos");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用部位"); 
		return column;
	}
	/**
	 * 获取部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_vt_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vt_pos");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部位"); 
		return column;
	}
	/**
	 * 获取部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_vt_posCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vt_pos");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部位编码"); 
		return column;
	}
	/**
	 * 获取启用辅助措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_auxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_aux");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用辅助措施"); 
		return column;
	}
	/**
	 * 获取辅助措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_vt_auxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vt_aux");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辅助措施"); 
		return column;
	}
	/**
	 * 获取辅助措施编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_vt_auxCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vt_aux");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("辅助措施编码"); 
		return column;
	}
	/**
	 * 获取值1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值1"); 
		return column;
	}
	/**
	 * 获取值2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值2"); 
		return column;
	}
	/**
	 * 获取值3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getValue3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Value3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("值3"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrv_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srv_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
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
