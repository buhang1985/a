package iih.bl.cg.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.mp.dg.oepdgappdt.d.OepDgAppDtDO;

public class GetOepDgAppDtDOFromBlCgItmOepDO {
	/**
	 * 由记账表生成药品请领数据
	 * @param BlcgoepAggDO_arr
	 * @return
	 */
	public OepDgAppDtDO[] GetOepDgAppDtDoFromBlCgItmOepDO(BlcgoepAggDO[] BlcgoepAggDO_arr)
	{
		List<OepDgAppDtDO> OepDgAppDtDO_list=new ArrayList<OepDgAppDtDO>();
		for(int j=0;j<BlcgoepAggDO_arr.length;j++)
		{
			BlCgOepDO blCgOepDO=BlcgoepAggDO_arr[j].getParentDO();
			BlCgItmOepDO[] blCgItmOepDO_arr=BlcgoepAggDO_arr[j].getBlCgItmOepDO();
			for(int i=0;i<blCgItmOepDO_arr.length;i++)
			{
				if(FBoolean.TRUE.equals(blCgItmOepDO_arr[i].getFg_mm()))
				{
					OepDgAppDtDO oepDgAppDtDO=new OepDgAppDtDO();
					oepDgAppDtDO.setAmt_std(blCgItmOepDO_arr[i].getAmt_std());
					oepDgAppDtDO.setAmt(blCgItmOepDO_arr[i].getAmt());				
					oepDgAppDtDO.setCode_pres(null);
					oepDgAppDtDO.setCode_srv(blCgItmOepDO_arr[i].getCode_srv());
					oepDgAppDtDO.setCode_mm(blCgItmOepDO_arr[i].getCode_mm());
					oepDgAppDtDO.setCode_batch(blCgItmOepDO_arr[i].getCd_batch());				
					oepDgAppDtDO.setCode_entp(blCgItmOepDO_arr[i].getCode_enttp());
					oepDgAppDtDO.setDt_or(blCgItmOepDO_arr[i].getDt_or());
					oepDgAppDtDO.setFg_boil(null);
					oepDgAppDtDO.setFactor(blCgItmOepDO_arr[i].getFactor());
					oepDgAppDtDO.setFg_mm(blCgItmOepDO_arr[i].getFg_mm());
					oepDgAppDtDO.setId_org_or(blCgItmOepDO_arr[i].getId_org_or());				
					oepDgAppDtDO.setId_dep_or(blCgItmOepDO_arr[i].getId_dep_or());
					oepDgAppDtDO.setId_emp_or(blCgItmOepDO_arr[i].getId_emp_or());
					oepDgAppDtDO.setId_org_mp(blCgItmOepDO_arr[i].getId_org_mp());
					oepDgAppDtDO.setId_dep_mp(blCgItmOepDO_arr[i].getId_dep_mp());
					//oepDgAppDtDO.setId_cgoep(blCgItmOepDO_arr[i].getId_cgoep());
					oepDgAppDtDO.setId_cgoepitm(blCgItmOepDO_arr[i].getId_cgitmoep());
					oepDgAppDtDO.setId_grp(blCgItmOepDO_arr[i].getId_grp());
					oepDgAppDtDO.setId_org(blCgItmOepDO_arr[i].getId_org());	
					oepDgAppDtDO.setId_pat(blCgItmOepDO_arr[i].getId_pat());
					oepDgAppDtDO.setId_entp(blCgItmOepDO_arr[i].getId_enttp());
					oepDgAppDtDO.setId_prestp(null);			
					oepDgAppDtDO.setId_ent(blCgItmOepDO_arr[i].getId_ent());
					oepDgAppDtDO.setId_or(blCgItmOepDO_arr[i].getId_or());			
					oepDgAppDtDO.setId_pres(blCgItmOepDO_arr[i].getId_pres());
					oepDgAppDtDO.setId_orsrv(blCgItmOepDO_arr[i].getId_orsrv());
					oepDgAppDtDO.setId_srv(blCgItmOepDO_arr[i].getId_srv());
					oepDgAppDtDO.setId_srvca(blCgItmOepDO_arr[i].getId_srvca());
					oepDgAppDtDO.setId_mm(blCgItmOepDO_arr[i].getId_mm());
					oepDgAppDtDO.setId_mmtp(blCgItmOepDO_arr[i].getId_mmtp());				
					oepDgAppDtDO.setId_pkgu_base(blCgItmOepDO_arr[i].getPgku_base());
					oepDgAppDtDO.setId_unit_medu(blCgItmOepDO_arr[i].getSrvu());				
					oepDgAppDtDO.setId_route(null);
					oepDgAppDtDO.setId_routedes(null);				
					oepDgAppDtDO.setId_boil(null);
					oepDgAppDtDO.setId_boildes(null);
					oepDgAppDtDO.setId_freq(null);
					oepDgAppDtDO.setId_pkgu_cur(blCgItmOepDO_arr[i].getPgku_cur());				
					oepDgAppDtDO.setId_srvtp(blCgItmOepDO_arr[i].getId_srvtp());
					oepDgAppDtDO.setName_pres(null);				
					oepDgAppDtDO.setName_mm(blCgItmOepDO_arr[i].getName_mm());
					oepDgAppDtDO.setName_srv(blCgItmOepDO_arr[i].getName_srv());				
					oepDgAppDtDO.setPrice(blCgItmOepDO_arr[i].getPrice());
					oepDgAppDtDO.setQuan_base(blCgItmOepDO_arr[i].getQuan_base());				
					oepDgAppDtDO.setQuan_cur(blCgItmOepDO_arr[i].getQuan());
					oepDgAppDtDO.setQuan_or(null);				
					oepDgAppDtDO.setQuan(blCgItmOepDO_arr[i].getQuan());
					oepDgAppDtDO.setQuan_pair_mp(0);				
					oepDgAppDtDO.setQuan_mp(new FDouble(0));
					oepDgAppDtDO.setQuan_pair_bk(0);
					oepDgAppDtDO.setQuan_bk(new FDouble(0));
					oepDgAppDtDO.setQuan_medu(null);
					oepDgAppDtDO.setQuan_orders_boil(null);				
					oepDgAppDtDO.setSortno(null);
					oepDgAppDtDO.setSd_srvtp(blCgItmOepDO_arr[i].getSd_srvtp());				
					oepDgAppDtDO.setSd_prestp(null);
					oepDgAppDtDO.setSd_mmtp(blCgItmOepDO_arr[i].getSd_mmtp());
					
					//计划窗口:调接口
					oepDgAppDtDO.setId_quesite_pl(null);
					
					oepDgAppDtDO.setEu_su_mp(0);
					oepDgAppDtDO.setFg_by(null);
					oepDgAppDtDO.setDt_st(blCgItmOepDO_arr[i].getDt_st());
					oepDgAppDtDO.setDt_bl(blCgOepDO.getDt_cg());
					
					oepDgAppDtDO.setFg_otc(null);
					oepDgAppDtDO.setId_val(null);
					oepDgAppDtDO.setSd_val(null);
					oepDgAppDtDO.setId_st(null);					
					oepDgAppDtDO.setCharacter(null);
					oepDgAppDtDO.setOnlycode(blCgItmOepDO_arr[i].getOnlycode());
					oepDgAppDtDO.setNote(blCgItmOepDO_arr[i].getNote());
					oepDgAppDtDO.setStatus(DOStatus.NEW);
					OepDgAppDtDO_list.add(oepDgAppDtDO);
				}
			}	
		}
		return OepDgAppDtDO_list.toArray(new OepDgAppDtDO[]{});
	}
	

}
