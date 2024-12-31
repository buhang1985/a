package iih.ci.ord.i.mi.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 默认医保信息返回结果对象
 * 
 * @author HUMS
 *
 */
public class DefaultOrdHpInfoRstDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;

	public String getKey() {
		String key = ((String) getAttrVal("Key"));
		if (StringUtils.isNotEmpty(key)) {
			return key;
		}
		return this.getCode_or();
	}

	public void setKey(String Key) {
		setAttrVal("Key", Key);
	}

	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}

	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}

	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}

	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}

	/**
	 * 获取医嘱的适应症判断结果<br>
	 * 1.存在未判断的，返回空 <br>
	 * 2.如果存在待判断的，返回待判断
	 */
	public Integer getEu_hpindicjudge() {

		List<DefaultOrdSrvHpInfoRstDTO> ordSrvHpInfoRstList = getOrdSrvDefaultHpInfoRstList();
		if (ordSrvHpInfoRstList.size() == 0) {
			return HpIndicJudgeRstEnum.NON_BLITEM;
		}

		for (DefaultOrdSrvHpInfoRstDTO ordSrvHpInfoRst : ordSrvHpInfoRstList) {

			Integer eu_hpindicjudg = ordSrvHpInfoRst.getEu_hpindicjudge();
			
			// 存在空的，未进行医保适应症判断
			if (ordSrvHpInfoRst.getEu_hpindicjudge() == null) {
				return null;
			}
			
			// 如果存在非医保就诊的费用项目，返回本次非医保就诊
			if(HpIndicJudgeRstEnum.NON_MEDICAL.equals(eu_hpindicjudg)){
				return HpIndicJudgeRstEnum.NON_MEDICAL;
			}

			// 如果存在待判断的费用项目，返回待判断
			if (HpIndicJudgeRstEnum.WAITING_JUDGE.equals(eu_hpindicjudg)) {
				return HpIndicJudgeRstEnum.WAITING_JUDGE;
			}

			// 如果存在医生判断的费用项目，返回为医生判断
			if (HpIndicJudgeRstEnum.DOCTOR_JUDGE.equals(eu_hpindicjudg)) {
				return HpIndicJudgeRstEnum.DOCTOR_JUDGE;
			}
		}

		return HpIndicJudgeRstEnum.SYSTEM_JUDGE;
	}

	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}

	/**
	 * 当有一个明细项自费标识为空时返回nul 当不存在明细项费用标识为空时，如果存在一项是医保返回医保
	 */
	public FBoolean getFg_orhp() {

		FBoolean fg_orhp = FBoolean.FALSE;
		List<DefaultOrdSrvHpInfoRstDTO> ordSrvHpInfoRstList = getOrdSrvDefaultHpInfoRstList();
		if (ordSrvHpInfoRstList.size() == 0) {
			return fg_orhp;
		}

		for (DefaultOrdSrvHpInfoRstDTO ordSrvHpInfoRst : ordSrvHpInfoRstList) {
			if (ordSrvHpInfoRst.getFg_selfpay() == null) {
				return null;
			}

			if (FBoolean.FALSE.equals(ordSrvHpInfoRst.getFg_selfpay())) {
				fg_orhp = FBoolean.TRUE;
				break;
			}
		}

		return fg_orhp;
		// return ((FBoolean) getAttrVal("Fg_orhp"));
	}

	public void setFg_orhp(FBoolean Fg_orhp) {
		setAttrVal("Fg_orhp", Fg_orhp);
	}

	public FArrayList getOrdSrvDefaultHpInfoRsts() {
		return ((FArrayList) getAttrVal("OrdSrvDefaultHpInfoRsts"));
	}

	public void setOrdSrvDefaultHpInfoRsts(FArrayList OrdSrvDefaultHpInfoRsts) {
		setAttrVal("OrdSrvDefaultHpInfoRsts", OrdSrvDefaultHpInfoRsts);
	}

	public List<DefaultOrdSrvHpInfoRstDTO> addOrdSrvHpInfoRst(DefaultOrdSrvHpInfoRstDTO OrdSrvHpInfoRst) {

		FArrayList ordSrvDefaultHpInfos = this.getOrdSrvDefaultHpInfoRsts();
		if (ordSrvDefaultHpInfos == null || ordSrvDefaultHpInfos.size() == 0) {
			ordSrvDefaultHpInfos = new FArrayList();
		}

		ordSrvDefaultHpInfos.add(OrdSrvHpInfoRst);
		this.setOrdSrvDefaultHpInfoRsts(ordSrvDefaultHpInfos);

		return this.getOrdSrvDefaultHpInfoRstList();
	}

	/**
	 * 获取服务项目默认医保信息List集合
	 * 
	 * @return
	 */
	public List<DefaultOrdSrvHpInfoRstDTO> getOrdSrvDefaultHpInfoRstList() {

		List<DefaultOrdSrvHpInfoRstDTO> ordSrvDefaultHpInfoList = new ArrayList<DefaultOrdSrvHpInfoRstDTO>();
		FArrayList ordSrvDefaultHpInfoRsts = ((FArrayList) getAttrVal("OrdSrvDefaultHpInfoRsts"));

		if (ordSrvDefaultHpInfoRsts == null || ordSrvDefaultHpInfoRsts.size() == 0) {
			return ordSrvDefaultHpInfoList;
		}

		for (Object obj : ordSrvDefaultHpInfoRsts) {

			DefaultOrdSrvHpInfoRstDTO ordSrvHpInfo = (DefaultOrdSrvHpInfoRstDTO) obj;
			ordSrvDefaultHpInfoList.add(ordSrvHpInfo);
		}

		return ordSrvDefaultHpInfoList;
	}

	/**
	 * 获取服务项目默认医保信息Map集合
	 * 
	 * @return
	 */
	public Map<String, DefaultOrdSrvHpInfoRstDTO> getOrdSrvDefaultHpInfoRstMap() {

		Map<String, DefaultOrdSrvHpInfoRstDTO> ordSrvHpInfoRstMap = new HashMap<String, DefaultOrdSrvHpInfoRstDTO>();

		FArrayList ordSrvDefaultHpInfoRsts = ((FArrayList) getAttrVal("OrdSrvDefaultHpInfoRsts"));

		if (ordSrvDefaultHpInfoRsts == null || ordSrvDefaultHpInfoRsts.size() == 0) {
			return ordSrvHpInfoRstMap;
		}

		for (Object obj : ordSrvDefaultHpInfoRsts) {

			DefaultOrdSrvHpInfoRstDTO ordSrvHpInfo = (DefaultOrdSrvHpInfoRstDTO) obj;
			ordSrvHpInfoRstMap.put(ordSrvHpInfo.getKey(), ordSrvHpInfo);
		}

		return ordSrvHpInfoRstMap;
	}
}
