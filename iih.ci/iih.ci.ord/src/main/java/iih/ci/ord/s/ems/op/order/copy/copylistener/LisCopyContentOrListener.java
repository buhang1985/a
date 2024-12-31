package iih.ci.ord.s.ems.op.order.copy.copylistener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
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
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.meta.LisOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.xbd.udi.d.UdidocDO;
/**
 * 03检验复制拼接医嘱内容标准版
 * @author F
 *
 * @date 2019年12月17日下午2:17:19
 *
 * @classpath iih.ci.ord.s.ems.op.order.copy.copylistener.LisCopyContentOrListener
 */
public class LisCopyContentOrListener extends OrderCopyContentOrAbstractListener{

	private String ismuldose;//是否多剂量
	private String ismulexec;//是否多执行
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		if(!(SourceIdConst.COPY_CONTENTOR_LIS_SOURCEID.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
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
		this.setParam((LisOrContentParam)newObjs[1]);
		
	}

	@Override
	public void doYourAction(IBusinessEvent event) throws BizException {
		CiOrContentDO contentdo = getCiOrContentDO();
		LisOrContentParam param = (LisOrContentParam) getParam();
		if(CiOrdUtils.isEmpty(contentdo)||CiOrdUtils.isEmpty(param)) {
			return;
		}
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【检验医嘱复制获取到的参数】"+"[CiOrContentDO]:"+contentdo.toString());
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【检验医嘱复制获取到的参数】"+"[LisOrContentParam]:"+param.toString());
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
	public void getMul(CiOrContentDO contentdo,LisOrContentParam param)throws BizException{
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
	public void setTypeId(CiOrContentDO contentdo,LisOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO=param.getCiOrderDO();
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
	public void setTitle(CiOrContentDO contentdo,LisOrContentParam param)throws BizException{
		contentdo.setTitle("");
	}
	/**
	 * 拼接中部
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setItemInfos(CiOrContentDO contentdo,LisOrContentParam param)throws BizException{
		CiOrderDO ciOrderDO=param.getCiOrderDO();
		UdidocDO udidocDO=param.getUdidocDO();
		OrdApLabDO ordApLabDO =param.getOrdApLabDO();
		if(ciOrderDO==null) {
			return;
		}
		String strUrgent = "";
		ListenerUtils urgentRed = new ListenerUtils();
		if (ciOrderDO.getFg_urgent() != null && ciOrderDO.getFg_urgent().booleanValue()) {
			if (urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent = "\\H01\\加急！\\N\\   ";
			} else {
				strUrgent = "加急！   ";
			}
		}
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();	
		String total_pri = "0";
		OrdSrvDO[] ordSrvDOs = param.getCi_or_srvs();
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
		
		// 如果有标本就拼接
		if (udidocDO!=null&&!CiOrdUtils.isEmpty(udidocDO.getName())) {
			arrList.add(strUrgent + name_srvs + "(" + udidocDO.getName() + ")");
		} else {
			arrList.add(strUrgent + name_srvs);
		}
		if (ismuldose != null && ismuldose.equals("Y")) {
			arrList.add((ciOrderDO.getQuan_medu() == null) ? "" : ciOrderDO.getQuan_medu().toString());
			arrList.add((ciOrderDO.getName_unit_med() == null) ? "" : ciOrderDO.getName_unit_med());
		} else {
			arrList.add("");
			arrList.add("");
		}
		if(param.getCi_or_srvs() != null && param.getCi_or_srvs().length >0){
			OrdSrvDO[] ordSrvDO = param.getCi_or_srvs();
			if (ordSrvDO != null && !"0.00".equals(calPrice(ordSrvDO))) {
				arrList.add(calPrice(ordSrvDO)+"元");
			} else {
				arrList.add(total_pri+"元");
			}
		}else{
			if (ordApLabDO!=null&&!CiOrdUtils.isEmpty(ordApLabDO.getId_or())) {
				ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
				CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", ordApLabDO.getId_or());
				OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
				if (ordSrvDO != null && !"0.00".equals(calPrice(ordSrvDO))) {
					arrList.add(calPrice(ordSrvDO)+"元");
				} else {
					arrList.add(total_pri+"元");
				}
			}
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
	public void setTailInfo(CiOrContentDO contentdo,LisOrContentParam param)throws BizException{
		ArrayList<String> list = new ArrayList<String>();
		CiOrderDO ciOrderDO=param.getCiOrderDO();
		String str = "";
		String freq_name = "";
		String days = "";
		if(ciOrderDO!=null) {
			if (ismulexec != null && ismulexec.equals("Y")) {
				freq_name = (ciOrderDO.getFreq_name() == null) ? "" : ciOrderDO.getFreq_name().toString();
				days = (ciOrderDO.getDays_or() == null) ? "" : "" + ciOrderDO.getDays_or().toString() + "天";
			}
			if (!CiOrdUtils.isEmpty(ciOrderDO.getDes_or())) {
				str += ICiOrContentConst.ChangeToEscapeCharacter(ciOrderDO.getDes_or());
			}
		}
		list.add(freq_name);
		list.add(days);
		list.add(str);
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
						&& (OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())|| OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
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
}
