
package iih.pe.phm.pesurveycma.d.desc;

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
 * 体检自测问卷 DO 元数据信息
 */
public class PeSurveyCmaDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pesurveycma.d.PeSurveyCmaDO";
	public static final String CLASS_DISPALYNAME = "体检自测问卷";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_pesurveycma";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pesurveycma";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PeSurveyCmaDODesc(){
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
		this.setKeyDesc(getId_pesurveycmaADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pesurveycmaADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getSexADesc(tblDesc));
		this.add(getBirthdateADesc(tblDesc));
		this.add(getFg_nationADesc(tblDesc));
		this.add(getNamtion_minorityADesc(tblDesc));
		this.add(getBirthplaceADesc(tblDesc));
		this.add(getMarital_statusADesc(tblDesc));
		this.add(getEducationADesc(tblDesc));
		this.add(getOccupationADesc(tblDesc));
		this.add(getMedical_insuranceADesc(tblDesc));
		this.add(getTelADesc(tblDesc));
		this.add(getQ1ADesc(tblDesc));
		this.add(getQ1_1ADesc(tblDesc));
		this.add(getQ1_2ADesc(tblDesc));
		this.add(getQ1_3ADesc(tblDesc));
		this.add(getQ2ADesc(tblDesc));
		this.add(getQ2_1ADesc(tblDesc));
		this.add(getQ2_2ADesc(tblDesc));
		this.add(getQ2_3ADesc(tblDesc));
		this.add(getQ3ADesc(tblDesc));
		this.add(getQ3_1ADesc(tblDesc));
		this.add(getQ4ADesc(tblDesc));
		this.add(getQ4_1ADesc(tblDesc));
		this.add(getQ5ADesc(tblDesc));
		this.add(getQ5_1ADesc(tblDesc));
		this.add(getQ6ADesc(tblDesc));
		this.add(getQ7ADesc(tblDesc));
		this.add(getQ7_1ADesc(tblDesc));
		this.add(getQ8ADesc(tblDesc));
		this.add(getQ9ADesc(tblDesc));
		this.add(getQ9_1_1ADesc(tblDesc));
		this.add(getQ9_1_2ADesc(tblDesc));
		this.add(getQ9_1_3ADesc(tblDesc));
		this.add(getQ9_2ADesc(tblDesc));
		this.add(getQ9_3ADesc(tblDesc));
		this.add(getQ9_4ADesc(tblDesc));
		this.add(getQ9_5ADesc(tblDesc));
		this.add(getQ10ADesc(tblDesc));
		this.add(getQ11ADesc(tblDesc));
		this.add(getQ12ADesc(tblDesc));
		this.add(getQ13ADesc(tblDesc));
		this.add(getQ14ADesc(tblDesc));
		this.add(getQ15ADesc(tblDesc));
		this.add(getQ16ADesc(tblDesc));
		this.add(getQ17ADesc(tblDesc));
		this.add(getQ18ADesc(tblDesc));
		this.add(getQ19ADesc(tblDesc));
		this.add(getQ20ADesc(tblDesc));
		this.add(getQ21ADesc(tblDesc));
		this.add(getQ22ADesc(tblDesc));
		this.add(getQ23ADesc(tblDesc));
		this.add(getQ24ADesc(tblDesc));
		this.add(getQ25ADesc(tblDesc));
		this.add(getQ26ADesc(tblDesc));
		this.add(getQ27ADesc(tblDesc));
		this.add(getQ28ADesc(tblDesc));
		this.add(getQ29ADesc(tblDesc));
		this.add(getQ30ADesc(tblDesc));
		this.add(getQ31ADesc(tblDesc));
		this.add(getQ32ADesc(tblDesc));
		this.add(getQ33ADesc(tblDesc));
		this.add(getQ34ADesc(tblDesc));
		this.add(getQ34_1ADesc(tblDesc));
		this.add(getQ35ADesc(tblDesc));
		this.add(getQ36ADesc(tblDesc));
		this.add(getQ37ADesc(tblDesc));
		this.add(getQ38ADesc(tblDesc));
		this.add(getQ39ADesc(tblDesc));
		this.add(getQ40ADesc(tblDesc));
		this.add(getQ41ADesc(tblDesc));
		this.add(getQ42ADesc(tblDesc));
		this.add(getQ43ADesc(tblDesc));
		this.add(getQ44ADesc(tblDesc));
		this.add(getQ45ADesc(tblDesc));
		this.add(getQ46ADesc(tblDesc));
		this.add(getQ47ADesc(tblDesc));
		this.add(getQ48ADesc(tblDesc));
		this.add(getQ49ADesc(tblDesc));
		this.add(getQ50ADesc(tblDesc));
		this.add(getQ51ADesc(tblDesc));
		this.add(getQ52ADesc(tblDesc));
		this.add(getQ53ADesc(tblDesc));
		this.add(getQ53_1ADesc(tblDesc));
		this.add(getQ53_2ADesc(tblDesc));
		this.add(getQ53_3ADesc(tblDesc));
		this.add(getQ54ADesc(tblDesc));
		this.add(getQ54_1ADesc(tblDesc));
		this.add(getQ54_2ADesc(tblDesc));
		this.add(getQ54_3ADesc(tblDesc));
		this.add(getQ54_4ADesc(tblDesc));
		this.add(getQ54_5ADesc(tblDesc));
		this.add(getQ55ADesc(tblDesc));
		this.add(getQ55_1ADesc(tblDesc));
		this.add(getQ55_2ADesc(tblDesc));
		this.add(getQ55_3ADesc(tblDesc));
		this.add(getQ55_4ADesc(tblDesc));
		this.add(getQ56ADesc(tblDesc));
		this.add(getQ56_1ADesc(tblDesc));
		this.add(getQ56_2ADesc(tblDesc));
		this.add(getQ57ADesc(tblDesc));
		this.add(getQ58ADesc(tblDesc));
		this.add(getQ59ADesc(tblDesc));
		this.add(getQ60ADesc(tblDesc));
		this.add(getQ61ADesc(tblDesc));
		this.add(getQ62ADesc(tblDesc));
		this.add(getQ63ADesc(tblDesc));
		this.add(getQ64ADesc(tblDesc));
		this.add(getQ65ADesc(tblDesc));
		this.add(getQ66ADesc(tblDesc));
		this.add(getQ67ADesc(tblDesc));
		this.add(getQ68ADesc(tblDesc));
		this.add(getQ68_1ADesc(tblDesc));
		this.add(getQ68_2ADesc(tblDesc));
		this.add(getQ69ADesc(tblDesc));
		this.add(getQ70ADesc(tblDesc));
		this.add(getQ71ADesc(tblDesc));
		this.add(getQ71_1ADesc(tblDesc));
		this.add(getQ72ADesc(tblDesc));
		this.add(getQ73ADesc(tblDesc));
		this.add(getQ74ADesc(tblDesc));
		this.add(getQ75ADesc(tblDesc));
		this.add(getQ76ADesc(tblDesc));
		this.add(getQ77ADesc(tblDesc));
		this.add(getQ78ADesc(tblDesc));
		this.add(getQ79ADesc(tblDesc));
		this.add(getQ80ADesc(tblDesc));
		this.add(getQ81ADesc(tblDesc));
		this.add(getQ82_1ADesc(tblDesc));
		this.add(getQ82_2ADesc(tblDesc));
		this.add(getQ83ADesc(tblDesc));
		this.add(getQ84ADesc(tblDesc));
		this.add(getQ85ADesc(tblDesc));
		this.add(getQ86ADesc(tblDesc));
		this.add(getQ87ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_pehmapptADesc(tblDesc));
		this.add(getName_psnADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getIdcodeADesc(tblDesc));
		this.add(getDt_birthADesc(tblDesc));
		this.add(getCode_sexADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getCode_nationADesc(tblDesc));
		this.add(getName_nationADesc(tblDesc));
		this.add(getCode_marADesc(tblDesc));
		this.add(getName_marADesc(tblDesc));
		this.add(getCode_eduADesc(tblDesc));
		this.add(getName_eduADesc(tblDesc));
		this.add(getName_q1_1ADesc(tblDesc));
		this.add(getName_q1_2ADesc(tblDesc));
		this.add(getName_q2_1ADesc(tblDesc));
		this.add(getName_q2_2ADesc(tblDesc));
		this.add(getName_q3_1ADesc(tblDesc));
		this.add(getName_q4_1ADesc(tblDesc));
		this.add(getName_q5_1ADesc(tblDesc));
		this.add(getName_q10ADesc(tblDesc));
		this.add(getName_q11ADesc(tblDesc));
		this.add(getName_q12ADesc(tblDesc));
		this.add(getName_q13ADesc(tblDesc));
		this.add(getName_q14ADesc(tblDesc));
		this.add(getName_q15ADesc(tblDesc));
		this.add(getName_q16ADesc(tblDesc));
		this.add(getName_q17ADesc(tblDesc));
		this.add(getName_q18ADesc(tblDesc));
		this.add(getName_q19ADesc(tblDesc));
		this.add(getName_q20ADesc(tblDesc));
		this.add(getName_q21ADesc(tblDesc));
		this.add(getName_q22ADesc(tblDesc));
		this.add(getName_q23ADesc(tblDesc));
		this.add(getName_q24ADesc(tblDesc));
		this.add(getName_q25ADesc(tblDesc));
		this.add(getName_q26ADesc(tblDesc));
		this.add(getName_q27ADesc(tblDesc));
		this.add(getName_q28ADesc(tblDesc));
		this.add(getName_q29ADesc(tblDesc));
		this.add(getName_q30ADesc(tblDesc));
		this.add(getName_34_1ADesc(tblDesc));
		this.add(getName_q35ADesc(tblDesc));
		this.add(getName_q37ADesc(tblDesc));
		this.add(getName_q38ADesc(tblDesc));
		this.add(getName_q39ADesc(tblDesc));
		this.add(getName_q40ADesc(tblDesc));
		this.add(getName_q41ADesc(tblDesc));
		this.add(getName_q42ADesc(tblDesc));
		this.add(getName_q43ADesc(tblDesc));
		this.add(getName_q44ADesc(tblDesc));
		this.add(getName_q45ADesc(tblDesc));
		this.add(getName_q46ADesc(tblDesc));
		this.add(getName_q47ADesc(tblDesc));
		this.add(getName_q48ADesc(tblDesc));
		this.add(getName_q49ADesc(tblDesc));
		this.add(getName_q50ADesc(tblDesc));
		this.add(getName_q51ADesc(tblDesc));
		this.add(getName_q52ADesc(tblDesc));
		this.add(getName_q53ADesc(tblDesc));
		this.add(getName_q54ADesc(tblDesc));
		this.add(getName_q54_1ADesc(tblDesc));
		this.add(getName_q54_2ADesc(tblDesc));
		this.add(getName_q54_3ADesc(tblDesc));
		this.add(getName_q55ADesc(tblDesc));
		this.add(getName_q55_1ADesc(tblDesc));
		this.add(getName_q55_2ADesc(tblDesc));
		this.add(getName_q55_3ADesc(tblDesc));
		this.add(getName_q56ADesc(tblDesc));
		this.add(getName_q56_1ADesc(tblDesc));
		this.add(getName_q57ADesc(tblDesc));
		this.add(getName_q58ADesc(tblDesc));
		this.add(getName_q59ADesc(tblDesc));
		this.add(getName_q60ADesc(tblDesc));
		this.add(getName_q61ADesc(tblDesc));
		this.add(getName_q62ADesc(tblDesc));
		this.add(getName_q63ADesc(tblDesc));
		this.add(getName_q64ADesc(tblDesc));
		this.add(getName_q65ADesc(tblDesc));
		this.add(getName_q66ADesc(tblDesc));
		this.add(getName_q67ADesc(tblDesc));
		this.add(getName_68ADesc(tblDesc));
		this.add(getName_q68_1ADesc(tblDesc));
		this.add(getName_q68_2ADesc(tblDesc));
		this.add(getName_q69ADesc(tblDesc));
		this.add(getName_q70ADesc(tblDesc));
		this.add(getName_q71_1ADesc(tblDesc));
		this.add(getName_q72ADesc(tblDesc));
		this.add(getName_q73ADesc(tblDesc));
		this.add(getName_q74ADesc(tblDesc));
		this.add(getName_q75ADesc(tblDesc));
		this.add(getName_q76ADesc(tblDesc));
		this.add(getName_q77ADesc(tblDesc));
		this.add(getName_q78ADesc(tblDesc));
		this.add(getName_q79ADesc(tblDesc));
		this.add(getName_q80ADesc(tblDesc));
		this.add(getName_q81ADesc(tblDesc));
		this.add(getName_82_1ADesc(tblDesc));
		this.add(getName_q82_2ADesc(tblDesc));
		this.add(getName_q83ADesc(tblDesc));
		this.add(getName_q84ADesc(tblDesc));
		this.add(getName_85ADesc(tblDesc));
		this.add(getName_q86ADesc(tblDesc));
		this.add(getName_q87ADesc(tblDesc));
		this.add(getDt_apptADesc(tblDesc));
		this.add(getNo_apptADesc(tblDesc));
		this.add(getHmstatusADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pesurveycmaCDesc(tblDesc));
		tblDesc.add(getId_pesurveycmaCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getNameCDesc(tblDesc));
		tblDesc.add(getSexCDesc(tblDesc));
		tblDesc.add(getBirthdateCDesc(tblDesc));
		tblDesc.add(getFg_nationCDesc(tblDesc));
		tblDesc.add(getNamtion_minorityCDesc(tblDesc));
		tblDesc.add(getBirthplaceCDesc(tblDesc));
		tblDesc.add(getMarital_statusCDesc(tblDesc));
		tblDesc.add(getEducationCDesc(tblDesc));
		tblDesc.add(getOccupationCDesc(tblDesc));
		tblDesc.add(getMedical_insuranceCDesc(tblDesc));
		tblDesc.add(getTelCDesc(tblDesc));
		tblDesc.add(getQ1CDesc(tblDesc));
		tblDesc.add(getQ1_1CDesc(tblDesc));
		tblDesc.add(getQ1_2CDesc(tblDesc));
		tblDesc.add(getQ1_3CDesc(tblDesc));
		tblDesc.add(getQ2CDesc(tblDesc));
		tblDesc.add(getQ2_1CDesc(tblDesc));
		tblDesc.add(getQ2_2CDesc(tblDesc));
		tblDesc.add(getQ2_3CDesc(tblDesc));
		tblDesc.add(getQ3CDesc(tblDesc));
		tblDesc.add(getQ3_1CDesc(tblDesc));
		tblDesc.add(getQ4CDesc(tblDesc));
		tblDesc.add(getQ4_1CDesc(tblDesc));
		tblDesc.add(getQ5CDesc(tblDesc));
		tblDesc.add(getQ5_1CDesc(tblDesc));
		tblDesc.add(getQ6CDesc(tblDesc));
		tblDesc.add(getQ7CDesc(tblDesc));
		tblDesc.add(getQ7_1CDesc(tblDesc));
		tblDesc.add(getQ8CDesc(tblDesc));
		tblDesc.add(getQ9CDesc(tblDesc));
		tblDesc.add(getQ9_1_1CDesc(tblDesc));
		tblDesc.add(getQ9_1_2CDesc(tblDesc));
		tblDesc.add(getQ9_1_3CDesc(tblDesc));
		tblDesc.add(getQ9_2CDesc(tblDesc));
		tblDesc.add(getQ9_3CDesc(tblDesc));
		tblDesc.add(getQ9_4CDesc(tblDesc));
		tblDesc.add(getQ9_5CDesc(tblDesc));
		tblDesc.add(getQ10CDesc(tblDesc));
		tblDesc.add(getQ11CDesc(tblDesc));
		tblDesc.add(getQ12CDesc(tblDesc));
		tblDesc.add(getQ13CDesc(tblDesc));
		tblDesc.add(getQ14CDesc(tblDesc));
		tblDesc.add(getQ15CDesc(tblDesc));
		tblDesc.add(getQ16CDesc(tblDesc));
		tblDesc.add(getQ17CDesc(tblDesc));
		tblDesc.add(getQ18CDesc(tblDesc));
		tblDesc.add(getQ19CDesc(tblDesc));
		tblDesc.add(getQ20CDesc(tblDesc));
		tblDesc.add(getQ21CDesc(tblDesc));
		tblDesc.add(getQ22CDesc(tblDesc));
		tblDesc.add(getQ23CDesc(tblDesc));
		tblDesc.add(getQ24CDesc(tblDesc));
		tblDesc.add(getQ25CDesc(tblDesc));
		tblDesc.add(getQ26CDesc(tblDesc));
		tblDesc.add(getQ27CDesc(tblDesc));
		tblDesc.add(getQ28CDesc(tblDesc));
		tblDesc.add(getQ29CDesc(tblDesc));
		tblDesc.add(getQ30CDesc(tblDesc));
		tblDesc.add(getQ31CDesc(tblDesc));
		tblDesc.add(getQ32CDesc(tblDesc));
		tblDesc.add(getQ33CDesc(tblDesc));
		tblDesc.add(getQ34CDesc(tblDesc));
		tblDesc.add(getQ34_1CDesc(tblDesc));
		tblDesc.add(getQ35CDesc(tblDesc));
		tblDesc.add(getQ36CDesc(tblDesc));
		tblDesc.add(getQ37CDesc(tblDesc));
		tblDesc.add(getQ38CDesc(tblDesc));
		tblDesc.add(getQ39CDesc(tblDesc));
		tblDesc.add(getQ40CDesc(tblDesc));
		tblDesc.add(getQ41CDesc(tblDesc));
		tblDesc.add(getQ42CDesc(tblDesc));
		tblDesc.add(getQ43CDesc(tblDesc));
		tblDesc.add(getQ44CDesc(tblDesc));
		tblDesc.add(getQ45CDesc(tblDesc));
		tblDesc.add(getQ46CDesc(tblDesc));
		tblDesc.add(getQ47CDesc(tblDesc));
		tblDesc.add(getQ48CDesc(tblDesc));
		tblDesc.add(getQ49CDesc(tblDesc));
		tblDesc.add(getQ50CDesc(tblDesc));
		tblDesc.add(getQ51CDesc(tblDesc));
		tblDesc.add(getQ52CDesc(tblDesc));
		tblDesc.add(getQ53CDesc(tblDesc));
		tblDesc.add(getQ53_1CDesc(tblDesc));
		tblDesc.add(getQ53_2CDesc(tblDesc));
		tblDesc.add(getQ53_3CDesc(tblDesc));
		tblDesc.add(getQ54CDesc(tblDesc));
		tblDesc.add(getQ54_1CDesc(tblDesc));
		tblDesc.add(getQ54_2CDesc(tblDesc));
		tblDesc.add(getQ54_3CDesc(tblDesc));
		tblDesc.add(getQ54_4CDesc(tblDesc));
		tblDesc.add(getQ54_5CDesc(tblDesc));
		tblDesc.add(getQ55CDesc(tblDesc));
		tblDesc.add(getQ55_1CDesc(tblDesc));
		tblDesc.add(getQ55_2CDesc(tblDesc));
		tblDesc.add(getQ55_3CDesc(tblDesc));
		tblDesc.add(getQ55_4CDesc(tblDesc));
		tblDesc.add(getQ56CDesc(tblDesc));
		tblDesc.add(getQ56_1CDesc(tblDesc));
		tblDesc.add(getQ56_2CDesc(tblDesc));
		tblDesc.add(getQ57CDesc(tblDesc));
		tblDesc.add(getQ58CDesc(tblDesc));
		tblDesc.add(getQ59CDesc(tblDesc));
		tblDesc.add(getQ60CDesc(tblDesc));
		tblDesc.add(getQ61CDesc(tblDesc));
		tblDesc.add(getQ62CDesc(tblDesc));
		tblDesc.add(getQ63CDesc(tblDesc));
		tblDesc.add(getQ64CDesc(tblDesc));
		tblDesc.add(getQ65CDesc(tblDesc));
		tblDesc.add(getQ66CDesc(tblDesc));
		tblDesc.add(getQ67CDesc(tblDesc));
		tblDesc.add(getQ68CDesc(tblDesc));
		tblDesc.add(getQ68_1CDesc(tblDesc));
		tblDesc.add(getQ68_2CDesc(tblDesc));
		tblDesc.add(getQ69CDesc(tblDesc));
		tblDesc.add(getQ70CDesc(tblDesc));
		tblDesc.add(getQ71CDesc(tblDesc));
		tblDesc.add(getQ71_1CDesc(tblDesc));
		tblDesc.add(getQ72CDesc(tblDesc));
		tblDesc.add(getQ73CDesc(tblDesc));
		tblDesc.add(getQ74CDesc(tblDesc));
		tblDesc.add(getQ75CDesc(tblDesc));
		tblDesc.add(getQ76CDesc(tblDesc));
		tblDesc.add(getQ77CDesc(tblDesc));
		tblDesc.add(getQ78CDesc(tblDesc));
		tblDesc.add(getQ79CDesc(tblDesc));
		tblDesc.add(getQ80CDesc(tblDesc));
		tblDesc.add(getQ81CDesc(tblDesc));
		tblDesc.add(getQ82_1CDesc(tblDesc));
		tblDesc.add(getQ82_2CDesc(tblDesc));
		tblDesc.add(getQ83CDesc(tblDesc));
		tblDesc.add(getQ84CDesc(tblDesc));
		tblDesc.add(getQ85CDesc(tblDesc));
		tblDesc.add(getQ86CDesc(tblDesc));
		tblDesc.add(getQ87CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_pehmapptCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检自测问卷主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pesurveycmaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pesurveycma",  getId_pesurveycmaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检自测问卷主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 体检预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnappt",  getId_pepsnapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检客户ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsnbinfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsnbinfo",  getId_pepsnbinfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检客户ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex",  getSexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirthdateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birthdate",  getBirthdateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 汉族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_nation",  getFg_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("汉族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 少数民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNamtion_minorityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Namtion_minority",  getNamtion_minorityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("少数民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出生地属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirthplaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birthplace",  getBirthplaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出生地");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 婚姻状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMarital_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Marital_status",  getMarital_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("婚姻状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文化程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEducationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Education",  getEducationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职业属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOccupationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Occupation",  getOccupationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保类别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedical_insuranceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medical_insurance",  getMedical_insuranceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保类别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel",  getTelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您父母或兄弟是否患有明确诊断的疾病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q1",  getQ1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您父母或兄弟是否患有明确诊断的疾病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请选择疾病名称（可多选）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ1_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q1_1",  getQ1_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请选择疾病名称（可多选）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请确定所患的恶性肿瘤名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ1_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q1_2",  getQ1_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请确定所患的恶性肿瘤名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您的父亲是否在 55 岁、母亲在 65 岁之前患有上述疾病吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ1_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q1_3",  getQ1_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您的父亲是否在 55 岁、母亲在 65 岁之前患有上述疾病吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您是否患有明确诊断的疾病或异常？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q2",  getQ2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否患有明确诊断的疾病或异常？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请您确认具体疾病或异常的名称：属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ2_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q2_1",  getQ2_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请您确认具体疾病或异常的名称：");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请确定您所患的恶性肿瘤名称:属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ2_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q2_2",  getQ2_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请确定您所患的恶性肿瘤名称:");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请填写您被诊断患有上述疾病或异常的年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ2_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q2_3",  getQ2_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("请填写您被诊断患有上述疾病或异常的年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您是否出现过过敏？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q3",  getQ3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否出现过过敏？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请选择过敏源:属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ3_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q3_1",  getQ3_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请选择过敏源:");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您是否长期服用药物？（连续服用 6 个月以上，平均每日服用一次以上）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q4",  getQ4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否长期服用药物？（连续服用 6 个月以上，平均每日服用一次以上）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您长期服用哪些药物？（可多选）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ4_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q4_1",  getQ4_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您长期服用哪些药物？（可多选）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您是否因病进行过手术治疗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q5",  getQ5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否因病进行过手术治疗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请您选择手术的部位？（可多选）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ5_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q5_1",  getQ5_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请您选择手术的部位？（可多选）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您第一次来月经的年龄：属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q6",  getQ6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您第一次来月经的年龄：");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您是否绝经？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q7",  getQ7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否绝经？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 绝经年龄： 岁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ7_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q7_1",  getQ7_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("绝经年龄： 岁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您的结婚年龄：属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q8",  getQ8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您的结婚年龄：");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您是否生育过？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9",  getQ9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否生育过？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 初产年龄： 岁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9_1_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9_1_1",  getQ9_1_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("初产年龄： 岁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产 次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9_1_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9_1_2",  getQ9_1_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("生产 次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流产总次数 次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9_1_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9_1_3",  getQ9_1_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("流产总次数 次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您的孩子是母乳喂养吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9_2",  getQ9_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您的孩子是母乳喂养吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 哺乳时间 月属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9_3",  getQ9_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("哺乳时间 月");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您是否曾患有妊娠糖尿病？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9_4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9_4",  getQ9_4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否曾患有妊娠糖尿病？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您是否曾患有妊娠高血压？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9_5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9_5",  getQ9_5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否曾患有妊娠高血压？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您感觉身体总体健康状况如何?属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q10",  getQ10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感觉身体总体健康状况如何?");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到疲劳乏力或周身明显不适吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q11",  getQ11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到疲劳乏力或周身明显不适吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您视力有下降吗？ 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q12",  getQ12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您视力有下降吗？ ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您听力有下降吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q13",  getQ13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您听力有下降吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您有鼻出血或浓血鼻涕吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q14",  getQ14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您有鼻出血或浓血鼻涕吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您出现过吞咽不适、哽噎感吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q15",  getQ15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您出现过吞咽不适、哽噎感吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您有明显的咳嗽、咳痰吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q16",  getQ16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您有明显的咳嗽、咳痰吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您有过咳痰带血或咯血吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q17",  getQ17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您有过咳痰带血或咯血吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到胸痛或心前区憋闷不适吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q18",  getQ18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到胸痛或心前区憋闷不适吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到有胸闷气喘或呼吸困难吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q19",  getQ19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到有胸闷气喘或呼吸困难吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到低热（体温偏高）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q20",  getQ20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到低热（体温偏高）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到头晕或头昏吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q21",  getQ21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到头晕或头昏吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到恶心、反酸或上腹部不适吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q22",  getQ22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到恶心、反酸或上腹部不适吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您有过食欲不振、消化不良或腹胀吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q23",  getQ23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您有过食欲不振、消化不良或腹胀吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您有过不明原因跌倒或晕倒吗？ 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q24",  getQ24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您有过不明原因跌倒或晕倒吗？ ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到明显的手足发麻或刺痛吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q25",  getQ25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到明显的手足发麻或刺痛吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您双下肢水肿吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q26",  getQ26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您双下肢水肿吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您排尿困难吗？ 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q27",  getQ27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您排尿困难吗？ ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您有尿频、尿急、尿痛及尿血吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q28",  getQ28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您有尿频、尿急、尿痛及尿血吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您有腹泻、腹痛或大便习惯改变（入厕时间、次数、形状等）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q29",  getQ29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您有腹泻、腹痛或大便习惯改变（入厕时间、次数、形状等）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您出现过柏油样便或便中带血吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q30",  getQ30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您出现过柏油样便或便中带血吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您出现过不明原因的身体消瘦或体重减轻吗？（体重减轻超过原体重的 10%）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ31ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q31",  getQ31CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您出现过不明原因的身体消瘦或体重减轻吗？（体重减轻超过原体重的 10%）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您是否发现乳房有包块，并伴有胀痛吗（与月经周期无关）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ32ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q32",  getQ32CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否发现乳房有包块，并伴有胀痛吗（与月经周期无关）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您有不明原因的阴道出血、白带异常吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ33ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q33",  getQ33CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您有不明原因的阴道出血、白带异常吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您身体有过明显的疼痛吗？（外伤除外） 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ34ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q34",  getQ34CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您身体有过明显的疼痛吗？（外伤除外） ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛的部位？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ34_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q34_1",  getQ34_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛的部位？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您通常能够按时吃三餐吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q35",  getQ35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您通常能够按时吃三餐吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您常暴饮暴食吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ36ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q36",  getQ36CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您常暴饮暴食吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您常吃夜宵吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q37",  getQ37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您常吃夜宵吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您参加请客吃饭（应酬）情况？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q38",  getQ38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您参加请客吃饭（应酬）情况？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您的饮食口味？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q39",  getQ39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您的饮食口味？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您的饮食偏好？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q40",  getQ40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您的饮食偏好？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您的主食结构如何？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q41",  getQ41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您的主食结构如何？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您喝牛奶吗？ 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q42",  getQ42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您喝牛奶吗？ ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您吃鸡蛋吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q43",  getQ43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您吃鸡蛋吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您吃豆类及豆制品吗?属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q44",  getQ44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您吃豆类及豆制品吗?");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您吃水果吗？ 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q45",  getQ45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您吃水果吗？ ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您平均每天吃多少蔬菜？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q46",  getQ46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您平均每天吃多少蔬菜？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您平均每天吃多少肉（猪、牛、羊、禽）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q47",  getQ47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您平均每天吃多少肉（猪、牛、羊、禽）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您吃肥肉吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q48",  getQ48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您吃肥肉吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您吃动物内脏吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q49",  getQ49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您吃动物内脏吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您吃鱼肉或海鲜吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q50",  getQ50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您吃鱼肉或海鲜吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您喝咖啡吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ51ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q51",  getQ51CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您喝咖啡吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您喝含糖饮料（果汁、可乐等）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ52ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q52",  getQ52CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您喝含糖饮料（果汁、可乐等）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您吸烟吗？（持续吸烟 1 年以上）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ53ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q53",  getQ53CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您吸烟吗？（持续吸烟 1 年以上）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您通常每天吸多少支烟？（含戒烟前） 支属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ53_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q53_1",  getQ53_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您通常每天吸多少支烟？（含戒烟前） 支");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ,您持续吸烟的年限？（含戒烟前） 年属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ53_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q53_2",  getQ53_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel(",您持续吸烟的年限？（含戒烟前） 年");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您戒烟多长时间了？ 年属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ53_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q53_3",  getQ53_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您戒烟多长时间了？ 年");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您喝酒吗？（平均每周饮酒 1 次以上）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ54ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q54",  getQ54CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您喝酒吗？（平均每周饮酒 1 次以上）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您一般喝什么酒?属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ54_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q54_1",  getQ54_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您一般喝什么酒?");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您每周喝几次酒？（含戒酒前） 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ54_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q54_2",  getQ54_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您每周喝几次酒？（含戒酒前） ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您每次喝几两？（1 两相当于 50 ml 白酒，100 ml 红酒，300 ml 啤酒）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ54_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q54_3",  getQ54_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您每次喝几两？（1 两相当于 50 ml 白酒，100 ml 红酒，300 ml 啤酒）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您持续喝酒的年限？（含戒酒前） 年属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ54_4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q54_4",  getQ54_4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您持续喝酒的年限？（含戒酒前） 年");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您戒酒多长时间了 年属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ54_5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q54_5",  getQ54_5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您戒酒多长时间了 年");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您参加运动锻炼吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ55ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q55",  getQ55CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您参加运动锻炼吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您常采用的运动锻炼方式：（可多选）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ55_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q55_1",  getQ55_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您常采用的运动锻炼方式：（可多选）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您每周锻炼几次？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ55_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q55_2",  getQ55_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您每周锻炼几次？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您每次锻炼多次时间？ 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ55_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q55_3",  getQ55_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您每次锻炼多次时间？ ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您坚持锻炼多少年了？ 年属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ55_4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q55_4",  getQ55_4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您坚持锻炼多少年了？ 年");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您工作中的体力强度？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ56ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q56",  getQ56CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您工作中的体力强度？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您每周工作几天？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ56_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q56_1",  getQ56_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您每周工作几天？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您每天平均工作多长时间？ 小时属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ56_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q56_2",  getQ56_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("您每天平均工作多长时间？ 小时");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 除工作、学习时间外，您每天坐着（如看电视、上网、打麻将、打牌等）的时间是？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ57ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q57",  getQ57CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("除工作、学习时间外，您每天坐着（如看电视、上网、打麻将、打牌等）的时间是？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您的工作/生活场所经常会接触到哪些有害物质？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ58ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q58",  getQ58CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您的工作/生活场所经常会接触到哪些有害物质？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到闷闷不乐，情绪低落吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ59ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q59",  getQ59CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到闷闷不乐，情绪低落吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您容易情绪激动或生气吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ60ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q60",  getQ60CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您容易情绪激动或生气吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到精神紧张，很难放松吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ61ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q61",  getQ61CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到精神紧张，很难放松吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您比平常容易紧张和着急吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ62ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q62",  getQ62CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您比平常容易紧张和着急吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您容易发脾气，没有耐性吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ63ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q63",  getQ63CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您容易发脾气，没有耐性吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感到心力枯竭，对人对事缺乏热情吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ64ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q64",  getQ64CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感到心力枯竭，对人对事缺乏热情吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您容易焦虑不安、心烦意乱吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ65ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q65",  getQ65CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您容易焦虑不安、心烦意乱吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您感觉压抑或沮丧吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ66ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q66",  getQ66CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您感觉压抑或沮丧吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您注意力集中有困难吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ67ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q67",  getQ67CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您注意力集中有困难吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最近 1 个月，您的睡眠如何？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ68ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q68",  getQ68CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最近 1 个月，您的睡眠如何？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您睡眠差的主要表现：属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ68_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q68_1",  getQ68_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您睡眠差的主要表现：");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 影响您睡眠差的主要原因：属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ68_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q68_2",  getQ68_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("影响您睡眠差的主要原因：");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您每天平均睡眠时间：（不等于卧床时间）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ69ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q69",  getQ69CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您每天平均睡眠时间：（不等于卧床时间）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您多长时间做一次体检？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ70ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q70",  getQ70CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您多长时间做一次体检？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您是否主动获取医疗保健知识？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ71ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q71",  getQ71CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("您是否主动获取医疗保健知识？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 您获取医疗保健知识的途径？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ71_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q71_1",  getQ71_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您获取医疗保健知识的途径？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您入厕观察二便（大小便）吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ72ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q72",  getQ72CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您入厕观察二便（大小便）吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您自测血压、心率吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ73ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q73",  getQ73CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您自测血压、心率吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您出差或旅游带常用或急救药品吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ74ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q74",  getQ74CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您出差或旅游带常用或急救药品吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您乘坐私家车或出租车时系安全带吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ75ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q75",  getQ75CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您乘坐私家车或出租车时系安全带吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您经常晒太阳吗？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ76ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q76",  getQ76CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您经常晒太阳吗？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为以下血压值哪个最理想？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ77ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q77",  getQ77CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为以下血压值哪个最理想？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成年人腋下体温最理想的范围是？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ78ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q78",  getQ78CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成年人腋下体温最理想的范围是？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为安静状态下成年人最理想的脉搏次数是？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ79ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q79",  getQ79CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为安静状态下成年人最理想的脉搏次数是？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成年人每天最佳食盐量不要超过多少克？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ80ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q80",  getQ80CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成年人每天最佳食盐量不要超过多少克？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成年人正常体重指数是（体重指数=体重 kg/身高 m  2  ）？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ81ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q81",  getQ81CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成年人正常体重指数是（体重指数=体重 kg/身高 m  2  ）？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成年人正常腰围是？男性：属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ82_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q82_1",  getQ82_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成年人正常腰围是？男性：");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成年人正常腰围是？女性：属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ82_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q82_2",  getQ82_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成年人正常腰围是？女性：");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成人空腹血糖正常值是？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ83ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q83",  getQ83CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成人空腹血糖正常值是？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成人三酰甘油正常值是？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ84ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q84",  getQ84CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成人三酰甘油正常值是？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您认为成人总胆固醇理想值是？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ85ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q85",  getQ85CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您认为成人总胆固醇理想值是？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 答完该问卷后，您对自己的健康状态感觉如何？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ86ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q86",  getQ86CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("答完该问卷后，您对自己的健康状态感觉如何？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 您对该健康自测问卷的总体印象是？属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ87ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q87",  getQ87CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("您对该健康自测问卷的总体印象是？");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
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
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
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
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
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
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
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
	 * 健康管理预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pehmapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pehmappt",  getId_pehmapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康管理预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 客户姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn",  getName_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b2","id_pepsnbinfo=id_pepsnbinfo","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b2","id_pepsnbinfo=id_pepsnbinfo","sd_sex"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证件号码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIdcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Idcode",  getIdcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证件号码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b2","id_pepsnbinfo=id_pepsnbinfo","idcode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth",  getDt_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b2","id_pepsnbinfo=id_pepsnbinfo","dt_birth"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_sex",  getCode_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","sex=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_nation",  getCode_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","namtion_minority=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nation",  getName_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","namtion_minority=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_marADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_mar",  getCode_marCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","marital_status=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_marADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mar",  getName_marCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","marital_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_eduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_edu",  getCode_eduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","education=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eduADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_edu",  getName_eduCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","education=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q1_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q1_1",  getName_q1_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","q1_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q1_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q1_2",  getName_q1_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","q1_2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q2_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q2_1",  getName_q2_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","q2_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q2_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q2_2",  getName_q2_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","q2_2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q3_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q3_1",  getName_q3_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","q3_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q4_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q4_1",  getName_q4_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b36","q4_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q5_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q5_1",  getName_q5_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b37","q5_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q10",  getName_q10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","q10=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q11",  getName_q11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","q11=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q12",  getName_q12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","q12=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q13",  getName_q13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","q13=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q14",  getName_q14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","q14=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q15",  getName_q15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","q15=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q16",  getName_q16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","q16=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q17",  getName_q17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","q17=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q18",  getName_q18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","q18=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q19",  getName_q19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","q19=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q20",  getName_q20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","q20=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q21",  getName_q21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","q21=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q22",  getName_q22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","q22=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q23",  getName_q23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","q23=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q24",  getName_q24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","q24=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q25",  getName_q25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","q25=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q26",  getName_q26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","q26=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q27",  getName_q27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","q27=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q28",  getName_q28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","q28=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q29",  getName_q29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","q29=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q30",  getName_q30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","q30=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_34_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_34_1",  getName_34_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b38","q34_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q35",  getName_q35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b39","q35=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q37",  getName_q37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","q37=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q38",  getName_q38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","q38=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q39",  getName_q39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","q39=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q40",  getName_q40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","q40=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q41",  getName_q41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b44","q41=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q42",  getName_q42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b45","q42=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q43",  getName_q43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b46","q43=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q44",  getName_q44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b47","q44=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q45",  getName_q45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b48","q45=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q46",  getName_q46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b49","q46=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q47",  getName_q47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b50","q47=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q48",  getName_q48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b51","q48=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q49",  getName_q49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b52","q49=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q50",  getName_q50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b53","q50=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q51ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q51",  getName_q51CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b54","q51=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q52ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q52",  getName_q52CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b55","q52=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q53ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q53",  getName_q53CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b56","q53=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q54ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q54",  getName_q54CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b57","q54=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q54_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q54_1",  getName_q54_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b58","q54_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q54_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q54_2",  getName_q54_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b59","q54_2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q54_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q54_3",  getName_q54_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b60","q54_3=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q55ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q55",  getName_q55CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b61","q55=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q55_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q55_1",  getName_q55_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b62","q55_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q55_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q55_2",  getName_q55_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b63","q55_2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q55_3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q55_3",  getName_q55_3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b64","q55_3=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q56ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q56",  getName_q56CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b65","q56=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q56_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q56_1",  getName_q56_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b66","q56_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q57ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q57",  getName_q57CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b67","q57=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q58ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q58",  getName_q58CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b68","q58=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q59ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q59",  getName_q59CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b69","q59=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q60ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q60",  getName_q60CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b70","q60=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q61ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q61",  getName_q61CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b71","q61=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q62ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q62",  getName_q62CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b72","q62=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q63ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q63",  getName_q63CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b73","q63=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q64ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q64",  getName_q64CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b74","q64=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q65ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q65",  getName_q65CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b75","q65=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q66ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q66",  getName_q66CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b76","q66=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q67ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q67",  getName_q67CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b77","q67=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_68ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_68",  getName_68CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b78","q68=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q68_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q68_1",  getName_q68_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b79","q68_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q68_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q68_2",  getName_q68_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b80","q68_2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q69ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q69",  getName_q69CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b81","q69=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q70ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q70",  getName_q70CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b82","q70=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q71_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q71_1",  getName_q71_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b83","q71_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q72ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q72",  getName_q72CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b84","q72=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q73ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q73",  getName_q73CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b85","q73=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q74ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q74",  getName_q74CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b86","q74=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q75ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q75",  getName_q75CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b87","q75=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q76ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q76",  getName_q76CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b88","q76=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q77ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q77",  getName_q77CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b89","q77=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q78ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q78",  getName_q78CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b90","q78=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q79ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q79",  getName_q79CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b91","q79=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q80ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q80",  getName_q80CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b92","q80=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q81ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q81",  getName_q81CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b93","q81=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_82_1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_82_1",  getName_82_1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b94","q82_1=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q82_2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q82_2",  getName_q82_2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b100","q82_2=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q83ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q83",  getName_q83CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b95","q83=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q84ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q84",  getName_q84CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b96","q84=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_85ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_85",  getName_85CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b97","q85=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q86ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q86",  getName_q86CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b98","q86=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_q87ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_q87",  getName_q87CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b99","q87=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_appt",  getDt_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("预约日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b103","id_pehmappt=id_pehmappt","dt_appt"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_appt",  getNo_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("预约号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b103","id_pehmappt=id_pehmappt","no_appt"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 健康管理状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHmstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hmstatus",  getHmstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("健康管理状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b103","id_pehmappt=id_pehmappt","hmstatus"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检自测问卷主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pesurveycmaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pesurveycma");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检自测问卷主键标识"); 
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
	 * 获取体检预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检预约单ID"); 
		return column;
	}
	/**
	 * 获取体检客户ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsnbinfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsnbinfo");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检客户ID"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirthdateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birthdate");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取汉族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_nation");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("汉族"); 
		return column;
	}
	/**
	 * 获取少数民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNamtion_minorityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Namtion_minority");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("少数民族"); 
		return column;
	}
	/**
	 * 获取出生地表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirthplaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birthplace");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出生地"); 
		return column;
	}
	/**
	 * 获取婚姻状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMarital_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Marital_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("婚姻状况"); 
		return column;
	}
	/**
	 * 获取文化程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEducationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Education");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度"); 
		return column;
	}
	/**
	 * 获取职业表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOccupationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Occupation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业"); 
		return column;
	}
	/**
	 * 获取医保类别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMedical_insuranceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medical_insurance");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保类别"); 
		return column;
	}
	/**
	 * 获取电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电话"); 
		return column;
	}
	/**
	 * 获取您父母或兄弟是否患有明确诊断的疾病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q1");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您父母或兄弟是否患有明确诊断的疾病？"); 
		return column;
	}
	/**
	 * 获取请选择疾病名称（可多选）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ1_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q1_1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请选择疾病名称（可多选）"); 
		return column;
	}
	/**
	 * 获取请确定所患的恶性肿瘤名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ1_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q1_2");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请确定所患的恶性肿瘤名称"); 
		return column;
	}
	/**
	 * 获取您的父亲是否在 55 岁、母亲在 65 岁之前患有上述疾病吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ1_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q1_3");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您的父亲是否在 55 岁、母亲在 65 岁之前患有上述疾病吗？"); 
		return column;
	}
	/**
	 * 获取您是否患有明确诊断的疾病或异常？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q2");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否患有明确诊断的疾病或异常？"); 
		return column;
	}
	/**
	 * 获取请您确认具体疾病或异常的名称：表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ2_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q2_1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请您确认具体疾病或异常的名称："); 
		return column;
	}
	/**
	 * 获取请确定您所患的恶性肿瘤名称:表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ2_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q2_2");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请确定您所患的恶性肿瘤名称:"); 
		return column;
	}
	/**
	 * 获取请填写您被诊断患有上述疾病或异常的年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ2_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q2_3");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("请填写您被诊断患有上述疾病或异常的年龄"); 
		return column;
	}
	/**
	 * 获取您是否出现过过敏？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q3");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否出现过过敏？"); 
		return column;
	}
	/**
	 * 获取请选择过敏源:表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ3_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q3_1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请选择过敏源:"); 
		return column;
	}
	/**
	 * 获取您是否长期服用药物？（连续服用 6 个月以上，平均每日服用一次以上）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q4");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否长期服用药物？（连续服用 6 个月以上，平均每日服用一次以上）"); 
		return column;
	}
	/**
	 * 获取您长期服用哪些药物？（可多选）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ4_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q4_1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您长期服用哪些药物？（可多选）"); 
		return column;
	}
	/**
	 * 获取您是否因病进行过手术治疗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q5");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否因病进行过手术治疗？"); 
		return column;
	}
	/**
	 * 获取请您选择手术的部位？（可多选）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ5_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q5_1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请您选择手术的部位？（可多选）"); 
		return column;
	}
	/**
	 * 获取您第一次来月经的年龄：表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q6");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您第一次来月经的年龄："); 
		return column;
	}
	/**
	 * 获取您是否绝经？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q7");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否绝经？"); 
		return column;
	}
	/**
	 * 获取绝经年龄： 岁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ7_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q7_1");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("绝经年龄： 岁"); 
		return column;
	}
	/**
	 * 获取您的结婚年龄：表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q8");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您的结婚年龄："); 
		return column;
	}
	/**
	 * 获取您是否生育过？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否生育过？"); 
		return column;
	}
	/**
	 * 获取初产年龄： 岁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9_1_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9_1_1");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("初产年龄： 岁"); 
		return column;
	}
	/**
	 * 获取生产 次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9_1_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9_1_2");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("生产 次"); 
		return column;
	}
	/**
	 * 获取流产总次数 次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9_1_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9_1_3");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("流产总次数 次"); 
		return column;
	}
	/**
	 * 获取您的孩子是母乳喂养吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9_2");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您的孩子是母乳喂养吗？"); 
		return column;
	}
	/**
	 * 获取哺乳时间 月表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9_3");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("哺乳时间 月"); 
		return column;
	}
	/**
	 * 获取您是否曾患有妊娠糖尿病？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9_4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9_4");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否曾患有妊娠糖尿病？"); 
		return column;
	}
	/**
	 * 获取您是否曾患有妊娠高血压？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9_5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9_5");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否曾患有妊娠高血压？"); 
		return column;
	}
	/**
	 * 获取您感觉身体总体健康状况如何?表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q10");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感觉身体总体健康状况如何?"); 
		return column;
	}
	/**
	 * 获取您感到疲劳乏力或周身明显不适吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q11");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到疲劳乏力或周身明显不适吗？"); 
		return column;
	}
	/**
	 * 获取您视力有下降吗？ 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q12");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您视力有下降吗？ "); 
		return column;
	}
	/**
	 * 获取您听力有下降吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q13");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您听力有下降吗？"); 
		return column;
	}
	/**
	 * 获取您有鼻出血或浓血鼻涕吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q14");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您有鼻出血或浓血鼻涕吗？"); 
		return column;
	}
	/**
	 * 获取您出现过吞咽不适、哽噎感吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q15");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您出现过吞咽不适、哽噎感吗？"); 
		return column;
	}
	/**
	 * 获取您有明显的咳嗽、咳痰吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q16");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您有明显的咳嗽、咳痰吗？"); 
		return column;
	}
	/**
	 * 获取您有过咳痰带血或咯血吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q17");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您有过咳痰带血或咯血吗？"); 
		return column;
	}
	/**
	 * 获取您感到胸痛或心前区憋闷不适吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q18");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到胸痛或心前区憋闷不适吗？"); 
		return column;
	}
	/**
	 * 获取您感到有胸闷气喘或呼吸困难吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q19");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到有胸闷气喘或呼吸困难吗？"); 
		return column;
	}
	/**
	 * 获取您感到低热（体温偏高）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q20");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到低热（体温偏高）吗？"); 
		return column;
	}
	/**
	 * 获取您感到头晕或头昏吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q21");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到头晕或头昏吗？"); 
		return column;
	}
	/**
	 * 获取您感到恶心、反酸或上腹部不适吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q22");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到恶心、反酸或上腹部不适吗？"); 
		return column;
	}
	/**
	 * 获取您有过食欲不振、消化不良或腹胀吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q23");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您有过食欲不振、消化不良或腹胀吗？"); 
		return column;
	}
	/**
	 * 获取您有过不明原因跌倒或晕倒吗？ 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q24");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您有过不明原因跌倒或晕倒吗？ "); 
		return column;
	}
	/**
	 * 获取您感到明显的手足发麻或刺痛吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q25");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到明显的手足发麻或刺痛吗？"); 
		return column;
	}
	/**
	 * 获取您双下肢水肿吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q26");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您双下肢水肿吗？"); 
		return column;
	}
	/**
	 * 获取您排尿困难吗？ 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q27");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您排尿困难吗？ "); 
		return column;
	}
	/**
	 * 获取您有尿频、尿急、尿痛及尿血吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q28");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您有尿频、尿急、尿痛及尿血吗？"); 
		return column;
	}
	/**
	 * 获取您有腹泻、腹痛或大便习惯改变（入厕时间、次数、形状等）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q29");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您有腹泻、腹痛或大便习惯改变（入厕时间、次数、形状等）吗？"); 
		return column;
	}
	/**
	 * 获取您出现过柏油样便或便中带血吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q30");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您出现过柏油样便或便中带血吗？"); 
		return column;
	}
	/**
	 * 获取您出现过不明原因的身体消瘦或体重减轻吗？（体重减轻超过原体重的 10%）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ31CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q31");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您出现过不明原因的身体消瘦或体重减轻吗？（体重减轻超过原体重的 10%）"); 
		return column;
	}
	/**
	 * 获取您是否发现乳房有包块，并伴有胀痛吗（与月经周期无关）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ32CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q32");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否发现乳房有包块，并伴有胀痛吗（与月经周期无关）"); 
		return column;
	}
	/**
	 * 获取您有不明原因的阴道出血、白带异常吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ33CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q33");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您有不明原因的阴道出血、白带异常吗？"); 
		return column;
	}
	/**
	 * 获取您身体有过明显的疼痛吗？（外伤除外） 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ34CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q34");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您身体有过明显的疼痛吗？（外伤除外） "); 
		return column;
	}
	/**
	 * 获取疼痛的部位？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ34_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q34_1");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛的部位？"); 
		return column;
	}
	/**
	 * 获取您通常能够按时吃三餐吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q35");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您通常能够按时吃三餐吗？"); 
		return column;
	}
	/**
	 * 获取您常暴饮暴食吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ36CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q36");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您常暴饮暴食吗？"); 
		return column;
	}
	/**
	 * 获取您常吃夜宵吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q37");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您常吃夜宵吗？"); 
		return column;
	}
	/**
	 * 获取您参加请客吃饭（应酬）情况？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q38");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您参加请客吃饭（应酬）情况？"); 
		return column;
	}
	/**
	 * 获取您的饮食口味？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q39");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您的饮食口味？"); 
		return column;
	}
	/**
	 * 获取您的饮食偏好？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q40");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您的饮食偏好？"); 
		return column;
	}
	/**
	 * 获取您的主食结构如何？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q41");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您的主食结构如何？"); 
		return column;
	}
	/**
	 * 获取您喝牛奶吗？ 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q42");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您喝牛奶吗？ "); 
		return column;
	}
	/**
	 * 获取您吃鸡蛋吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q43");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您吃鸡蛋吗？"); 
		return column;
	}
	/**
	 * 获取您吃豆类及豆制品吗?表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q44");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您吃豆类及豆制品吗?"); 
		return column;
	}
	/**
	 * 获取您吃水果吗？ 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q45");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您吃水果吗？ "); 
		return column;
	}
	/**
	 * 获取您平均每天吃多少蔬菜？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q46");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您平均每天吃多少蔬菜？"); 
		return column;
	}
	/**
	 * 获取您平均每天吃多少肉（猪、牛、羊、禽）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q47");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您平均每天吃多少肉（猪、牛、羊、禽）？"); 
		return column;
	}
	/**
	 * 获取您吃肥肉吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q48");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您吃肥肉吗？"); 
		return column;
	}
	/**
	 * 获取您吃动物内脏吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q49");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您吃动物内脏吗？"); 
		return column;
	}
	/**
	 * 获取您吃鱼肉或海鲜吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q50");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您吃鱼肉或海鲜吗？"); 
		return column;
	}
	/**
	 * 获取您喝咖啡吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ51CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q51");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您喝咖啡吗？"); 
		return column;
	}
	/**
	 * 获取您喝含糖饮料（果汁、可乐等）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ52CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q52");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您喝含糖饮料（果汁、可乐等）吗？"); 
		return column;
	}
	/**
	 * 获取您吸烟吗？（持续吸烟 1 年以上）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ53CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q53");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您吸烟吗？（持续吸烟 1 年以上）"); 
		return column;
	}
	/**
	 * 获取您通常每天吸多少支烟？（含戒烟前） 支表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ53_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q53_1");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您通常每天吸多少支烟？（含戒烟前） 支"); 
		return column;
	}
	/**
	 * 获取,您持续吸烟的年限？（含戒烟前） 年表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ53_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q53_2");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel(",您持续吸烟的年限？（含戒烟前） 年"); 
		return column;
	}
	/**
	 * 获取您戒烟多长时间了？ 年表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ53_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q53_3");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您戒烟多长时间了？ 年"); 
		return column;
	}
	/**
	 * 获取您喝酒吗？（平均每周饮酒 1 次以上）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ54CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q54");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您喝酒吗？（平均每周饮酒 1 次以上）"); 
		return column;
	}
	/**
	 * 获取您一般喝什么酒?表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ54_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q54_1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您一般喝什么酒?"); 
		return column;
	}
	/**
	 * 获取您每周喝几次酒？（含戒酒前） 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ54_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q54_2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您每周喝几次酒？（含戒酒前） "); 
		return column;
	}
	/**
	 * 获取您每次喝几两？（1 两相当于 50 ml 白酒，100 ml 红酒，300 ml 啤酒）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ54_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q54_3");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您每次喝几两？（1 两相当于 50 ml 白酒，100 ml 红酒，300 ml 啤酒）"); 
		return column;
	}
	/**
	 * 获取您持续喝酒的年限？（含戒酒前） 年表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ54_4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q54_4");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您持续喝酒的年限？（含戒酒前） 年"); 
		return column;
	}
	/**
	 * 获取您戒酒多长时间了 年表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ54_5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q54_5");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您戒酒多长时间了 年"); 
		return column;
	}
	/**
	 * 获取您参加运动锻炼吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ55CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q55");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您参加运动锻炼吗？"); 
		return column;
	}
	/**
	 * 获取您常采用的运动锻炼方式：（可多选）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ55_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q55_1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您常采用的运动锻炼方式：（可多选）"); 
		return column;
	}
	/**
	 * 获取您每周锻炼几次？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ55_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q55_2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您每周锻炼几次？"); 
		return column;
	}
	/**
	 * 获取您每次锻炼多次时间？ 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ55_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q55_3");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您每次锻炼多次时间？ "); 
		return column;
	}
	/**
	 * 获取您坚持锻炼多少年了？ 年表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ55_4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q55_4");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您坚持锻炼多少年了？ 年"); 
		return column;
	}
	/**
	 * 获取您工作中的体力强度？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ56CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q56");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您工作中的体力强度？"); 
		return column;
	}
	/**
	 * 获取您每周工作几天？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ56_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q56_1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您每周工作几天？"); 
		return column;
	}
	/**
	 * 获取您每天平均工作多长时间？ 小时表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ56_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q56_2");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("您每天平均工作多长时间？ 小时"); 
		return column;
	}
	/**
	 * 获取除工作、学习时间外，您每天坐着（如看电视、上网、打麻将、打牌等）的时间是？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ57CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q57");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("除工作、学习时间外，您每天坐着（如看电视、上网、打麻将、打牌等）的时间是？"); 
		return column;
	}
	/**
	 * 获取您的工作/生活场所经常会接触到哪些有害物质？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ58CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q58");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您的工作/生活场所经常会接触到哪些有害物质？"); 
		return column;
	}
	/**
	 * 获取您感到闷闷不乐，情绪低落吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ59CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q59");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到闷闷不乐，情绪低落吗？"); 
		return column;
	}
	/**
	 * 获取您容易情绪激动或生气吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ60CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q60");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您容易情绪激动或生气吗？"); 
		return column;
	}
	/**
	 * 获取您感到精神紧张，很难放松吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ61CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q61");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到精神紧张，很难放松吗？"); 
		return column;
	}
	/**
	 * 获取您比平常容易紧张和着急吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ62CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q62");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您比平常容易紧张和着急吗？"); 
		return column;
	}
	/**
	 * 获取您容易发脾气，没有耐性吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ63CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q63");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您容易发脾气，没有耐性吗？"); 
		return column;
	}
	/**
	 * 获取您感到心力枯竭，对人对事缺乏热情吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ64CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q64");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感到心力枯竭，对人对事缺乏热情吗？"); 
		return column;
	}
	/**
	 * 获取您容易焦虑不安、心烦意乱吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ65CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q65");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您容易焦虑不安、心烦意乱吗？"); 
		return column;
	}
	/**
	 * 获取您感觉压抑或沮丧吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ66CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q66");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您感觉压抑或沮丧吗？"); 
		return column;
	}
	/**
	 * 获取您注意力集中有困难吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ67CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q67");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您注意力集中有困难吗？"); 
		return column;
	}
	/**
	 * 获取最近 1 个月，您的睡眠如何？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ68CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q68");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最近 1 个月，您的睡眠如何？"); 
		return column;
	}
	/**
	 * 获取您睡眠差的主要表现：表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ68_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q68_1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您睡眠差的主要表现："); 
		return column;
	}
	/**
	 * 获取影响您睡眠差的主要原因：表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ68_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q68_2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("影响您睡眠差的主要原因："); 
		return column;
	}
	/**
	 * 获取您每天平均睡眠时间：（不等于卧床时间）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ69CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q69");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您每天平均睡眠时间：（不等于卧床时间）"); 
		return column;
	}
	/**
	 * 获取您多长时间做一次体检？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ70CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q70");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您多长时间做一次体检？"); 
		return column;
	}
	/**
	 * 获取您是否主动获取医疗保健知识？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ71CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q71");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("您是否主动获取医疗保健知识？"); 
		return column;
	}
	/**
	 * 获取您获取医疗保健知识的途径？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ71_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q71_1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您获取医疗保健知识的途径？"); 
		return column;
	}
	/**
	 * 获取您入厕观察二便（大小便）吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ72CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q72");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您入厕观察二便（大小便）吗？"); 
		return column;
	}
	/**
	 * 获取您自测血压、心率吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ73CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q73");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您自测血压、心率吗？"); 
		return column;
	}
	/**
	 * 获取您出差或旅游带常用或急救药品吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ74CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q74");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您出差或旅游带常用或急救药品吗？"); 
		return column;
	}
	/**
	 * 获取您乘坐私家车或出租车时系安全带吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ75CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q75");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您乘坐私家车或出租车时系安全带吗？"); 
		return column;
	}
	/**
	 * 获取您经常晒太阳吗？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ76CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q76");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您经常晒太阳吗？"); 
		return column;
	}
	/**
	 * 获取您认为以下血压值哪个最理想？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ77CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q77");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为以下血压值哪个最理想？"); 
		return column;
	}
	/**
	 * 获取您认为成年人腋下体温最理想的范围是？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ78CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q78");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成年人腋下体温最理想的范围是？"); 
		return column;
	}
	/**
	 * 获取您认为安静状态下成年人最理想的脉搏次数是？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ79CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q79");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为安静状态下成年人最理想的脉搏次数是？"); 
		return column;
	}
	/**
	 * 获取您认为成年人每天最佳食盐量不要超过多少克？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ80CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q80");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成年人每天最佳食盐量不要超过多少克？"); 
		return column;
	}
	/**
	 * 获取您认为成年人正常体重指数是（体重指数=体重 kg/身高 m  2  ）？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ81CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q81");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成年人正常体重指数是（体重指数=体重 kg/身高 m  2  ）？"); 
		return column;
	}
	/**
	 * 获取您认为成年人正常腰围是？男性：表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ82_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q82_1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成年人正常腰围是？男性："); 
		return column;
	}
	/**
	 * 获取您认为成年人正常腰围是？女性：表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ82_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q82_2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成年人正常腰围是？女性："); 
		return column;
	}
	/**
	 * 获取您认为成人空腹血糖正常值是？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ83CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q83");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成人空腹血糖正常值是？"); 
		return column;
	}
	/**
	 * 获取您认为成人三酰甘油正常值是？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ84CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q84");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成人三酰甘油正常值是？"); 
		return column;
	}
	/**
	 * 获取您认为成人总胆固醇理想值是？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ85CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q85");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您认为成人总胆固醇理想值是？"); 
		return column;
	}
	/**
	 * 获取答完该问卷后，您对自己的健康状态感觉如何？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ86CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q86");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("答完该问卷后，您对自己的健康状态感觉如何？"); 
		return column;
	}
	/**
	 * 获取您对该健康自测问卷的总体印象是？表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ87CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q87");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("您对该健康自测问卷的总体印象是？"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取健康管理预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pehmapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pehmappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康管理预约单ID"); 
		return column;
	}
	/**
	 * 获取客户姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户姓名"); 
		return column;
	}
	/**
	 * 获取性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别编码"); 
		return column;
	}
	/**
	 * 获取证件号码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIdcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Idcode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证件号码"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_nation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_marCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_mar");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_marCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mar");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_eduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_edu");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eduCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_edu");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q1_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q1_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q1_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q1_2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q2_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q2_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q2_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q2_2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q3_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q3_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q4_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q4_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q5_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q5_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q10");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q11");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q12");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q13");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q14");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q15");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q16");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q17");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q18");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q19");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q20");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q21");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q22");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q23");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q24");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q25");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q26");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q27");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q28");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q29");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q30");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_34_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_34_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q35");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q37");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q38");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q39");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q40");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q41");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q42");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q43");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q44");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q45");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q46");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q47");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q48");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q49");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q50");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q51CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q51");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q52CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q52");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q53CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q53");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q54CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q54");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q54_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q54_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q54_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q54_2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q54_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q54_3");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q55CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q55");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q55_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q55_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q55_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q55_2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q55_3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q55_3");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q56CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q56");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q56_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q56_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q57CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q57");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q58CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q58");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q59CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q59");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q60CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q60");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q61CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q61");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q62CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q62");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q63CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q63");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q64CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q64");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q65CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q65");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q66CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q66");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q67CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q67");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_68CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_68");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q68_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q68_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q68_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q68_2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q69CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q69");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q70CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q70");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q71_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q71_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q72CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q72");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q73CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q73");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q74CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q74");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q75CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q75");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q76CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q76");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q77CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q77");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q78CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q78");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q79CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q79");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q80CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q80");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q81CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q81");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_82_1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_82_1");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q82_2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q82_2");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q83CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q83");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q84CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q84");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_85CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_85");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q86CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q86");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_q87CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_q87");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取预约日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_appt");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约日期"); 
		return column;
	}
	/**
	 * 获取预约号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_appt");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("预约号"); 
		return column;
	}
	/**
	 * 获取健康管理状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHmstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hmstatus");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("健康管理状态"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_pesurveycma");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
