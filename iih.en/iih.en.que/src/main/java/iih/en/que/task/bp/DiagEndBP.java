package iih.en.que.task.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.d.desc.EnPsnDODesc;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.i.IEnQueOutQryService;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 诊毕BP
 * 
 * @author liubin
 *
 */
public class DiagEndBP {
	private static final String ORG_ID = "orgId";
	private static final String DIAG_END_DAYS = "diag_end_days";
	/**
	 * 把长时间未诊毕病人设置为诊毕
	 * 
	 * @throws BizException
	 */
	public void executeTask(Map<String, Object> map) throws BizException {
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		if(dateTime == null){
			throw new BizException("定时诊毕任务：获取当前时间失败！");
		}
		String orgId = (String)map.get(ORG_ID);
		if(EnValidator.isEmpty(orgId)){
			throw new BizException("定时诊毕任务：任务部署未设置组织！");
		}
		Context.get().setOrgId(orgId);
		String  paramDays = (String)map.get(DIAG_END_DAYS);
		int diagEndDays = 1;
		if(!EnValidator.isEmpty(paramDays))
			diagEndDays = Integer.parseInt(paramDays);
		//设置EN_ENT_OP表定时诊毕（包括门诊患者，急诊抢救患者）
		this.setEntOpDiagEnd(dateTime, diagEndDays, map);
		//设置已经挂号预检诊毕
		this.setFlowErPreDiagEnd(dateTime, diagEndDays);
	}
	
	/**
	 * 设置EN_ENT_OP表定时诊毕（包括门诊患者，急诊抢救患者）
	 * 
	 * @param dateTime
	 * @throws BizException
	 */
	private void setEntOpDiagEnd(FDateTime dateTime, int diagEndDays, Map<String, Object> map) throws BizException{
		// 把长时间未诊毕病人设置为诊毕
		int maxDiTimes = EnParamUtils.getOpMaxDiPeriodm();//获取门诊医生诊断最大时长，以分钟为单位
		if(maxDiTimes > 0) {
			String[] entIds = this.getNoFinishEnt(dateTime, maxDiTimes, diagEndDays);
			if(!EnValidator.isEmpty(entIds)){
				//1 设置EN_ENT_OP表中状态为诊毕（接诊状态）
				this.updateOpStatus(entIds);
				//2设置EN_ENT_EMP表中诊毕时间
				updateDtEnd(entIds,maxDiTimes);
				//3 发送诊毕事件
				try {
					fireDiagEndEvents(entIds);
				}catch (Exception e) {
					EnLogUtil.getInstance().logError("定时诊毕发送诊毕事件失败",e);
				}
			}
		}
	}
	
