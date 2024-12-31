package iih.ci.mb.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mb.i.ArrayOfDCNursingDocument;
import iih.ci.mb.i.DCNursingDocument;
import iih.ci.mb.i.GetNursingDocumentsOfPatientHRResponse;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatIpNmrListBP {

	/**
	 * @param patientID
	 * @param templateID
	 * @param reloadFlag
	 * @param times
	 * @return
	 * @throws BizException
	 */
	public GetNursingDocumentsOfPatientHRResponse exec(String patientID, String times) throws BizException {

		GetNursingDocumentsOfPatientHRResponse rtn = new GetNursingDocumentsOfPatientHRResponse();

		// 1.参数校验
		if (!validate(patientID, times)) {
			return rtn;
		}

		// 2.不同的模板走不同的保存逻辑
		DCNursingDocument[] dcNursingDocuments = getPatNmrList(patientID, times);
		// 3.封装返回数据
		wrapResponse(rtn, dcNursingDocuments);

		return rtn;
	}

	/**
	 * @param rtn
	 * @param dcNursingDocuments
	 */
	private void wrapResponse(GetNursingDocumentsOfPatientHRResponse rtn, DCNursingDocument[] dcNursingDocuments) {
		ArrayOfDCNursingDocument arrayOfDCNursingDocument = new ArrayOfDCNursingDocument();

		List<DCNursingDocument> results = new ArrayList<>();
		if (dcNursingDocuments != null && dcNursingDocuments.length > 0) {
			for (DCNursingDocument dcND : dcNursingDocuments) {
				DCNursingDocument existsGroup = null;
				for (DCNursingDocument doc : results) {
					if (doc.getGroupKey() == dcND.getGroupKey()) {
						existsGroup = doc;
						break;
					}
				}
				if (existsGroup == null) {
					existsGroup = new DCNursingDocument();
					existsGroup.setTitle(dcND.getTitle());
					existsGroup.setGroupKey(dcND.getGroupKey());

					results.add(existsGroup);
				}
				ArrayOfDCNursingDocument arrayOfDCNursingDocument2 = new ArrayOfDCNursingDocument();
				arrayOfDCNursingDocument2.setDCNursingDocument(new DCNursingDocument[] { dcND });
				existsGroup.setSubNursingDocument(arrayOfDCNursingDocument2);

			}
		}

		arrayOfDCNursingDocument
				.setDCNursingDocument((DCNursingDocument[]) results.toArray(new DCNursingDocument[results.size()]));

		rtn.setGetNursingDocumentsOfPatientHRResult(arrayOfDCNursingDocument);
	}

	private DCNursingDocument[] getPatNmrList(String patId, String ipTimes) throws DAException {

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select mrset.ID_MRSET as ID,");
		sqlBuilder.append(" mrset.ID_ENT as PatientID,");
		sqlBuilder.append(" mrset.NAME as GroupKey,");
		sqlBuilder.append(" mrset.NAME as Title,");
		sqlBuilder.append("(sysset.value||'&'||'file='||sysp.PARAMVALUE||'&'||'id_ent='||mrset.ID_ENT) as Content");
		sqlBuilder.append(" FROM ci_mr_set mrset  ");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = mrset.ID_ENT,");
		sqlBuilder.append(" sys_funcreg sysfunc,");
		sqlBuilder.append(" sys_paramreg sysp,");
		sqlBuilder.append(" SYS_PARAMSET sysset");
		sqlBuilder.append(
				" where  IP.CODE_AMR_IP=? AND IP.TIMES_IP=? and sysfunc.code=mrset.FUN_CODE and sysfunc.ID_FUN=sysp.ID_PARENT and sysp.PARAMNAME='Nu_RptFile'");
		sqlBuilder.append(" and sysset.PARAMCODE='CIOR0280'");
		sqlBuilder.append(" ORDER BY mrset.DT_CREATE");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(ipTimes);
		List<DCNursingDocument> mrReportList = (List<DCNursingDocument>) new DAFacade().execQuery(sqlBuilder.toString(),
				param, new BeanListHandler(DCNursingDocument.class));
		if (!ListUtil.isEmpty(mrReportList)) {
			return mrReportList.toArray(new DCNursingDocument[0]);
		} else {
			return null;
		}
	}

	/**
	 * @param patientID
	 * @param templateID
	 * @param reloadFlag
	 * @param times
	 * @return
	 */
	private boolean validate(String patientID, String times) {

		if (StringUtil.isEmptyWithTrim(patientID)) {
			return false;
		}

		return true;
	}

}
