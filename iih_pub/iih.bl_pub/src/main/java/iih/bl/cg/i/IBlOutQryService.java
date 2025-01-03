package iih.bl.cg.i;

import java.util.List;

import iih.bd.pp.pripm.d.PriPmDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryCondDTO;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryDTO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCgInfoDTO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCondDTO;
import iih.bl.cg.dto.d.BLCgIpOutQryDTO;
import iih.bl.cg.dto.d.BLCgIpOutInfoDTO;
import iih.bl.cg.dto.d.ChargeItmDTO;
import iih.bl.cg.dto.d.OpRegStDTO;
import iih.bl.cg.dto.ipcg4en.d.BlCgIp4EnDTO;
import iih.bl.cg.dto.oepcg4en.d.BlCgOep4EnDTO;
import iih.bl.cg.dto.oepcg4en.d.BlCgUnpay4EnDTO;
import iih.bl.hp.viewmziihypshare.d.ViewMzIihYpShareDTO;
import iih.bl.st.dto.d.BlIpOutPatPriQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 记账对外查询服务接口
 * 
 * @author yankan
 * @since 2017-06-19
 *
 */
public interface IBlOutQryService {
	/**
	 * 判断是否可以使用预交金 
	 * (北京市医保不支持预交金，高端商保记账不支持预交金)
	 * 
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @param bizType 业务场景类型，暂为空，（后续可参考：iih.bl.pay.prepay.d.EuPrepayBizType）
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	public abstract FBoolean canUsePrepay(String patId, String entId, String bizType) throws BizException;
	/**
	 * 获取收费项目集合	
	 * @param entpCode 就诊类型编码
	 * @param orIds 医嘱ID集合
	 * @return 收费项目DTO集合
	 * @throws BizException
	 * @author
	 */
	public abstract ChargeItmDTO[] getChargeItmList(String entpCode,String[] orIds) throws BizException;
	
	/**
	 * 判定记账是否已经结算 记账明细只要有结算，就判定改记账存在结算数据
	 * 
	 * @param cgId
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan,lpy
	 */
	public abstract FBoolean hasSettled(String cgId) throws BizException;
	
	/**
	 * 返回第三方支付方式解析接口
	 * 
	 * @param outCode
	 *            本地类型
	 * @return
	 * @throws BizException
	 */
	public abstract PriPmDO getPayCodeToOut(String outCode) throws BizException;

	/**
	 * 批量获取门诊挂号結算信息
	 * @param cgIds 记账id集合
	 * @return DTO集合
	 * @throws BizException
	 * @author yankan
	 * @author yanglu
	 */
	public abstract OpRegStDTO[] batchGetOpRegStInfo(String[] cgIds) throws BizException;
	/**
	 * 第三方支付方式解析接口
	 * 
	 * @param inCode
	 *            输入类型
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract PriPmDO getPayCodeToIn(String inCode) throws BizException;
	/**
	 * 过滤返回有效的共享数据
	 * 
	 * @param dtos
	 *            提供的共享数据
	 * @return
	 * @throws BizException
	 */
	public abstract ViewMzIihYpShareDTO[] getChisEffeData(ViewMzIihYpShareDTO[] dtos) throws BizException;
	/**
	 * 过滤返回有效的开单校验数据
	 * 
	 * @param list 校验数据集合
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 getRuleEffeData(FArrayList2 list) throws BizException;
	/**
	 * 过滤返回有效的门诊收费集合
	 * 
	 * @param presdtos
	 *            校验数据集合
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList getImputEffeData(FArrayList presdtos) throws BizException;
	/**
	 * 获取医保收款XML信息
	 * @param dtos 记账明细集合
	 * @param code 交易流水号
	 * @param operatorCode 操作人编码（人员编码）
	 * @param entpCode 医保就诊类型 11门诊，19急诊，17门诊挂号，18急诊挂号
	 * @param personType 医保患者类型
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract String GetOrderInsurXml(List<BlCgItmOepDO> dtos, String code, String operatorCode, String entpCode, String personType) throws BizException;

	
	/**
	 * 出院患者的后台划价费用核查接口--展示患者的否已经自动做最后一次划价
	 * @param entMap 出院患者就诊信息  包含两个参数  id_ent 就诊ID 和outDate 预出院时间
	 * @param bErrExist 是否有未划价信息就返回
	 * @return
	 * @throws BizException
	 */
	public abstract  FMap getPatPriceByLast(BlIpOutPatPriQryDTO[] blIpOutPatPriQryDTO,FBoolean bErrExist)throws BizException;
	
	/**
	 * 住院补费项目查询
	 * @param cond 查询条件
	 * @return
	 * @throws BizException
	 * @author ly 2018/05/11
	 */
	public abstract BlCgAddFeeQryDTO[] qryIpAddFee(BlCgAddFeeQryCondDTO cond)throws BizException;

	/**
	 * 根据就诊主键查询门诊记账数据
	 * @param entId 就诊id
	 * @return 记账数据
	 * @throws BizException
	 * @author ly 2018/10/30
	 */
	public abstract BlCgOep4EnDTO[] getOepCgDataByEntId(String entId) throws BizException;

	/**
	 * 根据就诊主键查询住院记账数据
	 * @param entId 就诊id
	 * @return 记账数据
	 * @throws BizException
	 * @author ly 2019/01/15 
	 */
	public abstract BlCgIp4EnDTO[] getIpCgDataByEntId(String entId) throws BizException;

	/**
	 * 查询患者门诊待交费数据
	 * (就诊域使用)
	 * @param patId 患者id
	 * @param days 查询天数
	 * @return 待交费数据
	 * @throws BizException
	 * @author ly 2019/02/26
	 */
	public abstract BlCgUnpay4EnDTO[] getOepUnpayDetail(String patId, Integer days) throws BizException;
	
	/**
	 * 查询住院记账汇总信息
	 * @param idEnt:就诊主键
	 * @param idStIp：结算主键
	 * @param idOrs:医嘱主键
	 * @return
	 * @throws BizException
	 */
	public abstract BLCgIpOutInfoDTO[] getCgIpTotalInfo(BLCgIpOutQryDTO qryDto) throws BizException;
	//public abstract String redcard()throws BizException;
	
	/**
	 * 获取持续医嘱记账信息
	 * @param condDtos 查询条件
	 * @return 持续医嘱记账信息
	 * @throws BizException
	 * @author ly 2020/03/12
	 */
	public abstract BlCgAlwaysOrCgInfoDTO[] getAlwaysOrCgInfo(BlCgAlwaysOrCondDTO[] condDtos) throws BizException;
}
	
