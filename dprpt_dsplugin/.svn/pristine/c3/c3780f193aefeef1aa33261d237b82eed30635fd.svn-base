package iih.mp.dg.printmanage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.handler.BeanListHandler;

public class TransFusionQryPrintService {

	public List<ActionMesListDTO> exec(String id_or) throws Exception{
		if("".equals(id_or) || id_or.equals(null))return null;
		List<MesListQryDTO> dtolist = this.getMpActionMesOr(id_or);
		if(dtolist == null)return null;
		//用量
		FDouble speed = this.getDri_speed(id_or);
		//ActionMesQryDTO --> ActionMesDTO 转换
		ActionMesListDTO[] mesList = this.setActionMesDTO(dtolist,speed);
		//排序
		Arrays.sort(mesList, new Comparator<ActionMesListDTO>(){
			@Override
			public int compare(ActionMesListDTO a1, ActionMesListDTO a2) {
				
				return a1.getDt_mp_plan().compareTo(a2.getDt_mp_plan());
			}
		});
		//设置滴速
		//this.setMesSpeed(mesList,speed);
		
		
		return Arrays.asList(mesList);	
	}
	
	private ActionMesListDTO[] setActionMesDTO(List<MesListQryDTO> dtolist,
			FDouble speed) {
		List<ActionMesListDTO> mesDTO = new ArrayList<>();				
		Map<String,ActionMesListDTO> map = new HashMap<>();
		int i = 1;
		for(MesListQryDTO qrydto : dtolist)
		{
			if(map.containsKey(qrydto.getId_dginfu()))
			{
				ActionMesListDTO dto = map.get(qrydto.getId_dginfu());
				dto.setDt_mp_plan(qrydto.getDt_mp_plan());
				dto.setStatus_rst(qrydto.getStatus_rst());
				setDateBySd(dto,qrydto);
			}else{
				ActionMesListDTO dto = new ActionMesListDTO();				
				dto.setDt_mp_plan(qrydto.getDt_mp_plan());
				dto.setStatus_rst(qrydto.getStatus_rst());
				setDateBySd(dto,qrydto);
				map.put(qrydto.getId_dginfu(), dto);
				dto.setNumber(i);
				i += 1;
			}
			
		}
		return map.values().toArray(new ActionMesListDTO[0]);
	}
	
	
	private void setDateBySd(ActionMesListDTO dto, MesListQryDTO qrydto) {
		
		if(qrydto.getSd_dgprtp() != null && qrydto.getSd_dgprtp().equals("2"))
		{							
			dto.setBegin_date(qrydto.getDt_mp());		
			
		}else if(qrydto.getSd_dgprtp() != null && qrydto.getSd_dgprtp().equals("4")){			
			dto.setEnd_date(qrydto.getDt_mp());
			if(qrydto.getIvgtt() != null){				
				dto.setSpeed(qrydto.getIvgtt().toString() + "滴/分");
			}
			
		}else{			
			dto.setCheck_date(qrydto.getDt_mp());
		}
		
	}
	
	private FDouble getDri_speed(String id_or) throws Exception {
		StringBuffer where = new StringBuffer();
		where.append(" select  srv.quan_medu quan ");
		where.append(" from ci_or_srv srv ");		
		where.append(" where srv.sd_srvtp  = '010104' ");
		where.append(" and srv.id_or  = '"+id_or+"' ");
				
		List<MesListQryDTO> dtolist =  this.getResultBySql(where.toString());
		FDouble quan = FDouble.ZERO_DBL;
		for(MesListQryDTO sredo : dtolist)
		{
			quan = quan.add(sredo.getQuan());
		}
		return quan;
	}
	
private List<MesListQryDTO> getMpActionMesOr(String id_or) throws Exception {
		
		StringBuffer sb=new StringBuffer();
		
		sb.append(" select orpr.dt_mp_plan, ");
		sb.append(" orpr.id_or_pr id_dginfu, ");
		sb.append("  pr.dt_mp, ");
		sb.append("  pr.ivgtt, ");
		sb.append("  pr.sd_dgprtp, ");
		sb.append(" psn.name pname, ");
		sb.append(" infu.fg_skintest, ");
		sb.append(" decode(infu.eu_su_mp,  0, '未执行',1, '正在执行', 2, '执行完成', 9,'带走',null,'未执行') status_fin,");
		sb.append(" decode(pr.fg_rst, 'Y', '正常', 'N', '异常', null) status_rst ");
		sb.append(" from mp_or_pr orpr ");
		sb.append(" left outer join mp_dg_infu infu on infu.id_or_pr = orpr.id_or_pr ");
		sb.append(" left outer join mp_dg_infu_pr pr on pr.id_dginfu = infu.id_dginfu ");
		sb.append(" left outer join bd_psndoc psn on psn.id_psndoc = pr.id_emp_mp ");
		sb.append(" where  1=1 ");
		if(!StringUtils.isBlank(id_or) && !"null".equals(id_or) && !"".equals(id_or.trim())) {
			sb.append(" and orpr.id_or = '"+ id_or +"' ");
		}
		sb.append(" order by orpr.dt_mp_plan ");
		return  this.getResultBySql(sb.toString());
	}

@SuppressWarnings("unchecked")
private List<MesListQryDTO> getResultBySql(String strSql) throws Exception {
	SqlReader sql_rdr = new SqlReader(null, strSql);
	sql_rdr.runSql(null, true);
	com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
	
	// 转换成对应 DTO 对象
	BeanListHandler beanlist_handler = new BeanListHandler(MesListQryDTO.class);
	List<MesListQryDTO> result = (List<MesListQryDTO>)beanlist_handler.processRs(cached_rs);

	sql_rdr.destroy();		
	
	return result;
}
}
