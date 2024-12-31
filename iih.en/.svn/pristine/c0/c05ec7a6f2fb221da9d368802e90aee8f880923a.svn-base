package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEndepCudService;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.i.IEnOpCmdService;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 接诊
 * 
 * @author liubin
 *
 */
public class ReceiveBP {
	/**
	 * 接诊
	 * 
	 * @param entId
	 * 		就诊ID
	 * @param queSite
	 * 		出诊站点
	 * @param date
	 * 		当前日期
	 * @param dayslotId
	 * 		当前时间分组ID
	 * @throws BizException
	 */
	public FBoolean exec(String entId, QueSiteDO queSite, String dayslotId, RegResDTO regRes,String reason) throws BizException {
		
		long bz = System.currentTimeMillis();
		EnValidator.validateParam("entQueId", entId);
		EnValidator.validateParam("queSite", queSite);
		EnValidator.validateParam("dayslotId", dayslotId);
		
		this.volidate(queSite);
		
		//判断是否注册站点，未注册站点也能接诊
		boolean isNullSite = EnValidator.isEmpty(queSite.getId_quesite());	
		FDateTime curTime = EnAppUtils.getServerDateTime();
		if(!isNullSite){
			if(!PauseEnum.ONLINE.equals(queSite.getEu_pause()))
				throw new BizException("当前登录站点已离线,不能接诊，请重新登录站点!");
		}
		//0.把当前站点其他就诊状态患者置为诊毕
		this.setDiagEnd(queSite, dayslotId, curTime);
		//1.修改EN_ENT_QUE
		String codeEnTp = this.acptUpdateEQ(entId, queSite, dayslotId, curTime);
		//2.修改EN_ENT
		PatiVisitDO patiVisit = this.acptUpdateEN(entId, queSite, curTime, reason);		
		//3.修改EN_ENT_OP
		this.acptUpdateOP(entId, patiVisit, regRes);
		//4.插入EN_ENT_EMP
		this.acptInsertEMP(entId, queSite.getId_emp(), curTime);
		//5.修改EN_ENT_DEP
		this.acptUpdateDEP(entId, queSite.getId_dep(), curTime);
		//6.记录接诊事件EN_ENT_EVT
		new EnEvtHandle().insertAcptEvt(entId, queSite);
		//7.触发接诊事件
		this.invoke(queSite.getId_que(), queSite.getId_quesite(), codeEnTp, entId);
		long e = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo("          方法ReceiveBP耗时："+(e - bz));
		return FBoolean.TRUE;
	}
	
	/**100039279700
	 * 把当前站点其他就诊状态患者置为诊毕
	 * 
	 * @param siteId
	 * @param dayslotId
	 * @param curTime
	 * @throws BizException
	 */
	private void setDiagEnd(QueSiteDO site, String dayslotId, FDateTime curTime) throws BizException{
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();

		sb.append("SELECT DISTINCT OP.ID_ENT ");
		sb.append("FROM EN_ENT_OP OP INNER JOIN EN_ENT_QUE EQ ON OP.ID_ENT = EQ.ID_ENT ");
		sb.append("WHERE OP.SD_STATUS = ? ");
		param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		sb.append("AND EQ.DT_REGIST  in (?,?) ");
		param.addParam(curTime.getDate());
	    param.addParam(curTime.getDate().getDateAfter(-1));
		sb.append("AND EQ.SD_ENTQUE_TP = ? ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		if(EnValidator.isEmpty(site.getId_quesite())){
			sb.append("AND EQ.ID_EMP_ACPT = ? ");
			param.addParam(site.getId_emp());
		}else{
			sb.append("AND EQ.ID_QUE_SITE = ? ");
			param.addParam(site.getId_quesite());
		}
		String sql = sb.toString();
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(EnValidator.isEmpty(list))
			return;
		OpEP opEP = new OpEP();
		OutpatientDO[] outpatientDOs = opEP.getOutpatientsByDAFacade(list.toArray(new String[0]));
		if(!EnValidator.isEmpty(outpatientDOs)){
			for(OutpatientDO outpatientDO : outpatientDOs){
				outpatientDO.setStatus(DOStatus.UPDATED);
				outpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
			}
			opEP.save(outpatientDOs);
		}
		//更改诊毕时间
		PatiVisitDO[] patiVisitDOs = opEP.getPatiVisitDOByDAFacade(list.toArray(new String[0]));
		if(!EnValidator.isEmpty(patiVisitDOs)){
			for(PatiVisitDO patiVisitDO : patiVisitDOs){
				patiVisitDO.setDt_end(EnAppUtils.getServerDateTime());
				patiVisitDO.setStatus(DOStatus.UPDATED);
			}
			opEP.save(patiVisitDOs);
		}
	}
	
