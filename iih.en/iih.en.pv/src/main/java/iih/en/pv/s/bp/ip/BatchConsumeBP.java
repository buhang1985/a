package iih.en.pv.s.bp.ip;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnAccEP;
import iih.en.pv.enfee.d.EnAccountDO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 多个就诊批量消费
 * 
 * @author yank
 */
public class BatchConsumeBP {
	/**
	 * 批量消费
	 * 
	 * @param consumeMap 消费map，KEY:就诊id， VALUE: 合计消费金额
	 * @throws BizException
	 * @author yank
	 */
	public void exec(Map<String, FDouble> consumeMap) throws BizException {
		if (consumeMap == null || consumeMap.size() <= 0)
			return;

		// 1、批量获取就诊账户
		EnAccEP enAccEP = new EnAccEP();
		EnAccountDO[] accDOArray = enAccEP.getEnAccList(consumeMap.keySet().toArray(new String[0]));
		if (accDOArray == null || accDOArray.length != consumeMap.size()) {
			throw new BizException(IEnMsgConst.ERROR_ACC_ENT_AND_ACC_NOT_MATCH);
		}

		// 2、逐个消费，批量保存
		for (EnAccountDO accDo : accDOArray) {
			accDo.setAmt_uncg(accDo.getAmt_uncg().add(consumeMap.get(accDo.getId_ent())));// 消费
		}
		enAccEP.update(accDOArray);
	}
}
