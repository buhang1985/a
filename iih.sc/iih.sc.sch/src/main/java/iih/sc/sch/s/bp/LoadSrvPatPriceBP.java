package iih.sc.sch.s.bp;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.sc.sch.reg.dto.d.RelSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 加载服务患者价格
 * 根据患者价格分类计算
 * @author yank
 *
 */
public class LoadSrvPatPriceBP {
	/**
	 * 加载服务患者价格
	 * @param relSrvDTO 排班关联DTO
	 * @param priPatId 患者价格分类
	 * @throws BizException
	 */
	public void exec(RelSrvDTO relSrvDTO,String priPatId) throws BizException{
		if(relSrvDTO==null)return;
		IPriCalService priCalService = ServiceFinder.find(IPriCalService.class);
		SrvPricalRateAndPriceDTO priceDTO = priCalService.CalSingleSrvPriceByIdPripat_NameTip(relSrvDTO.getId_srv(),relSrvDTO.getName_srv(),priPatId);
		FDouble price_st = priceDTO.getPrice();
		FDouble price_pat = priceDTO.getRate()==null ? price_st : price_st.multiply(priceDTO.getRate());
		relSrvDTO.setAmt_st(price_st);
		relSrvDTO.setAmt(price_pat);
		relSrvDTO.setAmt_hp(FDouble.ZERO_DBL);//医保分担为0
		relSrvDTO.setAmt_pat(price_pat);
	}
}
