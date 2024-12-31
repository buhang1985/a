package iih.bl.cg.s;

import java.util.List;

import iih.bd.pp.pripm.d.PriPmDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.bp.CheckCgHasSettledBP;
import iih.bl.cg.bp.oep.BatchGetOpRegStInfoBP;
import iih.bl.cg.bp.self.GetOrderXmlBp;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryCondDTO;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeQryDTO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCgInfoDTO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCondDTO;
import iih.bl.cg.dto.d.BLCgIpOutInfoDTO;
import iih.bl.cg.dto.d.BLCgIpOutQryDTO;
import iih.bl.cg.dto.d.ChargeItmDTO;
import iih.bl.cg.dto.d.OpRegStDTO;
import iih.bl.cg.dto.ipcg4en.d.BlCgIp4EnDTO;
import iih.bl.cg.dto.oepcg4en.d.BlCgOep4EnDTO;
import iih.bl.cg.dto.oepcg4en.d.BlCgUnpay4EnDTO;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.cg.s.bp.CanUsePrepayBP;
import iih.bl.cg.s.bp.GetChargeItmListBP;
import iih.bl.cg.s.bp.GetEffeOrderBP;
import iih.bl.cg.s.bp.GetPatPriceByLastBP;
import iih.bl.cg.s.bp.GetPayCodeBP;
import iih.bl.cg.s.bp.ip.BlIpGetAddFeeBP;
import iih.bl.cg.s.bp.ip.GetAlwaysOrCgInfoBP;
import iih.bl.cg.s.bp.ip.GetCgIpAmtRatioBP;
import iih.bl.cg.s.bp.ip.GetIpCgDataByEntIdBP;
import iih.bl.cg.s.bp.op.GetOepCgDataByEntIdBP;
import iih.bl.cg.s.bp.op.GetOepUnpayDetailBP;
import iih.bl.hp.viewmziihypshare.d.ViewMzIihYpShareDTO;
import iih.bl.st.dto.d.BlIpOutPatPriQryDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用对外查询服务
 * 
 * @author yankan
 * @since 2017-06-19
 *
 */
@Service(serviceInterfaces = { IBlOutQryService.class }, binding = Binding.JSONRPC)
public class BlOutQryServiceImpl implements IBlOutQryService {
	/**
	 * 判断是否可以使用预交金
	 * 
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @param bizType 业务场景类型
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public FBoolean canUsePrepay(String patId,String entId,String bizType) throws BizException{
		CanUsePrepayBP checkBP = new CanUsePrepayBP();
		return checkBP.exec(patId, entId, bizType);
	}
	/**
	 * 获取收费项目集合
	 * @param entpCode 就诊类型编码
	 * @param orIds 医嘱ID集合	 
	 * @return 收费项目DTO集合
	 * @throws BizException
	 * @author
	 */
	@Override
	public ChargeItmDTO[] getChargeItmList(String entpCode,String[] orIds) throws BizException{
		GetChargeItmListBP getItmListBP = new GetChargeItmListBP();
		return getItmListBP.exec(entpCode,orIds);
	}
	
	/**
	 * 判定记账是否已经结算 记账明细只要有结算，就判定改记账存在结算数据
	 * 
	 * @param cgId
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan,lpy
	 */
	@Override
	public FBoolean hasSettled(String cgId) throws BizException {
		CheckCgHasSettledBP checkBP = new CheckCgHasSettledBP();
		return checkBP.exec(cgId);
	}
	
	/**
	 * 返回第三方支付方式解析接口
	 * 
	 * @param outCode
	 *            本地类型
	 * @return
	 * @throws BizException
	 */
	public PriPmDO getPayCodeToOut(String outCode) throws BizException {
		GetPayCodeBP bp = new GetPayCodeBP();
		return bp.exec(outCode, false);
	}
	
	/**
	 * 批量获取门诊挂号結算信息
	 * 
	 * @param cgIds
	 *            记账id集合
	 * @return DTO集合
	 * @throws BizException
	 * @author yankan
	 * @author yanglu
	 */
	@Override
	public OpRegStDTO[] batchGetOpRegStInfo(String[] cgIds) throws BizException {
		BatchGetOpRegStInfoBP batchGetOpStBP = new BatchGetOpRegStInfoBP();
		return batchGetOpStBP.exec(cgIds);
	}
	
