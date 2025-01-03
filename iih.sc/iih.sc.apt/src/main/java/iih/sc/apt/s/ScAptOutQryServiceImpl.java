package iih.sc.apt.s;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.AptQryDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.s.bp.GetApptedResListBP;
import iih.sc.apt.s.bp.GetAptIpByEntIdBP;
import iih.sc.apt.s.bp.GetCanApptResListBP;
import iih.sc.apt.s.bp.GetOpAptChlListBP;
import iih.sc.apt.s.bp.GetOpAptedListBP;
import iih.sc.apt.s.bp.GetUntakenAptCountBP;
import iih.sc.apt.s.bp.mt.apt.GetAptSchTicks4WeChatBP;
import iih.sc.apt.s.bp.op.qry.GetAptExChlBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.AptOpEP;
import iih.sc.apt.s.rule.ScMtApt4RuleBP;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.comm.ScSqlUtils;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 预约对外查询服务(暂停添加新内容)
 *
 * @author yank
 *
 */
@Service(serviceInterfaces = { IScAptOutQryService.class }, binding = Binding.JSONRPC)
public class ScAptOutQryServiceImpl implements IScAptOutQryService {
	/**
	 * 获取可预约资源
	 *
	 * @param qryScheme 查询模板
	 * @return 可预约资源信息集合
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public RegResDTO[] getCanApptResList(AptQryDTO qryScheme) throws BizException {
		GetCanApptResListBP getBP = new GetCanApptResListBP();
		return getBP.exec(qryScheme);
	}

	/**
	 * 获取已预约资源 默认加载标准价格，如果已经结算，加载的是结算价格
	 *
	 * @param patId 患者id
	 * @param dt_begin 起始日期
	 * @return 预约资源信息集合
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public RegResDTO[] getApptedResList(String patId, FDate dt_begin) throws BizException {
		GetApptedResListBP getBP = new GetApptedResListBP();
		return getBP.exec(patId, dt_begin);
	}

	/**
	 * 获取已预约信息 默认加载标准价格，如果已经结算，加载的是结算价格
	 *
	 * @param patId 患者id
	 * @param dt_begin 起始日期
	 * @return 预约资源信息集合
	 * @throws BizException
	 */
	@Override
	public OpAptDTO[] getOpAptList(String patId, FDate dt_begin,String dt_e) throws BizException {
		GetOpAptedListBP getBP = new GetOpAptedListBP();
		return getBP.exec(patId, dt_begin,dt_e);
	}
	/**
	 * 获取已预约信息 默认加载标准价格，如果已经结算，加载的是结算价格
	 *
	 * @param aptId 预约id
	 * @return 预约资源信息
	 * @throws BizException
	 */
	@Override
	public OpAptDTO getOpApt(String aptId) throws BizException {
		GetOpAptedListBP bp = new GetOpAptedListBP();
		return bp.exec(aptId);
	}
	/**
	 * 获取未取号的预约总数
	 *
	 * @param scTp 排班类型
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer getUntakenAptCount(String scTp, String patId) throws BizException {
		GetUntakenAptCountBP getBP = new GetUntakenAptCountBP();
		return getBP.exec(scTp, patId);
	}

	/**
	 * 查询住院预约申请单
	 *
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	@Override
	public AptIpDTO getAptIpByEntId(String entId) throws BizException {
		GetAptIpByEntIdBP getBP = new GetAptIpByEntIdBP();
		return getBP.exec(entId);
	}



	/**
	 * 获取门诊预约
	 *
	 * @param entId 就诊ID
	 * @return 门诊预约DO
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public ScAptOpDO getAptOpByEntId(String entId) throws BizException {
		AptOpEP aptOpEP = new AptOpEP();
		return aptOpEP.getAptOpByEntId(entId);
	}

	/**
	 * 获取预约渠道信息
	 *
	 * @param entIds 就诊ID集合
	 * @return 预约信息集合
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public OpAptDTO[] getOpAptChlList(String[] entIds) throws BizException {
		GetOpAptChlListBP getAptChlBP = new GetOpAptChlListBP();
		return getAptChlBP.exec(entIds);
	}

	/**
	 * 获取本次就诊外部渠道预约信息
	 *
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptExChlDO[] getAptExChl(String entId) throws BizException {
		GetAptExChlBP getExChlBp = new GetAptExChlBP();
		return getExChlBp.exec(entId);
	}

	/**
	 * 根据预约ID获取预约DO
	 *
	 * @author zhengcm
	 * @date 2017-11-20 09:51:49
	 *
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScAptDO getAptById(String id_apt) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_apt)) {
			return null;
		}
		return new AptEP().getById(id_apt);
	}

	/**
	 * 根据预约ID批量获取预约DO
	 *
	 * @author zhengcm
	 * @date 2017-11-20 08:36:23
	 *
	 * @param aptIds
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScAptDO[] getAptByIds(List<String> aptIds) throws BizException {
		if (ListUtil.isEmpty(aptIds)) {
			return null;
		}
		ScAptDO[] aptDOs = new AptEP().getByWhere(ScSqlUtils.getInSqlByIds("id_apt", aptIds));
		return aptDOs;
	}

	/**
	 * 根据申请单判断患者是否能自助预约或自助取消预约
	 * @param id_aptappl
	 * @param rule_type
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isSelfAptOrCanc(String id_aptappl, String id_apt, String rule_type, String chlType)
			throws BizException {
		ScMtApt4RuleBP bp = new ScMtApt4RuleBP();
		return bp.exec(id_aptappl,id_apt, rule_type,chlType);
	}
	/**
	 * 获取选号预约时可用号位或号段
	 * @param id_sch 排班id
	 * @param id_srv 申请单服务id
	 * @param id_scchl 渠道id
	 * @param id_enttp 就诊类型id
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param d_sch 排班日期
	 * @param fg_hp 医保支付标识
	 * @return
	 * @throws BizException
	 * @author yzh
	 */
	@Override
	public FArrayList getMtAptSchTicks8FilterForWeChat(String id_sch, String id_srv, String id_scchl,String id_enttp,String id_pat,String id_ent,FDate d_sch,FBoolean fg_hp) throws BizException {
		return new GetAptSchTicks4WeChatBP().exec(id_sch, id_scchl, id_srv, id_enttp,IScDictCodeConst.SD_SCTP_MT,id_pat,id_ent, d_sch,fg_hp);
	}
}
