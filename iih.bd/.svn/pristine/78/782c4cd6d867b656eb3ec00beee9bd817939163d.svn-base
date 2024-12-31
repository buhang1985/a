package iih.bd.fc.que.s;

import iih.bd.fc.que.bp.GetOpBenAddrBP;
import iih.bd.fc.que.bp.HasScPlBP;
import iih.bd.fc.que.bp.IsBenContainQueBP;
import iih.bd.fc.que.bp.QueQryBP;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueQryService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 队列查询服务
 * @author yankan
 *
 */
@Service(serviceInterfaces={IQueQryService.class}, binding=Binding.JSONRPC)
public class QueQryServiceImpl implements IQueQryService {
	/**
	 * 获取排班队列
	 * @param scResId 排班资源id
	 * @param depId 出诊科室id
	 * @param quebenId 分诊台id
	 * @param queTp 队列类型
	 * @return
	 * @throws BizException
	 */
	public QueDO getQue(String scResId,String depId, String quebenId, String queTp) throws BizException{
		QueQryBP qryBP = new QueQryBP();
		return qryBP.getQue(scResId, depId, quebenId, queTp);
	}

	/**
	 * 判断队列是否有相对应排班计划
	 * 
	 * @param que
	 * 		队列DO
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public FBoolean hasScPl(QueDO que) throws BizException {
		HasScPlBP bp = new HasScPlBP();
		return bp.hasScPl(que);
	}
	/**
     * 判断队列是否在分诊台管理之下
     * 
     * @param benId 分诊台ID
     * @param queId 队列ID
     * @return
     * @throws BizException
     */
	@Override
	public FBoolean isBenContainQue(String benId, String queId) throws BizException {
		IsBenContainQueBP bp = new IsBenContainQueBP();
		return bp.exec(benId, queId);
	}
	/**
	 * 获取门诊分诊台地址
	 * 
	 * @param depId
	 * @param scresId
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getOpBenAddr(String depId, String scresId, String benId)
			throws BizException {
		GetOpBenAddrBP bp = new GetOpBenAddrBP();
		return bp.exec(depId, scresId, benId);
	}
}
