package iih.ci.ord.i.common.b;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.FArrayList;

public class BaseCiDTO extends BaseXapJsonSerialization {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public BaseCiDTO(){
		setDocument(new FArrayList());
	}
	
	public CiEnContextDTO getEnContext(){
		return ((CiEnContextDTO) getAttrVal("EnContext"));
	}
	
	public void setEnContext(CiEnContextDTO ctx){
		setAttrVal("EnContext", ctx);
	}
	
	/**
	 * 数据档案
	 * @return String
	 */
	public FArrayList getDocument() {
		return ((FArrayList) getAttrVal("Document"));
	}
	/**
	 * 数据档案
	 * @param Document
	 */
	public void setDocument(FArrayList document) {
		setAttrVal("Document", document);
	}
	
}
