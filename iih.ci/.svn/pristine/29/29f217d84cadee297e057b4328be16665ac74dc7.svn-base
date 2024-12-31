package iih.ci.mb.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.base.validator.ParamValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 根据档案类型编码获取档案
 * @author yankan
 * @since 2018-03-22
 *
 */
public class GetUdidocByTypeCodeBP {
	/**
	 * 根据档案类型编码获取档案
	 * 
	 * @param udidocListCode 档案类型编码
	 * @return 自定义档案DOMap
	 * @throws BizException
	 */
	public Map<String, UdidocDO> exec(String udidocListCode) throws BizException {
		ParamValidator.validateNotNull("自定义档案类型编码", udidocListCode);
		
		Map<String, UdidocDO> udiMap = new HashMap<String, UdidocDO>();
		IUdidocServiceExt qryService = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidos = qryService.findByUdidoclistCode(udidocListCode);
		if (ArrayUtil.isEmpty(udidos)) {
			return udiMap;
		}

		for (UdidocDO udido : udidos) {
			if (!udiMap.containsKey(udido.getId_udidoc())) {
				udiMap.put(udido.getId_udidoc(), udido);
			}
		}
		return udiMap;
	}
}
