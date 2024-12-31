package iih.bl.itf.std.bp.opcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlImplicitParamKeyConst;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamOpCostBillNew;
import iih.bl.itf.std.bean.input.charge.sub.WsParamCgItm;
import iih.bl.itf.std.bean.input.charge.sub.WsParamOrderItem;
import iih.bl.itf.std.bean.output.WsResultMsgInfo;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
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
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 门诊补退费新(可循环记账)
 * 
 * @author shaokx
 * @date 2019.10.24
 */
public class SetOpCostBillNewBP extends BlItfBaseBP<WsParamOpCostBillNew, WsResultMsgInfo>{

	public static final String FG_SUCESS = "0"; // 成功
	public static final String FG_FAIL = "1"; // 失败
	
	@Override
	protected String getBusiness() {
		// TODO Auto-generated method stub
		return "门诊补退费";
	}

	@Override
	protected void checkParam(WsParamOpCostBillNew param) throws BizException {
		
		if (param == null) {
			throw new BizException("入参数据为空");
		}
		
		List<WsParamOrderItem> orderItems = param.getOrderItem();
		
		if(ListUtil.isEmpty(orderItems)){
			throw new BizException("入参明细为空");
		}
		
		for (WsParamOrderItem WsParamOrderItem : orderItems) {
			if (StringUtil.isEmpty(WsParamOrderItem.getPatCode())) {
				throw new BizException("患者编码为空");
			}

			if (StringUtil.isEmpty(WsParamOrderItem.getMpDepCode())) {
				throw new BizException("执行科室为空");
			}

			if (StringUtil.isEmpty(WsParamOrderItem.getDirectFlag())) {
				throw new BizException("补退费方向为空");
			}
			
			if (!"1".equals(WsParamOrderItem.getDirectFlag()) && !"-1".equals(WsParamOrderItem.getDirectFlag())) {
				throw new BizException("补退费方向值不正确");
			}
			
			List<WsParamCgItm> cgItems = WsParamOrderItem.getChargeItem();
			
			if(ListUtil.isEmpty(cgItems)){
				throw new BizException("入参记账明细为空");
			}
			
			for (WsParamCgItm itm : cgItems) {
				if (!StringUtil.isEmpty(itm.getMmCode())) {
					throw new BizException("门诊不允许补药品");// 因为门诊补药品时，需要传入id_orsrv，而这个字段通过接口没法获取
				}

				if (StringUtil.isEmpty(itm.getChargeCode())) {
					throw new BizException("入参记账明细服务编码为空");
				}

				if (StringUtil.isEmpty(itm.getQuan())) {
					throw new BizException("入参记账明细数量为空");
				}

				if (new FDouble(itm.getQuan()).compareTo(new FDouble().ZERO_DBL) <= 0) {
					throw new BizException("入参记账明细数量不能小于等于0");
				}

				if (StringUtil.isEmpty(itm.getPrice())) {
					throw new BizException("入参记账明细单价为空");
				}

				if (StringUtil.isEmpty(itm.getCgPrice())) {
					throw new BizException("入参记账明细金额为空");
				}
			}
			
			if (!StringUtil.isEmpty(WsParamOrderItem.getOperaOR())) {
				// 设置人员上下文
				PsnDocDO psndocDO = super.getPsnInfo(WsParamOrderItem.getOperaOR());
				if (psndocDO == null) {
					throw new BizException("退补费:未查询到开立人员信息");
				}
				Context.get().setStuffId(psndocDO.getId_psndoc());
			}

			if (!StringUtil.isEmpty(WsParamOrderItem.getOperaCG())) {
				// 设置人员上下文
				PsnDocDO psndocDO = super.getPsnInfo(WsParamOrderItem.getOperaCG());
				if (psndocDO == null) {
					throw new BizException("退补费:未查询到记账人员信息");
				}
				Context.get().setStuffId(psndocDO.getId_psndoc());
			}
			
		}
		
	}

