package iih.en.que.s.bp;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.enqueue.d.EntQueStatus;
import iih.en.que.s.bp.er.HandleTriageEntErInfoBP;
import iih.en.que.s.bp.op.qry.benmgr.GetQue4BenMgrBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取队列或站点的分诊详情
 * 
 * @author liubin
 */
public class GetTriagedWaitBP {
	/**
	 * 根据status状态获取队列或站点的分诊详情
	 * 
	 * @param triageInfo
	 * 		分诊台信息
	 * @param queId
	 * 		门诊队列ID
	 * @param queSiteId
	 * 		医生工作站ID（可以为空）
	 * @param status
	 * 		状态
	 * <ul>
	 * <li>[0] 未分诊状态患者</li>
	 * <li>[1] 候诊状态患者</li>
	 * <li>[3] 就诊状态患者</li>
	 * </ul>
	 * @return
	 * @throws BizException
	 */
	public TriageEntDTO[] exec(TriageBenInfoDTO triageInfo, String[] queIds, String queSiteId, int status)throws BizException {
		if (triageInfo == null || EnValidator.isEmpty(triageInfo.getId_dayslot())) {
			return null;
		}	
		TriageEntDTO[] ents = null;
		//是否是分诊台管理队列
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		if(EnValidator.isEmpty(queSiteId)){
			if(EnValidator.isEmpty(queIds))
				return null;
			//队列
			if(EntQueStatus.Arrived == status){
				//得到队列的未分诊患者
				ents =  this.getNoTriageEnt4Que(triageInfo, queIds);
			}else if(EntQueStatus.Triaged == status){
				//得到队列的候诊列表
				ents = this.getWaitEnt4Que(triageInfo, queIds);
			}
		}else{
			if(!EnValidator.isEmpty(queIds) && isBenQueMgr){
				EnTrDocSiteInfoDTO siteInfo = new EnTrDocSiteInfoDTO();
				siteInfo.setId_quesite(queSiteId);
				siteInfo.setId_dayslot(triageInfo.getId_dayslot());
				siteInfo.setId_queben(triageInfo.getId_queben());
				siteInfo.setDate(triageInfo.getDate());
				queIds = new GetQue4BenMgrBP().getQueIdsBySiteId(siteInfo);
			}
			//医生站点
			if(EntQueStatus.Triaged == status){
				//得到医生工作点的候诊列表
				ents = this.getWaitEnt4QueSite(triageInfo, queIds, queSiteId);
			}else if(EntQueStatus.Accept == status){
				//得到医生工作点的已诊列表
				ents = this.getAcptEnt4QueSite(triageInfo, queIds, queSiteId);
			}
		}
		//急诊处理
		new HandleTriageEntErInfoBP().exec(ents, triageInfo.getCode_entp());
		return ents;
	}
	
