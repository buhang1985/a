package iih.bl.cg.service.s.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincoepcanclog.d.BlIncOepCancLogDO;
import iih.bl.inc.blincoepcanclog.i.IBlincoepcanclogCudService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;

public class RePrintIncBp {

	/**
	 * 重打发票业务
	 * 
	 * @param strCodeSt
	 * @param operatorInfoDto
	 * @param fg_reginc  是否是挂号发票类型
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] doRePrintInvoice(String strCodeSt, OperatorInfoDTO operatorInfoDto,RePrintInvoiceInfoDTO rePrintIncInfoDTO) throws BizException {
		if (StringUtil.isEmpty(strCodeSt)) {
			throw new BizException("没有传入结算流水号！");
		}
		// 查找原结算信息
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOArr = iBlstoepRService.findByAttrValString("Code_st", strCodeSt);
		if (ArrayUtil.isEmpty(blStOepDOArr))
			throw new BizException("未找到结算信息，请核对结算流水号是否正确！");

		// 1.操作合法性校验，判断是否可以重打印发票
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] blincoepAggDOArr = iBlincoepRService.findByAttrValString(BlIncOepDO.ID_STOEP, blStOepDOArr[0].getId_stoep());
		// 原发票信息
		BlIncOepDO blincOepDo = null;
		if (!ArrayUtil.isEmpty(blincoepAggDOArr)) {
			blincOepDo = blincoepAggDOArr[0].getParentDO();
		}
		BLCiOrderToBlCgServiceImplBp orderBp = new BLCiOrderToBlCgServiceImplBp();
		
		//1.1 判断是否是挂号发票，如果是挂号发票，则可能是很久以前的发票 可能已经结过账了 仍然可以重打 
	  if(rePrintIncInfoDTO.getFg_reg_inc()!=null && rePrintIncInfoDTO.getFg_reg_inc().booleanValue())
	  {
			BlincoepAggDO[] blincoepAggDOArrUpdated = this.handleIncDatas(blincoepAggDOArr, operatorInfoDto);
        	// 获取最新的发票信息
			BlIncItmVsTypeDTO[] incOepDtoArr = orderBp.assemblyIncInfoDtos(blStOepDOArr[0], blincoepAggDOArrUpdated);
			return incOepDtoArr; 
	  }else{
		    //1.2 非挂号发票，只能重打上一张发票，
	  		// 校验发票信息，只能处理未记账以及本人开立的发票
	  		if (blincOepDo.getFg_cc_out().booleanValue())
	  			throw new BizException("该发票已经结账，不能再补打发票！");
	  		BlincoepAggDO[] blincoepAggDOArrUpdated = this.handleIncDatas(blincoepAggDOArr, operatorInfoDto);
            BlIncItmVsTypeDTO[] incOepDtoArr = orderBp.assemblyIncInfoDtos(blStOepDOArr[0], blincoepAggDOArrUpdated);
	  		return incOepDtoArr; 
	       }
	}

   
	private  BlincoepAggDO[]   handleIncDatas(BlincoepAggDO[]  blincOepAggdos,OperatorInfoDTO operInfoDto)throws BizException
    {
    	IBLInvoiceService incService = ServiceFinder.find(IBLInvoiceService.class);
    	IBlincoepcanclogCudService cancLogSer = ServiceFinder.find(IBlincoepcanclogCudService.class);
    	List<BlIncOepCancLogDO> list_log =  new ArrayList<BlIncOepCancLogDO>();
    	// 1.对原发票的某些字段信息更新  2.增加一条作废 发票数据  3.增加一条作废日志记录
		// 考虑到分票的情况，一次结算对应多张发票，则对于原发票单独处理
		for (BlincoepAggDO incAggdo : blincOepAggdos) 
		{
			//1。 更新原来的发票的某些字段信息 ，
			BlIncOepDO blIncOepDO = incAggdo.getParentDO(); // 原发票
			//原发票号
			String incno=blIncOepDO.getIncno();
			// 获取最新发票信息
			BlIncissOepDTO incIssOepDto = incService.useReceipt(operInfoDto.getId_emp(), IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
			blIncOepDO.setIncno(incIssOepDto.getIncno_cur());
			blIncOepDO.setCode_incpkg(incIssOepDto.getCode_incpkg());
			blIncOepDO.setDt_inc(AppUtils.getServerDateTime());
			blIncOepDO.setId_emp_inc(operInfoDto.getId_emp());
			blIncOepDO.setId_dep_inc(operInfoDto.getId_dep());
			blIncOepDO.setStatus(DOStatus.UPDATED);
			blIncOepDO.setFg_cc_out(FBoolean.FALSE);
			blIncOepDO.setId_cc_out(null);
			blIncOepDO.setFg_cc_in(FBoolean.FALSE);
			blIncOepDO.setId_cc_in(null);
			// 2.作废空白票
			BlIncCancDO blIncCancDO = new BlIncCancDO();
			blIncCancDO.setCode_incpkg(blIncOepDO.getCode_incpkg());
			blIncCancDO.setIncno(incno);
			blIncCancDO.setId_emp_canc(operInfoDto.getId_emp());
			blIncCancDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_PRINT_ERROR);
			blIncCancDO.setId_reason_canc(IBdPpCodeTypeConst.ID_PRINT_ERROR);
			blIncCancDO.setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
			blIncCancDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_PRINT_ERROR);
			blIncCancDO.setDt_canc(AppUtils.getServerDateTime());
			blIncCancDO.setFg_canc(FBoolean.TRUE);
			blIncCancDO.setFg_canc(FBoolean.FALSE);
			blIncCancDO.setId_cc(null);
			blIncCancDO.setId_grp(operInfoDto.getId_grp());
			blIncCancDO.setId_org(operInfoDto.getId_org());
			blIncCancDO.setStatus(DOStatus.NEW);
			incService.AddBlIncCanc(operInfoDto.getId_emp(), IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE, blIncCancDO);

			//3.增加作废记录日志
			BlIncOepCancLogDO cancLogDO =  new BlIncOepCancLogDO();
			cancLogDO.setId_org(operInfoDto.getId_org());
			cancLogDO.setId_grp(operInfoDto.getId_grp());
			cancLogDO.setId_pat(blIncOepDO.getId_pat());
			cancLogDO.setId_entp(blIncOepDO.getId_enttp());
			cancLogDO.setEu_direct(blIncOepDO.getEu_direct());
			cancLogDO.setId_incca(blIncOepDO.getId_incca());
			cancLogDO.setCode_incpkg(blIncOepDO.getCode_incpkg());
			cancLogDO.setIncno(incno);
			cancLogDO.setCode_incpkg_new(incIssOepDto.getCode_incpkg());
			cancLogDO.setIncno_new(incIssOepDto.getIncno_cur());
			cancLogDO.setEu_freemd(blIncOepDO.getEu_freemd());
			cancLogDO.setAmt_free(blIncOepDO.getAmt_free());
			cancLogDO.setAmt(blIncOepDO.getAmt());
			cancLogDO.setAmt_pat(blIncOepDO.getAmt_pat());
			cancLogDO.setNote(blIncOepDO.getNote());
			cancLogDO.setId_emp_inc(blIncOepDO.getId_emp_inc());
			cancLogDO.setId_dep_inc(blIncOepDO.getId_dep_inc());
			cancLogDO.setId_emp_inc_new(operInfoDto.getId_emp());
			cancLogDO.setId_dep_inc_new(operInfoDto.getId_dep());
			cancLogDO.setId_stoep(blIncOepDO.getId_stoep());
			cancLogDO.setFg_fundpay(blIncOepDO.getFg_fundpay());
			cancLogDO.setFg_hp_card(blIncOepDO.getFg_hp_card());
			cancLogDO.setTimes_prn(blIncOepDO.getTimes_prn());
			cancLogDO.setDt_inc(blIncOepDO.getDt_inc());
			cancLogDO.setDt_inc_new(AppUtils.getServerDateTime());
			cancLogDO.setStatus(DOStatus.NEW);
			list_log.add(cancLogDO);
		}
		cancLogSer.save(list_log.toArray(new BlIncOepCancLogDO[0]));
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		BlincoepAggDO[] blincoepAggDOArrUpdated = iBlincoepCudService.save(blincOepAggdos);
    	return blincoepAggDOArrUpdated;
    	
    }

}
