package iih.mbh.nm.nmstatis.d;

public class NmPsnStatisSiDTO {

	// 班次个数
	private int count_nhr_si;
	// 总工时
	private int hour_nhr_si;
	// 班次外键
	private String id_nhr_si;
	// 护理人员外键
	private String id_nur;
	// 班次
	private String name_nhr_si;
	// 护理人员
	private String name_nur;

	public int getCount_nhr_si() {
		return count_nhr_si;
	}

	public void setCount_nhr_si(int count_nhr_si) {
		this.count_nhr_si = count_nhr_si;
	}

	public int getHour_nhr_si() {
		return hour_nhr_si;
	}

	public void setHour_nhr_si(int hour_nhr_si) {
		this.hour_nhr_si = hour_nhr_si;
	}

	public String getId_nhr_si() {
		return id_nhr_si;
	}

	public void setId_nhr_si(String id_nhr_si) {
		this.id_nhr_si = id_nhr_si;
	}

	public String getId_nur() {
		return id_nur;
	}

	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
	}

	public String getName_nhr_si() {
		return name_nhr_si;
	}

	public void setName_nhr_si(String name_nhr_si) {
		this.name_nhr_si = name_nhr_si;
	}

	public String getName_nur() {
		return name_nur;
	}

	public void setName_nur(String name_nur) {
		this.name_nur = name_nur;
	}

}
