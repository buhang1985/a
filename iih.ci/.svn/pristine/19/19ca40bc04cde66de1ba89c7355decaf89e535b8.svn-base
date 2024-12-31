package iih.ci.ord.s.bp.orsms.ris.mergesheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 撤回图文报告时校验
 * @author zhangwq
 *
 */
public class ImageTextReportDelValidate {
	/**
	 * 删除图文报告费时的校验,检查项目存在时，不能删除图文报告费，考虑检查项目全部退费的情况
	 * 
	 * @param lstIdors
	 * @throws BizException
	 */
	public static void DiriveDataDelValideRis(List<String> lstIdors) throws BizException {
		if (lstIdors == null || lstIdors.size() == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select c.sd_su_bl,c.name_or, c.id_or, rel.id_relor id_or_rel from CI_APP_DIRIVE_OR_REL rel ");
		sb.append("inner join ci_app_ris_or lisor on lisor.ID_CIAPPRISSHEET=rel.id_app ");
		sb.append("inner join ci_order c on c.id_or = lisor.id_or ");
		sb.append("inner join ci_order crel on crel.id_or=rel.id_relor ");
		sb.append("where c.sd_su_bl<>'2' and crel.sd_su_bl<>'2' and c.fg_sign='Y' and c.fg_canc='N' and rel.id_relor in ('"
				+ CiOrdUtils.ConcatInSqlMark(lstIdors) + "') ");
		SqlParam param = new SqlParam();
		List<CiOrderDO> list = (List<CiOrderDO>) new DAFacade().execQuery(sb.toString(),
				new BeanListHandler(CiOrderDO.class));
		
		// 如果撤回医嘱中已经包含了图文费关联的所有检查医嘱，则按自动撤回所有处理
		if (list != null && list.size() > 0) {
		    // 关联检查医嘱
            List<String> relRisOrderIds = new ArrayList<>();
            // 关联图文报告费费
            List<String> containerOrderIds = new ArrayList<>();
            for (CiOrderDO order : list) {
                relRisOrderIds.add(order.getId_or());
                containerOrderIds.add(order.getId_or_rel());
            }
            if (lstIdors.containsAll(relRisOrderIds)) {             
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
			throw new BizException("存在对应的检查医嘱，不允许撤回\r\n请勾选生成的关联费用医嘱对应所有的检查医嘱\r\n");
		}
	}
}
