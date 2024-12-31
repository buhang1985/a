package iih.ei.std.cr_technology.v1.s.bp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import iih.bd.bc.udi.pub.IMpDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.webservice.WsResultMsgCode;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParaItemBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParamBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBean;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.i.IMpDgMaintainService;
import iih.mp.dg.ipdgapp.d.IpDgApStatusEnum;
import iih.mp.dg.ipdgapp.d.IpDgApdeItmDO;
import iih.mp.dg.ipdgapp.d.IpDgDispStatusEnum;
import iih.mp.dg.ipdgapp.i.IIpdgapdeCudService;
import iih.mp.dg.ipdgapp.i.IIpdgapdeRService;
import iih.mp.nr.mpcharge.IMpChargeService;
import iih.mp.nr.mpcharge.d.MpChargeDTO;
import iih.mp.nr.mpcharge.d.MpChargeSetDTO;
import iih.mp.nr.mporplan.d.ExecuteStatusEnum;
import iih.mp.nr.mpsrvplan.d.EnumPlanChargeSrc;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class PivasDispDrugSplitBp {
	
	private List<IpDgDtDTO> dgdtList = null;
	
	/**
	 * 发药
	 * 
	 * @throws BizException
	 */
	public PivasDispDrugRstBean exec(PivasDispDrugParamBean paramBean, Map<String, List<IpDgDtDTO>> ipdgItemMap) throws BizException {
		
		//获取明细数据
		this.dgdtList = this.getDgdtDtoList(paramBean, ipdgItemMap);
		
		try {
			//校验数据
			this.dgdtList = this.validaPara(paramBean, ipdgItemMap);
			
			//发药
			this.dispDrug(this.dgdtList);
			
			//收取静配费
			this.costStaticAlloc(paramBean, this.dgdtList);
		} catch(Exception ex) {
			
			//更新执行计划发药失败原因
			throw ex;
		}
		
		//返回结果
		return this.iniRstBean(paramBean);
	}

	public void recordFailNote(final Exception ex) throws BizException {
		
		if(this.dgdtList == null || this.dgdtList.size() <= 0)
			return;
		
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus arg0) {
				try {
					//更新摆药失败原因
					IIpdgapdeRService apdeRService = ServiceFinder.find(IIpdgapdeRService.class);
					IIpdgapdeCudService apdeCudService = ServiceFinder.find(IIpdgapdeCudService.class);
					String note = ex.getMessage();
					if(note.indexOf("医嘱号") > 0)
						note = note.substring(0, note.indexOf("医嘱号"));
					List<String> ids = new ArrayList<String>();
					for(IpDgDtDTO dtDTO : dgdtList) {
						ids.add(dtDTO.getId_dgipdt());
					}
					IpDgApdeItmDO[] result = apdeRService.findByIds(ids.toArray(new String[0]), FBoolean.TRUE);
					if(result == null || result.length <= 0)
						return null;
					for(IpDgApdeItmDO itemDO : result) {
						itemDO.setStatus(DOStatus.UPDATED);
						note = StringUtils.isBlank(itemDO.getNote()) ? note : itemDO.getNote() + "," + note;
						itemDO.setNote(note);
					}
					apdeCudService.update(result);
				} catch (Exception e) {
				}
				return null;
			}
		});
	}

	private List<IpDgDtDTO> getDgdtDtoList(PivasDispDrugParamBean paramBean, Map<String, List<IpDgDtDTO>> ipdgItemMap) throws BizException {
		//执行计划点主键
		LinkedHashMap<String, String> idsMap = this.getIdsMap(paramBean);
		String[] ids = idsMap.keySet().toArray(new String[0]);
		String idStr = StringUtil.getDefaultPiecesTogether(ids);
		if(ipdgItemMap == null || ipdgItemMap.size() <= 0) {
			String error = String.format("医嘱号与医嘱下服务执行计划主键不匹配。医嘱号：%s，主键：%s", paramBean.getOrderNo(), idStr);
			throw new BizException(error);
		}
		List<IpDgDtDTO> dgdtList = ipdgItemMap.get(paramBean.getOrderSrvPlanTime());
		//是否检索到发药明细
		if(dgdtList == null || dgdtList.size() <= 0) {
			String error = String.format("根据医嘱服务执行计划主键未查询到请领明细。医嘱号：%s，主键：%s", paramBean.getOrderNo(), idStr);
			throw new BizException(error);
		}
		//发药明细是否与传入的执行计划点主键匹配
		LinkedHashMap<String, String> dtIdsMap = this.getDtIdsMap(dgdtList);
		for(String id_item : idsMap.keySet()) {
			if(!dtIdsMap.containsKey(id_item)) {
				String error = String.format("根据医嘱服务执行计划主键未查询到请领明细。医嘱号：%s，主键：%s", paramBean.getOrderNo(), id_item);
				throw new BizException(error);
			}
		}
		
		return dgdtList;
	}

	/**
	 * 数据校验
	 * 
	 * @throws BizException
	 */
	private List<IpDgDtDTO> validaPara(PivasDispDrugParamBean paramBean, Map<String, List<IpDgDtDTO>> ipdgItemMap) throws BizException {
		List<IpDgDtDTO> dgdtList = ipdgItemMap.get(paramBean.getOrderSrvPlanTime());
		//执行计划点主键
		LinkedHashMap<String, String> idsMap = this.getIdsMap(paramBean);
		String[] ids = idsMap.keySet().toArray(new String[0]);
		String idStr = StringUtil.getDefaultPiecesTogether(ids);
		//执行计划是否有效
		//1.取消发送 
		if(IMpDictCodeConst.SD_DGAP_IP_NOT_SEND.equals(dgdtList.get(0).getSd_dgap())) {
			String error = String.format("药单未发送，拒绝发药。医嘱号：%s，主键：%s", paramBean.getOrderNo(), idStr);
			throw new BizException(error);
		}
		for(IpDgDtDTO dgdtDTO : dgdtList) {
			//0.患者已出院
			if(dgdtDTO.getFg_ip() != null && !dgdtDTO.getFg_ip().booleanValue()) {
				String error = String.format("患者已出院，拒绝发药。医嘱号：%s，主键：%s", paramBean.getOrderNo(), idStr);
				throw new BizException(error);
			}
			//1.药房已发药、拒摆
			if((IpDgDispStatusEnum.DISPENSED.equals(dgdtDTO.getEn_opde()) || 
					IpDgDispStatusEnum.DEPREJECTED.equals(dgdtDTO.getEn_opde())) &&
					!StringUtils.isBlank(dgdtDTO.getId_dgipde())) {
				String dispName = IpDgDispStatusEnum.DISPENSED.equals(dgdtDTO.getEn_opde()) ? "发药" : "拒摆";
				String error = String.format("药房已%s，拒绝再次发药。医嘱号：%s，主键：%s", dispName, paramBean.getOrderNo(), idStr);
				throw new BizException(error);
			}
			//2.执行计划是否有效
			if(ExecuteStatusEnum.NOEXECUTE.equals(dgdtDTO.getEu_su()) || 
					ExecuteStatusEnum.CANCEL.equals(dgdtDTO.getEu_su())) {
				String error = String.format("执行计划已取消，拒绝发药。医嘱号：%s，主键：%s", paramBean.getOrderNo(), idStr);
				throw new BizException(error);
			}
			//3.数据已被删除
			if(dgdtDTO.getDs() == 1) {
				String error = String.format("执行计划已删除，拒绝发药。医嘱号：%s，主键：%s", paramBean.getOrderNo(), idStr);
				throw new BizException(error);
			}
			//4.护士拒摆 
			if(IpDgApStatusEnum.NURREJECTED.equals(dgdtDTO.getEn_opap())) {
				String error = String.format("护士已拒摆，拒绝发药。医嘱号：%s，主键：%s", paramBean.getOrderNo(), idStr);
				throw new BizException(error);
			}
			//校验通过设置发药状态
			dgdtDTO.setEn_opde(IpDgDispStatusEnum.DISPENSED);
		}
		
		return dgdtList;
	}

	/**
	 * 传入执行计划主键
	 * 
	 * @throws BizException
	 */
	private LinkedHashMap<String, String> getIdsMap(PivasDispDrugParamBean paramBean) {
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
		for(PivasDispDrugParaItemBean itemBean : paramBean.getOrderPrSrvID()) {
			result.put(itemBean.getItemID(), itemBean.getItemID());
		}
		
		return result;
	}
	
	/**
	 * 获取到的执行计划主键
	 * 
	 * @throws BizException
	 */
	private LinkedHashMap<String, String> getDtIdsMap(List<IpDgDtDTO> dgdtList) {
		LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
		for(IpDgDtDTO dgdtDTO : dgdtList) {
			result.put(dgdtDTO.getId_or_pr_srv(), dgdtDTO.getId_or_pr_srv());
		}
		return result;
	}
	
	/**
	 * 开始发药
	 * 
	 * @throws BizException
	 */
	private void dispDrug(List<IpDgDtDTO> dgdtList) throws BizException {
		IMpDgMaintainService iMpDgMaintainService = ServiceFinder.find(IMpDgMaintainService.class);
		iMpDgMaintainService.putIpMedicineSend(dgdtList.toArray(new IpDgDtDTO[0]), "21", "47103015");
	}
	
	/**
	 * 收取静配费
	 * 
	 * @throws BizException
	 */
	private void costStaticAlloc(PivasDispDrugParamBean paramBean, List<IpDgDtDTO> dgdtList) throws BizException {
		if(StringUtils.isBlank(paramBean.getChargeCode()) || StringUtils.isBlank(paramBean.getQty())
				|| Integer.parseInt(paramBean.getQty()) == 0)
			return;
		
		//医疗服务获取
		IMedsrvMDORService medRSrv = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDOS = medRSrv.findByAttrValString(MedSrvDO.CODE, paramBean.getChargeCode());
		if(medSrvDOS == null || medSrvDOS.length <= 0) {
			String error = String.format("获取收费服务项目失败，拒绝发药。医嘱号：%s，主键：%s", paramBean.getOrderNo(), paramBean.getChargeCode());
			throw new BizException(error);
		}
		IpDgDtDTO dgdtDO = dgdtList.get(0);
		MpChargeDTO accountDTO = new MpChargeDTO();
		accountDTO.setId_ent(dgdtDO.getId_ent());
		accountDTO.setId_pat(dgdtDO.getId_pat());
		accountDTO.setId_srv(medSrvDOS[0].getId_srv());
		accountDTO.setQuan(new FDouble(paramBean.getQty()));
		accountDTO.setId_dep_mp(Context.get().getDeptId());
		accountDTO.setEu_direct(BookRtnDirectEnum.CHARGE);
		
		FBoolean canImplWhenPrepayIsNotEnough = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(), "MPDGIP0005");;

		MpChargeSetDTO accountSetDTO = new MpChargeSetDTO();
		accountSetDTO.setId_dep_cg(this.getDeptDO(paramBean.getDeptCode()));
		accountSetDTO.setId_emp_cg(this.getPsndocDO(paramBean.getOperCode()));
		accountSetDTO.setDt_cg(new FDateTime());
		accountSetDTO.setFg_price_cal(FBoolean.TRUE);// 计算服务价格
		accountSetDTO.setFg_singlepat(FBoolean.FALSE);// 单患者模式
		accountSetDTO.setFg_postpaid(canImplWhenPrepayIsNotEnough);
		accountSetDTO.setFg_exception(FBoolean.TRUE);
		accountSetDTO.setFg_addfee(FBoolean.FALSE);
		accountSetDTO.setEu_src(EnumPlanChargeSrc.PHARMACY);
		accountSetDTO.setSrcfunc_des(IBlCgFuncConst.FUNC_IPMP_MEDICINEDISPEND);
		IMpChargeService chargeSrv = ServiceFinder.find(IMpChargeService.class);
		chargeSrv.mpChargingByOrig(new MpChargeDTO[] { accountDTO } , accountSetDTO);
	}

	/**
	 * 获取收费科室
	 * 
	 * @throws BizException
	 */
	private String getDeptDO(String id_dep) throws BizException {
		if(StringUtils.isBlank(id_dep))
			return Context.get().getDeptId();
		IDeptRService deptSrv = ServiceFinder.find(IDeptRService.class);
		String whrStr = String.format("id_dep = '%s' or code = '%s'", id_dep, id_dep);
		DeptDO[] deptDO = deptSrv.find(whrStr, "", FBoolean.TRUE);
		if(deptDO == null || deptDO.length <= 0)
			return Context.get().getDeptId();
		return deptDO[0].getId_dep();
	}
	
	/**
	 * 获取收费人员
	 * 
	 * @throws BizException
	 */
	public String getPsndocDO(String operCode) throws BizException {
		if(StringUtils.isBlank(operCode))
			return Context.get().getStuffId();
		IPsndocMDORService docRSrv = ServiceFinder.find(IPsndocMDORService.class);
		String whrStr = String.format("id_psndoc = '%s' or code = '%s'", operCode, operCode);
		PsnDocDO[] psnDO = docRSrv.find(whrStr, "", FBoolean.TRUE);
		if(psnDO == null || psnDO.length <= 0)
			return Context.get().getStuffId();
		Context.get().setStuffId(psnDO[0].getId_psndoc());
		return psnDO[0].getId_psndoc();
	}
	
	/**
	 * 返回结果
	 * 
	 * @throws BizException
	 */
	private PivasDispDrugRstBean iniRstBean(PivasDispDrugParamBean paramBean) {
		PivasDispDrugRstBean rstBean = new PivasDispDrugRstBean();
		rstBean.setOrderNo(paramBean.getOrderNo());
		rstBean.setOrderSrvPlanTime(paramBean.getOrderSrvPlanTime());
		rstBean.setOrderPrSrvID(paramBean.getOrderPrSrvID());
		rstBean.setResultCode(WsResultMsgCode.SUCCESS);
		rstBean.setResultMsg("发药成功");
		
		return rstBean;
	}
}
