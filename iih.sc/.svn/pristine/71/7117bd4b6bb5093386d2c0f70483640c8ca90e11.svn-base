package iih.sc.apt.s.bp.ws;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.sc.apt.custom.ScAptCustomServiceUtils;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.GetOpAptedListBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.event.OpAptTakeEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 
 * ws取号服务
 * @author liubin,renying
 *
 */
public class TakeApptNoForAptNewBP {
	/**
	 * 对已收费预约取号
	 * 
	 * @param aptId
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	public String exec(String aptId, String oprCode) throws BizException {
		ScAptDO apt = this.getScApt(aptId);
		this.validateAptDO(apt);
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status())){
			return null;
		}
		//1.获取预约DTO
		GetOpAptedListBP bp = new GetOpAptedListBP();
		OpAptDTO aptDTO = bp.exec(aptId);
		if(aptDTO == null) 
			throw new BizException(IScMsgConst.SC_APT_NOT_EXIST);
		//3.获取门诊do
		IOutpatientRService rService = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] outPatientDO = rService.find(" id_schapt ='"+apt.getId_apt()+"'", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(outPatientDO)){
			throw new BizException("未找到预约记录");
		}
		//4，获取就诊DO
		IPativisitRService pService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO entDO = pService.findById(outPatientDO[0].getId_ent());
		//5.取号之前调用客开做校验
		if(ScAptCustomServiceUtils.handle4TakeApptNoBefor(apt, outPatientDO[0].getId_ent())){
			//3.创建队列DO
			this.CreatEnQueDO(entDO, outPatientDO[0], aptDTO);
			//4.取号
			this.takeNum(apt, oprCode,entDO,outPatientDO[0]);
		}
		return null;
	}
	
	/**
	 * 取号
	 * @param aptDO
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	public String takeNum(ScAptDO aptDO, String oprCode,PatiVisitDO entDO,OutpatientDO outPatientDO) throws BizException {
		//1.获取操作员
		IPsndocMDORService rService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psnDoc =	rService.find("code ='"+oprCode+"'", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(psnDoc))
			throw new BizException("未查询到code"+oprCode+"对应的人员"); 
		
		//2.更新预约状态
		AptEP aptEP = new AptEP();
		// add by zhengcm 2017-11-17 保存状态ID
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_FINISH);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH);//状态改为完成	
		aptDO.setStatus(DOStatus.UPDATED);
		aptEP.save(aptDO);	
		//3.更新门诊状态
		IOutpatientCudService cudService = ServiceFinder.find(IOutpatientCudService.class);		
		outPatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
		outPatientDO.setId_emp_operator(psnDoc[0].getId_psndoc());
		cudService.update(new OutpatientDO[]{outPatientDO});
		
		IPativisitCudService pcudService = ServiceFinder.find(IPativisitCudService.class);		
		if(entDO == null )
			throw new BizException("未找到就诊记录");
		entDO.setDt_insert(ScAppUtils.getServerDateTime());
		pcudService.update(new PatiVisitDO[]{entDO});
		
		//7、触发预约取号事件
		this.invokeAptEvent(aptDO.getId_apt(),aptDO.getId_pat(),outPatientDO.getId_ent());
		return oprCode;
	}
	/**
	 * 创建队列DO
	 * @param entDO
	 * @param outPatientDO
	 * @param RegResDto
	 * @throws BizException
	 */
	private void CreatEnQueDO(PatiVisitDO entDO,OutpatientDO outPatientDO,OpAptDTO aptDTO) throws BizException{
		RegInfoDTO regInfoDTO = new RegInfoDTO();

		regInfoDTO.setRegresarray(aptDTO.getRegresarray());
		regInfoDTO.setId_dayslot(outPatientDO.getId_dateslot());
		regInfoDTO.setTickno(outPatientDO.getTicketno());
		regInfoDTO.setId_tick(outPatientDO.getId_tick());
		IEnqueueRService enqueueCudService  = ServiceFinder.find(IEnqueueRService.class);
		EnQueueDO [] enQueDOs =  enqueueCudService.find("id_ent ='"+entDO.getId_ent()+"'" , "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(enQueDOs)){
			IEnOutCmdService enOutService = ServiceFinder.find(IEnOutCmdService.class);
			enOutService.creatEntQueDO(entDO,regInfoDTO);
		}
	}
	
	/**
	 * 验证预约信息
	 * @param aptDO
	 * @throws BizException
	 */
	private void validateAptDO(ScAptDO aptDO) throws BizException{		
		if(aptDO == null){
			throw new BizException(IScMsgConst.SC_APT_NOT_EXIST);
		}	
		if(IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(aptDO.getSd_status())){
			throw new BizException(IScMsgConst.SC_APT_OP_TAKEN_HAS_CANCELED);
		}
		if(IScDictCodeConst.SD_APTSTATUS_ORDER.equals(aptDO.getSd_status())){
			throw new BizException(IScMsgConst.SC_APT_TAKE_NO_PAY);
		}
	}
	/**
	 * 获取预约记录
	 * 
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param requestDate 预约日期
	 * @param dayslotType 午别类型
	 * @param scsrvCode 服务编码
	 * @param seqNo 顺序号
	 * @return
	 * @throws BizException 
	 * @throws Exception 
	 */
	private ScAptDO getScApt(String aptId) throws BizException{
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		return serv.findById(aptId);
	}
	
	/**
	 * 触发事件 自助机需要IIH自己发事件
	 * @param aptId 预约ID
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @throws BizException
	 */
	private void invokeAptEvent(String aptId,String patId,String entId) throws BizException{
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(aptId);
		apt4EsDTO.setId_pat(patId);
		apt4EsDTO.setId_ent(entId);
		try{
			new OpAptTakeEvent().invoke(apt4EsDTO);
		}catch(Exception ex){
			Logger.error("", ex);
		}
		
	}
}
