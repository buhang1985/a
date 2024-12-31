package iih.en.pv.s.listener.op;

import iih.bd.bc.event.pub.IScEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.op.CheckIsGcVipBP;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpApt4EsDTO;
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
 * 门诊预约取号--VIP短信通知
 * @author yankan
 * @author 
 *
 */
public class EnOpAptCfmVip4SmsListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		if(!this.validate(event))
			return;
		
		//2、包装短信通知所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		OpApt4EsDTO esDTO = (OpApt4EsDTO)bizUserObj.getUserObj ();	
		
		//3、判定是否VIP
		CheckIsGcVipBP checkBP = new CheckIsGcVipBP();
		FBoolean isVIP = checkBP.exec(esDTO.getId_ent());
		if(!FBoolean.TRUE.equals(isVIP)){
			return;
		}
		
		//4、包装短信所需数据结构,发送短信BP
		OpApt4SmsDTO aptDTO = wrapObj4Sms(esDTO);
		this.sendMsg(aptDTO);	
	}	
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private boolean validate(IBusinessEvent event) throws BizException{
		if(!IScEventConst.EVENT_SOURCE_SOURCE_SC_OP_APT.equalsIgnoreCase(event.getSourceID())
			|| !IScEventConst.EVENT_SC_OP_APT_TAKE.equals(event.getEventType())){
			return false;
		}	
		return true;
	}
	/**
	 * 包装短信通知DTO
	 * @param esDTO 预约事件源DTO
	 * @return
	 * @throws BizException 
	 */
	private OpApt4SmsDTO wrapObj4Sms(OpApt4EsDTO esDTO) throws BizException {
		OpApt4SmsDTO aptDTO = new OpApt4SmsDTO();
		
		// 填写具体的包装逻辑,患者姓名，患者编号，挂号日期，就诊日期，科室，医生
		aptDTO.setId_apt(esDTO.getId_apt());	//预约ID
		aptDTO.setId_pat(esDTO.getId_pat());    //患者ID
		//排班ID，Id_sch
		//就诊ID，Id_ent
		PatDO patDO = new PatEP().getPatById(esDTO.getId_pat());
		if(patDO!=null){
			aptDTO.setName_pat(patDO.getName());//患者姓名
			aptDTO.setCode_pat(patDO.getCode());//患者编码
			aptDTO.setMobile(patDO.getMob());//手机号码
		}
		else {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		PatiVisitDO pvDO = new PvEP().getPvById(esDTO.getId_ent());
		if(pvDO !=null){
			aptDTO.setD_apt(pvDO.getDt_insert().getDate());//挂号日期
			aptDTO.setDt_entry(pvDO.getDt_entry());//就诊日期
			aptDTO.setName_dep(pvDO.getName_dep_phy());//科室
		}
		else {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		OutpatientDO op = new OpEP().getOpByEntId(esDTO.getId_ent());
		aptDTO.setName_doc(op.getScres_name());
		aptDTO.setTime_op(op.getTimes_op());
		aptDTO.setName_srv(op.getScsrv_name());
		aptDTO.setCode_doc(op.getScres_code());
		aptDTO.setCode_dep(op.getDep_reg_code());
		aptDTO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		return aptDTO;
	}
	/**
	 * 发送消息
	 * @param aptDTO 预约短信DTO
	 * @throws BizException
	 */
	private void sendMsg(OpApt4SmsDTO aptDTO) throws BizException{
		//获取预约中心号码
		String mobiles = EnParamUtils.getGcVipNoteTel(EnContextUtils.getOrgId());
		if(EnValidator.isEmpty(mobiles)){
			Logger.error("【挂绿色通道号患者通知预约中心负责人】未获取到负责人电话");
			return;
		}
		IScAptOutCmdService aptOutCmdService = ServiceFinder.find(IScAptOutCmdService.class);
		aptOutCmdService.sendOpSmsMsg(mobiles,IScSmsConst.EN_OP_GREEN_CHANNEL_MSG, aptDTO);
	}
}
