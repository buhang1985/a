package iih.mi.bd.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.param.IBdMhiParamCodeConst.ExtAttr;
import iih.bd.bc.param.IBdMhiParamCodeConst.ProgramConfig;
import iih.bd.bc.udi.pub.IBdMhiDictCodeTypeConst;
import iih.bd.utils.BdMhiParamUtils;
import iih.mi.bd.d.HpDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 填充医保产品实体参数业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FillHpInstParamsBp {

	public void exec(HpDTO[] hpDtos) throws BizException {
		if (hpDtos == null || hpDtos.length <= 0) {
			return;
		}

		fillHpInstParams(hpDtos);
		fillPatSourceCode(hpDtos);
	}

	/**
	 * 填充患者来源编码
	 * 
	 * @param hpDtos
	 * @throws BizException
	 */
	private void fillPatSourceCode(HpDTO[] hpDtos) throws BizException {
		HashMap<String, UdidocDO> patSourceMap = getPatSourceMap();
		if (patSourceMap == null || patSourceMap.size() <= 0) {
			return;
		}

		for (HpDTO hpDTO : hpDtos) {
			String patSourceId = hpDTO.getId_patsource();
			if (StringUtils.isEmpty(patSourceId)) {
				continue;
			}
			String[] patSourceIds = patSourceId.split(",");
			StringBuilder patSourceCodeBuilder = new StringBuilder();
			for (String str : patSourceIds) {
				if (!patSourceMap.containsKey(str)) {
					continue;
				}

				UdidocDO patSource = patSourceMap.get(str);
				if (patSource != null) {
					if (patSourceCodeBuilder.length() > 0) {
						patSourceCodeBuilder.append(",");
					}
					patSourceCodeBuilder.append(patSource.getCode());
				}
			}
			hpDTO.setSd_patsource(patSourceCodeBuilder.toString());
		}
	}

	/**
	 * 获取患者来源字典
	 * 
	 * @param patSourceIds
	 * @return [患者来源主键,患者来源]
	 * @throws BizException
	 */
	private HashMap<String, UdidocDO> getPatSourceMap() throws BizException {
		HashMap<String, UdidocDO> patSourceMap = new HashMap<String, UdidocDO>();
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] result = udidocServiceExt.findByUdidoclistCode(IBdMhiDictCodeTypeConst.SD_HPPATSOURCE);
		if (result == null || result.length <= 0) {
			return patSourceMap;
		}
		for (UdidocDO udidocDO : result) {
			patSourceMap.put(udidocDO.getId_udidoc(), udidocDO);
		}
		return patSourceMap;
	}

	/**
	 * 填充医保产品实体参数
	 * 
	 * @param hpDtos
	 * @throws BizException
	 */
	private void fillHpInstParams(HpDTO[] hpDtos) throws BizException {
		String[] hpIds = getHpIds(hpDtos);
		if (hpIds == null || hpIds.length <= 0) {
			return;
		}

		Map<String, Map<String, String>> paramMap = BdMhiParamUtils.ExtAttr.getAllParamsByHpIds(hpIds);
		if (paramMap == null || paramMap.size() <= 0) {
			return;
		}

		for (HpDTO hpDTO : hpDtos) {
			String hpId = hpDTO.getId_hp();
			if (StringUtils.isNotEmpty(hpId) && paramMap.containsKey(hpId)) {
				Map<String, String> instParamMap = paramMap.get(hpId);
				setInstParams(hpDTO, instParamMap);
			}
		}
	}

	/**
	 * 获取医保产品主键集合
	 * 
	 * @param hpDtos
	 *            医保产品集合
	 * @return
	 */
	private String[] getHpIds(HpDTO[] hpDtos) {
		if (hpDtos == null || hpDtos.length <= 0) {
			return null;
		}

		ArrayList<String> hpIdList = new ArrayList<String>();
		for (HpDTO hpDTO : hpDtos) {
			String hpId = hpDTO.getId_hp();
			if (StringUtils.isNotEmpty(hpId)) {
				hpIdList.add(hpId);
			}
		}

		return hpIdList.toArray(new String[0]);
	}

	/**
	 * 设置实体参数值
	 * 
	 * @param hpDTO
	 *            医保产品DTO
	 * @param instParamMap
	 *            参数字典
	 */
	private void setInstParams(HpDTO hpDTO, Map<String, String> instParamMap) {
		if (hpDTO == null || instParamMap == null || instParamMap.size() <= 0) {
			return;
		}

		if (instParamMap.containsKey(ProgramConfig.HPFACTORYINSTFULLNAME)) {
			// 医保产品工厂实例类全名称
			hpDTO.setFactoryinst(instParamMap.get(ProgramConfig.HPFACTORYINSTFULLNAME));
		}

		if (instParamMap.containsKey(ProgramConfig.HPMIWSINVOKETIMEOUTS)) {
			// 医保WebService调用超时时长(秒)
			hpDTO.setWsinvoketimeouts(instParamMap.get(ProgramConfig.HPMIWSINVOKETIMEOUTS));
		}

		if (instParamMap.containsKey(ProgramConfig.HPMIWSINVOKEURL)) {
			// 医保WebService调用地址
			hpDTO.setWsinvokeurl(instParamMap.get(ProgramConfig.HPMIWSINVOKEURL));
		}

		if (instParamMap.containsKey(ProgramConfig.HPMIWSINVOKEUSERNAME)) {
			// 医保WebService调用用户名
			hpDTO.setWsinvokeusername(instParamMap.get(ProgramConfig.HPMIWSINVOKEUSERNAME));
		}

		if (instParamMap.containsKey(ProgramConfig.HPDATASOURCENAME)) {
			// 医保产品第三方数据源
			hpDTO.setDatasourcename(instParamMap.get(ProgramConfig.HPDATASOURCENAME));
		}
		if (instParamMap.containsKey(ProgramConfig.HPIPSTEXPPATH)) {
			// 住院医保结算导出路径
			hpDTO.setIpstexppath(instParamMap.get(ProgramConfig.HPIPSTEXPPATH));
		}
		if (instParamMap.containsKey(ProgramConfig.HPIPSTIMPPATH)) {
			// 住院医保结算导入路径
			hpDTO.setIpstimppath(instParamMap.get(ProgramConfig.HPIPSTIMPPATH));
		}

		if (instParamMap.containsKey(ExtAttr.HPDESIGMICODE)) {
			// 医保定点医疗机构编码
			hpDTO.setDesigmicode(instParamMap.get(ExtAttr.HPDESIGMICODE));
		}

		if (instParamMap.containsKey(ExtAttr.HPDESIGMINAME)) {
			// 医保定点医疗机构名称
			hpDTO.setDesigminame(instParamMap.get(ExtAttr.HPDESIGMINAME));
		}

		if (instParamMap.containsKey(ExtAttr.HPMEDDISTCODE)) {
			// 就医地地区编码
			hpDTO.setMeddistcode(instParamMap.get(ExtAttr.HPMEDDISTCODE));
		}

		if (instParamMap.containsKey(ExtAttr.HPPATSOURCE)) {
			// 医保患者来源
			hpDTO.setId_patsource(instParamMap.get(ExtAttr.HPPATSOURCE));
		}
		if (instParamMap.containsKey(ExtAttr.HPHOSLEVELCODE)) {
			// 医疗机构级别代码
			hpDTO.setHoslevel_code(instParamMap.get(ExtAttr.HPHOSLEVELCODE));
		}
		if (instParamMap.containsKey(ExtAttr.HPHOSLEVELNAME)) {
			// 医疗机构级别名称
			hpDTO.setHoslevel_name(instParamMap.get(ExtAttr.HPHOSLEVELNAME));
		}
	}
}
