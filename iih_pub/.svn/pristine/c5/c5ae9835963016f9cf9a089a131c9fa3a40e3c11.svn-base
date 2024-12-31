package iih.ci.mr.mrsign.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.d.MrsignAggDO;

/**
* 临床医疗记录签名数据维护服务
*/
public interface IMrsignCudService {
	/**
	*  临床医疗记录签名数据真删除
	*/
    public abstract void delete(MrsignAggDO[] aggdos) throws BizException;
    
    /**
	*  临床医疗记录签名数据插入保存
	*/
	public abstract MrsignAggDO[] insert(MrsignAggDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录签名数据保存
	*/
	public abstract MrsignAggDO[] save(MrsignAggDO[] aggdos) throws BizException;
	
    /**
	*  临床医疗记录签名数据更新
	*/
	public abstract MrsignAggDO[] update(MrsignAggDO[] aggdos) throws BizException;
	
	/**
	*  临床医疗记录签名数据逻辑删除
	*/
	public abstract void logicDelete(MrsignAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对临床医疗记录签名数据真删除
	 */
	public abstract void deleteByParentDO(CiMrSignDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对临床医疗记录签名数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(CiMrSignDO[] mainDos) throws BizException;
}
