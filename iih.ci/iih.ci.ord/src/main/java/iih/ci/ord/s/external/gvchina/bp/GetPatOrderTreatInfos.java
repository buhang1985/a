package iih.ci.ord.s.external.gvchina.bp;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.external.gvchina.meta.GvTreatOrderRstInfo;
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
 * 获取患者诊疗项目医嘱信息业务处理逻辑
 * 
 * @author wangqingzhu
 *
 */
public class GetPatOrderTreatInfos  extends BaseGetPatInfo {
	public GvTreatOrderRstInfo[] exec(String code_en, String code_dept) throws BizException {
		// 有效性判断
		if (CiOrdUtils.isEmpty(code_en) || CiOrdUtils.isEmpty(code_dept)) {
			throw new BizException("就诊编码或者科室编码不能为空");
		}
		OpBasicDTO opBasicInfo = ServiceFinder.find(IEnOutQryService.class).getOpBasicInfoByEntCode(code_en);
		if (null == opBasicInfo) {
			throw new BizException(String.format("不存在患者就诊信息（code_en:%s", code_en));
		}
		StringBuilder sb = new StringBuilder(" select ");
		sb.append(" ord.id_en, ord.id_emp_sign doctorCode, ord.id_srv code,ord.name_or name,ord.dt_effe appTime ")
				.append(" from ci_order ord ")
				.append(" left join bd_dep dep on ord.id_dep_or = dep.id_dep ")
				.append(" where ord.fg_sign = 'Y' and ord.fg_canc = 'N' and ord.sd_su_bl != '2' and ord.ds = 0 and ord.sd_srvtp like '05%' and ")
				.append(EnvContextUtil.processEnvContext("", new CiOrderDO(), "ord"))
				.append(" and ord.id_en =?")
				.append(" and dep.code =?");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(opBasicInfo.getId_ent());
		sqlParam.addParam(code_dept);
		
		// 查询数据库
		List<GvTreatOrderRstInfo> listGvTreatOrderRstInfo = (List<GvTreatOrderRstInfo>) new DAFacade()
				.execQuery(sb.toString(), sqlParam,new BeanListHandler(GvTreatOrderRstInfo.class));
		if (null != listGvTreatOrderRstInfo) {
			// 填充患者基本信息
			for (GvTreatOrderRstInfo info : listGvTreatOrderRstInfo) {
				info.setId_key(opBasicInfo.getCode_pat() + opBasicInfo.getTimes_op());
				info.setPatCode(opBasicInfo.getCode_pat());
				info.setEnTimes(opBasicInfo.getTimes_op());
			}
		}

		return listGvTreatOrderRstInfo == null || listGvTreatOrderRstInfo.size() == 0 ? null
				: listGvTreatOrderRstInfo.toArray(new GvTreatOrderRstInfo[listGvTreatOrderRstInfo.size()]);
	}
}
