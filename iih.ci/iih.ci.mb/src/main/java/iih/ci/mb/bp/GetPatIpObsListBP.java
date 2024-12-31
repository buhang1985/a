package iih.ci.mb.bp;

import java.util.List;

import iih.bd.utils.ContextUtils;
import iih.bd.utils.BdEnvContextUtil;
import iih.bd.utils.ParamUtils;
import iih.ci.mb.bp.qry.GetPatCodeInfoSql;
import iih.ci.mb.bp.qry.GetPatOrderInfoSql;
import iih.ci.mb.i.DCDoctorAdvice;
import iih.ci.mb.i.DCPatientHospitalRecord;
import iih.ci.mb.i.GetCheckUrlOfPatientHRResponse;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mp.mb.i.GetPatientInfoByPIDRequest;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者住院检查列表
 * 
 * @author yankan
 * @since 2018-03-15
 *
 */
public class GetPatIpObsListBP {
	/**
	 * 检查系统URL参数
	 */
	private static final String PARAM_OBS_REMOTE = "CIOR0275";
	/**
	 * 地址格式串
	 */
	private static final String URL_FORMATER = "%s?&pid=%s&XExternalUrlFlag=1&os=UIS,RIS,EIS,PIS";

	/**
	 * 获取患者住院检查列表
	 * 
	 * @param patId
	 *            患者ID
	 * @param ipTimes
	 *            住院次数
	 * @return 检查集合
	 * @throws BizException
	 * @author yankan
	 */
	public GetCheckUrlOfPatientHRResponse exec(String patId, String ipTimes) throws BizException {
		String url = ParamUtils.GetOrgParamStringValue(ContextUtils.getOrgId(), PARAM_OBS_REMOTE);
		// String url = "http://192.168.90.29:8080/ReportView/web/index.action";
		// 通过code_amr_ip获取病人pi_pat中的'H'+code (pacs用)
		List<DCPatientHospitalRecord> patRecords = GetPiCode(patId);
		if (patRecords.size() > 0) {
			String fullUrl = String.format(URL_FORMATER, url, patRecords.get(0).getHID());

			GetCheckUrlOfPatientHRResponse response = new GetCheckUrlOfPatientHRResponse();
			response.setGetCheckUrlOfPatientHRResult(fullUrl);
			return response;
		} else
			return null;
	}

	private List<DCPatientHospitalRecord> GetPiCode(String patId) throws DAException {
		GetPatCodeInfoSql sql = new GetPatCodeInfoSql(patId);
		return (List<DCPatientHospitalRecord>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null),
				new BeanListHandler(DCPatientHospitalRecord.class));
	}

}
