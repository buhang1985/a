package iih.mbh.nm.nmstatis.d;

import java.util.List;

public class NmPsnStatisDTO {

	// 开始日期
	private String dt_begin;
	// 结束日期
	private String dt_end;
	// 护理单元外键
	private String id_dep_nur;
	// 护理人员外键
	private String id_nur;
	// 人员外键
	private String id_psndoc;
	// 工时总数
	private int labor_hour;
	// 护理单元
	private String name_dep_nur;
	// 护理人员
	private String name_nur;
	// 加班工时
	private int over_wkhour;
	// 人员班次列表
	private List<NmPsnStatisSiDTO> psnsilist;
	// 累计存欠
	private int saveowe_hour;

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

	public String getId_dep_nur() {
		return id_dep_nur;
	}

	public void setId_dep_nur(String id_dep_nur) {
		this.id_dep_nur = id_dep_nur;
	}

	public String getId_nur() {
		return id_nur;
	}

	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
	}

	public String getId_psndoc() {
		return id_psndoc;
	}

	public void setId_psndoc(String id_psndoc) {
		this.id_psndoc = id_psndoc;
	}

	public int getLabor_hour() {
		return labor_hour;
	}

	public void setLabor_hour(int labor_hour) {
		this.labor_hour = labor_hour;
	}

	public String getName_dep_nur() {
		return name_dep_nur;
	}

	public void setName_dep_nur(String name_dep_nur) {
		this.name_dep_nur = name_dep_nur;
	}

	public String getName_nur() {
		return name_nur;
	}

	public void setName_nur(String name_nur) {
		this.name_nur = name_nur;
	}

	public int getOver_wkhour() {
		return over_wkhour;
	}

	public void setOver_wkhour(int over_wkhour) {
		this.over_wkhour = over_wkhour;
	}

	public List<NmPsnStatisSiDTO> getPsnsilist() {
		return psnsilist;
	}

	public void setPsnsilist(List<NmPsnStatisSiDTO> psnsilist) {
		this.psnsilist = psnsilist;
	}

	public int getSaveowe_hour() {
		return saveowe_hour;
	}

	public void setSaveowe_hour(int saveowe_hour) {
		this.saveowe_hour = saveowe_hour;
	}

}
