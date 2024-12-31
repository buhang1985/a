package iih.ci.mr.s.bp.task.bp.MrCheckUnFilnishedTaskBP;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSqlReviewTpbp {

	public static CiMrDO[]getReviewTp(String id_ent) throws BizException{
		StringBuilder sd = new StringBuilder();
		SqlParam sp = new SqlParam();
		sd.append(" select ci_mr.sd_su_mr, ci_mr.name ");
		sd.append(" from ci_mr ci_mr ");
		sd.append(" where ci_mr.id_ent = ? ");
		sp.addParam(id_ent);
		sd.append(" and ((ci_mr.sd_su_mr = '"+ICiMrDictCodeConst.SD_SU_MR_REJECT+"' and ci_mr.ds = '0') or ");
		sd.append(" (ci_mr.sd_su_mr = '"+ICiMrDictCodeConst.SD_SU_MR_RETRIEVE+"' and ci_mr.ds = '0') or ");
		sd.append(" (ci_mr.sd_su_mr = '"+ICiMrDictCodeConst.SD_SU_MR_NEW+"' and ci_mr.ds = '0') or ");
		sd.append(" (ci_mr.id_reviewtp in ");
		sd.append(" (select br.id_reviewtp ");
		sd.append(" from bd_reviewtp br ");
		sd.append(" where ci_mr.id_reviewtp = br.id_reviewtp ");
		sd.append(" and ci_mr.sd_su_mr != '"+ICiMrDictCodeConst.SD_SU_MR_COMPLETE+"' ");
		sd.append(" and br.code not in ('"+ICiMrDictCodeConst.SD_MRREVIEW_NONE+"', '"+ICiMrDictCodeConst.SD_MRREVIEW_ONELEVEL+"')))); ");
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiMrDO> listDto = (List<CiMrDO>) daf.execQuery(sd.toString(),sp,
				new BeanListHandler(CiMrDO.class));
		return listDto.toArray(new CiMrDO[0]);
	}
}
