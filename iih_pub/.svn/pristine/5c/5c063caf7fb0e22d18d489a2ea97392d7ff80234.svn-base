package iih.mkr.ms.mkrms.i;

import iih.mkr.ms.mkrms.d.MkrMsDO;
import iih.mkr.ms.mkrms.d.MkrMsDiDO;
import iih.mkr.ms.mkrms.d.MkrMsMrtplDO;
import iih.mkr.ms.mkrms.d.MkrMsOrtpl;
import iih.mkr.ms.mkrms.d.MkrMsSrvDO;
import iih.mkr.ms.mkrms.d.MkrmsAggDO;
import iih.mkr.ms.mscacust.d.MkrMscaCtmDO;
import xap.mw.core.data.BizException;

public interface IMkrmsService {
	
	/**
	 * 启用
	 * @param mkrMsDOList
	 * @return
	 * @throws BizException
	 */
	public MkrMsDO[] Enable(MkrMsDO[] mkrMsDOList) throws BizException;
	
	/**
	 * 停用
	 * @param mkrMsDOList
	 * @return
	 * @throws BizException
	 */
	public MkrMsDO[] Disable(MkrMsDO[] mkrMsDOList) throws BizException;
	
	/**
	 * 获取医疗服务信息
	 * @param mkrMsSrvDO
	 * @return
	 * @throws BizException
	 */
	public MkrMsSrvDO GetSrvInfo(MkrMsSrvDO mkrMsSrvDO) throws BizException;
	
	/**
	 * 获取医疗记录模板信息
	 * @param mkrMsMrtplDO
	 * @return
	 * @throws BizException
	 */
	public abstract MkrMsMrtplDO getMrtplInfo(MkrMsMrtplDO mkrMsMrtplDO) throws BizException;
	
	/**
	 * 获取医嘱模板信息
	 * @param mkrMsOrtpl
	 * @return
	 * @throws BizException
	 */
	public abstract MkrMsOrtpl getOrTplcaInfo(MkrMsOrtpl mkrMsOrtpl) throws BizException;
	
	/**
	 *  获取医嘱模板信息
	 * @param mkrMsDiDO
	 * @return
	 * @throws BizException
	 */
	public abstract MkrMsDiDO getCdsysInfo(MkrMsDiDO mkrMsDiDO) throws BizException;
	
	/**
	 * 删除分类以及关联组套
	 * @param mscaCtmDO
	 * @throws BizException
	 */
	public abstract void delete (MkrMscaCtmDO mscaCtmDO) throws BizException;
	
	/**
	 * 粘贴组套（到分类）
	 * @param mkrMsDO
	 * @param mkrMscaCtmDO
	 * @param operType
	 * @throws BizException 
	 */
	public abstract MkrmsAggDO paste(MkrMsDO mkrMsDO, MkrMscaCtmDO mkrMscaCtmDO, int operType) throws BizException;
	
	/**
	 * 保存组套
	 * @param mkrmsAggDO
	 * @param mkrMscaCtmDO
	 * @throws BizException
	 */
	public abstract void saveMkrmsAggDO(MkrmsAggDO mkrmsAggDO,MkrMscaCtmDO mkrMscaCtmDO) throws BizException;
}
