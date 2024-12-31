package iih.bd.mhi.hptreatdircomp.i;

import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import xap.mw.core.data.BizException;

/**
 * 医保产品_诊疗对照数据维护扩展服务
 * 
 * @author dj.zhang
 *
 */
public interface IHptreatdircompExtCudService {

	/**
	 * @Title: saveHpTreatComp
	 * @Description:保存诊疗项目对照
	 * @param hpId
	 * @param treatDirCompDTOs
	 * @throws BizException
	 */
	public abstract HpTreatDirCompDTO[] saveHpTreatComp(String hpId, HpTreatDirCompDTO[] treatDirCompDTOs)
			throws BizException;

	/**
	 * @Title: autoHpTreatComp
	 * @Description: 自动对照
	 * @param hpId
	 * @throws BizException
	 */
	public void autoHpTreatComp(String hpId) throws BizException;

	/**
	 * @Title: delHpTreatComp
	 * @Description: 删除对照
	 * @param hpId
	 * @param treatDirCompDtOs
	 * @throws BizException
	 */
	HpTreatDirCompDTO[] delHpTreatComp(String hpId, HpTreatDirCompDTO[] treatDirCompDtOs) throws BizException;
	
	/**
	 * @Title: onDownload
	 * @Description: 下载目录
	 * @throws BizException
	 */
	public void onDownload() throws BizException;
	
	/**
	 * @Title: onDownload
	 * @Description: 医保上报
	 * @throws BizException
	 */
	public void onMedireport() throws BizException;
	
	/**
	 * @Title: onDownload
	 * @Description: 同步审批
	 * @throws BizException
	 */
	public void onSyncMediapproval() throws BizException;
	
	/**
	 * @Title: onDownload
	 * @Description: 医保上报撤销
	 * @throws BizException
	 */
	public void onRevokeMedireport() throws BizException;
}
