package iih.bl.hp.Service.s.Bp;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.viewmziihypshare.d.ViewMzIihYpShareDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医嘱共享需要的。
 * 北大国际医院上线阶段CHIS与IIH有一段时间是同时运行，为了处理首信要求的医嘱共享需求，CHIS提供了一个视图接口方便IIH获取患者在CHIS中开的药品
 * @author tcy
 *
 */
public class BlHpInteractiveWithCHISBp extends GetMzYpDataFromChisViewBp {
		
	/**
	 * 根据患者编码，获取患者在CHIS中的开药信息，并转换成CiHpCheckDTO结构，供医嘱开单整体校验使用
	 * @param code 患者编码
	 * @return
	 * @throws BizException
	 */
	public CiHpCheckDTO getCiHpCheckDTOFromCHIS(String code) throws BizException 
	{
		DAFacade dafacade=new DAFacade();
		List<MedSrvDO> medSrvDOLst = new ArrayList<MedSrvDO>();
		CiHpCheckDTO ciHpCheckDTO=null;
		ViewMzIihYpShareDTO[] shareArray =null;
		List<ViewMzIihYpShareDTO> viewMzIihYpShareDTOs = new ArrayList<ViewMzIihYpShareDTO>();
		try
		{
			//1. 获得CHIS数据		
			shareArray = this.getEBSBatchDTOs(code);
			if(!ArrayUtil.isEmpty(shareArray)){
				viewMzIihYpShareDTOs.addAll(Arrays.asList(shareArray));
		    }
		}
		catch(BizException e)
		{
		    //老his服务获取失败时，返回空数据
			return null;
		}
		
		//2.区分出已收费，未收费，已经收费的，配置成Historycidto，未收费的，配置成Savecidto
//		FArrayList2 savecidtoLst=new FArrayList2();
		FArrayList2 historycidtoLst=new FArrayList2();//已收费
		FArrayList2 ordsrvList_history=new FArrayList2();//已收费
		FArrayList2 orSrvMmList_history=new FArrayList2();//已收费
//		FArrayList2 noPaycidtoLst=new FArrayList2();//未收费
//		FArrayList2 ordsrvList_noPay=new FArrayList2();//未收费
//		FArrayList2 orSrvMmList_noPay=new FArrayList2();//未收费
		Map<String,String> FreqMap=new HashMap<String,String>();//<code,id_freq>
		String sd_srvtp="";
		String id_srv="";
		String id_mm="";
		String id_freq="";				
		int id_or=1;
		int id_orsrv=1;
		int id_orsrvmm=1;
		FDouble quan_cur=new FDouble(0);
		for(ViewMzIihYpShareDTO viewMzIihYpShareDTO: viewMzIihYpShareDTOs)
		{
			//翻译sd_srvtp,获得对照的id_srv
			medSrvDOLst= (List<MedSrvDO>) dafacade.execQuery(
					"select b.id_srv,a.id_mm as id_mmbind_op,b.sd_srvtp, a.code from bd_mm a,bd_srv b  where a.id_srv=b.id_srv and a.code='" + viewMzIihYpShareDTO.getCharge_code() + "'", new BeanListHandler(
							MedSrvDO.class));
			if(medSrvDOLst==null || medSrvDOLst.size()==0)
			{
				continue;
			}
			sd_srvtp=medSrvDOLst.toArray(new MedSrvDO[0])[0].getSd_srvtp();
			id_srv=medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_srv();
			id_mm=medSrvDOLst.toArray(new MedSrvDO[0])[0].getId_mmbind_op();
			//翻译频次
			if(!FreqMap.containsKey(viewMzIihYpShareDTO.getFreq_code()))
			{	
				List<FreqDefDO> freqDefDOLst=(List<FreqDefDO>)dafacade.execQuery(" select id_freq,code from bd_freq where code='"+viewMzIihYpShareDTO.getFreq_code()+"'", new BeanListHandler(FreqDefDO.class));
				if(freqDefDOLst==null || freqDefDOLst.size()==0)
				{
					continue;
				}
				FreqMap.put(viewMzIihYpShareDTO.getFreq_code(), freqDefDOLst.toArray(new FreqDefDO[0])[0].getId_freq());
			}
			id_freq=FreqMap.get(viewMzIihYpShareDTO.getFreq_code());

				HpQryCiorderDTO hpQryCiorderDTO=new HpQryCiorderDTO();
				OrdSrvDO ordSrvDO=new OrdSrvDO();
				OrdSrvMmDO ordSrvMmDO=new OrdSrvMmDO();
				CiOrderDO ciOrderDO=new CiOrderDO();
				//重新清空
				ordsrvList_history=new FArrayList2();//已收费
				orSrvMmList_history=new FArrayList2();//已收费
				
				ciOrderDO.setId_srv("chis_"+viewMzIihYpShareDTO.getCharge_code());
				ciOrderDO.setName_or(viewMzIihYpShareDTO.getDrugname());
				ciOrderDO.setDays_or(viewMzIihYpShareDTO.getPersist_days());
				ciOrderDO.setSd_srvtp(sd_srvtp);
				ciOrderDO.setDt_effe(viewMzIihYpShareDTO.getHappen_date());
				ciOrderDO.setId_dep_or(viewMzIihYpShareDTO.getVisit_dept());
				ciOrderDO.setId_emp_or(viewMzIihYpShareDTO.getDoctor_code());
				ciOrderDO.setId_or(viewMzIihYpShareDTO.getCharge_code()+"_"+id_or);
				ciOrderDO.setDt_entry(viewMzIihYpShareDTO.getHappen_date());//开立时间
				
				ordSrvDO.setId_freq(id_freq);
				ordSrvDO.setId_srv(id_srv);
				
				ordSrvDO.setCode_srv(medSrvDOLst.toArray(new MedSrvDO[0])[0].getCode()); 
				ordSrvDO.setName(viewMzIihYpShareDTO.getDrugname());
				ordSrvDO.setId_orsrv(viewMzIihYpShareDTO.getCharge_code()+"_"+id_orsrv);
				ordSrvDO.setId_or(viewMzIihYpShareDTO.getCharge_code()+"_"+id_or);
				ordSrvDO.setDt_create(viewMzIihYpShareDTO.getHappen_date());//开立时间
				
				ordSrvMmDO.setId_orsrvmm(viewMzIihYpShareDTO.getCharge_code()+"_"+id_orsrvmm);
				ordSrvMmDO.setId_orsrv(viewMzIihYpShareDTO.getCharge_code()+"_"+id_orsrv);
				ordSrvMmDO.setQuan_cur(viewMzIihYpShareDTO.getCharge_amount());
				ordSrvMmDO.setDays_available(viewMzIihYpShareDTO.getPersist_days());
				ordSrvMmDO.setId_srv(id_srv);
				ordSrvMmDO.setId_mm(id_mm);
				
				id_or++;
				id_orsrv++;
				id_orsrvmm++;
//				if(viewMzIihYpShareDTO.getCharge_status()==4)//已经收费的
//				{
				// 返回封装医嘱、项目、物品的集合
				HpQryCiorderDTO dto = new HpQryCiorderDTO();
				ordsrvList_history.add(ordSrvDO);
				orSrvMmList_history.add(ordSrvMmDO);
				dto.setCiorderdo(ciOrderDO); // 添加医嘱
				dto.setOrdsrvs(ordsrvList_history); // 添加服务项目
				dto.setOrdsrvmms(orSrvMmList_history);// 添加物品
				historycidtoLst.add(dto);
//				}
//				else //未收费
//				{
//					// 返回封装医嘱、项目、物品的集合
//					HpQryCiorderDTO dto_noPay = new HpQryCiorderDTO();
//					ordsrvList_noPay.add(ordSrvDO);
//					orSrvMmList_noPay.add(ordSrvMmDO);
//					dto_noPay.setCiorderdo(ciOrderDO); // 添加医嘱
//					dto_noPay.setOrdsrvs(ordsrvList_noPay); // 添加服务项目
//					dto_noPay.setOrdsrvmms(orSrvMmList_noPay);// 添加物品
//					noPaycidtoLst.add(dto_noPay);
//				}
		}

		if(historycidtoLst!=null && historycidtoLst.size()!=0) {
			ciHpCheckDTO=new CiHpCheckDTO();
			ciHpCheckDTO.setHistorycidto(historycidtoLst);  //返回老CHIS的所有数据
		}
		return ciHpCheckDTO;
	}
}
