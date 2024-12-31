package iih.bd.mhi.hpphytp.i;

import xap.mw.core.data.BizException;
import iih.bd.mhi.hpphytp.d.HpPhytpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保计划医师类别数据维护服务
*/
public interface IHpphytpCudService {
	/**
	*  医保计划医师类别数据真删除
	*/
    public abstract void delete(HpPhytpDO[] aggdos) throws BizException;
    
    /**
	*  医保计划医师类别数据插入保存
	*/
	public abstract HpPhytpDO[] insert(HpPhytpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划医师类别数据保存
	*/
	public abstract HpPhytpDO[] save(HpPhytpDO[] aggdos) throws BizException;
	
    /**
	*  医保计划医师类别数据更新
	*/
	public abstract HpPhytpDO[] update(HpPhytpDO[] aggdos) throws BizException;
	
	/**
	*  医保计划医师类别数据逻辑删除
	*/
	public abstract void logicDelete(HpPhytpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpPhytpDO[] enableWithoutFilter(HpPhytpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpPhytpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpPhytpDO[] disableVOWithoutFilter(HpPhytpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpPhytpDO[] dos) throws BizException ;
}
