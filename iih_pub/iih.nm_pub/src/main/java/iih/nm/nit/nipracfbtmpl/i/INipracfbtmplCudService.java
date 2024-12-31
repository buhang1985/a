package iih.nm.nit.nipracfbtmpl.i;

import xap.mw.core.data.BizException;
import iih.nm.nit.nipracfbtmpl.d.NiPracfbTmplDO;
import iih.nm.nit.nipracfbtmpl.d.NipracfbtmplAggDO;

/**
* 实习反馈模板数据维护服务
*/
public interface INipracfbtmplCudService {
	/**
	*  实习反馈模板数据真删除
	*/
    public abstract void delete(NipracfbtmplAggDO[] aggdos) throws BizException;
    
    /**
	*  实习反馈模板数据插入保存
	*/
	public abstract NipracfbtmplAggDO[] insert(NipracfbtmplAggDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈模板数据保存
	*/
	public abstract NipracfbtmplAggDO[] save(NipracfbtmplAggDO[] aggdos) throws BizException;
	
    /**
	*  实习反馈模板数据更新
	*/
	public abstract NipracfbtmplAggDO[] update(NipracfbtmplAggDO[] aggdos) throws BizException;
	
	/**
	*  实习反馈模板数据逻辑删除
	*/
	public abstract void logicDelete(NipracfbtmplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对实习反馈模板数据真删除
	 */
	public abstract void deleteByParentDO(NiPracfbTmplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对实习反馈模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(NiPracfbTmplDO[] mainDos) throws BizException;
}
