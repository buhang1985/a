/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.bp.write;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamCudService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrfs.i.ICimrfsCudService;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.cimrsource.i.ICimrsourceCudService;
import iih.ci.mr.cimrsource.i.ICimrsourceRService;
import iih.ci.mr.mraudit.i.IMrAuitExt;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueCudService;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.mrlog.d.CiMrLogDO;
import iih.ci.mr.mrlog.i.ICimrlogCudService;
import iih.ci.mr.mrlogitm.d.CiMrLogItmDO;
import iih.ci.mr.mrlogitm.i.IMrlogitmCudService;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.i.IMrsignCudService;
import iih.ci.mr.mrsign.i.IMrsignMDOCudService;
import iih.ci.mr.mrsign.i.IMrsignMDORService;
import iih.ci.mr.mrsign.i.IMrsignRService;
import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import iih.ci.mrqc.qaflt.i.IQafltRService;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeCudService;
import iih.ci.mrqc.revisionnotice.i.IRevisionnoticeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 〈连续书写相关保存〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrWriteSaveBP {
	/**
	 * 保存mrdo
	 * @param mrDo
	 * @return
	 * @throws BizException
	 */
	public CiMrDO SaveMrDo(CiMrDO mrDo) throws BizException{
		ICiemrCudService mrService=ServiceFinder.find(ICiemrCudService.class);
		ICiemrRService mrFService=ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] mrDoArr;
		if (mrDo.getId_mr()==null) {//新增
			CiMrDO ciMrDo=new CiMrDO();
			ciMrDo.setId_grp(Context.get().getGroupId());
			ciMrDo.setId_org(Context.get().getOrgId());
			ciMrDo.setId_emp(Context.get().getUserId());
			ciMrDo.setId_mr_bt(mrDo.getId_mr_bt());
			ciMrDo.setId_dep(Context.get().getDeptId());
			ciMrDo.setId_mrtpl(mrDo.getId_mrtpl());
			ciMrDo.setId_mrtp(mrDo.getId_mrtp());
			ciMrDo.setId_mred(mrDo.getId_mred());
			ciMrDo.setId_flowtype(mrDo.getId_flowtype());
			ciMrDo.setId_reviewtp(mrDo.getId_reviewtp());
			ciMrDo.setSd_reviewtp(mrDo.getSd_reviewtp());
			ciMrDo.setId_mr_signlvl(mrDo.getId_mr_signlvl());
			ciMrDo.setSd_mr_signlvl(mrDo.getSd_mr_signlvl());
			ciMrDo.setId_mrsigntpl(mrDo.getId_mrsigntpl());
			ciMrDo.setId_mrcactm(mrDo.getId_mrcactm());
			ciMrDo.setNewtop(mrDo.getNewtop());
			ciMrDo.setNewend(mrDo.getNewend());
			ciMrDo.setName(mrDo.getName());
			ciMrDo.setId_ent(mrDo.getId_ent());
			ciMrDo.setId_pat(mrDo.getId_pat());
			ciMrDo.setDt_rd(mrDo.getDt_rd());
			ciMrDo.setId_su_mr(mrDo.getId_su_mr());
			ciMrDo.setSd_su_mr(mrDo.getSd_su_mr());
			ciMrDo.setCode_entp(mrDo.getCode_entp());
			ciMrDo.setId_sex(mrDo.getId_sex());
			ciMrDo.setId_emp_higher(mrDo.getId_emp_higher());
			ciMrDo.setTask_id(mrDo.getTask_id());
			ciMrDo.setId_sex(mrDo.getId_sex());
			ciMrDo.setReviewtp_name(mrDo.getReviewtp_name());
			ciMrDo.setCreatedby(Context.get().getUserId());
			ciMrDo.setCreatedtime(new FDateTime());
			ciMrDo.setModifiedby(Context.get().getUserId());
			ciMrDo.setModifiedtime(new FDateTime());
			ciMrDo.setId_emp_higher(mrDo.getId_emp_higher());
			ciMrDo.setStatus(DOStatus.NEW);
			mrDoArr= mrService.save(new CiMrDO[]{ciMrDo});
			return mrFService.findById(mrDoArr[0].getId_mr());
		} else {
			mrDoArr= mrService.update(new CiMrDO[]{mrDo});
			return mrDoArr[0];
		}
	}
	/**
	 * 保存流do
	 * @param mrFsDo
	 * @return
	 * @throws BizException
	 */
	public CiMrFsDO SaveMrFsDo(CiMrFsDO mrFsDo) throws BizException{
		ICimrfsCudService mrFsService=ServiceFinder.find(ICimrfsCudService.class);
		CiMrFsDO[] mrDoArr;
		if (mrFsDo.getId_mrfs()!=null) {
			mrDoArr=mrFsService.update(new CiMrFsDO[]{mrFsDo});
		} else {
			mrDoArr=mrFsService.save(new CiMrFsDO[]{mrFsDo});
		}
		return mrDoArr[0];
	}
	/**
	 * 保存引用
	 * @param ReferenceValues
	 * @return
	 * @throws BizException
	 */
	public MrDocRefValueDO[] SaveMrDocRefValueDos(MrDocRefValueDO[] ReferenceValues) throws BizException {
		if (ReferenceValues == null || ReferenceValues.length == 0)
			return null;
		IMrdocrefvalueRService rservice = ServiceFinder.find(IMrdocrefvalueRService.class);
		IMrdocrefvalueCudService cudservice = ServiceFinder.find(IMrdocrefvalueCudService.class);
		MrDocRefValueDO[] OldRefValueArr = rservice.find("id_ent = '"+ ReferenceValues[0].getId_ent() + "'", null, new FBoolean(false));

		List<MrDocRefValueDO> beSaveValues = new ArrayList<MrDocRefValueDO>();
		MrDocRefValueDO[] savedValues;

		for (MrDocRefValueDO sValue : ReferenceValues) {
			boolean bFound = false;
			for (MrDocRefValueDO oValue : OldRefValueArr) {
				if (sValue.getId_ent().equals(oValue.getId_ent())
						&& sValue.getCode_element().equals(
								oValue.getCode_element())) {
					bFound = true;
					oValue.setId_mr(sValue.getId_mr());
					oValue.setContent(sValue.getContent());
					oValue.setStatus(DOStatus.UPDATED);
					beSaveValues.add(oValue);
					break;
				}

			}
			if (!bFound) {
				beSaveValues.add(sValue);
			}
		}
		savedValues = cudservice.save(beSaveValues.toArray(new MrDocRefValueDO[0]));
		return savedValues;
	}
	/**
	 * 保存病历源
	 * @param ReferenceValues
	 * @return
	 * @throws BizException
	 */
	public CiMrSourceDO[] SaveMrSourceDo(CiMrSourceDO[] sourceDoArr,String id_mr) throws BizException {
		ICimrsourceCudService sourceService=ServiceFinder.find(ICimrsourceCudService.class);
		ICimrsourceRService findService=ServiceFinder.find(ICimrsourceRService.class);
		CiMrSourceDO[] returnArr;
		CiMrSourceDO[] deleteArr=findService.find("a0.id_mr='"+id_mr+"'", "", FBoolean.FALSE);
		if (deleteArr.length>0) {
			sourceService.delete(deleteArr);
			returnArr=sourceService.save(sourceDoArr);
			return returnArr;
		}else {
			returnArr=sourceService.save(sourceDoArr);
			return returnArr;
		}
	}
	/**
	 * 文书签名保存方法
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public CiMrDO SignMrDo(CiMrDO ciMrDO) throws BizException{
		
		ICiemrCudService mrService=ServiceFinder.find(ICiemrCudService.class);
		//保存文书的签名
		ciMrDO.setId_emp_lat(Context.get().getUserId());
		ciMrDO.setFg_sign(FBoolean.TRUE);
		ciMrDO.setDt_sign_lat(new FDateTime());
		
		CiMrDO[] mrArr=mrService.update(new CiMrDO[]{ciMrDO});
		//保存签名do
		IMrsignMDOCudService signService=ServiceFinder.find(IMrsignMDOCudService.class);
		CiMrSignDO signDO=new CiMrSignDO();
		signDO.setId_mr(ciMrDO.getId_mr());
		signDO.setId_emp_sign(Context.get().getStuffId());
		signDO.setDt_sign(new FDateTime());
		signDO.setStatus(DOStatus.NEW);
		CiMrSignDO[] signArr = signService.save(new CiMrSignDO[]{signDO});
		if (signArr.length>0) {
			return mrArr[0];
		} else {
			return null;
		}
	}
	/**
	 * 文书提交
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public CiMrDO SubmitMrDo(CiMrDO ciMrDO) throws BizException {
		String id_user =Context.get().getUserId();
		String id_dep =Context.get().getDeptId();
		CiMrDO recCiMrDO;
		IMrAuitExt submitService=ServiceFinder.find(IMrAuitExt.class);
		ICiemrCudService mrService=ServiceFinder.find(ICiemrCudService.class);
		//提交的是二级审签或者 三级审签
		if ((ciMrDO.getSd_reviewtp()!=null&&ciMrDO.getSd_reviewtp().equals(ICiMrDictCodeConst.SD_MRREVIEW_TWOLEVEL))||
				(ciMrDO.getSd_reviewtp()!=null&&ciMrDO.getSd_reviewtp().equals(ICiMrDictCodeConst.SD_MRREVIEW_THREELEVEL))) {
			//驳回的文书 走原有的审批流
			if (ciMrDO.getSd_su_mr()!=null&&ciMrDO.getSd_su_mr().equals(ICiMrDictCodeConst.SD_SU_MR_REJECT)) {
				
				String task_id=submitService.getCompletedTask(id_user, ciMrDO.getId_mr());
				if (!task_id.equals(null)) {
					recCiMrDO=submitService.nextStep(id_user, ciMrDO, task_id);
					return recCiMrDO;
				} else {
					return null;
				}
				
			} else {//新建或者取回的走新的审批流
				//先保存mrdo
				ciMrDO.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
				ciMrDO.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
				ciMrDO.setDate_submit(new FDateTime());
				ciMrDO.setId_emp_submit(id_user);
				ciMrDO.setId_emp_audit(id_user);
				ciMrDO.setId_submit_dept(id_dep);
				CiMrDO[] mrArr=mrService.update(new CiMrDO[]{ciMrDO});
				//提交到审批流
				recCiMrDO=submitService.startProcess(id_user, mrArr[0]);
				return recCiMrDO;
			}
		} else {
			//无需审签的 直接保存mrdo
			ciMrDO.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
			ciMrDO.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
			ciMrDO.setDate_submit(new FDateTime());
			ciMrDO.setId_emp_submit(id_user);
			ciMrDO.setId_emp_audit(id_user);
			ciMrDO.setId_submit_dept(id_dep);
			CiMrDO[] mrArr=mrService.update(new CiMrDO[]{ciMrDO});
			return mrArr[0];
		}
	}
	/**
	 * 保存文书操作日志
	 * @param id_type
	 * @param sd_type
	 * @param ciMrDo
	 * @return
	 * @throws BizException
	 */
	public CiMrLogDO SaveMrLog(String id_type, String sd_type, CiMrDO ciMrDo,String hostid) throws BizException{
		ICimrlogCudService logService =ServiceFinder.find(ICimrlogCudService.class);
		CiMrLogDO logDo=new CiMrLogDO();
		logDo.setId_mr(ciMrDo.getId_mr());
		logDo.setId_type_operate(id_type);
		logDo.setSd_type_operate(sd_type);
		logDo.setId_user_operate(Context.get().getUserId());
		logDo.setDt_operate(new FDateTime());
		logDo.setId_grp(Context.get().getGroupId());
		logDo.setId_org(Context.get().getOrgId());
		//logDo.setHostid(hostid);
		logDo.setStatus(DOStatus.NEW);
		CiMrLogDO[] logArr= logService.save(new CiMrLogDO[]{logDo});
		if (logArr.length>0) {
			return logArr[0];
		} else {
			return new CiMrLogDO();
		}
	}
	/**
	 * 保存文书操作日志明细
	 * @param CiMrLogItmList
	 * @return
	 * @throws BizException
	 */
	public CiMrLogItmDO[] SaveMrLogItm(CiMrLogItmDO[] CiMrLogItmList) throws BizException {
		IMrlogitmCudService logitmService=ServiceFinder.find(IMrlogitmCudService.class);
		return logitmService.save(CiMrLogItmList);
	}
	/**
	 * 签名大方法
	 * @param mrDo
	 * @param fsDo
	 * @return
	 */
	/*public CiMrDO SignAndSubmitMr(CiMrDO mrDo,CiMrFsDO fsDo,String title) throws BizException{
		ICiemrCudService mrService=ServiceFinder.find(ICiemrCudService.class);
		IMrsignCudService signService=ServiceFinder.find(IMrsignCudService.class);
		IMrAuitExt submitService=ServiceFinder.find(IMrAuitExt.class);
		String id_user =Context.get().getUserId();
		String id_dep =Context.get().getDeptId();
		CiMrDO returnDo =null;
		CiMrDO[] mrDoArr;
		if (mrDo.getId_mr()==null) {//新增
			CiMrDO ciMrDo=new CiMrDO();
			ciMrDo.setId_grp(Context.get().getGroupId());
			ciMrDo.setId_org(Context.get().getOrgId());
			ciMrDo.setId_emp(id_user);
			ciMrDo.setId_dep(id_dep);
			ciMrDo.setId_mrtpl(mrDo.getId_mrtpl());
			ciMrDo.setId_mrtp(mrDo.getId_mrtp());
			ciMrDo.setId_mred(mrDo.getId_mred());
			ciMrDo.setId_flowtype(mrDo.getId_flowtype());
			ciMrDo.setId_reviewtp(mrDo.getId_reviewtp());
			ciMrDo.setSd_reviewtp(mrDo.getSd_reviewtp());
			ciMrDo.setId_mrcactm(mrDo.getId_mrcactm());
			ciMrDo.setNewend(mrDo.getNewtop());
			ciMrDo.setNewend(mrDo.getNewend());
			ciMrDo.setName(mrDo.getName());
			ciMrDo.setId_ent(mrDo.getId_ent());
			ciMrDo.setId_pat(mrDo.getId_pat());
			ciMrDo.setDt_rd(mrDo.getDt_rd());
			ciMrDo.setId_su_mr(mrDo.getId_su_mr());
			ciMrDo.setSd_su_mr(mrDo.getSd_su_mr());
			ciMrDo.setCode_entp(mrDo.getCode_entp());
			ciMrDo.setStatus(DOStatus.NEW);
			//保存文书的签名
			ciMrDo.setId_emp_lat(id_user);
			ciMrDo.setFg_sign(FBoolean.TRUE);
			ciMrDo.setDt_sign_lat(new FDateTime());
			mrDoArr= mrService.save(new CiMrDO[]{ciMrDo});
			if (mrDoArr.length>0) {
				returnDo=mrDoArr[0];
				returnDo.setDate_submit(new FDateTime());
				returnDo.setId_emp_submit(id_user);
				returnDo.setId_emp_audit(id_user);
				returnDo.setId_submit_dept(id_dep);
				ICiMrParamService ciMrParamService = ServiceFinder.find(ICiMrParamService.class);
				Boolean isSign = ciMrParamService.getSysParamIsSignLevel(Context.get().getOrgId());
				if(isSign){
					IMrSignMaintainService mrSignMaintainService = ServiceFinder.find(IMrSignMaintainService.class);
					Boolean isMaxTitle = mrSignMaintainService.isMaxTitle(returnDo, title);
					if(isMaxTitle){
						returnDo.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_COMPLETE);
						returnDo.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_COMPLETE);
					}
				}else{
					returnDo.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
					returnDo.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
				}
				CiMrDO[] mrArr=mrService.update(new CiMrDO[]{returnDo});
				if (mrArr.length>0) {
					returnDo=mrArr[0];
				}
			}
		} else {
			returnDo=mrDo;
			//保存文书的签名
			returnDo.setId_emp_lat(id_user);
			returnDo.setFg_sign(FBoolean.TRUE);
			returnDo.setDt_sign_lat(new FDateTime());
			returnDo.setDate_submit(new FDateTime());
			returnDo.setId_emp_submit(id_user);
			returnDo.setId_emp_audit(id_user);
			returnDo.setId_submit_dept(id_dep);
			ICiMrParamService ciMrParamService = ServiceFinder.find(ICiMrParamService.class);
			Boolean isSign = ciMrParamService.getSysParamIsSignLevel(Context.get().getOrgId());
			if(isSign){
				IMrSignMaintainService mrSignMaintainService = ServiceFinder.find(IMrSignMaintainService.class);
				Boolean isMaxTitle = mrSignMaintainService.isMaxTitle(returnDo, title);
				if(isMaxTitle){
					returnDo.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_COMPLETE);
					returnDo.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_COMPLETE);
				}else{
					returnDo.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
					returnDo.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
				}
			}else{
				returnDo.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
				returnDo.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
			}
			CiMrDO[] mrArr=mrService.update(new CiMrDO[]{returnDo});
			if (mrArr.length>0) {
				returnDo=mrArr[0];
			}
		}
		//保存流
		if (returnDo!=null) {
			CiMrFsDO ciMrFsDO;
			if (fsDo.getId_mrfs()==null) {//新建 未经过保存直接提交
				ciMrFsDO=new CiMrFsDO();
				ciMrFsDO.setId_mr(returnDo.getId_mr());
				ciMrFsDO.setEmrfs(fsDo.getEmrfs());
				ciMrFsDO.setStatus(DOStatus.NEW);
				
			} else {//更新
				ciMrFsDO = fsDo;
				ciMrFsDO.setStatus(DOStatus.UPDATED);				
			}
			
			CiMrFsBP ciMrFsBP = new CiMrFsBP();
			try {
				ciMrFsBP.SaveCiMrFsDO(returnDo, ciMrFsDO);
			} catch (IOException e) {
				FastdfsMrLogger.error("病历："+e.getMessage()+e.getStackTrace());
				e.printStackTrace();
			}
		}
		return returnDo;
	}*/
	/**
	 * 另存为模板
	 * @param emrTplDO
	 * @param tplStreamDo
	 * @return
	 * @throws BizException
	 */
	public EmrTplDO SaveAsTpl(EmrTplDO emrTplDO,EmrTplStreamDO tplStreamDo) throws BizException {
		IEmrtplMDOCudService tplService =ServiceFinder.find(IEmrtplMDOCudService.class);
		IMrtplstreamCudService tplFsService=ServiceFinder.find(IMrtplstreamCudService.class);
		EmrTplDO[] tplArr=tplService.save(new EmrTplDO[]{emrTplDO});
		if (tplArr.length>0) {
			tplStreamDo.setId_mrtpl(tplArr[0].getId_mrtpl());
			tplStreamDo.setStatus(DOStatus.NEW);
			tplFsService.save(new EmrTplStreamDO[]{tplStreamDo});
			return tplArr[0];
		}else{
			return null;
		}
	}
	/**
	 * 文书取回逻辑方法--2、3级审签
	 * @param ciMrDO
	 * @param fsByte
	 * @return
	 * @throws BizException 
	 */
	public CiMrDO getBackMrForTwoOrThreeLvl(CiMrDO ciMrDO,CiMrFsDO ciMrFsDO,String taskId) throws BizException{
		String id_user=Context.get().getUserId();
		IMrAuitExt auditService =ServiceFinder.find(IMrAuitExt.class);
		ICiemrCudService mrService=ServiceFinder.find(ICiemrCudService.class);
		ICimrfsCudService fsService=ServiceFinder.find(ICimrfsCudService.class);
		IMrsignMDOCudService signService=ServiceFinder.find(IMrsignMDOCudService.class);
		IMrsignMDORService signFService=ServiceFinder.find(IMrsignMDORService.class);
		//删除签名
		CiMrSignDO[] signDoArr=signFService.find("id_mr='"+ciMrDO.getId_mr()+"' and id_emp_sign='"+id_user+"'", "dt_sign desc", FBoolean.FALSE);
		if (signDoArr!=null && signDoArr.length>0) {
			signService.delete(signDoArr);
		}
		//更新流
		fsService.save(new CiMrFsDO[]{ciMrFsDO});
		CiMrDO auditDO=auditService.backTask(id_user, ciMrDO, taskId);
		auditDO.setFg_sign(FBoolean.FALSE);
		//更新mrdo
		CiMrDO[] mrArr= mrService.save(new CiMrDO[]{auditDO});
		if (mrArr.length>0) {
			return mrArr[0];
		} else {
			return null;
		}
	}
	/**
	 * 文书取回逻辑方法--1级审签
	 * @param ciMrDO
	 * @param fsByte
	 * @return
	 * @throws BizException 
	 */
	public CiMrDO getBackMrForOneLvl(CiMrDO ciMrDO,CiMrFsDO ciMrFsDO) throws BizException{
		String id_user=Context.get().getUserId();
		ICiemrCudService mrService=ServiceFinder.find(ICiemrCudService.class);
		ICimrfsCudService fsService=ServiceFinder.find(ICimrfsCudService.class);
		IMrsignMDOCudService signService=ServiceFinder.find(IMrsignMDOCudService.class);
		IMrsignMDORService signFService=ServiceFinder.find(IMrsignMDORService.class);
		//删除签名
		CiMrSignDO[] signDoArr=signFService.find("id_mr='"+ciMrDO.getId_mr()+"' and id_emp_sign='"+id_user+"'", "dt_sign desc", FBoolean.FALSE);
		if (signDoArr!=null && signDoArr.length>0) {
			signService.delete(signDoArr);
		}
		//更新流
		fsService.save(new CiMrFsDO[]{ciMrFsDO});
		//更新mrdo
		ciMrDO.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_RETRIEVE);
		ciMrDO.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_RETRIEVE);
		ciMrDO.setId_emp_submit(null);
		ciMrDO.setId_emp_audit(null);
		ciMrDO.setDate_submit(null);
		ciMrDO.setId_submit_dept(null);
		ciMrDO.setFg_sign(FBoolean.FALSE);
		this.cancelSign(ciMrDO.getId_mr());
		CiMrDO[] mrArr= mrService.save(new CiMrDO[]{ciMrDO});
		if (mrArr.length>0) {
			return mrArr[0];
		} else {
			return null;
		}
	}
	/**
	 * 连续书写 整改通知批量通过
	 * @param qaNoticeDtos
	 * @param noticeDto 反馈备注
	 * @return
	 * @throws BizException 
	 */
	public RevisionNoticeDO[] batchExeFeedBackRes(QaNoticeDTO[] qaNoticeDtos,QaNoticeDTO noticeDto) throws BizException{
		IRevisionnoticeRService noticeFindService=ServiceFinder.find(IRevisionnoticeRService.class);
		IRevisionnoticeCudService noticeService=ServiceFinder.find(IRevisionnoticeCudService.class);
		if (qaNoticeDtos.length>0) {
			List<String> idRevisions=new ArrayList<String>();
			for (int i = 0; i < qaNoticeDtos.length; i++) {
				idRevisions.add(qaNoticeDtos[i].getId_revision());
			}
			String[] idArr=idRevisions.toArray(new String[0]);
			RevisionNoticeDO[] noticeArr=noticeFindService.findByBIds(idArr, FBoolean.FALSE);
			for (int i = 0; i < noticeArr.length; i++) {
				noticeArr[i].setDes_feedback(noticeDto.getDes_feedback());
				noticeArr[i].setId_status(ICiMrDictCodeConst.ID_HAS_RECTIFICATION);
				noticeArr[i].setSd_status(ICiMrDictCodeConst.SD_HAS_RECTIFICATION);
				noticeArr[i].setStatus(DOStatus.UPDATED);
				updateFlt(noticeArr[i].getId_revision());
			}
			noticeService.save(noticeArr);
			return noticeArr;
		}else {
			return null;
		}
	}
	/**
	 * 更新通知下缺陷状态
	 * @param id_revision
	 * @throws BizException
	 */
	public void updateFlt(String id_revision) throws BizException{
		IQafltRService fltFindService=ServiceFinder.find(IQafltRService.class);
		IQafltCudService fltService=ServiceFinder.find(IQafltCudService.class);
		QaFltDO[] fltArr=fltFindService.find(" id_revision='"+id_revision+"'", "", FBoolean.FALSE);
		for (int i = 0; i < fltArr.length; i++) {
			fltArr[i].setId_flt_sta(ICiMrDictCodeConst.ID_HAS_REFORM);
			fltArr[i].setSd_flt_sta(ICiMrDictCodeConst.SD_HAS_REFORM);
			fltArr[i].setStatus(DOStatus.UPDATED);
		}
		fltService.save(fltArr);
	}
	/**
	 * 保存引用
	 * @param ReferenceValues
	 * @return
	 * @throws BizException
	 */
	public MrDocRefValueDO[] saveSourceReferences(
			MrDocRefValueDO[] ReferenceValues) throws BizException {
		if (ReferenceValues == null || ReferenceValues.length == 0)
			return null;
		IMrdocrefvalueRService rservice = ServiceFinder
				.find(IMrdocrefvalueRService.class);
		IMrdocrefvalueCudService cudservice = ServiceFinder
				.find(IMrdocrefvalueCudService.class);
		MrDocRefValueDO[] OldRefValueArr = rservice.find("id_ent = '"
				+ ReferenceValues[0].getId_ent() + "'", null, new FBoolean(
				false));

		List<MrDocRefValueDO> beSaveValues = new ArrayList<MrDocRefValueDO>();
		MrDocRefValueDO[] savedValues;

		for (MrDocRefValueDO sValue : ReferenceValues) {
			boolean bFound = false;
			for (MrDocRefValueDO oValue : OldRefValueArr) {
				if (sValue.getId_ent().equals(oValue.getId_ent())
						&& sValue.getCode_element().equals(
								oValue.getCode_element())) {
					bFound = true;
					oValue.setId_mr(sValue.getId_mr());
					oValue.setContent(sValue.getContent());
					oValue.setStatus(DOStatus.UPDATED);
					beSaveValues.add(oValue);
					break;
				}

			}
			if (!bFound) {
				beSaveValues.add(sValue);

			}
		}
		savedValues = cudservice.save(beSaveValues
				.toArray(new MrDocRefValueDO[0]));
		return savedValues;
	}
	/**
	 * 签名
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public Boolean saveSign(String id_mr,String title) throws BizException{
		IMrsignMDORService mrsignRService = ServiceFinder.find(IMrsignMDORService.class);
		IMrsignMDOCudService mrsignCudService = ServiceFinder.find(IMrsignMDOCudService.class);
		CiMrSignDO ciMrSignDo = new CiMrSignDO();
		ciMrSignDo.setId_emp_sign(Context.get().getStuffId());
		ciMrSignDo.setDt_sign(new FDateTime());
		ciMrSignDo.setId_mr(id_mr);
		ciMrSignDo.setId_role_sign(title);
		CiMrSignDO[] ciMrSignDos = mrsignRService.find("id_mr = '"+ id_mr +"'", "", FBoolean.FALSE);
		/*if(ciMrSignDos != null && ciMrSignDos.length > 0){
			ciMrSignDo.setFg_up(FBoolean.TRUE);
		}*/
		ciMrSignDo.setStatus(DOStatus.NEW);
		mrsignCudService.save(new CiMrSignDO[]{ciMrSignDo});
		return true;
	}
	
	/**
	 * 取消签名
	 * @param id_mr
	 * @throws BizException 
	 */
	public void cancelSign(String id_mr) throws BizException{
		IMrsignMDORService mrsignRService = ServiceFinder.find(IMrsignMDORService.class);
		IMrsignMDOCudService mrsignCudService = ServiceFinder.find(IMrsignMDOCudService.class);
		CiMrSignDO[] ciMrSignDos = mrsignRService.find("id_mr = '"+ id_mr+"' and id_emp_sign = '"+ Context.get().getStuffId() +"'", "", FBoolean.FALSE);
		if(ciMrSignDos == null || ciMrSignDos.length <= 0){
			return;
		}
		mrsignCudService.logicDelete(ciMrSignDos);
	}
}
