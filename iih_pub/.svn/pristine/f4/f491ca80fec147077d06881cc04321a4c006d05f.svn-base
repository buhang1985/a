package iih.bl.st.blpaypatoep.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;

/**
* 组件数据维护服务
*/
public interface IBlpaypatoepCudService {
	/**
	*  组件数据真删除
	*/
    public abstract void delete(BlpaypatoepAggDO[] aggdos) throws BizException;
    
    /**
	*  组件数据插入保存
	*/
	public abstract BlpaypatoepAggDO[] insert(BlpaypatoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据保存
	*/
	public abstract BlpaypatoepAggDO[] save(BlpaypatoepAggDO[] aggdos) throws BizException;
	
    /**
	*  组件数据更新
	*/
	public abstract BlpaypatoepAggDO[] update(BlpaypatoepAggDO[] aggdos) throws BizException;
	
	/**
	*  组件数据逻辑删除
	*/
	public abstract void logicDelete(BlpaypatoepAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对组件数据真删除
	 */
	public abstract void deleteByParentDO(BlPayPatOepDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对组件数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlPayPatOepDO[] mainDos) throws BizException;
}
