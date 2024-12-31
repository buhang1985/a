package iih.pis.ivx.apt.i;

import java.util.Map;

import iih.en.pv.appoint.bean.PatOpAptAndEntListParam;
import iih.en.pv.appoint.bean.PatOpAptListParam;
import iih.en.pv.appoint.bean.PatOpEntListParam;
import iih.en.pv.appoint.result.OEPDepListResult;
import iih.en.pv.appoint.result.PatOpAptAndEntListResult;
import iih.en.pv.appoint.result.PatOpAptListResult;
import iih.en.pv.appoint.result.PatOpEntListResult;
import iih.pis.ivx.apt.d.SchListBean;
import iih.pis.ivx.apt.d.SchListParam;
import xap.mw.core.data.BizException;

public interface IAptRService {
	
	public String getOEPEmpDepMatch() throws BizException;
	
	public OEPDepListResult[] getOEPDepList() throws BizException;
	
	/**
	 * 查询查询一段时间内指定科室的门诊排班
	 * @param deptCode
	 * @param beginDate
	 * @param endDate
	 * @return Object[] 门诊排班xml字符串信息、开始时间、结束时间
	 * @throws BizException
	 */
	public Map<String, Map<String, Map<String, SchListBean>>> getSchList(SchListParam schListParam) throws Exception;
	
	/**
	 * 查询指定患者指定时间段内的预约记录
	 * @param patCode
	 * @param beginDateStr
	 * @param endDateStr
	 * @return
	 * @throws BizException
	 */
	public PatOpAptListResult[] getPatOpAptList(PatOpAptListParam patOpAptListParam) throws BizException;
	
	/**
	 * 查询指定患者指定时间段内的挂号记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	//String getPatOpEntList(String params) throws BizException;
	public PatOpEntListResult[] getPatOpEntList(PatOpEntListParam patOpEntListParam) throws BizException;
	
	/**
	 * 查询指定患者指定时间段内的预约及挂号记录
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public PatOpAptAndEntListResult[] getPatOpAptAndEntList(PatOpAptAndEntListParam patOpAptAndEntListParam) throws BizException;
	
}
