package iih.ei.std.bd.v1.i;

import java.util.List;
import java.util.Map;

import iih.ei.std.bd.v1.model.BdQryRtnData;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;

/**
 * 基础数据查询服务
 * 
 * @author hao_wu 2019-2-26
 *
 */
public interface IBdQryService {

	/**
	 * 查询数据
	 * 
	 * @param itfCode 接口编码
	 * @return
	 */
	public abstract List<Map<String, Object>> findData(String itfCode) throws BizException;

	/**
	 * 查询分页数据
	 * 
	 * @param itfCode 接口编码
	 * @param pgInfo  分页信息
	 * @return
	 */
	public abstract BdQryRtnData findPagingData(String itfCode, PaginationInfo pgInfo) throws BizException;
}
