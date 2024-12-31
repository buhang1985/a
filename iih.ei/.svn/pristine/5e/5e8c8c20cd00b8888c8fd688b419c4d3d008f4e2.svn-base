package iih.ei.std.cr_technology.v1.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IMpDictCodeConst;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgErrorDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParamBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBean;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.i.IMpDgMaintainService;
import iih.mp.dg.ipdgapp.d.IpDgApStatusEnum;
import iih.mp.dg.ipdgapp.d.IpDgDispStatusEnum;
import iih.mp.nr.mporplan.d.ExecuteStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;

public class PivasDispDrugChkBp {
	
	/**
	 * 发药前数据校验
	 * 
	 * @throws BizException
	 */
	public void exec(IpDgDtDTO[] ipDgDtDtoList) throws BizException {
		try {
			//收费校验，返回无效患者列表
			Map<String, String> cgErrorEntMap = this.checkCanBlcgAccount(ipDgDtDtoList);
			
			//库存、仓库物品关系校验
			this.checkStock(cgErrorEntMap, ipDgDtDtoList);
		} catch(Exception ex) {
			//抛出异常
			throw ex;
		}
	}
	
	/**
	 * 收费校验
	 * 
	 * @throws BizException
	 */
	private Map<String, String> checkCanBlcgAccount(IpDgDtDTO[] ipDgDtDtoList) throws BizException {
		IBlCgAccountService blcgAccountSrv = ServiceFinder.find(IBlCgAccountService.class);
		//返回无效患者列表
		Map<String, String> result = new HashMap<String, String>();
		//按患者就诊分组
		Map<String, List<IpDgDtDTO>> entMap = new HashMap<String, List<IpDgDtDTO>>();
		//组装收费校验入参数据
		List<BlCgAccountDTO> blcgAccDTOS = new ArrayList<BlCgAccountDTO>();
		for(IpDgDtDTO itemDTO : ipDgDtDtoList) {
			//按患者就诊分组
			if(entMap.containsKey(itemDTO.getId_ent())) {
				List<IpDgDtDTO> itemDTOList = entMap.get(itemDTO.getId_ent());
				itemDTOList.add(itemDTO);
			} else {
				List<IpDgDtDTO> itemDTOList = new ArrayList<IpDgDtDTO>();
				itemDTOList.add(itemDTO);
				entMap.put(itemDTO.getId_ent(), itemDTOList);
			}
			//请领明细数据是否有效
			if(!this.checkItemDTO(null, null, itemDTO, FBoolean.TRUE).booleanValue())
				continue;
			if(itemDTO.getQuan_ap() == null || itemDTO.getQuan_ap().compareTo(FDouble.ZERO_DBL) <= 0)
				continue;
			BlCgAccountDTO blcgAccDTO = new BlCgAccountDTO();
			blcgAccDTO.setId_ent(itemDTO.getId_ent());
			blcgAccDTO.setId_pat(itemDTO.getId_pat());
			blcgAccDTO.setId_or(itemDTO.getId_or());
			blcgAccDTO.setId_orsrv(itemDTO.getId_orsrv());
			blcgAccDTO.setId_srv(itemDTO.getId_srv());
			blcgAccDTO.setId_or_prsrv(itemDTO.getId_or_pr_srv());
			blcgAccDTO.setId_mm(itemDTO.getId_mm());
			blcgAccDTO.setFg_mm(FBoolean.TRUE);
			blcgAccDTO.setId_pkgu_cur(itemDTO.getId_pkgu_cur());
			blcgAccDTO.setQuan(itemDTO.getQuan_ap());
			blcgAccDTO.setPrice_std(itemDTO.getPrice().setScale(-4, BigDecimal.ROUND_HALF_UP));
			blcgAccDTO.setPrice_ratio(itemDTO.getPrice().setScale(-4, BigDecimal.ROUND_HALF_UP));
			blcgAccDTO.setRatio_pripat(FDouble.ONE_DBL);
			blcgAccDTO.setEu_direct(BookRtnDirectEnum.CHARGES);
			blcgAccDTOS.add(blcgAccDTO);
		}
		//组装收费校验入参数据
		BlCgAccountSetDTO accountSetDTO = new BlCgAccountSetDTO();
		accountSetDTO.setFg_price_cal(FBoolean.FALSE);// 计算服务价格
		accountSetDTO.setFg_postpaid(FBoolean.TRUE);// 是否支持后付费
		//收费前校验
		if(blcgAccDTOS == null || blcgAccDTOS.size() <= 0)
			return result;
		BlCgErrorDTO[] cgErrorDTOS = blcgAccountSrv.checkBeforeKeepAccountForIp(blcgAccDTOS.toArray(new BlCgAccountDTO[0]), accountSetDTO);
		if(cgErrorDTOS == null || cgErrorDTOS.length <= 0)
			return result;
		//收费异常信息设置
		Map<String, IpDgDtDTO> invalidMap = new HashMap<String, IpDgDtDTO>();
		for(BlCgErrorDTO cgErrorDTO : cgErrorDTOS) {
			List<IpDgDtDTO> itemDTOList = entMap.get(cgErrorDTO.getId_ent());
			for(IpDgDtDTO itemDTO : itemDTOList) {
				itemDTO.setEn_opap(IpDgApStatusEnum.INVALID);
				itemDTO.setEn_opde(IpDgDispStatusEnum.DEPREJECTED);
				String note = this.getNote(itemDTO.getNote(), cgErrorDTO.getError_msg());
				itemDTO.setNote(note);
				invalidMap.put(itemDTO.getId_dgipdt(), itemDTO);
			}
			result.put(cgErrorDTO.getId_ent(), cgErrorDTO.getId_ent());
		}
		
		//异常信息存储
		PivasDispDrugCommBp.saveIpdgItem(invalidMap, FBoolean.FALSE);
		
		return result;
	}
	
