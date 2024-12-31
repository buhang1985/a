package iih.mp.dg.mpdgshetpprntmpl.i;

import xap.mw.core.data.BizException;
import iih.mp.dg.mpdgshetpprntmpl.d.MpdgShetpPrntmplIitmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 药单打印模板管理数据维护服务
*/
public interface IMpdgShetpPrntmplIitmDOCudService {
	/**
	*  药单打印模板管理数据真删除
	*/
    public abstract void delete(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException;
    
    /**
	*  药单打印模板管理数据插入保存
	*/
	public abstract MpdgShetpPrntmplIitmDO[] insert(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException;
	
    /**
	*  药单打印模板管理数据保存
	*/
	public abstract MpdgShetpPrntmplIitmDO[] save(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException;
	
    /**
	*  药单打印模板管理数据更新
	*/
	public abstract MpdgShetpPrntmplIitmDO[] update(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException;
	
	/**
	*  药单打印模板管理数据逻辑删除
	*/
	public abstract void logicDelete(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MpdgShetpPrntmplIitmDO[] enableWithoutFilter(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MpdgShetpPrntmplIitmDO[] disableVOWithoutFilter(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MpdgShetpPrntmplIitmDO[] aggdos) throws BizException ;
	
}
