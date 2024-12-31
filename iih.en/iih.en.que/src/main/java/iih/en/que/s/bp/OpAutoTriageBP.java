package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EntQueStatus;
import iih.en.que.s.bp.op.qry.benmgr.GetTriageSite4BenMgrBP;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门急诊-自动分诊BP
 * @author yankan
 * @since 2015-11-28
 *
 */
public class OpAutoTriageBP {
	/**
	 * 自动分诊
	 * @param triageInfo 分诊台
	 * @throws BizException
	 */
	public void exec(TriageBenInfoDTO triageInfo) throws BizException{
		if(triageInfo == null 
				|| EnValidator.isEmpty(triageInfo.getId_queben()) 
				|| EnValidator.isEmpty(triageInfo.getId_dayslot()))	
			return;			
		//1、获取分诊台签到的就诊列表
		GetWaitingByBenBP getWaitingByBenBP = new GetWaitingByBenBP();
		TriageEntDTO[] waitEntDTOArray = getWaitingByBenBP.exec(triageInfo, triageInfo.getId_dayslot(), EntQueStatus.Arrived,null);
		if(EnValidator.isEmpty(waitEntDTOArray)){
			Logger.info("签到的就诊患者为空");
			return;
		}
		this.autoTriageSite(waitEntDTOArray, triageInfo, null);
	}
	
	/**
	 * 给某个患者自动分诊
	 * @param benId 分诊台id
	 * @param dayslotId 日期分组id
	 * @throws BizException
	 */
	public FMap exec2(TriageBenInfoDTO triageInfo, String entId) throws BizException{
		FMap map = new FMap();
		if(triageInfo == null 
				|| EnValidator.isEmpty(triageInfo.getId_queben()) 
				|| EnValidator.isEmpty(triageInfo.getId_dayslot())
				|| EnValidator.isEmpty(entId))	
			return map;		
		//1、获取分诊台签到的就诊列表
		GetWaitingByBenBP getWaitingByBenBP = new GetWaitingByBenBP();
		TriageEntDTO[] waitEntDTOArray = getWaitingByBenBP.exec(triageInfo, triageInfo.getId_dayslot(), EntQueStatus.Arrived,entId);
		if(EnValidator.isEmpty(waitEntDTOArray)){
			Logger.info("签到的就诊患者为空");
			return map;
		}
		this.autoTriageSite(waitEntDTOArray, triageInfo,map);
		return map;
	}

	/**
	 * 自动分诊
	 * @param waitEntDTOArray
	 * @param benId
	 * @param dayslotId
	 * @throws BizException
	 */
	private void autoTriageSite(TriageEntDTO[] waitEntDTOArray,TriageBenInfoDTO triageInfo, FMap map) throws BizException{
		//2、准备站点数据
		//2.1、获取分诊台站点
		//是否是分诊台管理队列
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		List<TriageQueSiteDTO> queSiteArray = null;
		if(isBenQueMgr){
			queSiteArray = new GetTriageSite4BenMgrBP().getSiteInfo(triageInfo);
		}else{
			queSiteArray = new GetTriageSiteBP().getSiteInfo(triageInfo);
		}
		if(EnValidator.isEmpty(queSiteArray)){
			Logger.info("分诊台站点为空");
			return;
		}
		//2.2 过滤不可分诊站点,并按候诊数正序排列
		LinkedList<TriageQueSiteDTO> queSiteList = new LinkedList<TriageQueSiteDTO>();
		//获取站点侯诊数
		TriageQueSiteDTO[] sitesNum = this.getTriSiteNum(triageInfo.getDate(), triageInfo.getId_dayslot(), triageInfo.getId_queben());
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
			return;
		}
		 Map<String, List<TriageQueSiteDTO>> mapTemp = EnFMapUtils.getMapList("Id_quesite", queSiteList.toArray(new TriageQueSiteDTO[0]));
		//3 根据队列计算总数和平均数
		//3.1 计算各个队列待分诊总数
		for(TriageEntDTO entDTO : waitEntDTOArray){
			//需手动分诊，则过滤
			if(FBoolean.TRUE.equals(entDTO.getFg_manual())){
				continue;
			}
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
				if(entDTO.getId_que().equals(cursite.getId_que())){
					//分诊到站点
					TriageToSiteBP triageToSiteBP = new TriageToSiteBP();
					triageToSiteBP.exec(cursite,entDTO.getId_entque(), FBoolean.TRUE, triageInfo, map);
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
			
		}
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
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(benId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		String sql = builder.toString();
		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new TriageQueSiteDTO[0]);
		}
		return null;
	}
}
/**
 * 队列对象
 * @author Administrator
 *
 */
class QueForTriage{
	//队列id
	private String id_que;
	//站点总数
	private Integer siteCount;
	//候诊总数
	private Integer waitCount;
	//待分诊
	private Integer needTriage;
	//分诊平均数
	private Integer triagedAvg;
	//余数
	private Integer remainder;
	public String getId_que() {
		return id_que;
	}
	public void setId_que(String id_que) {
		this.id_que = id_que;
	}
	public Integer getSiteCount() {
		return siteCount;
	}
	public void setSiteCount(Integer siteCount) {
		this.siteCount = siteCount;
	}
	public Integer getWaitCount() {
		return waitCount;
	}
	public void setWaitCount(Integer waitCount) {
		this.waitCount = waitCount;
	}
	public Integer getNeedTriage() {
		return needTriage;
	}
	public void setNeedTriage(Integer needTriage) {
		this.needTriage = needTriage;
	}
	public Integer getTriagedAvg() {
		return triagedAvg;
	}
	public void setTriagedAvg(Integer triagedAvg) {
		this.triagedAvg = triagedAvg;
	}
	public Integer getRemainder() {
		return remainder;
	}
	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}


	public QueForTriage(){
		this.siteCount = 0;
		this.waitCount = 0;
		this.needTriage = 0;
		this.triagedAvg =0;
		this.remainder = 0;
	}
}
