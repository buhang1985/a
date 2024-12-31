
package iih.sc.scp.scplweek.d.desc;

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
 * 计划排班_计划_周_渠道 DO 元数据信息
 */
public class ScPlanWeekChlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.scp.scplweek.d.ScPlanWeekChlDO";
	public static final String CLASS_DISPALYNAME = "计划排班_计划_周_渠道";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_pl_week_chl";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_scplweekchl";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public ScPlanWeekChlDODesc(){
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
		this.setKeyDesc(getId_scplweekchlADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_scplweekADesc(tblDesc));
		this.add(getId_scplweekchlADesc(tblDesc));
		this.add(getId_scplweekADesc(tblDesc));
		this.add(getId_scchlADesc(tblDesc));
		this.add(getScpolcnADesc(tblDesc));
		this.add(getIds_emp_specADesc(tblDesc));
		this.add(getIds_dep_specADesc(tblDesc));
		this.add(getId_entpADesc(tblDesc));
		this.add(getName_scchlADesc(tblDesc));
		this.add(getCode_scchlADesc(tblDesc));
		this.add(getNames_emp_specADesc(tblDesc));
		this.add(getNames_dep_specADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getName_entpADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_scplweekchlCDesc(tblDesc));
		tblDesc.add(getId_scplweekchlCDesc(tblDesc));
		tblDesc.add(getId_scplweekCDesc(tblDesc));
		tblDesc.add(getId_scchlCDesc(tblDesc));
		tblDesc.add(getScpolcnCDesc(tblDesc));
		tblDesc.add(getIds_emp_specCDesc(tblDesc));
		tblDesc.add(getIds_dep_specCDesc(tblDesc));
		tblDesc.add(getId_entpCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 计划周渠道ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplweekchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scplweekchl",  getId_scplweekchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划周渠道ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划周属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scplweekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scplweek",  getId_scplweekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划周");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 渠道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_scchl",  getId_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("渠道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 对应号源池编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScpolcnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Scpolcn",  getScpolcnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("对应号源池编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 授权医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_emp_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_emp_spec",  getIds_emp_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("授权医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 授权科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIds_dep_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ids_dep_spec",  getIds_dep_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("授权科室");
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
	 * 预约渠道名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_scchl",  getName_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约渠道名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_chl a1b2","id_scchl=id_scchl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约渠道编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_scchlADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_scchl",  getCode_scchlCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约渠道编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sc_chl a1b2","id_scchl=id_scchl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 授权医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNames_emp_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Names_emp_spec",  getNames_emp_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("授权医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b3","ids_emp_spec=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 授权科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNames_dep_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Names_dep_spec",  getNames_dep_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("授权科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a1b4","ids_dep_spec=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a1b5","id_entp=id_entp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_entp",  getName_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_entp a1b5","id_entp=id_entp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取计划周渠道ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplweekchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scplweekchl");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划周渠道ID"); 
		return column;
	}
	/**
	 * 获取计划周表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scplweekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scplweek");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划周"); 
		return column;
	}
	/**
	 * 获取渠道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_scchl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("渠道"); 
		return column;
	}
	/**
	 * 获取对应号源池编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScpolcnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Scpolcn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("对应号源池编号"); 
		return column;
	}
	/**
	 * 获取授权医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_emp_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_emp_spec");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("授权医生"); 
		return column;
	}
	/**
	 * 获取授权科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIds_dep_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ids_dep_spec");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("授权科室"); 
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
	 * 获取预约渠道名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_scchl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约渠道名称"); 
		return column;
	}
	/**
	 * 获取预约渠道编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_scchlCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_scchl");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约渠道编码"); 
		return column;
	}
	/**
	 * 获取授权医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNames_emp_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Names_emp_spec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("授权医生"); 
		return column;
	}
	/**
	 * 获取授权科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNames_dep_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Names_dep_spec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("授权科室"); 
		return column;
	}
	/**
	 * 获取就诊类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型编码"); 
		return column;
	}
	/**
	 * 获取就诊类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_entp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型名称"); 
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
