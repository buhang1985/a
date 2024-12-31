package iih.bl.cg.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;

public class UpdateBlOepPriceIdent {
	/**
	 * 回写划价产生数据所缺失的id_ent，回写bl_cg_itm_oep
	 * @param id_ent 回写的id_ent
	 * @param blcgoepAggDO 划价后的数据
	 * @throws BizException
	 */
	public void UpdateBlOepPriceIdent(String id_ent,BlcgoepAggDO[] blcgoepAggDO) throws  BizException
	{		
		//1.回写CG
		IBlCgItmOepDOCudService iBlCgItmOepDOCudService=ServiceFinder.find(IBlCgItmOepDOCudService.class);
		BlCgItmOepDO[] blCgItmOepDOArr=null;
		DAFacade dafacade=new DAFacade();
		String[] updateFields={"Id_ent"};
		for(BlcgoepAggDO blcgoepAggDO1: blcgoepAggDO)
		{
			blCgItmOepDOArr=blcgoepAggDO1.getBlCgItmOepDO();
			for(BlCgItmOepDO blCgItmOepDO: blCgItmOepDOArr)
			{
				blCgItmOepDO.setId_ent(id_ent);
				blCgItmOepDO.setStatus(DOStatus.UPDATED);				
				//保存bl_cg_itm_oep*****************
				//dafacade.updateDO(blCgItmOepDO, updateFields);
			}
		}
		if(blCgItmOepDOArr!=null && blCgItmOepDOArr.length>0)
		{
			iBlCgItmOepDOCudService.save(blCgItmOepDOArr);
		}
		
		//2.回写st
		String id_stoep=blcgoepAggDO[0].getBlCgItmOepDO()[0].getId_stoep();
		IBlstoepCudService iBlstoepCudService=ServiceFinder.find(IBlstoepCudService.class);
		IBlstoepRService iBlstoepRService=ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOArr=iBlstoepRService.find(" id_stoep='"+id_stoep+"'", "", FBoolean.TRUE);
		if(blStOepDOArr!=null || blStOepDOArr.length>0)
		{
			blStOepDOArr[0].setId_ent(id_ent);
			blStOepDOArr[0].setStatus(DOStatus.UPDATED);	
			iBlstoepCudService.save(blStOepDOArr);
		}
		//3.回写INC
		IBlincoepCudService  iBlincoepCudService=ServiceFinder.find(IBlincoepCudService.class);
		IBlincoepRService iBlincoepRService=ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] blincoepAggDO=iBlincoepRService.find(" id_stoep='"+id_stoep+"'", "", FBoolean.TRUE);
		if(blincoepAggDO!=null && blincoepAggDO.length>0)
		{
//			blincoepAggDO[0].getParentDO().setId_ent(id_ent);
			blincoepAggDO[0].getParentDO().setStatus(DOStatus.UPDATED);	
			iBlincoepCudService.save(blincoepAggDO);
		}
	}
	/**
	 * 回写划价产生数据所缺失的id_ent，回写bl_cg_itm_oep,bl_st_oep,bl_Inc_oep
	 * @param id_ent 回写的id_ent
	 * @param blcgoepAggDO 划价后的数据
	 * @throws BizException
	 */
	public void UpdateBlOepCgStIncPriceIdent(String id_ent,BlcgoepAggDO[] blcgoepAggDO) throws  BizException
	{
		IBlCgItmOepDOCudService iBlCgItmOepDOCudService=ServiceFinder.find(IBlCgItmOepDOCudService.class);
		List<String> id_stoepLst=new ArrayList<String>();
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		DAFacade dafacade=new DAFacade();
		String[] updateFields={"Id_ent"};
		BlCgItmOepDO[] blCgItmOepDOArr=null;
		for(BlcgoepAggDO blcgoepAggDO1: blcgoepAggDO)
		{
			 blCgItmOepDOArr=blcgoepAggDO1.getBlCgItmOepDO();
			for(BlCgItmOepDO blCgItmOepDO: blCgItmOepDOArr)
			{
				blCgItmOepDO.setId_ent(id_ent);
				blCgItmOepDO.setStatus(DOStatus.UPDATED);
				if(!id_stoepLst.contains(blCgItmOepDO.getId_stoep()))
				{
					id_stoepLst.add(blCgItmOepDO.getId_stoep());
					
					//修改st表中id_ent					
					List<BlStOepDO> BlStOepDOList=(List<BlStOepDO>)dafacade.findByCond(BlStOepDO.class, " id_stoep='" + blCgItmOepDO.getId_stoep() + "'");
					if(ListUtil.isEmpty(BlStOepDOList) || BlStOepDOList.size()==0)
					{
						throw new BizException("查询患者结算信息失败");
					}					
					for(BlStOepDO blStOepDO:BlStOepDOList)
					{
						blStOepDO.setId_ent(id_ent);
						blStOepDO.setStatus(DOStatus.UPDATED);
						dafacade.updateDO(blStOepDO, updateFields);
					}
					
					//修改INC表中ID_ENT			
					List<BlIncOepDO> blIncOepDOList=(List<BlIncOepDO>)dafacade.findByCond(BlIncOepDO.class, " id_stoep='" + blCgItmOepDO.getId_stoep() + "'");
					if(ListUtil.isEmpty(blIncOepDOList) || blIncOepDOList.size()==0)
					{
						throw new BizException("根据结算号，查询患者发票信息失败。\r\n结算号："+blCgItmOepDO.getId_stoep());
					}					
					for(BlIncOepDO blIncOepDO:blIncOepDOList)
					{
//						blIncOepDO.setId_ent(id_ent);
						blIncOepDO.setStatus(DOStatus.UPDATED);
						dafacade.updateDO(blIncOepDO, updateFields);
					}					
				}
//				//保存bl_cg_itm_oep*****************
//				dafacade.updateDO(blCgItmOepDO, updateFields);
			}
		}
		if(blCgItmOepDOArr!=null && blCgItmOepDOArr.length>0)
		{
			iBlCgItmOepDOCudService.save(blCgItmOepDOArr);
		}
	}

}
