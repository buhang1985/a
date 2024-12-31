package iih.ci.ord.i.external.thirdws.lis.d;

import java.util.List;

import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsPresDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisOrdDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisPrintDTO;
import iih.ci.ord.i.external.thirdws.lis.d.EmsLisSrvDTO;

/**
 * @code 第三方入参 检验就诊
 * @author LiYue
 * @date 2019年6月17日,下午6:05:59
 */
public class EntWsLisDTO extends EntWsDTO{
		/**
		 * 检验费用DTO_第三方系统回传
		 * @return List<EmsDrugsPresDTO>
		 */
		public List<EmsLisPrintDTO> getPrintList() {
			return ((List<EmsLisPrintDTO>) getAttrVal("PrintList"));
		}
		/**
		 * 检验费用DTO_第三方系统回传
		 * @param PresList
		 */
		public void setPrintList(List<EmsLisPrintDTO> printList) {
			setAttrVal("PrintList", printList);
		}
}
