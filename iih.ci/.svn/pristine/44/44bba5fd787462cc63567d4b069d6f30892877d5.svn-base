package iih.ci.mb.s;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import iih.ci.mb.bp.DelDoctorMemorandumListByMemoIDBP;
import iih.ci.mb.bp.GetDeptDoctorsBP;
import iih.ci.mb.bp.GetDeptIpPatListBP;
import iih.ci.mb.bp.GetDoctorMemorandumListByEntBP;
import iih.ci.mb.bp.GetNurseOfDeptBP;
import iih.ci.mb.bp.GetPatIpHistoryBP;
import iih.ci.mb.bp.GetPatIpLabListBP;
import iih.ci.mb.bp.GetPatIpMrListBP;
import iih.ci.mb.bp.GetPatIpNmrListBP;
import iih.ci.mb.bp.GetPatIpObsListBP;
import iih.ci.mb.bp.GetPatIpOrdListBP;
import iih.ci.mb.bp.GetVsInfoByEntBP;
import iih.ci.mb.bp.SaveDoctorMemorandumBP;
import iih.ci.mb.i.ArrayOfDCZdTemperatureDisplayColumn;
import iih.ci.mb.i.DCNursingRecord;
import iih.ci.mb.i.DCNursingRecordItem;
import iih.ci.mb.i.DCZdTemperatureDisplayColumn;
import iih.ci.mb.i.DelDoctorMemorandumRequest;
import iih.ci.mb.i.DelDoctorMemorandumResponse;
import iih.ci.mb.i.GetCheckUrlOfPatientHRResponse;
import iih.ci.mb.i.GetDepartmentCareLevelCountOfDeptResponse;
import iih.ci.mb.i.GetDoctorAdviceOfPatientHRResponse;
import iih.ci.mb.i.GetDoctorMemorandumListRequest;
import iih.ci.mb.i.GetDoctorMemorandumListResponse;
import iih.ci.mb.i.GetDoctorOfDepartmentResponse;
import iih.ci.mb.i.GetMedicalRecordsOfPatientHRResponse;
import iih.ci.mb.i.GetNursingDocumentsOfPatientHRResponse;
import iih.ci.mb.i.GetNursingRecordOfPatientHRRequest;
import iih.ci.mb.i.GetNursingRecordOfPatientHRResponse;
import iih.ci.mb.i.GetPatientHROfDepartmentResponse;
import iih.ci.mb.i.GetPatientHistoryHRByIDResponse;
import iih.ci.mb.i.GetTestOfPatientHRResponse;
import iih.ci.mb.i.GetZdTemperatureDisplayColumnResponse;
import iih.ci.mb.i.ICiMbQueryService;
import iih.ci.mb.i.SaveDoctorMemorandumRequest;
import iih.ci.mb.i.SaveDoctorMemorandumResponse;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 移动医生站查询服务
 * 
 * @author yankan
 * @since 2018-03-12
 *
 */
