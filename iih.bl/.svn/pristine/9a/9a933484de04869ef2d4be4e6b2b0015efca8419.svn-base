package iih.bl.cg.s.cglogic.pkgbp;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.s.cglogic.et.BlEtRefundAccountBP;
import iih.bl.cg.s.cglogic.ip.BlIpRefundAccountBP;
import iih.bl.cg.s.cglogic.util.BlCombineAccRltUtil;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院流程退记账包装
 * @author ly 2019/03/14
 *
 */
public class BlRefundAccountForIpFlowPackBP {
	
	/**
	 * 住院流程退记账包装
	 * @param refundDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCgAccountRltDTO exec(BlCgRefundAccountDTO[] refundDtos, BlCgRefundAccountSetDTO accSetDto) throws BizException {
		
		if (ArrayUtil.isEmpty(refundDtos)) {
			throw new BizException("退记账数据为空");
		}
		
		//数据分组
		List<String> entIdList = new ArrayList<String>();
		for (BlCgRefundAccountDTO accDto : refundDtos) {
			entIdList.add(accDto.getId_ent());
		}
		
		DAFacade daf = new DAFacade();
		List<PatiVisitDO> enList = (List<PatiVisitDO>) daf.findByPKs(PatiVisitDO.class, 
				entIdList.toArray(new String[0]), new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.CODE_ENTP });
		
		Map<String,PatiVisitDO> enMap = (Map<String,PatiVisitDO>)MapUtils.
				convertListToMap(enList, PatiVisitDO.ID_ENT);
		
		List<BlCgRefundAccountDTO> ipAccList = new ArrayList<BlCgRefundAccountDTO>();
		List<BlCgRefundAccountDTO> etAccList = new ArrayList<BlCgRefundAccountDTO>();
		
		for (BlCgRefundAccountDTO accDto : refundDtos) {
			
			PatiVisitDO enDO = enMap.get(accDto.getId_ent());
			if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(enDO.getCode_entp()) ||
				IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(enDO.getCode_entp())){
				ipAccList.add(accDto);
			}else{
				etAccList.add(accDto);
			}
		}
		
		BlCgAccountRltDTO rlt = null;
		if(ipAccList.size() > 0){
			BlIpRefundAccountBP ipKeepAccountBp = new BlIpRefundAccountBP();
			rlt = ipKeepAccountBp.exec(ipAccList.toArray(new BlCgRefundAccountDTO[0]), accSetDto);
		}
		
		if(etAccList.size() > 0){
			
			BlEtRefundAccountBP etKeepAccountBp = new BlEtRefundAccountBP();
			BlCgAccountRltDTO rltEt = etKeepAccountBp.exec(etAccList.toArray(new BlCgRefundAccountDTO[0]), accSetDto);
			if(rlt == null){
				rlt = rltEt;
			}else{
				BlCombineAccRltUtil.combine(rltEt, rlt);
			}
		}
		
		return rlt;
	}
}
