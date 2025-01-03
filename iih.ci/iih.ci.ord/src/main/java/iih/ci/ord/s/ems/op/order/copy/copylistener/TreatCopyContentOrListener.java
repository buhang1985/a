package iih.ci.ord.s.ems.op.order.copy.copylistener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ArrayUtils;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.GetSrvExecDose;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.gj.MeasDocDOQuery;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.meta.TreatOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.measdoc.d.MeasDocDO;
/**
 *05诊疗复制拼接医嘱内容标准版
 * @author F
 *
 * @date 2019年12月17日下午3:43:34
 *
 * @classpath iih.ci.ord.s.ems.op.order.copy.copylistener.TreatCopyContentOrListener
 */
public class TreatCopyContentOrListener extends OrderCopyContentOrAbstractListener{

	private String ismuldose;//是否多剂量
	private String ismulexec;//是否多执行
	/**
	 * 事件源和事件类型判断
	 * @param event
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		if(!(SourceIdConst.COPY_CONTENTOR_TREAT_SOURCEID.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}
	/**
	 * 数据转换
	 * @param event
	 * @throws BizException
	 */
	@Override
	public void transformData(IBusinessEvent event) throws BizException {
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		this.setCiOrContentDO((CiOrContentDO)newObjs[0]);
		this.setParam((TreatOrContentParam)newObjs[1]);
		
	}
	/**
	 * 逻辑实现
	 * @param event
	 * @throws BizException
	 */
	@Override
	public void doYourAction(IBusinessEvent event) throws BizException {
		CiOrContentDO contentdo = getCiOrContentDO();
		TreatOrContentParam param = (TreatOrContentParam) getParam();
		if(CiOrdUtils.isEmpty(contentdo)||CiOrdUtils.isEmpty(param)) {
			return;
		}
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【诊疗医嘱复制获取到的参数】"+"[CiOrContentDO]:"+contentdo.toString());
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【诊疗医嘱复制获取到的参数】"+"[TreatOrContentParam]:"+param.toString());
		getMul(contentdo,param);//获取多剂量 多次执行
		setTypeId(contentdo, param);//拼接类型
		setTitle(contentdo, param);//拼接头
		setItemInfos(contentdo, param);//拼接中部
		setTailInfo(contentdo, param);//拼接尾
	}
	/**
	 * 获取多剂量 多次执行
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void getMul(CiOrContentDO contentdo,TreatOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO=param.getCiOrderDO();
		if(ciOrderDO!=null) {
			List<String> lst = GetSrvExecDose.exec(ciOrderDO.getId_srv());
		    ismuldose = lst.get(0);
			ismulexec = lst.get(1);
		}
	}
	/**
	 * 拼接类型
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTypeId(CiOrContentDO contentdo,TreatOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO=param.getCiOrderDO();
		if (ciOrderDO != null && !CiOrdUtils.isEmpty(ciOrderDO.getSd_srvtp())) {
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
	public void setTitle(CiOrContentDO contentdo,TreatOrContentParam param)throws BizException{
		contentdo.setTitle("");
	}
	/**
	 * 拼接中部
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setItemInfos(CiOrContentDO contentdo,TreatOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO=param.getCiOrderDO();
		String id_or_old = param.getId_or_old();
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String name_srv="";
		String strUrgent="";
		FBoolean fg_urgent = ciOrderDO.getFg_urgent();
		ListenerUtils urgentRed = new ListenerUtils();
		if(fg_urgent != null && fg_urgent.booleanValue()){
			if(urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent = "\\H01\\加急！\\N\\   ";
			}else {
				strUrgent = "加急！   ";
			}
		}
		
		String total_pri = "0元";
		if (id_or_old != null) {
			ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
			CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", id_or_old);
			if(!CiOrdUtils.isEmpty(ciorderAggDOs)) {
				OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
				for (OrdSrvDO ordSrvDO2 : ordSrvDO) {
					if(ordSrvDO2.getSd_nodispense()!=null){
						if ("0".equals(ordSrvDO2.getSd_nodispense())) {
							if(ciOrderDO!=null) {
								if (!CiOrdUtils.isEmpty(ciOrderDO.getName_or())) {
									name_srv=ciOrderDO.getName_or()+"(自备)";
								}
							}
							
						}else if ("1".equals(ordSrvDO2.getSd_nodispense())) {
							if(ciOrderDO!=null) {
								if (!CiOrdUtils.isEmpty(ciOrderDO.getName_or())) {
									name_srv=ciOrderDO.getName_or()+"(嘱托)";
								}
							}
						}else if ("2".equals(ordSrvDO2.getSd_nodispense())) {
							if(ciOrderDO!=null) {
								if (!CiOrdUtils.isEmpty(ciOrderDO.getName_or())) {
									name_srv=ciOrderDO.getName_or()+"(外配)";
								}
							}
						}
						
					}
				}
				if(StringUtils.isNullOrEmpty(name_srv)){
					name_srv =ciOrderDO.getName_or();		//0197065: 历史既往带入后，医嘱名称不显示了
				}
				if(!CiOrdUtils.isEmpty(ciOrderDO.getNote_or())){
					name_srv =name_srv+"  ("+ciOrderDO.getNote_or()+")";
				}
				arrList.add(strUrgent + name_srv);
				if (ordSrvDO!= null && !"0.00".equals(calPrice(ordSrvDO))) {
					arrList.add(calPrice(ordSrvDO)+"元");
				} else {
					arrList.add(total_pri);
				}
			}else {
				arrList.add(total_pri);
			}
		}else {
			arrList.add(total_pri);
		}
		
		if (ismuldose != null && ismuldose.equals("Y")&& ciOrderDO!=null) {
			arrList.add((ciOrderDO.getQuan_medu() == null) ? "" : ciOrderDO.getQuan_medu().toString());
			if (ciOrderDO.getId_unit_med()!=null) {
				MeasDocDO[] measDocDO = getMeasDocDO(ciOrderDO.getId_unit_med());
				if (measDocDO!=null&&measDocDO.length>0) {
					arrList.add((measDocDO[0].getName()==null)?"":(IsNumberic(measDocDO[0].getName().substring(0,1))?"*"+measDocDO[0].getName():measDocDO[0].getName()));
				}
			} else {
				arrList.add("");
			}
		} else {
			arrList.add("");
			arrList.add("");
		}

		list.add(arrList);
		contentdo.setItemInfos(list);
	}
	/**
	 * 拼接尾
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTailInfo(CiOrContentDO contentdo,TreatOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO=param.getCiOrderDO();
		if(ciOrderDO==null) {
			return;
		}
		ArrayList<String> list = new ArrayList<String>();
		String freq_name = "";
		String days = "";
		if (ismulexec != null && ismulexec.equals("Y")) {
			freq_name = (ciOrderDO.getFreq_name() == null) ? "" : ciOrderDO.getFreq_name().toString();
			days = (ciOrderDO.getDays_or() == null) ? "" : "" + ciOrderDO.getDays_or().toString() + "天";
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
						if (ordsrv.getSd_srvtp() != null&& ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
							totalPri = totalPri.add(
									(ordsrv.getQuan_total_medu() == null ? new FDouble(0) : ordsrv.getQuan_total_medu())
									.multiply(ordsrv.getPri()));
						} else {
							totalPri = totalPri.add(
									(ordsrv.getQuan_medu() == null ? new FDouble(0) : ordsrv.getQuan_medu())
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
	public static MeasDocDO[] getMeasDocDO(String id_unit_med) throws BizException {
		if(CiOrdUtils.isEmpty(id_unit_med)) {
			return null;
		}
		MeasDocDOQuery qry = new MeasDocDOQuery(id_unit_med);
		MeasDocDO[] rtn = (MeasDocDO[]) AppFwUtil.getDORstWithDao(qry, MeasDocDO.class);
		return rtn;
	}
	/**
	 * 判断字符串是否为数字
	 * 
	 * @param message
	 * @return
	 */
	protected static boolean IsNumberic(String message) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(message).matches();
	}
}
