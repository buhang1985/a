package iih.bd.srv.emreditor.s;

import iih.bd.srv.emreditor.bp.EmreditorBp;
import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emreditor.i.IEmreditorService;
import xap.mw.core.data.BizException;

public class EmreditorServiceImpl implements IEmreditorService {

	@Override
	public int getMaxVersionByCode(String code) throws BizException {
		EmreditorBp emreditorBp = new EmreditorBp();
		return emreditorBp.getMaxVersionByCode(code);
	}

	@Override
	public String CopyEmreditor(EmrEditorDO emrEditorDO) throws BizException {
		EmreditorBp emreditorBp = new EmreditorBp();
		return emreditorBp.CopyEmreditor(emrEditorDO);
	}

}
