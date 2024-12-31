package iih.mp.mpbd.i;

import iih.mp.mpbd.dto.orpltpcfg.d.OrpltpCfgDTO;
import iih.mp.mpbd.dto.orpltpcfg.d.OrpltpCfgStaDTO;
import iih.mp.mpbd.exerepair.d.ExeRepairCondDTO;
import iih.mp.mpbd.patvstagt.d.PatvstagtAggDO;
import iih.mp.mpbd.prnca.d.MpOrPrnDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.mdm.dto.thirdmdm.d.MdmThirdDTO;
import xap.sys.tool.authorization.d.AuthorizationDO;

public interface IMpBdMaintenceService {

	/**
	 * 第三方主数据保存
	 * 
	 * @param params
	 * @throws BizException
	 */
	public abstract void saveThirdMdm(MdmThirdDTO[] params) throws BizException;

	/**
	 * 免密授权信息批量保存
	 * 
	 * @param paras
	 * @return
	 * @throws BizException
	 */
	public abstract String saveAuthorizationDO(AuthorizationDO[] paras) throws BizException;

	/**
	 * 执行数据修复
	 * 
	 * @param fg_prefix
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public abstract String saveExeFixData(FBoolean fg_prefix, ExeRepairCondDTO dto) throws BizException;

	/**
	 * 病区执行打印配置保存
	 * 
	 * @throws BizException
	 */
	public abstract void wardPrntSave(MpOrPrnDO[] prns) throws BizException;

	/**
	 * 病区执行打印配置 初始化
	 * 
	 * @throws BizException
	 */
	public abstract void wardPrntSetInit() throws BizException;

	/**
	 * 患者体征指标维护保存逻辑
	 * 
	 * @throws BizException
	 */
	public abstract void tagtSave(PatvstagtAggDO aggDO) throws BizException;

	/**
	 * 医嘱闭环设置保存
	 * @param orpltpCfgDTO
	 * @param orpltpCfgStaDTOS
	 * @throws BizException
	 */
	public void orpltpCfgSave(OrpltpCfgDTO orpltpCfgDTO, OrpltpCfgStaDTO[] orpltpCfgStaDTOS) throws BizException;

}
