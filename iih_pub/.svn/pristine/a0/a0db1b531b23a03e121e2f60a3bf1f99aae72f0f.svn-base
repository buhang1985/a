package iih.pe.phm.pesurveycma.i;

import xap.mw.core.data.BizException;
import iih.pe.phm.pesurveycma.d.PeSurveyCmaDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;

/**
* 体检自测问卷_中华医学会健康分会数据维护服务
*/
public interface IPesurveycmaCudService {
	/**
	*  体检自测问卷_中华医学会健康分会数据真删除
	*/
    public abstract void delete(PeSurveyCmaDO[] aggdos) throws BizException;
    
    /**
	*  体检自测问卷_中华医学会健康分会数据插入保存
	*/
	public abstract PeSurveyCmaDO[] insert(PeSurveyCmaDO[] aggdos) throws BizException;
	
    /**
	*  体检自测问卷_中华医学会健康分会数据保存
	*/
	public abstract PeSurveyCmaDO[] save(PeSurveyCmaDO[] aggdos) throws BizException;
	
    /**
	*  体检自测问卷_中华医学会健康分会数据更新
	*/
	public abstract PeSurveyCmaDO[] update(PeSurveyCmaDO[] aggdos) throws BizException;
	
	/**
	*  体检自测问卷_中华医学会健康分会数据逻辑删除
	*/
	public abstract void logicDelete(PeSurveyCmaDO[] aggdos) throws BizException;

	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public PeSurveyCmaDO[] enableWithoutFilter(PeSurveyCmaDO[] dos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(PeSurveyCmaDO[] dos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public PeSurveyCmaDO[] disableVOWithoutFilter(PeSurveyCmaDO[] dos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(PeSurveyCmaDO[] dos) throws BizException ;
}
