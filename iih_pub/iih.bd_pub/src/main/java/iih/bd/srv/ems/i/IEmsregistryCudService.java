package iih.bd.srv.ems.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsregistryAggDO;

/**
* 医疗单注册数据维护服务
*/
public interface IEmsregistryCudService {
	/**
	*  医疗单注册数据真删除
	*/
    public abstract void delete(EmsregistryAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗单注册数据插入保存
	*/
	public abstract EmsregistryAggDO[] insert(EmsregistryAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗单注册数据保存
	*/
	public abstract EmsregistryAggDO[] save(EmsregistryAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗单注册数据更新
	*/
	public abstract EmsregistryAggDO[] update(EmsregistryAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗单注册数据逻辑删除
	*/
	public abstract void logicDelete(EmsregistryAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗单注册数据真删除
	 */
	public abstract void deleteByParentDO(EmsDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗单注册数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmsDO[] mainDos) throws BizException;
}
