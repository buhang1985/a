package iih.ci.mr.s;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst.DoctorNur;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.i.IMrCaCtmItmDORService;
import iih.bd.srv.mrctmca.i.IMrctmcaMDORService;
import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import iih.bd.srv.mrtplsec.i.IMrtplsecRService;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrtplsegRService;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamCudService;
import iih.bd.srv.mrtplstream.i.IMrtplstreamRService;
import iih.bd.srv.preformat.d.MrPreFormatDO;
import iih.bd.srv.preformat.i.IPreformatRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.d.desc.CiMrDODesc;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrfs.i.ICimrfsCudService;
import iih.ci.mr.cimrfs.i.ICimrfsRService;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.cimrsource.i.ICimrsourceCudService;
import iih.ci.mr.cimrsource.i.ICimrsourceRService;
import iih.ci.mr.i.IOPMrService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueCudService;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.s.bp.CiMrFsBP;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoCudService;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.bd.BDCommonEventUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { IOPMrService.class }, binding = Binding.JSONRPC)
public class IOPMrServiceImpl implements IOPMrService {

	@Override
	public FArrayList2 SaveMr(MrDocRefValueDO[] mrDocRefValueDOs,
			CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException {
		IMrdocrefvalueCudService cudservice = ServiceFinder.find(IMrdocrefvalueCudService.class);
		IMrdocrefvalueRService rservice = ServiceFinder.find(IMrdocrefvalueRService.class);
		
		FArrayList2 fArrayList2 = new FArrayList2();
		ICiemrCudService iCiemrCudService = ServiceFinder.find(ICiemrCudService.class);
		Boolean b = (ciMrDO.getStatus() == 2);
		if (!b) {
			MrDocRefValueDO[] mrDocRefValueDOs_d = rservice.find("id_mr = '"
					+ ciMrDO.getId_mr() + "'", "", FBoolean.FALSE);
			if (mrDocRefValueDOs_d != null && mrDocRefValueDOs_d.length > 0) {
				cudservice.delete(mrDocRefValueDOs_d);
			}
		}
		if (mrDocRefValueDOs != null && mrDocRefValueDOs.length > 0) {
			if (mrDocRefValueDOs[0].getId_mr() == null || mrDocRefValueDOs[0].getId_mr().equals("")) {
				if (b) {
					for (MrDocRefValueDO mrDocRefValueDOc : mrDocRefValueDOs) {
						mrDocRefValueDOc.setId_mr(ciMrDO.getId_ent());
					}
				} else {
					for (MrDocRefValueDO mrDocRefValueDOc : mrDocRefValueDOs) {
						mrDocRefValueDOc.setId_mr(ciMrDO.getId_mr());
					}
				}
			}
			mrDocRefValueDOs = cudservice.save(mrDocRefValueDOs);
		}
		CiMrDO[] ciMrDOs = iCiemrCudService.save(new CiMrDO[] { ciMrDO });
		if (ciMrDOs != null && ciMrDOs.length > 0) {
			ciMrFsDO.setId_mr(ciMrDOs[0].getId_mr());
			CiMrFsBP ciMrFsBP = new CiMrFsBP();
			fArrayList2 = ciMrFsBP.SaveCiMrFsDO(ciMrDOs[0], ciMrFsDO);
			if (b) {
				MrDocRefValueDO[] mrDocRefValueDOs_u = rservice.find(
						"id_ent = '" + ciMrDO.getId_ent() + "'", "", FBoolean.FALSE);
				if (mrDocRefValueDOs_u != null && mrDocRefValueDOs_u.length > 0) {
					for (MrDocRefValueDO mrDocRefValueDOc : mrDocRefValueDOs_u) {
						mrDocRefValueDOc.setId_mr(ciMrDOs[0].getId_mr());
						mrDocRefValueDOc.setStatus(1);
					}
					cudservice.save(mrDocRefValueDOs_u);
				}
			}
			if (ciMrDO.getSd_su_mr().equals(ICiMrDictCodeConst.SD_SU_MR_SUBMIT)) {
				ICiemrRService iCiemrRService = ServiceFinder.find(ICiemrRService.class);
				CiMrDO[] ciMrDOsu = iCiemrRService.find(" id_ent = '"
						+ ciMrDOs[0].getId_ent() + "' and id_mr <> '"
						+ ciMrDOs[0].getId_mr() + "' and sd_su_mr = '"
						+ ICiMrDictCodeConst.SD_SU_MR_NEW + "'", "", FBoolean.FALSE);
				if (ciMrDOsu != null && ciMrDOsu.length > 0) {
					for (CiMrDO ciMrDOu : ciMrDOsu) {
						ciMrDOu.setStatus(1);
						ciMrDOu.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
						ciMrDOu.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
					}
					iCiemrCudService.save(ciMrDOsu);
				}
			}
		}
		return fArrayList2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public FArrayList2 GetDefaultMrPreFormats(String id_dept) throws BizException {
		IPreformatRService iPreformatCudService = ServiceFinder.find(IPreformatRService.class);
		IMrtplsecRService iMrtplsecRService = ServiceFinder.find(IMrtplsecRService.class);
		IMrtplsegRService iMrtplsegRService = ServiceFinder.find(IMrtplsegRService.class);

		FArrayList2 fArrayList2 = new FArrayList2();
		MrPreFormatDO[] preformatDOs = iPreformatCudService.find("id_dept = '"
				+ id_dept + "' and fg_active = 'Y'", "nu_sort asc", FBoolean.FALSE);
		if (preformatDOs == null || preformatDOs.length <= 0) {
			preformatDOs = iPreformatCudService.find("id_entp = '" + ICiMrDictCodeConst.ID_ENTP_MENZHEN
					+ "' and fg_active = 'Y'", "nu_sort asc", FBoolean.FALSE);
		}
		if (preformatDOs != null && preformatDOs.length > 0) {
			FArrayList fArrayList = new FArrayList();
			for (MrPreFormatDO mrPreFormatDO : preformatDOs) {
				fArrayList.add(mrPreFormatDO);
			}
			fArrayList2.add(fArrayList);
			ArrayList<String> ls = new ArrayList<String>();
			for (MrPreFormatDO mrPreFormatDO : preformatDOs) {
				if (!ls.contains(mrPreFormatDO.getId_mrtplsec())) {
					ls.add(mrPreFormatDO.getId_mrtplsec());
				}
			}
			MrTplSegFsDO[] mrTplSegFsDOs = 
					iMrtplsecRService.findByAttrValStrings("Id_mrtplsec", ls.toArray(new String[0]));
			if (mrTplSegFsDOs != null && mrTplSegFsDOs.length >= 0) {
				FArrayList fArrayListFs = new FArrayList();
				for (MrTplSegFsDO mrTplSegFsDO : mrTplSegFsDOs) {
					fArrayListFs.add(mrTplSegFsDO);
				}
				fArrayList2.add(fArrayListFs);
			}
			MrTplSegmentDO[] mrTplSegmentDOs = 
					iMrtplsegRService.findByIds(ls.toArray(new String[0]), FBoolean.FALSE);
			if (mrTplSegmentDOs != null && mrTplSegmentDOs.length >= 0) {
				FArrayList fArrayListSeg = new FArrayList();
				for (MrTplSegmentDO mrTplSegmentDO : mrTplSegmentDOs) {
					fArrayListSeg.add(mrTplSegmentDO);
				}
				fArrayList2.add(fArrayListSeg);
			}
		}
		return fArrayList2;
	}

	@Override
	public String GetIdMrctm(String id_mrtp, String code_entp) throws BizException {
		IMrCaCtmItmDORService iMrCaCtmItmDORService = ServiceFinder.find(IMrCaCtmItmDORService.class);
		MrCaCtmItmDO[] mrCaCtmItmDOs = iMrCaCtmItmDORService.findByAttrValString("Id_mrtp", id_mrtp);
		IMrctmcaMDORService iMrctmcaMDOCrudService = ServiceFinder.find(IMrctmcaMDORService.class);

		if (mrCaCtmItmDOs != null && mrCaCtmItmDOs.length > 0) {
			String[] strs = new String[mrCaCtmItmDOs.length];
			for (int i = 0; i < mrCaCtmItmDOs.length; i++) {
				strs[i] = mrCaCtmItmDOs[i].getId_mrcactm();
			}
			MrCtmCaDO[] mrCtmCaDOs = iMrctmcaMDOCrudService.findByIds(strs, FBoolean.FALSE);
			if (mrCtmCaDOs != null && mrCtmCaDOs.length > 0 && code_entp != null && !"".equals(code_entp)) {
				for (MrCtmCaDO mrCtmCaDO : mrCtmCaDOs) {
					if (code_entp.equals(mrCtmCaDO.getCode_entp()))
						return mrCtmCaDO.getId_mrcactm();
				}
			}
			return mrCaCtmItmDOs[0].getId_mrcactm();
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	@Override
	public FArrayList2 GetData(CiMrDO ciMrDO) throws BizException, IOException {
		IPatiMDORService iPatiMDORService = ServiceFinder.find(IPatiMDORService.class);
		IEmrtplMDORService iEmrtplMDORService = ServiceFinder.find(IEmrtplMDORService.class);

		FArrayList2 fArrayList2 = new FArrayList2();
		PatDO patDO = iPatiMDORService.findById(ciMrDO.getId_pat());
		fArrayList2.add(patDO);
		EmrTplDO emrTplDO = iEmrtplMDORService.findById(ciMrDO.getId_mrtpl());
		fArrayList2.add(emrTplDO);
		if (ciMrDO.getStatus() == ICiMrDictCodeConst.DOStatusNew) {
			IMrtplstreamRService iMrtplstreamRService = ServiceFinder.find(IMrtplstreamRService.class);
			EmrTplStreamDO[] emrTplStreamDOs = iMrtplstreamRService.find(
					"id_mrtpl ='" + ciMrDO.getId_mrtpl() + "'", "sv desc", FBoolean.FALSE);
			if (emrTplStreamDOs != null && emrTplStreamDOs.length > 0) {
				fArrayList2.add(emrTplStreamDOs[0]);
			}
		} else {
			CiMrFsBP ciMrFsBP = new CiMrFsBP();
			fArrayList2.add(ciMrFsBP.GetCiMrFsDO(ciMrDO));
		}
		if (ciMrDO != null) {
			String id_mrtp = GetBdSetCodeByMrtp(ciMrDO.getId_mrtp());
			fArrayList2.add(id_mrtp);
		}
		return fArrayList2;
	}

	public CiMrDO[] GetCiMrByIdEnt(String id_ent, String[] code_sets) throws BizException {
		if (code_sets != null && code_sets.length > 0) {
			DAFacade daf = new DAFacade();
			String codeStr = "( '";
			for (String code : code_sets) {
				codeStr += code + "',";
			}
			codeStr = codeStr.substring(0, codeStr.length() - 2) + "')";
			String sqlStr = "select mr.* from ci_mr  mr "
					+ "left join bd_mrtp mrtp on mr.id_mrtp = mrtp.id_mrtp left join bd_set on mrtp.id_data_set = bd_set.id_set "
					+ "where mr.id_ent = '" + id_ent + "' and bd_set.code in "
					+ codeStr;
			@SuppressWarnings("unchecked")
			java.util.List<CiMrDO> lstMrs = 
				(java.util.List<CiMrDO>) daf.execQuery(sqlStr, new BeanListHandler(CiMrDO.class));
			return lstMrs.toArray(new CiMrDO[0]);
		} else
			return null;
	}

	public String GetBdSetCodeByMrtp(String id_mrtp) throws BizException {
		String sql = "select bd_set.code code from bd_mrtp left join  bd_set on "
				+ "bd_mrtp.id_data_set = bd_set.id_set where bd_mrtp.id_mrtp = '" + id_mrtp + "'";
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		java.util.List<DeDataSetDO> lstMrs = 
			(java.util.List<DeDataSetDO>)daf.execQuery(sql, new BeanListHandler(DeDataSetDO.class));
		if (lstMrs != null && lstMrs.size() > 0) {
			return lstMrs.get(0).getCode();
		} else {
			return null;
		}
	}

	@Override
	public EmrTplDO SaveTplAs(EmrTplStreamDO emrTplStreamDo, EmrTplDO emrTplDo) throws BizException {
		/*
		 * IEmrtplMDORService iEmrtplMDORService =
		 * ServiceFinder.find(IEmrtplMDORService.class); EmrTplDO emrTpl =
		 * iEmrtplMDORService.findById(emrTplDo.getId_basemrtpl());
		 * if(emrTpl!=null){ emrTplDo.setId_basemrtpl(emrTpl.getId_basemrtpl());
		 * emrTplDo.setVer(emrTpl.getVer()); }else{ throw new
		 * BizException("基础模板被删除，无法另存"); }
		 */
		IEmrtplMDOCudService tplService = ServiceFinder.find(IEmrtplMDOCudService.class);
		EmrTplDO[] emrTplAggDos = tplService.save(new EmrTplDO[] { emrTplDo });
		DAFacade daf = new DAFacade();

		if (emrTplAggDos != null && emrTplAggDos.length > 0) {
			daf.execUpdate("update bd_mrtpl t set t.orderid = nvl(( select max(orderid) +1 from bd_mrtpl t where t.id_emp = '"
					+ emrTplAggDos[0].getId_emp() + "' and id_mrtp ='"
					+ emrTplAggDos[0].getId_mrtp() + "' ),1) where t.id_mrtpl='"
					+ emrTplAggDos[0].getId_mrtpl() + "'");
			emrTplStreamDo.setId_mrtpl(emrTplAggDos[0].getId_mrtpl());
			IMrtplstreamCudService services = ServiceFinder.find(IMrtplstreamCudService.class);
			services.save(new EmrTplStreamDO[] { emrTplStreamDo });
			return emrTplAggDos[0];
		}
		return emrTplDo;

	}

	@Override
	public void UpdateMrForce(CiMrDO ciMrDO) throws BizException {
		ICiemrRService service = ServiceFinder.find(ICiemrRService.class);
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		String sql = "update ci_mr cm set cm.id_su_mr='" + ciMrDO.getId_su_mr()
				+ "',cm.sd_su_mr='" + ciMrDO.getSd_su_mr() + "',"
				+ " cm.Id_emp_submit='" + ciMrDO.getId_emp_submit()
				+ "',cm.Id_submit_dept='" + ciMrDO.getId_submit_dept() + "',"
				+ " cm.Id_emp_audit='" + ciMrDO.getId_emp_audit()
				+ "',cm.Date_submit='" + ciMrDO.getDate_submit() + "' "
				+ " where cm.id_mr = '" + ciMrDO.getId_mr() + "'";

		daf.execUpdate(sql);
		CiMrDO upciMrDO = service.findById(ciMrDO.getId_mr());
		if (upciMrDO != null) {
			CiMrDO[] dos = new CiMrDO[] { upciMrDO };
			BDCommonEventUtil eventUtil = new BDCommonEventUtil(CiMrDODesc.CLASS_FULLNAME);
			eventUtil.dispatchUpdateAfterEvent((Object[]) dos);
		}
	}

	@Override
	public CiMrDO[] getCurrentEntAllCiMrList(String id_ent, String id_mrcactm) throws BizException {
		String sqlStr = "select mr.* from ci_mr  mr left join bd_mrca_ctm ctm on mr.id_mrcactm = ctm.id_mrcactm  where mr.ds ='0' and mr.id_ent = '"
				+ id_ent + "' and mr.id_mrcactm = '"
				+ id_mrcactm + "' and ctm.docornur in ( '"
				+ DoctorNur.doctorNur.getCode()
				+ "' , '" + DoctorNur.doctor.getCode() + "' )";
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		java.util.List<CiMrDO> lstMrs = 
			(java.util.List<CiMrDO>)daf.execQuery(sqlStr, new BeanListHandler(CiMrDO.class));
		return lstMrs.toArray(new CiMrDO[0]);
	}

	@Override
	public boolean deleteMr(CiMrDO[] ciMrDos) throws BizException {
		if (ciMrDos == null || ciMrDos.length <= 0) {
			return false;
		}
		// 服务定义
		ICiemrRService mrRService = ServiceFinder.find(ICiemrRService.class);
		ICiemrCudService mrCudService = ServiceFinder.find(ICiemrCudService.class);
		ICimrfsRService fsRService = ServiceFinder.find(ICimrfsRService.class);
		ICimrfsCudService fsCudService = ServiceFinder.find(ICimrfsCudService.class);
		ICimrmfileinfoRService fileRService = ServiceFinder.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService fileCudService = ServiceFinder.find(ICimrmfileinfoCudService.class);
		IMrdocrefvalueRService refRService = ServiceFinder.find(IMrdocrefvalueRService.class);
		IMrdocrefvalueCudService refCudService = ServiceFinder.find(IMrdocrefvalueCudService.class);
		ICimrsourceRService sourceRService = ServiceFinder.find(ICimrsourceRService.class);
		ICimrsourceCudService sourceCudService = ServiceFinder.find(ICimrsourceCudService.class);
		BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
		// 删除条件拼接
		StringBuilder mrSb = new StringBuilder();
		mrSb.append(" id_mr in (");
		for (CiMrDO ciMrDO : ciMrDos) {
			mrSb.append("'");
			mrSb.append(ciMrDO.getId_mr());
			mrSb.append("', ");
		}
		String mrSqlWhere = mrSb.toString().substring(0, mrSb.toString().length() - 2) + ") ";
		// 执行删除流程
		CiMrDO[] mrDOs = mrRService.find(mrSqlWhere, "", FBoolean.FALSE);
		mrCudService.delete(mrDOs);
		
		CiMrFsDO[] mrFsDOs = fsRService.find(mrSqlWhere, "", FBoolean.FALSE);
		fsCudService.delete(mrFsDOs);
		
		MrDocRefValueDO[] refValueDOs = refRService.find(mrSqlWhere, "", FBoolean.FALSE);
		refCudService.delete(refValueDOs);
		
		CiMrSourceDO[] sourceDOs = sourceRService.find(mrSqlWhere, "", FBoolean.FALSE);
		sourceCudService.delete(sourceDOs);
		
		mrSqlWhere = mrSqlWhere.replace("id_mr", "id_bu_sy");
		CiMrmFileInfoDO[] fileInfoDOs = fileRService.find(mrSqlWhere, "", FBoolean.FALSE);
		// 备用集合：从文件系统删除病历时，某一篇删除报错不会影响到之前成功删除的文件对应的CiMrmFileInfoDO的删除流程
		List<CiMrmFileInfoDO> spareList = new ArrayList<CiMrmFileInfoDO>();
		for (CiMrmFileInfoDO fileInfoDO : fileInfoDOs) {
			if (fileInfoDO != null && fileInfoDO.getCode_file() != null && !"".equals(fileInfoDO.getCode_file())) {
				try {
					fileService.delete(fileInfoDO.getCode_file());
				} catch (Exception e) {
					fileCudService.delete(spareList.toArray(new CiMrmFileInfoDO[spareList.size()]));
					throw new BizException(e.getStackTrace().toString());
				}
				spareList.add(fileInfoDO);
			}
		}
		fileCudService.delete(fileInfoDOs);
		return true;
	}

	@Override
	public boolean logicDeleteMr(CiMrDO[] ciMrDos) throws BizException {
		if (ciMrDos == null || ciMrDos.length <= 0) {
			return false;
		}
		// 服务定义
		ICiemrRService mrRService = ServiceFinder.find(ICiemrRService.class);
		ICiemrCudService mrCudService = ServiceFinder.find(ICiemrCudService.class);
		ICimrfsRService fsRService = ServiceFinder.find(ICimrfsRService.class);
		ICimrfsCudService fsCudService = ServiceFinder.find(ICimrfsCudService.class);
		ICimrmfileinfoRService fileRService = ServiceFinder.find(ICimrmfileinfoRService.class);
		ICimrmfileinfoCudService fileCudService = ServiceFinder.find(ICimrmfileinfoCudService.class);
		IMrdocrefvalueRService refRService = ServiceFinder.find(IMrdocrefvalueRService.class);
		IMrdocrefvalueCudService refCudService = ServiceFinder.find(IMrdocrefvalueCudService.class);
		ICimrsourceRService sourceRService = ServiceFinder.find(ICimrsourceRService.class);
		ICimrsourceCudService sourceCudService = ServiceFinder.find(ICimrsourceCudService.class);
		// 删除条件拼接
		StringBuilder mrSb = new StringBuilder();
		mrSb.append(" id_mr in (");
		for (CiMrDO ciMrDO : ciMrDos) {
			mrSb.append("'");
			mrSb.append(ciMrDO.getId_mr());
			mrSb.append("', ");
		}
		String mrSqlWhere = mrSb.toString().substring(0, mrSb.toString().length() - 2) + ") ";
		// 执行删除流程
		CiMrDO[] mrDOs = mrRService.find(mrSqlWhere, "", FBoolean.FALSE);
		mrCudService.logicDelete(mrDOs);
		
		CiMrFsDO[] mrFsDOs = fsRService.find(mrSqlWhere, "", FBoolean.FALSE);
		fsCudService.logicDelete(mrFsDOs);
		
		MrDocRefValueDO[] refValueDOs = refRService.find(mrSqlWhere, "", FBoolean.FALSE);
		refCudService.logicDelete(refValueDOs);
		
		CiMrSourceDO[] sourceDOs = sourceRService.find(mrSqlWhere, "", FBoolean.FALSE);
		sourceCudService.logicDelete(sourceDOs);
		
		mrSqlWhere = mrSqlWhere.replace("id_mr", "id_bu_sy");
		CiMrmFileInfoDO[] fileInfoDOs = fileRService.find(mrSqlWhere, "", FBoolean.FALSE);
		fileCudService.logicDelete(fileInfoDOs);
		return true;
	}

}
