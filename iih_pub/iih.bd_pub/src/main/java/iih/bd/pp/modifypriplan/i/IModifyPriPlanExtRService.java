package iih.bd.pp.modifypriplan.i;

import iih.bd.pp.modifypriplan.d.ModifyPriPlanItmDO;
import iih.bd.pp.modifypriplan.d.ModifypriplanAggDO;
import xap.mw.core.data.BizException;

/**
 * 调价计划扩展服务
 * 
 * @author guoyang
 *
 */
public interface IModifyPriPlanExtRService {

	/**
	 * 查询aggdo
	 * 
	 * @param id_mdo
	 * @return
	 */
	public abstract ModifypriplanAggDO findModifypriplanAggDo(String id_mdo) throws BizException;

	/**
	 * 更新调价计划项目关联信息</br>
	 * 设置价格
	 * 
	 * @param planItmDo
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	public abstract ModifyPriPlanItmDO updatePlanItmDORefInfo(ModifyPriPlanItmDO planItmDo, String id_pripat)
			throws BizException;
}
