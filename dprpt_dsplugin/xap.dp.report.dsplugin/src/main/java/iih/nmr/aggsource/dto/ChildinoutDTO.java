package iih.nmr.aggsource.dto;

public class ChildinoutDTO {
	/*
	 * 儿童医院护理记录单出入液量总结dto
	 */
	public String id_ent;
	public String name_iotype;
	public String dt_begin;
	public String dt_end;
	public String num_in;
	public String num_out;
	public String name_nur;
	public String note;
	public String dt_create;
	public String id_nur;
	public byte[] pic;
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public String getName_iotype() {
		return name_iotype;
	}
	public void setName_iotype(String name_iotype) {
		this.name_iotype = name_iotype;
	}
	public String getDt_begin() {
		return dt_begin;
	}
	public void setDt_begin(String dt_begin) {
		this.dt_begin = dt_begin;
	}
	public String getDt_end() {
		return dt_end;
	}
	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}
	public String getNum_in() {
		return num_in;
	}
	public void setNum_in(String num_in) {
		this.num_in = num_in;
	}
	public String getNum_out() {
		return num_out;
	}
	public void setNum_out(String num_out) {
		this.num_out = num_out;
	}
	public String getName_nur() {
		return name_nur;
	}
	public void setName_nur(String name_nur) {
		this.name_nur = name_nur;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDt_create() {
		return dt_create;
	}
	public void setDt_create(String dt_create) {
		this.dt_create = dt_create;
	}
	public String getId_nur() {
		return id_nur;
	}
	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}

}
