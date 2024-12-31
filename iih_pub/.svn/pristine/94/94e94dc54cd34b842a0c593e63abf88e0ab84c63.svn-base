package iih.ei.std.i.v1;

import iih.ei.std.d.v1.hr.depscheddata.d.DepSchedInParamDTO;
import iih.ei.std.d.v1.hr.depscheddata.d.WeekSchedInfoResultDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.AllSiInParamDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.DepSiInParamDTO;
import iih.ei.std.d.v1.hr.schedsiinfodto.d.SchedSiInfoResultDTO;
import xap.mw.core.data.BizException;

/**
 * 
 * @ClassName: IHrApiService
 * @Description: IIH人力管理域标准对外接口
 * @author lijm
 * @date 2020年3月23日
 *
 */
public interface IHrApiService {
	/**
	 * 获取全院排班班次信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public SchedSiInfoResultDTO getAllSchedSiInfo(AllSiInParamDTO param) throws BizException;
	/**
	 * 获取科室排班班次信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public SchedSiInfoResultDTO getDepSchedSiInfo(DepSiInParamDTO param) throws BizException;
	/**
	 * 获取科室排班信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WeekSchedInfoResultDTO getDepSchedData(DepSchedInParamDTO param) throws BizException;
	/**
	 * 科室排班
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public WeekSchedInfoResultDTO depSched(WeekSchedInfoResultDTO param) throws BizException;

}
