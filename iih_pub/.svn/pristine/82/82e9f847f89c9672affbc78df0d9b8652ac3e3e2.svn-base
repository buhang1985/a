package iih.ems.eass.emde.i;


import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.ems.eass.emde.d.EmsDeDO;

/**
* 设备折旧数据维护服务
*/
public interface IEmdeExtService {
	/**
	*  根据折旧年月查询需要折旧的资产卡
	*  de_ym  折旧年月
	*  canDE 是否可折旧的资产卡
	*/	
	public abstract EmsDeDO[] getNotDeCard(String de_ym,FBoolean canDE) throws BizException;
	
	
	/**
	*  根据折旧年月折旧所有当月可折旧的资产卡
	*  de_ym  折旧年月
	*/	
	public abstract String deAllCard(String de_ym) throws BizException;
	
	/**
	*  折旧选中的资产卡
	*/	
	public abstract String deSelectedCard(EmsDeDO[] des) throws BizException;
	
	
}