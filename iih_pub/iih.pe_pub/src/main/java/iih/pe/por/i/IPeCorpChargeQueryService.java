package iih.pe.por.i;

import iih.pe.por.dto.pecorpchargedto.d.PeCorpChargeDTO;
import iih.pe.por.dto.pecorpchargedto.d.PeCorpChargeItmDTO;
import iih.pe.por.dto.pecorpchargedto.d.PeCorpChargeSumDTO;
import xap.mw.core.data.BizException;

public interface IPeCorpChargeQueryService {
    /// <summary>
    /// 查询体检团体费用
    /// </summary>
    /// <param name="id_pecorpappt"></param>
    /// <returns></returns>
	public PeCorpChargeDTO[] findPeCorpCharge(String id_pecorpappt, String id_pecorpcharge, String fg_chargesum,
			String dt_pe_begin, String dt_pe_end) throws BizException;

	/*
	 * 汇总
	 */
	public PeCorpChargeSumDTO[] findPeCorpChargeSum(String id_pecorpappt, String id_pecorpcharge, String fg_chargesum,
			String dt_pe_begin, String dt_pe_end) throws BizException;

	/*
	 * 明细
	 */
	public PeCorpChargeItmDTO[] findPeCorpChargeItm(String id_pecorpappt, String id_pecorpcharge, String fg_chargesum,
			String dt_pe_begin, String dt_pe_end) throws BizException;

}
