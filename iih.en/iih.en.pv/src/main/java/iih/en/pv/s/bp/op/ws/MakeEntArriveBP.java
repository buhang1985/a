package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.outpatient.dto.d.ArriveResultBean;
import iih.en.pv.s.bp.op.GetOpRegListByPatBP;
import iih.en.pv.s.bp.op.ws.ep.WsEp;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.enqueue.i.IEnqueueRService;
import iih.en.que.i.IEnQueCmdService;
import iih.en.que.i.IEnQueOutCmdService;
import iih.en.que.i.IEnQueQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 	给一个患者签到分诊
 * @author Sarah
 *
 */
public class MakeEntArriveBP {
	private String ErrorStatus = "1";
	private String NoErrorStatus = "0";
	/**
	 * 签到分诊
	 * @param patCode
	 * @param opTimes
	 * @param queBenCode
	 * @param dayslottp
	 * @param oprCode
	 * @return
	 * @throws BizException 
	 */
	public ArriveResultBean exec(String patCode,Integer opTimes,String queBenCode,String oprCode) throws BizException{
		String log = "方法：MakeEntArriveBP参数为:patCode:" + patCode + ";opTimes:" + opTimes + ";queBenCode:" + queBenCode + ";oprCode:"+ oprCode;
		EnLogUtil.getInstance().logInfo(log);
		ArriveResultBean regRst = new ArriveResultBean();
		regRst.setCode(NoErrorStatus);
		regRst.setSiteName("");
		//1.签到
		//2.签到后判断诊台，如果id_que_site不为空，则不需要调用自动分诊
		TriageBenInfoDTO triageBenInfo = null;
		OpRegDTO opRegInfo = null;
		try{
			//校验参数
			this.validParam(patCode, opTimes, queBenCode, oprCode);
			//设置上下文
			new SetPsnDocContextBP().exec(oprCode);
			//获取分诊台信息
			triageBenInfo = getTriageBenInfo(queBenCode);
			//获取患者有效挂号信息
			opRegInfo = getEnRegInfo(patCode, triageBenInfo, Integer.toString(opTimes));
			//校验患者状态
			validateEnInfo(opRegInfo, triageBenInfo);
			//设置患者为回诊
			setEntFirstOrRtn(opRegInfo);
			//签到
			makeArrive(opRegInfo, triageBenInfo);
			//签到后判断诊台，如果id_que_site不为空，则不需要调用自动分诊
			EnQueueDO queue = getEnQueue(opRegInfo.getId_ent());
			if(!EnValidator.isEmpty(queue.getId_que_site())){
				regRst.setCode(NoErrorStatus);
				regRst.setSiteName(getSiteName(queue.getId_que_site()));
				return regRst;
			}
		}catch(BizException ex){
			EnLogUtil.getInstance().logError(log, ex);
			regRst.setCode(ErrorStatus);
			regRst.setErrMsg(ex.getMessage());
			return regRst;
		}
		this.autoTriage(opRegInfo, triageBenInfo, regRst);
		return regRst;
	}
		//3.自动分诊
		
