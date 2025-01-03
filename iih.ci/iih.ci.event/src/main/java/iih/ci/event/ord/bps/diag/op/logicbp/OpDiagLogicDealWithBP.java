package iih.ci.event.ord.bps.diag.op.logicbp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.external.ICidiagExtQryService;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.i.IOverviewRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
/**
 * 门诊 诊断BS301逻辑处理
 * @author F
 *
 * @date 2019年9月18日下午3:34:13
 *
 * @classpath iih.ci.event.ord.bps.diag.op.logicbp.OpDiagLogicDealWithBP
 */
public class OpDiagLogicDealWithBP extends CommonParamBP{

	public IEOpPvDiagEnDTO[] IEOpPvDiagEnDTO(CidiagAggDO aggDO, CiEnContextDTO ctx)throws BizException {
		// 有效性校验
		IEOpPvDiagEnDTO pvDaigEnt = new IEOpPvDiagEnDTO();
		// 映射患者就诊信息
		MappingPvDiagEnDTO(pvDaigEnt, aggDO.getParentDO().getId_en(), ctx);
		// 映射诊断信息
		MappingDiag(aggDO, pvDaigEnt, ctx);
		return new IEOpPvDiagEnDTO[] { pvDaigEnt };
	}
	/**
	 * 映射患者就诊信息
	 * 
	 * @param pvDaigEnt
	 * @param id_ent
	 * @throws BizException
	 */
	private void MappingPvDiagEnDTO(IEOpPvDiagEnDTO pvDaigEnt, String id_ent, CiEnContextDTO ctx) throws BizException {
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		IDeptRService deptService = ServiceFinder.find(IDeptRService.class);
		IOverviewRService pipatService = ServiceFinder.find(IOverviewRService.class);
		IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
		if (qryService != null) {
			OpBasicDTO OpBasicDTO = qryService.getOpBasicInfo(id_ent);//获取门诊基本信息
			PatiVisitDO en_entDo=qryService.getEnInfo(id_ent);//查询就诊信息
			OverviewAggDO piPatDO = pipatService.findById(OpBasicDTO.getId_pat());//查询患者临床信息
			if (OpBasicDTO != null) {
				pvDaigEnt.setPatientid(piPatDO.getParentDO().getCode());// 患者ID
				pvDaigEnt.setP_bar_code(piPatDO.getParentDO().getBarcode_chis());// 就诊号 取pi_pat.barcode_chis
				pvDaigEnt.setBqcode(OpBasicDTO.getTimes_op() + "");// 就诊次数
				pvDaigEnt.setBqname(OpBasicDTO.getName_pat());// 患者姓名
				DeptDO dept = null;
				if (OpBasicDTO.getId_dep_phy() == null) {
					dept = deptService.findById(ctx.getId_dep_en());
				} else {
					dept = deptService.findById(OpBasicDTO.getId_dep_phy());
				}
				pvDaigEnt.setBedno(dept.getCode());// 科室编码
				pvDaigEnt.setName(dept.getName());// 科室名称
				OrgDO org = orgRService.findById(dept.getId_org());
				pvDaigEnt.setHospital_code(org.getOrgcode());// 医疗机构编码
				pvDaigEnt.setHospital_name(org.getName());// 医疗机构名称
				pvDaigEnt.setDomain_id("01");// 域id
				pvDaigEnt.setCategorycode(en_entDo==null?"":getParamCodeEntp(en_entDo.getCode_entp()));//就诊类别编码
				pvDaigEnt.setCategoryname(OpBasicDTO.getCategory_name());
				pvDaigEnt.setSerialno(OpBasicDTO.getSerialno());//就诊流水号取en_ent.code
			}
		}
	}

