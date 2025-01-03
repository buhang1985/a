package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊队列屏幕显示DTO DTO数据 
 * 
 */
public class OpQue4DispDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医生id
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}
	/**
	 * 医生id
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}
	/**
	 * 医生编码
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}
	/**
	 * 医生姓名
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 医生英文名
	 * @return String
	 */
	public String getName_doc_en() {
		return ((String) getAttrVal("Name_doc_en"));
	}
	/**
	 * 医生英文名
	 * @param Name_doc_en
	 */
	public void setName_doc_en(String Name_doc_en) {
		setAttrVal("Name_doc_en", Name_doc_en);
	}
	/**
	 * 医生职称
	 * @return String
	 */
	public String getName_doctitle() {
		return ((String) getAttrVal("Name_doctitle"));
	}
	/**
	 * 医生职称
	 * @param Name_doctitle
	 */
	public void setName_doctitle(String Name_doctitle) {
		setAttrVal("Name_doctitle", Name_doctitle);
	}
	/**
	 * 医生职称英文名
	 * @return String
	 */
	public String getName_doctile_en() {
		return ((String) getAttrVal("Name_doctile_en"));
	}
	/**
	 * 医生职称英文名
	 * @param Name_doctile_en
	 */
	public void setName_doctile_en(String Name_doctile_en) {
		setAttrVal("Name_doctile_en", Name_doctile_en);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 科室英文名
	 * @return String
	 */
	public String getName_dep_en() {
		return ((String) getAttrVal("Name_dep_en"));
	}
	/**
	 * 科室英文名
	 * @param Name_dep_en
	 */
	public void setName_dep_en(String Name_dep_en) {
		setAttrVal("Name_dep_en", Name_dep_en);
	}
	/**
	 * 诊室号
	 * @return String
	 */
	public String getCode_room() {
		return ((String) getAttrVal("Code_room"));
	}
	/**
	 * 诊室号
	 * @param Code_room
	 */
	public void setCode_room(String Code_room) {
		setAttrVal("Code_room", Code_room);
	}
	/**
	 * 诊室名称
	 * @return String
	 */
	public String getName_room() {
		return ((String) getAttrVal("Name_room"));
	}
	/**
	 * 诊室名称
	 * @param Name_room
	 */
	public void setName_room(String Name_room) {
		setAttrVal("Name_room", Name_room);
	}
	/**
	 * 号别id
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 号别id
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}
	/**
	 * 号别编码
	 * @param Code_scsrv
	 */
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
	}
	/**
	 * 号别名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 号别名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 号别简称
	 * @return String
	 */
	public String getShortname_srv() {
		return ((String) getAttrVal("Shortname_srv"));
	}
	/**
	 * 号别简称
	 * @param Shortname_srv
	 */
	public void setShortname_srv(String Shortname_srv) {
		setAttrVal("Shortname_srv", Shortname_srv);
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
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 票号
	 * @return Integer
	 */
	public Integer getTickno() {
		return ((Integer) getAttrVal("Tickno"));
	}
	/**
	 * 票号
	 * @param Tickno
	 */
	public void setTickno(Integer Tickno) {
		setAttrVal("Tickno", Tickno);
	}
	/**
	 * 分诊台id
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}
	/**
	 * 分诊台id
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
	/**
	 * 分诊台屏幕地址
	 * @return String
	 */
	public String getAddr_board_ben() {
		return ((String) getAttrVal("Addr_board_ben"));
	}
	/**
	 * 分诊台屏幕地址
	 * @param Addr_board_ben
	 */
	public void setAddr_board_ben(String Addr_board_ben) {
		setAttrVal("Addr_board_ben", Addr_board_ben);
	}
	/**
	 * 站点屏幕地址
	 * @return String
	 */
	public String getAddr_board_site() {
		return ((String) getAttrVal("Addr_board_site"));
	}
	/**
	 * 站点屏幕地址
	 * @param Addr_board_site
	 */
	public void setAddr_board_site(String Addr_board_site) {
		setAttrVal("Addr_board_site", Addr_board_site);
	}
	/**
	 * 候诊人数
	 * @return Integer
	 */
	public Integer getWaitnum() {
		return ((Integer) getAttrVal("Waitnum"));
	}
	/**
	 * 候诊人数
	 * @param Waitnum
	 */
	public void setWaitnum(Integer Waitnum) {
		setAttrVal("Waitnum", Waitnum);
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
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_op() {
		return ((Integer) getAttrVal("Times_op"));
	}
	/**
	 * 就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(Integer Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 诊室序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 诊室序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 优先标志
	 * @return String
	 */
	public String getLevel_pri() {
		return ((String) getAttrVal("Level_pri"));
	}
	/**
	 * 优先标志
	 * @param Level_pri
	 */
	public void setLevel_pri(String Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 挂号分类
	 * @return String
	 */
	public String getRegtp() {
		return ((String) getAttrVal("Regtp"));
	}
	/**
	 * 挂号分类
	 * @param Regtp
	 */
	public void setRegtp(String Regtp) {
		setAttrVal("Regtp", Regtp);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
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
	 * 滚动字幕
	 * @return String
	 */
	public String getScroll_text() {
		return ((String) getAttrVal("Scroll_text"));
	}
	/**
	 * 滚动字幕
	 * @param Scroll_text
	 */
	public void setScroll_text(String Scroll_text) {
		setAttrVal("Scroll_text", Scroll_text);
	}
	/**
	 * 当前接诊患者序号
	 * @return Integer
	 */
	public Integer getCur_acpt_sortno() {
		return ((Integer) getAttrVal("Cur_acpt_sortno"));
	}
	/**
	 * 当前接诊患者序号
	 * @param Cur_acpt_sortno
	 */
	public void setCur_acpt_sortno(Integer Cur_acpt_sortno) {
		setAttrVal("Cur_acpt_sortno", Cur_acpt_sortno);
	}
	/**
	 * 当前接诊患者chis编码
	 * @return String
	 */
	public String getCur_barcode_chis() {
		return ((String) getAttrVal("Cur_barcode_chis"));
	}
	/**
	 * 当前接诊患者chis编码
	 * @param Cur_barcode_chis
	 */
	public void setCur_barcode_chis(String Cur_barcode_chis) {
		setAttrVal("Cur_barcode_chis", Cur_barcode_chis);
	}
	/**
	 * 当前接诊患者
	 * @return String
	 */
	public String getCur_name_pat() {
		return ((String) getAttrVal("Cur_name_pat"));
	}
	/**
	 * 当前接诊患者
	 * @param Cur_name_pat
	 */
	public void setCur_name_pat(String Cur_name_pat) {
		setAttrVal("Cur_name_pat", Cur_name_pat);
	}
	/**
	 * 当前接诊患者号别
	 * @return String
	 */
	public String getCur_sd_srvtp() {
		return ((String) getAttrVal("Cur_sd_srvtp"));
	}
	/**
	 * 当前接诊患者号别
	 * @param Cur_sd_srvtp
	 */
	public void setCur_sd_srvtp(String Cur_sd_srvtp) {
		setAttrVal("Cur_sd_srvtp", Cur_sd_srvtp);
	}
	/**
	 * 患者状态
	 * @return String
	 */
	public String getPat_status() {
		return ((String) getAttrVal("Pat_status"));
	}
	/**
	 * 患者状态
	 * @param Pat_status
	 */
	public void setPat_status(String Pat_status) {
		setAttrVal("Pat_status", Pat_status);
	}
	/**
	 * 候诊号
	 * @return String
	 */
	public String getWait_queno() {
		return ((String) getAttrVal("Wait_queno"));
	}
	/**
	 * 候诊号
	 * @param Wait_queno
	 */
	public void setWait_queno(String Wait_queno) {
		setAttrVal("Wait_queno", Wait_queno);
	}
	/**
	 * 候诊号集合
	 * @return String
	 */
	public String getWait_quenos() {
		return ((String) getAttrVal("Wait_quenos"));
	}
	/**
	 * 候诊号集合
	 * @param Wait_quenos
	 */
	public void setWait_quenos(String Wait_quenos) {
		setAttrVal("Wait_quenos", Wait_quenos);
	}
	/**
	 * 站点状态
	 * @return String
	 */
	public String getSite_status() {
		return ((String) getAttrVal("Site_status"));
	}
	/**
	 * 站点状态
	 * @param Site_status
	 */
	public void setSite_status(String Site_status) {
		setAttrVal("Site_status", Site_status);
	}
	/**
	 * 候诊列表
	 * @return FArrayList
	 */
	public FArrayList getWait_list() {
		return ((FArrayList) getAttrVal("Wait_list"));
	}
	/**
	 * 候诊列表
	 * @param Wait_list
	 */
	public void setWait_list(FArrayList Wait_list) {
		setAttrVal("Wait_list", Wait_list);
	}
	/**
	 * 医生描述
	 * @return String
	 */
	public String getDoc_desc() {
		return ((String) getAttrVal("Doc_desc"));
	}
	/**
	 * 医生描述
	 * @param Doc_desc
	 */
	public void setDoc_desc(String Doc_desc) {
		setAttrVal("Doc_desc", Doc_desc);
	}
	/**
	 * 到诊患者
	 * @return String
	 */
	public String getNos_arrived() {
		return ((String) getAttrVal("Nos_arrived"));
	}
	/**
	 * 到诊患者
	 * @param Nos_arrived
	 */
	public void setNos_arrived(String Nos_arrived) {
		setAttrVal("Nos_arrived", Nos_arrived);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 挂号日期
	 * @return FDate
	 */
	public FDate getDt_regist() {
		return ((FDate) getAttrVal("Dt_regist"));
	}
	/**
	 * 挂号日期
	 * @param Dt_regist
	 */
	public void setDt_regist(FDate Dt_regist) {
		setAttrVal("Dt_regist", Dt_regist);
	}
}