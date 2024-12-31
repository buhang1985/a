package iih.bd.pp.s.external.provide;

import iih.bd.pp.i.external.provide.IBdPpBlQryService;
import iih.bd.pp.i.external.provide.IBdPpBlService;
import iih.bd.pp.i.external.provide.meta.bl.DrugPriceInfo;
import iih.bd.pp.i.external.provide.meta.bl.TreatPriceInfo;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.s.external.provide.bp.FindCaItmRelBySrvBP;
import iih.bd.pp.s.external.provide.bp.FindDrugPriListBySearchTextBp;
import iih.bd.pp.s.external.provide.bp.FindTreatPriListBySearchTextBp;
import xap.mw.core.data.BizException;

/**
 * 提供给费用域服务
 * 
 * @author hao_wu 2018-6-12
 *
 */
public class BdPpBlServiceImpl implements IBdPpBlService, IBdPpBlQryService {

	@Override
	public DrugPriceInfo[] findDrugPriListByPyCode(String pyCode) throws BizException {
		FindDrugPriListBySearchTextBp bp = new FindDrugPriListBySearchTextBp();
		DrugPriceInfo[] result = bp.exec(pyCode);
		return result;
	}

	@Override
	public TreatPriceInfo[] findTreatPriListByPyCode(String pyCode) throws BizException {
		FindTreatPriListBySearchTextBp bp = new FindTreatPriListBySearchTextBp();
		TreatPriceInfo[] result = bp.exec(pyCode);
		return result;
	}
	
	/**
	 * 批量获取票据分类对照
	 * 
	 * @param sdIncca
	 *            票据分类编码
	 * @param srvIds
	 *            服务id数组
	 * @return 票据分类对照
	 * @throws BizException
	 * @author ly 2018/06/28
	 */
	@Override
	public IncCaItmRelDO[] findCaItmRelBySrv(String sdIncca, String[] srvIds) throws BizException{
		FindCaItmRelBySrvBP bp = new FindCaItmRelBySrvBP();
		return bp.exec(sdIncca, srvIds);
	}
}
