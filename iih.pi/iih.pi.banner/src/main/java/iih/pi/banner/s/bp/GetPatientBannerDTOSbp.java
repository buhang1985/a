package iih.pi.banner.s.bp;

import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.banner.s.bp.qry.GetPatientBannerDTOSSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetPatientBannerDTOSbp {

	/*
	 * 患者Banner查询主入口
	 * */
	public PatientBannerDTO[] exec(String Keys) throws BizException
	{
		GetPatientBannerDTOSSql Sql=new GetPatientBannerDTOSSql(Keys);
		
		return (PatientBannerDTO[])AppFwUtil.getDORstWithDao(Sql, PatientBannerDTO.class);
	}
}

