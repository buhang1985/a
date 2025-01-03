package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BdQueEP;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.acpt.rule.CheckAcptRuleBp;
import iih.en.que.s.bp.op.qry.benmgr.GetQue4BenMgrBP;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 是否可以接诊（分诊）
 * 
 * @author liubin
 *
 */
public class AcptUtilsBP {

	/**
	 * 判断能否接诊
	 * 
	 * @param entId 就诊ID
	 * @param site 站点
	 * @param isTriage 是否是分诊
	 * @param isForceTriage 是否是强制分诊
	 * @return
	 * @throws BizException 
	 */
	public ResultDTO isAcptable(String entId, QueSiteDO site, FBoolean isTriage, FBoolean isForceTriage, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		ResultDTO result = new ResultDTO();
		//判断患者信息
		result = getPativisitInfo(entId,result);
		if(!EnValidator.isEmpty(result)){
			return result;
		}else{
			result =  new  ResultDTO();
		}
		if(EnValidator.isEmpty(site)){
			result.setFlag(FBoolean.FALSE);
			result.setMsg("医生出诊站点信息为空！");
			return result;
		}
		//校验规则引擎
		CheckAcptRuleBp checkAcptRuleBp = new CheckAcptRuleBp();
		ResultDTO res = checkAcptRuleBp.check(entId);
		if(res != null && FBoolean.FALSE.equals(res.getFlag())){
			return res;
		}
		//判断是否注册站点，未注册站点也能接诊
		boolean isNullSite = EnValidator.isEmpty(site.getId_quesite());
		if(!isNullSite && isTriage!=null && isTriage.booleanValue()){
			site = this.getSite(site.getId_quesite());
		    if(!PauseEnum.ONLINE.equals(site.getEu_pause())){
			    result.setFlag(FBoolean.FALSE);
			    result.setMsg("医生站点已经离线，请刷新界面或重新登录医生站！");
			    return result;
		    }
		}
		if(siteInfo.getDate() == null)
			siteInfo.setDate(EnAppUtils.getServerDate().asBegin());
		OutpatientDO op = this.getOp(entId);
		//1.判断是否在有效期
		FDateTime curTime = EnAppUtils.getAcptQryDateTime(siteInfo.getDate(), siteInfo.getId_dayslot());
		if(EnAppUtils.getAdvanceAcptTime(curTime).compareTo(op.getDt_valid_b()) < 0 || curTime.compareTo(op.getDt_valid_e()) > 0){
			result.setFlag(FBoolean.FALSE);
			result.setMsg(String.format(IEnMsgConst.ERROR_OUT_VALIDITY, op.getDt_valid_b(), op.getDt_valid_e()));
			return result;
		}

		EnQueueDO enQueue = this.getEnQue(entId);
		
		//2.如果是分诊台分诊到本站点, 允许直接接诊
		if(!isNullSite){
			if(!EnValidator.isEmpty(site.getId_que()) && site.getId_que().equals(enQueue.getId_que())){
			    result.setFlag(FBoolean.TRUE);
			    return result;
		    }
		}
		
		//3.如果EN_ENT_op.id_dep_reg = 当前科室
		if(op.getId_dep_reg().equals(site.getId_dep())){
			if(EnParamUtils.hasWholeDeptAcptAuth(site.getId_emp())){
				result.setFlag(FBoolean.TRUE);
				return result;
			}
			if(!EnValidator.isEmpty(op.getId_emp_reg())){
				//判断是否是挂这个医生的号
				if(op.getId_emp_reg().equals(site.getId_emp())){
					result.setFlag(FBoolean.TRUE);
					return result;
				}
			}
			boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
			if(isBenQueMgr){
				return benQueMgrValidate(site, op, enQueue, isTriage, siteInfo);
			}else{
				return empQueMgrValidate(entId, site, op, isTriage, isForceTriage);
			}
		}
		//4.如果EN_ENT_op.id_dep_reg !=当前科室
		else{
			//是否允许跨科接诊
			return new CheckCrossDeptAcptBP().exec(op.getId_dep_reg(), site.getId_dep());
		}
	}
	/**
	 * 判断患者就诊信息
	 * 
	 * @return
	 * @throws BizException 
	 */
	private ResultDTO getPativisitInfo(String entId,ResultDTO resultDTO) throws BizException{
		if(EnValidator.isEmpty(entId)){
			resultDTO.setFlag(FBoolean.FALSE);
			resultDTO.setMsg("患者就诊信息为空！");
			return resultDTO;
		}
		PatiVisitDO patiVisitDO = this.getPv(entId);
		if(!EnValidator.isEmpty(patiVisitDO) && FBoolean.TRUE.equals(patiVisitDO.getFg_canc())){
			resultDTO.setFlag(FBoolean.FALSE);
			resultDTO.setMsg("患者已退号，不能就诊！");
			
		}else{
			resultDTO = null;
		}
		return resultDTO;
	}
	/**
	 * 医生管理队列校验
	 * 
	 * @return
	 */
	private ResultDTO empQueMgrValidate(String entId, QueSiteDO site, OutpatientDO op, FBoolean isTriage, FBoolean isForceTriage) throws BizException{
		ResultDTO result = new ResultDTO();
		QueDO que = this.getQue(site.getId_que());
		if(que != null){
			if(que.getId_scres().equals(op.getId_scres())){
				if(EnValidator.isEmpty(op.getId_emp_reg())) {
					result.setFlag(FBoolean.TRUE);
					return result;
				}
				if(!EnValidator.isEmpty(op.getId_emp_reg())){
					if(op.getId_emp_reg().equals(site.getId_emp())){
						result.setFlag(FBoolean.TRUE);
						return result;
					}
				}
				if(FBoolean.TRUE.equals(isTriage)){
					result.setFlag(FBoolean.FALSE);
					result.setMsg(String.format("患者的挂号医生是%s，不允许分诊!", op.getEmp_reg_name()));
					return result;
				}else{
					result.setFlag(FBoolean.FALSE);
					result.setMsg(String.format("患者的挂号医生是%s，不允许接诊!", op.getEmp_reg_name()));
					return result;
				}
			}
			if(FBoolean.TRUE.equals(isTriage)) {
				if(FBoolean.TRUE.equals(isForceTriage) && op.getId_scsrv().equals(que.getId_scsrv())){
					result.setFlag(FBoolean.TRUE);
					return result;
				}
			}
		}
		PatiVisitDO pv = this.getPv(entId);
		if(FBoolean.TRUE.equals(pv.getFg_acptvalid())){
			result.setFlag(FBoolean.TRUE);
			return result;
		}else{
			boolean isDepReg = IsDepReg(op.getId_scres());
			if(EnParamUtils.isUseDeptSch(site.getId_dep()) && isDepReg){
				result.setFlag(FBoolean.TRUE);
				return result;
			}else {
				if(FBoolean.TRUE.equals(isTriage)){
					result.setFlag(FBoolean.FALSE);
					result.setMsg(String.format("患者的挂号资源是%s，不允许分诊!", op.getScres_name()));
					return result;
				}else{
					result.setFlag(FBoolean.FALSE);
					result.setMsg(String.format("患者的挂号资源是%s，不允许接诊!", op.getScres_name()));
					return result;
				}
			}
		}
	}
	/**
	 * 分诊台管理队列
	 * 
	 * @return
	 * @throws BizException 
	 */
	private ResultDTO benQueMgrValidate(QueSiteDO site, OutpatientDO op, EnQueueDO enQueue, FBoolean isTriage, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		ResultDTO result = new ResultDTO();
		String[] queIds = new GetQue4BenMgrBP().getQueIdsBySiteId(siteInfo);
		if(!EnValidator.isEmpty(queIds)){
			for(String queId : queIds){
				if(queId.equals(enQueue.getId_que())){
					result.setFlag(FBoolean.TRUE);
					return result;
				}
			}
		}
		PatiVisitDO pv = this.getPv(op.getId_ent());
		if(FBoolean.TRUE.equals(pv.getFg_acptvalid())){
			result.setFlag(FBoolean.TRUE);
			return result;
		}
		else{
			if(FBoolean.TRUE.equals(isTriage)){
				result.setFlag(FBoolean.FALSE);
				result.setMsg(String.format("患者的挂号资源是%s，不允许分诊!", op.getScres_name()));
				return result;
			}else{
				result.setFlag(FBoolean.FALSE);
				result.setMsg(String.format("患者的挂号资源是%s，不允许接诊!", op.getScres_name()));
				return result;
			}
		}
	}
	/**
	 * 获取门诊DO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private OutpatientDO getOp(String entId) throws BizException{
		OpEP opEP = new OpEP();
		OutpatientDO op = opEP.getOpByEntId(entId);
		if(op == null)
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		return op;
	}
	/**
	 * 获取门诊队列
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO getEnQue(String entId) throws BizException{
		EnQueEP enQueEP = new EnQueEP();
		EnQueueDO[] enQueues = enQueEP.getEnQueueByEntId(entId, IBdFcDictCodeConst.SD_QUETP_EMP);
		if(EnValidator.isEmpty(enQueues))
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		return enQueues[0];
	}
	/**
	 * 获取就诊DO
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPv(String entId) throws BizException{
		PvEP enBP = new PvEP();
		PatiVisitDO pv = enBP.getPvById(entId);
		if(pv == null)
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		return pv;
	}
	/***
	 * @Description:挂号对应的资源是否是部门类型的
	 * @param id_scres
	 * @return
	 * @throws BizException
	 */
	private boolean IsDepReg(String id_scres) throws BizException{
		if(!EnValidator.isEmpty(id_scres)){
			IScheduleresRService service = ServiceFinder.find(IScheduleresRService.class);
			ScheduleResDO resDo = service.findById(id_scres);
			if(!EnValidator.isEmpty(resDo) && IScDictCodeConst.SD_SCRESTP_DEP.equals(resDo.getSd_screstp())){
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取出诊站点
	 * 
	 * @param siteId
	 * @return
	 * @throws BizException
	 */
	private QueSiteDO getSite(String siteId) throws BizException{
		BdSiteEP siteEP = new BdSiteEP();
		QueSiteDO site = siteEP.getSiteById(siteId);
		if(site == null)
			throw new BizException("未找到工作点!");
		return site;
	}
	/**
	 * 获取医生出诊队列
	 * 
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	private QueDO getQue(String queId) throws BizException{
		if(EnValidator.isEmpty(queId))
			return null;
		BdQueEP queEP = new BdQueEP();
		return queEP.getQueById(queId);
	}
}
