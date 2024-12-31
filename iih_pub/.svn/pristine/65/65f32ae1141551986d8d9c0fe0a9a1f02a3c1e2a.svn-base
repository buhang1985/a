package iih.ci.ord.i.mi.meta;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 用于返回前端的医保数据对象
 * 
 * @author HUMS
 *
 */
public class OrdHpRstDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;

	/**
	 * 是否成功
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_success() {
		return ((FBoolean) getAttrVal("Fg_success"));
	}

	/**
	 * 是否成功
	 * 
	 * @param FBoolean
	 */
	public void setFg_success(FBoolean Fg_success) {
		setAttrVal("Fg_success", Fg_success);
	}

	/**
	 * 提示信息
	 * 
	 * @return FArrayList
	 */
	public FArrayList getMsgList() {
		return ((FArrayList) getAttrVal("MsgList"));
	}

	/**
	 * 提示信息
	 * 
	 * @param ErrorEmsList
	 */
	public void setMsgList(FArrayList MsgList) {
		setAttrVal("MsgList", MsgList);
	}

	/**
	 * 适应症校验结果
	 * 
	 * @return
	 */
	public FArrayList getOrdHpVerifyRstList() {
		return ((FArrayList) getAttrVal("OrdHpVerifyRstList"));
	}

	/**
	 * 适应症校验结果
	 * 
	 * @param OrdHpVerifyRstList
	 */
	public void setOrdHpVerifyRstList(FArrayList OrdHpVerifyRstList) {
		setAttrVal("OrdHpVerifyRstList", OrdHpVerifyRstList);
	}

	/**
	 * 获取医保适应症待校验集合
	 * 
	 * @return
	 */
	public List<OrdHpVerifyRstDTO> getWaitVerifyOrdHpRstList() {

		List<OrdHpVerifyRstDTO> rstList = new ArrayList<OrdHpVerifyRstDTO>();

		FArrayList ordHpVerifyList = getOrdHpVerifyRstList();

		if (ordHpVerifyList.size() > 0) {
			for (Object obj : ordHpVerifyList) {
				OrdHpVerifyRstDTO ordHpVerifyRst = (OrdHpVerifyRstDTO) obj;
				Integer eu_hpindicjudge = ordHpVerifyRst.getEu_hpindicjudge();
				if (eu_hpindicjudge == null || HpIndicJudgeRstEnum.WAITING_JUDGE.equals(eu_hpindicjudge)) {
					rstList.add(ordHpVerifyRst);
				}
			}
		}

		return rstList;
	}

	/**
	 * 获取医保适应症已校验集合
	 * 
	 * @return
	 */
	public List<OrdHpVerifyRstDTO> getVerifiedOrdHpRstList() {

		List<OrdHpVerifyRstDTO> rstList = new ArrayList<OrdHpVerifyRstDTO>();

		FArrayList ordHpVerifyList = getOrdHpVerifyRstList();

		if (ordHpVerifyList.size() > 0) {
			for (Object obj : ordHpVerifyList) {
				OrdHpVerifyRstDTO ordHpVerifyRst = (OrdHpVerifyRstDTO) obj;
				Integer eu_hpindicjudge = ordHpVerifyRst.getEu_hpindicjudge();
				if (eu_hpindicjudge != null && !HpIndicJudgeRstEnum.WAITING_JUDGE.equals(eu_hpindicjudge)) {
					rstList.add(ordHpVerifyRst);
				}
			}
		}

		return rstList;
	}
}
