package iih.pi.banner.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.data.BizException;
import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.banner.i.IBannerExtService;
import iih.pi.banner.s.bp.GetPatientBannerDTOSbp;

@Service(serviceInterfaces={IBannerExtService.class}, binding=Binding.JSONRPC)
public class IBannerExtServiceImpl implements IBannerExtService {
	/*
	 * 查询患者Banner
	 * */
	@Override
	public PatientBannerDTO[] GetPatientBannerDTOS(String Keys) throws BizException {
		
		GetPatientBannerDTOSbp bp=new GetPatientBannerDTOSbp();
		 
		return bp.exec(Keys);
	}

}