	/**
	 * 校验库存、仓库物品关系
	 * 
	 * @throws BizException
	 */
	private void checkStock(Map<String, String> cgErrorEntMap, IpDgDtDTO[] ipDgDtDtoList) throws BizException {
		//校验库存、仓库物品关系
		IMpDgMaintainService maintainSrv = ServiceFinder.find(IMpDgMaintainService.class);
		//排除记账异常数据
		List<IpDgDtDTO> dgdtDTOList = new ArrayList<IpDgDtDTO>();
		for(IpDgDtDTO itemDTO : ipDgDtDtoList) {
			if(cgErrorEntMap.containsKey(itemDTO.getId_ent()))
				continue;
			//请领明细数据是否有效
			if(!this.checkItemDTO(null, null, itemDTO, FBoolean.TRUE).booleanValue())
				continue;
			dgdtDTOList.add(itemDTO);
		}
		if(dgdtDTOList ==null || dgdtDTOList.size() <= 0)
			return;
		//校验库存、仓库物品关系
		maintainSrv.checkPivasStock(dgdtDTOList.toArray(new IpDgDtDTO[0]));
	}
	
	/**
	 * 请领明细数据是否有效
	 * 
	 * @throws BizException
	 */
	public FBoolean checkItemDTO(PivasDispDrugParamBean paramBean, List<PivasDispDrugRstBean> rstBeanList,
			IpDgDtDTO itemDTO, FBoolean fg_check) {
		//患者已出院
		if(itemDTO.getFg_ip() != null && !itemDTO.getFg_ip().booleanValue()) {
			if(!fg_check.booleanValue()) {
				String error = String.format("患者已出院。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				String note = this.getNote(itemDTO.getNote(), "患者已出院");
				itemDTO.setNote(note);
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
			}
			return FBoolean.FALSE;
		}
		//已发药
		if(!StringUtils.isBlank(itemDTO.getId_dgipde()) && 
				(IpDgDispStatusEnum.DISPENSED.equals(itemDTO.getEn_opde()) || 
						IpDgDispStatusEnum.DEPREJECTED.equals(itemDTO.getEn_opde()))) {
			if(!fg_check.booleanValue()) {
				String error = String.format("药房已确认。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				if(IpDgDispStatusEnum.DISPENSED.equals(itemDTO.getEn_opde())) {
					error = String.format("药房已确认，拒绝再次发药。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				}
				String note = this.getNote(itemDTO.getNote(), "药房已确认");
				itemDTO.setNote(note);
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
			}
			return FBoolean.FALSE;
		}
		//药单是否已发送
		if(IMpDictCodeConst.SD_DGAP_IP_NOT_SEND.equals(itemDTO.getSd_dgap())) {
			if(!fg_check.booleanValue()) {
				String error = String.format("药单未发送。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				String note = this.getNote(itemDTO.getNote(), "药单未发送");
				itemDTO.setNote(note);
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
			}
			return FBoolean.FALSE;
		}
		//执行计划是否有效
		if(ExecuteStatusEnum.NOEXECUTE.equals(itemDTO.getEu_su()) || 
				ExecuteStatusEnum.CANCEL.equals(itemDTO.getEu_su()) || 
				itemDTO.getFg_invalid().booleanValue()) {
			if(!fg_check.booleanValue()) {
				String error = String.format("执行计划已取消。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				String note = this.getNote(itemDTO.getNote(), "执行计划已取消");
				itemDTO.setNote(note);
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
			}
			return FBoolean.FALSE;
		}
		//数据已被删除
		if(itemDTO.getDs() == 1) {
			if(!fg_check.booleanValue()) {
				String error = String.format("请领明细已删除。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				String note = this.getNote(itemDTO.getNote(), "请领明细已删除");
				itemDTO.setNote(note);
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
			}
			return FBoolean.FALSE;
		}
		//护士拒摆
		if(IpDgApStatusEnum.NURREJECTED.equals(itemDTO.getEn_opap())) {
			if(!fg_check.booleanValue()) {
				String error = String.format("护士已拒摆。医嘱号：%s，计划执行时间：%s", paramBean.getOrderNo(), paramBean.getOrderSrvPlanTime());
				String note = this.getNote(itemDTO.getNote(), "护士已拒摆");
				itemDTO.setNote(note);
				rstBeanList.add(PivasDispDrugCommBp.initExcRstBean(paramBean, new BizException(error)));
			}
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
	
	/**
	 * 设置备注
	 * 
	 * @throws BizException
	 */
	private String getNote(String note, String noteSupp) {
		String result = StringUtils.isBlank(note) ? "" : note;
		if(result.indexOf(noteSupp) < 0) {
			result = result + "," + "校验" + ":" + noteSupp;
		}
		return result;
	}
}
