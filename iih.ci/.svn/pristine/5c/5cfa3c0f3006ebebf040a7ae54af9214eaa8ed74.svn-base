package iih.ci.ord.s.bp.orsms.lis.mergetube;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 合管生出的数据，撤回校验
 * @author zhangwq
 *
 */
public class MergeTubeDataDelValidate {
	/**
	 * 删除容器费的校验,考虑检验项目全部退费的情况
	 * 
	 * @param lstIdors
	 * @throws BizException
	 */
	public static void DiriveDataDelValide(List<String> lstIdors) throws BizException {
		if (lstIdors == null || lstIdors.size() == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select c.id_or,c.sd_su_bl,c.name_or, rel.id_relor id_or_rel from CI_APP_DIRIVE_OR_REL rel ");
		sb.append("inner join ci_app_lis_or lisor on lisor.id_ciapplissheet=rel.id_app ");
		sb.append("inner join ci_order c on c.id_or = lisor.id_or ");
		sb.append("inner join ci_order crel on crel.id_or=rel.id_relor ");
		sb.append("where c.sd_su_bl<>'2' and crel.sd_su_bl<>'2' and c.fg_sign='Y' and c.fg_canc='N' and rel.id_relor in ('"
				+ CiOrdUtils.ConcatInSqlMark(lstIdors) + "') ");
		SqlParam param = new SqlParam();
		List<CiOrderDO> list = (List<CiOrderDO>) new DAFacade().execQuery(sb.toString(),
				new BeanListHandler(CiOrderDO.class));
		
		// 如果撤回医嘱中已经包含了容器费关联的所有检验医嘱，则按自动撤回所有处理
		if (list != null && list.size() > 0) {
		    // 关联检验医嘱
		    List<String> relLisOrderIds = new ArrayList<>();
		    // 关联容器费
		    List<String> containerOrderIds = new ArrayList<>();
		    for (CiOrderDO order : list) {
		        relLisOrderIds.add(order.getId_or());
		        containerOrderIds.add(order.getId_or_rel());
		    }
		    if (lstIdors.containsAll(relLisOrderIds)) {		        
		        // 移除生成的费用医嘱
		        Iterator<String> iterator = lstIdors.iterator();
		        while (iterator.hasNext()) {
		            String next = iterator.next();
		            if (containerOrderIds.contains(next)) {
		                iterator.remove();
		            }
		        }
		        return;
		    }
		    
			//0173128: 门急诊医生站：开立血常规签署后带出两个诊疗项目、将三个医嘱全部勾选后处置撤回、处置删除报错。
			throw new BizException("生成的采集费、标本费医嘱有未勾选的关联检验医嘱，无法撤回，请勾选所有关联的检验医嘱");
		}
	}
}
