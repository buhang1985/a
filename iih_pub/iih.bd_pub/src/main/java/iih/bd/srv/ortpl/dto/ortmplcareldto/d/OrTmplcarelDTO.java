package iih.bd.srv.ortpl.dto.ortmplcareldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱模板DTO DTO数据 
 * 
 */
public class OrTmplcarelDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱模板主键标识
	 * @return String
	 */
	public String getId_ortmpl() {
		return ((String) getAttrVal("Id_ortmpl"));
	}
	/**
	 * 医嘱模板主键标识
	 * @param Id_ortmpl
	 */
	public void setId_ortmpl(String Id_ortmpl) {
		setAttrVal("Id_ortmpl", Id_ortmpl);
	}
	/**
	 * 模板编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 模板编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 编码名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 编码名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 五笔
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 医嘱模板与分类关系主键标识
	 * @return String
	 */
	public String getId_ortmplcarel() {
		return ((String) getAttrVal("Id_ortmplcarel"));
	}
	/**
	 * 医嘱模板与分类关系主键标识
	 * @param Id_ortmplcarel
	 */
	public void setId_ortmplcarel(String Id_ortmplcarel) {
		setAttrVal("Id_ortmplcarel", Id_ortmplcarel);
	}
	/**
	 * 医嘱模板分类
	 * @return String
	 */
	public String getId_ortmplca() {
		return ((String) getAttrVal("Id_ortmplca"));
	}
	/**
	 * 医嘱模板分类
	 * @param Id_ortmplca
	 */
	public void setId_ortmplca(String Id_ortmplca) {
		setAttrVal("Id_ortmplca", Id_ortmplca);
	}
	/**
	 * 医嘱模板分类编码
	 * @return String
	 */
	public String getSd_ortmplca() {
		return ((String) getAttrVal("Sd_ortmplca"));
	}
	/**
	 * 医嘱模板分类编码
	 * @param Sd_ortmplca
	 */
	public void setSd_ortmplca(String Sd_ortmplca) {
		setAttrVal("Sd_ortmplca", Sd_ortmplca);
	}
	/**
	 * 医嘱模板分类名称
	 * @return String
	 */
	public String getName_ortmplca() {
		return ((String) getAttrVal("Name_ortmplca"));
	}
	/**
	 * 医嘱模板分类名称
	 * @param Name_ortmplca
	 */
	public void setName_ortmplca(String Name_ortmplca) {
		setAttrVal("Name_ortmplca", Name_ortmplca);
	}
	/**
	 * 分类引用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sync_carel() {
		return ((FBoolean) getAttrVal("Fg_sync_carel"));
	}
	/**
	 * 分类引用标识
	 * @param Fg_sync_carel
	 */
	public void setFg_sync_carel(FBoolean Fg_sync_carel) {
		setAttrVal("Fg_sync_carel", Fg_sync_carel);
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
	 * 医嘱模板类型
	 * @return String
	 */
	public String getId_ortmpltp() {
		return ((String) getAttrVal("Id_ortmpltp"));
	}
	/**
	 * 医嘱模板类型
	 * @param Id_ortmpltp
	 */
	public void setId_ortmpltp(String Id_ortmpltp) {
		setAttrVal("Id_ortmpltp", Id_ortmpltp);
	}
	/**
	 * 医嘱模板类型编码
	 * @return String
	 */
	public String getSd_ortmpltp() {
		return ((String) getAttrVal("Sd_ortmpltp"));
	}
	/**
	 * 医嘱模板类型编码
	 * @param Sd_ortmpltp
	 */
	public void setSd_ortmpltp(String Sd_ortmpltp) {
		setAttrVal("Sd_ortmpltp", Sd_ortmpltp);
	}
	/**
	 * 医嘱模板类型名称
	 * @return String
	 */
	public String getName_ortmpltp() {
		return ((String) getAttrVal("Name_ortmpltp"));
	}
	/**
	 * 医嘱模板类型名称
	 * @param Name_ortmpltp
	 */
	public void setName_ortmpltp(String Name_ortmpltp) {
		setAttrVal("Name_ortmpltp", Name_ortmpltp);
	}
	/**
	 * 模板描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 模板描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 协定标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cipher() {
		return ((FBoolean) getAttrVal("Fg_cipher"));
	}
	/**
	 * 协定标识
	 * @param Fg_cipher
	 */
	public void setFg_cipher(FBoolean Fg_cipher) {
		setAttrVal("Fg_cipher", Fg_cipher);
	}
	/**
	 * 模板适用范围
	 * @return String
	 */
	public String getId_srvorrt() {
		return ((String) getAttrVal("Id_srvorrt"));
	}
	/**
	 * 模板适用范围
	 * @param Id_srvorrt
	 */
	public void setId_srvorrt(String Id_srvorrt) {
		setAttrVal("Id_srvorrt", Id_srvorrt);
	}
	/**
	 * 模板适用范围编码
	 * @return String
	 */
	public String getSd_srvorrt() {
		return ((String) getAttrVal("Sd_srvorrt"));
	}
	/**
	 * 模板适用范围编码
	 * @param Sd_srvorrt
	 */
	public void setSd_srvorrt(String Sd_srvorrt) {
		setAttrVal("Sd_srvorrt", Sd_srvorrt);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 个人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 个人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 可使用标识_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_op() {
		return ((FBoolean) getAttrVal("Fg_entp_op"));
	}
	/**
	 * 可使用标识_门诊
	 * @param Fg_entp_op
	 */
	public void setFg_entp_op(FBoolean Fg_entp_op) {
		setAttrVal("Fg_entp_op", Fg_entp_op);
	}
	/**
	 * 可使用标识_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}
	/**
	 * 可使用标识_住院
	 * @param Fg_entp_ip
	 */
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	/**
	 * 可使用标识_急诊流水
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er() {
		return ((FBoolean) getAttrVal("Fg_entp_er"));
	}
	/**
	 * 可使用标识_急诊流水
	 * @param Fg_entp_er
	 */
	public void setFg_entp_er(FBoolean Fg_entp_er) {
		setAttrVal("Fg_entp_er", Fg_entp_er);
	}
	/**
	 * 可使用标识_急诊抢救
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er1() {
		return ((FBoolean) getAttrVal("Fg_entp_er1"));
	}
	/**
	 * 可使用标识_急诊抢救
	 * @param Fg_entp_er1
	 */
	public void setFg_entp_er1(FBoolean Fg_entp_er1) {
		setAttrVal("Fg_entp_er1", Fg_entp_er1);
	}
	/**
	 * 可使用标识_急诊留观
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er2() {
		return ((FBoolean) getAttrVal("Fg_entp_er2"));
	}
	/**
	 * 可使用标识_急诊留观
	 * @param Fg_entp_er2
	 */
	public void setFg_entp_er2(FBoolean Fg_entp_er2) {
		setAttrVal("Fg_entp_er2", Fg_entp_er2);
	}
	/**
	 * 可使用标识_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}
	/**
	 * 可使用标识_体检
	 * @param Fg_entp_pe
	 */
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	/**
	 * 可使用标识_家床
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}
	/**
	 * 可使用标识_家床
	 * @param Fg_entp_fm
	 */
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
	}
	/**
	 * 是否派生
	 * @return FBoolean
	 */
	public FBoolean getFg_sync() {
		return ((FBoolean) getAttrVal("Fg_sync"));
	}
	/**
	 * 是否派生
	 * @param Fg_sync
	 */
	public void setFg_sync(FBoolean Fg_sync) {
		setAttrVal("Fg_sync", Fg_sync);
	}
	/**
	 * 来源模板
	 * @return String
	 */
	public String getId_ortmpl_src() {
		return ((String) getAttrVal("Id_ortmpl_src"));
	}
	/**
	 * 来源模板
	 * @param Id_ortmpl_src
	 */
	public void setId_ortmpl_src(String Id_ortmpl_src) {
		setAttrVal("Id_ortmpl_src", Id_ortmpl_src);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 模板内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 模板内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 模板服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 模板服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 模板服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 模板服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 医嘱付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 频次周期类型
	 * @return String
	 */
	public String getId_frequnit() {
		return ((String) getAttrVal("Id_frequnit"));
	}
	/**
	 * 频次周期类型
	 * @param Id_frequnit
	 */
	public void setId_frequnit(String Id_frequnit) {
		setAttrVal("Id_frequnit", Id_frequnit);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnit() {
		return ((String) getAttrVal("Sd_frequnit"));
	}
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnit
	 */
	public void setSd_frequnit(String Sd_frequnit) {
		setAttrVal("Sd_frequnit", Sd_frequnit);
	}
	/**
	 * 模板序号
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}
	/**
	 * 模板序号
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 关联诊断主键
	 * @return String
	 */
	public String getId_didef_ref() {
		return ((String) getAttrVal("Id_didef_ref"));
	}
	/**
	 * 关联诊断主键
	 * @param Id_didef_ref
	 */
	public void setId_didef_ref(String Id_didef_ref) {
		setAttrVal("Id_didef_ref", Id_didef_ref);
	}
	/**
	 * 关联诊断名称
	 * @return String
	 */
	public String getName_didef_ref() {
		return ((String) getAttrVal("Name_didef_ref"));
	}
	/**
	 * 关联诊断名称
	 * @param Name_didef_ref
	 */
	public void setName_didef_ref(String Name_didef_ref) {
		setAttrVal("Name_didef_ref", Name_didef_ref);
	}
}