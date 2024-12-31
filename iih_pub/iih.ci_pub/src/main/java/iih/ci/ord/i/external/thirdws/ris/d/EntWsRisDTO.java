package iih.ci.ord.i.external.thirdws.ris.d;

import java.util.List;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
/**
 * 第三方检查就诊
 * @author yangdong
 *
 */
public class EntWsRisDTO extends EntWsDTO {
	/**
	 * 检查费用DTO_第三方系统回传
	 * @return List<EmsDrugsPresDTO>
	 */
	public List<EmsRisPrintDTO> getPrintList() {
		return ((List<EmsRisPrintDTO>) getAttrVal("PrintList"));
	}
	/**
	 * 检查费用DTO_第三方系统回传
	 * @param PresList
	 */
	public void setPrintList(List<EmsRisPrintDTO> printList) {
		setAttrVal("PrintList", printList);
	}

}
