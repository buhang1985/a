package iih.ci.mr.nu.earlywarnmark.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.earlywarnmark.d.EarlywarnminfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 重症患者早期预警评分表数据维护服务
*/
public interface IEarlywarnmarkMDOCudService {
	/**
	*  重症患者早期预警评分表数据真删除
	*/
    public abstract void delete(EarlywarnminfoDO[] aggdos) throws BizException;
    
    /**
	*  重症患者早期预警评分表数据插入保存
	*/
	public abstract EarlywarnminfoDO[] insert(EarlywarnminfoDO[] aggdos) throws BizException;
	
    /**
	*  重症患者早期预警评分表数据保存
	*/
	public abstract EarlywarnminfoDO[] save(EarlywarnminfoDO[] aggdos) throws BizException;
	
    /**
	*  重症患者早期预警评分表数据更新
	*/
	public abstract EarlywarnminfoDO[] update(EarlywarnminfoDO[] aggdos) throws BizException;
	
	/**
	*  重症患者早期预警评分表数据逻辑删除
	*/
	public abstract void logicDelete(EarlywarnminfoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EarlywarnminfoDO[] enableWithoutFilter(EarlywarnminfoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EarlywarnminfoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EarlywarnminfoDO[] disableVOWithoutFilter(EarlywarnminfoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EarlywarnminfoDO[] aggdos) throws BizException ;
	
}
