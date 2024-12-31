package iih.mp.orm.surginsmtmrtpl.i;

import xap.mw.core.data.BizException;
import iih.mp.orm.surginsmtmrtpl.d.SurgInsmtMrtplDO;
import iih.mp.orm.surginsmtmrtpl.d.SurginsmtmrtplAggDO;

/**
* 手术器械模板数据维护服务
*/
public interface ISurginsmtmrtplCudService {
	/**
	*  手术器械模板数据真删除
	*/
    public abstract void delete(SurginsmtmrtplAggDO[] aggdos) throws BizException;
    
    /**
	*  手术器械模板数据插入保存
	*/
	public abstract SurginsmtmrtplAggDO[] insert(SurginsmtmrtplAggDO[] aggdos) throws BizException;
	
    /**
	*  手术器械模板数据保存
	*/
	public abstract SurginsmtmrtplAggDO[] save(SurginsmtmrtplAggDO[] aggdos) throws BizException;
	
    /**
	*  手术器械模板数据更新
	*/
	public abstract SurginsmtmrtplAggDO[] update(SurginsmtmrtplAggDO[] aggdos) throws BizException;
	
	/**
	*  手术器械模板数据逻辑删除
	*/
	public abstract void logicDelete(SurginsmtmrtplAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对手术器械模板数据真删除
	 */
	public abstract void deleteByParentDO(SurgInsmtMrtplDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对手术器械模板数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SurgInsmtMrtplDO[] mainDos) throws BizException;
}
