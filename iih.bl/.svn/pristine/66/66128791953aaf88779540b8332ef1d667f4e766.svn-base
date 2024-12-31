package iih.bl.pay.blpaypat.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;

/**
 * 或者支付方式及其分摊数据
 * @author tcy 2017-5-11修改，所有信息都从bl_pay_itm_pat_oep查出来
 * 
 *
 */
public class BlPayPmBp  {
	private String GetBlPayPmByIdCgOep()
	{
		StringBuffer sqla=new StringBuffer();
		sqla.append(" select distinct d.id_pm, d.sd_pm,e.name, d.amt,d.eu_direct pm_eu_direct,c.eu_direct pay_eu_direct,");	
		sqla.append("  d.id_bank,d.bankno,d.paymodenode,d.fg_realpay,d.id_cust ,f.name id_cust_name  ");
		sqla.append("   from bl_cg_itm_oep a ");
		sqla.append("  inner join bl_st_oep b ");
		sqla.append("     on a.id_stoep = b.id_stoep ");
		sqla.append("  inner join bl_pay_pat_oep c ");
		sqla.append("     on b.id_paypatoep = c.id_paypatoep ");
		sqla.append("  inner join bl_pay_itm_pat_oep d ");
		sqla.append("     on c.id_paypatoep = d.id_paypatoep ");
		sqla.append("  left join bd_pri_pm  e ");
		sqla.append("     on d.id_pm=e.id_pm ");
		sqla.append("  left join bd_cust f on d.id_cust=f.id_cust ");
		sqla.append("  where a.id_cgoep = ? ");
		return sqla.toString();
	}
	public BlPayPmDTO[] GetBlPayPmByIdCgOepDTO(String Id_cgoep) throws BizException
	{
		String sql=GetBlPayPmByIdCgOep();		
		
		SqlParam sqlParam = new SqlParam();
  		sqlParam.addParam(Id_cgoep);
  		
      	DAFacade cade = new DAFacade();
      	//1.查收付款明细表
    	List<BlPayPmDTO> list= (List<BlPayPmDTO>)cade.execQuery(sql,sqlParam, new BeanListHandler(BlPayPmDTO.class));
      	if(list==null)
      	{    		
      		throw new BizException("该记账主键下未查找到付款信息。\r\n 记账主键: "+Id_cgoep);
      	}
//      	//2.查分摊     分摊的信息已经回写到BL_PAY_ITM_PAT_OEP中了，故注释
//      	List<BlPropArOepDO> blPropArOepDO_list= (List<BlPropArOepDO>)cade.execQuery(getPropAmtSql(),sqlParam, new BeanListHandler(BlPropArOepDO.class));
//      	if(blPropArOepDO_list!=null && blPropArOepDO_list.size()>0)
//      	{
//      		//不考虑多医保
//      		BlPropArOepDO[] blPropArOepDO=blPropArOepDO_list.toArray(new BlPropArOepDO[0]);
//      		if(blPropArOepDO[0].getAmt_psnacc()!=null && blPropArOepDO[0].getAmt_psnacc().compareTo(new FDouble("0"))>0)
//      		{
//      			//有基金支付
//      			BlPayPmDTO blPayPmDTO=new BlPayPmDTO();
//      			//d.id_pm, d.sd_pm,e.name, d.amt,d.eu_direct pm_eu_direct,c.eu_direct pay_eu_direct
//      			blPayPmDTO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT);
//      			blPayPmDTO.setId_pm(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT);
//      			blPayPmDTO.setName("医保个人账户");
//      			if(blPropArOepDO[0].getNote()!=null)
//      			{
//      				blPayPmDTO.setPay_eu_direct(new Integer(blPropArOepDO[0].getNote()));
//      			}
//      			blPayPmDTO.setPm_eu_direct(1);
//      			blPayPmDTO.setAmt(blPropArOepDO[0].getAmt_psnacc());      			
//      			list.add(blPayPmDTO);
//      		}
//      		if(blPropArOepDO[0].getAmt_hp()!=null && blPropArOepDO[0].getAmt_hp().compareTo(new FDouble("0"))>0)
//      		{
//      			//有基金支付
//      			BlPayPmDTO blPayPmDTO=new BlPayPmDTO();
//      			//d.id_pm, d.sd_pm,e.name, d.amt,d.eu_direct pm_eu_direct,c.eu_direct pay_eu_direct
//      			blPayPmDTO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_INSUR);
//      			blPayPmDTO.setId_pm(IBdPripmCodeConst.CODE_PRI_PM_INSUR);
//      			blPayPmDTO.setName("医保基金");
//      			if(blPropArOepDO[0].getNote()!=null)
//      			{
//      				blPayPmDTO.setPay_eu_direct(new Integer(blPropArOepDO[0].getNote()));
//      			}
//      			blPayPmDTO.setPm_eu_direct(1);
//      			blPayPmDTO.setAmt(blPropArOepDO[0].getAmt_hp());      			
//      			list.add(blPayPmDTO);
//      		}
//      	}
      	
      	
		return list.toArray(new BlPayPmDTO[]{});
	}
	private String getPropAmtSql()
	{
		StringBuffer sqlb=new StringBuffer();
		sqlb.append("     select d.amt_all, d.amt_hp, d.amt_psnacc, d.amt_cash,b.eu_direct note ");
		sqlb.append("        from bl_cg_itm_oep a, bl_st_oep b, bl_prop_oep c, bl_prop_ar_oep d");
		sqlb.append("       where a.id_stoep = b.id_stoep");
		sqlb.append("         and b.id_stoep = c.id_stoep");
		sqlb.append("         and c.id_propoep = d.id_propoep");
		sqlb.append("         and a.id_cgoep = ?");
		return sqlb.toString();

	}
}
