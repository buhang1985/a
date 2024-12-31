package iih.mi.mibd.base.udidoc;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 自定档案查询器
 * 
 * @author hao_wu
 */
public class UdidocQuerier {

	/**
	 * 根据类型编码和档案编码获取档案信息
	 * 
	 * @param udidocTypeCode
	 * @param udidocCode
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO GetUdidoc(String udidocTypeCode, String udidocCode) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO result = udidocServiceExt.findByCode(udidocTypeCode, udidocCode);
		if (result == null) {
			String msg = String.format("获取自定义档案失败，档案类型编码:\"%s\",档案编码:\"%s\".", udidocTypeCode, udidocCode);
			throw new BizException(msg);

		}
		return result;
	}
}
