package iih.ei.std.i.v1;

import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.DeptInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.FeetypeInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.ItemSrvInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.SamptpInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.UserInfoResultDTO;
import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.IPCollocateDrugResult;
import iih.ei.std.d.v1.mp.ipdispdrugInfo.d.IPDispDrugParamDTO;
import iih.ei.std.d.v1.mp.iprefundsupplymmoutdto.d.IpRefundSupplyMmOutParamDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabParamDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabPatinfoResultDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LisCrisisParamDTO;
import iih.ei.std.d.v1.mp.lisreport.d.CancRptSDTO;
import iih.ei.std.d.v1.mp.lisreport.d.LisRptInfoDTO;
import iih.ei.std.d.v1.mp.opdispdrugInfo.d.OPCollocateDrugResult;
import iih.ei.std.d.v1.mp.opdispdrugInfo.d.OPDispDrugParamDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsParamDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsPatinfoDTO;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsCrisisDTO;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsItemParamDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyInfoResultDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyParamDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.RptPathgyParamDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasDrugPlanResultBeanListDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasIpOrderParamDTO;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasOrderListDTO;
import iih.ei.std.d.v1.mp.purchasedrug.d.PurchaseDrugParamDTO;
import iih.ei.std.d.v1.mp.updatebycodeor.d.UpdateStatusParams;
import iih.ei.std.d.v1.mp.updatestatus.d.PlanStatusForLisParamDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpLabStatusParamDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpdateStatusParamDTO;
import iih.ei.std.d.v1.mp.wribackskintestresult.d.ReturnParamsDTO;
import iih.ei.std.d.v1.mp.wribackskintestresult.d.WribackSkintestResultDTO;
import xap.mw.core.data.BizException;

/**
 * 
 * @ClassName: IMpApiService
 * @Description: IIH执行域标准对外接口
 * @author zhy
 * @date 2019年9月23日
 *
 */
public interface IMpApiService {

	/*************** 基础数据部分 ***************/
	/**
	 * 获取用户基础数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public UserInfoResultDTO getUserInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取部门基础信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public DeptInfoResultDTO getDeptInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取费别基础数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public FeetypeInfoResultDTO getFeetypeInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取检查申请项目数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public ItemSrvInfoResultDTO getItemObsInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取检验申请项目数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public ItemSrvInfoResultDTO getItemLabInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取手术申请项目数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public ItemSrvInfoResultDTO getItemOperInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取血申请项目数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public ItemSrvInfoResultDTO getItemBloodInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取卫材申请项目数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public ItemSrvInfoResultDTO getItemEisaiInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取诊断数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public DiInfoResultDTO getDiInfo(BaseParamDTO param) throws BizException;

	/**
	 * 获取标本类型数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public SamptpInfoResultDTO getSamptpInfo(BaseParamDTO param) throws BizException;

	/*************** 查询医技申请单部分: 检查、 检验、 病理 ***************/

	/**
	 * 获取检查申请单信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public ObsPatinfoDTO getObsApplyInfo(ObsParamDTO param) throws BizException;

	/**
	 * 获取检验申请单信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public LabPatinfoResultDTO getLabApplyInfo(LabParamDTO param) throws BizException;

	/**
	 * 获取病理申请单信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PathgyApplyInfoResultDTO getPathgyApplyInfo(PathgyApplyParamDTO param) throws BizException;

	/*************** 回写报告部分: 检查、 检验、 病理 ***************/
	public void reportWriteInForLis(LisRptInfoDTO param) throws BizException;

	/**
	 * 回写检查报告信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void reportWriteInForRis(RptObsItemParamDTO param) throws BizException;

	/**
	 * 检验危急值回写
	 * 
	 * @return
	 * @throws BizException
	 */
	public void crisisValueSendMsg(LisCrisisParamDTO param) throws BizException;

	/**
	 * 回写病理报告
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void reportWriteInforPathgy(RptPathgyParamDTO param) throws BizException;

	/**
	 * 检查危急值回写
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void obsCrisisValue(RptObsCrisisDTO param) throws BizException;

	/*************** 状态修改部分 ***************/
	/**
	 * 修改状态接口
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void updateOrderStatus(UpdateStatusParamDTO param) throws BizException;

	/**
	 * 修改状态接口按标本维度 检验专用
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void updateOrderStatusBylab(UpLabStatusParamDTO param) throws BizException;

	/**
	 * 修改医嘱状态(药品长期医嘱)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void updateOrstausbycodeor(UpdateStatusParams param) throws BizException;	
	
	/**
	 * 检验合管插入的材料费和采血费单独改状态计费
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void updatePlanStatusForLis(PlanStatusForLisParamDTO param) throws BizException;
	
	/**
	 * 报告作废
	 * @param param
	 * @throws BizException
	 */
	public void cancRpt(CancRptSDTO param) throws BizException;
	
	/*************** 药品相关 ***************/
	/**
	 * 获取住院发药明细
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public IPCollocateDrugResult getIpDispDrugInfo(IPDispDrugParamDTO param) throws BizException;
	
	/**
	 * 获取门诊发药明细
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OPCollocateDrugResult getOpDispDrugInfo(OPDispDrugParamDTO param) throws BizException;
	
	/**
	 * 生成采购入库（新建状态）数据
	 * @return
	 * @throws BizException
	 */
	public void downStockData(PurchaseDrugParamDTO param) throws BizException;

	/**
	 * 查询住院PIVAS用药计划
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PivasOrderListDTO getIpPivasMpOrPr(PivasIpOrderParamDTO param) throws BizException;

	/**
	 * 查询住院PIVAS医嘱信息
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PivasDrugPlanResultBeanListDTO getIpPivasCiOr(PivasIpOrderParamDTO param) throws BizException;
	
	/*************** 补费相关 ***************/
	/**
	 * 住院补退费（含住院补退费+出库）
	 * @param param
	 * @throws BizException
	 */
	public void ipRefundSupplyFeeAndMmOut(IpRefundSupplyMmOutParamDTO param) throws BizException;
	
	/**
	 * 过手持pda设备手动录入皮试结果回写
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public ReturnParamsDTO wribackSkintestResult(WribackSkintestResultDTO param) throws BizException;
}
