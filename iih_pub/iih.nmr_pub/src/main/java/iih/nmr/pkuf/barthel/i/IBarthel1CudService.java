package iih.nmr.pkuf.barthel.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.barthel.d.BarthelDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* Barthel指数评定量表数据维护服务
*/
public interface IBarthel1CudService {
	/**
	*  Barthel指数评定量表数据真删除
	*/
    public abstract void delete(BarthelDO[] aggdos) throws BizException;
    
    /**
	*  Barthel指数评定量表数据插入保存
	*/
	public abstract BarthelDO[] insert(BarthelDO[] aggdos) throws BizException;
	
    /**
	*  Barthel指数评定量表数据保存
	*/
	public abstract BarthelDO[] save(BarthelDO[] aggdos) throws BizException;
	
    /**
	*  Barthel指数评定量表数据更新
	*/
	public abstract BarthelDO[] update(BarthelDO[] aggdos) throws BizException;
	
	/**
	*  Barthel指数评定量表数据逻辑删除
	*/
	public abstract void logicDelete(BarthelDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public BarthelDO[] enableWithoutFilter(BarthelDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(BarthelDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public BarthelDO[] disableVOWithoutFilter(BarthelDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(BarthelDO[] dos) throws BizException ;
}
