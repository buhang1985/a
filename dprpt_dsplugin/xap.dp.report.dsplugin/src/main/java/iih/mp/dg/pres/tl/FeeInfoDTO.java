package iih.mp.dg.pres.tl;

import xap.mw.coreitf.d.FDouble;

public class FeeInfoDTO {

	private String Id_orsrv;
	private FDouble Amt;
	
	public String getId_orsrv() {
		return Id_orsrv;
	}
	public void setId_orsrv(String id_orsrv) {
		Id_orsrv = id_orsrv;
	}
	public FDouble getAmt() {
		return Amt;
	}
	public void setAmt(FDouble amt) {
		Amt = amt;
	}
	
}
