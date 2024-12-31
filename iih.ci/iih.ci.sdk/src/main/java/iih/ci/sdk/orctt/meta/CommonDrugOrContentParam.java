package iih.ci.sdk.orctt.meta;

import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 用于西成药医嘱内容拼接的DTO
 * @author zwq
 *
 */
public class CommonDrugOrContentParam extends BaseOrContentParam{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 预防用药标识
	 * @return
	 */
	public FBoolean getFg_propc(){
		return ((FBoolean) getAttrVal("Fg_propc"));
	}
	/**
	 * 预防用药标识
	 * @param Fg_propc
	 */
	public void setFg_propc(FBoolean Fg_propc){
		setAttrVal("Fg_propc", Fg_propc);
	}
	/**
	 * 集合
	 * @return
	 */
	public FArrayList getItems(){
		return ((FArrayList) getAttrVal("Items"));
	}
	/**
	 * 集合
	 * @param Items
	 */
	public void setItems(FArrayList Items){
		setAttrVal("Items", Items);
	}
	/**
	 * Note
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * Note
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	//Fg_nothingwithorders()
}
