package iih.bd.srv.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emreditor.i.IEmreditorCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗记录编辑器数据导入服务实现
 * 
 * @author hao_wu 2019-12-19
 *
 */
public class EmrEditorDataImptServiceImpl extends BDBaseDataImport<EmrEditorDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new EmrEditorDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { EmrEditorDO.ID_GRP, EmrEditorDO.ID_ORG, EmrEditorDO.NAME, EmrEditorDO.CODE,
				EmrEditorDO.ID_MREDTP, EmrEditorDO.SD_MREDTP, EmrEditorDO.ID_MRFMTP, EmrEditorDO.SD_MRFMTP };
	}

	@Override
	protected void insertToDB(EmrEditorDO[] importDatas) throws BizException {
		ServiceFinder.find(IEmreditorCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(EmrEditorDO[] importDatas) throws BizException {
		ServiceFinder.find(IEmreditorCudService.class).update(importDatas);
	}
}
