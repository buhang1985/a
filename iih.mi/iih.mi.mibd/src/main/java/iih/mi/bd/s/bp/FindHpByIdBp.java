package iih.mi.bd.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.HpDTO;
import xap.mw.core.data.BizException;

/**
 * 根据医保产品主键查询医保产品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindHpByIdBp {

	public HpDTO exec(String hpId) throws BizException {
		if (StringUtils.isEmpty(hpId)) {
			throw new BizException("医保产品主键不允许为空");
		}

		FindHpDtosByIdsBp bp = new FindHpDtosByIdsBp();
		HpDTO[] result = bp.exec(new String[] { hpId });
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}

}
