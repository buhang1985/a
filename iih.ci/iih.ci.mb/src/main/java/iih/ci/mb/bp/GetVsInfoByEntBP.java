package iih.ci.mb.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.ci.mb.i.ArrayOfDCNursingRecord;
import iih.ci.mb.i.ArrayOfDCNursingRecordFile;
import iih.ci.mb.i.ArrayOfDCNursingRecordItem;
import iih.ci.mb.i.DCNursingRecord;
import iih.ci.mb.i.DCNursingRecordFile;
import iih.ci.mb.i.DCNursingRecordItem;
import iih.ci.mb.i.DCPatientHospitalRecord;
import iih.ci.mb.i.GetNursingRecordOfPatientHRRequest;
import iih.ci.mb.i.GetNursingRecordOfPatientHRResponse;
import iih.ci.mb.i.NDCNursingRecordFile;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mp.mb.IMpMbQueryService;

import iih.mp.mb.i.ArrayOfNDCVitalSignNode;
import iih.mp.mb.i.GetPatientInfoByPIDResponse;
import iih.mp.mb.i.GetVitalSignOfPatientHRAtTimePointRequest;
import iih.mp.mb.i.GetVitalSignOfPatientHRAtTimePointResponse;
import iih.mp.mb.i.GetYjjAndFeeOfPatientHRResponse;
import iih.mp.mb.i.NDCNursingRecordItem;
import iih.mp.mb.i.NDCVitalSignNode;
import iih.mp.mb.keyboard.d.KeyBoardDO;
import iih.mp.mb.keyboard.i.IKeyboardMDORService;

import iih.mp.mpbd.dto.vstmatch.d.VstmatchparanDTO;
import iih.mp.mpbd.i.IMpBdQueryService;
import iih.mp.nr.i.IMpNrQueryService;
import iih.mp.nr.temperaturechart.d.Temchartpatdto;
import iih.mp.nr.temperaturechart.d.TemperatureChartDTO;
import iih.mp.nr.vitalsign.d.VitalSignRecordDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者体温单记录
 * 
 * @author wangwei
 * @since 2018-03-14
 *
 */
public class GetVsInfoByEntBP {
	/**
	 * 获取体征数据
	 * 
	 * @param request
	 * @return
	 * @throws BizException
	 */
	public GetNursingRecordOfPatientHRResponse exec(GetNursingRecordOfPatientHRRequest request) throws BizException {

		// 2、参数校验
		if (!validation(request))
			return null;

		DCPatientHospitalRecord patientInfo = getPatIp(request.getPatientHRID());

		// 3、查询体征信息
		DCNursingRecordItem[] nursingRecordItems = queryData(patientInfo.getSubID(), patientInfo.getEnterDate(),
				patientInfo.getExitDate());

		// 4、数据组装
		GetNursingRecordOfPatientHRResponse rtn = getRtnData(nursingRecordItems, request);

		return rtn;
	}

	/**
	 * 获取患者住院记录
	 * 
	 * @param patId
	 *            患者ID
	 * @return 住院记录集合
	 * @throws BizException
	 */
	private DCPatientHospitalRecord getPatIp(String patId) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_PAT AS ID,");
		sqlBuilder.append("ENT.NAME_PAT AS NAME,");
		sqlBuilder.append("ENT.CODE AS HID,");

		sqlBuilder.append("ENT.ID_ENT AS SUBID,");
		sqlBuilder.append("ENT.ID_HP AS MEDICALINSURANCEID,");

