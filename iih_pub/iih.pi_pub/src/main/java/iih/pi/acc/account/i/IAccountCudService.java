package iih.pi.acc.account.i;

import xap.mw.core.data.BizException;
import  iih.pi.acc.account.d.AccountAggDO;

/**
* 患者账户数据维护服务
*/
public interface IAccountCudService {
	/**
	*  患者账户数据真删除
	*/
    public abstract void delete(AccountAggDO[] aggdos) throws BizException;
    
    /**
	*  患者账户数据插入保存
	*/
	public abstract AccountAggDO[] insert(AccountAggDO[] aggdos) throws BizException;
	
    /**
	*  患者账户数据保存
	*/
	public abstract AccountAggDO[] save(AccountAggDO[] aggdos) throws BizException;
	
    /**
	*  患者账户数据更新
	*/
	public abstract AccountAggDO[] update(AccountAggDO[] aggdos) throws BizException;
	
	/**
	*  患者账户数据逻辑删除
	*/
	public abstract void logicDelete(AccountAggDO[] aggdos) throws BizException;
}
