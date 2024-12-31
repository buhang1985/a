package iih.en.que.task.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.sc.scbd.i.IScDaysLotService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 
 * 把上一午别签到未接诊的门诊患者移入下一午别队列
 * 
 * @author liubin
 *
 */
public class EntQueDaysLotMoveBP {
	
	private String SCTP = "sctp";
	/**
	 * 执行任务
	 * 
	 * @param map 参数传递
	 * @throws BizException
	 */
	public void executeTask(Map<String, Object> map) throws BizException{
		if(map == null || !map.containsKey(SCTP))
			throw new BizException("定时任务未添加排班类型参数！");
		if (!map.containsKey("orgId") || !map.containsKey("grpId")) {
			throw new BizException("组织机构为空！");
		}
	
		Context.get().setOrgId(	(String)map.get("orgId"));
		Context.get().setGroupId((String)map.get("grpId"));
		//1.获取到排班类型
		String sctp = getSctp(map);
		if(EnValidator.isEmpty(sctp))
			throw new BizException("未获取到排班类型参数！");
		
		//2.获取当前日期分组curDayslot
		DaysLotDO curDayslot = this.getCurDayslot(sctp);
		if(curDayslot == null)
			throw new BizException("未获取到当前日期分组！");
		
		//3.获取当前日期分组之前一个日期分组preDayslot
		DaysLotDO preDayslot = this.getPreDayslot(curDayslot, sctp);
		if(preDayslot == null)
			return;
		
		//4.获取日期分组preDayslot内到诊未接诊患者
		EnQueueDO[] queues = this.getEnQueues(curDayslot, preDayslot);
		if(EnValidator.isEmpty(queues))
			return;
		
		//5.把上一午别preDayslot签到未接诊的门诊患者移入下一午别curDayslot队列
		this.updateQueueDayslot(queues, curDayslot, preDayslot);
	}
	/**
	 * 获取排班分类
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	private String getSctp(Map<String, Object> map) throws BizException{
		Object obj = map.get(SCTP);
		if(obj == null)
			throw new BizException("未获取到排班类型参数！");
		if(obj instanceof UdidocDO){
			return ((UdidocDO)obj).getCode();
		}
		if(obj instanceof String){
			String sctpId = (String) obj;
			UdidocDO scca = ServiceFinder.find(IUdidocRService.class).findById(sctpId); 
			if(scca != null)
				return scca.getCode();
		}
		return null;
	}
	
	/**
	 * 把上一午别preDayslot签到未接诊的门诊患者移入下一午别curDayslot队列
	 * 
	 * @param queues
	 * @param curDayslot
	 * @throws BizException 
	 */
	private void updateQueueDayslot(EnQueueDO[] queues, DaysLotDO curDayslot, DaysLotDO preDayslot) throws BizException{
		if(EnValidator.isEmpty(queues))
			return;
		Set<String> entlist = new HashSet<String>();
		for(EnQueueDO queue : queues){
			entlist.add(queue.getId_ent());
		}
		//获取门诊信息
		Map<String, OutpatientDO> map = getOutpatients(entlist.toArray(new String[0]));
		int levelPri = EnParamUtils.getOpDsLevelPri();
		String levelRsn = String.format("%s号%s接诊", preDayslot.getName(), curDayslot.getName());
		for(EnQueueDO queue : queues){
			queue.setStatus(DOStatus.UPDATED);
			queue.setId_dateslot(curDayslot.getId_dayslot());
			queue.setDt_regist(new FDate(curDayslot.getDef1()));
			queue.setLevel_pri(levelPri);
			queue.setLevel_pri_rsn(levelRsn);
		}
		EnQueEP ep = new EnQueEP();
		ep.save(queues);
	}
	
	private EnQueueDO[] getEnQueues(DaysLotDO curDayslot, DaysLotDO preDayslot) throws BizException{
		FDateTime curTime = EnAppUtils.getServerDateTime();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN_ENT_QUE.* ");
		sb.append("FROM EN_ENT_QUE EN_ENT_QUE INNER JOIN EN_ENT_OP EN_ENT_OP ON EN_ENT_QUE.ID_ENT = EN_ENT_OP.ID_ENT ");
		sb.append("WHERE EN_ENT_QUE.SD_STATUS_ACPT = ? ");
		sb.append("AND EN_ENT_QUE.FG_ACTIVE = ? ");
		sb.append("AND EN_ENT_QUE.SD_ENTQUE_TP = ? ");
		sb.append("AND EN_ENT_QUE.DT_REGIST = ? ");
		sb.append("AND EN_ENT_QUE.ID_DATESLOT = ? ");
		sb.append("AND EN_ENT_OP.DT_VALID_E >= ? ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(new FDate(preDayslot.getDef1()));
		param.addParam(preDayslot.getId_dayslot());
		param.addParam(EnAppUtils.getFDateTime(new FDate(curDayslot.getDef1()), curDayslot.getTime_begin()));
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnQueueDO.class));
		if(!EnValidator.isEmpty(list))
			return list.toArray(new EnQueueDO[0]);
		return null;
	}
	
	
	/**
	 * 获取当前日期分组curDayslot
	 * 
	 * @param sctp
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDayslot(String sctp) throws BizException{
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		return serv.getNowDaysLotCross(sctp, FBoolean.TRUE);
	}
	/**
	 * 获取当前日期分组之前一个日期分组preDayslot
	 * 
	 * @param curDayslot
	 * @param sctp
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getPreDayslot(DaysLotDO curDayslot, String sctp) throws BizException{
		IScDaysLotService serv = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] dayslots = serv.getDaysLotDOs(sctp);
		FDate date = new FDate(curDayslot.getDef1());
		if(EnValidator.isEmpty(dayslots))
			return null;
		DaysLotDO preDayslot = null;
		//如果当前午别为上午需要检查前一天的最后一个午别是否有到诊未接诊现象
		if(curDayslot.getId_dayslot().equals(dayslots[0].getId_dayslot())){
			preDayslot = dayslots[(dayslots.length-1)];
			preDayslot.setDef1(date.getDateBefore(1).toString());
			return preDayslot;
		}
		for(DaysLotDO dayslot : dayslots){
			if(curDayslot.getId_dayslot().equals(dayslot.getId_dayslot()))
				break;
			preDayslot = dayslot;
			preDayslot.setDef1(date.toString());
		}
		return preDayslot;
	}
	/**
	 * 获取门诊就诊信息
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, OutpatientDO> getOutpatients(String[] entIds) throws BizException {
		Map<String, OutpatientDO> map = new HashMap<>();
		if(EnValidator.isEmpty(entIds))
			return map;
		@SuppressWarnings("unchecked")
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().findByAttrValStrings(OutpatientDO.class, OutpatientDO.ID_ENT, entIds, 
				new String[]{OutpatientDO.ID_OUTPATIENT, OutpatientDO.ID_ENT, OutpatientDO.ID_DATESLOT});
		if(!EnValidator.isEmpty(list)){
			for(OutpatientDO op: list)
				if(!map.containsKey(op.getId_ent()))
					map.put(op.getId_ent(), op);
		}
		return map;
	}
}
