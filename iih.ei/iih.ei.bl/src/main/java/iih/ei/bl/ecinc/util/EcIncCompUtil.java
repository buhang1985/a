package iih.ei.bl.ecinc.util;

import java.util.HashMap;
import java.util.Map;

import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.blecinccomp.i.IBlecinccompRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 电子票据对照数据获取工具类
 * @author ly 2020/01/06
 *
 */
public class EcIncCompUtil {

	/**
	 * 查询对照数据
	 * @param compType
	 * @return
	 * @throws BizException
	 */
	public static Map<String,BlEcIncCompDO> getCompData(String compType) throws BizException{
		IBlecinccompRService rService = ServiceFinder.find(IBlecinccompRService.class);
		String whereSql = String.format("sd_comptype = '%s' and ecinc_code is not null", compType);
		BlEcIncCompDO[] compDos = rService.find(whereSql, null, FBoolean.FALSE);
		
		Map<String,BlEcIncCompDO> compMap = new HashMap<String,BlEcIncCompDO>();
		if(!ArrayUtil.isEmpty(compDos)){
			for (BlEcIncCompDO compDO : compDos) {
				if(!StringUtil.isEmpty(compDO.getCode()) && 
						!StringUtil.isEmpty(compDO.getEcinc_code())){
					compMap.put(compDO.getCode(), compDO);
				}
			}
		}
		return compMap;
	}
}
