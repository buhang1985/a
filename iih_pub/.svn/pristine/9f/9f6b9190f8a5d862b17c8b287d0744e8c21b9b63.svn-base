package iih.mp.ne.transfusion.i;

import xap.mw.core.data.BizException;
import iih.mp.ne.transfusion.d.NeBtrDO;
import iih.mp.ne.transfusion.d.TransfusionAggDO;

/**
* 输血执行数据维护服务
*/
public interface ITransfusionCudService {
	/**
	*  输血执行数据真删除
	*/
    public abstract void delete(TransfusionAggDO[] aggdos) throws BizException;
    
    /**
	*  输血执行数据插入保存
	*/
	public abstract TransfusionAggDO[] insert(TransfusionAggDO[] aggdos) throws BizException;
	
    /**
	*  输血执行数据保存
	*/
	public abstract TransfusionAggDO[] save(TransfusionAggDO[] aggdos) throws BizException;
	
    /**
	*  输血执行数据更新
	*/
	public abstract TransfusionAggDO[] update(TransfusionAggDO[] aggdos) throws BizException;
	
	/**
	*  输血执行数据逻辑删除
	*/
	public abstract void logicDelete(TransfusionAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对输血执行数据真删除
	 */
	public abstract void deleteByParentDO(NeBtrDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对输血执行数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NeBtrDO[] mainDos) throws BizException;
}
