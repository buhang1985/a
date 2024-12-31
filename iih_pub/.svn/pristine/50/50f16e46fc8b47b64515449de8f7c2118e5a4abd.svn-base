package iih.ci.mi.ord.i;

import java.util.List;

import iih.ci.mi.ord.i.meta.OrdIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillParamDTO;
import iih.ci.mi.ord.i.meta.OrdSpecillRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

public interface ICiMiOrdRService {

	/**
	 * 获取复用医保计划</br>
	 * 解决异地医保，没有对照问题，使用复用医保计划替换患者就诊医保，根据复用医保获取医保目录参照查询等（存在问题是临床的医保计划于患者解决的医保计划不一致）
	 * @param id_hp 患者当前就诊医保计划id
	 * @return
	 * @throws BizException 
	 */
	public String getParentIdHp(String id_hp) throws BizException;
	
	/**
	 * 是否启用医保共享校验
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public boolean isEnabledMedicalShareVerify(CiEnContextDTO ctx) throws BizException ;
	
	/**
	 * 是否启用医保适应症校验
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public boolean isEnabledIndicVerify(CiEnContextDTO ctx) throws BizException;

	/**
	 * 获取医保开单规则校验
	 * @param ctx
	 * @param orderAggList
	 * @return
	 * @throws BizException
	 */
	public List<OrdRuleRstDTO> checkWholeRule(CiEnContextDTO ctx , List<OrdRuleParamDTO> orderList) throws BizException;
	
	/**
	 * 医保适应症校验
	 * @param ctx
	 * @param orderAggList
	 * @return
	 * @throws BizException
	 */
	public List<OrdIndicRstDTO> checkIndicationRule(CiEnContextDTO ctx , List<OrdIndicParamDTO> orderList) throws BizException;
	
	/**
	 * 特殊病药品判断接口</br>
	 * @param ctx 
	 * @param orderParam
	 * @return
	 * @throws BizException
	 */
	public List<OrdSpecillRstDTO> getPatSpecillVerify(CiEnContextDTO ctx, List<OrdSpecillParamDTO> orderParamList) throws BizException;

}
