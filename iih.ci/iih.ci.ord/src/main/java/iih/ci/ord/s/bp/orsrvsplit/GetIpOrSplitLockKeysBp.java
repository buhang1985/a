package iih.ci.ord.s.bp.orsrvsplit;

import java.util.List;

import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获取拆分加锁Key
 * 
 * @author xuxing_2018年2月10日16:58:54
 * @version xuxing_2018年2月27日08:29:12按照病区拆分条件写成id_dep_mp的bug修复
 * @version xuxing_2019年2月21日13:09:51因性能要求，左链接更改为内连接，使用函数least替换casewhen部分
 * @version xuxing_加锁查询始终增加ent表的连接，便于后期过滤非在院患者
 *
 */
public class GetIpOrSplitLockKeysBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public String[] exec(OrSrvSplitParamDTO param) throws BizException {

		// 1、基础校验
		if (!validation(param))
			return null;

		// 2、获取条件串
		String whereStr = getSqlWhereStr(param);

		// 3、获取SQl
		String sqlStr = getSqlStr(whereStr, param);

		// 4、查询数据
		List<String> reList = queryData(sqlStr);
		if (reList == null || reList.size() < 1)
			return null;

		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 基础校验
	 * 
	 * @param param
	 * @return
	 */
	private boolean validation(OrSrvSplitParamDTO param) {
		if (param == null)
			return false;
		param.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		return true;
	}

	/**
	 * 获取拆分查询条件
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private String getSqlWhereStr(OrSrvSplitParamDTO param) throws BizException {
		GetOrSrvSplitCondSqlBP bp = new GetOrSrvSplitCondSqlBP();
		return bp.exec(param);
	}

	/**
	 * 获取SQl语句
	 * 
	 * @param whereStr
	 * @return
	 */
	private String getSqlStr(String whereStr, OrSrvSplitParamDTO param) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select ");
		sqlStr.append(" concat(ci_order.id_or,'MPNR')");
		sqlStr.append(" from ci_order ci_order");
		sqlStr.append(" inner join ci_or_srv ci_or_srv on ci_or_srv.id_or = ci_order.id_or");
		sqlStr.append(" inner join en_ent " + IOrAndSrvSplitConst.EN_TABLE_ALIAS + " on ci_order.id_en = " + IOrAndSrvSplitConst.EN_TABLE_ALIAS + ".id_ent");
		sqlStr.append(whereStr);
		return sqlStr.toString();
	}

	/**
	 * 查询医嘱ID集合
	 * 
	 * @param sqlStr
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<String> queryData(String sqlStr) throws DAException {
		List<String> reList = (List<String>) new DAFacade().execQuery(sqlStr, null, new ColumnListHandler());
		return reList;
	}
}
