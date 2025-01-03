package iih.en.pv.hpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保卡信息 DTO数据 
 * 
 */
public class EnHpCardDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 社保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 社保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}
	/**
	 * 患者性别编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	/**
	 * 患者性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 患者性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 患者性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
	 * 医保在院状态
	 * @return FBoolean
	 */
	public FBoolean getFg_hpip() {
		return ((FBoolean) getAttrVal("Fg_hpip"));
	}
	/**
	 * 医保在院状态
	 * @param Fg_hpip
	 */
	public void setFg_hpip(FBoolean Fg_hpip) {
		setAttrVal("Fg_hpip", Fg_hpip);
	}
	/**
	 * 医保在院状态名称
	 * @return String
	 */
	public String getName_fg_hpip() {
		return ((String) getAttrVal("Name_fg_hpip"));
	}
	/**
	 * 医保在院状态名称
	 * @param Name_fg_hpip
	 */
	public void setName_fg_hpip(String Name_fg_hpip) {
		setAttrVal("Name_fg_hpip", Name_fg_hpip);
	}
	/**
	 * 医疗人员类别id
	 * @return String
	 */
	public String getId_hppatca() {
		return ((String) getAttrVal("Id_hppatca"));
	}
	/**
	 * 医疗人员类别id
	 * @param Id_hppatca
	 */
	public void setId_hppatca(String Id_hppatca) {
		setAttrVal("Id_hppatca", Id_hppatca);
	}
	/**
	 * 医疗人员类别编码
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 医疗人员类别编码
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 医疗人员类别
	 * @return String
	 */
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}
	/**
	 * 医疗人员类别
	 * @param Name_hppatca
	 */
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPercode() {
		return ((String) getAttrVal("Percode"));
	}
	/**
	 * 个人编号
	 * @param Percode
	 */
	public void setPercode(String Percode) {
		setAttrVal("Percode", Percode);
	}
	/**
	 * 统筹区域编号
	 * @return String
	 */
	public String getCode_hparea() {
		return ((String) getAttrVal("Code_hparea"));
	}
	/**
	 * 统筹区域编号
	 * @param Code_hparea
	 */
	public void setCode_hparea(String Code_hparea) {
		setAttrVal("Code_hparea", Code_hparea);
	}
	/**
	 * 统筹区域
	 * @return String
	 */
	public String getName_hparea() {
		return ((String) getAttrVal("Name_hparea"));
	}
	/**
	 * 统筹区域
	 * @param Name_hparea
	 */
	public void setName_hparea(String Name_hparea) {
		setAttrVal("Name_hparea", Name_hparea);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_frim() {
		return ((String) getAttrVal("Code_frim"));
	}
	/**
	 * 单位编码
	 * @param Code_frim
	 */
	public void setCode_frim(String Code_frim) {
		setAttrVal("Code_frim", Code_frim);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_firm() {
		return ((String) getAttrVal("Name_firm"));
	}
	/**
	 * 单位名称
	 * @param Name_firm
	 */
	public void setName_firm(String Name_firm) {
		setAttrVal("Name_firm", Name_firm);
	}
	/**
	 * 账户余额
	 * @return FDouble
	 */
	public FDouble getAccamount() {
		return ((FDouble) getAttrVal("Accamount"));
	}
	/**
	 * 账户余额
	 * @param Accamount
	 */
	public void setAccamount(FDouble Accamount) {
		setAttrVal("Accamount", Accamount);
	}
	/**
	 * 医疗类别id
	 * @return String
	 */
	public String getId_hpmedkind() {
		return ((String) getAttrVal("Id_hpmedkind"));
	}
	/**
	 * 医疗类别id
	 * @param Id_hpmedkind
	 */
	public void setId_hpmedkind(String Id_hpmedkind) {
		setAttrVal("Id_hpmedkind", Id_hpmedkind);
	}
	/**
	 * 医疗类别编码
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}
	/**
	 * 医疗类别编码
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getName_hpmedkind() {
		return ((String) getAttrVal("Name_hpmedkind"));
	}
	/**
	 * 医疗类别
	 * @param Name_hpmedkind
	 */
	public void setName_hpmedkind(String Name_hpmedkind) {
		setAttrVal("Name_hpmedkind", Name_hpmedkind);
	}
	/**
	 * 医疗类别明细
	 * @return String
	 */
	public String getMedkinditem_code() {
		return ((String) getAttrVal("Medkinditem_code"));
	}
	/**
	 * 医疗类别明细
	 * @param Medkinditem_code
	 */
	public void setMedkinditem_code(String Medkinditem_code) {
		setAttrVal("Medkinditem_code", Medkinditem_code);
	}
	/**
	 * 医生id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 医生id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}
	/**
	 * 医生编码
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 医生名称
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 账户使用标志
	 * @return String
	 */
	public String getFlag_account_use() {
		return ((String) getAttrVal("Flag_account_use"));
	}
	/**
	 * 账户使用标志
	 * @param Flag_account_use
	 */
	public void setFlag_account_use(String Flag_account_use) {
		setAttrVal("Flag_account_use", Flag_account_use);
	}
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 上次出院日期
	 * @return FDate
	 */
	public FDate getDt_ltst() {
		return ((FDate) getAttrVal("Dt_ltst"));
	}
	/**
	 * 上次出院日期
	 * @param Dt_ltst
	 */
	public void setDt_ltst(FDate Dt_ltst) {
		setAttrVal("Dt_ltst", Dt_ltst);
	}
	/**
	 * 统筹累计
	 * @return FDouble
	 */
	public FDouble getTyovamount() {
		return ((FDouble) getAttrVal("Tyovamount"));
	}
	/**
	 * 统筹累计
	 * @param Tyovamount
	 */
	public void setTyovamount(FDouble Tyovamount) {
		setAttrVal("Tyovamount", Tyovamount);
	}
	/**
	 * 大病累计
	 * @return FDouble
	 */
	public FDouble getTylovamount() {
		return ((FDouble) getAttrVal("Tylovamount"));
	}
	/**
	 * 大病累计
	 * @param Tylovamount
	 */
	public void setTylovamount(FDouble Tylovamount) {
		setAttrVal("Tylovamount", Tylovamount);
	}
	/**
	 * 慢病编码
	 * @return String
	 */
	public String getCode_oepchronic() {
		return ((String) getAttrVal("Code_oepchronic"));
	}
	/**
	 * 慢病编码
	 * @param Code_oepchronic
	 */
	public void setCode_oepchronic(String Code_oepchronic) {
		setAttrVal("Code_oepchronic", Code_oepchronic);
	}
	/**
	 * 慢病统筹累计
	 * @return FDouble
	 */
	public FDouble getInhp_oepchronic() {
		return ((FDouble) getAttrVal("Inhp_oepchronic"));
	}
	/**
	 * 慢病统筹累计
	 * @param Inhp_oepchronic
	 */
	public void setInhp_oepchronic(FDouble Inhp_oepchronic) {
		setAttrVal("Inhp_oepchronic", Inhp_oepchronic);
	}
	/**
	 * 个人身份
	 * @return String
	 */
	public String getPer_iden() {
		return ((String) getAttrVal("Per_iden"));
	}
	/**
	 * 个人身份
	 * @param Per_iden
	 */
	public void setPer_iden(String Per_iden) {
		setAttrVal("Per_iden", Per_iden);
	}
	/**
	 * 异地人员标识
	 * @return String
	 */
	public String getFg_allopatry() {
		return ((String) getAttrVal("Fg_allopatry"));
	}
	/**
	 * 异地人员标识
	 * @param Fg_allopatry
	 */
	public void setFg_allopatry(String Fg_allopatry) {
		setAttrVal("Fg_allopatry", Fg_allopatry);
	}
	/**
	 * 异地人员标识名称
	 * @return String
	 */
	public String getName_fg_allopatry() {
		return ((String) getAttrVal("Name_fg_allopatry"));
	}
	/**
	 * 异地人员标识名称
	 * @param Name_fg_allopatry
	 */
	public void setName_fg_allopatry(String Name_fg_allopatry) {
		setAttrVal("Name_fg_allopatry", Name_fg_allopatry);
	}
	/**
	 * 困难群众标识
	 * @return String
	 */
	public String getFg_specneed() {
		return ((String) getAttrVal("Fg_specneed"));
	}
	/**
	 * 困难群众标识
	 * @param Fg_specneed
	 */
	public void setFg_specneed(String Fg_specneed) {
		setAttrVal("Fg_specneed", Fg_specneed);
	}
	/**
	 * 困难群众标识名称
	 * @return String
	 */
	public String getName_fg_specneed() {
		return ((String) getAttrVal("Name_fg_specneed"));
	}
	/**
	 * 困难群众标识名称
	 * @param Name_fg_specneed
	 */
	public void setName_fg_specneed(String Name_fg_specneed) {
		setAttrVal("Name_fg_specneed", Name_fg_specneed);
	}
	/**
	 * 本年困难群众大额补充报销累计
	 * @return FDouble
	 */
	public FDouble getSpecneed_bigcivilamount() {
		return ((FDouble) getAttrVal("Specneed_bigcivilamount"));
	}
	/**
	 * 本年困难群众大额补充报销累计
	 * @param Specneed_bigcivilamount
	 */
	public void setSpecneed_bigcivilamount(FDouble Specneed_bigcivilamount) {
		setAttrVal("Specneed_bigcivilamount", Specneed_bigcivilamount);
	}
	/**
	 * 本年困难群众大额补充自付累计
	 * @return FDouble
	 */
	public FDouble getSpecneed_bigcivilselfamount() {
		return ((FDouble) getAttrVal("Specneed_bigcivilselfamount"));
	}
	/**
	 * 本年困难群众大额补充自付累计
	 * @param Specneed_bigcivilselfamount
	 */
	public void setSpecneed_bigcivilselfamount(FDouble Specneed_bigcivilselfamount) {
		setAttrVal("Specneed_bigcivilselfamount", Specneed_bigcivilselfamount);
	}
	/**
	 * 本年困难群众进入大额补充累计
	 * @return FDouble
	 */
	public FDouble getSpecneed_inbigcivilamount() {
		return ((FDouble) getAttrVal("Specneed_inbigcivilamount"));
	}
	/**
	 * 本年困难群众进入大额补充累计
	 * @param Specneed_inbigcivilamount
	 */
	public void setSpecneed_inbigcivilamount(FDouble Specneed_inbigcivilamount) {
		setAttrVal("Specneed_inbigcivilamount", Specneed_inbigcivilamount);
	}
	/**
	 * 生育证号
	 * @return String
	 */
	public String getBirthcerticode() {
		return ((String) getAttrVal("Birthcerticode"));
	}
	/**
	 * 生育证号
	 * @param Birthcerticode
	 */
	public void setBirthcerticode(String Birthcerticode) {
		setAttrVal("Birthcerticode", Birthcerticode);
	}
	/**
	 * 男职工配偶身份证号
	 * @return String
	 */
	public String getIdcard_malespouse() {
		return ((String) getAttrVal("Idcard_malespouse"));
	}
	/**
	 * 男职工配偶身份证号
	 * @param Idcard_malespouse
	 */
	public void setIdcard_malespouse(String Idcard_malespouse) {
		setAttrVal("Idcard_malespouse", Idcard_malespouse);
	}
	/**
	 * 男职工配偶姓名
	 * @return String
	 */
	public String getName_malespouse() {
		return ((String) getAttrVal("Name_malespouse"));
	}
	/**
	 * 男职工配偶姓名
	 * @param Name_malespouse
	 */
	public void setName_malespouse(String Name_malespouse) {
		setAttrVal("Name_malespouse", Name_malespouse);
	}
	/**
	 * 生育手术类别
	 * @return String
	 */
	public String getBearoper_type() {
		return ((String) getAttrVal("Bearoper_type"));
	}
	/**
	 * 生育手术类别
	 * @param Bearoper_type
	 */
	public void setBearoper_type(String Bearoper_type) {
		setAttrVal("Bearoper_type", Bearoper_type);
	}
	/**
	 * 民政标识编码
	 * @return String
	 */
	public String getCode_civil() {
		return ((String) getAttrVal("Code_civil"));
	}
	/**
	 * 民政标识编码
	 * @param Code_civil
	 */
	public void setCode_civil(String Code_civil) {
		setAttrVal("Code_civil", Code_civil);
	}
	/**
	 * 民政标识
	 * @return String
	 */
	public String getName_civil() {
		return ((String) getAttrVal("Name_civil"));
	}
	/**
	 * 民政标识
	 * @param Name_civil
	 */
	public void setName_civil(String Name_civil) {
		setAttrVal("Name_civil", Name_civil);
	}
	/**
	 * 社保机构编号
	 * @return String
	 */
	public String getNo_hp_org() {
		return ((String) getAttrVal("No_hp_org"));
	}
	/**
	 * 社保机构编号
	 * @param No_hp_org
	 */
	public void setNo_hp_org(String No_hp_org) {
		setAttrVal("No_hp_org", No_hp_org);
	}
	/**
	 * 参保机构名称
	 * @return String
	 */
	public String getName_hp_org() {
		return ((String) getAttrVal("Name_hp_org"));
	}
	/**
	 * 参保机构名称
	 * @param Name_hp_org
	 */
	public void setName_hp_org(String Name_hp_org) {
		setAttrVal("Name_hp_org", Name_hp_org);
	}
	/**
	 * 灰名单标志
	 * @return String
	 */
	public String getFlag_greylist() {
		return ((String) getAttrVal("Flag_greylist"));
	}
	/**
	 * 灰名单标志
	 * @param Flag_greylist
	 */
	public void setFlag_greylist(String Flag_greylist) {
		setAttrVal("Flag_greylist", Flag_greylist);
	}
	/**
	 * 灰名单原因
	 * @return String
	 */
	public String getRsn_greylist() {
		return ((String) getAttrVal("Rsn_greylist"));
	}
	/**
	 * 灰名单原因
	 * @param Rsn_greylist
	 */
	public void setRsn_greylist(String Rsn_greylist) {
		setAttrVal("Rsn_greylist", Rsn_greylist);
	}
	/**
	 * 人群类别
	 * @return String
	 */
	public String getCrowdtype() {
		return ((String) getAttrVal("Crowdtype"));
	}
	/**
	 * 人群类别
	 * @param Crowdtype
	 */
	public void setCrowdtype(String Crowdtype) {
		setAttrVal("Crowdtype", Crowdtype);
	}
	/**
	 * 险种编码
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}
	/**
	 * 险种编码
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	/**
	 * 险种id
	 * @return String
	 */
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}
	/**
	 * 险种id
	 * @param Id_hpkind
	 */
	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}
	/**
	 * 险种
	 * @return String
	 */
	public String getName_hpkind() {
		return ((String) getAttrVal("Name_hpkind"));
	}
	/**
	 * 险种
	 * @param Name_hpkind
	 */
	public void setName_hpkind(String Name_hpkind) {
		setAttrVal("Name_hpkind", Name_hpkind);
	}
	/**
	 * 低保标识
	 * @return String
	 */
	public String getFg_minliving() {
		return ((String) getAttrVal("Fg_minliving"));
	}
	/**
	 * 低保标识
	 * @param Fg_minliving
	 */
	public void setFg_minliving(String Fg_minliving) {
		setAttrVal("Fg_minliving", Fg_minliving);
	}
	/**
	 * 五保标识
	 * @return String
	 */
	public String getFg_fiveguar() {
		return ((String) getAttrVal("Fg_fiveguar"));
	}
	/**
	 * 五保标识
	 * @param Fg_fiveguar
	 */
	public void setFg_fiveguar(String Fg_fiveguar) {
		setAttrVal("Fg_fiveguar", Fg_fiveguar);
	}
	/**
	 * 优抚对象标志
	 * @return String
	 */
	public String getFg_perferent() {
		return ((String) getAttrVal("Fg_perferent"));
	}
	/**
	 * 优抚对象标志
	 * @param Fg_perferent
	 */
	public void setFg_perferent(String Fg_perferent) {
		setAttrVal("Fg_perferent", Fg_perferent);
	}
	/**
	 * 优抚对象类别
	 * @return String
	 */
	public String getPerferentcate() {
		return ((String) getAttrVal("Perferentcate"));
	}
	/**
	 * 优抚对象类别
	 * @param Perferentcate
	 */
	public void setPerferentcate(String Perferentcate) {
		setAttrVal("Perferentcate", Perferentcate);
	}
	/**
	 * 门诊科室编码
	 * @return String
	 */
	public String getCode_dep_op() {
		return ((String) getAttrVal("Code_dep_op"));
	}
	/**
	 * 门诊科室编码
	 * @param Code_dep_op
	 */
	public void setCode_dep_op(String Code_dep_op) {
		setAttrVal("Code_dep_op", Code_dep_op);
	}
	/**
	 * 门诊科室id
	 * @return String
	 */
	public String getId_dep_op() {
		return ((String) getAttrVal("Id_dep_op"));
	}
	/**
	 * 门诊科室id
	 * @param Id_dep_op
	 */
	public void setId_dep_op(String Id_dep_op) {
		setAttrVal("Id_dep_op", Id_dep_op);
	}
	/**
	 * 门诊科室
	 * @return String
	 */
	public String getName_dep_op() {
		return ((String) getAttrVal("Name_dep_op"));
	}
	/**
	 * 门诊科室
	 * @param Name_dep_op
	 */
	public void setName_dep_op(String Name_dep_op) {
		setAttrVal("Name_dep_op", Name_dep_op);
	}
	/**
	 * 住院方式
	 * @return String
	 */
	public String getInpatient_way() {
		return ((String) getAttrVal("Inpatient_way"));
	}
	/**
	 * 住院方式
	 * @param Inpatient_way
	 */
	public void setInpatient_way(String Inpatient_way) {
		setAttrVal("Inpatient_way", Inpatient_way);
	}
	/**
	 * 就医类型
	 * @return String
	 */
	public String getHospitalize_type() {
		return ((String) getAttrVal("Hospitalize_type"));
	}
	/**
	 * 就医类型
	 * @param Hospitalize_type
	 */
	public void setHospitalize_type(String Hospitalize_type) {
		setAttrVal("Hospitalize_type", Hospitalize_type);
	}
	/**
	 * 审批编号
	 * @return String
	 */
	public String getApply_code() {
		return ((String) getAttrVal("Apply_code"));
	}
	/**
	 * 审批编号
	 * @param Apply_code
	 */
	public void setApply_code(String Apply_code) {
		setAttrVal("Apply_code", Apply_code);
	}
	/**
	 * 医保诊断id
	 * @return String
	 */
	public String getId_hpdi() {
		return ((String) getAttrVal("Id_hpdi"));
	}
	/**
	 * 医保诊断id
	 * @param Id_hpdi
	 */
	public void setId_hpdi(String Id_hpdi) {
		setAttrVal("Id_hpdi", Id_hpdi);
	}
	/**
	 * 州市统筹区域编号
	 * @return String
	 */
	public String getCode_hparea_city() {
		return ((String) getAttrVal("Code_hparea_city"));
	}
	/**
	 * 州市统筹区域编号
	 * @param Code_hparea_city
	 */
	public void setCode_hparea_city(String Code_hparea_city) {
		setAttrVal("Code_hparea_city", Code_hparea_city);
	}
	/**
	 * 州市统筹区域名称
	 * @return String
	 */
	public String getName_hparea_city() {
		return ((String) getAttrVal("Name_hparea_city"));
	}
	/**
	 * 州市统筹区域名称
	 * @param Name_hparea_city
	 */
	public void setName_hparea_city(String Name_hparea_city) {
		setAttrVal("Name_hparea_city", Name_hparea_city);
	}
	/**
	 * 建档立卡标识
	 * @return FBoolean
	 */
	public FBoolean getFg_filing_card() {
		return ((FBoolean) getAttrVal("Fg_filing_card"));
	}
	/**
	 * 建档立卡标识
	 * @param Fg_filing_card
	 */
	public void setFg_filing_card(FBoolean Fg_filing_card) {
		setAttrVal("Fg_filing_card", Fg_filing_card);
	}
	/**
	 * 参保地市编码
	 * @return String
	 */
	public String getArea_insuredcode() {
		return ((String) getAttrVal("Area_insuredcode"));
	}
	/**
	 * 参保地市编码
	 * @param Area_insuredcode
	 */
	public void setArea_insuredcode(String Area_insuredcode) {
		setAttrVal("Area_insuredcode", Area_insuredcode);
	}
	/**
	 * 是否为慢性病
	 * @return FBoolean
	 */
	public FBoolean getFg_oepchronic() {
		return ((FBoolean) getAttrVal("Fg_oepchronic"));
	}
	/**
	 * 是否为慢性病
	 * @param Fg_oepchronic
	 */
	public void setFg_oepchronic(FBoolean Fg_oepchronic) {
		setAttrVal("Fg_oepchronic", Fg_oepchronic);
	}
	/**
	 * 卡识别码
	 * @return String
	 */
	public String getSocialcardid() {
		return ((String) getAttrVal("Socialcardid"));
	}
	/**
	 * 卡识别码
	 * @param Socialcardid
	 */
	public void setSocialcardid(String Socialcardid) {
		setAttrVal("Socialcardid", Socialcardid);
	}
	/**
	 * 读卡信息串
	 * @return String
	 */
	public String getReadcardinfo() {
		return ((String) getAttrVal("Readcardinfo"));
	}
	/**
	 * 读卡信息串
	 * @param Readcardinfo
	 */
	public void setReadcardinfo(String Readcardinfo) {
		setAttrVal("Readcardinfo", Readcardinfo);
	}
	/**
	 * 分级诊疗类别
	 * @return String
	 */
	public String getLevel_treattp() {
		return ((String) getAttrVal("Level_treattp"));
	}
	/**
	 * 分级诊疗类别
	 * @param Level_treattp
	 */
	public void setLevel_treattp(String Level_treattp) {
		setAttrVal("Level_treattp", Level_treattp);
	}
	/**
	 * 是否费用总控
	 * @return FBoolean
	 */
	public FBoolean getFg_blcontr() {
		return ((FBoolean) getAttrVal("Fg_blcontr"));
	}
	/**
	 * 是否费用总控
	 * @param Fg_blcontr
	 */
	public void setFg_blcontr(FBoolean Fg_blcontr) {
		setAttrVal("Fg_blcontr", Fg_blcontr);
	}
	/**
	 * 预产期
	 * @return FDate
	 */
	public FDate getD_expected_child() {
		return ((FDate) getAttrVal("D_expected_child"));
	}
	/**
	 * 预产期
	 * @param D_expected_child
	 */
	public void setD_expected_child(FDate D_expected_child) {
		setAttrVal("D_expected_child", D_expected_child);
	}
	/**
	 * 怀孕时间
	 * @return FDate
	 */
	public FDate getD_conception() {
		return ((FDate) getAttrVal("D_conception"));
	}
	/**
	 * 怀孕时间
	 * @param D_conception
	 */
	public void setD_conception(FDate D_conception) {
		setAttrVal("D_conception", D_conception);
	}
	/**
	 * 生育胎次
	 * @return Integer
	 */
	public Integer getTimes_gravida() {
		return ((Integer) getAttrVal("Times_gravida"));
	}
	/**
	 * 生育胎次
	 * @param Times_gravida
	 */
	public void setTimes_gravida(Integer Times_gravida) {
		setAttrVal("Times_gravida", Times_gravida);
	}
	/**
	 * 结婚证号
	 * @return String
	 */
	public String getNo_marriage() {
		return ((String) getAttrVal("No_marriage"));
	}
	/**
	 * 结婚证号
	 * @param No_marriage
	 */
	public void setNo_marriage(String No_marriage) {
		setAttrVal("No_marriage", No_marriage);
	}
	/**
	 * 计划生育服务手册
	 * @return String
	 */
	public String getJsschm() {
		return ((String) getAttrVal("Jsschm"));
	}
	/**
	 * 计划生育服务手册
	 * @param Jsschm
	 */
	public void setJsschm(String Jsschm) {
		setAttrVal("Jsschm", Jsschm);
	}
	/**
	 * 并发症编码
	 * @return String
	 */
	public String getCode_complication() {
		return ((String) getAttrVal("Code_complication"));
	}
	/**
	 * 并发症编码
	 * @param Code_complication
	 */
	public void setCode_complication(String Code_complication) {
		setAttrVal("Code_complication", Code_complication);
	}
	/**
	 * 并发症名称
	 * @return String
	 */
	public String getName_complication() {
		return ((String) getAttrVal("Name_complication"));
	}
	/**
	 * 并发症名称
	 * @param Name_complication
	 */
	public void setName_complication(String Name_complication) {
		setAttrVal("Name_complication", Name_complication);
	}
	/**
	 * 客开登记信息
	 * @return String
	 */
	public String getCustom_info() {
		return ((String) getAttrVal("Custom_info"));
	}
	/**
	 * 客开登记信息
	 * @param Custom_info
	 */
	public void setCustom_info(String Custom_info) {
		setAttrVal("Custom_info", Custom_info);
	}
	/**
	 * 客开字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 客开字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客开字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 客开字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客开字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客开字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客开字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客开字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客开字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客开字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客开字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}
	/**
	 * 客开字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客开字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}
	/**
	 * 客开字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客开字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}
	/**
	 * 客开字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客开字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}
	/**
	 * 客开字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客开字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}
	/**
	 * 客开字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 电子医保二维码
	 * @return String
	 */
	public String getTwobar_code() {
		return ((String) getAttrVal("Twobar_code"));
	}
	/**
	 * 电子医保二维码
	 * @param Twobar_code
	 */
	public void setTwobar_code(String Twobar_code) {
		setAttrVal("Twobar_code", Twobar_code);
	}
	/**
	 * 电子医保令牌
	 * @return String
	 */
	public String getTwobar_token() {
		return ((String) getAttrVal("Twobar_token"));
	}
	/**
	 * 电子医保令牌
	 * @param Twobar_token
	 */
	public void setTwobar_token(String Twobar_token) {
		setAttrVal("Twobar_token", Twobar_token);
	}
}