package iih.ci.ord.rationaluse.meikang.s;

import java.util.List;
import java.util.Map;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.rationaluse.meikang.i.IMKRationalUseIpPatInfoService;
import iih.ci.ord.rationaluse.meikang.s.qry.MKRationalUseQrySqlConst;
import iih.syn.sci.i.ISynCIMainteanceService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author 张万青 美康 住院接口查询
 *
 */
@Service(serviceInterfaces = { IMKRationalUseIpPatInfoService.class }, binding = Binding.JSONRPC)
public class MKRationalUseIpPatInfoServiceImpl implements IMKRationalUseIpPatInfoService {

	@Override
	public String ZyPatientList(String startdate, String enddate) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(startdate);
		param.addParam(enddate);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYPATIENTLIST, param));
	}

	@Override
	public String ZyInPatientList() throws BizException {
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYINPATIENTLIST, null));
	}

	@Override
	public String ZyPatient(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(visitid);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYPATIENT, param));
	}

	@Override
	public String ZyOrders(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(visitid);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYORDERS, param));
	}

	@Override
	public String ZyAllergen(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYALLERGEN, param));
	}

	@Override
	public String ZyDisease(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYDISEASE, param));
	}

	@Override
	public String ZyCost(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYCOST, param));
	}

	@Override
	public String ZyOperation(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYOPERATION, param));
	}

	@Override
	public String ZyTemperature(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYTEMPERATURE, param));
	}

	@Override
	public String ZyLab(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYLAB, param));
	}

	@Override
	public String ZyExam(String hiscode, String patientid, String visitid) throws BizException {
		// 因为检查使用pacs系统，需要先调用次接口取回数据
		ServiceFinder.find(ISynCIMainteanceService.class).getObsRptInfo(patientid);
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(visitid);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYEXAM, param));
	}

	@Override
	public String ZyTransferred(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		List<Map<String, Object>> rstList = CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYTRANSFERRED, param);
		for (Map<String, Object> rstMap : rstList) {
			String dt_b = rstMap.get("admission_date_time") == null ? "" : (String) rstMap.get("admission_date_time");
			String dt_e = rstMap.get("discharge_date_time") == null ? "" : (String) rstMap.get("discharge_date_time");
			String id_ent = rstMap.get("id_ent") == null ? "" : (String) rstMap.get("id_ent");
			String empQrySql = "select code as doctor_in_charge from (select p.code from en_ent_emp emp "
					+ "left join bd_psndoc p on emp.id_emp = p.id_psndoc "
					+ " where emp.id_ent=? and emp.dt_b>=? and emp.dt_e <= ? "
					+ " order by emp.dt_e desc) where rownum=1 ";
			SqlParam empParam = new SqlParam();
			empParam.addParam(id_ent);
			empParam.addParam(dt_b);
			empParam.addParam(dt_e);
			Object rstObj = new DAFacade().execQuery(empQrySql, empParam, new ColumnHandler());
			if (!CiOrdUtils.isEmpty(rstObj)) {
				rstMap.put("doctor_in_charge", rstObj.toString());
			}
			if (rstMap.containsKey("id_ent")) {
				rstMap.remove("id_ent");
			}
		}
		return CiOrdUtils.MKQryInfoTransToXML(rstList);
	}

	@Override
	public String ZyPatientList_Orgcode(String startdate, String enddate, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(startdate);
		param.addParam(enddate);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYPATIENTLIST_NEW, param));
	}

	@Override
	public String ZyInPatientList_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYINPATIENTLIST_NEW, param));
	}

	@Override
	public String ZyPatient_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYPATIENT_NEW, param));
	}

	@Override
	public String ZyOrders_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYORDERS_NEW, param));
	}

	@Override
	public String ZyAllergen_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYALLERGEN_NEW, param));
	}

	@Override
	public String ZyDisease_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYDISEASE_NEW, param));
	}

	@Override
	public String ZyCost_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYCOST_NEW, param));
	}

	@Override
	public String ZyOperation_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYOPERATION_NEW, param));
	}

	@Override
	public String ZyTemperature_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYTEMPERATURE_NEW, param));
	}

	@Override
	public String ZyLab_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYLAB_NEW, param));
	}

	@Override
	public String ZyExam_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		// 因为检查使用pacs系统，需要先调用次接口取回数据
		ServiceFinder.find(ISynCIMainteanceService.class).getObsRptInfo(patientid);
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(orgcode);
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYEXAM_NEW, param));
	}

	@Override
	public String ZyTransferred_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(visitid);
		param.addParam(orgcode);
		List<Map<String, Object>> rstList = CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().ZYTRANSFERRED_NEW, param);
		for (Map<String, Object> rstMap : rstList) {
			String dt_b = rstMap.get("admission_date_time") == null ? "" : (String) rstMap.get("admission_date_time");
			String dt_e = rstMap.get("discharge_date_time") == null ? "" : (String) rstMap.get("discharge_date_time");
			String id_ent = rstMap.get("id_ent") == null ? "" : (String) rstMap.get("id_ent");
			String empQrySql = "select code as doctor_in_charge from (select p.code from en_ent_emp emp "
					+ "left join bd_psndoc p on emp.id_emp = p.id_psndoc "
					+ " where emp.id_ent=? and emp.dt_b>=? and emp.dt_e <= ? "
					+ " order by emp.dt_e desc) where rownum=1 ";
			SqlParam empParam = new SqlParam();
			empParam.addParam(id_ent);
			empParam.addParam(dt_b);
			empParam.addParam(dt_e);
			Object rstObj = new DAFacade().execQuery(empQrySql, empParam, new ColumnHandler());
			if (!CiOrdUtils.isEmpty(rstObj)) {
				rstMap.put("doctor_in_charge", rstObj.toString());
			}
			if (rstMap.containsKey("id_ent")) {
				rstMap.remove("id_ent");
			}
		}
		return CiOrdUtils.MKQryInfoTransToXML(rstList);
	}
}
