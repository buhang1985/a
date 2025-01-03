package iih.bl.cg.s;

import java.util.List;
import java.util.Map;

import com.founder.ws.back.WsRefundService;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoeptf.bp.BlCgOepTfBp;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.bliptfin.bp.BlIpTfInBp;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.cg.bloepdelcostdto.d.BlOepDeLCostDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blredapply.d.BlRefundApplyDO;
import iih.bl.cg.d.BlIpFeeDTO;
import iih.bl.cg.d.BlIpFeeInfo;
import iih.bl.cg.dto.blcgdif.d.BlCgOpDifDTO;
import iih.bl.cg.dto.d.BlNurSubsidyErrorReturnDTO;
import iih.bl.cg.dto.d.BlOrderRefundListDTO;
import iih.bl.cg.dto.d.BlPreIpParamDTO;
import iih.bl.cg.dto.d.BlRefundSrvItemDTO;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.cg.dto.oeptoip.d.BlCgOepToIpCondDTO;
import iih.bl.cg.extritf.d.RefundInfoDO;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.cg.s.bp.BlCgOepReturnSellBp;
import iih.bl.cg.s.bp.BlSavePrinterSetInfoNewBP;
import iih.bl.cg.s.bp.BlUpdateFgSelfpayBP;
import iih.bl.cg.s.bp.DoBlCgIpInfoMendBp;
import iih.bl.cg.s.bp.DoCompensationSubmitBp;
import iih.bl.cg.s.bp.DoRefundFeeSubmitBp;
import iih.bl.cg.s.bp.DoSaveOpAppendFeeBp;
import iih.bl.cg.s.bp.IpRepricingBP;
import iih.bl.cg.s.bp.OepRepricingBP;
import iih.bl.cg.s.bp.PreIpToOepBP;
import iih.bl.cg.s.bp.PreIpToOepBP2;
import iih.bl.cg.s.bp.SendChisProcBP;
import iih.bl.cg.s.bp.SendIIHRefundMsgBP;
import iih.bl.cg.s.bp.SendRefundMsgAllToFailBP;
import iih.bl.cg.s.bp.SendRefundMsgBP;
import iih.bl.cg.s.bp.SendRefundMsgByStIdBP;
import iih.bl.cg.s.bp.UpdateCgHpFlagBp;
import iih.bl.cg.s.bp.UpdateCgIpHpFlagBp;
import iih.bl.cg.s.bp.ip.BlIpSaveCompensationBP;
import iih.bl.cg.s.bp.ip.backcg.IpBackChargeBP;
import iih.bl.cg.s.bp.newrfd.BlCancelBillRefundApplyBP;
import iih.bl.cg.s.bp.newrfd.BlCancelDetailedRefundApplyBP;
import iih.bl.cg.s.bp.newrfd.BlSaveBillApplyAuditBP;
import iih.bl.cg.s.bp.newrfd.BlSaveDetailedApplyAuditBP;
import iih.bl.cg.s.bp.newrfd.BlSaveOrdReundDataBP;
import iih.bl.cg.s.bp.newrfd.BlSaveRefundApplyBP;
import iih.bl.cg.s.bp.op.BlCancelOepCgTransferToIpCgBP;
import iih.bl.cg.s.bp.op.BlCgUpdateOpDifBP;
import iih.bl.cg.s.bp.op.BlOepCgTransferToIpCgBP;
import iih.bl.cg.s.bp.op.OepCgTransferToIpCgRealBP;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.s.bp.BlIpFeeSubmitDataBp;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import xap.mw.core.annotation.Reference;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 记账命令服务
 * 
 * @author yankan
 *
 */
@Service(serviceInterfaces = { IBlCgCmdService.class }, binding = Binding.JSONRPC)
public class BlCgCmdServiceImpl implements IBlCgCmdService {
	// 公共webService
	// 修改调用地址需要在iih.integration模块中external-services\src\main\resources\com\founder\iih\Refund.xml
	@Reference(binding = Binding.WS)
	WsRefundService refundService;

	/**
	 * 调用第三方退费接口
	 * 
	 * @param RefundInfoDO
	 *            发送消息对象
	 * @return 执行状态
	 * @throws BizException
	 * @author yang.lu
	 */
	@Override
	public void sendRefundMsg(RefundInfoDO retfundInfo) throws BizException {
		SendRefundMsgBP bp = new SendRefundMsgBP();
		bp.exec(retfundInfo, refundService);
	}

