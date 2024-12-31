package iih.nm.nom.nmbedwardrecord.i;

import xap.mw.core.data.BizException;
import iih.nm.nom.nmbedwardrecord.d.NomBedwardItmDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 病房患者统计数据维护服务
*/
public interface INomBedwardItmDOCudService {
	/**
	*  病房患者统计数据真删除
	*/
    public abstract void delete(NomBedwardItmDO[] aggdos) throws BizException;
    
    /**
	*  病房患者统计数据插入保存
	*/
	public abstract NomBedwardItmDO[] insert(NomBedwardItmDO[] aggdos) throws BizException;
	
    /**
	*  病房患者统计数据保存
	*/
	public abstract NomBedwardItmDO[] save(NomBedwardItmDO[] aggdos) throws BizException;
	
    /**
	*  病房患者统计数据更新
	*/
	public abstract NomBedwardItmDO[] update(NomBedwardItmDO[] aggdos) throws BizException;
	
	/**
	*  病房患者统计数据逻辑删除
	*/
	public abstract void logicDelete(NomBedwardItmDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NomBedwardItmDO[] enableWithoutFilter(NomBedwardItmDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NomBedwardItmDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NomBedwardItmDO[] disableVOWithoutFilter(NomBedwardItmDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NomBedwardItmDO[] aggdos) throws BizException ;
	
}
