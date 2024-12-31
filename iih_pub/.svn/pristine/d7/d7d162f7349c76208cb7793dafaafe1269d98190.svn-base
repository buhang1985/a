package iih.mp.dg.i;

import java.util.List;
import java.util.Map;

import iih.mp.dg.dto.d.MedDetailsDTO;
import iih.mp.dg.dto.d.OpDgQueSiteDTO;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.dto.d.OpPresQueSiteDTO;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.dto.mpdrugflow.d.MpDrugFlowDTO;
import iih.mp.dg.dto.opdgdisp.d.DrugsDTO;
import iih.mp.dg.oepdgappdt.d.OepDgAppDtDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 执行域药品服务对其他域提供接口
 * @author ly
 *
 */
public interface IMpDgOutService {
	
	/**
	 * 门急诊药品退费时取得可退药数量
	 * @param dtos 需要设置医嘱服务id,已计费数量
	 * @return 可退数量，是否领药标志
	 * @throws BizException
	 */
	public abstract OpDgRtnAmountDTO[] getOpDgRtnAmount(OpDgRtnAmountDTO[] dtos) throws BizException;
	
	/**
	 * 门急诊药品退费后回写发放明细数据
	 * @param orsrvIds 医嘱服务id
	 * @throws BizException
	 */
	public abstract void writebackDispItmAfterRefundCharge(String[] orsrvIds) throws BizException;
	
	/**
	 * 门急诊药品收费时写入请领数据
	 * @param appDts 请领数据
	 * @return 药品对应领药窗口
	 * @throws BizException
	 */
	public abstract OpDgQueSiteDTO[] insertOpdgappWhenCharge(OepDgAppDtDO[] appDts) throws BizException;
	
	/**
	 * 医嘱作废时退药
	 * @param orStopTimeMap key:医嘱id value:停止时间
	 * @throws BizException
	 */
	public abstract void returnMedWhenCancelOrder2(FMap orStopTimeMap) throws BizException;
	
	/**
	 * 医嘱停止时退药2
	 * @param orStopTimeMap key:医嘱id value:停止时间
	 * @throws BizException
	 */
	public abstract void returnMedWhenStopOrder2(FMap orStopTimeMap) throws BizException;
	
	/**
	 * 查询出院病人未发药总数
	 * 备注:就诊域的这个要求欠考虑,暂定
	 * @param endId 就诊id
	 * @return 未发药总数
	 * @throws BizException
	 */
	public abstract FDouble queryMedTotalNumForPatiWhenOut(String entId) throws BizException;
	
	/**
	 * 查询出院病人未发药总数
	 * @param endIds 就诊id数组
	 * @return 未发药总数Map key:就诊id value:未发药总数(FDouble)
	 * @throws BizException 传入的数组超过1000条数据
	 */
	public abstract FMap queryMedTotalNumForPatisWhenOut(String[] entIds) throws BizException;
	
	/**
	 * 查询出院病人未发药明细
	 * @param endId 就诊id
	 * @return 未发药明细
	 * @throws BizException
	 */
	public abstract MedDetailsDTO[] queryMedDetaisForPatiWhenOut(String entId) throws BizException;
	
	/**
	 * 查询出院病人未发药明细
	 * @param endIds 就诊id数组
	 * @return 未发药明细Map key:就诊id value:未发药明细(FArrayList存放MedDetailsDTO)
	 *         取不到数据的时,传入的就诊id也会作为key
	 * @throws BizException 传入的数组超过1000条数据
	 */
	public abstract FMap queryMedDetaisForPatisWhenOut(String[] entIds) throws BizException;
	
	/**
	 * 当后台摆药被触发时调用，向数据库里的摆药明细表写记录
	 * 以处方为单位从请领明细的记录写到摆药明细表里
	 * @param idpres 处方id，或者医嘱id idor,有的记录的idpres是null
	 * @throws BizException
	 */
	public abstract void writeRecordsWhenTriggered(String[] idoepdts/*请领表主键集合*/ ) throws BizException;

	/**
	 * 插入处方状态数据
	 * 门诊医嘱签署时调用
	 * @param presId 处方id集合
	 * @throws BizException 处方id为空，处方不存在
	 */
	public abstract void insertPresStatusData(String[] presIds) throws BizException;
	
	/**
	 * 插入处方窗口信息
	 * @param idpres 处方id
	 * @param entry 调用点 1收费,2签到,3医嘱开立
	 * @return 队列信息
	 * 		   fg_window = true表示在该执行点分队列,false 该执行点不做队列处理
	 * @throws BizException
	 */
	public abstract OpPresQueSiteDTO insertPresWindowData(String presId,int entry) throws BizException;

