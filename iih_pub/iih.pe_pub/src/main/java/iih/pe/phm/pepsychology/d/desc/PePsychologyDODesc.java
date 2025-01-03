
package iih.pe.phm.pepsychology.d.desc;

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
 * 体检心理评估 DO 元数据信息
 */
public class PePsychologyDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.pe.phm.pepsychology.d.PePsychologyDO";
	public static final String CLASS_DISPALYNAME = "体检心理评估";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "pe_hm_pepsychology";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pepsychology";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PePsychologyDODesc(){
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
		this.setKeyDesc(getId_pepsychologyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pepsychologyADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_pepsnapptADesc(tblDesc));
		this.add(getId_pepsnbinfoADesc(tblDesc));
		this.add(getId_pehmapptADesc(tblDesc));
		this.add(getQ1ADesc(tblDesc));
		this.add(getQ2ADesc(tblDesc));
		this.add(getQ3ADesc(tblDesc));
		this.add(getQ4ADesc(tblDesc));
		this.add(getQ5ADesc(tblDesc));
		this.add(getQ6ADesc(tblDesc));
		this.add(getQ7ADesc(tblDesc));
		this.add(getQ8ADesc(tblDesc));
		this.add(getQ9ADesc(tblDesc));
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
		this.add(getQ54ADesc(tblDesc));
		this.add(getQ55ADesc(tblDesc));
		this.add(getQ56ADesc(tblDesc));
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
		this.add(getQ69ADesc(tblDesc));
		this.add(getQ70ADesc(tblDesc));
		this.add(getQ71ADesc(tblDesc));
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
		this.add(getQ82ADesc(tblDesc));
		this.add(getQ83ADesc(tblDesc));
		this.add(getQ84ADesc(tblDesc));
		this.add(getQ85ADesc(tblDesc));
		this.add(getQ86ADesc(tblDesc));
		this.add(getQ87ADesc(tblDesc));
		this.add(getQ88ADesc(tblDesc));
		this.add(getQ89ADesc(tblDesc));
		this.add(getQ90ADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getCode_psnADesc(tblDesc));
		this.add(getName_psnADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pepsychologyCDesc(tblDesc));
		tblDesc.add(getId_pepsychologyCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_pepsnapptCDesc(tblDesc));
		tblDesc.add(getId_pepsnbinfoCDesc(tblDesc));
		tblDesc.add(getId_pehmapptCDesc(tblDesc));
		tblDesc.add(getQ1CDesc(tblDesc));
		tblDesc.add(getQ2CDesc(tblDesc));
		tblDesc.add(getQ3CDesc(tblDesc));
		tblDesc.add(getQ4CDesc(tblDesc));
		tblDesc.add(getQ5CDesc(tblDesc));
		tblDesc.add(getQ6CDesc(tblDesc));
		tblDesc.add(getQ7CDesc(tblDesc));
		tblDesc.add(getQ8CDesc(tblDesc));
		tblDesc.add(getQ9CDesc(tblDesc));
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
		tblDesc.add(getQ54CDesc(tblDesc));
		tblDesc.add(getQ55CDesc(tblDesc));
		tblDesc.add(getQ56CDesc(tblDesc));
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
		tblDesc.add(getQ69CDesc(tblDesc));
		tblDesc.add(getQ70CDesc(tblDesc));
		tblDesc.add(getQ71CDesc(tblDesc));
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
		tblDesc.add(getQ82CDesc(tblDesc));
		tblDesc.add(getQ83CDesc(tblDesc));
		tblDesc.add(getQ84CDesc(tblDesc));
		tblDesc.add(getQ85CDesc(tblDesc));
		tblDesc.add(getQ86CDesc(tblDesc));
		tblDesc.add(getQ87CDesc(tblDesc));
		tblDesc.add(getQ88CDesc(tblDesc));
		tblDesc.add(getQ89CDesc(tblDesc));
		tblDesc.add(getQ90CDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 体检心理评估量表主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pepsychologyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pepsychology",  getId_pepsychologyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检心理评估量表主键标识");
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
	 * 健康预约单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pehmapptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pehmappt",  getId_pehmapptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("健康预约单ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 1.头痛 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q1",  getQ1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("1.头痛 ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 2.神经过敏，心中不踏实属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q2",  getQ2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("2.神经过敏，心中不踏实");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 3.头脑中有不必要的想法或字句盘旋属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q3",  getQ3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("3.头脑中有不必要的想法或字句盘旋");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 4.头晕或晕倒属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q4",  getQ4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("4.头晕或晕倒");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 5.对异性的兴趣减退属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q5",  getQ5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("5.对异性的兴趣减退");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 6.对旁人责备求全属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ6ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q6",  getQ6CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("6.对旁人责备求全");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 7.感到别人能控制您的思想属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ7ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q7",  getQ7CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("7.感到别人能控制您的思想");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 8.责怪别人制造麻烦属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ8ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q8",  getQ8CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("8.责怪别人制造麻烦");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 9.忘性大属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ9ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q9",  getQ9CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("9.忘性大");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 10.担心自己的衣饰整齐及仪态的端正属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ10ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q10",  getQ10CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("10.担心自己的衣饰整齐及仪态的端正");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 11.容易烦恼和激动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ11ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q11",  getQ11CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("11.容易烦恼和激动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 12.胸痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ12ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q12",  getQ12CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("12.胸痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 13.害怕空旷的场所或街道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ13ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q13",  getQ13CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("13.害怕空旷的场所或街道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 14.感到自己的精力下降，活动减慢属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ14ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q14",  getQ14CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("14.感到自己的精力下降，活动减慢");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 15.想结束自己的生命属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ15ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q15",  getQ15CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("15.想结束自己的生命");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 16.听到旁人听不到的声音属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ16ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q16",  getQ16CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("16.听到旁人听不到的声音");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 17.发抖属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ17ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q17",  getQ17CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("17.发抖");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 18.感到大多数人都不可信任属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ18ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q18",  getQ18CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("18.感到大多数人都不可信任");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 19.胃口不好属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ19ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q19",  getQ19CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("19.胃口不好");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 20.容易哭泣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ20ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q20",  getQ20CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("20.容易哭泣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 21.同异性相处时感到害羞不自在属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ21ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q21",  getQ21CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("21.同异性相处时感到害羞不自在");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 22.感到受骗，中了圈套或有人想抓住您属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ22ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q22",  getQ22CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("22.感到受骗，中了圈套或有人想抓住您");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 23.无缘无故地突然感到害怕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ23ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q23",  getQ23CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("23.无缘无故地突然感到害怕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 24.自己不能控制地大发脾气属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ24ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q24",  getQ24CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("24.自己不能控制地大发脾气");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 25.怕单独出门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ25ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q25",  getQ25CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("25.怕单独出门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 26.经常责怪自己属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ26ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q26",  getQ26CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("26.经常责怪自己");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 27.腰痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ27ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q27",  getQ27CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("27.腰痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 28.感到难以完成任务属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ28ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q28",  getQ28CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("28.感到难以完成任务");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 29.感到孤独属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ29ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q29",  getQ29CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("29.感到孤独");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 30.感到苦闷属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ30ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q30",  getQ30CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("30.感到苦闷");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 31.过分担忧属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ31ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q31",  getQ31CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("31.过分担忧");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 32.对事物不感兴趣属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ32ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q32",  getQ32CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("32.对事物不感兴趣");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 33.感到害怕属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ33ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q33",  getQ33CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("33.感到害怕");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 34.您的感情容易受到伤害属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ34ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q34",  getQ34CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("34.您的感情容易受到伤害");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 35.旁人能知道您的私下想法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ35ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q35",  getQ35CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("35.旁人能知道您的私下想法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 36.感到别人不理解您、不同情您属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ36ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q36",  getQ36CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("36.感到别人不理解您、不同情您");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 37.感到人们对您不友好，不喜欢您属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ37ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q37",  getQ37CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("37.感到人们对您不友好，不喜欢您");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 38.做事必须做得很慢以保证做得正确属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ38ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q38",  getQ38CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("38.做事必须做得很慢以保证做得正确");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 39.心跳得很厉害属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ39ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q39",  getQ39CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("39.心跳得很厉害");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 40.恶心或胃部不舒服属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ40ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q40",  getQ40CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("40.恶心或胃部不舒服");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 41.感到比不上他人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ41ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q41",  getQ41CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("41.感到比不上他人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 42.肌肉酸痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ42ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q42",  getQ42CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("42.肌肉酸痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 43.感到有人在监视您、谈论您属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ43ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q43",  getQ43CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("43.感到有人在监视您、谈论您");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 44.难以入睡属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ44ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q44",  getQ44CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("44.难以入睡");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 45.做事必须反复检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ45ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q45",  getQ45CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("45.做事必须反复检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 46.难以做出决定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ46ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q46",  getQ46CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("46.难以做出决定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 47.怕乘电车、公共汽车、地铁或火车属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ47ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q47",  getQ47CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("47.怕乘电车、公共汽车、地铁或火车");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 48.呼吸有困难属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ48ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q48",  getQ48CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("48.呼吸有困难");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 49.一阵阵发冷或发热属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ49ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q49",  getQ49CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("49.一阵阵发冷或发热");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 50.因为感到害怕而避开某些东西、场合或活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ50ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q50",  getQ50CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("50.因为感到害怕而避开某些东西、场合或活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 51.脑子变空了属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ51ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q51",  getQ51CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("51.脑子变空了");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 52.身体发麻或刺痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ52ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q52",  getQ52CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("52.身体发麻或刺痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 53.喉咙有梗塞感属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ53ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q53",  getQ53CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("53.喉咙有梗塞感");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 54.感到前途没有希望属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ54ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q54",  getQ54CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("54.感到前途没有希望");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 55.不能集中注意力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ55ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q55",  getQ55CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("55.不能集中注意力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 56.感到身体的某一部分软弱无力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ56ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q56",  getQ56CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("56.感到身体的某一部分软弱无力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 57.感到紧张或容易紧张属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ57ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q57",  getQ57CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("57.感到紧张或容易紧张");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 58.感到手或脚发重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ58ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q58",  getQ58CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("58.感到手或脚发重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 59.想到死亡的事属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ59ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q59",  getQ59CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("59.想到死亡的事");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 60.吃得太多属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ60ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q60",  getQ60CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("60.吃得太多");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 61.当别人看着您或谈论您时感到不自在属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ61ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q61",  getQ61CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("61.当别人看着您或谈论您时感到不自在");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 62.有一些不属于您自己的想法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ62ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q62",  getQ62CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("62.有一些不属于您自己的想法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 63.有想打人或伤害他人的冲动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ63ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q63",  getQ63CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("63.有想打人或伤害他人的冲动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 64.醒得太早属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ64ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q64",  getQ64CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("64.醒得太早");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 65.必须反复洗手、点数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ65ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q65",  getQ65CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("65.必须反复洗手、点数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 66.睡得不稳不深属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ66ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q66",  getQ66CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("66.睡得不稳不深");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 67.有想摔坏或破坏东西的想法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ67ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q67",  getQ67CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("67.有想摔坏或破坏东西的想法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 68.有一些别人没有的想法 属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ68ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q68",  getQ68CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("68.有一些别人没有的想法 ");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 69.感到对别人神经过敏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ69ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q69",  getQ69CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("69.感到对别人神经过敏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 70.在商店或电影院等人多的地方感到不自在属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ70ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q70",  getQ70CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("70.在商店或电影院等人多的地方感到不自在");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 71.感到任何事情都很困难属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ71ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q71",  getQ71CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("71.感到任何事情都很困难");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 72.一阵阵恐惧或惊恐属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ72ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q72",  getQ72CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("72.一阵阵恐惧或惊恐");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 73.感到公共场合吃东西很不舒服属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ73ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q73",  getQ73CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("73.感到公共场合吃东西很不舒服");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 74.经常与人争论属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ74ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q74",  getQ74CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("74.经常与人争论");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 75.单独一人时神经很紧张属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ75ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q75",  getQ75CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("75.单独一人时神经很紧张");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 76.别人对您的成绩没有做出恰当的评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ76ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q76",  getQ76CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("76.别人对您的成绩没有做出恰当的评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 77.即使和别人在一起也感到孤单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ77ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q77",  getQ77CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("77.即使和别人在一起也感到孤单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 78.感到坐立不安心神不定属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ78ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q78",  getQ78CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("78.感到坐立不安心神不定");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 79.感到自己没有什么价值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ79ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q79",  getQ79CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("79.感到自己没有什么价值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 80.感到熟悉的东西变成陌生或不像是真的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ80ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q80",  getQ80CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("80.感到熟悉的东西变成陌生或不像是真的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 81.大叫或摔东西属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ81ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q81",  getQ81CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("81.大叫或摔东西");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 82.害怕会在公共场合晕倒属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ82ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q82",  getQ82CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("82.害怕会在公共场合晕倒");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 83.感到别人想占您的便宜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ83ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q83",  getQ83CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("83.感到别人想占您的便宜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 84.为一些有关性的想法而很苦恼属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ84ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q84",  getQ84CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("84.为一些有关性的想法而很苦恼");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 85.您认为应该因为自己的过错而受到惩罚属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ85ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q85",  getQ85CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("85.您认为应该因为自己的过错而受到惩罚");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 85.感到要很快把事情做完属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ86ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q86",  getQ86CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("85.感到要很快把事情做完");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 87.感到自己的身体有严重问题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ87ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q87",  getQ87CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("87.感到自己的身体有严重问题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 88.从未感到和其他人很亲近属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ88ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q88",  getQ88CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("88.从未感到和其他人很亲近");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 89.感到自己有罪属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ89ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q89",  getQ89CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("89.感到自己有罪");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 90.感到自己的脑子有毛病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQ90ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Q90",  getQ90CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("90.感到自己的脑子有毛病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 客户编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_psn",  getCode_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("客户编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b7","id_pepsnbinfo=id_pepsnbinfo","code"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_or_pepsnbinfo a0b7","id_pepsnbinfo=id_pepsnbinfo","name"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b8","id_pehmappt=id_pehmappt","dt_appt"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b8","id_pehmappt=id_pehmappt","no_appt"});
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
		attrDesc.setRefTblInfos(new String[]{"pe_apt_pehmappt a0b8","id_pehmappt=id_pehmappt","hmstatus"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取体检心理评估量表主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pepsychologyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pepsychology");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检心理评估量表主键标识"); 
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
	 * 获取健康预约单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pehmapptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pehmappt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("健康预约单ID"); 
		return column;
	}
	/**
	 * 获取1.头痛 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q1");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("1.头痛 "); 
		return column;
	}
	/**
	 * 获取2.神经过敏，心中不踏实表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q2");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("2.神经过敏，心中不踏实"); 
		return column;
	}
	/**
	 * 获取3.头脑中有不必要的想法或字句盘旋表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q3");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("3.头脑中有不必要的想法或字句盘旋"); 
		return column;
	}
	/**
	 * 获取4.头晕或晕倒表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q4");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("4.头晕或晕倒"); 
		return column;
	}
	/**
	 * 获取5.对异性的兴趣减退表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q5");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("5.对异性的兴趣减退"); 
		return column;
	}
	/**
	 * 获取6.对旁人责备求全表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ6CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q6");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("6.对旁人责备求全"); 
		return column;
	}
	/**
	 * 获取7.感到别人能控制您的思想表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ7CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q7");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("7.感到别人能控制您的思想"); 
		return column;
	}
	/**
	 * 获取8.责怪别人制造麻烦表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ8CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q8");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("8.责怪别人制造麻烦"); 
		return column;
	}
	/**
	 * 获取9.忘性大表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ9CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q9");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("9.忘性大"); 
		return column;
	}
	/**
	 * 获取10.担心自己的衣饰整齐及仪态的端正表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ10CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q10");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("10.担心自己的衣饰整齐及仪态的端正"); 
		return column;
	}
	/**
	 * 获取11.容易烦恼和激动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ11CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q11");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("11.容易烦恼和激动"); 
		return column;
	}
	/**
	 * 获取12.胸痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ12CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q12");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("12.胸痛"); 
		return column;
	}
	/**
	 * 获取13.害怕空旷的场所或街道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ13CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q13");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("13.害怕空旷的场所或街道"); 
		return column;
	}
	/**
	 * 获取14.感到自己的精力下降，活动减慢表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ14CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q14");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("14.感到自己的精力下降，活动减慢"); 
		return column;
	}
	/**
	 * 获取15.想结束自己的生命表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ15CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q15");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("15.想结束自己的生命"); 
		return column;
	}
	/**
	 * 获取16.听到旁人听不到的声音表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ16CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q16");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("16.听到旁人听不到的声音"); 
		return column;
	}
	/**
	 * 获取17.发抖表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ17CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q17");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("17.发抖"); 
		return column;
	}
	/**
	 * 获取18.感到大多数人都不可信任表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ18CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q18");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("18.感到大多数人都不可信任"); 
		return column;
	}
	/**
	 * 获取19.胃口不好表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ19CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q19");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("19.胃口不好"); 
		return column;
	}
	/**
	 * 获取20.容易哭泣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ20CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q20");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("20.容易哭泣"); 
		return column;
	}
	/**
	 * 获取21.同异性相处时感到害羞不自在表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ21CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q21");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("21.同异性相处时感到害羞不自在"); 
		return column;
	}
	/**
	 * 获取22.感到受骗，中了圈套或有人想抓住您表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ22CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q22");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("22.感到受骗，中了圈套或有人想抓住您"); 
		return column;
	}
	/**
	 * 获取23.无缘无故地突然感到害怕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ23CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q23");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("23.无缘无故地突然感到害怕"); 
		return column;
	}
	/**
	 * 获取24.自己不能控制地大发脾气表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ24CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q24");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("24.自己不能控制地大发脾气"); 
		return column;
	}
	/**
	 * 获取25.怕单独出门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ25CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q25");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("25.怕单独出门"); 
		return column;
	}
	/**
	 * 获取26.经常责怪自己表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ26CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q26");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("26.经常责怪自己"); 
		return column;
	}
	/**
	 * 获取27.腰痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ27CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q27");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("27.腰痛"); 
		return column;
	}
	/**
	 * 获取28.感到难以完成任务表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ28CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q28");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("28.感到难以完成任务"); 
		return column;
	}
	/**
	 * 获取29.感到孤独表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ29CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q29");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("29.感到孤独"); 
		return column;
	}
	/**
	 * 获取30.感到苦闷表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ30CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q30");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("30.感到苦闷"); 
		return column;
	}
	/**
	 * 获取31.过分担忧表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ31CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q31");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("31.过分担忧"); 
		return column;
	}
	/**
	 * 获取32.对事物不感兴趣表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ32CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q32");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("32.对事物不感兴趣"); 
		return column;
	}
	/**
	 * 获取33.感到害怕表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ33CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q33");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("33.感到害怕"); 
		return column;
	}
	/**
	 * 获取34.您的感情容易受到伤害表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ34CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q34");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("34.您的感情容易受到伤害"); 
		return column;
	}
	/**
	 * 获取35.旁人能知道您的私下想法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ35CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q35");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("35.旁人能知道您的私下想法"); 
		return column;
	}
	/**
	 * 获取36.感到别人不理解您、不同情您表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ36CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q36");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("36.感到别人不理解您、不同情您"); 
		return column;
	}
	/**
	 * 获取37.感到人们对您不友好，不喜欢您表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ37CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q37");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("37.感到人们对您不友好，不喜欢您"); 
		return column;
	}
	/**
	 * 获取38.做事必须做得很慢以保证做得正确表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ38CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q38");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("38.做事必须做得很慢以保证做得正确"); 
		return column;
	}
	/**
	 * 获取39.心跳得很厉害表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ39CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q39");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("39.心跳得很厉害"); 
		return column;
	}
	/**
	 * 获取40.恶心或胃部不舒服表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ40CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q40");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("40.恶心或胃部不舒服"); 
		return column;
	}
	/**
	 * 获取41.感到比不上他人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ41CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q41");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("41.感到比不上他人"); 
		return column;
	}
	/**
	 * 获取42.肌肉酸痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ42CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q42");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("42.肌肉酸痛"); 
		return column;
	}
	/**
	 * 获取43.感到有人在监视您、谈论您表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ43CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q43");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("43.感到有人在监视您、谈论您"); 
		return column;
	}
	/**
	 * 获取44.难以入睡表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ44CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q44");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("44.难以入睡"); 
		return column;
	}
	/**
	 * 获取45.做事必须反复检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ45CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q45");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("45.做事必须反复检查"); 
		return column;
	}
	/**
	 * 获取46.难以做出决定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ46CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q46");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("46.难以做出决定"); 
		return column;
	}
	/**
	 * 获取47.怕乘电车、公共汽车、地铁或火车表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ47CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q47");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("47.怕乘电车、公共汽车、地铁或火车"); 
		return column;
	}
	/**
	 * 获取48.呼吸有困难表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ48CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q48");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("48.呼吸有困难"); 
		return column;
	}
	/**
	 * 获取49.一阵阵发冷或发热表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ49CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q49");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("49.一阵阵发冷或发热"); 
		return column;
	}
	/**
	 * 获取50.因为感到害怕而避开某些东西、场合或活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ50CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q50");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("50.因为感到害怕而避开某些东西、场合或活动"); 
		return column;
	}
	/**
	 * 获取51.脑子变空了表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ51CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q51");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("51.脑子变空了"); 
		return column;
	}
	/**
	 * 获取52.身体发麻或刺痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ52CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q52");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("52.身体发麻或刺痛"); 
		return column;
	}
	/**
	 * 获取53.喉咙有梗塞感表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ53CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q53");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("53.喉咙有梗塞感"); 
		return column;
	}
	/**
	 * 获取54.感到前途没有希望表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ54CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q54");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("54.感到前途没有希望"); 
		return column;
	}
	/**
	 * 获取55.不能集中注意力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ55CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q55");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("55.不能集中注意力"); 
		return column;
	}
	/**
	 * 获取56.感到身体的某一部分软弱无力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ56CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q56");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("56.感到身体的某一部分软弱无力"); 
		return column;
	}
	/**
	 * 获取57.感到紧张或容易紧张表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ57CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q57");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("57.感到紧张或容易紧张"); 
		return column;
	}
	/**
	 * 获取58.感到手或脚发重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ58CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q58");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("58.感到手或脚发重"); 
		return column;
	}
	/**
	 * 获取59.想到死亡的事表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ59CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q59");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("59.想到死亡的事"); 
		return column;
	}
	/**
	 * 获取60.吃得太多表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ60CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q60");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("60.吃得太多"); 
		return column;
	}
	/**
	 * 获取61.当别人看着您或谈论您时感到不自在表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ61CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q61");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("61.当别人看着您或谈论您时感到不自在"); 
		return column;
	}
	/**
	 * 获取62.有一些不属于您自己的想法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ62CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q62");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("62.有一些不属于您自己的想法"); 
		return column;
	}
	/**
	 * 获取63.有想打人或伤害他人的冲动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ63CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q63");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("63.有想打人或伤害他人的冲动"); 
		return column;
	}
	/**
	 * 获取64.醒得太早表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ64CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q64");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("64.醒得太早"); 
		return column;
	}
	/**
	 * 获取65.必须反复洗手、点数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ65CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q65");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("65.必须反复洗手、点数"); 
		return column;
	}
	/**
	 * 获取66.睡得不稳不深表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ66CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q66");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("66.睡得不稳不深"); 
		return column;
	}
	/**
	 * 获取67.有想摔坏或破坏东西的想法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ67CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q67");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("67.有想摔坏或破坏东西的想法"); 
		return column;
	}
	/**
	 * 获取68.有一些别人没有的想法 表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ68CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q68");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("68.有一些别人没有的想法 "); 
		return column;
	}
	/**
	 * 获取69.感到对别人神经过敏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ69CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q69");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("69.感到对别人神经过敏"); 
		return column;
	}
	/**
	 * 获取70.在商店或电影院等人多的地方感到不自在表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ70CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q70");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("70.在商店或电影院等人多的地方感到不自在"); 
		return column;
	}
	/**
	 * 获取71.感到任何事情都很困难表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ71CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q71");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("71.感到任何事情都很困难"); 
		return column;
	}
	/**
	 * 获取72.一阵阵恐惧或惊恐表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ72CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q72");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("72.一阵阵恐惧或惊恐"); 
		return column;
	}
	/**
	 * 获取73.感到公共场合吃东西很不舒服表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ73CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q73");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("73.感到公共场合吃东西很不舒服"); 
		return column;
	}
	/**
	 * 获取74.经常与人争论表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ74CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q74");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("74.经常与人争论"); 
		return column;
	}
	/**
	 * 获取75.单独一人时神经很紧张表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ75CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q75");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("75.单独一人时神经很紧张"); 
		return column;
	}
	/**
	 * 获取76.别人对您的成绩没有做出恰当的评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ76CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q76");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("76.别人对您的成绩没有做出恰当的评价"); 
		return column;
	}
	/**
	 * 获取77.即使和别人在一起也感到孤单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ77CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q77");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("77.即使和别人在一起也感到孤单"); 
		return column;
	}
	/**
	 * 获取78.感到坐立不安心神不定表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ78CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q78");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("78.感到坐立不安心神不定"); 
		return column;
	}
	/**
	 * 获取79.感到自己没有什么价值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ79CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q79");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("79.感到自己没有什么价值"); 
		return column;
	}
	/**
	 * 获取80.感到熟悉的东西变成陌生或不像是真的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ80CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q80");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("80.感到熟悉的东西变成陌生或不像是真的"); 
		return column;
	}
	/**
	 * 获取81.大叫或摔东西表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ81CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q81");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("81.大叫或摔东西"); 
		return column;
	}
	/**
	 * 获取82.害怕会在公共场合晕倒表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ82CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q82");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("82.害怕会在公共场合晕倒"); 
		return column;
	}
	/**
	 * 获取83.感到别人想占您的便宜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ83CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q83");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("83.感到别人想占您的便宜"); 
		return column;
	}
	/**
	 * 获取84.为一些有关性的想法而很苦恼表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ84CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q84");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("84.为一些有关性的想法而很苦恼"); 
		return column;
	}
	/**
	 * 获取85.您认为应该因为自己的过错而受到惩罚表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ85CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q85");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("85.您认为应该因为自己的过错而受到惩罚"); 
		return column;
	}
	/**
	 * 获取85.感到要很快把事情做完表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ86CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q86");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("85.感到要很快把事情做完"); 
		return column;
	}
	/**
	 * 获取87.感到自己的身体有严重问题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ87CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q87");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("87.感到自己的身体有严重问题"); 
		return column;
	}
	/**
	 * 获取88.从未感到和其他人很亲近表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ88CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q88");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("88.从未感到和其他人很亲近"); 
		return column;
	}
	/**
	 * 获取89.感到自己有罪表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ89CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q89");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("89.感到自己有罪"); 
		return column;
	}
	/**
	 * 获取90.感到自己的脑子有毛病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQ90CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Q90");
		column.setLength(50);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("90.感到自己的脑子有毛病"); 
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
	 * 获取客户编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("客户编码"); 
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
		iBDDataInfoFldMap.put("id","Id_pepsychology");
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
