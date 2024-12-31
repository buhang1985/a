package iih.sc.sch.op;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.xap.core.utils.StringUtils;
import com.sun.rowset.CachedRowSetImpl;

import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 手术预约查询打印
 * 
 * @author yaohl
 *
 */
public class AptQueryPrintService {

	/**
	 * 查询数据
	 * 
	 * @throws Exception
	 * 
	 */
	public List<AptQueryDTO> exec(String sqlcond) throws Exception {
		// 查询数据
		List<AptQueryDTO> datas = this.queryAptDatas(sqlcond);
		// 计算患者年龄; 性别; 人员类别
		List<AptQueryDTO> result = this.clacPatAge(datas);
		
		return result;
	}

	private List<AptQueryDTO> queryAptDatas(String sqlcond) throws Exception {

		StringBuilder wherestr = new StringBuilder();
		wherestr.append(" select apt.id_apt,");
		wherestr.append(" rs.name as opeRoom,");
		wherestr.append(" apt.queno as queno,");
		wherestr.append(" dep.name as depName,");
		wherestr.append(" ip.name_bed as namebed,ip.code_amr_ip as codeAmrIp,");
		wherestr.append(" appl.piname as piname,");
		wherestr.append(" appl.id_sex as idSex,");
		wherestr.append(" appl.d_pi as birDate,");
		wherestr.append(" opt.name_di as diaName,");
		wherestr.append(" appl.name as opeName,");
		wherestr.append(" apt.dt_b as opeDate,");
		wherestr.append(" doca.name as anesth,");
		wherestr.append(" docb.code as perCode,");
		wherestr.append(" docc.name as perName");
		wherestr.append(" from ");
		wherestr.append(" sc_apt apt ");
		wherestr.append(" inner join sc_apt_appl appl on appl.id_scapt = apt.id_apt  ");
		wherestr.append(" left join sc_apt_opt_emp emp on emp.id_aptappl = appl.id_aptappl ");
		wherestr.append(" inner join sc_apt_appl_opt opt on opt.id_aptappl = appl.id_aptappl ");
		wherestr.append(" left join en_ent_ip ip on ip.id_ent = appl.id_ent ");
		wherestr.append(" inner join sc_sch sch on sch.id_sch = apt.id_sch ");
		wherestr.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		wherestr.append(" inner join  sc_res rs on  rs.id_scres = pl.id_scres ");
		wherestr.append(" inner join  bd_dep dep on appl.id_dep_appl = dep.id_dep ");
		wherestr.append(" left join  bd_udidoc doca on opt.id_anestp = doca.id_udidoc ");//FIXME 修改 麻醉方式
		wherestr.append(" left  join  bd_udidoc docb on docb.id_udidoc = emp.id_role ");
		wherestr.append(" left  join  bd_psndoc docc on docc.id_psndoc = emp.id_emp ");
		wherestr.append(" left  join  pi_pat pat on appl.id_pi = pat.id_pat ");
		wherestr.append(" where 1 = 1 ");
		if (!StringUtil.isEmpty(sqlcond)) {
			wherestr.append(sqlcond);
		}
		wherestr.append(" and apt.fg_canc = 'N' ");
		wherestr.append(" order by opeRoom,queno ");
		// 执行查询
		List<AptQueryDTO> datas = this.getResultBySql(wherestr.toString());
		return datas;
	}

	/**
	 * 执行报表数据SQL查询你
	 * 
	 * @author：yaohl
	 * @param sql
	 * @return 手术预约查询DTO列表
	 * @throws Exception
	 */
	
	private List<AptQueryDTO> getResultBySql(String qry) throws Exception{
		
		SqlReader sql_rdr = new SqlReader(null, qry);
		sql_rdr.runSql(null, true);
		CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(AptQueryDTO.class);
		List<AptQueryDTO> result = (List<AptQueryDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		return result;
	}

	/**
	 * 处理数据
	 * @author yhl
	 * @param datas 待处理数据
	 * @return
	 */
	private List<AptQueryDTO> clacPatAge(List<AptQueryDTO> datas) {
		
		if(ListUtil.isEmpty(datas)){
			return null;
		}
		//创建空map list
		Map<String, List<AptQueryDTO>> map = new HashMap<String, List<AptQueryDTO>>();
		List<AptQueryDTO> result = new ArrayList<AptQueryDTO> ();
		// 数据根据id_apt分组
		for (AptQueryDTO aptQueryDTO : datas) {
			if(!map.containsKey(aptQueryDTO.getId_apt())){
				List<AptQueryDTO> list = new ArrayList<AptQueryDTO>();
				list.add(aptQueryDTO);
				map.put(aptQueryDTO.getId_apt(), list);
			}else{
				//
				map.get(aptQueryDTO.getId_apt()).add(aptQueryDTO);
			}
		}
		// 迭代map中key值对应的value，将每个key值对应的list记录中的数据分别设置人员类别后合并成一条AptQueryDTO 并添加到返回的list中
		for (Map.Entry<String, List<AptQueryDTO>> entry : map.entrySet()) {
			    List<AptQueryDTO> list = entry.getValue();
			    AptQueryDTO atQueryDTO = new AptQueryDTO();
			    //得到一条数据
			    AptQueryDTO src = list.get(0);
			    this.copyMainInfo(atQueryDTO, src);
			    for (AptQueryDTO aptQueryDTO : list) {
					
			    	if (!StringUtil.isEmpty(aptQueryDTO.getPerCode())) {
			    		//给新的对象赋值
				    	this.emplNameByType(atQueryDTO,aptQueryDTO);
					}
					
				}
			    result.add(atQueryDTO);
		}
	
		return result;
	}
	/**
	 * 复制主信息
	 * @param res 目标对象
	 * @param src 数据来源对象
	 */
	private void copyMainInfo(AptQueryDTO res,AptQueryDTO src){
		//设置年龄
		res.setBirDate(src.getBirDate());
		res.setAge(AgeCalcUtil.getAge(src.getBirDate()));
		//设置性别
		res.setSexName(this.getSex(src.getIdSex()));
		//设置其他属性
		res.setQueno(src.getQueno());
		res.setNameBed(src.getNameBed());
		res.setCodeAmrIp(src.getCodeAmrIp());
		res.setDiaName(src.getDiaName());
		res.setOpeName(src.getOpeName());
		res.setOpeDate((FDate)src.getOpeDate());
		res.setDepName(src.getDepName());
		res.setOpeRoom(src.getOpeRoom());
		res.setAnesth(src.getAnesth());
		res.setPiname(src.getPiname());
	}
	private void emplNameByType(AptQueryDTO res,AptQueryDTO src)
	{
			switch (src.getPerCode()) {
			case "00"://主刀医生
				res.setOperator(src.getPerName());
				break;
			case "01"://一助
				res.setFirAss(src.getPerName());
				break;
			case "02"://二助
				res.setSecAss(src.getPerName());
				break;
			case "10"://三助
				res.setThirAss(src.getPerName());
				break;
			case "05"://器械护士
				res.setInsNur(src.getPerName());
				break;
			case "07"://巡回护士
				res.setTourNur(src.getPerName());
				break;
			case "03":// 麻醉医生
				res.setAnes(src.getPerName());
				break;
			case "04"://二麻
				res.setSecAnes(src.getPerName());
				break;
			default:
				break;
			}
	}

	// 性别判断
	private String getSex(String idSex) {
		if (idSex.equals("@@@@AA1000000000MNT0")) {
			return "女";
		} else if (idSex.equals("@@@@AA1000000000MNSZ")) {
			return "男";
		} else {
			return "";
		}
	}
}
