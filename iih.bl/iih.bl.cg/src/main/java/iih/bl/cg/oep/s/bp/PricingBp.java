package iih.bl.cg.oep.s.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.PrecisionUtils;
import iih.bd.base.utils.SVCheckUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.bddepcg.d.BdDepCgDO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.patcadup.d.BdPatcaDupItmPriDO;
import iih.bd.pp.service.i.IBdInccaQueService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.IBlConst;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.service.i.IBLStQueService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.d.MaterialInfoDTO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.d.ReserveResultDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.overview.overview.d.PiPatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ArrayListHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 门诊收费划价操作
 * @author yangyang
 * @Date:2017-07-10
 * @version:重构
 */
public class PricingBp {
	
	private static final String LOCK_KEY = "pricing_lock_";
	
	/** 门诊收费划价业务
	 * @param billItmDtoLst 收费单据明细
	 * @param operatorInfoDTO 操作人员DTO
	 * @param isPrintInvoice 是否需要打印发票，根据业务情况来,该参数必须明确
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCgOepAggDTO exec(BlOrderAppendBillParamDTO[] billItmDtoArr, OperatorInfoDTO operatorInfoDTO, FBoolean isPrintInvoice) throws BizException
	{
		//1、对于数据完整性做一个验证，只针对一些基础字段
		ParamValidator.validateNotNull("isPrintInvoice", isPrintInvoice);
		validateBillData(billItmDtoArr,operatorInfoDTO);
		
		String lockKey = LOCK_KEY + billItmDtoArr[0].getId_pat();
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前患者正在划价，请刷新重试");
		}
		
		Set<String> orsrvIdSet = new HashSet<String>();
		for (BlOrderAppendBillParamDTO billDto : billItmDtoArr) {
			if(!StringUtil.isEmpty(billDto.getId_orsrv())){
				orsrvIdSet.add(billDto.getId_orsrv());
			}
		}
		//已划价校验
		this.unChargeEffeValidate(orsrvIdSet);
		
		//补充一些医嘱服务字段
		if(orsrvIdSet.size() > 0){
			this.addOrsrvField(orsrvIdSet.toArray(new String[0]), billItmDtoArr);
		}
		
		//TODO 补充一下预留标志 这个预留标志有问题，预留标志的两层含义1、一个是物品属性 2、流程定义，后续要明确
		for (BlOrderAppendBillParamDTO dto : billItmDtoArr) {
			// 判断当前预留字段为true的 如果是预交金和商保数据不再进行预留操作 提供计价方法
			if ((dto.getFg_reserveMaterials() != null && dto.getFg_reserveMaterials().booleanValue()
					&& dto.getOutpBillDTO() != null && dto.getOutpBillDTO().getFg_acc() != null
					&& !dto.getOutpBillDTO().getFg_acc().booleanValue() && dto.getOutpBillDTO().getFg_hpcg() != null && !dto
					.getOutpBillDTO().getFg_hpcg().booleanValue())) {
				dto.setFg_reserveMaterials(FBoolean.FALSE);
			}
			
			// 非医嘱标识不预留
			if (dto.getFg_reserveMaterials() != null
					&& dto.getFg_reserveMaterials().booleanValue()
					&& !FBoolean.TRUE.equals(dto.getFg_or())) {
				dto.setFg_reserveMaterials(FBoolean.FALSE);
			}
			
			if(!StringUtil.isEmpty(dto.getId_orsrv())){
				orsrvIdSet.add(dto.getId_orsrv());
			}
		}
		
		//2、开始计价，这里生成记账明细
		BlOrderAppendBillParamDTO[] billItmDtos=calculatePriceValue(billItmDtoArr);
		
		//TODO yangyang 以后看是否有优化可能，划价不再生成结算数据，甚至什么也不生成；但有一个问题是获取物品价格需要调用预留，为了保证事务性，以及数据幂等性还是需要持久化
		//3、生成记账数据和结算数据
		BlCgOepAggDTO cgOepAggDto=assemblyStOepInfo(billItmDtos, operatorInfoDTO);
		
		//TODO 4、这个后续必须优化掉，后续的在付款时，生成发票相关信息，发票实际和支付和结算关系最密切
		//assemblyIncOepInfo(cgOepAggDto,operatorInfoDTO);
		
		// ly 2018/05/17 发票保存
		BlcgoepAggDO[] blcgoepAggDOs = (BlcgoepAggDO[])cgOepAggDto.getBlcgoepAggDO().toArray(new BlcgoepAggDO[0]);
		
		/*
		FArrayList arr=new FArrayList();
		for(BlcgoepAggDO itm:blcgoepAggDOs){
		   arr.add(itm);
		}
		
		try {
			FileUtils.writeStringToFile(new File("d:/cg.txt"), arr.serializeJson(), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] incAggDos = incService.saveOpInvoice(blcgoepAggDOs);
		
		if(!ArrayUtil.isEmpty(incAggDos)){
			cgOepAggDto.setNeedIncCount(incAggDos.length);
		}
		
		return cgOepAggDto;
	}
	
	/** 验证数据合法性
	 * @param billItmDtoArr
	 * @throws BizException
	 */
	private void validateBillData(BlOrderAppendBillParamDTO[] billItmDtoArr,OperatorInfoDTO operatorInfoDTO) throws BizException
	{
		Map<String, FDateTime> svCheckMap = new HashMap<String, FDateTime>();
		for(BlOrderAppendBillParamDTO billItmDto:billItmDtoArr)
		{
			if(billItmDto.getId_dep_mp()==null)
				throw new BizException("执行科室不能为空！");
			if(billItmDto.getId_dep_or()==null)
				throw new BizException("申请科室不能为空！");
			if(billItmDto.getId_emp_cg()==null)
				throw new BizException("记账人员不能为空！");
//			if(billItmDto.getId_emp_or()==null)
//				throw new BizException("申请医生不能为空!");
			if(billItmDto.getId_org()==null)
				throw new BizException("记账组织不能为空！");
			
			if(!StringUtil.isEmpty(billItmDto.getId_or()) && billItmDto.getCi_sv() != null){
				svCheckMap.put(billItmDto.getId_or(), billItmDto.getCi_sv());
			}
		}
		if(operatorInfoDTO.getId_dep()==null)
			throw new BizException("记账人员所在部门ID不能为空！");
		if(operatorInfoDTO.getId_emp()==null)
			throw new BizException("记账操作人员ID不能为空！");
		if(operatorInfoDTO.getId_org()==null)
			throw new BizException("记账人员所在组织不能为空!");
		
		if(svCheckMap.size() > 0){
			Boolean check = SVCheckUtils.checkSv(svCheckMap, new CiOrderDO());
			if(!check){
				throw new BizException("当前医嘱数据已被他人修改，请重新调入");
			}
		}
		
		// 如果是急诊留观数据，根据参数判断是否进行了费用审核 by lim 2019-03-07
		String code_enttp = billItmDtoArr[0].getCode_enttp();
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_enttp)) {
			// 结算前判断是否需要通过医保审核
			FBoolean bAudi = BlParams.BLST0006();
			if (FBoolean.TRUE.equals(bAudi)) {
				String blst0001 = BlParams.BLST0001();

				String entId = "";
				String id_patica = "";
				for (BlOrderAppendBillParamDTO dto : billItmDtoArr) {
					if (!StringUtils.isEmpty(dto.getId_ent())) {
						entId = dto.getId_ent();
					}
					if (!StringUtils.isEmpty(dto.getId_patica())) {
						id_patica = dto.getId_patica();
					}
				}
				if (StringUtils.isEmpty(id_patica)) {
					throw new BizException("留观患者未获取到患者分类id");
				} else {
					if (!StringUtils.isEmpty(blst0001)) {
						String[] id_paticas = blst0001.split(",");
						if (!ArrayUtil.isEmpty(id_paticas)) {
							List<String> paticaList = Arrays.asList(id_paticas);
							if (paticaList.contains(id_patica)) {
								// 如果该患者分类在维护得参数中，才去校验有没有医保审核
								if (!StringUtils.isEmpty(entId)) {
									IBLStQueService ser = ServiceFinder.find(IBLStQueService.class);
									FBoolean bAudied = ser.HasETHpAudited(entId);
									if (FBoolean.FALSE.equals(bAudied)) {
										throw new BizException("留观费用还未进行医保审核");
									}
								}
							}
						}
					}
				}

			}
		}
	}
	
	/**
	 * 补充医嘱服务的一些属性
	 * @param orsrvIds
	 * @param billItmDtoArr
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void addOrsrvField(String[] orsrvIds, BlOrderAppendBillParamDTO[] billItmDtoArr) throws BizException{
		
		DAFacade daf = new DAFacade();
		List<OrdSrvDO> orsrvList = (List<OrdSrvDO>)daf.findByPKs(OrdSrvDO.class, orsrvIds);
		if(ListUtil.isEmpty(orsrvList))
			return;
		
		Map<String,OrdSrvDO> orsrvMap = (Map<String,OrdSrvDO>)MapUtils.convertListToMap(orsrvList, OrdSrvDO.ID_ORSRV);
		for (BlOrderAppendBillParamDTO itmDto : billItmDtoArr) {
			
			OrdSrvDO orsrvDO = orsrvMap.get(itmDto.getId_orsrv());
			if(orsrvDO != null){
				itmDto.setFg_or(orsrvDO.getFg_or());
			}
		}
	}
	
    /**
     * 费用计算
     * @param appendBillParamDTOs 待计费明细
     * @return
     * @throws BizException
     */
    private BlOrderAppendBillParamDTO[] calculatePriceValue(BlOrderAppendBillParamDTO[] appendBillParamDTOs) throws BizException{
        //药品服务，物品的价格是通过物品域提供的接口获得
        IMaterialBaseInfoService meterialInfoService=ServiceFinder.find(IMaterialBaseInfoService.class);
        /*(2017-03-09 yangyang 
        1、针对物品预留，如果是正常流程（没有预付费）需要门诊结算的时候调用物品预留
        2、如果是预付费，无论是医嘱开立时预付费还是执行时预付费，都不能再次调用物品预留
        3、如果是后付费的情况，则也不能在结算的时候再次调用物品预留*/
		IMaterialStockService mlService = ServiceFinder.find(IMaterialStockService.class);
		
		/*
		 * 针对物品价格的获取，如果物品需要预留（库存管理），则获取预留物品的价格，如过不需要预留（不通过库存管理），则获取物品的基本价格 
		 */
//		IPriCalService pcService = (IPriCalService)ServiceFinder.find(IPriCalService.class);
		//2018-01-11 新版计价服务
		IBdPriCalcService priCalcService=(IBdPriCalcService)ServiceFinder.find(IBdPriCalcService.class);
		//针对需要预留的物品，组装预留信息
		List<ReserveReqDTO> reserveDtoLst=new ArrayList<ReserveReqDTO>();
		List<String> strIdmmLst=new ArrayList<String>();
		for(BlOrderAppendBillParamDTO orderDto:appendBillParamDTOs)
		{
		    //这里以后的判断条件需要更加明确，直接定位到某个字段去区分是否走预留，如果走预交金，则当时已经预留了物品，并获取了物品价格
		    if(orderDto.getOutpBillDTO()!=null)
		        continue;
		    validateParam(orderDto);
		    //获取过价格的不再重新计算价格
		    if(orderDto.getPrice()==null)
		    {
		        if((orderDto.getFg_mm()!=null && orderDto.getFg_mm().booleanValue() && orderDto.getFg_reserveMaterials()!=null && orderDto.getFg_reserveMaterials().booleanValue()))
		        {
		            //校验物品属性
		            validateMmAttribute(orderDto);
	                ReserveReqDTO reserveDto=new ReserveReqDTO();
	                //组装数据获取物品预留
	                reserveDto.setId_mm(orderDto.getId_mm());
	                //仓库
	                reserveDto.setId_dep(orderDto.getId_dep_wh());
	                //请求数量
	                reserveDto.setReq_num(orderDto.getQuan());
	                //对应的出售单位
	                reserveDto.setReq_unit_id(orderDto.getPgku_cur());
	                //对应的医嘱服务
	                reserveDto.setId_orsrv(orderDto.getId_orsrv());
	                reserveDtoLst.add(reserveDto);
	                strIdmmLst.add(orderDto.getId_mm());
		        }
		        else if(orderDto.getFg_mm()!=null && orderDto.getFg_mm().booleanValue() && orderDto.getFg_reserveMaterials()!=null && !orderDto.getFg_reserveMaterials().booleanValue()){
		            //如果是物品但不走预留，则走物品的基本价格
	                //校验物品属性
                    validateMmAttribute(orderDto);
                    strIdmmLst.add(orderDto.getId_mm());
		        }
		    }
		}//for结束
		
		
		Map<String,ReserveResultDTO> reserveResultDtoMap=new HashMap<String,ReserveResultDTO>();
		Map<String,MaterialInfoDTO> materialMap=new HashMap<String,MaterialInfoDTO>();
		if(reserveDtoLst.size()>0)
		{
		    /*
		     * 这里需要注意，在物品预留时，同一个id_mm可能获取到不同批次的物品，价格也可能不一样,所以需要直接从物品域获取批次价格
		     */
		    ReserveResultDTO[] reserveResultDtoArr=mlService.reserveMaterials(mlService.TYPE_RESERVE, reserveDtoLst.toArray(new ReserveReqDTO[0]));
		    for(ReserveResultDTO reserveResultDto:reserveResultDtoArr)
		    {
		        if(!reserveResultDtoMap.containsKey(reserveResultDto.getId_orsrv()))
		        {
		            reserveResultDtoMap.put(reserveResultDto.getId_orsrv(), reserveResultDto);
		        }
		    }
		}
		if(!strIdmmLst.isEmpty()){
		    MaterialInfoDTO[] materialInfoDtoArr=meterialInfoService.getMaterialsByIds(strIdmmLst.toArray(new String[0]));
		    for(MaterialInfoDTO materialDto:materialInfoDtoArr)
		    {
		        if(!materialMap.containsKey(materialDto.getId_mm()))
		            materialMap.put(materialDto.getId_mm(),materialDto);
		    }
		}
		
		
		//处理医嘱开单时价格来计价逻辑
		String prtps = BlParams.BLSTOEP0016();
		Map<String, OrdSrvDO> orsrvMap = new HashMap<String, OrdSrvDO>();
		// 当前默认门诊采用当前价表来计价, 如果为 嘱开单时价格来计价时 需要获取对应的医嘱数据
		if (prtps == BlParamValueConst.BLSTOEP0016_WHENORDER) {
			List<String> idOrSrv = new ArrayList<String>();
			for (BlOrderAppendBillParamDTO billDto : appendBillParamDTOs) {
				idOrSrv.add(billDto.getId_orsrv());
			}
			// 组装服务MAP
			if (idOrSrv.size() != 0) {
				IOrdSrvDORService orService = ServiceFinder.find(IOrdSrvDORService.class);
				OrdSrvDO[] orsrvs = (OrdSrvDO[]) orService.findByIds(idOrSrv.toArray(new String[idOrSrv.size()]), FBoolean.FALSE);
				for (OrdSrvDO ordSrvDO : orsrvs) {
					orsrvMap.put(ordSrvDO.getId_orsrv(), ordSrvDO);
				}
			}
		}
		
		
		//对明细开始计价
		for(BlOrderAppendBillParamDTO billItemDto:appendBillParamDTOs)
		{
		    //预交金
		    if(billItemDto.getOutpBillDTO()!=null)
		    {
		        //对于已经记账的费用，当发生患者价格分类变更情况的，由门诊重划价处理
		        //注意：预付费的医嘱记录是已经更改了医嘱收费状态为已记账
		        continue;
		    }
		    
		    if(billItemDto.getFg_mm().booleanValue() && billItemDto.getFg_reserveMaterials()!=null && billItemDto.getFg_reserveMaterials().booleanValue())
		    {
		        //是物品，同时走库存管理，可以预留
		        ReserveResultDTO reserveResultDto=reserveResultDtoMap.get(billItemDto.getId_orsrv());
		        billItemDto.setPrice(PrecisionUtils.formatPrice(reserveResultDto.getPrice_act()));
		        //折扣价格
		        billItemDto.setPrice_ratio(billItemDto.getPrice());
		        billItemDto.setRatio_pripat(new FDouble(1.00));
		        billItemDto.setPri_ss(PrecisionUtils.formatPrice(reserveResultDto.getPrice_sale()));
		        billItemDto.setOnlycode(reserveResultDto.getOnlycode()); //唯一码
		        billItemDto.setCd_batch(reserveResultDto.getBatch()); //批次
		        billItemDto.setQuan_base(reserveResultDto.getQuan_base());//数量_基本包装=换算系数*数量
		        billItemDto.setQuan(reserveResultDto.getQuan_act());//出库数量
		        billItemDto.setCode_mm(reserveResultDto.getMm_code());//物品编码
		        billItemDto.setSd_abrd(reserveResultDto.getSd_abrd());
		        //因为预留DTO里没有存储物品的批准文号，以及规格,需要获取物品基本信息
		        MaterialInfoDTO materialDto=materialMap.get(billItemDto.getId_mm());
		        if(materialDto!=null)
		        {
		        	//药品批准文号
		            billItemDto.setApprno(materialDto.getApprno());
		            //药品规格
		            billItemDto.setSpec(materialDto.getSpec());
		            //物品类型
		            billItemDto.setSd_mmtp(materialDto.getSd_mmtp());
		        }
		        billItemDto.setAmt_ratio(PrecisionUtils.formatAmt(billItemDto.getPrice().multiply(billItemDto.getQuan())));
	            billItemDto.setAmt(PrecisionUtils.formatAmt(billItemDto.getPrice().multiply(billItemDto.getQuan())));
	            billItemDto.setAmt_std(PrecisionUtils.formatAmt(billItemDto.getPrice().multiply(billItemDto.getQuan())));
	            //北京医保不对明细做分解
	            billItemDto.setAmt_pat(new FDouble(0.00));
	            billItemDto.setAmt_hp(new FDouble(0.00));
		    }
		    else if(billItemDto.getFg_mm().booleanValue() && billItemDto.getFg_reserveMaterials()!=null && !billItemDto.getFg_reserveMaterials().booleanValue())
		    {		        
		        //是物品，但是不走库存管理，这里是走物品的基本价格,这里可以优化掉，物品提供的预留接口考虑了这种情况，当非预留的物品调用时，返回物品的固定价格
		    	//TODO yangyang 2017-07-10 为了更加兼容，这里暂不直接调用
		    	//通过物品Id_mm和当前包装单位获取当前价格
		    	IMaterialBaseInfoService InfoService= ServiceFinder.find(IMaterialBaseInfoService.class);
		        GetMaterialPriceDTO materialPriceDto =InfoService.MaterialPriceForOt(billItemDto.getId_mm(), billItemDto.getPgku_cur());
		        if(materialPriceDto.getFg_success().booleanValue()) //如果
		        {
		            MaterialInfoDTO materialDto=materialMap.get(billItemDto.getId_mm());
		            if(materialDto!=null)
		            {
		                billItemDto.setApprno(materialDto.getApprno());
		                billItemDto.setSpec(materialDto.getSpec());
		                billItemDto.setSd_abrd(materialDto.getSd_abrd());
		                billItemDto.setSd_mmtp(materialDto.getSd_mmtp());
		            }
		            //格式花金额
		            billItemDto.setPrice(PrecisionUtils.formatPrice(materialPriceDto.getPrice_act()));
		            billItemDto.setPrice_ratio(billItemDto.getPrice());
		            billItemDto.setRatio_pripat(new FDouble(1.00));
		            billItemDto.setQuan_base(materialPriceDto.getFactor().multiply(billItemDto.getQuan()));
		            billItemDto.setAmt(PrecisionUtils.formatAmt(billItemDto.getPrice().multiply(billItemDto.getQuan())));
		            billItemDto.setAmt_std(PrecisionUtils.formatAmt(billItemDto.getPrice().multiply(billItemDto.getQuan())));
		            billItemDto.setAmt_pat(new FDouble(0.00));
		            billItemDto.setAmt_hp(new FDouble(0.00));
		            billItemDto.setAmt_ratio(billItemDto.getAmt_std());		            
		        }
		    }
		    else
		    {
		        //普通诊疗项目，非物品
//		        SrvPricalRateAndPriceDTO srvPriceAndRateDto=pcService.CalSingleSrvPriceByIdPripat_NameTip(billItemDto.getId_srv(),billItemDto.getName_srv(),billItemDto.getId_pripat());
		    	PriceResultDTO priceResultDto=priCalcService.calcPatPrice(billItemDto.getId_srv(), billItemDto.getId_pripat());
		    	if(priceResultDto!=null && !StringUtil.isEmpty(priceResultDto.getError_msg()))
		    	{
		    		String strErrMsg=String.format("服务\"%s\"未获取到价格，计价故障，原因为:%s", billItemDto.getName_srv(),priceResultDto.getError_msg());
		    		throw new BizException(strErrMsg);
		    	}
		    	
		    	if("1".equals(billItemDto.getEu_blmd())){
		    		billItemDto.setRatio_pripat(FDouble.ONE_DBL);
			        billItemDto.setPrice(billItemDto.getPri());
			        billItemDto.setPrice_ratio(billItemDto.getPri());
		    	}else{
		    		
		    		// 医嘱开单时价格来计价

					// 价格比例与标准单价
					FDouble ratio = null;
					FDouble price_std = null;
					FDouble price_ratio = null;
					if (prtps == BlParamValueConst.BLSTOEP0016_WHENORDER && orsrvMap.get(billItemDto.getId_orsrv()) != null) {
						OrdSrvDO srvDO = orsrvMap.get(billItemDto.getId_orsrv());
						if (srvDO != null ) {
							ratio = srvDO.getPri_ratio();
							price_std = srvDO.getPri_std();
							price_ratio = srvDO.getPri();
						}
						
						//如果医嘱计价信息不完整，走新取的价格
						if (ratio == null || price_std == null||price_ratio==null) {

							ratio = priceResultDto.getRate();
							price_std = priceResultDto.getPrice_std();
							// 折扣价格=标准单价*比例 取4位小数
							price_ratio = priceResultDto.getPrice_ratio();
						}
					}else
					{
						ratio = priceResultDto.getRate();
						price_std = priceResultDto.getPrice_std();
						// 折扣价格=标准单价*比例 取4位小数
						price_ratio = priceResultDto.getPrice_ratio();
					}

		    		billItemDto.setRatio_pripat(ratio);
			        billItemDto.setPrice(price_std);
			        //当前患者价格分类，作用于价格
			        billItemDto.setPrice_ratio(price_ratio);
		    	}
		       
		        //格式化标准金额
		        billItemDto.setAmt_std(PrecisionUtils.formatAmt(billItemDto.getPrice().multiply(billItemDto.getQuan())));
		        //实际价格
		        billItemDto.setAmt_ratio(PrecisionUtils.formatAmt(billItemDto.getPrice_ratio().multiply(billItemDto.getQuan())));
		        //就为实收价格
		        billItemDto.setAmt(billItemDto.getAmt_ratio());
		        billItemDto.setAmt_hp(new FDouble(0.00));
		        billItemDto.setAmt_pat(new FDouble(0.00));		        
		    }
		   /* //账单项补充
            IncCaItmDO incCaitmDo=getInccaitmCodeAndName(billItemDto.getCode_enttp(), billItemDto.getId_srv());
            if(incCaitmDo!=null)
            {
                billItemDto.setCode_inccaitm(incCaitmDo.getCode());
                billItemDto.setName_inccaitm(incCaitmDo.getName());
            }*/
		}
		
		//组合计价重新计算折扣率  ly 2019/09/23
		Set<String> srvIdSet = new HashSet<String>();
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTOs) {
			
			if (dto.getOutpBillDTO() != null)
				continue;
			
			if(FBoolean.TRUE.equals(dto.getFg_mm()))
				continue;
				
			if(!StringUtil.isEmpty(dto.getId_srv_or())){
				srvIdSet.add(dto.getId_srv_or());
			}
		}
		if(srvIdSet.size() > 0){
			//获取特殊比例组合计价子数据
			IBdPpQryService ppService = ServiceFinder.find(IBdPpQryService.class);
			BdPriSrvCompRatioDTO[] compDtos = ppService.getSpecialSrvCompRatio(srvIdSet.toArray(new String[0]));
			if(!ArrayUtil.isEmpty(compDtos)){
				for (BdPriSrvCompRatioDTO compDto : compDtos) {
					for (BlOrderAppendBillParamDTO cgDto : appendBillParamDTOs) {
						
						if (cgDto.getOutpBillDTO() != null)
							continue;
						
						if(FBoolean.TRUE.equals(cgDto.getFg_mm()))
							continue;
						
						if (!StringUtil.isEmpty(cgDto.getId_orsrv()) && prtps == BlParamValueConst.BLSTOEP0016_WHENORDER)
							continue;
						
						if(compDto.getId_srv().equals(cgDto.getId_srv_or()) && 
								compDto.getId_srv_bl().equals(cgDto.getId_srv())){
							//重新计算折扣价
							cgDto.setPrice_ratio(cgDto.getPrice_ratio().multiply(compDto.getRatio(),IBlConst.PRECISION_PRICE));
							cgDto.setRatio_pripat(cgDto.getRatio_pripat().multiply(compDto.getRatio()));
							cgDto.setAmt_ratio(cgDto.getPrice_ratio().multiply(cgDto.getQuan(),IBlConst.PRECISION_AMOUNT));
							cgDto.setAmt_pat(cgDto.getAmt_ratio());
							cgDto.setAmt(cgDto.getAmt_ratio());
							break;
						}
					}
				}
			}
		}
		
        return appendBillParamDTOs;
    }

    /** 校验参数
     * @param billItmDto 计费明细
     * @throws BizException 异常信息
     */
    private void validateParam(BlOrderAppendBillParamDTO billItmDto) throws BizException
    {
        if(billItmDto.getFg_mm()==null)
        {
            throw new BizException("没有设置物品标识:\r\n,服务名称："+billItmDto.getName_srv());
        }
        if(billItmDto.getId_pripat()==null)
        {
            throw new BizException("没有设置价格分类:\r\n,服务名称："+billItmDto.getName_srv());
        }
    }

    /**
     * 对属于物品的收费明细，校验一下物品属性
     * @param billItmDto
     * @throws BizException
     */
    private void validateMmAttribute(BlOrderAppendBillParamDTO billItmDto)
            throws BizException {
        if(billItmDto.getId_mm()==null)
        {
            throw new BizException("没有物品ID。\r\n名称："+billItmDto.getName_srv()+" 服务ID:"+billItmDto.getId_srv());
        }
        if(billItmDto.getId_dep_mp()==null)
        {
            throw new BizException("没有物品执行科室ID。\r\n服务名称："+billItmDto.getName_srv()+" 服务ID:"+billItmDto.getId_srv());
        }
        if(billItmDto.getQuan()==null)
        {
            throw new BizException("没有物品数量。\r\n服务名称："+billItmDto.getName_srv()+" 服务ID:"+billItmDto.getId_srv());
        }
        if(billItmDto.getPgku_cur()==null)
        {
            throw new BizException("没有物品单位。\r\n服务名称："+billItmDto.getName_srv()+" 服务ID:"+billItmDto.getId_srv());
        }
//        if(billItmDto.getId_dep_wh()==null)
//        {
//            throw new BizException("没有库房信息：\r\n服务名称："+billItmDto.getName_srv()+" 服务ID:"+billItmDto.getId_srv());    
//        }

    }

    /**
     * 根据就诊类型和ID_srv，查询对应的账单项
     * @param code_enttp 就诊类型代码
     * @param id_srv 服务ID
     * @return 对应的账单项
     * @throws BizException
     */
    public IncCaItmDO getInccaitmCodeAndName(String code_enttp,String id_srv) throws  BizException
    {
        IBdInccaQueService iBdInccaQueService=ServiceFinder.find(IBdInccaQueService.class);
        return iBdInccaQueService.getInccaitmCodeAndName(code_enttp, id_srv);
    }

    /**
     * 组装记账数据、结算数据，并持久化到数据库
     * @param appendBillParamDTOs
     * @param operatorInfoDTO
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	private BlCgOepAggDTO assemblyStOepInfo(BlOrderAppendBillParamDTO[] appendBillParamDTOs,OperatorInfoDTO operatorInfoDTO) throws BizException
    {
        FArrayList arrayList=new FArrayList();
        List<BlCgItmOepDO> cgItmOepDoPricingLst=new ArrayList<BlCgItmOepDO>();
        FDouble amtFd=new FDouble(0.00);
        FDouble amtRatioFd=new FDouble(0.00);
        FDouble amtStdFd=new FDouble(0.00);
        List<String> strIdCgOepLst=new ArrayList<String>();
        //就诊流水号集合
        List<String> strEntLst=new ArrayList<String>();
        //1、数据分拣，把预付费数据和医嘱收费数据分拣开，对于记账的数据，需要做更新操作
        
        setBdPatcaDupItmAmtPrice(appendBillParamDTOs, strEntLst ,appendBillParamDTOs[0].getId_pat());
        
        for(BlOrderAppendBillParamDTO billDto:appendBillParamDTOs)
        {
        	if(!strEntLst.contains(billDto.getId_ent()) && !StringUtil.isEmpty(billDto.getId_ent()))
        	{
        		strEntLst.add(billDto.getId_ent());
        	}
            if(billDto.getOutpBillDTO()!=null && billDto.getOutpBillDTO().getId_cgoep()!=null)
            {
                //如果是预交金付费,这里是有记账明细主键的
                strIdCgOepLst.add(billDto.getOutpBillDTO().getId_cgoep());
                amtFd=amtFd.add(billDto.getAmt());
                amtRatioFd=amtRatioFd.add(billDto.getAmt_ratio());
                amtStdFd=amtStdFd.add(billDto.getAmt_std());
                continue;
            }
            else
            {
                BlCgItmOepDO cgItmOep=mapperDoToDto(billDto,operatorInfoDTO);
                cgItmOepDoPricingLst.add(cgItmOep);
                amtFd=amtFd.add(billDto.getAmt());
                amtRatioFd=amtRatioFd.add(billDto.getAmt_ratio());
                amtStdFd=amtStdFd.add(billDto.getAmt_std());
//                //TODO 杨扬 1、门诊补费 2、挂号费用
//                if(!StringUtil.isEmpty(billDto.getId_orsrv()))
//                    strIdOrSrvLst.add(billDto.getId_orsrv());
            }
        }
        
        //2、生成结算DO
        GetCodeByCustomization customCode=new GetCodeByCustomization();
        BlStOepDO stOepDo=new BlStOepDO();
        stOepDo.setId_grp(operatorInfoDTO.getId_grp());
        stOepDo.setId_org(operatorInfoDTO.getId_org());
        stOepDo.setId_pat(appendBillParamDTOs[0].getId_pat());
        stOepDo.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
        stOepDo.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
        stOepDo.setAmt_std(amtStdFd);
        stOepDo.setAmt_pat(new FDouble(0.00));
        stOepDo.setDt_st(AppUtils.getServerDateTime());
        stOepDo.setId_dep_st(operatorInfoDTO.getId_dep());
        stOepDo.setId_emp_st(operatorInfoDTO.getId_emp());
        stOepDo.setFg_canc(FBoolean.FALSE);
        stOepDo.setFg_arclear(FBoolean.TRUE);
        stOepDo.setFg_cc(FBoolean.FALSE);
        String strCodest=null;
        if(Context.get().getAttribute("codest")!=null)
        {
        	strCodest=(String)Context.get().getAttribute("codest");
        }
        if(StringUtil.isEmpty(strCodest))
        {
            //获取结算流水号
            stOepDo.setCode_st(customCode.GetCodeStOep());
        }
        else
        {
        	stOepDo.setCode_st(strCodest);
        }
        if(strEntLst.size()==1)
        {
        	//如果只有一次就诊则在bl_st_oep里插入就诊号
        	stOepDo.setId_ent(strEntLst.get(0));
        	stOepDo.setId_enttp(appendBillParamDTOs[0].getId_enttp());
        	stOepDo.setCode_enttp(appendBillParamDTOs[0].getCode_enttp());
        }
        stOepDo.setId_patca(appendBillParamDTOs[0].getId_patica());//卡工本费
        if(strEntLst.size() > 0 && StringUtil.isEmpty(stOepDo.getId_patca())){
        	//补充字段
            DAFacade daf = new DAFacade();
            List<PatiVisitDO> enDOList = (List<PatiVisitDO>)daf.findByPKs(PatiVisitDO.class, strEntLst.toArray(new String[0]));
//            stOepDo.setId_hp(enDOList.get(0).getId_hp());
            stOepDo.setId_patca(enDOList.get(0).getId_patca());//后台任务
        }
        if(!StringUtil.isEmpty(stOepDo.getId_patca())){
        	IPatcatehpRService patcaHpService = ServiceFinder.find(IPatcatehpRService.class);
        	PiPatCaHpDO[] patcaHpDos = patcaHpService.findByAttrValString(PiPatCaHpDO.ID_PATCA, stOepDo.getId_patca());
        	if(!ArrayUtil.isEmpty(patcaHpDos)){
        		stOepDo.setId_hp(patcaHpDos[0].getId_hp());
        	}
        }
        
        stOepDo.setEu_direct(BookRtnDirectEnum.CHARGES);
        
        //判断是否都为挂号费用
        
        
        stOepDo.setEu_sttp(StTypeEnum.ST_OEP_CHARGE);
        stOepDo.setAmt_hp(new FDouble(0.00));
        stOepDo.setAmt(amtRatioFd);
        stOepDo.setAmt_ratio(amtRatioFd);
        //医疗类别
        if(StringUtils.isNotEmpty(appendBillParamDTOs[0].getSd_hpsttp())){
	        stOepDo.setSd_hpsttp(appendBillParamDTOs[0].getSd_hpsttp());
	        stOepDo.setId_hpsttp(appendBillParamDTOs[0].getId_hpsttp());
        }
        //医保计划下医疗类别
        if(StringUtils.isNotEmpty(appendBillParamDTOs[0].getId_medkind())){
	        stOepDo.setId_medkind(appendBillParamDTOs[0].getId_medkind());
        }
        stOepDo.setStatus(DOStatus.NEW);
        IBlstoepCudService stOepCudService=ServiceFinder.find(IBlstoepCudService.class);
        BlStOepDO[] stOepDoSavedArr=stOepCudService.insert(new BlStOepDO[]{stOepDo});
        
        //3、记账数据更新
        /*
         * 针对收费明细，有两种情况的数据需要处理
         * 1、预交金预付费的数据，已经有bl_cg_itm,做更新操作
         * 2、正常流程下的医嘱服务收费，没有bl_Cg_itm，做数据增加操作
         */
        IBlcgoepCudService cgoepCudService=ServiceFinder.find(IBlcgoepCudService.class);
        if(strIdCgOepLst.size()>0)
        {            
            //记账明细获取服务
            IBlcgoepRService cgOepRService=ServiceFinder.find(IBlcgoepRService.class);
            //获取已记账的收费明细
            BlcgoepAggDO[] cgOepAggdoArr=cgOepRService.findByIds(strIdCgOepLst.toArray(new String[0]), FBoolean.FALSE);
            if(cgOepAggdoArr.length>0){
                for(BlcgoepAggDO cgOepAggdoTmp:cgOepAggdoArr)
                {
                    BlCgItmOepDO[] cgItmOepDoArr=cgOepAggdoTmp.getBlCgItmOepDO(); 
                    //情况1，如果有已记账数据，一般是预交金预付的项目
                    for(BlCgItmOepDO itmOepDo:cgItmOepDoArr)
                    {
                        itmOepDo.setId_stoep(stOepDoSavedArr[0].getId_stoep());
                        itmOepDo.setFg_st(FBoolean.TRUE);
                        itmOepDo.setFg_susp(FBoolean.TRUE);
                        itmOepDo.setCode_st(stOepDoSavedArr[0].getCode_st());
                        itmOepDo.setStatus(DOStatus.UPDATED);
                    }
                }
                
                BlcgoepAggDO[] cgOepAggdoUpdated=cgoepCudService.update(cgOepAggdoArr);
                arrayList.addAll(Arrays.asList(cgOepAggdoUpdated));
            }
        }

        if(!cgItmOepDoPricingLst.isEmpty())
        {
            //情况2，正常的医嘱服务收费
            BlcgoepAggDO cgoepAggdo=new BlcgoepAggDO();
            //医嘱数据，需要生成
            BlCgOepDO cgOepDo=new BlCgOepDO();
            cgOepDo.setId_grp(operatorInfoDTO.getId_grp());
            cgOepDo.setId_org(operatorInfoDTO.getId_org());
            cgOepDo.setId_pat(cgItmOepDoPricingLst.get(0).getId_pat());
            cgOepDo.setEu_direct(BookRtnDirectEnum.CHARGES);
            cgOepDo.setDt_cg(AppUtils.getServerDateTime());
            cgOepDo.setId_org_cg(operatorInfoDTO.getId_org());
            cgOepDo.setId_dep_cg(operatorInfoDTO.getId_dep());
            cgOepDo.setId_emp_cg(operatorInfoDTO.getId_emp());
            cgOepDo.setCode_cg(customCode.GetCodeBlCgOep());
            cgOepDo.setStatus(DOStatus.NEW);
            cgoepAggdo.setParentDO(cgOepDo);
            
            //补全记账明细结算主键字段
            for(BlCgItmOepDO itmDo:cgItmOepDoPricingLst)
            {
                itmDo.setId_stoep(stOepDoSavedArr[0].getId_stoep());
                itmDo.setCode_st(stOepDoSavedArr[0].getCode_st());
            }
            cgoepAggdo.setBlCgItmOepDO(cgItmOepDoPricingLst.toArray(new BlCgItmOepDO[0]));
            BlcgoepAggDO[] cgOepAggdoSavedArr=cgoepCudService.save(new BlcgoepAggDO[]{cgoepAggdo});
            arrayList.addAll(Arrays.asList(cgOepAggdoSavedArr));
        }        
        
        
        BlCgOepAggDTO cgOepAggDto=new BlCgOepAggDTO();
        cgOepAggDto.setBlcgoepAggDO(arrayList);
        
        //重新确定结算类型
        boolean fgEnSt = true;//是否挂号结算
        for (int i = 0; i < arrayList.size(); i++) {
        	BlcgoepAggDO cgAggDo = (BlcgoepAggDO)arrayList.get(i);
        	for (BlCgItmOepDO cgItmDO : cgAggDo.getBlCgItmOepDO()) {
        		if(!FeeOriginEnum.ENCOUNTER_FEE.equals(cgItmDO.getEu_srctp())){
        			fgEnSt = false;
        			break;
        		}
			}
        	if(!fgEnSt)
        		break;
		}
        
        if(fgEnSt){
        	stOepDoSavedArr[0].setEu_sttp(StTypeEnum.ST_OEP_REG);
        	stOepDoSavedArr[0].setStatus(DOStatus.UPDATED);
        	stOepCudService.update(new BlStOepDO[]{stOepDoSavedArr[0]});
        }
        
        return cgOepAggDto;
    }
    /**
     * 患者分类重复收费设置-数量相同的大于第1条的收费项目金额和单价设置为0
     * @param arrayList
     * @param cgoepCudService
     * @param id_ent
     * @return
     * @throws BizException
     * @author hanJQ
     */
    @SuppressWarnings("unchecked")
	private void setBdPatcaDupItmAmtPrice(BlOrderAppendBillParamDTO[] appendBillParamDTOs  , List<String> id_ents ,String id_pat) throws BizException{
    	boolean isEnt = false;//使用idEnt还是idPat查询患者分类。false为pat,true为idEnt
    	//1.根据id_ent查找患者分类
    	HashSet<String> idEnts = new HashSet<String>(id_ents);
    	idEnts.remove(null);
    	isEnt = idEnts.size() > 0;
    	
    	HashSet<String> idPatCas = new HashSet<String>();
    	//就诊和患者分类关系
    	HashMap<String, String> idEnt_idpatca = new HashMap<>();    	
    	DAFacade dao = new DAFacade();
    	if(isEnt){
    		String [] idEntArr = idEnts.toArray(new String[idEnts.size()]);
        	
        	String [] pks = new String []{PatiVisitDO.ID_ENT , PatiVisitDO.ID_PAT, PatiVisitDO.ID_PATCA};
        	List<PatiVisitDO> PatiVisitDOs = (List<PatiVisitDO>) dao.findByPKs(PatiVisitDO.class,idEntArr, pks);
        	if(PatiVisitDOs == null || PatiVisitDOs.size() == 0){
        		isEnt = false;
        	}else{
        		for(PatiVisitDO entDo : PatiVisitDOs){
        			idEnt_idpatca.put(entDo.getId_ent(), entDo.getId_patca());
        			idPatCas.add(entDo.getId_patca());
        		}
        		
        	}
    	}
    	String [] pks = new String []{PiPatDO.ID_PAT,PiPatDO.ID_PATICATE};
    	PiPatDO piPatDO =  (PiPatDO) dao.findByPK(PiPatDO.class,id_pat, pks);
    	//默认如果就诊的患者分类为空则按患者的患者分类
    	String dftIdPatCa = "";
    	if(piPatDO != null){
    		dftIdPatCa = piPatDO.getId_paticate();
    		idPatCas.add(dftIdPatCa);
    	}
    	
    	//2.查找患者分类重复收费项目
    	StringBuilder sb = new StringBuilder();
    	sb.append(" Id_patca ").append(" in (");
    	for(String Id_patca : idPatCas){
    		sb.append("'").append(Id_patca).append("' ,");
    	}
    	sb.append(" '' ) ")
    	.append(" and ( fg_entp_op = 'Y' or fg_entp_er = 'Y' ) and ")
    	.append(" dt_e >= '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("'")
    	.append(" and id_srv in (");
    	HashSet<String> idSrvSet = new HashSet<>();
        String key = null;
        HashMap<String, ArrayList<BlOrderAppendBillParamDTO>> srvQuanMap = new HashMap<>();
        for(int i = 0 ,size = appendBillParamDTOs.length ; i < size ; i++){
        	BlOrderAppendBillParamDTO itmOep =  appendBillParamDTOs[i];
			if(StringUtils.isNotBlank(itmOep.getId_srv()))
				idSrvSet.add(itmOep.getId_srv());
			String id_patca = idEnt_idpatca.get(itmOep.getId_ent());
			if(StringUtils.isBlank(id_patca)){
				id_patca = dftIdPatCa;
			}
			//键设置成   Id_srv:Quan:id_patca格式的
			key = String.format("%s:%s:%s", itmOep.getId_srv(),itmOep.getQuan(),id_patca);
			if(srvQuanMap.containsKey(key)){
				srvQuanMap.get(key).add(itmOep);
			}else{
				ArrayList<BlOrderAppendBillParamDTO> newList = new ArrayList<>();
				newList.add(itmOep);
				srvQuanMap.put(key , newList);
			}    
        }
        if(idSrvSet.size() == 0){
        	return;
        }
        sb.append(SqlUtils.arrayToStr(idSrvSet.toArray(new String[0])));
        sb.append(" ) ");
        
        List<BdPatcaDupItmPriDO> patcaDupItmPriDOs =(List<BdPatcaDupItmPriDO>) dao.findByCond(BdPatcaDupItmPriDO.class, sb.toString());
        
        ArrayList<BlOrderAppendBillParamDTO> list = null;
        //找出患者分类重复收费项目中的重复服务，从第2条开始设置金额等为0
        if(patcaDupItmPriDOs != null && patcaDupItmPriDOs.size() > 0){
        	for(BdPatcaDupItmPriDO itm:patcaDupItmPriDOs){
        		for (String srvQuan:srvQuanMap.keySet()) {
					if(srvQuan.contains(itm.getId_srv()) && srvQuan.contains(itm.getId_patca()) &&srvQuanMap.get(srvQuan).size() > 1){
						list = srvQuanMap.get(srvQuan);
						int j = 0;
						for(BlOrderAppendBillParamDTO itmOep : list){
							if(j > 0){
								//itmOep.setAmt_acc(FDouble.ZERO_DBL);
								itmOep.setAmt(FDouble.ZERO_DBL);
								itmOep.setAmt_hp(FDouble.ZERO_DBL);
								itmOep.setAmt_pat(FDouble.ZERO_DBL);
								itmOep.setAmt_ratio(FDouble.ZERO_DBL);
								//itmOep.setAmt_std(FDouble.ZERO_DBL);
								
								//itmOep.setPrice(FDouble.ZERO_DBL);
								itmOep.setPrice_ratio(FDouble.ZERO_DBL);
								itmOep.setStatus(DOStatus.UPDATED);
							}
							j++;
						}
					}
				}
        	}
        }
    }
    /**
     * 计费明细DTO到记账DO的映射
     * @param appendBillParamDTO 记账明细dto
     * @param operatorInfoDTO 操作人员DTO
     * @return
     * @throws BizException
     */
    private BlCgItmOepDO mapperDoToDto(BlOrderAppendBillParamDTO appendBillParamDTO,OperatorInfoDTO operatorInfoDTO) throws BizException{
        BlCgItmOepDO cgItmOepDo=new BlCgItmOepDO();
        cgItmOepDo.setId_grp(operatorInfoDTO.getId_grp());
        cgItmOepDo.setId_org(operatorInfoDTO.getId_org());
        cgItmOepDo.setId_pat(appendBillParamDTO.getId_pat());
        cgItmOepDo.setId_pres(appendBillParamDTO.getId_pres());
        cgItmOepDo.setId_ent(appendBillParamDTO.getId_ent());
        cgItmOepDo.setCode_enttp(appendBillParamDTO.getCode_enttp());
        cgItmOepDo.setId_enttp(appendBillParamDTO.getId_enttp());
        cgItmOepDo.setId_or(appendBillParamDTO.getId_or());
        cgItmOepDo.setId_orsrv(appendBillParamDTO.getId_orsrv());
        cgItmOepDo.setId_srvtp(appendBillParamDTO.getId_srvtp());
        cgItmOepDo.setSd_srvtp(appendBillParamDTO.getSd_srvtp());
        cgItmOepDo.setId_srvca(appendBillParamDTO.getId_srvca());
        cgItmOepDo.setId_srv(appendBillParamDTO.getId_srv());
        cgItmOepDo.setCode_srv(appendBillParamDTO.getCode_srv());
        cgItmOepDo.setName_srv(appendBillParamDTO.getName_srv());
        cgItmOepDo.setSrvu(appendBillParamDTO.getSrvu());
        //单价
        cgItmOepDo.setPrice(appendBillParamDTO.getPrice());
        cgItmOepDo.setPrice_ratio(appendBillParamDTO.getPrice_ratio());
        cgItmOepDo.setQuan(appendBillParamDTO.getQuan());
        cgItmOepDo.setAmt(appendBillParamDTO.getAmt());
        cgItmOepDo.setRatio_pripat(appendBillParamDTO.getRatio_pripat());
        cgItmOepDo.setAmt_std(appendBillParamDTO.getAmt_std());
        cgItmOepDo.setId_pripat(appendBillParamDTO.getId_pripat());
        cgItmOepDo.setAmt_pat(appendBillParamDTO.getAmt_pat());
        cgItmOepDo.setId_hpsrvtp(appendBillParamDTO.getId_hpsrvtp());
        cgItmOepDo.setSd_hpsrvtp(appendBillParamDTO.getSd_hpsrvtp());
        cgItmOepDo.setId_hp(appendBillParamDTO.getId_hp());
        cgItmOepDo.setRatio_hp(appendBillParamDTO.getRatio_hp());
        cgItmOepDo.setAmt_hp(appendBillParamDTO.getAmt_hp());
        cgItmOepDo.setAmt_ratio(appendBillParamDTO.getAmt_ratio());
        cgItmOepDo.setAmt_acc(new FDouble(0.00));
        cgItmOepDo.setFg_acc(FBoolean.FALSE);
        cgItmOepDo.setDt_or(appendBillParamDTO.getDt_or());
        cgItmOepDo.setId_org_or(appendBillParamDTO.getId_org_or());
        cgItmOepDo.setId_dep_or(appendBillParamDTO.getId_dep_or());
        cgItmOepDo.setId_emp_or(appendBillParamDTO.getId_emp_or());
        cgItmOepDo.setId_org_mp(appendBillParamDTO.getId_org_mp());
        cgItmOepDo.setId_dep_mp(appendBillParamDTO.getId_dep_mp());
        cgItmOepDo.setId_dep_wh(appendBillParamDTO.getId_dep_wh());
        cgItmOepDo.setFg_mm(appendBillParamDTO.getFg_mm());
        cgItmOepDo.setId_mm(appendBillParamDTO.getId_mm());
        cgItmOepDo.setId_mmtp(appendBillParamDTO.getId_mmtp());
        cgItmOepDo.setSd_mmtp(appendBillParamDTO.getSd_mmtp());
        cgItmOepDo.setCode_mm(appendBillParamDTO.getCode_mm());
        cgItmOepDo.setOnlycode(appendBillParamDTO.getOnlycode());
        cgItmOepDo.setName_mm(appendBillParamDTO.getName_mm());
        cgItmOepDo.setSpec(appendBillParamDTO.getSpec());
        cgItmOepDo.setCd_batch(appendBillParamDTO.getCd_batch());
        cgItmOepDo.setPgku_base(appendBillParamDTO.getPgku_base());
        cgItmOepDo.setPgku_cur(appendBillParamDTO.getPgku_cur());
        cgItmOepDo.setFactor(appendBillParamDTO.getFactor());
        cgItmOepDo.setQuan_base(appendBillParamDTO.getQuan_base());
        cgItmOepDo.setPri_ss(appendBillParamDTO.getPri_ss());
        cgItmOepDo.setSd_abrd(appendBillParamDTO.getSd_abrd());
        //划价操作，这里置为true
        cgItmOepDo.setFg_st(FBoolean.TRUE);
        cgItmOepDo.setDt_st(AppUtils.getServerDateTime());
        cgItmOepDo.setFg_susp(FBoolean.TRUE);
        cgItmOepDo.setEu_srctp(appendBillParamDTO.getEu_srctp());
        cgItmOepDo.setFg_refund(FBoolean.FALSE);
        cgItmOepDo.setFg_additm(appendBillParamDTO.getFg_additm());
        //物品唯一码
        cgItmOepDo.setApprno(appendBillParamDTO.getApprno());
        //重划价标志
        cgItmOepDo.setFg_recg(FBoolean.FALSE);
        //服务项目发生日期（结算），默认为当前服务器时间
        cgItmOepDo.setDt_srv(AppUtils.getServerDateTime());
        cgItmOepDo.setSrcfunc_des(appendBillParamDTO.getSrcfunc_des());
        cgItmOepDo.setCode_inccaitm(appendBillParamDTO.getCode_inccaitm());
        cgItmOepDo.setName_inccaitm(appendBillParamDTO.getName_inccaitm());
        cgItmOepDo.setFg_free(appendBillParamDTO.getFg_free());
        cgItmOepDo.setFg_pricinginsertcg(appendBillParamDTO.getFg_pricinginsertcg());
        //是否商保记账
        cgItmOepDo.setFg_hpcg(FBoolean.FALSE);
        cgItmOepDo.setCode_apply(appendBillParamDTO.getCode_apply());
        //打印单类型
        cgItmOepDo.setCode_applytp(appendBillParamDTO.getCode_applytp());
        //赋值通用目录等级
        if (iih.bd.base.utils.StringUtils.isNotEmpty(appendBillParamDTO.getSd_std_hpsrvtp())) {
			cgItmOepDo.setSd_std_hpsrvtp(appendBillParamDTO.getSd_std_hpsrvtp());
		}else {
			cgItmOepDo.setSd_std_hpsrvtp(getSdStdHpsrvtp(appendBillParamDTO));
		}
        return cgItmOepDo;
    }
    /**
     * 获取通用目录等级
     * @author zhang.hw
     * @date 2020年6月18日
     * @param appendBillParamDTO
     * @return
     * @throws BizException
     */
    private String getSdStdHpsrvtp(BlOrderAppendBillParamDTO appendBillParamDTO) throws BizException {
    	String id_dep = appendBillParamDTO.getId_dep_or();
		String id_hp = appendBillParamDTO.getId_hp();
		
		// 取的科室的黑白名单标识
		FBoolean fg_black = this.getDepFgblack(id_dep);
		
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append(" DECODE(srvtp.sd_hpsrvtp, ");
		sb.append("                                               NULL, ");
		sb.append("                                               srvtp3.sd_hpsrvtp, ");
		sb.append("                                               srvtp.sd_hpsrvtp)  Sd_hpsrvtp ");
		if(fg_black==null){
			sb.append(" from bd_srv srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
			sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
			sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		}else if(fg_black.booleanValue()){
			sb.append(" from (select * from bd_srv srv where srv.id_srv not in(");
			sb.append(" select itm.id_srv from bd_dep_cg limt");
			sb.append(" inner join bd_dep_cg_itm itm on limt.id_depcg=itm.id_depcg and limt.fg_black='Y'  and limt.id_dep='"+id_dep+"' ))");
			sb.append(" srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
			sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
			sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		}else{
			sb.append(" from (select * from bd_srv srv where srv.id_srv in(");
			sb.append(" select itm.id_srv from bd_dep_cg limt");
			sb.append(" inner join bd_dep_cg_itm itm on limt.id_depcg=itm.id_depcg and limt.fg_black='N'  and limt.id_dep='"+id_dep+"' ))");
			sb.append(" srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
			sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
			sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		}
		sb.append(" left  outer  join  (select  distinct  srvca.id_hpsrvorca, ");
		sb.append("                                                                   srvca.id_srv, ");
		sb.append("                                                                   DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                 NULL, ");
		sb.append("                                                                                 srvtp2.sd_hpsrvtp_name, ");
		sb.append("                                                                                 DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                               '~', ");
		sb.append("                                                                                               srvtp2.sd_hpsrvtp_name, ");
		sb.append("                                                                                               udidoc.name))  sd_hpsrvtp_name, ");
		sb.append("                                                                   DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                 NULL, ");
		sb.append("                                                                                 srvtp2.sd_hpsrvtp, ");
		sb.append("                                                                                 DECODE(srvca.sd_hpsrvtp, ");
		sb.append("                                                                                               '~', ");
		sb.append("                                                                                               srvtp2.sd_hpsrvtp, ");
		sb.append("                                                                                               srvca.sd_hpsrvtp))  sd_hpsrvtp ");
		sb.append("                                       from  bd_hp_srvorca  srvca ");
		sb.append("                                     inner  join  bd_hp  hp ");
		if (StringUtils.isNotEmpty(id_hp)) {
			sb.append("                                   on  hp.id_hp  =  '").append(id_hp).append("' ");
		}else {
			sb.append("                                   on  hp.FG_DEFAULT  =  'Y' ");
		}
		sb.append("                                         and  hp.id_hp  =  srvca.id_hp ");
		sb.append("                                     inner  join  mi_hpsrvtp_vs_stdhpsrvtp  srvtp1 ");
		sb.append("                                           on  srvtp1.SD_STD_HPSRVTP  =  srvca.sd_hpsrvtp ");
		sb.append(" inner  join  bd_udidoc  udidoc ");
		sb.append("                                               on  udidoc.code  =  srvca.sd_hpsrvtp ");
		sb.append("                                         inner  join  bd_udidoclist  udlist ");
		sb.append("                                               on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sb.append("                                             and  udlist.code  =  'BD.BL.1020' ");

		sb.append("                                       left  outer  join  (select  srvtp.SD_STD_HPSRVTP as sd_hpsrvtp,srvtp.sd_hpsrvtp as sd_hpsrvtp_name ");
		sb.append("                                                                           from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sb.append("                                                                         inner  join  bd_udidoc  udidoc ");
		sb.append("                                                                               on  udidoc.code  = ");
		sb.append("                                                                                     srvtp.SD_STD_HPSRVTP ");
		sb.append("                                                                             and  udidoc.ctrl1  =  'Y' ");
		sb.append("                                                                             and  udidoc.activestate  =  '2' ");
		sb.append("                                                                         inner  join  bd_udidoclist  udlist ");
		sb.append("                                                                               on  udlist.id_udidoclist  = ");
		sb.append("                                                                                     udidoc.id_udidoclist ");
		sb.append("                                                                             and  udlist.code  =  'BD.BL.1020' ");
		sb.append("                                                                         where  rownum  =  1)  srvtp2 ");
		sb.append("                                           on  1  =  1)  srvtp ");
		sb.append("     on  srvtp.id_srv  =  srv1.id_srv ");
		sb.append(" left  outer  join  (select  srvtp.SD_STD_HPSRVTP as sd_hpsrvtp,srvtp.sd_hpsrvtp as sd_hpsrvtp_name ");
		sb.append("                                       from  mi_hpsrvtp_vs_stdhpsrvtp  srvtp ");
		sb.append("                                     inner  join  bd_udidoc  udidoc ");
		sb.append("                                           on  udidoc.code  =  srvtp.SD_STD_HPSRVTP ");
		sb.append("                                         and  udidoc.ctrl1  =  'Y' ");
		sb.append("                                         and  udidoc.activestate  =  '2' ");
		sb.append("                                     inner  join  bd_udidoclist  udlist ");
		sb.append("                                           on  udlist.id_udidoclist  =  udidoc.id_udidoclist ");
		sb.append("                                         and  udlist.code  =  'BD.BL.1020' ");
		sb.append("                                     where  rownum  =  1)  srvtp3 ");
		sb.append("     on  1  =  1 ");
		sb.append(" where 1=1 and srv1.fg_active = 'Y' and srv1.Ds=0 and (bd_mm.fg_active is null or bd_mm.fg_active = 'Y') ");
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new MedSrvDO(), "srv1");//增加组织隔离
		sb.append(sqlContext);
		
		if (FBoolean.FALSE.equals(appendBillParamDTO.getFg_mm())) {
			sb.append(" and srv1.id_srv=? ");
		}else {
			sb.append(" and srv1.id_srv=? and bd_mm.id_mm=? ");
		}
		SqlParam sqlParam = new SqlParam();
		if (FBoolean.FALSE.equals(appendBillParamDTO.getFg_mm())) {
			sqlParam.addParam(appendBillParamDTO.getId_srv());
		}else {
			sqlParam.addParam(appendBillParamDTO.getId_srv());
			sqlParam.addParam(appendBillParamDTO.getId_mm());
		}
		DAFacade daFacade = new DAFacade();
		ArrayList<String> list = (ArrayList<String>)daFacade.execQuery(sb.toString(), sqlParam, new ColumnListHandler());
		if (list.size()<=0) {
			return null;
		}
		if (list.size()>1) {
			throw new BizException("门诊记账数据组装错误：通用医保目录等级查询出多条，请检查后重试！");
		}
		return list.get(0);
	}
    
    /**
     * 取的科室的黑白名单标识
     * @author zhang.hw
     * @date 2020年6月18日
     * @param id_dep
     * @return
     */
    private FBoolean getDepFgblack(String id_dep) {
		if (StringUtil.isEmpty(id_dep)) {
			return null;
		}
		try {
			List<BdDepCgDO> results = (List<BdDepCgDO>) new DAFacade().findByAttrValString(BdDepCgDO.class,
					BdDepCgDO.ID_DEP, id_dep, new String[] { BdDepCgDO.FG_BLACK });
			if (!ListUtil.isEmpty(results)) {
				return results.get(0).getFg_black();
			} else {
				return null;
			}
		} catch (DAException daException) {
			return null;
		}
	}

	/**
     * 生成发票信息
     * @param cgOepAggDto 记账信息
     * @throws BizException 抛出的业务异常
     */
    private void assemblyIncOepInfo(BlCgOepAggDTO cgOepAggDto,OperatorInfoDTO operatorInfoDto) throws BizException{
    	//账单项对应金额Amt
    	Map<String,FDouble> mapInccaitmCodeVsAmt=new HashMap<String,FDouble>();
    	Map<String,FDouble> mapInccaitmCodeVsAmtStd=new HashMap<String,FDouble>();
    	Map<String,FDouble> mapInccaitmCodeVsAmtRatio=new HashMap<String,FDouble>();
    	Map<String,FDouble> mapInccaitmCodeVsAmtPat=new HashMap<String,FDouble>();
    	Map<String,FDouble> mapInccaitmCodeVsAmtHp=new HashMap<String,FDouble>();
//    	Map<String,FDouble> mapInccaitmCodeVsAmtHp=new HashMap<String,FDouble>();
    	//1、生成发票记账明细对应表DO
		List<BlIncCgItmOep> incCgitmOepLst=new ArrayList<BlIncCgItmOep>();
		List<BlCgItmOepDO> cgItmOepDoLst=new ArrayList<BlCgItmOepDO>();
		//获取记账数据
		FArrayList cgOepAggdoLst=cgOepAggDto.getBlcgoepAggDO();
		for(Object cgOepAggdo:cgOepAggdoLst)
		{
			//转化为记账主AggDO
			BlcgoepAggDO aggdo=(BlcgoepAggDO)cgOepAggdo;
			BlCgItmOepDO[] cgItmOepDoArr=aggdo.getBlCgItmOepDO();
			for(BlCgItmOepDO cgItmOepDo:cgItmOepDoArr)
			{
				if(cgItmOepDo.getFg_refund().booleanValue())
					continue;
				String strKey=cgItmOepDo.getCode_inccaitm()+";"+cgItmOepDo.getName_inccaitm();
				//账单项的对应Amt
				if(mapInccaitmCodeVsAmt.containsKey(strKey))
				{
					//如果有对应账单项，则金额累加
					FDouble FdTmp=mapInccaitmCodeVsAmt.get(strKey).add(cgItmOepDo.getAmt());	
					mapInccaitmCodeVsAmt.put(strKey, FdTmp);
				}
				else
				{
					FDouble fdAmt=cgItmOepDo.getAmt();
					mapInccaitmCodeVsAmt.put(strKey, fdAmt);
				}
				//账单项的对应AmtStd
				if(mapInccaitmCodeVsAmtStd.containsKey(strKey))
				{
					//如果有对应账单项，则金额累加
					FDouble FdTmp=mapInccaitmCodeVsAmtStd.get(strKey).add(cgItmOepDo.getAmt_std());
					mapInccaitmCodeVsAmtStd.put(strKey, FdTmp);
				}
				else
				{
					FDouble fdAmtStd=cgItmOepDo.getAmt_std();
					mapInccaitmCodeVsAmtStd.put(strKey, fdAmtStd);
				}
				//账单项的对应amt_ratio
				if(mapInccaitmCodeVsAmtRatio.containsKey(strKey))
				{
					//如果有对应账单项，则金额累加
					FDouble FdTmp=mapInccaitmCodeVsAmtRatio.get(strKey).add(cgItmOepDo.getAmt_ratio());	
					mapInccaitmCodeVsAmtRatio.put(strKey, FdTmp);
				}
				else
				{
					FDouble fdAmtRatio=cgItmOepDo.getAmt_ratio();
					mapInccaitmCodeVsAmtRatio.put(strKey, fdAmtRatio);
				}				
				//账单项的对应amt_pat
				if(mapInccaitmCodeVsAmtPat.containsKey(strKey))
				{
					//如果有对应账单项，则金额累加
					FDouble FdTmp=mapInccaitmCodeVsAmtPat.get(strKey).add(cgItmOepDo.getAmt_pat());	
					mapInccaitmCodeVsAmtPat.put(strKey,FdTmp);
				}
				else
				{
					FDouble fdAmtPat=cgItmOepDo.getAmt_pat();
					mapInccaitmCodeVsAmtPat.put(strKey, fdAmtPat);
				}
				//账单项的对应amt_hp
				if(mapInccaitmCodeVsAmtHp.containsKey(strKey))
				{
					//如果有对应账单项，则金额累加
					FDouble FdTmp=mapInccaitmCodeVsAmtHp.get(strKey).add(cgItmOepDo.getAmt_hp());
					mapInccaitmCodeVsAmtHp.put(strKey, FdTmp);
				}
				else
				{
					FDouble fdAmtHp=cgItmOepDo.getAmt_hp();
					mapInccaitmCodeVsAmtHp.put(strKey, fdAmtHp);
				}
				//发票明细对照关系表
				BlIncCgItmOep incCgItmOep=new BlIncCgItmOep();
				incCgItmOep.setId_cgitmoep(cgItmOepDo.getId_cgitmoep());
				incCgItmOep.setStatus(DOStatus.NEW);//设置实体状态
				incCgitmOepLst.add(incCgItmOep);
				//生成明细集合
				cgItmOepDoLst.add(cgItmOepDo);
			}
		}
		//2、发票账单项明细表，并计算总金额
		FDouble fdAmt=new FDouble(0.00);
		FDouble fdAmtRatio=new FDouble(0.00);
		FDouble fdAmtStd=new FDouble(0.00);
		FDouble fdAmtPat=new FDouble(0.00);
		FDouble fdAmtHp=new FDouble(0.00);
		List<BlIncItmOepDO> incItmOepDoLst=new ArrayList<BlIncItmOepDO>();
		Iterator iterator=mapInccaitmCodeVsAmt.entrySet().iterator();
		while(iterator.hasNext())
		{
			BlIncItmOepDO incItmOepDo=new BlIncItmOepDO();
			Map.Entry entry=(Map.Entry)iterator.next();
			String[] strFieldArr=((String)entry.getKey()).split(";");
			incItmOepDo.setCode(strFieldArr[0]);
			incItmOepDo.setName(strFieldArr[1]);
			incItmOepDo.setAmt((FDouble)entry.getValue());
			incItmOepDo.setAmt_free(new FDouble(0.00));
			incItmOepDo.setAmt_hp(new FDouble(0.00));
//			incItmOepDo.setAmt_pat(mapInccaitmCodeVsAmtPat.get((String)entry.getKey()));
			incItmOepDo.setAmt_ratio(mapInccaitmCodeVsAmtRatio.get((String)entry.getKey()));
			incItmOepDo.setAmt_std(mapInccaitmCodeVsAmtStd.get((String)entry.getKey()));
//			incItmOepDo.setAmt_hp(mapInccaitmCodeVsAmtHp.get((String)entry.getKey()));
			incItmOepDo.setStatus(DOStatus.NEW);
			incItmOepDoLst.add(incItmOepDo);
			
			fdAmt=fdAmt.add((FDouble)entry.getValue());
			fdAmtStd=fdAmtStd.add(mapInccaitmCodeVsAmtStd.get((String)entry.getKey()));
			fdAmtRatio=fdAmtRatio.add(mapInccaitmCodeVsAmtRatio.get((String)entry.getKey()));
//			fdAmtPat=fdAmtPat.add(mapInccaitmCodeVsAmtPat.get((String)entry.getKey()));
//			fdAmtHp=fdAmtHp.add(mapInccaitmCodeVsAmtHp.get((String)entry.getKey()));
		}
		//3、构建主DO
		BlIncOepDO blIncOepDo = new BlIncOepDO();
		blIncOepDo.setCode_enttp("00");
		blIncOepDo.setCreatedby(Context.get().getUserId());
		blIncOepDo.setCreatedtime(AppUtils.getServerDateTime());
		blIncOepDo.setDt_inc(AppUtils.getServerDateTime());
		blIncOepDo.setEu_direct(BookRtnDirectEnum.CHARGES);
		blIncOepDo.setFg_canc(FBoolean.FALSE);
		blIncOepDo.setFg_print(FBoolean.FALSE);
		blIncOepDo.setId_dep_inc(Context.get().getDeptId());
		//人员ID
		blIncOepDo.setId_emp_inc(Context.get().getStuffId());
		blIncOepDo.setId_grp(Context.get().getGroupId());
		//患者编号
		blIncOepDo.setId_pat(((BlcgoepAggDO)cgOepAggdoLst.get(0)).getParentDO().getId_pat());
		
		blIncOepDo.setAmt(fdAmt);
		blIncOepDo.setAmt_ratio(fdAmtRatio);
		blIncOepDo.setAmt_std(fdAmtStd);
		blIncOepDo.setAmt_hp(fdAmtHp);
		blIncOepDo.setAmt_pat(fdAmtPat);
		//发票类型
		blIncOepDo.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		blIncOepDo.setId_org(Context.get().getOrgId());
		//结算主键
		blIncOepDo.setId_stoep(cgItmOepDoLst.get(0).getId_stoep());
		//金额计算
		
		blIncOepDo.setStatus(DOStatus.NEW);
		//4、发票主AggDo生成
		BlincoepAggDO blincoepAggDo = new BlincoepAggDO();
		blincoepAggDo.setParentDO(blIncOepDo);
		blincoepAggDo.setBlIncCgItmOep(incCgitmOepLst.toArray(new BlIncCgItmOep[0]));
		blincoepAggDo.setBlIncItmOepDO(incItmOepDoLst.toArray(new BlIncItmOepDO[0]));
		IBlincoepCudService service=ServiceFinder.find(IBlincoepCudService.class);
		service.save(new BlincoepAggDO[]{blincoepAggDo});
    }
    
    /**
     * 根据超量开药原因的编码获取对应的id
     * @param sdReason
     * @return
     */
    private String getExcessiveReasonID(String sdReason){
    	String id_reason="";
    	switch (sdReason){
    	case ICiDictCodeConst.SD_EXCESSIVE_REASON_NORMAL://无超量情况
    		id_reason=ICiDictCodeConst.ID_EXCESSIVE_REASON_NORMAL;
    		break;
    	case ICiDictCodeConst.SD_EXCESSIVE_REASON_INCONVENIENCE://行动不便
    		id_reason=ICiDictCodeConst.ID_EXCESSIVE_REASON_INCONVENIENCE;
    		break;
    	case ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC: //慢性病
    		id_reason=ICiDictCodeConst.ID_EXCESSIVE_REASON_CHRONIC;
    		break;
    	case ICiDictCodeConst.SD_EXCESSIVE_REASON_SENILE: //老年病
    		id_reason=ICiDictCodeConst.ID_EXCESSIVE_REASON_SENILE;
    		break;
    	case ICiDictCodeConst.SD_EXCESSIVE_REASON_EXCEPTIONAL: //特殊情况
    		id_reason=ICiDictCodeConst.ID_EXCESSIVE_REASON_EXCEPTIONAL;
    		break;    		
    	}
    	return id_reason;
    }
    
	/**
	 * 未记账待划价数据有效性校验
	 * @param unChargeList
	 * @throws BizException
	 */
	private void unChargeEffeValidate(Set<String> orsrvIdSet) throws BizException{

		if(orsrvIdSet.size() == 0)
			return;
		
		String sql = "select count(1) from bl_cg_itm_oep where " + SqlUtils.getInSqlByIds("id_orsrv", orsrvIdSet.toArray(new String[0]))
		+ " and fg_pricinginsertcg = 'Y' ";
		
		DAFacade daf = new DAFacade();
		Integer cnt = (Integer)daf.execQuery(sql, new ColumnHandler());
		
		if(cnt > 0){
			throw new BizException("门诊划价:重复划价");
		}
	}
}
