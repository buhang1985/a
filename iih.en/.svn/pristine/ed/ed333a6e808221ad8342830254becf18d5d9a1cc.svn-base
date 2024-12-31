package iih.en.pv.s.bp.ippre.qry;


import iih.en.comm.util.EnAppUtils;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.dto.d.IppreQryConditionsDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 预住院查询
 */
public class GetIppreQryPatInfoBP extends GetIpPreInfoAbstact {

	/**
	 * 获取患者信息
	 * @param str
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EnIppreInfoDTO> exec(IppreQryConditionsDTO qrydto,PaginationInfo pageInfo) throws BizException{
		PagingRtnData<EnIppreInfoDTO> pageDatas = getWhereSql(qrydto,pageInfo);
		String[] entIds =  IpPreUtils.pageConvertEntIds(pageDatas);
		EnIppreInfoDTO[] ippreInfoDTO = getIpPreByEntIds(entIds);
		if(ArrayUtil.isEmpty(ippreInfoDTO)){
			return pageDatas;
		}
		pageDatas.setPageData(EnAppUtils.doArray2List(ippreInfoDTO));
		return pageDatas;
	}
	
	/**
	 * 获取就诊ids
	 * @param qrydto
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<EnIppreInfoDTO> getWhereSql(IppreQryConditionsDTO qrydto,PaginationInfo pageInfo) throws BizException {
		StringBuffer sql = new StringBuffer();
		SqlParam sqlParam = new SqlParam();
		sql.append("select distinct ippre.id_ent ");
		sql.append(" from en_ippre ippre " );
		sql.append(" inner join en_ent_ip ip on ip.id_ent = ippre.id_ent ");
		sql.append(" inner join en_ent ent on ent.id_ent = ippre.id_ent and ent.fg_canc = 'N' ");
		sql.append("where 1 = 1 ");
		if(qrydto != null){
			//科室病区
			if(qrydto.getId_dep_phy()!= null){
				sql.append(" and (ippre.id_dep_phy = ? or ippre.id_dep_ward = ? or ip.id_dep_phyadm = ? or ip.id_dep_nuradm = ?)");
				sqlParam.addParam(qrydto.getId_dep_phy());
				sqlParam.addParam(qrydto.getId_dep_phy());
				sqlParam.addParam(qrydto.getId_dep_phy());
				sqlParam.addParam(qrydto.getId_dep_phy());
			}
			//临床医疗组
			if(qrydto.getId_wg()!= null){
				sql.append(" and ippre.id_wg = ?");
				sqlParam.addParam(qrydto.getId_wg());
			}
			//就诊状态
			if(qrydto.getSd_status()!= null && !qrydto.getSd_status().equals("0")){
				
				sql.append(" and ippre.sd_status = ?");
				sqlParam.addParam(qrydto.getSd_status());
			}
			//时间
			if(qrydto.getD_begin()!=null && qrydto.getD_end()!=null){
				
			}
			if(qrydto.getTime_type()!= null && !qrydto.getTime_type().equals("")){
				switch (qrydto.getTime_type().charAt(0)) {
				//入院登记时间
				case '1':
					if(qrydto.getD_begin()!= null){
						sql.append(" and ent.dt_entry >= ?");
						sqlParam.addParam(qrydto.getD_begin() + " 00:00:00");
					}
					if(qrydto.getD_end()!= null){
						sql.append(" and ent.dt_entry <= ?");
						sqlParam.addParam(qrydto.getD_end() + " 23:59:59");
					}
					break;
				//预住院时间
				case '2':
					if(qrydto.getD_begin()!= null){
						sql.append(" and ippre.dt_acpt_ippre >= ?");
						sqlParam.addParam(qrydto.getD_begin() + " 00:00:00");
					}
					if(qrydto.getD_end()!= null){
						sql.append(" and ippre.dt_acpt_ippre <= ?");
						sqlParam.addParam(qrydto.getD_end() + " 23:59:59");
					}
					break;
				//入科时间(ippre现在也没有这个字段,用的这个)
				case '3':
					if(qrydto.getD_begin()!= null){
						sql.append(" and ent.dt_acpt >= ?");
						sqlParam.addParam(qrydto.getD_begin() + " 00:00:00");
					}
					if(qrydto.getD_end()!= null){
						sql.append(" and ent.dt_acpt <= ?");
						sqlParam.addParam(qrydto.getD_end() + " 23:59:59");
					}
					break;
				//出院,中止住院时间
				case '4':
					if(qrydto.getD_begin()!= null){
						sql.append(" and ip.dt_disc >= ?");
						sqlParam.addParam(qrydto.getD_begin() + " 00:00:00");
					}
					if(qrydto.getD_end()!= null){
						sql.append(" and ip.dt_disc <= ?");
						sqlParam.addParam(qrydto.getD_end() + " 23:59:59");
					}
					break;
				default:
					break;
				}
			}
		}
		PagingServiceImpl<EnIppreInfoDTO> pageQryService = new PagingServiceImpl<EnIppreInfoDTO>();
		return pageQryService.findByPageInfo(new EnIppreInfoDTO(), pageInfo, sql.toString(), null, sqlParam);
	}

}
