package iih.ci.ord.rationaluse.meikang.s;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.rationaluse.meikang.i.IMKRationalUseOpPatInfoService;
import iih.ci.ord.rationaluse.meikang.s.qry.MKRationalUseQrySqlConst;
import iih.syn.sci.i.ISynCIMainteanceService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 美康门诊接口查询
 * 
 * @author zhangwq
 *
 */
@Service(serviceInterfaces = { IMKRationalUseOpPatInfoService.class }, binding = Binding.JSONRPC)
public class MKRationalUseOpPatInfoServiceImpl implements IMKRationalUseOpPatInfoService {

	@Override
	public String MzPatientList(String startdate, String enddate) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(startdate);
		param.addParam(enddate);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZPATIENTLIST, param));
	}

	@Override
	public String MzPatient(String hiscode, String patientid, String visitid) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(visitid);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZPATIENT, param));
	}

	@Override
	public String MzPresc(String hiscode, String patientid, String clinicno) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		param.addParam(clinicno);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZPRESC, param));
	}

	@Override
	public String MzOrders(String hiscode, String patientid, String clinicno) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(clinicno);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZORDERS, param));
	}

	@Override
	public String MzAllergen(String hiscode, String patientid, String clinicno) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZALLERGEN, param));
	}

	@Override
	public String MzDisease(String hiscode, String patientid, String clinicno) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZDISEASE, param));
	}

	@Override
	public String MzCost(String hiscode, String patientid, String clinicno) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZCOST, param));
	}

	@Override
	public String MzLab(String hiscode, String patientid, String clinicno) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZLAB, param));
	}

	@Override
	public String MzExam(String hiscode, String patientid, String clinicno) throws BizException {
		// 因为检查使用pacs系统，需要先调用次接口取回数据
		ServiceFinder.find(ISynCIMainteanceService.class).getObsRptInfo(patientid);
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		param.addParam(clinicno);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZEXAM, param));
	}

	@Override
	public String MzPatientList_Orgcode(String startdate, String enddate, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(startdate);
		param.addParam(enddate);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZPATIENTLIST_NEW, param));
	}

	@Override
	public String MzPatient_Orgcode(String hiscode, String patientid, String visitid, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(visitid);
		param.addParam(orgcode);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZPATIENT_NEW, param));
	}

	@Override
	public String MzPresc_Orgcode(String hiscode, String patientid, String clinicno, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		param.addParam(clinicno);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZPRESC_NEW, param));
	}

	@Override
	public String MzOrders_Orgcode(String hiscode, String patientid, String clinicno, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(clinicno);
		param.addParam(orgcode);
		return CiOrdUtils
				.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZORDERS_NEW, param));
	}

	@Override
	public String MzAllergen_Orgcode(String hiscode, String patientid, String clinicno, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(patientid);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZALLERGEN_NEW, param));
	}

	@Override
	public String MzDisease_Orgcode(String hiscode, String patientid, String clinicno, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils
				.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZDISEASE_NEW, param));
	}

	@Override
	public String MzCost_Orgcode(String hiscode, String patientid, String clinicno, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZCOST_NEW, param));
	}

	@Override
	public String MzLab_Orgcode(String hiscode, String patientid, String clinicno, String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZLAB_NEW, param));
	}

	@Override
	public String MzExam_Orgcode(String hiscode, String patientid, String clinicno, String orgcode) throws BizException {
		// 因为检查使用pacs系统，需要先调用次接口取回数据
		ServiceFinder.find(ISynCIMainteanceService.class).getObsRptInfo(patientid);
		SqlParam param = new SqlParam();
		param.addParam(clinicno);
		param.addParam(orgcode);
		param.addParam(clinicno);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(
				CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().MZEXAM_NEW, param));
	}

}
