package iih.ci.mi.external.obtain.mi;

import java.util.List;

import iih.ci.mi.diag.i.meta.CiMiDiagDTO;
import iih.ci.mi.ord.i.meta.OrdIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvSpecillRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

/**
 * 临床医保接口
 * 对应iih.mi模块
 * @author HUMS
 *
 */
public interface ICiMiMcRService {

	/**
	 * 医保开单规则校验 
	 * @param ctx
	 * @param orderList
	 * @return
	 * @throws BizException
	 */
	public List<OrdRuleRstDTO> checkWholeRule(CiEnContextDTO ctx , List<OrdRuleParamDTO> orderList) throws BizException;
	
	/**
	 * 医保适应症校验
	 * @param ctx
	 * @param orderList
	 * @return
	 * @throws BizException
	 */
	public List<OrdIndicRstDTO> checkIndicationRule(CiEnContextDTO ctx , List<OrdIndicParamDTO> orderList) throws BizException;
	
	/**
	 * 校验药品是否为患者特殊病药品
	 * @param ctx
	 * @param orderParam
	 * @return
	 * @throws BizException
	 */
	public List<OrdSrvSpecillRstDTO> checkPatSpecillDrug(CiEnContextDTO ctx, List<CiMiDiagDTO> diagList,
			List<OrdSrvSpecillParamDTO> ordSrvParamList) throws BizException;
}
