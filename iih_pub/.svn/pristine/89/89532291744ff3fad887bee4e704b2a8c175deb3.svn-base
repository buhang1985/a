package iih.hp.cp.sdele.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.sdele.d.HpCpSdElemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 诊疗计划标准元素数据维护服务
*/
public interface IHpcpsdeleMDOCudService {
	/**
	*  诊疗计划标准元素数据真删除
	*/
    public abstract void delete(HpCpSdElemDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划标准元素数据插入保存
	*/
	public abstract HpCpSdElemDO[] insert(HpCpSdElemDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划标准元素数据保存
	*/
	public abstract HpCpSdElemDO[] save(HpCpSdElemDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划标准元素数据更新
	*/
	public abstract HpCpSdElemDO[] update(HpCpSdElemDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划标准元素数据逻辑删除
	*/
	public abstract void logicDelete(HpCpSdElemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpCpSdElemDO[] enableWithoutFilter(HpCpSdElemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpCpSdElemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpCpSdElemDO[] disableVOWithoutFilter(HpCpSdElemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpCpSdElemDO[] aggdos) throws BizException ;
	
}
