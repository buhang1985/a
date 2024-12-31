package iih.ci.ord.i.cfg.rulecfg;

import java.util.List;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.cfg.rulecfg.meta.RuleCfgParamDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱规则维护接口
 * 
 * @author HUMS
 *
 */
public interface ICiRuleCfgMaintainService {

	/**
	 * 获取当前组织配置的规则集合
	 * 
	 * @return
	 * @throws BizException
	 */
	public List<CiRuleCfg> getRuleCfgs(RuleCfgParamDTO ruleCfgParam) throws BizException;

	/**
	 * 获取合单规则
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public CiRuleCfg getMergeRuleCfg() throws BizException;

	/**
	 * 获取当前组织分方规则集合
	 * 
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public List<CiRuleCfg> getSplitPresRuleCfgs(String code_entp) throws BizException;

	/**
	 * 获取医嘱开单规则校验集合
	 * 
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public List<CiRuleCfg> getExcessiveReasonCfgs(String code_entp) throws BizException;
}