	@Override
	protected WsResultMsgInfo doWork(WsParamOpCostBillNew param) throws BizException {
		
		WsResultMsgInfo rltMsg = new WsResultMsgInfo();
		
		List<WsParamOrderItem> orderItem = param.getOrderItem();
		WsParamOrderItem[] params = orderItem.toArray(new WsParamOrderItem[] {});
		// 3 .退补费
		this.setOrderFee(params);
		
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("操作成功");
		
		return rltMsg;
	}
	
	/**
	 * 医嘱id
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OrdSrvDO initOr(WsParamOrderItem params) throws BizException {
		DAFacade daFacade = new DAFacade();
		if (!StringUtil.isEmpty(params.getCodeApply())) {
			StringBuilder sql = new StringBuilder();
			sql.append(
					" select ci.id_or ,srv.id_orsrv from ci_order ci inner join ci_or_srv srv  on ci.id_or = srv.id_or where ci.code_or =   ? ");
			SqlParam sqlp = new SqlParam();
			sqlp.addParam(params.getCodeApply());
			List<OrdSrvDO> ListCi = (List<OrdSrvDO>) daFacade.execQuery(sql.toString(), sqlp,
					new BeanListHandler(OrdSrvDO.class));
			if (!ListUtil.isEmpty(ListCi)) {
				return ListCi.get(0);
			}
		}
		return null;

	}

	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamOrderItem param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getPatCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}
	
	/**
	 * 根据患者编码和住院次数查患者就诊信息
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO initPatiVisitInfo(WsParamOrderItem params,String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ent.id_ent,ent.id_pat from  ");
		sql.append(" en_ent ent ");
		sql.append(" inner join en_ent_op entop on ent.id_ent = entop.id_ent ");
		sql.append(" where 1=1 ");
		sql.append(" and ent.id_pat = ? ");
		sql.append(" and entop.times_op = ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(patId);
		if(!StringUtil.isEmpty(params.getTimesOP())){
			param.addParam(params.getTimesOP());
		}else{
			// 查询这个患者当前的就诊次数
			String timesOp = this.getTimesOp(patId);
			param.addParam(timesOp);
		}
		
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PatiVisitDO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据患者id查询到患者当前的就诊次数(门诊)
	 * 
	 * @return
	 * @throws DAException
	 */
	private String getTimesOp(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select entop.times_op ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_op entop ");
		sql.append(" on ent.id_ent = entop.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" order by entop.times_op desc ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		@SuppressWarnings("unchecked")
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(OutpatientDO.class));

		if (ListUtil.isEmpty(list)) {
			return "0";
		}
		return list.get(0).getTimes_op().toString();
	}
	
