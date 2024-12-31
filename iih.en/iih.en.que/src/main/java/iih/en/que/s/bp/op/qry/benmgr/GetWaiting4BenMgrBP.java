package iih.en.que.s.bp.op.qry.benmgr;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.enqueue.d.EntQueStatus;
import iih.en.que.s.bp.GetAcptEntBP;
import iih.en.que.s.bp.WaitQueSortUtilBP;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取候诊患者队列(分诊台管理队列模式)
 * 
 * @author liubin
 *
 */
public class GetWaiting4BenMgrBP {
	/**
	 * 获取候诊患者队列(分诊台管理队列模式)
	 * 
	 * @param queSiteDO 
	 * 		医生出诊工作点DO
	 * @param siteInfo 
	 * 		站点信息
	 * @return 
	 * 		候诊队列DTO集合
	 * @throws BizException
	 */
	public ReceptionQueDTO[] exec(QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		if (EnValidator.isEmpty(queSiteDO) 
				|| siteInfo == null 
				|| EnValidator.isEmpty(siteInfo.getId_dayslot())) {
			return null;
		}
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate());
		//1.获取医生出诊队列
		QueDO[] ques = new GetQue4BenMgrBP().getQuesBySiteId(siteInfo);
		if(EnValidator.isEmpty(ques))
			return null;
		//获取候诊患者（候诊，叫号，过号）
		String[] entIds = this.getWaitingEntIds(ques, queSiteDO, siteInfo);
		if(!EnValidator.isEmpty(entIds)){
			GetAcptEntBP getAcptEntBP = new GetAcptEntBP();
			//获取叫号患者
			List<ReceptionQueDTO> callList = getAcptEntBP.getAcptEnt(entIds, EntQueStatus.Called, IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			this.setScreenStatus(callList);
			//获取过号患者
			List<ReceptionQueDTO> callButNotComeList = getAcptEntBP.getAcptEnt(entIds, EntQueStatus.Called, IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
			//获取候诊患者
			List<ReceptionQueDTO> waitList = getAcptEntBP.getAcptEnt(entIds, EntQueStatus.Triaged, IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			//优先级高的患者
			List<ReceptionQueDTO> levelList = new LinkedList<>();
			//有序的候诊队列
			List<ReceptionQueDTO> order = new LinkedList<>();
			if(!EnValidator.isEmpty(waitList)){
				//出诊候诊队列
				List<ReceptionQueDTO> firstList = new LinkedList<>();
				//回诊候诊队列
				List<ReceptionQueDTO> rtnList = new LinkedList<>();
				int heightLevel = EnParamUtils.getPvOrderAcptLevel();
				for(ReceptionQueDTO receptionQue : waitList){
					if(receptionQue.getSortno_called() != null && receptionQue.getSortno_called() > 0) {
						receptionQue.setScreen_status("00");
						order.add(receptionQue);
						continue;
					}
					if(!EnValidator.isEmpty(receptionQue.getLevel_pri())){
						if(Integer.parseInt(receptionQue.getLevel_pri()) >= heightLevel){
							levelList.add(receptionQue);
							continue;
						}
					}
					if(FBoolean.TRUE.equals(receptionQue.getFg_needrtn())){
						rtnList.add(receptionQue);
						continue;
					}
					firstList.add(receptionQue);
				}
				sortRtnList(rtnList);
				//分诊和接诊按初回比例排序
				WaitQueSortUtilBP sortBP = new WaitQueSortUtilBP();
				siteInfo.setId_ques(EnAppUtils.objArray2List(EnAppUtils.getKeyPropArrayFromDO(QueDO.ID_QUE, ques)));
				siteInfo.setId_quesite(queSiteDO.getId_quesite());
				waitList = sortBP.sort(firstList, rtnList,siteInfo, false);
			}
			List<ReceptionQueDTO> list = new LinkedList<>();
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
				return list.toArray(new ReceptionQueDTO[0]);
			}
		}
		return null;
	}
	
	/**
	 * 获取候,叫号，过号诊患者就诊ID
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param siteInfo
	 * @return
	 * @throws BizException
	 */
	private String[] getWaitingEntIds(QueDO[] ques, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		Set<String> modeEmpSet = new HashSet<>();
		Set<String> modeTriageSet = new HashSet<>();
		for(QueDO que : ques){
			if (IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(que.getSd_mode())) {
				modeEmpSet.add(que.getId_que());
			}else
				modeTriageSet.add(que.getId_que());
		}
		Set<String> set = new HashSet<>();
		if(!modeEmpSet.isEmpty()){
			String[] entIds = getModeEmpEntIds(modeEmpSet.toArray(new String[0]), queSiteDO, siteInfo);
			if(!EnValidator.isEmpty(entIds)){
				set.addAll(Arrays.asList(entIds));
			}
		}
		if(!modeTriageSet.isEmpty()){
			String[] entIds = getModeTriageEntIds(modeTriageSet.toArray(new String[0]), queSiteDO, siteInfo);
			if(!EnValidator.isEmpty(entIds)){
				set.addAll(Arrays.asList(entIds));
			}
		}
		return set.isEmpty()?null : set.toArray(new String[0]);
	}
	/**
	 * 设置上屏状态
	 * 
	 * @param rects
	 */
	private void setScreenStatus(List<ReceptionQueDTO> rects){
		if(!EnValidator.isEmpty(rects)){
			for(ReceptionQueDTO rect : rects){
				rect.setScreen_status("00");
			}
		}
	}
	/**
	 * 回诊患者排序
	 * 
	 * @param list
	 */
	private void sortRtnList(List<ReceptionQueDTO> list){
		Collections.sort(list, new Comparator<ReceptionQueDTO>(){
			@Override
			public int compare(ReceptionQueDTO rect1, ReceptionQueDTO rect2) {
				int level_pri1 = EnValidator.isEmpty(rect1.getLevel_pri())?0:Integer.parseInt(rect1.getLevel_pri());
				int level_pri2 = EnValidator.isEmpty(rect2.getLevel_pri())?0:Integer.parseInt(rect2.getLevel_pri());
				if(level_pri1 == level_pri2){
					return rect1.getDt_in().compareTo(rect2.getDt_in());
				}
				return level_pri2 - level_pri1;
			}
		});
	}
	/**
	 * 获取医生叫号模式候诊患者
	 * 
	 * @param queIds
	 * @param queSiteDO
	 * @param siteInfo
	 * @return
	 * @throws BizException
	 */
	private String[] getModeEmpEntIds(String[] queIds, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT DISTINCT EQ.ID_ENT ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("WHERE ((EQ.SD_STATUS_ACPT IN (?,?) AND EQ.ID_QUE_SITE = ?) ");
		builder.append("OR (EQ.SD_STATUS_ACPT=? AND (EQ.ID_QUE_SITE = ? OR ISNULL(EQ.ID_QUE_SITE,'~')='~'))) ");
		builder.append("AND EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		param.addParam(queSiteDO.getId_quesite());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(queSiteDO.getId_quesite());
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		builder.append(EnSqlUtils.getInSqlByIds(" AND EQ.ID_QUE", queIds));
		String sql = builder.toString();
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new String[0]);
		}
		return null;
	}
	/**
	 * 获取分诊台分诊模式候诊患者
	 * 
	 * @param queIds
	 * @param queSiteDO
	 * @param siteInfo
	 * @return
	 * @throws BizException
	 */
	private String[] getModeTriageEntIds(String[] queIds, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT DISTINCT EQ.ID_ENT ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN EN_ENT EN ON EQ.ID_ENT = EN.ID_ENT ");
		builder.append("WHERE EQ.ID_QUE_SITE=? ");
		builder.append("AND EQ.SD_STATUS_ACPT IN (?,?,?) ");
		builder.append("AND EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("AND ").append(EnSqlUtils.getOpOrErTpSql("EN", siteInfo.getCode_entp()));
		param.addParam(queSiteDO.getId_quesite());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		builder.append(EnSqlUtils.getInSqlByIds(" AND EQ.ID_QUE", queIds));
		String sql = builder.toString();
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new String[0]);
		}
		return null;
	}
}