		sqlBuilder.append("ENT.SD_SEX_PAT AS SEX,");
		sqlBuilder.append("ENT.ADDR_PAT AS ADDRESS,");
		sqlBuilder.append("ENT.TELNO_PAT AS PHONE,");
		sqlBuilder.append("ENT.DT_ENTRY AS ENTERDATE,");
		sqlBuilder.append("ENT.DT_END AS EXITDATE,");
		sqlBuilder.append("DEPT.CODE AS DEPTCODE,");
		sqlBuilder.append("DEPT.NAME AS DEPTNAME");
		sqlBuilder.append(" FROM EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT=ENT.ID_ENT");
		sqlBuilder.append(" LEFT JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEPT ON DEPT.ID_DEP = ENT.ID_DEP_PHY");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC COUNTRY ON COUNTRY.ID_UDIDOC=PAT.ID_COUNTRY");
		sqlBuilder.append(" LEFT JOIN EN_ENT_CONT CONT ON CONT.ID_ENT=ENT.ID_ENT AND CONT.EU_ENTCONTTP='1'");
		sqlBuilder.append(" WHERE ENT.FG_CANC='N' AND ENT.CODE_ENTP='10' ");
		sqlBuilder.append(" AND IP.code_amr_ip=? ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		List<DCPatientHospitalRecord> ipRecordList = (List<DCPatientHospitalRecord>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(DCPatientHospitalRecord.class));
		if (!ListUtil.isEmpty(ipRecordList)) {
			return ipRecordList.toArray(new DCPatientHospitalRecord[0])[0];
		} else {
			return null;
		}

	}

	/**
	 * 参数校验
	 * 
	 * @param request
	 * @return
	 */
	private boolean validation(GetNursingRecordOfPatientHRRequest request) {
		if (request == null)
			return false;
		// 就诊id
		if (StringUtil.isEmptyWithTrim(request.getPatientHRID()))
			return false;
		// 部门编码
		if (StringUtil.isEmptyWithTrim(request.getSubID()))
			return false;
		// 时间点
		if (StringUtil.isEmptyWithTrim(request.getDepartmentID()))
			return false;
		return true;
	}

