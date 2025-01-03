package iih.ci.sdk.price;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.ci.sdk.utils.CiOrSrvPriHelper;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 折扣价计算
 * @author wangqingzhu
 *
 */
public class CiOrBdSrvPricesCalByPriModeBP {
	public MedSrvPriceDO exec(BdSrvPriCalParamDTO param, String id_pripat) 
			throws BizException{
		IPriCalService iPriCalService = ServiceFinder.find(IPriCalService.class);
		MedSrvPriceDO mspDO = new MedSrvPriceDO();
		if (iPriCalService != null && CiOrSrvPriHelper.isSrvSelfPrimd(param.getId_primd())) {
			SrvPricalRateAndPriceDTO sprapDTO = iPriCalService.CalSingleSrvPriceByIdPripat_NameTip(param.getId_srv(), param.getName_srv(), id_pripat);
			mspDO.setId_srv(param.getId_srv());
			mspDO.setSrv_name(param.getName_srv());
			mspDO.setPrice_ratio(sprapDTO.getPrice_ratio());
			mspDO.setPrice_std(sprapDTO.getPrice());
		} else {
			CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
			mspDO = bp.exec(param, id_pripat);
		}

		return mspDO;
	}
}
