package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技预约查询DTO DTO数据 
 * 
 */
public class MtAppQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 当前科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 当前科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 当前科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 是否门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}
	/**
	 * 是否门诊
	 * @param Fg_op
	 */
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	/**
	 * 是否急诊
	 * @return FBoolean
	 */
	public FBoolean getFg_et() {
		return ((FBoolean) getAttrVal("Fg_et"));
	}
	/**
	 * 是否急诊
	 * @param Fg_et
	 */
	public void setFg_et(FBoolean Fg_et) {
		setAttrVal("Fg_et", Fg_et);
	}
	/**
	 * 是否住院
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 是否住院
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 是否留观
	 * @return FBoolean
	 */
	public FBoolean getFg_es() {
		return ((FBoolean) getAttrVal("Fg_es"));
	}
	/**
	 * 是否留观
	 * @param Fg_es
	 */
	public void setFg_es(FBoolean Fg_es) {
		setAttrVal("Fg_es", Fg_es);
	}
	/**
	 * 是否急诊流水
	 * @return FBoolean
	 */
	public FBoolean getFg_et_flow() {
		return ((FBoolean) getAttrVal("Fg_et_flow"));
	}
	/**
	 * 是否急诊流水
	 * @param Fg_et_flow
	 */
	public void setFg_et_flow(FBoolean Fg_et_flow) {
		setAttrVal("Fg_et_flow", Fg_et_flow);
	}
	/**
	 * 是否急诊抢救
	 * @return FBoolean
	 */
	public FBoolean getFg_et_fstaid() {
		return ((FBoolean) getAttrVal("Fg_et_fstaid"));
	}
	/**
	 * 是否急诊抢救
	 * @param Fg_et_fstaid
	 */
	public void setFg_et_fstaid(FBoolean Fg_et_fstaid) {
		setAttrVal("Fg_et_fstaid", Fg_et_fstaid);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getD_begin() {
		return ((FDate) getAttrVal("D_begin"));
	}
	/**
	 * 开始日期
	 * @param D_begin
	 */
	public void setD_begin(FDate D_begin) {
		setAttrVal("D_begin", D_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getD_end() {
		return ((FDate) getAttrVal("D_end"));
	}
	/**
	 * 结束日期
	 * @param D_end
	 */
	public void setD_end(FDate D_end) {
		setAttrVal("D_end", D_end);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 是否自动过滤
	 * @return FBoolean
	 */
	public FBoolean getFg_autofilter() {
		return ((FBoolean) getAttrVal("Fg_autofilter"));
	}
	/**
	 * 是否自动过滤
	 * @param Fg_autofilter
	 */
	public void setFg_autofilter(FBoolean Fg_autofilter) {
		setAttrVal("Fg_autofilter", Fg_autofilter);
	}
	/**
	 * 过滤项目id
	 * @return String
	 */
	public String getId_srv_filter() {
		return ((String) getAttrVal("Id_srv_filter"));
	}
	/**
	 * 过滤项目id
	 * @param Id_srv_filter
	 */
	public void setId_srv_filter(String Id_srv_filter) {
		setAttrVal("Id_srv_filter", Id_srv_filter);
	}
	/**
	 * 过滤项目名称
	 * @return String
	 */
	public String getName_srv_filter() {
		return ((String) getAttrVal("Name_srv_filter"));
	}
	/**
	 * 过滤项目名称
	 * @param Name_srv_filter
	 */
	public void setName_srv_filter(String Name_srv_filter) {
		setAttrVal("Name_srv_filter", Name_srv_filter);
	}
	/**
	 * 过滤科室id
	 * @return String
	 */
	public String getId_dep_filter() {
		return ((String) getAttrVal("Id_dep_filter"));
	}
	/**
	 * 过滤科室id
	 * @param Id_dep_filter
	 */
	public void setId_dep_filter(String Id_dep_filter) {
		setAttrVal("Id_dep_filter", Id_dep_filter);
	}
	/**
	 * 过滤科室名称
	 * @return String
	 */
	public String getName_dep_filter() {
		return ((String) getAttrVal("Name_dep_filter"));
	}
	/**
	 * 过滤科室名称
	 * @param Name_dep_filter
	 */
	public void setName_dep_filter(String Name_dep_filter) {
		setAttrVal("Name_dep_filter", Name_dep_filter);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 是否已预约
	 * @return FBoolean
	 */
	public FBoolean getFg_apted() {
		return ((FBoolean) getAttrVal("Fg_apted"));
	}
	/**
	 * 是否已预约
	 * @param Fg_apted
	 */
	public void setFg_apted(FBoolean Fg_apted) {
		setAttrVal("Fg_apted", Fg_apted);
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
	 * 查询类型
	 * @return Integer
	 */
	public Integer getQrytype() {
		return ((Integer) getAttrVal("Qrytype"));
	}
	/**
	 * 查询类型
	 * @param Qrytype
	 */
	public void setQrytype(Integer Qrytype) {
		setAttrVal("Qrytype", Qrytype);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getAppno() {
		return ((String) getAttrVal("Appno"));
	}
	/**
	 * 申请单号
	 * @param Appno
	 */
	public void setAppno(String Appno) {
		setAttrVal("Appno", Appno);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 排班分类名称
	 * @return String
	 */
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}
	/**
	 * 排班分类名称
	 * @param Name_scca
	 */
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 患者选择标识
	 * @return FBoolean
	 */
	public FBoolean getFg_manu_tak() {
		return ((FBoolean) getAttrVal("Fg_manu_tak"));
	}
	/**
	 * 患者选择标识
	 * @param Fg_manu_tak
	 */
	public void setFg_manu_tak(FBoolean Fg_manu_tak) {
		setAttrVal("Fg_manu_tak", Fg_manu_tak);
	}
	/**
	 * 渠道編碼
	 * @return String
	 */
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}
	/**
	 * 渠道編碼
	 * @param Code_scchl
	 */
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
	/**
	 * 医嘱生效时间
	 * @return String
	 */
	public String getDt_effe_or() {
		return ((String) getAttrVal("Dt_effe_or"));
	}
	/**
	 * 医嘱生效时间
	 * @param Dt_effe_or
	 */
	public void setDt_effe_or(String Dt_effe_or) {
		setAttrVal("Dt_effe_or", Dt_effe_or);
	}
	/**
	 * 预约备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 预约备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 是否过滤就诊类型
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_filter() {
		return ((FBoolean) getAttrVal("Fg_entp_filter"));
	}
	/**
	 * 是否过滤就诊类型
	 * @param Fg_entp_filter
	 */
	public void setFg_entp_filter(FBoolean Fg_entp_filter) {
		setAttrVal("Fg_entp_filter", Fg_entp_filter);
	}
	/**
	 * 自动确认
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_cfm() {
		return ((FBoolean) getAttrVal("Fg_auto_cfm"));
	}
	/**
	 * 自动确认
	 * @param Fg_auto_cfm
	 */
	public void setFg_auto_cfm(FBoolean Fg_auto_cfm) {
		setAttrVal("Fg_auto_cfm", Fg_auto_cfm);
	}
	/**
	 * 是否定位到可预约日期
	 * @return FBoolean
	 */
	public FBoolean getFg_locate_apt() {
		return ((FBoolean) getAttrVal("Fg_locate_apt"));
	}
	/**
	 * 是否定位到可预约日期
	 * @param Fg_locate_apt
	 */
	public void setFg_locate_apt(FBoolean Fg_locate_apt) {
		setAttrVal("Fg_locate_apt", Fg_locate_apt);
	}
	/**
	 * 是否查询已预约申请单
	 * @return FBoolean
	 */
	public FBoolean getFg_qry_apted() {
		return ((FBoolean) getAttrVal("Fg_qry_apted"));
	}
	/**
	 * 是否查询已预约申请单
	 * @param Fg_qry_apted
	 */
	public void setFg_qry_apted(FBoolean Fg_qry_apted) {
		setAttrVal("Fg_qry_apted", Fg_qry_apted);
	}
}