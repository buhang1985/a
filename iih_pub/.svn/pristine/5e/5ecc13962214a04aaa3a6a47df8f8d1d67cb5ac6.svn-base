package iih.nmr.pkuf.childnurse.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.childnurse.d.ChildNurseDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 儿童医院护理记录单数据维护服务
*/
public interface IChildnurseCudService {
	/**
	*  儿童医院护理记录单数据真删除
	*/
    public abstract void delete(ChildNurseDO[] aggdos) throws BizException;
    
    /**
	*  儿童医院护理记录单数据插入保存
	*/
	public abstract ChildNurseDO[] insert(ChildNurseDO[] aggdos) throws BizException;
	
    /**
	*  儿童医院护理记录单数据保存
	*/
	public abstract ChildNurseDO[] save(ChildNurseDO[] aggdos) throws BizException;
	
    /**
	*  儿童医院护理记录单数据更新
	*/
	public abstract ChildNurseDO[] update(ChildNurseDO[] aggdos) throws BizException;
	
	/**
	*  儿童医院护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(ChildNurseDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ChildNurseDO[] enableWithoutFilter(ChildNurseDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ChildNurseDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ChildNurseDO[] disableVOWithoutFilter(ChildNurseDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ChildNurseDO[] dos) throws BizException ;
}