	/**
	 * 得到队列的未分诊患者
	 * 按优先级，挂号序号，签到时间排序
	 * 
	 * @param triageInfo
	 * 		分诊台信息
	 * @param queId
	 * @return
	 * @throws DAException 
	 */
	private TriageEntDTO[] getNoTriageEnt4Que(TriageBenInfoDTO triageInfo, String[] queIds) throws DAException{
		GetTriageEntBP bp = new GetTriageEntBP();
		StringBuilder builder = bp.getBaseBuilder();
		builder.append("WHERE EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", triageInfo.getCode_entp()));
		builder.append("AND ").append(EnSqlUtils.getInSqlByIds("EQ.ID_QUE", queIds));
		builder.append("AND EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND ISNULL(EQ.ID_QUE_SITE,'~')='~' ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND (BQ.SD_MODE = ? OR ");
		builder.append("(BQ.SD_MODE = ? AND NOT EXISTS ");
		builder.append("(SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 WHERE QS1.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? ))) ");
		builder.append("ORDER BY EQ.LEVEL_PRI DESC NULLS LAST,EQ.SORTNO,EQ.DT_IN DESC ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_TRIAGE);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(FBoolean.TRUE);
		return bp.getTriageEnts(sql, param);
	}
	/**
	 * 得到队列的候诊列表
	 * 按优先级，挂号序号，签到时间排序
	 * 
	 * @param triageInfo
	 * 		分诊台信息
	 * @param queId
	 * @return
	 * @throws DAException 
	 */
	private TriageEntDTO[] getWaitEnt4Que(TriageBenInfoDTO triageInfo, String[] queIds) throws DAException{
		GetTriageEntBP bp = new GetTriageEntBP();
		StringBuilder builder = bp.getBaseBuilder();
		builder.append("WHERE EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", triageInfo.getCode_entp()));
		builder.append("AND ").append(EnSqlUtils.getInSqlByIds("EQ.ID_QUE", queIds));
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND ( EQ.SD_STATUS_ACPT IN (?,?)  OR (");
		builder.append("EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND (ISNULL(EQ.ID_QUE_SITE,'~')<>'~' OR ");
		builder.append("(BQ.SD_MODE = ? AND EXISTS ");
		builder.append("(SELECT QS1.ID_QUESITE FROM BD_QUE_SITE QS1 WHERE QS1.ID_QUE = EQ.ID_QUE AND QS1.ID_QUEBEN = BQ.ID_QUEBEN AND QS1.EU_PAUSE = ? AND QS1.FG_ACTIVE = ? ))) ");
		builder.append(" )) ");
		builder.append("ORDER BY EQ.LEVEL_PRI DESC NULLS LAST,EQ.SORTNO,EQ.DT_IN ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(FBoolean.TRUE);
		return bp.getTriageEnts(sql, param);
	}
	/**
	 * 得到医生工作点的候诊列表
	 * 按叫号（按sortno_called排序），候诊（按初回比例排序），过号（按sortno_called排序）排序
	 * 
	 * @param date
	 * @param dayslotId
	 * @param queId
	 * @param queSiteId
	 * @return
	 * @throws BizException 
	 */
	private TriageEntDTO[] getWaitEnt4QueSite(TriageBenInfoDTO triageInfo, String[] queIds, String queSiteId) throws BizException{
		//获取叫号患者
		List<TriageEntDTO> callList = this.getEnt4QueSite(triageInfo, queIds, queSiteId, IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		this.setScreenStatus(callList);
		//获取过号患者
		List<TriageEntDTO> callButNotComeList = this.getEnt4QueSite(triageInfo, queIds, queSiteId, IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		//获取候诊患者
		List<TriageEntDTO> waitList = this.getSiteWaitEnt(triageInfo, queIds, queSiteId);
		//优先级高的患者
		List<TriageEntDTO> levelList = new LinkedList<>();
		//有序的候诊队列
		List<TriageEntDTO> order = new LinkedList<>();
		if(!EnValidator.isEmpty(waitList)&&!EnValidator.isEmpty(queIds)){
			//出诊候诊队列
			List<TriageEntDTO> firstList = new LinkedList<>();//出诊候诊队列
			List<TriageEntDTO> rtnList = new LinkedList<>();//回诊候诊队列
			int heightLevel = EnParamUtils.getPvOrderAcptLevel();
			for(TriageEntDTO triageEnt : waitList){
				if(triageEnt.getSortno_called() != null && triageEnt.getSortno_called() > 0) {
					triageEnt.setScreen_status("00");
					order.add(triageEnt);
					continue;
				}
				if(!EnValidator.isEmpty(triageEnt.getLevel_pri())){
					if(Integer.parseInt(triageEnt.getLevel_pri()) >= heightLevel){
						levelList.add(triageEnt);
						continue;
					}
				}
				if(FBoolean.TRUE.equals(triageEnt.getFg_needrtn())){
					rtnList.add(triageEnt);
					continue;
				}
				firstList.add(triageEnt);
			}
			sortRtnList(rtnList);
			//分诊和接诊按初回比例排序
			WaitQueSortUtilBP sortBP = new WaitQueSortUtilBP();
			EnTrDocSiteInfoDTO siteInfo = new EnTrDocSiteInfoDTO();
			siteInfo.setId_ques(EnAppUtils.objArray2List(queIds));
			siteInfo.setId_quesite(queSiteId);
			siteInfo.setId_dayslot(triageInfo.getId_dayslot());
			siteInfo.setDate(triageInfo.getDate());
			waitList = sortBP.sort(firstList, rtnList, siteInfo, false);
		}
		List<TriageEntDTO> list = new LinkedList<>();
		
		if(!EnValidator.isEmpty(callList))
			list.addAll(callList);
		if(!EnValidator.isEmpty(order))
			list.addAll(order);
		if(!EnValidator.isEmpty(levelList))
			list.addAll(levelList);
		if(!EnValidator.isEmpty(waitList))
			list.addAll(waitList);
		if(!EnValidator.isEmpty(callButNotComeList))
			list.addAll(callButNotComeList);
		
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageEntDTO[0]);
		}
		return null;
	}
	/**
	 * 得到医生工作点的已诊列表
	 * 按接诊时间排序
	 * 
	 * @param date
	 * @param dayslotId
	 * @param queId
	 * @param queSiteId
	 * @return
	 * @throws DAException 
	 */
	private TriageEntDTO[] getAcptEnt4QueSite(TriageBenInfoDTO triageInfo, String[] queIds, String queSiteId) throws DAException{
		List<TriageEntDTO> list = this.getEnt4QueSite(triageInfo, queIds, queSiteId, IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageEntDTO[0]);
		}
		return null;
	}
	
	/**
	 * 根据sd_status_acpt得到站点的患者列表
	 * 
	 * @param date
	 * @param dayslotId
	 * @param queIds
	 * @param queSiteId
	 * @param sdStatusAcpt
	 * @return
	 * @throws DAException
	 */
	private List<TriageEntDTO> getEnt4QueSite(TriageBenInfoDTO triageInfo, String[] queIds, String queSiteId, String sdStatusAcpt) throws DAException{
		GetTriageEntBP bp = new GetTriageEntBP();
		StringBuilder builder = bp.getBaseBuilder();
		builder.append("WHERE EQ.DT_REGIST = ? ");
		int orgParam = EnParamUtils.isCurrentDaysltAllDay();
		if(orgParam==1 && IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(sdStatusAcpt) ){
			
		}else{
			builder.append("AND EQ.ID_DATESLOT = ? ");
		}
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", triageInfo.getCode_entp()));
		if(!EnValidator.isEmpty(queIds)){
			builder.append("AND ").append(EnSqlUtils.getInSqlByIds("EQ.ID_QUE", queIds));
		}
		builder.append("AND EQ.ID_QUE_SITE = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		if(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(sdStatusAcpt)){
			builder.append("ORDER BY DL.CODE,EQ.SORTNO,EN.DT_ACPT  ");
		}else if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(sdStatusAcpt)||IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(sdStatusAcpt)){
			builder.append("ORDER BY EQ.SORTNO_CALLED ");
		}else if(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT.equals(sdStatusAcpt)){
			builder.append("ORDER BY EQ.SORTNO_CALLED,EQ.LEVEL_PRI DESC NULLS LAST,EQ.SORTNO, EQ.DT_IN  ");
		}
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(triageInfo.getDate());
		if(orgParam==1 && IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(sdStatusAcpt) ){
			
		}else{
			param.addParam(triageInfo.getId_dayslot());
		}
		param.addParam(queSiteId);
		param.addParam(sdStatusAcpt);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		return bp.getTriageEntList(sql, param);
	}
	/**
	 * 获取队列候诊列表
	 * 
	 * @param date
	 * @param dayslotId
	 * @param queIds
	 * @param queSiteId
	 * @return
	 * @throws DAException
	 */
	private List<TriageEntDTO> getSiteWaitEnt(TriageBenInfoDTO triageInfo, String[] queIds, String queSiteId) throws DAException{
		GetTriageEntBP bp = new GetTriageEntBP();
		StringBuilder builder = bp.getBaseBuilder();
		SqlParam param = new SqlParam();
		builder.append("WHERE EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT = ? ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", triageInfo.getCode_entp()));
		param.addParam(triageInfo.getDate());
		param.addParam(triageInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		if(!EnValidator.isEmpty(queIds)){
			builder.append("AND ").append(EnSqlUtils.getInSqlByIds("EQ.ID_QUE", queIds));
			builder.append("AND (EQ.ID_QUE_SITE = ?  OR (BQ.SD_MODE = ? AND ISNULL(EQ.ID_QUE_SITE,'~')='~')) ");
			param.addParam(queSiteId);
			param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		}else{
			builder.append("AND EQ.ID_QUE_SITE = ? ");
			param.addParam(queSiteId);
		}
		builder.append("ORDER BY EQ.SORTNO_CALLED,EQ.LEVEL_PRI DESC NULLS LAST,EQ.SORTNO, EQ.DT_IN  ");
		String sql = builder.toString();
		return bp.getTriageEntList(sql, param);
	}
	/**
	 * 设置上屏状态
	 * 
	 * @param rects
	 */
	private void setScreenStatus(List<TriageEntDTO> rects){
		if(!EnValidator.isEmpty(rects)){
			for(TriageEntDTO rect : rects){
				rect.setScreen_status("00");
			}
		}
	}
	/**
	 * 回诊患者排序
	 * 
	 * @param list
	 */
	private void sortRtnList(List<TriageEntDTO> list){
		Collections.sort(list, new Comparator<TriageEntDTO>(){
			@Override
			public int compare(TriageEntDTO rect1, TriageEntDTO rect2) {
				int level_pri1 = EnValidator.isEmpty(rect1.getLevel_pri())?0:Integer.parseInt(rect1.getLevel_pri());
				int level_pri2 = EnValidator.isEmpty(rect2.getLevel_pri())?0:Integer.parseInt(rect2.getLevel_pri());
				if(level_pri1 == level_pri2){
					return rect1.getDt_in().compareTo(rect2.getDt_in());
				}
				return level_pri2 - level_pri1;
			}
		});
	}
}
