package iih.bd.mm.drugcombctl.s;

import iih.bd.mm.drugcombctl.d.DrugCombCtlDTO;
import iih.bd.mm.drugcombctl.i.IDrugcombctlExtCudService;
import iih.bd.mm.drugcombctl.i.IDrugcombctlExtRService;
import iih.bd.mm.drugcombctl.s.bp.FindDrugCombCtlBp;
import xap.mw.core.data.BizException;

/**
 * 联合用药限制扩展服务
 * 
 * @author hao_wu 2018-11-6
 *
 */
public class DrugcombctlExtCrudServiceImpl implements IDrugcombctlExtCudService, IDrugcombctlExtRService {

	@Override
	public DrugCombCtlDTO[] findDrugCombCtl() throws BizException {
		FindDrugCombCtlBp bp = new FindDrugCombCtlBp();
		DrugCombCtlDTO[] result = bp.exec();
		return result;
	}

}
