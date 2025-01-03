package iih.bl.cg.i;

import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
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
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 记账命令服务接口
 * 
 * @author yankan
 * @since 2017-06-13
 *
 */
public interface IBlCgCmdService {

	/**
	 * 调用第三方退费接口
	 * 
	 * @param RefundInfoDO
	 *            发送消息对象
	 * @return 执行状态
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract void sendRefundMsg(RefundInfoDO retfundInfo) throws BizException;

	/**
	 * 退费是调用第三方接口
	 * 
	 * @param id_soep
	 *            退费结算编号
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract void sendRefundMsgByStId(String id_soep) throws BizException;
	
	/**
	 * 调用IIH退费平台退费接口
	 * @param RefundInfoDO
	 *            发送消息对象
	 * @return 执行状态
	 * @throws BizException
	 * @author liming
	 */
	public abstract FBoolean sendIIHRefundMsg(BlOrdReqDTO blOrdReqDTO) throws BizException;
	/**
	 * 收/退费，记账，取消记账 调用检查检验接口
	 * @param cgIdList 记账编码集合
	 * @param directEu 方向
	 * @throws BizException
	 */
	public abstract void sendChisProc(List<String> cgIdList,int directEu) throws BizException;
	
	/**
	 * 将第三方接口失败数据重新发送
	 * 
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract void sendRefundMsgAllToFail() throws BizException;
	
	/**
	 * 执行住院后台划价
	 * @param patId 患者ID
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	public abstract void execIpCgTask(String patId,FDateTime cgEndTime) throws BizException;
	
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
	public FBoolean updateCgUploadedFlag(String idEnt, String idStIp, FMap2 map, FBoolean isUploaded, FBoolean isBat) throws BizException;
	
	/** 医保更新记账数据
	 * @param strIdEnt 就诊号
	 * @param map
	 * @param isUploaded 是否上传
	 * @return
	 */
	public abstract FBoolean updateHpCgIp(String strIdEnt,IpBillItmUploadHpDTO[] list,FBoolean isUploaded) throws BizException;
	
	
	/**
	 * 住院退补费-进行退费确认
	 * @param dtoArr
	 * @author liwq
	 * @since 2018年3月31日6:04:03
	 * @return
	 * @throws BizException
	 */
	public FBoolean doRefundFeeSubmit(NurseCompFeeItmDTO[] dtoArr) throws BizException;
	
	/**
	 * 住院退补费-进行退费确认(可退任意科室费用)
	 * @param infos
	 * @author zhanghw
	 * @return
	 * @throws BizException
	 */
	public FBoolean submitRefundData(BlIpFeeInfo[] infos) throws BizException;
	
	/**
	 * 住院退补费-进行补费确认
	 * @param dtoArr
	 * @author liwq
	 * @since 2018年3月31日6:04:03
	 * @return
	 * @throws BizException
	 */
	public BlNurSubsidyErrorReturnDTO[] doCompensationSubmit(NurseCompFeeItmDTO[] dtoArr,String[] list_id_ent) throws BizException;

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
	public BlIpFeeDTO[] doBlCgIpInfoMend(String id_ent, BlIpFeeDTO[] blcgOrArr) throws BizException;	
	/**
	 * 门诊通用补费保存
	 * @author liwq
	 */
	public BlOrderAppendBillParamDTO[] doSaveOpAppendFee(NurseCompFeeItmDTO[] dtoArr,String id_ent) throws BizException;

	/**
	 * 住院补退费保存
	 * @param ipFeeDtos
	 * @date 2018年8月20日
	 * @author wq.li
	 */
	public abstract void saveCompensation(BlIpFeeDTO[] ipFeeDtos)throws BizException;

	/**
	 * 门诊销账回写
	 * @param blstrebill 需销账数据
	 * @param id_pat  患者id
	 * @return BlOepDeLCostDTO
	 *          销账后数据源(用于打印票据)
	 * @author zhangxin06
	 * @date   2018-9-29
	 * @throws BizException
	 */
	public BlOepDeLCostDTO[]  findSetSellData (BlOepDeLCostDTO[] blstrebill, String id_pat) throws BizException;
	
