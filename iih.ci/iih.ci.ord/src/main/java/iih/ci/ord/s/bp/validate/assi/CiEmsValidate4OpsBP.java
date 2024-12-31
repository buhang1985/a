package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.i.IEmsregistryMDORService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术医疗单校验
 * 
 * @author qzwang
 *
 */
public class CiEmsValidate4OpsBP extends BaseEmsValidate4OtherBP {

	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		// 必填项的检查
		if (StringUtil.isEmpty(emsDTO.getId_srv()) || StringUtil.isEmpty(emsDTO.getName())
				|| StringUtil.isEmpty(emsDTO.getSd_srvtp())) {
			errorList.add("医疗单服务相关信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
		}
		// 执行科室
		checkDepInfo(emsDTO, errorList);

		// 就诊相关信息检查
		checkPatDiInfo(emsDTO, errorList);

		// 申请单检查 ？？
		checkOpsInfo(emsDTO, errorList);

		return this.getValidateRst();
	}

	private void checkOpsInfo(CiEmsDTO emsDTO, List<String> errorList) {
		// errorList.add("医疗单必填信息不完整，请在医疗单中填写完整");
		// this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);

		// 必填项的检查
		FMap orapplysheet = emsDTO.getOrapplysheet();
		if ("10".equals(emsDTO.getCode_entp())) {
			String id_anestp = null;
			String name_anestp = null;//麻醉方式
			String id_surgical_site = null;
			String name_surgical_site = null;//手术部位
			String id_incitp = null;
			String name_incitp = null;//切口等级
			String id_emp_operate = null;//主刀医生
			String key = EmsType.OPER + "";
			if (orapplysheet.containsKey(key)) {
				CiorappsurgeryAggDO aggDo = (CiorappsurgeryAggDO) orapplysheet.get(key);
				OrdApOpDO parent = (OrdApOpDO) aggDo.getParent();
				id_anestp = parent.getId_anestp();
				name_anestp =parent.getName_anestp();
				id_surgical_site = parent.getId_surgical_site();
				name_surgical_site =parent.getName_surgical_site();
				id_incitp =parent.getId_incitp();
				name_incitp =parent.getName_incitp();
				id_emp_operate = parent.getId_emp_operate();
			}
			if (StringUtil.isEmpty(id_anestp) || StringUtil.isEmpty(name_anestp)) {
				errorList.add("必填项麻醉方式未填，请重新检查");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
			}
			if (StringUtil.isEmpty(id_surgical_site) || StringUtil.isEmpty(name_surgical_site)) {
				errorList.add("必填项手术部位未填，请重新检查");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
			}
			if (StringUtil.isEmpty(id_incitp) || StringUtil.isEmpty(name_incitp)) {
				errorList.add("必填项切口等级未填，请重新检查");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
			}
			if (StringUtil.isEmpty(id_emp_operate)) {
				errorList.add("必填项主刀医师未填，请重新检查");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
			}
		}

		// 动态指标项 DO数据
		EmsDynamicIndexDTO[] dynamicIndexs;
		try {
			dynamicIndexs = this.getEmsDynamicIndex(emsDTO);
			if (dynamicIndexs != null && dynamicIndexs.length > 0) {
				for (int i = 0; i < dynamicIndexs.length; i++) {
					if ((dynamicIndexs[i].getFg_allowempty() == null
							|| !dynamicIndexs[i].getFg_allowempty().booleanValue())
							&& (dynamicIndexs[i].getIndexval() == null
									|| dynamicIndexs[i].getIndexval().trim().length() <= 0)) {
						errorList.add("动态指标" + dynamicIndexs[i].getShowname() + "值不能为空");
						this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
					}
				}

			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void checkDepInfo(CiEmsDTO ems, List<String> errorList) {
		if (StringUtil.isEmpty(ems.getId_dep_mp()) || StringUtil.isEmpty(ems.getName_dep_mp())) {
			errorList.add("医疗单执行科室相关信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
		}
	}

	private void checkPatDiInfo(CiEmsDTO ems, List<String> errorList) {
		if (StringUtil.isEmpty(ems.getId_en()) || StringUtil.isEmpty(ems.getId_entp())
				|| StringUtil.isEmpty(ems.getId_pat())) {
			errorList.add("医疗单就诊相关信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
		}
	}

	private void checkApplySheetInfo(CiEmsDTO ems, List<String> errorList) {

	}

	/**
	 * 获取动态指标
	 */
	private EmsDynamicIndexDTO[] getEmsDynamicIndex(CiEmsDTO ciemsDTO) throws BizException {

		// 医疗单服务类
		IEmsregistryMDORService emsRegistryService = (IEmsregistryMDORService) ServiceFinder
				.find(IEmsregistryMDORService.class);
		EmsDO emsDO = emsRegistryService.findById(ciemsDTO.getId_srvof());

		IBdSrvQryService qryService = (IBdSrvQryService) ServiceFinder.find(IBdSrvQryService.class);

		EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
		paramDto.setId_ems(ciemsDTO.getId_srvof());

		// 指标跨就诊标识
		boolean fg_dyncitm_en = FBoolean.TRUE.equals(emsDO.getFg_dyncitm_crossentp()) ? true : false;
		paramDto.setFg_dyncitm_en(fg_dyncitm_en);

		// 指标周期类型
		paramDto.setEu_dyncitmunit(emsDO.getEu_dyncitmunit());
		paramDto.setId_ent(ciemsDTO.getId_en());
		paramDto.setId_pat(ciemsDTO.getId_pat());

		// 指标周期下数值
		paramDto.setDyncitmunitct(emsDO.getCnt_dyncitmunit());

		// 获取动态指标
		return qryService.getEmsDynamicIndexInfos(paramDto);

	}
}
