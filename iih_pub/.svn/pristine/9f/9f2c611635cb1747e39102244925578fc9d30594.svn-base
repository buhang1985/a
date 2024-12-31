package iih.bd.pp.hpdidictah.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.hpdidictah.d.HpDiDictAhDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 医保诊断扩展_东软安徽数据维护服务
*/
public interface IHpdidictahCudService {
	/**
	*  医保诊断扩展_东软安徽数据真删除
	*/
    public abstract void delete(HpDiDictAhDO[] aggdos) throws BizException;
    
    /**
	*  医保诊断扩展_东软安徽数据插入保存
	*/
	public abstract HpDiDictAhDO[] insert(HpDiDictAhDO[] aggdos) throws BizException;
	
    /**
	*  医保诊断扩展_东软安徽数据保存
	*/
	public abstract HpDiDictAhDO[] save(HpDiDictAhDO[] aggdos) throws BizException;
	
    /**
	*  医保诊断扩展_东软安徽数据更新
	*/
	public abstract HpDiDictAhDO[] update(HpDiDictAhDO[] aggdos) throws BizException;
	
	/**
	*  医保诊断扩展_东软安徽数据逻辑删除
	*/
	public abstract void logicDelete(HpDiDictAhDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public HpDiDictAhDO[] enableWithoutFilter(HpDiDictAhDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(HpDiDictAhDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public HpDiDictAhDO[] disableVOWithoutFilter(HpDiDictAhDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(HpDiDictAhDO[] dos) throws BizException ;
}
