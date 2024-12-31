package iih.bd.srv.emrsourceprop.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrsourceprop.d.EmrSourcePropDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 病历(源+属性主表)数据维护服务
*/
public interface IEmrsourcepropCudService {
	/**
	*  病历(源+属性主表)数据真删除
	*/
    public abstract void delete(EmrSourcePropDO[] aggdos) throws BizException;
    
    /**
	*  病历(源+属性主表)数据插入保存
	*/
	public abstract EmrSourcePropDO[] insert(EmrSourcePropDO[] aggdos) throws BizException;
	
    /**
	*  病历(源+属性主表)数据保存
	*/
	public abstract EmrSourcePropDO[] save(EmrSourcePropDO[] aggdos) throws BizException;
	
    /**
	*  病历(源+属性主表)数据更新
	*/
	public abstract EmrSourcePropDO[] update(EmrSourcePropDO[] aggdos) throws BizException;
	
	/**
	*  病历(源+属性主表)数据逻辑删除
	*/
	public abstract void logicDelete(EmrSourcePropDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public EmrSourcePropDO[] enableWithoutFilter(EmrSourcePropDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(EmrSourcePropDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public EmrSourcePropDO[] disableVOWithoutFilter(EmrSourcePropDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(EmrSourcePropDO[] dos) throws BizException ;
}
