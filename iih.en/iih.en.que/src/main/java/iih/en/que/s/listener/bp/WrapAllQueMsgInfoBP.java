package iih.en.que.s.listener.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.ScripRulConst;
import iih.en.comm.ep.BdQueBenEP;
import iih.en.comm.ep.EnBrdEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.bp.GetBrdNameRulScripBP;
import iih.sc.scbd.i.IScDaysLotService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

import com.mysql.jdbc.StringUtils;

public class WrapAllQueMsgInfoBP {

	/***
	 * @Description:
	 * @param allQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	public AllQue4EsDTO wrap(AllQue4EsDTO allQue4EsDTO) throws BizException{
		DaysLotDO dayslot = this.getCurDaysLot();
		String dayslotId = dayslot==null? null : dayslot.getId_dayslot();
		FDate curDate = (dayslot == null || EnValidator.isEmpty(dayslot.getDef1())) ? EnAppUtils.getServerDate() : new FDate(dayslot.getDef1());
		EnQueueDO enque = EnValidator.isEmpty(allQue4EsDTO.getId_entque()) ? null : new EnQueEP().getEnQueueById(allQue4EsDTO.getId_entque());
		String id_ben = enque == null || StringUtils.isNullOrEmpty(enque.getId_queben()) ? allQue4EsDTO.getId_ben() : enque.getId_queben();
		//设置分诊台屏幕地址
		this.setBrdAddr(allQue4EsDTO,id_ben);
		//设置到诊未分诊患者
		this.setArriedQuenos(allQue4EsDTO,id_ben,curDate,dayslotId);
		return allQue4EsDTO;
	}
	
	/***
	 * @Description:设置分诊台屏幕地址
	 * @param allQue4EsDTO
	 * @param enque
	 * @throws BizException
	 */
	private void setBrdAddr(AllQue4EsDTO allQue4EsDTO,String id_ben) throws BizException{
		if(StringUtils.isNullOrEmpty(id_ben)){
			return;
		}
		QueBenDO queBenDO = new BdQueBenEP().findById(id_ben);
		if(queBenDO == null){
			EnLogUtil enLog = EnLogUtil.getInstance();
			enLog.logInfo("通用分诊门诊大屏到诊/取消到诊获取就诊队列的工作台为空，Id_queben为："+id_ben);
		}
		allQue4EsDTO.setAddr_board_ben(queBenDO.getAddr_board());
	}

	/***
	 * @Description:设置到诊未分诊患者
	 * @param allQue4EsDTO
	 * @throws BizException
	 */
	private void setArriedQuenos(AllQue4EsDTO allQue4EsDTO,String id_ben,FDate curDate,String dayslotId) throws BizException{
		String arriedQuenos = null;
		if(StringUtils.isNullOrEmpty(id_ben)){
			allQue4EsDTO.setArriedquenos(arriedQuenos);
			return;
		}
		EnQueueDO[] enQueueDOs = this.arrivedPat(id_ben,curDate,dayslotId);
		if(enQueueDOs == null || enQueueDOs.length <= 0){
			allQue4EsDTO.setArriedquenos(arriedQuenos);
			return;
		}
		List<String> nosArrivedList = new ArrayList<String>();
		FMap map = new FMap();
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		for(EnQueueDO quedo : enQueueDOs){
			if(!map.containsKey(quedo.getId_pat())){
				map.put(quedo.getId_pat(), quedo.getName_pat());
				String name_pat = quedo.getName_pat();
				name_pat = bp.exec(name_pat,ScripRulConst.BRD_OP_SHOW_NAME,ScripRulConst.ARRIVEDPAT);
				nosArrivedList.add(name_pat);
			}
		}
		arriedQuenos = nosArrivedList.toString();
		if(!StringUtils.isNullOrEmpty(arriedQuenos)){
			arriedQuenos = arriedQuenos.replace("[", "").replace("]", "").replace(" ", "");
			if(arriedQuenos.length() > 2800){
				arriedQuenos = arriedQuenos.substring(0, 2800);
			}
		}
		allQue4EsDTO.setArriedquenos(arriedQuenos);
	}
	
