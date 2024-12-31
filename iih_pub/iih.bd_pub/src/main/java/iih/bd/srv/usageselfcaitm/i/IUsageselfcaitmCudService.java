package iih.bd.srv.usageselfcaitm.i;

import xap.mw.core.data.BizException;
import  iih.bd.srv.usageselfcaitm.d.UsageselfcaitmAggDO;

/**
* 用法自定义分类项目数据维护服务
*/
public interface IUsageselfcaitmCudService {
	/**
	*  用法自定义分类项目数据删除
	*/
    public abstract void delete(UsageselfcaitmAggDO[] aggdos) throws BizException;
    
    /**
	*  用法自定义分类项目数据插入保存
	*/
	public abstract UsageselfcaitmAggDO[] insert(UsageselfcaitmAggDO[] aggdos) throws BizException;
	
    /**
	*  用法自定义分类项目数据保存
	*/
	public abstract UsageselfcaitmAggDO[] save(UsageselfcaitmAggDO[] aggdos) throws BizException;
	
    /**
	*  用法自定义分类项目数据更新
	*/
	public abstract UsageselfcaitmAggDO[] update(UsageselfcaitmAggDO[] aggdos) throws BizException;
	
	/**
	*  用法自定义分类项目数据真删
	*/
	public abstract void logicDelete(UsageselfcaitmAggDO[] aggdos) throws BizException;
}
