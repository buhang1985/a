package iih.ci.ord.s.external.obtain.bp.bl;


import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.utils.ParamUtils;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderInParamDTO;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderOutParamDTO;
import iih.bl.pay.blcontrolciorder.d.CiOrderSrvDTO;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayCondDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.external.obtain.meta.bl.PrePaidAccAmt4CiDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @code 预交金控制 
 * @author LiYue
 */
public class GetArrearageCheckBP {

	/**
	 * @code 进行欠费提醒 WW_CIOR0005 
	 */
	private FBoolean ArrearageCheckParam(CiEnContextDTO envinfo) {
		if (envinfo!=null&&envinfo.getCode_entp()!=null&&IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(envinfo.getCode_entp())) {//预住院不需要进行欠费提醒
			return FBoolean.FALSE;
		}
		try {
			FBoolean param = ParamUtils.getOrgParamFBooleanValue(ICiOrdNSysParamConst.SYS_PARAM_WW_CIOR0005);
			return param;
		} catch (Exception ex) {
			ICiOrdLogService logService = ServiceFinder.find(ICiOrdLogService.class);
			logService.log(" 接诊患者时是否进行欠费提醒,获取参数WW_CIOR0005失败，默认不提醒" + ex.toString(), Level.INFO);
		}
		return FBoolean.FALSE;
	}

	/**
	 * @code 获取患者分类ID
	 */
	public String getIdpatCa(String id_ent) throws BizException {
		PatiVisitDO ent = ServiceFinder.find(IPativisitRService.class).findById(id_ent);
		return ent.getId_patca();
	}

