package iih.en.pv.entplan.i;

import xap.mw.core.data.BizException;
import iih.en.pv.entplan.d.EntHpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 就诊医保计划数据维护服务
*/
public interface IEnthpCudService {
	/**
	*  就诊医保计划数据真删除
	*/
    public abstract void delete(EntHpDO[] aggdos) throws BizException;
    
    /**
	*  就诊医保计划数据插入保存
	*/
	public abstract EntHpDO[] insert(EntHpDO[] aggdos) throws BizException;
	
    /**
	*  就诊医保计划数据保存
	*/
	public abstract EntHpDO[] save(EntHpDO[] aggdos) throws BizException;
	
    /**
	*  就诊医保计划数据更新
	*/
	public abstract EntHpDO[] update(EntHpDO[] aggdos) throws BizException;
	
	/**
	*  就诊医保计划数据逻辑删除
	*/
	public abstract void logicDelete(EntHpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EntHpDO[] enableWithoutFilter(EntHpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EntHpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EntHpDO[] disableVOWithoutFilter(EntHpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EntHpDO[] dos) throws BizException ;
}
