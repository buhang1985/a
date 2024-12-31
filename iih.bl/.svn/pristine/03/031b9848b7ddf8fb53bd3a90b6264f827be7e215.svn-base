package iih.bl.cg.oep.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeTypeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.BlBizUtil;
import iih.bl.params.BlParams;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.i.ICiOrdQryService;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 获取未记账的医嘱信息
 * 
 * @author wq.li
 *
 */
public class GetNoBookkeepingCiSrvBP {

	public BlOrderAppendBillParamDTO[] exec(String patId) throws BizException {
		
		Integer defaultDay = BlParams.BLPREPAY0019();
		//Integer defaultDay = 1;
		FDateTime endDateTime = AppUtils.getServerDateTime();
		FDateTime beginDateTime = DateTimeUtils.getDateTimeBefore(DateTimeUtils.getDayBeginTime(endDateTime), defaultDay);
		
		// 获取未记账的医嘱信息
		ICiOrdQryService service = (ICiOrdQryService) ServiceFinder.find(ICiOrdQryService.class);
		PrescriptionConstBaseDto prescriptionConstBaseDto = service.getPrescriptionConstBaseDto(patId, beginDateTime, endDateTime,
				IBdFcDictCodeConst.SD_CODE_ENTP_OP, Context.get().getOrgId());

		// 获取srvid集合
		FArrayList srvList = prescriptionConstBaseDto.getPrescriptionCostDto();
		if (srvList == null || srvList.size() == 0) {
			return null;
		}
		List<PrescriptionCostDto> preList = new ArrayList<PrescriptionCostDto>();
		preList.addAll(srvList);
		
		List<String> srvIdList = new ArrayList<String>();
		List<GetStockReqDTO> mmInDtoList=new ArrayList<GetStockReqDTO>();
		for (PrescriptionCostDto prescriptionCostDto : preList) {
			if(FBoolean.FALSE.equals(prescriptionCostDto.getFg_mm())){
				srvIdList.add(prescriptionCostDto.getId_srv());
			}else{
				//组装物品计价入参
				GetStockReqDTO inDto=new GetStockReqDTO();
				inDto.setId_mm(prescriptionCostDto.getId_mm());
				inDto.setReq_unit_id(prescriptionCostDto.getId_unit_cur());
				inDto.setId_dep(prescriptionCostDto.getId_dep_wh());
				mmInDtoList.add(inDto);
			}
			
		}
//
//		// 查询患者信息
//		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
//		PatDO patDo = patRService.findById(patId);
//
//		// 计算服务价格
//		IBdPriCalService pricalService = ServiceFinder.find(IBdPriCalService.class);
//		BdPriViewDTO[] priDto = pricalService.calSrvPrice(srvIdList.toArray(new String[0]),
//				new String[] { patDo.getId_patpritp() });
//		Map<String, BdPriViewDTO> priMap=new HashMap<String, BdPriViewDTO>();
//		if(!ArrayUtil.isEmpty(priDto)){
//			for (BdPriViewDTO bdPriViewDTO : priDto) {
//				priMap.put(bdPriViewDTO.getId_srv(), bdPriViewDTO);
//			}
//		}
		
		//计算物品价格
		
//		//组装物品价格map
//		Map<String, MaterialStockDTO> mmMap=new HashMap<String, MaterialStockDTO>();
//		if(!ListUtil.isEmpty(mmInDtoList)){
//			IMaterialStockService mmService = ServiceFinder.find(IMaterialStockService.class);
//			MaterialStockDTO[] materialStock = mmService.getMaterialStocks(mmInDtoList.toArray(new GetStockReqDTO[0]));
//			if(!ArrayUtil.isEmpty(materialStock)){
//				for (MaterialStockDTO materialStockDTO : materialStock) {
//					if(!mmMap.containsKey(materialStockDTO.getId_mm())){
//						mmMap.put(materialStockDTO.getId_mm(), materialStockDTO);
//					}
//				}
//			}
//		}
//		
		// 获取计量单位列表
		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典
		measMap = this.setMeasDocDOMap();

		// 组装返回值数据
		List<BlOrderAppendBillParamDTO> dtoList=new ArrayList<BlOrderAppendBillParamDTO>();
		for (PrescriptionCostDto costDto : preList) {
			BlOrderAppendBillParamDTO dto=setBillDetailDtoField(costDto, measMap);
			dtoList.add(dto);
		}
		
		//计算价格
		IBLCiOrderToBlCgService cgService=ServiceFinder.find(IBLCiOrderToBlCgService.class);
		BlOrderAppendBillParamDTO[] paramArr = cgService.computePrice(dtoList.toArray(new BlOrderAppendBillParamDTO[0]));
		return paramArr;
	}

