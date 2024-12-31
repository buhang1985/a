package iih.en.que.s.bp.mt;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtTriageSiteBP {
	/**
	 * 得到工作站
	 * 
	 * @param triageInfo
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	public List<TriageQueSiteDTO> getSiteInfo(TriageBenInfoDTO triageInfo) throws BizException{
		StringBuilder sb  = new StringBuilder();
		sb.append("SELECT BD_QUE_SITE.ID_QUESITE AS ID_QUESITE,");
		sb.append("BD_QUE_SITE.NAME AS NAME_QUESITE,");
		sb.append("BD_QUE_SITE.ID_QUE AS ID_QUE,");
		sb.append("BD_QUE_SITE.ID_QUEBEN  AS ID_BEN,");
		sb.append("BD_QUE_SITE.ID_DEP AS ID_DEP,");
		sb.append("BD_QUE_SITE.ID_EMP AS ID_EMP,");
		sb.append("BD_PSNDOC.NAME AS EMP_NAME,");
		sb.append("BQ.SD_MODE, ");
		sb.append("BQ.NAME AS NAME_QUE, ");
		sb.append("BD_QUE_SITE.APPLY_MAX, ");
		sb.append("BD_QUE_SITE.EU_PAUSE AS EU_PAUSE ");
		sb.append("FROM BD_QUE_SITE BD_QUE_SITE ");
		sb.append("LEFT JOIN BD_QUE BQ ON BD_QUE_SITE.ID_QUE = BQ.ID_QUE ");
		sb.append("LEFT JOIN BD_PSNDOC BD_PSNDOC ON BD_QUE_SITE.ID_EMP = BD_PSNDOC.ID_PSNDOC ");
		sb.append("WHERE BD_QUE_SITE.ID_QUEBEN = ? ");
		sb.append("AND BD_QUE_SITE.SD_QUESITETP = ? ");
		sb.append("AND BD_QUE_SITE.FG_ACTIVE = ? ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(triageInfo.getId_queben());
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_UNIVERSAL);
		param.addParam(FBoolean.TRUE);
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		return list;
	}
}
