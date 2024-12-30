package iih.sc.sch.s.bp;

import iih.bd.pp.primd.i.IPriCalService;
import iih.sc.sch.reg.dto.d.RelSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 加载标准价格BP
 * @author yank
 *
 */
public class LoadSrvStdPriceBP {
	/**
	 * 加载服务标准价格
	 * @param relSrvDTO
	 * @throws BizException
	 */
	public void exec(RelSrvDTO relSrvDTO) throws BizException{
		if(relSrvDTO==null)return;
		IPriCalService priCalService = ServiceFinder.find(IPriCalService.class);
		FDouble price = priCalService.CalSingleSrvStdPrice(relSrvDTO.getId_srv());
		relSrvDTO.setAmt_st(price);
		relSrvDTO.setAmt(price);
		relSrvDTO.setAmt_hp(FDouble.ZERO_DBL);//医保分摊为0
		relSrvDTO.setAmt_pat(price);
	}
}
