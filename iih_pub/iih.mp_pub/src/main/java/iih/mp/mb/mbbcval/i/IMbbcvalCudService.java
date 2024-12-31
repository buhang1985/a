package iih.mp.mb.mbbcval.i;

import xap.mw.core.data.BizException;
import iih.mp.mb.mbbcval.d.MbBcValDO;
import iih.mp.mb.mbbcval.d.MbbcvalAggDO;

/**
* 条码对照查询数据维护服务
*/
public interface IMbbcvalCudService {
	/**
	*  条码对照查询数据真删除
	*/
    public abstract void delete(MbbcvalAggDO[] aggdos) throws BizException;
    
    /**
	*  条码对照查询数据插入保存
	*/
	public abstract MbbcvalAggDO[] insert(MbbcvalAggDO[] aggdos) throws BizException;
	
    /**
	*  条码对照查询数据保存
	*/
	public abstract MbbcvalAggDO[] save(MbbcvalAggDO[] aggdos) throws BizException;
	
    /**
	*  条码对照查询数据更新
	*/
	public abstract MbbcvalAggDO[] update(MbbcvalAggDO[] aggdos) throws BizException;
	
	/**
	*  条码对照查询数据逻辑删除
	*/
	public abstract void logicDelete(MbbcvalAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对条码对照查询数据真删除
	 */
	public abstract void deleteByParentDO(MbBcValDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对条码对照查询数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MbBcValDO[] mainDos) throws BizException;
}
