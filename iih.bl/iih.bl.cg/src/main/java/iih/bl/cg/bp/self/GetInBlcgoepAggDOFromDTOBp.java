package iih.bl.cg.bp.self;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 获取收费明细AGGDTO
 * @author LIM
 *
 */
public class GetInBlcgoepAggDOFromDTOBp {
	 public BlCgOepAggDTO exec(BlOrderAppendBillParamDTO[] blOrdersDTOs, OperatorInfoDTO operatorInfoDTO, String sdTypeIncca, String codeIncpkg) throws BizException
     {
         String condStr = "";
         String key ="";
         List<String> Lst = new ArrayList<String>();
         for (int i = 0; i < blOrdersDTOs.length; i++)
         {
       	  key = blOrdersDTOs[i].getOutpBillDTO().getId_cgoep() ;
             if (!Lst.contains(key))
             {
				Lst.add(key);
				condStr = condStr + " a0.id_cgoep='" + blOrdersDTOs[i].getOutpBillDTO().getId_cgoep() + "' or ";
             }
         }
         if (condStr.length() > 3)
         {
             condStr = condStr.substring(0, condStr.length() - 3);
         }
         //调用标准BlCgOepAgg服务,condStr是查询条件
         BlCgOepAggDTO blCgOepAggDTO = new BlCgOepAggDTO();
         IBLCiOrderToBlCgService service = ServiceFinder.find(IBLCiOrderToBlCgService.class);
         blCgOepAggDTO = service.FindNoSettlementBlcgoepAggDOWithNewInvocie(condStr, operatorInfoDTO, sdTypeIncca, codeIncpkg);  
         return blCgOepAggDTO;
     }
}
