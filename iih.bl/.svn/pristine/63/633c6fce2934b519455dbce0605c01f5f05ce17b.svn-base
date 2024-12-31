package iih.bl.cg.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.service.i.IBdInccaQueService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendIncParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.comm.IBlConst;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.d.ReserveResultDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 计价功能
 * 
 * @author tcy
 *
 */
public class SetBlOrderAppendBillParamDTOPricing {

	/**
	 * 计算每条DTO的费用
	 * 
	 * @param appendBillParamDTO
	 * @return BlOrderAppendBillParamDTO[]格式的费用明细
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetBlOrderAppendBillParamDTOPricing(BlOrderAppendBillParamDTO[] appendBillParamDTO) throws BizException {
		List<BlOrderAppendBillParamDTO> temp = SetBlOrderAppendBillParamDTOPricing_bp(appendBillParamDTO);
		return temp.toArray(new BlOrderAppendBillParamDTO[] {});
	}

	/**
	 * 根据就诊类型和ID_srv，查询对应的账单项
	 * 
	 * @param code_enttp
	 *            就诊类型代码
	 * @param id_srv
	 *            服务ID
	 * @return 对应的账单项
	 * @throws BizException
	 */
	private IncCaItmDO getInccaitmCodeAndName(String code_enttp, String id_srv) throws BizException {
		IBdInccaQueService iBdInccaQueService = ServiceFinder.find(IBdInccaQueService.class);
		return iBdInccaQueService.getInccaitmCodeAndName(code_enttp, id_srv);
	}

