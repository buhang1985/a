package iih.sfda.aer.dto.sfdaaerinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 上报单据信息 DTO数据 
 * 
 */
public class SfdaEvInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 受损害者资料
	 * @return FArrayList
	 */
	public FArrayList getSuffer() {
		return ((FArrayList) getAttrVal("Suffer"));
	}
	/**
	 * 受损害者资料
	 * @param Suffer
	 */
	public void setSuffer(FArrayList Suffer) {
		setAttrVal("Suffer", Suffer);
	}
	/**
	 * 事件资料及事后处理
	 * @return FArrayList
	 */
	public FArrayList getEv_data() {
		return ((FArrayList) getAttrVal("Ev_data"));
	}
	/**
	 * 事件资料及事后处理
	 * @param Ev_data
	 */
	public void setEv_data(FArrayList Ev_data) {
		setAttrVal("Ev_data", Ev_data);
	}
	/**
	 * 事件详情信息
	 * @return FArrayList
	 */
	public FArrayList getEv_info() {
		return ((FArrayList) getAttrVal("Ev_info"));
	}
	/**
	 * 事件详情信息
	 * @param Ev_info
	 */
	public void setEv_info(FArrayList Ev_info) {
		setAttrVal("Ev_info", Ev_info);
	}
	/**
	 * 当事人信息
	 * @return FArrayList
	 */
	public FArrayList getParty_info() {
		return ((FArrayList) getAttrVal("Party_info"));
	}
	/**
	 * 当事人信息
	 * @param Party_info
	 */
	public void setParty_info(FArrayList Party_info) {
		setAttrVal("Party_info", Party_info);
	}
	/**
	 * 附件列表
	 * @return FArrayList
	 */
	public FArrayList getEvfilelist() {
		return ((FArrayList) getAttrVal("Evfilelist"));
	}
	/**
	 * 附件列表
	 * @param Evfilelist
	 */
	public void setEvfilelist(FArrayList Evfilelist) {
		setAttrVal("Evfilelist", Evfilelist);
	}
}