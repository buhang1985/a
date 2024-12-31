package iih.ci.ord.i.external.obtain.meta.hp;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.FArrayList;

/**
 * 医保校验参数
 * 
 * @author HUMS
 *
 */
public class HpVerifyParamDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;
	

	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}

	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}

	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}

	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}

	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}

	public HpVerifyDiagParamDTO getDiagItem() {
		return ((HpVerifyDiagParamDTO) getAttrVal("DiagItem"));
	}

	public void setDiagItem(HpVerifyDiagParamDTO DiagItem) {
		setAttrVal("DiagItem", DiagItem);
	}

	public FArrayList getOrdSrvList() {
		return ((FArrayList) getAttrVal("OrdSrvList"));
	}

	public void setOrdSrvList(FArrayList OrdSrvList) {
		setAttrVal("OrdSrvList", OrdSrvList);
	}

}
