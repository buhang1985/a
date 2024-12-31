package iih.bd.srv.emrtpl.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.d.EmrtplAggDO;

/**
* 医疗记录模板数据维护服务
*/
public interface IEmrtplCudService {
	/**
	*  医疗记录模板数据真删除
	*/
    public abstract void delete(EmrtplAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗记录模板数据插入保存
	*/
	public abstract EmrtplAggDO[] insert(EmrtplAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板数据保存
	*/
	public abstract EmrtplAggDO[] save(EmrtplAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗记录模板数据更新
	*/
	public abstract EmrtplAggDO[] update(EmrtplAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗记录模板数据逻辑删除
	*/
	public abstract void logicDelete(EmrtplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录模板数据真删除
	 */
	public abstract void deleteByParentDO(EmrTplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗记录模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(EmrTplDO[] mainDos) throws BizException;
	
	/**
	 * 修改位置
	 * @param emrtplDo
	 */
	public abstract void changeOrder(EmrTplDO emrtplDoOne,EmrTplDO emrtplDoTwo) throws BizException;
}
