package iih.en.que.s.bp.mt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageQueSiteDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取通用分诊站点列表数据
 * @author fanlq
 * @date: 2020年1月6日 下午3:15:24
 */
public class GetTriageQueSiteBP {

	public TriageQueSiteDTO[] exec(String benId,String dayslotId) throws BizException{
		if(EnValidator.isEmpty(dayslotId) || EnValidator.isEmpty(benId))
			return null;
		FDate date = EnAppUtils.getServerDate();
		TriageQueSiteDTO[] quesites = getQueSiteInfos(date, dayslotId, benId);
		if(EnValidator.isEmpty(quesites))
			return null;
		Set<String> queIdSet  = new HashSet<String>();
		Set<String> siteIdSet  = new HashSet<String>();
		this.filterId(quesites, queIdSet, siteIdSet);
		//获取站点候诊数量
		Map<String, Integer> siteWaitNumMap = getSiteWaitNumMap(siteIdSet.toArray(new String[0]), date, dayslotId);
		//获取站点已检查数量
		Map<String, Integer> checkedNumMap = getCheckedNumMap(siteIdSet.toArray(new String[0]), date, dayslotId);
		this.setTriageNum(quesites, siteWaitNumMap,checkedNumMap);
		return quesites;
	}
	/**
	 * 组装未分诊，已分诊和候诊数量
	 * 
	 * @param quesites
	 * @param noTriageNumMap
	 * @param triageNumMap
	 * @param siteWaitNumMap
	 */
	private void setTriageNum(TriageQueSiteDTO[] quesites,Map<String, Integer> siteWaitNumMap,Map<String, Integer> checkedNumMap) {
		for (TriageQueSiteDTO quesite : quesites) {
			String key = quesite.getId_que();
			key = quesite.getId_que() + quesite.getId_quesite();
			quesite.setWaitnum(siteWaitNumMap.containsKey(key) ? siteWaitNumMap.get(key) : 0);
			quesite.setCheckednum(checkedNumMap.containsKey(key) ? checkedNumMap.get(key) : 0);
		}
	}
	/**
	 * 获取队列已检查数量
	 * 
	 * @return
	 * @throws BizException 
	 */
	private Map<String, Integer> getCheckedNumMap(String[] siteIds,FDate date,String dayslotId) throws BizException{
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EQ.ID_QUE_SITE AS ID_QUESITE,");
		builder.append("COUNT(EQ.ID_ENT_QUE) AS CHECKEDNUM ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT in (?,?) ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND " + EnSqlUtils.getInSqlByIds("EQ.ID_QUE_SITE", siteIds));
		builder.append("GROUP BY EQ.ID_QUE_SITE ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CHECKED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_FINCHECKED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			for(TriageQueSiteDTO quesite : list)
				map.put(quesite.getId_quesite(), quesite.getCheckednum());
		}
		return map;
	}
	/**
	 * 获取站点候诊数量
	 * 
	 * @return
	 * @throws BizException 
	 */
	private Map<String, Integer> getSiteWaitNumMap(String[] siteIds, FDate date,String dayslotId) throws BizException{
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EQ.ID_QUE_SITE AS ID_QUESITE,");
		builder.append("EQ.ID_QUE AS ID_QUE,");
		builder.append("COUNT(EQ.ID_ENT_QUE) AS WAITNUM ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT NOT IN (?, ?) ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND " + EnSqlUtils.getInSqlByIds("EQ.ID_QUE_SITE", siteIds));
		builder.append("GROUP BY EQ.ID_QUE_SITE, EQ.ID_QUE ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			for(TriageQueSiteDTO quesite : list)
				map.put(quesite.getId_que() + quesite.getId_quesite(), quesite.getWaitnum());
		}
		return map;
	}
	/**
	 * 过略队列id和站点id
	 * 
	 * @param quesites
	 * @param queIdSet
	 * @param siteIdSet
	 */
	private void filterId(TriageQueSiteDTO[] quesites, Set<String> queIdSet, Set<String> siteIdSet){
		for(TriageQueSiteDTO quesite : quesites){
			queIdSet.add(quesite.getId_que());
			siteIdSet.add(quesite.getId_quesite());
		}
	}
	/**
	 * 获取分诊台在线的站点信息
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	private TriageQueSiteDTO[] getQueSiteInfos(FDate date, String dayslotId, String benId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT BS.ID_QUESITE AS ID_QUESITE,");
		builder.append("BS.NAME AS NAME_QUESITE,");
		builder.append("BS.EU_PAUSE AS SITESTATUS,");
		builder.append("BQ.ID_QUE AS ID_QUE,");
		builder.append("BQ.NAME AS NAME_QUE,");
		builder.append("BEN.ID_QUEBEN AS ID_BEN,");
		builder.append("BEN.NAME AS NAME_BEN,");
		builder.append("DEP.ID_DEP AS ID_DEP,");
		builder.append("DEP.NAME AS NAME_DEP,");
		builder.append("EMP.ID_PSNDOC AS ID_EMP,");
		builder.append("EMP.NAME AS EMP_NAME,");
		builder.append("BS.FG_PAUSE AS FG_PAUSE,");
		builder.append("BS.EU_PAUSE AS EU_PAUSE,");
		builder.append("SCH.ID_SCH AS ID_SCH,");
		builder.append(" ? AS ID_DAYSLOT,");
		builder.append("(CASE WHEN PLSRV.ID_SCSRV IS NULL THEN BQSRV.ID_SCSRV ELSE PLSRV.ID_SCSRV END) AS ID_SCSRV,");
		builder.append("(CASE WHEN PLSRV.ID_SCSRV IS NULL THEN BQSRV.NAME ELSE PLSRV.NAME END) AS SCSRV_NAME,");
		builder.append("(CASE WHEN PLSRV.ID_SCSRV IS NULL THEN BQSRV.SD_SRVTP ELSE PLSRV.SD_SRVTP END) AS SD_SRVTP ");
		builder.append("FROM BD_QUE_SITE BS ");
		builder.append("INNER JOIN BD_QUE BQ ON BS.ID_QUE = BQ.ID_QUE ");
		builder.append("INNER JOIN BD_QUE_BEN BEN ON BQ.ID_QUEBEN = BEN.ID_QUEBEN ");
		builder.append("LEFT JOIN SC_PL SCPL ON BQ.ID_DEP = SCPL.ID_DEP AND BQ.ID_SCRES = SCPL.ID_SCRES AND BQ.ID_QUEBEN = SCPL.ID_QUEBEN ");
		builder.append("LEFT JOIN SC_SCH SCH ON SCPL.ID_SCPL = SCH.ID_SCPL AND SCH.D_SCH = ? AND SCH.ID_DAYSLOT = ? ");
		builder.append("LEFT JOIN BD_DEP DEP ON BQ.ID_DEP = DEP.ID_DEP ");
		builder.append("LEFT JOIN BD_PSNDOC EMP ON BS.ID_EMP = EMP.ID_PSNDOC ");
		builder.append("LEFT JOIN SC_SRV PLSRV ON SCPL.ID_SCSRV = PLSRV.ID_SCSRV ");
		builder.append("LEFT JOIN SC_SRV BQSRV ON BQ.ID_SCSRV = BQSRV.ID_SCSRV ");
		builder.append("WHERE 1=1 ");
		builder.append("AND BQ.ID_QUEBEN = ? ");
		builder.append("AND BQ.FG_ACTIVE = ? ");
		builder.append("AND BQ.SD_QUETP = ? ");
		builder.append("AND BS.FG_ACTIVE = ? ");
		builder.append("AND BS.ID_QUEBEN = ? ");
		builder.append("AND BS.SD_QUESITETP = ? ");
		builder.append("ORDER BY BS.CODE ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(dayslotId);
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(benId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		param.addParam(FBoolean.TRUE);
		param.addParam(benId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_UNIVERSAL);
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		return EnValidator.isEmpty(list)?null:list.toArray(new TriageQueSiteDTO[0]);
	}
}