	/**
	 * 查询体征信息
	 * 
	 * @param id_ent
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	private DCNursingRecordItem[] queryData(String id_ent, String dt_begin, String dt_end) throws BizException {

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select ID_ENT as ID,");
		sqlBuilder.append("ID_ENT as PatientID,");
		sqlBuilder.append("DT_VT as CreateTime,");
		sqlBuilder.append("ID_DEP_PHY,");
		sqlBuilder.append("ID_DEP_NUR as DepartmentName,");
		sqlBuilder.append("ID_EMP as Recorder,");
		sqlBuilder.append("DT_OPER as SaveTime ,");
		sqlBuilder.append("(case c.NAME when '血糖(mmol/L)' then '血糖'  when '体重(KG)' then '体重' else c.Name end)  as RecordType,VALUE as Value,");
		sqlBuilder.append("(case c.NAME when '血糖(mmol/L)' then '血糖'  when '体重(KG)' then '体重' else c.Name end)  AS TypeName,");
		sqlBuilder.append("d.fg_custom as ValueFlag");
		sqlBuilder.append(" from ci_mr_vs a");
		sqlBuilder.append(" inner join ci_mr_vs_itm b on a.ID_MR_VS=b.ID_MR_VS");
		sqlBuilder.append(" left join bd_mrtpl_vs_itm c on b.ID_SRV=c.ID_SRV ");
		sqlBuilder.append(" left join bd_mrtpl_vs d on c.id_mrtpl_vs = d.id_mrtpl_vs"); 
		sqlBuilder.append(" where d.fg_custom = 'Y' and a.ID_ENT=?");
    
		sqlBuilder.append(" union select ID_ENT as ID,");
		sqlBuilder.append("ID_ENT as PatientID,");
		sqlBuilder.append("DT_VT as CreateTime,");
		sqlBuilder.append("ID_DEP_PHY,");
		sqlBuilder.append("ID_DEP_NUR as DepartmentName,");
		sqlBuilder.append("ID_EMP as Recorder,");
		sqlBuilder.append("DT_OPER as SaveTime ,");
		sqlBuilder.append("(case c.NAME when '大便次' then '大便次数'  when '体重(KG)' then '体重' else c.Name end)  as RecordType,VALUE as Value,");
		sqlBuilder.append("(case c.NAME when '大便次' then '大便次数'  when '体重(KG)' then '体重' else c.Name end)  AS TypeName,");
		sqlBuilder.append("'N' as ValueFlag");
		sqlBuilder.append(" from ci_mr_vs a,");
		sqlBuilder.append("ci_mr_vs_itm b");
		sqlBuilder.append(" left join bd_mrtpl_vs_itm c on b.ID_SRV=c.ID_SRV and b.ID_MRTPL_VS=c.ID_MRTPL_VS and b.ID_MRTPL_VST=c.ID_MRTPL_VST and b.ID_MRTPL_VS_ITM=c.ID_MRTPL_VS_ITM");
		sqlBuilder.append(" where a.ID_ENT=? ");
		sqlBuilder.append(" and  c.NAME <>'高压' and c.NAME<>'低压'");
		sqlBuilder.append(" and a.ID_MR_VS=b.ID_MR_VS");
		

		sqlBuilder.append(" union select ID_ENT as ID,ID_ENT as PatientID,");
		sqlBuilder.append(" DT_VT as CreateTime,ID_DEP_PHY,ID_DEP_NUR as DepartmentName,ID_EMP as Recorder,'' as SaveTime ,");
		sqlBuilder.append(" '血压' as RecordType,");
		sqlBuilder.append(" LISTAGG(value, '/') within group(order by value asc) as Value,");
		sqlBuilder.append(" '血压' AS TypeName,");
		sqlBuilder.append("'N' as ValueFlag");
		sqlBuilder.append(" from ci_mr_vs a,");
		sqlBuilder.append(" ci_mr_vs_itm b");
		sqlBuilder.append(" left join bd_mrtpl_vs_itm c on b.ID_SRV=c.ID_SRV and b.ID_MRTPL_VS=c.ID_MRTPL_VS and b.ID_MRTPL_VST=c.ID_MRTPL_VST and b.ID_MRTPL_VS_ITM=c.ID_MRTPL_VS_ITM");
		sqlBuilder.append(" where a.ID_ENT=?");
		sqlBuilder.append(" and ( c.NAME ='高压' or c.NAME='低压')");
		sqlBuilder.append(" and a.ID_MR_VS=b.ID_MR_VS");
		sqlBuilder.append(" group by ID_ENT ,ID_ENT ,DT_VT,ID_DEP_PHY,ID_DEP_NUR ,ID_EMP");
		sqlBuilder.append(" order by CreateTime");

		SqlParam param = new SqlParam();
		
		param.addParam(id_ent);
		param.addParam(id_ent);
		param.addParam(id_ent);
		
		List<DCNursingRecordItem> nursingRecordList = (List<DCNursingRecordItem>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(DCNursingRecordItem.class));
		if (!ListUtil.isEmpty(nursingRecordList)) {
			return nursingRecordList.toArray(new DCNursingRecordItem[0]);
		} else {
			return null;
		}

	}

	/**
	 * 转换成移动护理所需结构
	 * 
	 * @param ciMrVsDOs
	 * @param map
	 * @return
	 * @throws BizException
	 */
	private GetNursingRecordOfPatientHRResponse getRtnData(DCNursingRecordItem[] recordItemDTOs,
			GetNursingRecordOfPatientHRRequest request) throws BizException {
		GetNursingRecordOfPatientHRResponse response = new GetNursingRecordOfPatientHRResponse();
		ArrayOfDCNursingRecordFile arry = converToArrayOfDCNursingRecordFile(request);
		List<DCNursingRecordFile> recordFilds = converList(recordItemDTOs, request);

		arry.setDCNursingRecordFile(recordFilds.toArray(new DCNursingRecordFile[recordFilds.size()]));

		response.setGetNursingRecordOfPatientHRResult(arry);
		return response;
	}

	/**
	 * 数据转换
	 * 
	 * @param ciMrVsDO
	 * @return
	 * @throws BizException
	 */
	private ArrayOfDCNursingRecordFile converToArrayOfDCNursingRecordFile(GetNursingRecordOfPatientHRRequest request)
			throws BizException {
		IPativisitRService rService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = rService.findById(request.getPatientHRID());
		ArrayOfDCNursingRecordFile item = new ArrayOfDCNursingRecordFile();

		return item;
	}

