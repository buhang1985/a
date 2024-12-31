package iih.ci.mb.bp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.FileServerUtils;
import iih.ci.mb.dcmo.d.DoctorMemoFileDO;
import iih.ci.mb.dcmo.d.DoctorMemoDO;
import iih.ci.mb.dcmo.d.DoctormemoAggDO;
import iih.ci.mb.dcmo.i.IDoctorMemoFileDORService;
import iih.ci.mb.dcmo.i.IDoctormemoRService;
import iih.ci.mb.i.ArrayOfDCDoctorMemorandum;
import iih.ci.mb.i.ArrayOfDCMemorandumFile;
import iih.ci.mb.i.DCDoctorMemorandum;
import iih.ci.mb.i.DCMemorandumFile;
import iih.ci.mb.i.GetDoctorMemorandumListRequest;
import iih.ci.mb.i.GetDoctorMemorandumListResponse;
import sun.misc.BASE64Encoder;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取医生备忘录
 * 
 * @author wangwei
 * @since 2018-03-20
 *
 */
public class GetDoctorMemorandumListByEntBP {

	final BASE64Encoder encoder = new BASE64Encoder();

	/**
	 * 获取医生备忘录
	 * 
	 * @param request
	 *            病人信息
	 * @return 备忘录集合
	 * @throws BizException
	 * @throws IOException
	 */
	public GetDoctorMemorandumListResponse exec(GetDoctorMemorandumListRequest request)
			throws BizException, IOException {

		GetDoctorMemorandumListResponse rtn = new GetDoctorMemorandumListResponse();

		// 1、基础校验
		if (!validation(request.getPatientID()))
			return rtn;

		// 2、查询数据
		DoctormemoAggDO[] doctorMemoAgg = ServiceFinder.find(IDoctormemoRService.class)
				.findByAttrValString(DoctorMemoDO.ID_ENT, request.getPatientID());
		if (doctorMemoAgg == null || doctorMemoAgg.length < 1)
			return rtn;

		// 3、封装返回值
		getReturn(rtn, doctorMemoAgg);

		return rtn;

	}

	/**
	 * 备忘录实体对象集合转换成前端备忘录对象集合
	 * 
	 * @param doctorMemoAgg
	 *            备忘录几个
	 * @return rtn 返回备忘录对象集合
	 * @throws BizException
	 * @throws IOException
	 */
	private void getReturn(GetDoctorMemorandumListResponse rtn, DoctormemoAggDO[] doctorMemoAgg) throws IOException {
		if (doctorMemoAgg != null && doctorMemoAgg.length > 0) {
			ArrayOfDCDoctorMemorandum array = new ArrayOfDCDoctorMemorandum();
			DCDoctorMemorandum[] doctorMemorandums = new DCDoctorMemorandum[doctorMemoAgg.length];
			// DCDoctorMemorandum-->DoctorMemoDO
			int i = 0;
			for (DoctormemoAggDO docmemoAggDO : doctorMemoAgg) {

				DoctorMemoDO docMemoDO = docmemoAggDO.getParentDO();
				DCDoctorMemorandum dcDoctorMemorandum = new DCDoctorMemorandum();
				if (docMemoDO == null)
					continue;
				else {
					dcDoctorMemorandum.setGUID(docMemoDO.getId_memo());
					dcDoctorMemorandum.setPatientID(docMemoDO.getId_ent());
					dcDoctorMemorandum.setTitle(docMemoDO.getTitle());
					dcDoctorMemorandum.setContent(docMemoDO.getContent());
					dcDoctorMemorandum.setCreateTime(docMemoDO.getCreatedtime().toString());
					dcDoctorMemorandum.setCreateDoctorName(docMemoDO.getName_doc());
					try {
						DoctorMemoFileDO[] doctorMemoFiles = ServiceFinder.find(IDoctorMemoFileDORService.class)
								.findByAttrValString("Id_memo", docMemoDO.getId_memo().trim());
						ArrayOfDCMemorandumFile arrayOfDCMemorandumFile = new ArrayOfDCMemorandumFile();
						if (doctorMemoFiles != null && doctorMemoFiles.length > 0) {
							DCMemorandumFile[] dcMemoFiles = new DCMemorandumFile[doctorMemoFiles.length];
							if (doctorMemoFiles != null && doctorMemoFiles.length > 0) {
								int j = 0;
								for (DoctorMemoFileDO doctorMemoFile : doctorMemoFiles) {
									DCMemorandumFile dcMemoFile = new DCMemorandumFile();
									dcMemoFile.setMainID(doctorMemoFile.getId_memo());
									dcMemoFile.setID(doctorMemoFile.getId_mefi());
									dcMemoFile.setGUID(doctorMemoFile.getId_mefi());
									dcMemoFile.setFileUrl(doctorMemoFile.getFilename());
									dcMemoFile.setFileName(doctorMemoFile.getFilename());
									dcMemoFile.setFileExtName(doctorMemoFile.getFileextname());
									dcMemoFile.setContentType(doctorMemoFile.getContenttype());
									dcMemoFile.setCreateTime(doctorMemoFile.getDt_act().toString());
									String dataContent = new String();
									dataContent = isToString(getFileData(doctorMemoFile.getFilename()));

									dcMemoFile.setDataContent(dataContent);

									dcMemoFiles[j] = dcMemoFile;
									j++;
								}
							}
							arrayOfDCMemorandumFile.setDCMemorandumFile(dcMemoFiles);
							dcDoctorMemorandum.setFileList(arrayOfDCMemorandumFile);
						}
					} catch (BizException e) {
						e.printStackTrace();
					}

				}

				doctorMemorandums[i] = dcDoctorMemorandum;
				i++;

			}

			List<DCDoctorMemorandum> list = new ArrayList<>();

			for (DCDoctorMemorandum dcDoctorMemorandum : doctorMemorandums) {
				list.add(dcDoctorMemorandum);
			}

			array.setDCDoctorMemorandum(list.toArray(new DCDoctorMemorandum[list.size()]));
			rtn.setGetDoctorMemorandumListResult(array);
		}
	}

	/**
	 * 从文件服务器获取文件流
	 * 
	 * @param fileKey
	 *            文件关键字
	 * @return InputStream 文件流
	 * @throws BizException
	 */

	public InputStream getFileData(String fileKey) throws BizException {
		InputStream inputStream = FileServerUtils.Download(fileKey, true);
		try {
			if (inputStream != null && inputStream.available() > 0)
				return inputStream;
			else
				return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean validation(String patientID) {
		if (patientID == null)
			return false;
		if (StringUtil.isEmptyWithTrim(patientID))
			return false;

		return true;
	}

	/**
	 * 文件流转换字符串
	 * 
	 * @param InputStream
	 *            文件流
	 * @return String 字符串
	 * @throws BizException
	 */
	public String isToString(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int n = 0;
		while ((n = in.read(buffer)) != -1) {
			out.write(buffer, 0, n);
		}
		return out.toString();
	}

}
