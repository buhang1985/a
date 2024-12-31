package iih.bd.pp.bp.pri;

import java.util.HashMap;
import java.util.Map;

import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.i.IPripatRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取患者价格分类map
 * @author yankan
 * @since 2017-09-19
 *
 */
public class GetAllPriPatBP {
	/**
	 * 获取患者价格分类map
	 * @return 患者价格分类map【key:患者价格分类ID，value: 患者价格分类Agg】
	 * @throws BizException
	 * @author yankan
	 */
	public Map<String,PripatAggDO> exec() throws BizException{
		IPripatRService pripatRService = ServiceFinder.find(IPripatRService.class);
		PripatAggDO[] pripatAggs = pripatRService.find("1=1", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(pripatAggs)){
			return null;
		}
		
		Map<String,PripatAggDO> priPatMap = new HashMap<String,PripatAggDO>();
		for(PripatAggDO aggDO : pripatAggs){
			priPatMap.put(aggDO.getParentDO().getId_pripat(), aggDO);
		}
		return priPatMap;
	}
}
