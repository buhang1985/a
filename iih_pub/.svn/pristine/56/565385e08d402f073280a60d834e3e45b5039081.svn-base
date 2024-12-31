package iih.pe.pwf.i;

import iih.pe.pwf.dto.pewfnextrmdto.d.PeWfNextrmDTO;
import xap.mw.core.data.BizException;

public interface IPeNextroomMaintainService {

	// 流程刷入刷出
	public boolean checkInClinicalLaboratory(String Id_pepsnappt) throws BizException;

	// 流程刷入刷出
	public boolean checkOutClinicalLaboratory(String Id_pepsnappt) throws BizException;

	// 流程刷入刷出
	public boolean checkIn(String Id_pepsnappt, String id_nur, String id_doc, String Id_pediroom) throws BizException;

	// 流程刷入刷出
	public boolean checkOut(String Id_pepsnappt, String id_nur, String id_doc, String Id_pediroom) throws BizException;

	// 下一诊间
	public boolean nextRoom(String Id_pepsnappt, String Id_pediroom) throws BizException;
	
	// 添加当前用户
	public boolean updateNurAndDoc(String Id_pepsnappt, String id_nur, String id_doc, String Id_pediroom) throws BizException;

}
