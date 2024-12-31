package iih.en.pv.pativisit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.pativisit.d.desc.EntContDODesc;
import java.math.BigDecimal;

/**
 * 就诊联系人 DO数据 
 * 
 */
public class EntContDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//就诊联系人id
	public static final String ID_ENTCONT= "Id_entcont";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//序号
	public static final String SORTNO= "Sortno";
	//就诊联系人类型
	public static final String EU_ENTCONTTP= "Eu_entconttp";
	//患者联系人id
	public static final String ID_PATCONTID= "Id_patcontid";
	//联系人类型id
	public static final String ID_CONTTP= "Id_conttp";
	//联系人类型
	public static final String SD_CONTTP= "Sd_conttp";
	//联系人名称
	public static final String NAME= "Name";
	//联系人电话
	public static final String CONTTEL= "Conttel";
	//联系人地址
	public static final String CONTADDR= "Contaddr";
	//邮政编码
	public static final String ZIP= "Zip";
	//证件类型id
	public static final String ID_IDTP= "Id_idtp";
	//证件类型编码
	public static final String SD_IDTP= "Sd_idtp";
	//担保类型id
	public static final String ID_GUARANTP= "Id_guarantp";
	//担保类型编码
	public static final String SD_GUARANTP= "Sd_guarantp";
	//证件号
	public static final String IDCODE= "Idcode";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//名称
	public static final String NAME_CONTTP= "Name_conttp";
	//名称
	public static final String NAME_IDTP= "Name_idtp";
	//担保类型名称
	public static final String NAME_GUARANTP= "Name_guarantp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 就诊联系人id
	 * @return String
	 */
	public String getId_entcont() {
		return ((String) getAttrVal("Id_entcont"));
	}	
	/**
	 * 就诊联系人id
	 * @param Id_entcont
	 */
	public void setId_entcont(String Id_entcont) {
		setAttrVal("Id_entcont", Id_entcont);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 就诊联系人类型
	 * @return Integer
	 */
	public Integer getEu_entconttp() {
		return ((Integer) getAttrVal("Eu_entconttp"));
	}	
	/**
	 * 就诊联系人类型
	 * @param Eu_entconttp
	 */
	public void setEu_entconttp(Integer Eu_entconttp) {
		setAttrVal("Eu_entconttp", Eu_entconttp);
	}
	/**
	 * 患者联系人id
	 * @return String
	 */
	public String getId_patcontid() {
		return ((String) getAttrVal("Id_patcontid"));
	}	
	/**
	 * 患者联系人id
	 * @param Id_patcontid
	 */
	public void setId_patcontid(String Id_patcontid) {
		setAttrVal("Id_patcontid", Id_patcontid);
	}
	/**
	 * 联系人类型id
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}	
	/**
	 * 联系人类型id
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人类型
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}	
	/**
	 * 联系人类型
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 联系人名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getConttel() {
		return ((String) getAttrVal("Conttel"));
	}	
	/**
	 * 联系人电话
	 * @param Conttel
	 */
	public void setConttel(String Conttel) {
		setAttrVal("Conttel", Conttel);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getContaddr() {
		return ((String) getAttrVal("Contaddr"));
	}	
	/**
	 * 联系人地址
	 * @param Contaddr
	 */
	public void setContaddr(String Contaddr) {
		setAttrVal("Contaddr", Contaddr);
	}
	/**
	 * 邮政编码
	 * @return String
	 */
	public String getZip() {
		return ((String) getAttrVal("Zip"));
	}	
	/**
	 * 邮政编码
	 * @param Zip
	 */
	public void setZip(String Zip) {
		setAttrVal("Zip", Zip);
	}
	/**
	 * 证件类型id
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	/**
	 * 证件类型id
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 担保类型id
	 * @return String
	 */
	public String getId_guarantp() {
		return ((String) getAttrVal("Id_guarantp"));
	}	
	/**
	 * 担保类型id
	 * @param Id_guarantp
	 */
	public void setId_guarantp(String Id_guarantp) {
		setAttrVal("Id_guarantp", Id_guarantp);
	}
	/**
	 * 担保类型编码
	 * @return String
	 */
	public String getSd_guarantp() {
		return ((String) getAttrVal("Sd_guarantp"));
	}	
	/**
	 * 担保类型编码
	 * @param Sd_guarantp
	 */
	public void setSd_guarantp(String Sd_guarantp) {
		setAttrVal("Sd_guarantp", Sd_guarantp);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	/**
	 * 证件号
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}	
	/**
	 * 名称
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}	
	/**
	 * 名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 担保类型名称
	 * @return String
	 */
	public String getName_guarantp() {
		return ((String) getAttrVal("Name_guarantp"));
	}	
	/**
	 * 担保类型名称
	 * @param Name_guarantp
	 */
	public void setName_guarantp(String Name_guarantp) {
		setAttrVal("Name_guarantp", Name_guarantp);
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
		return "Id_entcont";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_cont";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntContDODesc.class);
	}
	
}