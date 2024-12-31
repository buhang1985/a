package iih.pi.banner.i;

import iih.pi.banner.d.PatientBannerDTO;
import xap.mw.core.data.BizException;

public interface IBannerExtService {

	/**
	 * 卡录入
	 * @param dto
	 * @throws BizException
	 */
	public abstract PatientBannerDTO[] GetPatientBannerDTOS(String Keys) throws BizException;
	
}
