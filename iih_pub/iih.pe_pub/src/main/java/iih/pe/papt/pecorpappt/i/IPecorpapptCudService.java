package iih.pe.papt.pecorpappt.i;

import xap.mw.core.data.BizException;
import iih.pe.papt.pecorpappt.d.PeCorpApptDO;
import iih.pe.papt.pecorpappt.d.PecorpapptAggDO;

/**
* 体检团体预约单数据维护服务
*/
public interface IPecorpapptCudService {
	/**
	*  体检团体预约单数据真删除
	*/
    public abstract void delete(PecorpapptAggDO[] aggdos) throws BizException;
    
    /**
	*  体检团体预约单数据插入保存
	*/
	public abstract PecorpapptAggDO[] insert(PecorpapptAggDO[] aggdos) throws BizException;
	
    /**
	*  体检团体预约单数据保存
	*/
	public abstract PecorpapptAggDO[] save(PecorpapptAggDO[] aggdos) throws BizException;
	
    /**
	*  体检团体预约单数据更新
	*/
	public abstract PecorpapptAggDO[] update(PecorpapptAggDO[] aggdos) throws BizException;
	
	/**
	*  体检团体预约单数据逻辑删除
	*/
	public abstract void logicDelete(PecorpapptAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对体检团体预约单数据真删除
	 */
	public abstract void deleteByParentDO(PeCorpApptDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对体检团体预约单数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(PeCorpApptDO[] mainDos) throws BizException;
}
