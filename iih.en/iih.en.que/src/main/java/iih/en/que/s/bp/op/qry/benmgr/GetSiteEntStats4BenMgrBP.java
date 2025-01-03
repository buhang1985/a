package iih.en.que.s.bp.op.qry.benmgr;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门急诊医生站候诊，已诊，待回诊，未分诊数量
 * 
 * @author liubin
 *
 */
public class GetSiteEntStats4BenMgrBP {
	//挂号
	private static final String KEY_REG = "REG";
	//候诊
	private static final String KEY_WAIT = "WAIT";
	//已诊
	private static final String KEY_ACPT = "ACPT";
	//待回诊
	private static final String KEY_NEEDRTN = "NEEDRTN";
	
	/**
	 * 获取门急诊医生站候诊，已诊，待回诊，未分诊数量
	 * 
	 * @param queId 队列id
	 * @param siteId 站点id
	 * @param date 日期
	 * @param dayslotId 日期分组id
	 * @return key: 挂号REG,已诊ACPT,候诊WAIT；value为相应的数量
	 * @throws BizException
	 */
	public FMap getSiteEntStats(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate().asBegin());
		String[] queIds = null;
		if(EnParamUtils.isBenQueMgr())
			queIds = new GetQue4BenMgrBP().getQueIdsBySiteId(siteInfo);
		else{
			if(!EnValidator.isEmpty(siteInfo.getId_ques()))
				queIds = new String[]{(String)siteInfo.getId_ques().get(0)};
		}
		FMap map = new FMap();
		//未分诊
		map.put(KEY_REG, getRegCount(queIds, siteInfo));
		//候诊
		map.put(KEY_WAIT, getWaitCount(queIds, siteInfo));
		//已诊
		map.put(KEY_ACPT, getAcptCount(siteInfo, FBoolean.FALSE));
		//待回诊
		if(isDepShare()){
			map.put(KEY_NEEDRTN, getNeedRtnCountbyShare(siteInfo));
		}else{
			map.put(KEY_NEEDRTN, getAcptCount(siteInfo, FBoolean.TRUE));
		}
		return map;
	}
	/**
	 * 获取未分诊数量
	 * 
	 * @param queIds
	 * @param siteInfo
	 * @return
	 * @throws BizException
	 */
	private int getRegCount(String[] queIds, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(EnValidator.isEmpty(queIds))
			return 0;
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT COUNT(1) ");
		sqlBuilder.append(" FROM EN_ENT_QUE EQ ");
		sqlBuilder.append(" INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		sqlBuilder.append(" INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		sqlBuilder.append(" WHERE EQ.SD_ENTQUE_TP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		sqlBuilder.append(" AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		sqlBuilder.append(" AND EQ.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append(" AND EQ.DT_REGIST = ? ");
		param.addParam(siteInfo.getDate());
		sqlBuilder.append(" AND EQ.ID_DATESLOT = ? ");
		param.addParam(siteInfo.getId_dayslot());
		if(queIds.length > 1){
			sqlBuilder.append(EnSqlUtils.getInSqlByIds(" AND EQ.ID_QUE ", queIds));
		}else{
			sqlBuilder.append(" AND EQ.ID_QUE = ? ");
			param.addParam(queIds[0]);
		}
		sqlBuilder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		sqlBuilder.append(" AND (EQ.SD_STATUS_ACPT = ? OR (EQ.SD_STATUS_ACPT = ? AND ISNULL(EQ.ID_QUE_SITE,'~') = '~' AND BQ.SD_MODE = ? ))");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE);
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return count == null ? 0 : count;
	}
	/**
	 * 获取候诊数量
	 * 
	 * @param queIds
	 * @param siteInfo
	 * @return
	 * @throws BizException
	 */
	public int getWaitCount(String[] queIds, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		if(EnValidator.isEmpty(queIds))
			return 0;
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT COUNT(1) ");
		sqlBuilder.append(" FROM EN_ENT_QUE EQ ");
		sqlBuilder.append(" INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		sqlBuilder.append(" INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		sqlBuilder.append(" WHERE EQ.SD_ENTQUE_TP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		sqlBuilder.append(" AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		sqlBuilder.append(" AND EQ.FG_ACTIVE = ? ");
		param.addParam(FBoolean.TRUE);
		sqlBuilder.append(" AND EQ.DT_REGIST = ? ");
		param.addParam(siteInfo.getDate());
		sqlBuilder.append(" AND EQ.ID_DATESLOT = ? ");
		param.addParam(siteInfo.getId_dayslot());
		if(queIds.length > 1){
			sqlBuilder.append(EnSqlUtils.getInSqlByIds(" AND EQ.ID_QUE ", queIds));
		}else{
			sqlBuilder.append(" AND EQ.ID_QUE = ? ");
			param.addParam(queIds[0]);
		}
		sqlBuilder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		if(EnParamUtils.getIncludeOverNumberPat(EnContextUtils.getDeptId())){
			sqlBuilder.append(" AND ((EQ.SD_STATUS_ACPT IN (?,?) AND EQ.ID_QUE_SITE = ?) OR (EQ.SD_STATUS_ACPT=? AND (EQ.ID_QUE_SITE = ? OR (ISNULL(EQ.ID_QUE_SITE,'~')='~' AND BQ.SD_MODE = ? )))) ");
		}else{
			sqlBuilder.append(" AND ((EQ.SD_STATUS_ACPT = ? AND EQ.ID_QUE_SITE = ?) OR (EQ.SD_STATUS_ACPT=? AND (EQ.ID_QUE_SITE = ? OR (ISNULL(EQ.ID_QUE_SITE,'~')='~' AND BQ.SD_MODE = ? )))) ");
		}
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		if(EnParamUtils.getIncludeOverNumberPat(EnContextUtils.getDeptId())){
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		}
		param.addParam(siteInfo.getId_quesite());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(siteInfo.getId_quesite());
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return count == null ? 0 : count;
	}
	/**
	 * 获取已诊数量
	 * 
	 * @param empId
	 * @param siteInfo
	 * @return
	 * @throws BizException 
	 */
	private int getAcptCount(EnTrDocSiteInfoDTO siteInfo, FBoolean isNeedRtn) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT COUNT(DISTINCT EN.ID_ENT) ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_EMP EMP ON EN.ID_ENT = EMP.ID_ENT ");
	    builder.append("INNER JOIN EN_ENT_QUE EQ ON EN.ID_ENT = EQ.ID_ENT ");
		builder.append("WHERE EMP.ID_EMP = ? ");
		builder.append("AND OP.FG_NEEDRTN = ? ");
		builder.append("AND EMP.DT_B >= to_char(sysdate,'yyyy-mm-dd') ");
		builder.append("AND EN.FG_ACPTVALID = ? "); 
		builder.append("AND EN.FG_CANC = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		builder.append(" AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		param.addParam(siteInfo.getId_emp());
		param.addParam(isNeedRtn);
		//param.addParam(siteInfo.getDate());
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.FALSE);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		Integer count = (Integer) new DAFacade().execQuery(builder.toString(), param, new ColumnHandler());
		return count == null ? 0 : count;
	}
	/**
	 * 获取待回诊数量（科室共享）
	 * 
	 * @param siteInfo 
	 * @return
	 * @throws BizException 
	 */
	private int getNeedRtnCountbyShare(EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT COUNT(DISTINCT EN.ID_ENT) ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
	    builder.append("INNER JOIN EN_ENT_QUE EQ ON EN.ID_ENT = EQ.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_EMP EMP ON EN.ID_ENT = EMP.ID_ENT ");	
		builder.append("WHERE EN.Id_Dep_Phy = ? ");
		builder.append("AND OP.FG_NEEDRTN = ? ");
		//builder.append("AND EN.Dt_Entry >= ? ");
		//builder.append("AND EN.Dt_Entry < ? "); 
		builder.append("AND EMP.DT_B >= to_char(sysdate,'yyyy-mm-dd') ");
		builder.append("AND EN.FG_ACPTVALID = ? ");
		builder.append("AND EN.FG_CANC = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "EN") + " ");
		builder.append(" AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		String sql = builder.toString();
		param.addParam(siteInfo.getId_dep());
		param.addParam(FBoolean.TRUE);
		//param.addParam(siteInfo.getDate());
		//param.addParam(siteInfo.getDate().getDateAfter(1));
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.FALSE);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		Integer count = (Integer) new DAFacade().execQuery(builder.toString(), param, new ColumnHandler());
		return count == null ? 0 : count;
	}
	/**
	 * 是否科室共享回诊患者
	 * 
	 * @return
	 */
	private static boolean isDepShare() throws BizException{
		return 1 == EnParamUtils.getPatListShareRet();
	}
}