	/**
	 * 计算每条DTO的费用
	 * 
	 * @param appendBillParamDTO
	 * @return List<BlOrderAppendBillParamDTO>格式的费用明细
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<BlOrderAppendBillParamDTO> SetBlOrderAppendBillParamDTOPricing_bp(BlOrderAppendBillParamDTO[] appendBillParamDTO) throws BizException {
		// 如果不起物品服务，会报错
		IMaterialStockService mlService = ServiceFinder.find(IMaterialStockService.class);
		IMaterialBaseInfoService meterialInfoService = ServiceFinder.find(IMaterialBaseInfoService.class);
		IMeterialService iMeterialService = ServiceFinder.find(IMeterialService.class);
		MeterialDO[] meterialDOs = null;
		FDateTime strDateTime = AppUtils.getServerDateTime();
		// 价格分类，待计价的服务项目
		ArrayList<BlOrderAppendBillParamDTO> newBlOrderAppendBillParamDTO = new ArrayList<BlOrderAppendBillParamDTO>();
		DAFacade dafacade = new DAFacade();
		FDouble amt = new FDouble();
		FDouble amt_std = new FDouble();
		FDouble price_ratio = new FDouble();
		String[] fields = { "id_ent", "Id_pripat" };

		//需要预留的物品信息
		List<ReserveReqDTO> mlDTOLst = new ArrayList<ReserveReqDTO>();
		//所有物品信息，为了取价格用 
		List<ReserveReqDTO> mlNoReserveDTOLst = new ArrayList<ReserveReqDTO>();
		List<String> id_mmLst = new ArrayList<String>();

		// TODO review by yangyang 该函数通用业务函数，上级不是已经校验过吗？
		// 1.作必要的校验，及其字段完善。如果需要物品预留，则需要提预留
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO) {
			if (dto.getId_org() == null) {
				throw new BizException("参数中未设置组织");
			}
			if (dto.getId_grp() == null) {
				throw new BizException("参数中未设置集团");
			}

			// 医嘱记账时间
			if (dto.getDt_last_bl() == null) {
				dto.setDt_last_bl(strDateTime);
			}
			if(dto.getEu_srctp()==null){
				
			}
			// 门诊已划价
			if (dto.getOutpBillDTO() != null && dto.getPrice() != null) {
				continue;
			}
			if (dto.getPrice() == null || ("").equals(String.valueOf(dto.getPrice()))) {
				// // 划价产生的数据
//				if ((dto.getFg_mm() != null && dto.getFg_mm().booleanValue() && dto.getFg_reserveMaterials() != null && dto.getFg_reserveMaterials().booleanValue())) {
				if ((dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) && FBoolean.TRUE.equals(dto.getFg_or())) {
					if (dto.getId_mm() == null) {
						throw new BizException("没有物品ID。\r\n名称：" + dto.getName_srv() + " 服务ID:" + dto.getId_srv());
					}
					if (dto.getId_dep_mp() == null) {
						throw new BizException("没有物品执行科室ID。\r\n服务名称：" + dto.getName_srv() + " 服务ID:" + dto.getId_srv());
					}
					if (dto.getQuan() == null) {
						throw new BizException("没有物品数量。\r\n服务名称：" + dto.getName_srv() + " 服务ID:" + dto.getId_srv());
					}
					if (dto.getPgku_cur() == null) {
						throw new BizException("没有物品单位。\r\n服务名称：" + dto.getName_srv() + " 服务ID:" + dto.getId_srv());
					}
					if (dto.getId_orsrv() == null) {
						throw new BizException("没有物品：医嘱服务ID。\r\n服务名称：" + dto.getName_srv() + " 服务ID:" + dto.getId_srv());
					}
					
					ReserveReqDTO mlDTO = new ReserveReqDTO();
					// 组装数据，获取物品预留
					mlDTO.setId_mm(dto.getId_mm());
					if (dto.getId_dep_wh() == null) {
						throw new BizException("没有为该服务(" + dto.getName_srv() + ")配置对应的库房信息");
					}
					mlDTO.setId_dep(dto.getId_dep_wh());
					mlDTO.setReq_num(dto.getQuan());
					mlDTO.setReq_unit_id(dto.getPgku_cur());
					mlDTO.setId_orsrv(dto.getId_orsrv());
					if (dto.getFg_reserveMaterials() != null && dto.getFg_reserveMaterials().booleanValue()) // 需要调用预留
					{
//						ReserveReqDTO mlDTO = new ReserveReqDTO();
//						// 组装数据，获取物品预留
//						mlDTO.setId_mm(dto.getId_mm());
//						if (dto.getId_dep_wh() == null) {
//							throw new BizException("没有为该服务(" + dto.getName_srv() + ")配置对应的库房信息");
//						}
//						mlDTO.setId_dep(dto.getId_dep_wh());
//						mlDTO.setReq_num(dto.getQuan());
//						mlDTO.setReq_unit_id(dto.getPgku_cur());
//						mlDTO.setId_orsrv(dto.getId_orsrv());
						mlDTOLst.add(mlDTO);
						id_mmLst.add(dto.getId_mm());
					}
					mlNoReserveDTOLst.add(mlDTO);
					
				}
			}
		}
		//取物品价格
		HashMap<String,FDouble> materialPriMap= new HashMap<String,FDouble>();
		if(!ListUtil.isEmpty(mlNoReserveDTOLst)){
			ReserveResultDTO[] materialStockDTOs = mlService.getPreReserveMaterialsPrice(mlNoReserveDTOLst.toArray(new ReserveReqDTO[]{}));
			if(!ArrayUtil.isEmpty(materialStockDTOs)){
				String sKey="";
				for(ReserveResultDTO dto:materialStockDTOs){
					sKey=dto.getId_orsrv();
					if(!materialPriMap.containsKey(sKey))
						materialPriMap.put(sKey, dto.getPrice_act());
				}
			}
			
		}
		
		// 若有物品且需要预留，则先预留物品
		ReserveResultDTO[] mlResults = null;
		Map<String, List<ReserveResultDTO>> reserveResultDTOMap = new HashMap<String, List<ReserveResultDTO>>();
		Map<String, MeterialDO> materialInfoDTOMap = new HashMap<String, MeterialDO>();
		if (mlDTOLst != null && mlDTOLst.size() > 0) {
			// 调用预留物品接口
			mlResults = mlService.reserveMaterials(IMaterialStockService.TYPE_RESERVE, mlDTOLst.toArray(new ReserveReqDTO[0]));
			meterialDOs = iMeterialService.findMaterialByIDS(id_mmLst.toArray(new String[0]));
			for (ReserveResultDTO reserveResultDTO : mlResults) {
				if (reserveResultDTOMap.containsKey(reserveResultDTO.getId_mm() + " " + reserveResultDTO.getId_orsrv())) {
					List<ReserveResultDTO> temp = reserveResultDTOMap.get(reserveResultDTO.getId_mm() + " " + reserveResultDTO.getId_orsrv());
					temp.add(reserveResultDTO);
					reserveResultDTOMap.remove(reserveResultDTO.getId_mm() + " " + reserveResultDTO.getId_orsrv());
					reserveResultDTOMap.put(reserveResultDTO.getId_mm() + " " + reserveResultDTO.getId_orsrv(), temp);
				} else {
					List<ReserveResultDTO> temp = new ArrayList<ReserveResultDTO>();
					temp.add(reserveResultDTO);
					reserveResultDTOMap.put(reserveResultDTO.getId_mm() + " " + reserveResultDTO.getId_orsrv(), temp);
				}
			}
			for (MeterialDO meterialDO : meterialDOs) {
				materialInfoDTOMap.put(meterialDO.getId_mm(), meterialDO);
			}
		}
		// 获取当前划价模式
		String prtps = BlParams.BLSTOEP0016();
		// 服务MAP 如果当前计价方式为2 需要获取服务中的金额
		Map<String, OrdSrvDO> orsrvMap = new HashMap<String, OrdSrvDO>();
		// 当前默认门诊采用当前价表来计价, 如果为 嘱开单时价格来计价时 需要获取对应的医嘱数据
		if (prtps == BlParamValueConst.BLSTOEP0016_WHENORDER) {
			List<String> idOrSrv = new ArrayList<String>();
			for (BlOrderAppendBillParamDTO billDto : appendBillParamDTO) {
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

		// 2.计价
		// 2018/11/3 ly 临时处理
		Set<String> srvList = new HashSet<String>();
		List<String> pripatIdList = new ArrayList<String>();
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO) {
			
			if(FBoolean.TRUE.equals(dto.getFg_mm()))
				continue;
			
			srvList.add(dto.getId_srv());
			pripatIdList.add(dto.getId_pripat());
		}
		
		Map<String, BdPriViewDTO> priMap = new HashMap<String, BdPriViewDTO>();
		if(srvList.size() > 0){
			
			IBdPriCalService calService = ServiceFinder.find(IBdPriCalService.class);
			BdPriViewDTO[] priViewDtos = calService.calSrvPrice(
					srvList.toArray(new String[0]),
					pripatIdList.toArray(new String[0]));
			
			priMap = (Map<String, BdPriViewDTO>) MapUtils
					.convertArrayToMap(priViewDtos, "Id_srv,Id_pripat");
		}
		
		
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO) {
			// 2.1.已授权的数据不用再次划价
			if (dto.getOutpBillDTO() != null) // 门诊已划价
			{
				if (dto.getOutpBillDTO().getFg_acc() != null) {
					// 已授权的价格
					if (dto.getOutpBillDTO().getFg_acc().booleanValue() && dto.getOutpBillDTO().getAmt_acc() != null) {
						if (dto.getAmt_ratio() == null) {
							dto.setAmt_ratio(dto.getAmt());
						}
						// 增加了折扣价格
						if (dto.getPrice_ratio() == null || dto.getPrice_ratio().toString().trim().length() == 0) {
							dto.setPrice_ratio(dto.getPrice());
						}
						if (dto.getName_inccaitm() == null || dto.getName_inccaitm().trim().length() == 0) {
							// 完善账单码
							/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(dto.getCode_enttp(), dto.getId_srv());
							if (incCaItmDO != null) {
								dto.setName_inccaitm(incCaItmDO.getName());
								dto.setCode_inccaitm(incCaItmDO.getCode());
							}*/
						}
						newBlOrderAppendBillParamDTO.add(dto);
						continue;
					}
				}
			}

			// 2.2.已计价的不能再次计价
			if (dto.getPrice() != null && !("").equals(String.valueOf(dto.getPrice())) && dto.getRatio_pripat() != null) {
				if (dto.getAmt_ratio() == null) {
					dto.setAmt_ratio(dto.getAmt());
				}
				// 增加了折扣价格
				if (dto.getPrice_ratio() == null || dto.getPrice_ratio().toString().trim().length() == 0) {
					dto.setPrice_ratio(dto.getPrice());
				}
				if (dto.getName_inccaitm() == null || dto.getName_inccaitm().trim().length() == 0) {
					// 完善账单码
					/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(dto.getCode_enttp(), dto.getId_srv());
					if (incCaItmDO != null) {
						dto.setName_inccaitm(incCaItmDO.getName());
						dto.setCode_inccaitm(incCaItmDO.getCode());
					}*/
				}
				newBlOrderAppendBillParamDTO.add(dto);
				continue;
			}

			// ——————————————————————————下面需要计价————————————————————————————

			// 2.3.确保Id_pripat（价格分类）有值

			if (dto.getId_pripat() == null) { // 通过id_ent查id_pripat
				if (dto.getId_ent() == null) {
					throw new BizException("没有设置患者就诊和价格分类。就诊ID:" + dto.getId_ent());
				}
//				if (!id_entLst.contains(dto.getId_ent())) {
//					id_entLst.add(dto.getId_ent());
//				}
				List<PatiVisitDO> PatiVisitDOL = (List<PatiVisitDO>) dafacade.findByCond(PatiVisitDO.class, " id_ent='" + dto.getId_ent() + "'", fields);
				if (PatiVisitDOL != null) {
					dto.setId_pripat(PatiVisitDOL.toArray(new PatiVisitDO[0])[0].getId_pripat());
				} else {
					throw new BizException("没有找到患者就诊记录。就诊ID:" + dto.getId_ent());
				}
			}

			// 2.4.计价
			if ((dto.getFg_mm() == null || !dto.getFg_mm().booleanValue())) {
				// 2.4.1
				// 非物品计价是参与患者价格分类的 物品类的不参与患者价格分类
				/*priStdSrvDTO = new PriStdSrvDTO();
				priStdSrvDTO.setId_srv(dto.getId_srv());
				SrvPricalRateAndPriceDTO[] srvPricalRateAndPriceDTOArr = pcService.CalManySrvsPriceMapByIdPripat(new PriStdSrvDTO[] { priStdSrvDTO }, dto.getId_pripat());
				*/
				String key = dto.getId_srv() + dto.getId_pripat();
				BdPriViewDTO priDto = priMap.get(key);
				
				// 写入 组装DTO数据 中
				if (priDto != null) {
					// 价格比例与标准单价
					FDouble ratio = null, price_std = null;
					price_ratio = FDouble.ZERO_DBL;
					// 判断是否是医嘱开单时价格来计价 2018年1月15日14:23:43 yang.lu
					if (prtps == BlParamValueConst.BLSTOEP0016_WHENORDER && orsrvMap.get(dto.getId_orsrv()) != null) {
						OrdSrvDO srvDO = orsrvMap.get(dto.getId_orsrv());
						if (srvDO != null ) {
							ratio = srvDO.getPri_ratio();
							price_std = srvDO.getPri_std();
							price_ratio = srvDO.getPri();
						}
					}

					if (ratio == null || price_std == null) {

						ratio = priDto.getRate();
						price_std = priDto.getPrice_std();
						// 折扣价格=标准单价*比例 取4位小数
						price_ratio = priDto.getPrice_ratio();
					}

					if( MedSrvBlModeEnum.MANUALBL.toString().equals(dto.getEu_blmd())){//手工计价
						dto.setRatio_pripat(FDouble.ONE_DBL);
						if(dto.getPrice()==null){
							dto.setPrice(FDouble.ZERO_DBL);
						}
						if(dto.getPrice_ratio()==null){
							dto.setPrice_ratio(FDouble.ZERO_DBL);
						}	
						amt_std = dto.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
						// 折扣金额=折扣单价*数量 取2位小数
						amt = dto.getPrice_ratio().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
						
					}else{//自动计价
						dto.setRatio_pripat(ratio);
						dto.setPrice(price_std);
						dto.setPrice_ratio(price_ratio);
						amt_std = price_std.multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
						// 折扣金额=折扣单价*数量 取2位小数
						amt = price_ratio.multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
						
					}
					dto.setAmt_std(amt_std);
					// 折扣金额
					dto.setAmt_ratio(amt);
					dto.setAmt_pat(amt);
					dto.setAmt(amt);
					dto.setAmt_hp(new FDouble(0));

					if (dto.getOutpBillDTO() != null) {
						BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
						outpBillDTO.setFg_acc(dto.getOutpBillDTO().getFg_acc());
						outpBillDTO.setFg_hpcg(dto.getOutpBillDTO().getFg_hpcg());
						outpBillDTO.setAmt_acc(amt);
						dto.setOutpBillDTO(outpBillDTO);
					}
				}
				/*IncCaItmDO incCaItmDO = getInccaitmCodeAndName(dto.getCode_enttp(), dto.getId_srv());

				if (incCaItmDO != null) {
					dto.setName_inccaitm(incCaItmDO.getName());
					dto.setCode_inccaitm(incCaItmDO.getCode());
				}*/
				newBlOrderAppendBillParamDTO.add(dto);
			} else // 2.4.2物品计价
			{
				if(FBoolean.TRUE.equals(dto.getFg_or())){
					// 物品计价分为调用预留和不调用预留两种
					if (dto.getFg_reserveMaterials() != null && dto.getFg_reserveMaterials().booleanValue()) // 需要调用预留
					{
						List<ReserveResultDTO> temp = reserveResultDTOMap.get(dto.getId_mm() + " " + dto.getId_orsrv());
						if (temp != null && temp.size() > 0) {
							ReserveResultDTO[] mlResult = temp.toArray(new ReserveResultDTO[0]);
							for (int j = 0; j < mlResult.length; j++) {
								BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();
								ordShow = this.createDTO(dto);
								MeterialDO meterialDO = materialInfoDTOMap.get(dto.getId_mm());
								if (meterialDO != null) {
									ordShow.setApprno(meterialDO.getApprno());// 药品批准文号
									ordShow.setSpec(meterialDO.getSpec());
								}
	
								if (mlResult[j].getSd_abrd() != null) {
									ordShow.setSd_abrd(mlResult[j].getSd_abrd()); // 进口分类编码
								}
								
								// 判断是否是医嘱开单时价格来计价 2018年1月15日14:23:43 yang.lu
								setMMPrice(ordShow, prtps, orsrvMap, mlResult[j].getPrice_act().setScale(-4, BigDecimal.ROUND_HALF_UP));
	
								ordShow.setPri_ss(mlResult[j].getPrice_sale().setScale(-4, BigDecimal.ROUND_HALF_UP));
								ordShow.setOnlycode(mlResult[j].getOnlycode());
								ordShow.setCd_batch(mlResult[j].getBatch());
								ordShow.setQuan_base(mlResult[j].getQuan_base());// 数量_基本包装=换算系数*数量
								ordShow.setQuan(mlResult[j].getQuan_act());// 出库数量
								ordShow.setCode_mm(mlResult[j].getMm_code());// 物品代码
								ordShow.setAmt(ordShow.getPrice().multiply(mlResult[j].getQuan_act()).setScale(-2, BigDecimal.ROUND_HALF_UP));// 总金额
								ordShow.setAmt_std(ordShow.getPrice().multiply(mlResult[j].getQuan_act()).setScale(-2, BigDecimal.ROUND_HALF_UP));// 总金额
								ordShow.setAmt_pat(ordShow.getPrice().multiply(mlResult[j].getQuan_act()).setScale(-2, BigDecimal.ROUND_HALF_UP));// 总金额
								ordShow.setAmt_hp(new FDouble(0));
								ordShow.setAmt_ratio(ordShow.getAmt());
								ordShow.setEnt_times(dto.getEnt_times());
	
								if (dto.getOutpBillDTO() != null) {
									BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
									outpBillDTO.setFg_acc(dto.getOutpBillDTO().getFg_acc());
									outpBillDTO.setFg_hpcg(dto.getOutpBillDTO().getFg_hpcg());
									outpBillDTO.setAmt_acc(ordShow.getAmt());
									ordShow.setOutpBillDTO(outpBillDTO);
								}
								newBlOrderAppendBillParamDTO.add(ordShow);
							}
						}
					} else // 不需要调用预留
					{
	//					GetStockReqDTO getStockReqDTO = new GetStockReqDTO();
	//					getStockReqDTO.setId_mm(dto.getId_mm());
	//					getStockReqDTO.setReq_unit_id(dto.getPgku_cur());
	//					MaterialStockDTO[] materialStockDTOs = mlService.getMaterialStocks(new GetStockReqDTO[] { getStockReqDTO });
	//					if (materialStockDTOs[0] != null) {
						String sKey=dto.getId_orsrv();
						if(materialPriMap.containsKey(sKey)){	
							BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();
							ordShow = this.createDTO(dto);
							meterialDOs = iMeterialService.findMaterialByIDS(new String[] { dto.getId_mm() });
							if (meterialDOs != null) {
								ordShow.setApprno(meterialDOs[0].getApprno());// 药品批准文号
								ordShow.setSpec(meterialDOs[0].getSpec());
								ordShow.setSd_abrd(meterialDOs[0].getSd_abrd());
							}
							// 判断是否是医嘱开单时价格来计价 2018年1月15日14:23:43 yang.lu
							//setMMPrice(ordShow, prtps, orsrvMap, materialStockDTOs[0].getPrice_act().setScale(-4, BigDecimal.ROUND_HALF_UP));
							setMMPrice(ordShow, prtps, orsrvMap, materialPriMap.get(sKey).setScale(-4, BigDecimal.ROUND_HALF_UP));
							
							ordShow.setQuan(dto.getQuan());// 数量
							ordShow.setAmt(ordShow.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));// 总金额
							ordShow.setAmt_std(ordShow.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));// 总金额
							ordShow.setAmt_pat(ordShow.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP));// 总金额
							ordShow.setAmt_hp(new FDouble(0));
							ordShow.setAmt_ratio(ordShow.getAmt());
							ordShow.setEnt_times(dto.getEnt_times());
							if (dto.getOutpBillDTO() != null) {
	
								BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
								outpBillDTO.setFg_acc(dto.getOutpBillDTO().getFg_acc());
								outpBillDTO.setFg_hpcg(dto.getOutpBillDTO().getFg_hpcg());
								outpBillDTO.setAmt_acc(ordShow.getAmt());
								ordShow.setOutpBillDTO(outpBillDTO);
							}
							newBlOrderAppendBillParamDTO.add(ordShow);
						}
					}
				}else{
					GetMaterialPriceDTO otMMPriceRlt = meterialInfoService.MaterialPriceForOt(dto.getId_mm(),dto.getPgku_cur());
					if(otMMPriceRlt != null){
						dto.setPrice(otMMPriceRlt.getPrice_act());
						dto.setPrice_ratio(otMMPriceRlt.getPrice_act());
						dto.setRatio_pripat(FDouble.ONE_DBL);
						FDouble amtMM = dto.getPrice().multiply(dto.getQuan()).setScale(-2, BigDecimal.ROUND_HALF_UP);
						dto.setAmt_std(amtMM);
						dto.setAmt_ratio(amtMM);
						dto.setAmt_pat(amtMM);
						dto.setAmt(amtMM);
						dto.setAmt_hp(new FDouble(0));
					}
					newBlOrderAppendBillParamDTO.add(dto);
				}
			}
		}
		
		//组合计价重新计算折扣率  ly 2019/09/23
		Set<String> srvIdSet = new HashSet<String>();
		for (BlOrderAppendBillParamDTO dto : newBlOrderAppendBillParamDTO) {
			
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
					for (BlOrderAppendBillParamDTO cgDto : newBlOrderAppendBillParamDTO) {
						
						if (cgDto.getOutpBillDTO() != null)
							continue;
						
						if(FBoolean.TRUE.equals(cgDto.getFg_mm()))
							continue;
						
						if (!StringUtil.isEmpty(cgDto.getId_orsrv()) && prtps == BlParamValueConst.BLSTOEP0016_WHENORDER)
							continue;
						
						if(compDto.getId_srv().equals(cgDto.getId_srv_or()) && 
								compDto.getId_srv_bl().equals(cgDto.getId_srv())){
							//重新计算折扣价
							cgDto.setRatio_pripat(cgDto.getRatio_pripat().multiply(compDto.getRatio()));
							cgDto.setPrice_ratio(cgDto.getPrice_ratio().multiply(cgDto.getRatio_pripat(),IBlConst.PRECISION_PRICE));
							cgDto.setAmt_ratio(cgDto.getPrice_ratio().multiply(cgDto.getQuan(),IBlConst.PRECISION_AMOUNT));
							cgDto.setAmt_pat(cgDto.getAmt_ratio());
							cgDto.setAmt(cgDto.getAmt_ratio());
							break;
						}
					}
				}
			}
		}
		
		return newBlOrderAppendBillParamDTO;
	}

	/**
	 * 设置物品计价金额
	 * 
	 * @param ordShow
	 * @param prtps
	 * @param orsrvMap
	 * @param mmPri
	 */
	private void setMMPrice(BlOrderAppendBillParamDTO ordShow, String prtps, Map<String, OrdSrvDO> orsrvMap, FDouble mmPri) {
		FDouble price_ratio = null, price_std = null;
		
		//医嘱开单计价，不处理物品
		
//		// 判断是否是医嘱开单时价格来计价 2018年1月15日14:23:43 yang.lu
//		if (prtps == BlParamValueConst.BLSTOEP0016_WHENORDER && orsrvMap.get(ordShow.getId_orsrv()) != null) {
//			OrdSrvDO srvDO = orsrvMap.get(ordShow.getId_orsrv());
//			if (srvDO != null) {
//				price_std = srvDO.getPri_std();
//				price_ratio = srvDO.getPri();
//			}
//		}

//		if (price_ratio == null || price_std == null) {
			price_ratio = mmPri;
			price_std = mmPri;
//		}

		ordShow.setPrice_ratio(price_ratio);
		ordShow.setPrice(price_std);
	}

	/**
	 * 创建BlOrderAppendBillParamDTO的公共字段
	 * 
	 * @param dto
	 * @return
	 */
	private BlOrderAppendBillParamDTO createDTO(BlOrderAppendBillParamDTO dto) throws BizException {

		BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();

		BlOrderAppendIncParamDTO blOrderAppendIncParamDTO = new BlOrderAppendIncParamDTO();
		blOrderAppendIncParamDTO = dto.getIncBillDTO();

		IncCaItmDO incCaItmDO = getInccaitmCodeAndName(dto.getCode_enttp(), dto.getId_srv());
		if (incCaItmDO != null) {
			ordShow.setName_inccaitm(incCaItmDO.getName());
			ordShow.setCode_inccaitm(incCaItmDO.getCode());
		}
		ordShow.setCode_apply(dto.getCode_apply());
		ordShow.setCode_applytp(dto.getCode_applytp());
		ordShow.setEu_direct(dto.getEu_direct());
		ordShow.setEu_srctp(dto.getEu_srctp());
		ordShow.setIncBillDTO(blOrderAppendIncParamDTO);
		ordShow.setId_org(dto.getId_org());
		ordShow.setId_org_mp(dto.getId_org_mp());
		ordShow.setId_hp(dto.getId_hp());
		ordShow.setId_hpsrvtp(dto.getId_hpsrvtp());
		ordShow.setSd_hpsrvtp(dto.getSd_hpsrvtp());
		ordShow.setId_org_or(dto.getId_org_or());
		ordShow.setId_dep_mp(dto.getId_dep_mp());
		ordShow.setId_dep_or(dto.getId_dep_or());
		ordShow.setId_emp_or(dto.getId_emp_or());
		ordShow.setId_emp_cg(dto.getId_emp_cg());
		ordShow.setId_dep_wh(dto.getId_dep_wh());
		ordShow.setId_ent(dto.getId_ent());
		ordShow.setId_grp(dto.getId_grp());
		ordShow.setId_mm(dto.getId_mm());
		ordShow.setId_pat(dto.getId_pat());
		ordShow.setId_srv(dto.getId_srv());
		ordShow.setCode_srv(dto.getCode_srv());
		ordShow.setId_srvca(dto.getId_srvca());
		ordShow.setSd_srvtp(dto.getSd_srvtp());
		ordShow.setId_srvtp(dto.getId_srvtp());
		ordShow.setCode_enttp(dto.getCode_enttp());
		ordShow.setId_enttp(dto.getId_enttp());
		ordShow.setId_pres(dto.getId_pres());
		ordShow.setId_pripat(dto.getId_pripat());
		ordShow.setId_pres(dto.getId_pres());
		ordShow.setSrvu(dto.getSrvu());
		ordShow.setSupportAppendBill(dto.getSupportAppendBill());
		ordShow.setDt_last_bl(dto.getDt_last_bl());
		ordShow.setCode_st(dto.getCode_st());
		// 物品特性
		ordShow.setFg_mm(dto.getFg_mm());
		ordShow.setId_mmtp(dto.getId_mmtp()); // 物品类型ID？？？
		ordShow.setSd_mmtp(dto.getSd_mmtp()); // 物品类型编码 ？？？
		ordShow.setCode_mm(dto.getCode_mm()); // 物品编码？？？
		ordShow.setName_mm(dto.getName_mm()); // 物品名称 ？？？
		ordShow.setPgku_cur(dto.getPgku_cur()); // 物品包装单位_当前
		ordShow.setFactor(dto.getFactor());
		ordShow.setPgku_base(dto.getPgku_base());// 物品包装单位_基本
		ordShow.setQuan_base(dto.getQuan_base());
		if (dto.getFg_Cgoep() != null && dto.getFg_Cgoep().booleanValue()) {
			ordShow.setFg_Cgoep(dto.getFg_Cgoep());
		} else {
			ordShow.setFg_Cgoep(FBoolean.FALSE);
		}
		ordShow.setFg_st(FBoolean.FALSE);
		ordShow.setId_or(dto.getId_or());
		ordShow.setId_orsrv(dto.getId_orsrv());
		ordShow.setName_srv(dto.getName_srv());
		ordShow.setDt_or(dto.getDt_or());
		ordShow.setCi_sv(dto.getCi_sv());
		ordShow.setSrcfunc_des(dto.getSrcfunc_des());
		ordShow.setPresrption_name(dto.getPresrption_name());
		ordShow.setFg_pricinginsertcg(dto.getFg_pricinginsertcg());
		ordShow.setFg_selfPay(dto.getFg_selfPay());
		ordShow.setIndicitemid(dto.getIndicitemid());
		ordShow.setHiname(dto.getHiname());
		return ordShow;

	}

	/**
	 * 计算每条DTO的费用
	 * 
	 * @param appendBillParamDTO
	 * @return List<BlOrderAppendBillParamDTO>格式的费用明细
	 * @throws BizException
	 */
	public List<BlOrderAppendBillParamDTO> SetBlOrderAppendBillParamDTOPricing_list(BlOrderAppendBillParamDTO[] appendBillParamDTO) throws BizException {
		return SetBlOrderAppendBillParamDTOPricing_bp(appendBillParamDTO);
	}

}
