package iih.bd.srv.emrimg.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrimg.d.EmrImageDO;
import iih.bd.srv.emrimg.d.EmrimgAggDO;

/**
* 医疗记录图片库管理数据维护服务
*/
public interface IEmrimgCudService {
	/**
	*  医疗记录图片库管理数据真删除
	*/
    public abstract void delete(EmrimgAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录图片库管理数据插入保存
	*/
	public abstract EmrimgAggDO[] insert(EmrimgAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录图片库管理数据保存
	*/
	public abstract EmrimgAggDO[] save(EmrimgAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录图片库管理数据更新
	*/
	public abstract EmrimgAggDO[] update(EmrimgAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录图片库管理数据逻辑删除
	*/
	public abstract void logicDelete(EmrimgAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录图片库管理数据真删除
	 */
	public abstract void deleteByParentDO(EmrImageDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录图片库管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmrImageDO[] mainDos) throws BizException;
}
