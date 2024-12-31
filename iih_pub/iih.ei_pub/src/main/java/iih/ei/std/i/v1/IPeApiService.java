package iih.ei.std.i.v1;

import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.DeptInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.FeetypeInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.ItemSrvInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.SamptpInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.UserInfoResultDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabParamDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LabPatinfoResultDTO;
import iih.ei.std.d.v1.mp.lisdata.d.LisCrisisParamDTO;
import iih.ei.std.d.v1.mp.lisreport.d.CancRptSDTO;
import iih.ei.std.d.v1.mp.lisreport.d.LisRptInfoDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsParamDTO;
import iih.ei.std.d.v1.mp.pacedata.d.ObsPatinfoDTO;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsCrisisDTO;
import iih.ei.std.d.v1.mp.pacedata.d.RptObsItemParamDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyInfoResultDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyParamDTO;
import iih.ei.std.d.v1.mp.pathgydata.d.RptPathgyParamDTO;
import iih.ei.std.d.v1.mp.updatebycodeor.d.UpdateStatusParams;
import iih.ei.std.d.v1.mp.updatestatus.d.PlanStatusForLisParamDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpLabStatusParamDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.UpdateStatusParamDTO;
import xap.mw.core.data.BizException;

/**
 * 
 * @ClassName: IPeApiService
 * @Description: IIH体检标准对外接口
 * @author 聂利生
 * @date 2020年3月31日
 *
 */
public interface IPeApiService {

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
	
}
