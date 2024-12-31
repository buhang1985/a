package iih.ci.ord.s.external.provide.bp.cdss.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.i.external.provide.meta.cdss.OrderInfoDTO;
import iih.ci.ord.i.external.provide.meta.cdss.OrderItemInfoDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 医嘱数据服务层
 * 
 * @author MaKunPeng
 *
 */
public class OrderInfoRepository {
    
    /**
     * 查询医嘱数据
     * @param orderIds
     * @return
     * @throws BizException 
     */
    public OrderInfoDTO[] findOrderInfoByIdOrs(String[] orderIds) throws BizException {
        StringBuilder orderIdsStr = new StringBuilder();
        for (String id : orderIds) {
            orderIdsStr.append(",").append(id);
        }

        // 查询医嘱信息
        OrderInfoDTO[] orderInfoDTOs = getOrderInfos(orderIdsStr.substring(1));
        
        /*
         * 查询医嘱项目信息
         * key: id_or
         * value: OrderItemInfoDTO列表
         */
        Map<String, FArrayList> orderItemMap = getOrderItemMap(orderIdsStr.substring(1));
        
        // 设置医嘱项目信息
        for (OrderInfoDTO orderInfoDTO : orderInfoDTOs) {
            orderInfoDTO.setOrdersrvlist(orderItemMap.get(orderInfoDTO.getId_or()));
        }
        
        return orderInfoDTOs;
    }


    private OrderInfoDTO[] getOrderInfos(String orderIds) throws BizException {
        SqlParamBuilder sql = new SqlParamBuilder();
        sql.appendSql(" select ord.ID_OR,")
        .appendSql("       ord.CODE_OR,")
        .appendSql("       srvtp.CODE,")
        .appendSql("       srvtp.NAME,")
        .appendSql("       ord.FG_LONG,")
        .appendSql("       ord.SD_SU_OR,")
        .appendSql("       srvtp.Code sd_srvtp,")
        .appendSql("       srvtp.Name name_srvtp,")
        .appendSql("       status.NAME name_su_or,")
        .appendSql("       ord.DT_ENTRY,")
        .appendSql("       ord.DT_CHK dt_confirm,")
        .appendSql("       ord.DT_EFFE,")
        .appendSql("       ord.DT_END,")
        .appendSql("       depor.ID_DEP id_dep_or,")
        .appendSql("       depor.NAME name_dep_or,")
        .appendSql("       empor.ID_PSNDOC id_emp_or,")
        .appendSql("       empor.NAME name_emp_or,")
        .appendSql("       depcfm.ID_DEP id_dep_confirm,")
        .appendSql("       depcfm.NAME name_dep_confirm,")
        .appendSql("       empcfm.ID_PSNDOC id_emp_confirm,")
        .appendSql("       empcfm.NAME name_emp_confirm,")
        .appendSql("       depsign.ID_DEP id_dep_sign,")
        .appendSql("       depsign.NAME name_dep_sign,")
        .appendSql("       empsign.ID_PSNDOC id_emp_sign,")
        .appendSql("       empsign.NAME name_emp_sign,")
        .appendSql("       anestp.ID_UDIDOC id_anestp,")
        .appendSql("       anestp.NAME name_anestp,")
        .appendSql("       obs_body.ID_UDIDOC id_body,")
        .appendSql("       obs_body.NAME name_body,")
        .appendSql("       ord.SD_DRUGDELIVERYMETHOD")
        .appendSql(" from ci_order ord")
        .appendSql("         left join BD_UDIDOC srvtp on ord.ID_SRVTP = srvtp.ID_UDIDOC")
        .appendSql("         left join bd_udidoc status on ord.ID_SU_OR = status.ID_UDIDOC")
        .appendSql("         left join bd_dep depor on ord.ID_DEP_OR = depor.ID_DEP")
        .appendSql("         left join bd_psndoc empor on ord.ID_EMP_OR = empor.ID_PSNDOC")
        .appendSql("         left join bd_dep depcfm on ord.ID_DEP_CHK = depcfm.ID_DEP")
        .appendSql("         left join bd_psndoc empcfm on ord.ID_EMP_CHK = empcfm.ID_PSNDOC")
        .appendSql("         left join bd_dep depsign on ord.ID_DEP_SIGN = depsign.ID_DEP")
        .appendSql("         left join bd_psndoc empsign on ord.ID_EMP_SIGN = empsign.ID_PSNDOC")
        .appendSql("         left join bd_freq freq on ord.id_freq = freq.id_freq")
        .appendSql("         left join ci_ap_obs obs on obs.ID_OR = ord.ID_OR")
        .appendSql("         left join BD_UDIDOC obs_body on obs.ID_BODY = obs_body.ID_UDIDOC")
        .appendSql("         left join CI_AP_LAB lab on lab.ID_OR = ord.ID_OR")
        .appendSql("         left join ci_ap_sug sug on sug.ID_OR = ord.ID_OR")
        .appendSql("         left join bd_udidoc anestp on anestp.ID_UDIDOC = sug.ID_ANESTP")
        .appendSql(" where ord.ID_OR IN")
        .appendSql("      (")
        .appendSqlParam("          SELECT REGEXP_SUBSTR(?, '[^,]+', 1, LEVEL) AS value_str", orderIds)
        .appendSql("          FROM DUAL")
        .appendSql("          CONNECT BY LEVEL <=")
        .appendSql("                     LENGTH(TRIM(TRANSLATE(?, TRANSLATE(?, ',', ' '), ' '))) + 1").appendParam(orderIds).appendParam(orderIds)
        .appendSql("      )");
        
        List<OrderInfoDTO> list = sql.Q(OrderInfoDTO.class);
        
        if (list == null || list.size() == 0) {
            return null;
        }
        
        return list.toArray(new OrderInfoDTO[0]);
    }
    
