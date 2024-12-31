package iih.ci.event.ord.listeners.diag;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 门诊住院 公共监听
 * @author F
 *
 * @date 2019年9月18日下午3:16:22
 *
 * @classpath iih.ci.event.ord.listeners.diag.OpIpDiagCommonListener
 */
public abstract class OpIpDiagCommonListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(OpIpDiagCommonListener.class.getSimpleName(), "诊断 公共监听入口");
		if(OrdEventUtil.isEmpty(event))return;
		//是否满足事件源和事件类型
		if(!isMatchSourceIdAndEventType(event)) return;
		//转换数据
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(OrdEventUtil.isEmpty(newObjs)||newObjs.length != 2){return;}
		CidiagAggDO ret=(CidiagAggDO)newObjs[0];
		CiEnContextDTO ctx=(CiEnContextDTO)newObjs[1];
		if(OrdEventUtil.isEmpty(ret)||OrdEventUtil.isEmpty(ret.getParentDO())||OrdEventUtil.isEmpty(ctx)) {
			return;
		}
		OrdEventLogger.info(OpIpDiagCommonListener.class.getSimpleName(), ret.getParentDO().getCode_entp()+"诊断CidiagAggDO ret:"+ret.serializeJson());
		OrdEventLogger.info(OpIpDiagCommonListener.class.getSimpleName(), ret.getParentDO().getCode_entp()+"诊断CiEnContextDTO ctx:"+ctx.serializeJson());
		//实现自身业务
		doYourAction(ret,ctx);
	}
	/**
	 * 是否满足事件源和事件类型
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public abstract boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException;
	/**
	 * 实现自身业务
	 * @param ret
	 * @param ctx
	 * @throws BizException
	 */
	public void doYourAction(CidiagAggDO ret,CiEnContextDTO ctx)throws BizException{
		//筛选门诊 急诊流水 急诊抢救 住院 急诊留观数据(注 这里细分 不在上级细分 防止以后变动太大，导致结构无法使用)
		if(!isOpData(ret.getParentDO())) {
			return;
		}
		//组装数据
		IEOpPvDiagEnDTO[] OpPvDiagDTO=assemableDate(ret, ctx);
		if(OrdEventUtil.isEmpty(OpPvDiagDTO)) {
			return;
		}
		//发送数据
		sendMessagesToIE(OpPvDiagDTO);
	}
	/**
	 * 门诊、急诊流水、急诊抢救数据筛选
	 * @param or
	 * @return
	 */
	public abstract boolean isOpData(CiDiagDO ciDiagDO)throws BizException; 
	/**
	 * 组装数据
	 * @param ret
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public abstract IEOpPvDiagEnDTO[] assemableDate(CidiagAggDO ret, CiEnContextDTO ctx)throws BizException;
	/**
	 * 发送数据
	 * @param OpPvDiagDTO
	 * @throws BizException
	 */
	public abstract void sendMessagesToIE(IEOpPvDiagEnDTO[] OpPvDiagDTO)throws BizException;
}
