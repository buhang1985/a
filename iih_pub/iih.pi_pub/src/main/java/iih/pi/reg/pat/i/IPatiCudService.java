package iih.pi.reg.pat.i;

import xap.mw.core.data.BizException;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;

/**
* 患者基本信息数据维护服务
*/
public interface IPatiCudService {
	/**
	*  患者基本信息数据真删除
	*/
    public abstract void delete(PatiAggDO[] aggdos) throws BizException;
    
    /**
	*  患者基本信息数据插入保存
	*/
	public abstract PatiAggDO[] insert(PatiAggDO[] aggdos) throws BizException;
	
    /**
	*  患者基本信息数据保存
	*/
	public abstract PatiAggDO[] save(PatiAggDO[] aggdos) throws BizException;
	
    /**
	*  患者基本信息数据更新
	*/
	public abstract PatiAggDO[] update(PatiAggDO[] aggdos) throws BizException;
	
	/**
	*  患者基本信息数据逻辑删除
	*/
	public abstract void logicDelete(PatiAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对患者基本信息数据真删除
	 */
	public abstract void deleteByParentDO(PatDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对患者基本信息数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PatDO[] mainDos) throws BizException;
}
