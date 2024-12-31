package iih.mi.itf.facade;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.ArrayUtils;

import iih.mi.bd.d.HpDTO;
import iih.mi.bd.i.IMiBdQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保产品缓存代理
 * 
 * @author ge_jie,hao_wu
 *
 */
public class HpCacheProxy {

	private static Map<String, Map<String, HpDTO>> HpDTOsByDataSourceMap = new ConcurrentHashMap<String, Map<String, HpDTO>>();

	/**
	 * 根据医保产品主键查询医保产品信息
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @return 医保产品信息
	 * @throws BizException
	 */
	public static HpDTO getHpDTOById(String hpId) throws BizException {
		return getHpDTOsMap() == null ? null : getHpDTOsMap().get(hpId);
	}

	/**
	 * 获取医保产品DTO字典
	 * 
	 * @return 医保产品DTO字典
	 * @throws BizException
	 */
	private static Map<String, HpDTO> getHpDTOsMap() throws BizException {
		String dataSource = Context.get().getUserDataSource();
		Map<String, HpDTO> HpDTOsMap = HpDTOsByDataSourceMap.get(dataSource);
		if (HpDTOsMap == null) {
			synchronized (HpCacheProxy.class) {
				HpDTOsMap = HpDTOsByDataSourceMap.get(dataSource);
				if (HpDTOsMap == null) {
					HpDTOsMap = getAllHpDTOsMap();
					HpDTOsByDataSourceMap.put(dataSource, HpDTOsMap);
				}
			}
		}
		return HpDTOsMap;
	}

	/**
	 * 获取所有医保产品DTO字典
	 * 
	 * @return 医保产品DTO字典
	 * @throws BizException
	 */
	private static Map<String, HpDTO> getAllHpDTOsMap() throws BizException {
		IMiBdQryService miBdQryService = ServiceFinder.find(IMiBdQryService.class);
		HpDTO[] HpDTOs = miBdQryService.findAllHps();
		Map<String, HpDTO> HpDTOsMap = new ConcurrentHashMap<String, HpDTO>();
		if (ArrayUtils.isEmpty(HpDTOs))
			return HpDTOsMap;
		for (HpDTO HpDTO : HpDTOs) {
			HpDTOsMap.put(HpDTO.getId_hp(), HpDTO);
		}
		return HpDTOsMap;
	}

}
