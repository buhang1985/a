package iih.en.pv.s.listener.op;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnRuleConst;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.s.listener.bp.CheckSendMsgByMvelBP;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/***
 * 门诊挂号调用规则引擎发送短信监听器
 * @author fanlq
 *
 */
public class EnOpRegSendMsg4MvelListener implements IBusinessListener,EuRegTp {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		if (!this.validate(event))
			return;
		// 2、获取事件源
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		OpReg4EsDTO esDTO = (OpReg4EsDTO) bizUserObj.getUserObj();
		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = service.findById(esDTO.getId_pat());
		CheckSendMsgByMvelBP bp = new CheckSendMsgByMvelBP();
		bp.exec(IEnRuleConst.EN_SENDMSG_REGRULEPKG_CONST,patDO,esDTO.getId_ent());
	}
	/**
	 * 验证事件
	 * 
	 * @param event
	 *            事件
	 * @throws BizException
	 */
	private boolean validate(IBusinessEvent event) throws BizException {
		if (!IEnEventConst.EVENT_SOURCE_EN_OP_REG.equalsIgnoreCase(event
				.getSourceID())
				|| !IEnEventConst.EVENT_EN_OP_REG.equals(event.getEventType())) {
			return false;
		}
		return true;
	}
}
