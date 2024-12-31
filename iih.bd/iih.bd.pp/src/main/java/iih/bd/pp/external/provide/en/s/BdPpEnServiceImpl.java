package iih.bd.pp.external.provide.en.s;

import iih.bd.pp.external.provide.en.d.DrugMaxPriceDTO;
import iih.bd.pp.external.provide.en.i.IBdPpEnQryService;
import iih.bd.pp.external.provide.en.i.IBdPpEnService;
import iih.bd.pp.external.provide.en.s.bp.FindDrugMaxPriListByPyCodeBp;
import xap.mw.core.data.BizException;

/**
 * 提供给就诊域服务
 * 
 * @author hao_wu 2018-6-12
 *
 */
public class BdPpEnServiceImpl implements IBdPpEnService, IBdPpEnQryService {

	@Override
	public DrugMaxPriceDTO[] findDrugMaxPriListByPyCode(String pyCode) throws BizException {
		FindDrugMaxPriListByPyCodeBp bp = new FindDrugMaxPriListByPyCodeBp();
		DrugMaxPriceDTO[] result = bp.exec(pyCode);
		return result;
	}
}