	/**
	 * 门诊补退费
	 * 
	 * @param rtn
	 * @throws BizException
	 */
	private void setOrderFee(WsParamOrderItem[] params) throws BizException {
		// 获取科室信息列表 code,id
		Map<String, String> mapDep = getMapDep(params);
		// 获取人员信息列表 code,id
		Map<String, PsnDocDO> mapPsn = getMapPsn(params);
		// 循环最外层 以每一个患者为维度
		for (WsParamOrderItem cgDto : params) {
				
			// 获取服务信息
			MedSrvDO[] medSrvDOs = this.initMedSvrInfo(cgDto);
			// 记账数据集合
			List<BlCgAccountDTO> listAccount = new ArrayList<BlCgAccountDTO>();
			// 退记账数据集合
			List<BlCgRefundAccountDTO> listRefend = new ArrayList<BlCgRefundAccountDTO>();
			// 查询医嘱服务信息
			OrdSrvDO ciorderdo = initOr(cgDto);
			// 记账方向
			// Integer directflag = this.getDirectFlag(cgDto);
			// 查询患者信息
			String patId = this.findPat(cgDto);
			PatiVisitDO entDO = this.initPatiVisitInfo(cgDto,patId);

			if (medSrvDOs != null) {
				// 循环服务信息集合
				for (MedSrvDO medSrvDO : medSrvDOs) {
					// 查询费用明细内容
					WsParamCgItm itemParamDTO = this.getBlCostAddItemParamDTO(cgDto, medSrvDO);

					MeterialDO meterialDO = null;
					if (!StringUtil.isEmpty(itemParamDTO.getMmCode())) {
						IMeterialMDORService mSerivce = ServiceFinder.find(IMeterialMDORService.class);//
						MeterialDO[] tmpDOs = mSerivce.findByAttrValString(MeterialDO.CODE, itemParamDTO.getMmCode());
						if (!ArrayUtil.isEmpty(tmpDOs)) {
							meterialDO = tmpDOs[0];
							IMaterialBaseInfoService mbaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
							GetMaterialPriceDTO mmPriceDTO = mbaseService.MaterialPriceForOt(meterialDO.getId_mm(),
									meterialDO.getId_unit_pkgbase());
							if (mmPriceDTO != null && mmPriceDTO.getPrice_act() != null) {
								if (mmPriceDTO.getPrice_act().compareTo(new FDouble(itemParamDTO.getPrice())) != 0) {
									StringBuilder sqlStrBuf = new StringBuilder();
									sqlStrBuf.append("门诊补费：物品编码为[");
									sqlStrBuf.append(itemParamDTO.getMmCode());
									sqlStrBuf.append("]的补费价格(");
									sqlStrBuf.append(new FDouble(itemParamDTO.getPrice()));
									sqlStrBuf.append(")和IIH计算的价格(");
									sqlStrBuf.append(mmPriceDTO.getPrice_act());
									sqlStrBuf.append(")有差异！");
									throw new BizException(sqlStrBuf.toString());
								}
							}
						}
					}

					// 筛选、组装记账信息
					if ("1".equals(cgDto.getDirectFlag())) {
						BlCgAccountDTO cgAccountDto = this.getBlcgAccount(patId,entDO, ciorderdo, medSrvDO, cgDto,
								itemParamDTO, mapDep, mapPsn, meterialDO);
						
						//体检流水号赋值
						if(!StringUtil.isEmpty(cgDto.getPeCode())){
							cgAccountDto.setAttrVal(IBlImplicitParamKeyConst.BL_PECODE, cgDto.getPeCode());
						}
						
						listAccount.add(cgAccountDto);
					} else if ("-1".equals(cgDto.getDirectFlag())) {
						listRefend = this.getBlCgRefundAccountDTO(patId,entDO, ciorderdo, medSrvDO, params, itemParamDTO,
								meterialDO, listRefend);
					}
				}
				// 调用记账新接口
				IBlCgAccountService iblCgAccount = ServiceFinder.find(IBlCgAccountService.class);
				// 如果等于收费
				if ("1".equals(cgDto.getDirectFlag())) {
					// 记账 配置
					BlCgOpAccountSetDTO accSetDto = this.setCgAccoutnSetDto(cgDto, mapDep, mapPsn);
					BlCgAccountRltDTO keepAccountForOp = iblCgAccount
							.keepAccountForOp(listAccount.toArray(new BlCgAccountDTO[] {}), accSetDto);
					// 如果不成功
					if (!keepAccountForOp.getFg_success().booleanValue()) {
						throw new BizException(keepAccountForOp.getErr_msg());
					}
					// 调用退记账接口
				} else if ("-1".equals(cgDto.getDirectFlag())) {
					// 退记账配置
					BlCgRefundAccountSetDTO refundDto = this.setCgRefundAccoutnSetDto(cgDto, mapDep, mapPsn);
					BlCgAccountRltDTO refundAccountForOp = iblCgAccount
							.refundAccountForOp(listRefend.toArray(new BlCgRefundAccountDTO[] {}), refundDto);
					if (!refundAccountForOp.getFg_success().booleanValue()) {
						throw new BizException(refundAccountForOp.getErr_msg());
					}
				}
			}

		}
	}

