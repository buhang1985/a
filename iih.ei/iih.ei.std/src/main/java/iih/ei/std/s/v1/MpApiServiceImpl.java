package iih.ei.std.s.v1;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
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
import iih.ei.std.i.v1.IMpApiService;
import iih.ei.std.s.v1.bp.mp.basedata.GetDeptInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetDiInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetFeetypeInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetItemBloodInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetItemEisaiInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetItemLabInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetItemObsInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetItemOperInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetSamptpInfoBp;
import iih.ei.std.s.v1.bp.mp.basedata.GetUserInfoBp;
import iih.ei.std.s.v1.bp.mp.crisisvalue.CrisisValuePackageBp;
import iih.ei.std.s.v1.bp.mp.dispdruginfo.GetIPDispDrugInfoBP;
import iih.ei.std.s.v1.bp.mp.dispdruginfo.GetOPDispDrugInfoBP;
import iih.ei.std.s.v1.bp.mp.downstockdata.CallHisForPOsBp;
import iih.ei.std.s.v1.bp.mp.iprefundsupplymmout.IpRefundSupplyFeeMmOutBp;
import iih.ei.std.s.v1.bp.mp.lisdata.GetLabApplyInfoBp;
import iih.ei.std.s.v1.bp.mp.lisrpt.CancRptBp;
import iih.ei.std.s.v1.bp.mp.lisrpt.LisRptBp;
import iih.ei.std.s.v1.bp.mp.pacedata.GetObsApplyInfoBp;
import iih.ei.std.s.v1.bp.mp.pacedata.ObsCrisisBp;
import iih.ei.std.s.v1.bp.mp.pacedata.SaveObsRptDataBp;
import iih.ei.std.s.v1.bp.mp.pathgydata.GetPathgyApplyInfoBp;
import iih.ei.std.s.v1.bp.mp.pathgydata.SavePathgyRptDataBp;
import iih.ei.std.s.v1.bp.mp.pivas.GetIpDrugPlansBp;
import iih.ei.std.s.v1.bp.mp.pivas.GetIpOrdersBp;
import iih.ei.std.s.v1.bp.mp.updatastatus.UpdateOrderStatusBp;
import iih.ei.std.s.v1.bp.mp.updatebyplan.UpdatePlanStatusForLisBp;
import iih.ei.std.s.v1.bp.mp.updatebyplan.UpdatebyplanBp;
import iih.ei.std.s.v1.bp.mp.updatestatusbylab.ApUpdateStatusByLabBp;
import iih.ei.std.s.v1.bp.mp.wribackskintestresult.UpdateSkintestResultBp;
import iih.ei.std.s.v1.bp.pe.lisdata.GetPeLabApplyInfoBp;
import iih.ei.std.s.v1.bp.pe.pacsdata.GetPeObsApplyInfoBp;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

/**
 * 
* @ClassName: MpApiServiceImpl
* @Description: IIH执行域标准对外接口
* @author zhy
* @date 2019年9月23日
*
 */
public class MpApiServiceImpl implements IMpApiService{

	/*************** 基础数据部分 ***************/
	
	/**
	 * 获取用户基础数据
	 * @throws DAException 
	 */
	@Override
	public UserInfoResultDTO getUserInfo(BaseParamDTO param) throws BizException {	
		return new GetUserInfoBp().exec(param);
	}
    
	/**
	 * 获取部门基础数据
	 */
	@Override
	public DeptInfoResultDTO getDeptInfo(BaseParamDTO param) throws BizException {
		return new GetDeptInfoBp().exec(param);
	}
    
	/**
	 * 获取费别基础数据
	 */
	@Override
	public FeetypeInfoResultDTO getFeetypeInfo(BaseParamDTO param) throws BizException {	
		return new GetFeetypeInfoBp().exec(param);
	}
   
	/**
	 * 获取检查申请项目数据
	 */
	@Override
	public ItemSrvInfoResultDTO getItemObsInfo(BaseParamDTO param) throws BizException {
		return new GetItemObsInfoBp().exec(param);
	}

	/**
	 * 获取检验申请项目数据
	 */
	@Override
	public ItemSrvInfoResultDTO getItemLabInfo(BaseParamDTO param) throws BizException {
		return new GetItemLabInfoBp().exec(param);
	}
	
	/**
	 * 获取手术申请项目数据
	 */
	@Override
	public ItemSrvInfoResultDTO getItemOperInfo(BaseParamDTO param) throws BizException {
		return new GetItemOperInfoBp().exec(param);
	}
	
	/**
	 * 获取血申请项目数据
	 */
	@Override
	public ItemSrvInfoResultDTO getItemBloodInfo(BaseParamDTO param) throws BizException {
		return new GetItemBloodInfoBp().exec(param);
	}

	/**
	 * 获取卫材申请项目数据
	 */
	@Override
	public ItemSrvInfoResultDTO getItemEisaiInfo(BaseParamDTO param) throws BizException {
		return new GetItemEisaiInfoBp().exec(param);
	}
	
	/**
	 * 获取诊断数据
	 */
	@Override
	public DiInfoResultDTO getDiInfo(BaseParamDTO paramDTO) throws BizException {
		return new GetDiInfoBp().exec(paramDTO);
	}
	
