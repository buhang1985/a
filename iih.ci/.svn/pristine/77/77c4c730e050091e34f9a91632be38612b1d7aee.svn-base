/*
 * 扼要描述
 * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.bp.write;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.SuMrConst;
import iih.bd.srv.mrcompleterule.d.MrCompleteRuleDO;
import iih.bd.srv.mrcompleterule.i.IMrcompleteruleRService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.mrqc.amrapply.d.AmrApplyDO;
import iih.ci.mrqc.amrapply.i.IAmrapplyRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 〈扼要描述〉 〈功能详细描述〉
 * 
 * @author [邹海强]
 * @version [版本号, YYYY-MM-DD]
 */
public class MrWriteAmrBP {

	/**
	 * 获取病案是否封存
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FBoolean AmrIsSeal(String id_ent) throws BizException {
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("a0.id_ent=");
		sbSql.append("'");
		sbSql.append(id_ent);
		sbSql.append("'");
		String sqlWhere = sbSql.toString();
		AMrDO[] amrDoArr = amrService.find(sqlWhere, "", FBoolean.FALSE);
		if (amrDoArr.length > 0) {
			return amrDoArr[0].getFg_seal();
		} else {
			return FBoolean.FALSE;
		}
	}
	/**
	 * 提交病案验证
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public String SubmitAmr(String id_ent) throws BizException {

		StringBuilder sb = new StringBuilder();
		ICiemrRService emrRService = ServiceFinder.find(ICiemrRService.class);
		//查询新建的文书
		CiMrDO[] cimrDoArr = emrRService.find("a0.id_ent = '" + id_ent
				+ "' And a0.sd_su_mr ='" + SuMrConst.SD_SUMR_NEW + "'", null,
				FBoolean.FALSE);
		if (null != cimrDoArr && cimrDoArr.length > 0)
			sb.append("\r\n该病人还有处于新建状态的医疗文书");
		//组装where条件
		StringBuilder sWhereInAudit = new StringBuilder();
		sWhereInAudit.append(" a0.id_ent = '");
		sWhereInAudit.append(id_ent);
		sWhereInAudit.append("' and  a0.id_reviewtp  in (select br.id_reviewtp from bd_reviewtp br ");
		sWhereInAudit.append("  where a0.id_reviewtp = br.id_reviewtp and a0.id_su_mr <> '");
		sWhereInAudit.append(SuMrConst.ID_SUMR_COMPLETE);
		sWhereInAudit.append("' and br.code not in ( '00','01'))");
		//查询审签的
		cimrDoArr = emrRService.find(sWhereInAudit.toString(), null, FBoolean.FALSE);
		if (null != cimrDoArr && cimrDoArr.length > 0)
			sb.append("\r\n该病人还有未审签完成的医疗文书");
		// 此处验证完成书写规则节点传过来的数据
		IMrcompleteruleRService completeService = ServiceFinder.find(IMrcompleteruleRService.class);
		MrCompleteRuleDO[] ruleArr = completeService.find(" fg_active='Y'", "",FBoolean.FALSE);
		if (ruleArr.length <= 0) {
			return sb.toString();
		}
		for (int i = 0; i < ruleArr.length; i++) {
			if (ruleArr[i].getFg_change() == FBoolean.TRUE) {
				String qry = " a0.id_ent = '" + id_ent + "' and  a0.id_mrtp = '" + ruleArr[i].getId_mrtp() + "'";
				cimrDoArr = emrRService.find(qry, "", FBoolean.FALSE);
				if (cimrDoArr.length <= 0) {
					String mrtpsStr = "'"+ ruleArr[i].getId_change_mrtps().replace(",","','") + "'";
					String sqlwhere = " a0.id_ent = '" + id_ent+ "' and  a0.id_mrtp in (" + mrtpsStr + ")";
					CiMrDO[] cimrDoChangeArr = emrRService.find(sqlwhere, "",FBoolean.FALSE);
					if ((null == cimrDoArr || cimrDoArr.length == 0)&& null == cimrDoChangeArr|| cimrDoChangeArr.length == 0) {
						sb.append("\r\n该病人未建立" + ruleArr[i].getMrtp_name() + "");
					}
				}
			} else {
				String qryby = " a0.id_ent = '" + id_ent+ "' and  a0.id_mrtp = '" + ruleArr[i].getId_mrtp()+ "'";
				cimrDoArr = emrRService.find(qryby, "", FBoolean.FALSE);
				if (null == cimrDoArr || cimrDoArr.length == 0) {
					sb.append("\r\n该病人未建立" + ruleArr[i].getMrtp_name() + "");
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 完成病案提交
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public AMrDO CompleteSubmitAmr(String id_ent) throws BizException{
		ICiamrRService amrQryService=ServiceFinder.find(ICiamrRService.class);
		ICiamrCudService amrSaveService=ServiceFinder.find(ICiamrCudService.class);
		AMrDO[] amrDoArr=amrQryService.find("a0.id_ent='"+id_ent+"'", "", FBoolean.FALSE);
		if (amrDoArr.length>0) {
			AMrDO amrDo=amrDoArr[0];
			amrDo.setFg_complete(FBoolean.TRUE);
			Boolean deptQc=CiMrParamUtils.GetSysParamDeptQc(Context.get().getDeptId());
			Boolean terminalQc=CiMrParamUtils.GetSysParamTerminalQc(Context.get().getDeptId());
			if(!deptQc && terminalQc){//不启用科室 启用终末  状态到 终末那里
				amrDo.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_COMDEPTSCORE);
				amrDo.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_COMDEPTSCORE);
				amrDo.setStatus(DOStatus.UPDATED);
				AMrDO[] updateDoArr=amrSaveService.save(new AMrDO[]{amrDo});
				if (updateDoArr.length>0) {
					return updateDoArr[0];
				} else {
					return null;
				}
			}else if(!deptQc && !terminalQc){//不科室 不终末 直接到病案
				amrDo.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_COMTERMINALSCORE);
				amrDo.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_COMTERMINALSCORE);
				amrDo.setStatus(DOStatus.UPDATED);
				AMrDO[] updateDoArr=amrSaveService.save(new AMrDO[]{amrDo});
				if (updateDoArr.length>0) {
					return updateDoArr[0];
				} else {
					return null;
				}
			}else{
				amrDo.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_COMWRITE);
				amrDo.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_COMWRITE);
				amrDo.setStatus(DOStatus.UPDATED);
				AMrDO[] updateDoArr=amrSaveService.save(new AMrDO[]{amrDo});
				if (updateDoArr.length>0) {
					return updateDoArr[0];
				} else {
					return null;
				}
			}
			
		} else {
			return null;
		}
	}
	/**
	 * 能否撤回病案  只有 完成书写状态的才可以撤回
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FBoolean IsCanRecallAmr(String id_ent) throws BizException {
		ICiamrRService amrService =ServiceFinder.find(ICiamrRService.class);
		AMrDO[] amrDoArr=amrService.find("a0.id_ent='"+id_ent+"'", "", FBoolean.FALSE);
		if (amrDoArr.length>0) {
			if (amrDoArr[0].getSd_qa_doctor_part_sta().equals(ICiMrDictCodeConst.SD_MR_COMWRITE)) {
				return FBoolean.TRUE;
			} else {
				return FBoolean.FALSE;
			}
		} else {
			return FBoolean.FALSE;
		}
	}
	/**
	 * 判断是否提交过撤回病案申请
	 * @param id_ent
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public FBoolean IsHasApply(String id_ent,String id_pat) throws BizException {
		IAmrapplyRService applyService=ServiceFinder.find(IAmrapplyRService.class);
		AmrApplyDO[] spplyDoArr=applyService.find(" a0.id_ent ='" + id_ent + "' and a0.id_pat = '"+ id_pat +"' and a0.sd_apply_status <> '02'", "", FBoolean.FALSE);
		if (spplyDoArr.length>0) {
			return FBoolean.TRUE;
		} else {
			return FBoolean.FALSE;
		}
	}
}
