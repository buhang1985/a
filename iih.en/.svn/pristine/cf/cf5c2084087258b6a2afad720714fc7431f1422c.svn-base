package iih.en.comm.validator;

import iih.en.comm.IEnMsgConst;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FDateTime;

/**
 * 版本验证器
 * @author yank
 *
 */
public class EnVersionValidator {
	/**
	 * 验证版本
	 * @param currentDO 当前DO
	 * @param persitDO 持久化DO
	 * @throws BizException
	 */
	public static void validate(BaseDO currentDO,BaseDO persitDO) throws BizException{
		if(currentDO==null){
			throw new BizException("参数：currentDO为空！");
		}
		if(persitDO==null){
			throw new BizException("参数：persitDO为空！");
		}
		
		FDateTime currentSv = (FDateTime)currentDO.getAttrVal(GlobalConst.SYSTEM_VERSION);
		FDateTime persistSv = (FDateTime)persitDO.getAttrVal(GlobalConst.SYSTEM_VERSION);		
		if(currentSv == null || persistSv==null){
			throw new BizException(IEnMsgConst.ERROR_SV_NOT_EXIST);
		}	
		//如果数据库的SV比当前SV时间晚，则说明数据已经被修改
		if(persistSv.after(currentSv)){
			throw new BizException(IEnMsgConst.ERROR_DATA_HAS_MODIFIED);
		}
	}
}
