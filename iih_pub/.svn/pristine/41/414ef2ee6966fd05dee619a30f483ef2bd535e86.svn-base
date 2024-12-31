package iih.bd.res.opt.i;

import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAException;

/**
 * 手术台查询服务
 * @author wjy
 *
 */
public interface IOptServiceExt {

	/**
	 * 根据科室ID对手术台分组，统计每个科室的手术台数量
	 * @return
	 */
	public FArrayList getOptCountByDepId();
	
	/**
	 * 检查手术台编码是否重复
	 * @param opertCode 手术台编码
	 * @return
	 */
	public int checkOpertCode(String opertCode) throws DAException;
}