	/**
	 * 修改EN_ENT_QUE
	 * 
	 * @param entQueId
	 * @param queSite
	 * @param dayslotId
	 * @param curTime
	 * @throws BizException
	 */
	private String acptUpdateEQ(String entId, QueSiteDO queSite, String dayslotId, FDateTime curTime) throws BizException{
		EnQueEP bp = new EnQueEP();
		String whereStr = String.format("ID_ENT = '%s' AND SD_ENTQUE_TP = '%s' ",entId, IBdFcDictCodeConst.SD_QUETP_EMP);
		EnQueueDO[] enQueues = bp.getEnQueueByDAFacade(whereStr, null);
		if(!EnValidator.isEmpty(enQueues)){
			EnQueueDO enQueue = enQueues[0];
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
			enQueue.setId_que_site(queSite.getId_quesite());
			enQueue.setId_emp_acpt(queSite.getId_emp());
			enQueue.setName_emp_acpt(queSite.getEmp_name());
			enQueue.setDt_acpt(curTime);
			if(enQueue.getSortno_called()==null || enQueue.getSortno_called() == 0){
				String queId = EnValidator.isEmpty(queSite.getId_que()) ? enQueue.getId_que() : queSite.getId_que();
				enQueue.setSortno_called(this.getMaxSortnoCalled(queId, queSite.getId_quesite(), curTime.getDate(), dayslotId)+1);
			}
			if(EnParamUtils.isTriageToEmp())
				enQueue.setId_emp_opreg(queSite.getId_emp());
			else
				enQueue.setId_emp_opreg(null);
			bp.updateWithDAFcade(new EnQueueDO[]{enQueue});
		}else{
			throw new BizException(IEnMsgConst.ERROR_ACPT_WRONG);
		}
		return enQueues[0].getCode_entp();
	}
	
	/**
	 * 修改EN_ENT
	 * 
	 * @param entId
	 * @param queSite
	 * @param curTime
	 * @throws BizException
	 */
	private PatiVisitDO acptUpdateEN(String entId, QueSiteDO queSite, FDateTime curTime, String reason) throws BizException{
		PvEP bp = new PvEP();
		PatiVisitDO patiVisit = bp.getPvByPK(entId);
		if(patiVisit!=null){
			patiVisit.setStatus(DOStatus.UPDATED);
			patiVisit.setFg_acptvalid(FBoolean.TRUE);
			patiVisit.setId_emp_phy(queSite.getId_emp());
			patiVisit.setDt_end(null);
			if(patiVisit.getDt_acpt() == null){
				patiVisit.setDt_acpt(curTime);
			}
			if(!EnValidator.isEmpty(reason)){
				patiVisit.setNote(reason);
			}
			PatiVisitDO[] patiVisits = new PvEP().save(new PatiVisitDO[]{patiVisit});
			if(!EnValidator.isEmpty(patiVisits))
				return patiVisits[0];
		}
		throw new BizException(IEnMsgConst.ERROR_ACPT_WRONG);
	}
	
	/**
	 * 修改EN_ENT_OP
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void acptUpdateOP(String entId, PatiVisitDO patVisit,RegResDTO regRes) throws BizException{
		OpEP bp = new OpEP();
		OutpatientDO outpatient = bp.getOpByEntIdWithOutRef(entId);
		if(outpatient == null){
			throw new BizException(IEnMsgConst.ERROR_ACPT_WRONG);
		}
		outpatient.setStatus(DOStatus.UPDATED);
		outpatient.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
		outpatient.setFg_needrtn(FBoolean.FALSE);
		//未挂号分诊患者记账
		noRegTriageAccount(patVisit, outpatient,regRes);
		
		bp.save(outpatient);
		//把预约未取号患者置为取号
		this.setAptToFinish(outpatient.getId_schapt());
	}
	
	/**
	 * 插入EN_ENT_EMP
	 * 
	 * @param entId
	 * @param empId
	 * @param curTime
	 * @throws BizException
	 */
	private void acptInsertEMP(String entId, String empId, FDateTime curTime) throws BizException{
		EnPsnDO enPsnDO = new EnPsnDO();
		enPsnDO.setId_ent(entId);
		enPsnDO.setId_emp(empId);
		enPsnDO.setId_emprole(IEnDictCodeConst.ID_EMPROLE_OPDOC);
		enPsnDO.setSd_emprole(IEnDictCodeConst.SD_EMPROLE_OPDOC);
		enPsnDO.setDt_b(curTime);
		enPsnDO.setStatus(DOStatus.NEW);
		ServiceFinder.find(IEnpsnCudService.class).save(new EnPsnDO[] { enPsnDO });
	}
	
