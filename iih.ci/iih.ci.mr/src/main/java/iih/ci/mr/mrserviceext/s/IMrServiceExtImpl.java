package iih.ci.mr.mrserviceext.s;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.SuMrConst;
import iih.bd.srv.dto.d.MrDTO;
import iih.bd.srv.macrovaluedo.d.MacroValueDo;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cmis.s.CMISSendServiceImpl;
import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import iih.ci.mr.i.ICiMrBrowseParamService;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.i.IIPMrService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueCudService;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.mrfs.d.MrfsDTO;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;
import iih.ci.mr.mrserviceext.s.bp.JCPTMrFpDataBP;
import iih.ci.mr.mrserviceext.s.bp.MrSignMvelBp;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.pub.mrutil.stringoper.StringOperUtil;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.mr.s.util.MrCommonUtils;
import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpRService;
import iih.ci.mrfp.cimrfp.d.CiMrFpDO;
import iih.ci.mrfp.cimrfp.i.ICimrfpRService;
import iih.ci.mrfp.hospitalfirstpagedto.d.HospitalFirstPageDTO;
import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpMDORService;
import iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO;
import iih.ci.mrfp.pat2mrfp.i.IPat2mrfpRService;
import iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO;
import iih.ci.mrfp.sug2mrfp.i.ISug2mrfpRService;
import iih.ci.mrm.dto.cimrmmacrovaluedto.d.CiMrmMacroValueDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.springframework.transaction.TransactionStatus;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.annotation.Service;
import xap.mw.core.base64.Base64;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.bdfw.d.bd.pub.IPubEnumConst;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ArrayListHandler;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.perm.scvi.i.IScviRService;

/**
 * 组件操作方法服务实现
 */
@Service(serviceInterfaces = { IMrServiceExt.class }, binding = Binding.JSONRPC)
public class IMrServiceExtImpl implements IMrServiceExt {

	/**
	 * 质控类型
	 * 
	 * @author zhangjb
	 *
	 */
	private enum CompleteType {
		/**
		 * 不启用科室,启用终末,状态到终末那里
		 */
		COMDEPTSCORE,

		/**
		 * 不科室,不终末,直接到病案
		 */
		COMTERMINALSCORE,

		/**
		 * 书写完成，质控完成
		 */
		COMWRITE,

		/**
		 * 单纯书写完成
		 */
		COMPLETE
	}

	/**
	 * 根据自定义分类获取病历文书
	 */

