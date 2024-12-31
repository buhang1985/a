package iih.pi.reg.s.ws.base;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者信息更新ws服务基类
 * 
 * @author ly 2018/01/16
 *
 */
public class PatInfoUpdateBaseWSBP {

	/**
	 * 获取患者数据
	 * 
	 * @param patCode
	 *            患者编码
	 * @return
	 * @throws BizException
	 */
	protected PatDO getPat(String patCode) throws BizException {
		IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);

		String wherePart = String.format("code = '%s' and fg_invd = 'N'", patCode);
		PatDO[] result = patiMDORService.find(wherePart, "", FBoolean.FALSE);

		if (result != null && result.length > 0) {
			return result[0];
		}

		return null;
	}

	/**
	 * 获取患者Agg数据
	 * 
	 * @param patCode
	 *            患者编码
	 * @return
	 * @throws BizException
	 */
	protected PatiAggDO getPatAgg(String patCode) throws BizException {

		IPatiRService rService = ServiceFinder.find(IPatiRService.class);

		PatiAggDO[] aggDos = rService.find(PatDODesc.TABLE_ALIAS_NAME + ".code = '" + patCode + "' and "
				+ PatDODesc.TABLE_ALIAS_NAME + ".fg_invd = 'N' ", "", FBoolean.FALSE);

		PatiAggDO agg = null;
		if (!ArrayUtil.isEmpty(aggDos)) {
			for (PatiAggDO patiAggDO : aggDos) {
				// 排除失效患者
				if (FBoolean.TRUE.equals(patiAggDO.getParentDO().getFg_invd()))
					continue;

				agg = patiAggDO;
			}
		}

		return agg;
	}
}