	/**
	 * 门诊费用转住院费用
	 * @param condDto 转移条件
	 * @throws BizException
	 * @author ly 2019/03/12
	 */
	public abstract void oepCgTransferToIpCg(BlCgOepToIpCondDTO condDto,FBoolean flag) throws BizException;
	
	/**
	 * 撤销门诊转住院费用
	 * @param condDto 转移条件
	 * @throws BizException
	 * @author ly 2019/03/12
	 */
	public abstract void cancelOepCgTransferToIpCg(BlCgOepToIpCondDTO condDto) throws BizException;
	
	/**
	 * 门诊费用转住院费用(真实转入)
	 * @author zhang.hw
	 * @date 2020年3月11日
	 * @param id_ent
	 * @throws BizException
	 */
	public abstract BlCgIpDO[] oepCgTransferToIpCgReal(String id_ent) throws BizException;
	
	/**
	 * 修改住院费用自费状态-指定自费
	 * @author zhang.hw
	 * @date 2019年4月30日
	 * @param ipBillItmUploadHpDTOs
	 * @param flag
	 * @return
	 * @throws BizException
	 */
	public FBoolean updateFgSelfpay(IpBillItmUploadHpDTO[] ipBillItmUploadHpDTOs) throws BizException;

	/**
	 * 门诊医保差额回写明细数据处理
	 * @param cgDifDtos
	 * @throws BizException
	 * @author ly 2019/06/03
	 */
	public void updateOpDif(BlCgOpDifDTO[] cgDifDtos) throws BizException;
	
	/**
	 * 保存明细模式退费申请
	 * @param nFeeItmDTOs
	 * @param pattern
	 * @throws BizException
	 */
	public abstract BlRefundApplyDO saveRefundApply(NurseCompFeeItmDTO [] nFeeItmDTOs,String pattern)throws BizException;
	
	/**
	 * 取消明细模式退费申请
	 * @param nFeeItmDTOs
	 * @param pattern
	 * @throws BizException
	 */
	public abstract void cancelRefundApply(NurseCompFeeItmDTO [] nFeeItmDTOs,String pattern)throws BizException;
	
	/**
	 * 取消单据模式退费申请
	 * @param nFeeItmDTOs
	 * @param pattern
	 * @throws BizException
	 */
	public abstract void cancelBillRefundApply(String [] rdfapIds)throws BizException;

	/**
	 * 明细模式退费审核保存
	 * @param bItemDTOs
	 * @throws BizException
	 */
	public abstract void refundApDetailedAuditSave(BlRefundSrvItemDTO [] bItemDTOs)throws BizException;

	/**
	 * 单据模式退费审核保存
	 * @param bItemDTOs
	 * @throws BizException
	 */
	public abstract void refundApBillAuditSave(BlRefundSrvItemDTO [] bItemDTOs)throws BizException;

	/**
	 * 保存医生退费申请
	 * @param ords
	 * @throws BizException
	 */
	public abstract void saveOrdRefundApply(BlOrderRefundListDTO [] ords)throws BizException;
	/**
	 * 门诊转住院记账明细
	 * @param entId 住院就诊id
	 * @param blcgoepAggDO 门诊记账数据
	 * @param propData 医保分摊数据
	 * @param tfInids 费用转移记录id
	 * @param id_st_proxyhp 代报结算_门急转住院id
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgIpTfInDO[] saveBlIpTfInInfo(String entId,BlCgItmOepDO[] cgItmArr,String[] tfInids,String id_st_proxyhp)throws BizException;
	
	/**
	 * 门诊记账转移记录
	 * @param id_ent 就诊id
	 * @param cgOepTfInMap 门诊记账门诊转住院记账明细map
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgItmOepTfRcdDO[] saveBlCgOepTfInfo(String id_ent,Map<String,String> cgOepTfInMap)throws BizException;

	/**
	 * 保存费用域打印配置(新)
	 * @param blPrinterSetDTO
	 * @throws BizException
	 * @author ly 2019/09/02
	 */
	public abstract void savePrinterSetInfoNew(BlPrinterSetDTO blPrinterSetDTO) throws BizException;
	
	/**
	 * 预住院转门诊
	 * @param blPreIpParamDto
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean preIpToOep(BlPreIpParamDTO blPreIpParamDto) throws BizException;
}
