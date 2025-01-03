package iih.ci.mr.i;

import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.BizException;

/**
 * 病历文书内容上传集成平台接口</br>
 * 用于统一处理门诊病历和住院病历新增、修改、召回、删除时的上传消息触发
 * @author YanSu
 */
public interface ICiMrUpLoadService {
	
	/**
	 * 发送消息
	 * @param ciMrDO 上传DO数据
	 * @param upLoadStatus 上传状态：01 提交/诊毕，02 删除
	 * @return true：成功/false：失败
	 * @throws BizException
	 */
	public abstract boolean sendMessage(CiMrDO ciMrDO, String upLoadStatus) throws BizException;
	
	/**
	 * 发送消息
	 * @param ciMrDOs 上传DO数组数据
	 * @param upLoadStatus 上传状态：01 提交/诊毕，02 删除
	 * @return true：成功/false：失败
	 * @throws BizException
	 */
	public abstract boolean sendMessage2(CiMrDO[] ciMrDOs, String upLoadStatus) throws BizException;
	
	/**
	 * 通过事件源ID发送消息给监听
	 * @param msgArr 消息内容
	 * @param eventFlag 事件源ID
	 * @return true：成功/false：失败
	 * @throws BizException
	 */
	public abstract boolean sendMessageByEventFlag(String[] msgArr, String eventFlag) throws BizException;
	
}
