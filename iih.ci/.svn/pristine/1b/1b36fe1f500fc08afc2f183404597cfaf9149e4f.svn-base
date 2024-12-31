package iih.ci.preop.imp.bp;

import java.util.List;

import iih.ci.preop.order.d.OrderListViewDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import xap.mw.core.data.BizException;

public class OrderLoadBP {
    public List<OrderListViewDTO> exec(String id_en, String code_entp) throws BizException {
        String id_en_op = new SqlParamBuilder()
                .select("aptip.id_ent id_ent")
                .from("sc_apt_ip aptip")
                .where("aptip.id_entip", id_en).V("id_ent");

        List<OrderListViewDTO> list = new SqlParamBuilder()
                .select("ts.sd_su_ts_mp imp_status,ts.id_tsor id_or,ts.code_or,ts.sd_srvtp,ts.name_or content_or,ts.id_emp_create as id_emp_or,ts.dt_effe,srvtpdoc.name as name_srvtp,psn.name as name_emp_or")
                .from("ci_ts_or ts").leftJoin("bd_udidoc srvtpdoc")
                .on("srvtpdoc.id_udidoclist='@@@@ZZ2000000000000T' and ts.sd_srvtp = srvtpdoc.code")
                .leftJoin("bd_psndoc psn").on("psn.id_psndoc = ts.id_emp_create").where("ts.fg_canc='N'")
                .and("ts.id_en", id_en_op)
                .and("ts.sd_tstp", "0")
                .Q(OrderListViewDTO.class);
        return list;
    }
}