	/**
	 * 退费是调用第三方接口
	 * 
	 * @param id_soep
	 *            退费结算编号
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	@Override
	public void sendRefundMsgByStId(String id_soep) throws BizException {
		SendRefundMsgByStIdBP bp = new SendRefundMsgByStIdBP();
		bp.exec(id_soep, refundService);
	}

	/**
	 * 收/退费，记账，取消记账 调用检查检验接口
	 * 
	 * @param cgIdList
	 *            记账编码集合
	 * @param directEu
	 *            方向
	 * @throws BizException
	 */
	@Override
	public void sendChisProc(List<String> cgIdList, int directEu) throws BizException {
		SendChisProcBP bp = new SendChisProcBP();
		bp.exec(cgIdList, directEu);
	}

	/**
	 * 将第三方接口失败数据重新发送
	 * 
	 * @throws BizException
	 * @author yang.lu
	 */
	@Override
	public void sendRefundMsgAllToFail() throws BizException {
		SendRefundMsgAllToFailBP bp = new SendRefundMsgAllToFailBP();
		bp.exec();
	}

	/**
	 * 调用IIH退费平台退费接口
	 * @param RefundInfoDO
	 *            发送消息对象
	 * @return 执行状态
	 * @throws BizException
	 * @author liming
	 */
	@Override
	public FBoolean sendIIHRefundMsg(BlOrdReqDTO blOrdReqDTO) throws BizException {
		SendIIHRefundMsgBP bp= new SendIIHRefundMsgBP();
		return bp.exec(blOrdReqDTO);
	}
	
	/**
	 * 对指定就诊进行门诊重划价 备注：只针对补费产生的数据（即仅在CG表中存在的数据）
	 * 
	 * @param id_pat
	 *            患者ID
	 * @param from
	 *            原价格分类
	 * @param to
	 *            新价格分类
	 * @param operatorInfo
	 *            操作员人员信息
	 * @return 划价成功，返回FBoolean.true,失败返回FBoolean.false
	 * @throws BizException
	 * @author liwq
	 */
	public FBoolean doOepRePricingCg(String id_pat, String id_ent, String from, String to, OperatorInfoDTO operatorInfo)
			throws BizException {
		OepRepricingBP bp = new OepRepricingBP();
		return bp.exec(id_pat, id_ent, from, to, operatorInfo);
	}

	/**
	 * 对指定就诊进行住院重划价
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param from
	 *            原价格分类id
	 * @param to
	 *            新价格分类id
	 * @param operatorInfo
	 *            操作员人员信息
	 * @return 划价成功，返回FBoolean.true,失败返回FBoolean.false
	 * @throws BizException
	 * @author liwq
	 */
	public FBoolean doIpRePricingCg(String id_pat, String id_ent, String from, String to, OperatorInfoDTO operatorInfo)
			throws BizException {
		IpRepricingBP bp = new IpRepricingBP();
		return bp.exec(id_pat, id_ent, from, to, operatorInfo);

	}

	/**
	 * 执行住院后台划价
	 * 
	 * @param patId
	 *            患者ID
	 * @param cgEndTime
	 *            记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public void execIpCgTask(String patId, FDateTime cgEndTime) throws BizException {
		IpBackChargeBP chargeBP = new IpBackChargeBP();
		chargeBP.exec(patId, cgEndTime, false);
	}

	/**
	 * 医保费用上传/撤销后，更新fg_hp='Y' 并更新amt_pat和amt_hp字段
	 * 
	 * @param idEnt
	 *            就诊id
	 * @param idStIp
	 *            结算id
	 * @param map
	 *            医保上传结果与对应的记账主键关系<idcgip,OutUploadPresDTO>
	 * @param isUploaded
	 *            fg_hp标志更改
	 * @param isBat
	 *            是否是批量上传
	 * @author liwq
	 */
	public FBoolean updateCgUploadedFlag(String idEnt, String idStIp, FMap2 map, FBoolean isUploaded, FBoolean isBat)
			throws BizException {
		UpdateCgHpFlagBp bp = new UpdateCgHpFlagBp();
		return bp.exec(idEnt, idStIp, map, isUploaded, isBat);
	}

	/**
	 * 医保更新记账数据
	 * 
	 * @param strIdEnt
	 *            就诊号
	 * @param map
	 * @param isBat
	 *            是否批量更新
	 * @return
	 */
	@Override
	public FBoolean updateHpCgIp(String strIdEnt, IpBillItmUploadHpDTO[] list, FBoolean isUploaded)
			throws BizException {
		UpdateCgIpHpFlagBp handlerBp = new UpdateCgIpHpFlagBp();
		return handlerBp.exec(strIdEnt, list, isUploaded);
	}

	/**
	 * 住院退补费-进行退费确认
	 * 
	 * @param dtoArr
	 * @author liwq
	 * @since 2018年3月31日6:04:03
	 * @return
	 * @throws BizException
	 */
	public FBoolean doRefundFeeSubmit(NurseCompFeeItmDTO[] dtoArr) throws BizException {
		DoRefundFeeSubmitBp bp = new DoRefundFeeSubmitBp();
		return bp.exec(dtoArr);
	}

