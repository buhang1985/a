package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.i.IBlOutQryService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.op.st.CancPricingBP;
import iih.en.pv.s.bp.op.st.RefundBP;
import iih.en.pv.s.event.OpCancRegEvent;
import iih.en.pv.s.rule.SupplyTicketRuleBP;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 退号BP
 * @author yankan
 *
 */
public class CancOpRegBP {
	/**
	 * 取消挂号
	 * @param entId 就诊id
	 * @param fromAptId　来源预约id
	 * @param drawMod 退号方式
	 * @param sd_pttp 收付款终端类型编码
	 * @throws BizException
	 */
	public void exec(String entId,String fromAptId,String drawMod, String sd_pttp) throws BizException{
		//1.可退号检验
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.getPvById(entId);
		this.validatePv(pvDO);
		
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(entId);
		this.validateOp(opDO);

		
		//2.更新就诊数据				
		//3、更新就诊队列信息
		CancEntBP cancEntBP = new CancEntBP();
		cancEntBP.cancEnt(pvDO.getId_ent());
		
		//4、更新en_ent_op就诊次数
//		CancEntOpBp cancEntOpBP = new CancEntOpBp();
//		cancEntOpBP.cancEntOp(opDO, pvDO.getId_pat());
				
		//5.退费服务，只要支付了，就需要退费，包括挂号、预约
		if(!EnValidator.isEmpty(opDO.getId_cg())){
			if(this.hasSettled(opDO.getId_cg())){
				//已经结算的，需退费
				RefundBP refundBP = new RefundBP();
				refundBP.exec(entId, opDO.getId_cg(),FBoolean.FALSE, sd_pttp, FBoolean.TRUE);
			}else{
				//后付费情况，取消划价
				CancPricingBP cancPriBP = new CancPricingBP();
				cancPriBP.exec(pvDO.getId_ent());
			}
		}		
		
		//6.释放号源
		if(!EnValidator.isEmpty(opDO.getId_sch())){
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
			this.invokeOpCancelRegEvent(pvDO.getId_ent());
		} catch (Exception ex) {
			// xap.mw.runtime.msys.logging.
		}
		
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
	 * 验证
	 * @param pvDO 
	 * @throws BizException
	 */
	private void validatePv(PatiVisitDO pvDO) throws BizException{
		if(pvDO==null){
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		}
		if(pvDO.getFg_canc().equals(FBoolean.TRUE)){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_HAS_CANCED);
		}
	}
	/**
	 * 验证门诊信息
	 * @param opDO
	 * @throws BizException
	 */
	private void validateOp(OutpatientDO opDO) throws BizException{
		if(opDO==null){
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}
		//非预约或挂号状态，不能退号
		if(!opDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER)
				&& !opDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER)){
			throw new BizException(IEnMsgConst.ERROR_OP_ACPT_CANNOT_CANC);
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
}
