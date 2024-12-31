package iih.en.er.bp.erfstaiddocstation;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EuUrgInOutTransStatus;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取急诊抢救医生站列表数量
 * 
 * @author liubin
 *
 */
public class GetErFstaidPatCountsBP {
	/**
	 * 上下文key
	 * 
	 */
	private static final String KeyContextCodeEntps = "KeyContextCodeEntps";
	/**
	 * 获取急诊抢救医生站列表数量
	 * 
	 * @return
	 * @throws BizException
	 */
	public FMap exec() throws BizException {
		FMap map = new FMap();
		map.put(EuUrgInOutTransStatus.UNENTRY, getCount(EuUrgInOutTransStatus.UNENTRY));
		map.put(EuUrgInOutTransStatus.INDEP, getCount(EuUrgInOutTransStatus.INDEP));
		map.put(EuUrgInOutTransStatus.OUTDEP, getCount(EuUrgInOutTransStatus.OUTDEP));
		return map;
	}
	/**
	 * 
	 * 
	 * @param euUrgInOutTransStatus
	 * @return
	 * @throws BizException
	 */
	private int getCount(String euUrgInOutTransStatus) throws BizException{
		SqlParam sqlParam = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COUNT(1) ");
		sqlBuilder.append(" FROM EN_ENT EN  ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER ER ON EN.ID_ENT = ER.ID_ENT  ");
		sqlBuilder.append(" INNER JOIN EN_ERPRE ERPRE ON EN.ID_ENT = ERPRE.ID_ENT_LAST  ");
		sqlBuilder.append(" WHERE EN.FG_CANC = 'N' ");
		String[] codeEntps = getCodeEntps();
		if(codeEntps.length == 1){
			sqlBuilder.append(" AND EN.CODE_ENTP = ? ");
			sqlParam.addParam(codeEntps[0]);
		}else{
			sqlBuilder.append(" AND ").append(EnSqlUtils.getInSqlByIds("EN.CODE_ENTP", codeEntps));
		}
		String OrgWhere = ScGroupControlUtils.getGroupControlFitler(new PatiVisitDODesc(), "EN");
		if (!EnValidator.isEmpty(OrgWhere)) {
			sqlBuilder.append(" AND ").append(OrgWhere);
		}
		sqlBuilder.append(" AND EN.ID_DEP_PHY = ? ");
		sqlParam.addParam(EnContextUtils.getDeptId());
		if(EuUrgInOutTransStatus.UNENTRY.equals(euUrgInOutTransStatus)){
			sqlBuilder.append(" AND (ERPRE.SD_STATUS = ? AND NVL(ER.ID_BED,'~') = '~') ");
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
		}else if(EuUrgInOutTransStatus.INDEP.equals(euUrgInOutTransStatus)){
			sqlBuilder.append(" AND (ERPRE.SD_STATUS = ? AND NVL(ER.ID_BED,'~') <> '~') ");
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
		}else if(EuUrgInOutTransStatus.OUTDEP.equals(euUrgInOutTransStatus)){
			sqlBuilder.append(" AND (ERPRE.SD_STATUS = ? AND ERPRE.DT_END >= ? ) ");
			sqlParam.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_END);
			sqlParam.addParam(EnAppUtils.getServerDateTime().subSeconds(60 * 60 * EnParamUtils.getErLeaveListHours()));
		}else{
			return 0;
		}
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), sqlParam, new ColumnHandler());
		return count != null ? count : 0;
	}
	/**
	 * 获取就诊类型
	 * 
	 * @return
	 * @throws BizException
	 */
	private String[] getCodeEntps() throws BizException{
		if(Context.get().getAttribute(KeyContextCodeEntps) != null)
			return (String[]) Context.get().getAttribute(KeyContextCodeEntps);
		String[] codeEntps = EnParamUtils.getErTpNoComm();
		Context.get().setAttribute(KeyContextCodeEntps, codeEntps);
		return codeEntps;
	}
}
