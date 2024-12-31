package iih.ei.std.s.v1.bp.mr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ei.std.d.v1.mr.downloadmrmfileinfo.d.DownLoadMrmFileInfoParamDTO;
import iih.ei.std.d.v1.mr.downloadmrmfileinfo.d.DownLoadMrmFileInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mr.util.UnZipUtil;
import iih.mkr.std.deset.d.DeDataSetDO;
import sun.misc.BASE64Encoder;
import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FBinary;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;


/***
 * 服务端通用文件下载
 * 
 * @author 病历
 * @date: 2019-11-07
 */
public class DownLoadMrmFileInfoBp extends IIHServiceBaseBP<DownLoadMrmFileInfoParamDTO, DownLoadMrmFileInfoResultDTO> {

	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(DownLoadMrmFileInfoParamDTO param) throws BizException {
		if (param.getCode_ent() == null || StringUtil.isEmpty(param.getCode_ent())) {
			throw new BizException("就诊唯一编码为空");
		}
		if (param.getCode_set() == null || StringUtil.isEmpty(param.getCode_set())) {
			throw new BizException("数据集编码为空");
		} else {
			DAFacade daf = new DAFacade();
			StringBuilder sql = new StringBuilder();
			sql.append("select bdset.id_set  ");// 数据集主键
			sql.append("from bd_set bdset  ");
			sql.append("where bdset.code='" + param.getCode_set() + "' ");
			String sqlStr = sql.toString();
			@SuppressWarnings("unchecked")
			List<DeDataSetDO> list = (List<DeDataSetDO>) daf.execQuery(sqlStr, new BeanListHandler(DeDataSetDO.class));
			if (list != null) {
				if (list.size() == 1) {
					param.setCode_set(list.get(0).getId_set());
				}
				if (list.size() > 1) {
					throw new BizException("数据集编码不唯一");
				}
			}
		}
	}

	/**
	 * 核心处理
	 */
	@Override
	protected DownLoadMrmFileInfoResultDTO process(DownLoadMrmFileInfoParamDTO param) throws BizException {
		DownLoadMrmFileInfoResultDTO result = new DownLoadMrmFileInfoResultDTO();
		String str = "";
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select fi.code_file,  ");// 文件系统编码
		sql.append("fi.id_bu_sy,  ");// 病历主键
		sql.append("bd.code def5  ");// 性别编码
		sql.append("from ci_mrm_fi fi  ");
		sql.append("left join ci_amr amr on fi.id_ci_amr = amr.id_enhr  ");
		sql.append("left join ci_mr mr on fi.id_bu_sy = mr.id_mr  ");
		sql.append("left join bd_udidoc bd on amr.id_sex = bd.id_udidoc  ");
		sql.append("left join bd_mrtp mrtp on mr.id_mrtp=mrtp.id_mrtp   ");
		sql.append("left join bd_set bdset on mrtp.id_data_set=bdset.id_set  ");
		sql.append("left join en_ent ee on amr.id_ent=ee.id_ent ");
		sql.append("where ee.code='" + param.getCode_ent() + "' ");
		sql.append("and  bdset.id_set='" + param.getCode_set() + "' ");
		sql.append("order by fi.sv asc");
		String sqlStr = sql.toString();
		@SuppressWarnings("unchecked")
		List<CiMrmFileInfoDO> listMr = (List<CiMrmFileInfoDO>) daf.execQuery(sqlStr,
				new BeanListHandler(CiMrmFileInfoDO.class));

		if (listMr != null && listMr.size() > 0) {
			BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
			BASE64Encoder encoder = new BASE64Encoder();
			UnZipUtil util = new UnZipUtil();
			FBinary bin = null;
			byte[] bytes = null;
			for (CiMrmFileInfoDO ciMrmFileInfoDO : listMr) {
				str += "分隔符";
				try {
					bin = fileService.read(ciMrmFileInfoDO.getCode_file());
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					bin.writeBodyToStream(os);
					bytes = os.toByteArray();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				int sex = Integer.parseInt(ciMrmFileInfoDO.getDef5());
				bytes = util.unZip(bytes, (Integer) sex == null ? 0 : sex);
				String ss = encoder.encode(bytes);
				String s="";
				try {
					s = new String(ss.getBytes("GBK"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				str += s;
			}
		}
		if(str.length()>3){
		str=str.substring(3, str.length());
		}
		result.setPdf_str(str);
		return result;
	}

}
