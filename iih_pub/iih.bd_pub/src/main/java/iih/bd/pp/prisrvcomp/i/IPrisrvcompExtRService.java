package iih.bd.pp.prisrvcomp.i;

import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import xap.mw.core.data.BizException;

/**
 * 付款策略_组合定价扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IPrisrvcompExtRService {
	/**
	 * 根据医疗服务主键查询组合定价列表</br>
	 * 增加了金额的计算
	 * 
	 * @param medsrvId
	 *            医疗服务主键
	 * @param orderByPart
	 *            排序语句
	 * @return
	 * @throws BizException
	 */
	public abstract PriSrvCompDO[] FindByMedsrvId(String medsrvId, String orderByPart) throws BizException;
}