	/**
	 * 修改EN_ENT_DEP
	 * 
	 * @param entId
	 * @param depId
	 * @param curTime
	 * @throws BizException
	 */
	private void acptUpdateDEP(String entId, String depId, FDateTime curTime) throws BizException{
		String whereStr = String.format("ID_ENT='%s' AND ID_DEP='%s'", entId, depId);
		List<EnDepDO> list = (List<EnDepDO>) new DAFacade().findByCond(EnDepDO.class, whereStr, "id_ent");
		if (EnValidator.isEmpty(list)) {
			EnDepDO enDepDO = new EnDepDO();
			enDepDO.setStatus(DOStatus.NEW);
			enDepDO.setId_ent(entId);
			enDepDO.setId_dep(depId);
			enDepDO.setSd_entdeprole(IEnDictCodeConst.SD_ENTDEPROLE_DEP);
			enDepDO.setId_dep_from(null);
			enDepDO.setId_dep_to(null);
			enDepDO.setDt_b(curTime);
			enDepDO.setDt_e(null);
			enDepDO.setFg_admit(FBoolean.FALSE);
			enDepDO.setFg_discharge(FBoolean.FALSE);
			enDepDO.setSd_status(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC);
			enDepDO.setDt_dcg_bill(null);
			IEndepCudService depCudService = ServiceFinder.find(IEndepCudService.class);
			depCudService.save(new EnDepDO[] { enDepDO });
		}
	}
	
	
	
	/**
	 * 查询站点最大的叫号序号
	 * 
	 * @return
	 * @throws BizException
	 */
	private int getMaxSortnoCalled(String queId, String queSiteId, FDate date, String dayslotId) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT ISNULL(MAX(EQ.SORTNO_CALLED),0) ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.ID_QUE = ? ");
		param.addParam(queId);
		if(!EnValidator.isEmpty(queSiteId)){
			builder.append("AND EQ.ID_QUE_SITE = ? ");
			param.addParam(queSiteId);
		}
		builder.append("AND EQ.ID_DATESLOT = ? ");
		param.addParam(dayslotId);
		builder.append("AND EQ.DT_REGIST = ? ");
		param.addParam(date);
		String sql = builder.toString();
		return (int) new DAFacade().execQuery(sql, param, new ColumnHandler());
	}
	/**
	 * 把预约未取号患者置为取号
	 * 
	 * @param aptId
	 * @throws BizException
	 */
	private void setAptToFinish(String aptId) throws BizException{
		if(EnValidator.isEmpty(aptId))
			return;
		DAFacade df = new DAFacade();
		ScAptDO apt = (ScAptDO) df.findByPK(ScAptDO.class, aptId);
		if(apt == null)
			return;
		if(FBoolean.TRUE.equals(apt.getFg_canc()))
			return;
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status()) 
				|| IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(apt.getSd_status()))
			return;
		apt.setStatus(DOStatus.UPDATED);
		apt.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH);
		apt.setId_status(IScDictCodeConst.ID_APTSTATUS_FINISH);
		df.updateDO(apt);
	}
	/**
	 * 未挂号分诊患者记账
	 * 
	 * @param patiVisit
	 * @param outpatient
	 * @throws BizException 
	 */
	private void noRegTriageAccount(PatiVisitDO patiVisit, OutpatientDO outpatient,RegResDTO regRes) throws BizException{
		if(!EuRegTp.NOREGTRIAGE.equals(outpatient.getEu_regtp()))
			return;
		if(!EnValidator.isEmpty(outpatient.getId_cg()))
			return;
		regRes.setId_dep(patiVisit.getId_dep_phy());
		RegInfoDTO regInfo = new RegInfoDTO();	
		regInfo.setId_pat(patiVisit.getId_pat());
		regInfo.setId_ent(patiVisit.getId_ent());
		regInfo.setCode_entp(patiVisit.getCode_entp());
		regInfo.setId_patca(patiVisit.getId_patca());
		regInfo.setId_pripat(patiVisit.getId_pripat());
		regInfo.setId_patcredtp(patiVisit.getId_patcret());
		regInfo.setId_hp(patiVisit.getId_hp());
		regInfo.setRegresarray(EnAppUtils.doArray2List(regRes));//绑定挂号资源
		IEnOpCmdService serv = ServiceFinder.find(IEnOpCmdService.class);
		String cgId = serv.registAccount(regInfo);
		if(EnValidator.isEmpty(cgId))
			throw new BizException("记账失败!");
		outpatient.setId_cg(cgId);
		outpatient.setId_scsrv(regRes.getId_scsrv());
		outpatient.setFg_cg(FBoolean.TRUE);
	}
	
	/**
	 * 获取站点并验证
	 * 
	 * @param siteId
	 * @return
	 * @throws BizException 
	 */
	private void volidate(QueSiteDO site) throws BizException{
		if(site == null)
			throw new BizException("登录站点为空不能接诊!");
	}
	
	/**
	 * 触发事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invoke(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_DOC_ACPT);
	}
}
