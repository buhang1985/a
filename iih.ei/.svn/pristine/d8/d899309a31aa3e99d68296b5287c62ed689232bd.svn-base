package iih.ei.std.bd.v1.s;

import java.util.List;
import java.util.Map;

import iih.ei.std.bd.v1.i.IBdQryService;
import iih.ei.std.bd.v1.model.BdQryRtnData;
import iih.ei.std.bd.v1.s.bp.FindPagingViewDataByItfCodeBp;
import iih.ei.std.bd.v1.s.bp.FindViewDataByItfCodeBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;

/**
 * 基础数据查询服务
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class BdQryServiceImpl implements IBdQryService {

	@Override
	public List<Map<String, Object>> findData(String itfCode) throws BizException {
		FindViewDataByItfCodeBp bp = new FindViewDataByItfCodeBp();
		List<Map<String, Object>> dataList = bp.exec(itfCode);
		return dataList;
	}

	@Override
	public BdQryRtnData findPagingData(String itfCode, PaginationInfo pgInfo) throws BizException {
		FindPagingViewDataByItfCodeBp bp = new FindPagingViewDataByItfCodeBp();
		BdQryRtnData rtnData = bp.exec(pgInfo, itfCode);
		return rtnData;
	}

}
