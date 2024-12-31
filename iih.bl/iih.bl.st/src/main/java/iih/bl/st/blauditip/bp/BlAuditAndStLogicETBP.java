package iih.bl.st.blauditip.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.comm.IBlConst;
import iih.bl.et.auditresultdto.d.AuditResultDTO;
import iih.bl.et.msg.IBlEtMsgConst;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.bl.st.blauditip.d.BlAuditLogIp;
import iih.bl.st.blauditip.d.BlauditipAggDO;
import iih.bl.st.blauditip.i.IBlauditipCudService;
import iih.bl.st.blauditip.i.IBlauditipMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.i.mqmsg.meta.NurseWaitConfirmMsgDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 出观审核与住出观算逻辑处理Bp
 * @author xuebei
 * @date 2019年3月7日
 */
public class BlAuditAndStLogicETBP {
	
	private FDateTime currentTime;
	
	/**
	 * 判断是否已经被审核过，如果有合法审核 true ,没有合法审核false
	 */
	public BlAuditAndStLogicETBP()
	{
		TimeService timeService = new TimeServiceImpl();
		this.currentTime = timeService.getUFDateTime();
	}
	
	public FBoolean HasETHpAudited(String id_ent) throws BizException
	{
		if (StringUtil.isEmpty(id_ent)) {
			throw new BizException("患者主键不能为空!");
		}
		
		IBlauditipMDORService iBlauditipMDORService = ServiceFinder.find(IBlauditipMDORService.class);
		BlAuditIp[] blAuditIpArr = iBlauditipMDORService
				.find(" fg_active = 'Y' and Fg_pass_hp = 'Y' and id_ent = '" + id_ent + "'", " sv desc ", FBoolean.TRUE);
		if (blAuditIpArr == null || blAuditIpArr.length <= 0)
			return FBoolean.FALSE;

		return FBoolean.TRUE;
	}
	
	/**
	 * 发送签署消息给护士工作站
	 * @param msgList
	 * @throws BizException
	 */
	public void SendAuditMsgToNurse(AuditResultDTO auditResultDTO) throws BizException {
		// 组织消息参数
		Map<String, Object> msgMap = new HashMap<String, Object>();

		msgMap.put(IBlEtMsgConst.SENDAUDITMSGTONURSE_MSG, auditResultDTO);

		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		// 此处调用方法，为Map参数，因此在后台接收，也应该实现Map参数的接口方法
		msgService.GenerateMessageAndMap(IBlEtMsgConst.SENDAUDITMSGTONURSE_MSG, msgMap, null);
	}
	
	

	@SuppressWarnings("unused")
	public FBoolean SaveHpAuditET(BlAuditIp blAuditIp) throws BizException
	{
		if(blAuditIp.getId_auditip() == null)
			blAuditIp.setStatus(DOStatus.NEW);
		else
			blAuditIp.setStatus(DOStatus.UPDATED);
		
		if(blAuditIp == null)
			throw new BizException("审核不能为空!");
		
		BlAuditLogIp log = new BlAuditLogIp();
		log.setId_auditlogip(null);
		if(blAuditIp.getId_auditip() != null)
			log.setId_auditip(blAuditIp.getId_auditip());
		else
			log.setId_auditip(null);
		
		if(blAuditIp.getFg_pass_hp().equals(FBoolean.TRUE))
		{
			log.setEu_act(IBlConst.INSUR_AUDIT_PASS);
			log.setId_emp_act(blAuditIp.getId_emp_hp());
		}
		else
		{
			log.setEu_act(IBlConst.INSUR_AUDIT_CANCEL);
			log.setId_emp_act(blAuditIp.getId_emp_canc_hp());
		}
		
		log.setDt_act(this.currentTime);
		log.setStatus(DOStatus.NEW);
		
		BlauditipAggDO blauditipAggDO = new BlauditipAggDO();
		blauditipAggDO.setParentDO(blAuditIp);
		blauditipAggDO.setBlAuditLogIp(new  BlAuditLogIp[] { log });
		
		IBlauditipCudService iBlauditipCudService = ServiceFinder.find(IBlauditipCudService.class);
		iBlauditipCudService.save(new BlauditipAggDO[] { blauditipAggDO });
		return FBoolean.TRUE;
	}
}
