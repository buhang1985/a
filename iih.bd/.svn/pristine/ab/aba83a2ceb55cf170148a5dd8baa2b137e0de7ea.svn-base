package iih.bd.base.udidoc;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 自定档案查询器
 * 
 * @author hao_wu 添加根据iecode查询档案信息 ly 2017/09/11
 */
public class UdidocQuerier {

	/**
	 * 根据类型编码和档案编码获取档案信息</br>
	 * 此方法已过时，请使用getUdidocByCode
	 * 
	 * @param udidocTypeCode
	 * @param udidocCode
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static UdidocDO GetUdidoc(String udidocTypeCode, String udidocCode) throws BizException {
		return getUdidocByCode(udidocTypeCode, udidocCode);
	}

	/**
	 * 根据类型编码和IE编码获取档案信息 不支持组织级档案数据
	 * 
	 * @param udidocTypeCode
	 * @param udidocIECode
	 * @throws BizException
	 */
	public static UdidocDO getUdidocByIECode(String udidocTypeCode, String udidocIECode) throws BizException {

		if (StringUtil.isEmpty(udidocTypeCode) || StringUtil.isEmpty(udidocIECode))
			return null;

		String sql = "select doc.* from bd_udidoc doc " + "inner join bd_udidoclist doclist "
				+ "on doc.id_udidoclist = doclist.id_udidoclist " + "where doclist.code = ? " + "and doc.code_ie = ? ";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(udidocTypeCode);
		sqlParam.addParam(udidocIECode);

		UdidocDO doc = (UdidocDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(UdidocDO.class));
		return doc;
	}

	/**
	 * 根据类型编码和档案编码获取档案信息
	 * 
	 * @param udidocTypeCode
	 * @param udidocCode
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO getUdidocByCode(String udidocTypeCode, String udidocCode) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO result = udidocServiceExt.findByCode(udidocTypeCode, udidocCode);
		if (result == null) {
			String msg = String.format("获取自定义档案失败，档案类型编码:\"%s\",档案编码:\"%s\".", udidocTypeCode, udidocCode);
			throw new BizException(msg);

		}
		return result;
	}
}
