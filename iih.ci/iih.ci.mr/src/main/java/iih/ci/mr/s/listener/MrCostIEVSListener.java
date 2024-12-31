/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.iecost.d.IECostMrVSDTO;
import iih.ci.mr.iecost.d.IECostMrVSOpDTO;
import iih.ci.mr.iecost.d.IECostMrVSOpItemDTO;
import iih.ci.mr.middle.d.CiMrVSMiddleDO;
import iih.ci.mr.middle.i.ICimrvsmiddleCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrCostIEVSListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// TODO Auto-generated method stub
		FArrayList2 bizUserObj = (FArrayList2) event.getUserObject();
		if (!"iih.ci.mr.iecost.d.IECostMrVSDTO".equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			return;
		}
		IECostMrVSDTO costVSDto = (IECostMrVSDTO) bizUserObj.get(0);
		if(costVSDto==null)
		{
			return;
		}
		//FArrayList opList =costVSDto.getVsopdto();
		FArrayList2 opList =(FArrayList2) costVSDto.getAttrVal("Vsopdto");
		List<CiMrVSMiddleDO> doList=new ArrayList<CiMrVSMiddleDO>();
		if (opList!=null&&opList.size()>0) {
			IECostMrVSOpDTO[] vsOpList=(IECostMrVSOpDTO[]) opList.toArray(new IECostMrVSOpDTO[0]);
			for (IECostMrVSOpDTO opDto : vsOpList) {
				FArrayList2 itemList=(FArrayList2) opDto.getAttrVal("Opitemdto");
				if (itemList!=null&&itemList.size()>0) {
					IECostMrVSOpItemDTO[] vsItemList=(IECostMrVSOpItemDTO[])itemList.toArray(new IECostMrVSOpItemDTO[0]);
					for (IECostMrVSOpItemDTO ieCostMrVSOpItemDTO : vsItemList) {
						CiMrVSMiddleDO middleDo = new CiMrVSMiddleDO();
						middleDo.setCode_ent(costVSDto.getCode_ent());
						middleDo.setCode_pat(costVSDto.getCode_pat());
						middleDo.setTimes_ip(Integer.parseInt(costVSDto.getTimes_ip()));
						middleDo.setName_pat(costVSDto.getName_pat());
						middleDo.setCode_pat_dep(costVSDto.getCode_pat_dep());
						middleDo.setPat_dep(costVSDto.getPat_dep());
						middleDo.setCode_pat_nur(costVSDto.getCode_pat_nur());
						middleDo.setPat_nur(costVSDto.getPat_nur());
						middleDo.setCode_emp_operate(opDto.getCode_emp_operate());
						middleDo.setEmp_operate(opDto.getEmp_operate());
						middleDo.setDt_operate(opDto.getDt_operate());
						middleDo.setName_vs_item(ieCostMrVSOpItemDTO.getName_vs_item());
						middleDo.setCode_vs_item(ieCostMrVSOpItemDTO.getCode_vs_item());
						if (ICiMrDictCodeConst.SD_VITALSIGNS_BLOODPRESSURE.equals(ieCostMrVSOpItemDTO.getCode_vs_item())) {
							middleDo.setValue_vs_item_low(ieCostMrVSOpItemDTO.getValue_vs_item_low());
							middleDo.setValue_vs_item_high(ieCostMrVSOpItemDTO.getValue_vs_item_high());
							middleDo.setValue_vs_item(ieCostMrVSOpItemDTO.getValue_vs_item_low()+"/"+ieCostMrVSOpItemDTO.getValue_vs_item_high());
						}else {
							middleDo.setValue_vs_item(ieCostMrVSOpItemDTO.getValue_vs_item());
						}
						middleDo.setDt_vs_item(ieCostMrVSOpItemDTO.getDt_vs_item());
						middleDo.setStatus(DOStatus.NEW);
						doList.add(middleDo);
					}
				}
			}
		}
		ICimrvsmiddleCudService saveService =ServiceFinder.find(ICimrvsmiddleCudService.class);
		saveService.save(doList.toArray(new CiMrVSMiddleDO[0]));
	}

}