	/**
	 * 体征测量值 转换 0001Z7100000000EZCIP 高压 0001Z7100000000EZCGC 脉搏
	 * 1001Z8100000000VOFUC 引流量 1001Z7100000000VOJVL 尿量 1001Z81000000002FXGT
	 * 药物过敏 1001Z7100000000VOGWH 体温 0001Z7100000000EZCIJ 体温 1001Z7100000000VOEOV
	 * 24小时总入量 0001Z7100000000EZCGJ 呼吸 1001Z81000000004SPMW 事件
	 * 1001Z81000000003AC55 低压 1001Z71000000002CHOF 疼痛评分 0001Z7100000000EZCJ2 入量
	 * 1001Z8100000000VOFW3 输入液量 0001Z7100000000EZCHR 出量 0001Z7100000000EZCGV 心率
	 * 0001Z7100000000EZCI7 体重(KG) 0001Z7100000000EZCID 大便次 1001Z8100000000VOFYQ
	 * 体重(g) 1001Z810000000027JO5 黄疸(mg/dl)
	 * 
	 * @param itemdtoList
	 * @return
	 * @throws BizException
	 */
	private List<DCNursingRecordFile> converList(DCNursingRecordItem[] nursingRecordItems,
			GetNursingRecordOfPatientHRRequest request) throws BizException {
		List<DCNursingRecordFile> recordFiles = new ArrayList<DCNursingRecordFile>();
		DCNursingRecordFile recordFile = new DCNursingRecordFile();
		recordFile.setTitle("体温单");
		recordFile.setStartDateTime(request.getSubID());
		ArrayOfDCNursingRecord NurseingRecordList = new ArrayOfDCNursingRecord();
		DCNursingRecord nursingRecord = new DCNursingRecord();
		ArrayOfDCNursingRecordItem nursingRecordItemList = new ArrayOfDCNursingRecordItem();
		// DCNursingRecordItem[] nursingRecordItems=new
		// DCNursingRecordItem[]{nursingRecordItem};
		nursingRecordItemList.setDCNursingRecordItem(nursingRecordItems);
		nursingRecord.setItemList(nursingRecordItemList);
		DCNursingRecord[] nursingRecords = new DCNursingRecord[] { nursingRecord };
		NurseingRecordList.setDCNursingRecord(nursingRecords);
		recordFile.setNurseingRecordList(NurseingRecordList);
		recordFiles.add(recordFile);
		return recordFiles;
	}

	/**
	 * 获取体征模板id
	 * 
	 * @return
	 * @throws BizException
	 */
	private String getIdMrtplVst() throws BizException {
		IMpBdQueryService srv = ServiceFinder.find(IMpBdQueryService.class);
		VstmatchparanDTO vstmatchparan = initVstMatParam();
		BdMrtplVstDO[] mtplVsts = srv.getMrtplVsts(vstmatchparan);
		if (mtplVsts == null || mtplVsts.length < 1) {
			throw new BizException("获取体征模板失败！");
		}
		return mtplVsts[0].getId_mrtpl_vst();
	}

	/**
	 * 构造体征模板参数
	 * 
	 * @param vstmatchparan
	 * @throws BizException
	 */
	private VstmatchparanDTO initVstMatParam() throws BizException {
		VstmatchparanDTO vstmatchparan = new VstmatchparanDTO();
		vstmatchparan.setId_dep(Context.get().getDeptId());// 科室
		vstmatchparan.setCode_entp(IMpNsDictCodeConst.SD_ENTP_IN);// 就诊类型
		vstmatchparan.setFg_newborn(FBoolean.FALSE);// 新生儿标识
		vstmatchparan.setFun_code(IMpNsDictCodeConst.FUN_CODE_MOB_HL);// 节点编码
		vstmatchparan.setEu_sex(IMpNsDictCodeConst.EU_SEX_GENVERAL);// 性别编码
		return vstmatchparan;
	}
}
