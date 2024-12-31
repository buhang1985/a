package iih.ei.std.s.v1.bp.common;

import org.apache.commons.lang.ArrayUtils;

import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class ChlTpEP {
	/**
	 * 根据渠道类型获取渠道信息
	 * 
	 * @param chlType 渠道类型
	 * @return
	 * @throws BizException
	 */
	public SchedulechlDO getScChlByTp(String chlType) throws BizException {
		if (chlType == null || "".equals(chlType)) {
			return null;
		}
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		SchedulechlDO[] chlDOs = bdQryService.getChlByTp(chlType);
		if (ArrayUtils.isNotEmpty(chlDOs)) {
			return chlDOs[0];
		} else {
			throw new BizException("获取渠道信息失败！");
		}
	}
}
