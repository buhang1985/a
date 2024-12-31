package iih.ci.mr.nu.babyhandover.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.babyhandover.d.BabyhandoverinfoDO;
import iih.ci.mr.nu.babyhandover.d.BabyhandoverAggDO;

/**
* 新生儿交接与记录单数据维护服务
*/
public interface IBabyhandoverCudService {
	/**
	*  新生儿交接与记录单数据真删除
	*/
    public abstract void delete(BabyhandoverAggDO[] aggdos) throws BizException;
    
    /**
	*  新生儿交接与记录单数据插入保存
	*/
	public abstract BabyhandoverAggDO[] insert(BabyhandoverAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿交接与记录单数据保存
	*/
	public abstract BabyhandoverAggDO[] save(BabyhandoverAggDO[] aggdos) throws BizException;
	
    /**
	*  新生儿交接与记录单数据更新
	*/
	public abstract BabyhandoverAggDO[] update(BabyhandoverAggDO[] aggdos) throws BizException;
	
	/**
	*  新生儿交接与记录单数据逻辑删除
	*/
	public abstract void logicDelete(BabyhandoverAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对新生儿交接与记录单数据真删除
	 */
	public abstract void deleteByParentDO(BabyhandoverinfoDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对新生儿交接与记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BabyhandoverinfoDO[] mainDos) throws BizException;
}