	/**
	 * 第三方支付方式解析接口
	 * 
	 * @param inCode 输入类型
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	public PriPmDO getPayCodeToIn(String inCode) throws BizException {
		GetPayCodeBP bp = new GetPayCodeBP();
		return bp.exec(inCode, true);
	}
	/**
	 * 过滤返回有效的共享数据
	 * 
	 * @param dtos 提供的共享数据
	 * @return
	 * @throws BizException
	 */
	@Override
	public ViewMzIihYpShareDTO[] getChisEffeData(ViewMzIihYpShareDTO[] dtos) throws BizException {
		GetEffeOrderBP bp = new GetEffeOrderBP();
		return bp.getChisEffeData(dtos);
	}
	/**
	 * 过滤返回有效的开单校验数据
	 * 
	 * @param list 校验数据集合
	 * @return
	 * @throws BizException
	 */
	@Override
	public FArrayList2 getRuleEffeData(FArrayList2 list) throws BizException {
		GetEffeOrderBP bp = new GetEffeOrderBP();
		return bp.getRuleEffeData(list);
	}
	/**
	 * 过滤返回有效的门诊收费集合
	 * 
	 * @param presdtos
	 *            校验数据集合
	 * @return
	 * @throws BizException
	 */
	@Override
	public FArrayList getImputEffeData(FArrayList presdtos) throws BizException {
		GetEffeOrderBP bp = new GetEffeOrderBP();
		return bp.getImputEffeData(presdtos);
	}
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
	@Override
	public String GetOrderInsurXml(List<BlCgItmOepDO> dtos, String code, String operatorCode, String entpCode, String personType) throws BizException {
		GetOrderXmlBp bp = new GetOrderXmlBp();
		return bp.exec(dtos, code, operatorCode, entpCode, personType);
	}
	
	/**
	 * 出院患者的后台划价费用核查接口--展示患者的否已经自动做最后一次划价
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param outDate
	 *            预出院时间
	 */
	@Override
	public FMap getPatPriceByLast(BlIpOutPatPriQryDTO[] blIpOutPatPriQryDTO,FBoolean bErrExist) throws BizException {
		GetPatPriceByLastBP bp = new GetPatPriceByLastBP();
		return bp.exec(blIpOutPatPriQryDTO,bErrExist);
	}
	
	/**
	 * 住院补费项目查询
	 * @param cond 查询条件
	 * @return
	 * @throws BizException
	 * @author ly 2018/05/11
	 */
	@Override
	public BlCgAddFeeQryDTO[] qryIpAddFee(BlCgAddFeeQryCondDTO cond) throws BizException {
		BlIpGetAddFeeBP bp = new BlIpGetAddFeeBP();
		return bp.exec(cond);
	}
	
	/**
	 * 根据就诊主键查询门诊记账数据
	 * @param entId 就诊id
	 * @return 记账数据
	 * @throws BizException
	 * @author ly 2018/10/30
	 */
	@Override
	public BlCgOep4EnDTO[] getOepCgDataByEntId(String entId) throws BizException{
		GetOepCgDataByEntIdBP bp = new GetOepCgDataByEntIdBP();
		return bp.exec(entId);
	}
	
	/**
	 * 根据就诊主键查询住院记账数据
	 * @param entId 就诊id
	 * @return 记账数据
	 * @throws BizException
	 * @author ly 2019/01/15 
	 */
	@Override
	public BlCgIp4EnDTO[] getIpCgDataByEntId(String entId) throws BizException{
		GetIpCgDataByEntIdBP bp = new GetIpCgDataByEntIdBP();
		return bp.exec(entId);
	}
	
	/**
	 * 查询患者门诊待交费数据
	 * @param patId 患者id
	 * @param days 查询天数
	 * @return 待交费数据
	 * @throws BizException
	 * @author ly 2019/02/26
	 */
	@Override
	public BlCgUnpay4EnDTO[] getOepUnpayDetail(String patId, Integer days) throws BizException{
		GetOepUnpayDetailBP bp = new GetOepUnpayDetailBP();
		return bp.exec(patId, days);
	}
	
	/**
	 * 查询住院记账汇总信息
	 * @param idEnt:就诊主键
	 * @param idStIp：结算主键
	 * @param idOrs:医嘱主键
	 * @return
	 * @throws BizException
	 */
	@Override
	public BLCgIpOutInfoDTO[] getCgIpTotalInfo(BLCgIpOutQryDTO qryDto) throws BizException {
		GetCgIpAmtRatioBP bp = new GetCgIpAmtRatioBP();
		return bp.exec(qryDto);
	}
	
	/**
	 * 获取持续医嘱可退费记账信息
	 * @param condDtos 查询条件
	 * @return 持续医嘱记账信息
	 * @throws BizException
	 * @author ly 2020/03/12
	 */
	@Override
	public BlCgAlwaysOrCgInfoDTO[] getAlwaysOrCgInfo(BlCgAlwaysOrCondDTO[] condDtos) throws BizException{
		GetAlwaysOrCgInfoBP bp = new GetAlwaysOrCgInfoBP();
		return bp.exec(condDtos);
	}
}
