package iih.syn.common.unittrg.i;

import xap.mw.core.data.BizException;
import iih.syn.common.unittrg.d.SynUnitTrgDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 数据同步目标数据维护服务
*/
public interface IUnittrgMDOCudService {
	/**
	*  数据同步目标数据真删除
	*/
    public abstract void delete(SynUnitTrgDO[] aggdos) throws BizException;
    
    /**
	*  数据同步目标数据插入保存
	*/
	public abstract SynUnitTrgDO[] insert(SynUnitTrgDO[] aggdos) throws BizException;
	
    /**
	*  数据同步目标数据保存
	*/
	public abstract SynUnitTrgDO[] save(SynUnitTrgDO[] aggdos) throws BizException;
	
    /**
	*  数据同步目标数据更新
	*/
	public abstract SynUnitTrgDO[] update(SynUnitTrgDO[] aggdos) throws BizException;
	
	/**
	*  数据同步目标数据逻辑删除
	*/
	public abstract void logicDelete(SynUnitTrgDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public SynUnitTrgDO[] enableWithoutFilter(SynUnitTrgDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(SynUnitTrgDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public SynUnitTrgDO[] disableVOWithoutFilter(SynUnitTrgDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(SynUnitTrgDO[] aggdos) throws BizException ;
	
}