	public CiMrDO[] GetMrByMrCa(String id_ent, String id_mrcactm, String code_entp, String docornur) throws BizException {
		/**
		 * 实现代码
		 */
		if (id_ent == null || id_ent == "")
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");
		
		if (docornur == null || docornur.equals("")) {
			docornur = ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_DOC;
		}

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");

		String sql1 = " select a0.id_mrcactm, a0b27.code Bed_code, a0b27.name Bed_name, a0.Code_dept_pat, a0.Code_entp, "
					+ " a0b15.code Createby_code, a0b15.name Createby_name, a0.Createdby, a0.Createdtime, "
					+ " a0.Date_submit, a0.Date_time_show, a0b11.code Dep_code, a0b11.name Dep_name, "
					+ " a0b24.code Dep_pat_code, a0b24.name Dep_pat_name, a0b26.code Deptline_code, a0b26.name Deptline_name, "
					+ " a0b23.code Dir_code, a0.Dir_doctor_date, a0b23.name Dir_name, a0.Ds, "
					+ " a0.Dt_audit_lat, a0.Dt_rd, a0.Dt_sign, a0.Dt_sign_lat, a0b13.code Emp_audit_code, "
					+ " a0b13.name Emp_audit_name, a0b10.code Emp_code, a0b17.code Emp_higher_code, "
					+ " a0b17.name Emp_higher_name, a0b12.code Emp_lat_code, a0b12.name Emp_lat_name, a0b10.name Emp_name, "
					+ " a0b19.code Emp_submit_code, a0b19.name Emp_submit_name, a0b4.code Entp_code, a0b4.name Entp_name, "
					+ " a0.Fg_arc, a0.Fg_complete, a0.Fg_duty_doctor, a0.Fg_edit, a0.Fg_prn, a0.Fg_reject, a0.Fg_seal, "
					+ " a0.Fg_submit, a0b25.typecode Flowtype_typecode, a0b25.typename Flowtype_typename, "
					+ " a0b1.code Grp_code, a0b1.name Grp_name, a0.Id_bed, a0.Id_dep, a0.Id_dep_nuradm, a0.Id_dep_pat, "
					+ " a0.Id_dir_doctor, a0.Id_emp, a0.Id_emp_audit, a0.Id_emp_higher, a0.Id_emp_lat, a0.Id_emp_submit, "
					+ " a0.Id_ent, a0.Id_entp, a0.Id_flowtype, a0.Id_grp, a0.Id_mast_doctor, a0.Id_mr, "
					+ " a0b18.id_mr_finish_status Id_mr_finish_status, a0.Id_mred, a0.Id_mrtp, a0.Id_mrtpl, a0.Id_mrtplstmd, "
					+ " a0.Id_org,a0.Id_pat, a0.Id_reviewtp, a0.Id_sex, a0.Id_su_mr, a0.Id_submit_dept, a0.Id_treat_doctor, "
					+ " a0b22.code Mast_code, a0.Mast_doctor_date, a0b22.name Mast_name, a0.Modifiedby, a0b16.code Modifiedby_code, "
					+ " a0b16.name Modifiedby_name, a0.Modifiedtime, a0b8.code Mred_code, a0b8.name Mred_name, "
					+ " a0b6.code Mrtp_code, a0b6.name Mrtp_name, a0b7.code Mrtpl_code, a0b7.name Mrtpl_name, "
					+ " a0b9.code Mrtplstmd_code, a0b9.name Mrtplstmd_name, a0.Name, a0.Newend, a0.Newtop, a0b2.code Org_code, "
					+ " a0b2.name Org_name, a0.Pat_age, a0b3.code Pat_code, a0b3.name Pat_name, a0b18.code Reviewtp_code, "
					+ " a0b18.name Reviewtp_name, a0.Scoreqalat, a0.Sd_mrtplstmd, a0.Sd_reviewtp, a0.Sd_su_mr, a0.Sign_suggestion, "
					+ " a0.Startparaed, a0b14.code Su_mr_code, a0b14.name Su_mr_name, a0b20.code Submit_dept_code, "
					+ " a0b20.name Submit_dept_name, a0.Sv, a0.Task_id, a0b21.code Treat_code, "
					+ " a0b21.name Treat_name, a0.Url_file, a0.fg_sign ";
		String sql2 = " from ci_mr a0 " 
				+ "  left outer join bd_bed a0b27 ON a0.id_bed = a0b27.id_bed\n"
				+ "  left outer join sys_user a0b15 ON a0.createdby = a0b15.id_user\n"
				+ "  left outer join bd_dep a0b11 ON a0.id_dep = a0b11.id_dep\n"
				+ "  left outer join bd_dep a0b24 ON a0.id_dep_pat = a0b24.id_dep\n"
				+ "  left outer join BD_DEPL a0b26 ON a0.id_dep_nuradm = a0b26.id_depl\n"
				+ "  left outer join sys_user a0b23 ON a0.id_dir_doctor = a0b23.id_user\n"
				+ "  left outer join sys_user a0b13 ON a0.id_emp_audit = a0b13.id_user\n"
				+ "  left outer join sys_user a0b10 ON a0.id_emp = a0b10.id_user\n"
				+ "  left outer join sys_user a0b17 ON a0.id_emp_higher = a0b17.id_user\n"
				+ "  left outer join sys_user a0b12 ON a0.id_emp_lat = a0b12.id_user\n"
				+ "  left outer join sys_user a0b19 ON a0.id_emp_submit = a0b19.id_user\n"
				+ "  left outer join bd_entp a0b4 ON a0.id_entp = a0b4.id_entp\n"
				+ "  left outer join wf_flwtype a0b25 ON a0.id_flowtype = a0b25.id_flowtype\n"
				+ "  left outer join bd_grp a0b1 ON a0.id_grp = a0b1.id_grp\n"
				+ "  left outer join bd_reviewtp a0b18 ON a0.id_reviewtp = a0b18.id_reviewtp\n"
				+ "  left outer join sys_user a0b22 ON a0.id_mast_doctor = a0b22.id_user\n"
				+ "  left outer join sys_user a0b16 ON a0.modifiedby = a0b16.id_user\n"
				+ "  left outer join bd_mred a0b8 ON a0.id_mred = a0b8.id_mred\n"
				+ "  left outer join bd_mrtp a0b6 ON a0.id_mrtp = a0b6.id_mrtp\n"
				+ "  left outer join bd_mrtpl a0b7 ON a0.id_mrtpl = a0b7.id_mrtpl\n"
				+ "  left outer join bd_udidoc a0b9 ON a0.id_mrtplstmd = a0b9.id_udidoc\n"
				+ "  left outer join bd_org a0b2 ON a0.id_org = a0b2.id_org\n"
				+ "  left outer join pi_pat a0b3 ON a0.id_pat = a0b3.id_pat\n"
				+ "  left outer join bd_udidoc a0b14 ON a0.id_su_mr = a0b14.id_udidoc\n"
				+ "  left outer join bd_dep a0b20 ON a0.id_submit_dept = a0b20.id_dep\n"
				+ "  left outer join sys_user a0b21 ON a0.id_treat_doctor = a0b21.id_user\n"
				// + " left outer join bd_mrca_ctm_itm itm\n"
				// + " on itm.id_mrtp = a0.id_mrtp\n"
				+ "  left outer join bd_mrca_ctm ctm on ctm.id_mrcactm = a0.id_mrcactm\n";
		StringBuilder sb = new StringBuilder();
		SqlParam sp = new SqlParam();
		sp.addParam(id_ent);
		if(id_mrcactm!=null&&!id_mrcactm.equals("")&&!id_mrcactm.equals("%"))
		{
		sp.addParam(id_mrcactm);
		}
		sb.append(" (a0.id_ent = ?) ");
		sb.append(" and a0.ds!=1 ");
		if(id_mrcactm!=null&&!id_mrcactm.equals("")&&!id_mrcactm.equals("%"))
		{
		sb.append(" and ctm.id_mrcactm = ? ");
		}
		//sb.append(" and ctm.code_entp in (" + code_entp + ")");

		if (docornur.equals(ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_NUR)) {
			sb.append("	AND (ctm.docornur = '"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_NUR+"' or ctm.docornur ='"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_ALL+"')");
		} else {
			sb.append("	AND (ctm.docornur = '"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_DOC+"' or ctm.docornur ='"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_ALL+"')");
		}
		// sb.append(" AND (a0.id_mrtp in ( ");
		// sb.append(" SELECT bmci.id_mrtp FROM bd_mrca_ctm_itm bmci\n");
		// sb.append(" JOIN bd_mrca_ctm bmc\n");
		// sb.append(" ON bmc.code_entp = '");
		// sb.append(code_entp + "' AND bmc.ds = 0 ");
		// sb.append(" AND bmc.id_mrcactm = bmci.id_mrcactm");
		// if (docornur.equals("20")) {
		// sb.append(" AND (bmc.docornur = '20' or bmc.docornur ='30')");
		// } else {
		// sb.append(" AND (bmc.docornur = '10' or bmc.docornur ='30')");
		// }
		// // sb.append(" and bmc.id_mrcactm like '" + id_mrcactm + "'"
		// sb.append(" )) ");

		String whereStr = sb.toString();
		String orderBy = " order by ctm.sortno,dt_rd";
		String sql = sql1 + sql2 + " where \n" + whereStr + orderBy;
		// CiMrDO[] mrDos = cmservice.find(whereStr, "dt_rd", new
		// FBoolean(false));
		// return mrDos;
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql, sp, new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);
	}
	
	public CiMrDO[] getMrByMrCaAndType(String id_ent, String id_mrcactm,
			String code_entp, String docornur,String id_mr_bt,String id_surdata_classi) throws BizException {
		/**
		 * 实现代码
		 */
		if (id_ent == null || id_ent == "")
			throw new BizException("病人就诊号不能为空");
		
		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");
		
		if (docornur == null || docornur.equals("")) {
			docornur = ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_DOC;
		}

		DAFacade daf = new DAFacade();

		String sql1 = "select a0.id_mrsigntpl, a0.id_mrcactm,a0b27.code Bed_code,a0b27.name Bed_name,a0.Code_dept_pat,a0.Code_entp,a0b15.code Createby_code,a0b15.name Createby_name,a0.Createdby,a0.Createdtime,a0.id_mr_bt,a0.Date_submit,a0.Date_time_show,a0b11.code Dep_code,a0b11.name Dep_name,a0b24.code Dep_pat_code,a0b24.name Dep_pat_name,a0b26.code Deptline_code,a0b26.name Deptline_name,a0b23.code Dir_code,a0.Dir_doctor_date,a0b23.name Dir_name,a0.Ds,a0.Dt_audit_lat,a0.Dt_rd,a0.Dt_sign,a0.Dt_sign_lat,a0b13.code Emp_audit_code,a0b13.name Emp_audit_name,a0b10.code Emp_code,a0b17.code Emp_higher_code,a0b17.name Emp_higher_name,a0b12.code Emp_lat_code,a0b12.name Emp_lat_name,a0b10.name Emp_name,a0b19.code Emp_submit_code,a0b19.name Emp_submit_name,a0b4.code Entp_code,a0b4.name Entp_name,a0.Fg_arc,a0.Fg_complete,a0.Fg_duty_doctor,a0.Fg_edit,a0.Fg_prn,a0.Fg_reject,a0.Fg_seal,a0.Fg_submit,a0b25.typecode Flowtype_typecode,a0b25.typename Flowtype_typename,a0b1.code Grp_code,a0b1.name Grp_name,a0.Id_bed,a0.Id_dep,a0.Id_dep_nuradm,a0.Id_dep_pat,a0.Id_dir_doctor,a0.Id_emp,a0.Id_emp_audit,a0.Id_emp_higher,a0.Id_emp_lat,a0.Id_emp_submit,a0.Id_ent,a0.Id_entp,a0.Id_flowtype,a0.Id_grp,a0.Id_mast_doctor,a0.Id_mr,a0b18.id_mr_finish_status Id_mr_finish_status,a0.Id_mred,a0.Id_mrtp,a0.Id_mrtpl,a0.Id_mrtplstmd,a0.Id_org,a0.Id_pat,a0.Id_reviewtp,a0.Id_sex,a0.Id_su_mr,a0.Id_submit_dept,a0.Id_treat_doctor,a0b22.code Mast_code,a0.Mast_doctor_date,a0b22.name Mast_name,a0.Modifiedby,a0b16.code Modifiedby_code,a0b16.name                Modifiedby_name,a0.Modifiedtime,a0b8.code Mred_code,a0b8.name Mred_name,a0b6.code Mrtp_code,a0b6.name Mrtp_name,a0b7.code Mrtpl_code,a0b7.name Mrtpl_name,a0b9.code Mrtplstmd_code,a0b9.name Mrtplstmd_name,a0.Name,a0.Newend,a0.Newtop,a0b2.code Org_code,a0b2.name                 Org_name,a0.Pat_age,a0b3.code Pat_code,a0b3.name Pat_name,a0b18.code Reviewtp_code,a0b18.name                Reviewtp_name,a0.Scoreqalat,a0.Sd_mrtplstmd,a0.Sd_reviewtp,a0.Sd_su_mr,a0.Sign_suggestion,a0.Startparaed,a0b14.code Su_mr_code,a0b14.name Su_mr_name,a0b20.code Submit_dept_code,a0b20.name Submit_dept_name,a0.Sv,a0.Task_id,a0b21.code Treat_code,a0b21.name Treat_name,a0.Url_file,a0.fg_sign\n";
		String sql2 = "  from ci_mr a0\n" + "  left outer join bd_bed a0b27\n"
				+ "    ON a0.id_bed = a0b27.id_bed\n"
				+ "  left outer join sys_user a0b15\n"
				+ "    ON a0.createdby = a0b15.id_user\n"
				+ "  left outer join bd_dep a0b11\n"
				+ "    ON a0.id_dep = a0b11.id_dep\n"
				+ "  left outer join bd_dep a0b24\n"
				+ "    ON a0.id_dep_pat = a0b24.id_dep\n"
				+ "  left outer join BD_DEPL a0b26\n"
				+ "    ON a0.id_dep_nuradm = a0b26.id_depl\n"
				+ "  left outer join sys_user a0b23\n"
				+ "    ON a0.id_dir_doctor = a0b23.id_user\n"
				+ "  left outer join sys_user a0b13\n"
				+ "    ON a0.id_emp_audit = a0b13.id_user\n"
				+ "  left outer join sys_user a0b10\n"
				+ "    ON a0.id_emp = a0b10.id_user\n"
				+ "  left outer join sys_user a0b17\n"
				+ "    ON a0.id_emp_higher = a0b17.id_user\n"
				+ "  left outer join sys_user a0b12\n"
				+ "    ON a0.id_emp_lat = a0b12.id_user\n"
				+ "  left outer join sys_user a0b19\n"
				+ "    ON a0.id_emp_submit = a0b19.id_user\n"
				+ "  left outer join bd_entp a0b4\n"
				+ "    ON a0.id_entp = a0b4.id_entp\n"
				+ "  left outer join wf_flwtype a0b25\n"
				+ "    ON a0.id_flowtype = a0b25.id_flowtype\n"
				+ "  left outer join bd_grp a0b1\n"
				+ "    ON a0.id_grp = a0b1.id_grp\n"
				+ "  left outer join bd_reviewtp a0b18\n"
				+ "    ON a0.id_reviewtp = a0b18.id_reviewtp\n"
				+ "  left outer join sys_user a0b22\n"
				+ "    ON a0.id_mast_doctor = a0b22.id_user\n"
				+ "  left outer join sys_user a0b16\n"
				+ "    ON a0.modifiedby = a0b16.id_user\n"
				+ "  left outer join bd_mred a0b8\n"
				+ "    ON a0.id_mred = a0b8.id_mred\n"
				+ "  left outer join bd_mrtp a0b6\n"
				+ "    ON a0.id_mrtp = a0b6.id_mrtp\n"
				+ "  left outer join bd_mrtpl a0b7\n"
				+ "    ON a0.id_mrtpl = a0b7.id_mrtpl\n"
				+ "  left outer join bd_udidoc a0b9\n"
				+ "    ON a0.id_mrtplstmd = a0b9.id_udidoc\n"
				+ "  left outer join bd_org a0b2\n"
				+ "    ON a0.id_org = a0b2.id_org\n"
				+ "  left outer join pi_pat a0b3\n"
				+ "    ON a0.id_pat = a0b3.id_pat\n"
				+ "  left outer join bd_udidoc a0b14\n"
				+ "    ON a0.id_su_mr = a0b14.id_udidoc\n"
				+ "  left outer join bd_dep a0b20\n"
				+ "    ON a0.id_submit_dept = a0b20.id_dep\n"
				+ "  left outer join sys_user a0b21\n"
				+ "    ON a0.id_treat_doctor = a0b21.id_user\n"
//				+ "  left outer join bd_mrca_ctm_itm itm\n"
//				+ "    on itm.id_mrtp = a0.id_mrtp\n"
				+ "  left outer join bd_mrca_ctm ctm\n"
				+ "    on ctm.id_mrcactm = a0.id_mrcactm\n";
		SqlParam sp = new SqlParam();

		StringBuilder sb = new StringBuilder();
		if(id_mr_bt != null && id_mr_bt != "")
		{
			sb.append(" a0.id_mr_bt = ? and");
			sp.addParam(id_mr_bt);
		}
		if(id_surdata_classi != null && id_surdata_classi != "")
		{
			sb.append(" a0.id_surdata_classi = ? and");
			sp.addParam(id_surdata_classi);
		}
		sb.append(" (a0.id_ent = ?) ");
		sp.addParam(id_ent);
		sb.append(" and a0.ds!=1 ");
		if(id_mrcactm!=null&&!id_mrcactm.equals("")&&!id_mrcactm.equals("%"))
		{
		sb.append(" and ctm.id_mrcactm = ? ");
		sp.addParam(id_mrcactm);
		}
		sb.append(" and ctm.code_entp = ?");
		sp.addParam(code_entp);
		if (docornur.equals(ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_NUR)) {
			sb.append("	AND (ctm.docornur = '"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_NUR+"' or ctm.docornur ='"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_ALL+"')");
		} else {
			sb.append("	AND (ctm.docornur = '"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_DOC+"' or ctm.docornur ='"+ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_ALL+"')");
		}
		
		String whereStr = sb.toString();
		String orderBy = " order by ctm.sortno,dt_rd asc";

		String sql = sql1 + sql2 + " where \n" + whereStr + orderBy;
		// CiMrDO[] mrDos = cmservice.find(whereStr, "dt_rd", new
		// FBoolean(false));
		// return mrDos;
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql,sp,new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);

	}
	@Override
	public MrDTO[] GetMrDtoForTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException {

		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals("")) {
			docornur = "10";
		}
		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		StringBuilder sb = new StringBuilder();
		if ("0".equals(paramtype))// 住院
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.id_emp_submit  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'  and cm.ds = 0 \n ");
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			sb.append("   AND cm.sd_su_mr not in ( '");
			sb.append(SuMrConst.SD_SUMR_NEW);
			sb.append("','");
			sb.append(SuMrConst.SD_SUMR_RETRIEVE);
			sb.append("','");
			sb.append(SuMrConst.SD_SUMR_REJECT);
			sb.append("')\n");
			sb.append("   AND cm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ");
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}
		if ("1".equals(paramtype))// 门诊
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.id_emp_submit  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'  and cm.ds = 0 \n ");
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + "\n");

			sb.append("   AND cm.code_entp in ( '" + code_entp + "' ");
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}
	@Override
	public MrDTO[] getMrDtoForBrowseTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals("")) {
			docornur = "10";
		}
		DAFacade daf = new DAFacade();
		ICiMrBrowseParamService browseParamService = ServiceFinder.find(ICiMrBrowseParamService.class);
		SqlParam sp = new SqlParam();
		StringBuilder sbfg = new StringBuilder();
		sbfg.append(" select *from ci_amr where ");
		
		if (id_ent != null && id_ent != "") {
			sbfg.append(" id_ent =? ");
			sp.addParam(id_ent);
		}
		AMrDO amrDo = (AMrDO) daf.execQuery(sbfg.toString(), sp, new BeanHandler(AMrDO.class));
		String param = "";
		if(amrDo==null)
		{
			return new MrDTO[]{};
		}
		if (amrDo.getFg_complete() !=null &&amrDo.getFg_complete().equals(FBoolean.TRUE)){
			param = browseParamService.GetSysParamArchived(amrDo.getId_org());
		} else {
			param = browseParamService.GetSysParamNoArchive(amrDo.getId_org());
		}
		String [] str = param.split(",");
		StringBuffer sbf = new StringBuffer();
		
		if(str.length>0){
			for(int i = 0 ; i <str.length ; i++){
				if(i==str.length-1){
					sbf.append("\'"+str[i]+"\'");
				}else{
					sbf.append("\'"+str[i]+"\',");
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		if ("0".equals(paramtype))// 住院
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append(" cm.id_mr,\n");
			sb.append(" cm.id_ent id_ent,\n ");
			sb.append(" cm.id_pat,\n");
			sb.append(" cm.name,\n");
			sb.append(" cm.id_mrtp,\n");
			sb.append(" cm.sd_su_mr,\n");
			sb.append(" bmc.id_mrcactm,\n");
			sb.append(" bmc.name mrcactm_name,\n");
			sb.append(" cm.id_emp_submit  id_treat_doctor,\n");
			sb.append(" cm.id_submit_dept id_dep_pat,\n");
			sb.append(" bmc.id_fst,\n");
			sb.append(" cqif.name fst_name\n");
			sb.append(" FROM bd_mrca_ctm bmc\n");
			sb.append(" JOIN CI_MR cm\n");
			sb.append(" ON cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append(" LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append(" ON cqif.id_fst = bmc.id_fst\n");
			sb.append(" left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append(" AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append(" AND cm.id_ent = '" + id_ent + "' and cm.ds = 0 \n ");
			
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			sb.append(" AND cm.id_su_mr in ("+sbf.toString()+")\n ");
			sb.append("   AND cm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ");
			// if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp) &&
			// !IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){
			// sb.append(" , '" + code_entp + "'");
			// }
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");
		}
		
		if ("1".equals(paramtype))// 门诊
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.id_emp_submit  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'  and cm.ds = 0 \n ");
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + "\n");

			sb.append("   AND cm.code_entp in ( '" + code_entp + "' ");
			// if(!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp) &&
			// !IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){
			// sb.append(" , '" + code_entp + "'");
			// }
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

			// sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as
			// dt_rd,\n");
			// sb.append(" cm.id_mr, cm.id_ent id_ent, cm.id_pat, cm.name,\n");
			// sb.append(" cm.id_mrtp, cm.sd_su_mr, bmc.id_mrcactm,bmc.name
			// mrcactm_name, \n");
			// sb.append(" cm.id_emp_submit as id_treat_doctor ,
			// cm.id_submit_dept as id_dep_pat \n");
			// // sb.append(" cm.createdby as createdby, cm.createdtime as
			// createdtime \n"
			// // );
			// sb.append(" FROM bd_mrca_ctm bmc, bd_mrca_ctm_itm bmci, CI_MR
			// cm\n");
			// sb.append(" left outer join sys_user su on su.id_user =
			// cm.id_emp_submit \n");
			// // sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n" );
			// sb.append(" WHERE cm.code_entp in ( '"
			// + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' ");
			// if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
			// sb.append(" , '" + code_entp + "'");
			// }
			// sb.append(" )\n ");
			// sb.append(" AND bmc.id_mrcactm LIKE '" + id_mrcactm + "'\n");
			// sb.append(" AND cm.id_ent = '" + id_ent + "'\n");
			// sb.append(" AND bmc.id_mrcactm = bmci.id_mrcactm\n");
			// sb.append(" AND bmc.activestate = "
			// + IPubEnumConst.ACTIVESTATE_ENABLE + " \n");
			// if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			// if (docornur.equals("20")) {
			// sb.append(" AND (bmc.docornur = '20' or bmc.docornur ='30')");
			// } else {
			// sb.append(" AND (bmc.docornur = '10' or bmc.docornur ='30')");
			// }
			//
			// }
			// sb.append(" AND bmci.id_mrtp = cm.id_mrtp\n");
			// // sb.append(" AND cm.code_entp = '" + code_entp + "' " );
			// sb.append(" AND cm.code_entp in ( '"
			// + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' ");
			// if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
			// sb.append(" , '" + code_entp + "'");
			// }
			// sb.append(" )\n ");
			// sb.append(" order by cm.dt_rd asc ");

		}

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}

	/**
	 * 获取指定病人医疗文件DTO 查询过滤： 1.若未完成书写，则查询已提交（或者是审签中和审签完成）的病历
	 * 2.若已完成书写，则只按照完成书写标志查询，已完成书写则可以查看 此方法暂时为兰陵使用方法 - by Vampire
	 */
	public MrDTO[] getSpecialMrDtoForTree(String id_ent, String id_mrcactm, String code_entp, String docornur)
			throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals("")) {
			docornur = "10";
		}
		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);
		PatiVisitDO patiVisitDo = service.findById(id_ent);

		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		AMrDO[] aMrDOs = amrService.find(" a0.id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		// 查询部门参数
		String id_dep = Context.get().getDeptId();
		Boolean canShowNewMR = paraService.getSysParamShowNewMR(id_dep);

		StringBuilder sb = new StringBuilder();
		sb.append(" select su.name as name_emp_submit,cm.dt_rd as dt_rd, ");
		sb.append(" cm.id_mr, ");
		sb.append(" cm.id_ent as id_ent, ");
		sb.append(" cm.id_pat, ");
		sb.append(" cm.name, ");
		sb.append(" cm.id_mrtp, ");
		sb.append(" cm.sd_su_mr, ");
		sb.append(" bmc.id_mrcactm, ");
		sb.append(" bmc.name as mrcactm_name, ");
		sb.append(" cm.id_emp_submit  id_treat_doctor, ");
		sb.append(" cm.id_submit_dept id_dep_pat, ");
		sb.append(" bmc.id_fst, ");
		sb.append(" cqif.name as fst_name ");
		sb.append(" from bd_mrca_ctm bmc ");
		sb.append(" join ci_mr cm ");
		sb.append(" on cm.id_mrcactm = bmc.id_mrcactm ");
		sb.append(" left outer join ci_qa_itm_fst cqif ");
		sb.append(" on cqif.id_fst = bmc.id_fst ");
		sb.append(" left outer join sys_user su on su.id_user = cm.id_emp_submit ");
		sb.append(" where bmc.code_entp = '" + code_entp + "' ");
		sb.append(" and bmc.id_mrcactm like '" + id_mrcactm + "' ");
		sb.append(" and cm.id_ent = '" + id_ent + "'  and cm.ds = 0 ");
		if (docornur.equals("20")) {
			sb.append("	and (bmc.docornur = '20' or bmc.docornur ='30') ");
		} else {
			sb.append("	and (bmc.docornur = '10' or bmc.docornur ='30') ");
		}
		sb.append(" and bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE);
		// 如果当前科室参数为true，则可以直接查看未提交状态的病历；否则需要判断是否已经完成书写
		if(aMrDOs!=null && aMrDOs.length>0){
			if (!canShowNewMR) {
				if (aMrDOs[0].getFg_complete() != FBoolean.TRUE) {
					sb.append(" and cm.sd_su_mr not in ( '");
					sb.append(SuMrConst.SD_SUMR_NEW);
					sb.append("', '");
					sb.append(SuMrConst.SD_SUMR_RETRIEVE);
					sb.append("', '");
					sb.append(SuMrConst.SD_SUMR_REJECT);
					sb.append("') ");
				}
			}
		}
		
		sb.append(" and cm.code_entp in ('" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "') ");
		sb.append(" order by cm.dt_rd asc ");

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		List<MrDTO> list = specialCombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}

	/**
	 * 针对getSpecialMrDtoForTree方法查询的病历进行名称显示的重新定义
	 * 
	 * @param listMrDto
	 * @return 组合显示病历名称后的list
	 */
	public List<MrDTO> specialCombineNamesList(List<MrDTO> listMrDto) {
		List<MrDTO> listMrDto2 = new ArrayList<MrDTO>();
		for (MrDTO mr : listMrDto) {
			String sd_su_mr = mr.getSd_su_mr();
			String statusName = "";

			switch (sd_su_mr) {
			case SuMrConst.SD_SUMR_NEW:
				statusName = "新建";
				break;
			case SuMrConst.SD_SUMR_RETRIEVE:
				statusName = "已取回";
				break;
			case SuMrConst.SD_SUMR_REJECT:
				statusName = "已驳回";
				break;
			case SuMrConst.SD_SUMR_SUBMIT:
				statusName = "已提交";
				break;
			case SuMrConst.SD_SUMR_SIGNING:
				statusName = "审签中";
				break;
			case SuMrConst.SD_SUMR_COMPLETE:
				statusName = "已完成";
				break;
			default:
				break;
			}
			String CombineName = sprcialCombineName(mr.getName(), statusName, mr.getDt_rd(), mr.getName_emp_submit());
			mr.setName(CombineName);
			listMrDto2.add(mr);
		}
		return listMrDto2;
	}

	/**
	 * 整合显示病历名称 显示为：名称(病历状态)+"_"+业务时间+"_"+提交人 如果提交人为空显示为：名称(病历状态)+"_"+业务时间
	 * 
	 * @param name
	 *            名称
	 * @param name
	 *            病历状态
	 * @param dt_rd
	 *            业务时间（精确到分钟）
	 * @param id_emp_submit
	 *            提交人
	 * @return 组合后的名称
	 */
	public String sprcialCombineName(String name, String statusName, String dt_rd, String name_emp_submit) {
		StringBuilder returnV = new StringBuilder();
		if (name == null || "".equals(name) || "~".equals(name)) {
			returnV.append(name);
		} else if (dt_rd == null || "".equals(dt_rd) || "~".equals(dt_rd) || dt_rd.length() < 3) {
			returnV.append(name);
		} else if (name_emp_submit == null || "".equals(name_emp_submit) || "~".equals(name_emp_submit)) {
			if (statusName == null || "".equals(statusName)) {
				returnV.append(name);
				returnV.append("_");
				returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
			} else {
				returnV.append(name);
				returnV.append("(");
				returnV.append(statusName);
				returnV.append(")");
				returnV.append("_");
				returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
			}
		} else {
			if (statusName == null || "".equals(statusName)) {
				returnV.append(name);
				returnV.append("_");
				returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
				returnV.append("_");
				returnV.append(name_emp_submit);
			} else {
				returnV.append(name);
				returnV.append("(");
				returnV.append(statusName);
				returnV.append(")");
				returnV.append("_");
				returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
				returnV.append("_");
				returnV.append(name_emp_submit);
			}
		}
		return returnV.toString();
	}

	@Override
	public CiMrDO[] GetAuditMrs(String id_dep, String id_user, String auditStatus, String docornur)
			throws BizException {
		if (id_dep == null || id_dep == "")
			throw new BizException("科室不能为空");
		if (id_user == null || id_user == "")
			throw new BizException("医生不能为空");
		if (docornur == null || docornur.equals("")) {
			docornur = "10";
		}

		ICiemrRService service = ServiceFinder.find(ICiemrRService.class);
		StringBuilder sb = new StringBuilder();
		sb.append("a0.id_dep_pat like '" + id_dep + "'");
		if (auditStatus.equals("0")) {
			sb.append(" AND (((a0.id_mast_doctor like '" + id_user + "') AND ( (sd_su_mr ='" + SuMrConst.SD_SUMR_SUBMIT
					+ "' OR sd_su_mr = '" + SuMrConst.SD_SUMR_INTWOLEVELAUDIT + "')))");
			sb.append(" OR ((a0.id_dir_doctor like '" + id_user + "') AND ( (sd_su_mr ='"
					+ SuMrConst.SD_SUMR_TWOLEVELSIGNBY + "' OR sd_su_mr = '" + SuMrConst.SD_SUMR_IN_THREELEVELAUDIT
					+ "'))))");

		}
		if (auditStatus.equals("1")) {

			sb.append(" AND (((a0.id_mast_doctor like '" + id_user + "') AND (Mast_doctor_date IS NOT NULL))");
			sb.append(" OR ((a0.id_dir_doctor like '" + id_user + "') AND (dir_doctor_date IS NOT NULL)))");

		}
		String whereStr = sb.toString();
		CiMrDO[] mrDos = service.find(whereStr, null, new FBoolean(false));
		return mrDos;
	}

	@Override
	public FBoolean CompleteEdit(String id_ent) throws BizException {
		if (id_ent == null || id_ent == "")
			throw new BizException("病人就诊号不能为空");

		IInpatientRService service = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] patiVisitDoArr = service.find("id_ent ='" + id_ent + "'", null, new FBoolean(false));
		if (patiVisitDoArr == null || patiVisitDoArr.length == 0)
			throw new BizException("病人就诊号为不存在");
		if (!("".equals(CanCompleteEdit(id_ent)) || CanCompleteEdit(id_ent) == null)) {
			throw new BizException("不能完成审核");

		}
		// InpatientDO inPatientDo = patiVisitDoArr[0];
		// String sd_status = inPatientDo.getSd_status();

		// 0X-门诊 1x-急诊 2X-住院 3X-体检 （ X5-接诊 X8-诊毕)
		// 01 预约 02挂号 05 就诊 08诊毕 0a续诊 （del： 03-分诊 04-叫号 0b叫号未到
		// ，因为这三个状态放入en_ent_que中）
		// 11 登记，15 接诊，18诊毕，13 出报告
		// 21 预约 22-入院 25-入科 28出院 2a退院
		// 31 登记，35 接诊，38诊毕，39 出报告

		int result = 0;
		DAFacade daf = new DAFacade();
		StringBuilder sSql = new StringBuilder();
		Boolean isSuc = false;
		if (!CiMrParamUtils.GetSysParamDeptQc(Context.get().getDeptId())
				&& CiMrParamUtils.GetSysParamTerminalQc(Context.get().getDeptId())) {// 不启用科室
																						// 启用终末
																						// 状态到
																						// 终末那里

			try {
				isSuc = setAmrCompleteAndSendMsg(id_ent, CompleteType.COMDEPTSCORE);
			} catch (Exception e) {
				isSuc = false;
				throw new BizException("更新病案表失败");
			}
			if (isSuc == false)
				throw new BizException("更新病案表失败");
		} else if (!CiMrParamUtils.GetSysParamDeptQc(Context.get().getDeptId())
				&& !CiMrParamUtils.GetSysParamTerminalQc(Context.get().getDeptId())) {// 不科室
																						// 不终末
																						// 直接到病案

			try {
				isSuc = setAmrCompleteAndSendMsg(id_ent, CompleteType.COMTERMINALSCORE);
			} catch (Exception e) {
				isSuc = false;
				throw new BizException("更新病案表失败");
			}
			if (isSuc == false)
				throw new BizException("更新病案表失败");
		} else {

			try {
				isSuc = setAmrCompleteAndSendMsg(id_ent, CompleteType.COMWRITE);
			} catch (Exception e) {
				isSuc = false;
				throw new BizException("更新病案表失败");
			}
			if (isSuc == false)
				throw new BizException("更新病案表失败");
		}
		if (isSuc) {
			/*sSql.delete(0, sSql.length());
			sSql.append("UPDATE ci_mr SET fg_complete = 'Y' WHERE id_ent = '");
			sSql.append(id_ent);
			sSql.append("'");
			result = daf.execUpdate(sSql.toString());
			if (result == 0)
				throw new BizException("更新病历 表失败");*/
			HospitalFirstPageDTO hospitalFirstPageDTO = this.getMrFpMsg(id_ent);
			if (hospitalFirstPageDTO != null // && hospitalFirstPageDTO.getId_mrfp() != null
			) {
				BDCommonEvent event = new BDCommonEvent(IMrEventConst.EVENT_SOURCE_MR_FP_COMPLETE,
						IEventType.TYPE_UPDATE_AFTER, hospitalFirstPageDTO);
				EventDispatcher.fireEvent(event);
			}
		} else {
			return new FBoolean(false);
		}
		// ICiamrRService ciamrService =
		// ServiceFinder.find(ICiamrRService.class);
		// AMrDO[] amrDOs = ciamrService.find("id_ent='" + id_ent + "'", "",
		// FBoolean.FALSE);

		// if (!ArrayUtils.isEmpty(amrDOs)) {
		//// BusinessEvent mrEvent = new BusinessEvent(
		//// IMrEventConst.EVENT_SOURCE_MR_AMR_COMPLETE,
		//// IEventType.TYPE_UPDATE_AFTER, amrDOs[0]);
		//// EventDispatcher.fireEvent(mrEvent);
		//
		// DomainBusinessUserObj buo = new
		// DomainBusinessUserObj(amrDOs[0],IMrPubConst.DZBL);
		// BusinessEvent event = new
		// BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_AMR_COMPLETE,
		// IEventType.TYPE_UPDATE_AFTER, buo);
		//// try {
		//// EventDispatcher.fireEvent(event);
		//// } catch (BizException e) {
		//// e.printStackTrace();
		//// }
		// }
		// 发送集成平台消息
		ICiMrParamService paramService = ServiceFinder.find(ICiMrParamService.class);
		String mrFpTypeParam = paramService.getSysParamMrFpType(Context.get().getDeptId());
		
		String serviceCode = "";
		HospitalFirstPageDTO hospitalFPDTO = new HospitalFirstPageDTO();
		JCPTMrFpDataBP jctMrFpDataBP = new JCPTMrFpDataBP();
		// 根据参数判断查询中医或西医病案首页数据
		if (ICiMrDictCodeConst.MR_FP_ZY_TYPE.equals(mrFpTypeParam)) {
			hospitalFPDTO = jctMrFpDataBP.getMrfpZYDataForIE(id_ent);
			serviceCode = IMrEventConst.EVENT_SOURCE_MR_ZYFP_COMPLETE;
		} else if (ICiMrDictCodeConst.MR_FP_XY_TYPE.equals(mrFpTypeParam)) {
			hospitalFPDTO = jctMrFpDataBP.getMrfpXYDataForIE(id_ent);
			serviceCode = IMrEventConst.EVENT_SOURCE_MR_FP_COMPLETE;
		}
		// && hospitalFirstPageDTO.getId_mrfp() != null
		// 完成书写时如果病案首页未提交，则通过完成书写上传病案首页数据，反之则无需再次上传  - by Vampire 2020.1.6
		if (hospitalFPDTO != null && (hospitalFPDTO.getFg_submit() == null || hospitalFPDTO.getFg_submit() == FBoolean.FALSE)) {
			MsgObj msgobj = new MsgObj();
			msgobj.setEnNO(id_ent);
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(hospitalFPDTO.getTimes_ip()));
			//msgobj.setPatientCode(hospitalFPDTO.getId_pat());
			msgobj.setInteractionCode(hospitalFPDTO.getType_message());
			// 上传病案首页数据
			DomainBusinessUserObj buo = new DomainBusinessUserObj(hospitalFPDTO, IMrPubConst.NOCAT, "0", "0");
			buo.setMsgObj(msgobj);
			BusinessEvent event = new BusinessEvent(serviceCode, IEventType.TYPE_UPDATE_AFTER, buo);
			BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
			beListener.doAction(event);
			// 上传术语：手术切口愈合等级
			DomainBusinessUserObj incicondiBuo = new DomainBusinessUserObj(hospitalFPDTO, IMrPubConst.ZY, "0", "0");
			BusinessEvent incicondiEvent = new BusinessEvent(IMrEventConst.MR_FP_INCICONDI_MSG, IEventType.TYPE_UPDATE_AFTER, incicondiBuo);
			BusinessEventListener incicondiBeListener = ServiceFinder.find(BusinessEventListener.class);
			incicondiBeListener.doAction(incicondiEvent);
			// 上传完成后，将病案首页主表中的上传标识修改为已上传状态
			if (!"1".equals(hospitalFPDTO.getType_message())) {
				jctMrFpDataBP.updateFlagForMrFpUpload(id_ent);
			}
		}
		return new FBoolean(true);
	}

	/**
	 * 设置病案表为完成状态，同时推送数据到CMIS --这是是铜陵代码逻辑，其他版本注意，修改推送数据逻辑--
	 * 
	 * @param id_ent
	 * @param nextIndex
	 *            下一步类型：1-不启用科室 启用终末 状态到 终末那里 2-不科室 不终末 直接到病案 3-书写完成，质控完成
	 *            4-单纯书写完成
	 * @return 是否操作成功
	 * @throws DAException
	 * @throws Exception_Exception
	 */
	private Boolean setAmrCompleteAndSendMsg(String id_ent, CompleteType nextIndex) throws BizException {
		Boolean operResult = false;// 操作结果
		ICiMrParamService paraSer = ServiceFinder.find(ICiMrParamService.class);
		Boolean canSend = paraSer.getSysParamSend2OthSys(Context.get().getOrgId());
		Boolean isByMonitor = paraSer.getSysParaIsPushMrByMonitor(Context.get().getOrgId());
		// if(!canSend) return operResult;//测试版不需要实际推送数据
		
		if(canSend && isByMonitor){
			 // 触发事件
			 BDCommonEvent event = new BDCommonEvent(IMrEventConst.EVENT_SOURCE_MR_AMR_COMPLETE, 
					 IEventType.TYPE_UPDATE_AFTER, new String[]{id_ent});
			 EventDispatcher.fireEvent(event);			
		}
		
		// 通过参数判断病案是否使用了第三方系统，若未使用，则不推送数据
		if (canSend && !isByMonitor) {
			/**
			 * 第三方操作结果
			 * <RESPONSE><RESULT_CODE>false</RESULT_CODE><RESULT_CONTENT></RESULT_CONTENT></RESPONSE>
			 * RESULT_CODE值为true代表成功。如果返回失败，RESULT_CONTENT会返回失败原因
			 */
			CMISSendServiceImpl _service = new CMISSendServiceImpl();
			String sendResult = "false";
			try {
				sendResult = _service.sendCMISMsg(id_ent);
			} catch (BizException e) {
				sendResult = "false";
				e.printStackTrace();
				throw new BizException("更新病案表失败");
			}
			if (!sendResult.contains("true"))
				throw new BizException("更新病案表失败");// 如果第三方未保存上数据，不置为完成
		}
		DAFacade daf = new DAFacade();
		StringBuilder sSql = new StringBuilder();

		switch (nextIndex) {
		case COMDEPTSCORE:
			sSql.append("UPDATE ci_amr SET fg_complete = 'Y', id_qa_doctor_part_sta = '"
					+ ICiMrDictCodeConst.ID_MR_COMDEPTSCORE + "', sd_qa_doctor_part_sta ='"
					+ ICiMrDictCodeConst.SD_MR_COMDEPTSCORE + "' WHERE id_ent = '");
			break;
		case COMTERMINALSCORE:
			sSql.append("UPDATE ci_amr SET fg_complete = 'Y', id_qa_doctor_part_sta = '"
					+ ICiMrDictCodeConst.ID_MR_COMTERMINALSCORE + "', sd_qa_doctor_part_sta ='"
					+ ICiMrDictCodeConst.SD_MR_COMTERMINALSCORE + "' WHERE id_ent = '");
			break;
		case COMWRITE:
			sSql.append(
					"UPDATE ci_amr SET fg_complete = 'Y', id_qa_doctor_part_sta = '" + ICiMrDictCodeConst.ID_MR_COMWRITE
							+ "', sd_qa_doctor_part_sta ='" + ICiMrDictCodeConst.SD_MR_COMWRITE + "' WHERE id_ent = '");
			break;
		case COMPLETE:
			//sSql.append("UPDATE ci_mr SET fg_complete = 'Y' WHERE id_ent = '");
			break;
		}
		sSql.append(id_ent);
		sSql.append("'");
		int result = daf.execUpdate(sSql.toString());
		if (result == 0)
			operResult = false;
		else
			operResult = true;
		return operResult;
	}

	/**
	 * 获取病案首页信息
	 * 
	 * @param Id_ent
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private HospitalFirstPageDTO getMrFpMsg(String id_ent) throws BizException {

		HospitalFirstPageDTO hospitalFirstPageDTO = new HospitalFirstPageDTO();

		FArrayList list_bl = new FArrayList();

		IBl2mrfpRService bl2mrfpRService = ServiceFinder.find(IBl2mrfpRService.class);
		CiMrFpBlDO[] ciMrFpBlDOArrs = bl2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_bl.add(ciMrFpBlDOArrs);
		hospitalFirstPageDTO.setLs_bl(list_bl);

		FArrayList list_di = new FArrayList();
		DiaInfoDTO diaInfoDTO = new DiaInfoDTO();// TODO 未赋值
		list_di.add(diaInfoDTO);
		hospitalFirstPageDTO.setLs_dia(list_di);

		FArrayList list_other = new FArrayList();
		IOther2mrfpMDORService other2mrfpMDORService = ServiceFinder.find(IOther2mrfpMDORService.class);
		CiMrFpOtherDO[] ciMrFpOtherDOArrs = other2mrfpMDORService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_other.add(ciMrFpOtherDOArrs);
		hospitalFirstPageDTO.setLs_other(list_other);

		FArrayList list_pat = new FArrayList();
		IPat2mrfpRService pat2mrfpRService = ServiceFinder.find(IPat2mrfpRService.class);
		CiMrFpPatDO[] ciMrFpPatDOArrs = pat2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_pat.add(ciMrFpPatDOArrs);
		hospitalFirstPageDTO.setLs_patient(list_pat);

		FArrayList list_sug = new FArrayList();
		ISug2mrfpRService sug2mrfpRService = ServiceFinder.find(ISug2mrfpRService.class);
		CiMrFpSugDO[] ciMrFpSugDOArrs = sug2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_sug.add(ciMrFpSugDOArrs);
		hospitalFirstPageDTO.setLs_sug(list_sug);

		// 重症监护
		// FArrayList list_inte = new FArrayList();
		// ICiMrfpIntenCareDORService ciMrfpIntenCareDORService = ServiceFinder
		// .find(ICiMrfpIntenCareDORService.class);
		// CiMrfpIntenCareDO[] ciMrfpIntenCareDOArrs = ciMrfpIntenCareDORService
		// .find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		// list_inte.add(ciMrfpIntenCareDOArrs);
		// hospitalFirstPageDTO.setLs_intencare(list_inte);

		// 缺少附页信息
		return hospitalFirstPageDTO;
	}

    public String CanCompleteEdit(String id_ent) throws BizException {
	    MrSignMvelBp bp=new MrSignMvelBp();
	    String id_user=Context.get().getUserId();
	    return bp.exec(id_ent,id_user);
	}
  

	@Override
	public MrDocRefValueDO[] SaveSourceReferences(MrDocRefValueDO[] ReferenceValues) throws BizException {
		if (ReferenceValues == null || ReferenceValues.length == 0)
			return null;
		IMrdocrefvalueRService rservice = ServiceFinder.find(IMrdocrefvalueRService.class);
		IMrdocrefvalueCudService cudservice = ServiceFinder.find(IMrdocrefvalueCudService.class);
		MrDocRefValueDO[] OldRefValueArr = rservice.find("id_mr = '" + ReferenceValues[0].getId_mr() + "'", null,
				new FBoolean(false));

		List<MrDocRefValueDO> beSaveValues = new ArrayList<MrDocRefValueDO>();
		MrDocRefValueDO[] savedValues;

		for (MrDocRefValueDO sValue : ReferenceValues) {
			boolean bFound = false;
			for (MrDocRefValueDO oValue : OldRefValueArr) {
				if (sValue.getId_ent().equals(oValue.getId_ent())
						&& sValue.getCode_element().equals(oValue.getCode_element())) {
					bFound = true;
					oValue.setId_mr(sValue.getId_mr());
					oValue.setContent(sValue.getContent());
					oValue.setStatus(DOStatus.UPDATED);
					beSaveValues.add(oValue);
					break;
				}

			}
			if (!bFound) {
				beSaveValues.add(sValue);

			}
		}

		// 删除机制有问题，暂时不进行删除操作 待定 ryp
		// List<MrDocRefValueDO> beDeleteValues = new
		// ArrayList<MrDocRefValueDO>();
		// for(MrDocRefValueDO sValue : OldRefValueArr)
		// {
		// boolean bFound = false;
		// for (MrDocRefValueDO oValue : beSaveValues) {
		// if (sValue.getId_ent().equals(oValue.getId_ent())
		// && sValue.getCode_element().equals(
		// oValue.getCode_element())) {
		// bFound = true;
		// break;
		// }
		// }
		// if(!bFound)
		// {
		// beDeleteValues.add(sValue);
		// }
		// }
		// cudservice.delete(beDeleteValues.toArray(new MrDocRefValueDO[0]));
		savedValues = cudservice.save(beSaveValues.toArray(new MrDocRefValueDO[0]));
		return savedValues;

	}

	@Override
	public void ClearSourceReferences(String id_ent) throws DAException {
		String sql = "delete from ci_mr_doc_reference_value t where t.id_ent='" + id_ent + "'";
		(new DAFacade()).deleteByWhere(MrDocRefValueDO.class, "id_ent='" + id_ent + "'");
	}

	@Override
	public MrfsDTO[] GetMrfsByDos(CiMrDO[] mrdos) throws BizException {
		if (null == mrdos || mrdos.length == 0)
			return null;
		DAFacade daf = new DAFacade();
		MrfsDTO[] result = new MrfsDTO[mrdos.length];
		StringBuilder sbIdmrs = new StringBuilder();
		sbIdmrs.append("('0'");
		for (int i = 0; i < result.length; i++) {

			String id_mr = mrdos[i].getId_mr();
			sbIdmrs.append(",'");
			sbIdmrs.append(id_mr);
			sbIdmrs.append("'");
		}
		sbIdmrs.append(")");
		String ssql = "SELECT cm.id_mr, cm.id_ent,cm.\"NAME\",cm.newend, cm.newtop, cm.code_entp, cm.id_mred,\n"
				+ "       cmf.emrfs\n" + "  FROM ci_mr cm\n" + "LEFT JOIN ci_mr_fs cmf\n" + "ON cm.id_mr = cmf.id_mr\n"
				+ "WHERE cm.id_mr in " + sbIdmrs.toString();
		@SuppressWarnings("unchecked")
		List<MrfsDTO> listMrDto = (List<MrfsDTO>) daf.execQuery(ssql, new BeanListHandler(MrfsDTO.class));

		MrfsDTO[] mrfsDtos = (MrfsDTO[]) listMrDto.toArray(new MrfsDTO[listMrDto.size()]);
		return mrfsDtos;
	}

	@Override
	public MrDTO[] GetMrDtoForOPTree(String id_ent, String id_mrcactm, String code_entp) throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
		sb.append("		cm.id_mr, cm.id_ent id_ent, cm.id_pat, cm.name,\n");
		sb.append("       cm.id_mrtp, cm.sd_su_mr, bmc.id_mrcactm,bmc.name mrcactm_name, \n");
		sb.append("       cm.id_emp_submit as id_treat_doctor , cm.id_submit_dept as id_dep_pat \n");
		sb.append("  FROM bd_mrca_ctm bmc, CI_MR cm\n");
		sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
		sb.append(" WHERE cm.ds = 0 and cm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' ");
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
			sb.append(" , '" + code_entp + "'");
		}
		sb.append(" )\n ");
		sb.append("   AND bmc.id_mrcactm LIKE '" + id_mrcactm + "'\n");
		sb.append("   AND cm.id_ent = '" + id_ent + "'\n");
		sb.append("   AND cm.id_mrcactm = bmc.id_mrcactm\n");
		sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + " \n");
		sb.append(" AND bmc.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' ");
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
			sb.append(" , '" + code_entp + "'");
		}
		sb.append(" )\n ");
		sb.append(" order by cm.dt_rd asc ");

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}

	@Override
	public MrDTO[] GetMrDtoForHelperTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals(""))
			docornur = "10";
		
		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		
		StringBuilder sb = new StringBuilder();
		sb.append("select su.name     as name_emp_submit, ");
		sb.append(" cm.dt_rd          as dt_rd, ");
		sb.append(" cm.id_mr          as id_mr, ");
		sb.append(" cm.id_ent         as id_ent, ");
		sb.append(" cm.id_pat         as id_pat, ");
		sb.append(" cm.name, ");
		sb.append(" cm.id_mrtp        as id_mrtp, ");
		sb.append(" cm.sd_su_mr, ");
		sb.append(" bmc.id_mrcactm, ");
		sb.append(" bmc.fg_cp, ");
		sb.append(" bmc.name          as mrcactm_name, ");
		sb.append(" cm.id_emp_submit  as id_treat_doctor, ");
		sb.append(" cm.id_submit_dept as id_dep_pat, ");
		sb.append(" bmc.id_fst, ");
		sb.append(" cqif.name         as fst_name ");
		sb.append("  from bd_mrca_ctm bmc ");
		sb.append("  join ci_mr cm ");
		sb.append("  on bmc.id_mrcactm = cm.id_mrcactm ");
		sb.append("  left outer join ci_qa_itm_fst cqif ");
		sb.append("  on cqif.id_fst = bmc.id_fst ");
		sb.append("  left outer join sys_user su ");
		sb.append("  on su.id_user = cm.id_emp_submit ");
		sb.append(" where cm.code_entp = '" + code_entp + "' ");
		sb.append(" and bmc.id_mrcactm like '" + id_mrcactm + "' ");
		sb.append(" and bmc.id_org = '" + Context.get().getOrgId() + "' ");
		sb.append(" and cm.id_ent = '" + id_ent + "' and cm.ds = 0 ");
		
		if (docornur.equals("20")) {
			sb.append(" and (bmc.docornur = '20' or bmc.docornur ='30') ");
		} else {
			sb.append(" and (bmc.docornur = '10' or bmc.docornur ='30') ");
		}
		sb.append(" and bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + " ");
		sb.append(" order by bmc.sortno,cm.dt_rd asc ");

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}

	@Override
	public MrDTO[] GetMrDtoForPastTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals("")) {
			docornur = "10";
		}

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		StringBuilder sb = new StringBuilder();
		if ("0".equals(paramtype))// 住院
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.id_emp_submit  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "' and cm.ds = 0 \n");
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			// sb.append(" AND cm.sd_su_mr <> '"+SuMrConst.SD_SUMR_NEW+"'\n"
			// );
			sb.append("   AND cm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ");
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}
		if ("1".equals(paramtype))// 门诊
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr, cm.id_ent id_ent, cm.id_pat, cm.name,\n");
			sb.append("       cm.id_mrtp, cm.sd_su_mr, bmc.id_mrcactm,bmc.name mrcactm_name, \n");
			sb.append("       cm.id_emp_submit as id_treat_doctor , cm.id_submit_dept as id_dep_pat \n");
			sb.append("  FROM bd_mrca_ctm bmc, CI_MR cm\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE cm.ds = 0 and cm.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' ");
			if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
				sb.append(" , '" + code_entp + "'");
			}
			sb.append(" )\n ");
			sb.append("   AND bmc.id_mrcactm LIKE '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'\n");
			sb.append("   AND cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + " \n");
			sb.append(" AND bmc.code_entp in ( '" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' ");
			if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
				sb.append(" , '" + code_entp + "'");
			}
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		// List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) listMrDto.toArray(new MrDTO[0]);
	}

	public MrDocRefValueDO[] GetSpecRefs(String id_ent, String[] arrRefCode) throws BizException {
		if (null == id_ent || "".equals(id_ent))
			return null;
		if (null == arrRefCode || arrRefCode.length == 0)
			return null;
		IMrdocrefvalueRService service = ServiceFinder.find(IMrdocrefvalueRService.class);

		// String strId = null;
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" (1=1)\n");
		sqlSb.append("and a0.id_ent = '" + id_ent + "' \n");
		sqlSb.append("and ( 1= 0\n ");
		for (String id_ref : arrRefCode) {
			sqlSb.append(" or a0.code_element ='" + id_ref + "' \n ");

		}
		sqlSb.append(" )");

		MrDocRefValueDO[] docRefValueDoArr = service.find(sqlSb.toString(), null, FBoolean.FALSE);

		return docRefValueDoArr;
	}

	/**
	 * 整合显示病历名称 显示为：名称+"_"+业务时间+"_"+提交人 如果提交人为空显示为：名称+"_"+业务时间
	 * 
	 * @param name
	 *            名称
	 * @param dt_rd
	 *            业务时间（精确到分钟）
	 * @param id_emp_submit
	 *            提交人
	 * @return 组合后的名称
	 */
	public String CombineName(String name, String dt_rd, String name_emp_submit) {
		StringBuilder returnV = new StringBuilder();
		if (name == null || "".equals(name) || "~".equals(name)) {
			returnV.append(name);
		} else if (dt_rd == null || "".equals(dt_rd) || "~".equals(dt_rd) || dt_rd.length() < 3) {
			returnV.append(name);
		} else if (name_emp_submit == null || "".equals(name_emp_submit) || "~".equals(name_emp_submit)) {
			returnV.append(name);
			returnV.append("_");
			returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
		} else {
			returnV.append(name);
			returnV.append("_");
			returnV.append(dt_rd.substring(0, dt_rd.length() - 3));
			returnV.append("_");
			returnV.append(name_emp_submit);
		}
		return returnV.toString();
	}

	/**
	 * 返回组合显示病历名称后的List<MrDTO>
	 * @param listMrDto
	 * @return 组合显示病历名称后的list
	 */
	public List<MrDTO> CombineNamesList(List<MrDTO> listMrDto) {
		List<MrDTO> listMrDto2 = new ArrayList<MrDTO>();
		
		for (MrDTO mr : listMrDto) {
			// mr.getName_emp_submit();
			// mr.getDt_rd();
			String CombineName = CombineName(mr.getName(), mr.getDt_rd(), mr.getName_emp_submit());
			mr.setName(CombineName);
			listMrDto2.add(mr);
		}
		return listMrDto2;
	}

	/**
	 * 根据用户id 和 签名密码获取64位base码
	 */
	@Override
	public String GetBase64ByUserIdAndPassWord(String userid, String password) throws BizException {
		IScviRService sr = ServiceFinder.find(IScviRService.class);
		String pic = sr.findBase64ByUserIdAndPassWord(userid, password);
		return pic;
	}

	/**
	 * 根据用户id 和 签名密码 校验密码是否正确
	 * 
	 * @param userid
	 * @param password
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean CheckPassWord(String userid, String password) throws BizException {
		boolean b = false;
		IScviRService sr = ServiceFinder.find(IScviRService.class);
		b = sr.checkPassWord(userid, password);
		return b;
	}

	@Override
	public boolean IsPicExist(String userid) throws BizException {
		boolean b = false;
		IScviRService sr = ServiceFinder.find(IScviRService.class);
		b = sr.isPicExist(userid);
		return b;
	}

	@Override
	public FMap2 getPicExist(String userid, String password) throws BizException {
		FMap2 fmap2 = new FMap2();
		IScviRService sr = ServiceFinder.find(IScviRService.class);
		fmap2 = sr.getPicExist(userid, password);
		return fmap2;
	}

	@Override
	public String GetPicByUserId(String userid) throws BizException {
		IScviRService sr = ServiceFinder.find(IScviRService.class);
		String pic = sr.findBase64ByUserId(userid);
		return pic;
	}

	/**
	 * 讲数据库中查询出的xml解析出来
	 * 
	 * @param xmlStr
	 * @param nodeName
	 * @return
	 * @throws BizException
	 */
	private String parseXml(String xmlStr, String nodeName) throws BizException {
		String returnV = "";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));

			Element root = doc.getDocumentElement();
			NodeList books = root.getChildNodes();
			if (books != null) {
				for (int i = 0; i < books.getLength(); i++) {
					Node book = books.item(i);
					if (book.getNodeName().equals(nodeName))
						returnV = book.getFirstChild().getNodeValue();
				}
			}

		} catch (Exception e) {
			throw new BizException("解析xml出错");
		}
		return returnV;
	}

	@Override
	public MrDTO[] getMrDtoForNurTree(String id_ent, String id_mrcactm, String code_entp) throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
		sb.append("		cm.id_mr, cm.id_ent id_ent, cm.id_pat, cm.name,\n");
		sb.append("       cm.id_mrtp, cm.sd_su_mr, bmc.id_mrcactm,bmc.name mrcactm_name, \n");
		sb.append("       cm.id_emp_submit as id_treat_doctor , cm.id_submit_dept as id_dep_pat \n");
		sb.append("  FROM bd_mrca_ctm bmc, CI_MR cm\n");
		sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
		sb.append(" WHERE cm.ds = 0 and cm.code_entp in ( '" + code_entp + "' ");
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
			sb.append(" , '" + code_entp + "'");
		}
		sb.append(" )\n ");
		sb.append("   AND bmc.id_mrcactm LIKE '" + id_mrcactm + "'\n");
		sb.append("   AND cm.id_ent = '" + id_ent + "'\n");
		sb.append("   AND ci.id_mrcactm = bmc.id_mrcactm\n");
		sb.append("   AND bmc.activestate = " + IPubEnumConst.ACTIVESTATE_ENABLE + " \n");
		sb.append(" AND bmc.code_entp in ( '" + code_entp + "' ");
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)) {
			sb.append(" , '" + code_entp + "'");
		}
		sb.append(" )\n ");
		sb.append(" And bmc.docornur in ('20','30') \n");
		sb.append(" order by cm.dt_rd asc ");

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrDTO.class));
		List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}

	@Override
	public String getCiMrXml2Str(String id_ent, String code_entp) throws BizException {
		String returnV = null;
		if (null == id_ent || "".equals(id_ent))
			return null;
		if (null == code_entp || "".equals(code_entp))
			return null;
		DAFacade daf = new DAFacade();

		StringBuilder sb = new StringBuilder();
		sb.append("select  cimrfs.emrfs,cimr.* from ci_mr_fs cimrfs , ci_mr cimr , \n");
		sb.append("(select mrtp.id_mrtp from bd_mrtp mrtp ,bd_mrca_ctm_itm itm , bd_mrca_ctm ctm \n");
		sb.append(" where mrtp.id_mrtp = itm.id_mrtp and itm.id_mrcactm = ctm.id_mrcactm \n");
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			sb.append(" and ctm.id_mrcactm = '01AMMMMMMMMMRM140003') mrtps  \n");// 病程自定义分类id
																					// 病程记录
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			sb.append(" and ctm.id_mrcactm = '0001AA10000000059Q9L') mrtps  \n");// 病程自定义分类id
																					// ，
																					// 门诊病历
		}
		sb.append("where cimr.id_mr = cimrfs.id_mr and \n");
		sb.append("cimr.id_ent = '" + id_ent + "' and cimr.code_entp = '" + code_entp + "'  \n");
		sb.append("and mrtps.id_mrtp = cimr.id_mrtp \n");
		sb.append("order by cimr.dt_rd desc \n");

		@SuppressWarnings("unchecked")
		List<MrfsDTO> listMrfsDto = (List<MrfsDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrfsDTO.class));
		if (listMrfsDto.size() > 0) {
			byte[] encode = Base64.encode(listMrfsDto.get(0).getEmrfs());
			try {
				returnV = new String(encode, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new BizException("解析xml出错");
			}
		}
		returnV = parseXml(returnV, "BodyText");
		return returnV;
	}

	@Override
	public String getCiMrXml(String id_ent, String code_entp) throws BizException {
		String returnV = null;
		if (null == id_ent || "".equals(id_ent))
			return null;
		if (null == code_entp || "".equals(code_entp))
			return null;
		DAFacade daf = new DAFacade();

		StringBuilder sb = new StringBuilder();
		sb.append("select  cimrfs.emrfs,cimr.* from ci_mr_fs cimrfs , ci_mr cimr , \n");
		sb.append("(select mrtp.id_mrtp from bd_mrtp mrtp ,bd_mrca_ctm_itm itm , bd_mrca_ctm ctm \n");
		sb.append(" where mrtp.id_mrtp = itm.id_mrtp and itm.id_mrcactm = ctm.id_mrcactm \n");
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			sb.append(" and ctm.id_mrcactm = '01AMMMMMMMMMRM140003') mrtps  \n");// 病程自定义分类id
																					// 病程记录
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			sb.append(" and ctm.id_mrcactm = '0001AA10000000059Q9L') mrtps  \n");// 病程自定义分类id
																					// ，
																					// 门诊病历
		}
		sb.append("where cimr.id_mr = cimrfs.id_mr and \n");
		sb.append("cimr.id_ent = '" + id_ent + "' and cimr.code_entp = '" + code_entp + "'  \n");
		sb.append("and mrtps.id_mrtp = cimr.id_mrtp \n");
		sb.append("order by cimr.dt_rd desc \n");

		@SuppressWarnings("unchecked")
		List<MrfsDTO> listMrfsDto = (List<MrfsDTO>) daf.execQuery(sb.toString(), new BeanListHandler(MrfsDTO.class));
		if (listMrfsDto.size() > 0) {
			byte[] encode = Base64.encode(listMrfsDto.get(0).getEmrfs());
			try {
				returnV = new String(encode, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new BizException("解析xml出错");
			}
		}

		return returnV;

	}

	@Override
	public CiMrDO[] GetHasDelMrByEnt(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();

		String sql = "select mr.*,su.name as modifiedby_name from ci_mr mr  "
				+ "left join sys_user su  on su.id_user=mr.modifiedby  " + "where mr.ds='1' and mr.id_ent='" + id_ent
				+ "'";

		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql, new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);
	}

	@Override
	public CiMrDO[] getCiMrByIdMr(String id_mr) throws DAException {
		DAFacade daf = new DAFacade();
		String sql = "select t.* from ci_mr t where t.id_mr = '" + id_mr + "'";
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql, new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);
	}

	public CiMrDO[] getAllCiMrList(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		String sql = "select id_mr,id_grp,id_org,id_ent,id_pat,name,id_mrcactm,id_mrtp,id_su_mr,sd_su_mr,fg_complete,id_reviewtp,sd_reviewtp,id_mrtpl,id_mred,startparaed,id_mrtplstmd,sd_mrtplstmd,url_file,id_emp_submit,date_submit,"
				+ " date_time_show,id_submit_dept,code_dept_pat,id_treat_doctor,id_mast_doctor,mast_doctor_date,id_dir_doctor,dir_doctor_date,id_entp,code_entp,"
				+ " fg_duty_doctor,dt_rd,id_emp,id_dep,id_emp_higher,dt_sign,id_emp_lat,dt_sign_lat,id_emp_audit,dt_audit_lat,scoreqalat,fg_edit,fg_submit,fg_reject,fg_seal,fg_arc,fg_prn,createdby,createdtime,modifiedby,modifiedtime,"
				+ " task_id,id_dep_pat,id_flowtype,id_dep_nuradm,id_bed,id_sex,pat_age,newtop,newend,sign_suggestion,fg_sign from ci_mr  where id_ent = '"
				+ id_ent + "'";
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql, new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);
	}

	public CiMrDO[] getAllCiMrListButDelete(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		String sql = "select id_mr,id_grp,id_org,id_ent,id_pat,name,id_mrcactm,id_mrtp,id_su_mr,sd_su_mr,fg_complete,id_reviewtp,sd_reviewtp,id_mrtpl,id_mred,startparaed,id_mrtplstmd,sd_mrtplstmd,url_file,id_emp_submit,date_submit,"
				+ " date_time_show,id_submit_dept,code_dept_pat,id_treat_doctor,id_mast_doctor,mast_doctor_date,id_dir_doctor,dir_doctor_date,id_entp,code_entp,"
				+ " fg_duty_doctor,dt_rd,id_emp,id_dep,id_emp_higher,dt_sign,id_emp_lat,dt_sign_lat,id_emp_audit,dt_audit_lat,scoreqalat,fg_edit,fg_submit,fg_reject,fg_seal,fg_arc,fg_prn,createdby,createdtime,modifiedby,modifiedtime,"
				+ " task_id,id_dep_pat,id_flowtype,id_dep_nuradm,id_bed,id_sex,pat_age,newtop,newend,sign_suggestion,fg_sign from ci_mr  where ds=0 and id_ent = '"
				+ id_ent + "'";
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql, new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);
	}

	/*
	 * 根据患者就诊号，获取患者所有的病历文书
	 */
	public CiMrDO[] getPatCiMrList(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		String sql = "select ci_mr.id_mr,ci_mr.id_grp,ci_mr.id_org,ci_mr.id_ent,ci_mr.id_pat,"
				+ "ci_mr.name,ci_mr.id_mrcactm,ci_mr.id_mrtp,ci_mr.id_su_mr,ci_mr.sd_su_mr,ci_mr.fg_complete,ci_mr.id_reviewtp,"
				+ "ci_mr.sd_reviewtp,ci_mr.id_mrtpl,ci_mr.id_mred,ci_mr.startparaed,ci_mr.id_mrtplstmd,ci_mr.sd_mrtplstmd,ci_mr.url_file,"
				+ "ci_mr.id_emp_submit,ci_mr.date_submit, ci_mr.date_time_show,ci_mr.id_submit_dept,ci_mr.code_dept_pat,"
				+ "ci_mr.id_treat_doctor,ci_mr.id_mast_doctor,ci_mr.mast_doctor_date,ci_mr.id_dir_doctor,"
				+ "ci_mr.dir_doctor_date,ci_mr.id_entp,ci_mr.code_entp,"
				+ " ci_mr.fg_duty_doctor,ci_mr.dt_rd,ci_mr.id_emp,ci_mr.id_dep,ci_mr.id_emp_higher,"
				+ "ci_mr.dt_sign,ci_mr.id_emp_lat,ci_mr.dt_sign_lat,ci_mr.id_emp_audit,ci_mr.dt_audit_lat,"
				+ "ci_mr.scoreqalat,ci_mr.fg_edit,ci_mr.fg_submit,ci_mr.fg_reject,ci_mr.fg_seal,ci_mr.fg_arc,"
				+ "ci_mr.fg_prn,ci_mr.createdby,ci_mr.createdtime,ci_mr.modifiedby,ci_mr.modifiedtime,"
				+ " ci_mr.task_id,ci_mr.id_dep_pat,ci_mr.id_flowtype,ci_mr.id_dep_nuradm,ci_mr.id_bed,"
				+ "ci_mr.id_sex,ci_mr.pat_age,ci_mr.newtop,ci_mr.newend,ci_mr.sign_suggestion,ci_mr.fg_sign "
				+ " from en_ent,ci_mr" + " where en_ent.id_pat = ci_mr.id_pat and ci_mr.ds =0 and en_ent.id_ent = '"
				+ id_ent + "'";
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql, new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);

	}

	/**
	 * 宏元素自定义节点数据调用查询方法
	 * 
	 * @param id_ent
	 * @param id_type
	 * @throws BizException
	 * @throws SQLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FMap2 getMacroResultMap(String id_ent, String sd_type, String[] arrMacroCodes)
			throws BizException, SQLException {
		FMap2 MacroResultMap = new FMap2();
		// 拼接条件，查询宏元素自定义表
		StringBuilder sqlWhere1 = new StringBuilder();
		
		sqlWhere1.append(" where bd_marco_value.sd_type = '");
		sqlWhere1.append(sd_type);
		sqlWhere1.append("' and bd_marco_value.id_org = '"+Context.get().getOrgId()+"'");
		sqlWhere1.append("  and bd_marco_value.fg_active = 'Y' and bd_mr_de.id_mr_de is not null");
		// 调用sql方法
		StringBuilder sqlSB = getCiMrmMacroValueDTOSql(sqlWhere1.toString());
		String sqlMacroCodes = StringOperUtil.arrayStringJoin(arrMacroCodes, ",", "'", "'");
		sqlSB.append(" and bd_de.code in (" + sqlMacroCodes + ")");
		sqlSB.append(" order by name_table ");
		String sqlStr = sqlSB.toString();
		// 查询结果集，开始拼接sql
		DAFacade daf1 = new DAFacade();
		List<CiMrmMacroValueDTO> MacroValueDTOList = (List<CiMrmMacroValueDTO>) daf1.execQuery(sqlStr,
				new BeanListHandler(CiMrmMacroValueDTO.class));

		if (MacroValueDTOList == null || MacroValueDTOList.size() <= 0) {
			return new FMap2();
		}
		// key：code_de/value：name_column
		Map<String, String> nameColumnMap = new HashMap<String, String>();

		int num = 0;
		for (int i = 0; i < MacroValueDTOList.size(); i++) {
			CiMrmMacroValueDTO macroValueDo = MacroValueDTOList.get(i);
			// 如果此条数据未启用，跳过
			if (macroValueDo.getFg_active().equals("N")) {
				continue;
			}
			// 获取结果集中的第一个对象，开始拼接sql
			StringBuilder sqlWhere2 = new StringBuilder();
			sqlWhere2.append(" select ");
			sqlWhere2.append(macroValueDo.getName_column());
			nameColumnMap.put(macroValueDo.getCode_de(), macroValueDo.getName_column());

			for (int j = i + 1; j < MacroValueDTOList.size(); j++) {
				// 如果此条数据未启用，跳过
				if (MacroValueDTOList.get(j).getFg_active().equals("N")) {
					continue;
				}
				// 前一个对象的Name_table与后一个对象的Name_table比较，来确定是否是用于同一组查询的数据
				if (!MacroValueDTOList.get(i).getName_table().equals(MacroValueDTOList.get(j).getName_table())) {
					num = i;
					i = j - 1;// 控制i的数值，让i从每一组的第一个开始循环
					break;
				}
				// 拼接同组sql的查询字段，直到出现新的一组数据停止当前这组的循环
				sqlWhere2.append(" , ");
				sqlWhere2.append(MacroValueDTOList.get(j).getName_column());
				nameColumnMap.put(MacroValueDTOList.get(j).getCode_de(), MacroValueDTOList.get(j).getName_column());
			}
			// 当前组的查询字段的拼接完成，将完整的sql先add到集合中
			sqlWhere2.append(" from ");
			sqlWhere2.append(MacroValueDTOList.get(num).getName_table());
			sqlWhere2.append(" '");
			sqlWhere2.append(id_ent);
			sqlWhere2.append("' ");
			String sql = sqlWhere2.toString();
			// 通过最终拼接的sql查询，将查询数据封装到Map中返回给前台
			DAFacade daf2 = new DAFacade();
			List<Map<String, String>> resultList = (List<Map<String, String>>) daf2.execQuery(sql, new MapListHandler());

			for (Map resultMap : resultList) {
				Set<Entry<String, String>> entrySet = nameColumnMap.entrySet();

				for (Entry<String, String> entry : entrySet) {
					if (entry == null || entry.getValue() == null) {
						continue;
					}
					String columnValue = entry.getValue();
					if (columnValue.contains(".")) {
						columnValue = columnValue.substring(columnValue.indexOf(".") + 1);
					}
					if (entry == null || entry.getKey() == null) {
						continue;
					}
					String key = entry.getKey();
					Object obj = resultMap.get(columnValue.replaceAll(" ", "").toUpperCase());
					String value = "";
					if (obj != null) {
						value = obj.toString();
						MacroResultMap.put(key, value);
					}
				}
			}
			num = i + 1;
			nameColumnMap.clear();// 重置sql的查询数据
		}
		return MacroResultMap;
	}

	/**
	 * getMacroResultMap方法查询sql
	 * @param 查询条件
	 * @return sql
	 */
	private StringBuilder getCiMrmMacroValueDTOSql(String sqlWhere1) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select bd_marco_value.id_marco_value as id_marco_value, ");// 宏元素主键
		sql.append(" bd_marco_value.id_grp as id_grp, ");// 所属集团
		sql.append(" bd_marco_value.id_org as id_org, ");// 所属组织
		sql.append(" bd_marco_value.id_type as id_type, ");// 宏元素自定义主键
		sql.append(" bd_marco_value.sd_type as sd_type, ");// 宏元素自定义编码
		sql.append(" bd_marco_value.name_type as name_type, ");// 宏元素自定义名称
		sql.append(" bd_marco_value.id_mr_de as id_mr_de, ");// 病历元素主键
		sql.append(" bd_marco_value.sd_mr_de as sd_mr_de, ");// 病历元素编码
		sql.append(" bd_marco_value.name_mr_de as name_mr_de, ");// 病历元素名称
		sql.append(" bd_marco_value.name_table as name_table, ");// 表名
		sql.append(" bd_marco_value.name_column as name_column, ");// 字段名
		sql.append(" bd_marco_value.fg_active as fg_active, ");// 是否启用
		sql.append(" bd_de.code as code_de ");// 公共数据元编码
		sql.append(" from bd_marco_value ");
		sql.append(" left join bd_mr_de bd_mr_de ");
		sql.append(" on bd_marco_value.id_mr_de = bd_mr_de.id_mr_de ");
		sql.append(" left join bd_de bd_de ");
		sql.append(" on bd_mr_de.id_de = bd_de.id_de ");
		sql.append(sqlWhere1);

		return sql;
	}
	
	@Override
	public MrDTO[] GetMrDtoForQcTree(String id_ent, String id_mrcactm, String code_entp, String paramtype,
			String docornur) throws BizException {
		if (id_ent == null || id_ent.equals(""))
			throw new BizException("病人就诊号不能为空");
		if (code_entp == null || code_entp.equals(""))
			throw new BizException("就诊类型不能为空");
		if (docornur == null || docornur.equals("")) {
			docornur = "10";
		}

		DAFacade daf = new DAFacade();
		IPativisitRService service = ServiceFinder
				.find(IPativisitRService.class);
		iih.en.pv.pativisit.d.PatiVisitDO patiVisitDo = service
				.findById(id_ent);
		if (patiVisitDo == null)
			throw new BizException("病人就诊号为不存在");
		StringBuilder sb = new StringBuilder();
		if ("0".equals(paramtype))// 住院
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.createdby  id_treat_doctor,\n");
			sb.append("       cm.id_dep_pat id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       bm.code as code_mrtp,\n");
			sb.append("       bmc.code as code_mrcactm,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  LEFT  JOIN bd_mrtp bm\n");
			sb.append("    ON cm.id_mrtp = bm.id_mrtp\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'  and cm.ds = 0 \n ");
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = "
					+ IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			sb.append("   AND cm.sd_su_mr not in ('" + SuMrConst.SD_SUMR_NEW + "','"+SuMrConst.SD_SUMR_RETRIEVE+"','"+SuMrConst.SD_SUMR_REJECT+"')\n");
			sb.append("   AND cm.code_entp in ( '"
					+ IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' ");
	
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");

		}
		if ("1".equals(paramtype))// 门诊
		{
			sb.append("SELECT su.name as name_emp_submit,cm.dt_rd as dt_rd,\n");
			sb.append("       cm.id_mr,\n");
			sb.append("       cm.id_ent         id_ent,\n ");
			sb.append("       cm.id_pat,\n");
			sb.append("       cm.name,\n");
			sb.append("       cm.id_mrtp,\n");
			sb.append("       cm.sd_su_mr,\n");
			sb.append("       bmc.id_mrcactm,\n");
			sb.append("       bmc.name          mrcactm_name,\n");
			sb.append("       cm.createdby  id_treat_doctor,\n");
			sb.append("       cm.id_submit_dept id_dep_pat,\n");
			sb.append("       bmc.id_fst,\n");
			sb.append("       cqif.name         fst_name\n");
			sb.append("  FROM bd_mrca_ctm bmc\n");
			sb.append("  JOIN CI_MR cm\n");
			sb.append("  ON  cm.id_mrcactm = bmc.id_mrcactm\n");
			sb.append("  LEFT outer JOIN ci_qa_itm_fst cqif\n");
			sb.append("    ON cqif.id_fst = bmc.id_fst\n");
			sb.append("  left outer join sys_user su on su.id_user = cm.id_emp_submit \n");
			sb.append(" WHERE bmc.code_entp = '" + code_entp + "'\n");
			sb.append("   AND bmc.id_mrcactm like '" + id_mrcactm + "'\n");
			sb.append("   AND cm.id_ent = '" + id_ent + "'  and cm.ds = 0 \n ");
			if (docornur.equals("20")) {
				sb.append("	AND (bmc.docornur = '20' or bmc.docornur ='30')");
			} else {
				sb.append("	AND (bmc.docornur = '10' or bmc.docornur ='30')");
			}
			sb.append("   AND bmc.activestate = "
					+ IPubEnumConst.ACTIVESTATE_ENABLE + "\n");
			
			sb.append("   AND cm.code_entp in ( '"
					+ code_entp + "' ");
	
			sb.append(" )\n ");
			sb.append(" order by cm.dt_rd asc ");
			


		}

		@SuppressWarnings("unchecked")
		List<MrDTO> listMrDto = (List<MrDTO>) daf.execQuery(sb.toString(),
				new BeanListHandler(MrDTO.class));
		List<MrDTO> list = CombineNamesList(listMrDto);
		return (MrDTO[]) list.toArray(new MrDTO[0]);
	}
	/**
	 * 判断sql语句是否可以执行
	 * 
	 * @param sql
	 * @return
	 * @throws DAException
	 */
	public FBoolean judgeSQLRunResult(MacroValueDo sData) throws DAException {
		FBoolean res = FBoolean.FALSE;
		try {
			DAFacade da = new DAFacade();
			String sql = "select " + sData.getName_column() + " from " + sData.getName_table() + "''";
			Object obj = da.execQuery(sql, new ArrayListHandler());
			// 执行不报异常就是可以执行
			res = FBoolean.TRUE;
		} catch (DAException e) {
			throw new DAException("请检查sql语句（表名和字段），执行不正确");
		}
		return res;
	}

	@Override
	public Boolean SubmitRecallMrfp(String id_ent) throws BizException {
		ICiamrRService ciAmrRService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDos = ciAmrRService.find("id_ent = '" + id_ent + "'", "", FBoolean.FALSE);
		
		if (aMrDos.length <= 0) {
			return false;
		} else {
			ICiamrCudService ciAmrCudService = ServiceFinder.find(ICiamrCudService.class);
			aMrDos[0].setFg_amr_callback(FBoolean.FALSE);
			ciAmrCudService.update(aMrDos);
			HospitalFirstPageDTO hospitalFirstPageDTO = new HospitalFirstPageDTO();
			hospitalFirstPageDTO.setCode_ent_liushui(id_ent);
			ICimrfpRService mrfpService = ServiceFinder.find(ICimrfpRService.class);
			CiMrFpDO[] mrfoDoArr = mrfpService.find(" id_ent='" + id_ent + "'", "", FBoolean.FALSE);
			if (mrfoDoArr != null && mrfoDoArr.length > 0) {
				hospitalFirstPageDTO.setId_mrfp(mrfoDoArr[0].getId_mrfp());
			}
			HospitalFirstPageDTO[] doEventArr = new HospitalFirstPageDTO[] { hospitalFirstPageDTO };
			MrCommonUtils.fireBDEvent(IMrEventConst.EVENT_SOURCE_MR_AMR_COMPLETE, IEventType.TYPE_UPDATE_AFTER,
					doEventArr);
		}
		return true;
	}

	@Override
	public Boolean RejectMrfp(String id_ent) throws BizException {
		ICiamrRService ciAmrRService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] aMrDos = ciAmrRService.find("id_ent = '" + id_ent + "'", "", FBoolean.FALSE);
		
		if (aMrDos.length <= 0) {
			return false;
		} else {
			ICiamrCudService ciAmrCudService = ServiceFinder.find(ICiamrCudService.class);
			aMrDos[0].setFg_amr_callback(FBoolean.TRUE);
			ciAmrCudService.update(aMrDos);
			IPativisitRService iPativisitRService = ServiceFinder.find(IPativisitRService.class);
			PatiVisitDO[] patiVisitDos = iPativisitRService.find("id_ent = '" + id_ent + "'", "", FBoolean.FALSE);
			IIPMrService iIPMrService = ServiceFinder.find(IIPMrService.class);
			iIPMrService.sendRejectMrfpMsg(patiVisitDos[0]);
		}
		return true;
	}

	@Override
	public CiMrDO[] GetMrByMrCaAndType(String id_ent, String id_mrcactm, String code_entp, String docornur, String id_mr_bt) throws BizException {
		if (id_ent == null || id_ent == "")
			throw new BizException("病人就诊号不能为空");

		if (code_entp == null || code_entp == "")
			throw new BizException("就诊类型不能为空");

		if (docornur == null || docornur.equals("")) {
			docornur = ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_DOC;
		}

		DAFacade daf = new DAFacade();
		String sql1 = "select a0.id_mrcactm,a0b27.code Bed_code,a0b27.name Bed_name,a0.Code_dept_pat,a0.Code_entp,a0b15.code Createby_code,a0b15.name Createby_name,a0.Createdby,a0.Createdtime,a0.Date_submit,a0.Date_time_show,a0b11.code Dep_code,a0b11.name Dep_name,a0b24.code Dep_pat_code,a0b24.name Dep_pat_name,a0b26.code Deptline_code,a0b26.name Deptline_name,a0b23.code Dir_code,a0.Dir_doctor_date,a0b23.name Dir_name,a0.Ds,a0.Dt_audit_lat,a0.Dt_rd,a0.Dt_sign,a0.Dt_sign_lat,a0b13.code Emp_audit_code,a0b13.name Emp_audit_name,a0b10.code Emp_code,a0b17.code Emp_higher_code,a0b17.name Emp_higher_name,a0b12.code Emp_lat_code,a0b12.name Emp_lat_name,a0b10.name Emp_name,a0b19.code Emp_submit_code,a0b19.name Emp_submit_name,a0b4.code Entp_code,a0b4.name Entp_name,a0.Fg_arc,a0.Fg_complete,a0.Fg_duty_doctor,a0.Fg_edit,a0.Fg_prn,a0.Fg_reject,a0.Fg_seal,a0.Fg_submit,a0b25.typecode Flowtype_typecode,a0b25.typename Flowtype_typename,a0b1.code Grp_code,a0b1.name Grp_name,a0.Id_bed,a0.Id_dep,a0.Id_dep_nuradm,a0.Id_dep_pat,a0.Id_dir_doctor,a0.Id_emp,a0.Id_emp_audit,a0.Id_emp_higher,a0.Id_emp_lat,a0.Id_emp_submit,a0.Id_ent,a0.Id_entp,a0.Id_flowtype,a0.Id_grp,a0.Id_mast_doctor,a0.Id_mr,a0b18.id_mr_finish_status Id_mr_finish_status,a0.Id_mred,a0.Id_mrtp,a0.Id_mrtpl,a0.Id_mrtplstmd,a0.Id_org,a0.Id_pat,a0.Id_reviewtp,a0.Id_sex,a0.Id_su_mr,a0.Id_submit_dept,a0.Id_treat_doctor,a0b22.code Mast_code,a0.Mast_doctor_date,a0b22.name Mast_name,a0.Modifiedby,a0b16.code Modifiedby_code,a0b16.name                Modifiedby_name,a0.Modifiedtime,a0b8.code Mred_code,a0b8.name Mred_name,a0b6.code Mrtp_code,a0b6.name Mrtp_name,a0b7.code Mrtpl_code,a0b7.name Mrtpl_name,a0b9.code Mrtplstmd_code,a0b9.name Mrtplstmd_name,a0.Name,a0.Newend,a0.Newtop,a0b2.code Org_code,a0b2.name                 Org_name,a0.Pat_age,a0b3.code Pat_code,a0b3.name Pat_name,a0b18.code Reviewtp_code,a0b18.name                Reviewtp_name,a0.Scoreqalat,a0.Sd_mrtplstmd,a0.Sd_reviewtp,a0.Sd_su_mr,a0.Sign_suggestion,a0.Startparaed,a0b14.code Su_mr_code,a0b14.name Su_mr_name,a0b20.code Submit_dept_code,a0b20.name Submit_dept_name,a0.Sv,a0.Task_id,a0b21.code Treat_code,a0b21.name Treat_name,a0.Url_file,a0.fg_sign\n";
		String sql2 = "  from ci_mr a0\n" + "  left outer join bd_bed a0b27\n" + "    ON a0.id_bed = a0b27.id_bed\n"
				+ "  left outer join sys_user a0b15\n" + "    ON a0.createdby = a0b15.id_user\n"
				+ "  left outer join bd_dep a0b11\n" + "    ON a0.id_dep = a0b11.id_dep\n"
				+ "  left outer join bd_dep a0b24\n" + "    ON a0.id_dep_pat = a0b24.id_dep\n"
				+ "  left outer join BD_DEPL a0b26\n" + "    ON a0.id_dep_nuradm = a0b26.id_depl\n"
				+ "  left outer join sys_user a0b23\n" + "    ON a0.id_dir_doctor = a0b23.id_user\n"
				+ "  left outer join sys_user a0b13\n" + "    ON a0.id_emp_audit = a0b13.id_user\n"
				+ "  left outer join sys_user a0b10\n" + "    ON a0.id_emp = a0b10.id_user\n"
				+ "  left outer join sys_user a0b17\n" + "    ON a0.id_emp_higher = a0b17.id_user\n"
				+ "  left outer join sys_user a0b12\n" + "    ON a0.id_emp_lat = a0b12.id_user\n"
				+ "  left outer join sys_user a0b19\n" + "    ON a0.id_emp_submit = a0b19.id_user\n"
				+ "  left outer join bd_entp a0b4\n" + "    ON a0.id_entp = a0b4.id_entp\n"
				+ "  left outer join wf_flwtype a0b25\n" + "    ON a0.id_flowtype = a0b25.id_flowtype\n"
				+ "  left outer join bd_grp a0b1\n" + "    ON a0.id_grp = a0b1.id_grp\n"
				+ "  left outer join bd_reviewtp a0b18\n" + "    ON a0.id_reviewtp = a0b18.id_reviewtp\n"
				+ "  left outer join sys_user a0b22\n" + "    ON a0.id_mast_doctor = a0b22.id_user\n"
				+ "  left outer join sys_user a0b16\n" + "    ON a0.modifiedby = a0b16.id_user\n"
				+ "  left outer join bd_mred a0b8\n" + "    ON a0.id_mred = a0b8.id_mred\n"
				+ "  left outer join bd_mrtp a0b6\n" + "    ON a0.id_mrtp = a0b6.id_mrtp\n"
				+ "  left outer join bd_mrtpl a0b7\n" + "    ON a0.id_mrtpl = a0b7.id_mrtpl\n"
				+ "  left outer join bd_udidoc a0b9\n" + "    ON a0.id_mrtplstmd = a0b9.id_udidoc\n"
				+ "  left outer join bd_org a0b2\n" + "    ON a0.id_org = a0b2.id_org\n"
				+ "  left outer join pi_pat a0b3\n" + "    ON a0.id_pat = a0b3.id_pat\n"
				+ "  left outer join bd_udidoc a0b14\n" + "    ON a0.id_su_mr = a0b14.id_udidoc\n"
				+ "  left outer join bd_dep a0b20\n" + "    ON a0.id_submit_dept = a0b20.id_dep\n"
				+ "  left outer join sys_user a0b21\n" + "    ON a0.id_treat_doctor = a0b21.id_user\n"
				// + " left outer join bd_mrca_ctm_itm itm\n"
				// + " on itm.id_mrtp = a0.id_mrtp\n"
				+ "  left outer join bd_mrca_ctm ctm\n" + "    on ctm.id_mrcactm = a0.id_mrcactm\n";
		SqlParam sp = new SqlParam();

		StringBuilder sb = new StringBuilder();
		if (id_mr_bt != null && id_mr_bt != "") {
			sb.append(" a0.id_mr_bt = ? and");
			sp.addParam(id_mr_bt);
		}
		sb.append(" (a0.id_ent = ?) ");
		sp.addParam(id_ent);
		sb.append(" and a0.ds!=1 ");
		
		if (id_mrcactm != null && !id_mrcactm.equals("") && !id_mrcactm.equals("%")) {
			sb.append(" and ctm.id_mrcactm = ? ");
			sp.addParam(id_mrcactm);
		}
		sb.append(" and ctm.code_entp = ?");
		sp.addParam(code_entp);
		
		if (docornur.equals(ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_NUR)) {
			sb.append("	AND (ctm.docornur = '" + ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_NUR + "' or ctm.docornur ='"
					+ ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_ALL + "')");
		} else {
			sb.append("	AND (ctm.docornur = '" + ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_DOC + "' or ctm.docornur ='"
					+ ICiMrDictCodeConst.SD_UDIDOCLIST_MROWNTP_ALL + "')");
		}

		String whereStr = sb.toString();
		String orderBy = " order by ctm.sortno,dt_rd desc";
		String sql = sql1 + sql2 + " where \n" + whereStr + orderBy;
		// CiMrDO[] mrDos = cmservice.find(whereStr, "dt_rd", new
		// FBoolean(false));
		// return mrDos;
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql, sp, new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);
	}
	
	/**
	 * 病案首页提交后上传集成平台
	 */
	public FBoolean CompleteMrFpEdit(final String id_ent) throws BizException {
		String sWhere = " a0.id_ent = '" + id_ent + "' and fg_submit = 'Y' ";
		ICimrfpRService mrfpService = ServiceFinder.find(ICimrfpRService.class);
		CiMrFpDO[] mrfoDoArr = mrfpService.find(sWhere, "", FBoolean.FALSE);
		
		if (mrfoDoArr != null && mrfoDoArr.length <= 0) {
			throw new BizException("该病人病案首页未提交");
		}
		//因为消息BS342住院病案首页信息服务是在完成书写时发送的，所以将病案首页提交里面消息发送的注掉
//		TransactionExecutor.executeNewTransaction(new TransactionalOperation<Object>() {
//			@Override
//			public Object doInTransaction(TransactionStatus arg0) throws InvocationTargetException {
//				// 里面不要吞掉异常
//				// insert do1 有异常回滚
//				// insert do2 有异常回滚 do1
//				// insert do3 有异常回滚 do1 do2
//				try {
//					HospitalFirstPageDTO hospitalFirstPageDTO = new HospitalFirstPageDTO();
//					hospitalFirstPageDTO.setCode_ent_liushui(id_ent);
//					ICimrfpRService mrfpService = ServiceFinder.find(ICimrfpRService.class);
//					CiMrFpDO[] mrfoDoArr = mrfpService.find(" id_ent='" + id_ent + "'", "", FBoolean.FALSE);
//					if (mrfoDoArr != null && mrfoDoArr.length > 0) {
//						hospitalFirstPageDTO.setId_mrfp(mrfoDoArr[0].getId_mrfp());
//					}
//					/*HospitalFirstPageDTO[] doEventArr = new HospitalFirstPageDTO[] { hospitalFirstPageDTO };
//					MrCommonUtils.fireBDEvent(IMrEventConst.EVENT_SOURCE_MR_AMR_COMPLETE, IEventType.TYPE_UPDATE_AFTER,
//							doEventArr);*/
//					
//					// 发送集成平台消息	
//					DomainBusinessUserObj buo = new DomainBusinessUserObj(hospitalFirstPageDTO, IMrPubConst.NOCAT, "0", "0");
//					BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_FP_COMPLETE,IEventType.TYPE_UPDATE_AFTER, buo);
//					BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
//					beListener.doAction(event);
//
//				} catch (Exception e) {
//					throw new BizRuntimeException(e.getMessage());
//				}
//				return null;
//			}
//		});
		// 发送集成平台消息
		ICiMrParamService paramService = ServiceFinder.find(ICiMrParamService.class);
		String mrFpTypeParam = paramService.getSysParamMrFpType(Context.get().getDeptId());
		
		String serviceCode = "";
		HospitalFirstPageDTO hospitalFPDTO = new HospitalFirstPageDTO();
		JCPTMrFpDataBP jctMrFpDataBP = new JCPTMrFpDataBP();
		// 根据参数判断查询中医或西医病案首页数据
		if (ICiMrDictCodeConst.MR_FP_ZY_TYPE.equals(mrFpTypeParam)) {
			hospitalFPDTO = jctMrFpDataBP.getMrfpZYDataForIE(id_ent);
			serviceCode = IMrEventConst.EVENT_SOURCE_MR_ZYFP_COMPLETE;
		} else if (ICiMrDictCodeConst.MR_FP_XY_TYPE.equals(mrFpTypeParam)) {
			hospitalFPDTO = jctMrFpDataBP.getMrfpXYDataForIE(id_ent);
			serviceCode = IMrEventConst.EVENT_SOURCE_MR_FP_COMPLETE;
		}
		// && hospitalFirstPageDTO.getId_mrfp() != null
		if (hospitalFPDTO != null) {
			MsgObj msgobj = new MsgObj();
			msgobj.setEnNO(id_ent);
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(hospitalFPDTO.getTimes_ip()));
			//msgobj.setPatientCode(hospitalFPDTO.getId_pat());
			msgobj.setInteractionCode(hospitalFPDTO.getType_message());
			// 上传病案首页数据
			DomainBusinessUserObj buo = new DomainBusinessUserObj(hospitalFPDTO, IMrPubConst.NOCAT, "0", "0");
			buo.setMsgObj(msgobj);
			BusinessEvent event = new BusinessEvent(serviceCode, IEventType.TYPE_UPDATE_AFTER, buo);
			BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
			beListener.doAction(event);
			// 上传术语：手术切口愈合等级
			DomainBusinessUserObj incicondiBuo = new DomainBusinessUserObj(hospitalFPDTO, IMrPubConst.ZY, "0", "0");
			BusinessEvent incicondiEvent = new BusinessEvent(IMrEventConst.MR_FP_INCICONDI_MSG, IEventType.TYPE_UPDATE_AFTER, incicondiBuo);
			BusinessEventListener incicondiBeListener = ServiceFinder.find(BusinessEventListener.class);
			incicondiBeListener.doAction(incicondiEvent);
			// 上传完成后，将病案首页主表中的上传标识修改为已上传状态
			if (!"1".equals(hospitalFPDTO.getType_message())) {
				jctMrFpDataBP.updateFlagForMrFpUpload(id_ent);
			}
		}
		return new FBoolean(true);
	}

	public FBoolean CompleteMrEdit(final String id_ent) throws BizException {
		if (id_ent == null || id_ent == "")
			throw new BizException("病人就诊号不能为空");

		if (!("".equals(CanCompleteEdit(id_ent)) || CanCompleteEdit(id_ent) == null)) {
			throw new BizException("不能完成审核");
		}
       
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<Object>() {
			@Override
			public Object doInTransaction(TransactionStatus arg0) throws InvocationTargetException {
				// 里面不要吞掉异常
				// insert do1 有异常回滚
				// insert do2 有异常回滚 do1
				// insert do3 有异常回滚 do1 do2
				try {

					ICiamrRService amrService = ServiceFinder.find(ICiamrRService.class);
					ICiamrCudService amrSService = ServiceFinder.find(ICiamrCudService.class);
					ICiemrRService mrService = ServiceFinder.find(ICiemrRService.class);
					ICiemrCudService mrSService = ServiceFinder.find(ICiemrCudService.class);
					AMrDO[] amrDoArr = amrService.find(" id_ent='" + id_ent + "'", "", FBoolean.FALSE);
					CiMrDO[] mrDoArr = mrService.find(" id_ent='" + id_ent + "'", "", FBoolean.FALSE);
					if (amrDoArr != null && amrDoArr.length > 0 && mrDoArr != null && mrDoArr.length > 0) {
						// 更新病案的完成状态
						AMrDO amrDo = amrDoArr[0];
						amrDo.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_COMWRITE);
						amrDo.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_COMWRITE);
						amrDo.setFg_complete(FBoolean.TRUE);
						amrDo.setStatus(DOStatus.UPDATED);
						amrSService.save(new AMrDO[] { amrDo });

						// 更新文书的完成状态
						for (int i = 0; i < mrDoArr.length; i++) {
							mrDoArr[i].setFg_complete(FBoolean.TRUE);
							mrDoArr[i].setStatus(DOStatus.UPDATED);
						}
					} else {
						throw new BizException("查不到相关的病案数据");
					}
				} catch (Exception e) {
					throw new BizRuntimeException(e.getMessage());
				}
				return null;
			}
		});
		return new FBoolean(true);
	}
}