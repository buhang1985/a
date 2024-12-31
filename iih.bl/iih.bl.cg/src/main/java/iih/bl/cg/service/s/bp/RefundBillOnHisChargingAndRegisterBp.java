package iih.bl.cg.service.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.params.BlParams;
import iih.bl.st.blhperror.d.BlHpErrorDO;
import iih.bl.st.blhperror.i.IBlhperrorCudService;
import iih.bl.st.blhperror.i.IBlhperrorRService;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.desc.BlStOepDODesc;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 退费医保交易、退号医保交易异常处理。医保交易成功，HIS交易失败，需要单独处理HIS 针对退费医保异常处理，目前只考虑全退，没有考虑全退重收
 * 
 * @author yang.lu 2017年6月26日11:32:13
 * 
 */
public class RefundBillOnHisChargingAndRegisterBp {

	/**
	 * 退费医保交易、退号医保交易异常处理。医保交易成功，HIS交易失败，需要单独处理HIS 针对退费医保异常处理，目前只考虑全退，没有考虑全退重收
	 * 
	 * @param id_stoep
	 *            原始结算ID
	 * @param id_ent
	 *            就诊id_ent(退费可以为null)
	 * @param eu_direct
	 *            原始收费方向：收费or退费
	 * @param eu_srctp
	 *            交易类型：医嘱收费的交易 or 就诊的交易
	 * @param operatorInfo
	 *            操作人员信息
	 * @param paypatOepAggDo
	 *            目前，只考虑全退，传参null。如果未来考虑退费重收后，为重收的收费
	 * @return BlIncItmVsTypeDTO
	 *         就诊异常处理后，返回的是null；退费异常处理后，返回的是BlIncItmVsTypeDTO[]
	 * @throws BizException
	 * @author yang.lu
	 */
	public BlIncItmVsTypeDTO[] exec(String id_stoep, String id_ent, Integer eu_direct, Integer eu_srctp, OperatorInfoDTO operatorInfo, BlpaypatoepAggDO paypatOepAggDo) throws BizException {
		// 1.判断是收费还是退费
		if (eu_direct == BookRtnDirectEnum.REFUND) // 退费
		{
			DAFacade dafacade = new DAFacade();
			// 2.判断交易类型
			if (eu_srctp == FeeOriginEnum.ORDERS_FEE) // 医嘱产生
			{
				// 单独进行HIS的退费,需要查询部分参数，装配接口
				// 2.1查询退费的记账主键
				String[] fields = { "id_cgoep", "id_cgitmoep", "Id_orsrv", "Fg_mm", "Id_mm", "Srvu", "Id_dep_mp", "Id_dep_wh", "Eu_srctp", "Quan", "Sd_srvtp" };
				String[] fields1 = { "fg_feertnable" };
				List<BlCgItmOepDO> blCgItmOepDOLst = (List<BlCgItmOepDO>) dafacade.findByCond(BlCgItmOepDO.class, " id_stoep='" + id_stoep + "'", fields);
				if (blCgItmOepDOLst == null || blCgItmOepDOLst.size() == 0) {
					throw new BizException("该结算下的记账明细不存在 ! ");
				}
				List<String> blCgOepLst = new ArrayList<String>();
				List<BlRefundItmDTO> blRefundItmDTOLst = new ArrayList<BlRefundItmDTO>();
				IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
				// 2.2组装退费信息
				for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOLst) {
					if (!blCgOepLst.contains(blCgItmOepDO.getId_cgoep())) {
						blCgOepLst.add(blCgItmOepDO.getId_cgoep());
					}

					BlRefundItmDTO blRefundItmDTO = new BlRefundItmDTO();
					blRefundItmDTO.setId_cgoep(blCgItmOepDO.getId_cgoep());
					blRefundItmDTO.setId_cditmoep(blCgItmOepDO.getId_cgitmoep());
					blRefundItmDTO.setId_orsrv(blCgItmOepDO.getId_orsrv());
					blRefundItmDTO.setFg_mm(blCgItmOepDO.getFg_mm());
					blRefundItmDTO.setId_mm(blCgItmOepDO.getId_mm());
					blRefundItmDTO.setReq_unit_id(blCgItmOepDO.getSrvu());
					blRefundItmDTO.setId_dep(blCgItmOepDO.getId_dep_mp());
					blRefundItmDTO.setId_dep_wh(blCgItmOepDO.getId_dep_wh());
					blRefundItmDTO.setEu_srctp(blCgItmOepDO.getEu_srctp());
					blRefundItmDTO.setQuan_refund(blCgItmOepDO.getQuan());
					// TODO:退费数量，医保不考虑补费退。如果医保支持部分退费了，此处需要修改
					if (blCgItmOepDO.getSd_srvtp() != null && blCgItmOepDO.getSd_srvtp().indexOf("01") == 0) // 药品
					{
						OpDgRtnAmountDTO opDgRtnAmountDTO = new OpDgRtnAmountDTO();
						opDgRtnAmountDTO.setId_orsrv(blCgItmOepDO.getId_orsrv());
						opDgRtnAmountDTO.setCharged_amount(blCgItmOepDO.getQuan());
						OpDgRtnAmountDTO[] opDgRtnAmountDTOs = iMpDgOutService.getOpDgRtnAmount(new OpDgRtnAmountDTO[] { opDgRtnAmountDTO });
						if (opDgRtnAmountDTOs != null && opDgRtnAmountDTOs.length > 0) {
							// 设置可退数
							blRefundItmDTO.setQuan_refund(opDgRtnAmountDTOs[0].getRtn_amount());
							// 是否领药
							if (opDgRtnAmountDTOs[0].getFg_get().booleanValue()) {
								blRefundItmDTO.setFg_drug_provide(FBoolean.TRUE); // 已领药
							} else {
								blRefundItmDTO.setFg_drug_provide(FBoolean.FALSE); // 未发药
							}
						}
					} else // 医技
					{
						List<OrdSrvDO> ordSrvDOLst = (List<OrdSrvDO>) dafacade.findByCond(OrdSrvDO.class, " id_orsrv='" + blCgItmOepDO.getId_orsrv() + "'", fields1);
						if (ordSrvDOLst != null && ordSrvDOLst.size() > 0) {
							if (!ordSrvDOLst.toArray(new OrdSrvDO[0])[0].getFg_feertnable().booleanValue()) // 医技
							{
								blRefundItmDTO.setQuan_refund(new FDouble(0));
							} else {
								blRefundItmDTO.setQuan_refund(blCgItmOepDO.getQuan());
							}
						} else {
							blRefundItmDTO.setQuan_refund(blCgItmOepDO.getQuan());
						}
					}
					blRefundItmDTOLst.add(blRefundItmDTO);
				}

				// TODO:3.目前，不考虑退费重收，因此调用红冲
				refundBillOnHis_insurException(id_stoep, blCgOepLst.toArray(new String[0]), blRefundItmDTOLst.toArray(new BlRefundItmDTO[0]), operatorInfo);
			} else // 就诊产生
			{
				// 3.单独进行HIS的退费退号
				IEnOutCmdService IEnOutCmdService = ServiceFinder.find(IEnOutCmdService.class);
				IEnOutCmdService.cancOpReg4Bl(id_ent); // 退号没有返回值
			}

			// 4.需要改异常表的状态
			updateBlHpErrorFgRollback(id_stoep);

			BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();
			// 5.因为医保要打红冲票，因此要跳号。
			if (bLCancelSettlementImplBp.getFPrintRedInc(id_ent).booleanValue()) {
				return getRedInvoiceAndSetNextInvoice(operatorInfo, id_stoep);
			} else {
				return null;
			}

		} else // 收费的医保异常，HIS端不用处理，仅处理医保端，故返回null
		{
			return null;
		}
	}

	/**
	 * 单独退医保（HIS）,前台不用传分解后的分摊数据
	 */
	private void refundBillOnHis_insurException(String id_stoep, String[] strCgOepArr, BlRefundItmDTO[] refundItmDtoArr, OperatorInfoDTO operatorInfo) throws BizException {

		// 1.通过结算流水号获得此次的交易信息
		IBlstoepRService stoepService = ServiceFinder.find(IBlstoepRService.class);
		String strWhere = BlStOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + id_stoep + "'";
		BlStOepDO[] stOepDoArr = stoepService.find(strWhere, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(stOepDoArr)) {
			throw new BizException("查询结算信息失败，没有找到该结算流水号对应的结算");
		}

		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();
		FBoolean PrintOnlyOneInvoice = BlParams.BLSTOEP0003();
		FBoolean AllRefundAndAllCharge = FBoolean.TRUE;
		FBoolean AllRefund = FBoolean.FALSE;

		TimeService timeService = new TimeServiceImpl();
		FDateTime strDateTime = timeService.getUFDateTime();
		// 2.红冲原记账，结算信息，发票信息，收付款信息，修改医嘱记账标志2，发事件 。
		FBoolean printRedInc = bLCancelSettlementImplBp.getFPrintRedInc(stOepDoArr[0].getId_ent());
		bLCancelSettlementImplBp.redBackBill_withoutProp(stOepDoArr[0].getId_stoep(), strCgOepArr, refundItmDtoArr, operatorInfo, PrintOnlyOneInvoice, AllRefundAndAllCharge, AllRefund, strDateTime,
				printRedInc, null);

		// 3.红冲分摊数据
		// 查找原应收信息
		bLCancelSettlementImplBp.RedBackBlCg_blproparoepAggDO(stOepDoArr[0].getId_stoep());
	}

	/**
	 * 对应医保异常交易记录处理后，需要修改医保异常交易记录标志
	 * 
	 * @param id_stoep
	 *            需要处理的结算对应的医保异常交易记录
	 * @throws BizException
	 */
	private void updateBlHpErrorFgRollback(String id_stoep) throws BizException {
		IBlhperrorRService iBlhperrorRService = ServiceFinder.find(IBlhperrorRService.class);
		BlHpErrorDO[] blHpErrorDOs = iBlhperrorRService.find(" id_stoep='" + id_stoep + "'", "", FBoolean.FALSE);
		if (blHpErrorDOs == null || blHpErrorDOs.length == 0) {
			throw new BizException("查询医保异常交易记录失败！");
		}
		blHpErrorDOs[0].setFg_rollback(FBoolean.TRUE);
		blHpErrorDOs[0].setStatus(DOStatus.UPDATED);
		IBlhperrorCudService iBlhperrorCudService = ServiceFinder.find(IBlhperrorCudService.class);
		BlHpErrorDO[] blHpErrorDOs1 = iBlhperrorCudService.save(blHpErrorDOs);
		if (blHpErrorDOs1 == null || blHpErrorDOs1.length == 0) {
			throw new BizException("修改医保异常交易记录失败！");
		}
	}

	/**
	 * 根据原结算号，查询红冲结算，红冲发票信息，红冲收付款， 返回需要打印的发票信息，且设置下一个发票号为当前票号
	 * 
	 * @param operatorInfo
	 *            操作员信息
	 * @param orgin_id_stoep
	 *            原结算信息
	 * @return 返回需要打印的发票信息
	 * @throws BizException
	 */
	private BlIncItmVsTypeDTO[] getRedInvoiceAndSetNextInvoice(OperatorInfoDTO operatorInfo, String orgin_id_stoep) throws BizException {
		// 查询红冲结算：
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] red_blStOepDOs = iBlstoepRService.find(" id_par='" + orgin_id_stoep + "'", "", FBoolean.FALSE);
		if (red_blStOepDOs == null || red_blStOepDOs.length == 0) {
			throw new BizException("红冲结算不存在 ! ");
		}
		// 查红冲发票
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] red_blincoepAggDOArrx1 = iBlincoepRService.find(BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='" + red_blStOepDOs[0].getId_stoep() + "'", "", FBoolean.FALSE);
		// 查红冲收付款
		IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO red_blpaypatoepAggDO = iBlpaypatoepRService.findById(red_blStOepDOs[0].getId_paypatoep());
		// 提取打印的发票信息
		BLCiOrderToBlCgServiceImplBp handlerBp = new BLCiOrderToBlCgServiceImplBp();
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = handlerBp.handlerIncInfoDtos(FBoolean.FALSE, FBoolean.TRUE, red_blStOepDOs[0], red_blincoepAggDOArrx1, red_blpaypatoepAggDO);

		// 跳号：设置下张票号为当前票
		/*IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);
		iBLInvoiceService.NextInvoiceNoUpdateCurNo(operatorInfo.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);*/

		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		incService.nextInvoiceNo(operatorInfo.getId_emp(), Context.get().getClientHost(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		
		return blIncItmVsTypeDTOs;
	}

}
