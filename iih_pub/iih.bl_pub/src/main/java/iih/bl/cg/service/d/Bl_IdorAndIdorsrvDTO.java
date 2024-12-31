package iih.bl.cg.service.d;

import java.util.List;

import xap.mw.core.data.BaseDTO;

public class Bl_IdorAndIdorsrvDTO  extends BaseDTO {
	private static final long serialVersionUID = 1L;
	/**
	 * id_or
	 * @return
	 */
	public List<String> getId_or() {
		return ((List<String>) getAttrVal("Id_or"));
	}
	public void setId_or(List<String> Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * id_orsrv
	 * @return
	 */
	public List<String> getId_orsrv() {
		return ((List<String>) getAttrVal("Id_orsrv"));
	}
	public void setId_orsrv(List<String> Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
}
