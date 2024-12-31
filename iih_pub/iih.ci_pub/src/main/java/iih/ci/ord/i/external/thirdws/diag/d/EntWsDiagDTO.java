package iih.ci.ord.i.external.thirdws.diag.d;

import java.util.List;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;

public class EntWsDiagDTO extends EntWsDTO{
	
	/**
	 * 诊断信息
	 * @return List<EmsDiagDto>
	 */
	public List<EmsDiagDto> getDiagList() {
		return ((List<EmsDiagDto>) getAttrVal("DiagList"));
	}
	/**
	 * 诊断信息
	 * @param DiagList
	 */
	public void setDiagList(List<EmsDiagDto> DiagList) {
		setAttrVal("DiagList", DiagList);
	}
}
