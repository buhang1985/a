package iih.mp.dg.mpdgshetpprntmpl.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.mpdgshetpprntmpl.d.MpdgShetpPrntmplDO;
import iih.mp.dg.mpdgshetpprntmpl.d.MpdgshetpprntmplAggDO;

/**
* 药单打印模板管理数据维护服务
*/
public interface IMpdgshetpprntmplCudService {
	/**
	*  药单打印模板管理数据真删除
	*/
    public abstract void delete(MpdgshetpprntmplAggDO[] aggdos) throws BizException;
    
    /**
	*  药单打印模板管理数据插入保存
	*/
	public abstract MpdgshetpprntmplAggDO[] insert(MpdgshetpprntmplAggDO[] aggdos) throws BizException;
	
    /**
	*  药单打印模板管理数据保存
	*/
	public abstract MpdgshetpprntmplAggDO[] save(MpdgshetpprntmplAggDO[] aggdos) throws BizException;
	
    /**
	*  药单打印模板管理数据更新
	*/
	public abstract MpdgshetpprntmplAggDO[] update(MpdgshetpprntmplAggDO[] aggdos) throws BizException;
	
	/**
	*  药单打印模板管理数据逻辑删除
	*/
	public abstract void logicDelete(MpdgshetpprntmplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对药单打印模板管理数据真删除
	 */
	public abstract void deleteByParentDO(MpdgShetpPrntmplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对药单打印模板管理数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MpdgShetpPrntmplDO[] mainDos) throws BizException;
}
