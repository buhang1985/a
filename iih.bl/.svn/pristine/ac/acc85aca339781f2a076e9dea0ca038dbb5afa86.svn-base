package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.bp.DoOepFgAccAmtAcc;
import iih.bl.cg.dto.d.BlCgoepAggAndPrintRedIncItmDTO;
import iih.bl.cg.dto.d.OpRefund4EsDTO;
import iih.bl.cg.event.OpRefundEvent;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlConst;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.service.i.IBLPropMaintainService;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保退费（全退）,前台需要传入分摊数据
 * 
 * @author yang.lu 2017年6月26日
 *
 */
public class RefundInsurBp {
	/**
	 * 医保退费（全退）,前台需要传入分摊数据
	 * 
	 * @param blPropOepDOArr
	 *            退费生成的分摊1
	 * @param blproparoepAggDOArr
	 *            退费生成的分摊2
	 * @param id_stoep
	 *            ：退费结算号
	 * @param id_cgoep_arr
	 *            ：退费的记账主键数组
	 * @param id_cditmoep_arr
	 *            :退费的详细数组（id_cgoep,id_cditmoep,退费数量）
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param blpaypatoepAggDO
	 *            ：收付款信息
	 * @return 需要打印的红冲发票信息
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, String id_stoep, String[] id_cgoep_arr, BlRefundItmDTO[] id_cditmoep_arr, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean isSc) throws BizException {

		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOs0 = iBlstoepRService.find(" a0.id_stoep='" + id_stoep + "'", "", FBoolean.TRUE);
		if (null == blStOepDOs0 || blStOepDOs0.length == 0) {
			throw new BizException("查询原门诊结算信息失败");
		}
		IEnthpRService iEnthpRService = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOArr = iEnthpRService.find(" id_ent='" + blStOepDOs0[0].getId_ent() + "'", "", FBoolean.TRUE);
		if (null == entHpDOArr || entHpDOArr.length == 0) {
			throw new BizException("查询就诊医保计划信息失败");
		}
		
		String id_hp = "";
		for (EntHpDO entHpDO : entHpDOArr) {
			if (entHpDO.getFg_maj().booleanValue()) {
				id_hp = entHpDO.getId_hp();
				break;
			}
		}
		BlcgoepAggDO[] blcgoepAggDO_arr = redBackBill_insur(blPropOepDOArr, blproparoepAggDOArr, id_stoep, id_cgoep_arr, id_cditmoep_arr, operatorInfoDTO, id_hp, FBoolean.TRUE, FBoolean.FALSE, blpaypatoepAggDO, isSc);
		if (blpaypatoepAggDO != null) // 挂号退费，此处有可能为null
		{
			// 如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
			DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
			doOepFgAccAmtAccBp.doPayByPrepay(new BlpaypatoepAggDO[] { blpaypatoepAggDO });
		}
		// 门诊退费时 参数为null 如果为就诊调用则不为null
		if (isSc == null) {
			List<String> id_orsrvLst = new ArrayList<String>();
			if (blcgoepAggDO_arr == null || blcgoepAggDO_arr.length == 0)// 全退
			{

				boolean RefundFg_mm = false; // 物品退费
				// 需要的工作：调用物品，退物品
				// 退物品有两种情况：1.药品已发，且药品处已做退费。2.药品本来就未发放
				List<OpDgRtnAmountDTO> opDgRtnAmountDTO_list = new ArrayList<OpDgRtnAmountDTO>();
				for (int i = 0; i < id_cditmoep_arr.length; i++) {
					id_orsrvLst.add(id_cditmoep_arr[i].getId_orsrv());
					if (("Y").equals(id_cditmoep_arr[i].getFg_mm())) {
						RefundFg_mm = true;

					}
				}

				OpDgRtnAmountDTO[] opDgRtnAmountDTOs = opDgRtnAmountDTO_list.toArray(new OpDgRtnAmountDTO[] {});

				if (RefundFg_mm) // 物品退费
				{
					if (id_orsrvLst != null && id_orsrvLst.size() > 0) {
						// 调用门急诊药品退费后回写发放明细数据
						IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
						iMpDgOutService.writebackDispItmAfterRefundCharge(id_orsrvLst.toArray(new String[0]));
					}
				}
			} else {
				throw new BizException("医保不支持部分退费");
			}
		}
		if (blcgoepAggDO_arr != null && blcgoepAggDO_arr.length > 0 && blcgoepAggDO_arr[0].getBlCgItmOepDO() != null && blcgoepAggDO_arr[0].getBlCgItmOepDO().length > 0)
			invokeRefundEvent(blcgoepAggDO_arr[0].getBlCgItmOepDO()[0].getId_stoep());
		BLCancelSettlementImplBp bp = new BLCancelSettlementImplBp();
		// 是否打印医保红冲发票 2017-3-28
		// 读配置参数:
		FBoolean FPrintInsurRedInc = bp.getFPrintRedInc(blStOepDOs0[0].getId_ent());
		if (FPrintInsurRedInc.booleanValue()) {

			BLCiOrderToBlCgServiceImplBp bLCiOrderToBlCgServiceImplBp = new BLCiOrderToBlCgServiceImplBp();
			BlStOepDO[] blStOepDOs = iBlstoepRService.find(" id_par='" + blStOepDOs0[0].getId_stoep() + "'", "", FBoolean.TRUE); // 查询出红冲的结算
			IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
			String strWhere = String.format(" id_stoep='%s'", blStOepDOs[0].getId_stoep());
			BlincoepAggDO[] blincoepAggDO = iBlincoepRService.find(strWhere, "", FBoolean.TRUE); // 查询出红冲的发票
			BlIncItmVsTypeDTO[] incInfoDtoLst = bLCiOrderToBlCgServiceImplBp.assemblyIncInfoDtos(blStOepDOs[0], blincoepAggDO);
			return incInfoDtoLst;
		} else {
			return null;
		}

	}

	/**
	 * 出发退费事件
	 * 
	 * @param id_st
	 * @throws BizException
	 */
	private void invokeRefundEvent(String id_st) throws BizException {
		OpRefundEvent event = new OpRefundEvent();
		OpRefund4EsDTO eventSource = new OpRefund4EsDTO();
		eventSource.setId_st(id_st);
		event.invoke(eventSource);
	}

