package iih.bl.cg.bp.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.FDoubleUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bl.cg.api.d.InsurPriceInfo;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.api.s.bp.GetEntExistsHpBP;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.i.IBlOpCgExternalService;
import iih.bl.cg.s.bp.GetMedWindowsBP;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.medicareinformation.d.HealthFeeDTO;
import iih.bl.st.dto.medicareinformation.d.HealthFeeItemDTO;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊医保结算确认(收费)
 * 
 * @author LIM
 *
 */
public class payStOepBp {
	public OpPayReturn exec(OpPayParam paramOp, InsurPriceInfo paramIn, BlOrderAppendBillParamDTO[] appendBillParamDTOs, boolean isEn) throws BizException {
		additional(appendBillParamDTOs);
		if (paramIn == null || paramOp == null) {
			throw new BizException("参数不能为空！");
		}
		if (paramIn.getPatCode() == null || paramIn.getEntpCode() == null || paramIn.getOperatorCode() == null) {
			throw new BizException("传入的参数不能为空！");
		}
		writeLog(paramOp, paramIn);
		OpPayReturn rtnInfo = new OpPayReturn();
		// 医保患者判断医保卡号不能为空
		if (("02").equals(paramOp.getPatType())) {
			if (paramIn.getInsurCardNo() == null || paramIn.getInsurPriceResult() == null 
					|| paramIn.getId_ent() == null) {
				throw new BizException("传入的参数不能为空！");
			}
		} else {
			// 自费结算
			IBlOpCgExternalService blOpCgExternalService = ServiceFinder.find(IBlOpCgExternalService.class);
			rtnInfo = blOpCgExternalService.pay(paramOp);
			return rtnInfo;
		}

		rtnInfo.setResultCode("1");
		rtnInfo.setResultMsg("操作失败！");
		// 2.判断门急诊代码是否正确 00 门诊 01 急诊
		if (!("01").equals(paramIn.getEntpCode()) && !("00").equals(paramIn.getEntpCode())) {
			rtnInfo.setResultMsg("门急诊代码不正确！");
			return rtnInfo;
		}
		// 3.根据患者code查询患者id_pat
		String[] pat = { "Id_pat" };
		List<PatDO> patDoList = (List<PatDO>) new DAFacade().findByCond(PatDO.class, "code = '" + paramIn.getPatCode() + "' ", "1", pat);

		if (patDoList == null || patDoList.size() <= 0) {
			rtnInfo.setResultMsg("该患者不存在！");
			return rtnInfo;
		}
		// 4.判断操作员是否存在
		String[] psn = { "Id_psndoc" };
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class, "code='" + paramIn.getOperatorCode() + "'", "1", psn);
		if (psnList == null || psnList.size() <= 0) {
			rtnInfo.setResultMsg("该操作员不存在！");
			return rtnInfo;
		}
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_dep(Context.get().getDeptId());
		operatorInfoDTO.setId_emp(psnList.get(0).getId_psndoc());
		operatorInfoDTO.setId_grp(Context.get().getGroupId());
		operatorInfoDTO.setId_org(Context.get().getOrgId());
		operatorInfoDTO.setId_org_emp(Context.get().getOrgId());
		// 判断处方是否存在非北京社保的医保，如果存在医保计划则不允许结算
		String[] appcodes = new String[] {};
		appcodes = paramOp.getApplyNos();
		GetEntExistsHpBP getEntExistsHpBP = new GetEntExistsHpBP();
		String existsHp = getEntExistsHpBP.exec(paramIn.getId_ent(), appcodes, IBdPpCodeTypeConst.ID_HP_BJ_BASIC_MEDICAL_INSUR);
		if (!("").equals(existsHp)) {
			rtnInfo.setResultMsg(existsHp);
			return rtnInfo;
		}
		// 5.分解传入医保xml
		DivideResultDTO divDto = new DivideResultDTO();
		DivideResultByXmlBp bp = new DivideResultByXmlBp();
		divDto = bp.exec(paramIn.getInsurPriceResult());
		// 6.组装数据
		if (divDto != null) {
			// 查询计算表id_stoep字段值
			String[] st = { "Id_stoep,Id_ent" };
			String id_stoep = "";
			String id_ent = "";
			// String[] appcodes = paramOp.getApplyNos();

			String strWhere = "";
			if (appcodes != null && appcodes.length > 0) {
				// 医嘱
				String codes = "";
				for (String code : appcodes) {
					if (!("").equals(codes)) {
						codes = codes + ",'" + code + "'";
					} else {
						codes = "'" + code + "'";
					}
				}
				strWhere = " id_stoep in (SELECT ID_STOEP FROM BL_CG_ITM_OEP itmoep" + " INNER JOIN PI_PAT pat on PAT.id_pat=ITMOEP.ID_PAT" + " INNER JOIN EN_ENT_OP  op on OP.id_ent=itmoep.id_ent" + " WHERE CODE_APPLY in (" + codes + ") AND op.TIMES_OP='" + paramOp.getOpTimes() + "' AND pat.CODE='" + paramOp.getPatCode() + "')";
			} else {
				// 挂号
				// IBLCiOrderToBlCgServiceImpl impl = new
				// IBLCiOrderToBlCgServiceImpl();
				// impl.SetCiOrderToPrice(appendBillParamDTOs, operatorInfoDTO,
				// FBoolean.FALSE);
				List<String> cgList = new ArrayList<String>();
				for (BlOrderAppendBillParamDTO billDto : appendBillParamDTOs) {
					if (!cgList.contains(billDto.getId_cg())) {
						cgList.add(billDto.getId_cg());
					}
				}
				// 挂号更新医保卡和id_ent信息
				IBlCgItmOepDORService i = ServiceFinder.find(IBlCgItmOepDORService.class);

				BlCgItmOepDO[] blCgItmOepDO = i.find(SqlUtils.getInSqlByIds(BlCgItmOepDO.ID_CGOEP, cgList), "", FBoolean.FALSE);
				if (blCgItmOepDO != null) {
					for (BlCgItmOepDO itmDO : blCgItmOepDO) {
						itmDO.setId_ent(paramIn.getId_ent());
						itmDO.setId_hp(appendBillParamDTOs[0].getId_hp());
						itmDO.setFg_hp(FBoolean.TRUE);
						itmDO.setStatus(DOStatus.UPDATED);
					}
				}
				IBlCgItmOepDOCudService cud = ServiceFinder.find(IBlCgItmOepDOCudService.class);
				cud.update(blCgItmOepDO);
				strWhere = "ID_STOEP='" + blCgItmOepDO[0].getId_stoep() + "'";
				// strWhere =
				// " id_stoep in (SELECT ID_STOEP FROM BL_CG_ITM_OEP itmoep" +
				// " INNER JOIN PI_PAT pat on PAT.id_pat=ITMOEP.ID_PAT" +
				// " WHERE EU_STTP='31' AND itmoep.ID_ENT='" +
				// paramIn.getId_ent() + "' AND pat.CODE='" +
				// paramOp.getPatCode() + "')";
			}

			List<BlStOepDO> stDoList = (List<BlStOepDO>) new DAFacade().findByCond(BlStOepDO.class, strWhere, "1", st);

			if (stDoList == null || stDoList.size() <= 0) {
				rtnInfo.setResultMsg("该患者划价信息有误！");
				return rtnInfo;
			} else {
				id_stoep = stDoList.get(0).getId_stoep();
				//挂号划价后结算表st还没有id_ent ,所以取参数传进来的id_ent
				if(stDoList.get(0).getId_ent()!=null){
					id_ent = stDoList.get(0).getId_ent();
				}else{
					id_ent=paramIn.getId_ent();
				}
			}

			// String tradeNo=divDto.getTradeno();
			// 7.分解汇总信息
			HealthFeeDTO feeDTO = new HealthFeeDTO();
			AssmHealthFeeDTOBp assmHealth = new AssmHealthFeeDTOBp();
			feeDTO = assmHealth.exec(divDto);
			// 8.明细信息
			List<HealthFeeItemDTO> feeItemDTO = assmHealth.ConvertTOHealthFeeItemDTOLst(divDto);

			//
			List<BlproparoepAggDO> blproparoepAggDOArr = assmHealth.ConvertTOBlproparoepAggDOLst(feeDTO, feeItemDTO, id_ent);
			blproparoepAggDOArr.get(0).getParentDO().setInputinfo(paramIn.getInsurPriceDivide());
			blproparoepAggDOArr.get(0).getParentDO().setOutputinfo(paramIn.getInsurPriceResult());
			// 9.组装分摊数据
			List<BlPropOepDO> blPropOepDO = assmHealth.ConvertTOPropOepDODTOLst(operatorInfoDTO, id_stoep);

			// 10.组装记账数据
			BlcgoepAggDO[] blcgoepAggDO = assmHealth.getBlcgoepAggDO(id_stoep);

			// 11.组装支付数据
			BlpaypatoepAggDO blpaypatoepAggDO = assmHealth.AssemblePayData(paramOp, patDoList.get(0).getId_pat(), operatorInfoDTO);

			// 12.组装医保返回数据的结算数据
			if (paramIn != null && !StringUtil.isEmptyWithTrim(paramIn.getInsurPriceResult())) {
				List<BlPayItmPatOepDO> itmlist = assmHealth.getInsurPayItmByXml(paramIn.getInsurPriceResult());
				FDouble hpAmt = FDouble.ZERO_DBL;
				for (BlPayItmPatOepDO payItmDo : itmlist) {
					// 如果当前为挂号调用已经计算付款金额 择不用计算此数据(自助机定义 结算为总金额，挂号传入为支付金额)
					if (!isEn)
						hpAmt = hpAmt.add(payItmDo.getAmt());
				}
				if (itmlist != null && itmlist.size() > 0) {
					if (blpaypatoepAggDO.getBlPayItmPatOepDO() != null && blpaypatoepAggDO.getBlPayItmPatOepDO().length > 0) {
						
						blpaypatoepAggDO.getBlPayItmPatOepDO()[0].setAmt(blpaypatoepAggDO.getBlPayItmPatOepDO()[0].getAmt().sub(hpAmt));
						itmlist.add(blpaypatoepAggDO.getBlPayItmPatOepDO()[0]);
					}
					blpaypatoepAggDO.setBlPayItmPatOepDO(itmlist.toArray(new BlPayItmPatOepDO[itmlist.size()]));
				}
			}

			//如果是就诊传入数据，重新计算合计金额
			if (isEn) {
				FDouble enAmt = FDouble.ZERO_DBL;
				for (BlPayItmPatOepDO payItemDO : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
					enAmt = enAmt.add(payItemDO.getAmt());
				}
				paramIn.setAmt(enAmt.toDouble());
			}
			// 13增加判断支付金额与传入的金额时候相等
			FDouble amt = new FDouble();
			if (blpaypatoepAggDO != null) {
				for (BlPayItmPatOepDO pay : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
					amt = amt.add(pay.getAmt());
				}
			}
			if(paramIn.getAmt() == null){
				throw new BizException("参数金额不能为空！");
			}
			FDouble inamt= new FDouble(paramIn.getAmt());
			if (!FDoubleUtils.isEqualWithTwoFDouble(amt, inamt)){
				rtnInfo.setResultMsg("结算金额与传入金额不相等！");
				return rtnInfo;
			}
			blpaypatoepAggDO.getParentDO().setAmt(amt);
			IBLCiOrderToBlCgService ser = ServiceFinder.find(IBLCiOrderToBlCgService.class);
			BlIncItmVsTypeDTO[] blinc = new BlIncItmVsTypeDTO[] {};
			if (("01").equals(paramOp.getPatType()))// 自费
			{
				blinc = ser.SettlementPayment(blcgoepAggDO, blpaypatoepAggDO, FBoolean.TRUE, FBoolean.FALSE, FBoolean.FALSE);

			} else if (("02").equals(paramOp.getPatType())) {// 医保

				blinc = ser.SettlementInsurPayment(null,blPropOepDO.toArray(new BlPropOepDO[blPropOepDO.size()]), blproparoepAggDOArr.toArray(new BlproparoepAggDO[blproparoepAggDOArr.size()]), blcgoepAggDO, blpaypatoepAggDO, FBoolean.TRUE, FBoolean.FALSE, FBoolean.FALSE);

			}
			// 13.发药窗口
			String disWindow = "";
			GetMedWindowsBP getWin = new GetMedWindowsBP();
			disWindow = getWin.getWindows(blinc);

			List<String> cgidList = new ArrayList<String>();
			for (BlcgoepAggDO aggDO : blcgoepAggDO) {
				cgidList.add(aggDO.getParentDO().getId_cgoep());
			}
			rtnInfo.setIdCgOepArray(cgidList.toArray(new String[cgidList.size()]));
			rtnInfo.setResultCode("0");
			rtnInfo.setResultMsg("支付成功！");
			rtnInfo.setDispenseWindow(disWindow);
		}

