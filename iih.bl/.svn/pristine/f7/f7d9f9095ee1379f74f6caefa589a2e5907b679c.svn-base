package iih.bl.pay.s;

import xap.mw.core.data.BizException;
import iih.bl.pay.dto.mb.prepayrcd.d.BlPrepayIpRecordDTO;
import iih.bl.pay.i.IBlPayForMbhService;
import iih.bl.pay.s.provide.mbh.BlIpGetPrepayRecordBP;

/**
 * 费用收付款域对移动医疗提供服务
 * @author ly 2018/08/09
 *
 */
public class BlPayForMbhServiceImpl implements IBlPayForMbhService {

	/**
	 * 查询患者住院预交金记录
	 * @param entId 就诊id
	 * @return 预交金冲退记录
	 * @throws BizException
	 */
	@Override
	public BlPrepayIpRecordDTO[] getIpPrepayRecord(String entId) throws BizException {
		BlIpGetPrepayRecordBP bp = new BlIpGetPrepayRecordBP();
		return bp.exec(entId);
	}

}
