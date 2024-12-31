package iih.pi.reg.i;

import iih.pi.reg.dto.uniquemanage.d.PiPatDealRltDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatRegistRltDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueDeleteCondDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueQryCondDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueQryRltDTO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;

/**
 * 患者唯一性管理服务(客开服务)
 * (用于第三方平台患者唯一性管理)
 * @author ly 2019/02/14
 *
 */
public interface IPiPatUniqueManageService {

	/**
	 * 注册患者
	 * @param patAggDO 患者信息
	 * @return 第三方注册信息
	 * @throws BizException
	 * @author ly 2019/02/14
	 */
	public abstract PiPatRegistRltDTO registerPatient(PatiAggDO patAggDO) throws BizException;
	
	/**
	 * 更新患者
	 * (关键信息一致时，无需调用第三方更新接口)
	 * @param newAggDO 新患者数据
	 * @param oldAggDO 就患者数据
	 * @return 处理结果
	 * @throws BizException
	 * @author ly 2019/02/14
	 */
	public abstract PiPatDealRltDTO updatePatient(PatiAggDO newAggDO, PatiAggDO oldAggDO) throws BizException;
	
	/**
	 * 删除患者
	 * @param condDto 删除条件
	 * @return 处理结果
	 * @throws BizException
	 * @author ly 2019/02/14
	 */
	public abstract PiPatDealRltDTO deletePatient(PiPatUniqueDeleteCondDTO condDto) throws BizException;

	/**
	 * 查询患者
	 * @param cond 查询条件
	 * @return 第三方平台患者信息
	 * @throws BizException
	 * @author ly 2019/02/14
	 */
	public abstract PiPatUniqueQryRltDTO queryPatient(PiPatUniqueQryCondDTO condDto) throws BizException;
}
