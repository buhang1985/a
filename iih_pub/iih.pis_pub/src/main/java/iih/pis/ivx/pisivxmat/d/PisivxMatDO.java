package iih.pis.ivx.pisivxmat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxmat.d.desc.PisivxMatDODesc;
import java.math.BigDecimal;

/**
 * 微信患者材料 DO数据 
 * 
 */
public class PisivxMatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信患者材料主键标识
	public static final String ID_PISIVXMAT= "Id_pisivxmat";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//微信就诊人ID
	public static final String ID_PISIVXMEMBER= "Id_pisivxmember";
	//正面
	public static final String FACE= "Face";
	//反面
	public static final String BACK= "Back";
	//证件照片类型
	public static final String CARDTP= "Cardtp";
	//姓名
	public static final String NAME_PAT= "Name_pat";
	//移动电话
	public static final String MOB= "Mob";
	//关系
	public static final String REL= "Rel";
	//患者医保卡号
	public static final String MEDINSCODE= "Medinscode";
	//参保机构代码
	public static final String INSUREDORGCODE= "Insuredorgcode";
	//年龄
	public static final String AGE= "Age";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//主身份标识号码
	public static final String ID_CODE= "Id_code";
	//主身份标志类型
	public static final String ID_IDTP= "Id_idtp";
	//主身份标志类型编码
	public static final String SD_IDTP= "Sd_idtp";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信患者材料主键标识
	 * @return String
	 */
	public String getId_pisivxmat() {
		return ((String) getAttrVal("Id_pisivxmat"));
	}	
	/**
	 * 微信患者材料主键标识
	 * @param Id_pisivxmat
	 */
	public void setId_pisivxmat(String Id_pisivxmat) {
		setAttrVal("Id_pisivxmat", Id_pisivxmat);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 微信账户ID
	 * @return String
	 */
	public String getId_pisivxaccount() {
		return ((String) getAttrVal("Id_pisivxaccount"));
	}	
	/**
	 * 微信账户ID
	 * @param Id_pisivxaccount
	 */
	public void setId_pisivxaccount(String Id_pisivxaccount) {
		setAttrVal("Id_pisivxaccount", Id_pisivxaccount);
	}
	/**
	 * 微信就诊人ID
	 * @return String
	 */
	public String getId_pisivxmember() {
		return ((String) getAttrVal("Id_pisivxmember"));
	}	
	/**
	 * 微信就诊人ID
	 * @param Id_pisivxmember
	 */
	public void setId_pisivxmember(String Id_pisivxmember) {
		setAttrVal("Id_pisivxmember", Id_pisivxmember);
	}
	/**
	 * 正面
	 * @return byte[]
	 */
	public byte[] getFace() {
		return ((byte[]) getAttrVal("Face"));
	}	
	/**
	 * 正面
	 * @param Face
	 */
	public void setFace(byte[] Face) {
		setAttrVal("Face", Face);
	}
	/**
	 * 反面
	 * @return byte[]
	 */
	public byte[] getBack() {
		return ((byte[]) getAttrVal("Back"));
	}	
	/**
	 * 反面
	 * @param Back
	 */
	public void setBack(byte[] Back) {
		setAttrVal("Back", Back);
	}
	/**
	 * 证件照片类型
	 * @return Integer
	 */
	public Integer getCardtp() {
		return ((Integer) getAttrVal("Cardtp"));
	}	
	/**
	 * 证件照片类型
	 * @param Cardtp
	 */
	public void setCardtp(Integer Cardtp) {
		setAttrVal("Cardtp", Cardtp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 关系
	 * @return Integer
	 */
	public Integer getRel() {
		return ((Integer) getAttrVal("Rel"));
	}	
	/**
	 * 关系
	 * @param Rel
	 */
	public void setRel(Integer Rel) {
		setAttrVal("Rel", Rel);
	}
	/**
	 * 患者医保卡号
	 * @return String
	 */
	public String getMedinscode() {
		return ((String) getAttrVal("Medinscode"));
	}	
	/**
	 * 患者医保卡号
	 * @param Medinscode
	 */
	public void setMedinscode(String Medinscode) {
		setAttrVal("Medinscode", Medinscode);
	}
	/**
	 * 参保机构代码
	 * @return String
	 */
	public String getInsuredorgcode() {
		return ((String) getAttrVal("Insuredorgcode"));
	}	
	/**
	 * 参保机构代码
	 * @param Insuredorgcode
	 */
	public void setInsuredorgcode(String Insuredorgcode) {
		setAttrVal("Insuredorgcode", Insuredorgcode);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
		return "Id_pisivxmat";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxMatDODesc.class);
	}
	
}