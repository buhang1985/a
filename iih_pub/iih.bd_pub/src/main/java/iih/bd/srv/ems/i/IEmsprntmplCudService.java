package iih.bd.srv.ems.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;

/**
* 医疗单打印模板管理数据维护服务
*/
public interface IEmsprntmplCudService {
	/**
	*  医疗单打印模板管理数据真删除
	*/
    public abstract void delete(EmsprntmplAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗单打印模板管理数据插入保存
	*/
	public abstract EmsprntmplAggDO[] insert(EmsprntmplAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗单打印模板管理数据保存
	*/
	public abstract EmsprntmplAggDO[] save(EmsprntmplAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗单打印模板管理数据更新
	*/
	public abstract EmsprntmplAggDO[] update(EmsprntmplAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗单打印模板管理数据逻辑删除
	*/
	public abstract void logicDelete(EmsprntmplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗单打印模板管理数据真删除
	 */
	public abstract void deleteByParentDO(EmsPrnTmplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗单打印模板管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmsPrnTmplDO[] mainDos) throws BizException;
}
