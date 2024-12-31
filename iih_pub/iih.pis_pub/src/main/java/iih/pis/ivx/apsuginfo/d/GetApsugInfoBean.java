package iih.pis.ivx.apsuginfo.d;

import xap.mw.core.data.BaseDTO;
import java.io.Serializable;

public class GetApsugInfoBean extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id_srv;
	private String name_or;
	public String getId_srv() {
		return id_srv;
	}
	public void setId_srv(String id_srv) {
		this.id_srv = id_srv;
	}
	public String getName_or() {
		return name_or;
	}
	public void setName_or(String name_or) {
		this.name_or = name_or;
	}
	
}
