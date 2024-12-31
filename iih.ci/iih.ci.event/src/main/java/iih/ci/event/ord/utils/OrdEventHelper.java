package iih.ci.event.ord.utils;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 处理某些字段查询类
 * @author F
 *
 * @date 2019年8月19日上午10:10:34
 *
 * @classpath iih.ci.event.ord.utils.OrdEventHelper
 */
public class OrdEventHelper {

	/**
	 * 获取收费状态标识
	 * @param column
	 * @param columnValue
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] getOrdSrvDO(String id_or) throws BizException {

		if (StringUtil.isEmpty(id_or)) {
			return null;
		}
		IOrdSrvDORService service = ServiceFinder.find(IOrdSrvDORService.class);
		OrdSrvDO[] ordSrvDOs = service.findByAttrValString(OrdSrvDO.ID_OR, id_or);
		List<OrdSrvDO> newDos=new ArrayList<OrdSrvDO>();
		if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
			for(OrdSrvDO srvDO:ordSrvDOs) {
				if(srvDO.getFg_bl()!=null&&"Y".equals(srvDO.getFg_bl().toString())) {
					newDos.add(srvDO);
				}
			}
			if(!OrdEventUtil.isEmpty(newDos)) {
				OrdEventLogger.info(OrdEventHelper.class.getSimpleName(), "获取收费状态标识[0]:"+newDos.get(0).getSd_su_bl());
			}
		}
		return newDos.toArray(new OrdSrvDO[0]);
	}
	/**
	 * 获取就诊类型（域id-消息头第三位）
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public static String getCodeEntp(String idors) throws BizException{
		if(OrdEventUtil.isEmpty(idors)) {
			return null;
		}
		String[] idorsArr=idors.split(",");
		if(idorsArr==null || idorsArr.length==0) {
			return null;
		}
		ICiorderRService iCiorderRService=ServiceFinder.find(ICiorderRService.class);
		String idorString=idorsArr[0];
		CiorderAggDO ciorderAggDO=iCiorderRService.findById(idorString);
		if(ciorderAggDO==null) {
			return null;
		}
		CiOrderDO ciOrderDO=ciorderAggDO.getParentDO();
		if(ciOrderDO==null) {
			return null;
		}
		OrdEventLogger.info(OrdEventHelper.class.getSimpleName(), "ciOrderDO.getCode_entp():"+ciOrderDO.getCode_entp());
		if(ciOrderDO.getCode_entp().equals(OrdEventUtil.OP)) {//门诊00
			return OrdEventUtil.OP_XML;
		}
		if(ciOrderDO.getCode_entp().equals(OrdEventUtil.JZ)) {//急诊01
			return OrdEventUtil.JZ_XML;
		}
		if(ciOrderDO.getCode_entp().equals(OrdEventUtil.IP)) {//住院10
			return OrdEventUtil.IP_XML;
		}
		if(ciOrderDO.getCode_entp().equals(OrdEventUtil.TJ)) {//体检02
			return OrdEventUtil.TJ_XML;
		}
		return null;
	}
}
