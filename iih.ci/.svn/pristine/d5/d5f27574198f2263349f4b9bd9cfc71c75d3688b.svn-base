package iih.ci.ord.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取收费状态标识 不在sql查询的原因是有的表关联ci_or_srv 有的不关联 不管怎样这个类的方法肯定需要 故全部统一走这个类查询收费标识
 * @author F
 *
 */
public class GetPayFlagHelper {
	
	/**
	 * 获取收费状态标识
	 * @param column
	 * @param columnValue
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] getOrdSrvDO(String column,String columnValue) throws BizException {

		if (StringUtil.isEmpty(columnValue)) {
			return null;
		}
		String sql = "select id_or from ci_order where "+column+"=? ";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(columnValue);
		CiOrderDO ciOrderDO = (CiOrderDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(CiOrderDO.class));
		if(ciOrderDO==null) {
			return null;
		}
		IOrdSrvDORService service = ServiceFinder.find(IOrdSrvDORService.class);
		OrdSrvDO[] ordSrvDOs = service.findByAttrValString(OrdSrvDO.ID_OR, ciOrderDO.getId_or());
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		List<OrdSrvDO> newDos=new ArrayList<OrdSrvDO>();
		if(!CiOrdUtils.isEmpty(ordSrvDOs)) {
			String string="";
			for(OrdSrvDO srvDO:ordSrvDOs) {
				if(srvDO.getFg_bl()!=null&&"Y".equals(srvDO.getFg_bl().toString())) {
					newDos.add(srvDO);
					string=string+srvDO.toString()+",";
				}
			}
			OrdBizLogger.info(ctx, "获取收费状态标识:"+string);
			if(newDos!=null&&newDos.size()>0) {
				OrdBizLogger.info(ctx, "获取收费状态标识[0]:"+newDos.get(0).getSd_su_bl());
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
		if(StringUtil.isEmpty(idors)) {
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
		System.out.println("ciOrderDO.getCode_entp():"+ciOrderDO.getCode_entp());
		if(ciOrderDO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)) {//门诊00
			return "01";
		}
		if(ciOrderDO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) {//急诊01
			return "02";
		}
		if(ciOrderDO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {//住院10
			return "03";
		}
		if(ciOrderDO.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) {//体检02
			return "04";
		}
		return null;
	}
}
