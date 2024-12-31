package iih.nm.nqm.bp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.nm.common.GetResultBySql;
import iih.nm.nqm.bp.qry.GetNqmChkListQry;
import iih.nm.nqm.bp.qry.GetNqmImprovListQry;
import iih.nm.nqm.dto.NmNqmChkDTO;
import iih.nm.nqm.dto.NmNqmImprovDTO;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 护理质量检查月度统计
 * @author 王鹏
 *
 */
public class GetNqmImprovBp {

	public List<NmNqmImprovDTO> exec(String dt_chk,String id_dep,String id_nqm_lvl) throws Exception{
		List<NmNqmImprovDTO> improvList = assemblyData(dt_chk,id_dep,id_nqm_lvl);
		return improvList;

	}
	
	private List<NmNqmImprovDTO> assemblyData(String dt_chk,String id_dep,String id_nqm_lvl) throws Exception{
		String[] dates = getMonthTimeInterval(dt_chk);
		String dt_b = dates[0];
		String dt_e = dates[1];
		List<NmNqmImprovDTO> improvList = getNqmImprov(dt_b,dt_e,id_dep,id_nqm_lvl);
		return improvList;
	}
	
	/**
	 * 获取持续改进问题
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<NmNqmImprovDTO> getNqmImprov(String dt_b,String dt_e,String id_dep,String id_nqm_lvl) throws Exception{
		GetNqmImprovListQry qry = new GetNqmImprovListQry(dt_b, dt_e,id_nqm_lvl,id_dep);
		String strSql = qry.getQrySQLStr();
		GetResultBySql sqlUtil = new GetResultBySql();
		List<NmNqmImprovDTO> improvList = (List<NmNqmImprovDTO>) sqlUtil.getResultListBySql(strSql, NmNqmImprovDTO.class);
		if(ListUtil.isEmpty(improvList)){
			return new ArrayList<NmNqmImprovDTO>();
		}
		HashMap<String,List<NmNqmChkDTO>> chkMap = getNqmChk(dt_b, dt_e,id_dep,id_nqm_lvl);	
		HashMap<String,NmNqmImprovDTO> improvMap = new HashMap<String,NmNqmImprovDTO>();
		//遍历持续改进问题 根据检查标准编码分组
		int index = 1;
		for (int i = 0; i < improvList.size(); i++) {
			NmNqmImprovDTO improvDTO = improvList.get(i);
			if(improvMap.containsKey(improvDTO.getCodeNqmCs())){
				NmNqmImprovDTO value = improvMap.get(improvDTO.getCodeNqmCs());
				String assembProblem = value.getExistProblem() + (StringUtils.isEmpty(improvDTO.getExistProblem()) ? "" : improvDTO.getExistProblem());
				value.setExistProblem(assembProblem);
				String assembMendMeas = value.getMendMeas() + (StringUtils.isEmpty(improvDTO.getMendMeas()) ? "" : improvDTO.getMendMeas());
				value.setMendMeas(assembMendMeas);				
			}else{
				if(StringUtil.isEmpty(improvDTO.getExistProblem())){
					improvDTO.setExistProblem("");
				}
				if(StringUtil.isEmpty(improvDTO.getMendMeas())){
					improvDTO.setMendMeas("");
				}
				improvMap.put(improvDTO.getCodeNqmCs(), improvDTO);
				List<NmNqmChkDTO> chkList = chkMap.get(improvDTO.getCodeNqmCs());
				if(!ListUtil.isEmpty(chkList)){
					improvDTO.setCsName(index + "." + chkList.get(0).getCsName());
					improvDTO.setChkList(chkList);
					index ++;
				}
									
			}
		}
		improvList.clear(); 
		for (String key : improvMap.keySet()) {
			improvList.add(improvMap.get(key));
		}
		return improvList;
	}
	
	/**
	 * 获取检查标准
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws Exception
	 */
	private HashMap<String,List<NmNqmChkDTO>> getNqmChk(String dt_b,String dt_e,String id_dep,String id_nqm_lvl) throws Exception{
		GetNqmChkListQry qry = new GetNqmChkListQry(dt_b,dt_e,id_dep,id_nqm_lvl);
		String strSql = qry.getQrySQLStr();
		GetResultBySql sqlUtil = new GetResultBySql();
		List<NmNqmChkDTO> chkList = (List<NmNqmChkDTO>) sqlUtil.getResultListBySql(strSql, NmNqmChkDTO.class);
		HashMap<String,List<NmNqmChkDTO>> chkMap = new HashMap<String,List<NmNqmChkDTO>>();
		for (NmNqmChkDTO nqmChkDTO : chkList) {
			//按检查标准分类
			if(StringUtils.isEmpty(nqmChkDTO.getCodeNqmCs())){
				continue;
			}
			if(chkMap.containsKey(nqmChkDTO.getCodeNqmCs())){
				chkMap.get(nqmChkDTO.getCodeNqmCs()).add(nqmChkDTO);
			}else{
				List<NmNqmChkDTO> nqmChkList = new ArrayList<NmNqmChkDTO>();
				nqmChkList.add(nqmChkDTO);
				chkMap.put(nqmChkDTO.getCodeNqmCs(),nqmChkList);
			}
		}
		return chkMap;
	}
	
	private String[] getMonthTimeInterval(String dt_monday) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sft.parse(dt_monday);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		Date first = calendar.getTime();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
		Date end = calendar.getTime();
		return new String[]{sft.format(first),sft.format(end)};
	}
}
