package iih.bd.res.bed.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 床位扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IBedExtRService {

	/**
	 * 根据床位主键集合查询床位费字典
	 * 
	 * @param bedIds
	 *            床位主键集合
	 * @return 床位费字典 [床位主键,床位费]
	 * @throws BizException
	 */
	public abstract FMap2 findBedPriMapByIds(String[] bedIds) throws BizException;
}
