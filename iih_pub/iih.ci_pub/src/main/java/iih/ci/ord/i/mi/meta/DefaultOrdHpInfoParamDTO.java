package iih.ci.ord.i.mi.meta;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获取默认医保信息参数
 * 
 * @author HUMS
 *
 */
public class DefaultOrdHpInfoParamDTO extends BaseXapJsonSerialization {

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

	public FBoolean getFg_orhp() {
		return ((FBoolean) getAttrVal("Fg_orhp"));
	}

	public void setFg_orhp(FBoolean Fg_orhp) {
		setAttrVal("Fg_orhp", Fg_orhp);
	}

	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}

	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}

	public FArrayList getOrdSrvDefaultHpInfo() {
		return ((FArrayList) getAttrVal("OrdSrvDefaultHpInfo"));
	}

	public void setOrdSrvDefaultHpInfo(FArrayList OrdSrvDefaultHpInfo) {
		setAttrVal("OrdSrvDefaultHpInfo", OrdSrvDefaultHpInfo);
	}

	/**
	 * 添加医嘱项目的获取默认医保参数对象
	 * 
	 * @param ordSrvHpInfoParam
	 * @return
	 */
	public List<DefaultOrdSrvHpInfoParamDTO> addDefaultOrdSrvHpInfoParam(DefaultOrdSrvHpInfoParamDTO ordSrvHpInfoParam) {

		FArrayList ordSrvDefaultHpInfos = this.getOrdSrvDefaultHpInfo();
		if (ordSrvDefaultHpInfos == null || ordSrvDefaultHpInfos.size() == 0) {
			ordSrvDefaultHpInfos = new FArrayList();
		}

		ordSrvDefaultHpInfos.add(ordSrvHpInfoParam);
		this.setOrdSrvDefaultHpInfo(ordSrvDefaultHpInfos);

		return this.getOrdSrvDefaultHpInfoList();

	}

	/**
	 * 获取服务项目默认医保信息
	 * 
	 * @return
	 */
	public List<DefaultOrdSrvHpInfoParamDTO> getOrdSrvDefaultHpInfoList() {

		List<DefaultOrdSrvHpInfoParamDTO> ordSrvDefaultHpInfoList = new ArrayList<DefaultOrdSrvHpInfoParamDTO>();
		FArrayList ordSrvDefaultHpInfos = ((FArrayList) getAttrVal("OrdSrvDefaultHpInfo"));

		if (ordSrvDefaultHpInfos == null || ordSrvDefaultHpInfos.size() == 0) {
			return ordSrvDefaultHpInfoList;
		}

		for (Object obj : ordSrvDefaultHpInfos) {

			DefaultOrdSrvHpInfoParamDTO ordSrvHpInfo = (DefaultOrdSrvHpInfoParamDTO) obj;
			ordSrvDefaultHpInfoList.add(ordSrvHpInfo);
		}

		return ordSrvDefaultHpInfoList;
	}

}
