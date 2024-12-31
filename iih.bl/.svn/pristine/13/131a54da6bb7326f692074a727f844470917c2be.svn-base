package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.dto.d.BlRefundApplyBillDTO;
import iih.bl.cg.dto.d.BlRefundApplyQueryDTO;
import iih.bl.comm.IBlCustomFileConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 根据查询条件获取申请单明细
 * @author xy.zhou
 *
 */
public class GetRfdApQueryBP {

	@SuppressWarnings("unchecked")
	public BlRefundApplyBillDTO [] exec(BlRefundApplyQueryDTO blQueryDTO)throws BizException{
		
		if(blQueryDTO==null){
			throw new BizException("查询条件为空！");
		}
		StringBuilder sqlSb = new StringBuilder();
		SqlParam param=new SqlParam();
		sqlSb.append(" select a.* ");
		sqlSb.append("  from (select rap.id_rfdap, ");
		sqlSb.append("               rap.code_rfdap, ");
		sqlSb.append("               rap.id_dep_ap, ");
		sqlSb.append("               dep.name       as name_dep_ap, ");
		sqlSb.append("               rap.id_emp_ap, ");
		sqlSb.append("               psn.name       as name_emp_ap, ");
		sqlSb.append("               rap.dt_ap, ");
		sqlSb.append("               rap.sd_rfdaptp, ");
		sqlSb.append("               rap.id_rfdaptp, ");
		sqlSb.append("               udi.name       as name_rfdaptp, ");
		sqlSb.append("               rap.fg_canc, ");
		sqlSb.append("               rap.fg_audit ");
		sqlSb.append("          from bl_rfd_ap rap ");
		sqlSb.append("          left join bd_dep dep ");
		sqlSb.append("            on dep.id_dep = rap.id_dep_ap ");
		sqlSb.append("          left join bd_Psndoc psn ");
		sqlSb.append("            on psn.id_psndoc = rap.id_emp_ap ");
		sqlSb.append("          left join bd_udidoc udi ");
		sqlSb.append("            on udi.id_udidoc = rap.id_rfdaptp ");
		sqlSb.append("          left join bl_rfd_itm rtm ");
		sqlSb.append("            on rap.id_rfdap = rtm.id_rfdap ");
		sqlSb.append("         where 1 = 1 ");
		
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new DeptDO(), "dep");//增加组织隔离
		sqlSb.append(sqlContext);
		if(!StringUtil.isEmpty(blQueryDTO.getId_ent())){
			 sqlSb.append(" and rtm.id_ent=?");
			 param.addParam(blQueryDTO.getId_ent());
		}
		if(!StringUtil.isEmpty(blQueryDTO.getId_dep_ap())){
			sqlSb.append(" and rap.id_dep_ap=?");
			param.addParam(blQueryDTO.getId_dep_ap());
		}
		if(!StringUtil.isEmpty(blQueryDTO.getId_emp_ap())){
			sqlSb.append(" and rap.id_emp_ap=?");
			param.addParam(blQueryDTO.getId_emp_ap());
		}
		if(blQueryDTO.getDt_ap_start()!=null){
			sqlSb.append(" and rap.dt_ap>=?");
			param.addParam(blQueryDTO.getDt_ap_start());   
		}
		if(blQueryDTO.getDt_ap_end()!=null){
			sqlSb.append(" and rap.dt_ap<=? ");
			param.addParam(blQueryDTO.getDt_ap_end());
		}

		if(!StringUtil.isEmpty(blQueryDTO.getSd_rfdaptp())){
			sqlSb.append(" and rap.sd_rfdaptp=?");
			param.addParam(blQueryDTO.getSd_rfdaptp());
		}
		sqlSb.append("         group by rap.id_rfdap, ");
		sqlSb.append("                  rap.code_rfdap, ");
		sqlSb.append("                  rap.id_dep_ap, ");
		sqlSb.append("                  dep.name, ");
		sqlSb.append("                  rap.id_emp_ap, ");
		sqlSb.append("                  psn.name, ");
		sqlSb.append("                  rap.dt_ap, ");
		sqlSb.append("                  rap.sd_rfdaptp, ");
		sqlSb.append("                  rap.id_rfdaptp, ");
		sqlSb.append("                  udi.name, ");
		sqlSb.append("                  rap.fg_audit, ");
		sqlSb.append("                  rap.fg_canc) a");
		sqlSb.append("   order by a.dt_ap desc ");
		List<BlRefundApplyBillDTO> blRefundApplyBillDTOs = (List<BlRefundApplyBillDTO>) new DAFacade().execQuery(sqlSb.toString(),param, new BeanListHandler(BlRefundApplyBillDTO.class));
		if(ListUtil.isEmpty(blRefundApplyBillDTOs)){
			return null;
		}
		for (BlRefundApplyBillDTO blRefundApplyBillDTO : blRefundApplyBillDTOs) {
			
			if(FBoolean.TRUE.equals(blRefundApplyBillDTO.getFg_audit())){
				blRefundApplyBillDTO.setCode_state(IBlCustomFileConst.SD_AUDIT_ADOPT);
				blRefundApplyBillDTO.setName_state("审核通过");
			}else if(FBoolean.FALSE.equals(blRefundApplyBillDTO.getFg_canc())&&FBoolean.FALSE.equals(blRefundApplyBillDTO.getFg_audit())){
				blRefundApplyBillDTO.setCode_state(IBlCustomFileConst.SD_INAPPLY);
				blRefundApplyBillDTO.setName_state("申请中");
			}else if(FBoolean.TRUE.equals(blRefundApplyBillDTO.getFg_canc())&&FBoolean.FALSE.equals(blRefundApplyBillDTO.getFg_audit())){
				blRefundApplyBillDTO.setCode_state(IBlCustomFileConst.SD_REVOKE);
				blRefundApplyBillDTO.setName_state("撤销");
			}else{
				blRefundApplyBillDTO.setCode_state(IBlCustomFileConst.ID_AUDIT_NOTADOPT);
				blRefundApplyBillDTO.setName_state("审核不通过");
			}
		}
		List<BlRefundApplyBillDTO> apList=new ArrayList<>();
		if(!StringUtil.isEmpty(blQueryDTO.getCode_su_ap())){
			for (BlRefundApplyBillDTO blRefundApplyBillDTO : blRefundApplyBillDTOs) {
				if(blQueryDTO.getCode_su_ap().equals(blRefundApplyBillDTO.getCode_state())){
					apList.add(blRefundApplyBillDTO);
				}
			}
			return apList.toArray(new BlRefundApplyBillDTO[]{});
		}
		return blRefundApplyBillDTOs.toArray(new BlRefundApplyBillDTO[]{});
	}
}