	/// <summary>
	/// 开立欠费校验
	/// </summary>
	public FBoolean openCheckedArrearage(CiEnContextDTO envinfo, CiEmsDTO[] ciEmsDTOs) throws BizException {
		// 是否欠费校验
		if (FBoolean.TRUE.equals(ArrearageCheckParam(envinfo))) {
			envinfo.setPrePaidAccAmt4CiDTO(GetAccAmt4CiDto(envinfo));
			FDouble available = envinfo.getPrePaidAccAmt4CiDTO().getAmt_available();// 可用余额
			FDouble allControl = envinfo.getPrePaidAccAmt4CiDTO().getAllControl();// 完全控制
			FDouble someControl = envinfo.getPrePaidAccAmt4CiDTO().getSomeControl();// 部分控制
			
			//当前科室没有配置预交金策略时，应按不限制处理:0184137 
			if(allControl== null || someControl== null)
				return FBoolean.TRUE;
			// 【可用余额】 <= 【完全控制警戒金额】
			if (available.compareTo(allControl) <= 0) {
				throw new BizRuntimeException("当前费用不足以开立本次医嘱!");
			}
			// 【完全控制警戒金额】 <= 【可用余额】 < 【部分控制警戒金额】
			else if (allControl.compareTo(available) <= 0 && available.compareTo(someControl) <= 0) {
				return SomeControlOrd(ciEmsDTOs, envinfo);
			}
		}
		return FBoolean.TRUE;
	}
		/// <summary>
		/// 开立欠费校验
		/// </summary>
		public FBoolean openCheckedArrearage(CiEnContextDTO envinfo, CiOrderDO[] ciEmsDTOs) throws BizException {
			// 是否欠费校验
			if (FBoolean.TRUE.equals(ArrearageCheckParam(envinfo))) {
				envinfo.setPrePaidAccAmt4CiDTO(GetAccAmt4CiDto(envinfo));
				FDouble available = envinfo.getPrePaidAccAmt4CiDTO().getAmt_available();// 可用余额
				FDouble allControl = envinfo.getPrePaidAccAmt4CiDTO().getAllControl();// 完全控制
				FDouble someControl = envinfo.getPrePaidAccAmt4CiDTO().getSomeControl();// 部分控制
				
				//当前科室没有配置预交金策略时，应按不限制处理:0184137 
				if(allControl== null || someControl== null)
					return FBoolean.TRUE;
				// 【可用余额】 <= 【完全控制警戒金额】
				if (available.compareTo(allControl) <= 0) {
					throw new BizRuntimeException("当前费用不足以开立本次医嘱!");
				}
				// 【完全控制警戒金额】 <= 【可用余额】 < 【部分控制警戒金额】
				else if (allControl.compareTo(available) <= 0 && available.compareTo(someControl) <= 0) {
					return SomeControlOrd(ciEmsDTOs, envinfo);
				}
			}
			return FBoolean.TRUE;
		}
	/**
	 * @code 调用费用是否欠费接口 
	 * @author LiYue
	 */
	public PrePaidAccAmt4CiDTO GetAccAmt4CiDto(CiEnContextDTO envinfo) throws BizException {
		BlPrepayCondDTO blPrepayCondDto = new BlPrepayCondDTO();
		blPrepayCondDto.setCode_entp(envinfo.getCode_entp());
		blPrepayCondDto.setId_ent(envinfo.getId_en());
		blPrepayCondDto.setId_pat(envinfo.getId_pat());
		blPrepayCondDto.setId_patca(getIdpatCa(envinfo.getId_en()));
		PrePaidAccAmtDTO accAmtDto =null;
		// 住院和急诊留观调用不同的欠费接口 liyuelong 2020/1/17
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(envinfo.getCode_entp())){//住院医生站
			accAmtDto = ServiceFinder.find(IBlPayOutQryService.class).getAccJudge(blPrepayCondDto);
		}else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(envinfo.getCode_entp())){//急诊留观医生站
			accAmtDto=ServiceFinder.find(IBlPayOutQryService.class).getETAccJudge(envinfo.getCode_entp(),envinfo.getId_en(),envinfo.getId_pat(),getIdpatCa(envinfo.getId_en()));
		}
		PrePaidAccAmt4CiDTO CiaccAmtDto = new PrePaidAccAmt4CiDTO();
		CiaccAmtDto.setFg_arrears(accAmtDto.getFg_arrears());
		CiaccAmtDto.setSd_arslv(accAmtDto.getSd_arslv());
		CiaccAmtDto.setAmt_limit(accAmtDto.getAmt_limit());
		CiaccAmtDto.setAmt_available(accAmtDto.getAmt_available());
		CiaccAmtDto.setSd_prewarntp(accAmtDto.getSd_prewarntp());
		CiaccAmtDto.setAmt_prepay(accAmtDto.getAmt_prepay());
		CiaccAmtDto.setAmt_bal(accAmtDto.getAmt_bal());
		if (accAmtDto.getBalancedtos() != null && accAmtDto.getBalancedtos().size() > 0) {
			BalanceDTO[] balanceDTOs = (BalanceDTO[]) accAmtDto.getBalancedtos()
					.toArray(new BalanceDTO[accAmtDto.getBalancedtos().size()]);
			CiaccAmtDto.setAmt_uncg(balanceDTOs[0].getAmt_uncg());
		}
		// 费用预交金管理策略计算
		getControlInfo(accAmtDto, CiaccAmtDto);
		return CiaccAmtDto;
	}

	/**
	 * @code 获取对应的控制金额   
	 * @author LiYue
	 */
	public void getControlInfo(PrePaidAccAmtDTO blAccAmtDto, PrePaidAccAmt4CiDTO ciAccAmt4CiDto) {
		if (blAccAmtDto.getPrewarns() != null && blAccAmtDto.getPrewarns().size() > 0) {
			BdPreWarnDO bdPreWarnDO = ((BdPreWarnDO[]) blAccAmtDto.getPrewarns()
					.toArray(new BdPreWarnDO[blAccAmtDto.getPrewarns().size()]))[0];
			ciAccAmt4CiDto.setAllControl(bdPreWarnDO.getF_control());
			ciAccAmt4CiDto.setSomeControl(bdPreWarnDO.getP_control());
			ciAccAmt4CiDto.setPrompt(bdPreWarnDO.getLimit());
		} 
	}

	/**
	 * @code 部分医嘱限制开立逻辑
	 *  @author LiYue
	 */
	private FBoolean SomeControlOrd(CiEmsDTO[] ciEmsDTOs, CiEnContextDTO envinfo) throws BizException {
		ArrearsControlOrderInParamDTO orderInParamDTO = new ArrearsControlOrderInParamDTO();
		orderInParamDTO.setId_ent(envinfo.getId_en());
		CiOrderSrvDTO srvdto = new CiOrderSrvDTO();
		srvdto.setId_srv(ciEmsDTOs[0].getId_srv());
		FArrayList clArrayList = new FArrayList();
		clArrayList.add(srvdto);
		if(FBoolean.TRUE.equals(ciEmsDTOs[0].getFg_set())) {
			addSrvSet(clArrayList,ciEmsDTOs[0].getId_srv());
		}
		orderInParamDTO.setCiorlist(clArrayList);
		ArrearsControlOrderInParamDTO[] arrOrderInParamDTO = new ArrearsControlOrderInParamDTO[] { orderInParamDTO };
		// 调用【欠费控制是否可开立医嘱（费用）】
		ArrearsControlOrderOutParamDTO[] outParam = ServiceFinder.find(IBlPayOutQryService.class)
				.getArrearsControl(arrOrderInParamDTO);
		CiOrderSrvDTO[] srvDTOs = (CiOrderSrvDTO[]) outParam[0].getCiorlist()
				.toArray(new CiOrderSrvDTO[outParam[0].getCiorlist().size()]);
		// 不允许开立
		if (FBoolean.FALSE.equals(outParam[0].getFg_open()) || FBoolean.FALSE.equals(srvDTOs[0].getFg_or())) {
			// 不允许开立原因
			throw new BizRuntimeException(srvDTOs[0].getDes());
		} else {
			return FBoolean.TRUE;
		}
	}
	/**
	 * @code 部分医嘱限制开立逻辑
	 *  @author LiYue
	 */
	private FBoolean SomeControlOrd(CiOrderDO[] ciEmsDTOs, CiEnContextDTO envinfo) throws BizException {
		ArrearsControlOrderInParamDTO orderInParamDTO = new ArrearsControlOrderInParamDTO();
		orderInParamDTO.setId_ent(envinfo.getId_en());
		CiOrderSrvDTO srvdto = new CiOrderSrvDTO();
		srvdto.setId_srv(ciEmsDTOs[0].getId_srv());
		FArrayList clArrayList = new FArrayList();
		clArrayList.add(srvdto);
		if(FBoolean.TRUE.equals(ciEmsDTOs[0].getFg_set())) {
			addSrvSet(clArrayList,ciEmsDTOs[0].getId_srv());
		}
		orderInParamDTO.setCiorlist(clArrayList);
		ArrearsControlOrderInParamDTO[] arrOrderInParamDTO = new ArrearsControlOrderInParamDTO[] { orderInParamDTO };
		// 调用【欠费控制是否可开立医嘱（费用）】
		ArrearsControlOrderOutParamDTO[] outParam = ServiceFinder.find(IBlPayOutQryService.class)
				.getArrearsControl(arrOrderInParamDTO);
		CiOrderSrvDTO[] srvDTOs = (CiOrderSrvDTO[]) outParam[0].getCiorlist()
				.toArray(new CiOrderSrvDTO[outParam[0].getCiorlist().size()]);
		// 不允许开立
		if (FBoolean.FALSE.equals(outParam[0].getFg_open()) || FBoolean.FALSE.equals(srvDTOs[0].getFg_or())) {
			// 不允许开立原因
			throw new BizRuntimeException(srvDTOs[0].getDes());
		} else {
			return FBoolean.TRUE;
		}
	}
	/**
	 * 
	 * @code 将服务套子项放入集合
	 * @param clArrayList
	 * @param id_srv
	 */
    private void addSrvSet(FArrayList clArrayList, String id_srv) {
    	if(StringUtils.isNullOrEmpty(id_srv)) return;
    	
		MedSrvSetItemDO[] srvChildrens = null;
		try
		{
			srvChildrens = ServiceFinder.find(IMedSrvSetItemDORService.class).findByAttrValString(MedSrvSetItemDO.ID_SRV, id_srv);
		}catch (Exception e) {
		}
		if (srvChildrens != null && srvChildrens.length > 0)
		{
			for (MedSrvSetItemDO srvChildren : srvChildrens)
			{
				CiOrderSrvDTO srvdto = new CiOrderSrvDTO();
				srvdto.setId_srv(srvChildren.getId_srv_itm());
				clArrayList.add(srvdto);
			}
		}
	}

	/**
     * @throws BizException 
     * @code 保存欠费校验 
     */
	public void saveCheckdArrearage(CiEnContextDTO envinfo,CiorderAggDO[] ciorList) throws BizException {
		//是否欠费校验
		if (FBoolean.TRUE.equals(ArrearageCheckParam(envinfo))) {
			envinfo.setPrePaidAccAmt4CiDTO(GetAccAmt4CiDto(envinfo));
			FDouble available = envinfo.getPrePaidAccAmt4CiDTO().getAmt_available();// 可用余额
			FDouble allControl = envinfo.getPrePaidAccAmt4CiDTO().getAllControl();// 完全控制
			//当前科室没有配置预交金策略时，应按不限制处理:0184137 
			if(allControl == null)
				return ;
			// 待保存的医嘱金额 （临时）
			FDouble ordersPriFDouble = getOrdersPri(ciorList);
			//【待保存的医嘱金额】 > 【可用余额】- 【完全控制警戒金额】时
			if (ordersPriFDouble.compareTo(available.sub(allControl)) >0)
			{
				throw new BizRuntimeException("开立本次医嘱后总费用将超出可用费用上限，无法开立本次医嘱！!");
			}
			else {
				//更新【可用余额】字段	
				//envinfo.getPrePaidAccAmt4CiDTO().setAmt_available(envinfo.getPrePaidAccAmt4CiDTO().getAmt_available().sub(ordersPriFDouble));
			}
		}
	}

	/**
	 * @code 待保存的医嘱金额 （临时） @author LiYue
	 */
	private FDouble getOrdersPri(CiorderAggDO[] aggOrders) throws BizException {
		FDouble ordersPriFDouble = FDouble.ZERO_DBL;
		if (aggOrders != null && aggOrders.length > 0) {
			for (CiorderAggDO ciorderAggDO : aggOrders) {
				FBoolean flag = ciorderAggDO.getParentDO().getFg_long();
				//判断临时
				if(FBoolean.TRUE.equals(flag)) {
					continue;
				}
				OrdSrvDO[] ordsrvdos = ciorderAggDO.getOrdSrvDO();
				if(ordsrvdos != null && ordsrvdos.length > 0) {
					for (OrdSrvDO ordSrvDO : ordsrvdos) {
						//判断空，判断收费
						if(ordSrvDO.getPri() != null && (ordSrvDO.getQuan_total_medu() != null || ordSrvDO.getQuan_medu() != null) && FBoolean.TRUE.equals(ordSrvDO.getFg_bl())) {
							FDouble srvPri = FDouble.ZERO_DBL;
							if(ordSrvDO.getQuan_total_medu() != null) {
								 srvPri =  ordSrvDO.getPri().multiply(ordSrvDO.getQuan_total_medu());
							}else {
								 srvPri =  ordSrvDO.getPri().multiply(ordSrvDO.getQuan_medu());
							}
							ordersPriFDouble = ordersPriFDouble.add(srvPri);
						}
					}
				}
			}
		}
		return ordersPriFDouble;
	}
}
