package iih.nmr.ha.tcho.tchoillpatientcare.i;

import xap.mw.core.data.BizException;
import iih.nmr.ha.tcho.tchoillpatientcare.d.TchoIllPatientDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病危(病重)患者护理记录单数据维护服务
*/
public interface ITchoillpatientcareMDOCudService {
	/**
	*  病危(病重)患者护理记录单数据真删除
	*/
    public abstract void delete(TchoIllPatientDO[] aggdos) throws BizException;
    
    /**
	*  病危(病重)患者护理记录单数据插入保存
	*/
	public abstract TchoIllPatientDO[] insert(TchoIllPatientDO[] aggdos) throws BizException;
	
    /**
	*  病危(病重)患者护理记录单数据保存
	*/
	public abstract TchoIllPatientDO[] save(TchoIllPatientDO[] aggdos) throws BizException;
	
    /**
	*  病危(病重)患者护理记录单数据更新
	*/
	public abstract TchoIllPatientDO[] update(TchoIllPatientDO[] aggdos) throws BizException;
	
	/**
	*  病危(病重)患者护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(TchoIllPatientDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public TchoIllPatientDO[] enableWithoutFilter(TchoIllPatientDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(TchoIllPatientDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public TchoIllPatientDO[] disableVOWithoutFilter(TchoIllPatientDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(TchoIllPatientDO[] aggdos) throws BizException ;
	
}
