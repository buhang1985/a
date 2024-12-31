package iih.mi.biz.mirecordstrecord.i;

import xap.mw.core.data.BizException;
import iih.mi.biz.mirecordstrecord.d.MiOrderStRecordDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保交易结算状态关系表数据维护服务
*/
public interface IMirecordstrecordCudService {
	/**
	*  医保交易结算状态关系表数据真删除
	*/
    public abstract void delete(MiOrderStRecordDO[] aggdos) throws BizException;
    
    /**
	*  医保交易结算状态关系表数据插入保存
	*/
	public abstract MiOrderStRecordDO[] insert(MiOrderStRecordDO[] aggdos) throws BizException;
	
    /**
	*  医保交易结算状态关系表数据保存
	*/
	public abstract MiOrderStRecordDO[] save(MiOrderStRecordDO[] aggdos) throws BizException;
	
    /**
	*  医保交易结算状态关系表数据更新
	*/
	public abstract MiOrderStRecordDO[] update(MiOrderStRecordDO[] aggdos) throws BizException;
	
	/**
	*  医保交易结算状态关系表数据逻辑删除
	*/
	public abstract void logicDelete(MiOrderStRecordDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public MiOrderStRecordDO[] enableWithoutFilter(MiOrderStRecordDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(MiOrderStRecordDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public MiOrderStRecordDO[] disableVOWithoutFilter(MiOrderStRecordDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(MiOrderStRecordDO[] dos) throws BizException ;
}
