package iih.pis.mbw.dto.pismbwwaitquedto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwWaitqueDTO {

	// 挂号顺序号
	@RPCField(id = 1)
	private String code_ticket;
	// 就诊状态
	@RPCField(id = 10)
	private String code_entstatus;
	// 顺序号
	@RPCField(id = 11)
	private String row_number;
	// 就诊队列状态
	@RPCField(id = 12)
	private String code_questatus;
	// 就诊站点
	@RPCField(id = 13)
	private String id_que_site;
	// 出生日期
	@RPCField(id = 14)
	private String dt_birth_pat;
	// 优先级
	@RPCField(id = 15)
	private int level_pri;
	// 回诊标志
	@RPCField(id = 16)
	private String fg_rtn;
	// 候诊标志
	@RPCField(id = 17)
	private String fg_wait;
	// 患者编码
	@RPCField(id = 2)
	private String code_pat;
	// 患者名称
	@RPCField(id = 3)
	private String name_pat;
	// 就诊次数
	@RPCField(id = 4)
	private int times_op;
	// 就诊id
	@RPCField(id = 5)
	private String in_ent;
	// 就诊编码
	@RPCField(id = 6)
	private String code_ent;
	// 诊室
	@RPCField(id = 7)
	private String room_ent;
	// 就诊队列id
	@RPCField(id = 8)
	private String id_ent_que;
	// 叫好顺序号
	@RPCField(id = 9)
	private int sortno_called;

	public String getCode_ticket() {
		return code_ticket;
	}

	public void setCode_ticket(String code_ticket) {
		this.code_ticket = code_ticket;
	}

	public String getCode_entstatus() {
		return code_entstatus;
	}

	public void setCode_entstatus(String code_entstatus) {
		this.code_entstatus = code_entstatus;
	}

	public String getRow_number() {
		return row_number;
	}

	public void setRow_number(String row_number) {
		this.row_number = row_number;
	}

	public String getCode_questatus() {
		return code_questatus;
	}

	public void setCode_questatus(String code_questatus) {
		this.code_questatus = code_questatus;
	}

	public String getId_que_site() {
		return id_que_site;
	}

	public void setId_que_site(String id_que_site) {
		this.id_que_site = id_que_site;
	}

	public String getDt_birth_pat() {
		return dt_birth_pat;
	}

	public void setDt_birth_pat(String dt_birth_pat) {
		this.dt_birth_pat = dt_birth_pat;
	}

	public int getLevel_pri() {
		return level_pri;
	}

	public void setLevel_pri(int level_pri) {
		this.level_pri = level_pri;
	}

	public String getFg_rtn() {
		return fg_rtn;
	}

	public void setFg_rtn(String fg_rtn) {
		this.fg_rtn = fg_rtn;
	}

	public String getFg_wait() {
		return fg_wait;
	}

	public void setFg_wait(String fg_wait) {
		this.fg_wait = fg_wait;
	}

	public String getCode_pat() {
		return code_pat;
	}

	public void setCode_pat(String code_pat) {
		this.code_pat = code_pat;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public int getTimes_op() {
		return times_op;
	}

	public void setTimes_op(int times_op) {
		this.times_op = times_op;
	}

	public String getIn_ent() {
		return in_ent;
	}

	public void setIn_ent(String in_ent) {
		this.in_ent = in_ent;
	}

	public String getCode_ent() {
		return code_ent;
	}

	public void setCode_ent(String code_ent) {
		this.code_ent = code_ent;
	}

	public String getRoom_ent() {
		return room_ent;
	}

	public void setRoom_ent(String room_ent) {
		this.room_ent = room_ent;
	}

	public String getId_ent_que() {
		return id_ent_que;
	}

	public void setId_ent_que(String id_ent_que) {
		this.id_ent_que = id_ent_que;
	}

	public int getSortno_called() {
		return sortno_called;
	}

	public void setSortno_called(int sortno_called) {
		this.sortno_called = sortno_called;
	}

}
