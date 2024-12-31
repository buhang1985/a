package iih.bd.pp.hpdidict.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hpdidict.d.HpDiDictDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 付款策略_医保诊断数据维护服务
*/
public interface IHpdidictCudService {
	/**
	*  付款策略_医保诊断数据真删除
	*/
    public abstract void delete(HpDiDictDO[] aggdos) throws BizException;
    
    /**
	*  付款策略_医保诊断数据插入保存
	*/
	public abstract HpDiDictDO[] insert(HpDiDictDO[] aggdos) throws BizException;
	
    /**
	*  付款策略_医保诊断数据保存
	*/
	public abstract HpDiDictDO[] save(HpDiDictDO[] aggdos) throws BizException;
	
    /**
	*  付款策略_医保诊断数据更新
	*/
	public abstract HpDiDictDO[] update(HpDiDictDO[] aggdos) throws BizException;
	
	/**
	*  付款策略_医保诊断数据逻辑删除
	*/
	public abstract void logicDelete(HpDiDictDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDiDictDO[] enableWithoutFilter(HpDiDictDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDiDictDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDiDictDO[] disableVOWithoutFilter(HpDiDictDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDiDictDO[] dos) throws BizException ;
}