	/**
	 * 门急诊药品未发药退费时释放药房队列
	 * @param orsrvIds 医嘱服务id
	 * @throws BizException
	 */
	public abstract void releaseQueueAfterRefundCharge(String[] orsrvIds) throws BizException;
	
	/**
	 * 通过处方id释放药房队列
	 * @param presIds 处方id数组
	 * @throws BizException
	 */
	public abstract void releaseQueueByPresId(String[] presIds)throws BizException;
	
	/**
	 * 医技补费时生成药品请领单
	 * @param orsrvIds 医嘱服务id数组
	 * @return 请领单主键
	 * @throws BizException
	 */
	public abstract String createDrugSheetWhenOtAddFee(String[] orsrvIds) throws BizException;
	
	/**
	 * 医技补费时生成药品请领单(新版)
	 * @param orsrvIds 医嘱服务id数组
	 * @param fg_otDocStation 医技医生站补录
	 * @return 请领单主键数组
	 * @throws BizException
	 */
	public abstract String[] createDrugSheetWhenOtAddFeeNew(String[] orsrvIds, FBoolean fg_otDocStation) throws BizException;
	
	/**
	 * 发送医技请领单
	 * 默认预留库存并先记费
	 * @param apIds 请领主键
	 * @throws BizException
	 */
	public abstract void sendOtMedicineAppli(String[] apIds) throws BizException;
	
	/**
	 * 医技退补录项目时生成药品退药单
	 * @param orsrvIds 医嘱服务id数组
	 * @return 请领单主键
	 * @throws BizException
	 */
	public abstract String createDrugSheetWhenOtRefundFee(String[] orsrvIds) throws BizException;

	/**
	 * 医技退补录项目时生成药品退药单(新版)
	 * @param orsrvIds 医嘱服务id数组
	 * @return 请领单主键
	 * @throws BizException
	 */
	public abstract String createDrugSheetWhenOtRefundFeeNew(IpDgDtDTO[] deldtoList) throws BizException;
	
	/**
	 * 医技退补录项目时生成药品退药单(新版)
	 * @param orsrvIds 医嘱服务id数组
	 * @return 请领单主键
	 * @throws BizException
	 */
	public abstract String createDrugSheetWhenOtRefundFeeNewAll(String[] ordIds) throws BizException;
	
	/**
	 * 获取物品物资流向及库存价格(目前只用于医技补费)
	 * @param 物品及服务信息
	 * @return 流向科室及库存信息（价格，可用库存量）
	 * @throws BizException
	 */
	public abstract MpDrugFlowDTO[] getMaterialFlowAndStockPrice(MpDrugFlowDTO[] dtos) throws BizException;

	/**
	 * 获取处方对应的发药窗口号
	 * @param presIds 处方id数组
	 * @return map key:处方id value:窗口名称（多个时用逗号分隔）
	 * @throws BizException
	 */
	public abstract FMap getQueSiteNameOfPres(String[] presIds) throws BizException;
	/**
	 * 获取总用量
	 * @param presIds 医嘱id
	 * @return 总用量 quan
	 * @throws BizException
	 */
	public abstract FDouble getQuan_medu(String Id) throws BizException;


	/**
	 * 病区执行药品时进行基数药发药
	 * @param orPrsrvIds 医嘱服务执行点id
	 * @param depNurId 病区id
	 * @throws BizException
	 */
	public abstract void putMedWhenImplInDepNur(String[] orPrsrvIds,String depNurId) throws BizException;

	/**
	 * 病区取消执行药品时进行基数药退药
	 * @param orPrsrvIds 医嘱服务执行点id
	 * @param depNurId 病区id
	 * @throws BizException
	 */
	public abstract void returnMedWhenCancelImplInDepNur(String[] orPrsrvIds,String depNurId) throws BizException;

	/**
	 * 判断站点是否有没发药的处方
	 * 如果没有需要处理的发药处方则可以删除
	 * @param quesiteId
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean ifSiteHasUnDispPres(String quesiteId) throws BizException;
	
	/**
	 * 查询待出院患者未处理的退药单数量
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract List<Map<String, Object>> getStayHospitalReturnOrder(String[] id_ents) throws BizException;
	
	/**
	 * 查询门诊已记账未拿药的药品信息
	 * @param patId
	 * @return
	 * @throws BizException 
	 */
	public abstract DrugsDTO[] getAccountDrugInfo(String patId) throws BizException;
	
	/**
	 * 查询门诊就诊药品是否全部发放完毕
	 * @param entId
	 * @return 发放完毕 true  未发放完 false
	 * @throws BizException
	 */
	public abstract FBoolean whetherAllDrugDispense(String entId) throws BizException;
}
