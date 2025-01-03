package iih.ci.ord.s.external.gvchina.bp;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.external.gvchina.meta.GvDrugOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvSurgeryOrderRstInfo;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 获取患者药品项目医嘱信息业务处理逻辑
 * @author wangqingzhu
 *
 */
public class GetPatOrderDrugInfos  extends BaseGetPatInfo{
	public GvDrugOrderRstInfo[] exec(String code_en,String code_dept) throws BizException{
		
		// 有效性判断
		if (CiOrdUtils.isEmpty(code_en) || CiOrdUtils.isEmpty(code_dept)){
			throw new BizException("就诊编码或者科室编码不能为空");
		}
		OpBasicDTO opBasicInfo = ServiceFinder.find(IEnOutQryService.class).getOpBasicInfoByEntCode(code_en);
		if( null == opBasicInfo){
			throw new BizException(String.format("不存在患者就诊信息（code_en:%s",code_en));
		}
		
		// 组织查询语句
		StringBuilder sb = new StringBuilder(" select ");
		sb.append(" mm.code_mm ,mm.name_mm name, mm.quan_cur totalQuan,mm.id_pgku_cur totalQuanUnitCode, mm.id_dosage dosageCode, ")
			.append(" ord.id_en,ord.days_or useDays, ord.dt_effe effeTime, ord.id_dep_sign signDeptCode, ")
			.append(" srv.quan_medu medQuan , srv.id_medu medUnitCode,  srv.id_route routeCode, srv.id_freq freqCode, ")
			.append(" bm.spec,ut.name medUnitName, route.name routeName,freq.name freqName,ut1.name totalQuanUnitName,udi.name dosageName,routedes.name routeDes ")
			.append(" from ci_order ord ")
			.append(" left join ci_or_srv srv on ord.id_or = srv.id_or ")
			.append(" left join ci_or_srv_mm mm on srv.id_orsrv = mm.id_orsrv ")
			.append(" left join bd_mm bm on mm.id_mm = bm.id_mm ")
			.append(" left join bd_measdoc ut on srv.id_medu = ut.id_measdoc ")
			.append(" left join bd_measdoc ut1 on mm.id_pgku_cur = ut1.id_measdoc ")
			.append(" left join bd_route route on srv.id_route = route.id_route ")
			.append(" left join bd_route_des routedes on srv.id_routedes = routedes.id_routedes ")
			.append(" left join bd_udidoc udi on mm.id_dosage = udi.id_udidoc  ")
			.append(" left join bd_freq freq on srv.id_freq = freq.id_freq ")
			.append(" left join bd_dep dep on ord.id_dep_or = dep.id_dep ")
			.append(" where srv.fg_mm = 'Y' and ord.fg_sign = 'Y' and ord.ds = 0 and ord.sd_srvtp like '01%' and ord.fg_canc = 'N' and srv.sd_su_bl != '2' and ")
			.append(EnvContextUtil.processEnvContext("", new CiOrderDO(), "ord"))
			.append(" and ord.id_en = ?")
			.append(" and dep.code = ?");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(opBasicInfo.getId_ent());
		sqlParam.addParam(code_dept);
		
		List<GvDrugOrderRstInfo> listGvDrugOrderRstInfo = (List<GvDrugOrderRstInfo>)new DAFacade().execQuery(sb.toString(), sqlParam,new BeanListHandler(GvDrugOrderRstInfo.class));
		if(null != listGvDrugOrderRstInfo){
			// 填充患者基本信息
			for(GvDrugOrderRstInfo info : listGvDrugOrderRstInfo){
				info.setId_key(opBasicInfo.getCode_pat()+opBasicInfo.getTimes_op());
				info.setPatCode(opBasicInfo.getCode_pat());
				info.setEnTimes(opBasicInfo.getTimes_op());
			}
		}
		// 结果集处理
		return (null == listGvDrugOrderRstInfo || listGvDrugOrderRstInfo.size() == 0)?null:listGvDrugOrderRstInfo.toArray(new GvDrugOrderRstInfo[listGvDrugOrderRstInfo.size()]);
	}
}
