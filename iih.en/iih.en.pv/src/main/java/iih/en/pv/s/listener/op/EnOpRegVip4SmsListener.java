package iih.en.pv.s.listener.op;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.s.bp.op.CheckIsGcVipBP;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.pub.IScSmsConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊挂号--VIP短信通知
 * 
 * @author yankan
 * @author
 *
 */
public class EnOpRegVip4SmsListener implements IBusinessListener,EuRegTp {
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
		// 4、判断电话号码是否为空,CONSULTINGROOM为医生诊间挂号
		OpEP opEp = new OpEP();
		OutpatientDO outpatientDO = opEp.getOpByEntId(esDTO.getId_ent());
		String eu_reg = outpatientDO.getEu_regtp();	
		if (eu_reg.equals(CONSULTINGROOM))
			return;
		// 3、判定是否VIP
		CheckIsGcVipBP checkBP = new CheckIsGcVipBP();
		FBoolean isVIP = checkBP.exec(esDTO.getId_ent());
		if (!FBoolean.TRUE.equals(isVIP)) {
			return;
		}

	
		// 5、包装短信所需数据结构,发送短信BP
		OpApt4SmsDTO aptDTO = wrapObj4Sms(esDTO);
		this.sendMsg(aptDTO);
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

	/**
	 * 包装短信通知DTO
	 * 
	 * @param esDTO
	 * @return
	 * @throws BizException
	 */
	private OpApt4SmsDTO wrapObj4Sms(OpReg4EsDTO esDTO) throws BizException {
		OpApt4SmsDTO aptDTO = new OpApt4SmsDTO();

		// 填写具体的包装逻辑,患者姓名Name_pat，患者编码Code_pat，联系电话：Mobile,挂号日期D_pat，就诊日期Dt_entry，挂号科室Name_dep，医生姓名Name_doc
		aptDTO.setName_pat(esDTO.getName_pat());// 患者姓名
		aptDTO.setName_doc(esDTO.getName_scres());// 资源名称
		aptDTO.setId_pat(esDTO.getId_pat()); // 患者ID
		aptDTO.setD_apt(esDTO.getDt_insert().getDate());// 挂号日期
		aptDTO.setDt_entry(esDTO.getDt_entry());// 就诊日期
		aptDTO.setName_dep(esDTO.getName_dep_reg());// 挂号科室名称
		aptDTO.setName_srv(esDTO.getName_scsrv());
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(esDTO.getId_pat());
		if (patDO == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		aptDTO.setCode_pat(patDO.getCode());// 患者编码
		aptDTO.setMobile(patDO.getMob());// 手机号码

		return aptDTO;
	}

	/**
	 * 发送消息
	 * 
	 * @param aptDTO
	 *            预约短信DTO
	 * @throws BizException
	 */
	private void sendMsg(OpApt4SmsDTO aptDTO) throws BizException {
		// 获取预约中心号码
		String mobiles = EnParamUtils
				.getGcVipNoteTel(EnContextUtils.getOrgId());
		if (EnValidator.isEmpty(mobiles)) {
			Logger.error("【挂绿色通道号患者通知预约中心负责人】未获取到负责人电话");
			return;
		}
		IScAptOutCmdService aptOutCmdService = ServiceFinder
				.find(IScAptOutCmdService.class);
		aptOutCmdService.sendOpSmsMsg(mobiles,
				IScSmsConst.EN_OP_GREEN_CHANNEL_MSG, aptDTO);
	}
}
