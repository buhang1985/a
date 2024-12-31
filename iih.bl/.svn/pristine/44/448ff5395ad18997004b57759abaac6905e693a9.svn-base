package iih.bl.cg.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.service.s.bp.BLCiOrderToBlCgServiceImplBp;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 发票重打业务类
 * (改造半成品)
 * @author ly 2018/04/16
 *
 */
public class BlCgReprintIncBP {

	/**
	 * 发票重打
	 * @param stId
	 * @param incDtos
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(String stId,RePrintInvoiceInfoDTO[] incDtos) throws BizException{
	
		if (StringUtil.isEmpty(stId)) {
			throw new ArgumentNullException("发票重打", "结算id");
		}
		
		if(ArrayUtil.isEmpty(incDtos)){
			throw new ArgumentNullException("发票重打", "需重打发票信息");
		}
		
		// 查找原结算信息
		IBlstoepRService stRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stDO = stRService.findById(stId);
		if (stDO == null)
			throw new BizException("未找到结算信息，请核对结算流水号是否正确！");
		
		// 重打发票
		FBoolean fgReg = null;
		List<String> incIdList = new ArrayList<String>();
		for (RePrintInvoiceInfoDTO incDto : incDtos) {
			if(fgReg == null){
				fgReg = incDto.getFg_reg_inc();
			}
			incIdList.add(incDto.getId_incoep());
		}
		BlIncPrintDTO printSet = new BlIncPrintDTO();
		printSet.setFgpay(FBoolean.FALSE);
		printSet.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		printSet.setFgreg(fgReg);
		
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		BlincoepAggDO[] aggDos = incService.reprintOpInvoice(incIdList.toArray(new String[0]), printSet);
		
		//组织返回值
		BLCiOrderToBlCgServiceImplBp dataBp = new BLCiOrderToBlCgServiceImplBp();
		return dataBp.assemblyIncInfoDtos(stDO, aggDos);
	}
	
	
}
