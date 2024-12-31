package iih.en.pv.pub.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.pv.out.i.IEn4EiQryService;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;

/**
 * 门诊就诊流程显示监听器
 * 
 * @author liubin
 * 
 * 2018-06-29 上午10:15:02
 */
public abstract class AbstractEnOpDisplayListener implements IBusinessListener {

	@Override
	final public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);
		// 2.内部组装数据
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpQue4EsDTO eventSourceDTO = (OpQue4EsDTO)bizUserObj.getUserObj();
		OpQue4DispDTO opQue4Disp = wrapOpQue4DispDTO(eventSourceDTO, event.getEventType());
		// 3.处理各事件
		doEachAction(opQue4Disp, event.getEventType());
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_OP_QUE.equalsIgnoreCase(event.getSourceID())){
			throw new BizException("监听器与事件源不匹配！");
		}		
	}
	/**
	 * 组装数据
	 * 
	 * @author liubin
	 * 
	 * @param opQue4EsDTO
	 * @param eventType
	 * @return
	 * @throws BizException
	 */
	private OpQue4DispDTO wrapOpQue4DispDTO(OpQue4EsDTO opQue4EsDTO, String eventType) throws BizException{
		if(opQue4EsDTO == null || StringUtil.isEmptyWithTrim(eventType))
			return null;
		IEn4EiQryService service = ServiceFinder.find(IEn4EiQryService.class);
		return service.getOpQueDTO4Disp(opQue4EsDTO, eventType);
		
	}
	/**
	 * 处理各个事件
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @param eventType
	 * @throws BizException
	 */
	private void doEachAction(OpQue4DispDTO opQue4Disp, String eventType) throws BizException{
		if(opQue4Disp == null)
			return;
		switch (eventType) {
		case IEnEventConst.EVENT_EN_OP_DOC_ONLINE:// 医生上线
			doActionOnLine(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_SIGNIN:// 到诊
			doActionSignin(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_CANC_SIGNIN:// 取消到诊
			doActionCancSignin(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_TRIAGE:// 分诊
			doActionTriage(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_CANC_TRIAGE:// 取消分诊
			doActionCancTriage(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_PASSNUM:// 过号
			doActionPass(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_DOC_ACPT:// 接诊
			doActionAcpt(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_DOC_CANC_ACPT:// 取消接诊
			doActionCancAcpt(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_DOC_OFFLINE:// 医生下线
			doActionOffLine(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_CANC_REG:// 退号
			doActionCancEnt(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_DIAGEND:// 诊毕
			doActionDiagEnd(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_DIAGNOSECONTINUE:// 待回诊
			doActionNeedRtn(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_CALLNUM:// 叫号
			doActionCall(opQue4Disp);
			break;
		case IEnEventConst.EVENT_EN_OP_CANC_CALLNUM:// 取消叫号
			doActionCancCall(opQue4Disp);
			break;
		}
	}
	/**
	 * 医生上线处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionOnLine(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 医生下线处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionOffLine(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 患者到诊处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionSignin(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 患者取消到诊处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionCancSignin(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 分诊处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionTriage(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 取消分诊处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionCancTriage(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 过号处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionPass(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 医生接诊处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionAcpt(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 医生取消接诊处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionCancAcpt(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 退号处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionCancEnt(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 诊毕处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionDiagEnd(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 医生上线处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionNeedRtn(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 医生上线处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionCall(OpQue4DispDTO opQue4Disp) throws BizException;
	/**
	 * 医生上线处理
	 * 
	 * @author liubin
	 * 
	 * @param opQue4Disp
	 * @throws BizException
	 */
	protected abstract void doActionCancCall(OpQue4DispDTO opQue4Disp) throws BizException;
}
