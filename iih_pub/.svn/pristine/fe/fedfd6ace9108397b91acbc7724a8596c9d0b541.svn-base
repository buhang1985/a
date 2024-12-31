package iih.bl.itf.std;

import iih.bl.itf.std.d.ipchargeqry.BlTotalCostInfoDTO;
import iih.bl.itf.std.d.ipchargeqry.BlPrepaymentRecordDTO;
import iih.bl.itf.std.d.ipchargeqry.BlPrepaymentBalanceDTO;
import iih.bl.itf.std.d.ipchargeqry.BlPatDayListDTO;

import xap.mw.core.data.BizException;

public interface IBlIpChargeQryExternalService {
	
	/**
	 * 费用查询功能
	 * 
	 * @param patCode 患者编码
	 * @param times 就诊次数
	 * @return
	 * @throws BizException
	 */
	public abstract BlTotalCostInfoDTO[] getTotalCostInfo(String patCode,Integer times) throws BizException;
	
	/**
	 * 预交金交费查询
	 * 
	 * @param patCode 患者编码
	 * @param times 就诊次数
	 * @return
	 * @throws BizException
	 */
	public abstract BlPrepaymentRecordDTO[] getPrepaymentRecord(String patCode,Integer times) throws BizException;
	
	/**
	 * 预交金余额查询
	 * 
	 * @param patCode 患者编码
	 * @param times 就诊次数
	 * @return
	 * @throws BizException
	 */
	public abstract BlPrepaymentBalanceDTO[] getPrepaymentBalace(String patCode,Integer times) throws BizException;
	
	/**
	 * 住院病人日清单
	 * 
	 * @param patCode 患者编码
	 * @param times 就诊次数
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	public abstract BlPatDayListDTO[] getPatDayList(String patCode,Integer times,String startDate, String endDate) throws BizException;

}
