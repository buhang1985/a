package iih.pe.por.pecorpbinfo.i;

import xap.mw.core.data.BizException;
import iih.pe.por.pecorpbinfo.d.PeCorpbInfoDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 体检团体信息数据维护服务
*/
public interface IPecorpbinfoMDOCudService {
	/**
	*  体检团体信息数据真删除
	*/
    public abstract void delete(PeCorpbInfoDO[] aggdos) throws BizException;
    
    /**
	*  体检团体信息数据插入保存
	*/
	public abstract PeCorpbInfoDO[] insert(PeCorpbInfoDO[] aggdos) throws BizException;
	
    /**
	*  体检团体信息数据保存
	*/
	public abstract PeCorpbInfoDO[] save(PeCorpbInfoDO[] aggdos) throws BizException;
	
    /**
	*  体检团体信息数据更新
	*/
	public abstract PeCorpbInfoDO[] update(PeCorpbInfoDO[] aggdos) throws BizException;
	
	/**
	*  体检团体信息数据逻辑删除
	*/
	public abstract void logicDelete(PeCorpbInfoDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeCorpbInfoDO[] enableWithoutFilter(PeCorpbInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeCorpbInfoDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeCorpbInfoDO[] disableVOWithoutFilter(PeCorpbInfoDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeCorpbInfoDO[] aggdos) throws BizException ;
	
}
