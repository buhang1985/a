package iih.pe.papt.dto.pepanapptdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeappttladderDTO {

	// 体检预约梯次主键标识
	@RPCField(id = 1)
	private String id_peappttladder;
	// 编码
	@RPCField(id = 2)
	private String code;
	// 名称
	@RPCField(id = 3)
	private String name;
	// 开始时间
	@RPCField(id = 4)
	private String time_begin;
	// 结束时间
	@RPCField(id = 5)
	private String time_end;
	// 次序
	@RPCField(id = 6)
	private int sortno;
	// 启用标识
	@RPCField(id = 7)
	private boolean fg_active;
	// 说明
	@RPCField(id = 8)
	private String des;
	// 开放人数
	@RPCField(id = 9)
	private int psnlimit;

	public String getId_peappttladder() {
		return id_peappttladder;
	}

	public void setId_peappttladder(String id_peappttladder) {
		this.id_peappttladder = id_peappttladder;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(String time_begin) {
		this.time_begin = time_begin;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
	}

	public boolean getFg_active() {
		return fg_active;
	}

	public void setFg_active(boolean fg_active) {
		this.fg_active = fg_active;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public int getPsnlimit() {
		return psnlimit;
	}

	public void setPsnlimit(int psnlimit) {
		this.psnlimit = psnlimit;
	}

}
