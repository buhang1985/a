package iih.bl.cg.s.cglogic.validator;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.dto.cglogic.d.BlCgAccountBizDTO;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.ci.ord.ciorder.d.OrdSrvDO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;

/**
 * 重复记账校验器 
 * @author ly 2018/06/27
 *
 */
public class BlCgRepeatAccValidator {

	/**
	 * 重复计费校验
	 * @param accBizList
	 * @param prsrvQuanMap
	 * @throws BizException
	 */
	public void validate(List<BlCgAccountBizDTO> accBizList, Map<String, FDouble> prsrvQuanMap) throws BizException {

		for (BlCgAccountBizDTO accDto : accBizList) {
			
			if(StringUtil.isEmpty(accDto.getId_or_prsrv()))
				continue;
			
			FDouble quan = prsrvQuanMap.get(accDto.getId_or_prsrv());
			if(quan != null && !FDouble.ZERO_DBL.equals(quan)){
				throw new BizException("执行计划重复记账,服务:"+accDto.getName_srv());
			}
		}
	}
	
	/**
	 * 门诊重复记账校验
	 * @param accBizList
	 * @param dataWh
	 * @throws BizException
	 */
	public void validateOep(List<BlCgAccountBizDTO> accBizList, BlCgAccDataWarehouse dataWh) throws BizException {
		
		for (BlCgAccountBizDTO accDto : accBizList) {
			
			if(StringUtil.isEmpty(accDto.getId_orsrv()) || !StringUtil.isEmpty(accDto.getId_or_pr()))
				continue;
			
			OrdSrvDO orsrvDO = dataWh.getOrsrvMap().get(accDto.getId_orsrv());
			if(ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(orsrvDO.getSd_su_bl())){
				throw new BizException("医嘱服务重复记账,服务:"+accDto.getName_srv());
			}
		}
	}
}
