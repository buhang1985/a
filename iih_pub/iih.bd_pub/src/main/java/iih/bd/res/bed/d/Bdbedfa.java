package iih.bd.res.bed.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.bed.d.desc.BdbedfaDesc;
import java.math.BigDecimal;

/**
 * 床位固定资产对应 DO数据 
 * 
 */
public class Bdbedfa extends BaseDO {
	private static final long serialVersionUID = 1L;

	//床位固定资产ID
	public static final String ID_BEDFA= "Id_bedfa";
	//床位
	public static final String ID_BED= "Id_bed";
	//序号
	public static final String SORTNO= "Sortno";
	//对应设备编码
	public static final String CODE_FA= "Code_fa";
	//对应设备名称
	public static final String NAME_FA= "Name_fa";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 床位固定资产ID
	 * @return String
	 */
	public String getId_bedfa() {
		return ((String) getAttrVal("Id_bedfa"));
	}	
	/**
	 * 床位固定资产ID
	 * @param Id_bedfa
	 */
	public void setId_bedfa(String Id_bedfa) {
		setAttrVal("Id_bedfa", Id_bedfa);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 床位
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 对应设备编码
	 * @return String
	 */
	public String getCode_fa() {
		return ((String) getAttrVal("Code_fa"));
	}	
	/**
	 * 对应设备编码
	 * @param Code_fa
	 */
	public void setCode_fa(String Code_fa) {
		setAttrVal("Code_fa", Code_fa);
	}
	/**
	 * 对应设备名称
	 * @return String
	 */
	public String getName_fa() {
		return ((String) getAttrVal("Name_fa"));
	}	
	/**
	 * 对应设备名称
	 * @param Name_fa
	 */
	public void setName_fa(String Name_fa) {
		setAttrVal("Name_fa", Name_fa);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_bedfa";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_BED_FA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdbedfaDesc.class);
	}
	
}