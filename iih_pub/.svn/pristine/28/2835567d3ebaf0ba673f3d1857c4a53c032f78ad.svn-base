package iih.bd.res.mtassist.i;

import xap.mw.core.data.BizException;
import iih.bd.res.mtassist.d.MtAssistDO;
import iih.bd.res.mtassist.d.MtassistAggDO;

/**
* 医技辅数据维护服务
*/
public interface IMtassistCudService {
	/**
	*  医技辅数据真删除
	*/
    public abstract void delete(MtassistAggDO[] aggdos) throws BizException;
    
    /**
	*  医技辅数据插入保存
	*/
	public abstract MtassistAggDO[] insert(MtassistAggDO[] aggdos) throws BizException;
	
    /**
	*  医技辅数据保存
	*/
	public abstract MtassistAggDO[] save(MtassistAggDO[] aggdos) throws BizException;
	
    /**
	*  医技辅数据更新
	*/
	public abstract MtassistAggDO[] update(MtassistAggDO[] aggdos) throws BizException;
	
	/**
	*  医技辅数据逻辑删除
	*/
	public abstract void logicDelete(MtassistAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医技辅数据真删除
	 */
	public abstract void deleteByParentDO(MtAssistDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医技辅数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MtAssistDO[] mainDos) throws BizException;
}
