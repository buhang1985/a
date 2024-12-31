package iih.mi.bd.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.param.IBdMhiParamCodeConst;
import iih.bd.utils.BdMhiParamUtils;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 获取对应医保产品的所有实体参数map
 * @author yangyang
 *
 */
public class FindAllHpParamMapBp {

	public FMap2 exec(String strIdHp,String[] strParamCodeArr) throws BizException
	{
		Map<String, Map<String, String>> paramMap = getAllParamsByHpId(strIdHp,strParamCodeArr);
		if (paramMap == null || paramMap.size() <= 0) {
			return null;
		}
		return convertToFMap2(paramMap);
	}
	
	/**
	 * 参数转化为FMap2
	 * @param paramMap
	 * @return
	 * @throws BizException
	 */
	private FMap2 convertToFMap2(Map<String, Map<String, String>> paramMap) throws BizException
	{
		FMap2 map=new FMap2();
		for (Map.Entry<String, Map<String, String>> entryOut : paramMap.entrySet()) { 
			Map<String,String> mapValue=entryOut.getValue();
			if(mapValue!=null)
			{
				FMap2 mapParam=new FMap2();
				for (Map.Entry<String,String> entryIn : mapValue.entrySet())
				{
					mapParam.put(entryIn.getKey(), entryIn.getValue());
				}
				map.put(entryOut.getKey(),mapParam);
			}
		}
		return map;
	}
	


	/** 获取某医保产品下所有得实体参数
	 * @param hpId 医保产品主键
	 * @return 参数类别
	 * @throws BizException
	 */
	private Map<String, Map<String, String>> getAllParamsByHpId(String hpId,String[] strParamCodeArr) throws BizException {
		if(StringUtils.isEmpty(hpId))
			return null;

		Map<String, Map<String, String>> allParamMap = new HashMap<String, Map<String, String>>();
		Map<String, String> paramsMap = getAllInstParamsByHpId(hpId,strParamCodeArr);
		if (paramsMap != null) {
			allParamMap.put(hpId, paramsMap);
		}
		return allParamMap;
	}
	 
		/**
		 * 获取医保产品的所有实体参数
		 * 
		 * @param hpId
		 *            医保产品主键
		 * @return 实体参数字典[参数编码，参数值]
		 * @throws BizException
		 */
		private Map<String, String> getAllInstParamsByHpId(String hpId,String[] strParamCodeArr) throws BizException {
			Map<String, String> allParamMap = ParamsetQryUtil.getParasStringByInstance(hpId,
					strParamCodeArr);
			return allParamMap;
		}
}
