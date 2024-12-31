package iih.ci.ord.s.external.provide;

import iih.ci.ord.i.external.provide.ICiOrdMpNrService;
import iih.ci.ord.s.external.provide.bp.mpnr.CiOrPharmOrRefoundBedMarginUpdateBP;
import xap.mw.core.data.BizException;

/**
 * 临床提供给护理执行域的对外接口
 * 
 * @author HUMS
 *
 */
public class CiOrdMpNrServiceImpl implements ICiOrdMpNrService{

	/**
	 * 扣减床旁余量 
	 */
	@Override
	public String reductionBedQuan(String[] id_ors) throws BizException {

		CiOrPharmOrRefoundBedMarginUpdateBP bp = new CiOrPharmOrRefoundBedMarginUpdateBP();

		return bp.exec(id_ors,"-");
	}

	/**
	 * 执行取消回退床旁余量
	 */
	@Override
	public String refoundBedQuan(String[] id_ors) throws BizException {

		CiOrPharmOrRefoundBedMarginUpdateBP bp = new CiOrPharmOrRefoundBedMarginUpdateBP();

		return bp.exec(id_ors,"+");
	}

}