@Service(serviceInterfaces = { ICiMbQueryService.class }, binding = Binding.JSONRPC)
public class CiMbQueryServiceImpl implements ICiMbQueryService {
	/**
	 * 获取科室医生列表
	 * 
	 * @param deptId
	 *            科室ID
	 * @return 医生信息集合
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetDoctorOfDepartmentResponse getDeptDoctors(String deptId) throws BizException {
		GetDeptDoctorsBP getDeptDoctorsBP = new GetDeptDoctorsBP();
		return getDeptDoctorsBP.exec(deptId);
	}

	/**
	 * 获取病区科室
	 * 
	 * @param deptId
	 *            科室ID
	 * @return 科室
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetDepartmentCareLevelCountOfDeptResponse getWardOrDept(String deptID) throws BizException {
		GetNurseOfDeptBP getDeptBP = new GetNurseOfDeptBP();
		return getDeptBP.exec(deptID);
	}

	/**
	 * 获取科室在院患者
	 * 
	 * @param deptId
	 *            科室ID
	 * @return 在院患者集合
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetPatientHROfDepartmentResponse getDeptIpPatList(String deptId) throws BizException {
		GetDeptIpPatListBP getDeptPatBP = new GetDeptIpPatListBP();
		return getDeptPatBP.exec(deptId);
	}

	/**
	 * 获取患者历史住院记录
	 * 
	 * @param patId
	 *            患者ID
	 * @return 住院记录集合
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetPatientHistoryHRByIDResponse getPatIpHistory(String patId) throws BizException {
		GetPatIpHistoryBP getPatIpHistoryBP = new GetPatIpHistoryBP();
		return getPatIpHistoryBP.exec(patId);
	}

	/**
	 * 获取患者医嘱列表
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetDoctorAdviceOfPatientHRResponse getPatIpOrdList(String entId) throws BizException{
		GetPatIpOrdListBP getOrdBP = new GetPatIpOrdListBP();
		return getOrdBP.exec(entId);
	}
	/**
	 * 获取患者住院检查列表
	 * 
	 * @param patId
	 *            患者ID
	 * @param ipTimes
	 *            住院次数
	 * @return 检查集合
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetCheckUrlOfPatientHRResponse getPatIpObsList(String patId, String ipTimes) throws BizException {
		GetPatIpObsListBP getObsListBP = new GetPatIpObsListBP();
		return getObsListBP.exec(patId, ipTimes);
	}

	/**
	 * 获取患者住院检验列表
	 * 
	 * @param entId
	 *            就诊ID
	 * @return 住院检验集合
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetTestOfPatientHRResponse getPatIpLabList(String entId) throws BizException {
		GetPatIpLabListBP getIpLabBP = new GetPatIpLabListBP();
		return getIpLabBP.exec(entId);
	}

	/**
	 * 获取患者住院病历列表
	 * 
	 * @param patId
	 *            患者ID
	 * @param ipTimes
	 *            住院次数
	 * @return 住院病历集合
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public GetMedicalRecordsOfPatientHRResponse getPatIpMrList(String patId, String ipTimes) throws BizException {
		GetPatIpMrListBP getIpMrBP = new GetPatIpMrListBP();
		return getIpMrBP.exec(patId, ipTimes);
	}

	/**
	 * 获取护理体征记录
	 * 
	 * @param patientHRID
	 *            患者ID
	 * @param subID
	 *            患者住院次数
	 * @param departmentID患者科室ID
	 * @return 护理记录集合
	 * @throws BizException
	 * @author wangwei
	 */
	@Override
	public GetNursingRecordOfPatientHRResponse getNursingRecordOfPatientHR(GetNursingRecordOfPatientHRRequest request)
			throws BizException {
		GetVsInfoByEntBP bp = new GetVsInfoByEntBP();
		return bp.exec(request);
	}

