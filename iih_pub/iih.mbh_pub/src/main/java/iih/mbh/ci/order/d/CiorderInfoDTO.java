package iih.mbh.ci.order.d;

import iih.mbh.ci.order.d.CirptObsDTO;
import iih.mbh.ci.order.d.CirptLabDTO;

/**
 * 医嘱信息
 * 
 */
public class CiorderInfoDTO {

	/** 医嘱ID */
	private String id_or;
	/** 开始时间 */
	private String dt_effe;
	/** 医嘱状态编码 */
	private String code_state;
	/** 医嘱内容 */
	private String content_or;
	/** 开立医生主键 */
	private String id_emp_or;
	/** 开立医生姓名 */
	private String name_emp_or;
	/** 签署医生ID */
	private String id_emp_sign;
	/** 签署医生姓名 */
	private String name_emp_sign;
	/** 停止医生ID */
	private String id_emp_stop;
	/** 停止医生姓名 */
	private String name_emp_stop;
	/** 执行状态 */
	private String sd_su_mp;
	/** 医嘱初始状态 */
	private String sd_su_or;
	/** 就诊类型 */
	private String code_entp;
	/** 停止标志 */
	private Boolean fg_stop;
	/** 长临标志 */
	private Boolean fg_long;
	/** 检查数据 */
	private CirptObsDTO obsdto;
	/** 检验数据 */
	private CirptLabDTO labdto;
	/** 医嘱状态名称 */
	private String name_state;
	/** 停止时间 */
	private String dt_end;
	/** 停止核对护士姓名 */
	private String name_emp_chk_stop;
	/** 停止核对护士 */
	private String id_emp_chk_stop;
	/**医嘱图标状态编码*/
	private String code_state_icon;
	/**医嘱图标状态名称*/
	private String name_state_icon;
	/**医嘱编码*/
	private String code_or;

	/** getter and setter */

	public String getId_or() {
		return this.id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getDt_effe() {
		return this.dt_effe;
	}

	public void setDt_effe(String dt_effe) {
		this.dt_effe = dt_effe;
	}

	public String getCode_state() {
		return this.code_state;
	}

	public void setCode_state(String code_state) {
		this.code_state = code_state;
	}

	public String getContent_or() {
		return this.content_or;
	}

	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}

	public String getId_emp_or() {
		return this.id_emp_or;
	}

	public void setId_emp_or(String id_emp_or) {
		this.id_emp_or = id_emp_or;
	}

	public String getName_emp_or() {
		return this.name_emp_or;
	}

	public void setName_emp_or(String name_emp_or) {
		this.name_emp_or = name_emp_or;
	}

	public String getId_emp_sign() {
		return this.id_emp_sign;
	}

	public void setId_emp_sign(String id_emp_sign) {
		this.id_emp_sign = id_emp_sign;
	}

	public String getName_emp_sign() {
		return this.name_emp_sign;
	}

	public void setName_emp_sign(String name_emp_sign) {
		this.name_emp_sign = name_emp_sign;
	}

	public String getId_emp_stop() {
		return this.id_emp_stop;
	}

	public void setId_emp_stop(String id_emp_stop) {
		this.id_emp_stop = id_emp_stop;
	}

	public String getName_emp_stop() {
		return this.name_emp_stop;
	}

	public void setName_emp_stop(String name_emp_stop) {
		this.name_emp_stop = name_emp_stop;
	}

	public String getSd_su_mp() {
		return this.sd_su_mp;
	}

	public void setSd_su_mp(String sd_su_mp) {
		this.sd_su_mp = sd_su_mp;
	}

	public String getSd_su_or() {
		return this.sd_su_or;
	}

	public void setSd_su_or(String sd_su_or) {
		this.sd_su_or = sd_su_or;
	}

	public String getCode_entp() {
		return this.code_entp;
	}

	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}

	public Boolean getFg_stop() {
		return this.fg_stop;
	}

	public void setFg_stop(Boolean fg_stop) {
		this.fg_stop = fg_stop;
	}

	public Boolean getFg_long() {
		return fg_long;
	}

	public void setFg_long(Boolean fg_long) {
		this.fg_long = fg_long;
	}

	public CirptObsDTO getObsdto() {
		return this.obsdto;
	}

	public void setObsdto(CirptObsDTO obsdto) {
		this.obsdto = obsdto;
	}

	public CirptLabDTO getLabdto() {
		return this.labdto;
	}

	public void setLabdto(CirptLabDTO labdto) {
		this.labdto = labdto;
	}

	public String getName_state() {
		return this.name_state;
	}

	public void setName_state(String name_state) {
		this.name_state = name_state;
	}

	public String getDt_end() {
		return this.dt_end;
	}

	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}

	public String getName_emp_chk_stop() {
		return this.name_emp_chk_stop;
	}

	public void setName_emp_chk_stop(String name_emp_chk_stop) {
		this.name_emp_chk_stop = name_emp_chk_stop;
	}

	public String getId_emp_chk_stop() {
		return this.id_emp_chk_stop;
	}

	public void setId_emp_chk_stop(String id_emp_chk_stop) {
		this.id_emp_chk_stop = id_emp_chk_stop;
	}

	public String getCode_state_icon() {
		return code_state_icon;
	}

	public void setCode_state_icon(String code_state_icon) {
		this.code_state_icon = code_state_icon;
	}

	public String getName_state_icon() {
		return name_state_icon;
	}

	public void setName_state_icon(String name_state_icon) {
		this.name_state_icon = name_state_icon;
	}

	public String getCode_or() {
		return code_or;
	}

	public void setCode_or(String code_or) {
		this.code_or = code_or;
	}
	
}