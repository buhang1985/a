package iih.bl.hp.Service.s;

import java.util.Map;

import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.bl.hp.bdhpindicationdto.service.i.IHpQueService;
import iih.bl.hp.blhppatspec.d.BlhppatspecAggDO;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.hpque.bp.BdHpDiJudgeBp;
import iih.bl.hp.hpque.bp.CheckPiPatBbrBlackBp;
import iih.bl.hp.hpque.bp.GetBlhppatspecAggDOBp;
import iih.bl.hp.hpque.bp.GetHpIndicationBp;
import iih.bl.hp.hpque.bp.GetSystemNoControlHpIndicationBp;
import iih.bl.hp.rule.HpRuleExecuter;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 关于医保的判断接口
 * 
 * @author tcy
 *
 */
@Service(serviceInterfaces = { IHpQueService.class }, binding = Binding.JSONRPC)
public class IHpQueServiceImpl implements IHpQueService {

	/**
	 * 根据患者的ID_PAT，获得该患者的特殊病诊断信息
	 * 	
	 * @param id_pat
	 *            患者的ID_PAT
	 * @return 医保特殊病患者
	 * @throws BizException
	 * @author tcy
	 */
	public BlhppatspecAggDO[] getBlhppatspecAggDOFromIdpat(String id_pat) throws BizException {
		GetBlhppatspecAggDOBp bp = new GetBlhppatspecAggDOBp();
		return bp.exec(id_pat);
	}

	/**
	 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口， 如单方、领量、持有量等
	 * 
	 * @param ciHpCheckDTO
	 *            开单需要进行校验的相关信息
	 * @return CiHpCheckResultDTO 开单结果。 首先，获得CiHpCheckResultDTO.CheckFlag，
	 *         如果为TRUE,则校验通过，可以保存； 如果为FALSE，则校验失败，
	 *         失败，通过CiHpCheckResultDTO.FailIdorsrvMap获得失败的原因<失败的id_srv,失败原因描述>
	 * @throws BizException
	 */
	public CiHpCheckResultDTO checkCiHpSave(CiHpCheckDTO ciHpCheckDTO) throws BizException {
		HpRuleExecuter ruleExecuter = new HpRuleExecuter();
		return ruleExecuter.exec(ciHpCheckDTO);
	}

	/**
	 * 用于判断患者是否在医保黑名单中
	 * 
	 * @param id_pat
	 *            患者ID
	 * @return FBoolean.TRUE：在医保黑名单中； FBoolean.FALSE：不在医保黑名单中；
	 * @throws BizException
	 */
	public FBoolean checkPiPatBbr_Black(String id_pat) throws BizException {
		CheckPiPatBbrBlackBp bp = new CheckPiPatBbrBlackBp();
		return bp.exec(id_pat);
	}

	/**
	 * 供医生站缓存使用 查询医保计划下的所有不控制判断方式的服务，查询条件: select * from bd_hp_srvorca where
	 * id_hp=? and (eu_hpsrvctrtp='01' or sd_hpsrvtp='2')
	 * 
	 * @param id_hp
	 *            医保计划
	 * @return 组织成BdHpIndicationDTO，
	 *         只填写：Id_srv，Fg_indic，Des_hplimit，Sd_hpsrvtp，Id_hpsrvtp
	 *         ，Code_hpindicjudged
	 * @throws BizException
	 */
	public BdHpIndicationDTO[] getSystemNoControlHpIndication(String id_hp) throws BizException {
		GetSystemNoControlHpIndicationBp bp = new GetSystemNoControlHpIndicationBp();
		return bp.exec(id_hp);
	}

	/**
	 * 根据id_pat，就诊的主医保计划，医嘱项目，返回含医保适应症提示的医疗服务数组
	 * 
	 * @param bdHpIndicationDTOArr
	 *            (患者主键,主医保计划,医疗服务数组)
	 * @return 含医保适应症提示的医疗服务数组
	 *         （患者主键,主医保计划,医疗服务相关数据，医保目录类型sd_hpsrvtp,id_hpsrvtp，判断方式
	 *         ，系统判断结果fg_indic，医保限制条件des_hplimit）
	 * @throws BizException
	 */
	@Override
	public BdHpIndicationDTO[] getHpIndication(BdHpIndicationDTO[] bdHpIndicationDTOArr) throws BizException {
		GetHpIndicationBp bp = new GetHpIndicationBp();
		return bp.exec(bdHpIndicationDTOArr);
	}

	/**
	 * 用于判断医保诊断是否在保内诊断列表中。 该接口提供给医生站使用，医生站在下诊断时，应当通过该接口判断是否保外诊断，
	 * 如果是保外诊断，则禁止医生开保内处方和医嘱。
	 * 
	 * @param id_hp
	 *            医保计划
	 * @param id_diArr
	 *            诊断ID数组
	 * @param id_entp
	 *            就诊类型ID
	 * @return Map<String,FBoolean>
	 *         <id_di,保内(Fboolean.true)还是保外(Fboolean.false)>
	 * @throws BizException
	 */
	public Map<String, FBoolean> BdHpDiJudge(String id_hp, String[] id_diArr, String id_entp) throws BizException {

		BdHpDiJudgeBp bp = new BdHpDiJudgeBp();

		return bp.exec(id_hp, id_diArr, id_entp);
	}
}
