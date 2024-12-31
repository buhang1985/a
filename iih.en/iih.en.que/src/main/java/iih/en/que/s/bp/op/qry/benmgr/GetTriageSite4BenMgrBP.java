package iih.en.que.s.bp.op.qry.benmgr;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.dto.d.TriageSiteDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 得到分诊台的队列和站点信息信息，(队列管理)
 * 
 * @author liubin
 *
 */
public class GetTriageSite4BenMgrBP {
	/**
	 * 医疗组号
	 */
	private static final String KEY_QUE = "QUE";
	/**
	 * 空诊台
	 */
	private static final String KEY_EMPTY = "EMPTY";
	/**
	 * 得到分诊台的队列和站点信息信息，
	 * 包括队列或站点的分诊数和候诊数
	 * 
	 * @param benId 分诊台ID
	 * @param date 日期
	 * @param dayslotId 日期分组Id
	 * @param depId 科室ID
	 * @param status
	 * @return
	 * @throws BizException
	 */
	public FMap exec(TriageBenInfoDTO triageInfo, int status) throws BizException {
		if (triageInfo == null || EnValidator.isEmpty(triageInfo.getId_dayslot())
				|| EnValidator.isEmpty(triageInfo.getId_queben())) {
			return null;
		}
		Map<String, Map<String, TriageSiteDTO>> map = this.initMap();
		//获取队列
		List<TriageQueSiteDTO> queList = this.getQueInfo(triageInfo);
		if(!EnValidator.isEmpty(queList)){
			List<TriageQueSiteDTO> queNumList = this.getQueNum(triageInfo);
			this.processQueList(map, queList, queNumList);
		}
		//获取站点
		List<TriageQueSiteDTO> siteList = this.getSiteInfo(triageInfo);
		if(!EnValidator.isEmpty(siteList)){
			List<TriageQueSiteDTO> siteNumList = this.getSiteNum(triageInfo);
			this.processSiteList(siteList, siteNumList);
		}
		FMap fMap = this.wrapQueAndSite(map, siteList);
		return fMap;
	}
	/**
	 * 获取队列
	 * 
	 * @param triageInfo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<TriageQueSiteDTO> getQueInfo(TriageBenInfoDTO triageInfo) throws BizException {
		List<TriageQueSiteDTO> queList = new ArrayList<>();
		//1.查询有排班的队列
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT BQ.ID_QUE AS ID_QUE,");
		builder.append("BQ.NAME AS NAME_QUE,");
		builder.append("BEN.ID_QUEBEN AS ID_BEN,");
		builder.append("BEN.NAME AS NAME_BEN,");
		builder.append("DEP.ID_DEP AS ID_DEP,");
		builder.append("DEP.NAME AS NAME_DEP,");
		builder.append("RES.ID_SCRES AS ID_SCRES,");
		builder.append("RES.NAME AS NAME_RES,");
		builder.append("RES.SD_SCRESTP AS SD_SCRESTP,");
		builder.append("RES.ID_EMP AS ID_EMP,");
		builder.append("EMP.NAME AS EMP_NAME,");
		builder.append("BQ.ID_SCSRV AS ID_SCSRV,");
		builder.append("PLSRV.NAME AS SCSRV_NAME,");
		builder.append("PLSRV.SD_SRVTP AS SD_SRVTP ");
		builder.append("FROM BD_QUE BQ ");
		builder.append("INNER JOIN BD_QUE_BEN BEN ON BQ.ID_QUEBEN = BEN.ID_QUEBEN ");
		builder.append("INNER JOIN SC_RES RES ON BQ.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON BQ.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN SC_SRV PLSRV ON PLSRV.ID_SCSRV = BQ.ID_SCSRV ");
		builder.append("LEFT JOIN BD_PSNDOC EMP ON RES.ID_EMP = EMP.ID_PSNDOC ");
		builder.append("WHERE BQ.ID_QUEBEN = ? ");
		builder.append("AND BQ.FG_ACTIVE = ? ");
		builder.append("AND BQ.SD_QUETP = ? ");
		builder.append("AND EXISTS (SELECT * FROM SC_PL SCPL INNER JOIN SC_SCH SCH ON SCPL.ID_SCPL = SCH.ID_SCPL WHERE BQ.ID_DEP = SCPL.ID_DEP AND BQ.ID_SCRES = SCPL.ID_SCRES AND BQ.ID_QUEBEN = SCPL.ID_QUEBEN ");
		builder.append("AND SCPL.FG_ACTIVE = ? ");	
		builder.append("AND SCH.D_SCH = ? ");
		builder.append("AND SCH.ID_DAYSLOT = ? )");
		String sql  = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(triageInfo.getId_queben());
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		Set<String> queSet = new HashSet<>();
		if(!EnValidator.isEmpty(list)){
			for(TriageQueSiteDTO queInfo : list)
			{
				queSet.add(queInfo.getId_que());
				queList.add(queInfo);
			}
		}
		//2.查询已登陆站点的队列
		builder = new StringBuilder();
		builder.append("SELECT BQ.ID_QUE AS ID_QUE,");
		builder.append("BQ.NAME AS NAME_QUE,");
		builder.append("BEN.ID_QUEBEN AS ID_BEN,");
		builder.append("BEN.NAME AS NAME_BEN,");
		builder.append("DEP.ID_DEP AS ID_DEP,");
		builder.append("DEP.NAME AS NAME_DEP,");
		builder.append("RES.ID_SCRES AS ID_SCRES,");
		builder.append("RES.NAME AS NAME_RES,");
		builder.append("RES.SD_SCRESTP AS SD_SCRESTP,");
		builder.append("RES.ID_EMP AS ID_EMP,");
		builder.append("EMP.NAME AS EMP_NAME,");
		builder.append("SRV.ID_SCSRV AS ID_SCSRV,");
		builder.append("SRV.NAME AS SCSRV_NAME,");
		builder.append("SRV.SD_SRVTP AS SD_SRVTP ");
		builder.append("FROM BD_QUE BQ ");
		builder.append("INNER JOIN BD_QUE_BEN BEN ON BQ.ID_QUEBEN = BEN.ID_QUEBEN ");
		builder.append("INNER JOIN SC_RES RES ON BQ.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON BQ.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN SC_SRV SRV ON BQ.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("LEFT JOIN BD_PSNDOC EMP ON RES.ID_EMP = EMP.ID_PSNDOC ");
		builder.append("WHERE BQ.ID_QUEBEN = ? ");
		builder.append("AND BQ.FG_ACTIVE = ? ");
		builder.append("AND BQ.SD_QUETP = ? ");
		builder.append("AND EXISTS (SELECT BS.ID_QUESITE FROM BD_QUE_SITE BS INNER JOIN EN_QUE_EMP EMP ON BS.ID_EMP = EMP.ID_EMP WHERE EMP.ID_QUE = BQ.ID_QUE AND BS.ID_QUEBEN = BQ.ID_QUEBEN AND BS.FG_ACTIVE = ? AND EMP.FG_ACTIVE = ? ) ");
		builder.append(" ");
		if(!queSet.isEmpty()){
			builder.append("AND " + EnSqlUtils.getNotInSqlByIds("BQ.ID_QUE", queSet.toArray(new String[0])));
		}
		sql  = builder.toString();
		param = new SqlParam();
		param.addParam(triageInfo.getId_queben());
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list))
			queList.addAll(list);
		return queList;	
	}
	/**
	 *  查找 队列的未分诊数，分诊数和候诊数
	 * 
	 * @param triageInfo
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private List<TriageQueSiteDTO> getQueNum(TriageBenInfoDTO triageInfo) throws BizException{
		StringBuilder builder  = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT EQ.ID_QUE AS ID_QUE,");
		builder.append("SUM(CASE WHEN EQ.SD_STATUS_ACPT = ? AND BQ.SD_MODE = ? AND ISNULL(EQ.ID_QUE_SITE,'~') = '~' THEN 1 ");
		builder.append("WHEN EQ.SD_STATUS_ACPT = ? AND BQ.SD_MODE = ?  AND ISNULL(EQ.ID_QUE_SITE,'~') = '~' AND NOT EXISTS (SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 INNER JOIN EN_QUE_EMP EMP ON QS1.ID_EMP = EMP.ID_EMP WHERE EMP.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? AND EMP.ID_DAYSLOT = ? AND EMP.D_QUE = ? AND EMP.FG_ACTIVE = ? ) THEN 1 ");
		builder.append("ELSE 0 END) AS NOTRIAGENUM, ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(FBoolean.TRUE);
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(triageInfo.getDate());
		param.addParam(FBoolean.TRUE);
		builder.append("SUM(CASE WHEN ISNULL(EQ.ID_QUE_SITE,'~')<>'~' THEN 1  ");
		builder.append("WHEN BQ.SD_MODE = ?  AND ISNULL(EQ.ID_QUE_SITE,'~') = '~' AND EXISTS (SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 INNER JOIN EN_QUE_EMP EMP ON QS1.ID_EMP = EMP.ID_EMP WHERE EMP.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? AND EMP.ID_DAYSLOT = ? AND EMP.D_QUE = ? AND EMP.FG_ACTIVE = ?) THEN 1 ");
		builder.append("ELSE 0 END) AS TRIAGENUM, ");
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(FBoolean.TRUE);
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(triageInfo.getDate());
		param.addParam(FBoolean.TRUE);
		builder.append("SUM(CASE WHEN ISNULL(EQ.ID_QUE_SITE,'~')<>'~' AND EQ.SD_STATUS_ACPT<>? THEN 1  ");
		builder.append("WHEN BQ.SD_MODE = ?  AND ISNULL(EQ.ID_QUE_SITE,'~') = '~' AND EQ.SD_STATUS_ACPT<>? AND EXISTS (SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 INNER JOIN EN_QUE_EMP EMP ON QS1.ID_EMP = EMP.ID_EMP WHERE EMP.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? AND EMP.ID_DAYSLOT = ? AND EMP.D_QUE = ? AND EMP.FG_ACTIVE = ?) THEN 1 ");
		builder.append("ELSE 0 END) AS WAITNUM ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(FBoolean.TRUE);
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(triageInfo.getDate());
		param.addParam(FBoolean.TRUE);
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT<> ? AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", triageInfo.getCode_entp()));
		builder.append("GROUP BY EQ.ID_QUE ");
		builder.append("HAVING EQ.ID_QUE IN ");
		builder.append("(SELECT ID_QUE FROM BD_QUE QUE WHERE QUE.ID_QUEBEN = ? AND QUE.SD_QUETP = ? AND QUE.FG_ACTIVE = ? )");
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(triageInfo.getId_queben());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		String sql = builder.toString();
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		return list;
	}
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
		SqlParam param = new SqlParam();
		sb.append("SELECT DISTINCT BD_QUE_SITE.ID_QUESITE AS ID_QUESITE,");
		sb.append("BD_QUE_SITE.NAME AS NAME_QUESITE,");
		sb.append("EN_QUE_EMP.ID_QUE AS ID_QUE,");
		sb.append("BD_QUE_SITE.ID_QUEBEN  AS ID_BEN,");
		sb.append("BD_QUE_SITE.ID_DEP AS ID_DEP,");
		sb.append("BD_QUE_SITE.ID_EMP AS ID_EMP,");
		sb.append("BD_PSNDOC.NAME AS EMP_NAME,");
		sb.append("BQ.SD_MODE, ");
		sb.append("BQ.NAME AS NAME_QUE, ");
		sb.append("BD_QUE_SITE.APPLY_MAX, ");
		sb.append("BD_QUE_SITE.EU_PAUSE AS EU_PAUSE ");
		sb.append("FROM BD_QUE_SITE BD_QUE_SITE ");
		sb.append("LEFT JOIN EN_QUE_EMP ON BD_QUE_SITE.ID_EMP = EN_QUE_EMP.ID_EMP AND EN_QUE_EMP.D_QUE = ? AND EN_QUE_EMP.FG_ACTIVE = ? ");
		sb.append("LEFT JOIN BD_QUE BQ ON EN_QUE_EMP.ID_QUE = BQ.ID_QUE ");
		sb.append("LEFT JOIN BD_PSNDOC BD_PSNDOC ON BD_QUE_SITE.ID_EMP = BD_PSNDOC.ID_PSNDOC ");
		sb.append("WHERE BD_QUE_SITE.ID_QUEBEN = ? ");
		sb.append("AND BD_QUE_SITE.SD_QUESITETP = ? ");
		sb.append("AND BD_QUE_SITE.FG_ACTIVE = ? ");
		param.addParam(triageInfo.getDate());
		param.addParam(FBoolean.TRUE);
		param.addParam(triageInfo.getId_queben());
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		param.addParam(FBoolean.TRUE);
		sb.append("AND ").append(EnSqlUtils.getInSqlByIds("EN_QUE_EMP.ID_DAYSLOT", GetQue4BenMgrBP.getDayslotIds(triageInfo.getId_dayslot())));
		String sql = sb.toString();
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		return list;
	}
	/**
	 * 查找 工作站的分诊数和候诊数
	 * 
	 * @param triageInfo
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private List<TriageQueSiteDTO> getSiteNum(TriageBenInfoDTO triageInfo) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT TMP.ID_QUESITE, SUM(TMP.TRIAGENUM) AS TRIAGENUM, SUM(TMP.WAITNUM) AS WAITNUM FROM ( ");
		builder.append("SELECT BS.ID_QUESITE,");
		builder.append("(CASE WHEN NVL(BS.ID_QUE,'~') = '~' ");
		builder.append("THEN (SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT <> ? AND EQ.FG_ACTIVE = ? AND EQ.SD_ENTQUE_TP = ? AND EQ.ID_QUE_SITE = BS.ID_QUESITE) ");
		builder.append("ELSE (SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT <> ? AND EQ.FG_ACTIVE = ? AND EQ.SD_ENTQUE_TP = ? AND EQ.ID_QUE = BS.ID_QUE ");
		builder.append("AND (EQ.ID_QUE_SITE = BS.ID_QUESITE OR (BS.SD_MODE = ? AND NVL(EQ.ID_QUE_SITE,'~') = '~'))) ");
		builder.append("END ) AS TRIAGENUM, ");
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		builder.append("(CASE WHEN NVL(BS.ID_QUE,'~') = '~' ");
		builder.append("THEN (SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT NOT IN (?,?) AND EQ.FG_ACTIVE = ? AND EQ.SD_ENTQUE_TP = ? AND EQ.ID_QUE_SITE = BS.ID_QUESITE) ");
		builder.append("ELSE (SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT NOT IN (?,?) AND EQ.FG_ACTIVE = ? AND EQ.SD_ENTQUE_TP = ? AND EQ.ID_QUE = BS.ID_QUE ");
		builder.append("AND (EQ.ID_QUE_SITE = BS.ID_QUESITE OR (BS.SD_MODE = ? AND NVL(EQ.ID_QUE_SITE,'~') = '~'))) ");
		builder.append("END ) AS WAITNUM ");
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		builder.append("FROM  ");
		builder.append("(SELECT BQS.ID_QUESITE,EMP.ID_QUE,BEQ.SD_MODE  ");
		builder.append(" FROM BD_QUE_SITE BQS ");
		builder.append(" LEFT JOIN EN_QUE_EMP EMP ON BQS.ID_EMP = EMP.ID_EMP AND EMP.ID_DAYSLOT = ? AND EMP.D_QUE = ? AND EMP.FG_ACTIVE = ? ");
		builder.append(" LEFT JOIN BD_QUE BEQ ON EMP.ID_QUE = BEQ.ID_QUE AND BEQ.FG_ACTIVE = ? ");
		builder.append(" WHERE BQS.ID_QUEBEN = ? ");
		builder.append(" AND BQS.SD_QUESITETP = ? ");
		builder.append(" AND BQS.FG_ACTIVE = ? ");
		builder.append(" ) BS ");
		builder.append(") TMP GROUP BY TMP.ID_QUESITE ");
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(triageInfo.getDate());
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		param.addParam(triageInfo.getId_queben());
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		param.addParam(FBoolean.TRUE);
		String sql = builder.toString();
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		return list;
	}
	/**
	 * 处理队列和队列的未分诊数，分诊数和候诊数并分组
	 * 
	 * @param map
	 * @param queList
	 * @param queNumList
	 */
	private void processQueList(Map<String, Map<String, TriageSiteDTO>> map, List<TriageQueSiteDTO> queList, List<TriageQueSiteDTO> queNumList){
		if(map == null || EnValidator.isEmpty(queList))
			return;
		Map<String, TriageQueSiteDTO> queNumMap = new HashMap<>();
		if(!EnValidator.isEmpty(queNumList)){
			for(TriageQueSiteDTO queNum : queNumList)
				queNumMap.put(queNum.getId_que(), queNum);
		}
		for(TriageQueSiteDTO que : queList){
			this.processQueNum(que,  queNumMap);
			String queKey = que.getId_que();
			this.processQue(map, que, KEY_QUE, queKey);
		}
	}
	/**
	 * 处理队列
	 * 
	 * @param map
	 * @param que
	 */
	@SuppressWarnings("unchecked")
	private void processQue(Map<String, Map<String, TriageSiteDTO>> map, TriageQueSiteDTO que, String key, String queKey){
		if(map == null || que == null)
			return;
		Map<String, TriageSiteDTO> queMap = map.get(key);
		if(queMap.containsKey(queKey)){
			TriageSiteDTO dto = queMap.get(queKey);
			dto.setNum_notriage((dto.getNum_notriage() == null ? 0 : dto.getNum_notriage())
					+ (que.getNotriagenum() == null ? 0 : que.getNotriagenum()));
			dto.setNum_triage((dto.getNum_triage() == null ? 0 : dto.getNum_triage())
					+ (que.getTriagenum() == null ? 0 : que.getTriagenum()));
			dto.setNum_wait((dto.getNum_wait() == null ? 0 : dto.getNum_wait())
					+ (que.getWaitnum() == null ? 0 : que.getWaitnum()));
			FArrayList list = dto.getList_quesite();
			if(list == null)
				list = new FArrayList();
			list.add(que);
			dto.setList_quesite(list);
			
		}else{
			TriageSiteDTO dto = new TriageSiteDTO();
			dto.setId_dep(que.getId_dep());
			dto.setId_que(que.getId_que());
			dto.setId_scsrv(que.getId_scsrv());
			dto.setSd_screstp(que.getSd_screstp());
			dto.setSd_srvtp(que.getSd_srvtp());
			dto.setName_que(que.getName_que());
			dto.setName_scsrv(que.getScsrv_name());
			dto.setNum_notriage(que.getNotriagenum() == null ? 0 : que.getNotriagenum());
			dto.setNum_triage(que.getTriagenum() == null ? 0 : que.getTriagenum());
			dto.setNum_wait(que.getWaitnum() == null ? 0 : que.getWaitnum());
			queMap.put(queKey, dto);
		}
	}
	/**
	 * 处理队列和队列的未分诊数，分诊数和候诊数
	 * 
	 * @param que
	 * @param queNumList
	 */
	private void processQueNum(TriageQueSiteDTO que, Map<String, TriageQueSiteDTO> queNumMap){
		if(que == null)
			return;
		que.setNotriagenum(0);
		que.setTriagenum(0);
		que.setWaitnum(0);
		if(queNumMap.containsKey(que.getId_que())){
			TriageQueSiteDTO num = queNumMap.get(que.getId_que());
			que.setNotriagenum(num.getNotriagenum());
			que.setTriagenum(num.getTriagenum());
			que.setWaitnum(num.getWaitnum());
		}
	}
	/**
	 * 处理站点和站点的分诊和候诊数
	 * 
	 * @param siteList
	 * @param siteNumList
	 */
	private void processSiteList(List<TriageQueSiteDTO> siteList, List<TriageQueSiteDTO> siteNumList){
		if(EnValidator.isEmpty(siteList))
			return;
		Map<String, TriageQueSiteDTO> map = new HashMap<>();
		if(!EnValidator.isEmpty(siteNumList)){
			for(TriageQueSiteDTO siteNum : siteNumList)
				map.put(siteNum.getId_quesite(), siteNum);
		}
		for(TriageQueSiteDTO site : siteList){
			site.setNotriagenum(0);
			site.setTriagenum(0);
			site.setWaitnum(0);
			if(map.containsKey(site.getId_quesite())){
				TriageQueSiteDTO siteNum = map.get(site.getId_quesite());
				site.setTriagenum(siteNum.getTriagenum());
				site.setWaitnum(siteNum.getWaitnum());
			}
		}
	}
	/**
	 * 组装FMap
	 * 
	 * @param map
	 * @param siteList
	 * @return
	 */
	private FMap wrapQueAndSite(Map<String, Map<String, TriageSiteDTO>> map, List<TriageQueSiteDTO> siteList){
		if(map == null)
			return null;
		FMap fMap = new FMap();
		Map<String, TriageSiteDTO> qsMap = map.get(KEY_QUE);
		this.wrapFMap(fMap, KEY_QUE, qsMap, siteList);
		//空诊桌
		this.wrapEmptySite(fMap, siteList);
		return fMap;
	}
	/**
	 * 组装数据
	 * 
	 * @param fmap
	 * @param key
	 * @param map
	 * @param siteList
	 */
	@SuppressWarnings("unchecked")
	private void wrapFMap(FMap fMap, String key, Map<String, TriageSiteDTO> map, List<TriageQueSiteDTO> siteList){
		if(map == null || map.size() <= 0){
			fMap.put(key, null);
			return;
		}
		FArrayList valueList = new FArrayList();
		for(Entry<String, TriageSiteDTO> set : map.entrySet()){
			TriageSiteDTO dto = set.getValue();
			FArrayList newList = new FArrayList();
			if(!EnValidator.isEmpty(siteList)){
				for(int i = siteList.size()-1;i>=0;i--){
					if(dto.getId_que().equals(siteList.get(i).getId_que()) && dto.getId_dep().equals(siteList.get(i).getId_dep())){
						newList.add(siteList.get(i));
					}
				}
			}
			dto.setList_quesite(newList);
			valueList.add(dto);
		}
		fMap.put(key, valueList);
	}
	/**
	 * 组装空诊桌
	 * 
	 * @param fMap
	 * @param siteList
	 */
	@SuppressWarnings("unchecked")
	private void wrapEmptySite(FMap fMap, List<TriageQueSiteDTO> siteList){
		if(EnValidator.isEmpty(siteList)){
			fMap.put(KEY_EMPTY, null);
			return;
		}
		FArrayList valueList = new FArrayList();
		for(TriageQueSiteDTO site : siteList){
			if(EnValidator.isEmpty(site.getId_que())){
				valueList.add(site);
			}
		}
		fMap.put(KEY_EMPTY, valueList);
	}
	/**
	 * 初始化map
	 * 
	 * @return
	 */
	private Map<String, Map<String, TriageSiteDTO>> initMap(){
		Map<String, Map<String, TriageSiteDTO>> map = new HashMap<String, Map<String, TriageSiteDTO>>();
		map.put(KEY_QUE, new HashMap<String, TriageSiteDTO>());
		map.put(KEY_EMPTY, new HashMap<String, TriageSiteDTO>());
		return map;
	}
}
