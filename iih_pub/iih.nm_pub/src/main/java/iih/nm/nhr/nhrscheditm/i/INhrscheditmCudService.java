package iih.nm.nhr.nhrscheditm.i;

import xap.mw.core.data.BizException;
import iih.nm.nhr.nhrscheditm.d.NhrSchedDO;
import iih.nm.nhr.nhrscheditm.d.NhrscheditmAggDO;

/**
* 人员排班明细数据维护服务
*/
public interface INhrscheditmCudService {
	/**
	*  人员排班明细数据真删除
	*/
    public abstract void delete(NhrscheditmAggDO[] aggdos) throws BizException;
    
    /**
	*  人员排班明细数据插入保存
	*/
	public abstract NhrscheditmAggDO[] insert(NhrscheditmAggDO[] aggdos) throws BizException;
	
    /**
	*  人员排班明细数据保存
	*/
	public abstract NhrscheditmAggDO[] save(NhrscheditmAggDO[] aggdos) throws BizException;
	
    /**
	*  人员排班明细数据更新
	*/
	public abstract NhrscheditmAggDO[] update(NhrscheditmAggDO[] aggdos) throws BizException;
	
	/**
	*  人员排班明细数据逻辑删除
	*/
	public abstract void logicDelete(NhrscheditmAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对人员排班明细数据真删除
	 */
	public abstract void deleteByParentDO(NhrSchedDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对人员排班明细数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NhrSchedDO[] mainDos) throws BizException;
}
