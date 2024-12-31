package iih.ci.preop.ems.treat;

import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.preop.ems.base.BasePreOpEmsSaveBP;
import iih.ci.preop.ems.d.b.BasePreOpEmsViewDTO;
import iih.ci.sdk.cache.BDRouteInfoCache;
import iih.ci.sdk.orctt.CiOrContentUtils;
import iih.ci.tsip.d.CitsorderAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊预住院治疗申请单保存逻辑
 * @author wangqingzhu
 *
 */
public class EmsTreatSaveBP extends BasePreOpEmsSaveBP {

	/**
	 * 医嘱内容拼接
	 * @param tsOrdAggDO
	 * @return
	 * @throws BizException 
	 */
	@Override
	protected CiOrContentDO setOrContentInfo(CitsorderAggDO tsOrdAggDO,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		return CiOrContentUtils.create(emsViewDto.getSd_srvtp(),emsViewDto.getName_srv()
				,BDRouteInfoCache.GetNameOfBdRouteInfo(tsOrdAggDO.getParentDO().getId_route()),FBoolean.FALSE);
	}
	
}

