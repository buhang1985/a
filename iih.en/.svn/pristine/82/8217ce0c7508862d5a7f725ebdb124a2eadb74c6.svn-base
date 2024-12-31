package iih.en.que.s;

import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.en.que.i.ICalcPriService;
import iih.en.que.s.bp.GetEntInfo4CalPriBP;
import iih.en.que.s.bp.GetMatchRuleItmBP;
import iih.en.que.s.bp.GetRuleItmByEntIdAndQueIdBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 计算优先级服务
 * @author yank
 *
 */
@Service(serviceInterfaces={ICalcPriService.class}, binding=Binding.JSONRPC)
public class CalcPriServiceImpl implements ICalcPriService {
	
	public CalcPriServiceImpl(){}
	/**
	 * 获取计算优先级的患者信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public PriorityDTO getEntInfo4CalPri(String entId) throws BizException{
		GetEntInfo4CalPriBP getBP = new GetEntInfo4CalPriBP();
		return getBP.exec(entId);
	}
	/**
	 * 得到门急诊就诊优先级的规则明细
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueRuleItmDO getMatchRuleItm(String entId) throws BizException {
		GetMatchRuleItmBP getBP = new GetMatchRuleItmBP();
		return getBP.exec(entId);
	}
	/**
	 * 获取就诊优先级的规则明细
	 * @param entId 就诊id
	 * @param queId 队列id
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueRuleItmDO getRuleItmByEntIdAndQueId(String entId, String queId) throws BizException {
		GetRuleItmByEntIdAndQueIdBP getRuleItmBP = new GetRuleItmByEntIdAndQueIdBP();
		return getRuleItmBP.exec(entId, queId);
	}
}
