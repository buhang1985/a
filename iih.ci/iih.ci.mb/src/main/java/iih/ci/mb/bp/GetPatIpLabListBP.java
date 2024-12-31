package iih.ci.mb.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IMpNsDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.mb.i.ArrayOfDCPatientTest;
import iih.ci.mb.i.ArrayOfDCPatientTestItem;
import iih.ci.mb.i.DCPatientTest;
import iih.ci.mb.i.DCPatientTestItem;
import iih.ci.mb.i.GetTestOfPatientHRResponse;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.mp.nr.mpnelabsamptra.d.MpnelabsampTraDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者住院检验集合
 * @author yankan
 * @since 2018-03-20
 *
 */
public class GetPatIpLabListBP {
	/**
	 * 获取患者住院检验
	 * @param entId 就诊ID
	 * @return 住院检验集合
	 * @throws BizException
	 * @author yankan
	 */
	public GetTestOfPatientHRResponse exec(String entId) throws BizException{
		ParamValidator.validateNotNull("就诊ID", entId);
		
		//1、查询住院检验
		DCPatientTest[] labArray = this.getIpLabList(entId);
		if(ArrayUtil.isEmpty(labArray)) {
			return new GetTestOfPatientHRResponse();		
		}
		
		//2、查询检验项目
		this.loadRptItems(labArray);
		
		//3、加载执行信息
		this.loadMpInfo(labArray);
		
		//3、包装返回值
		GetTestOfPatientHRResponse response = new GetTestOfPatientHRResponse();
		ArrayOfDCPatientTest testArray = new ArrayOfDCPatientTest();
		testArray.setDCPatientTest(labArray);		
		response.setGetTestOfPatientHRResult(testArray);
		return response;
	}
	/**
	 * 获取患者住院检验
	 * @param patId
	 * @param ipTimes
	 * @return
	 * @throws BizException
	 */
	private DCPatientTest[] getIpLabList(String entId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT IP.ID_ENT AS PATIENTVISITID,");
		sqlBuilder.append("ORD.ID_PAT AS PATIENTID,");
		sqlBuilder.append("PAT.NAME AS PATIENTNAME,");
		sqlBuilder.append("PAT.PYCODE AS PATIENTNAMEPHONETIC,");
		sqlBuilder.append("PAT.DT_BIRTH AS PATIENTDATEOFBIRTH,");
		sqlBuilder.append("SEX.NAME AS PATIENTSEX,");
		sqlBuilder.append("IP.NAME_BED AS BEDNO,/*床号*/");	
		sqlBuilder.append("AP.NO_APPLYFORM AS ID,");
		sqlBuilder.append("SRV.NAME AS CONTENT,");
		sqlBuilder.append("ID_RPTLAB AS TESTID,");
		sqlBuilder.append("ORD.ID_OR AS ORID,");//医嘱ID
		sqlBuilder.append("ORD.DT_EFFE AS APPLYDATE,");/*申请日期*/
		sqlBuilder.append("DOC.NAME AS APPLYDOCTOR,");//申请医生
		sqlBuilder.append("RPTDOC.NAME AS REPORTDOCTORNAME,");//报告医生
		sqlBuilder.append("VERIFYDOC.NAME AS VERIFYPERSONNAME,");//检验医生
		sqlBuilder.append("DEP.CODE AS DEPTCODE,");		
		sqlBuilder.append("LAB.DT_RPTLAB AS REPORTDATE,");/*报告日期*/			
		sqlBuilder.append("SAMPLE.NAME AS SAMPLE,");/*标本名称*/
		sqlBuilder.append("CASE WHEN LAB.DT_RPTLAB IS NULL THEN '0' ELSE '1' END  AS STATE");
		sqlBuilder.append(" FROM CI_AP_LAB AP");
		sqlBuilder.append(" LEFT JOIN CI_RPT_LAB LAB ON LAB.ID_ORLAB=AP.ID_ORLAB");
		sqlBuilder.append(" LEFT JOIN CI_ORDER ORD ON ORD.ID_OR=AP.ID_OR");
		sqlBuilder.append(" LEFT JOIN BD_SRV SRV ON SRV.ID_SRV=ORD.ID_SRV");
		sqlBuilder.append(" LEFT JOIN EN_ENT_IP IP ON IP.ID_ENT=ORD.ID_EN");
		sqlBuilder.append(" LEFT JOIN PI_PAT PAT ON PAT.ID_PAT=ORD.ID_PAT");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC=PAT.ID_SEX");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC SAMPLE ON SAMPLE.ID_UDIDOC=AP.ID_SAMPTP");
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=ORD.ID_EMP_SIGN");
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC RPTDOC ON RPTDOC.ID_PSNDOC=LAB.ID_EMP");
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC VERIFYDOC ON VERIFYDOC.ID_PSNDOC=LAB.ID_EMP_VERIFY");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP=LAB.ID_DEP");
		sqlBuilder.append(" WHERE IP.ID_ENT=?");
		sqlBuilder.append(" AND "+BdEnvContextUtil.processEnvContext(new OrdApLabDO(), "AP"));// 增加多组织)
		
		SqlParam param = new SqlParam();
		param.addParam(entId);
		
		List<DCPatientTest> labList = (List<DCPatientTest>)new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(DCPatientTest.class));
		if(ListUtil.isEmpty(labList)){
			return null;
		}else{			
			return  labList.toArray(new DCPatientTest[0]);
		}		
	}
	/**
	 * 加载报告项目
	 * @param labArray
	 * @throws BizException
	 */
	private void loadRptItems(DCPatientTest[] labArray) throws BizException{
		List<String> rptIdList = new ArrayList<String>();
		for(DCPatientTest lab : labArray){
			if(!StringUtil.isEmpty(lab.getTestID())){
				rptIdList.add(lab.getTestID());
			}
		}		
		Map<String,List<DCPatientTestItem>> itemMap = this.getLabItmList(rptIdList);		
		for(DCPatientTest lab : labArray){
			//年龄赋值
			lab.setPatientAge(AgeCalcUtil.getAge(new FDate(lab.getPatientDateOfBirth())));
			//绑定项目
			List<DCPatientTestItem> itemList = itemMap.get(lab.getID());
			if(!ListUtil.isEmpty(itemList)){
				ArrayOfDCPatientTestItem itemArray = new ArrayOfDCPatientTestItem();
				itemArray.setDCPatientTestItem(itemList.toArray(new DCPatientTestItem[0]));
				lab.setTestItemList(itemArray);
			}
		}
	}
	/**
	 * 获取检验报告项目
	 * @param labRptIdList 检验报告ID集合
	 * @return 检验项目Map
	 * @throws BizException
	 */
	private Map<String,List<DCPatientTestItem>> getLabItmList(List<String> labRptIdList) throws BizException{
		Map<String,List<DCPatientTestItem>> itemMap = new HashMap<String,List<DCPatientTestItem>>();
		if(ListUtil.isEmpty(labRptIdList)){
			return itemMap;
		}		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT SORTNO AS ITEMNO,");
		sqlBuilder.append("SRV.CODE AS ITEMCODE,");
		sqlBuilder.append("NAME_SRV AS PROJECTNAME,");
		sqlBuilder.append("LAB.NO_APPLYFORM AS ID,");
		sqlBuilder.append("LABITM.VAL_RSTRPTLAB AS REUSLTVALUE,");
		sqlBuilder.append("replace(LABITM.REFERENCE_RANGES,'--','~') AS REFERENCENORMAL,");//NAME_UNIT,REFERENCE_RANGES
		sqlBuilder.append("LABITM.NAME_UNIT AS UNIT,");
		sqlBuilder.append("(case udidoc.Name when '正常' then '' else udidoc.Name end)  AS Result");
		sqlBuilder.append(" FROM CI_RPT_LAB_ITM LABITM");
		sqlBuilder.append(" LEFT JOIN CI_RPT_LAB LAB ON LAB.ID_RPTLAB=LABITM.ID_RPTLAB");
		sqlBuilder.append(" LEFT JOIN BD_SRV SRV ON SRV.ID_SRV=LABITM.ID_SRV");
		sqlBuilder.append(" LEFT JOIN bd_udidoc udidoc ON LABITM.ID_VAL_STATE=udidoc.id_udidoc and udidoc.ID_UDIDOCLIST='@@@@TL400000000000ST'");
		
		sqlBuilder.append(" WHERE 1=1 AND ");
		sqlBuilder.append(SqlUtils.getInSqlByIds("LABITM.ID_RPTLAB",labRptIdList));
		
		List<DCPatientTestItem> itmList = (List<DCPatientTestItem>)new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(DCPatientTestItem.class));
		if(!ListUtil.isEmpty(itmList)){
			for(DCPatientTestItem item : itmList){
				List<DCPatientTestItem> itemList = itemMap.get(item.getID());
				if(itemList==null){
					itemList = new ArrayList<DCPatientTestItem>();
					itemMap.put(item.getID(), itemList);
				}
				itemList.add(item);
			}			
		}
		return itemMap;
	}
	/**
	 * 加载执行信息
	 * @param labArray
	 */
	private void loadMpInfo(DCPatientTest[] labArray) throws BizException{
		if(ArrayUtil.isEmpty(labArray)){
			return;
		}
		List<String> orIdList = new ArrayList<String>();
		for(DCPatientTest lab : labArray){
			orIdList.add(lab.getOrId());
		}
		Map<String, MpnelabsampTraDO> mpTraceMap = this.getOrMpTraceList(orIdList);
		if(mpTraceMap.isEmpty()){
			return;
		}
		for (DCPatientTest lab : labArray) {
			MpnelabsampTraDO traceDO = mpTraceMap.get(lab.getOrId());
			if (traceDO != null) {
				lab.setSendDateTime(traceDO.getDt_mp() == null ? "" : traceDO.getDt_mp().toStdString());// 采集时间
			}
		}	
	}
	/**
	 * 获取医嘱送检时间
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, MpnelabsampTraDO> getOrMpTraceList(List<String> orIdList) throws BizException {
		Map<String, MpnelabsampTraDO> map = new HashMap<String, MpnelabsampTraDO>();
		if (ListUtil.isEmpty(orIdList)) {
			return map;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ORD.ID_OR AS ID_LABSAMPTRA,");
		sqlBuilder.append("TRA.DT_MP");
		sqlBuilder.append(" FROM CI_ORDER ORD");
		sqlBuilder.append(" LEFT JOIN MP_OR_PR PR ON PR.ID_OR=ORD.ID_OR");
		sqlBuilder.append(" LEFT JOIN MP_NE_LAB_SAMP_ITM_REF SAMREF ON SAMREF.ID_OR_PR=PR.ID_OR_PR");
		sqlBuilder.append(" LEFT JOIN MP_NE_LAB_SAMP SAMP ON SAMP.ID_LABSAMP=SAMREF.ID_LABSAMP");
		sqlBuilder.append(" LEFT JOIN MP_NE_LAB_SAMP_TRA TRA ON TRA.ID_LABSAMP=SAMP.ID_LABSAMP");
		sqlBuilder.append(" WHERE 1=1  ");
		sqlBuilder.append(" AND TRA.ID_ORPLTPSTA=?");
		sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds("ORD.ID_OR", orIdList));

		SqlParam param = new SqlParam();
		//param.addParam(IMpNsDictCodeConst.ID_ORPLTPSTA_TESTCOLLECTION);
		List<MpnelabsampTraDO> traceList = (List<MpnelabsampTraDO>) new DAFacade().execQuery(sqlBuilder.toString(),
				param, new BeanListHandler(MpnelabsampTraDO.class));
		if (!ListUtil.isEmpty(traceList)) {
			for (MpnelabsampTraDO traDO : traceList) {
				map.put(traDO.getId_labsamptra(), traDO);
			}
		}

		return map;
	}
	
}
