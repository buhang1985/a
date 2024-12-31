package iih.pis.ivx.admin.i;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import iih.pis.ivx.pisivxaccount.d.PisIvxAccountDO;
import iih.pis.ivx.pisivxmenu.d.PisivxMenuDO;
import iih.pis.ivx.pisivxmodule.d.PisivxModuleDO;
import iih.pis.ivx.pisivxmsgtmpl.d.PisivxMsgTmplDO;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingDO;
import iih.pis.ivx.pisivxsetting.d.PisivxTagsDO;
import iih.pis.ivx.pisivxsrvact.d.PisIvxSrvactTagDO;
import iih.pis.ivx.pisivxsrvactmsgtpl.d.PisIvxSrvactMsgtplDO;
import iih.pis.ivx.pisivxsrvmenu.d.PisIvxSrvMenuDO;
import xap.mw.core.data.BizException;

public interface IAdminService {
	
	public List<PisivxMenuDO> getMenuList() throws BizException;
	
	public List<PisivxModuleDO> getModule() throws BizException;
	
	public void saveMenu(List<PisivxMenuDO> menu) throws BizException;
	
	/**
	 * 创建菜单(自定义，个性化通用)
	 * @param pisivxTagsDO
	 * @throws BizException
	 */
	public void releaseMenu(PisIvxSettingDO settings, PisivxTagsDO tags) throws BizException;
	
	/**
	 * 创建菜单
	 * @param pisIvxSrvMenuDO
	 * @throws BizException
	 */
	public boolean createMenu(PisIvxSrvMenuDO pisIvxSrvMenuDO) throws BizException;

	
	/**
	 * 创建个性化菜单
	 * @param pisIvxSrvMenuDO
	 * @return
	 * @throws BizException
	 */
	public String createConditionMenu(PisIvxSrvMenuDO pisIvxSrvMenuDO) throws BizException;
	
	/**
	 * 删除菜单
	 * @return
	 * @throws BizException
	 */
	public boolean deleteMenu() throws BizException;
	
	/**
	 * 删除个性化菜单
	 */
	public boolean delConditionalMenu(PisIvxSrvMenuDO pisIvxSrvMenuDo) throws BizException;
	
	/**
	 * 同步微信服务器菜单
	 * @return
	 * @throws BizException
	 * @throws Exception 
	 */
	public boolean sysWeMenu(String id_ivx_srvact) throws BizException, Exception;
	
	public void disableMenu() throws BizException;
	
	/**
	 * 群发文本消息
	 * @param msgid
	 * @throws BizException
	 */
	public void msgPushText(String msgid) throws BizException;
	
	/**
	 * 循环群发文本消息
	 * @param msgid
	 * @throws BizException
	 */
	public void msgPushTextLoop(String msgid) throws BizException;
	
	/**
	 * 给特定openid发送指定消息
	 * @param openId
	 * @param msgContent
	 * @throws BizException
	 */
	public void msgPushTextSingle(String openId, String msgContent) throws BizException;
	
	/**
	 * 群发标签用户文本消息
	 * @param id_pisivxtags
	 * @param msgContent
	 * @throws BizException
	 */
	public void tagUserMsgPushText(String id_pisivxtags,String msgContent) throws BizException;
	
	/**
	 *  群发模板消息
	 * @param pisivxMsgTmplDO
	 * @throws BizException
	 */
	public void msgPushTmpl(PisivxMsgTmplDO pisivxMsgTmplDO) throws BizException;
	
	/**
	 *  关注后，发送欢迎消息
	 * @param openId
	 * @throws BizException
	 */
	public void msgWelcomPushText(String openId) throws BizException;

	
	
	/**
	 * 订阅或关注事件
	 * @param account
	 * @throws BizException
	 */
	public void subscribe(PisIvxAccountDO account) throws BizException;
	
	/**
	 * 取消订阅或取消关注事件
	 * @param openId
	 * @throws BizException
	 */
	public void unsubscribe(String openId) throws BizException;
	
	/**
	 * 用户标签创建
	 * @param pisivxTagsDO
	 * @throws BizException
	 */
	public void createTags(PisivxTagsDO pisivxTagsDO) throws BizException;
	
	/**
	 * 发送模板消息
	 * @param openids
	 * @param template_id
	 * @param url
	 * @param map
	 * @throws BizException
	 */
	public void sendTmplMsg(String[] openids, String template_id, String url, Map<String, String> map) throws BizException;
	
	/**
	 * 创建服务号标签
	 * @param PisIvxSrvactTagDO
	 * @throws BizException
	 */
	public PisIvxSrvactTagDO createSrvactTag(PisIvxSrvactTagDO pisIvxSrvactTagDO) throws BizException;
	
	/**
	 * 更新服务号标签
	 * @param pisIvxSrvactTagDO
	 * @return
	 * @throws BizException
	 */
	public boolean updateSrvactTag(PisIvxSrvactTagDO pisIvxSrvactTagDO) throws BizException;
	
	/**
	 * 删除服务号标签
	 * @param tagId
	 * @return
	 * @throws BizException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public boolean deleteSrvactTag(int tagId) throws BizException;
	
	/**
	 * 获取服务号下已创建的标签
	 * @return
	 * @throws BizException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public PisIvxSrvactTagDO[] getSrvactTag() throws BizException;
	
	/**
	 * 同步全部openid 
	 * @param setting
	 * @throws BizException
	 */
	public void synOpenid(PisIvxSettingDO setting) throws BizException;
	
	/**
	 * 同步全部单个openid 
	 * @param openid
	 * @return
	 * @throws BizException
	 */
	public PisIvxAccountDO synSingleOpenid(String openid) throws BizException;
	
	/**
	 * 获取课程培训链接地址
	 * @param courseid
	 * @return
	 * @throws BizException
	 */
	public String[] getCourseUrl(String[] courseid) throws BizException;
	
	
	/**
	 * 获取模板消息列表
	* @return
	* @throws BizException
	 */
	public PisIvxSrvactMsgtplDO[] getAllPrivateTemplate() throws BizException;
	
	/**
	 * 删除模板消息
	* @param templateId
	* @throws BizException
	 */
	public boolean delPrivateTemplate(String templateId) throws BizException;
	
	/**
	 * 是否是默认服务号
	 * @return
	 * @throws BizException
	 */
	public boolean isDefaultSrvactInfo(String ivxSrvactId) throws BizException;
}
