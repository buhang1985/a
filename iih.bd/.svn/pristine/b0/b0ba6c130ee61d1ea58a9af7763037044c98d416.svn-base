package iih.bd.fc.s.bp;

import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.s.bp.qry.GetorpltpStaByFunCodesSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年12月1日 上午10:44:14 类说明：根据节点编码查询闭环类型 Company: Copyright 2016
 *          by PKU healthcare IT Co.,Ltd.
 */
public class GetIdOrpltpsByFuncodeBp {

	public OrpltpStaFuncDO[] exec(String funcode) throws BizException {

		// 1、数据验证
		if (StringUtil.isEmpty(funcode)) {

			return null;
		}

		// 2、查询数据并返回id
		return getRtnData(funcode);

	}

	/**
	 * 根据节点编码获取闭环类型ID集合
	 * 
	 * @param funcode节点编码
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaFuncDO[] getRtnData(String funcode) throws BizException {

		GetorpltpStaByFunCodesSql Sql = new GetorpltpStaByFunCodesSql(new String[] { funcode });

		OrpltpStaFuncDO[] orpltpStaFuncDOs = (OrpltpStaFuncDO[]) AppFwUtil.getDORstWithDao(Sql, OrpltpStaFuncDO.class);

		return orpltpStaFuncDOs;
	}
}
