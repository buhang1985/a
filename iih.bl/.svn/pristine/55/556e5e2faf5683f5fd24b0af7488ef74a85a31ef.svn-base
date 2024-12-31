package iih.bl.st.s.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.st.blstoep.d.BlStOepDO;

public class QryLastStInfoBp {

	@SuppressWarnings("unchecked")
	public RePrintInvoiceInfoDTO exec(String id_pat,
			OperatorInfoDTO operatorInfoDTO ,FBoolean fg_reginc,String incno,FBoolean fg_hpCard) throws BizException {
		// TODO Auto-generated method stub
		RePrintInvoiceInfoDTO rpiDto = new RePrintInvoiceInfoDTO();
		//当是非挂号发票时，所要重打发票为上一张结算的发票,并且费用来源还得是非挂号的、门诊收费来源的发票
		if(FBoolean.FALSE.equals(fg_reginc))
		{
			StringBuffer sql1=new StringBuffer();
			sql1.append("select t.id_incoep,t.id_pat,t.id_stoep, t.code_incpkg,t.incno  as incno_old,t.fg_print,st.code_st  ");
			sql1.append("from  bl_inc_oep      t     ");
			sql1.append(" inner join bl_st_oep  st on  t.id_stoep = st.id_stoep ");
			sql1.append(" inner join bl_cg_itm_oep  cgitm on  cgitm.id_stoep = st.id_stoep ");
		    sql1.append(" where ");
		    sql1.append("  t.id_incca= '@@@@AA1000000001SHRD'");
			sql1.append("  and t.fg_canc ='N'   and  t.incno is not null    ");
			sql1.append("  and t.eu_direct = 1     ");
			sql1.append("  and cgitm.eu_srctp = 0 and  length(st.id_paypatoep)>2   ");
			sql1.append("  and  t.id_pat ='").append(id_pat).append("'");
		    sql1.append("  order by  t.dt_inc  desc ");
		    List<RePrintInvoiceInfoDTO> list  = (List<RePrintInvoiceInfoDTO>)new DAFacade().execQuery(sql1.toString() ,new BeanListHandler(RePrintInvoiceInfoDTO.class));
			if(list==null || list.size() ==0){
				//throw new BizException("该患者没有非挂号发票可以重打");  //此步校验在前台校验了，在此不再校验
				return null ;
			}else{
		   
				rpiDto = list.get(0);
				String strsql = "select st.code_st as code_business,aroep.code_hp,aroep.id_hp  from bl_st_oep  st  "
				  +" left join bl_prop_oep     prop  on  prop.id_stoep = st.id_stoep"
				  +" inner join bl_prop_ar_oep  aroep on  aroep.id_propoep = prop.id_propoep"
				  +" where  st.id_stoep = '"+rpiDto.getId_stoep()+"' and  id_pat = '"+rpiDto.getId_pat()+"'";
				DAFacade dafacade = new DAFacade();
				List<BlPropArOepDO> hpDOLst = (List<BlPropArOepDO>) dafacade.execQuery(strsql, new BeanListHandler(BlPropArOepDO.class));
				if (hpDOLst != null && hpDOLst.size() > 0) 
				{
					//则本次结算是医保结算
					
					if(FBoolean.FALSE.equals(fg_hpCard))
					{
						//此步校验在前台校验了，在此不再校验
						//throw new BizException("所要重打的发票属于医保结算,获取该患者的医保卡信息失败，请重新插入医保卡");	
					}
					rpiDto.setCode_hp(hpDOLst.toArray(new BlPropArOepDO[0])[0].getCode_hp());
					rpiDto.setFg_hp_inc(FBoolean.TRUE);
				}else{
					  //则本次结算是自费结算，不管他现在是否是持卡 他要重打的票是自费的结算票，无需处理
					rpiDto.setFg_hp_inc(FBoolean.FALSE);
				}
				rpiDto.setFg_reg_inc(FBoolean.FALSE);
				return rpiDto;
			  }
        }
		//当是挂号发票号时，有可能是患者随意输入的一个发票号，不是上一个号，而是以前的某个票号，此时需要根据此票号得到其结算号
		if(FBoolean.TRUE.equals(fg_reginc))
		{
			StringBuffer sql2=new StringBuffer();
			sql2.append("select t.id_incoep,t.id_pat,t.id_stoep, t.code_incpkg,t.incno  as incno_old,t.fg_print,st.code_st  ");
			sql2.append("from  bl_inc_oep      t     ");
			sql2.append(" inner join bl_st_oep  st on  t.id_stoep = st.id_stoep ");
			sql2.append(" inner join bl_cg_itm_oep  cgitm on  cgitm.id_stoep = st.id_stoep ");
			sql2.append(" where ");
			sql2.append("  t.id_incca= '@@@@AA1000000001SHRD'");
			sql2.append("  and t.fg_canc ='N'  and  t.incno is not null    ");
			sql2.append("  and t.eu_direct = 1     ");
			sql2.append("  and cgitm.eu_srctp = 1 and  length(st.id_paypatoep)>2   ");
			sql2.append("  and  t.id_pat ='").append(id_pat).append("'");
			if(!StringUtil.isEmpty(incno))
			{
			sql2.append("  and  t.incno ='").append(incno).append("'");
			}
			sql2.append("  order by  t.dt_inc  desc ");
			 List<RePrintInvoiceInfoDTO> list2  = (List<RePrintInvoiceInfoDTO>)new DAFacade().execQuery(sql2.toString() ,new BeanListHandler(RePrintInvoiceInfoDTO.class));
			//校验用户输入的发票是否是挂号发票，如果费用来源不是挂号发票，则提示此票号不是挂号发票
			if(list2 != null && list2.size()>0 )
			{
				rpiDto = list2.get(0);
				String strsql = "select st.code_st as code_business,aroep.code_hp,aroep.id_hp  from bl_st_oep  st  "
						  +" left join bl_prop_oep     prop  on  prop.id_stoep = st.id_stoep"
						  +" inner join bl_prop_ar_oep  aroep on  aroep.id_propoep = prop.id_propoep"
						  +" where  st.id_stoep = '"+rpiDto.getId_stoep()+"' and  id_pat = '"+rpiDto.getId_pat()+"'";
						DAFacade dafacade = new DAFacade();
						List<BlPropArOepDO> hpDOLst = (List<BlPropArOepDO>) dafacade.execQuery(strsql, new BeanListHandler(BlPropArOepDO.class));
						if (hpDOLst != null && hpDOLst.size() > 0) 
						{
							//则为医保结算
							if(FBoolean.FALSE.equals(fg_hpCard))
							{
								//throw new BizException("所要重打的发票属于医保结算,获取该患者的医保卡信息失败，请重新插入医保卡");	//此步校验在前台校验了，在此不再校验
							}
							rpiDto.setCode_hp(hpDOLst.toArray(new BlPropArOepDO[0])[0].getCode_hp());
							rpiDto.setFg_hp_inc(FBoolean.TRUE);
						}else{
							//自费结算
							rpiDto.setFg_hp_inc(FBoolean.FALSE);
						}
			   rpiDto.setFg_reg_inc(FBoolean.TRUE);
			   return rpiDto;
			}else{
				   if(!StringUtil.isEmpty(incno))
				   {
					   throw new BizException(IBlMsgConst.ERROR_CHECK_INCSRCTP_ALERT);  
				   }
				  }
		}
		return null;
	}

}
