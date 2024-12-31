package iih.bd.fc.triagecmpt.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.triagecmpt.d.TriageCmptDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 检伤主诉数据维护服务
*/
public interface ITriagecmptCudService {
	/**
	*  检伤主诉数据真删除
	*/
    public abstract void delete(TriageCmptDO[] aggdos) throws BizException;
    
    /**
	*  检伤主诉数据插入保存
	*/
	public abstract TriageCmptDO[] insert(TriageCmptDO[] aggdos) throws BizException;
	
    /**
	*  检伤主诉数据保存
	*/
	public abstract TriageCmptDO[] save(TriageCmptDO[] aggdos) throws BizException;
	
    /**
	*  检伤主诉数据更新
	*/
	public abstract TriageCmptDO[] update(TriageCmptDO[] aggdos) throws BizException;
	
	/**
	*  检伤主诉数据逻辑删除
	*/
	public abstract void logicDelete(TriageCmptDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TriageCmptDO[] enableWithoutFilter(TriageCmptDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TriageCmptDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TriageCmptDO[] disableVOWithoutFilter(TriageCmptDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TriageCmptDO[] dos) throws BizException ;
}
