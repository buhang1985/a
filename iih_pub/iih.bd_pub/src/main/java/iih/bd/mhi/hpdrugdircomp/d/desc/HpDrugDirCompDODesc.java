
package iih.bd.mhi.hpdrugdircomp.d.desc;

import java.sql.Types;
import java.util.HashMap;
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

/**
 * 医保产品_药品对照 DO 元数据信息
 */
public class HpDrugDirCompDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO";
	public static final String CLASS_DISPALYNAME = "医保产品_药品对照";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "BD_HP_COMP_DRUG";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME = "Id_comp_drug";
	private ColumnDesc dsColumn = null;
	private ColumnDesc svColumn = null;

	/**
	 * 无参构造函数
	 */
	public HpDrugDirCompDODesc() {
		init();
	}

	/**
	 * 数据初始化
	 */
	private void init() {
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc = getTableDesc();
		this.setKeyDesc(getId_comp_drugADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_comp_drugADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getId_drugADesc(tblDesc));
		this.add(getCodeADesc(tblDesc));
		this.add(getEu_statusADesc(tblDesc));
		this.add(getDt_approvedADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getHp_nameADesc(tblDesc));
		this.add(getDrug_nameADesc(tblDesc));
		this.add(getDrug_codeADesc(tblDesc));
		this.add(new DsAttr(dsColumn, this));
		this.add(new SvAttr(svColumn, this));
		this.setIsRefTableInfo(true);

	}

	/**
	 * 获得表元数据
	 * 
	 * @return
	 */
	private ITableDesc getTableDesc() {
		TableDesc tblDesc = new TableDesc(TABLE_NAME, TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_comp_drugCDesc(tblDesc));
		tblDesc.add(getId_comp_drugCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getId_drugCDesc(tblDesc));
		tblDesc.add(getCodeCDesc(tblDesc));
		tblDesc.add(getEu_statusCDesc(tblDesc));
		tblDesc.add(getDt_approvedCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn = new DsColumn(tblDesc);
		svColumn = new SvColumn(tblDesc);

		return tblDesc;
	}

	/**
	 * 药品对照主键属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_comp_drugADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Id_comp_drug", getId_comp_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品对照主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}

	/**
	 * 所属集团属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Id_grp", getId_grpCDesc(tblDesc), this);
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
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Id_org", getId_orgCDesc(tblDesc), this);
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
	 * 医保产品属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Id_hp", getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保产品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}

	/**
	 * HIS药品属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drugADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Id_drug", getId_drugCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIS药品");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}

	/**
	 * 药品编码属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCodeADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Code", getCodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}

	/**
	 * 状态属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_statusADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Eu_status", getEu_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}

	/**
	 * 审批时间属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_approvedADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Dt_approved", getDt_approvedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审批时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}

	/**
	 * 创建人属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Createdby", getCreatedbyCDesc(tblDesc), this);
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
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Createdtime", getCreatedtimeCDesc(tblDesc), this);
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
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Modifiedby", getModifiedbyCDesc(tblDesc), this);
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
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Modifiedtime", getModifiedtimeCDesc(tblDesc), this);
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
	 * 医保产品名称属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHp_nameADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Hp_name", getHp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保产品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[] { "BD_MHI_HP a0b4", "id_hp=id_hp", "name" });
		attrDesc.setRefType(false);
		return attrDesc;
	}

	/**
	 * HIS药品物品名称属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_nameADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Drug_name", getDrug_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("HIS药品物品名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[] { "BD_MM a0b5", "id_drug=id_mm", "name" });
		attrDesc.setRefType(false);
		return attrDesc;
	}

	/**
	 * 药品编码属性元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrug_codeADesc(ITableDesc tblDesc) {
		Attr attrDesc = new Attr("Drug_code", getDrug_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[] { "BD_HP_DRUG a0b6", "code=id_drug", "code" });
		attrDesc.setRefType(false);
		return attrDesc;
	}

	/**
	 * 获取药品对照主键表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_comp_drugCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Id_comp_drug");
		column.setLength(20);
		column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("药品对照主键");
		return column;
	}

	/**
	 * 获取所属集团表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Id_grp");
		column.setLength(20);
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团");
		return column;
	}

	/**
	 * 获取所属组织表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Id_org");
		column.setLength(20);
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织");
		return column;
	}

	/**
	 * 获取医保产品表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Id_hp");
		column.setLength(20);
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保产品");
		return column;
	}

	/**
	 * 获取HIS药品表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drugCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Id_drug");
		column.setLength(20);
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIS药品");
		return column;
	}

	/**
	 * 获取药品编码表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCodeCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Code");
		column.setLength(20);
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品编码");
		return column;
	}

	/**
	 * 获取状态表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_statusCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Eu_status");
		column.setLength(10);
		column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("状态");
		return column;
	}

	/**
	 * 获取审批时间表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_approvedCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Dt_approved");
		column.setLength(19);
		column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审批时间");
		return column;
	}

	/**
	 * 获取创建人表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Createdby");
		column.setLength(20);
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人");
		return column;
	}

	/**
	 * 获取创建时间表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Createdtime");
		column.setLength(19);
		column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间");
		return column;
	}

	/**
	 * 获取最后修改人表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Modifiedby");
		column.setLength(20);
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人");
		return column;
	}

	/**
	 * 获取最后修改时间表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Modifiedtime");
		column.setLength(19);
		column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间");
		return column;
	}

	/**
	 * 获取医保产品名称表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHp_nameCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Hp_name");
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保产品名称");
		return column;
	}

	/**
	 * 获取HIS药品物品名称表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_nameCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Drug_name");
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("HIS药品物品名称");
		return column;
	}

	/**
	 * 获取药品编码表列元数据
	 * 
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrug_codeCDesc(ITableDesc tblDesc) {
		ColumnDesc column = new ColumnDesc(tblDesc, "Drug_code");
		column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品编码");
		return column;
	}

	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap() {
		iBDDataInfoFldMap = new HashMap<String, String>();
		iBDDataInfoFldMap.put("id", "Id_comp_drug");
		iBDDataInfoFldMap.put("id_org", "Id_org");
		iBDDataInfoFldMap.put("id_group", "Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系
	 */
	private void setIAuditInfoFldMap() {
		iAuditInfoFldMap = new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby", "Createdby");
		iAuditInfoFldMap.put("createdtime", "Createdtime");
		iAuditInfoFldMap.put("modifiedby", "Modifiedby");
		iAuditInfoFldMap.put("modifiedtime", "Modifiedtime");
	}

	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap() {
		defaultValueMap = new HashMap<String, Object>();
	}

}