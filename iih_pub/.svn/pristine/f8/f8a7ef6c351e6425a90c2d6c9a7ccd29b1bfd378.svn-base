package iih.pe.pitm.pesrvbcatlog.i;

import xap.mw.core.data.BizException;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvCastChargeDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检项目基本目录数据维护服务
*/
public interface IPeSrvCastChargeDOCudService {
	/**
	*  体检项目基本目录数据真删除
	*/
    public abstract void delete(PeSrvCastChargeDO[] aggdos) throws BizException;
    
    /**
	*  体检项目基本目录数据插入保存
	*/
	public abstract PeSrvCastChargeDO[] insert(PeSrvCastChargeDO[] aggdos) throws BizException;
	
    /**
	*  体检项目基本目录数据保存
	*/
	public abstract PeSrvCastChargeDO[] save(PeSrvCastChargeDO[] aggdos) throws BizException;
	
    /**
	*  体检项目基本目录数据更新
	*/
	public abstract PeSrvCastChargeDO[] update(PeSrvCastChargeDO[] aggdos) throws BizException;
	
	/**
	*  体检项目基本目录数据逻辑删除
	*/
	public abstract void logicDelete(PeSrvCastChargeDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSrvCastChargeDO[] enableWithoutFilter(PeSrvCastChargeDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSrvCastChargeDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSrvCastChargeDO[] disableVOWithoutFilter(PeSrvCastChargeDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSrvCastChargeDO[] aggdos) throws BizException ;
	
}
