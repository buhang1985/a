package iih.bl.hp.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.validator.ParamValidator;
import iih.bd.pp.hp.d.BdHpLimitPsdDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 批量判定是否存在单方限制
 * @author yankan
 * @since 2017-09-04
 *
 */
public class BatchCheckHasPsdLimitBP {
	/**
	 * 批量判定是否存在单方限制
	 * @param hpId 医保计划ID
	 * @param srvIds 服务ID集合
	 * @return Map,[key: 服务ID，value:FBoolean]
	 * @throws BizException
	 * @author yankan
	 */
	public Map<String,FBoolean> exec(String hpId,String[] srvIds) throws BizException{
		//参数校验
		ParamValidator.validateNotNull("医保计划ID", hpId);
		ParamValidator.validateNotNull("服务ID集合", srvIds);
		
		//1、获取医保单方限制记录
		GetHpLimitPsdListBP getPsdBP = new GetHpLimitPsdListBP();
		List<BdHpLimitPsdDO> limitPsdList = getPsdBP.exec(new String[]{hpId}, srvIds);
		List<String> limitSrvIdList = this.getLimitSrvIdList(limitPsdList);
		
		//2、根据限制记录判定
		Map<String,FBoolean> resultMap = new HashMap<String,FBoolean>();		 
		for(String srvId : srvIds){
			FBoolean hasLimit = FBoolean.FALSE;
			if(!ListUtil.isEmpty(limitSrvIdList) && limitSrvIdList.contains(srvId)){
				hasLimit = FBoolean.TRUE;
			}
			resultMap.put(srvId, hasLimit);
		}
		return resultMap;		
	}
	/**
	 * 获取限制的服务ID集合
	 * @param limitPsdList
	 * @return
	 */
	private List<String> getLimitSrvIdList(List<BdHpLimitPsdDO> limitPsdList){
		if(ListUtil.isEmpty(limitPsdList)){
			return null;
		}
		List<String> srvIdList = new ArrayList<String>();
		for(BdHpLimitPsdDO limitDO : limitPsdList){
			if(limitDO!=null && !StringUtil.isEmpty(limitDO.getId_srv())){
				if(srvIdList.contains(limitDO.getId_srv())){
					srvIdList.add(limitDO.getId_srv());
				}
			}
		}
		return srvIdList;
	}
}
