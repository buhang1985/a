package iih.ems.embd.emca.i;

import xap.mw.core.data.BizException;
import iih.ems.embd.emca.d.EmCaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医疗器械分类数据维护服务
*/
public interface IEmcaCudService {
	/**
	*  医疗器械分类数据真删除
	*/
    public abstract void delete(EmCaDO[] aggdos) throws BizException;
    
    /**
	*  医疗器械分类数据插入保存
	*/
	public abstract EmCaDO[] insert(EmCaDO[] aggdos) throws BizException;
	
    /**
	*  医疗器械分类数据保存
	*/
	public abstract EmCaDO[] save(EmCaDO[] aggdos) throws BizException;
	
    /**
	*  医疗器械分类数据更新
	*/
	public abstract EmCaDO[] update(EmCaDO[] aggdos) throws BizException;
	
	/**
	*  医疗器械分类数据逻辑删除
	*/
	public abstract void logicDelete(EmCaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmCaDO[] enableWithoutFilter(EmCaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmCaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmCaDO[] disableVOWithoutFilter(EmCaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmCaDO[] dos) throws BizException ;
}