	/**
	 * 住院退补费-进行补费确认
	 * 
	 * @param dtoArr
	 * @author liwq
	 * @since 2018年3月31日6:04:03
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlNurSubsidyErrorReturnDTO[] doCompensationSubmit(NurseCompFeeItmDTO[] dtoArr, String[] list_id_ent)
			throws BizException {
		DoCompensationSubmitBp bp = new DoCompensationSubmitBp();
		return bp.exec(dtoArr, list_id_ent);
	}

	/**
	 * 住院退/补费(改造dto)
	 * 
	 * @param id_ent
	 * @param blcgOrArr
	 * @return
	 * @author liwenqiang
	 * @throws BizException
	 * 
	 */
	@Override
	public BlIpFeeDTO[] doBlCgIpInfoMend(String id_ent, BlIpFeeDTO[] blcgOrArr) throws BizException {
		DoBlCgIpInfoMendBp bp = new DoBlCgIpInfoMendBp();
		return bp.exec(id_ent, blcgOrArr);
	}

	/**
	 * 门诊通用补费保存
	 * 
	 * @author liwq
	 */
	public BlOrderAppendBillParamDTO[] doSaveOpAppendFee(NurseCompFeeItmDTO[] dtoArr, String id_ent)
			throws BizException {
		DoSaveOpAppendFeeBp bp = new DoSaveOpAppendFeeBp();
		return bp.exec(dtoArr, id_ent);
	}

	/**
	 * 住院退补费-进行退费确认(可退全科室费用)
	 * 
	 * @param infos
	 * @author zhanghw
	 * @return
	 * @throws BizException
	 */
	public FBoolean submitRefundData(BlIpFeeInfo[] infos) throws BizException {
		BlIpFeeSubmitDataBp bp = new BlIpFeeSubmitDataBp();
		return bp.exec(infos);
	}

	/**
	 * 住院补退费保存
	 * 
	 * @param ipFeeDtos
	 * @date 2018年8月20日
	 * @author wq.li
	 */
	public void saveCompensation(BlIpFeeDTO[] ipFeeDtos) throws BizException {
		BlIpSaveCompensationBP bp = new BlIpSaveCompensationBP();
		bp.exec(ipFeeDtos);
	}

	/**
	 * 门诊销账
	 * 
	 * @param blstrebill
	 *            销账数据
	 * @param id_pat
	 *            患者id
	 * @return BlOepDeLCostDTO 销账数据源
	 * @author zhangxin06 2018-9-29
	 * @throws BizException
	 * 
	 */
	@Override
	public BlOepDeLCostDTO[] findSetSellData(BlOepDeLCostDTO[] blstrebill, String id_pat) throws BizException {
		BlCgOepReturnSellBp bp = new BlCgOepReturnSellBp();
		return bp.exec(blstrebill, id_pat);
	}
	
	/**
	 * 门诊费用转住院费用
	 * @param condDto 转移条件
	 * @throws BizException
	 * @author ly 2019/03/12
	 */
	@Override
	public void oepCgTransferToIpCg(BlCgOepToIpCondDTO condDto,FBoolean flag) throws BizException{
		BlOepCgTransferToIpCgBP bp = new BlOepCgTransferToIpCgBP();
		bp.exec(condDto,flag);
	}
	
	/**
	 * 门诊费用转住院费用(真实转入)
	 * @author zhang.hw
	 * @date 2020年3月11日
	 * @param id_ent
	 * @throws BizException
	 */
	@Override
	public BlCgIpDO[] oepCgTransferToIpCgReal(String id_ent) throws BizException {
		OepCgTransferToIpCgRealBP bp = new OepCgTransferToIpCgRealBP();
		return bp.exec(id_ent);
	};
	
	/**
	 * 撤销门诊转住院费用
	 * @param condDto 转移条件
	 * @throws BizException
	 * @author ly 2019/03/12
	 */
	@Override
	public void cancelOepCgTransferToIpCg(BlCgOepToIpCondDTO condDto) throws BizException{
		BlCancelOepCgTransferToIpCgBP bp = new BlCancelOepCgTransferToIpCgBP();
		bp.exec(condDto);
	}

