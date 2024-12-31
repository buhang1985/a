package iih.ci.ord.s.ems.utils.meta;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class TreatOrContentParam extends BaseOrContentParam {
	
	private static final long serialVersionUID = 1L;

	public TreatOrContentParam(String sd_srvtp, String name_srv,String note_or,String name_freq, String name_route, FBoolean fg_urgent,String id_or_old, FDouble quan_medu, String id_unit_medu,String id_srv) {
		this.setSd_srvtp(sd_srvtp);
		this.setName_srv(name_srv);
		this.setNote(note_or);
		this.setName_freq(name_freq);
		this.setId_or_old(id_or_old);
		this.setQuan_medu(quan_medu);
		this.setId_unit_medu(id_unit_medu);
		this.setId_srv(id_srv);
		
	}
	public TreatOrContentParam(String id_or_old,CiOrderDO ciOrderDO) {
		this.Id_or_old=id_or_old;
		this.ciOrderDO=ciOrderDO;
	}
	private CiOrderDO ciOrderDO;
	private String Name_srv;
	private String Name_freq;
	private String Id_or_old;
	private FDouble Quan_medu;
	private String Id_unit_medu;
	private String Id_srv;
	
	public String getId_srv() {
		return Id_srv;
	}
	public void setId_srv(String id_srv) {
		Id_srv = id_srv;
	}
	public FDouble getQuan_medu() {
		return Quan_medu;
	}
	public void setQuan_medu(FDouble quan_medu2) {
		Quan_medu = quan_medu2;
	}
	public String getId_unit_medu() {
		return Id_unit_medu;
	}
	public void setId_unit_medu(String id_unit_medu) {
		Id_unit_medu = id_unit_medu;
	}
	public String getId_or_old() {
		return Id_or_old;
	}
	public void setId_or_old(String id_or_old) {
		Id_or_old = id_or_old;
	}
	public String getName_freq() {
		return Name_freq;
	}
	public void setName_freq(String name_freq) {
		Name_freq = name_freq;
	}
	public String getName_srv() {
		return Name_srv;
	}
	public void setName_srv(String name_srv) {
		Name_srv = name_srv;
	}
	public CiOrderDO getCiOrderDO() {
		return ciOrderDO;
	}
	public void setCiOrderDO(CiOrderDO ciOrderDO) {
		this.ciOrderDO = ciOrderDO;
	}
	
}
