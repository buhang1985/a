package iih.ci.ord.orderchangeprn.s;

import java.util.List;
import java.util.Map;
import xap.sys.jdbc.handler.BeanListHandler;
import org.apache.commons.lang.StringUtils;
import iih.ci.ord.orderchangeprn.d.CiOrChangePrnDO;
import iih.ci.ord.orderchangeprn.d.OrdChangeOrderInfoDTO;
import iih.ci.ord.orderchangeprn.d.OrdChangePersonDTO;
import iih.ci.ord.orderchangeprn.i.ICichangePrnCrudService;
import iih.ci.ord.orderchangeprn.i.IOrderchangeprnCudService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱变更单数据查询
 * 
 * @author 李岳
 *
 */
@Service(serviceInterfaces = { ICichangePrnCrudService.class }, binding = Binding.JSONRPC)
public class ICichangePrnCrudServiceImpl implements ICichangePrnCrudService {
	FDateTime dtNow = new FDateTime();

	@Override
	public void exec(String model, String id_ent, String changeDate, String ordstatus, String print, String end,
			String sign, String fg_long, String name_freq, String name_route, String yhz,String sd_srvtp) {
		try {
			// SQL拼接
			String sqlStr = getQrySql(model, id_ent, changeDate, print, end, sign, fg_long, name_freq, name_route, yhz,sd_srvtp);
			List<CiOrChangePrnDO> ords = (List<CiOrChangePrnDO>) new DAFacade().execQuery(sqlStr,
					new BeanListHandler(CiOrChangePrnDO.class));
			// 变更表添加打印数据
			DoAddPrn(ords);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获得不同模式下的查询sql
	 * 
	 * @param model
	 * @param id_en
	 * @return
	 */
	private String getQrySql(String model, String id_en, String changeDate, String print, String end, String sign,
			String fg_long, String name_freq, String name_route, String YHZ,String sd_srvtp) {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" select * from (select");
		sqlSb.append(" ci.id_or,ci.id_en,ci.Des_or,ci.dt_effe,ip.name_bed ,ci.dt_stop");
		sqlSb.append(" from ci_order ci");
		sqlSb.append(" left join bd_measdoc measdoc");
		sqlSb.append(" on ci.id_unit_med = measdoc.id_measdoc");
		sqlSb.append(" left join bd_route route");
		sqlSb.append(" on ci.id_route = route.id_route");
		sqlSb.append(" left join pi_pat pat");
		sqlSb.append(" on ci.id_pat = pat.id_pat");
		sqlSb.append(" left join en_ent_ip ip");
		sqlSb.append(" on ci.id_en = ip.id_ent");
		sqlSb.append(" left join bd_freq freq");
		sqlSb.append(" on ci.id_freq = freq.id_freq");
		sqlSb.append(" left join bd_udidoc bd");
		sqlSb.append(" on pat.id_sex = bd.id_udidoc");
//		sqlSb.append(String.format(" where ci.id_en in( %s ) and srv.sd_srvtp like '01%' ",id_en));

//		sqlSb.append(String.format(" and %s ",this.getStrTime(sign, changeDate, end)));
//		sqlSb.append(String.format(" %s ", this.getStrYHZ(YHZ)));
//		sqlSb.append(String.format(" %s ", this.getStrLong(fg_long)));
		sqlSb.append(" where ci.id_en in( "+id_en+" ) and ci.sd_srvtp not like '01%' ");
		sqlSb.append(" and "+this.getStrTime(sign, changeDate, end));
		sqlSb.append(this.getStrYHZ(YHZ));
		sqlSb.append(this.getStrLong(fg_long));

		if (!StringUtils.isBlank(name_freq) && !"all".equals(name_freq)) {
			sqlSb.append(String.format(" and ci.id_freq = '%s' ",name_freq));
		}
		if(!StringUtils.isBlank(name_route)&&!"all".equals(name_route)) {
			String ss=this.formatStr(name_route);
			if(ss!=null) {
				sqlSb.append(String.format(" and ci.id_route in (%s) ",ss));
			}								
		}


		if(!StringUtils.isBlank(sd_srvtp)) {
			String[] srvtps=sd_srvtp.split(",");    
			StringBuilder sb=new StringBuilder();
			for (String s : srvtps) {
                sb.append(String.format(" ci.sd_srvtp like '%s%' or ",s));
			}           
			String ss=sb.toString();
			if(!StringUtils.isBlank(ss)) {
				int i=ss.lastIndexOf("or");
				sqlSb.append(String.format(" and ( %s)", ss.substring(0,i)));
			}
		}

		sqlSb.append("  union all");
		sqlSb.append(" select ci.id_or,ci.id_en,ci.Des_or,ci.dt_effe,ip.name_bed,ci.dt_stop");
		sqlSb.append(" from ci_order ci");
		sqlSb.append(" left join bd_measdoc measdoc");
		sqlSb.append(" on ci.id_unit_med = measdoc.id_measdoc");
		sqlSb.append(" left join bd_route route");
		sqlSb.append(" on ci.id_route = route.id_route");
		sqlSb.append(" left join pi_pat pat");
		sqlSb.append(" on ci.id_pat = pat.id_pat");
		sqlSb.append(" left join en_ent_ip ip");
		sqlSb.append(" on ci.id_en = ip.id_ent");
		sqlSb.append(" left join bd_freq freq");
		sqlSb.append(" on ci.id_freq = freq.id_freq");
		sqlSb.append(" left join bd_udidoc bd");
		sqlSb.append(" on pat.id_sex = bd.id_udidoc");
//		sqlSb.append(String.format(" where ci.id_en in (%s) and ci.sd_srvtp not like '01%' ", id_en));
//
//		sqlSb.append(String.format(" and %s", this.getStrTime(sign, changeDate, end)));
//		sqlSb.append(String.format("  %s", this.getStrYHZ(YHZ)));
//		sqlSb.append(String.format("  %s", this.getStrLong(fg_long)));
		sqlSb.append(" where ci.id_en in( "+id_en+" ) and ci.sd_srvtp not like '01%' ");
		sqlSb.append(" and "+this.getStrTime(sign, changeDate, end));
		sqlSb.append(" "+this.getStrYHZ(YHZ));
		sqlSb.append(" "+this.getStrLong(fg_long));
		if (!StringUtils.isBlank(name_freq) && !"all".equals(name_freq)) {
			sqlSb.append(String.format(" and ci.id_freq = '%s' ",name_freq));
		}

		if(!StringUtils.isBlank(name_route)&&!"all".equals(name_route)) {
			String ss=this.formatStr(name_route);
			if(ss!=null) {
				sqlSb.append(String.format(" and ci.id_route in (%s) ",ss));
			}								
		}
		//服务类型
		if(!StringUtils.isBlank(sd_srvtp)) {
			String[] srvtps=sd_srvtp.split(",");    
			StringBuilder sb=new StringBuilder();
			for (String s : srvtps) {
                sb.append(String.format(" ci.sd_srvtp like '%s%' or ",s));
			}           
			String ss=sb.toString();
			if(!StringUtils.isBlank(sd_srvtp)) {
				int i=ss.lastIndexOf("or");
				sqlSb.append(String.format(" and ( %s)",ss.substring(0,i)));
			}
		}
		sqlSb.append(this.getOrderByPart());
		return sqlSb.toString();
	}

	/**
	 * 是否打印过滤
	 * 
	 * @param print
	 * @return
	 */
	private String getIsPrint(String print) {
		return " and ci.id_or not in (select id_or from ci_or_change_prn) ";
	}

	/**
	 * 长期临时过滤
	 * 
	 * @param fg_long
	 * @return
	 */
	private String getStrLong(String fg_long) {
		if (!StringUtils.isBlank(fg_long)) {
			switch (fg_long) {
			case "1":// 长期
				return " and ci.fg_long = 'Y' ";
			case "2":// 临时
				return " and ci.fg_long = 'N' ";
			default:// 全部
				return " ";
			}
		}
		return " ";
	}

	/**
	 * 医护嘱过滤
	 * 
	 * @param YHZ
	 * @return
	 */
	private String getStrYHZ(String YHZ) {
		if (!StringUtils.isBlank(YHZ)) {
			switch (YHZ) {
			case "1":// 医嘱
				return " and ci.sd_orsrcfun = '1' ";
			case "2":// 护嘱
				return " and ci.sd_orsrcfun = '2' ";
			default:// 全部
				return " ";
			}
		}
		return " ";
	}

	/**
	 * 时间段过滤
	 * 
	 * @param sign
	 *            全部0/签署医嘱1/停止医嘱2
	 * @param changeDate
	 *            开始时间
	 * @param end
	 *            截止时间
	 * @return
	 */
	private String getStrTime(String sign, String changeDate, String end) {
		String begindate = (StringUtils.isEmpty(changeDate) ? this.dtNow.getBeginDate().toString() + " 00:00:00" : changeDate);
		String endindate = (StringUtils.isEmpty(end) ? this.dtNow.getBeginDate().toString() + " 23:59:59" : end);
		if (StringUtils.isBlank(sign)) {
			sign = "0";
		}
		switch (sign) {
		case "1":
			return " ci.fg_sign='Y' and '" + begindate + "' <= ci.dt_sign and ci.dt_sign < ='" + endindate + "' ";
		case "2":
			return " ci.fg_stop='Y' and '" + begindate + "' <= ci.dt_end and ci.dt_end < ='" + endindate + "' ";
		default:
			return " ((ci.fg_sign='Y'and '" + begindate + "' <= ci.dt_sign and ci.dt_sign < ='" + endindate+ "' ) "
					+ "or (ci.fg_stop='Y'  and '" + begindate + "' <= ci.dt_end and ci.dt_end < ='" + endindate+ "' )) ";
		}
	}

	/**
	 * 变更打印表添加数据
	 * 
	 * @return
	 * @throws BizException
	 */
	private void DoAddPrn(List<CiOrChangePrnDO> ords) throws BizException {

		if ( ords == null )
			return;
		if ( ords.size() > 0 && !StringUtils.isBlank( ords.get(0).getId_en())) {
			for (CiOrChangePrnDO ciOrChangePrnDO : ords) {
				ciOrChangePrnDO.setStatus(DOStatus.NEW);
			}

			ServiceFinder.find(IOrderchangeprnCudService.class).save(ords.toArray(new CiOrChangePrnDO[ords.size()]));
		}
	}

	/**
	 * 排序规则
	 * 
	 * @return
	 */
	private String getOrderByPart() {
		return " ) order by name_bed asc,dt_effe,id_or";
	}

	/**
	 * 设置患者的字段信息
	 * 
	 * @param person
	 * @param map
	 */
	private void setPersonProperty(OrdChangePersonDTO person, Map<String, Object> map) {
		person.setName(map.get("pat_name") == null ? "" : map.get("pat_name").toString());
		person.setName_sex(map.get("name_sex") == null ? "" : map.get("name_sex").toString());
		person.setName_bed(map.get("name_bed") == null ? "" : map.get("name_bed").toString());
	}

	/**
	 * 设置医嘱的字段信息
	 */
	private void setOrdInfoProperty(OrdChangeOrderInfoDTO ordInfo, Map<String, Object> map) {
		ordInfo.setName_srv(map.get("name_srv") == null ? "" : map.get("name_srv").toString());
		ordInfo.setQuan_med(map.get("quan_medu") == null ? null : new Double(map.get("quan_medu").toString()));
		ordInfo.setName_unit_med(map.get("name_unit_medu") == null ? null : map.get("name_unit_medu").toString());
		ordInfo.setName_freq(map.get("name_freq") == null ? "" : map.get("name_freq").toString());
		ordInfo.setName_route(map.get("name_route") == null ? "" : map.get("name_route").toString());
		if (!StringUtils.isBlank((String) map.get("dt_stop"))) {
			ordInfo.setDt_stop(new FDateTime(map.get("dt_stop").toString()));
		}
		ordInfo.setDt_effe(new FDateTime(map.get("dt_effe").toString()));
	}

	/**
	 * 设置草药医嘱的字段信息
	 * 
	 * @param ordInfo
	 * @param map
	 */
	private void setHerbOrdInfoProperty(OrdChangeOrderInfoDTO ordInfo, Map<String, Object> map) {
		ordInfo.setName_srv(
				"草药" + map.get("orders") + "付：" + (map.get("des_or") == null ? "" : map.get("des_or").toString()));
		ordInfo.setName_route(map.get("name_route") == null ? "" : map.get("name_route").toString());
		ordInfo.setDt_effe(new FDateTime(map.get("dt_effe").toString()));
	}
	
	private String formatStr(String vals) {
		if(StringUtils.isBlank(vals))
		   return null;
		String[] ss=vals.split(",");
		StringBuilder sb=new StringBuilder();
		for (String s : ss) {
			sb.append("'"+s+"',");
		}
		String str=sb.toString();
		if(!StringUtils.isBlank(str)) {
			int i=str.lastIndexOf(",");
			return str.substring(0,i);
		}
		return null;
	}
}
