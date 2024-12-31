package iih.bl.pay.debtcallup;

import java.util.List;

import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.bl.inc.blincquerydto.d.DetailsReceiptDTO;
import iih.bl.pay.dto.d.DebtinfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class DebtcallupBp {

	/**
	 * 重写findByQCond()方法，通过用户选择的病区来查询出 所选病区内所有欠款的病人的欠款信息
	 * @param whereSql
	 * @param orderStr
	 * @param isLazy
	 * @return
	 */
	public DebtinfoDTO[] findDebtinfoDTOsByQCond(String whereSql,
			String orderStr, FBoolean isLazy)throws BizException {
		// TODO Auto-generated method stub
		StringBuffer sql1=new StringBuffer();
				
		//改用左连接来查询，可以保证一般情况下都能查出来
		sql1.append(" select distinct t1.id_dep_phy, t1.id_dep_nur, t1.name_pat, t1.code, t1.id_patca, t1.dt_acpt, t1.code_entp, t6.name name_patca, t2.amt_prepay, ");
		sql1.append(" t2.amt_uncg, t7.name name_sdstatus, t5.sd_status, t5.name_bed, t3.name name_dep_phy, t4.name name_dep_nur, ( t2.amt_uncg - t2.amt_prepay ) amt_debt "); 
		sql1.append(" from  en_ent t1");
		sql1.append(" left join  en_ent_acc t2 on  t1.id_ent = t2.id_ent");
		sql1.append(" left join  bd_dep t3 on   t1.id_dep_phy = t3.id_dep");
		sql1.append(" left join  bd_dep t4 on   t1.id_dep_nur = t4.id_dep");
		sql1.append(" left join  en_ent_ip t5  on  t1.id_ent = t5.id_ent");
		sql1.append(" left join  pi_pat_ca t6  on  t1.id_patca = t6.id_patca ");
		sql1.append(" left join  bd_udidoc t7  on  t5.sd_status = t7.code ");
		sql1.append(" join  bd_udidoclist t8 on t7.id_udidoclist = t8.id_udidoclist  and t8.code = 'EN.EN.0505' ");
		sql1.append("  where t2.amt_uncg > t2.amt_prepay  and t1.fg_ip='Y' ");
		
		
		 StringBuffer bb =new StringBuffer();
		 bb.append(sql1);
		 bb.append(whereSql);  //会往原sql后边追加查询条件如在where后追加 and id_dep_nur=? 字符串，这里字符串中的参数值从前台获得
		 System.out.println(bb);
		 List<DebtinfoDTO> list  = (List<DebtinfoDTO>)new DAFacade().execQuery(bb.toString(), new BeanListHandler(DebtinfoDTO.class));
		 DebtinfoDTO[]  debtdos=list.toArray(new DebtinfoDTO[0]);
			TimeService timeService = new TimeServiceImpl();
	        FDateTime dateTime =timeService.getUFDateTime();
	        FDate  date=dateTime.getDate();
	        FDate dtbefore=date.getDateBefore(1);
	        String dtnowstr=date.toStdString();
	        String dtbeforestr=dtbefore.toStdString();
	        for(int i=0;i<debtdos.length;i++){
	        	debtdos[i].setDt_print(dtnowstr);
	        	debtdos[i].setDt_deadline(dtbeforestr); // 当前日期的前一天
	         }
		 return debtdos;
		
	}

}