	/**
	 * 组装退记账配置
	 * 
	 * @param cgDto
	 * @param mapDep
	 * @param mapPsn
	 * @return
	 */
	private BlCgRefundAccountSetDTO setCgRefundAccoutnSetDto(WsParamOrderItem cgDto, Map<String, String> mapDep,
			Map<String, PsnDocDO> mapPsn) {
		BlCgRefundAccountSetDTO accSetDto = new BlCgRefundAccountSetDTO();
		accSetDto.setEu_rfdmode(RefundModeEnum.CG_KEY);
		// 记账人员
		if (!StringUtil.isEmpty(cgDto.getOperaCG())) {
			accSetDto.setId_emp_cg(mapPsn.get(cgDto.getOperaCG()).getId_psndoc());
		}
		if (!StringUtil.isEmpty(cgDto.getMpDepCode())) {
			// 记账部门 执行部门
			accSetDto.setId_dep_cg(mapDep.get(cgDto.getMpDepCode()));
		}
		if (!StringUtil.isEmpty(cgDto.getOperaTime())) {
			// 记账时间
			accSetDto.setDt_cg(new FDateTime(cgDto.getOperaTime()));
		}
		if (!StringUtil.isEmpty(cgDto.getSourceDesc())) {
			// 来源备注
			accSetDto.setSrcfunc_des(cgDto.getSourceDesc());
		}
		// 拋異常
		accSetDto.setFg_exception(FBoolean.TRUE);
		accSetDto.setFg_updateor(FBoolean.FALSE);
		return accSetDto;
	}

	/**
	 * 组装退记账明细数据
	 * 
	 * @param piPatDO
	 * @param ciorderdo
	 * @param medSrvDO
	 * @param params
	 * @param itemParamDTO
	 * @return
	 * @throws BizException
	 */
	private List<BlCgRefundAccountDTO> getBlCgRefundAccountDTO(String patId,PatiVisitDO entDO, OrdSrvDO ciorderdo, MedSrvDO medSrvDO,
			WsParamOrderItem[] params, WsParamCgItm itemParamDTO, MeterialDO meterialDO, List<BlCgRefundAccountDTO> listRefend)
			throws BizException {

		DAFacade daFacade = new DAFacade();
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" select itmoep.id_cgitmoep, itmoep.quan, itmoep.id_pat, itmoep.id_ent  ");
		whereStr.append(" from bl_cg_itm_oep itmoep ");
		whereStr.append(" inner join bl_cg_oep oep on itmoep.id_cgoep = oep.id_cgoep ");
		whereStr.append(" where itmoep.id_pat ='" + patId + "'");
		whereStr.append(" and  itmoep.id_srv ='" + medSrvDO.getId_srv() + "'");
		whereStr.append(" and  itmoep.price ='" + itemParamDTO.getPrice() + "'");
		if (ciorderdo != null) {
			whereStr.append(" and itmoep.id_or ='" + ciorderdo.getId_or() + "'");
			// whereStr.append(" and itmoep.id_orsrv ='" +
			// ciorderdo.getId_orsrv() + "'");
		}

		if (meterialDO != null) {
			whereStr.append(" and itmoep.id_mm ='" + meterialDO.getId_mm() + "'");
		}
		whereStr.append(
				" and  itmoep.fg_refund = 'N' and oep.eu_direct = 1 and  itmoep.fg_susp = 'N' and itmoep.fg_st='N'  ");
		whereStr.append(" order by  oep.dt_cg desc ");
		// sqlp1.addParam(timesIp);
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> listItmOep = (List<BlCgItmOepDO>) daFacade.execQuery(whereStr.toString(), null,
				new BeanListHandler(BlCgItmOepDO.class));

		if (ListUtil.isEmpty(listItmOep)) {
			throw new BizException("服务编码 " + itemParamDTO.getChargeCode() + "无可退费的数据");
		}

		FDouble canrnt = FDouble.ZERO_DBL;
		// 循环所有记账明细
		for (BlCgItmOepDO cgItmOepDo : listItmOep) {
			canrnt = canrnt.add(cgItmOepDo.getQuan());
		}

