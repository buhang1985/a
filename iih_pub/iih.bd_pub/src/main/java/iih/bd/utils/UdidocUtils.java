package iih.bd.utils;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 自定义档案工具类
 * 
 * @author hao_wu 2018-12-12
 *
 */
public class UdidocUtils {

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
	
	/**
	 * 根据类型编码和档案编码获取档案信息
	 * 
	 * @param udidocTypeCode
	 * @param udidocCode
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO getUdidocByCodeNoExp(String udidocTypeCode, String udidocCode) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO result = udidocServiceExt.findByCode(udidocTypeCode, udidocCode);
		return result;
	}

	/**
	 * 根据自定义档案类型编码查询档案数据
	 * 
	 * @param udidocTypeCode 自定义档案类型编码
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO[] getUdidocByTpCode(String udidocTypeCode) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] result = udidocServiceExt.findByUdidoclistCode(udidocTypeCode);
		return result;
	}

	/**
	 * 根据类型编码和档案编码获取档案信息
	 * 
	 * @param udidocTypeCode
	 * @param udidocCode
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static UdidocDO[] getUdidocByCodes(String udidocTypeCode, String[] udidocCodes) throws BizException {
		DAFacade daFacade = new DAFacade();

		String wherePart = String.format(
				"id_udidoclist in (select id_udidoclist from bd_udidoclist where code = '%s') and %s", udidocTypeCode,
				SqlUtils.getInSqlByIds("code", udidocCodes));
		List<UdidocDO> result = (List<UdidocDO>) daFacade.findByCond(UdidocDO.class, wherePart);
		if (result != null) {
			return result.toArray(new UdidocDO[0]);
		}
		return null;
	}
}
