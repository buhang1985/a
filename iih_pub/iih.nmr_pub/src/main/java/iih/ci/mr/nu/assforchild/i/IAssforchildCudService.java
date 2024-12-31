package iih.ci.mr.nu.assforchild.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.assforchild.d.AssforchildDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 儿童压疮风险评估单数据维护服务
*/
public interface IAssforchildCudService {
	/**
	*  儿童压疮风险评估单数据真删除
	*/
    public abstract void delete(AssforchildDO[] aggdos) throws BizException;
    
    /**
	*  儿童压疮风险评估单数据插入保存
	*/
	public abstract AssforchildDO[] insert(AssforchildDO[] aggdos) throws BizException;
	
    /**
	*  儿童压疮风险评估单数据保存
	*/
	public abstract AssforchildDO[] save(AssforchildDO[] aggdos) throws BizException;
	
    /**
	*  儿童压疮风险评估单数据更新
	*/
	public abstract AssforchildDO[] update(AssforchildDO[] aggdos) throws BizException;
	
	/**
	*  儿童压疮风险评估单数据逻辑删除
	*/
	public abstract void logicDelete(AssforchildDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public AssforchildDO[] enableWithoutFilter(AssforchildDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(AssforchildDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public AssforchildDO[] disableVOWithoutFilter(AssforchildDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(AssforchildDO[] dos) throws BizException ;
}
