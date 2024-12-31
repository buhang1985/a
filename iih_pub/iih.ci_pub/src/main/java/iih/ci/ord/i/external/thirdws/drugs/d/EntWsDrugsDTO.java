package iih.ci.ord.i.external.thirdws.drugs.d;

import java.util.List;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
/**
 * 药品的诊断信息
 * @author zhangwq
 *
 */
public class EntWsDrugsDTO extends EntWsDTO {
	/**
	 * 处方信息
	 * @return List<EmsDrugsPresDTO>
	 */
	public List<EmsDrugsPresDTO> getPresList() {
		return ((List<EmsDrugsPresDTO>) getAttrVal("PresList"));
	}
	/**
	 * 处方信息
	 * @param PresList
	 */
	public void setPresList(List<EmsDrugsPresDTO> PresList) {
		setAttrVal("PresList", PresList);
	}
}