	/**
	 * 获取标本类型数据	
	 */
	@Override
	public SamptpInfoResultDTO getSamptpInfo(BaseParamDTO param) throws BizException {
		return new GetSamptpInfoBp().exec(param);
	}
	
	/*************** 查询医技申请单部分: 检查、 检验、 病理 ***************/
	/**
	 * 获取检查申请单信息
	 */
	@Override
	public ObsPatinfoDTO getObsApplyInfo(ObsParamDTO param) throws BizException {
		return new GetObsApplyInfoBp().exec(param);
	}
	
	/**
	 * 获取检验申请信息
	 */
	@Override
	public LabPatinfoResultDTO getLabApplyInfo(LabParamDTO param) throws BizException {
		return new GetLabApplyInfoBp().exec(param);
	}
	
	/**
	 * 获取病理申请单信息
	 */
	@Override
	public PathgyApplyInfoResultDTO getPathgyApplyInfo(PathgyApplyParamDTO param) throws BizException {
		return new GetPathgyApplyInfoBp().exec(param);
	}
	
	/*************** 回写报告部分: 检查、 检验、 病理 ***************/

	@Override
	public void reportWriteInForLis(LisRptInfoDTO param) throws BizException {
		new LisRptBp().execTrans(param);
	}
	
	/**
	 * 回写检查报告信息
	 */
	@Override
	public void reportWriteInForRis(RptObsItemParamDTO param) throws BizException {
		new SaveObsRptDataBp().execTrans(param);
	}
	
	/**
	 * 回写病理报告
	 */
	@Override
	public void reportWriteInforPathgy(RptPathgyParamDTO param) throws BizException {
		new SavePathgyRptDataBp().execTrans(param);
	}
	
	/**
	 * 检验危急值回写
	 */
	@Override
	public void crisisValueSendMsg(LisCrisisParamDTO param) throws BizException {
		new CrisisValuePackageBp().execTrans(param);
	}
	
	/**
	 * 检查危急值回写
	 */
	@Override
	public void obsCrisisValue(RptObsCrisisDTO param) throws BizException {
		new ObsCrisisBp().execTrans(param);
	}
	
	/*************** 状态 修改部分 ***************/
	/**
	 * 修改状态接口
	 * @return 
	 */
	@Override
	public void updateOrderStatus(UpdateStatusParamDTO param) throws BizException {
		new UpdateOrderStatusBp().execTrans(param);
	}
	
	/**
	 * 修改状态接口按标本维度 检验专用
	 */
	@Override
	public void updateOrderStatusBylab(UpLabStatusParamDTO param) throws BizException {
		new ApUpdateStatusByLabBp().execTrans(param);
	}
	
	/**
	 * 修改医嘱状态
	 */
	@Override
	public void updateOrstausbycodeor(UpdateStatusParams param) throws BizException {
		new UpdatebyplanBp().execTrans(param);
	}
	
	/**
	 * 检验合管插入的材料费和采血费单独改状态计费
	 * 
	 * @param xmlParam
	 * @return
	 * @throws BizException 
	 */
	public void updatePlanStatusForLis(PlanStatusForLisParamDTO param) throws BizException {
		new UpdatePlanStatusForLisBp().execTrans(param);
	}

	/**
	 * 作废检验报告接口
	 */
	@Override
	public void cancRpt(CancRptSDTO param) throws BizException {
		new CancRptBp().execTrans(param);
	}
	
	/*************** 药品相关 ***************/
	/**
	 * 获取住院发药明细
	 */
	@Override
	public IPCollocateDrugResult getIpDispDrugInfo(IPDispDrugParamDTO param) throws BizException {
		return new GetIPDispDrugInfoBP().exec(param);
	}
	
	/**
	 * 获取门诊发药明细
	 */
	@Override
	public OPCollocateDrugResult getOpDispDrugInfo(OPDispDrugParamDTO param) throws BizException {
		return new GetOPDispDrugInfoBP().exec(param);
	}
	
	/**
	 * 生成采购入库（新建状态）数据
	 */
	@Override
	public void downStockData(PurchaseDrugParamDTO param) throws BizException {
		new CallHisForPOsBp().exec(param);
	}
	
	/**
	 * 查询住院PIVAS用药计划
	 */
	@Override
	public PivasOrderListDTO getIpPivasMpOrPr(PivasIpOrderParamDTO param) throws BizException {
		return  new GetIpOrdersBp().exec(param);
	}
	
	/**
	 * 查询住院PIVAS医嘱信息
	 */
	@Override
	public PivasDrugPlanResultBeanListDTO getIpPivasCiOr(PivasIpOrderParamDTO param) throws BizException {
		return  new GetIpDrugPlansBp().exec(param);
	}

	/*************** 补费相关 ***************/
	/**
	 * 住院补退费（含住院补退费+出库）
	 * @param param
	 * @throws BizException
	 */
	@Override
	public void ipRefundSupplyFeeAndMmOut(IpRefundSupplyMmOutParamDTO param) throws BizException {
		new IpRefundSupplyFeeMmOutBp().execTrans(param);
	}
	
	/**
	 * 过手持pda设备手动录入皮试结果回写
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public ReturnParamsDTO wribackSkintestResult(WribackSkintestResultDTO param) throws BizException {
		return new UpdateSkintestResultBp().exec(param);
	}
}
