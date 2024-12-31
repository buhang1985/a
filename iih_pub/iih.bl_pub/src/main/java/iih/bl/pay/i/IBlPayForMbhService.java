package iih.bl.pay.i;

import xap.mw.core.data.BizException;
import iih.bl.pay.dto.mb.prepayrcd.d.BlPrepayIpRecordDTO;

/**
 * 费用收付款域对移动医疗提供服务
 * @author ly 2018/08/09
 *
 */
public interface IBlPayForMbhService {

	/**
	 * 查询患者住院预交金记录
	 * @param entId 就诊id
	 * @return 预交金冲退记录
	 * @throws BizException
	 */
	public abstract BlPrepayIpRecordDTO[] getIpPrepayRecord(String entId) throws BizException;
}
