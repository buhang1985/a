package iih.bl.st.exchangehandle.i;

import iih.bl.cg.dto.d.BlChargeDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊退费收费交易接口
 * @author yangyang
 *
 */
public interface IChargeVsRefundOepService {

	BlChargeDTO[] price(BlChargeDTO[] chargeItems) throws BizException;
}
