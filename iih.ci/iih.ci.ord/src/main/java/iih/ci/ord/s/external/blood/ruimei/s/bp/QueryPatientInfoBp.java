package iih.ci.ord.s.external.blood.ruimei.s.bp;

import iih.ci.ord.external.blood.ruimei.d.DepCondition;
import iih.ci.ord.external.blood.ruimei.d.PatIpcodeParam;
import iih.ci.ord.external.blood.ruimei.d.PatcodeParam;
import iih.ci.ord.external.blood.ruimei.d.Patientinfo;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class QueryPatientInfoBp {
	
	public Patientinfo[] exec(DepCondition param, PatcodeParam patcodeParam, PatIpcodeParam ipcodeParam) throws BizException {

		// 1.查询数据
		Patientinfo[] rtnDatas = queryPatientData(param, patcodeParam, ipcodeParam);

		return rtnDatas;
	}

	/**
	 * 查询数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private Patientinfo[] queryPatientData(DepCondition param, PatcodeParam patcodeParam, PatIpcodeParam ipcodeParam) throws BizException {
		Patientinfo[] patientinfos = null;
		if (param != null) {
			QueryPatientDataSql sql = new QueryPatientDataSql(param.getDeptcode(), param.getNurcode(), param.getDate_b_in(), param.getDate_e_in(), param.getDate_b_out(), param.getDate_e_out(), param.getIpstatus());
			patientinfos = (Patientinfo[]) AppFwUtil.getDORstWithDao(sql, Patientinfo.class);
		}
		return patientinfos;
	}

}
