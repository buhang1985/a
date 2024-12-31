package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.itf.dto.regincinfo.d.RegIncDTO;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.EntDiEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.d.desc.EnDepDODesc;
import iih.en.pv.enres.d.desc.EnPsnDODesc;
import iih.en.pv.enres.i.IEndepCudService;
import iih.en.pv.enres.i.IEndepRService;
import iih.en.pv.enres.i.IEnpsnCudService;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.i.IEnOpCmdService;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取消接诊BP
 * @author liubin
 *
 */
public class CancRecptBP {
	/**
	 * 取消接诊
	 * @param docId 医生id
	 * @param depId 科室id
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public FBoolean exec(String docId,String depId,String entId) throws BizException{
		EnValidator.validateParam("entId", entId);
		PatiVisitDO pvDO = this.getPv(entId);
		OutpatientDO op = this.getOp(entId);
		//校验就诊状态
		if(!IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(op.getSd_status())){
			throw new BizException("患者当前未被接诊，不可以取消接诊！");
		}
		//1.判断是否在有效期
//		FDateTime curTime = EnAppUtils.getServerDateTime();
//		if(curTime.compareTo(op.getDt_valid_b()) < 0 || curTime.compareTo(op.getDt_valid_e()) > 0)
//			throw new BizException(String.format(IEnMsgConst.ERROR_CANC_OUT_VALIDITY, op.getDt_valid_b(), op.getDt_valid_e()));
		
		// 取消接诊时校验是否存在有效医嘱，fanlq-20170822
		ICiOrdEnService service = ServiceFinder.find(ICiOrdEnService.class);
		if (service.isExistValidOrders(entId, "0").equals(FBoolean.TRUE)) {
			throw new BizException("患者当前存在有效医嘱，不可以取消接诊！");
		}
		
		//2、校验诊断
		if(this.hasDi(entId)){
			return FBoolean.FALSE;
		}
		//3、更新队列未到诊状态		
		EnQueueDO enQue = this.getEnQue(entId, docId);
		if(enQue == null) {
			return FBoolean.FALSE;
		}
		String queId = enQue.getId_que();
		String siteId = enQue.getId_que_site();
		
		this.updateEnQue(enQue);
		//4、是否首次接诊
		if(this.isFirstRect(entId, docId)){
			//挂号费是否结算
			boolean isSettle = this.hasSettled(op.getId_cg());
			//删除就诊记录
			this.updateEnt(entId);
			this.updateEntOP(op, isSettle);
			this.deteleEnDep(entId, depId);
			//是否退号标志，默认false
			boolean isCancReg = false;
			//如果是当前医生诊间挂号接诊(包括未挂号分诊)
			//根据挂号费是否结算及挂号模式判断，是否需退号
			if((EuRegTp.CONSULTINGROOM.equals(op.getEu_regtp()) 
					|| EuRegTp.FREENOSCH.equals(op.getEu_regtp())) 
					&& EnContextUtils.getPsnId().equals(pvDO.getId_emp_entry())){
				//已结算的
			    if(isSettle){
			    	//如果接诊是结算模式，调用bl接口判断是否退号，记账模式不退号
			    	//参数ENOP0025
			    	if (Boolean.TRUE.equals(EnParamUtils.isOpinregSt(depId))) {
			    		//调用费用的接口，返回为true，则执行退号操作
			    		IBlOpChargeForEnInnerService iService = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
			    		RegIncDTO incDTO = iService.getRegIncInfo(op.getId_ent());
						if(!EnValidator.isEmpty(incDTO) && !EnValidator.isEmpty(incDTO.getIncno_paper())){
							isCancReg = false;
						}else{
							isCancReg = iService.isClinicRetNo(entId);
						}
					}else {
						//记账模式，不能执行退号操作，需提示到收费处进行退号，此处未给出提示
					}
			    }else{//未结算的，需退号
			    	isCancReg = true;
				}
			}
			//执行退号
			if(isCancReg){
				IEnOpCmdService opCmdService = ServiceFinder.find(IEnOpCmdService.class);
				opCmdService.cancRegByEntId(entId);
			}
			if(EuRegTp.NOREGTRIAGE.equals(op.getEu_regtp())){
				IEnOpCmdService opCmdService = ServiceFinder.find(IEnOpCmdService.class);
				opCmdService.cancRegByEntId(entId);
			}
		}
		//4.2　如果不是首次接诊，删除就诊医生记录
		this.deteleEnEmp(entId, docId);
		//5.触发取消接诊事件
		this.invoke(queId, siteId, enQue.getCode_entp(), entId);
		
		return FBoolean.TRUE;
	}
	
	/**
	 * 判断是否有诊断
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean hasDi(String entId) throws BizException {
		boolean result = false;
		EntDiEP ep = new EntDiEP();
		EntDiDO[] entDis = ep.getEntDiByEntId(entId);
		if(!EnValidator.isEmpty(entDis)){
			throw new BizException(IEnMsgConst.ERROR_NO_CANCEL_ACPT_DI);
		}
		return result;
	}
	/**
	 * 判断是否是首次接诊
	 * 
	 * @param entId
	 * @param empId
	 * @return
	 * @throws BizException 
	 */
	private boolean isFirstRect(String entId, String empId) throws BizException{
		boolean result = true;
		String sql = "SELECT COUNT(EMP.ID_ENTEMP) FROM EN_ENT_EMP EMP WHERE EMP.ID_ENT = ? AND EMP.ID_EMP <> ? ";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(empId);
		int orCount = (int) new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(orCount>0){
			result = false; //不是首次接诊
		}
		return result;
	}
	
