package iih.ci.ord.i.external.obtain.meta.hp;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取医保目录类型参数
 * 
 * @author HUMS
 *
 */
public class HpsrvtpQryParamDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;

	public HpsrvtpQryParamDTO(){
		
	}
	
	public HpsrvtpQryParamDTO( String id_srv, String id_mm) {
		
		this.setId_srv(id_srv);
		this.setId_mm(id_mm);
	}
	

	// 获取医保目录类型key值，id_srv+id_mm
	public String getKey() {
		return this.getId_srv() + StringUtils.trimToEmpty(this.getId_mm());
	}

	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}

	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}

	public FBoolean getFg_mm() {
		
		if(StringUtils.isNotEmpty(this.getId_mm())){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;		
	}
}