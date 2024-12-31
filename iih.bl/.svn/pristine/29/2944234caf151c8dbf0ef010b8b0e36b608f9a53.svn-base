package iih.bl.comm.util;

import iih.en.pv.inpatient.d.EnPeCmpyItmDO;
import iih.en.pv.inpatient.i.IEnPeCmpyItmDORService;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 团检相关工具类
 * 
 * @author ly 2018/06/04
 *
 */
public class BlPeCmpyUtil {

	/**
	 * 判断是否属于团检患者
	 * 
	 * @param entId
	 *            就诊id
	 * @return 团检记录id
	 * @throws BizException
	 */
	public static String isPecmpy(String entId) throws BizException {

		if (StringUtil.isEmpty(entId))
			return null;

		IEnPeCmpyItmDORService rService = ServiceFinder.find(IEnPeCmpyItmDORService.class);
		EnPeCmpyItmDO[] dos = rService.findByAttrValString(EnPeCmpyItmDO.ID_ENT, entId);
		if (ArrayUtil.isEmpty(dos))
			return null;

		return dos[0].getId_pecmpy();
	}

	/**
	 * 批量获取就诊对应团检数据 如果没有 value为null
	 * 
	 * @param entIds
	 *            就诊id集合
	 * @return Key 就诊id Value 团检记录id
	 * @throws BizException
	 */
	public static Map<String, String> getEntsIsPecmpy(String[] entIds) throws BizException {
		Map<String, String> retMap = new HashMap<String, String>();
		if (ArrayUtil.isEmpty(entIds))
			return retMap;
		IEnPeCmpyItmDORService encmp = ServiceFinder.find(IEnPeCmpyItmDORService.class);
		EnPeCmpyItmDO[] enItmDOs = encmp.findByAttrValStrings(EnPeCmpyItmDO.ID_ENT, entIds);
		if (enItmDOs==null||enItmDOs.length==0) {
			return retMap;
		}
		
		for (EnPeCmpyItmDO enPeCmpyItmDO : enItmDOs) {
			retMap.put(enPeCmpyItmDO.getId_ent(), enPeCmpyItmDO.getId_pecmpy());
		}
		
		return retMap;
	}
}
