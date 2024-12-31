package iih.bd.pp.singlediamt.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.singlediamt.d.SingleDiAmtDO;
import iih.bd.pp.singlediamt.d.SinglediamtAggDO;

/**
* 医保计划单病种控费数据维护服务
*/
public interface ISinglediamtCudService {
	/**
	*  医保计划单病种控费数据真删除
	*/
    public abstract void delete(SinglediamtAggDO[] aggdos) throws BizException;
    
    /**
	*  医保计划单病种控费数据插入保存
	*/
	public abstract SinglediamtAggDO[] insert(SinglediamtAggDO[] aggdos) throws BizException;
	
    /**
	*  医保计划单病种控费数据保存
	*/
	public abstract SinglediamtAggDO[] save(SinglediamtAggDO[] aggdos) throws BizException;
	
    /**
	*  医保计划单病种控费数据更新
	*/
	public abstract SinglediamtAggDO[] update(SinglediamtAggDO[] aggdos) throws BizException;
	
	/**
	*  医保计划单病种控费数据逻辑删除
	*/
	public abstract void logicDelete(SinglediamtAggDO[] aggdos) throws BizException;
	
	/**
	 *  根据主DO对医保计划单病种控费数据真删除
	 */
	public abstract void deleteByParentDO(SingleDiAmtDO[] mainDos) throws BizException;
	
	/**
	 *  根据主DO对医保计划单病种控费数据逻辑删除
	 */
	public abstract void logicDeleteByParentDO(SingleDiAmtDO[] mainDos) throws BizException;
}
