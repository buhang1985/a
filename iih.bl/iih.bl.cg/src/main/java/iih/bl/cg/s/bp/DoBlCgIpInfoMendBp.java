package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.pripat.i.IPripatCalService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgipmend.bp.BlCgIpMendBp;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.d.BlIpFeeDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mm.itf.material.d.MaterialInfoDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院退补费改造bp 保存退补费信息
 * 
 * @author liwenqiang
 *
 */
public class DoBlCgIpInfoMendBp {

	public BlIpFeeDTO[] exec(String id_ent, BlIpFeeDTO[] blIPFeeArr) throws BizException {

		if (blIPFeeArr == null || blIPFeeArr.length == 0) {
			return null;
		}
		//组装记账数据
		BlCgIpDO[] blcgOrArr = getBlcgOrArr(blIPFeeArr);
		//调用原补费接口
		BlCgIpMendBp bp = new BlCgIpMendBp();
		bp.setBlCgIpInfoMend(id_ent, blcgOrArr);
		//查询显示数据
		GetBlIpFeeDTOINfoBp blIpFeeDTOBp = new GetBlIpFeeDTOINfoBp();
		return blIpFeeDTOBp.exec(null,id_ent);
	}

	/**
	 * 根据补费数据组装记账信息
	 * 
	 * @param blIpFeearr
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] getBlcgOrArr(BlIpFeeDTO[] blIpFeeArr) throws BizException {
		List<BlCgIpDO> list = new ArrayList<BlCgIpDO>();
		// 获取所有id_or
		List<String> idorList = new ArrayList<String>();
		List<String> idorSrvList = new ArrayList<String>();
		List<String> idmmList = new ArrayList<String>();
		for (BlIpFeeDTO blIpFeeDto : blIpFeeArr) {
			if(!StringUtil.isEmpty(blIpFeeDto.getId_or())){
				idorList.add(blIpFeeDto.getId_or());
			}
			if(!StringUtil.isEmpty(blIpFeeDto.getId_srv())){
				idorSrvList.add(blIpFeeDto.getId_srv());
			}
			if(!StringUtil.isEmpty(blIpFeeDto.getId_mm())){
				idmmList.add(blIpFeeDto.getId_mm());
			}
			
		}
//		if (idorList == null || idorList.size() == 0) {
//			return null;
//		}
//		String idorStr = SqlUtils.arrayToStr(idorList.toArray(new String[0]));
//		// 记账信息
//		IBlcgqueryMDORService cgRservice = ServiceFinder.find(IBlcgqueryMDORService.class);
//		BlCgIpDO[] blCgDos = cgRservice.find("id_or in (" + idorStr + ")", "", FBoolean.FALSE);
//		if (blCgDos == null || blCgDos.length == 0) {
//			throw new BizException("原补费医嘱不能为空");
//		}
		BlCgIpDO[] blCgDos = null;
		if(idorList!=null&&idorList.size()>0){
			String idorStr = SqlUtils.arrayToStr(idorList.toArray(new String[0]));
			// 记账信息
			IBlcgqueryRService cgRservice = ServiceFinder.find(IBlcgqueryRService.class);
			 blCgDos = cgRservice.find("id_or in (" + idorStr + ")", "", FBoolean.FALSE);
			if (blCgDos == null || blCgDos.length == 0) {
				throw new BizException("原补费医嘱不能为空");
			}	
		}
		//服务信息
		MedSrvDO[] medSrvDos=null;
		if(idorSrvList!=null&&idorSrvList.size()>0){
			IMedsrvMDORService medSrvService = ServiceFinder.find(IMedsrvMDORService.class);
			 medSrvDos = medSrvService.findByIds(idorSrvList.toArray(new String[0]),FBoolean.FALSE);
		}
		//物品信息
		MaterialInfoDTO[] meinfoDtos=null;
		if(idmmList!=null&&idmmList.size()>0){
			IMaterialBaseInfoService materialService=ServiceFinder.find(IMaterialBaseInfoService.class);
			MaterialInfoDTO[] meinfoDTOs=materialService.getMaterialsByIds(idmmList.toArray(new String[0]));
		}
		
		//患者价格分类
		IPativisitRService patiVisitSrvice=ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDOs=patiVisitSrvice.find("a0.id_ent = '"+blIpFeeArr[0].getId_ent()+"'", "", FBoolean.FALSE);
		//患者价格比例
		FDouble Ratio_pripat=new FDouble(0.00);
		if(patiVisitDOs!=null && patiVisitDOs.length>0 && patiVisitDOs[0].getId_pripat()!=null){
			IPripatCalService pripatCalService=ServiceFinder.find(IPripatCalService.class);
			Ratio_pripat=pripatCalService.GetPriPatRate(patiVisitDOs[0].getId_pripat());
		}
		for (BlIpFeeDTO blIpFeeDto : blIpFeeArr) {
			BlCgIpDO cgIpDo = new BlCgIpDO();
			// 组装患者价格信息
			if(patiVisitDOs!=null && patiVisitDOs.length>0){
				cgIpDo.setRatio_pripat(Ratio_pripat);
			}
			if(patiVisitDOs!=null && patiVisitDOs.length>0){
				cgIpDo.setId_pripat(patiVisitDOs[0].getId_pripat());
			}
			
			cgIpDo.setId_ent(blIpFeeDto.getId_ent());
			cgIpDo.setId_pat(blIpFeeDto.getId_pat());
			cgIpDo.setId_enttp(blIpFeeDto.getId_enttp());
			cgIpDo.setCode_enttp(blIpFeeDto.getCode_enttp());
			cgIpDo.setId_grp(Context.get().getGroupId());
			cgIpDo.setId_org(Context.get().getOrgId());
			cgIpDo.setFg_pddisc(FBoolean.FALSE);
			cgIpDo.setEu_srctp(0);
			cgIpDo.setId_pripat(blIpFeeDto.getId_pripat());
			cgIpDo.setFg_st(FBoolean.FALSE);
			cgIpDo.setDt_st(new FDateTime());
			cgIpDo.setFg_hp(FBoolean.FALSE);
			cgIpDo.setFg_susp(FBoolean.FALSE);
			cgIpDo.setFg_refund(FBoolean.FALSE);
			cgIpDo.setFg_additm(FBoolean.TRUE);
			cgIpDo.setFg_additm(FBoolean.TRUE);
			cgIpDo.setQuan(blIpFeeDto.getQuan());
			cgIpDo.setQuan_mend(blIpFeeDto.getQuan_mend());
			cgIpDo.setId_org_cg(Context.get().getOrgId());
			cgIpDo.setId_dep_cg(Context.get().getDeptId());
			cgIpDo.setId_emp_cg(Context.get().getUserId());
			cgIpDo.setBlcgenttpname("住院");
			cgIpDo.setDt_cg(new FDateTime());
			cgIpDo.setDt_srv(new FDateTime());
			cgIpDo.setMark(blIpFeeDto.getMark());
			cgIpDo.setPrice(blIpFeeDto.getPrice());
			cgIpDo.setId_srv(blIpFeeDto.getId_srv());
			cgIpDo.setId_dep_mp(blIpFeeDto.getId_dep_mp());
			cgIpDo.setDes_or(blIpFeeDto.getDes_or());
			cgIpDo.setId_or(blIpFeeDto.getId_or());
			// 组装医嘱信息
			if(blCgDos!=null&&blCgDos.length>0){
				for (BlCgIpDO blCgDo : blCgDos) {
					if (blCgDo.getId_or().equals(blIpFeeDto.getId_or())&&!StringUtil.isEmpty(blCgDo.getId_org_mp())) {
						cgIpDo.setDt_or(blCgDo.getDt_or());
						cgIpDo.setId_org_or(blCgDo.getId_org_or());
						cgIpDo.setId_emp_or(blCgDo.getId_emp_or());
						cgIpDo.setId_wg_or(blCgDo.getId_wg_or());
						cgIpDo.setId_dep_nur(blCgDo.getId_dep_nur());
						cgIpDo.setId_org_mp(blCgDo.getId_org_mp());
						break;
					}
				}
			}

			//服务信息
			if(medSrvDos!=null && medSrvDos.length>0){
				for (MedSrvDO medSrvDo : medSrvDos) {
					if(medSrvDo.getId_srv().equals(cgIpDo.getId_srv())){
						cgIpDo.setCode_srv(medSrvDo.getCode());
						cgIpDo.setId_srvca(medSrvDo.getId_srvca());
						cgIpDo.setId_srvtp(medSrvDo.getId_srvtp());
						cgIpDo.setSd_srvtp(medSrvDo.getSd_srvtp());
						cgIpDo.setName_srv(medSrvDo.getName());
						cgIpDo.setId_srv(medSrvDo.getId_srv());
						cgIpDo.setSrvu(medSrvDo.getId_unit_med());
						cgIpDo.setSrvu_code(medSrvDo.getMed_code());
						cgIpDo.setSrvu_name(medSrvDo.getMed_name());
						cgIpDo.setFg_mm(medSrvDo.getFg_mm());
						break;
					}
				}
			}
			
			//物品信息
			if(meinfoDtos!=null && meinfoDtos.length>0){
				for (MaterialInfoDTO materialInfoDTO : meinfoDtos) {
					if(materialInfoDTO.getId_mm().equals(cgIpDo.getId_mm())){
						cgIpDo.setCode_mm(materialInfoDTO.getCode());
						cgIpDo.setSd_mmtp(materialInfoDTO.getSd_mmtp());
						cgIpDo.setSpec(materialInfoDTO.getSpec());
						cgIpDo.setPgku_base(materialInfoDTO.getId_unit_pkgbase());
						cgIpDo.setPgku_cur(materialInfoDTO.getId_unit_pkgsp());
					}
				}
			}
			list.add(cgIpDo);
		}

		return list.toArray(new BlCgIpDO[0]);
	}
}
