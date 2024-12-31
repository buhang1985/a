package iih.ci.ord.content.d;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 医嘱内容生成通用检验生成工厂（非皮试类）
 */
public class DefaultLisOrContentFactory extends BaseCiOrContentFactory implements CiOrContentObjFactory {

	private String ismuldose;
	private String ismulexec;

	@Override
	public CiOrContentDO create(CiEmsDTO ems) throws BizException {
		if (ems == null || ems.getEmssrvs() == null || ems.getEmssrvs().size() == 0) {
			return getNullContent(ems);
		}
		CiOrContentDO contentdo = new CiOrContentDO();
		String sd_srvtp = ((CiEmsSrvDTO) ems.getEmssrvs().get(0)).getSd_srvtp();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
		List<String> lst = GetSrvExecDose.exec(ems.getId_srv());
		ismuldose = lst.get(0);
		ismulexec = lst.get(1);
		contentdo.setTitle(getTitle(ems));
		contentdo.setItemInfos(getItemInfos(ems));
		contentdo.setTailInfo(getTailInfos(ems));
		return contentdo;
	}

	/**
	 * 获得标题数据
	 * 
	 * @param ems
	 * @return
	 */
	private String getTitle(CiEmsDTO ems) {
		return "";
	}

	/**
	 * 获得表体数据
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private ArrayList<ArrayList<String>> getItemInfos(CiEmsDTO ems) throws BizException {
		if (ems == null || ems.getEmssrvs() == null)
			return null;
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		FArrayList emssrvs = ems.getEmssrvs();
		// 医嘱内容拼接价格 by yzh 2017-11-30 14:09:47
		// DecimalFormat df = new DecimalFormat("#.00");
		String total_pri = "0";
		String strUrgent = "";
		ListenerUtils urgentRed = new ListenerUtils();
		if (ems.getFg_urgent() != null && ems.getFg_urgent().booleanValue()) {
			// 0178579: 加急改为红色显示 liyue 2019-12-09
			if (urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent += "\\H01\\加急！\\N\\   ";
			} else {
				strUrgent += "加急！   ";
			}
		}
		if (ems.getFg_set() != null && ems.getFg_set().booleanValue()) {
			for (int i = 0; i < emssrvs.size(); i++) {
				CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
				if (item.getStatus() == DOStatus.DELETED || item.getFg_or() == null || !item.getFg_or().booleanValue())
					continue;
				boolean pri_flag = true;
				String name_srvs="";
				OrdApLabDO labDO = (OrdApLabDO) ems.getOrapplysheet().get(EmsType.LIS + "");
				if (labDO != null && !StringUtils.isNullOrEmpty(labDO.getSd_samptp())) {
					 	String strName =   getApLabName(labDO.getSd_samptp());
					 
						if(item.getSd_nodispense()!=null){
							if ("0".equals(item.getSd_nodispense())) {
								name_srvs= item.getName_srv() +"(自备)";
							}else if ("1".equals(item.getSd_nodispense())) {
								name_srvs= item.getName_srv() +"(嘱托)";
							}else if ("2".equals(item.getSd_nodispense())) {
								name_srvs= item.getName_srv() +"(外配)";
							}
							
						}else{
							name_srvs= item.getName_srv();
						}
					if (item.getFg_set() != null && item.getFg_set().equals(FBoolean.TRUE)) {
						arrList.add(strUrgent +
								name_srvs + (StringUtils.isNullOrEmpty(strName) ? "" : "(" + strName + ")"));
					}
				} else {
					if (item.getFg_set() != null && item.getFg_set().equals(FBoolean.TRUE)) {
						arrList.add(strUrgent + name_srvs);
					}
				}
				if (item.getFg_set() != null && item.getFg_set().equals(FBoolean.TRUE)) {
					if (item.getTotal_pri() != null) {
						total_pri = item.getTotal_pri().toString();
					} else if (item.getPrice() != null) {
						total_pri = item.getPrice().toString();
					}
					pri_flag = false;
				} else {
					if (pri_flag) {
						if (item.getTotal_pri() != null) {
							total_pri = item.getTotal_pri().toString();
						}
					}
				}

			}
			if (ems.getId_or() != null) {
				StringBuffer ordSrvsql = new StringBuffer();
				ordSrvsql.append(" select pri from ci_or_srv where id_or='" + ems.getId_or() + "' and fg_set='Y'");
				List<Map<String, Object>> ordsrvlist = (List<Map<String, Object>>) new DAFacade()
						.execQuery(ordSrvsql.toString(), new MapListHandler());
				if (ordsrvlist != null && ordsrvlist.size() > 0) {
					Map<String, Object> map = ordsrvlist.get(0);
					total_pri = map.get("pri") == null ? "0" : map.get("pri").toString();
				}
			}
		} else {
			for (int i = 0; i < emssrvs.size(); i++) {
				CiEmsSrvDTO item = (CiEmsSrvDTO) emssrvs.get(i);
				if (item.getStatus() == DOStatus.DELETED || item.getFg_or() == null || !item.getFg_or().booleanValue())
					continue;
				
				boolean pri_flag = true;
				String name_srvs ="";
				if(item.getSd_nodispense()!=null){
					if ("0".equals(item.getSd_nodispense())) {
						name_srvs =item.getName_srv() +"(自备)";
					}else if ("1".equals(item.getSd_nodispense())) {
						name_srvs= item.getName_srv() +"(嘱托)";
					}else if ("2".equals(item.getSd_nodispense())) {
						name_srvs= item.getName_srv() +"(外配)";
					}
					
				}else{
					name_srvs= item.getName_srv();
				}
				OrdApLabDO labDO = (OrdApLabDO) ems.getOrapplysheet().get(EmsType.LIS + "");
				if (labDO != null && !StringUtils.isNullOrEmpty(labDO.getSd_samptp())) {
					String strName =  getApLabName(labDO.getSd_samptp());
					arrList.add(strUrgent + name_srvs + (StringUtils.isNullOrEmpty(strName) ? "" : "(" + strName + ")"));
				} else {
					arrList.add(strUrgent + name_srvs);
				}
				
				if (item.getFg_set() != null && item.getFg_set().equals(FBoolean.TRUE)) {
					if (item.getTotal_pri() != null) {
						total_pri = item.getTotal_pri().compareTo(new FDouble("0")) <= 0 ? "0"
								: item.getTotal_pri().toString();
					}
					pri_flag = false;
				} else {
					if (pri_flag) {
						if (item.getTotal_pri() != null) {
							total_pri = item.getTotal_pri().compareTo(new FDouble("0")) <= 0 ? "0"
									: item.getTotal_pri().toString();
						}
					}
				}

			}
		}

		if (ismuldose != null && ismuldose.equals("Y")) {
			arrList.add((ems.getQuan_medu() == null) ? "" : ems.getQuan_medu().toString());
			arrList.add((ems.getName_unit_med() == null) ? "" : ems.getName_unit_med());
		} else {
			arrList.add("");
			arrList.add("");
		}
		if(this.getOrdsrvs()!=null){
			arrList.add(this.calPrice_new()+"元");
		}else{
			arrList.add(total_pri+"元");
		}
		list.add(arrList);
		return list;
	}
	/**
	 * 计算价格
	 * 
	 * @return
	 */
	public String calPrice_new() {
		FDouble totalPri = new FDouble(0);
		if (this.getOrdsrvs() != null && getOrdsrvs().length > 0) {
			for(OrdSrvDO ordsrv : getOrdsrvs()){
				//临床项目费用
				if(DOStatus.DELETED!=ordsrv.getStatus()&&FBoolean.TRUE.equals(ordsrv.getFg_bl())&&(OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())||OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
						||OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()))){
					if(ordsrv.getPri()!=null){
						if(ordsrv.getSd_srvtp()!=null&&ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
							totalPri = totalPri.add((ordsrv.getQuan_total_medu()==null?new FDouble(0):ordsrv.getQuan_total_medu()).multiply(ordsrv.getPri()));
						}else {
							totalPri = totalPri.add((ordsrv.getQuan_medu()==null?new FDouble(0):ordsrv.getQuan_medu()).multiply(ordsrv.getPri()));
						}
						
					}
				}
			}
		}
		BigDecimal a=new BigDecimal(totalPri.setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		return a.stripTrailingZeros().toPlainString();
	}
	
	private String getApLabName(String code)throws BizException{
	    StringBuffer sqlsb = new StringBuffer();
	    String name = "";
	    sqlsb.append(" select doc.name from  bd_udidoc  doc, bd_udidoclist  doclist ");
	    sqlsb.append("  where doc.id_udidoclist = doclist.id_udidoclist ");
	    sqlsb.append("  and doclist.code ='").append(IBdSrvDictCodeTypeConst.SD_SAMPTP).append("'");
	    sqlsb.append("  and doc.code ='").append(code).append("'");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
	
	/**
	 * 获得表尾数据
	 * 
	 * @param ems
	 * @return
	 * @throws DAException 
	 */
	private ArrayList<String> getTailInfos(CiEmsDTO ems) throws DAException {
		OrdApLabDO labDO = (OrdApLabDO) ems.getOrapplysheet().get(EmsType.LIS + "");
		ArrayList<String> list = new ArrayList<String>();
		String str = "";
		String freq_name = "";
		String days = "";
		if (ismulexec != null && ismulexec.equals("Y")) {
			if(ems.getId_freq()!=null) {
				freq_name=getFreqName(ems.getId_freq());
			}
			//freq_name = (ems.getName_freq() == null) ? "" : ems.getName_freq().toString();
			days = (ems.getDays_or() == null) ? "" : "" + ems.getDays_or().toString() + "天";
			// str += ((ems.getName_freq() == null) ? "" :
			// ems.getName_freq().toString())
			// + ((ems.getDays_or() == null) ? "" : " " +
			// ems.getDays_or().toString() + "天");
		}

		if (ems.getDes_or() != null && !"".equals(ems.getDes_or())) {
			str += ICiOrContentConst.ChangeToEscapeCharacter(ems.getDes_or());
		}
		// 0177331: 住院医生站开检验医嘱增加备注框需求 2020-04-17
		if (!StringUtils.isNullOrEmpty(labDO.getDes_sympsign())) {
			str += ICiOrContentConst.ChangeToEscapeCharacter(labDO.getDes_sympsign());
		}
		list.add(freq_name);
		list.add(days);
		list.add(str);
		// if (str.length() > 0) {

		// }
		return list;
	}
	/**
	 * 获取频次名称
	 * @param id_freq
	 * @return
	 * @throws DAException 
	 * @throws BizException
	 */
	private static String getFreqName(String id_freq) throws DAException{
		String name = "";
		if(id_freq==null||id_freq=="") {
			return name;
		}
	    StringBuffer sqlsb = new StringBuffer();
	    sqlsb.append(" select name from  bd_freq ");
	    sqlsb.append(" where id_freq = '"+id_freq+"'");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
}
