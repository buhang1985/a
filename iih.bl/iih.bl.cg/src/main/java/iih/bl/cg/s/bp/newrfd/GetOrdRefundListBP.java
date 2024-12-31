package iih.bl.cg.s.bp.newrfd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blwardrefund.d.BlRefundTpEnum;
import iih.bl.cg.dto.d.BlOrderRefundListDTO;
import iih.bl.cg.dto.d.BlRefundSrvItemDTO;
import iih.bl.comm.IBlCustomFileConst;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者医嘱可退费数据
 * @author xy.zhou
 *
 */
public class GetOrdRefundListBP {

	@SuppressWarnings("unused")
	public BlOrderRefundListDTO[] exec(String id_ent)throws BizException{
		
		List<BlOrderRefundListDTO> ordList = this.getOrdList(id_ent);
		if(ListUtil.isEmpty(ordList)){
			return null;
		}
		
		List<String> id_ors=new ArrayList<>();
		for (BlOrderRefundListDTO blOrderRefundListDTO : ordList) {
			id_ors.add(blOrderRefundListDTO.getId_or());
		}
		
		Map<String, List<BlRefundSrvItemDTO>> ordItmMap = this.getrfdItemMap(id_ors);
		
		PatiVisitDO entDO=(PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, id_ent);
		
		this.addState(ordList, ordItmMap,entDO);
		
		return ordList.toArray(new BlOrderRefundListDTO[]{});
	}
	