		/**
		 * 通过entId得到EnQueueDO
		 * 
		 * @param entId 就诊ID
		 * @param queTp 队列类型
		 * @return
		 * @throws BizException
		 */
		private EnQueueDO getEnQueue(String entId) throws BizException{
			String whereStr = String.format("%s.ID_ENT = '%s' AND %s.SD_ENTQUE_TP = '%s'", 
					EnQueueDODesc.TABLE_ALIAS_NAME, entId,
					EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_EMP);
			EnQueueDO[] queues = ServiceFinder.find(IEnqueueRService.class).find(whereStr, null, FBoolean.FALSE);
			return queues[0];
		}
	/**
	 * 验证数据
	 * 
	 * @param patCode
	 * @param opTimes
	 * @param queBenCode
	 * @param oprCode
	 * @throws BizException
	 */
	private void validParam(String patCode,Integer opTimes,String queBenCode,String oprCode) throws BizException {
		if(EnValidator.isEmpty(patCode))
			throw new BizException("患者编码不能为空！");
		if(opTimes ==null)
			throw new BizException("就诊次数不能为空！");
		if(EnValidator.isEmpty(queBenCode))
			throw new BizException("分诊台编码不能为空！");
		if(EnValidator.isEmpty(oprCode))
			throw new BizException("操作员编码不能为空！");
	}
	/**
	 * 校验挂号状态
	 * @param opRegDTO
	 * @param regRst
	 */
	private void validateEnInfo(OpRegDTO opRegDTO, TriageBenInfoDTO triageBenInfo) throws BizException{
		if(triageBenInfo.getId_dayslot()!=null && !triageBenInfo.getId_dayslot().equals(opRegDTO.getId_dateslot()))
			return;
		String res = new GetVisitFlagBP().getVisitStatus(opRegDTO.getSd_status(), opRegDTO.getSd_status_acpt(), opRegDTO.getId_que_site(), opRegDTO.getSortno_called());
		if(WsEp.STATUS_TRIAGE.equals(res)){
			throw new BizException("已分诊，请等候叫号接诊!");
		}
		if (WsEp.STATUS_NOTIFY.equals(res)) {
			throw new BizException(String.format("已叫号，请直接到%s处接诊!", getSiteName(opRegDTO.getId_que_site())));
		}
		if(WsEp.STATUS_TRIAGEANDSCREENED.equals(res)){
			throw new BizException("已上屏，请等候叫号接诊!");
		}
	}
	/**
	 * 获取分诊台信息
	 * 
	 * @param benCode
	 * @return
	 * @throws BizException
	 */
	private TriageBenInfoDTO getTriageBenInfo(String benCode) throws BizException{		
		IQuebenRService queService = ServiceFinder.find(IQuebenRService.class);
		String whereStr = String.format("Code = '%s' and Sd_quebentp = '%s'", benCode, IBdFcDictCodeConst.SD_QUETP_EMP);
		QueBenDO[] benDOs = queService.find(whereStr, "", FBoolean.FALSE);
		TriageBenInfoDTO triageInfo = null;
		if (!EnValidator.isEmpty(benDOs)) {
			IEnQueQryService serv = ServiceFinder.find(IEnQueQryService.class);
			triageInfo = serv.getTriageBenInfo(benDOs[0].getId_queben(), IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		}
		if(triageInfo == null){
			throw new BizException(String.format("未查询到%s对应的分诊台！", benCode));
		}
		return triageInfo;
	}
	/**
	 * 获取患者的挂号信息
	 * 
	 * @param patCode
	 * @param triageInfo
	 * @param optimes
	 * @return
	 * @throws BizException
	 */
	private OpRegDTO getEnRegInfo(String patCode, TriageBenInfoDTO triageInfo, String optimes)
			throws BizException {
		//获取患者id
		String whereStr = String.format("Code = '%s' and Fg_invd = 'N'", patCode);
		IPatiMDORService rService = ServiceFinder.find(IPatiMDORService.class);
		PatDO[] patDo = rService.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(patDo)){
			throw new BizException(String.format("未查询到%s对应的患者信息！", patCode));
		}
		GetOpRegListByPatBP bp = new GetOpRegListByPatBP();
		List<String> patIdList = new ArrayList<String>();
		patIdList.add(patDo[0].getId_pat());
		List<String> benIdList = new ArrayList<String>();
		benIdList.add(triageInfo.getId_queben());
	    OpRegDTO[]  opRegDTOs= bp.getOpRegList(null, patIdList, null , benIdList, EnAppUtils.getAcptQryDateTime(triageInfo.getDate(), triageInfo.getId_dayslot()), optimes);
	    if(EnValidator.isEmpty(opRegDTOs)){
	    	throw new BizException("未检索到在该分诊台分诊的挂号信息!");
	    }
		return opRegDTOs[0];
	}
	/**
	 * 设置患者为回诊
	 * 
	 * @param opRegDTO
	 * @throws BizException
	 */
	private void setEntFirstOrRtn(OpRegDTO opRegDTO)  throws BizException {
		if(!IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(opRegDTO.getSd_status_acpt()))
			return;
		if(FBoolean.TRUE.equals(opRegDTO.getFg_needrtn()))
			return;
		if(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER.equals(opRegDTO.getSd_status()) 
				|| IEnDictCodeConst.SD_ENSTATUS_OP_FINISH.equals(opRegDTO.getSd_status())){
			IEnQueCmdService serv = ServiceFinder.find(IEnQueCmdService.class);
			serv.setEntFirstOrRtn(opRegDTO.getId_ent(), FBoolean.FALSE);
		}
	}
	
	/**
	 * 签到
	 * @param opRegDTOs
	 * @param triageDTO
	 * @param regRst
	 * @throws BizException
	 */
	private void makeArrive(OpRegDTO opRegDTO, TriageBenInfoDTO triageDTO) throws BizException {
		IEnQueCmdService service = ServiceFinder.find(IEnQueCmdService.class);
		service.arrive(opRegDTO, triageDTO);	
	}
	/**
	 * 自动分诊
	 * @param opRegDTOs
	 * @param regRst
	 * @throws BizException
	 */
	private void autoTriage(OpRegDTO opRegDTO, TriageBenInfoDTO triageBenInfo, ArriveResultBean regRst) throws BizException{		
		try {
			IEnQueOutCmdService service = ServiceFinder.find(IEnQueOutCmdService.class);
			FMap map = service.autoTriagePat(triageBenInfo, opRegDTO.getId_ent());
			if(map!=null && map.containsKey("site")){
				regRst.setCode(NoErrorStatus);
				regRst.setSiteName(map.get("site").toString());
			}
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
		}	
	}
	/**
	 * 获取医生站点名称
	 * 
	 * @param siteId
	 * @return
	 * @throws BizException
	 */
	private String getSiteName(String siteId) throws BizException{
		IQuesiteRService serv = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO site =  serv.findById(siteId);
		if(site == null)
			throw new BizException("获取医生诊台失败！");
		return site.getName();
	}
}
