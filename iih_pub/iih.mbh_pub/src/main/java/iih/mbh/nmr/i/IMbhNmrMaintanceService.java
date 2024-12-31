package iih.mbh.nmr.i;

import java.util.List;
import xap.mw.core.data.BizException;
import javax.jws.WebParam;
import javax.jws.WebService;
import iih.mbh.nmr.kb.d.KbButtonDTO;
import iih.mbh.nmr.doc.d.DocSetDTO;
import iih.mbh.nmr.kb.d.KeyBoardDTO;
import iih.mbh.nmr.doc.d.DocContentDTO;
import iih.mbh.nmr.mrtpl.d.PatVtMobileDTO;
import iih.mbh.nmr.doc.d.DocDTO;
import iih.mbh.nmr.doc.d.DocIndexDTO;
import iih.mbh.nmr.mrtpl.d.MrtplItmDTO;
import iih.mbh.nmr.mrtpl.d.DayTimeDTO;
import iih.mbh.nmr.mrtpl.d.VtResultMobileDTO;

@WebService
public interface IMbhNmrMaintanceService {

	// 保存体温单逻辑
	public abstract boolean saveTcInfo(@WebParam(name="patvts") PatVtMobileDTO patvts) throws BizException;

	public abstract String saveDocInfo(@WebParam(name="docs") List<DocDTO> docs, @WebParam(name="id_doc") String id_doc, @WebParam(name="id_ana") String id_ana) throws BizException;

}