    /**
     * 查询医嘱对应的医嘱项目
     * 
     * @param orderIds
     * @return
     * @throws BizException 
     */
    @SuppressWarnings("unchecked")
    private Map<String, FArrayList> getOrderItemMap(String orderIds) throws BizException {
        SqlParamBuilder sql = new SqlParamBuilder();
        sql.appendSql(" select orsrv.ID_ORSRV,")
        .appendSql("       ord.ID_OR,")
        .appendSql("       bdsrv.NAME name_Srv,")
        .appendSql("       bdmm.NAME trade_name,")
        .appendSql("       (case when substr(ord.sd_srvtp, 0, 2) = '01' then bdsrv.NAME end) common_name,")
        .appendSql("       bdmm.APPRNO,")
        .appendSql("       bdmm.CODE code_mm,")
        .appendSql("       mmca.NAME name_mmca,")
        .appendSql("       dosage.NAME name_dosage,")
        .appendSql("       route.NAME name_route,")
        .appendSql("       freq.CODE code_freq,")
        .appendSql("       freq.NAME name_freq,")
        .appendSql("       orsrv.QUAN_MEDU quan_med,")
        .appendSql("       NVL2(mmpkg.FACTOR, srvmm.QUAN_CUR * mmpkg.FACTOR, null) as quan_total_medu,")
        .appendSql("       quan_meadoc.NAME name_unit_med,")
        .appendSql("       orsrv.FG_SKINTEST")
        .appendSql(" from ci_order ord")
        .appendSql("         inner join ci_or_srv orsrv on ord.ID_OR = orsrv.ID_OR")
        .appendSql("         left join BD_UDIDOC srvtp on orsrv.ID_SRVTP = srvtp.ID_UDIDOC")
        .appendSql("         left join bd_udidoc status on ord.ID_SU_OR = status.ID_UDIDOC")
        .appendSql("         left join ci_or_srv_mm srvmm on orsrv.ID_ORSRV = srvmm.ID_ORSRV")
        .appendSql("         left join bd_mm bdmm on srvmm.ID_MM = bdmm.ID_MM")
        .appendSql("         left join bd_srv bdsrv on bdsrv.ID_SRV = orsrv.ID_SRV")
        .appendSql("         left join bd_mmca mmca on bdmm.ID_MMCA = mmca.ID_MMCA")
        .appendSql("         left join bd_srv_drug srvdrug on srvdrug.ID_SRV = orsrv.ID_SRV")
        .appendSql("         left join bd_udidoc dosage on srvdrug.ID_DOSAGE = dosage.ID_UDIDOC")
        .appendSql("         left join bd_route route on orsrv.ID_ROUTE = route.ID_ROUTE")
        .appendSql("         left join bd_freq freq on ord.id_freq = freq.id_freq")
        .appendSql("         left join bd_measdoc quan_meadoc on orsrv.ID_MEDU = quan_meadoc.ID_MEASDOC")
        .appendSql("         left join BD_MM_PKGU mmpkg on srvmm.ID_MM = mmpkg.ID_MM and srvmm.ID_PGKU_CUR = mmpkg.ID_UNIT_PKG and mmpkg.SD_MMPKGUPRO = '1'")
        .appendSql("where ord.ID_OR IN")
        .appendSql("      （")
        .appendSql("          SELECT REGEXP_SUBSTR(?, '[^,]+', 1, LEVEL) AS value_str").appendParam(orderIds)
        .appendSql("          FROM DUAL")
        .appendSql("          CONNECT BY LEVEL <=")
        .appendSql("                     LENGTH(TRIM(TRANSLATE(?, TRANSLATE(?, ',', ' '), ' '))) + 1").appendParam(orderIds).appendParam(orderIds)
        .appendSql("      ) and orsrv.fg_or = 'Y'");
        
        List<OrderItemInfoDTO> list = sql.Q(OrderItemInfoDTO.class);
        if (list == null || list.size() == 0) {
            return null;
        }
        
        // 构造map
        HashMap<String, FArrayList> map = new HashMap<String, FArrayList>();
        for (OrderItemInfoDTO itemInfoDTO : list) {
            if (map.containsKey(itemInfoDTO.getId_or())) {
                map.get(itemInfoDTO.getId_or()).add(itemInfoDTO);
            } else {
                FArrayList arrayList = new FArrayList();
                arrayList.add(itemInfoDTO);
                map.put(itemInfoDTO.getId_or(), arrayList);
            }
        }
        
        return map;
    }
}
