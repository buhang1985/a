package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊基本信息维护DTO DTO数据 
 * 
 */
public class OpBasic4EditDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者头像
	 * @return byte[]
	 */
	public byte[] getPhoto_pat() {
		return ((byte[]) getAttrVal("Photo_pat"));
	}
	/**
	 * 患者头像
	 * @param Photo_pat
	 */
	public void setPhoto_pat(byte[] Photo_pat) {
		setAttrVal("Photo_pat", Photo_pat);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getName_patcret() {
		return ((String) getAttrVal("Name_patcret"));
	}
	/**
	 * 信用分类
	 * @param Name_patcret
	 */
	public void setName_patcret(String Name_patcret) {
		setAttrVal("Name_patcret", Name_patcret);
	}
	/**
	 * 主医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 主医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 主医保计划
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 辅医保卡号
	 * @return String
	 */
	public String getNo_hp_as() {
		return ((String) getAttrVal("No_hp_as"));
	}
	/**
	 * 辅医保卡号
	 * @param No_hp_as
	 */
	public void setNo_hp_as(String No_hp_as) {
		setAttrVal("No_hp_as", No_hp_as);
	}
	/**
	 * 辅医保计划
	 * @return String
	 */
	public String getName_hp_as() {
		return ((String) getAttrVal("Name_hp_as"));
	}
	/**
	 * 辅医保计划
	 * @param Name_hp_as
	 */
	public void setName_hp_as(String Name_hp_as) {
		setAttrVal("Name_hp_as", Name_hp_as);
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
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}
	/**
	 * 证件号码
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}
	/**
	 * 联系电话
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 联系地址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 联系地址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 联系地址区县码编码
	 * @return String
	 */
	public String getSd_admdiv_addr() {
		return ((String) getAttrVal("Sd_admdiv_addr"));
	}
	/**
	 * 联系地址区县码编码
	 * @param Sd_admdiv_addr
	 */
	public void setSd_admdiv_addr(String Sd_admdiv_addr) {
		setAttrVal("Sd_admdiv_addr", Sd_admdiv_addr);
	}
	/**
	 * 联系地址区县码id
	 * @return String
	 */
	public String getId_admdiv_addr() {
		return ((String) getAttrVal("Id_admdiv_addr"));
	}
	/**
	 * 联系地址区县码id
	 * @param Id_admdiv_addr
	 */
	public void setId_admdiv_addr(String Id_admdiv_addr) {
		setAttrVal("Id_admdiv_addr", Id_admdiv_addr);
	}
	/**
	 * 联系地址区县码
	 * @return String
	 */
	public String getName_admdiv_addr() {
		return ((String) getAttrVal("Name_admdiv_addr"));
	}
	/**
	 * 联系地址区县码
	 * @param Name_admdiv_addr
	 */
	public void setName_admdiv_addr(String Name_admdiv_addr) {
		setAttrVal("Name_admdiv_addr", Name_admdiv_addr);
	}
	/**
	 * 联系人id
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}
	/**
	 * 联系人id
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
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
	 * 联系人类型编码
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人类型编码
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人类型名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型名称
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}
	/**
	 * 联系人姓名
	 * @param Name_cont
	 */
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
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
	 * 代办联系人id
	 * @return String
	 */
	public String getId_patcont_agent() {
		return ((String) getAttrVal("Id_patcont_agent"));
	}
	/**
	 * 代办联系人id
	 * @param Id_patcont_agent
	 */
	public void setId_patcont_agent(String Id_patcont_agent) {
		setAttrVal("Id_patcont_agent", Id_patcont_agent);
	}
	/**
	 * 代办人类型id
	 * @return String
	 */
	public String getId_conttp_agent() {
		return ((String) getAttrVal("Id_conttp_agent"));
	}
	/**
	 * 代办人类型id
	 * @param Id_conttp_agent
	 */
	public void setId_conttp_agent(String Id_conttp_agent) {
		setAttrVal("Id_conttp_agent", Id_conttp_agent);
	}
	/**
	 * 代办人类型编码
	 * @return String
	 */
	public String getSd_conttp_agent() {
		return ((String) getAttrVal("Sd_conttp_agent"));
	}
	/**
	 * 代办人类型编码
	 * @param Sd_conttp_agent
	 */
	public void setSd_conttp_agent(String Sd_conttp_agent) {
		setAttrVal("Sd_conttp_agent", Sd_conttp_agent);
	}
	/**
	 * 代办人类型
	 * @return String
	 */
	public String getName_conttp_agent() {
		return ((String) getAttrVal("Name_conttp_agent"));
	}
	/**
	 * 代办人类型
	 * @param Name_conttp_agent
	 */
	public void setName_conttp_agent(String Name_conttp_agent) {
		setAttrVal("Name_conttp_agent", Name_conttp_agent);
	}
	/**
	 * 代办人姓名
	 * @return String
	 */
	public String getName_cont_agent() {
		return ((String) getAttrVal("Name_cont_agent"));
	}
	/**
	 * 代办人姓名
	 * @param Name_cont_agent
	 */
	public void setName_cont_agent(String Name_cont_agent) {
		setAttrVal("Name_cont_agent", Name_cont_agent);
	}
	/**
	 * 代办人地址
	 * @return String
	 */
	public String getContaddr_agent() {
		return ((String) getAttrVal("Contaddr_agent"));
	}
	/**
	 * 代办人地址
	 * @param Contaddr_agent
	 */
	public void setContaddr_agent(String Contaddr_agent) {
		setAttrVal("Contaddr_agent", Contaddr_agent);
	}
	/**
	 * 代办人联系电话
	 * @return String
	 */
	public String getConttel_agent() {
		return ((String) getAttrVal("Conttel_agent"));
	}
	/**
	 * 代办人联系电话
	 * @param Conttel_agent
	 */
	public void setConttel_agent(String Conttel_agent) {
		setAttrVal("Conttel_agent", Conttel_agent);
	}
	/**
	 * 代办人证件号码
	 * @return String
	 */
	public String getIdcode_agent() {
		return ((String) getAttrVal("Idcode_agent"));
	}
	/**
	 * 代办人证件号码
	 * @param Idcode_agent
	 */
	public void setIdcode_agent(String Idcode_agent) {
		setAttrVal("Idcode_agent", Idcode_agent);
	}
	/**
	 * 联系人就诊id
	 * @return String
	 */
	public String getId_entcont() {
		return ((String) getAttrVal("Id_entcont"));
	}
	/**
	 * 联系人就诊id
	 * @param Id_entcont
	 */
	public void setId_entcont(String Id_entcont) {
		setAttrVal("Id_entcont", Id_entcont);
	}
	/**
	 * 代办人就诊id
	 * @return String
	 */
	public String getId_entcont_agent() {
		return ((String) getAttrVal("Id_entcont_agent"));
	}
	/**
	 * 代办人就诊id
	 * @param Id_entcont_agent
	 */
	public void setId_entcont_agent(String Id_entcont_agent) {
		setAttrVal("Id_entcont_agent", Id_entcont_agent);
	}
	/**
	 * 代办人证件类型id
	 * @return String
	 */
	public String getId_idtp_agent() {
		return ((String) getAttrVal("Id_idtp_agent"));
	}
	/**
	 * 代办人证件类型id
	 * @param Id_idtp_agent
	 */
	public void setId_idtp_agent(String Id_idtp_agent) {
		setAttrVal("Id_idtp_agent", Id_idtp_agent);
	}
	/**
	 * 代办人证件类型编码
	 * @return String
	 */
	public String getSd_idtp_agent() {
		return ((String) getAttrVal("Sd_idtp_agent"));
	}
	/**
	 * 代办人证件类型编码
	 * @param Sd_idtp_agent
	 */
	public void setSd_idtp_agent(String Sd_idtp_agent) {
		setAttrVal("Sd_idtp_agent", Sd_idtp_agent);
	}
	/**
	 * 代办人证件类型名称
	 * @return String
	 */
	public String getName_idtp_agent() {
		return ((String) getAttrVal("Name_idtp_agent"));
	}
	/**
	 * 代办人证件类型名称
	 * @param Name_idtp_agent
	 */
	public void setName_idtp_agent(String Name_idtp_agent) {
		setAttrVal("Name_idtp_agent", Name_idtp_agent);
	}
	/**
	 * 是否复诊
	 * @return FBoolean
	 */
	public FBoolean getFg_visit() {
		return ((FBoolean) getAttrVal("Fg_visit"));
	}
	/**
	 * 是否复诊
	 * @param Fg_visit
	 */
	public void setFg_visit(FBoolean Fg_visit) {
		setAttrVal("Fg_visit", Fg_visit);
	}
	/**
	 * 性别ID
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别ID
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 病情等级ID
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级ID
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情等级编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病情等级名称
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情等级名称
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 诊断发病日期
	 * @return FDateTime
	 */
	public FDateTime getDt_di_mor() {
		return ((FDateTime) getAttrVal("Dt_di_mor"));
	}
	/**
	 * 诊断发病日期
	 * @param Dt_di_mor
	 */
	public void setDt_di_mor(FDateTime Dt_di_mor) {
		setAttrVal("Dt_di_mor", Dt_di_mor);
	}
	/**
	 * 患者状况
	 * @return String
	 */
	public String getName_en_states() {
		return ((String) getAttrVal("Name_en_states"));
	}
	/**
	 * 患者状况
	 * @param Name_en_states
	 */
	public void setName_en_states(String Name_en_states) {
		setAttrVal("Name_en_states", Name_en_states);
	}
	/**
	 * 患者状况集合
	 * @return FArrayList
	 */
	public FArrayList getFlist_en_states() {
		return ((FArrayList) getAttrVal("Flist_en_states"));
	}
	/**
	 * 患者状况集合
	 * @param Flist_en_states
	 */
	public void setFlist_en_states(FArrayList Flist_en_states) {
		setAttrVal("Flist_en_states", Flist_en_states);
	}
	/**
	 * 户口地址区县码
	 * @return String
	 */
	public String getSd_admdiv_resi() {
		return ((String) getAttrVal("Sd_admdiv_resi"));
	}
	/**
	 * 户口地址区县码
	 * @param Sd_admdiv_resi
	 */
	public void setSd_admdiv_resi(String Sd_admdiv_resi) {
		setAttrVal("Sd_admdiv_resi", Sd_admdiv_resi);
	}
	/**
	 * 户口地址区县码ID
	 * @return String
	 */
	public String getId_admdiv_resi() {
		return ((String) getAttrVal("Id_admdiv_resi"));
	}
	/**
	 * 户口地址区县码ID
	 * @param Id_admdiv_resi
	 */
	public void setId_admdiv_resi(String Id_admdiv_resi) {
		setAttrVal("Id_admdiv_resi", Id_admdiv_resi);
	}
	/**
	 * 户口地址区县码名称
	 * @return String
	 */
	public String getName_admdiv_resi() {
		return ((String) getAttrVal("Name_admdiv_resi"));
	}
	/**
	 * 户口地址区县码名称
	 * @param Name_admdiv_resi
	 */
	public void setName_admdiv_resi(String Name_admdiv_resi) {
		setAttrVal("Name_admdiv_resi", Name_admdiv_resi);
	}
	/**
	 * 户口地址详细信息
	 * @return String
	 */
	public String getDetail_addr_resi() {
		return ((String) getAttrVal("Detail_addr_resi"));
	}
	/**
	 * 户口地址详细信息
	 * @param Detail_addr_resi
	 */
	public void setDetail_addr_resi(String Detail_addr_resi) {
		setAttrVal("Detail_addr_resi", Detail_addr_resi);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
}