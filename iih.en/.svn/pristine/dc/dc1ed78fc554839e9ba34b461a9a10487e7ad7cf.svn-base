package iih.en.er.bp.erfstaiddocstation;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.bp.GetBannerDefBP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.bp.inouttransmgr.GetInOutTransMgrBaseBP;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.sc.pub.ScGroupControlUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUrgInOutTransMgrDtosForFstBannerBP {
	/**
	 * 急诊抢救医生站banner查询
	 * 
	 * @param selectConditions
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	public UrgInOutTransMgrDTO[] exec(String[] selectConditions, String inputValue) throws BizException {
		if(EnValidator.isEmpty(selectConditions) || EnValidator.isEmpty(inputValue))
			return null;
		//获取患者id
		String[] patIds = new GetBannerDefBP().getPatIdFromEntBanner(selectConditions, inputValue);
		if(EnValidator.isEmpty(patIds))
			return null;
		String[] entIds = getEntIds(patIds);
		if(EnValidator.isEmpty(entIds))
			return null;
		return new GetInOutTransMgrBaseBP().exec(entIds);
	}
	/**
	 * 获取就诊id
	 * 
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	private String[] getEntIds(String[] patIds) throws BizException {
		SqlParam sqlParam = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.ID_ENT ");
		sqlBuilder.append(" FROM EN_ENT EN  ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER ER ON EN.ID_ENT = ER.ID_ENT  ");
		sqlBuilder.append(" INNER JOIN EN_ERPRE ERPRE ON EN.ID_ENT = ERPRE.ID_ENT_LAST  ");
		sqlBuilder.append(" WHERE EN.FG_CANC = 'N' ");
		String[] codeEntps = EnParamUtils.getErTpNoComm();
		if(codeEntps.length == 1){
			sqlBuilder.append(" AND EN.CODE_ENTP = ? ");
			sqlParam.addParam(codeEntps[0]);
		}else{
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("EN.CODE_ENTP", codeEntps));
		}
		if(patIds.length == 1){
			sqlBuilder.append(" AND EN.ID_PAT = ? ");
			sqlParam.addParam(patIds[0]);
		}else{
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("EN.ID_PAT", patIds));
		}
		String OrgWhere = ScGroupControlUtils.getGroupControlFitler(new PatiVisitDODesc(), "EN");
		if (!EnValidator.isEmpty(OrgWhere)) {
			sqlBuilder.append(" AND ").append(OrgWhere);
		}
		sqlBuilder.append(" AND EN.ID_DEP_PHY = ? ");
		sqlParam.addParam(EnContextUtils.getDeptId());
		sqlBuilder.append(" AND (ERPRE.SD_STATUS = ? OR (ERPRE.SD_STATUS = ? AND ERPRE.DT_END >= ? )) ");
		sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
		sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_END);
		sqlParam.addParam(EnAppUtils.getServerDateTime().subSeconds(60 * 60 * EnParamUtils.getErLeaveListHours()));
		sqlBuilder.append(" UNION ");
		sqlBuilder.append(" SELECT EN.ID_ENT ");
		sqlBuilder.append(" FROM EN_ENT EN  ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT  ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER ER ON EN.ID_ENT = ER.ID_ENT  ");
		sqlBuilder.append(" INNER JOIN EN_ERPRE ERPRE ON EN.ID_ENT = ERPRE.ID_ENT_LAST  ");
		sqlBuilder.append(" WHERE EN.FG_CANC = 'N' ");
		sqlBuilder.append(" AND EN.CODE_ENTP = ? ");
		sqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW);
		if (!EnValidator.isEmpty(OrgWhere)) {
			sqlBuilder.append(" AND ").append(OrgWhere);
		}
		if(patIds.length == 1){
			sqlBuilder.append(" AND EN.ID_PAT = ? ");
			sqlParam.addParam(patIds[0]);
		}else{
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("EN.ID_PAT", patIds));
		}
		sqlBuilder.append(" AND EN.ID_DEP_PHY = ? ");
		sqlParam.addParam(EnContextUtils.getDeptId());
		sqlBuilder.append(" AND OP.DT_VALID_B <= ? ");
		sqlBuilder.append(" AND OP.DT_VALID_E >= ? ");
		FDateTime curTime = EnAppUtils.getAcptQryDateTime(EnAppUtils.getServerDate(), null);
		sqlParam.addParam(EnAppUtils.getAdvanceAcptTime(curTime));
		sqlParam.addParam(curTime);
		List<String> list = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), sqlParam, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[0]);
	}
}