	/***
	 * @Description:获取某个分诊台下的通用到诊队列
	 * @param id_queben
	 * @return
	 * @throws BizException 
	 */
	private EnQueueDO[] arrivedPat(String id_queben,FDate curDate,String dayslotId) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("SELECT ENQUE.ID_ENT_QUE,ENQUE.ID_PAT,ENQUE.NAME_PAT ");
		sql.append("FROM EN_ENT_QUE ENQUE " );
		sql.append("WHERE ENQUE.ID_QUEBEN = ? " );
		sql.append("AND ENQUE.SD_ENTQUE_TP = ? " );
		sql.append("AND ENQUE.SD_STATUS_ACPT = ? " );
		sql.append("AND ENQUE.DT_REGIST = ? " );
		sql.append("AND ENQUE.ID_DATESLOT = ? " );
		sql.append("AND ENQUE.ID_QUE_SITE IS NULL " );
		sql.append("ORDER BY DT_IN ASC ");
		param.addParam(id_queben);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(curDate);
		param.addParam(dayslotId);
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(EnQueueDO.class));
		return list != null && list.size() > 0 ? list.toArray(new EnQueueDO[]{}):null;
	}
	/**
	 * 获取当前日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDaysLot() throws BizException{
		IScDaysLotService scDayslotServ = ServiceFinder.find(IScDaysLotService.class);
		return scDayslotServ.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_TY, FBoolean.TRUE);
	}

	/***
	 * @Description:
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 */
	public EnBrdSiteDO[] wrapSiteMsgInfo(AllQue4EsDTO allQue4EsDTO){
		if(StringUtils.isNullOrEmpty(allQue4EsDTO.getAddr_board_ben())){
			return null;
		}
		try{
			EnBrdEP ep = new EnBrdEP();
			EnBrdSiteDO[] enBrdSiteDOs = ep.findByAddr(allQue4EsDTO.getAddr_board_ben());
			if(enBrdSiteDOs != null && enBrdSiteDOs.length > 0){
				for(EnBrdSiteDO brdsite :enBrdSiteDOs){
					if(!BrdStatusEnum.DEL.equals(brdsite.getEu_status())){
						brdsite.setEu_status(BrdStatusEnum.UPDATE);
					}
					brdsite.setDt_lastmdf(EnAppUtils.getServerDateTime());
					brdsite.setNos_arrived(allQue4EsDTO.getArriedquenos());
					brdsite.setStatus(DOStatus.UPDATED);
				}
				ep.save(enBrdSiteDOs);
				return enBrdSiteDOs;
			}else{
				EnBrdSiteDO enBrdSiteDO = new EnBrdSiteDO();
				enBrdSiteDO.setId_grp(EnContextUtils.getGrpId());
				enBrdSiteDO.setId_org(EnContextUtils.getOrgId());
				enBrdSiteDO.setDt_lastmdf(EnAppUtils.getServerDateTime());
				enBrdSiteDO.setAddr_brd(allQue4EsDTO.getAddr_board_ben());
				enBrdSiteDO.setNos_arrived(allQue4EsDTO.getArriedquenos());
				enBrdSiteDO.setEu_status(BrdStatusEnum.ADD);
				enBrdSiteDO.setStatus(DOStatus.NEW);
				ep.save(new EnBrdSiteDO[]{enBrdSiteDO});
				return new EnBrdSiteDO[]{enBrdSiteDO};
			}
		}catch (Exception e) {
			EnLogUtil logUtil = EnLogUtil.getInstance();
			logUtil.logError("修改显示屏站点表出错:", e);
		}
		return null;
	}
	
	/***
	 * @Description:
	 * @param allQue4EsDTO
	 * @param eventType
	 * @return
	 */
	public EnBrdCallDO[] wrapCallMsgInfo(AllQue4EsDTO allQue4EsDTO, String eventType){
		return null;
	}
}
