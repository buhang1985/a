package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.i.IEmsprntmplRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetEmsprntmplBP {

	private String sd_entp, id_psn, id_dep, id_grp, id_org;
	
	public GetEmsprntmplBP(String sd_entp, String id_psn, String id_dep, String id_grp, String id_org){
		this.sd_entp = sd_entp;
		this.id_psn = id_psn;
        this.id_dep = id_dep;
        this.id_grp = id_grp;
        this.id_org = id_org;
	}
	
	public EmsprntmplAggDO[] getAllEmsprntmplAggDOs() throws BizException{
		IEmsprntmplRService service = ServiceFinder.find(IEmsprntmplRService.class);
		StringBuilder builder = new StringBuilder();
		builder.append(" a0.id_grp='%s' and a0.id_org='%s' and a0.fg_active='Y' ")
		.append(" and a0.sd_ciprintsheettp in (select b.code from bd_udidoc b where b.id_udidoclist='"
						+ ICiDictCodeTypeConst.ID_CIPRNSHEETTP + "'")
		.append(" and length(b.code)=(select max(length(b0.code)) from bd_udidoc b0 where b0.id_udidoclist='"
						+ ICiDictCodeTypeConst.ID_CIPRNSHEETTP + "')");
		//就诊类型为住院
		//1、不能用医疗单打印模板表bd_ems_prntmpl和基础编码表bd_udidoc级联查询，因为通过公司平台封装的方法只能获得EmsPrnTmplDO实体集合，不能直接获得EmsprntmplAggDO集合。
		//  虽然可以通过创建EmsprntmplAggDO对象，将EmsPrnTmplDO实体set进去，但是在matchEmsprntmpl()-->exec()-->matchUrlIDs()-->matchApp()方法中，
		//  调用了aggDO.getEmsPmTmplRelSrvDO()方法，这是我们没有set进去的，如果需要set进去还得自己手动写关联查询的sql。
		//2、所以采用分开查询，如下所示
		//	2.1  查询符合条件的模板的编码
		//	2.2  根据模板编码集合查询模板集合
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(this.sd_entp)
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(this.sd_entp)) {//住院
			builder.append(" and b.ctrl2 = 'Y'");
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(this.sd_entp)
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(this.sd_entp)
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(this.sd_entp)
				) {//门诊
			builder.append(" and b.activestate = 2");
        } else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(this.sd_entp)){
        	builder.append(" and b.ctrl3 = 'Y'");//预住院
        }else {//其它业务在此扩充 
        	throw new RuntimeException("暂无当前业务类型！");
        }
		builder.append(")");
		String strSql = String.format(builder.toString(), this.id_grp, this.id_org);
		EmsprntmplAggDO[] aggDOs = service.find(strSql + this.getFg_entp(), null, FBoolean.FALSE);
		
        //各级别的打印模板分开
        List<EmsprntmplAggDO> lstAggDOs_h = new ArrayList<EmsprntmplAggDO>();//全院
        List<EmsprntmplAggDO> lstAggDOs_d = new ArrayList<EmsprntmplAggDO>();//科室
        List<EmsprntmplAggDO> lstAggDOs_p = new ArrayList<EmsprntmplAggDO>();//个人
        for(EmsprntmplAggDO aggDO:aggDOs){
			String id_depts = aggDO.getParentDO().getId_dept();
        	switch(aggDO.getParentDO().getSd_srvorrt()) {
                case "0":
                    lstAggDOs_h.add(aggDO);
                    break;
                case "1":
                    if (!StringUtils.isNullOrEmpty(id_depts) && id_depts.contains(this.id_dep))
                        lstAggDOs_d.add(aggDO);
                    break;
                case "2":
                    if (!StringUtils.isNullOrEmpty(id_depts) && id_depts.contains(this.id_psn))
                        lstAggDOs_p.add(aggDO);
                    break;
            }
        }
        
        //科室和全院的打印模板类型与个人打印模板一致，记录科室和全院打印模板的序号，从集合中去除
        List<Integer> lstindex_d = new ArrayList<Integer>();
        List<Integer> lstindex_h = new ArrayList<Integer>();
        for(EmsprntmplAggDO aggdo_p:lstAggDOs_p) {
            for (int i = 0; i < lstAggDOs_d.size(); i++) {
                if (lstAggDOs_d.get(i).getParentDO().getSd_ciprintsheettp().equals(aggdo_p.getParentDO().getSd_ciprintsheettp()))
                    lstindex_d.add(i);
            }

            for (int i = 0; i < lstAggDOs_h.size(); i++) {
                if (lstAggDOs_h.get(i).getParentDO().getSd_ciprintsheettp().equals(aggdo_p.getParentDO().getSd_ciprintsheettp()))
                    lstindex_h.add(i);
            }
        }
        for (int i = lstindex_d.size() - 1; i >= 0; i--) {
			if (lstAggDOs_d.size() > lstindex_d.get(i).intValue()) {
				lstAggDOs_d.remove(lstindex_d.get(i).intValue());
			}
        }
        for (int i = lstindex_h.size() - 1; i >= 0; i--) {
			if (lstAggDOs_h.size() > lstindex_h.get(i).intValue()) {
				lstAggDOs_h.remove(lstindex_h.get(i).intValue());
			}
        }

        //全院的打印模板类型与科室打印模板一致，记录全院打印模板的序号，从集合中去除
        lstindex_h.clear();
        for (EmsprntmplAggDO aggdo_d:lstAggDOs_d) {
            for (int i = 0; i < lstAggDOs_h.size(); i++) {
                if (lstAggDOs_h.get(i).getParentDO().getSd_ciprintsheettp().equals(aggdo_d.getParentDO().getSd_ciprintsheettp()))
                    lstindex_h.add(i);
            }
        }
        for (int i = lstindex_h.size() - 1; i >= 0; i--){
			if (lstAggDOs_h.size() > lstindex_h.get(i).intValue()) {
				lstAggDOs_h.remove(lstindex_h.get(i).intValue());
			}
        }

        lstAggDOs_h.addAll(lstAggDOs_d);
        lstAggDOs_h.addAll(lstAggDOs_p);

        return lstAggDOs_h.toArray(new EmsprntmplAggDO[]{});
	}
	
	private String getFg_entp(){
		String value="";
		switch (this.sd_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
			value = " and a0.fg_entp_op='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
			value = " and a0.fg_entp_er='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
			value = " and a0.fg_entp_er1='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
			value = " and a0.fg_entp_er2='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
			value = " and a0.fg_entp_ip='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
			value = " and a0.fg_entp_fm='Y' ";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
			value = " and a0.fg_entp_pe='Y' ";
			break;
		}

		return value;
	}
}
