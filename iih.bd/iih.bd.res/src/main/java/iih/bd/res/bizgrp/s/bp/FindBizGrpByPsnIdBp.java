package iih.bd.res.bizgrp.s.bp;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.res.bizgrp.d.BizgrpAggDO;
import iih.bd.res.bizgrp.i.IBizgrpRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据人员主键查询业务组信息
 * 
 * @author hao_wu 2020-1-9
 *
 */
public class FindBizGrpByPsnIdBp {

	public BizgrpAggDO[] exec(String psnId) throws BizException {

		String[] bizGrpIds = findBizGrpIds(psnId);
		if (ArrayUtils.isEmpty(bizGrpIds)) {
			return null;
		}

		IBizgrpRService bizgrpRService = ServiceFinder.find(IBizgrpRService.class);
		BizgrpAggDO[] rtn = bizgrpRService.findByIds(bizGrpIds, FBoolean.FALSE);

		return rtn;
	}

	/**
	 * 根据人员主键查询业务组主键集合
	 * 
	 * @param psnId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String[] findBizGrpIds(String psnId) throws BizException {
		String sql = "select distinct id_wg from bd_emp_wg where id_emp = ?";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(psnId);

		DAFacade daFacade = new DAFacade();
		List<String> bizGrpIdList = (List<String>) daFacade.execQuery(sql, sqlParam, new ColumnListHandler());
		if (bizGrpIdList == null || bizGrpIdList.size() <= 0) {
			return null;
		}
		return bizGrpIdList.toArray(new String[0]);

	}

}
