package iih.bd.mm.s.external.provide;

import iih.bd.mm.drugcombctl.d.DrugCombCtlDTO;
import iih.bd.mm.drugcombctl.i.IDrugcombctlExtRService;
import iih.bd.mm.i.external.provide.IBdMmCiCudService;
import iih.bd.mm.i.external.provide.IBdMmCiRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 提供给临床域服务
 * 
 * @author hao_wu 2018-6-12
 *
 */
public class BdMmCiServiceImpl implements IBdMmCiCudService, IBdMmCiRService {

	@Override
	public DrugCombCtlDTO[] finaAllDrugCombCtl() throws BizException {
		IDrugcombctlExtRService drugcombctlExtRService = ServiceFinder.find(IDrugcombctlExtRService.class);
		DrugCombCtlDTO[] result = drugcombctlExtRService.findDrugCombCtl();
		return result;
	}

}
