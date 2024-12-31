package iih.bl.st.blstproxyhp.i;

import xap.mw.core.data.BizException;
import iih.bl.st.blstproxyhp.d.BlStProxyhpDO;
import iih.bl.st.blstproxyhp.d.BlstproxyhpAggDO;

/**
* 代报结算_门急诊转住院数据维护服务
*/
public interface IBlstproxyhpCudService {
	/**
	*  代报结算_门急诊转住院数据真删除
	*/
    public abstract void delete(BlstproxyhpAggDO[] aggdos) throws BizException;
    
    /**
	*  代报结算_门急诊转住院数据插入保存
	*/
	public abstract BlstproxyhpAggDO[] insert(BlstproxyhpAggDO[] aggdos) throws BizException;
	
    /**
	*  代报结算_门急诊转住院数据保存
	*/
	public abstract BlstproxyhpAggDO[] save(BlstproxyhpAggDO[] aggdos) throws BizException;
	
    /**
	*  代报结算_门急诊转住院数据更新
	*/
	public abstract BlstproxyhpAggDO[] update(BlstproxyhpAggDO[] aggdos) throws BizException;
	
	/**
	*  代报结算_门急诊转住院数据逻辑删除
	*/
	public abstract void logicDelete(BlstproxyhpAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对代报结算_门急诊转住院数据真删除
	 */
	public abstract void deleteByParentDO(BlStProxyhpDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对代报结算_门急诊转住院数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(BlStProxyhpDO[] mainDos) throws BizException;
}
