package iih.nmr.pkuf.prebracordxh.i;

import xap.mw.core.data.BizException;
import iih.nmr.pkuf.prebracordxh.d.PreBraCordxhDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 预防压疮护理评估表（Braden评分）数据维护服务
*/
public interface IPrebracordxh1CudService {
	/**
	*  预防压疮护理评估表（Braden评分）数据真删除
	*/
    public abstract void delete(PreBraCordxhDO[] aggdos) throws BizException;
    
    /**
	*  预防压疮护理评估表（Braden评分）数据插入保存
	*/
	public abstract PreBraCordxhDO[] insert(PreBraCordxhDO[] aggdos) throws BizException;
	
    /**
	*  预防压疮护理评估表（Braden评分）数据保存
	*/
	public abstract PreBraCordxhDO[] save(PreBraCordxhDO[] aggdos) throws BizException;
	
    /**
	*  预防压疮护理评估表（Braden评分）数据更新
	*/
	public abstract PreBraCordxhDO[] update(PreBraCordxhDO[] aggdos) throws BizException;
	
	/**
	*  预防压疮护理评估表（Braden评分）数据逻辑删除
	*/
	public abstract void logicDelete(PreBraCordxhDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PreBraCordxhDO[] enableWithoutFilter(PreBraCordxhDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PreBraCordxhDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PreBraCordxhDO[] disableVOWithoutFilter(PreBraCordxhDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PreBraCordxhDO[] dos) throws BizException ;
}
