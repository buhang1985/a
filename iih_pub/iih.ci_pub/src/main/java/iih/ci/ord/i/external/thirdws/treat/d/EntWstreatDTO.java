package iih.ci.ord.i.external.thirdws.treat.d;

import java.util.List;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;

/**
 * @code 第三方入参 诊疗就诊
 * @author LiYue
 * @date 2019年6月17日,下午6:05:59
 */
public class EntWstreatDTO extends EntWsDTO{
		/**
		 * 诊疗DTO_第三方系统回传
		 * @return List<EmsDrugsPresDTO>
		 */
		public List<EmstreatOrdDTO> getOrdList() {
			return ((List<EmstreatOrdDTO>) getAttrVal("OrdList"));
		}
		/**
		 * 诊疗DTO_第三方系统回传
		 * @param PresList
		 */
		public void setOrdList(List<EmstreatOrdDTO> ordlist) {
			setAttrVal("OrdList", ordlist);
		}
}
