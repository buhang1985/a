package iih.sc.apt.i;

import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.AptQryDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 预约对外查询服务
 *
 * @author yank
 *
 */
public interface IScAptOutQryService {
	/**
	 * 获取可预约资源
	 *
	 * @param qryScheme 查询模板
	 * @return 可预约资源信息集合
	 * @throws BizException
	 * @author yank
	 */
	RegResDTO[] getCanApptResList(AptQryDTO qryScheme) throws BizException;


	/**
	 * 获取已预约资源 默认加载标准价格，如果已经结算，加载的是结算价格
	 *
	 * @param patId 患者id
	 * @param dt_begin 起始日期
	 * @return 预约资源信息集合
	 * @throws BizException
	 * @author yank
	 */
	RegResDTO[] getApptedResList(String patId, FDate dt_begin) throws BizException;

	/**
	 * 获取已预约信息 默认加载标准价格，如果已经结算，加载的是结算价格
	 *
	 * @param patId 患者id
	 * @param dt_begin 起始日期
	 * @return 预约资源信息集合
	 * @throws BizException
	 */
	OpAptDTO[] getOpAptList(String patId, FDate dt_begin,String dt_e) throws BizException;
	/**
	 * 获取已预约信息 默认加载标准价格，如果已经结算，加载的是结算价格
	 *
	 * @param aptId 预约id
	 * @return 预约资源信息
	 * @throws BizException
	 */
	OpAptDTO getOpApt(String aptId) throws BizException;

	/**
	 * 获取未取号的预约总数
	 *
	 * @param scTp 排班类型
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	Integer getUntakenAptCount(String scTp, String patId) throws BizException;

	/**
	 * 查询住院预约申请单
	 *
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	AptIpDTO getAptIpByEntId(String entId) throws BizException;

	/**
	 * 获取门诊预约
	 *
	 * @param entId 就诊ID
	 * @return 门诊预约DO
	 * @throws BizException
	 * @author yank
	 */
	ScAptOpDO getAptOpByEntId(String entId) throws BizException;

	/**
	 * 获取预约渠道信息
	 *
	 * @param entIds 就诊ID集合
	 * @return 预约信息集合
	 * @throws BizException
	 * @author yank
	 */
	OpAptDTO[] getOpAptChlList(String[] entIds) throws BizException;

	/**
	 * 获取本次就诊外部渠道预约信息
	 *
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	AptExChlDO[] getAptExChl(String entId) throws BizException;

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
	ScAptDO getAptById(String id_apt) throws BizException;

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
	ScAptDO[] getAptByIds(List<String> aptIds) throws BizException;

	/**
	 * 根据申请单判断患者是否能微信自助预约或自助取消预约
	 * @param id_aptappl
	 * @param rule_type
	 * @return
	 * @throws BizException
	 */
	FBoolean isSelfAptOrCanc(String id_aptappl,String id_apt,String rule_type,String chlType) throws BizException;

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
	 * @return 号位信息
	 * @throws BizException
	 * @author yzh
	 */
	FArrayList getMtAptSchTicks8FilterForWeChat(String id_sch, String id_srv, String id_scchl,String id_enttp,String id_pat,String id_ent,FDate d_sch,FBoolean fg_hp) throws BizException;

}
