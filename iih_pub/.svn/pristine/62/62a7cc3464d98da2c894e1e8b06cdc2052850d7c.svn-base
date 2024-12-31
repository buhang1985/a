package iih.ci.mrm.cimrfpdicatado.i;

import xap.mw.core.data.BizException;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpDiCataDO;
import iih.ci.mrm.cimrfpdicatado.d.CimrfpdicatadoAggDO;

/**
* 病案编目诊断数据维护服务
*/
public interface ICimrfpdicatadoCudService {
	/**
	*  病案编目诊断数据真删除
	*/
    public abstract void delete(CimrfpdicatadoAggDO[] aggdos) throws BizException;
    
    /**
	*  病案编目诊断数据插入保存
	*/
	public abstract CimrfpdicatadoAggDO[] insert(CimrfpdicatadoAggDO[] aggdos) throws BizException;
	
    /**
	*  病案编目诊断数据保存
	*/
	public abstract CimrfpdicatadoAggDO[] save(CimrfpdicatadoAggDO[] aggdos) throws BizException;
	
    /**
	*  病案编目诊断数据更新
	*/
	public abstract CimrfpdicatadoAggDO[] update(CimrfpdicatadoAggDO[] aggdos) throws BizException;
	
	/**
	*  病案编目诊断数据逻辑删除
	*/
	public abstract void logicDelete(CimrfpdicatadoAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对病案编目诊断数据真删除
	 */
	public abstract void deleteByParentDO(CiMrFpDiCataDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对病案编目诊断数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiMrFpDiCataDO[] mainDos) throws BizException;
}
