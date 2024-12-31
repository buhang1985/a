package iih.bl.cg.s.bp.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.dto.blcgdif.d.BlCgOpDifDTO;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * 门诊医保差额回写明细数据处理
 * @author ly 2019/06/03
 *
 */
public class BlCgUpdateOpDifBP {

	/**
	 * 门诊医保差额回写明细数据处理
	 * @param cgDifDtos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(BlCgOpDifDTO[] cgDifDtos) throws BizException{
	
		if(ArrayUtil.isEmpty(cgDifDtos))
			return;
		
		List<String> cgIdList = new ArrayList<String>();
		Map<String, BlCgOpDifDTO> difCgMap = new HashMap<String, BlCgOpDifDTO>();
		FDouble amtDifSum = FDouble.ZERO_DBL;
		for (BlCgOpDifDTO opDifDto : cgDifDtos) {
			cgIdList.add(opDifDto.getId_cgitmoep());
			amtDifSum = amtDifSum.add(opDifDto.getAmt_dif());
			difCgMap.put(opDifDto.getId_cgitmoep(), opDifDto);
		}
		
		//查询记账数据
		DAFacade daf = new DAFacade();
		List<BlCgItmOepDO> cgItmList= (List<BlCgItmOepDO>)daf.findByPKs(
				BlCgItmOepDO.class, cgIdList.toArray(new String[0]));
	
		if(ListUtil.isEmpty(cgItmList))
			return;
		
		
		//更新明细金额
		for (BlCgItmOepDO blCgItmOepDO : cgItmList) {
			BlCgOpDifDTO difDto = difCgMap.get(blCgItmOepDO.getId_cgitmoep());
			difDto.setCode_inccaitm(blCgItmOepDO.getCode_inccaitm());
			blCgItmOepDO.setAmt(difDto.getAmt_ratiodif());
			blCgItmOepDO.setAmt_ratio(difDto.getAmt_ratiodif());
		}
		daf.updateDOArray(cgItmList.toArray(new BlCgItmOepDO[0]), new String[]{BlCgItmOepDO.AMT, BlCgItmOepDO.AMT_RATIO});
		
		//更新结算数据
		String stId = cgItmList.get(0).getId_stoep();
		BlStOepDO stDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, stId);
		stDO.setAmt(stDO.getAmt().add(amtDifSum));
		stDO.setAmt_ratio(stDO.getAmt());
		daf.updateDO(stDO, new String[]{BlStOepDO.AMT, BlStOepDO.AMT_RATIO});
		
		//更新发票数据
		IBlincoepRService incRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] incAggDO = incRService.findByAttrValString(BlIncOepDO.ID_STOEP, stId);
		if(ArrayUtil.isEmpty(incAggDO))
			return;
		
		for (BlincoepAggDO blincoepAggDO : incAggDO) {
			
			FDouble incAmtDif = FDouble.ZERO_DBL;
			Map<String, FDouble> incItmAmtDifMap = new HashMap<String, FDouble>();
			for (BlIncCgItmOep incCgItmDO : blincoepAggDO.getBlIncCgItmOep()) {
				
				if(!difCgMap.containsKey(incCgItmDO.getId_cgitmoep())){
					continue;
				}
				BlCgOpDifDTO difDto = difCgMap.get(incCgItmDO.getId_cgitmoep());
				incAmtDif = incAmtDif.add(difDto.getAmt_dif());
				
				FDouble incItmAmtDif = null;
				if(incItmAmtDifMap.containsKey(difDto.getCode_inccaitm())){
					incItmAmtDif = difDto.getAmt_dif().add(incItmAmtDifMap.get(difDto.getCode_inccaitm()));
				}else{
					incItmAmtDif = difDto.getAmt_dif();
				}
				incItmAmtDifMap.put(difDto.getCode_inccaitm(), incItmAmtDif);
			}
			
			if(incAmtDif.equals(FDouble.ZERO_DBL))
				continue;
			
			BlIncOepDO incOepDO = blincoepAggDO.getParentDO();
			incOepDO.setAmt_ratio(incOepDO.getAmt_ratio().add(incAmtDif));
			incOepDO.setAmt(incOepDO.getAmt_ratio());
			incOepDO.setStatus(DOStatus.UPDATED);
			
			for (BlIncItmOepDO incItmDO : blincoepAggDO.getBlIncItmOepDO()) {
				
				if(incItmAmtDifMap.containsKey(incItmDO.getCode())){
					FDouble incItmAmtDif = incItmAmtDifMap.get(incItmDO.getCode());
					incItmDO.setAmt_ratio(incItmDO.getAmt_ratio().add(incItmAmtDif));
					incItmDO.setAmt(incItmDO.getAmt_ratio());
					incItmDO.setStatus(DOStatus.UPDATED);
				}
			}
		}
		
		IBlincoepCudService incCudService = ServiceFinder.find(IBlincoepCudService.class);
		incCudService.save(incAggDO);
	}
}
