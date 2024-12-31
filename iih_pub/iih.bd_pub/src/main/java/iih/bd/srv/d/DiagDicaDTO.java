package iih.bd.srv.d;

import xap.mw.core.data.BaseDTO;

public class DiagDicaDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	public static String ID_DICA = "Id_dica";
	public static String NAME = "Name";
	public static String ACTIVE = "Active";
	
	public static String getID_DICA() {
		return ID_DICA;
	}
	public static void setID_DICA(String iD_DICA) {
		ID_DICA = iD_DICA;
	}
	public static String getNAME() {
		return NAME;
	}
	public static void setNAME(String nAME) {
		NAME = nAME;
	}
	public static String getACTIVE() {
		return ACTIVE;
	}
	public static void setACTIVE(String aCTIVE) {
		ACTIVE = aCTIVE;
	}
	
	
	
}
