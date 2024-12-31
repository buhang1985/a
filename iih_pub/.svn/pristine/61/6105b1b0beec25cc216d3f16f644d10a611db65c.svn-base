package iih.sc.apt.out.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 
 * 为Mp提供服务
 * 
 * @author yzh
 * 
 * 2019年6月13日17:45:06
 */
public interface ISc4MpCmdService {
	/**
	 * MP域接收BS024消息后调用该接口接收MP参数修改医技预约申请单到检状态
	 * @author yzh
	 * @param params
	 * @throws BizException
	 */
	public void updateMtApplAry(FArrayList params) throws BizException;
	
	/**
	 * 提供 给MP域设置-取消执行状态
	 * @author yaohl
	 * @param ids  医嘱id数组
	 * @param id_emp 操作人员id
	 * @param dt_opera 操作时间
	 * @throws BizException
	 */
	public void setScAptApplCancExec (String[] idOrs,String id_emp,String dt_canc) throws BizException;
	
	/**
	 * 提供 给MP域设置预约申请-撤销取消执行
	 * @author yaohl
	 * @param ids  医嘱id数组
	 * @param id_emp 操作人员id
	 * @param dt_opera 操作时间
	 * @throws BizException
	 */
	public void setScAptApplUndoCancExec (String[] idOrs,String id_emp,String dt_opera) throws BizException;
}
