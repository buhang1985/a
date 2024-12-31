package iih.ci.ord.s.external.thirdws.utils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
/**
 * 查询档案信息
 * @author zhangwq
 *
 */
public class UdidocUtils {
	/**
	 * 根据类型编码和IE编码获取档案信息 不支持组织级档案数据
	 * 
	 * @param udidocTypeCode
	 * @param udidocCode
	 * @throws BizException
	 */
	public static UdidocDO getUdidocByCode(String udidocTypeCode, String udidocCode) throws BizException {

		if (StringUtil.isEmpty(udidocTypeCode) || StringUtil.isEmpty(udidocCode))
			return null;

		String sql = "select doc.* from bd_udidoc doc " + "inner join bd_udidoclist doclist "
				+ "on doc.id_udidoclist = doclist.id_udidoclist " + "where doclist.code = ? " + "and doc.code = ? ";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(udidocTypeCode);
		sqlParam.addParam(udidocCode);

		UdidocDO doc = (UdidocDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(UdidocDO.class));
		return doc;
	}
}
