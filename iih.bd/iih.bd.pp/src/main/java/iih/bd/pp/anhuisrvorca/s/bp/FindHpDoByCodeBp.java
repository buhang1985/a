package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据医保计划编码获取医保计划业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindHpDoByCodeBp {

	public HPDO exec(String hpCode) throws BizException {
		if (StringUtils.isEmpty(hpCode)) {
			throw new BizException("医保计划编码为空。");
		}

		IHpMDORService hpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO[] result = hpMDORService.findByAttrValString(HPDO.CODE, hpCode);
		if (result == null || result.length < 1) {
			String msg = String.format("获取医保计划失败，医保计划编码\"%s\"。", hpCode);
			throw new BizException(msg);
		}
		if (result.length > 1) {
			String msg = String.format("获取到多个医保计划，医保计划编码\"%s\"。", hpCode);
			throw new BizException(msg);
		}

		return result[0];
	}
}
