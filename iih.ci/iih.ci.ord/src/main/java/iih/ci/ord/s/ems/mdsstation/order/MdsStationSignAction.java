package iih.ci.ord.s.ems.mdsstation.order;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.IOrFunCodeConst;
import iih.ci.ord.s.bp.CiApSugAgainSignValidateBP;
import iih.ci.ord.s.bp.CiOrdersSaveInvalidateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuValidateBP;
import iih.ci.ord.s.bp.order.sign.CiOrderSignStep1aBP;
import iih.ci.ord.s.bp.order.sign.tl.CiOrderSignBP;
import iih.ci.ord.s.bp.validate.OrMutexValidateBP;
import iih.ci.ord.s.bp.validate.PathgySampValidateBP;
import iih.ci.ord.s.bp.validate.skintest.OpSkinTestOrSignBP;
import iih.mp.nr.foreign.i.IForeignService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 医技医生站签署逻辑
 * @author zhangwq
 *
 */
public class MdsStationSignAction extends CiOrderSignBP{
	public ValidateRtnInfoDTO sign(String[] id_ors, CiEnContextDTO ciEnContextDTO, boolean fgUseEr,
			OrderOperateDTO arg) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		ValidateRtnInfoDTO rtnInfo = exec(id_ors, ciEnContextDTO, fgUseEr, arg);
		//签署成功
		if(rtnInfo != null &&rtnInfo.getPhaseno() !=null && 99==(rtnInfo.getPhaseno().intValue())){
			FMap2 rstMap = rtnInfo.getRtnvalue();
			if(rstMap != null && rstMap.containsKey("ciors")){
				FArrayList orderArrays = (FArrayList)rstMap.get("ciors");
				List<String> ids = new ArrayList<String>();
				List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
				for(Object obj : orderArrays){
					//执行科室等于当前开单科室，走一下医嘱确认，然后调用执行域接口
					if(((CiOrderDO)obj).getId_dep_mp().equals(Context.get().getDeptId())){
						ids.add(((CiOrderDO)obj).getId_or());
						orders.add((CiOrderDO)obj);
					}
				}
				//存在执行科室等于当前开单科室的医嘱时
				if(ids.size() > 0){
					// 护嘱确认
					MdsOrConfirmBP confirmBP = new MdsOrConfirmBP();
					String errorMsg = confirmBP.confirm(orders.toArray(new CiOrderDO[orders.size()]));
					if(!StringUtils.isNullOrEmpty(errorMsg)){
						throw new BizException (errorMsg); 
					}
					//调用执行域接口
					IForeignService mpService = ServiceFinder.find(IForeignService.class);
					mpService.techConfirm(ids.toArray(new String[0]), IOrFunCodeConst.FUN_CODE_MDSORDER);
				}
			}
		}
		return rtnInfo;
	}

	@Override
	public ValidateRtnInfoDTO exec(String[] id_ors, CiEnContextDTO ctx, boolean fgUseEr, OrderOperateDTO arg)
			throws BizException {

		ValidateRtnInfoDTO rstDTO = new ValidateRtnInfoDTO();

		// 有效性校验
		if (CiOrdUtils.isEmpty(id_ors)) {
			return null;
		}

		// 获得医嘱聚集数据集合
		CiorderAggDO[] aggors = CiOrdAppUtils.getOrAggQryService().findByIds(id_ors, FBoolean.FALSE);
		if (aggors == null || aggors.length == 0) {
			FMap2 scenedatum = new FMap2();
			scenedatum.put("checkResult", "医嘱信息已经发生变化，请刷新列表！");
			rstDTO.setScenedatum(scenedatum);
			return rstDTO;
		}
		CiOrderDO[] ciors = getCiOrderDOs(aggors);

		// *************************************************************//
		/**
		 * 0127291: 出院诊断判断 郑州骨伤科医院需求 liyuelong-2018-07-25
		 */
		checkDiagBeforeOutHos(ctx, ciors);
		// *************************************************************//
		// 医嘱保存校验 其内部逻辑待完善
		CiOrdersSaveInvalidateBP validate4save = new CiOrdersSaveInvalidateBP();
		validate4save.exec(aggors);

		// 用血医嘱可用血余量的校验
		UseBtOrNumMarginBuValidateBP usebt = new UseBtOrNumMarginBuValidateBP();
		String strRst_ub = usebt.exe(aggors);
		if (!CiOrdUtils.isEmpty(strRst_ub)) {
			FMap2 scenedatum = new FMap2();
			scenedatum.put("checkResult", strRst_ub);
			rstDTO.setScenedatum(scenedatum);
			return rstDTO;
		}

		// 病理标本项目非空检查
		PathgySampValidateBP pathgysamptestbp = new PathgySampValidateBP();
		String strRst_pathgy = pathgysamptestbp.exec(aggors);
		if (!CiOrdUtils.isEmpty(strRst_ub)) {
			FMap2 scenedatum = new FMap2();
			scenedatum.put("checkResult", strRst_pathgy);
			rstDTO.setScenedatum(scenedatum);
			return rstDTO;
		}

		if (!fgUseEr) {
			// 医嘱服务开立权限判断逻辑
			FMap2 orsrvrtchk = orSrvRtCtlChkHandle(aggors);
			if (orsrvrtchk != null && orsrvrtchk.size() > 0) {
				ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
				dto.setScenedatum(orsrvrtchk);
				return dto;
			}
		}

		if (ParamsetQryUtil.getParaString(ctx.getId_org(),
				ICiOrdCustomSysParamConst.LL_PARAM_IS_OPEN_SPECIAL_ANTIBACTERIAL_CONS) == "true") {
			// 特殊级抗生素（抗菌药）签署验证
			ValidateRtnInfoDTO specdto = verifySignSpecAntiDrugsInfo(ctx, ciors);// specAntiConsSignValidate(ciors);
			if (specdto != null && specdto.getScenedatum().get("validateMessage") != null) {
				return specdto;
			}
		}
		CiApSugAgainSignValidateBP sugValidateBp = new CiApSugAgainSignValidateBP();
		rstDTO = sugValidateBp.exec(ciors);
		// 存在错误信息,二次手术未审核通过
		if (rstDTO != null && rstDTO.getScenedatum().containsKey("ApOpAgainErrroInfo")) {
			return rstDTO;
		}
		if ("1".equals(CiOrdUtils.GetDefaultSkinModel(ctx.getId_org()))) {
			// 皮试逻辑保存校验
			OpSkinTestOrSignBP skintestbp = new OpSkinTestOrSignBP();
			FMap2 skinTestRstMap = skintestbp.exec(aggors, arg);
			FMap2 rstMap2 = new FMap2();
			if (skinTestRstMap != null && skinTestRstMap.containsKey("StopSignOrders")) {
				List<String> stopSignIdors = (List<String>) skinTestRstMap.get("StopSignOrders");
				List<CiorderAggDO> aggList = new ArrayList<CiorderAggDO>();
				List<CiOrderDO> orList = new ArrayList<CiOrderDO>();
				for (int i = aggors.length - 1; i >= 0; i--) {
					if (!stopSignIdors.contains(aggors[i].getParentDO().getId_or())) {
						aggList.add(aggors[i]);
						orList.add(aggors[i].getParentDO());
					}
				}
				if (aggList.size() == 0) {
					rstDTO = new ValidateRtnInfoDTO();
					// 返回前台
					rstMap2.put("Fail", FBoolean.FALSE);
					rstDTO.setRtnvalue(rstMap2);
					return rstDTO;
				}
				aggors = aggList.toArray(new CiorderAggDO[0]);
				ciors = orList.toArray(new CiOrderDO[0]);
			} else if (skinTestRstMap != null && skintestbp.isNeedToFront()) {
				rstDTO = new ValidateRtnInfoDTO();
				// 返回前台
				rstMap2.put("Fail", FBoolean.FALSE);
				rstMap2.put("Extention", skinTestRstMap);
				rstDTO.setRtnvalue(rstMap2);
				return rstDTO;
			}
		}

		// 进行互斥检查校验 仅对住院流程起作用
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		FArrayList fa = new FArrayList();
		fa.add(dt_cur);
		// 被排斥医嘱的停止时间应为全排医嘱的开立时间
		OrMutexValidateBP bp = new OrMutexValidateBP();
		ReactExtOrsAndStopOrsDO willstopors = bp.exec(aggors, fa);
		dt_cur = (FDateTime) fa.get(0);
		FArrayList checkPatInfoSrvs = new FArrayList();
		// 药品毒麻信息审核
		checkPatInfoSrvs = srvPoisInfoCheck(aggors);
		// 特殊病判断
		String specilInfo = judgeSpecillFlag(aggors, ctx);
		// 有要停止的医嘱时的处理逻辑setStopords
		if ((!CiOrdUtils.isEmpty(willstopors) && !CiOrdUtils.isEmpty(willstopors.getStopords()))
				|| checkPatInfoSrvs.size() > 0 || !CiOrdUtils.isEmpty(specilInfo)) {
			// 插入 用户干预点 //用户确认后继续
			ValidateRtnInfoDTO dto = new ValidateRtnInfoDTO();
			orReactStopOrPromptRtnHandle(dto, ciors, willstopors, dt_cur);
			if (checkPatInfoSrvs.size() > 0) {
				dto.getScenedatum().put("checkPatInfoSrvs", checkPatInfoSrvs);
			}
			if (!CiOrdUtils.isEmpty(specilInfo)) {
				dto.getScenedatum().put("specilDrugs", specilInfo + "是特殊病药品，未录入其对应特殊病的诊断，是否录入?");
			}
			return dto;
		}
		// 更新医嘱状态、被排斥医嘱停止、创建临床事件 门诊创建会话期间、门诊处方分方
		CiOrderSignStep1aBP bp1a = new CiOrderSignStep1aBP();
		return bp1a.exec(ciors, willstopors, dt_cur,ctx,arg);
	}
}
