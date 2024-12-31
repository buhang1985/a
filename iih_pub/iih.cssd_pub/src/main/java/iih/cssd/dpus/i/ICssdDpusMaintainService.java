package iih.cssd.dpus.i;

import iih.cssd.dpus.dfpapp.d.DfpAppDO;
import iih.cssd.dpus.dfpgrnt.d.DfpGrntDO;
import iih.cssd.dpus.dfpisu.d.DfpSendDO;
import iih.cssd.dpus.dto.dfpappdto.d.AppCardSourceDTO;
import iih.cssd.dpus.dto.dfpappsend.d.DfpSendSourceDTO;
import iih.cssd.dpus.dto.dfprev.d.DfpRevDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * @Description:包使用通用维护服务
 * @author: xu_xing@founder.com.cn
 * @version：2019年9月16日 下午12:42:53 创建
 */
public interface ICssdDpusMaintainService {

	/**
	 * 消毒包请领保存
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void dfpAppSave(AppCardSourceDTO param) throws BizException;

	/**
	 * 生成请领
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract String grntApp(DfpGrntDO[] grnts) throws BizException;

	/**
	 * 消毒包请领提交
	 * @param params
	 * @throws BizException
	 */
	public abstract void dfpAppSubmit(String[] id_dfp_apps) throws BizException;

	/**
	 * 消毒包发放保存
	 * 
	 * @throws BizException
	 */
	public abstract DfpSendDO dfpSendSave(DfpAppDO[] apps, FBoolean fg_send, String note_rejict) throws BizException;

	/**
	 * 请领单拒发
	 * @param id_dfp_apps
	 * @param note
	 * @throws BizException
	 */
	public abstract void dfpSendRefuseBp(String[] id_dfp_apps, String note) throws BizException;

	/**
	 * 消毒包发放删除
	 * @param source
	 * @throws BizException
	 */
	public abstract void deleteDfpSend(String id_dfp_sned) throws BizException;

	/**
	 * 消毒包发送提交
	 * @param source
	 * @throws BizException
	 */
	public abstract void sendCommit(DfpSendSourceDTO source) throws BizException;

	/**
	 * 消毒包接收保存
	 * 
	 * @throws BizException
	 */
	public abstract void dfpReveiveSave(DfpRevDTO[] params) throws BizException;

	/**
	 * 消毒包使用保存
	 * 
	 * @throws BizException
	 */
	public abstract void dfpUseSave(String[] id_dfps, String id_pat) throws BizException;
}
