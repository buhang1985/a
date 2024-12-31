package iih.bd.mm.drugcombctl.i;

import iih.bd.mm.drugcombctl.d.DrugCombCtlDTO;
import xap.mw.core.data.BizException;

/**
 * 联合用药限制扩展查询服务
 * 
 * @author hao_wu 2018-11-6
 *
 */
public interface IDrugcombctlExtRService {

	/**
	 * 查询联合用药限制信息</br>
	 * 业务使用
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract DrugCombCtlDTO[] findDrugCombCtl() throws BizException;
}
