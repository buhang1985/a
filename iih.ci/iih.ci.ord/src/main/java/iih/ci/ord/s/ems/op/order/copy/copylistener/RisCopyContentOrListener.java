package iih.ci.ord.s.ems.op.order.copy.copylistener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.GetSrvExecDose;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.orcontent.meta.RisOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
/**
 * 02(0207除外)普通检查复制拼接医嘱内容标准版
 * @author F
 *
 * @date 2019年12月16日下午4:57:49
 *
 * @classpath iih.ci.ord.s.ems.op.order.copy.copylistener.RisCopyContentOrListener
 */
public class RisCopyContentOrListener extends OrderCopyContentOrAbstractListener{
	private String ismuldose;//是否多剂量
	private String ismulexec;//是否多次执行
	public static final String SD_BODY = "BD.SRV.1010";
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		if(!(SourceIdConst.COPY_CONTENTOR_RIS_SOURCEID.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}

	@Override
	public void transformData(IBusinessEvent event) throws BizException {
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		this.setCiOrContentDO((CiOrContentDO)newObjs[0]);
		if(newObjs[1] instanceof RisOrContentParam) {
			this.setParam((RisOrContentParam)newObjs[1]);
		}else {
			return;
		}
	}

	@Override
	public void doYourAction(IBusinessEvent event) throws BizException {
		CiOrContentDO contentdo = getCiOrContentDO();
		RisOrContentParam param=(RisOrContentParam) getParam();
		if(CiOrdUtils.isEmpty(contentdo)||CiOrdUtils.isEmpty(param)||!(((BDCommonEvent) event).getNewObjs()[1] instanceof RisOrContentParam)) {
			return;
		}
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【普通检查医嘱复制获取到的参数】"+"[CiOrContentDO]:"+contentdo.toString());
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【普通检查复制获取到的参数】"+"[RisOrContentParam]:"+param.toString());
		getMul(contentdo,param);//获取多剂量 多次执行
		setTypeId(contentdo,param);//拼接类型
		setTitle(contentdo,param);//拼接头
		setItemInfos(contentdo,param);//拼接中部
		setTailInfo(contentdo,param);//拼接尾
		
	}
	/**
	 * 获取多剂量 多次执行
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void getMul(CiOrContentDO contentdo,RisOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO = param.getCiOrderDO();
		if(ciOrderDO!=null&&!CiOrdUtils.isEmpty(ciOrderDO.getId_srv())) {
			List<String> lst = GetSrvExecDose.exec(ciOrderDO.getId_srv());
			if(!CiOrdUtils.isEmpty(lst)) {
				ismuldose = lst.get(0);
				ismulexec = lst.get(1);
			}
		}
	}
	/**
	 * 拼接类型
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTypeId(CiOrContentDO contentdo,RisOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO = param.getCiOrderDO();
		if (ciOrderDO!=null && !CiOrdUtils.isEmpty(ciOrderDO.getSd_srvtp())) {
			contentdo.setTypeId(ciOrderDO.getSd_srvtp());
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}
	}
	/**
	 * 拼接头
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTitle(CiOrContentDO contentdo,RisOrContentParam param)throws BizException{
		contentdo.setTitle("");
	}
	/**
	 * 拼接中部
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setItemInfos(CiOrContentDO contentdo,RisOrContentParam param)throws BizException{
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		CiOrderDO ciOrderDO = param.getCiOrderDO();
		OrdApObsDO ordApObsDO = param.getOrdApObsDO();
		String id_or_old = param.getId_or_old();
		OrdSrvDO[] risOrdSrvDOs = param.getOrdSrvDO();
		OrdSrvDO[] ordSrvDOs = null;
		if(risOrdSrvDOs == null){
			IOrdSrvDORService iOrdSrvDORService =ServiceFinder.find(IOrdSrvDORService.class);
			ordSrvDOs = iOrdSrvDORService.findByAttrValString("Id_or",id_or_old );
		}else{
			ordSrvDOs = risOrdSrvDOs;
		}
		if(ciOrderDO!=null) {
			ListenerUtils urgentRed = new ListenerUtils();
			String strUrgent = "";
			if(ciOrderDO.getFg_urgent() != null && ciOrderDO.getFg_urgent().booleanValue()) {
				if (urgentRed.GetXH_CIOR0005().booleanValue()) {
					strUrgent = "\\H01\\加急！\\N\\   ";
				} else {
					strUrgent = "加急！   ";
				}
			}
			if (!CiOrdUtils.isEmpty(ciOrderDO.getFg_set())&& ciOrderDO.getFg_set().equals(FBoolean.TRUE)) {
				if (ordApObsDO!=null && !CiOrdUtils.isEmpty(ordApObsDO.getId_or())) {
					IOrdsrvsetRService iOrdsrvsetRService = ServiceFinder.find(IOrdsrvsetRService.class);
					OrdSrvSetDO[] findByAttrValString = iOrdsrvsetRService.findByAttrValString("Id_or", ordApObsDO.getId_or());
					String body_name="";
					String posNameString="";
					if(findByAttrValString!=null && findByAttrValString.length>0) {
						findByAttrValString=sort(findByAttrValString);
						for (OrdSrvSetDO ordSrvSetDO : findByAttrValString) {
							if(!StringUtils.isNullOrEmpty(ordSrvSetDO.getBody_name())) {
								posNameString=getPosName(ordSrvSetDO.getId_pos());
								body_name += ordSrvSetDO.getBody_name()+(posNameString==null?"":"-"+posNameString) +"、";	 
							}
						}
					}
					if(body_name.length() > 0){
						body_name=body_name.substring(0,body_name.length()-1);
					}
					
					String name_srvs= ciOrderDO.getName_or();
					for (OrdSrvDO ordSrvDO : ordSrvDOs) {
						if(ordSrvDO.getSd_nodispense()!=null){
							if ("0".equals(ordSrvDO.getSd_nodispense())) {
								name_srvs= ciOrderDO.getName_or() +"(自备)";
							}else if ("1".equals(ordSrvDO.getSd_nodispense())) {
								name_srvs= ciOrderDO.getName_or() +"(嘱托)";
							}else if ("2".equals(ordSrvDO.getSd_nodispense())) {
								name_srvs= ciOrderDO.getName_or() +"(外配)";
							}
							
						}
					}
					if (!"".equals(body_name)&&body_name!=null) {
						arrList.add(strUrgent + name_srvs + "(" + body_name + ")");
					}else{
						arrList.add(strUrgent + name_srvs);
					}
				}
			}else{
					String name_srvs= ciOrderDO.getName_or();
					for (OrdSrvDO ordSrvDO : ordSrvDOs) {
						if(ordSrvDO.getSd_nodispense()!=null){
							if ("0".equals(ordSrvDO.getSd_nodispense())) {
								name_srvs= ciOrderDO.getName_or() +"(自备)";
							}else if ("1".equals(ordSrvDO.getSd_nodispense())) {
								name_srvs= ciOrderDO.getName_or() +"(嘱托)";
							}else if ("2".equals(ordSrvDO.getSd_nodispense())) {
								name_srvs= ciOrderDO.getName_or() +"(外配)";
							}
							
						}
					}
				if (ordApObsDO!=null&&!StringUtils.isNullOrEmpty(ordApObsDO.getBiopsy())) {
					//String apObsName = getApObsName(ordApObsDO.getId_body());
					
					if (!"".equals(ordApObsDO.getBiopsy())) {
						arrList.add(strUrgent + name_srvs + "(" + ordApObsDO.getBiopsy() + ")");
					}else {
						arrList.add(strUrgent + name_srvs);
					}
				} else {
					arrList.add(strUrgent + name_srvs);
				}
			}
			//剂量和剂量单位
			if (ismuldose != null && ismuldose.equals("Y")) {
				if(!CiOrdUtils.isEmpty(ciOrderDO.getQuan_medu())&&!CiOrdUtils.isEmpty(ciOrderDO.getName_unit_med())) {
					arrList.add(ciOrderDO.getQuan_medu().toString());
					arrList.add(ciOrderDO.getName_unit_med());
				}
			} else {
				arrList.add("");
				arrList.add("");
			}
		}
		//价钱
		String total_pri = "0元";
			if (ordApObsDO!=null&&!CiOrdUtils.isEmpty(ordApObsDO.getId_or())) {
				if(risOrdSrvDOs == null){
					ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
					CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", ordApObsDO.getId_or());
					if(ciorderAggDOs!=null&&ciorderAggDOs.length>0) {
						OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
						if (ordSrvDO != null && !"0.00".equals(calPrice(ordSrvDO))) {
							arrList.add(calPrice(ordSrvDO)+"元");
						} else {
							arrList.add(total_pri);
						}
					}else {
						arrList.add(total_pri);
					}
				}else{
					if (!"0.00".equals(calPrice(risOrdSrvDOs))) {
						arrList.add(calPrice(risOrdSrvDOs)+"元");
					} else {
						arrList.add(total_pri);
					}
				}
			}
		list.add(arrList);
		
		contentdo.setItemInfos(list);
	}
	/**
	 * 拼接尾部
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTailInfo(CiOrContentDO contentdo,RisOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO = param.getCiOrderDO();
		ArrayList<String> list = new ArrayList<String>();
		String freq_name = "";
		String days = "";
		if (!CiOrdUtils.isEmpty(ciOrderDO)) {
			if (ismulexec != null && ismulexec.equals("Y")) {
				freq_name = (ciOrderDO.getFreq_name() == null) ? "" : ciOrderDO.getFreq_name().toString();
				days = (ciOrderDO.getDays_or() == null) ? "" : "" + ciOrderDO.getDays_or().toString() + "天";
			}
		}
		list.add(freq_name);
		list.add(days);
		list.add("");
		contentdo.setTailInfo(list);
	}
	/**
	 * 计算价格
	 * 
	 * @return
	 */
	public static String calPrice(OrdSrvDO[] ordsrvs) {
		FDouble totalPri = new FDouble(0);
		if (ordsrvs != null && ordsrvs.length > 0) {
			for (OrdSrvDO ordsrv : ordsrvs) {
				// 临床项目费用
				if (ordsrv!=null&&DOStatus.DELETED != ordsrv.getStatus() && FBoolean.TRUE.equals(ordsrv.getFg_bl())
						&& (OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())
								|| OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
								|| OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()))) {
					if (ordsrv.getPri() != null) {
						if (ordsrv.getSd_srvtp() != null
								&& ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
							totalPri = totalPri.add(
									(ordsrv.getQuan_total_medu() == null ? new FDouble(0) : ordsrv.getQuan_total_medu())
											.multiply(ordsrv.getPri()));
						} else {
							totalPri = totalPri
									.add((ordsrv.getQuan_medu() == null ? new FDouble(0) : ordsrv.getQuan_medu())
											.multiply(ordsrv.getPri()));
						}
					}
				}
			}
		}
		return getPrettyNumber(totalPri);
	}
	public static String getPrettyNumber(FDouble number) {
		BigDecimal a=new BigDecimal(number.setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		return a.stripTrailingZeros().toPlainString();
		//return number.setScale(-2, BigDecimal.ROUND_HALF_UP).toString();
	}
	@SuppressWarnings("unchecked")
	public static String getApObsName(String code)throws BizException{
	    StringBuffer sqlsb = new StringBuffer();
	    String name = "";
	    sqlsb.append(" select doc.name from  bd_udidoc  doc, bd_udidoclist  doclist ");
	    sqlsb.append("  where doc.id_udidoclist = doclist.id_udidoclist ");
	    sqlsb.append("  and doclist.code ='").append(SD_BODY).append("'");
	    sqlsb.append("  and doc.id_udidoc ='").append(code).append("'");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
	/**
	 * 体位名称
	 * @param code
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static String getPosName(String id_pos)throws BizException{
	    String name = "";
	    if(id_pos==null||id_pos=="") {
		    return null;
	    }
	    StringBuffer sqlsb = new StringBuffer();
	    sqlsb.append(" select name from  bd_udidoc ");
	    sqlsb.append("  where id_udidoc = '"+id_pos+"'");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
	/**
	 * 排序
	 * @param <T>
	 * @param arrays
	 * @return
	 */
	public <T> T[] sort(T[] arrays) {
		if(CiOrdUtils.isEmpty(arrays)) {
			return null;
		}
		List<T> list = (List<T>) Arrays.asList(arrays);
		Collections.sort(list, new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				if (o1 == null || o2 == null) {//OrdSrvSetDO
					return -1;
				}
				if(o1 instanceof OrdSrvSetDO && o2 instanceof OrdSrvSetDO && 
						!CiOrdUtils.isEmpty(((OrdSrvSetDO)o1).getId_orsrvset())
						&& !CiOrdUtils.isEmpty(((OrdSrvSetDO)o2).getId_orsrvset())) {
					return ((OrdSrvSetDO)o1).getId_orsrvset().compareTo(((OrdSrvSetDO)o2).getId_orsrvset());
				}
				return -1;
			}
			
		});
		int i = 0;
		for (T t : list) {
			arrays[i] = t;
			i++;
		}
		return arrays;
	}
}
