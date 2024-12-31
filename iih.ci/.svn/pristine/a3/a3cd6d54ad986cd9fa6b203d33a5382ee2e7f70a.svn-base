package iih.ci.mb.bp;

import java.io.InputStream;
import org.apache.activemq.util.ByteArrayInputStream;

import iih.bd.base.utils.BaseAppUtil;
import iih.bd.base.utils.FileServerUtils;
import iih.ci.mb.dcmo.d.DoctorMemoFileDO;
import iih.ci.mb.dcmo.d.DoctorMemoDO;
import iih.ci.mb.dcmo.d.DoctormemoAggDO;
import iih.ci.mb.dcmo.i.IDoctormemoCudService;
import iih.ci.mb.dcmo.i.IDoctormemoRService;
import iih.ci.mb.i.DCDoctorMemorandum;
import iih.ci.mb.i.DCMemorandumFile;
import iih.ci.mb.i.SaveDoctorMemorandumRequest;
import iih.ci.mb.i.SaveDoctorMemorandumResponse;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医生备忘录
 * 
 * @author wangwei
 * @since 2018-03-20
 *
 */
public class SaveDoctorMemorandumBP {

	/**
	 * 保存备忘录
	 * 
	 * @param request
	 *            备忘录对象
	 * @return SavDoctorMemorandumResponse 保存状态 int 1:成功；0：失败
	 * @throws BizException
	 */
	public SaveDoctorMemorandumResponse exec(SaveDoctorMemorandumRequest request) throws BizException {

		SaveDoctorMemorandumResponse rtn = new SaveDoctorMemorandumResponse();

		// 1、基础校验
		if (!validation(request.getModel()))
			return rtn;

		// 2、处理相关信息
		DoctormemoAggDO[] doctormemoAggDOs = handleData(request);

		// 3、存数据
		DoctormemoAggDO[] doctormemoAggDOs2 = saveDoctorMemo(request, doctormemoAggDOs);

		if (doctormemoAggDOs2 == null || doctormemoAggDOs2.length < 1)
			return rtn;

		// 4、封装返回值
		getReturn(rtn, doctormemoAggDOs2);

		return rtn;
	}

	/**
	 * 保存备忘录
	 * 
	 * @param request
	 *            请求的备忘录对象
	 * @param doctorMemoAggDos
	 *            备忘录集合
	 * @return DoctormemoAggDo 备忘录集合
	 * @throws BizException
	 */
	private DoctormemoAggDO[] saveDoctorMemo(SaveDoctorMemorandumRequest request, DoctormemoAggDO[] doctormemoAggDOs)
			throws BizException {
		DoctormemoAggDO[] doctormemoAggDOs2;
		DoctormemoAggDO docAggHad = ServiceFinder.find(IDoctormemoRService.class)
				.findById(request.getModel().getGUID());
		if (docAggHad != null && docAggHad.getParentDO() != null) {
			DoctorMemoFileDO[] doctorMemoFiles = docAggHad.getDoctorMemoFileDO();
			if (doctorMemoFiles != null && doctorMemoFiles.length > 0) {
				for (DoctorMemoFileDO doctorMemoFile : doctorMemoFiles) {

					FileServerUtils.Delete(doctorMemoFile.getFilename(), true);
				}
			}
			doctormemoAggDOs2 = new DoctormemoAggDO[] { docAggHad };
			ServiceFinder.find(IDoctormemoCudService.class).delete(doctormemoAggDOs2);

		}

		return doctormemoAggDOs2 = ServiceFinder.find(IDoctormemoCudService.class).insert(doctormemoAggDOs);
	}

	/**
	 * 对象转换
	 * 
	 * @param request
	 *            请求的备忘录集合对象
	 * @return DoctormemoAggDO 备忘录对象集合
	 * @throws BizException
	 */
	private DoctormemoAggDO[] handleData(SaveDoctorMemorandumRequest request) throws BizException {
		DoctormemoAggDO[] doctormemoAggDOs = new DoctormemoAggDO[1];
		DCMemorandumFile[] dcFiles = request.getModel().getFileList().getDCMemorandumFile();

		DoctorMemoFileDO[] doctormemoFileDOs = new DoctorMemoFileDO[dcFiles.length];
		DoctormemoAggDO doctorAggdo = new DoctormemoAggDO();

		int i = 0;
		if (dcFiles != null && dcFiles.length > 0) {
			for (DCMemorandumFile dcMemorandumFile : dcFiles) {
				DoctorMemoFileDO doctorMemoFileDO = new DoctorMemoFileDO();
				String fileName = new String();// dcMemorandumFile.getID();

				fileName = writeFile(dcMemorandumFile.getDataContent().getBytes());

				String FContentType = "1";
				FContentType = dcMemorandumFile.getContentType();
				String ExtName = ".png";
				doctorMemoFileDO.setContenttype(FContentType);
				doctorMemoFileDO.setDt_act(BaseAppUtil.getServerDateTime());
				if (FContentType == "1")
					ExtName = ".png";
				if (FContentType == "2")
					ExtName = ".pni";
				if (FContentType == "3")
					ExtName = ".mov";

				doctorMemoFileDO.setFileextname(ExtName);
				doctorMemoFileDO.setFilename(fileName);

				doctormemoFileDOs[i] = doctorMemoFileDO;
				i++;
			}
		}

		DoctorMemoDO doctorMemodo = new DoctorMemoDO();
		doctorMemodo.setId_ent(request.getModel().getPatientID());
		doctorMemodo.setContent(request.getModel().getContent());
		doctorMemodo.setDoctor(request.getModel().getCreateDoctorName());
		doctorMemodo.setDt_act(BaseAppUtil.getServerDateTime());

		doctorMemodo.setTitle(request.getModel().getTitle());
		doctorMemodo.setId_grp(xap.mw.core.data.Context.get().getGroupId());
		doctorMemodo.setId_org(xap.mw.core.data.Context.get().getOrgId());

		doctorAggdo.setParentDO(doctorMemodo);
		doctorAggdo.setDoctorMemoFileDO(doctormemoFileDOs);

		doctormemoAggDOs[0] = doctorAggdo;

		return doctormemoAggDOs;
	}

	/**
	 * 返回备忘录对象格式转换
	 * 
	 * @param doctormemoAggDos2
	 *            备忘录集合
	 * @return rtn 备忘录对象集合
	 * @throws BizException
	 */
	private void getReturn(SaveDoctorMemorandumResponse rtn, DoctormemoAggDO[] doctormemoAggDOs2) {

		if (doctormemoAggDOs2 != null && doctormemoAggDOs2.length > 0)
			rtn.setSaveDoctorMemorandumResult(1);
		else {

			rtn.setSaveDoctorMemorandumResult(0);
		}
	}

	private boolean validation(DCDoctorMemorandum doctormemo) {

		if (doctormemo == null)
			return false;

		return true;
	}

	/**
	 * 把文件流写入文件服务器
	 * 
	 * @param szData
	 *            文件二进制流
	 * @return newfileKey 文件关键字
	 * @throws BizException
	 */
	private String writeFile(byte[] szData) throws BizException {

		InputStream inputStream = new ByteArrayInputStream(szData);

		String newFileKey = FileServerUtils.Upload("", inputStream, true);
		if (newFileKey != null && newFileKey != "")
			return newFileKey;
		else
			return null;

	}

}
