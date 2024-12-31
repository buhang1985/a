package iih.bl.cg.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.cg.dto.d.OpCancAcc4EsDTO;
import iih.bl.cg.ep.OepReCgEP;
import iih.bl.cg.event.OpAccEvent;
import iih.bl.cg.event.OpCancAccEvent;
import iih.bl.cg.listener.qry.GetOpFund4IpEsDTOsByIdsQry;
import iih.bl.cg.service.s.bp.CancelReserveBP;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.DataCloneUtils;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 退记账的药品
 * 
 * @author yanglu
 *
 */
public class DrawbackAccDrugBP {
	/**
	 * 退记账的药品
	 * 
	 * @param entId
	 *            就诊ID
	 * @param backDrugMap
	 *            退药品MAP，[key:医嘱服务ID，value:需退数量]
	 * @throws BizException
	 * @author yanglu
	 */
	public void exec(String entId, Map<String, FDouble> backDrugMap) throws BizException {
		// 1.查找需要退账的记账信息
		OepReCgEP oepReCgEP = new OepReCgEP();
		BlcgoepAggDO[] cgAggDos = oepReCgEP.getAggCgOepDOs(entId);
		if (ArrayUtil.isEmpty(cgAggDos)) {
			// 没有找到就诊信息
			return;
		}
		// 2.过滤Agg中无效数据
		List<BlcgoepAggDO> aggDoList = oepReCgEP.getOrignAggDOs(cgAggDos);
		// 3.再次过滤 退费的医嘱
		List<BlcgoepAggDO> aggDosList = getFilterAggDO(aggDoList, backDrugMap);
		// 4.获取全退并保存的记账数据
		BlcgoepAggDO[] retCgAggOep = RetCgAggOep(aggDosList);
		if (retCgAggOep != null && retCgAggOep.length != 0) {
			updateAmtAcc(retCgAggOep);
		}
		// 5.获取重收的记账数据
		BlcgoepAggDO[] recCgAggOep = RecCgAggOep(aggDosList, backDrugMap);
		if (recCgAggOep != null && recCgAggOep.length != 0) {
			updateAmtAcc(recCgAggOep);
		}
		// 6.更改医嘱状态
		changeCiStatus(aggDosList, backDrugMap);
	}

