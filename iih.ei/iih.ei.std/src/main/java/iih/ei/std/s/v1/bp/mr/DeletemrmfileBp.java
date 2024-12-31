package iih.ei.std.s.v1.bp.mr;

import java.util.List;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoCudService;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.ei.std.d.v1.mr.deletemrmfile.d.DeletemrmfileParamDTO;
import iih.ei.std.d.v1.mr.deletemrmfile.d.DeletemrmfileResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/***
 * 第三方删除病案文件
 * 
 * @author 病历
 * @date: 2019-12-03
 */
public class DeletemrmfileBp extends IIHServiceBaseBP<DeletemrmfileParamDTO, DeletemrmfileResultDTO> {

	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(DeletemrmfileParamDTO param) throws BizException {
		if (param.getId_busy() == null || StringUtil.isEmpty(param.getId_busy())) {
			throw new BizException("业务主键id为空");
		}
		if (param.getCode_set() == null || StringUtil.isEmpty(param.getCode_set())) {
			throw new BizException("数据集编码code为空");
		} 
	}

	/**
	 * 核心处理
	 */
	@Override
	protected DeletemrmfileResultDTO process(DeletemrmfileParamDTO param) throws BizException {
		DeletemrmfileResultDTO result = new DeletemrmfileResultDTO();
		String str = "";
		DAFacade daf = new DAFacade();
		StringBuilder sql = new StringBuilder();
		sql.append("select  fi.code_file,  ");// 文件系统编码
		sql.append("fi.id_bu_sy,  ");// 病历主键
		sql.append("fi.createdby,  ");// 创建人
		sql.append("amr.sd_qa_doctor_part_sta  def5  ");// 病案状态
		sql.append("from ci_mrm_fi fi  ");
		sql.append("left join ci_amr amr on fi.id_ci_amr = amr.id_enhr  ");
		sql.append("left join ci_mr mr on fi.id_bu_sy = mr.id_mr  ");
		sql.append("left join bd_mrtp mrtp on mr.id_mrtp=mrtp.id_mrtp   ");
		sql.append("left join bd_set bdset on mrtp.id_data_set=bdset.id_set  ");
		sql.append("where fi.id_bu_sy='" + param.getId_busy() + "' ");
		sql.append("and  bdset.code='" + param.getCode_set() + "' ");
		sql.append("order by fi.sv asc");
		String sqlStr = sql.toString();
		@SuppressWarnings("unchecked")
		List<CiMrmFileInfoDO> listMr = (List<CiMrmFileInfoDO>) daf.execQuery(sqlStr,
				new BeanListHandler(CiMrmFileInfoDO.class));
		if (listMr != null && listMr.size() > 0) {
			BusinessStorageService storSer = ServiceFinder.find(BusinessStorageService.class);// 添加从文件系统删除文件的调用
			ICimrmfileinfoCudService cimrmfileinfoCudService = ServiceFinder.find(ICimrmfileinfoCudService.class);
			ICimrmfileinfoRService ciMrmFileInfoRService = ServiceFinder.find(ICimrmfileinfoRService.class);
			for (CiMrmFileInfoDO fido : listMr) {
				if (Context.get().getUserId().equals(fido.getCreatedby())) {
					if (fido.getDef5() == null || !fido.getDef5().equals("09")) {
						//文件系统文件删除
						storSer.delete(fido.getCode_file());
						//文件信息表删除
						CiMrmFileInfoDO[] dos = ciMrmFileInfoRService.find("  a0.id_bu_sy = '" + fido.getId_bu_sy()+ "'", "sortno desc",FBoolean.FALSE);
						if (dos != null && dos.length > 0) {
							cimrmfileinfoCudService.delete(dos);
						}									
						str = "1";// 病案文件已删除
						//---------------------提供业务日志供科室查询-------------------------		
					} else {
						str = "2";// 病案已入库
					}
				} else {
					str = "3";// 当前登录用户和文件上传用户不匹配
				}
			}
		} else {
			str = "4";// 病案文件信息未查到
		}
		result.setFlag(str);
		return result;
	}

}
