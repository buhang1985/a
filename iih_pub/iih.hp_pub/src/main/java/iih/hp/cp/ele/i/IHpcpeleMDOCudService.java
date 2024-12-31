package iih.hp.cp.ele.i;

import xap.mw.core.data.BizException;
import iih.hp.cp.ele.d.HpCpElemDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 诊疗计划元素数据维护服务
*/
public interface IHpcpeleMDOCudService {
	/**
	*  诊疗计划元素数据真删除
	*/
    public abstract void delete(HpCpElemDO[] aggdos) throws BizException;
    
    /**
	*  诊疗计划元素数据插入保存
	*/
	public abstract HpCpElemDO[] insert(HpCpElemDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素数据保存
	*/
	public abstract HpCpElemDO[] save(HpCpElemDO[] aggdos) throws BizException;
	
    /**
	*  诊疗计划元素数据更新
	*/
	public abstract HpCpElemDO[] update(HpCpElemDO[] aggdos) throws BizException;
	
	/**
	*  诊疗计划元素数据逻辑删除
	*/
	public abstract void logicDelete(HpCpElemDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpCpElemDO[] enableWithoutFilter(HpCpElemDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpCpElemDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpCpElemDO[] disableVOWithoutFilter(HpCpElemDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpCpElemDO[] aggdos) throws BizException ;
	
}
