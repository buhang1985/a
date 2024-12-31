package iih.ci.preip.imp.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.preip.di.bp.CiPreIpEntpUpdateBP;
import iih.ci.preip.imp.CiPreIPImpRst;
import iih.ci.preip.order.d.CiOrPipDO;
import iih.ci.preip.order.i.ICiorpipCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
import xap.mw.core.data.Context;

/**
 * 预住院医嘱导入成正式医嘱逻辑代理实现类
 * @author mkp
 *
 */
public class ImportPreIPOrdersBP {
    public static final String PRE_IP_CONTENET_PREFIX = "【院前】";

	/**
	 * 预住院医嘱导入为正式医嘱逻辑执行实现
	 * @param id_en
	 * @param id_emp_oper 
	 * @param id_dep_oper 
	 * @param dt_oper 
	 * @param dt_acpt 
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public CiPreIPImpRst exec(String id_en, FDateTime dt_acpt, FDateTime dt_oper, String id_dep_oper, String id_emp_oper) throws BizException{
		// 更新ci_order
		StringBuilder ordSql = new StringBuilder();
		ordSql.append("select * from ci_order where id_en = ? and code_entp = ?");
		SqlParam ordSqlParam = new SqlParam();
		ordSqlParam.addParam(id_en);
		ordSqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		
		List<CiOrderDO> orders = (List<CiOrderDO>) new DAFacade().execQuery(ordSql.toString(), ordSqlParam, new BeanListHandler(CiOrderDO.class));
		if (orders == null || orders.size() < 1) {
			return new CiPreIPImpRst("未查询到患者的预住院医嘱", FBoolean.FALSE);
		}
		
		// 更新医嘱信息，就诊类型 、生效时间等，并向记录表中写入记录
		updateOrders(dt_acpt, dt_oper, id_dep_oper, id_emp_oper, orders);
		
		// 更新诊断信息
		updateDiags(id_en, IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		
		return new CiPreIPImpRst("患者预住院医嘱导入成功", FBoolean.TRUE);
	}

    /**
	 * 更新医嘱信息
	 * @param dt_acpt
	 * @param dt_oper
	 * @param id_dep_oper
	 * @param id_emp_oper
	 * @param orders
	 * @throws DAException
	 * @throws BizException
	 */
    @SuppressWarnings("unchecked")
    private void updateOrders(FDateTime dt_acpt, FDateTime dt_oper, String id_dep_oper, String id_emp_oper,
            List<CiOrderDO> orders) throws DAException, BizException {
        List<OrdSrvDO> orsrvs = new ArrayList<>();
		List<CiOrPipDO> ciOrPipDOs = new ArrayList<>();
		
		// 是否允许修改医嘱生效时间
		FBoolean dtEffeModifyEnabled = null;
		
		for (CiOrderDO order : orders) {
		    /*
		     * 当【预住院转住院时医嘱生效时间是否修改】= True时，ci_order.dt_effe = 入参【入科时间】
		     */
		    FDateTime dt_effe_old = order.getDt_effe();
		    FBoolean modified = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(), "CIOR0807");
		    if (modified.booleanValue()) {
		        order.setDt_effe(dt_acpt);
		    }
			order.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			order.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			String content_or = PRE_IP_CONTENET_PREFIX + order.getContent_or();
			order.setContent_or(content_or);
			order.setStatus(DOStatus.UPDATED);
			
			// 更新ci_or_srv
			StringBuilder srvSql = new StringBuilder();
			srvSql.append("select * from ci_or_srv where id_or = ?");
			SqlParam srvSqlParam = new SqlParam();
			srvSqlParam.addParam(order.getId_or());
			List<OrdSrvDO> srvsOfOrder = (List<OrdSrvDO>) new DAFacade().execQuery(srvSql.toString(), srvSqlParam, new BeanListHandler(OrdSrvDO.class));
			
			for (OrdSrvDO ordSrv : srvsOfOrder) {
				ordSrv.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
				ordSrv.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
				ordSrv.setStatus(DOStatus.UPDATED);
				orsrvs.add(ordSrv);
			}
			
			// 新建操作记录
			CiOrPipDO orPipDO = new CiOrPipDO();
			String id_orpip = new DBUtil().getOIDs(1)[0];
			orPipDO.setId_orpip(id_orpip);
			orPipDO.setId_or(order.getId_or());
			orPipDO.setFg_effe_update(dtEffeModifyEnabled);
			orPipDO.setDt_effe_old(dt_effe_old);
			orPipDO.setId_dep_oper(id_dep_oper);
			orPipDO.setId_emp_oper(id_emp_oper);
			orPipDO.setDt_oper(dt_oper);
			orPipDO.setFg_pip(FBoolean.TRUE);
			orPipDO.setStatus(DOStatus.NEW);
			ciOrPipDOs.add(orPipDO);
		}
		
		// 保存ci_order
		ServiceFinder.find(ICiorderMDOCudService.class).save(orders.toArray(new CiOrderDO[0]));
		// 保存ci_or_srv
		ServiceFinder.find(ICiorderSrvDOCudService.class).save(orsrvs.toArray(new OrdSrvDO[0]));
		// 向ci_or_pip表中写入记录
		ServiceFinder.find(ICiorpipCudService.class).save(ciOrPipDOs.toArray(new CiOrPipDO[0]));
    }
    
    /**
     * 更新诊断信息
     * @param id_en
     * @param sdCodeEntpIpPre
     * @throws BizException 
     */
    private void updateDiags(String id_en, String code_entp) throws BizException {
        CiPreIpEntpUpdateBP bp = new CiPreIpEntpUpdateBP();
        bp.exec(id_en, code_entp);
    }
}
