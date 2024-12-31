package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueQryService;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.i.IRuleExecService;
import iih.bd.fc.querule.i.IRuleQryService;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存就诊队列
 * @author yank
 *
 */
public class JoinOpQueBP {
	/**
	 * 保存就诊队列
	 * @param pvDO 就诊DO
	 * @param regInfo 挂号信息
	 * @throws BizException
	 */
	public void exec(PatiVisitDO pvDO,RegInfoDTO regInfo)throws BizException {
		RegResDTO resDTO = (RegResDTO) regInfo.getRegresarray().get(0);	
		//1、获取队列		
		QueDO queDO = this.getQue(resDTO);
		//2、计算优先级
		QueRuleItmDO queRuleItm = this.getPriLevel(pvDO, resDTO.getId_scsrv(), queDO.getId_que());
		//3、保存就诊队列		
		this.saveEntQue(pvDO, regInfo, queDO, queRuleItm);
	}
	/**
	 * 获取队列
	 * @param scResId
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	private QueDO getQue(RegResDTO resDTO) throws BizException{
		QueDO queDO;
		if(!EnValidator.isEmpty(resDTO.getId_que())){
			queDO = (QueDO) new DAFacade().findByPK(QueDO.class, resDTO.getId_que());
		}else{
			String sql = "SELECT SC_PL.* FROM SC_PL SC_PL INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL WHERE SC_SCH.ID_SCH = ? ";
			 SqlParam param = new SqlParam();
	         param.addParam(resDTO.getId_sch());
			List<ScPlanDO> list = (List<ScPlanDO>) new DAFacade().execQuery(sql,param, new BeanListHandler(ScPlanDO.class));
			if(EnValidator.isEmpty(list))
				throw new BizException(String.format(IEnMsgConst.ERROR_FORMATTER_OP_REG_NO_QUE,resDTO.getName_scres(), resDTO.getName_dep()));
			IQueQryService queQryService = ServiceFinder.find(IQueQryService.class);
			queDO = queQryService.getQue(list.get(0).getId_scres(), list.get(0).getId_dep(), list.get(0).getId_queben(), IBdFcDictCodeConst.SD_QUETP_EMP);
		}
		if(queDO==null){
			throw new BizException(String.format(IEnMsgConst.ERROR_FORMATTER_OP_REG_NO_QUE,resDTO.getName_scres(), resDTO.getName_dep()));
		}
		return queDO;
	}
	/**
	 * 保存就诊队列
	 * @param pvDO 就诊信息
	 * @param regInfo 挂号信息
	 * @param queDO 队列
	 * @param priority 优先级
	 * @throws BizException
	 */
	private void saveEntQue(PatiVisitDO pvDO,RegInfoDTO regInfo,QueDO queDO,QueRuleItmDO queRuleItm) throws BizException{
		EnQueueDO enQueDO = new EnQueueDO();
		enQueDO.setStatus(DOStatus.NEW);
		enQueDO.setId_grp(pvDO.getId_grp());//所属集团
		enQueDO.setId_org(pvDO.getId_org()); //所属机构		
		enQueDO.setId_ent(pvDO.getId_ent()); //就诊ID
		enQueDO.setId_enttp(pvDO.getId_entp());//就诊类型id
		enQueDO.setCode_entp(pvDO.getCode_entp()); //就诊类型
		enQueDO.setId_pat(pvDO.getId_pat()); //患者ID
		enQueDO.setName_pat(pvDO.getName_pat()); //患者姓名				
		enQueDO.setDt_regist(pvDO.getDt_entry().getDate()); //就诊日期
		enQueDO.setId_dateslot(regInfo.getId_dayslot()); //日期分组
		enQueDO.setId_que(queDO.getId_que()); //队列
		enQueDO.setId_entque_tp(queDO.getId_quetp());//排队类型id
		enQueDO.setSd_entque_tp(queDO.getSd_quetp()); //排队类型
		enQueDO.setTicketno(regInfo.getTickno()); //票号
		enQueDO.setSortno(regInfo.getTickno()); //排序号 		
		enQueDO.setFg_active(FBoolean.TRUE); //有效标志
		enQueDO.setId_tick(regInfo.getId_tick()); //号位ID
		FDateTime time = EnAppUtils.getServerDateTime();
		enQueDO.setDt_in(time); //入队日期
		if(EnParamUtils.isRegAutoSign(queDO == null ? null : queDO.getId_queben()))
			enQueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT); //到诊状态
		else
			enQueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED); //未到诊状态	
		
		FArrayList regResArray = regInfo.getRegresarray();
		if(regResArray==null || regResArray.size()<=0){
			throw new BizException("挂号信息为空");
		}
		RegResDTO resDTO = (RegResDTO) regResArray.get(0);
		
		enQueDO.setId_emp_acpt(resDTO.getId_emp()); // 接受医护人员	
		enQueDO.setId_level_dise(null);
		enQueDO.setSd_level_dise(null);//病情等级
		enQueDO.setLevel_pri(queRuleItm == null ? IEnDictCodeConst.DEFLEVELPRI : queRuleItm.getLevel_pri());//优先级别
		enQueDO.setLevel_pri_rsn(queRuleItm == null ? null : queRuleItm.getName());
		enQueDO.setId_patca(pvDO.getId_patca()); //患者分类
		
		IEnqueueCudService enqueueCudService  = ServiceFinder.find(IEnqueueCudService.class);
		enqueueCudService.insert(new EnQueueDO[]{enQueDO});
	}
	/**
	 * 获取优先级
	 * @param pvDO 就诊ID
	 * @param scSrvId 号别ID
	 * @param queId 队列ID
	 * @return
	 * @throws BizException
	 */
	private QueRuleItmDO getPriLevel(PatiVisitDO pvDO,String scSrvId,String queId) throws BizException{
		//计算优先级	
		IRuleQryService ruleQryService = ServiceFinder.find(IRuleQryService.class);
		QueruleAggDO ruleAggDO = ruleQryService.getQueRule(queId);
		IRuleExecService ruleExecService = ServiceFinder.find(IRuleExecService.class);
		PriorityDTO ruleEntDTO = new PriorityDTO();
		ruleEntDTO.setId_ent(pvDO.getId_ent());
		ruleEntDTO.setId_patca(pvDO.getId_patca());//患者分类
		ruleEntDTO.setId_scsrv(scSrvId);//号别
		ruleEntDTO.setId_sex(pvDO.getId_sex_pat());// 患者性别
		ruleEntDTO.setD_birth(pvDO.getDt_birth_pat());//出生日期
		ruleEntDTO.setId_tagtp(new PatEP().getPatTagTp(pvDO.getId_pat()));
		ruleEntDTO.setFg_vip(this.isVIP(pvDO.getId_ent()));
		return ruleExecService.getMatchRuleItm(ruleAggDO, ruleEntDTO);
	}
	/**
	 * 判定是否是VIP
	 * @param endId
	 * @return
	 * @throws BizException
	 */
    private FBoolean isVIP(String endId) throws BizException{
    	String res =	new GetGcVipTpBP().exec(endId);
    	if(!EnValidator.isEmpty(res) && !IEnConst.TP_VIP_NONE.equals(res)){
    		return FBoolean.TRUE;
    	}
    	return FBoolean.FALSE;
    }
	
}
