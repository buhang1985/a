package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.ep.OepCgEP;
import iih.bl.cg.ep.OepIncEP;
import iih.bl.cg.ep.OepStEP;
import iih.bl.cg.service.d.BL_Register_RefundDTO;
import iih.bl.cg.service.d.BlRefundItmDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepMDOCudService;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.service.i.IBLPropMaintainService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;

import java.util.ArrayList;
import java.util.List;

import javax.tools.Tool;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

public class RegisterRefundAndSettlementBp {

	/**
	 * 退费重收(将id_cgoep下所有明细都退掉)
	 * 
	 * @param id_cgoep
	 *            ：需要退的就诊
	 * @param operatorInfoDTO
	 *            ：操作员信息
	 * @param printRedInc
	 *            :是否打印红冲票
	 * @return 退费成功返回发票信息
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(BL_Register_RefundDTO id_cgoep_and_ent, OperatorInfoDTO operatorInfoDTO, BlpaypatoepAggDO blpaypatoepAggDO, FBoolean isNew, FBoolean fgRealpay) throws BizException {
		
		if(operatorInfoDTO != null && !StringUtil.isEmpty(operatorInfoDTO.getId_emp())){
			Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_ID_EMP, operatorInfoDTO.getId_emp());
		}
		
		String condstr = "";
		if(fgRealpay==null)
			fgRealpay = FBoolean.TRUE;
		BlIncItmVsTypeDTO[] BlIncItmVsTypeDTO_temp = null;
		List<String> id_stoep_list = new ArrayList<String>();
		// 1.获得挂号对应的记账信息
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);

		condstr = "";
		condstr = " a0.id_cgoep='" + id_cgoep_and_ent.getId_cgoep() + "' ";

		BlcgoepAggDO[] register_blcgoepAggDO = iBlcgoepRService.find(condstr, "", FBoolean.FALSE);
		if (null == register_blcgoepAggDO || register_blcgoepAggDO.length == 0) {
			throw new BizException("查询挂号对应的原门诊记账信息失败。\r\n就诊主键:" + id_cgoep_and_ent.getId_ent());
		}
		id_stoep_list.clear();// 清空
		// 2.获得需要退费的所有结算号，
		for (int ii = 0; ii < register_blcgoepAggDO.length; ii++) {
			BlCgItmOepDO[] BlCgItmOepDO_arr = register_blcgoepAggDO[ii].getBlCgItmOepDO();
			for (int j = 0; j < BlCgItmOepDO_arr.length; j++) {
				if (!id_stoep_list.contains(BlCgItmOepDO_arr[j].getId_stoep())) {
					id_stoep_list.add(BlCgItmOepDO_arr[j].getId_stoep());
				}
			}
		}
		// 查看此笔交易是否是医保交易
		//FBoolean fbIsHp = FBoolean.FALSE;
		// 3.根据结算号取结算号下的退款信息
		if (id_stoep_list != null && id_stoep_list.size() > 0) {
			if (id_stoep_list.size() > 1) {
				throw new BizException("退号请分开操作");
			}
			String[] id_stoep_arr = id_stoep_list.toArray(new String[] {});

			List<String> id_cgoep_arr_list = new ArrayList<String>();
			List<BlRefundItmDTO> BlRefundItmDTO_list = new ArrayList<BlRefundItmDTO>();
			// 用结算反查记账
			for (int ii = 0; ii < register_blcgoepAggDO.length; ii++) {
				BlCgItmOepDO[] BlCgItmOepDO_arr = register_blcgoepAggDO[ii].getBlCgItmOepDO();

				for (int j = 0; j < BlCgItmOepDO_arr.length; j++) {
					if (id_stoep_arr[0].equals(BlCgItmOepDO_arr[j].getId_stoep())) {
						if (!id_cgoep_arr_list.contains(BlCgItmOepDO_arr[j].getId_cgoep())) {
							id_cgoep_arr_list.add(BlCgItmOepDO_arr[j].getId_cgoep());
						}
						BlRefundItmDTO blRefundItmDTO = new BlRefundItmDTO();
						blRefundItmDTO.setId_cgoep(BlCgItmOepDO_arr[j].getId_cgoep());
						blRefundItmDTO.setId_cditmoep(BlCgItmOepDO_arr[j].getId_cgitmoep());
						blRefundItmDTO.setQuan_refund(BlCgItmOepDO_arr[j].getQuan());
						blRefundItmDTO.setEu_srctp(BlCgItmOepDO_arr[j].getEu_srctp());
						BlRefundItmDTO_list.add(blRefundItmDTO);

						//fbIsHp = BlCgItmOepDO_arr[j].getFg_hp();
					}
				}
			}

			// 4.获得该结算下对应的原始支付信息 当blpaypatoepAggDO为null 的时候 则认为当前调用的是 SC就诊域的操作
			if (blpaypatoepAggDO == null) {
				// 1. 查找原结算信息
				String[] fields = { "id_paypatoep" };
				DAFacade dafacade = new DAFacade();
				List<BlStOepDO> blStOepDOLst = (List<BlStOepDO>) dafacade.findByCond(BlStOepDO.class, " id_stoep='" + id_stoep_list.toArray(new String[0])[0] + "'", fields);
				
				if (null == blStOepDOLst || blStOepDOLst.size() == 0) {
					throw new BizException("查询原门诊结算信息失败");
				}
				// 2. 获得该结算下对应的支付信息
				IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
				BlpaypatoepAggDO[] blpaypatoepAggDO_arr = iBlpaypatoepRService.find(" a0.id_paypatoep='" + blStOepDOLst.toArray(new BlStOepDO[0])[0].getId_paypatoep() + "'", "", FBoolean.FALSE);
				if (null == blpaypatoepAggDO_arr || blpaypatoepAggDO_arr.length == 0) {
					// throw new BizException("查询患者收付款信息失败");
					// 获取当前结算是否有收付款信息 如果没有 断定是诊间挂号数据 直接进行删除功能 删除记账，记账明细 结算信息
					// 2017年11月12日 yang.lu
					OepStEP step = new OepStEP();
					
					BlStOepDO stoep = step.getBlStOepDOByIdSt( id_stoep_list.toArray(new String[0])[0]);

					if (StringUtil.isEmpty(stoep.getId_paypatoep())) {

						IBlcgoepRService cgService = ServiceFinder.find(IBlcgoepRService.class);
						BlcgoepAggDO[] cgs = cgService.find(" id_cgoep in (SELECT ID_CGOEP FROM BL_CG_ITM_OEP WHERE ID_STOEP='" + stoep.getId_stoep() + "')", "", FBoolean.FALSE);
						FDateTime nowTime = AppUtils.getServerDateTime();
						//红冲结算数据
						BlStOepDO redStoep = step.redBack_StOep(stoep, 
								operatorInfoDTO, 
								null, 
								nowTime, 
								cgs[0].getBlCgItmOepDO()[0].getEu_srctp(),
								null);
						//红冲记账数据
						OepCgEP cgep=new OepCgEP();
						BlcgoepAggDO[] redcgs=cgep.redBack_CgOep(cgs,  nowTime,operatorInfoDTO, FBoolean.FALSE, FBoolean.TRUE, redStoep.getId_stoep());
						OepIncEP incep=new OepIncEP();
						incep.redback_BlIncOep(FBoolean.FALSE, stoep, redStoep.getId_stoep(), FBoolean.FALSE, FBoolean.FALSE, nowTime, operatorInfoDTO, redcgs);
						return null;
					}

				} else {
					blpaypatoepAggDO = blpaypatoepAggDO_arr[0];
					blpaypatoepAggDO.getParentDO().setSd_pttp(id_cgoep_and_ent.getSd_pttp());
					blpaypatoepAggDO.getParentDO().setId_paypatoep(null);
					if (!id_cgoep_and_ent.getAllRefundAndAllCharge().booleanValue()) // 全退重收不变
					{
						if (blpaypatoepAggDO.getParentDO().getEu_direct() == BookRtnDirectEnum.REFUND) {
							blpaypatoepAggDO.getParentDO().setEu_direct(BookRtnDirectEnum.CHARGES);
						} else {
							blpaypatoepAggDO.getParentDO().setEu_direct(BookRtnDirectEnum.REFUND);
						}
					}
					blpaypatoepAggDO.getParentDO().setStatus(DOStatus.NEW);
					BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDO.getBlPayItmPatOepDO();

					for (BlPayItmPatOepDO blPayItmPatOepDO : blPayItmPatOepDOArr) {
						blPayItmPatOepDO.setId_paypatoep(null);
						blPayItmPatOepDO.setId_payitmpatoep(null);
						if (!id_cgoep_and_ent.getAllRefundAndAllCharge().booleanValue()) // 全退重收不变
						{
							if (blPayItmPatOepDO.getEu_direct() == BookRtnDirectEnum.REFUND) {
								blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
							} else {
								blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
							}
						}
						blPayItmPatOepDO.setFg_realpay(fgRealpay);
						blPayItmPatOepDO.setStatus(DOStatus.NEW);
					}
				}
			}
			
			
			// 调用退费和重接函数
			//if (!fbIsHp.booleanValue()) // 非医保
			
			// 判断是否医保结算
 			if(id_cgoep_and_ent.getBlPropOepDO() == null || id_cgoep_and_ent.getBlPropOepDO().size() == 0)	
			{
				if (id_cgoep_and_ent.getAllRefundAndAllCharge().booleanValue()) // 全退重收
				{
					RefundAndSettlementBp bp = new RefundAndSettlementBp();
					BlIncItmVsTypeDTO_temp = bp.exec(id_stoep_arr[0], id_cgoep_arr_list.toArray(new String[] {}), BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), operatorInfoDTO, blpaypatoepAggDO); // 重划重收强制不打印红冲票
				} else // 全退
				{
					RefundFeeBp bp = new RefundFeeBp();
					BlIncItmVsTypeDTO_temp = bp.exec(id_stoep_arr[0], 
							id_cgoep_arr_list.toArray(new String[] {}), 
							BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), 
							operatorInfoDTO, blpaypatoepAggDO, 
							FBoolean.TRUE, 
							id_cgoep_and_ent.getPrintRedInc(),
							null);
				}

			} else {
				// 医保
				BlPropOepDO[] blPropOepDOArr = (BlPropOepDO[]) id_cgoep_and_ent.getBlPropOepDO().toArray(new BlPropOepDO[0]);
				BlproparoepAggDO[] blproparoepAggDOArr = (BlproparoepAggDO[]) id_cgoep_and_ent.getBlproparoepAggDO().toArray(new BlproparoepAggDO[0]);

				for (BlproparoepAggDO blproparoepAggDO : blproparoepAggDOArr) {
					blproparoepAggDO.getParentDO().setId_grp(blPropOepDOArr[0].getId_grp());
					blproparoepAggDO.getParentDO().setId_org(blPropOepDOArr[0].getId_org());
				}
				// 医保全退
				if (!FBoolean.TRUE.equals(isNew)) {

					RefundInsurBp bp = new RefundInsurBp();
					BlIncItmVsTypeDTO_temp = bp.exec(blPropOepDOArr, blproparoepAggDOArr, id_stoep_arr[0], id_cgoep_arr_list.toArray(new String[] {}), BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), operatorInfoDTO, blpaypatoepAggDO, id_cgoep_and_ent.getPrintRedInc());
				} else {

					RefundFeeBp bp = new RefundFeeBp();
					BlIncItmVsTypeDTO_temp = bp.exec(id_stoep_arr[0], 
							id_cgoep_arr_list.toArray(new String[] {}), 
							BlRefundItmDTO_list.toArray(new BlRefundItmDTO[] {}), 
							operatorInfoDTO, 
							blpaypatoepAggDO, 
							FBoolean.TRUE, 
							id_cgoep_and_ent.getPrintRedInc(),
							null);
					BlPropOepDO[] blPropOepDOArr_recharge = null;
					BlproparoepAggDO[] blproparoepAggDOArr_recharge = null;
					if (id_cgoep_and_ent.getBlproparoepAggDO_recharge() != null) {
						blPropOepDOArr_recharge = (BlPropOepDO[]) id_cgoep_and_ent.getBlPropOepDO_recharge().toArray(new BlPropOepDO[0]);
						blproparoepAggDOArr_recharge = (BlproparoepAggDO[]) id_cgoep_and_ent.getBlproparoepAggDO_recharge().toArray(new BlproparoepAggDO[0]);
					}
					// 保存医保分摊，含三部分数据：
					RefundAndSettlementInsurToSaveBp saveBp = new RefundAndSettlementInsurToSaveBp();
					saveBp.exec(blPropOepDOArr, blproparoepAggDOArr, blPropOepDOArr_recharge, blproparoepAggDOArr_recharge, id_stoep_arr[0]);
				}
			}
		}

		return BlIncItmVsTypeDTO_temp;
	}

}