	/**
	 * 过滤只退费的医嘱
	 * 
	 * @param aggDoList
	 * @param backDrugMap
	 * @return
	 */
	private List<BlcgoepAggDO> getFilterAggDO(List<BlcgoepAggDO> aggDoList, Map<String, FDouble> backDrugMap) {
		List<BlcgoepAggDO> aggDOsList = new ArrayList<BlcgoepAggDO>();
		for (BlcgoepAggDO dto : aggDoList) {
			BlCgItmOepDO[] blCgItmOepDOs = dto.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				if (blCgItmOepDO.getId_par() != null && !"~".equals(blCgItmOepDO.getId_par())) {
					continue;
				}
				if (backDrugMap.get(blCgItmOepDO.getId_orsrv()) != null) {
					aggDOsList.add(dto);
				}
			}
		}
		return aggDOsList;
	}

	/**
	 * 调用系统销账
	 * 
	 * @param refundBillParamDTO
	 * @param code_enttp
	 * @return
	 * @throws BizException
	 */
	private String setRefundBill(BlOrderAppendBillParamDTO[] refundBillParamDTO, String code_enttp) throws BizException {
		CancelReserveBP bp = new CancelReserveBP();
		return bp.exec(refundBillParamDTO, code_enttp);
	}

	/**
	 * 更改医嘱状态
	 * 
	 * @param aggDoList
	 * @param backDrugMap
	 * @return
	 * @throws BizException
	 */
	private FBoolean changeCiStatus(List<BlcgoepAggDO> aggDoList, Map<String, FDouble> backDrugMap) throws BizException {
		String code_enttp = "";
		ArrayList<BlOrderAppendBillParamDTO> ordlist = new ArrayList<BlOrderAppendBillParamDTO>();
		List<String> id_orsrv_list = new ArrayList<String>();
		for (BlcgoepAggDO dto : aggDoList) {
			BlCgItmOepDO[] blCgItmOepDOs = dto.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				if (blCgItmOepDO.getId_par() != null && !"~".equals(blCgItmOepDO.getId_par())) {
					continue;
				}
				if (backDrugMap.get(blCgItmOepDO.getId_orsrv()) != null) {
					FDouble sl = backDrugMap.get(blCgItmOepDO.getId_orsrv());
					FDouble sysl = blCgItmOepDO.getQuan().sub(sl);
					// 判断退记账数量是否比原记账数量大，半退
					if (sysl.toDouble() == 0) {
						id_orsrv_list.add(blCgItmOepDO.getId_orsrv());
					}

				}

			}
		}
		// 取消医嘱记账: 改成0还是2？？？
		// 2017-5-24修改：
		// 2、记账状态回写接口，入参需要增加【冲账类型】参数，参数值：【销账】【结算后冲账】。
		// 1) 记账后，【记账状态】=已记账，冲账类型 =空。
		// 2) 销账后，【记账状态】=已退费，冲账类型 =销账。
		// 3) 结算后冲账后，【记账状态】=已退费，冲账类型 =结算后冲账。
		if (id_orsrv_list != null && id_orsrv_list.size() > 0) {
			Object obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2X).UpdateOrdChargeRelInfo2(id_orsrv_list.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_REFOUND_ID, ICiDictCodeConst.SD_SU_BL_REFOUND, null, FeeReverseType.BLCGCANCEL);
		}
		return FBoolean.TRUE;
	}

	/**
	 * 生成全退记账数据
	 * 
	 * @param aggDoList
	 * @throws BizException
	 */
	private BlcgoepAggDO[] RetCgAggOep(List<BlcgoepAggDO> aggDoList) throws BizException {
		ArrayList<BlCgItmOepDO> updateItmOepDOs = new ArrayList<BlCgItmOepDO>();
		ArrayList<BlcgoepAggDO> aggdos = new ArrayList<BlcgoepAggDO>();

		for (BlcgoepAggDO blcgoepAggDO : aggDoList) {
			BlcgoepAggDO retAggDO = new BlcgoepAggDO();
			BlCgOepDO cgOepDO = blcgoepAggDO.getParentDO();
			cgOepDO.setId_cgoep(null);
			cgOepDO.setStatus(DOStatus.NEW);
			cgOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
			retAggDO.setParentDO(cgOepDO);
			BlCgItmOepDO[] itmDos = blcgoepAggDO.getBlCgItmOepDO();
			ArrayList<BlCgItmOepDO> retItmOepDOs = new ArrayList<BlCgItmOepDO>();
			for (BlCgItmOepDO blCgItmOepDO : itmDos) {
				// 如果不是高保，也非预交金 不操作任何数据并
				if (FBoolean.FALSE.equals(blCgItmOepDO.getFg_acc()) && FBoolean.FALSE.equals(blCgItmOepDO.getFg_hpcg())) {
					break;
				}
				// 复制记账数据
				BlCgItmOepDO retItmOepDO = DataCloneUtils.clone(blCgItmOepDO);

				// 修改记账数据
				retItmOepDO.setId_cgitmoep(null);
				retItmOepDO.setId_cgoep(null);
				retItmOepDO.setStatus(DOStatus.NEW);
				retItmOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
				retItmOepDO.setId_par(blCgItmOepDO.getId_cgitmoep());
				retItmOepDOs.add(retItmOepDO);

				// 更新原数据表状态
				blCgItmOepDO.setFg_refund(FBoolean.TRUE);
				blCgItmOepDO.setStatus(DOStatus.UPDATED);
				updateItmOepDOs.add(blCgItmOepDO);
			}
			retAggDO.setBlCgItmOepDO(retItmOepDOs.toArray(new BlCgItmOepDO[retItmOepDOs.size()]));
			if (retAggDO.getBlCgItmOepDO() != null && retAggDO.getBlCgItmOepDO().length > 0) {
				aggdos.add(retAggDO);
			}
		}
		if (aggdos != null && aggdos.size() != 0) {

			IBlcgoepCudService cgService = ServiceFinder.find(IBlcgoepCudService.class);
			updateRetCgAggDO(updateItmOepDOs);
			BlcgoepAggDO[] retDos = cgService.insert(aggdos.toArray(new BlcgoepAggDO[aggdos.size()]));
//			// 发送退费消息
//			this.invokeRefundCancAccEvent(retDos);
			return retDos;
		}
		return null;
	}

	/**
	 * 重收记账数据
	 * 
	 * @param aggDoList
	 * @param backDrugMap
	 * @throws BizException
	 */
	private BlcgoepAggDO[] RecCgAggOep(List<BlcgoepAggDO> aggDoList, Map<String, FDouble> backDrugMap) throws BizException {

		ArrayList<BlcgoepAggDO> aggdos = new ArrayList<BlcgoepAggDO>();
//		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOList = new ArrayList<BlOrderAppendBillParamDTO>();
		List<BlCgItmOepDO> blCgItmOepDOList = new ArrayList<BlCgItmOepDO>();
		ArrayList<BlCgItmOepDO> recItmOepDOs = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO blcgoepAggDO : aggDoList) {
			BlcgoepAggDO recAggDO = new BlcgoepAggDO();
			BlCgOepDO cgOepDO = blcgoepAggDO.getParentDO();
			cgOepDO.setId_cgoep(null);
			cgOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
			cgOepDO.setStatus(DOStatus.NEW);
			recAggDO.setParentDO(cgOepDO);
			BlCgItmOepDO[] itmDos = blcgoepAggDO.getBlCgItmOepDO();			
			for (BlCgItmOepDO blCgItmOepDO : itmDos) {
				// 如果不是高保，也非预交金 不操作任何数据并
				if (FBoolean.FALSE.equals(blCgItmOepDO.getFg_acc()) && FBoolean.FALSE.equals(blCgItmOepDO.getFg_hpcg())) {
					break;
				}
				// 复制记账数据
				BlCgItmOepDO recItmOepDO = DataCloneUtils.clone(blCgItmOepDO);

				recItmOepDO.setId_cgitmoep(null);
				recItmOepDO.setId_cgoep(null);
				recItmOepDO.setStatus(DOStatus.NEW);
				recItmOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
				recItmOepDO.setFg_refund(FBoolean.FALSE);
				recItmOepDO.setId_par(blCgItmOepDO.getId_cgoep());
				if (backDrugMap.get(blCgItmOepDO.getId_orsrv()) != null) {
					FDouble sl = backDrugMap.get(recItmOepDO.getId_orsrv());
					FDouble sysl = recItmOepDO.getQuan().sub(sl);
					// 判断退记账数量是否比原记账数量大 是否全退
					if (sysl.toDouble() <= 0) {
						blCgItmOepDOList.add(blCgItmOepDO);
						break;
					}
					recItmOepDO.setQuan(sysl);

					recItmOepDO.setAmt(sysl.multiply(recItmOepDO.getPrice()));
					recItmOepDO.setAmt_pat(recItmOepDO.getAmt_ratio());
					recItmOepDO.setAmt_ratio(sysl.multiply(recItmOepDO.getPrice_ratio()));
					recItmOepDO.setAmt_std(sysl.multiply(recItmOepDO.getPrice()));
					if (FBoolean.TRUE.equals(recItmOepDO.getFg_acc()))
						recItmOepDO.setAmt_acc(recItmOepDO.getAmt_ratio());
					recItmOepDOs.add(recItmOepDO);
					blCgItmOepDOList.add(blCgItmOepDO);
//				} else {
//					recItmOepDOs.add(recItmOepDO);
				}
			}

			recAggDO.setBlCgItmOepDO(recItmOepDOs.toArray(new BlCgItmOepDO[recItmOepDOs.size()]));

			if (recAggDO.getBlCgItmOepDO() != null && recAggDO.getBlCgItmOepDO().length > 0) {
				aggdos.add(recAggDO);
			}
		}
		//如果存在则触发
		if(blCgItmOepDOList.size() >0){
			this.invokeRefundCancAccEvent(blCgItmOepDOList.toArray(new BlCgItmOepDO[blCgItmOepDOList.size()]));
		}
		if (aggdos != null && aggdos.size() != 0) {

			IBlcgoepCudService cgService = ServiceFinder.find(IBlcgoepCudService.class);
			BlcgoepAggDO[] retDos = cgService.insert(aggdos.toArray(new BlcgoepAggDO[aggdos.size()]));
//			if (blOrderAppendBillParamDTOList.size() > 0) {
//				// 发送收费消息
//				this.invokeOpAccEvent(blOrderAppendBillParamDTOList.toArray(new BlOrderAppendBillParamDTO[blOrderAppendBillParamDTOList.size()]));
//			}
			return retDos;
		}
		return null;
	}

	/**
	 * 返回发送消息用到的dto
	 * 
	 * @param blCgItmOepDO
	 * @return
	 */
	private BlOrderAppendBillParamDTO setBlOrderAppendBillParamDTO(BlCgItmOepDO blCgItmOepDO) {
		BlOrderAppendBillParamDTO blOrBillParamDto = new BlOrderAppendBillParamDTO();
		BlOrderAppendOutpBillParamDTO blOut = new BlOrderAppendOutpBillParamDTO();
		blOut.setFg_acc(blCgItmOepDO.getFg_acc());
		blOut.setFg_hpcg(blCgItmOepDO.getFg_hpcg());
		blOut.setId_cgitmoep(blCgItmOepDO.getId_cgitmoep());
		blOut.setId_cgoep(blCgItmOepDO.getId_cgitmoep());
		blOrBillParamDto.setCode_apply(blCgItmOepDO.getCode_apply());
		blOrBillParamDto.setCode_applytp(blCgItmOepDO.getCode_applytp());
		blOrBillParamDto.setFg_free(blCgItmOepDO.getFg_free());
		blOrBillParamDto.setId_or(blCgItmOepDO.getId_or());
		blOrBillParamDto.setId_orsrv(blCgItmOepDO.getId_orsrv());
		blOrBillParamDto.setId_pres(blCgItmOepDO.getId_pres());
		blOrBillParamDto.setId_ent(blCgItmOepDO.getId_ent());
		blOrBillParamDto.setOutpBillDTO(blOut);
		return blOrBillParamDto;
	}

	/**
	 * 全退数据后 修改原数据表
	 * 
	 * @param updateItmOepDOs
	 * @throws BizException
	 */
	private void updateRetCgAggDO(ArrayList<BlCgItmOepDO> updateItmOepDOs) throws BizException {
		if (updateItmOepDOs != null && updateItmOepDOs.size() != 0) {
			IBlCgItmOepDOCudService cgitmService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
			cgitmService.update(updateItmOepDOs.toArray(new BlCgItmOepDO[updateItmOepDOs.size()]));
		}
	}

	/**
	 * 更新患者预交金
	 * 
	 * @throws BizException
	 */
	private void updateAmtAcc(BlcgoepAggDO[] cgAggDOs) throws BizException {
		if (cgAggDOs == null || cgAggDOs.length == 0)
			return;
		FDouble sum_amt = FDouble.ZERO_DBL;
		for (BlcgoepAggDO blcgoepAggDO : cgAggDOs) {
			for (BlCgItmOepDO blCgItmOepDO : blcgoepAggDO.getBlCgItmOepDO()) {
				if (FBoolean.TRUE.equals(blCgItmOepDO.getFg_acc()) && blCgItmOepDO.getAmt_acc() != null) {
					sum_amt = sum_amt.add(blCgItmOepDO.getAmt_acc().multiply(blCgItmOepDO.getEu_direct()));
				}
			}
		}

		if (FDouble.ZERO_DBL.equals(sum_amt))
			return;

		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		PiPatAccDO piPatAccDO = patAccImpls.PatiAccPreAuthor(cgAggDOs[0].getParentDO().getId_pat(), sum_amt);
		if (null == piPatAccDO) {
			throw new BizException("保存患者预交金信息失败");
		}
	}

	/**
	 * 发送监听事件
	 * 
	 * @param BlCgItmOepDO
	 * @throws BizException
	 */
	private void invokeRefundCancAccEvent(BlCgItmOepDO[] BlCgItmOepDO) throws BizException {

		ArrayList<String> idcgitmoepStr = new ArrayList<String>();
		if (!ArrayUtil.isEmpty(BlCgItmOepDO)) {
			for (BlCgItmOepDO itmDO : BlCgItmOepDO) {
				idcgitmoepStr.add(itmDO.getId_cgitmoep());
			}
		}
		OpCancAcc4EsDTO[] acc4EsDTOs = (OpCancAcc4EsDTO[]) AppFwUtil.getDORstWithDao(new GetOpFund4IpEsDTOsByIdsQry(idcgitmoepStr.toArray(new String[idcgitmoepStr.size()])), OpCancAcc4EsDTO.class);
		OpCancAccEvent event = new OpCancAccEvent();

		event.invoke(acc4EsDTOs);

	}

	/**
	 * 出发发送门诊高端商保，预交金记账数据
	 * 
	 * @throws BizException
	 */
	private void invokeOpAccEvent(BlOrderAppendBillParamDTO[] dtos) throws BizException {
		if (dtos == null || dtos.length == 0)
			return;
		List<OpAcc4EsDTO> opaccDtos = new ArrayList<OpAcc4EsDTO>();
		for (BlOrderAppendBillParamDTO orderDto : dtos) {
			OpAcc4EsDTO opaccDto = new OpAcc4EsDTO();
			opaccDto.setCode_apply(orderDto.getCode_apply());
			opaccDto.setCode_applytp(orderDto.getCode_applytp());
			opaccDto.setFg_acc(orderDto.getOutpBillDTO().getFg_acc());
			opaccDto.setFg_free(orderDto.getFg_free());
			opaccDto.setFg_hpcg(orderDto.getOutpBillDTO().getFg_hpcg());
			opaccDto.setId_cgitmoep(orderDto.getOutpBillDTO().getId_cgitmoep());
			opaccDto.setId_cgoep(orderDto.getOutpBillDTO().getId_cgitmoep());
			opaccDto.setId_or(orderDto.getId_or());
			opaccDto.setId_orsrv(orderDto.getId_orsrv());
			opaccDto.setId_pres(orderDto.getId_pres());
			opaccDto.setId_ent(orderDto.getId_ent());
			// TODO 当前数据中 Fg_additm 是在付款是补费才能为Y 所以当前判断不出来是否补费 ，此消息仅发送高端商保 与
			// 预交金记账数据，暂不支持补费发送数据
			// opaccDto.setFg_additm(orderDto.getFg_additm());
			opaccDtos.add(opaccDto);
		}

		OpAccEvent opAccEvent = new OpAccEvent();
		opAccEvent.invoke(opaccDtos.toArray(new OpAcc4EsDTO[opaccDtos.size()]));
	}
}
