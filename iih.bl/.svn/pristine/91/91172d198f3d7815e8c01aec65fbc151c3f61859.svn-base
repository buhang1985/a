package iih.bl.cg.service.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.cg.event.OpAccEvent;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.bl.st.service.i.IBLStQueService;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.mp.dg.dto.d.OpPresQueSiteDTO;
import iih.mp.dg.i.IMpDgConst;
import iih.mp.dg.i.IMpDgOutService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 记账BP
 * 
 * @author yang.lu2018年3月30日
 * @version ly 2018/05/16 预付费处理根据传入的医嘱信息进行数据过滤
 *
 */
public class SetOrderAppendBillToCgBP {

	/**
	 * 生成记账数据（高端商保，预交金，科研项目）
	 * 
	 * @param id_ent就诊编号
	 * @param code_enttp就诊类型
	 * @param cgType记账类型
	 * @param id_emp操作人
	 * @param idOrs对应医嘱
	 * @param srcFunc
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] exec(String id_ent, String cgType, String id_emp, String[] idOrs,String srcFunc) throws BizException {
		// 1.根据id_ent提取未交费的医嘱
		IBLStQueService iBLStQueService = ServiceFinder
				.find(IBLStQueService.class);
		BlOrderAppendBillParamDTO[] appendBillParamDTO1 = iBLStQueService
				.getOrderSrvPrinceInfoByIdent(id_ent, new String[] { ICiDictCodeConst.SD_SU_BL_NONE });
		//List<String> id_orSrvList = new ArrayList<String>(); //没啥用
		xap.mw.log.logging.Logger.info("获取记账数据：【就诊编号" + id_ent + "】【记账数据："
				+ appendBillParamDTO1.length + "】");
		
		if (cgType.equals(CgTypeEnum.CG_PREPAY)){
			// 预交金记账
			if (ArrayUtil.isEmpty(appendBillParamDTO1)) {
				throw new BizException("没有需要记账的医嘱！");
			}
			
			List<BlOrderAppendBillParamDTO> newList = new ArrayList<BlOrderAppendBillParamDTO>();
			List<String> orList = new ArrayList<String>();
			if(!ArrayUtil.isEmpty(idOrs)){
				orList.addAll(Arrays.asList(idOrs));
			}
			
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
				
				//传入的医嘱id不为空时，进行数据过滤
				if(orList.size() > 0 && !orList.contains(dto.getId_or()))
					continue;
				
				dto.setId_emp_cg(id_emp);
				dto.setSupportAppendBill(FBoolean.FALSE); // 不支持后付费，必须有足够的预交金
				dto.setFg_pricinginsertcg(FBoolean.FALSE); // 不是划价产生的数据
				if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品调预留接口，重新计价
				{
					dto.setFg_reserveMaterials(FBoolean.TRUE);
					dto.setPrice(null);
					dto.setPri_ss(null);
					dto.setPrice_ratio(null);
				}
				//id_orSrvList.add(dto.getId_orsrv());
				newList.add(dto);
			}
			
			appendBillParamDTO1 = newList
					.toArray(new BlOrderAppendBillParamDTO[0]);
			
			if (ArrayUtil.isEmpty(appendBillParamDTO1)) {
				throw new BizException("没有需要记账的医嘱！");
			}

		} else if (cgType.equals(CgTypeEnum.CG_HPCG)){
			
			// 高端商保记账
			if (appendBillParamDTO1 == null || appendBillParamDTO1.length == 0) {
				return null;
			}
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
				dto.setId_emp_cg(id_emp);
				dto.setFg_pricinginsertcg(FBoolean.FALSE); // 不是划价产生的数据
				if (dto.getOutpBillDTO() != null) {
					dto.getOutpBillDTO().setFg_hpcg(FBoolean.TRUE);
				} else {
					BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
					outpBillDTO.setFg_hpcg(FBoolean.TRUE);
					dto.setOutpBillDTO(outpBillDTO);
				}
				if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品调预留接口，重新计价
				{
					dto.setFg_reserveMaterials(FBoolean.TRUE);
					dto.setPrice(null);
					dto.setPri_ss(null);
					dto.setPrice_ratio(null);
				}
				//id_orSrvList.add(dto.getId_orsrv());
			}
		} else if (cgType.equals(CgTypeEnum.CG_RESEARCH) && idOrs != null){
			
			 // 科研项目记账
			if (appendBillParamDTO1 == null || appendBillParamDTO1.length == 0) {
				return null;
			}

			List<BlOrderAppendBillParamDTO> newList = new ArrayList<BlOrderAppendBillParamDTO>();
			Map<String, String> orMap = new HashMap<>();
			for (String idor : idOrs) {
				orMap.put(idor, idor);
			}
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
				if (StringUtil.isEmpty(orMap.get(dto.getId_or()))) {
					continue;
				}
				dto.setId_emp_cg(id_emp);
				dto.setFg_pricinginsertcg(FBoolean.FALSE); // 不是划价产生的数据
				if (dto.getOutpBillDTO() == null) {
					BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
					dto.setOutpBillDTO(outpBillDTO);
				}
				dto.getOutpBillDTO().setFg_research(FBoolean.TRUE);
				dto.getOutpBillDTO().setFg_acc(FBoolean.FALSE);
				dto.getOutpBillDTO().setFg_hpcg(FBoolean.FALSE);

				if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品调预留接口，重新计价
				{
					dto.setFg_reserveMaterials(FBoolean.TRUE);
					dto.setPrice(null);
					dto.setPri_ss(null);
					dto.setPrice_ratio(null);
				}
				newList.add(dto);
				//id_orSrvList.add(dto.getId_orsrv());
			}
			if (ListUtil.isEmpty(newList)) {
				return null;
			}
			appendBillParamDTO1 = newList
					.toArray(new BlOrderAppendBillParamDTO[newList.size()]);
		}
		
		for (BlOrderAppendBillParamDTO billParam : appendBillParamDTO1) {
			billParam.setSrcfunc_des(srcFunc);
		}

		appendBillParamDTO1 = SetOrderAppendBill_ByItms_ci_kljz_bp(
				appendBillParamDTO1, appendBillParamDTO1[0].getCode_enttp());

		return appendBillParamDTO1;
	}

	/**
	 * CI的开立记账调用，包括： 将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP）
	 * 冻结患者账户中相同金额的预交金 发送药品预留申请 发送收费消息到集成平台 更新医嘱状态 获取处方领药窗口号并回写到处方中（涉及药品和临床两个接口）
	 * 
	 * @param appendBillParamDTO1
	 *            待记账明细
	 * @param code_enttp
	 *            就诊类型
	 * @return
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_ci_kljz_bp(
			BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp)
			throws BizException {
		// 1.医嘱记账(含将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP），冻结患者账户中相同金额的预交金，发送药品预留申请）
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		BlOrderAppendBillParamDTO[] dtos = bp.SetOrderAppendBill(
				appendBillParamDTO1, code_enttp, false);
		// 2.获取处方领药窗口号
		IMpDgOutService mpDgoutService = ServiceFinder
				.find(IMpDgOutService.class);
		Map<String, String> presVsWindowInfo = new HashMap<String, String>(); // 《处方号，窗口号》
		List<String> id_orsrvLst = new ArrayList<String>();
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
			if (dto.getId_pres() != null
					&& dto.getSd_srvtp() != null
					&& dto.getSd_srvtp().startsWith(
							IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				if (!presVsWindowInfo.containsKey(dto.getId_pres())) {
					OpPresQueSiteDTO opPresQueSiteDTO = mpDgoutService
							.insertPresWindowData(dto.getId_pres(),
									IMpDgConst.ENTRY_AFTER_CHARGE);
					if (opPresQueSiteDTO != null) {

						presVsWindowInfo.put(dto.getId_pres(),
								opPresQueSiteDTO.getName_quesite());
					}
				}
			}
			if (!id_orsrvLst.contains(dto.getId_orsrv())) {
				id_orsrvLst.add(dto.getId_orsrv());
			}
		}
		// 3.领域窗口号回写到处方中
		ICiOrdMaintainService iCiOrdMaintainService = ServiceFinder
				.find(ICiOrdMaintainService.class);
		iCiOrdMaintainService.setPresWindowNo(presVsWindowInfo);

		// 4.发送收费信息到集成平台
		invokeOpAccEvent(dtos);
		return dtos;
	}

	/**
	 * 出发发送门诊高端商保，预交金记账数据
	 * 
	 * @throws BizException
	 */
	private void invokeOpAccEvent(BlOrderAppendBillParamDTO[] dtos)
			throws BizException {
		if (dtos == null || dtos.length == 0)
			return;
		List<OpAcc4EsDTO> opaccDtos = new ArrayList<OpAcc4EsDTO>();
		for (BlOrderAppendBillParamDTO orderDto : dtos) {
			OpAcc4EsDTO opaccDto = new OpAcc4EsDTO();
			opaccDto.setCode_apply(orderDto.getCode_apply());
			opaccDto.setCode_applytp(orderDto.getCode_applytp());
			opaccDto.setFg_acc(orderDto.getOutpBillDTO().getFg_acc());
			opaccDto.setFg_free(orderDto.getFg_free());
			opaccDto.setFg_hpcg(orderDto.getOutpBillDTO().getFg_hpcg());
			opaccDto.setId_cgitmoep(orderDto.getOutpBillDTO().getId_cgitmoep());
			opaccDto.setId_cgoep(orderDto.getOutpBillDTO().getId_cgitmoep());
			opaccDto.setId_or(orderDto.getId_or());
			opaccDto.setId_orsrv(orderDto.getId_orsrv());
			opaccDto.setId_pres(orderDto.getId_pres());
			opaccDto.setId_ent(orderDto.getId_ent());
			// TODO 当前数据中 Fg_additm 是在付款是补费才能为Y 所以当前判断不出来是否补费 ，此消息仅发送高端商保 与
			// 预交金记账数据，暂不支持补费发送数据
			// opaccDto.setFg_additm(orderDto.getFg_additm());
			opaccDtos.add(opaccDto);
		}

		OpAccEvent opAccEvent = new OpAccEvent();
		opAccEvent.invoke(opaccDtos.toArray(new OpAcc4EsDTO[opaccDtos.size()]));
	}
}