		return rtnInfo;
	}

	// 补充记账数据字段
	private void additional(BlOrderAppendBillParamDTO[] appendBillParamDTOs) throws BizException {
		if (!ArrayUtil.isEmpty(appendBillParamDTOs)) {
			HashMap<String, String> idHpAidSrv = new HashMap<String, String>();
			//1.获取未赋值的医保类型等级
			for (BlOrderAppendBillParamDTO billDto : appendBillParamDTOs) {
				if (StringUtil.isEmpty(billDto.getSd_hpsrvtp()) && !StringUtil.isEmpty(billDto.getId_hp())) {
					if (!idHpAidSrv.containsKey(billDto.getId_srv())) {
						idHpAidSrv.put(billDto.getId_srv(), billDto.getId_hp());
					}
				}
			}
			//2.判断是否需要提供医保等级赋值
			if (idHpAidSrv.size() != 0) {
				IHpsrvorcaRService service = ServiceFinder.find(IHpsrvorcaRService.class);
				String whereStr = "";
				//3.拼装条件 医保相同 并且物品服务相同
				for (Map.Entry<String, String> entry : idHpAidSrv.entrySet()) {
					whereStr = (StringUtil.isEmpty(whereStr)) ? "" : " OR ";
					whereStr = whereStr + "(" + HPSrvorcaDO.ID_HP + "='" + entry.getValue() + "' AND " + HPSrvorcaDO.ID_SRV + "='" + entry.getKey() + "')";
				}
				//4.获取对应的对照数据
				HPSrvorcaDO[] srvorcas = service.find(whereStr, "", FBoolean.FALSE);
				HashMap<String, String> srvtpMap = new HashMap<String, String>();
				//5.组装到map 中 以 idsrv 与 id_hp 相加为组件
				for (HPSrvorcaDO srvhpDO : srvorcas) {
					srvtpMap.put(srvhpDO.getId_srv()+srvhpDO.getId_hp(), srvhpDO.getSd_hpsrvtp());
				}
				for (BlOrderAppendBillParamDTO billDto : appendBillParamDTOs) {
					if (StringUtil.isEmpty(billDto.getSd_hpsrvtp()) && !StringUtil.isEmpty(billDto.getId_hp())) {
						billDto.setSd_hpsrvtp(srvtpMap.get(billDto.getId_srv()+billDto.getId_hp()));
					}
				}
			}
		}
	}

	private void writeLog(OpPayParam paramOp, InsurPriceInfo paramIn) {
		BLThirdItfLogger.info("pay{");
		BLThirdItfLogger.info("paramOp");
		BLThirdItfLogger.info("paramOp{");
		BLThirdItfLogger.info("Account:" + paramOp.getAccount());
		BLThirdItfLogger.info("Amt:" + paramOp.getAmt());
		BLThirdItfLogger.info("applynos:" + (paramOp.getApplyNos() != null ? CollectionUtils.toFArrayList(paramOp.getApplyNos()).serializeJson() : ""));
		BLThirdItfLogger.info("optimes:" + paramOp.getOpTimes());
		BLThirdItfLogger.info("operacode:" + paramOp.getOperaCode());
		BLThirdItfLogger.info("patcode:" + paramOp.getPatCode());
		BLThirdItfLogger.info("pattype:" + paramOp.getPatType());
		BLThirdItfLogger.info("pmcode:" + paramOp.getPmCode());
		BLThirdItfLogger.info("pttpcode:" + paramOp.getPtTpCode());
		BLThirdItfLogger.info("}");
		BLThirdItfLogger.info("InsurPriceInfo{");
		BLThirdItfLogger.info("entpcode:" + paramIn.getEntpCode());
		BLThirdItfLogger.info("id_ent:" + paramIn.getId_ent());
		BLThirdItfLogger.info("insurcardno:" + paramIn.getInsurCardNo());
		BLThirdItfLogger.info("insurepriceresult:" + paramIn.getInsurPriceResult());
		BLThirdItfLogger.info("operatorcode:" + paramIn.getOperatorCode());
		BLThirdItfLogger.info("patcode:" + paramIn.getPatCode());
		BLThirdItfLogger.info("presnoarray:" + (paramIn.getPresNoArray() != null ? CollectionUtils.toFArrayList(paramIn.getPresNoArray()).serializeJson() : ""));
		BLThirdItfLogger.info("}");
		BLThirdItfLogger.info("}");
	}
}
