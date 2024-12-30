package iih.sc.scbd.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.kernel.SqlParam;

public class GetScBdSrvDtosByIdSrvBP {
	/**
	 * 根据查询条件查询ScBdSrvDTO
	 * 
	 * @param scBdSrvDTO
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ScBdSrvDTO> exec(ScBdSrvDTO scBdSrvDTO, PaginationInfo pg) throws BizException {
		if (scBdSrvDTO == null || StringUtil.isEmptyWithTrim(scBdSrvDTO.getId_scca())) {
			return new PagingRtnData<>();
		}
		StringBuffer sqlSb = new StringBuffer();
		SqlParam param = new SqlParam();
		sqlSb.append(" select srv.id_srv, ");
		sqlSb.append(" srv.code code_srv,");
		sqlSb.append(" srv.name name_srv,");
		sqlSb.append(" srv.pri,");
		sqlSb.append(" ca.id_scca,");
		sqlSb.append(" ca.name name_scca,");
		sqlSb.append(" kind.srvslot,");
		//sqlSb.append(" itm.id_scsrvkinditm as id_scsrvkinditem,");
		//sqlSb.append(" itm.name_kinditm as  name_scsrvkinditem,");
		sqlSb.append(" kind.id_scbdsrv,");
		sqlSb.append(" kind.fg_needcfm");
		sqlSb.append(" from sc_bdsrv kind");
		sqlSb.append(" inner join bd_srv srv on kind.id_srv = srv.id_srv");
		//sqlSb.append(" left join sc_bdsrv_kinditm itm on kind.id_scbdsrv = itm.id_scbdsrv");
		sqlSb.append(" inner join sc_ca ca on kind.id_scca = ca.id_scca");
		if (!StringUtil.isEmptyWithTrim(scBdSrvDTO.getId_scsrvkinditem())) {
		sqlSb.append(" left join sc_bdsrv_kinditm itm on kind.id_scbdsrv = itm.id_scbdsrv");
		}
		sqlSb.append(" where 1 = 1");
		sqlSb.append(" and kind.id_scca = ?");
		param.addParam(scBdSrvDTO.getId_scca());
		if (!StringUtil.isEmptyWithTrim(scBdSrvDTO.getName_srv())) {
			sqlSb.append(" and srv.name like ?");
			param.addParam("%" + scBdSrvDTO.getName_srv() + "%");
		}
		if (!StringUtil.isEmptyWithTrim(scBdSrvDTO.getCode_srv())) {
			sqlSb.append(" and srv.code like ?");
			param.addParam("%" + scBdSrvDTO.getCode_srv() + "%");
		}
		if (!StringUtil.isEmptyWithTrim(scBdSrvDTO.getId_scbdsrv())) {			
			String[] idScbdsrvs = StringUtil.toArray(scBdSrvDTO.getId_scbdsrv(), ",");
			List datas = new FArrayList();
			for (String idScbdsrv : idScbdsrvs) {
				String[] sp = idScbdsrv.split("'");
				datas.add(sp[1]);
			}			
			String inStr = ScSqlUtils.getNotInSqlByIds("kind.id_srv", datas);
			if(!StringUtil.isEmpty(inStr)){
				sqlSb.append(" and " + inStr);
			}
		}
		//类别明细
		if(!StringUtil.isEmpty(scBdSrvDTO.getId_scsrvkinditem()))
		{
			String[] id_scsrvkinditems = scBdSrvDTO.getId_scsrvkinditem().split(",");
			for(String id_scsrvkinditem :id_scsrvkinditems )
			{
				sqlSb.append(" and itm.id_scsrvkinditm like ?");
				param.addParam("%" + id_scsrvkinditem + "%");
			}
		}
		
		sqlSb.append(" order by srv.id_srv");
		PagingServiceImpl<ScBdSrvDTO> pageQryService = new PagingServiceImpl<ScBdSrvDTO>();
		PagingRtnData<ScBdSrvDTO> result = pageQryService.findByPageInfo(new ScBdSrvDTO(), pg, sqlSb.toString(), null,
				param);
		FArrayList oldList = result.getPageData();
		FArrayList newList = new FArrayList();
		//获取医疗服务主键集合
		List<String> idBdSrvList = new ArrayList<String>();
		if(oldList.size()>0)
		{
			for (int i = 0;i<oldList.size();i++) 
			{
				ScBdSrvDTO dto = (ScBdSrvDTO)oldList.get(i);
				idBdSrvList.add(dto.getId_scbdsrv());
					}
		}else{
			return result;
					}
		//获取类别明细
		String cond = ScSqlUtils.getInSqlByIds(" where itm.id_scbdsrv ", idBdSrvList);
		StringBuilder sb = new StringBuilder();
		sb.append(" select itm.id_scbdsrv,");
		sb.append(" itm.id_scsrvkinditm,");
		sb.append(" kinditm.name as name_itm_kinditm");
		sb.append(" from  sc_bdsrv_kinditm itm ");
		sb.append(" inner join   sc_srv_kind_itm kinditm on itm.id_scsrvkinditm = kinditm.id_scsrvkinditm ");
		sb.append(cond);
		sb.append(" order by itm.id_scbdsrv");
		FArrayList itmList = AppFwUtil.getMapListWithDao(sb.toString());
		//合并数据
		Map<String,String> id_scbdsrvMap  = new HashMap<String,String>();//类别明细id集合
		Map<String,String> nameKindItmMap  = new HashMap<String,String>();//类别明细名称集合
		if(itmList != null && itmList.size() > 0){
			for (int i = 0; i < itmList.size(); i++) {
				Map<String, Object> itmMap = (Map<String, Object>) itmList.get(i);
				String id_scbdsrv = itmMap.get("id_scbdsrv").toString();
				String id_scsrvkinditm = itmMap.get("id_scsrvkinditm").toString();
				String name_itm_kinditm = itmMap.get("name_itm_kinditm").toString();
					if(id_scbdsrvMap.containsKey(id_scbdsrv) && nameKindItmMap.containsKey(id_scbdsrv)){
						String id_scbdsrv_temp = id_scbdsrvMap.get(id_scbdsrv)+","+ id_scsrvkinditm;
						String name_itm_kinditm_temp = nameKindItmMap.get(id_scbdsrv)+","+name_itm_kinditm;
						id_scbdsrvMap.put(id_scbdsrv, id_scbdsrv_temp);	
						nameKindItmMap.put(id_scbdsrv, name_itm_kinditm_temp);	
					}else{
					id_scbdsrvMap.put(id_scbdsrv, id_scsrvkinditm);
					nameKindItmMap.put(id_scbdsrv, name_itm_kinditm);			
				}
			}
		}
		//将类别明细id和name 赋值到DTO中
		for (int i = 0;i<oldList.size();i++) 
		{
			ScBdSrvDTO dto = (ScBdSrvDTO)oldList.get(i);
			if(id_scbdsrvMap.containsKey(dto.getId_scbdsrv()) && nameKindItmMap.containsKey(dto.getId_scbdsrv())){
				String idScsrvKindItm= id_scbdsrvMap.get(dto.getId_scbdsrv());
				String nameScSrvKindItm = nameKindItmMap.get(dto.getId_scbdsrv());
				dto.setId_scsrvkinditem(idScsrvKindItm);
				dto.setName_scsrvkinditem(nameScSrvKindItm);
				newList.add(dto);
			}else{
				newList.add(dto);
				}
			}
		result.setPageData(newList);
		
		
		return result;
	}
}