		// 组装可退费的记账信息
		FDouble itfQuan = new FDouble(itemParamDTO.getQuan());
		if (canrnt.sub(itfQuan).compareTo(FDouble.ZERO_DBL) < 0) {
			throw new BizException("服务编码 " + itemParamDTO.getChargeCode() + "可退数量小于退费数量");
		}
		for (BlCgItmOepDO cgItmOepDo : listItmOep) {
			BlCgRefundAccountDTO cgRefundDTO = new BlCgRefundAccountDTO();
			cgRefundDTO.setId_cg(cgItmOepDo.getId_cgitmoep());
			cgRefundDTO.setId_pat(cgItmOepDo.getId_pat());
			cgRefundDTO.setQuan(itfQuan);
			listRefend.add(cgRefundDTO);
		}
		return listRefend;

	}

	/**
	 * 组装记账明细主键和数量
	 * 
	 * @param cgItmOepDo
	 * @param itfQuan
	 * @return
	 */
	private BlCgRefundAccountDTO setBlCgRefundAccountDTO(BlCgItmOepDO cgItmOepDo, FDouble itfQuan) {
		BlCgRefundAccountDTO dto = new BlCgRefundAccountDTO();
		dto.setId_cg(cgItmOepDo.getId_cgitmoep());
		dto.setId_pat(cgItmOepDo.getId_pat());
		dto.setQuan(itfQuan);
		return dto;
	}

	/**
	 * 组装记账配置数据
	 * 
	 * @param params
	 * @param mapDep
	 * @param mapPsn
	 * @return
	 */
	private BlCgOpAccountSetDTO setCgAccoutnSetDto(WsParamOrderItem params, Map<String, String> mapDep,
			Map<String, PsnDocDO> mapPsn) {
		BlCgOpAccountSetDTO accSetDto = new BlCgOpAccountSetDTO();

		// 判断记账模式
		if (StringUtil.isEmpty(params.getAdditmFlag()) || params.getAdditmFlag().equals(FBoolean.TRUE.toString())) {
			// 记账模式 预交金记账
			accSetDto.setEu_oepcgmode(OepCgModeEnum.PREPAY_CG);
			// 是否补费
			accSetDto.setFg_addfee(FBoolean.TRUE);
		} else {
			// 记账模式 欠款记账
			accSetDto.setEu_oepcgmode(OepCgModeEnum.ARREARS_CG);
			// 是否补费
			accSetDto.setFg_addfee(FBoolean.TRUE);
		}
		// 费用来源
		accSetDto.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		// 是否计算服务价格
		accSetDto.setFg_price_cal(FBoolean.FALSE);
		// 记账人员
		if (!StringUtil.isEmpty(params.getOperaCG())) {
			accSetDto.setId_emp_cg(mapPsn.get(params.getOperaCG()).getId_psndoc());
		}
		if (!StringUtil.isEmpty(params.getMpDepCode())) {
			// 记账部门 执行部门
			accSetDto.setId_dep_cg(mapDep.get(params.getMpDepCode()));
		}
		if (!StringUtil.isEmpty(params.getOperaTime())) {
			// 记账时间
			accSetDto.setDt_cg(new FDateTime(params.getOperaTime()));
		}
		if (!StringUtil.isEmpty(params.getSourceDesc())) {
			// 来源备注
			accSetDto.setSrcfunc_des(params.getSourceDesc());
		}
		return accSetDto;

	}

	/**
	 * 组装记账数据
	 * 
	 * @param piPatDO
	 * @param ciorderdo
	 * @param medSrvDO
	 * @param params
	 * @param itemParamDTO
	 * @param mapPsn
	 * @param mapDep
	 * @return
	 */
	@SuppressWarnings("unused")
	private BlCgAccountDTO getBlcgAccount(String patId,PatiVisitDO entDO, OrdSrvDO ciorderdo, MedSrvDO medSrvDO, WsParamOrderItem cgDto,
			WsParamCgItm itemParamDTO, Map<String, String> mapDep, Map<String, PsnDocDO> mapPsn, MeterialDO meterialDO) {

		BlCgAccountDTO cgAccount = new BlCgAccountDTO();
		// 患者id
		cgAccount.setId_pat(patId);
		cgAccount.setId_ent(entDO == null ? null : entDO.getId_ent());
		// 医嘱id
		if (ciorderdo != null) {
			cgAccount.setId_or(ciorderdo.getId_or());
		    // cgAccount.setId_orsrv(ciorderdo.getId_orsrv());//感觉加的不对，先去掉
		}
		// 服务id
		cgAccount.setId_srv(medSrvDO.getId_srv());
		// 记账方向
		cgAccount.setEu_direct(BookRtnDirectEnum.CHARGE);
		// 标准价
		FDouble Price = new FDouble(itemParamDTO.getPrice());
		cgAccount.setPrice_std(Price);
		// 比例系数
		FDouble Price_ratio = new FDouble(itemParamDTO.getPriceRatio());
		if (Price_ratio != null) {
			cgAccount.setRatio_pripat(Price_ratio);
		} else {
			cgAccount.setRatio_pripat(new FDouble("1"));
		}

		// 实际价格
		FDouble Amt_ratio = new FDouble(itemParamDTO.getCgPrice());
		cgAccount.setPrice_ratio(Price.multiply(Price_ratio));
		// 数量
		FDouble dQuan = new FDouble(itemParamDTO.getQuan());
		cgAccount.setQuan(dQuan);
		// 执行科室id
		cgAccount.setId_dep_mp(mapDep.get(cgDto.getMpDepCode()));
		// 开立人员
		if(!StringUtil.isEmpty(cgDto.getOperaOR())){
			cgAccount.setId_emp_or(mapPsn.get(cgDto.getOperaOR()).getId_psndoc());
		}
		// 开立科室(如果入参传入开立科室，则取入参的，如果没传，则取开立人员所在科室作为开立科室)
		if(!StringUtil.isEmpty(cgDto.getOrDepCode())){
			cgAccount.setId_dep_or(mapDep.get(cgDto.getOrDepCode()));
		}else{
			if(!StringUtil.isEmpty(cgDto.getOperaOR())){
				cgAccount.setId_dep_or(mapPsn.get(cgDto.getOperaOR()).getId_dep());
			}
		}
		// 如果是物品，则要进行以下赋值
		if (meterialDO != null) {
			cgAccount.setFg_mm(FBoolean.TRUE); // 物品管理标识
			cgAccount.setId_mm(meterialDO.getId_mm()); // 物品
			cgAccount.setId_pkgu_cur(meterialDO.getId_unit_pkgbase()); // 物品单位
		}


	    return cgAccount;
	}

	private Integer getDirectFlag(WsParamOrderItem params) throws BizException {
		String sDirectFlag = params.getDirectFlag();

		String[] arr = { "-1", "1" };
		if (!ArrayUtils.contains(arr, sDirectFlag)) {
			throw new BizException("费用方向标识不是一个有效值！");
		}
		Integer iDirectFlag = new Integer(sDirectFlag);

		return iDirectFlag;
	}

	/**
	 * 获取科别目录列表
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, String> getMapDep(WsParamOrderItem[] params) throws BizException {
		List<String> listdep = new ArrayList<String>();
		Map<String, String> depMap = new HashMap<String, String>();
		// 获取计量单位id集合
		for (WsParamOrderItem peItfDto : params) {
			if(!StringUtil.isEmpty(peItfDto.getMpDepCode())){
				listdep.add(peItfDto.getMpDepCode());
			}
			
			if(!StringUtil.isEmpty(peItfDto.getOrDepCode())){
				listdep.add(peItfDto.getOrDepCode());
			}
			
		}
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = service.findByAttrValStrings(DeptDO.CODE, listdep.toArray(new String[] {}));
		if (!ArrayUtils.isEmpty(deptDOs)) {
			for (DeptDO deptDo : deptDOs) {
				if (depMap.get(deptDo.getId_dep()) == null) {
					depMap.put(deptDo.getCode(), deptDo.getId_dep());
				}
			}
		} else {
			throw new BizException("门诊补退费：编码为" + params[0].getMpDepCode() + "的执行科室不存在！");
		}
		return depMap;
	}

	/**
	 * 获得人员信息列表
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private Map<String, PsnDocDO> getMapPsn(WsParamOrderItem[] params) throws BizException {
		List<String> listpsn = new ArrayList<String>();
		Map<String, PsnDocDO> psnMap = new HashMap<String, PsnDocDO>();
		// 获取人员编码集合
		for (WsParamOrderItem peItfDto : params) {
			// 记账人员编码
			if(!StringUtil.isEmpty(peItfDto.getOperaCG())){
				listpsn.add(peItfDto.getOperaCG());
			}
			
			// 开立人员编码
            if(!StringUtil.isEmpty(peItfDto.getOperaOR())){
            	listpsn.add(peItfDto.getOperaOR());
			}
			
			// 执行人员编码
            if(!StringUtil.isEmpty(peItfDto.getOperaMP())){
            	listpsn.add(peItfDto.getOperaMP());
			}
			
		}
		// 人员信息服务
		IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndoc = service.findByAttrValStrings(PsnDocDO.CODE, listpsn.toArray(new String[] {}));
		if (!ArrayUtils.isEmpty(psndoc)) {
			for (PsnDocDO psn : psndoc) {
				if (psnMap.get(psn.getId_psndoc()) == null) {
					psnMap.put(psn.getCode(), psn);
				}
			}
		} else {
			throw new BizException("门诊补退费：编码为" + listpsn.toString() + "的人员编码不存在！");
		}
		return psnMap;
	}

	private WsParamCgItm getBlCostAddItemParamDTO(WsParamOrderItem params, MedSrvDO medSrvDO) {
		String chargeCode = medSrvDO.getCode();
		if (chargeCode != null) {
			for (WsParamCgItm itm : params.getChargeItem()) {
				if (chargeCode.equals(itm.getChargeCode())) {
					return itm;
				}
			}
		}
		return null;
	}

	/**
	 * 查服务编码为空的服务信息
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedSrvDO[] initMedSvrInfo(WsParamOrderItem params) throws BizException {
		FArrayList listMedSrvform = new FArrayList();
		for (WsParamCgItm itm : params.getChargeItem()) {
			if (StringUtil.isEmpty(itm.getChargeCode())) {
				if (StringUtil.isEmpty(itm.getMmCode())) {
					throw new BizException("门诊补退：物品编码为空");
				} else {
					MedSrvDO tmpMedSrvDo = this.GetMedSrvInfo(itm.getMmCode());
					itm.setChargeCode(tmpMedSrvDo.getCode());
					listMedSrvform.add(itm.getChargeCode());
				}
			} else {
				listMedSrvform.add(itm.getChargeCode());
			}
		}
		if (listMedSrvform.size() > 0) {
			// 获取医疗服务_项目
			IMedsrvMDORService srvSerivce = ServiceFinder.find(IMedsrvMDORService.class);// SRV服务
			MedSrvDO[] medsrvs = srvSerivce.findByAttrValList(MedSrvDO.CODE, listMedSrvform);

			if (medsrvs.length != listMedSrvform.size()) {
				for (MedSrvDO itm : medsrvs) {
					if (listMedSrvform.contains(itm.getCode())) {
						listMedSrvform.remove(itm.getCode());
					}
				}

				String err = "";
				for (int i = 0; i < listMedSrvform.size(); i++) {
					if (i == listMedSrvform.size() - 1) {
						err = err + (String) listMedSrvform.get(i);
					} else {
						err = err + (String) listMedSrvform.get(i) + "、";
					}
				}
				throw new BizException("门诊补费：患者编码为" + params.getPatCode() + "的服务编码" + err + "所对应的服务不存在");
			}
			return medsrvs;
		}
		return null;
	}

	/**
	 * 根据物品编码查询服务信息
	 * 
	 * @param mmCode
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO GetMedSrvInfo(String mmCode) throws BizException {
		// 获取患者本次就诊信息
		DAFacade daFacade = new DAFacade();
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append("SELECT b.id_srv, ");
		sqlStrBuf.append("  b.code ");
		sqlStrBuf.append("FROM bd_mm a ");
		sqlStrBuf.append("inner join bd_srv b on a.id_srv = b.id_srv ");
		sqlStrBuf.append("WHERE (a.code = ?) ");
		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(mmCode);
		List<MedSrvDO> tmpDTO = (List<MedSrvDO>) daFacade.execQuery(sqlStrBuf.toString(), sqlp1,
				new BeanListHandler(MedSrvDO.class));

		if (ListUtil.isEmpty(tmpDTO)) {
			throw new BizException("编码为[" + mmCode + "]的物品不存在！");
		}
		return tmpDTO.get(0);
	}

}
