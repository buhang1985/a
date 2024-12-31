package iih.pis.ivx.pmhyquery.d;

import xap.mw.coreitf.d.FDateTime;

public class GetOpPmhyQryDgPatListPara {
	
	private String id_itm; 
	private String id_mm; 
	private FDateTime dt_begin; 
	private FDateTime dt_end; 
	private String sd_srvtp;
	private String id_ent;
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public String getId_itm() {
		return id_itm;
	}
	public void setId_itm(String id_itm) {
		this.id_itm = id_itm;
	}
	public String getId_mm() {
		return id_mm;
	}
	public void setId_mm(String id_mm) {
		this.id_mm = id_mm;
	}
	public FDateTime getDt_begin() {
		return dt_begin;
	}
	public void setDt_begin(FDateTime dt_begin) {
		this.dt_begin = dt_begin;
	}
	public FDateTime getDt_end() {
		return dt_end;
	}
	public void setDt_end(FDateTime dt_end) {
		this.dt_end = dt_end;
	}
	public String getSd_srvtp() {
		return sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}
	
}