	/**
	 * 更新EN_ENT_QUE表信息
	 * 
	 * @param empId
	 * @param entId
	 * @throws BizException
	 */
	private EnQueueDO updateEnQue(EnQueueDO enQueueDO) throws BizException{
		
		enQueueDO.setStatus(DOStatus.UPDATED);
		enQueueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		enQueueDO.setId_que_site(null);
//		enQueueDO.setId_emp_acpt(null);
//		enQueueDO.setName_emp_acpt(null);
		enQueueDO.setId_emp_opreg(null);
		enQueueDO.setSortno_called(0);
		EnQueEP ep = new EnQueEP();
		EnQueueDO[] enQueueDOs = ep.save(new EnQueueDO[] {enQueueDO});
		if(!EnValidator.isEmpty(enQueueDOs)){
			return enQueueDOs[0];
		}
		return null;
	}
	/**
	 * 得到门诊队列
	 * 
	 * @param entId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO getEnQue(String entId, String empId) throws BizException{
		EnQueEP ep = new EnQueEP();
		String whereStr = String.format("%s.ID_ENT = '%s' AND %s.ID_EMP_ACPT = '%s' AND %s.SD_ENTQUE_TP = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, entId,
				EnQueueDODesc.TABLE_ALIAS_NAME, empId,
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_EMP);
		EnQueueDO[] enQueueDOs = ep.getEnQueueByWhereStr(whereStr, null);
		if(!EnValidator.isEmpty(enQueueDOs)){
			return enQueueDOs[0];
		}
		return null;
	}
	
	/**
	 * 更新EN_ENT表信息
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void updateEnt(String entId) throws BizException{
		IPativisitRService entRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entRService.findById(entId);
		patiVisitDO.setStatus(DOStatus.UPDATED);
		patiVisitDO.setFg_acptvalid(FBoolean.FALSE);
		patiVisitDO.setDt_acpt(null);
		IPativisitCudService entCudService = ServiceFinder.find(IPativisitCudService.class);
		entCudService.save(new PatiVisitDO[]{patiVisitDO});
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPv(String entId) throws BizException {
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.getPvById(entId);
		if (pvDO == null)
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		return pvDO;
	}
	/**
	 * 获取门诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private OutpatientDO getOp(String entId) throws BizException{
		OpEP opEP = new OpEP();
		OutpatientDO op = opEP.getOpByEntId(entId);
		if(op == null)
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		return op;
	}
	
	/**
	 * 更新EN_ENT_OP表信息
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void updateEntOP(OutpatientDO op, boolean isSettle) throws BizException{
		op.setStatus(DOStatus.UPDATED);
		op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
		if(!FBoolean.TRUE.equals(op.getFg_cg()))
			op.setFg_cg(new FBoolean(isSettle));
		OpEP opEP = new OpEP();
		opEP.save(new OutpatientDO[]{op});
	}
	
	/**
	 * 删除EN_ENT_EMP表信息
	 * 
	 * @param entId
	 * @param empId
	 * @throws BizException
	 */
	private void deteleEnEmp(String entId, String empId) throws BizException{
		IEnpsnRService enEmpRService = ServiceFinder.find(IEnpsnRService.class);
		String whereStr = String.format("%s.ID_ENT = '%s' AND %s.ID_EMP = '%s' ",
				EnPsnDODesc.TABLE_ALIAS_NAME, entId,
				EnPsnDODesc.TABLE_ALIAS_NAME, empId);
		EnPsnDO[] enPsnDOs = enEmpRService.find(whereStr, null,FBoolean.FALSE);
		if(!EnValidator.isEmpty(enPsnDOs)){
			for(EnPsnDO enPsnDO:enPsnDOs){
				enPsnDO.setStatus(DOStatus.DELETED);
			}
			IEnpsnCudService enEmpCudService = ServiceFinder.find(IEnpsnCudService.class);
			enEmpCudService.delete(enPsnDOs);
		}
	}
	
	/**
	 * 删除EN_ENT_DEP表信息
	 * 
	 * @param entId
	 * @param empId
	 * @throws BizException
	 */
	private void deteleEnDep(String entId, String depId) throws BizException{
		IEndepRService enDepRService = ServiceFinder.find(IEndepRService.class);
		String whereStr = String.format("%s.ID_ENT = '%s' AND %s.ID_DEP = '%s' ",
				EnDepDODesc.TABLE_ALIAS_NAME, entId,
				EnDepDODesc.TABLE_ALIAS_NAME, depId);
		EnDepDO[] enDepDOs = enDepRService.find(whereStr, null,FBoolean.FALSE);
		if(!EnValidator.isEmpty(enDepDOs)){
			for(EnDepDO enDepDO:enDepDOs){
				enDepDO.setStatus(DOStatus.DELETED);
			}
			IEndepCudService enDepCudService = ServiceFinder.find(IEndepCudService.class);
			enDepCudService.delete(enDepDOs);
		}
	}
	/**
	 * 挂号费是否付款
	 * 
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	private boolean hasSettled(String cgId) throws BizException{
		IBlOutQryService serv = ServiceFinder.find(IBlOutQryService.class);
		return FBoolean.TRUE.equals(serv.hasSettled(cgId));
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
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_DOC_CANC_ACPT);
	}
}