	/**
	 * 获取备忘录列表
	 * 
	 * @param request
	 *            请求参数
	 * @return 备忘录列表
	 * @throws BizException
	 * @author wangwei
	 */
	@Override
	public GetDoctorMemorandumListResponse getDoctorMemorandumList(GetDoctorMemorandumListRequest request)
			throws BizException {
		GetDoctorMemorandumListByEntBP bp = new GetDoctorMemorandumListByEntBP();
		try {
			return bp.exec(request);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 保存备忘录
	 * 
	 * @param request
	 *            请求参数
	 * @return 保存状态
	 * @throws BizException
	 * @author wangwei
	 */
	@Override
	public SaveDoctorMemorandumResponse saveDoctorMemorandum(SaveDoctorMemorandumRequest request) throws BizException {
		SaveDoctorMemorandumBP bp = new SaveDoctorMemorandumBP();
		return bp.exec(request);
	}

	/**
	 * 删除一个备忘录
	 * 
	 * @param request
	 *            请求参数
	 * @return 执行状态
	 * @throws BizException
	 * @author wangwei
	 */
	@Override
	public DelDoctorMemorandumResponse delDoctorMemorandum(DelDoctorMemorandumRequest request) throws BizException {
		DelDoctorMemorandumListByMemoIDBP bp = new DelDoctorMemorandumListByMemoIDBP();
		return bp.exec(request);
	}

	@Override
	public GetNursingDocumentsOfPatientHRResponse getNurNmrList(String patientHRID, String subID) throws BizException {
		GetPatIpNmrListBP getIpNmrBP = new GetPatIpNmrListBP();
		return getIpNmrBP.exec(patientHRID, subID);
	}
	
	/**
	 * 获取患者体温单自定义项目列表
	 * 
	 * @param p_id患者id
	 * @param visit_id在院次数
	 * @return
	 * @throws BizException
	 */
	@Override
	public  GetZdTemperatureDisplayColumnResponse getZDTemperatureDisplayColumn(String p_id, String visit_id) throws BizException
	{
		GetVsInfoByEntBP bp = new GetVsInfoByEntBP();
		GetNursingRecordOfPatientHRRequest nursingRecordOfPatientHRRequest=new GetNursingRecordOfPatientHRRequest();
		nursingRecordOfPatientHRRequest.setPatientHRID(p_id);
		nursingRecordOfPatientHRRequest.setSubID(visit_id);
		nursingRecordOfPatientHRRequest.setDepartmentID(p_id);
		GetNursingRecordOfPatientHRResponse getNursingRecordOfPatientHRResponse= bp.exec(nursingRecordOfPatientHRRequest);
		
		ArrayOfDCZdTemperatureDisplayColumn arrayOfDCZdTemperatureDisplayColumn=new ArrayOfDCZdTemperatureDisplayColumn();
		List<DCZdTemperatureDisplayColumn> dcZdTemperatureDisplayColumns=new ArrayList<>();
		
		//arrayOfDCZdTemperatureDisplayColumn.setDCZdTemperatureDisplayColumn(DCZdTemperatureDisplayColumn);
		
		
		if(getNursingRecordOfPatientHRResponse!=null && getNursingRecordOfPatientHRResponse.getGetNursingRecordOfPatientHRResult()!=null && getNursingRecordOfPatientHRResponse.getGetNursingRecordOfPatientHRResult().getDCNursingRecordFile().length>0)
		{
			
			for (DCNursingRecord dcNursingRecord : getNursingRecordOfPatientHRResponse.getGetNursingRecordOfPatientHRResult().getDCNursingRecordFile()[0].getNurseingRecordList().getDCNursingRecord()) {
				if(dcNursingRecord.getItemList().getDCNursingRecordItem().length>0)
				{
					//对每一行处理，判断是否为自定义项；如果是的话就把这一行作为字典输出；
					for(DCNursingRecordItem dcNursingRecordItem : dcNursingRecord.getItemList().getDCNursingRecordItem())
					{
						if(dcNursingRecordItem.getValueFlag()=="Y" )
						{
							Boolean flagIn=false;
							for(DCZdTemperatureDisplayColumn dczdtdc: dcZdTemperatureDisplayColumns)
							{
								if(dczdtdc.getColumn_name()==dcNursingRecordItem.getTypeName())
								{
									flagIn=true;
									break;
								}
							}
							if(flagIn==false)
							{
							DCZdTemperatureDisplayColumn dcZdTemperatureDisplayColumn=new DCZdTemperatureDisplayColumn();
							dcZdTemperatureDisplayColumn.setColumn_idex(String.valueOf(dcZdTemperatureDisplayColumns.size()));//顺序
							dcZdTemperatureDisplayColumn.setColumn_name(dcNursingRecordItem.getTypeName());//列名
							dcZdTemperatureDisplayColumn.setDatasource("");
							dcZdTemperatureDisplayColumn.setDeleted_flag("");
							dcZdTemperatureDisplayColumn.setDept_code("");
							dcZdTemperatureDisplayColumn.setEnter_date(dcNursingRecordItem.getSaveTime());
							dcZdTemperatureDisplayColumn.setFrequency("2");//分隔数
							dcZdTemperatureDisplayColumn.setGroup_no("");//组号
							dcZdTemperatureDisplayColumn.setGroup_no_idex("");//组内顺序
							dcZdTemperatureDisplayColumn.setIs_horizontal("1");//是否横向
							dcZdTemperatureDisplayColumn.setPatient_id(dcNursingRecordItem.getPatientID());//病人id
							dcZdTemperatureDisplayColumn.setTable_name("");
							dcZdTemperatureDisplayColumn.setUnit_name(dcNursingRecordItem.getValueUnit());//单位
							dcZdTemperatureDisplayColumn.setVisit_id(dcNursingRecordItem.getVisitID());//住院次数
							dcZdTemperatureDisplayColumn.setWard_code("");
							
							dcZdTemperatureDisplayColumns.add(dcZdTemperatureDisplayColumn);
							}
							
						}
						
					}
				}
			}
			arrayOfDCZdTemperatureDisplayColumn.setDCZdTemperatureDisplayColumn((DCZdTemperatureDisplayColumn[]) dcZdTemperatureDisplayColumns.toArray(new DCZdTemperatureDisplayColumn[dcZdTemperatureDisplayColumns.size()]));
			
		}
		GetZdTemperatureDisplayColumnResponse getZdTemperatureDisplayColumnResponse=new GetZdTemperatureDisplayColumnResponse();
		getZdTemperatureDisplayColumnResponse.setGetZdTemperatureDisplayColumnResult(arrayOfDCZdTemperatureDisplayColumn);
		return getZdTemperatureDisplayColumnResponse;
	
	}
	
}
