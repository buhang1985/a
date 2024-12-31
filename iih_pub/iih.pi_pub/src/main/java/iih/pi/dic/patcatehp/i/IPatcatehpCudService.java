package iih.pi.dic.patcatehp.i;

import xap.mw.core.data.BizException;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 患者分类医保计划数据维护服务
*/
public interface IPatcatehpCudService {
	/**
	*  患者分类医保计划数据真删除
	*/
    public abstract void delete(PiPatCaHpDO[] aggdos) throws BizException;
    
    /**
	*  患者分类医保计划数据插入保存
	*/
	public abstract PiPatCaHpDO[] insert(PiPatCaHpDO[] aggdos) throws BizException;
	
    /**
	*  患者分类医保计划数据保存
	*/
	public abstract PiPatCaHpDO[] save(PiPatCaHpDO[] aggdos) throws BizException;
	
    /**
	*  患者分类医保计划数据更新
	*/
	public abstract PiPatCaHpDO[] update(PiPatCaHpDO[] aggdos) throws BizException;
	
	/**
	*  患者分类医保计划数据逻辑删除
	*/
	public abstract void logicDelete(PiPatCaHpDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PiPatCaHpDO[] enableWithoutFilter(PiPatCaHpDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PiPatCaHpDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PiPatCaHpDO[] disableVOWithoutFilter(PiPatCaHpDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PiPatCaHpDO[] dos) throws BizException ;
}
