package iih.nmr.nm.bch.i;

import iih.nmr.nm.bch.evaluation.d.EvaluationAggDO;
import xap.mw.core.data.BizException;

public interface INmrBchQueryService {

	/**
	 * 获取住院患者及健康教育评价单
	 * 
	 * @param Id_ent就诊
	 *            ID
	 * @param code_udi自定义档案编码
	 * @return
	 * @throws BizException
	 * @author jinkk
	 */
	public EvaluationAggDO getEvaluation(String Id_ent, String code_udi) throws BizException;

}
