package iih.hp.cp.hpcpworkstatistic.bp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xap.mw.coreitf.d.FDouble;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import  iih.hp.cp.hpcpworkstatistic.d.HpCpWorkStatisticDTO;
import org.apache.commons.lang3.StringUtils;

public class HpCpWorkStatisticBP
{
	public List<HpCpWorkStatisticDTO> exe(String dt_start,String dt_end,String id_dep) throws Exception{
		List<HpCpWorkStatisticDTO>result=new ArrayList<>();
		if(StringUtils.isEmpty(id_dep)){
			return result;
		}
		List<Map<String, Object>> rst=GetQryRstMapList(getQrySql( dt_start, dt_end, id_dep)) ;		
		if(rst!=null){
			
            Map<String,List<Map<String,Object>>>cpmap=new HashMap<>();
			for(Map<String,Object> map : rst){
				String id_cp=getStrVal(map.get("id_cp"));
				if(cpmap.containsKey(id_cp)){
					List<Map<String,Object>> cplist=cpmap.get(id_cp);
					cplist.add(map);
				}else{
					List<Map<String,Object>> cplist=new ArrayList<>();
					cplist.add(map);
					cpmap.put(id_cp,cplist);
				}
			}
			for(String key: cpmap.keySet()){
				List<Map<String,Object>> cplist=cpmap.get(key);
				Map<String,Integer> valmap=new HashMap<>();
				valmap.put("allnum",valmap.size());
				BigDecimal finishnum=new BigDecimal("0");
				BigDecimal totalnum=new BigDecimal(cplist.size());
				BigDecimal exitnum=new BigDecimal("0");
				BigDecimal alternum=new BigDecimal("0");
				BigDecimal inpathnum=new BigDecimal("0");
                for(Map<String,Object> map : cplist){
					if(map.get("sd_status")!=null){
						Integer sd_status=Integer.parseInt(getStrVal(map.get("sd_status")));
						if(sd_status==1){
							//在径数
							inpathnum=inpathnum.add(new BigDecimal(1));
						}else if(sd_status==2){
							//变异退出数
							exitnum=exitnum.add(new BigDecimal(1));
						}else if(sd_status==3){
							//正常完成数
							finishnum=finishnum.add(new BigDecimal(1));
						}
					}
					String fg_alter=getStrVal(map.get("fg_alter"));
					if("Y".equals(fg_alter)){
						alternum=alternum.add(new BigDecimal(1));
					}				
                }
				FDouble finishrate=BigDecimal2FDouble(finishnum.divide(totalnum,2,BigDecimal.ROUND_HALF_UP));
				FDouble exitrate=BigDecimal2FDouble(exitnum.divide(totalnum,2,BigDecimal.ROUND_HALF_UP));
				FDouble alterrate=BigDecimal2FDouble(alternum.divide(totalnum,2,BigDecimal.ROUND_HALF_UP));

				HpCpWorkStatisticDTO dto=new HpCpWorkStatisticDTO();
				dto.setDeptname(getStrVal(cplist.get(0).get("deptname")));
				dto.setCpname(getStrVal(cplist.get(0).get("cpname")));
				dto.setVaroutnum(BigDecimal2FDouble(exitnum));
				dto.setNoroutnum(BigDecimal2FDouble(finishnum));
				dto.setChangenum(BigDecimal2FDouble(alternum));
				dto.setInpathnum(BigDecimal2FDouble(inpathnum));
				dto.setTotalnum(BigDecimal2FDouble(totalnum));
				dto.setNoroutrate(finishrate);
				dto.setVaroutrate(exitrate);
				dto.setChangerate(alterrate);
				result.add(dto);
			}
		}
		return result;
	}
	private String getQrySql(String dt_start,String dt_end,String id_dep){
		String sql=" select a.id_cpapp, a.id_cp, a.cpname ,a.dt_enter,a.fg_alter,a.dt_exit,a.sd_status,a.days_exe,a.cpcode,a.total_charge,a.sd_halt_rsn_tp, c.name deptname from hp_cp_app a left join en_ent  b on b.id_ent=a.id_ent  left join bd_dep c on b.id_dep_phy=c.id_dep where a.dt_enter>='"+dt_start+"'  and a.dt_enter<='"+dt_end+"' and b.id_dep_phy='"+id_dep+"'";
		return sql;	
	}

		/**
	 * 查询结果为MapList
	 * 
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	private List<Map<String, Object>> GetQryRstMapList(String sqlQry) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, sqlQry);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		MapListHandler maplist_handler = new MapListHandler();
		List<Map<String, Object>> result = (List<Map<String, Object>>) maplist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	private String getStrVal(Object val){
		if(val==null)
			return null;
		return val.toString().trim();
	}

	private FDouble BigDecimal2FDouble(BigDecimal val){
		FDouble d=new FDouble(val);
		return d;
	}
}
