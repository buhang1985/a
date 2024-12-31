package iih.nmr.pkuf.childfallbedeva.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.childfallbedeva.d.ChildFallbedEvaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 儿童医院预防跌倒/坠床评估表数据维护服务
*/
public interface IChildfallbedevaCudService {
	/**
	*  儿童医院预防跌倒/坠床评估表数据真删除
	*/
    public abstract void delete(ChildFallbedEvaDO[] aggdos) throws BizException;
    
    /**
	*  儿童医院预防跌倒/坠床评估表数据插入保存
	*/
	public abstract ChildFallbedEvaDO[] insert(ChildFallbedEvaDO[] aggdos) throws BizException;
	
    /**
	*  儿童医院预防跌倒/坠床评估表数据保存
	*/
	public abstract ChildFallbedEvaDO[] save(ChildFallbedEvaDO[] aggdos) throws BizException;
	
    /**
	*  儿童医院预防跌倒/坠床评估表数据更新
	*/
	public abstract ChildFallbedEvaDO[] update(ChildFallbedEvaDO[] aggdos) throws BizException;
	
	/**
	*  儿童医院预防跌倒/坠床评估表数据逻辑删除
	*/
	public abstract void logicDelete(ChildFallbedEvaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public ChildFallbedEvaDO[] enableWithoutFilter(ChildFallbedEvaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(ChildFallbedEvaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public ChildFallbedEvaDO[] disableVOWithoutFilter(ChildFallbedEvaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(ChildFallbedEvaDO[] dos) throws BizException ;
}
