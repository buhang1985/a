package iih.bd.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通用SQL执行类 支持普通JavaBean作为数据接收者
 * 
 * @author ly 2018/03/15
 * @author hao_wu 2018-6-4 从iih.bd.base.util移至iih.bd.utils
 *
 */
public class CommDAFacade {

	/**
	 * SQL执行
	 * 
	 * @param tQry
	 * @param 数据类型
	 * @return 查询到的数据集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] execQuery(ITransQry tQry, Class<T> c) throws BizException {

		DAFacade dao = new DAFacade();
		try {
			ArrayList<T> list = null;
			StringBuffer sqlBuffer = new StringBuffer(tQry.getQrySQLStr());
			SqlParam para = tQry.getQryParameter(sqlBuffer);

			if (para.getCountParams() > 0) {
				list = (ArrayList<T>) dao.execQuery(sqlBuffer.toString(), para, new BeanListHandler(c));
			} else {
				list = (ArrayList<T>) dao.execQuery(sqlBuffer.toString(), new BeanListHandler(c));
			}
			return (T[]) list.toArray((T[]) Array.newInstance(c, 0));
		} catch (Exception e) {
			Logger.error(e.getMessage());
			throw new BizException(e);
		}
	}
}
