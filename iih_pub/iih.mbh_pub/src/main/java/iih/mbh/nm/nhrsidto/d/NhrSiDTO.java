package iih.mbh.nm.nhrsidto.d;

import java.util.List;

public class NhrSiDTO {

	// 编码
	private String code;
	// 跨天数
	private int days_across;
	// 上班时间
	private String dt_beon;
	// 上班时间（扩展）
	private String dt_beon2;
	// 下班时间
	private String dt_off;
	// 下班时间（扩展）
	private String dt_off2;
	// 考勤时长
	private double dur_check;
	// 是否启用标记
	private boolean fg_active;
	// 是否分段
	private boolean fg_sect;
	// 字体颜色
	private int font_color;
	// 背景颜色
	private int fore_color;
	// 考勤分类id
	private String id_check_ca;
	// 所属科室id
	private String id_dep;
	// 班次信息ID
	private String id_nhr_si;
	// 所属类型id
	private String id_owntp;
	// 排班分类id
	private String id_sica;
	// 班次性质id
	private String id_sipro;
	// 备注
	private String memo;
	// 助记码
	private String mnecode;
	// 名称
	private String name;
	// 考勤分类名称
	private String name_check_ca;
	// 所属科室名称
	private String name_dep;
	// 所属类型名称
	private String name_owntp;
	// 简称
	private String name_short;
	// 排班分类名称
	private String name_sica;
	// 班次性质名称
	private String name_sipro;
	// 班次所管床位
	private List<NhrSiBedDTO> nhrsibeds;
	// 拼音码
	private String pycode;
	// 休息时长
	private double rest_dur;
	// 考勤分类编码
	private String sd_check_ca;
	// 所属类型编码
	private String sd_owntp;
	// 排班分类编码
	private String sd_sica;
	// 班次性质编码
	private String sd_sipro;
	// 序号
	private int sortno;
	// 数据状态状态
	private int status;
	// 五笔码
	private String wbcode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDays_across() {
		return days_across;
	}

	public void setDays_across(int days_across) {
		this.days_across = days_across;
	}

	public String getDt_beon() {
		return dt_beon;
	}

	public void setDt_beon(String dt_beon) {
		this.dt_beon = dt_beon;
	}

	public String getDt_beon2() {
		return dt_beon2;
	}

	public void setDt_beon2(String dt_beon2) {
		this.dt_beon2 = dt_beon2;
	}

	public String getDt_off() {
		return dt_off;
	}

	public void setDt_off(String dt_off) {
		this.dt_off = dt_off;
	}

	public String getDt_off2() {
		return dt_off2;
	}

	public void setDt_off2(String dt_off2) {
		this.dt_off2 = dt_off2;
	}

	public double getDur_check() {
		return dur_check;
	}

	public void setDur_check(double dur_check) {
		this.dur_check = dur_check;
	}

	public boolean getFg_active() {
		return fg_active;
	}

	public void setFg_active(boolean fg_active) {
		this.fg_active = fg_active;
	}

	public boolean getFg_sect() {
		return fg_sect;
	}

	public void setFg_sect(boolean fg_sect) {
		this.fg_sect = fg_sect;
	}

	public int getFont_color() {
		return font_color;
	}

	public void setFont_color(int font_color) {
		this.font_color = font_color;
	}

	public int getFore_color() {
		return fore_color;
	}

	public void setFore_color(int fore_color) {
		this.fore_color = fore_color;
	}

	public String getId_check_ca() {
		return id_check_ca;
	}

	public void setId_check_ca(String id_check_ca) {
		this.id_check_ca = id_check_ca;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_nhr_si() {
		return id_nhr_si;
	}

	public void setId_nhr_si(String id_nhr_si) {
		this.id_nhr_si = id_nhr_si;
	}

	public String getId_owntp() {
		return id_owntp;
	}

	public void setId_owntp(String id_owntp) {
		this.id_owntp = id_owntp;
	}

	public String getId_sica() {
		return id_sica;
	}

	public void setId_sica(String id_sica) {
		this.id_sica = id_sica;
	}

	public String getId_sipro() {
		return id_sipro;
	}

	public void setId_sipro(String id_sipro) {
		this.id_sipro = id_sipro;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMnecode() {
		return mnecode;
	}

	public void setMnecode(String mnecode) {
		this.mnecode = mnecode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_check_ca() {
		return name_check_ca;
	}

	public void setName_check_ca(String name_check_ca) {
		this.name_check_ca = name_check_ca;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getName_owntp() {
		return name_owntp;
	}

	public void setName_owntp(String name_owntp) {
		this.name_owntp = name_owntp;
	}

	public String getName_short() {
		return name_short;
	}

	public void setName_short(String name_short) {
		this.name_short = name_short;
	}

	public String getName_sica() {
		return name_sica;
	}

	public void setName_sica(String name_sica) {
		this.name_sica = name_sica;
	}

	public String getName_sipro() {
		return name_sipro;
	}

	public void setName_sipro(String name_sipro) {
		this.name_sipro = name_sipro;
	}

	public List<NhrSiBedDTO> getNhrsibeds() {
		return nhrsibeds;
	}

	public void setNhrsibeds(List<NhrSiBedDTO> nhrsibeds) {
		this.nhrsibeds = nhrsibeds;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public double getRest_dur() {
		return rest_dur;
	}

	public void setRest_dur(double rest_dur) {
		this.rest_dur = rest_dur;
	}

	public String getSd_check_ca() {
		return sd_check_ca;
	}

	public void setSd_check_ca(String sd_check_ca) {
		this.sd_check_ca = sd_check_ca;
	}

	public String getSd_owntp() {
		return sd_owntp;
	}

	public void setSd_owntp(String sd_owntp) {
		this.sd_owntp = sd_owntp;
	}

	public String getSd_sica() {
		return sd_sica;
	}

	public void setSd_sica(String sd_sica) {
		this.sd_sica = sd_sica;
	}

	public String getSd_sipro() {
		return sd_sipro;
	}

	public void setSd_sipro(String sd_sipro) {
		this.sd_sipro = sd_sipro;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getWbcode() {
		return wbcode;
	}

	public void setWbcode(String wbcode) {
		this.wbcode = wbcode;
	}

}