	/**
	 * 将未记账医嘱信息转换为可展示DTO
	 * 
	 * @param srvDTO
	 * @param measMap
	 * @return
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO setBillDetailDtoField(PrescriptionCostDto srvDTO, Map<String, MeasDocDO> measMap)
			throws BizException {
		BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();

		ordShow.setFg_free(FBoolean.FALSE);// 默认不减免
		// 注释，为保证IIH窗口收费的显示与手机终端显示一致
		ordShow.setCode_apply(srvDTO.getPresno());
		ordShow.setCode_applytp(srvDTO.getPrntype());
		// 打印单类型名称
		ordShow.setName_applytp(BlBizUtil.getPrntTpName(srvDTO.getPrntype()));
		ordShow.setId_org(srvDTO.getId_org());
		ordShow.setId_org_mp(srvDTO.getId_org_mp());
		ordShow.setId_org_or(srvDTO.getId_org_srv());
		ordShow.setName_dep_or(srvDTO.getName_dep_srv());
		ordShow.setId_dep_mp(srvDTO.getId_dep_mp());
		ordShow.setName_dep_mp(srvDTO.getName_dep_mp());
		ordShow.setId_dep_wh(srvDTO.getId_dep_wh());
		ordShow.setEu_blmd(srvDTO.getEu_blmd());
		ordShow.setPri(srvDTO.getPri());
		ordShow.setPri_std(srvDTO.getPri_std());
		ordShow.setPri_ratio(srvDTO.getPri_ratio());
		ordShow.setIndicitemid(srvDTO.getIndicitemid());
		// 2017年6月22日19:46:39 不能默认预留为true ，导致第三方不能结算 提示物品预留问题
		if (srvDTO.getFg_mm().booleanValue()) {
			ordShow.setFg_reserveMaterials(FBoolean.TRUE);// 调用物品预留
		} else {
			ordShow.setFg_reserveMaterials(FBoolean.FALSE);// 不调用物品预留
		}
		ordShow.setId_dep_or(srvDTO.getId_dep_srv());
		ordShow.setId_emp_or(srvDTO.getId_emp_srv());
		ordShow.setName_emp_or(srvDTO.getName_emp_srv());
		ordShow.setId_ent(srvDTO.getId_en());
		ordShow.setId_enttp(srvDTO.getId_entp());
		ordShow.setId_grp(srvDTO.getId_grp());
		ordShow.setId_mm(srvDTO.getId_mm());
		ordShow.setId_pat(srvDTO.getId_pat());
		ordShow.setId_srv(srvDTO.getId_srv());
		ordShow.setId_srvca(srvDTO.getId_srvca());

		// 医保计划
		ordShow.setId_hp(srvDTO.getId_hp());
		// 服务项目医保类别
		ordShow.setId_hpsrvtp(srvDTO.getId_hpsrvtp());
		// 服务项目医保类别
		ordShow.setSd_hpsrvtp(srvDTO.getSd_hpsrvtp());
		ordShow.setId_hpkind(srvDTO.getId_hpkind());
		ordShow.setFg_hpspcl(srvDTO.getFg_specill());
		ordShow.setFg_extdispense(srvDTO.getFg_extdispense());
		ordShow.setEu_direct(1);
		ordShow.setSd_srvtp(srvDTO.getSd_srvtp());
		ordShow.setId_srvtp(srvDTO.getId_srvtp());
		ordShow.setCode_enttp(srvDTO.getCode_entp());
		// tcy:在医嘱领域：物品信息取数为ci_or_srv_mm.quan_cur;非物品为ci_or_srv.quan_total_med(原来取值是ci_or_srv.quan_medu）
		if (!srvDTO.getFg_mm().booleanValue()) {
			ordShow.setQuan(new FDouble(srvDTO.getQuan_med()));
		} else {
			ordShow.setQuan(srvDTO.getQuan_cur());
		}
		// TODO 当前如果为物品 规格字段没有数据，规格无数据 提交到医保会提示 规格为空 需要在后期优化时 揉到获取数据时
		if (!StringUtil.isEmpty(srvDTO.getId_mm())) {
			IMeterialMDORService mmservice = ServiceFinder.find(IMeterialMDORService.class);
			MeterialDO mm = mmservice.findById(srvDTO.getId_mm());
			if (mm != null) {
				ordShow.setSpec(mm.getSpec());
			}
		}

		ordShow.setQuan_base(srvDTO.getQuan_base());
		ordShow.setPgku_cur(srvDTO.getId_unit_cur());
		ordShow.setPgku_base(srvDTO.getId_unit_base());
		ordShow.setFactor(srvDTO.getFactor_cb());
		ordShow.setFg_Cgoep(FBoolean.FALSE);

		ordShow.setId_or(srvDTO.getId_or());
		ordShow.setName_or(srvDTO.getDes());
		ordShow.setId_orsrv(srvDTO.getId_orsrv());
		ordShow.setName_srv(srvDTO.getName_srv());
		ordShow.setName_mm(srvDTO.getName_mm());
		// tcy:医嘱日期
		ordShow.setDt_or(srvDTO.getDt_sign());
		ordShow.setFg_or(srvDTO.getFg_or());

		ordShow.setCode_enttp(srvDTO.getCode_entp());// new
		ordShow.setCode_srv(srvDTO.getCode_srv());// new
		if (srvDTO.getFg_mm().booleanValue()) {
			MeasDocDO measDoc = measMap.get(srvDTO.getId_unit_cur());// 获取在医嘱服务数据中单位的ID值
			if (measDoc != null) {
				ordShow.setSrvu(measDoc.getId_measdoc());
				ordShow.setSrvu_name(measDoc.getName());
			}
		} else {

			MeasDocDO measDocDO = measMap.get(srvDTO.getId_unit_med());
			if (measDocDO != null) {
				ordShow.setSrvu(measDocDO.getId_measdoc());// new 服务项目单位
				ordShow.setSrvu_name(measDocDO.getName());// new 服务项目单位
			}
		}
		ordShow.setId_pres(srvDTO.getId_pres());// new 处方
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费

		// 拼接处方名称信息
		if (srvDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			ordShow.setPresrption_name(srvDTO.getPrestp_name());
		} else {
			ordShow.setPresrption_name(srvDTO.getDes());
		}
		ordShow.setFg_hpspcl(srvDTO.getFg_specill());
		ordShow.setFg_extdispense(srvDTO.getFg_extdispense());
		if (ordShow.getFg_extdispense() != null && ordShow.getFg_extdispense().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[外配处方]");
			} else {
				ordShow.setPresrption_name("[外配处方]");
			}
		}
		if (ordShow.getFg_hpspcl() != null && ordShow.getFg_hpspcl().booleanValue()) {
			if (ordShow.getPresrption_name() != null) {
				ordShow.setPresrption_name(ordShow.getPresrption_name().toString() + "[特殊病]");
			} else {
				ordShow.setPresrption_name("[特殊病]");
			}
		}
		
//		if("1"==srvDTO.getEu_blmd()){
//			
//			ordShow.setRatio_pripat(FDouble.ONE_DBL);
//			ordShow.setPrice(srvDTO.getPri());
//			ordShow.setPrice_ratio(srvDTO.getPri());
//			
//			ordShow.setAmt_hp(FDouble.ZERO_DBL);// new 金额_医保计划
//			if(srvDTO.getPri()!=null && ordShow.getQuan()!=null){
//				ordShow.setAmt_std(srvDTO.getPri().multiply(ordShow.getQuan()));
//				ordShow.setAmt_ratio(srvDTO.getPri().multiply(ordShow.getQuan()));
//			}else{
//				ordShow.setAmt_std(FDouble.ZERO_DBL);
//				ordShow.setAmt_ratio(FDouble.ZERO_DBL);
//			}
//		}else{
//			if(FBoolean.FALSE.equals(srvDTO.getFg_mm())){
//				//服务
//				BdPriViewDTO priDto = priMap.get(srvDTO.getId_srv());
//				if(priDto!=null){
//					ordShow.setAmt_hp(FDouble.ZERO_DBL);// new 金额_医保计划
//					ordShow.setAmt_ratio(priDto.getPrice_ratio().multiply(ordShow.getQuan()));
//					ordShow.setAmt_std(priDto.getPrice_std().multiply(ordShow.getQuan()));
//					ordShow.setPrice(priDto.getPrice_std());
//					ordShow.setPrice_ratio(priDto.getPrice_ratio());
//				}
//			}else{
//				//物品
//				MaterialStockDTO mmDto=mmMap.get(srvDTO.getId_mm());
//				if(mmDto.getPrice_act()!=null){
//					ordShow.setAmt_hp(FDouble.ZERO_DBL);// new 金额_医保计划
//					ordShow.setAmt_ratio(mmDto.getPrice_act().multiply(ordShow.getQuan()));
//					ordShow.setAmt_std(mmDto.getPrice_act().multiply(ordShow.getQuan()));
//					ordShow.setPrice(mmDto.getPrice_act());
//					ordShow.setPrice_ratio(mmDto.getPrice_act());
//				}
//				
//			}
//		}
		
		
		
		ordShow.setCode_mm(srvDTO.getCode_mm());// new 物品编码
		ordShow.setId_mmtp(srvDTO.getId_mmtp());// new 物品类型
		ordShow.setSd_mmtp(srvDTO.getSd_mmtp());// new 物品类型编码
		ordShow.setFg_mm(srvDTO.getFg_mm());// new 物品标示
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费
		ordShow.setId_pripat(srvDTO.getId_pripat());// new 患者价格类型
		ordShow.setEu_orsrcmdtp(srvDTO.getEu_orsrcmdtp());// new 费用来源 提供零挂使用
		// 就诊来源
		ordShow.setEu_srctp(0);
		ordShow.setCi_sv(srvDTO.getCi_sv());
		ordShow.setFg_pricinginsertcg(FBoolean.TRUE); // 划价是插入cg表中的数据

		ordShow.setFg_selfPay(srvDTO.getFg_selfpay());// 是否自费
		// 医嘱的超量开单原因对照费用的医疗类别
		if (StringUtils.isNotEmpty(srvDTO.getSd_excessive_reason())) {
			this.getHpStTp(srvDTO.getSd_excessive_reason(), ordShow);
		}
		return ordShow;
	}

	/**
	 * 医嘱的超量开单原因对照费用的医疗类别
	 * 
	 * @param sd_hpsttp
	 * @param ordShow
	 */
	private void getHpStTp(String sd_hpsttp, BlOrderAppendBillParamDTO ordShow) {
		switch (sd_hpsttp) {
		case ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC:// 慢性病
			ordShow.setSd_hpsttp(IBlDictCodeTypeConst.SD_HPSTTP_CHRONIC);
			ordShow.setId_hpsttp(IBlDictCodeTypeConst.ID_HPSTTP_CHRONIC);
			break;
		case ICiDictCodeConst.SD_EXCESSIVE_REASON_EXCEPTIONAL:// 特殊病
			ordShow.setSd_hpsttp(IBlDictCodeTypeConst.SD_HPSTTP_SPECIAL);
			ordShow.setId_hpsttp(IBlDictCodeTypeConst.ID_HPSTTP_SPECIAL);
			break;
		default:
			ordShow.setSd_hpsttp(IBlDictCodeTypeConst.SD_HPSTTP_HP);
			ordShow.setId_hpsttp(IBlDictCodeTypeConst.ID_HPSTTP_HP);
			break;
		}

	}

	/**
	 * 获取计量单位列表
	 * 
	 * @throws BizException
	 */
	private Map<String, MeasDocDO> setMeasDocDOMap() throws BizException {

		Map<String, MeasDocDO> measMap = new HashMap<String, MeasDocDO>();// 计量单位字典

		// 查询：调用轻量级的服务
		String[] fields = { "Id_measdoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
		if (measDocDOList != null && measDocDOList.size() > 0) {
			for (MeasDocDO measDocDO : measDocDOList) {
				if (measMap.get(measDocDO.getId_measdoc()) == null) {
					measMap.put(measDocDO.getId_measdoc(), measDocDO);
				}
			}
		}
		return measMap;
	}

}
