package iih.pi.reg.i;

import javax.jws.WebParam;
import javax.jws.WebService;

import xap.mw.core.data.BizException;

/**
 * 患者不良记录查询WebService接口
 * 
 * @author hao_wu
 *
 */
@WebService
public interface IPiPatBadRecQryWService {

	/**
	 * 检查患者不良记录
	 * 
	 * @author hao_wu
	 * @param patCode
	 *            患者编码
	 * @param badRecTpCode
	 *            不良记录类型编码 [PI.PI.1625]</br>
	 *            [00,预约挂号违约],[01,门诊欠款逾期],[02,资源预约违约],</br>
	 *            [03,门诊费用未结],[10,住院预约违约],[11,住院欠款逾期],</br>
	 *            [20,体检预约违约]
	 * @return [N,患者不存在该不良记录],[Y,患者存在该不良记录]
	 * @throws BizException
	 */
	public String checkPatBadRec(@WebParam(name = "patCode") String patCode,
			@WebParam(name = "badRecTpCode") String badRecTpCode) throws BizException;
}
