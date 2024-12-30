package iih.sc.sch.s.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.sc.sch.dto.d.MtSchDetailDTO;
import iih.sc.sch.dto.d.MtSchMgrDTO;
import iih.sc.sch.i.IScSchCmdService;
import iih.sc.sch.i.IScSchQryService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

public class SaveMtschMgrDTOBP {

	public void exec(FDate dt_b, FDate dt_e, String depId) throws BizException{
		//1。查找某个排班信息
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("sch.sd_tickmd,");
		sb.append("srv.id_scsrv,");
		sb.append("srv.name name_srv,");
		sb.append("res.id_scres,");
		sb.append("res.name name_res,");
		sb.append("dl.id_dayslot,");
		sb.append("dl.name name_dayslot,");
		sb.append("sch.scpolcn,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_chkin,");
		sb.append("sch.quan_total_appt,");
		sb.append(" sch.t_b_acpt,");
		sb.append("sch.t_e_acpt,");
		sb.append("sch.fg_active ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("left outer join sc_pl pl on sch.id_scpl = pl.id_scpl and pl.ds = 0 ");
		sb.append("left outer join sc_res res on res.id_scres = pl.id_scres and res.ds = 0 ");
		sb.append("left outer join sc_srv srv on srv.id_scsrv = pl.id_scsrv and srv.ds = 0 ");
		sb.append("left outer join bd_dayslot dl on dl.id_dayslot = sch.id_dayslot ");
		sb.append("where ");
		sb.append("sch.ds = 0 ");
		sb.append("and sch.d_sch >=? ");
		sb.append("and sch.d_sch <=? ");
		sb.append("and pl.id_dep =? ");
		SqlParam param = new SqlParam();
		param.addParam(dt_b);
		param.addParam(dt_e);
		param.addParam(depId);		
		@SuppressWarnings("unchecked")
		List<MtSchMgrDTO> datas = (List<MtSchMgrDTO>) new DAFacade().execQuery(sb.toString(),
				param, new BeanListHandler(MtSchMgrDTO.class));	
		if(ListUtil.isEmpty(datas))
			return;		

		MtSchDetailDTO detailDTO = new MtSchDetailDTO();
		detailDTO.setId_sch(datas.get(0).getId_sch());

		//2.查找排班的详细信息
		IScSchQryService qryService = ServiceFinder.find(IScSchQryService.class);
		MtSchDetailDTO newMtSchDetailDTO = qryService.getSchMgrDetail(detailDTO);
		//3.修改值开放数 总数加-1
		int i = newMtSchDetailDTO.getQuan_total()-1;
		if(i<0)
			return;
		newMtSchDetailDTO.setQuan_total(i);//总开放数
		//4.修改渠道
		FArrayList schlList = newMtSchDetailDTO.getSch_chl_list();
		int j =(( ScSchChlDO)schlList.get(0)).getQuan_appt()-1;
		if(j<0)
			return;
		(( ScSchChlDO)schlList.get(0)).setQuan_appt(j);
	
		//5.号位模式，选择其中一个设为保留
		if(newMtSchDetailDTO.getSd_tickmd() =="1"){
			FArrayList arrayList = newMtSchDetailDTO.getSch_tick_list();
			for(Object tickDO:arrayList ){
				if(((ScSchTickDO) tickDO).getEu_used() !=2){
					((ScSchTickDO) tickDO).setEu_used(2);
					break;
				}
			}
		}else{
			//号段模式，选择其中一个 开放数量减1
			FArrayList arrayList = newMtSchDetailDTO.getSch_ticks_list();
			
			for(Object ticksDO:arrayList ){
				if(((ScSchTicksDO) ticksDO).getQuecn_appt() >0){
					int num =((ScSchTicksDO) ticksDO).getQuecn_appt()-1;
					if(num>=0)
					{
						((ScSchTicksDO) ticksDO).setQuecn_appt(num);
						break;
					}
				}
			}
		}
		IScSchCmdService cmdService = ServiceFinder.find(IScSchCmdService.class);
		cmdService.saveMtSchMgr(newMtSchDetailDTO);
				
	}	

}
