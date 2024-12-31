package iih.ci.mb.bp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst.DoctorNur;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.mb.i.ArrayOfDCMedicalRecord;
import iih.ci.mb.i.DCMedicalRecord;
import iih.ci.mb.i.GetMedicalRecordsOfPatientHRResponse;
import iih.ci.mb.utils.FileUtils;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者住院病历
 * @author yankan
 * @since 2018-03-20
 *
 */
public class GetPatIpMrListBP {
	/**
	 * 获取患者住院病历
	 * @param patId 患者id
	 * @param ipTimes 住院次数
	 * @return 住院病历集合
	 * @throws BizException
	 * @throws IOException 
	 */
	public GetMedicalRecordsOfPatientHRResponse exec(String patId,String ipTimes) throws BizException {
		//参数校验
		ParamValidator.validateNotNull("患者ID", patId);
		ParamValidator.validateNotNull("住院次数", ipTimes);
		
		//1、获取住院病历集合
		DCMedicalRecord[] mrRcds = this.getIpMrList(patId, ipTimes);
		
		//2、设置URL
		int length = mrRcds==null ? 0 : mrRcds.length;
		for(int i=0;i<length;i++){
			String fileStr = mrRcds[i].getContent();			
			if(!StringUtil.isEmpty(fileStr)){
				fileStr = "http://"+FileUtils.getFileUrl(fileStr);
				mrRcds[i].setContent(fileStr);	
			}
		}
		
		//3、分组
		Map<String,List<DCMedicalRecord>> recordMap = this.group(mrRcds);
		
		//4、包装返回结果
		GetMedicalRecordsOfPatientHRResponse response = this.wrapResponse(recordMap);
		return response;
	}
	/**
	 * 获取住院病历集合
	 * @param patId 患者ID
	 * @param ipTimes 住院次数
	 * @return 病历集合
	 * @throws BizException
	 */
	private DCMedicalRecord[] getIpMrList(String patId,String ipTimes) throws BizException{
		StringBuilder sqlBuilder= new StringBuilder();
		sqlBuilder.append("SELECT MR.ID_MR AS ID,");
		sqlBuilder.append("MR.ID_PAT AS PATIENTID,");
		sqlBuilder.append("IP.TIMES_IP AS VISITID,");
		sqlBuilder.append("MR.NAME AS TITLE,");
		sqlBuilder.append("FI.CODE_FILE AS CONTENT,/*文件号*/");
		sqlBuilder.append("PSN.NAME AS CREATEDOCTORNAME,");
		sqlBuilder.append("MR.DT_RD AS CREATEDATETIME,");
		sqlBuilder.append("MR.DATE_SUBMIT AS FINISHDATETIME,");
		sqlBuilder.append("MRTP.SORTNO AS SORT,");
		sqlBuilder.append("MRTP.NAME AS GROUPKEY,");
		sqlBuilder.append("MRSTATE.NAME AS CURRENTSTATE");
		sqlBuilder.append(" FROM CI_MR MR");
		sqlBuilder.append(" LEFT JOIN CI_MRM_FI FI ON FI.ID_BU_SY=MR.ID_MR");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = MR.ID_ENT");
		sqlBuilder.append(" LEFT JOIN BD_MRTP MRTP ON MRTP.ID_MRTP=MR.ID_MRTP");
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC PSN ON PSN.ID_PSNDOC=MR.ID_DIR_DOCTOR");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC MRSTATE ON MRSTATE.ID_UDIDOC=MR.ID_SU_MR");
		sqlBuilder.append(" LEFT JOIN BD_MRCA_CTM CACTM ON CACTM.ID_MRCACTM = MR.ID_MRCACTM");
		sqlBuilder.append(" WHERE CACTM.DOCORNUR IN (?,?)");//住院病历
		sqlBuilder.append(" AND IP.CODE_AMR_IP=? AND IP.TIMES_IP=?");
		sqlBuilder.append(" AND "+BdEnvContextUtil.processEnvContext(new CiMrDO(), "MR"));// 增加多组织)
		sqlBuilder.append(" ORDER BY SORT");

		SqlParam param = new SqlParam();
		param.addParam(DoctorNur.doctor.getCode());
		param.addParam(DoctorNur.doctorNur.getCode());
		param.addParam(patId);
		param.addParam(ipTimes);
		
		List<DCMedicalRecord> mrRecordList = (List<DCMedicalRecord>)new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(DCMedicalRecord.class));
		if(!ListUtil.isEmpty(mrRecordList)){
			return mrRecordList.toArray(new DCMedicalRecord[0]);
		}else{
			return null;
		}				
	}
	/**
	 * 分组
	 * @param mrRcds
	 * @return
	 */
	private Map<String,List<DCMedicalRecord>> group(DCMedicalRecord[] mrRcds){
		int length = mrRcds==null ? 0 : mrRcds.length;
		Map<String,List<DCMedicalRecord>> recordMap = new HashMap<String,List<DCMedicalRecord>>();
		DCMedicalRecord record = null;
		for(int i=0;i<length;i++){
			record = mrRcds[i];
			List<DCMedicalRecord> recordList = recordMap.get(record.getGroupKey());
			if(recordList==null){
				recordList = new ArrayList<DCMedicalRecord>();
				recordMap.put(record.getGroupKey(), recordList);
			}
			recordList.add(record);
		}
		return recordMap;
	}
	/**
	 * 包装结果
	 * @param recordMap
	 * @return
	 */
	private GetMedicalRecordsOfPatientHRResponse wrapResponse(Map<String,List<DCMedicalRecord>> recordMap){
		GetMedicalRecordsOfPatientHRResponse response = new GetMedicalRecordsOfPatientHRResponse();
		ArrayOfDCMedicalRecord recordArray = new ArrayOfDCMedicalRecord();
		List<DCMedicalRecord> groupRecordList = new ArrayList<DCMedicalRecord>();
		for(Entry<String,List<DCMedicalRecord>> entry : recordMap.entrySet()){
			DCMedicalRecord groupRecord = new DCMedicalRecord();
			groupRecord.setGroupKey(entry.getKey());
			groupRecord.setTitle(entry.getKey());
			ArrayOfDCMedicalRecord subRcdArray = new ArrayOfDCMedicalRecord();
			subRcdArray.setDCMedicalRecord(entry.getValue().toArray(new DCMedicalRecord[0]));
			groupRecord.setSubMedicalRecord(subRcdArray);
			groupRecordList.add(groupRecord);			
		}
		recordArray.setDCMedicalRecord(groupRecordList.toArray(new DCMedicalRecord[0]));		
		response.setGetMedicalRecordsOfPatientHRResult(recordArray);
		return response;
	}
}
