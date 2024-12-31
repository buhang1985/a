package iih.ei.itf.eiitfcate.s;

import java.io.ByteArrayInputStream;

import iih.bd.base.utils.FileServerUtils;
import iih.bd.utils.ContextUtils;
import iih.ei.itf.eiitfcate.d.ItfDocTaskDO;
import iih.ei.itf.eiitfcate.i.IItfdocCudService;
import iih.ei.itf.eiitfcate.i.IItfdocRService;
import iih.ei.itf.eiitfcate.s.bp.BuildPDFFileByCateIdBp;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 构建PDF文件任务</br>
 * 构建接口分类PDF文档
 * 
 * @author hao_wu 2019-10-28
 *
 */
public class BuildPDFFileTask implements IBackgroundWorkPlugin {

	public static final String PARAM_TASKID = "TaskId";
	public static final String PARAM_PSNID = "PsnId";

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {

		String taskId = (String) arg0.getKeyMap().get(PARAM_TASKID);
		String psnId = (String) arg0.getKeyMap().get(PARAM_PSNID);

		ContextUtils.initContextByPsnId(psnId);

		IItfdocRService taskRService = ServiceFinder.find(IItfdocRService.class);
		ItfDocTaskDO taskDo = taskRService.findById(taskId);

		BuildPDFFileByCateIdBp bp = new BuildPDFFileByCateIdBp();
		byte[] pdfFile = bp.exec(taskDo.getId_itfca());

		ByteArrayInputStream stream = new ByteArrayInputStream(pdfFile);
		String filePath = FileServerUtils.Upload(stream);

		taskDo.setPath_file(filePath);
		IItfdocCudService taskCudService = ServiceFinder.find(IItfdocCudService.class);
		taskCudService.update(new ItfDocTaskDO[] { taskDo });

		return new PreAlertObject();
	}

}
