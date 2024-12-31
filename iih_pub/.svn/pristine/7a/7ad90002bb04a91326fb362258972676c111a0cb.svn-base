package iih.bd.srv.mrwp.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.mrwp.d.MrWritePowerDO;
import iih.bd.srv.mrwp.d.MrwpAggDO;

/**
* mrwp数据维护服务
*/
public interface IMrwpCudService {
	/**
	*  mrwp数据真删除
	*/
    public abstract void delete(MrwpAggDO[] aggdos) throws BizException;
    
    /**
	*  mrwp数据插入保存
	*/
	public abstract MrwpAggDO[] insert(MrwpAggDO[] aggdos) throws BizException;
	
    /**
	*  mrwp数据保存
	*/
	public abstract MrwpAggDO[] save(MrwpAggDO[] aggdos) throws BizException;
	
    /**
	*  mrwp数据更新
	*/
	public abstract MrwpAggDO[] update(MrwpAggDO[] aggdos) throws BizException;
	
	/**
	*  mrwp数据逻辑删除
	*/
	public abstract void logicDelete(MrwpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对mrwp数据真删除
	 */
	public abstract void deleteByParentDO(MrWritePowerDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对mrwp数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MrWritePowerDO[] mainDos) throws BizException;
}