	/**
	 * 医保红冲
	 * 
	 * @param id_stoep
	 *            退费的结算ID
	 * @param id_cgoep
	 *            退费的记账主键
	 * @param BlRefundItmDTO
	 *            :id_cgoep,id_cditmoep,退费数量
	 * @param id_hp
	 *            :结算对应的医保主计划
	 * @param operatorInfoDTO
	 * @param PrintOnlyOneInvoice
	 *            ：多次就诊一次结算打印一张发票还是多张发票
	 * @param AllRefundAndAllCharge
	 *            :是否重划重收
	 * @param blpaypatoepAggDO
	 *            ：红冲对应的支付方式
	 * @param printRedInc
	 *            是否打印红冲票。如果传参为null，则由bd_hp配置决定，门诊退费传参为null
	 * @throws BizException
	 */
	private BlcgoepAggDO[] redBackBill_insur(BlPropOepDO[] blPropOepDOArr, BlproparoepAggDO[] blproparoepAggDOArr, String id_stoep, String[] id_cgoep, BlRefundItmDTO[] id_cditmoep, OperatorInfoDTO operatorInfoDTO, String id_hp, FBoolean PrintOnlyOneInvoice, FBoolean AllRefundAndAllCharge, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean printRedInc) throws BizException {
		// BlcgoepAggDO[] blcgoepAggDOArr= redBackBill(blpaypatoepAggDO,
		// id_stoep, id_cgoep,
		// id_cditmoep, operatorInfoDTO,
		// id_hp, PrintOnlyOneInvoice, AllRefundAndAllCharge);
		// 1.做自费的全退费
		TimeService timeService = new TimeServiceImpl();
		FDateTime fDateTime = timeService.getUFDateTime();
		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();

		BlCgoepAggAndPrintRedIncItmDTO blCgoepAggAndPrintRedIncItmDTO = bLCancelSettlementImplBp.redBackBill_insur(blPropOepDOArr, blproparoepAggDOArr, id_stoep, id_cgoep, id_cditmoep, operatorInfoDTO, PrintOnlyOneInvoice, AllRefundAndAllCharge, blpaypatoepAggDO, FBoolean.TRUE, fDateTime, printRedInc);
		BlcgoepAggDO[] blcgoepAggDOArr = (BlcgoepAggDO[]) blCgoepAggAndPrintRedIncItmDTO.getBlCgoepAggDO().toArray(new BlcgoepAggDO[0]);

		// 2.退医保分摊部分
		// 获取红冲ST的id_stoep
		DAFacade dafacade = new DAFacade();
		List<BlStOepDO> blStOepDOList = (List<BlStOepDO>) dafacade.findByCond(BlStOepDO.class, " id_par='" + id_stoep + "'");
		if (ListUtil.isEmpty(blStOepDOList) || blStOepDOList.size() == 0) {
			throw new BizException("查询患者结算信息失败");
		}
		String id_stoep_new = blStOepDOList.get(0).getId_stoep();
		for (BlPropOepDO blPropOepDO : blPropOepDOArr) {
			blPropOepDO.setId_stoep(id_stoep_new);
		}
		IBLPropMaintainService iBLPropMaintainService = ServiceFinder.find(IBLPropMaintainService.class);
		iBLPropMaintainService.saveOepProp(blPropOepDOArr, blproparoepAggDOArr);

		return blcgoepAggDOArr;
	}
}
