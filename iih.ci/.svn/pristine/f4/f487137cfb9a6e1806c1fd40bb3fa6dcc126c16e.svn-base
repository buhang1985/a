/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.connonationqc;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.connonationqcdto.d.ConnonationQcItmDTO;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcDO;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcItmDO;
import iih.ci.mrqc.mrconnotationqc.d.MrconnotationqcAggDO;
import iih.ci.mrqc.mrconnotationqc.i.IMrconnotationqcCudService;
import iih.ci.mrqc.mrconnotationqc.i.IMrconnotationqcMDORService;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 〈扼要描述〉内涵质控保存
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class ConnoQcSaveBP {
	/**
	 * 保存内涵质控项目
	 * @param revnotice
	 * @throws BizException
	 */
	public FBoolean saveConnonationMrQcItm(ConnonationQcItmDTO[] qcItmDtos,ConnonationQcItmDTO qcItmDto, QaPatListDTO patListDto)
			throws BizException {
		IMrconnotationqcCudService aggService =ServiceFinder.find(IMrconnotationqcCudService.class);
		IMrconnotationqcMDORService MFindService =ServiceFinder.find(IMrconnotationqcMDORService.class);
		MrConnotationQcDO[] MExitDoArr=MFindService.find(" id_ent='"+patListDto.getId_ent()+"'", "", FBoolean.FALSE);
		if (MExitDoArr!=null && MExitDoArr.length>0) {
			aggService.deleteByParentDO(MExitDoArr);
		}
		String id_grp=Context.get().getGroupId();
		String id_org=Context.get().getOrgId();
		String id_emp=Context.get().getStuffId();
		MrconnotationqcAggDO aggDo=new MrconnotationqcAggDO();
		MrConnotationQcDO mrQcDo= new MrConnotationQcDO();
		mrQcDo.setId_grp(id_grp);
		mrQcDo.setId_org(id_org);
		mrQcDo.setId_emp_operate(id_emp);
		mrQcDo.setDt_operate(new FDateTime());
		mrQcDo.setId_emp_zydoc(patListDto.getId_emp_zydoc());
		mrQcDo.setId_emp_zzdoc(patListDto.getId_emp_zzdoc());
		mrQcDo.setId_emp_zrdoc(patListDto.getId_emp_zrdoc());
		mrQcDo.setCode_amr_ip(patListDto.getCode_amr_ip());
		mrQcDo.setId_amr(patListDto.getId_amr());
		mrQcDo.setId_ent(patListDto.getId_ent());
		mrQcDo.setId_pat(patListDto.getId_pat());
		mrQcDo.setId_dep_phy(patListDto.getId_dep_phy());
		mrQcDo.setId_total_assess(qcItmDto.getId_total_assess());
		mrQcDo.setSd_total_assess(qcItmDto.getSd_total_assess());
		mrQcDo.setName_total_assess(qcItmDto.getName_total_assess());
		mrQcDo.setName_pat(patListDto.getPat_name());
		mrQcDo.setDes_recommend(qcItmDto.getDes_recommend());
		mrQcDo.setDes_problem(qcItmDto.getDes_problem());
		//mrQcDo.setFg_deadmr(qcItmDto.getfg);
		mrQcDo.setFg_recommend(qcItmDto.getFg_recommend());
		mrQcDo.setStatus(DOStatus.NEW);
		mrQcDo.setFg_connonationqc(FBoolean.TRUE);
		aggDo.setParentDO(mrQcDo);
		List<MrConnotationQcItmDO> itmDolist =new ArrayList<MrConnotationQcItmDO>();
		if (qcItmDtos!=null&&qcItmDtos.length>0) {
			for (int i = 0; i < qcItmDtos.length; i++) {
				if (qcItmDtos[i].getSd_req_assess()!=null) {
					MrConnotationQcItmDO mrQcItmDo=new MrConnotationQcItmDO();
					mrQcItmDo.setId_ent(patListDto.getId_ent());
					mrQcItmDo.setId_grp(id_grp);
					mrQcItmDo.setId_org(id_org);
					mrQcItmDo.setId_conno_req_item(qcItmDtos[i].getId_conno_req_item());
					if (ICiMrDictCodeConst.SD_MR_QC_CONNONATIONQCITM_STATUS_YOU.equals(qcItmDtos[i].getSd_req_assess())) {
						mrQcItmDo.setId_req_assess(ICiMrDictCodeConst.ID_MR_QC_CONNONATIONQCITM_STATUS_YOU);
						mrQcItmDo.setSd_req_assess(ICiMrDictCodeConst.SD_MR_QC_CONNONATIONQCITM_STATUS_YOU);
						mrQcItmDo.setName_req_assess(ICiMrDictCodeConst.NAME_MR_QC_CONNONATIONQCITM_STATUS_YOU);
					}
					if (ICiMrDictCodeConst.SD_MR_QC_CONNONATIONQCITM_STATUS_ZHONG.equals(qcItmDtos[i].getSd_req_assess())) {
						mrQcItmDo.setId_req_assess(ICiMrDictCodeConst.ID_MR_QC_CONNONATIONQCITM_STATUS_ZHONG);
						mrQcItmDo.setSd_req_assess(ICiMrDictCodeConst.SD_MR_QC_CONNONATIONQCITM_STATUS_ZHONG);
						mrQcItmDo.setName_req_assess(ICiMrDictCodeConst.NAME_MR_QC_CONNONATIONQCITM_STATUS_ZHONG);
					}
					if (ICiMrDictCodeConst.SD_MR_QC_CONNONATIONQCITM_STATUS_CHA.equals(qcItmDtos[i].getSd_req_assess())) {
						mrQcItmDo.setId_req_assess(ICiMrDictCodeConst.ID_MR_QC_CONNONATIONQCITM_STATUS_CHA);
						mrQcItmDo.setSd_req_assess(ICiMrDictCodeConst.SD_MR_QC_CONNONATIONQCITM_STATUS_CHA);
						mrQcItmDo.setName_req_assess(ICiMrDictCodeConst.NAME_MR_QC_CONNONATIONQCITM_STATUS_CHA);
					}
					mrQcItmDo.setFg_none(qcItmDtos[i].getFg_none());
					mrQcItmDo.setReq_conno(qcItmDtos[i].getReq_conno().replaceAll(" ", ""));
					mrQcItmDo.setReq_conno_txt(qcItmDtos[i].getReq_conno_txt());
					mrQcItmDo.setStatus(DOStatus.NEW);
					itmDolist.add(mrQcItmDo);
				}
			}
		}
		if (itmDolist.size()>0) {
			aggDo.setMrConnotationQcItmDO(itmDolist.toArray(new MrConnotationQcItmDO[itmDolist.size()]));
		}
		
		aggService.save(new MrconnotationqcAggDO[]{aggDo});
		return FBoolean.TRUE;
	}
}
