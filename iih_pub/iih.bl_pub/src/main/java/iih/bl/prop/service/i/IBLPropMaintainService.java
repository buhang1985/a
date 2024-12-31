package iih.bl.prop.service.i;

import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

public interface IBLPropMaintainService {
	/**
	 * 保存门诊分摊数据
	 * @param blPropOepDOArr
	 * @param blproparoepAggDOArr
	 * @throws BizException
	 */
	public abstract FMap2 saveOepProp(BlPropOepDO[] blPropOepDOArr,BlproparoepAggDO[] blproparoepAggDOArr)  throws BizException;

}