	/**
	 * 查询该患者下可退费的医嘱
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<BlOrderRefundListDTO>  getOrdList(String id_ent) throws BizException{

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select cio.id_en       id_ent, ");
		sqlSb.append("            cio.sd_su_or, ");
		sqlSb.append("            cio.fg_stop, ");
		sqlSb.append("            cio.sd_su_mp, ");
		sqlSb.append("            cio.content_or, ");
		sqlSb.append("            cio.name_or, ");
		sqlSb.append("            cio.code_or, ");
		sqlSb.append("            cio.fg_long, ");
		sqlSb.append("            cio.dt_entry, ");
		sqlSb.append("            cio.dt_effe     dt_effc, ");
		sqlSb.append("            cio.dt_end, ");
		sqlSb.append("            cio.id_or, ");
		sqlSb.append("            cio.fg_bb, ");
		sqlSb.append("            cio.fg_research, ");
		sqlSb.append("            psn.name        name_emp_or, ");
		sqlSb.append("            dep.name        name_dep_or, ");
		sqlSb.append("            tp.name         tp_name ");
		sqlSb.append("       from ci_order cio ");
		sqlSb.append("      inner join bd_psndoc psn ");
		sqlSb.append("         on cio.id_emp_or = psn.id_psndoc ");
		sqlSb.append("      inner join bd_dep dep ");
		sqlSb.append("         on cio.id_dep_or = dep.id_dep ");
		sqlSb.append("      inner join bd_srvca tp ");
		sqlSb.append("         on cio.id_srvca = tp.id_srvca ");
		sqlSb.append(" where 1=1 ");
		sqlSb.append(" and (cio.sd_srvtp like '02%' or cio.sd_srvtp like '03%' or cio.sd_srvtp like '05%')");//检查、检验、诊疗
		sqlSb.append("   and cio.fg_long='N' ");//临时
		sqlSb.append(" and cio.sd_su_bl='").append(ICiDictCodeConst.SD_SU_BL_ACCOUNT).append("' ");//已记账
		sqlSb.append(" and cio.sd_su_mp='").append(ICiDictCodeConst.SD_SU_MP_NONE).append("' ");//未执行
		sqlSb.append(" and cio.fg_research='N' ");//非科研
		sqlSb.append(" and cio.id_en =?");
		SqlParam param=new SqlParam();
		param.addParam(id_ent);
		List<BlOrderRefundListDTO> ordList = (List<BlOrderRefundListDTO>) new DAFacade().execQuery(sqlSb.toString(), param,new BeanListHandler(BlOrderRefundListDTO.class));
		return ordList;
	}
	
	/**
	 * 组装医嘱明细Map
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, List<BlRefundSrvItemDTO>> getrfdItemMap(List<String> id_ors) throws BizException{
		
		Map<String, List<BlRefundSrvItemDTO>> ordItmMap=new HashMap<String, List<BlRefundSrvItemDTO>>();
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select cg.id_or, ");
		sqlSb.append("       rtm.sd_su_rdfitm, ");
		sqlSb.append("       udi.name as name_su_rdfitm, ");
		sqlSb.append("       udi.id_udidoc, ");
		sqlSb.append("       rtm.id_su_rdfitm ");
		sqlSb.append("  from bl_cg_ip cg ");
		sqlSb.append("  left join bl_rfd_itm rtm ");
		sqlSb.append("    on rtm.id_cgip = cg.id_cgip ");
		sqlSb.append("   and rtm.fg_active = 'Y'" );
		sqlSb.append("  left join bd_udidoc udi ");
		sqlSb.append("    on udi.id_udidoc = rtm.id_su_rdfitm ");
		sqlSb.append(" where 1 = 1");

		sqlSb.append(" and ").append(SqlUtils.getInSqlByIds("cg.id_or", id_ors));
		
		List<BlRefundSrvItemDTO> itemList = (List<BlRefundSrvItemDTO>) new DAFacade().execQuery(sqlSb.toString(),new BeanListHandler(BlRefundSrvItemDTO.class));
		
		if(ListUtil.isEmpty(itemList)){
			return ordItmMap;
		}
		for (BlRefundSrvItemDTO item : itemList) {
			
			if(ordItmMap.containsKey(item.getId_or())){
				ordItmMap.get(item.getId_or()).add(item);
			}else{
				List<BlRefundSrvItemDTO> itemList2=new ArrayList<>();
				itemList2.add(item);
				ordItmMap.put(item.getId_or(), itemList2);
			}
		}
		return ordItmMap;
	}
	
	private void addState(List<BlOrderRefundListDTO> ordList,Map<String, List<BlRefundSrvItemDTO>> ordItmMap,PatiVisitDO entDO){
		
		ICiOrdBlService iCiOrdBlService=ServiceFinder.find(ICiOrdBlService.class);
		for (BlOrderRefundListDTO blOrderRefundListDTO : ordList) {
			//设置医嘱展示状态
			String sd_or_show=iCiOrdBlService.getOrderStatus(entDO.getCode_entp(), blOrderRefundListDTO.getSd_su_or(), blOrderRefundListDTO.getSd_su_mp(),blOrderRefundListDTO.getFg_stop());
			blOrderRefundListDTO.setSd_or_show(sd_or_show);
			blOrderRefundListDTO.setEu_rfditmtp(BlRefundTpEnum.CIORDER.toString());
			blOrderRefundListDTO.setName_rfditmtp("医嘱");
			
			if(ordItmMap.containsKey(blOrderRefundListDTO.getId_or())){
				List<BlRefundSrvItemDTO> itemList = ordItmMap.get(blOrderRefundListDTO.getId_or());
				for (BlRefundSrvItemDTO blRefundSrvItemDTO : itemList) {
					
					if(StringUtil.isEmpty(blRefundSrvItemDTO.getSd_su_rdfitm())){
						blOrderRefundListDTO.setSd_su_rdfitm(blRefundSrvItemDTO.getSd_su_rdfitm());
						blOrderRefundListDTO.setName_su_rdfitm(blRefundSrvItemDTO.getName_su_rdfitm());
					}
					else{
						blOrderRefundListDTO.setSd_su_rdfitm("0");//临时展示状态 表示待申请
						blOrderRefundListDTO.setName_su_rdfitm("待申请");
					}
				}
				
			}else{
				blOrderRefundListDTO.setSd_su_rdfitm("-1");//临时展示状态 表示未记账
				blOrderRefundListDTO.setName_su_rdfitm("未记账");
			}
			
		}
	}
}
