package iih.cssd.dpus.dfpgrnt.i;

import xap.mw.core.data.BizException;
import iih.cssd.dpus.dfpgrnt.d.DfpGrntDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 科室请领生成数据维护服务
*/
public interface IDfpgrntCudService {
	/**
	*  科室请领生成数据真删除
	*/
    public abstract void delete(DfpGrntDO[] aggdos) throws BizException;
    
    /**
	*  科室请领生成数据插入保存
	*/
	public abstract DfpGrntDO[] insert(DfpGrntDO[] aggdos) throws BizException;
	
    /**
	*  科室请领生成数据保存
	*/
	public abstract DfpGrntDO[] save(DfpGrntDO[] aggdos) throws BizException;
	
    /**
	*  科室请领生成数据更新
	*/
	public abstract DfpGrntDO[] update(DfpGrntDO[] aggdos) throws BizException;
	
	/**
	*  科室请领生成数据逻辑删除
	*/
	public abstract void logicDelete(DfpGrntDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public DfpGrntDO[] enableWithoutFilter(DfpGrntDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(DfpGrntDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public DfpGrntDO[] disableVOWithoutFilter(DfpGrntDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(DfpGrntDO[] dos) throws BizException ;
}
