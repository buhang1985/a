
package iih.pe.phm.peeduplan.d.desc;

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
 * 健康群体教育计划明细 DO 元数据信息
 */
public class PeEduPlanDtlDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.peeduplan.d.PeEduPlanDtlDO";
	public static final String CLASS_DISPALYNAME = "健康群体教育计划明细";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_eduplandtl";
	public static final String TABLE_ALIAS_NAME = "a1";
	public static final String PRIMARYKEY_FIELDNAME="Id_peeduplandel";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeEduPlanDtlDODesc(){
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
		this.setKeyDesc(getId_peeduplandelADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.setFKeyDesc(getId_peeduplanADesc(tblDesc));
		this.add(getId_peeduplandelADesc(tblDesc));
		this.add(getId_peeduplanADesc(tblDesc));
		this.add(getId_edurecipeADesc(tblDesc));
		this.add(getContADesc(tblDesc));
		this.add(getGoalADesc(tblDesc));
		this.add(getDt_beginADesc(tblDesc));
		this.add(getDt_endADesc(tblDesc));
		this.add(getDirectorADesc(tblDesc));
		this.add(getBudgetADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getFg_finishADesc(tblDesc));
		this.add(getDt_finishADesc(tblDesc));
		this.add(getCode_recipeADesc(tblDesc));
		this.add(getName_recipeADesc(tblDesc));
		this.add(getExplain_recipeADesc(tblDesc));
		this.add(getSymptom_recipeADesc(tblDesc));
		this.add(getMainrisks_recipeADesc(tblDesc));
		this.add(getKeypoint_recipeADesc(tblDesc));
		this.add(getNote_recipeADesc(tblDesc));
		this.add(getCode_psnADesc(tblDesc));
		this.add(getName_psnADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_peeduplandelCDesc(tblDesc));
		tblDesc.add(getId_peeduplandelCDesc(tblDesc));
		tblDesc.add(getId_peeduplanCDesc(tblDesc));
		tblDesc.add(getId_edurecipeCDesc(tblDesc));
		tblDesc.add(getContCDesc(tblDesc));
		tblDesc.add(getGoalCDesc(tblDesc));
		tblDesc.add(getDt_beginCDesc(tblDesc));
		tblDesc.add(getDt_endCDesc(tblDesc));
		tblDesc.add(getDirectorCDesc(tblDesc));
		tblDesc.add(getBudgetCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getFg_finishCDesc(tblDesc));
		tblDesc.add(getDt_finishCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 健康群体教育计划明细主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peeduplandelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peeduplandel",  getId_peeduplandelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康群体教育计划明细主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康群体教育计划ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peeduplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peeduplan",  getId_peeduplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康群体教育计划ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康教育处方ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_edurecipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_edurecipe",  getId_edurecipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康教育处方ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 教育内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cont",  getContCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 教育目标属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGoalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Goal",  getGoalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("教育目标");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_begin",  getDt_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("开始日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 截止日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_endADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end",  getDt_endCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("截止日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 负责人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDirectorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Director",  getDirectorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("负责人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预算属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBudgetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Budget",  getBudgetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("预算");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_finishADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_finish",  getFg_finishCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("完成标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 完成日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_finishADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_finish",  getDt_finishCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("完成日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_recipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_recipe",  getCode_recipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_edurecipe a1b3","id_edurecipe=id_edurecipe","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_recipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_recipe",  getName_recipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_edurecipe a1b3","id_edurecipe=id_edurecipe","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 解释属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getExplain_recipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Explain_recipe",  getExplain_recipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("解释");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_edurecipe a1b3","id_edurecipe=id_edurecipe","explain"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 症状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSymptom_recipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Symptom_recipe",  getSymptom_recipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_edurecipe a1b3","id_edurecipe=id_edurecipe","symptom"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主要危险因素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMainrisks_recipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mainrisks_recipe",  getMainrisks_recipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主要危险因素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_edurecipe a1b3","id_edurecipe=id_edurecipe","mainrisks"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保健要点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKeypoint_recipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Keypoint_recipe",  getKeypoint_recipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保健要点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_edurecipe a1b3","id_edurecipe=id_edurecipe","keypoint"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特别说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_recipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_recipe",  getNote_recipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特别说明");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_hm_edurecipe a1b3","id_edurecipe=id_edurecipe","note"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_psn",  getCode_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b2","director=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn",  getName_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a1b2","director=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取健康群体教育计划明细主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peeduplandelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peeduplandel");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("健康群体教育计划明细主键标识"); 
		return column;
	}
	/**
	 * 获取健康群体教育计划ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peeduplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peeduplan");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康群体教育计划ID"); 
		return column;
	}
	/**
	 * 获取健康教育处方ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_edurecipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_edurecipe");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康教育处方ID"); 
		return column;
	}
	/**
	 * 获取教育内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cont");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育内容"); 
		return column;
	}
	/**
	 * 获取教育目标表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGoalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Goal");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("教育目标"); 
		return column;
	}
	/**
	 * 获取开始日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开始日期"); 
		return column;
	}
	/**
	 * 获取截止日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_endCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("截止日期"); 
		return column;
	}
	/**
	 * 获取负责人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDirectorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Director");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("负责人"); 
		return column;
	}
	/**
	 * 获取预算表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBudgetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Budget");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("预算"); 
		return column;
	}
	/**
	 * 获取说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("说明"); 
		return column;
	}
	/**
	 * 获取完成标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_finishCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_finish");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("完成标识"); 
		return column;
	}
	/**
	 * 获取完成日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_finishCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_finish");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("完成日期"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_recipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_recipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_recipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_recipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名单"); 
		return column;
	}
	/**
	 * 获取解释表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getExplain_recipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Explain_recipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("解释"); 
		return column;
	}
	/**
	 * 获取症状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSymptom_recipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Symptom_recipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状"); 
		return column;
	}
	/**
	 * 获取主要危险因素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMainrisks_recipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mainrisks_recipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主要危险因素"); 
		return column;
	}
	/**
	 * 获取保健要点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getKeypoint_recipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Keypoint_recipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保健要点"); 
		return column;
	}
	/**
	 * 获取特别说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_recipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_recipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特别说明"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_psn");
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
	private IColumnDesc getName_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn");
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
		iBDDataInfoFldMap.put("id","Id_peeduplandel");
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
