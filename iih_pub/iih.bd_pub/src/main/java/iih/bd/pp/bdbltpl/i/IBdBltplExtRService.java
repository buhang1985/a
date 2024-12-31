package iih.bd.pp.bdbltpl.i;

import java.util.Map;

import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 自定义费用模板扩展查询服务接口
 * 
 * @author hao_wu 2019-5-27
 *
 */
public interface IBdBltplExtRService {

	/**
	 * 根据费用模板主键查找自定义费用模板数据
	 * 
	 * @param tplId 费用模板主键
	 * @return
	 * @throws BizException
	 */
	public abstract BdbltplAggDO findBltplAggDoById(String tplId) throws BizException;

	/**
	 * 更新自定义费用模板明细集合</br>
	 * 更新参考价
	 * 
	 * @param itms 自定义费用模板明细集合
	 * @return
	 * @throws BizException
	 */
	public abstract BdBltplItmDO[] updateBlTplItms(BdBltplItmDO[] itms) throws BizException;

	/**
	 * 获取费用模板价格字典<br/>
	 * 只支持床位费
	 * 
	 * @param tplIds 自定义费用模板主键集合
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String, FDouble> getTplPriceMap(String[] tplIds) throws BizException;
}