	private void fireDiagEndEvents(String[] entIds) throws BizException {
		EnLogUtil.getInstance().logInfo("定时诊毕发送诊毕事件");
		IEnQueOutQryService serv = ServiceFinder.find(IEnQueOutQryService.class);
		for (String entId : entIds) {
			OpQue4EsDTO opQue4EsDTO = serv.getOpQue4EsDTO(entId, null, null);
			opQue4EsDTO.setFg_auto_diagend(FBoolean.TRUE);
			BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_DIAGEND, opQue4EsDTO);
			EventDispatcher.fireEvent(opRegEvent);
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				EnLogUtil.getInstance().logError(e.getMessage());
			}
		}
	}

	/**
	 * 设置已经挂号预检诊毕
	 * 
	 * @param dateTime
	 * @param diagEndDays
	 * @throws BizException
	 */
	private void setFlowErPreDiagEnd(FDateTime dateTime, int diagEndDays) throws BizException {
		//获取需要诊毕的预检
		EnErPreDO[] pres = this.getNoFinishPres(dateTime, diagEndDays);
		//把预检设为诊毕
		this.updateErPre(pres, dateTime);	
	}
	/**
	 * 获取需要自动诊毕的患者
	 * 
	 * @param dateTime
	 * @param maxDiTime
	 * @return
	 * @throws BizException
	 */
	private String[] getNoFinishEnt(FDateTime dateTime, int maxDiTime, int diagEndDays) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT OP.ID_ENT ");
		sb.append("FROM EN_ENT EN ");
		sb.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append("INNER JOIN (SELECT EMP.*, ");
		sb.append("ROW_NUMBER() OVER(PARTITION BY EMP.ID_ENT ORDER BY EMP.DT_B DESC) AS NEW_INDEX ");
		sb.append("FROM EN_ENT_EMP EMP ");
		sb.append("WHERE ISNULL(EMP.DT_E, '~') = '~') EN_ENT_EMP ");
		sb.append("ON OP.ID_ENT = EN_ENT_EMP.ID_ENT ");
		sb.append("WHERE EN_ENT_EMP.NEW_INDEX = 1 ");
		sb.append("AND EN.CODE_ENTP IN (?,?) ");
		sb.append("AND EN_ENT_EMP.DT_B >= ? ");
		sb.append("AND EN_ENT_EMP.DT_B < ? ");
		sb.append("AND OP.SD_STATUS = ? ");
		sb.append("AND NOT EXISTS (SELECT * FROM EN_ENT_OP_ER ER WHERE ER.ID_ENT = EN.ID_ENT AND ER.FG_TRANS = 'Y')");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW);
		param.addParam(dateTime.getDate().getDateBefore(diagEndDays).asLocalBegin());
		param.addParam(dateTime.addSeconds(-(maxDiTime*60)));
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list))
			return list.toArray(new String[0]);
		return null;
	}
	/**
	 * 获取需要诊毕的预检
	 * 
	 * @param dateTime
	 * @param diagEndDays
	 * @return
	 * @throws BizException
	 */
	private EnErPreDO[] getNoFinishPres(FDateTime dateTime, int diagEndDays) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ERPRE.* ");
		sb.append(" FROM EN_ERPRE ERPRE ");
		sb.append(" INNER JOIN EN_ENT EN ON ERPRE.ID_ENT_LAST = EN.ID_ENT ");
		sb.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sb.append(" INNER JOIN EN_ENT_OP_ER ER ON ER.ID_ENT = OP.ID_ENT ");
		sb.append(" WHERE EN.FG_CANC = 'N' ");
		sb.append(" AND ERPRE.SD_STATUS = ? ");
		sb.append(" AND EN.CODE_ENTP =  ? ");
		sb.append(" AND OP.DT_VALID_E < ? ");
		sb.append(" AND ERPRE.DT_ENTRY >= ? ");
		sb.append(" AND ER.FG_TRANS = 'N' ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW);
		param.addParam(dateTime);
		param.addParam(dateTime.getDate().getDateBefore(diagEndDays).asLocalBegin());
		List<EnErPreDO> list = (List<EnErPreDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnErPreDO.class));
		if(!EnValidator.isEmpty(list))
			return list.toArray(new EnErPreDO[0]);
		return null;
	}
	/**
	 * 把长时间未诊毕病人(接诊状态05)设置为诊毕<br/>
	 * 设置EN_ENT_OP表中状态为诊毕
	 * 
	 * @param dateTime
	 * 			当前时间
	 * @param maxDiTime
	 * 			门诊医生诊断最大时长，以分钟为单位
	 * @throws BizException 
	 */
	private void updateOpStatus(String[] entIds) throws BizException {
		//查找长时间未诊毕病人
		OpEP ep = new OpEP();
		OutpatientDO[] outpatientDOs = ep.getOutpatientsByDAFacade(entIds);
		if(!EnValidator.isEmpty(outpatientDOs)){
			for(OutpatientDO outpatientDO : outpatientDOs){
				outpatientDO.setStatus(DOStatus.UPDATED);
				outpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
			}
			new DAFacade().updateDOs(outpatientDOs);
		}
	}

	/**
	 * 把长时间未诊毕病人设置为诊毕<br/>
	 * 设置EN_ENT_EMP表中诊毕时间
	 * 
	 * @param dateTime
	 * 			当前时间
	 * @param maxDiTime
	 * 			门诊医生诊断最大时长，以分钟为单位
	 * @throws BizException 
	 */
	private void updateDtEnd(String[] entIds, int maxDiTime) throws BizException {
		String whereStr = String.format("ISNULL(%s.DT_E,'~') = '~' ", EnPsnDODesc.TABLE_ALIAS_NAME);
		whereStr += " AND " + SqlUtils.getInSqlByBigIds(EnPsnDODesc.TABLE_ALIAS_NAME + "." + EnPsnDO.ID_ENT, entIds);
		IEnpsnRService empRServ = ServiceFinder.find(IEnpsnRService.class);
		EnPsnDO[] enPsnDOs = empRServ.find(whereStr, null, FBoolean.FALSE);
		if(!EnValidator.isEmpty(enPsnDOs)){
			for(EnPsnDO enPsnDO : enPsnDOs){
				enPsnDO.setStatus(DOStatus.UPDATED);
				enPsnDO.setDt_e(enPsnDO.getDt_b().addSeconds(maxDiTime*60));
			}
			new DAFacade().updateDOs(enPsnDOs);
		}
	}
	/**
	 * 把预检设为诊毕
	 * 
	 * @param erPres
	 * @throws BizException
	 */
	private void updateErPre(EnErPreDO[] erPres, FDateTime dateTime) throws BizException{
		if(EnValidator.isEmpty(erPres))
			return;
		for(EnErPreDO erpre : erPres){
			erpre.setStatus(DOStatus.UPDATED);
			erpre.setDt_end(dateTime);
			erpre.setSd_status(IEnDictCodeConst.SD_STATUS_ERPRE_END);
		}
		new ErPreEP().save(erPres);
	}
}
