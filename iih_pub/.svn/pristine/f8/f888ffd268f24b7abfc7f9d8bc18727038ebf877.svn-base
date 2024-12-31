package iih.bd.srv.medsrv.i;

import xap.mw.core.data.BizException;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;

/**
* 医疗服务数据维护服务
*/
public interface IMedsrvCudService {
	/**
	*  医疗服务数据真删除
	*/
    public abstract void delete(MedsrvAggDO[] aggdos) throws BizException;
    
    /**
	*  医疗服务数据插入保存
	*/
	public abstract MedsrvAggDO[] insert(MedsrvAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务数据保存
	*/
	public abstract MedsrvAggDO[] save(MedsrvAggDO[] aggdos) throws BizException;
	
    /**
	*  医疗服务数据更新
	*/
	public abstract MedsrvAggDO[] update(MedsrvAggDO[] aggdos) throws BizException;
	
	/**
	*  医疗服务数据逻辑删除
	*/
	public abstract void logicDelete(MedsrvAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务数据真删除
	 */
	public abstract void deleteByParentDO(MedSrvDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医疗服务数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(MedSrvDO[] mainDos) throws BizException;
}
