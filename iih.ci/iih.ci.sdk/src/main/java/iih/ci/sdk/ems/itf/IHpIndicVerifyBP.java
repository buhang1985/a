package iih.ci.sdk.ems.itf;

import iih.ci.sdk.ems.meta.HpIndicParamInfo;
import iih.ci.sdk.ems.meta.HpIndicParamRstMap;
import xap.mw.core.data.BizException;

/**
 * 医保适应症校验接口
 * @author wangqingzhu
 *
 */
public interface IHpIndicVerifyBP {

	/**
	 * 批量获取医保适应症信息字典
	 * @param szParam
	 * @return
	 * @throws BizException
	 */
	public abstract HpIndicParamRstMap getHpIndicInfos(HpIndicParamInfo[] szParam) throws BizException;
}
