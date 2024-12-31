package iih.en.pv.outpatient.dto.d;

import xap.mw.coreitf.d.FDate;

public class EntQueDTO {

	// 序号
	private Integer rowNumber;
	// 挂号顺序号
	private Integer regSeqNo;
	// 门诊就诊状态
	private String sd_status;
	// 门诊队列状态
	private String sd_status_acpt;
	// 出生日期
	private FDate dt_birth_pat;
	// 优先级
	private Integer level_pri;
	// 就诊站点
	private String id_que_site;
	// 患者编码
	private String pat_code;
	// 门诊就诊次数
	private Integer times_op;
	// 就诊编码
	private String ent_code;
	// 就诊房间
	private String room;
	//就诊id
	private String id_ent;
	//就诊队列id
	private String id_ent_que;
	//叫号顺序号
	private Integer sortno_called;
	
	public Integer getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getRegSeqNo() {
		return regSeqNo;
	}

	public void setRegSeqNo(Integer regSeqNo) {
		this.regSeqNo = regSeqNo;
	}

	public String getSd_status() {
		return sd_status;
	}

	public void setSd_status(String sd_status) {
		this.sd_status = sd_status;
	}

	public String getSd_status_acpt() {
		return sd_status_acpt;
	}

	public void setSd_status_acpt(String sd_status_acpt) {
		this.sd_status_acpt = sd_status_acpt;
	}

	public FDate getDt_birth_pat() {
		return dt_birth_pat;
	}

	public void setDt_birth_pat(FDate dt_birth_pat) {
		this.dt_birth_pat = dt_birth_pat;
	}

	public Integer getLevel_pri() {
		return level_pri;
	}

	public void setLevel_pri(Integer level_pri) {
		this.level_pri = level_pri;
	}

	public String getId_que_site() {
		return id_que_site;
	}

	public void setId_que_site(String id_que_site) {
		this.id_que_site = id_que_site;
	}

	public String getPat_code() {
		return pat_code;
	}

	public void setPat_code(String pat_code) {
		this.pat_code = pat_code;
	}

	public Integer getTimes_op() {
		return times_op;
	}

	public void setTimes_op(Integer times_op) {
		this.times_op = times_op;
	}

	public String getEnt_code() {
		return ent_code;
	}

	public void setEnt_code(String ent_code) {
		this.ent_code = ent_code;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getId_ent_que() {
		return id_ent_que;
	}

	public void setId_ent_que(String id_ent_que) {
		this.id_ent_que = id_ent_que;
	}
	
	public Integer getSortno_called() {
		return sortno_called;
	}

	public void setSortno_called(Integer sortno_called) {
		this.sortno_called = sortno_called;
	}

}