	/**
	 * 映射诊断信息
	 * 
	 * @param pvDaigEnt
	 * @param id_ent
	 */
	@SuppressWarnings("unchecked")
	private void MappingDiag(CidiagAggDO aggDO, IEOpPvDiagEnDTO pvDaigEnt, CiEnContextDTO ctx) throws BizException {
		if (aggDO != null) {
			FArrayList2 list = new FArrayList2();
			// 需要优化 todo
			IDeptbRService deptService = ServiceFinder.find(IDeptbRService.class);
			IPsndocRService psnService = ServiceFinder.find(IPsndocRService.class);
			String bed_no = "";
			if(!OrdEventUtil.isEmpty(aggDO.getParentDO())&&!OrdEventUtil.isEmpty(aggDO.getParentDO().getId_en())) {
				DAFacade dafacade = new DAFacade();
				SqlParam param = new SqlParam();
				param.addParam(aggDO.getParentDO().getId_en());
				String bedSql = "select name_bed from en_ent_ip where id_ent= ? ";
				List<String> bedList = (List<String>) dafacade.execQuery(bedSql.toString(),param, new ColumnListHandler());
				if (bedList != null && bedList.size() > 0) {
					bed_no = bedList.get(0).toString();
				}
			}
			PsndocAggDO psnagg = null;
			if (aggDO.getParentDO().getId_emp_sign() == null) {
				psnagg = psnService.findById(ctx.getId_emp_or());
			} else {
				psnagg = psnService.findById(aggDO.getParentDO().getId_emp_sign());
			}
			DeptBDO dept = null;
			if (aggDO.getParentDO().getId_dep_sign() == null) {
				dept = deptService.findById(ctx.getId_dep_en());
			} else {
				dept = deptService.findById(aggDO.getParentDO().getId_dep_sign());
			}
			pvDaigEnt.setDeptcode(dept.getCode());
			pvDaigEnt.setDeptname(dept.getName());
			pvDaigEnt.setBedno(bed_no);
			aggDO.getParentDO().setEmpcode(psnagg.getParentDO().getCode());
			aggDO.getParentDO().setEmpname(psnagg.getParentDO().getName());
			if (aggDO.getCiDiagItemDO() != null && aggDO.getCiDiagItemDO().length > 0) {
				for (CiDiagItemDO item : aggDO.getCiDiagItemDO()) {
					IEOpPvDiagDTO pvDiag = new IEOpPvDiagDTO();
					setPvDiag(pvDiag, item, aggDO, dept);
					list.append(pvDiag);
				}
			}
			pvDaigEnt.setIeoppvmaindiags(list);
		}
	}
	/**
	 * 
	 * @param pvDiag
	 * @param item
	 * @param aggDO
	 * @throws BizException
	 */
	private void setPvDiag(IEOpPvDiagDTO pvDiag, CiDiagItemDO item, CidiagAggDO aggDO, DeptBDO dept)
			throws BizException {
		ICidiagExtQryService iCidiagExtQryService = ServiceFinder.find(ICidiagExtQryService.class);
		FMap2 result = iCidiagExtQryService.ConvertDiagType(aggDO.getParentDO().getCode_ditp(),
				aggDO.getParentDO().getCode_entp());

		pvDiag.setDiagno(item.getSortno());// 诊断号
		pvDiag.setDiagcode((String) result.get("code"));// 诊断类别编码
		pvDiag.setDiagname((String) result.get("name"));// 诊断类别名称
		// <!-- 是否待查 @code: N代表是, U代表否 --> 集成平台
		if (FBoolean.TRUE.equals(item.getFg_flupci())) { // 待查诊断标志
															// Fg_flupci存在为空情况
			pvDiag.setUnconfirm("N");// 是否待查
		} else {
			pvDiag.setUnconfirm("U");// 是否待查
		}
		pvDiag.setDiseasecode(item.getId_didef_code());// 疾病编码
		pvDiag.setDiseasename(item.getId_didef_name());// 疾病名称
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(aggDO.getParentDO().getDt_di().getMillis());
		pvDiag.setDiagtime(sdf.format(date));// 诊断时间
		pvDiag.setDoctorcode(aggDO.getParentDO().getEmpcode());// 诊断医生编码
		pvDiag.setDoctorname(aggDO.getParentDO().getEmpname());// 诊断医生名称
		pvDiag.setDeptcode(dept.getCode());// 诊断科室编码
		pvDiag.setDeptname(dept.getName());// 诊断科室编码
		pvDiag.setEmrtpcode(pvDiag.getDiagcode());// EMR系统诊断类别编码
		pvDiag.setEmrtpname(pvDiag.getDiagname());// EMR系统诊断类别名称
		if (FBoolean.TRUE.equals(item.getFg_infedi())) {
			pvDiag.setInflectable("true");// 是否传染
		} else {
			pvDiag.setInflectable("false");// 是否传染
		}

		if (FBoolean.TRUE.equals(item.getFg_majdi())) {
			pvDiag.setMain_flag("true");// 是否主诊断
		} else {
			pvDiag.setMain_flag("false");// 是否主诊断
		}

		pvDiag.setId_didef_syn_code(item.getId_didef_syn_code());
		pvDiag.setId_didef_syn_name(item.getId_didef_syn_name());
	}
}
