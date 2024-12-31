package iih.bd.srv.notice.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.notice.d.NoticeCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 临床注意事项数据维护服务
*/
public interface INoticecaCudService {
	/**
	*  临床注意事项数据真删除
	*/
    public abstract void delete(NoticeCaDO[] aggdos) throws BizException;
    
    /**
	*  临床注意事项数据插入保存
	*/
	public abstract NoticeCaDO[] insert(NoticeCaDO[] aggdos) throws BizException;
	
    /**
	*  临床注意事项数据保存
	*/
	public abstract NoticeCaDO[] save(NoticeCaDO[] aggdos) throws BizException;
	
    /**
	*  临床注意事项数据更新
	*/
	public abstract NoticeCaDO[] update(NoticeCaDO[] aggdos) throws BizException;
	
	/**
	*  临床注意事项数据逻辑删除
	*/
	public abstract void logicDelete(NoticeCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NoticeCaDO[] enableWithoutFilter(NoticeCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NoticeCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NoticeCaDO[] disableVOWithoutFilter(NoticeCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NoticeCaDO[] dos) throws BizException ;
}
