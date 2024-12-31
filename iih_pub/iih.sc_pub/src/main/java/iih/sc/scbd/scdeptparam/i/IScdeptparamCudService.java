package iih.sc.scbd.scdeptparam.i;

import xap.mw.core.data.BizException;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;

/**
* 排班科室参数数据维护服务
*/
public interface IScdeptparamCudService {
	/**
	*  排班科室参数数据真删除
	*/
    public abstract void delete(ScdeptparamAggDO[] aggdos) throws BizException;
    
    /**
	*  排班科室参数数据插入保存
	*/
	public abstract ScdeptparamAggDO[] insert(ScdeptparamAggDO[] aggdos) throws BizException;
	
    /**
	*  排班科室参数数据保存
	*/
	public abstract ScdeptparamAggDO[] save(ScdeptparamAggDO[] aggdos) throws BizException;
	
    /**
	*  排班科室参数数据更新
	*/
	public abstract ScdeptparamAggDO[] update(ScdeptparamAggDO[] aggdos) throws BizException;
	
	/**
	*  排班科室参数数据逻辑删除
	*/
	public abstract void logicDelete(ScdeptparamAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对排班科室参数数据真删除
	 */
	public abstract void deleteByParentDO(ScDeptParamDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对排班科室参数数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(ScDeptParamDO[] mainDos) throws BizException;
}
