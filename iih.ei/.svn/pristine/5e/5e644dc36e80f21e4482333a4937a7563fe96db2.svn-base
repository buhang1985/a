package iih.ei.std.s.v1.bp.common;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class HpEP {
	/**
	 * 获取医保信息
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public HPDO getHpByCode(String code) throws BizException{
		if(StringUtil.isEmptyWithTrim(code))
			return null;
		IHpMDORService serv = ServiceFinder.find(IHpMDORService.class);
		HPDO[] hpdos = serv.find(String.format(" Code = '%s' and Fg_active = '%s' ", code, FBoolean.TRUE), null, FBoolean.FALSE);
		return ArrayUtil.isEmpty(hpdos) ? null : hpdos[0];
	}
}
