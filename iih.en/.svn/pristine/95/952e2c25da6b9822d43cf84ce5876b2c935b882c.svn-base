package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.st.blstoep.d.EnReFundTpEnum;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.i.IEnErCmdService;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.op.st.CancPricingBP;
import iih.en.pv.s.bp.op.st.RefundWithCostBP;
import iih.en.pv.s.event.OpCancRegEvent;
import iih.en.pv.s.rule.SupplyTicketRuleBP;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 退号（含医保退费）
 * @author yank
 *
 */
public class CancOpRegWithCostBP {
	/**
	 * 取消挂号
	 * @param regInfo 挂号信息 
	 * @param payInfoDTO 支付信息
	 * @return 退费成功返回发票信息
	 * @throws BizException
	 */
	public FArrayList exec(RegInfoDTO regInfo,PayInfoDTO payInfoDTO) throws BizException{
		Context.get().setAttribute("ReFundTp", EnReFundTpEnum.ENREFUND_CANCEL);//退号
		FArrayList arrayList = new FArrayList();
		CancOpRegValidateBP bp = new CancOpRegValidateBP();
		bp.exec(regInfo.getId_ent());
		
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(regInfo.getId_ent());
		
		PvEP pvEP = new PvEP();
		PatiVisitDO pv = pvEP.getPvById(regInfo.getId_ent());
		
		// 1、急诊退号处理
		this.handleErCancRegist(pv);

		//2.更新就诊数据				
		CancEntBP cancEntBP = new CancEntBP();
		cancEntBP.cancEnt(regInfo.getId_ent());
				
		//5.退费服务，只要支付了，就需要退费，包括挂号、预约
		if(!EnValidator.isEmpty(opDO.getId_cg())){
			if(this.hasSettled(opDO.getId_cg())){
				//已经结算的，需退费
				RefundWithCostBP refundNewBP = new RefundWithCostBP();
				BlIncItmVsTypeDTO[] incItmVsTypeDTOs =  refundNewBP.exec(regInfo, payInfoDTO);
				arrayList = EnAppUtils.doArray2List(incItmVsTypeDTOs);
			}else{
				//后付费情况，取消划价
				CancPricingBP cancPriBP = new CancPricingBP();
				cancPriBP.exec(regInfo.getId_ent());
			}
		}		
		if(!EnValidator.isEmpty(opDO.getId_sch())){
			//6.释放号源
			IScschMDORService service = ServiceFinder.find(IScschMDORService.class);
			ScSchDO scSchDO = service.findById(opDO.getId_sch());
			if(scSchDO.getFg_transed().booleanValue()){
				throw new BizException("相关号位数据转移到sc_tickb表中，无法进行退号处理");
			}
			SupplyTicketRuleBP rule = new SupplyTicketRuleBP();
			String supplyTicketType = rule.exec(opDO.getId_ent(), opDO.getId_schapt());
			IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
			schService.revokeTick(opDO.getId_tick(), supplyTicketType);
		}
		
		//7、如果是预约，需要将预约取消,预约生成就诊后，需要修改预约，否则还能取号
		if(!EnValidator.isEmpty(opDO.getId_schapt())){
			IScAptOutCmdService aptCmdService = ServiceFinder.find(IScAptOutCmdService.class);
			aptCmdService.setAptToCancle(opDO.getId_schapt());
		}
		// 8、事件触发通知集成平台 ，正在测试，暂时吃了异常不影响挂号
		try {
			this.invokeOpCancelRegEvent(regInfo.getId_ent());
		} catch (Exception ex) {
			// xap.mw.runtime.msys.logging.
		}
		return arrayList;
	}
	/**
	 * 触发门诊退号事件
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void invokeOpCancelRegEvent(String entId) throws BizException{
		GetOpReg4EsBP getOpReg4EsBP = new GetOpReg4EsBP();
		OpReg4EsDTO reg4EsDTO = getOpReg4EsBP.createOpReg4EsDTO(entId);
		//2、触发事件
		OpCancRegEvent opCancelregEvent = new OpCancRegEvent();
		opCancelregEvent.invoke(reg4EsDTO);
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
	 * 急诊退号处理
	 * 
	 * @param pv
	 * @throws BizException
	 */
	private void handleErCancRegist(PatiVisitDO pv) throws BizException{
		if(!pv.getCode_entp().startsWith(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
			return;
		IEnErCmdService serv = ServiceFinder.find(IEnErCmdService.class);
		serv.handleErCancRegist(pv.getId_ent());
	}
}

