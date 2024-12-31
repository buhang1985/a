package iih.ei.std.s.v1;

import iih.ei.std.d.v1.hr.depscheddata.d.DepSchedInParamDTO;
import iih.ei.std.d.v1.hr.depscheddata.d.WeekSchedInfoResultDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.AllSiInParamDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.DepSiInParamDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.SchedSiInfoResultDTO;
import iih.ei.std.i.v1.IHrApiService;
import iih.ei.std.s.v1.bp.hr.DepSchedBp;
import iih.ei.std.s.v1.bp.hr.GetAllSchedSiInfoBp;
import iih.ei.std.s.v1.bp.hr.GetDepSchedDataBp;
import iih.ei.std.s.v1.bp.hr.GetDepSchedSiInfoBp;
import xap.mw.core.data.BizException;

/**
 * 
 * @ClassName: IHrApiService
 * @Description: IIH人力管理域标准对外接口
 * @author lijm
 * @date 2020年3月23日
 *
 */
public class IHrApiServiceImpl implements IHrApiService {

	/**
	 * 获取全院排班班次信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchedSiInfoResultDTO getAllSchedSiInfo(AllSiInParamDTO param) throws BizException {
		return (new GetAllSchedSiInfoBp()).exec(param);
	}

	/**
	 * 获取科室排班班次信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchedSiInfoResultDTO getDepSchedSiInfo(DepSiInParamDTO param) throws BizException {
		return (new GetDepSchedSiInfoBp()).exec(param);
	}

	/**
	 * 获取科室排班信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public WeekSchedInfoResultDTO getDepSchedData(DepSchedInParamDTO param) throws BizException {
		return (new GetDepSchedDataBp()).exec(param);
	}

	/**
	 * 科室排班
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public WeekSchedInfoResultDTO depSched(WeekSchedInfoResultDTO param) throws BizException {
		return (new DepSchedBp()).exec(param);
	}

}
