package iih.ci.ord.s.ems.op.order.copy.copylistener;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.meta.HerbOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 0103草药复制拼接医嘱内容标准版
 * @author F
 *
 * @date 2019年12月12日下午4:20:13
 *
 * @classpath iih.ci.ord.s.ems.op.order.copy.copylistener.HerbCopyContentOrListener
 */
public class HerbCopyContentOrListener extends OrderCopyContentOrAbstractListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		if(!(SourceIdConst.COPY_CONTENTOR_HERB_SOURCEID.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
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
		this.setParam((HerbOrContentParam)newObjs[1]);
	}

	@Override
	public void doYourAction(IBusinessEvent event) throws BizException {
		CiOrContentDO contentdo = getCiOrContentDO();
		HerbOrContentParam param = (HerbOrContentParam) getParam();
		if(CiOrdUtils.isEmpty(contentdo)||CiOrdUtils.isEmpty(param)) {
			return;
		}
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【草药医嘱复制获取到的参数】"+"[CiOrContentDO]:"+contentdo.toString());
		OrdBizLogger.info(null, this.getClass().getSimpleName()+"【草药医嘱复制获取到的参数】"+"[HerbOrContentParam]:"+param.toString());
		setTypeId(contentdo, param);//拼接类型
		setTitle(contentdo, param);//拼接头
		setItemInfos(contentdo, param);//拼接中部
		setTailInfo(contentdo, param);//拼接尾
	}
	/**
	 * 拼接类型
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTypeId(CiOrContentDO contentdo,HerbOrContentParam param)throws BizException{
		String sd_srvtp = param.getSd_srvtp();
		String typeIdString="";
		if (sd_srvtp != null && sd_srvtp != "") {
			typeIdString=getSrvtpl(sd_srvtp);
		} else {
			typeIdString=ICiOrContentConst.ORContent_TYPE_DEFAULT;
		}
		contentdo.setTypeId(typeIdString);
	}
	/**
	 * 拼接头
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTitle(CiOrContentDO contentdo,HerbOrContentParam param) throws BizException{
		contentdo.setTitle(param.getOrders()==null?"":param.getOrders().toString());
	}
	/**
	 * 拼接中部
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setItemInfos(CiOrContentDO contentdo,HerbOrContentParam param) throws BizException{
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		OrdSrvDO[] ordSrvDOs = param.getCi_or_srvs();
		OrdSrvMmDO[] ordSrvMmDOs = param.getOrdSrvMMs();
		if(CiOrdUtils.isEmpty(ordSrvDOs)) {
			return ;
		}
		for (int i = 0; i < ordSrvDOs.length; i++) {
			OrdSrvDO ordSrvDO=ordSrvDOs[i];
			if(CiOrdUtils.isEmpty(ordSrvDO)||!ordSrvDO.getFg_mm().booleanValue()||DOStatus.DELETED==ordSrvDO.getStatus()) {
				continue;
			}
			OrdSrvMmDO mmDO=null;
			if(!CiOrdUtils.isEmpty(ordSrvMmDOs)) {
				for(OrdSrvMmDO ordSrvMmDO:ordSrvMmDOs) {
					if(ordSrvMmDO!=null && ordSrvDO!=null &&!CiOrdUtils.isEmpty(ordSrvMmDO.getId_orsrv())&&!CiOrdUtils.isEmpty(ordSrvDO.getId_orsrv())&&ordSrvMmDO.getId_orsrv().equals(ordSrvDO.getId_orsrv())) {
						mmDO=ordSrvMmDO;
						break;
					}
				}
			}
			ArrayList<String> itemList = new ArrayList<String>();
			if (FBoolean.TRUE.equals(ordSrvDO.getFg_self())) {
				itemList.add(ordSrvDO.getName_srv()+"(自备)");
			} else {
				if(ordSrvDO.getSd_nodispense()!=null){
					if ("0".equals(ordSrvDO.getSd_nodispense())) {
						itemList.add(ordSrvDO.getName_srv()+"(自备)");
					}else if ("1".equals(ordSrvDO.getSd_nodispense())) {
						itemList.add(ordSrvDO.getName_srv()+"(嘱托)");
					}else if ("2".equals(ordSrvDO.getSd_nodispense())) {
						itemList.add(ordSrvDO.getName_srv()+"(外配)");
					}
					
				}else{
					itemList.add(ordSrvDO.getName_srv());
				}
				
			}
			//itemList.add(ordSrvDO.getName_srv());
			if(mmDO!=null) {
				DecimalFormat df = new DecimalFormat("0.00000000");
				if(!CiOrdUtils.isEmpty(mmDO.getQuan_medu_cur())&&!CiOrdUtils.isEmpty(mmDO.getName_unit_cur())) {//门诊取ci_or_srv_mm
					BigDecimal f=new BigDecimal(df.format(mmDO.getQuan_medu_cur())).setScale(4, BigDecimal.ROUND_HALF_UP);
					String quan_med=f.stripTrailingZeros().toPlainString();
					itemList.add(quan_med);
					itemList.add(mmDO.getName_unit_cur());
				}else if(ordSrvDO.getId_medu()!=null&&ordSrvDO.getQuan_medu()!=null){//住院取ci_or_srv，ci_or_srv_mm没存
					BigDecimal f=new BigDecimal(df.format(ordSrvDO.getQuan_medu())).setScale(4, BigDecimal.ROUND_HALF_UP);
					String quan_med=f.stripTrailingZeros().toPlainString();
					itemList.add(quan_med);
					itemList.add(getMedCurName(ordSrvDO.getId_medu()));
				}
			}
			list.add(itemList);
		}
		contentdo.setItemInfos(list);
	}
	/**
	 * 拼接尾
	 * @param contentdo
	 * @param param
	 * @throws BizException
	 */
	public void setTailInfo(CiOrContentDO contentdo,HerbOrContentParam param)throws BizException{
		ArrayList<String> list = new ArrayList<String>();
		list.add(StringUtils.isNullOrEmpty(param.getName_boil()) ? "" : param.getName_boil());
		list.add(StringUtils.isNullOrEmpty(param.getName_route()) ? "" : param.getName_route());
		list.add(StringUtils.isNullOrEmpty(param.getName_freq()) ? ""
				: param.getName_freq() + (StringUtils.isNullOrEmpty(param.getName_routedes()) ? ""
						: ("、(" + param.getName_routedes()) + ")"));
		list.add(calPrice(param));
		contentdo.setTailInfo(list);
	}
	/**
	 * 药品类获得服务类型
	 * 
	 * @param sd_srvtp
	 * @return
	 */
	public static String getSrvtpl(String sd_srvtp) {
		/*
		 * 0101普药： 010101 普通药品 010102 外用药 010199 其它 010201 中成药 010202 蒙成药
		 */
		if (sd_srvtp.equals("010101") || sd_srvtp.equals("010102") || sd_srvtp.equals("010199")
				|| sd_srvtp.equals("010201") || sd_srvtp.equals("010202")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT;
		}
		/*
		 * 0102注射： 010103 注射类药品 010104 溶媒 010105 皮试液
		 */
		if (sd_srvtp.equals("010103") || sd_srvtp.equals("010104") || sd_srvtp.equals("010105")) {
			return ICiOrContentConst.ORContent_TYPE_DRUGDEFAULT2;
		}
		if (sd_srvtp.startsWith("0103")) {
			return sd_srvtp;
		}
		return "0101";
	}
	public static String calPrice(HerbOrContentParam drugContentDTO) {
		FDouble[] prices = drugContentDTO.getPrices();
		FDouble[] quancurs = drugContentDTO.getQuan_curs();
		FDouble totalPri = new FDouble(0);
		OrdSrvDO[] ordSrvDOs = drugContentDTO.getCi_or_srvs();
		for (OrdSrvDO ordsrv : ordSrvDOs) {
			if(DOStatus.DELETED!=ordsrv.getStatus()&&FBoolean.TRUE.equals(ordsrv.getFg_bl())&&(OrSrvSourceFromEnum.PHYSIAN.equals(ordsrv.getEu_sourcemd())||OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ordsrv.getEu_sourcemd())
					||OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ordsrv.getEu_sourcemd()))&&ordsrv.getSd_srvtp()!=null&&ordsrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
				if(ordsrv.getPri()!=null){
//						
					totalPri = totalPri.add(new FDouble((ordsrv.getPri()==null?new FDouble(0):ordsrv.getPri()).multiply((ordsrv.getQuan_total_medu()==null?new FDouble(0):ordsrv.getQuan_total_medu())).doubleValue(),2));
				}
			}
		}

		/*for (int i = 0; i < prices.length; i++) {
			
			totalPri = totalPri.add((prices[i] == null ? new FDouble(0) : prices[i])
					.multiply(quancurs[i] == null ? new FDouble(0) : quancurs[i]), 2);
		}*/
		return getPrettyNumber(totalPri);
	}
	public static String getPrettyNumber(FDouble number) {
		return number.setScale(-2, BigDecimal.ROUND_HALF_UP).toString();
	}
	/**
	 * 剂量名称（参数为ci_or_srv的id_medu）
	 * @param code
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static String getMedCurName(String id_medu)throws BizException{
	    String name = "";
	    if(id_medu==null||id_medu=="") {
		    return null;
	    }
	    StringBuffer sqlsb = new StringBuffer();
	    sqlsb.append(" select name from  bd_measdoc ");
	    sqlsb.append("  where id_measdoc = '"+id_medu+"'");
        List<String> list = (List<String>)(new DAFacade()).execQuery(sqlsb.toString(),  new ColumnListHandler());
	    if(list != null && list.size() > 0) {
	    	name = list.get(0);
	    }
        return name;
	}
}
