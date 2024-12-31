package iih.bl.cg.bp;

/**
 * 退费相关业务的Bp
 * @author yangyang
 *
 */
public class RefundBackBizBp {

//	public BlIncItmVsTypeDTO[] refundAllBackBillOnHis(String strCodeSt,String[] strCgOepArr,String strCodeHp,BlRefundItmDTO[] refundItmDtoArr,OperatorInfoDTO operatorInfo,BlpaypatoepAggDO paypatOepAggDo) throws BizException
//	{
//		//1.通过结算流水号获得此次的交易信息
//		IBlstoepRService stoepService=ServiceFinder.find(IBlstoepRService.class);
//		String strWhere=BlStOepDODesc.TABLE_ALIAS_NAME+".code_st='"+strCodeSt+"'";
//		BlStOepDO[] stOepDoArr=stoepService.find(strWhere, "", FBoolean.FALSE);
//		if(BlValidator.IsNullOrEmpty(stOepDoArr))
//			throw new BizException("查询结算信息失败，没有找到该结算流水号对应的结算");
//		
//		//2、红冲收付款信息，以及相关的预交金的处理,因为本函数只处理全退的情况，所以是否全退字段设置为true；
//		BlpaypatoepAggDO[] paypatOepAggDoArr=redBackPayData(stOepDoArr[0].getId_paypatoep(),new BlpaypatoepAggDO[]{paypatOepAggDo},FBoolean.TRUE);
//		//新收付款主键ID
//		String strIdPaypatOep=paypatOepAggDoArr[0].getParentDO().getId_paypatoep();
//		
//		//3、红冲结算信息
//		BlStOepDO[] redBackStOepArr=redBackStBill(strIdPaypatOep,stOepDoArr[0],operatorInfo);
//		
//		//4.红冲明细信息
//		BlcgoepAggDO[] cgOepAggDoArr=redBackCgData(strCgOepArr,redBackStOepArr[0].getId_stoep(),operatorInfo);
//		
//		//5、红冲发票信息
//		BlincoepAggDO[] incOepAggDoArr=redBackIncBill(stOepDoArr[0].getId_stoep(),redBackStOepArr[0].getId_stoep(),operatorInfo);
//		
//		//6.红冲分摊数据
//		//查找原应收信息
//		BlproparoepAggDO[] propArOepAggDoArr=assemblyRedPropArOepAggDo(redBackStOepArr[0].getId_stoep(),strCodeHp);
//		redBackPropData(redBackStOepArr[0].getId_stoep(), propArOepAggDoArr);
//		
//		//7、解除物品预留，释放窗口队列
//		relieveMMReserved(refundItmDtoArr);
//		
//		//8、修改医嘱状态，因为允许部分退，需要更改部分医嘱服务项目的执行状态
//		updateOrdBlState(refundItmDtoArr);
//		
//		//9、发送事件
//		try{
//			this.methodInvoke(cgOepAggDoArr,paypatOepAggDoArr[0],redBackStOepArr[0],incOepAggDoArr[0]);
//		}
//		catch(Exception ex)
//		{
//			
//		}
//		return null;
//	}
//	
//	
//	/**
//	 * 组装医保应收数据，这个函数主要是提供给RefundAllBackBillOnHis用，其他地方不可能遇到
//	 * @param strIdStoep 原结算信息
//	 * @param strCodeHp 医保交易流水号，退费分解产生的
//	 * @return
//	 * @throws BizException
//	 */
//	private BlproparoepAggDO[] assemblyRedPropArOepAggDo(String strIdStoep,String strCodeHp) throws BizException
//	{
//		//验证数据合法性
//		BlValidator.ValidatorParam("AssemblyRedPropArOepAggDo", strIdStoep, strIdStoep);
//		
//		IBlproparoepRService rService=ServiceFinder.find(IBlproparoepRService.class);
//		String strWhere=BlPropArOepDODesc.TABLE_ALIAS_NAME+".id_stoep='"+strIdStoep+"'";
//		BlproparoepAggDO[] propArOepAggDoArr=rService.find(strWhere, "", FBoolean.FALSE);
//		//红冲数据
//		BlproparoepAggDO propArOepAggdoRedBack=new BlproparoepAggDO();
//		
//		BlPropArOepDO propArOepDoRedBack=(BlPropArOepDO)propArOepAggDoArr[0].getParentDO().clone();
//		propArOepDoRedBack.setId_proparoep(null);
//		propArOepDoRedBack.setEu_direct(BookRtnDirectEnum.RETURNS);
//		propArOepDoRedBack.setCode_hp(strCodeHp);
//		propArOepDoRedBack.setStatus(DOStatus.NEW);
//		propArOepAggdoRedBack.setParentDO(propArOepDoRedBack);
//		
//		List<BlPropArItmOepDO> lst=new ArrayList<BlPropArItmOepDO>();
//		BlPropArItmOepDO[] itmOepDoArr=propArOepAggDoArr[0].getBlPropArItmOepDO();
//		for(BlPropArItmOepDO itmOepDo:itmOepDoArr)
//		{
//			BlPropArItmOepDO propAritmOepDo=(BlPropArItmOepDO)itmOepDo.clone();
//			propAritmOepDo.setStatus(DOStatus.NEW);
//			lst.add(propAritmOepDo);
//		}
//		propArOepAggdoRedBack.setChildrenDO(lst.toArray(new BlPropArItmOepDO[0]));
//		
//		IBlproparoepCudService cudService=ServiceFinder.find(IBlproparoepCudService.class);
//		BlproparoepAggDO[] result=cudService.save(new BlproparoepAggDO[]{propArOepAggdoRedBack});
//		return result;
//	}
//		
//	/**
//	 * 账目红冲时发送事件
//	 * @param cgOepAggDoArr 记账明细集合
//	 * @param paypatOepAggDo 收付款
//	 * @param stOepDo 结算主DO
//	 * @param incOepAggdo 发票AggDO
//	 * @throws BizException
//	 */
//	private void methodInvoke(BlcgoepAggDO[] cgOepAggDoArr,BlpaypatoepAggDO paypatOepAggDo,BlStOepDO stOepDo,BlincoepAggDO incOepAggdo) throws BizException
//	{
//		BlEventInfoDTO blEventInfoDTO=new BlEventInfoDTO();
//		
//		//1.组装事件发送所需的数据
//		PatDO patDO=new PatDO();	
//		IPativisitRService iPativisitRService=ServiceFinder.find(IPativisitRService.class);
//		PatiVisitDO[] patiVisitDO=iPativisitRService.find(" id_ent='"+stOepDo.getId_ent()+"'", "", FBoolean.FALSE);
//		IPatiRService iPatiRService=ServiceFinder.find(IPatiRService.class);
//		PatiAggDO[]  patiAggDOArr=iPatiRService.find(" id_pat='"+stOepDo.getId_pat()+"'", "", FBoolean.FALSE);
//		
//		FArrayList cgItmOepDoLst=new FArrayList();
//		
//		for(BlcgoepAggDO cgOepAggdo:cgOepAggDoArr)
//		{
//			cgItmOepDoLst.add(cgOepAggdo.getChildrenDO());
//		}
//		
//		blEventInfoDTO.setPatiVisitDO(patiVisitDO[0]);
//		blEventInfoDTO.setPatDO(patiAggDOArr[0].getParentDO());
//		blEventInfoDTO.setBlpaypatoepAggDO(paypatOepAggDo);
//		blEventInfoDTO.setBlStOepDO(stOepDo);
//		blEventInfoDTO.setBlIncOepDO(incOepAggdo.getParentDO());
//		blEventInfoDTO.setBlCgItmOepDOList(cgItmOepDoLst);
//		blEventInfoDTO.setFunc_Status(IBlFunCodeConst.FUN_CODE_OPFEERTN_RED);//红冲
//		
//		//2、触发事件		
//		BusinessEvent oepSettlementEvent = new BusinessEvent(IBlEventConst.EVENT_SOURCE_BL_OEP_SETTLEMENT,IEventType.TYPE_INSERT_AFTER,
//				blEventInfoDTO);
//		EventDispatcher.fireEvent(oepSettlementEvent);	
//	}
//	
//	/**
//	 * 更改医嘱状态
//	 * @param refundItemDtoArr 退费明细项目退费情况
//	 * @throws BizException
//	 */
//	private void updateOrdBlState(BlRefundItmDTO[] refundItemDtoArr) throws BizException
//	{
//		//校验退费明细信息
//		BlValidator.ValidatorParam("退费明细:BlRefundItmDTO[]", refundItemDtoArr);
//		
//		List<String> refundItmDtoLst=new ArrayList<String>();
//		
//		for(BlRefundItmDTO refundItmDto:refundItemDtoArr)
//		{
//			if(!refundItmDto.getFg_mm().booleanValue() && refundItmDto.getQuan_refund().doubleValue()>0)
//			{
//				//如果是诊疗，则必须全退
//				refundItmDtoLst.add(refundItmDto.getId_orsrv());
//			}
//			else if(refundItmDto.getFg_mm().booleanValue() && !refundItmDto.getFg_drug_provide().booleanValue())
//			{
//				//如果是诊疗，则必须全退
//				refundItmDtoLst.add(refundItmDto.getId_orsrv());
//			}
//		}
//		
//		if(refundItmDtoLst.size()>0)
//		{
//			//更改医嘱状态
//			ICiOrdMaintainService ciOrdMaintainSer=ServiceFinder.find(ICiOrdMaintainService.class);
//			ciOrdMaintainSer.UpdateOrdChargeRelInfo(refundItmDtoLst.toArray(new String[]{}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND, Tools.getServerTime());
//		}
//		
//	}
//	
//	/**
//	 * 处理物品预留问题
//	 * @param refundItemDtoArr 退费明细
//	 * 
//	 * @throws BizException
//	 */
//	private void relieveMMReserved(BlRefundItmDTO[] refundItemDtoArr) throws BizException
//	{
//		//1、判断是否可以需要解除预留
//		List<String> strIdOrSrvLst=new ArrayList<String>();
//		List<ReserveReqDTO> reServeReqDtoLst=new ArrayList<ReserveReqDTO>();
//		for(BlRefundItmDTO refundItmDto:refundItemDtoArr)
//		{
//			if(refundItmDto.getFg_mm().booleanValue())
//			{
//				//药品且未发放，才可以解除预留以及释放队列
//				if(!refundItmDto.getFg_drug_provide().booleanValue())
//				{
//					//未发放药品集合
//					strIdOrSrvLst.add(refundItmDto.getId_orsrv());
//				
//					//生成物品预留DTO
//					ReserveReqDTO reserveReqDto = new ReserveReqDTO();
//					reserveReqDto.setId_mm(refundItmDto.getId_mm());
//					reserveReqDto.setId_dep(refundItmDto.getId_dep_wh());
//					reserveReqDto.setReq_num(refundItmDto.getQuan_refund());
//					reserveReqDto.setReq_unit_id(refundItmDto.getReq_unit_id());
//					reserveReqDto.setId_orsrv(refundItmDto.getId_orsrv());
//					reServeReqDtoLst.add(reserveReqDto);
//				}
//			}
//		}
//		//2.释放窗口队列,解除物品预留
//		if(strIdOrSrvLst.size()>0)
//		{
//			//释放窗口队列
//			IMpDgOutService mpDgoutSer=ServiceFinder.find(IMpDgOutService.class);
//			mpDgoutSer.writebackDispItmAfterRefundCharge(strIdOrSrvLst.toArray(new String[0]));
//			
//			//退预留
//			IMaterialStockService mlService = ServiceFinder.find(IMaterialStockService.class);
//			//退预留mlService.TYPE_RETURN
////			ReserveResultDTO[] mlResult
//			mlService.reserveMaterials(mlService.TYPE_RETURN,reServeReqDtoLst.toArray(new ReserveReqDTO[]{}));
//		}
//		
//	}
//	
//	/**
//	 * 红冲发票
//	 * @param strIdStOepOld 原结算信息
//	 * @param strIdStOep 红冲结算ID主键
//	 * @param operatorInfoDTO 操作人员信息
//	 * @throws BizException
//	 */
//	private BlincoepAggDO[] redBackIncBill(String strIdStOepOld,String strIdStOep,OperatorInfoDTO operatorInfoDTO) throws BizException
//	{
//		//1、作废原发票
//		//查询原发票信息
//		IBlincoepRService incOepRService=ServiceFinder.find(IBlincoepRService.class);
//		String strWhereSql=String.format("%s.id_stoep='%s'", BlIncOepDODesc.TABLE_ALIAS_NAME,strIdStOepOld);
//		//一次结算可能会对应多张发票，必须全部红冲掉
//		BlincoepAggDO[] incOepAggdoArr=incOepRService.find(strWhereSql,"",FBoolean.FALSE);
//		if(BlValidator.IsNullOrEmpty(incOepAggdoArr))
//			throw new BizException("通过结算主键"+strIdStOep+"未能找到对应的发票信息");
//		
//		//获取红冲明细信息,主要为了补充红冲发票明细表数据
//		IBlCgItmOepDORService cgItmOepRService=ServiceFinder.find(IBlCgItmOepDORService.class);
//				
//		//红冲发票AggDO集合
//		List<BlincoepAggDO> incOepAggdoLst=new ArrayList<BlincoepAggDO>();
//		//组装数据
//		for(BlincoepAggDO incOepAggdo:incOepAggdoArr)
//		{
//			BlincoepAggDO incOepRedBackAggdo=new BlincoepAggDO();
//			
//			//原发票信息
//			BlIncOepDO incOepDo=incOepAggdo.getParentDO();
//			//生成红冲主数据
//			BlIncOepDO incOepRedBackDo=(BlIncOepDO)incOepDo.clone();
//			incOepRedBackDo.setId_incoep(null);
//			incOepRedBackDo.setEu_direct(BookRtnDirectEnum.RETURNS);
//			//暂时按不打印红冲发票处理
//			incOepRedBackDo.setCode_incpkg(null);
//			incOepRedBackDo.setIncno(null);
//			incOepRedBackDo.setDt_inc(Tools.getServerTime());
//			incOepRedBackDo.setId_emp_inc(operatorInfoDTO.getId_emp());
//			incOepRedBackDo.setTimes_prn(1);
//			incOepRedBackDo.setFg_canc(FBoolean.FALSE);
//			incOepRedBackDo.setSd_reason_canc(null);
//			incOepRedBackDo.setDes_reason_canc(null);
//			incOepRedBackDo.setDt_canc(null);
//			incOepRedBackDo.setId_emp_canc(null);
//			incOepRedBackDo.setId_stoep(strIdStOep);
//			incOepRedBackDo.setFg_print(FBoolean.FALSE);
//			incOepRedBackDo.setFg_cc_out(FBoolean.FALSE);
//			incOepRedBackDo.setId_cc_out(null);
//			incOepRedBackDo.setFg_cc_in(FBoolean.FALSE);
//			incOepRedBackDo.setId_cc_in(null);
//			incOepRedBackDo.setStatus(DOStatus.NEW);
//			incOepRedBackAggdo.setParentDO(incOepRedBackDo);
//			
//			//修改原发票信息
//			incOepDo.setFg_canc(FBoolean.TRUE);
//			incOepDo.setSd_reason_canc("01");
//			incOepDo.setDes_reason_canc("退费");
//			incOepDo.setDt_canc(Tools.getServerTime());
//			incOepDo.setId_emp_canc(operatorInfoDTO.getId_emp());
//			incOepDo.setStatus(DOStatus.UPDATED);
//			
//			//获取红冲明细记账信息,如果一个结算对应多张发票，分票规则是一次就诊一张发票
//			List<BlIncCgItmOep> incCgItmDoRedBackLst=new ArrayList<BlIncCgItmOep>();
//			StringBuffer strSql=new StringBuffer();
//			strSql.append(BlCgItmOepDODesc.TABLE_ALIAS_NAME+".id_stoep='"+strIdStOep+"' and ");
////			strSql.append(BlCgItmOepDODesc.TABLE_ALIAS_NAME+".id_ent='"+incOepRedBackDo.getId_ent()+"'");
//			//获取红冲记账明细
//			BlCgItmOepDO[] cgItmOepDoArr=cgItmOepRService.find(strSql.toString(), "", FBoolean.FALSE);
//			
//			//红冲明细信息
//			for(BlCgItmOepDO cgItmOep:cgItmOepDoArr)
//			{
//				BlIncCgItmOep incCgItmDoRedBack=new BlIncCgItmOep();
//				incCgItmDoRedBack.setId_cgitmoep(cgItmOep.getId_cgitmoep());
//				incCgItmDoRedBack.setId_incoep(incOepRedBackDo.getId_incoep());
//				incCgItmDoRedBack.setStatus(DOStatus.NEW);
//				incCgItmDoRedBackLst.add(incCgItmDoRedBack);
//			}
//			//红冲数据添加明细信息
//			incOepRedBackAggdo.setChildrenDO(incCgItmDoRedBackLst.toArray(new BlIncCgItmOep[0]));	
//			incOepAggdoLst.add(incOepRedBackAggdo);
//		}
//		//保存原发票信息
//		IBlincoepCudService incOepCudService=ServiceFinder.find(IBlincoepCudService.class);
//		incOepCudService.save(incOepAggdoArr);
//		
//		//保存红冲发票信息
//		BlincoepAggDO[] resultAggdo=incOepCudService.save(incOepAggdoLst.toArray(new BlincoepAggDO[0]));
//		return resultAggdo;
//	}
//	
//	/**
//	 * 红冲结算信息
//	 * @param stOepDo 结算主DO
//	 * @param operatorInfoDTO 操作人员信息
//	 * @throws BizException 返回异常信息
//	 */
//	private BlStOepDO[] redBackStBill(String strIdPaypatOep,BlStOepDO stOepDo,OperatorInfoDTO operatorInfoDTO) throws BizException
//	{
//		//红冲数据操作
//		if(BlValidator.IsNullOrEmpty(stOepDo))
//			throw new IllegalArgumentException("BlStOepDO参数异常，待红冲结算数据不能为空");
//		
//		//获取结算处理服务
//		IBlstoepCudService stCudService=ServiceFinder.find(IBlstoepCudService.class);
//				
//		//1、克隆结算数据，生成红冲数据
//		BlStOepDO negStOepDo=(BlStOepDO)stOepDo.clone();
//		negStOepDo.setId_stoep(null);
//		//关联主键
//		negStOepDo.setId_par(stOepDo.getId_stoep());
//		negStOepDo.setId_dep_st(operatorInfoDTO.getId_dep());
//		negStOepDo.setEu_direct(BookRtnDirectEnum.RETURNS);
//		//如果原结算是挂号收费结算
//		if(stOepDo.getEu_sttp().equals(StTypeEnum.ST_OEP_REG))
//		{
//			negStOepDo.setEu_sttp(StTypeEnum.ST_REGISTER_RED);
//		}
//		else
//		{
//			//门诊冲账结算
//			negStOepDo.setEu_sttp(StTypeEnum.ST_OEP_MIDWAY);
//		}
//		GetCodeByCustomization code_ins = new GetCodeByCustomization();
//		//生成结算流水号
//		negStOepDo.setCode_st(code_ins.GetCodeStOep());
//		negStOepDo.setDt_st(Tools.getServerTime());
//		//结算部门
//		negStOepDo.setId_dep_st(operatorInfoDTO.getId_dep());
//		//结算收费员
//		negStOepDo.setId_emp_st(operatorInfoDTO.getId_emp());
//		negStOepDo.setFg_cc(FBoolean.FALSE);
//		negStOepDo.setFg_canc(FBoolean.FALSE);
//		negStOepDo.setId_emp_canc(null);
//		negStOepDo.setId_reason_canc(null);
//		negStOepDo.setSd_reason_cand(null);
//		negStOepDo.setDes_reason_canc(null);
//		//红冲收付款主键
//		negStOepDo.setId_paypatoep(strIdPaypatOep);
//		negStOepDo.setStatus(DOStatus.NEW);
//		//保存红冲结算数据
//		BlStOepDO[] stOepArr=stCudService.save(new BlStOepDO[]{negStOepDo});
//		if(BlValidator.IsNullOrEmpty(stOepArr))
//			throw new BizException("保存结算红冲数据失败");
//		
//		
//		//2、修改原结算信息字段
//		stOepDo.setFg_canc(FBoolean.TRUE);
//		stOepDo.setId_emp_canc(operatorInfoDTO.getId_emp());
//		stOepDo.setDt_canc(Tools.getServerTime());
//		stOepDo.setId_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED_ID);
//		stOepDo.setSd_reason_cand(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED);
//		stOepDo.setStatus(DOStatus.UPDATED);
//		//保存结算数据
//		stCudService.save(new BlStOepDO[]{negStOepDo,stOepDo});
//		 
//		return stOepArr;
//	}
//	
//	/**
//	 * 红冲收付款信息，包括对于预交金账户的处理
//	 * @param strIdPayPatOep 原首付款主键
//	 * @param changePayDataArr 退款信息
//	 * @param IsRefundAll 是否全退
//	 * @return 红冲后的数据信息
//	 * @throws BizException
//	 */
//	private BlpaypatoepAggDO[] redBackPayData(String strIdPayPatOep,BlpaypatoepAggDO[] changePayDataArr,FBoolean IsRefundAll) throws  BizException
//	{
//		//0.对红冲收付款信息做一个数据处理，处理收付款明细DO里的fg_realpay字段
//		//如果是全退，则fg_realpay为y
//		BlPayItmPatOepDO[] payItmPatOepDoArr=changePayDataArr[0].getBlPayItmPatOepDO();
//		for(BlPayItmPatOepDO payItmPatDo:payItmPatOepDoArr)
//		{
//			if(IsRefundAll.booleanValue())
//			{
//				payItmPatDo.setFg_realpay(FBoolean.TRUE);
//			}
//			else
//			{
//				payItmPatDo.setFg_realpay(FBoolean.FALSE);
//			}
//		}
//		//1、保存红冲收付款信息
//		IBlpaypatoepCudService cudService=ServiceFinder.find(IBlpaypatoepCudService.class);
//		BlpaypatoepAggDO[] result=cudService.save(changePayDataArr);
//		if(BlValidator.IsNullOrEmpty(result))
//			throw new BizException("保存红冲收付款信息失败");
//		
//		//2.判断支付明细里是否有预交金支付方式,如果有预交金则在预交金交易明细表bl_prepay_pat里插入数据
//		BlpaypatoepAggDO currentPaypatoepAggdo=result[0];
//		//收付款主DO
//		BlPayPatOepDO payPatOepDo=currentPaypatoepAggdo.getParentDO();
//		List<BlPrePayPatDO> prePaypatDoLst=new ArrayList<BlPrePayPatDO>();
//		BlPayItmPatOepDO[] payItemPatoepDoArr=currentPaypatoepAggdo.getBlPayItmPatOepDO();
//		FDouble prePayAmt=new FDouble(0);
//		for(BlPayItmPatOepDO  itemDo:payItemPatoepDoArr)
//		{
//			if(itemDo.getSd_pm().equals(IBdPripmCodeConst.CODE_PRI_PM_PAY))
//			{
//				//创建对应的预交金明细记录
//				BlPrePayPatDO prePayDo=new BlPrePayPatDO();
//				prePayDo.setId_grp(itemDo.getId_grp());
//				prePayDo.setId_org(itemDo.getId_org());
//				//预交金收付款类型，患者预交金消费
//				prePayDo.setId_paytp(IBlDictCodeConst.SD_PAYTP_ID_HZYJJXF);
//				//预交金收付款类型，患者预交金消费，21
//				prePayDo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CODE_HZYJJXF);
//				prePayDo.setId_pat(payPatOepDo.getId_pat());
//				prePayDo.setId_enttp(payPatOepDo.getId_enttp());
//				prePayDo.setCode_enttp(payPatOepDo.getCode_enttp());
//				prePayDo.setEu_direct(BookRtnDirectEnum.CHARGE);
//				prePayDo.setAmt(itemDo.getAmt());
//				prePayDo.setId_pm(itemDo.getId_pm());
//				prePayDo.setSd_pm(itemDo.getSd_pm());
//				prePayDo.setId_bank(null);
//				prePayDo.setBankno(null);
//				prePayDo.setPaymodenode(null);
//				prePayDo.setDt_pay(Tools.getServerTime());
//				prePayDo.setId_org_pay(payPatOepDo.getId_org_pay());
//				prePayDo.setId_dep_pay(payPatOepDo.getId_dep_pay());
//				prePayDo.setId_emp_pay(payPatOepDo.getId_emp_pay());
//				prePayDo.setId_cc(null);
//				//票据类型，门诊押金条
//				prePayDo.setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_DEPOSIT);
//				prePayDo.setCode_incca(IBdPpCodeTypeConst.SD_OUTPATIENT_DEPOSIT);
//				prePayDo.setFg_rep_return(FBoolean.FALSE);
//				prePayDo.setId_rep_lost(null);
//				prePayDo.setSd_rep_lost(null);
//				prePayDo.setDt_return(null);
//				prePayDo.setId_emp_return(null);
//				//收据编号
//				prePayDo.setCode_rep(null);
//				prePayDo.setId_par(null);
//				prePayDo.setId_st_mid(null);
//				prePayDo.setFg_canc(FBoolean.FALSE);
//				prePayDo.setId_emp_canc(null);
//				prePayDo.setDt_canc(null);
//				prePayDo.setNote("门诊预交金结算");
//				prePayDo.setFg_cc(FBoolean.FALSE);
//				//费用来源，是iih终端还是自助机等
//				prePayDo.setSd_pttp(payPatOepDo.getSd_pttp());
//				prePayDo.setStatus(DOStatus.NEW);
//				prePaypatDoLst.add(prePayDo);
//				
//				//预交金金额计算
//				prePayAmt=prePayAmt.add(prePayDo.getAmt());
//			}
//		}
//		if(prePaypatDoLst.size()>0)
//		{
//			//2.判断支付明细里是否有预交金支付方式,如果有预交金则在预交金交易明细表bl_prepay_pat里插入数据
//			IBlpaypatCudService prePayPatCudService=(IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
//			BlPrePayPatDO[] prePayPatDoArr=prePayPatCudService.save(prePaypatDoLst.toArray(new BlPrePayPatDO[0]));
//			if(BlValidator.IsNullOrEmpty(prePayPatDoArr))
//				throw new BizException("保存预交金交易明细失败");
//			//患者账户需要做相应的调整
//			IPatAccServiceExt accDService = ServiceFinder.find(IPatAccServiceExt.class);
//			accDService.updatePatPrepay(payPatOepDo.getId_pat(),prePayAmt);
//			
//			//3.处理预交金费用来源的问题
//			handlePrePay(changePayDataArr);
//		}
//		
//		//返回保存后的收付款信息
//		return result;
//	}
//	
//	/**
//	 * 红冲记账信息
//	 * @param strIdCgOepArr 记账主键ID
//	 * @param strStOepRedBack
//	 * @param operatorInfo 操作人员信息
//	 * @return
//	 * @throws BizException
//	 */
//	private BlcgoepAggDO[] redBackCgData(String[] strIdCgOepArr,String strStOepRedBack,OperatorInfoDTO operatorInfo) throws BizException
//	{
//		//1.查找出原结算信息对应的记账信息
//		//cud服务
//		IBlcgoepCudService cgOepCudService=ServiceFinder.find(IBlcgoepCudService.class);
//		//R查询服务
//		IBlcgoepRService cgOepRService=ServiceFinder.find(IBlcgoepRService.class);
//		//工具类，号段生成器
//		GetCodeByCustomization code_ins = new GetCodeByCustomization();
//		//查找原记账信息
//		BlcgoepAggDO[] cgOepAggDoArr=cgOepRService.findByIds(strIdCgOepArr, FBoolean.FALSE);
//		//红冲记账AggDO集合
//		List<BlcgoepAggDO> cgOepAggDoLst=new ArrayList<BlcgoepAggDO>();
//		for(BlcgoepAggDO cgOepAggDo:cgOepAggDoArr)
//		{
//			//红冲记账AggDo
//			BlcgoepAggDO cgOepaggDoRedBack=new BlcgoepAggDO();
//			
//			//原记账主DO
//			BlCgOepDO cgOepDo=cgOepAggDo.getParentDO();
//			//更改原记账信息
//			cgOepDo.setStatus(DOStatus.UPDATED);
//			
//			//红冲记账
//			BlCgOepDO cgOepDoRedback=(BlCgOepDO)cgOepDo.clone();
//			cgOepDoRedback.setId_cgoep(null);
//			cgOepDoRedback.setCode_cg(code_ins.GetCodeBlCgOep());
//			cgOepDoRedback.setEu_direct(BookRtnDirectEnum.RETURNS);
//			cgOepDoRedback.setDt_cg(Tools.getServerTime());
//			cgOepDoRedback.setId_org_cg(operatorInfo.getId_org());
//			cgOepDoRedback.setId_dep_cg(operatorInfo.getId_dep());
//			cgOepDoRedback.setId_emp_cg(operatorInfo.getId_emp());
//			cgOepDoRedback.setStatus(DOStatus.NEW);
//			cgOepaggDoRedBack.setParentDO(cgOepDoRedback);
//			
//			//原记账明细信息
//			BlCgItmOepDO[] cgItmOepDoArr=cgOepAggDo.getBlCgItmOepDO();
//			//红冲明细信息集合
//			List<BlCgItmOepDO> cgItmOepDoRedbackLst=new ArrayList<BlCgItmOepDO>();
//			for(BlCgItmOepDO cgItmOepDo:cgItmOepDoArr)
//			{
//				BlCgItmOepDO cgItmOepDoRedBack=(BlCgItmOepDO)cgItmOepDo.clone();
//				cgItmOepDoRedBack.setId_cgitmoep(null);
//				cgItmOepDoRedBack.setId_stoep(strStOepRedBack);
//				cgItmOepDoRedBack.setDt_st(Tools.getServerTime());
//				cgItmOepDoRedBack.setId_par(cgItmOepDo.getId_cgitmoep());
//				cgItmOepDoRedBack.setNote("退费"+cgItmOepDo.getId_cgitmoep());
//				cgItmOepDoRedBack.setStatus(DOStatus.NEW);
//				cgItmOepDoRedbackLst.add(cgItmOepDoRedBack);
//				
//				//修改原记账明细
//				cgItmOepDo.setFg_refund(FBoolean.TRUE);
//				cgItmOepDo.setStatus(DOStatus.UPDATED);	
//			}
//			cgOepaggDoRedBack.setBlCgItmOepDO(cgItmOepDoRedbackLst.toArray(new BlCgItmOepDO[0]));
//			cgOepAggDoLst.add(cgOepaggDoRedBack);	
//		}
//		
//		//保存原记账信息
//		cgOepCudService.save(cgOepAggDoArr);
//		BlcgoepAggDO[] saveResult=cgOepCudService.save(cgOepAggDoLst.toArray(new BlcgoepAggDO[0]));
//		if(ArrayUtil.isEmptyNoNull(saveResult))
//			throw new BizException("保存红冲记账信息失败！");
//		return saveResult;
//	}
// 
//	/**
//	 * @param PayDataArr 收付款AggDo
//	 * @throws BizException
//	 */
//	private void handlePrePay(BlpaypatoepAggDO[] PayDataArr) throws BizException
//	{
//		//验证参数合法性
//		BlValidator.ValidatorParam("方法HandlePrePay的参数BlpaypatoepAggDO[]",PayDataArr);
//		
//		//获取支付主DO
//		BlPayPatOepDO payPatOepDo=PayDataArr[0].getParentDO();
//		//获取收付款明细
//		BlPayItmPatOepDO[] payItemPatoepDoArr=PayDataArr[0].getBlPayItmPatOepDO();
//		IBlprepaypatpmamtoepCudService prePayAmtCudSer=ServiceFinder.find(IBlprepaypatpmamtoepCudService.class);
//		//预交金费用来源服务
//		IBlprepaysrcpmoepCudService prePaySrcCudSer=ServiceFinder.find(IBlprepaysrcpmoepCudService.class);
//		
//		StringBuffer sb=new StringBuffer();
//		sb.append(" select a.* from bl_prepay_pat_pmamt_oep a,bd_pri_pm b");
//		sb.append(" where a.id_pm=b.id_pm and a.id_pat=? order by b.prepay_lv asc");
//		SqlParam param=new SqlParam();
//		param.addParam(payPatOepDo.getId_pat());
//		@SuppressWarnings("unchecked")
//		List<BlPrepayPatPmamtOepDO> prePayPmAmtDoLst=(List<BlPrepayPatPmamtOepDO>)new DAFacade().execQuery(sb.toString(), param,new BeanListHandler(BlPrepayPatPmamtOepDO.class));
//		//预交金费用来源do
//		List<BlPrepaySrcpmOepDO> prepaySrcDoLst=new ArrayList<BlPrepaySrcpmOepDO>();
//		if(prePayPmAmtDoLst.size()>0)
//		{
//			for(BlPayItmPatOepDO payItmPatDo:payItemPatoepDoArr)
//			{
//				// 如果支付明细的支付方式采用的是预交金
//				if (!IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(payItmPatDo.getSd_pm())) 
//					continue;
//
//				if (payPatOepDo.getEu_direct()!=payItmPatDo.getEu_direct())
//				{
//					// 创建预交金费用来源DO
//					BlPrepaySrcpmOepDO prepaySrcDo = new BlPrepaySrcpmOepDO();
//					prepaySrcDo.setAmt(payItmPatDo.getAmt());
//					prepaySrcDo.setId_payitmpatoep(payItmPatDo
//							.getId_payitmpatoep());
//					//取优先级高的支付方式
//					prepaySrcDo.setId_pm_src(prePayPmAmtDoLst.get(0)
//							.getId_pm());
//					prepaySrcDo.setStatus(DOStatus.NEW);
//					prepaySrcDoLst.add(prepaySrcDo);
//					
//					for(BlPrepayPatPmamtOepDO prePayAmtItmDo:prePayPmAmtDoLst)
//					{
//						//查找费用来源所用的支付方式
//						if(!prePayAmtItmDo.getId_pm().equals(prepaySrcDo.getId_pm_src()))
//							continue;
//						prePayAmtItmDo.setAmt_in(prePayAmtItmDo.getAmt_in().add(prepaySrcDo.getAmt()));
//						prePayAmtItmDo.setStatus(DOStatus.UPDATED);
//					}
//				}
//				else{
//					//如果是收取患者的预交金
//					//通过账户里的钱判断预交金来源的分解方式	
//					FDouble amtRemain=payItmPatDo.getAmt();
//					for(BlPrepayPatPmamtOepDO prePayAmtDo:prePayPmAmtDoLst)
//					{
//						FDouble amtTmp=prePayAmtDo.getAmt_out().add(amtRemain).sub(prePayAmtDo.getAmt_in());
//						if(amtTmp.doubleValue()<=0)
//						{
//							//如果该支付方式足以用于支付
//							prePayAmtDo.setAmt_out(prePayAmtDo.getAmt_out().add(amtRemain));						
//							break;
//						}
//						amtRemain=amtTmp;
//						prePayAmtDo.setAmt_out(prePayAmtDo.getAmt_in());
//					}
//	
//				}
//			}//For结束
//			//保存更改后的数据
//			if(prepaySrcDoLst.size()>0)
//			{
//				//保存预交金支付账户表
//				prePayAmtCudSer.save(prePayPmAmtDoLst.toArray(new BlPrepayPatPmamtOepDO[0]));
//				//保存预交金费用来源表
//				prePaySrcCudSer.save(prepaySrcDoLst.toArray(new BlPrepaySrcpmOepDO[0]));
//			}
//		}
//		else
//		{
//			//老数据可能会导致空值
//		}
//	}
//
//	/**
//	 * 红冲分摊信息
//	 * @param strIdStoep 红冲结算主键
//	 * @param propArOepAggDoArr 应收数据
//	 * @throws BizException
//	 */
//	private void redBackPropData(String strIdStoep,BlproparoepAggDO[] propArOepAggDoArr) throws BizException
//	{
//		//如果是医保退费，需要红冲掉分摊数据
//		IBlpropoepCudService propOepCudSer=ServiceFinder.find(IBlpropoepCudService.class);
//		//组装分摊do数据
//		BlPropOepDO propOepDo=new BlPropOepDO();
//		propOepDo.setId_grp(Context.get().getGroupId());
//		propOepDo.setId_org(Context.get().getOrgId());
//		propOepDo.setDt_prop(Tools.getServerTime());
//		//判断有效标志
//		propOepDo.setFg_active(FBoolean.TRUE);
//		propOepDo.setEu_direct(-1);
//		propOepDo.setId_stoep(strIdStoep);
//		propOepDo.setStatus(DOStatus.NEW);
//		
//		//判断是否有分摊
//		BlPropOepDO[] propOepDoResultArr=propOepCudSer.save(new BlPropOepDO[]{propOepDo});
//		
//		//组装应收数据
//		BlValidator.ValidatorParam("RedBackPropData函数BlproparoepAggDO[]异常", propArOepAggDoArr);
//		//获取应收主表
//		BlPropArOepDO propAroepDo=propArOepAggDoArr[0].getParentDO();
//		propAroepDo.setId_propoep(propOepDoResultArr[0].getId_propoep());
//		propAroepDo.setStatus(DOStatus.NEW);
//		//保存红冲应收数据
//		IBlproparoepCudService propArOepCudSer=ServiceFinder.find(IBlproparoepCudService.class);
//		propArOepCudSer.save(propArOepAggDoArr);
//	}

}
