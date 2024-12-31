package iih.nm.nit.nitpracfb.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nitpracfb.d.NitPracfbDO;
import iih.nm.nit.nitpracfb.d.NitpracfbAggDO;

/**
* 实习反馈数据维护服务
*/
public interface INitpracfbCudService {
	/**
	*  实习反馈数据真删除
	*/
    public abstract void delete(NitpracfbAggDO[] aggdos) throws BizException;
    
    /**
	*  实习反馈数据插入保存
	*/
	public abstract NitpracfbAggDO[] insert(NitpracfbAggDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈数据保存
	*/
	public abstract NitpracfbAggDO[] save(NitpracfbAggDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈数据更新
	*/
	public abstract NitpracfbAggDO[] update(NitpracfbAggDO[] aggdos) throws BizException;
	
	/**
	*  实习反馈数据逻辑删除
	*/
	public abstract void logicDelete(NitpracfbAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对实习反馈数据真删除
	 */
	public abstract void deleteByParentDO(NitPracfbDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对实习反馈数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NitPracfbDO[] mainDos) throws BizException;
}
