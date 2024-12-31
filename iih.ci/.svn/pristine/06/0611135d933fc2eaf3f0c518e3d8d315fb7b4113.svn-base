package iih.ci.diag.s.ip.bp;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.s.CiDiUtils;
import iih.ci.diag.s.bp.CiDiCurrentBP;
import iih.en.pv.entdi.d.EntDiDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 * Copyright © 2018 北大医疗信息技术有限公司 PKU healthcare IT solution Co. Ltd
 * @author 作者 lizheng:
 * @version 创建时间：2018年4月4日 下午3:16:50
 * 
 * 
 * 类说明
 */

public class CogradientCiDiagToEnDiagBP {
   /**
    * 临床的当前诊断同步到就诊域
    * @param id_ent
    * @return
    */
	public String CogradientCiDiagToEnDiag(String id_ent)throws BizException{
		//判断就诊域是否诊断 有诊断删除
		JudgeEnDiag(id_ent);
		//插入临床的当前诊断
		getEntDiDO(id_ent);
		return "";
	}
	
	/**
	 * 判断就诊域的诊断
	 * @param id_ent
	 * @throws BizException
	 */
	private void JudgeEnDiag(String id_ent)throws BizException{
		//删除就诊域的原由的诊断
		StringBuffer sb= new StringBuffer();
		sb.append("a0.id_ent ='");
		sb.append(id_ent);
		sb.append("'");
		EntDiDO[] entDiDOs = CiDiUtils.getIEntdiRService().find(
				sb.toString(), "id_ent", FBoolean.FALSE);
		if (entDiDOs != null && entDiDOs.length > 0) {
			CiDiUtils.getIEntdiCudService().delete(entDiDOs);
		}
	}
	/**
	 * 取得就诊的当前诊断
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	private  EntDiDO[] getEntDiDO(String id_en)throws BizException{
		CiDiCurrentBP bp = new CiDiCurrentBP();
		CidiagAggDO[] aggs =  bp.getCiDiCurrent(id_en);
		List<EntDiDO> entdis = new ArrayList<EntDiDO>();
		if(aggs != null){
			boolean Fg_maj = false;
			for(CidiagAggDO agg:aggs){
				int i = 0;
				if (agg.getCiDiagItemDO() != null && agg.getCiDiagItemDO().length > 0) {
					for (CiDiagItemDO item : agg.getCiDiagItemDO()) {
						EntDiDO entdi = new EntDiDO();
						entdi.setId_org(agg.getParentDO().getId_org());
						entdi.setId_grp(agg.getParentDO().getId_grp());
						entdi.setId_ent(agg.getParentDO().getId_en());
						entdi.setId_didef_dis(item.getId_didef());
						entdi.setName_didef_dis(item.getId_didef_name());
						entdi.setSupplement(item.getSupplement());
						entdi.setId_ditp(agg.getParentDO().getId_ditp());
						entdi.setSd_ditp(agg.getParentDO().getSd_ditp());
						entdi.setId_didef_syn(item.getId_didef_syn());
						entdi.setName_didef_syn(item.getDidef_syn_name());
						entdi.setId_dep(Context.get().getDeptId());
						entdi.setName_bddi(item.getId_didef_name());
						entdi.setDt_diag(agg.getParentDO().getDt_di());
						entdi.setId_diitm(item.getId_diitm());
						entdi.setId_emp_phy(agg.getParentDO().getId_emp_sign());
						entdi.setSd_cdsystp(item.getSd_disys());
						entdi.setId_cdsystp(item.getId_disys());
						entdi.setFg_chronic(item.getFg_chronic());
						entdi.setFg_special(item.getFg_special());
						entdi.setFg_ur(item.getFg_ur());
						if (item.getId_didef_code() != null) {
							entdi.setCode_didef_dis(item.getId_didef_code());
						} else {
							entdi.setCode_didef_dis(item.getId_didef_syn_code());
						}

						entdi.setSortno(i);
						entdi.setId_parent(item.getId_parent());
						entdi.setInnercode(item.getInnercode());
						entdi.setFg_self(item.getFg_self());
						entdi.setId_di(item.getId_di());
						//entdi.setDes(dto.getSupply());
						//只有一个主诊断
						if (item.getFg_majdi().booleanValue() && !Fg_maj) {
							entdi.setFg_maj(item.getFg_majdi());
							Fg_maj = true;
						} else {
							entdi.setFg_maj(item.getFg_majdi());
						}

						//entdi.setFg_flupci(dto.getFg_flupci());
						//item.setFg_infedi(entdi.get);
						entdi.setFg_suspdi(item.getFg_suspdi());
						//entdi.setFg_sym(dto.getFg_sym());
						//entdi.setDes_di(agg.getParentDO().getDes_di());
						entdi.setId_infectiontp(item.getId_infectiontp());
						entdi.setSd_infectiontp(item.getSd_infectiontp());
						entdi.setStatus(DOStatus.NEW);
						entdis.add(entdi);
						i++;
					}
				}
				else{
					
				}
			}
		}
		CiDiUtils.getIEntdiCudService().save(entdis.toArray(new EntDiDO[]{}));
		return  entdis.toArray(new EntDiDO[]{});
	}
}

