package iih.bd.fc.triageres.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.triageres.d.TriageResDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 检伤判定数据维护服务
*/
public interface ITriageresCudService {
	/**
	*  检伤判定数据真删除
	*/
    public abstract void delete(TriageResDO[] aggdos) throws BizException;
    
    /**
	*  检伤判定数据插入保存
	*/
	public abstract TriageResDO[] insert(TriageResDO[] aggdos) throws BizException;
	
    /**
	*  检伤判定数据保存
	*/
	public abstract TriageResDO[] save(TriageResDO[] aggdos) throws BizException;
	
    /**
	*  检伤判定数据更新
	*/
	public abstract TriageResDO[] update(TriageResDO[] aggdos) throws BizException;
	
	/**
	*  检伤判定数据逻辑删除
	*/
	public abstract void logicDelete(TriageResDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TriageResDO[] enableWithoutFilter(TriageResDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TriageResDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TriageResDO[] disableVOWithoutFilter(TriageResDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TriageResDO[] dos) throws BizException ;
}
