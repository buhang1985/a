package iih.ci.ord.s.ems.op.order.copy.copylistener;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.base.ListenerUtils;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.SortEnum;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.meta.PathologyContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 0207病理复制拼接医嘱内容标准版
 * @author F
 *
 * @date 2019年12月16日下午3:57:59
 *
 * @classpath iih.ci.ord.s.ems.op.order.copy.copylistener.PathologyCopyContentOrListener
 */
public class PathologyCopyContentOrListener extends OrderCopyContentOrAbstractListener{

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
		if(newObjs[1] instanceof PathologyContentParam) {
			this.setParam((PathologyContentParam)newObjs[1]);
		}else {
			return;
		}
	}

	@Override
	public void doYourAction(IBusinessEvent event) throws BizException {
		CiOrContentDO contentdo = getCiOrContentDO();
		PathologyContentParam param=(PathologyContentParam) getParam();
		if(CiOrdUtils.isEmpty(contentdo)||CiOrdUtils.isEmpty(param)||!(((BDCommonEvent) event).getNewObjs()[1] instanceof PathologyContentParam)) {
			return;
		}
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【病理医嘱复制获取到的参数】"+"[CiOrContentDO]:"+contentdo.toString());
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【病理医嘱复制获取到的参数】"+"[PathologyContentParam]:"+param.toString());
		setTypeId(contentdo,param);//拼接类型
		setTitle(contentdo,param);//拼接头
		setItemInfos(contentdo,param);//拼接中部
		setTailInfo(contentdo,param);//拼接尾
		
	}
	/**
	 * 拼接类型
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTypeId(CiOrContentDO contentdo,PathologyContentParam param)throws BizException{
		CiOrderDO ciOrderDO=param.getCiOrderDO();
		if (!CiOrdUtils.isEmpty(ciOrderDO)&&!CiOrdUtils.isEmpty(ciOrderDO.getSd_srvtp())) {
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
	public void setTitle(CiOrContentDO contentdo,PathologyContentParam param)throws BizException{
		contentdo.setTitle("");
	}
	/**
	 * 拼接中部
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setItemInfos(CiOrContentDO contentdo,PathologyContentParam param)throws BizException{
		CiOrderDO ciOrderDO = param.getCiOrderDO();
		String id_or_old = param.getId_or_oldString();
		ArrayList<ArrayList<String>> itemList = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		String total_pri ="0";
		String nameString="";

		ArrayList<String> list = new ArrayList<String>();
		ListenerUtils urgentRed = new ListenerUtils();
		String strUrgent = "";
		if (!CiOrdUtils.isEmpty(ciOrderDO)&&!CiOrdUtils.isEmpty(ciOrderDO.getFg_urgent())&& FBoolean.TRUE.equals(ciOrderDO.getFg_urgent())) {
			if (urgentRed.GetXH_CIOR0005().booleanValue()) {
				strUrgent = "\\H01\\加急！\\N\\   ";
			} else {
				strUrgent = "加急！   ";
			}
		}
		if (!CiOrdUtils.isEmpty(id_or_old)) {
			ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
			CiorderAggDO[] ciorderAggDOs = iCiorderRService.findByAttrValString("Id_or", id_or_old);
			OrdSrvDO[] ordSrvDO = ciorderAggDOs[0].getOrdSrvDO();
			for (OrdSrvDO ordSrvDO1 : ordSrvDO) {
				if(ordSrvDO1.getSd_nodispense()!=null){
					if ("0".equals(ordSrvDO1.getSd_nodispense())) {
						if(ciOrderDO!=null) {
							if(!CiOrdUtils.isEmpty(ciOrderDO.getName_or())) {
								nameString=ciOrderDO.getName_or()+"(自备)";
							}
						}
					}else if ("1".equals(ordSrvDO1.getSd_nodispense())) {
						if(ciOrderDO!=null) {
							if(!CiOrdUtils.isEmpty(ciOrderDO.getName_or())) {
								nameString=ciOrderDO.getName_or()+"(嘱托)";
							}
						}
					}else if ("2".equals(ordSrvDO1.getSd_nodispense())) {
						if(ciOrderDO!=null) {
							if(!CiOrdUtils.isEmpty(ciOrderDO.getName_or())) {
								nameString=ciOrderDO.getName_or()+"(外配)";
							}
						}

					}
					
				}
			}
			if(StringUtils.isNullOrEmpty(nameString)){
				nameString =ciOrderDO.getName_or();		//0197525: 复制病理医嘱。医嘱拼接空白，病情描述没带过来
			}
			arrList.add(strUrgent + nameString);
			if (ordSrvDO != null && !"0.00".equals(calPrice(ordSrvDO))) {
				arrList.add(calPrice(ordSrvDO)+"元");
			} else {
				arrList.add(total_pri+"元");
			}
		}
		arrList.add("");
		itemList.add(arrList);
		contentdo.setItemInfos(itemList);
	}
	/**
	 * 拼接尾
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTailInfo(CiOrContentDO contentdo,PathologyContentParam param)throws BizException{
		ArrayList<String> list = new ArrayList<String>();
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
}
