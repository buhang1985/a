package iih.en.que.s.bp.mt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriagePatInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.EntQueStatus;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 自动分诊
 * @author fanlq
 * @date: 2020年1月8日 下午7:30:35
 */
public class AutoMtTriageBP {

	public EnQueueDO[] exec(TriageBenInfoDTO triageInfo) throws BizException{
		if(triageInfo == null || EnValidator.isEmpty(triageInfo.getId_queben()) 
				|| EnValidator.isEmpty(triageInfo.getId_dayslot()))	
			return null;
		GetTriageQueByBenBP bp = new GetTriageQueByBenBP();
		TriagePatInfoDTO[] triagePatInfoDTOs = bp.exec(triageInfo, triageInfo.getId_dayslot(),EntQueStatus.Arrived);
		if(EnValidator.isEmpty(triagePatInfoDTOs)){
			Logger.info("签到的就诊患者为空");
			return null;
		}
		return this.autoTriageSite(triagePatInfoDTOs, triageInfo);
	}
	/**
	 * 自动分诊
	 * @param waitEntDTOArray
	 * @param benId
	 * @param dayslotId
	 * @throws BizException
	 */
	private EnQueueDO[] autoTriageSite(TriagePatInfoDTO[] waitEntDTOArray,TriageBenInfoDTO triageInfo) throws BizException{
		//2、准备站点数据
		//2.1、获取分诊台站点
		//是否是分诊台管理队列
		List<TriageQueSiteDTO> queSiteArray = null;
		queSiteArray = new GetMtTriageSiteBP().getSiteInfo(triageInfo);
		if(EnValidator.isEmpty(queSiteArray)){
			Logger.info("分诊台站点为空");
			return null;
		}
		//2.2 过滤不可分诊站点,并按候诊数正序排列
		LinkedList<TriageQueSiteDTO> queSiteList = new LinkedList<TriageQueSiteDTO>();
		//获取站点侯诊数
		TriageQueSiteDTO[] sitesNum = this.getTriSiteNum(triageInfo.getDate(), triageInfo.getId_dayslot(), triageInfo.getId_queben());
		sitesNum = this.retTriSite(triageInfo.getId_queben(),sitesNum);
		for(TriageQueSiteDTO queSite : queSiteArray){
			//如果是离线站点则过滤
			if(EnValidator.isEmpty(queSite.getId_que()) ||
					!PauseEnum.ONLINE.equals(queSite.getEu_pause())){
				continue;
			}
			//医生叫号模式不自动分诊
			if(IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(queSite.getSd_mode()))
				continue;
			//设置分诊数、候诊数
			queSite.setNotriagenum(0);
			queSite.setTriagenum(0);
			queSite.setWaitnum(0);
			if(!EnValidator.isEmpty(sitesNum)){
				for(TriageQueSiteDTO siteNum : sitesNum){
					if(queSite.getId_quesite().equals(siteNum.getId_quesite())){
						queSite.setTriagenum(siteNum.getTriagenum());
						queSite.setWaitnum(siteNum.getWaitnum());
						break;
					}
				}
			}
			//按候诊数排序
			int j = 0;//默认
			for(;j<queSiteList.size();j++){
				if(queSite.getWaitnum()<queSiteList.get(j).getWaitnum()){
					break;
				}						
			}
			queSiteList.add(j,queSite);		
		}
		if(EnValidator.isEmpty(queSiteList)){
			Logger.info("可分诊的站点为空");
			return null;
		}
		 Map<String, List<TriageQueSiteDTO>> mapTemp = EnFMapUtils.getMapList("Id_quesite", queSiteList.toArray(new TriageQueSiteDTO[0]));
		//3 根据队列计算总数和平均数
		//3.1 计算各个队列待分诊总数
		List<EnQueueDO> triagedQueList = new ArrayList<EnQueueDO>();
		for(TriagePatInfoDTO entDTO : waitEntDTOArray){
			//医生叫号模式不自动分诊
			if(IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(entDTO.getSd_mode()))
				continue;
			Iterator<TriageQueSiteDTO> siteIterator = queSiteList.iterator();
			while(siteIterator.hasNext()){
				TriageQueSiteDTO cursite = siteIterator.next();
				if(cursite.getApply_max() <= cursite.getWaitnum())
				{
					//达到最大申请量，从可用站点中移除
					siteIterator.remove();
					continue;
				}
				//分诊到站点
				MtTriageToSiteBP triageToSiteBP = new MtTriageToSiteBP();
				EnQueueDO triagedQue = triageToSiteBP.exec(cursite,entDTO.getId_ent_que());
				if(!EnValidator.isEmpty(triagedQue)){
					triagedQueList.add(triagedQue);
				}
				List<TriageQueSiteDTO> sites = mapTemp.get(cursite.getId_quesite());
				if(!EnValidator.isEmpty(sites)){
					for(TriageQueSiteDTO site : sites){
						site.setWaitnum(site.getWaitnum()+1);//候诊数加1
					}
				}
				siteIterator.remove();
				queSiteList.addLast(cursite);
				break;
			}
		}
		return EnValidator.isEmpty(triagedQueList) ? null:triagedQueList.toArray(new EnQueueDO[]{});
	}
	/**
	 * 查找 工作站的分诊数和候诊数
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	private TriageQueSiteDTO[] getTriSiteNum(FDate date,String dayslotId,String benId) throws BizException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT EQ.ID_QUE_SITE AS ID_QUESITE,");
		builder.append("COUNT(EQ.ID_ENT_QUE） AS TRIAGENUM, ");
		builder.append("SUM(CASE WHEN EQ.SD_STATUS_ACPT IN ('2', '3') THEN 0 ELSE 1 END） AS WAITNUM ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT<> ? AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		builder.append("GROUP BY EQ.ID_QUE_SITE ");
		builder.append("HAVING EQ.ID_QUE_SITE IN ");
		builder.append("(SELECT QS.ID_QUESITE FROM BD_QUE_SITE QS WHERE QS.ID_QUEBEN = ? AND QS.SD_QUESITETP = ?)");
		SqlParam param = new SqlParam();
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		param.addParam(benId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_UNIVERSAL);
		String sql = builder.toString();
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageQueSiteDTO[0]);
		}
		return null;
	}
	
	/***
	 * @Description:重新设置站点对应的候诊人数
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	private TriageQueSiteDTO[] retTriSite(String benId,TriageQueSiteDTO[] sitesNum) throws BizException{
		FMap map = new FMap();
		if(!EnValidator.isEmpty(sitesNum)){
			for(TriageQueSiteDTO site : sitesNum){
				if(!map.containsKey(site.getId_quesite())){
					map.put(site.getId_quesite(), site);
				}
			}
		}
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT QUESITE.ID_QUESITE ");
		sql.append("FROM BD_QUE_SITE QUESITE " );
		sql.append("WHERE QUESITE.SD_QUESITETP = ? " );
		sql.append("AND QUESITE.EU_PAUSE = ? " );
		sql.append("AND QUESITE.ID_QUEBEN = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_UNIVERSAL);
		param.addParam(PauseEnum.ONLINE);
		param.addParam(benId);
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(TriageQueSiteDTO.class));
		List<TriageQueSiteDTO> newlist = new ArrayList<TriageQueSiteDTO>();
		if(!EnValidator.isEmpty(list)){
			for(TriageQueSiteDTO queSite : list){
				if(map.get(queSite.getId_quesite()) != null){
					TriageQueSiteDTO siteNum = (TriageQueSiteDTO)map.get(queSite.getId_quesite());
					queSite.setWaitnum(siteNum.getWaitnum());
					queSite.setTriagenum(siteNum.getTriagenum());
				}else{
					queSite.setTriagenum(0);
					queSite.setWaitnum(0);
				}
				newlist.add(queSite);
			}
			return newlist.toArray(new TriageQueSiteDTO[0]);
		}
		return sitesNum;
	}
}
