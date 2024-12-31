package iih.ci.rcm.s;

import iih.ci.rcm.i.ICiRcmParamService;
import iih.ci.rcm.s.bp.common.CiRcmParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiRcmParamService.class }, binding = Binding.JSONRPC)
public class CiRcmParamServiceImpl implements ICiRcmParamService{

	public String getSysParaContagionAidsUnit(String id_org) {
		return CiRcmParamUtils.GetSysParaContagionAidsUnit(id_org);
	}

	/**
	 * 获取传染漏报定点刷新时间
	 * @param id_org
	 * @return
	 */
	public String getSysParaConPassFixedTime(String id_org) {
		return CiRcmParamUtils.getSysParaConPassFixedTime(id_org);
	}

	/**
	 * 获取传染漏报刷新间隔时间
	 * @param id_org
	 * @return
	 */
	public String getSysParaConPassIntervalTime(String id_org) {
		return CiRcmParamUtils.getSysParaConPassIntervalTime(id_org);
	}

	/**
	 * 获取传染漏报是否启用动刷新
	 * @param id_org
	 * @return
	 */
	public Boolean getSysParaConPassRefrushActive(String id_org) {
		return CiRcmParamUtils.getSysParaConPassRefrushActive(id_org);
	}
	
	/**
	 * 获取死亡报卡医院邮编
	 * @param id_org
	 * @return
	 */
	public String getSysParaAdminCode(String id_org)
	{
		return CiRcmParamUtils.getSysParaAdminCode(id_org);
	}
	
	/**
	 * 获取死亡报卡编码前缀
	 * @param id_org
	 * @return
	 */
	public String getSysParaPrefixCode(String id_org)
	{
		return CiRcmParamUtils.getSysParaPrefixCode(id_org);
	}
}
