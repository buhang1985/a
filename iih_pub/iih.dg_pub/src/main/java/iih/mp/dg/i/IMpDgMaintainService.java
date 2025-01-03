package iih.mp.dg.i;

import java.util.Map;

import iih.mp.dg.dto.backdrugdisp.d.MpPrepPresListDTO;
import iih.mp.dg.dto.druginfudto.d.ActionMesDTO;
import iih.mp.dg.dto.druginfudto.d.OpInfuPatOrDTO;
import iih.mp.dg.dto.herbaldelivery.d.HerbalDeliveryDTO;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDispHdDTO;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.dto.mpherbverify.d.MpHerbVerifyDTO;
import iih.mp.dg.dto.opboilherb.d.OpBoilHerbPresDTO;
import iih.mp.dg.dto.opdgdisp.d.DrugsDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDrugsDTO;
import iih.mp.dg.transreg.dto.d.TransRegPrePaySrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IMpDgMaintainService {

	/**
	 * 门诊发药重构版
	 * 
	 * @param pres
	 * @param isHerb
	 * @throws BizException
	 */
	public abstract void dispenseOpDrugs2(iih.mp.dg.dto.opdgdisp.d.PresDTO pres, FBoolean isHerb) throws BizException;

	/**
	 * 门诊退药重构版
	 * 
	 * @param pres
	 * @param isHerb
	 * @return 
	 * @throws BizException
	 */
	public abstract Integer returnOpDrugs2(iih.mp.dg.dto.opdgdisp.d.PresDTO pres, FBoolean isHerb, Integer settlement) throws BizException;

	/**
	 * 门诊发药药房上线下线时更新工作站队列
	 * 
	 * @param siteStatus
	 * @throws BizException
	 */
	public abstract void updateQueState2(int siteStatus) throws BizException;

	/**
	 * 取消摆药
	 * 
	 * @param preses
	 * @throws BizException
	 */
	public abstract void cancelPrepareDrug(PresDTO[] preses) throws BizException;

	/**
	 * 住院直接摆药确认
	 * 
	 * @param dos
	 *            药品数据
	 * @param putType
	 *            摆药类型(21：发药 22：退药 23：出院带药)
	 * @return 摆药单号
	 * @throws BizException
	 */
	public abstract String putIpMedicineDirect(IpDgDtDTO[] dos, String putType) throws BizException;

	/**
	 * 住院直接摆药之退药确认
	 * 
	 * @param dos
	 *            药品数据
	 */
	public void putIpMedicineReturnDirect(IpDgDtDTO[] dos) throws BizException;

	/**
	 * 住院直接摆药确认(新版)
	 * 
	 * @param dos
	 *            药品数据
	 * @param putType
	 *            摆药类型(21：发药 22：退药 23：出院带药)
	 * @param fgSplit
	 *            是否按处方分单处理
	 * @param funCode
	 *            节点功能编码
	 * @return 摆药单号
	 * @throws BizException
	 */
	public abstract String putIpMedicineDirect2(IpDgDtDTO[] dos, String putType, FBoolean fgSplit, String funCode)
			throws BizException;

	/**
	 * 住院暂存更改请领数据
	 * 
	 * @param dos
	 * @param fg_putmed 是否发药动作标识
	 * @param fg_refresh 是否刷单动作标识
	 *            药品数据
	 * @throws BizException
	 */
	public abstract void curSaveIpMedicineAppli(IpDgDtDTO[] dos, Boolean fg_putmed, Boolean fg_refresh) throws BizException;
	
	/**
	 * 异常数据拒摆
	 * 
	 * @param dos
	 *            药品数据
	 * @throws BizException
	 */
	public abstract void curSaveIpMedicineAppliForInvalid(IpDgDtDTO[] dos) throws BizException;

	/**
	 * 住院保存特殊退药单
	 * 
	 * @param dos
	 *            药品数据
	 * @return dos 药品数据
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] saveIpSpecialRetSheet(IpDgDtDTO[] dos, FBoolean fgHerb, FBoolean check)
			throws BizException;

	/**
	 * 住院暂存特殊退药单
	 * 
	 * @param dos
	 *            药品数据
	 * @throws BizException
	 */
	public abstract void curSaveIpSpecialRetSheet(IpDgDtDTO[] dos) throws BizException;

	/**
	 * 住院发送摆药请领单
	 * 
	 * @param ipapId
	 *            请领主键
	 * @return 药单号
	 * @throws BizException
	 */
	public abstract IpDgDispHdDTO sendIpMedicineAppli(String ipapId) throws BizException;

	/**
	 * 住院发送摆药请领单(拒摆) 针对草药单
	 * 
	 * @param ipapId
	 *            请领主键
	 * @return 药单号
	 * @throws BizException
	 */
	public abstract IpDgDispHdDTO sendRefuseIpMedicineAppli(String ipapId) throws BizException;

	/**
	 * 住院取消发送住院摆药请领单
	 * 
	 * @param ipapId
	 *            请领主键
	 * @throws BizException
	 */
	public abstract void cancelIpMedicineAppliSending(String ipapId) throws BizException;

	/**
	 * 住院取消发送住院普通退药单
	 * 
	 * @param ipapId
	 *            请领主键
	 * @throws BizException
	 */
	public abstract void cancelIpRetSending(String ipapId) throws BizException;

	/**
	 * 住院取消发送住院特殊退药单
	 * 
	 * @param ipapId
	 *            请领主键
	 * @throws BizException
	 */
	public abstract void cancelIpSpecialRetSending(String ipapId) throws BizException;

	/**
	 * 住院发送摆药确认
	 * 
	 * @param dos
	 *            药品数据
	 * @param putType
	 *            摆药类型(21：发药 22：退药 23：出院带药)
	 * @param funCode
	 *            节点功能编码(回写医嘱闭环状态用)
	 * @throws BizException
	 */
	public abstract String putIpMedicineSend(IpDgDtDTO[] dos, String putType, String funCode) throws BizException;
	
	/**
	 * 住院发送摆药确认
	 * 
	 * @param dos
	 *            药品数据
	 * @param putType
	 *            摆药类型(21：发药 22：退药 23：出院带药)
	 * @param funCode
	 *            节点功能编码(回写医嘱闭环状态用)
	 * @throws BizException
	 */
	public abstract Map<String, String> putIpMedicineSendBat(String[] id_dgipaps, String funCode) throws BizException;
	
	/**
	 * 住院执行绑定时替换药品
	 * 
	 * @param dos
	 *            请领药品信息
	 * @throws BizException
	 */
	public abstract void replaceIpMedicine(IpDgDtDTO[] dos) throws BizException;

	/**
	 * 住院批量发药
	 * 
	 * @param apIds
	 *            请领表主键数组
	 * @throws BizException
	 */
	public abstract void putIpMedicineBat(String[] apIds, String funCode) throws BizException;

	/**
	 * 住院草药审核
	 * 
	 * @param apId
	 *            请领主键
	 * @return 审核结果
	 * @throws BizException
	 */
	public abstract MpHerbVerifyDTO verifyIpHerb(String apId) throws BizException;

	/**
	 * 更新请领明细和摆药明细表的处方信息,在配药完成时
	 * 
	 * @param details
	 *            当前处方的明细
	 * @throws BizException
	 */
	public abstract void updateAfterPrep(MpPrepPresListDTO[] pres) throws BizException;

	/**
	 * 更新请领明细和摆药明细表的处方信息，在打印时
	 * 
	 * @param details
	 *            当前处方的明细
	 * @throws BizException
	 */
	public abstract void updateAfterPrint(MpPrepPresListDTO[] pres) throws BizException;

	/**
	 * 当门子草药代煎打印煎药证时调用更新后台相关字段
	 * 
	 * @param pres
	 * @throws BizException
	 */
	public abstract void updateBoilmedRecordsWhenPrint(OpBoilHerbPresDTO[] pres) throws BizException;

	/**
	 * 门诊草药代煎，煎药完成时调用此方法
	 * 
	 * @param pres
	 * @throws BizException
	 */
	public abstract void updateBoilmedRecordsWhenBoiledOver(OpBoilHerbPresDTO[] pres) throws BizException;

	/**
	 * 门诊草药发放，当煎药完成需要发放给患者时调用此方法
	 * 
	 * @param pres
	 * @throws BizException
	 */
	public abstract void updateBoilmedRecordsWhenGive(OpBoilHerbPresDTO[] pres) throws BizException;

	/**
	 * 门诊输液登记
	 * 
	 * @throws BizException
	 */
	public abstract void registerInfuOrder(OpInfuPatOrDTO patOrder) throws BizException;

	/**
	 * 代煎收费
	 * 
	 * @param pres
	 * @throws BizException
	 */
	public abstract void chargeForPresToBoil(PresDTO pres) throws BizException;

	/**
	 * 校验代煎是否缴费
	 * 
	 * @param pres
	 * @throws BizException
	 */
	public abstract void validateBoilFeeCharged(PresDTO pres) throws BizException;

	/**
	 * 预交金付费
	 * 
	 * @param pres
	 * @param isHerb
	 * @throws BizException
	 */
	public abstract PresDTO appendPrepayFee(PresDTO pres, FBoolean isHerb) throws BizException;

	/**
	 * 输液登记节点:带走
	 * 
	 * @param patOrder
	 * @throws BizException
	 */
	public abstract void updateInfuAfterTaken(OpInfuPatOrDTO patOrder) throws BizException;

	/**
	 * 输液执行节点:保存
	 * 
	 * @param patOrder
	 * @throws BizException
	 */
	public abstract void executeSave(ActionMesDTO sData) throws BizException;

	/**
	 * 更新配药单和处方状态表信息
	 * 
	 * @param details
	 *            当前处方的明细
	 * @throws BizException
	 */
	public abstract void cancelData(MpPrepPresListDTO[] pres) throws BizException;

	/**
	 * 输液登记时进行预交金
	 * 
	 * @param prePaySrvs
	 *            预付费项目列表
	 * @throws BizException
	 */
	public abstract void prepayOnInfuRegist(TransRegPrePaySrvDTO[] prePaySrvs) throws BizException;
	
	/**
	 * 根据处方信息插入窗口表数据(当前窗口)
	 * 
	 * @param presInfo
	 * @throws BizException
	 */
	public abstract void insertWinData(PresDrugsDTO[] presInfo) throws BizException;

	/**
	 * 门诊医嘱服务是否已经结算(调用bl接口)
	 * @param laPres
	 * @param isHerb
	 * @return
	 * @throws BizException
	 */
	public abstract Integer orsrvHasSettled(PresDTO laPres, FBoolean isHerb) throws BizException;
	
	/**
	 * 门诊退药后退费操作(调用bl接口)
	 * @param laPres
	 * @param isHerb
	 * @throws BizException
	 */
	public abstract void refundAccount(PresDTO laPres, FBoolean isHerb) throws BizException;
	
	/**
	 * 静配库存确认，更新请领明细状态
	 * @throws BizException
	 */
	public abstract void pivasStockConfrim() throws BizException;
	
	/**
	 * 静配中心发药前异常确认
	 * @throws BizException
	*/
	public abstract void checkPivasStock(IpDgDtDTO[] ipDgDtDtoList) throws BizException;
	
	/**
	 * 保存门诊草药配送联系住址信息
	 * @param id_pres
	 * @return
	 * @throws BizException
	 */
	public abstract void saveHerbDelvrContact(HerbalDeliveryDTO param) throws BizException;
	
	/**
	 * 门诊草药外送（对接第三方接口）
	 * 
	 * @param presId
	 * @return 返回值 状态码： 0 标识调用成功 1 标识调用失败
	 * @throws BizException
	 */
	public abstract String outDelivery(String presId) throws BizException;

	/**
	 * 门诊草药取消外送（对接第三方接口）
	 * 
	 * @param presId
	 * @return 返回值 状态码： 0 标识调用成功 1 标识调用失败
	 * @throws BizException
	 */
	public abstract String cancelDelivery(String presId) throws BizException;

	/**
	 * 第三方包药机
	 * 
	 * @param idPres
	 * @throws BizException
	 */
	public abstract void pkMachDisp(String idPres) throws BizException;
	
	/**
	 * 用户密码确认
	 * 
	 * @param id_psndoc
	 * @param password
	 * @throws BizException
	 */
	public FBoolean validatePsndocPassword(String id_psndoc,String password) throws BizException;
	
	/**
	 * 门急诊处方审核(新)
	 * 
	 * @param presDTOS
	 * @throws BizException
	 */
	public abstract void verifyPres(PresDTO[] presDTOS) throws BizException;
	
	/**
	 * 门急诊处方发药
	 * 
	 * @param presDTOS
	 * @throws BizException
	 */
	public abstract void opOtDispPresBat(PresDTO[] presDTOS) throws BizException;
	
	/**
	 * 门急诊取消退药
	 * 
	 * @param drugsDtos
	 * @throws BizException
	 */
	public abstract void opCancelDrugReturn(DrugsDTO[] drugsDtos) throws BizException;
}