	/**
	 * 修改住院费用自费状态-指定自费
	 * @author zhang.hw
	 * @date 2019年4月30日
	 * @param ipBillItmUploadHpDTOs
	 * @param flag
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean updateFgSelfpay(IpBillItmUploadHpDTO[] ipBillItmUploadHpDTOs) throws BizException {
		BlUpdateFgSelfpayBP bp = new BlUpdateFgSelfpayBP();
		return bp.exec(ipBillItmUploadHpDTOs);
	}
	
	/**
	 * 门诊医保差额回写明细数据处理
	 * @param cgDifDtos
	 * @throws BizException
	 * @author ly 2019/06/03
	 */
	@Override
	public void updateOpDif(BlCgOpDifDTO[] cgDifDtos) throws BizException{
		BlCgUpdateOpDifBP bp = new BlCgUpdateOpDifBP();
		bp.exec(cgDifDtos);
	}

	/**
	 * 保存明细模式退费申请
	 * @param nFeeItmDTOs
	 * @param pattern
	 * @throws BizException
	 */
	@Override
	public BlRefundApplyDO saveRefundApply(NurseCompFeeItmDTO[] nFeeItmDTOs, String pattern) throws BizException {
		BlSaveRefundApplyBP bp=new BlSaveRefundApplyBP();
		return bp.exec(nFeeItmDTOs, pattern);
	}

	/**
	 * 取消明细模式退费申请
	 * @param nFeeItmDTOs
	 * @param pattern
	 * @throws BizException
	 */
	@Override
	public void cancelRefundApply(NurseCompFeeItmDTO[] nFeeItmDTOs, String pattern) throws BizException {
		BlCancelDetailedRefundApplyBP bp=new BlCancelDetailedRefundApplyBP();		
		bp.exec(nFeeItmDTOs, pattern);
	}

	/**
	 * 取消单据模式退费申请
	 * @param nFeeItmDTOs
	 * @param pattern
	 * @throws BizException
	 */
	@Override
	public void cancelBillRefundApply(String[] rdfapIds) throws BizException {
		BlCancelBillRefundApplyBP bp=new BlCancelBillRefundApplyBP();
		bp.exec(rdfapIds);
	}
	
	/**
	 * 明细模式退费审核保存
	 * @param bItemDTOs
	 * @throws BizException
	 */
	@Override
	public void refundApDetailedAuditSave(BlRefundSrvItemDTO[] bItemDTOs) throws BizException {
		BlSaveDetailedApplyAuditBP bp=new BlSaveDetailedApplyAuditBP();
		bp.exec(bItemDTOs);
	}
	
	/**
	 * 单据模式退费审核保存
	 * @param bItemDTOs
	 * @throws BizException
	 */
	@Override
	public void refundApBillAuditSave(BlRefundSrvItemDTO[] bItemDTOs) throws BizException {
		BlSaveBillApplyAuditBP bp=new BlSaveBillApplyAuditBP();
		bp.exec(bItemDTOs);
	}
	
	/**
	 * 门诊转住院记账明细
	 * @param entId 住院就诊id
	 * @param blcgoepAggDO 门诊记账数据
	 * @param tfInids 费用转移记录id
	 * @param id_st_proxyhp 代报结算_门急转住院id
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgIpTfInDO[] saveBlIpTfInInfo(String entId, BlCgItmOepDO[]  cgItmArr,String[] tfInids,String id_st_proxyhp) throws BizException {
		BlIpTfInBp bp= new BlIpTfInBp();
		return bp.exec(entId, cgItmArr, tfInids,id_st_proxyhp);
	}

	/**
	 * 门诊记账转移记录
	 * @param id_ent 就诊id
	 * @param cgOepTfInMap 门诊记账门诊转住院记账明细map
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCgItmOepTfRcdDO[] saveBlCgOepTfInfo(String id_ent,Map<String,String> cgOepTfInMap) throws BizException {
		BlCgOepTfBp bp= new BlCgOepTfBp();
		return bp.exec(id_ent, cgOepTfInMap);
	}
	
	/**
	 * 保存医生退费申请
	 */
	@Override
	public void saveOrdRefundApply(BlOrderRefundListDTO[] ords) throws BizException {
		BlSaveOrdReundDataBP bp=new BlSaveOrdReundDataBP();
		bp.exec(ords);
	}
	
	/**
	 * 保存费用域打印配置(新)
	 * @param blPrinterSetDTO
	 * @throws BizException
	 * @author ly 2019/09/02
	 */
	@Override
	public void savePrinterSetInfoNew(BlPrinterSetDTO blPrinterSetDTO) throws BizException{
		BlSavePrinterSetInfoNewBP bp = new BlSavePrinterSetInfoNewBP();
		bp.exec(blPrinterSetDTO);
	}

	@Override
	public FBoolean preIpToOep(BlPreIpParamDTO blPreIpParamDto) throws BizException {
		PreIpToOepBP2 bp = new PreIpToOepBP2();
		return bp.exec(blPreIpParamDto);
	}
}
