package iih.ei.std.s.v1.bp.mp.wribackskintestresult;

import iih.bd.bc.udi.pub.IMpNsDictCodeTypeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.i.ISkintestRService;
import iih.ei.std.d.v1.mp.wribackskintestresult.d.ReturnParamsDTO;
import iih.ei.std.d.v1.mp.wribackskintestresult.d.WribackSkintestResultDTO;
import iih.mp.nr.dto.internal.d.ExecuteTpEnum;
import iih.mp.nr.dto.internal.d.PlanDTO;
import iih.mp.nr.dto.skinexe.d.SkinExeDTO;
import iih.mp.nr.i.IMpNrMaintanceService;
import iih.mp.nr.i.IMporInternalService;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mporplan.i.IMporplanRService;
import iih.mp.pub.IMpFunCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;

public class UpdateSkintestResultBp {

	/**
	 * 程序入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public ReturnParamsDTO exec(WribackSkintestResultDTO param) throws BizException {
		ReturnParamsDTO data;
		//1.校验入参
		data = checkParam(param);
		if (1 == data.getCode())
			return data;
		
		//2.获取当前皮试结果ID
		String idSkinRes = getUdidoc(param);
	
		//3.获取医嘱计划ID
		String idorpr = getIdorpr(param);
		
		//4.获取皮试ID
		String idskintest = getIdskintest(param);
		//4.更新皮试结果
		data = updateSkinTest(param,idorpr,idSkinRes,idskintest);
		if (2 == data.getCode()) 
			return data;
		
		//5.状态更新
		data = updateOrpltpByPlan(param, idorpr);

		return data;
	}

	/**
	 * 校验入参
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private ReturnParamsDTO checkParam(WribackSkintestResultDTO param) throws BizException {
		ReturnParamsDTO returnParams = new ReturnParamsDTO();
		returnParams.setCode(0);
		StringBuffer errLog = new StringBuffer();
		if (param == null) {
			errLog.append("入参 ");
		}else {
			if (StringUtil.isEmptyWithTrim(param.getCode_or())) {
				errLog.append("医嘱 ");
			}
			/*if (StringUtil.isEmptyWithTrim(param.getPatient_id())) {
				errLog.append(" 患者 ");
			}
			if (StringUtil.isEmptyWithTrim(param.getId_ent())) {
				errLog.append(" 就诊 ");
			}*/
			if (StringUtil.isEmptyWithTrim(param.getSd_rst_skintest())) {
				errLog.append(" 皮试结果编码 ");
			}
			if (StringUtil.isEmptyWithTrim(param.getId_sign())) {
				errLog.append(" 录入人员 ");
			}
			if (param.getDt_create() == null) {
				errLog.append(" 录入时间 ");
			}else if (new FDateTime().before(param.getDt_create())) {
				errLog.append(" 录入时间不得大于当前时间 ");
			}
		}
		if (!StringUtil.isEmptyWithTrim(errLog.toString())) {
			errLog.append(" 、等数据存在问题..");
			returnParams.setCode(1);
			returnParams.setMsg(errLog.toString());
			return returnParams;
		}
		return returnParams;
	}

	/**
	 * 获取皮试结果ID
	 * 
	 * @param datas
	 * @return
	 * @throws BizException 
	 */
	private String getUdidoc(WribackSkintestResultDTO param) throws BizException {
		UdidoclistDO[] udidoclistDOs = ServiceFinder.find(IUdidoclistRService.class).findByAttrValString(UdidoclistDO.CODE, IMpNsDictCodeTypeConst.CI_SKIN_REL);
		if (udidoclistDOs == null) {
			return null;
		}
		UdidocDO[] udidocDOs = ServiceFinder.find(IUdidocRService.class).findByAttrValString(UdidocDO.ID_UDIDOCLIST, udidoclistDOs[0].getId_udidoclist());
		for (UdidocDO udidocDO : udidocDOs) {
			if (udidocDO.getCode().equals(param.getSd_rst_skintest())) {
				return udidocDO.getId_udidoc();
			}
		}
		return null;
	}
	
	/**
	 * 获取医嘱计划ID
	 * 
	 * @param datas
	 * @return
	 * @throws BizException 
	 */
	private String getIdorpr(WribackSkintestResultDTO param) throws BizException {
		CiorderAggDO[] dos = ServiceFinder.find(ICiorderRService.class).findByAttrValString(CiOrderDO.CODE_OR, param.getCode_or());
		if (dos != null) {
			MpOrPlanDO[] planDOs = ServiceFinder.find(IMporplanRService.class).findByAttrValString(MpOrPlanDO.ID_OR, dos[0].getParentDO().getId_or());
			return planDOs[0].getId_or_pr();
		}
		return null;
	}
	
	/**
	 * 获取皮试ID
	 * 
	 * @param datas
	 * @return
	 * @throws BizException 
	 */
	private String getIdskintest(WribackSkintestResultDTO param) throws BizException {
		CiorderAggDO[] dos = ServiceFinder.find(ICiorderRService.class).findByAttrValString(CiOrderDO.CODE_OR, param.getCode_or());
		if (dos != null) {
			CiSkinTestRstDO[] skinTestDo = ServiceFinder.find(ISkintestRService.class).findByAttrValString(CiSkinTestRstDO.ID_OR,dos[0].getParentDO().getId_or());
			return skinTestDo[0].getId_skintest();
		}
		return null;
	}
	
	/**
	 *  保存皮试结果
	 * 
	 * @param skinTestRstDO
	 * @param stDto
	 * @throws BizException
	 */
	private ReturnParamsDTO updateSkinTest(WribackSkintestResultDTO param,String idorpr,String idSkinRes,String idskintest) throws BizException {
		ReturnParamsDTO returnParams = new ReturnParamsDTO();
		returnParams.setCode(2);
		if (!StringUtil.isEmptyWithTrim(idorpr) && !StringUtil.isEmptyWithTrim(idSkinRes)) {
			returnParams.setCode(0);
			SkinExeDTO exeDTO = new SkinExeDTO();
			exeDTO.setId_or_pr(idorpr);
			exeDTO.setId_skin_res(idSkinRes);
			exeDTO.setSd_skin_res(param.getSd_rst_skintest());
			exeDTO.setId_emp_confirm(param.getId_sign());
			exeDTO.setDt_create(param.getDt_create());
			exeDTO.setId_skintest(idskintest);
			ServiceFinder.find(IMpNrMaintanceService.class).saveSkinConfirm(exeDTO);
			return returnParams;
		}else {
			returnParams.setMsg("皮试结果保存失败...");
		}
		return returnParams;
	}
	
	/**
	 * 状态更新
	 * 
	 * @param data
	 * @param id_rptlabs
	 * @return
	 * @throws BizException
	 */
	private ReturnParamsDTO updateOrpltpByPlan(WribackSkintestResultDTO param,String idorpr) throws BizException {
		ReturnParamsDTO returnParams = new ReturnParamsDTO();
		returnParams.setCode(2);
		if (!StringUtil.isEmptyWithTrim(idorpr)) {
			returnParams.setCode(0);
			PlanDTO dto = new PlanDTO();
			dto.setId_dep(Context.get().getDeptId());
			dto.setId_emp(param.getId_sign());
			dto.setDt_exe(param.getDt_create());
			dto.setId_or_pr(idorpr);
			dto.setEu_tp(ExecuteTpEnum.EXECUTE);
			ServiceFinder.find(IMporInternalService.class).updateOrpltpByPlan(new PlanDTO[]{dto},IMpFunCodeConst.FUN_CODE_ORDEXECCONFIRM, "");
			return returnParams;
		}else {
			returnParams.setMsg("医嘱执行计划ID为空...");
		}
		return returnParams;
	}
	
}
