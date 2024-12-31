package iih.ci.mr.nu.perioperativenurrec.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.perioperativenurrec.d.PpNurDO;
import iih.ci.mr.nu.perioperativenurrec.d.PerioperativenurrecAggDO;

/**
* 围手术期护理记录单数据维护服务
*/
public interface IPerioperativenurrecCudService {
	/**
	*  围手术期护理记录单数据真删除
	*/
    public abstract void delete(PerioperativenurrecAggDO[] aggdos) throws BizException;
    
    /**
	*  围手术期护理记录单数据插入保存
	*/
	public abstract PerioperativenurrecAggDO[] insert(PerioperativenurrecAggDO[] aggdos) throws BizException;
	
    /**
	*  围手术期护理记录单数据保存
	*/
	public abstract PerioperativenurrecAggDO[] save(PerioperativenurrecAggDO[] aggdos) throws BizException;
	
    /**
	*  围手术期护理记录单数据更新
	*/
	public abstract PerioperativenurrecAggDO[] update(PerioperativenurrecAggDO[] aggdos) throws BizException;
	
	/**
	*  围手术期护理记录单数据逻辑删除
	*/
	public abstract void logicDelete(PerioperativenurrecAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对围手术期护理记录单数据真删除
	 */
	public abstract void deleteByParentDO(PpNurDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对围手术期护理记录单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PpNurDO[] mainDos) throws BizException;
}
