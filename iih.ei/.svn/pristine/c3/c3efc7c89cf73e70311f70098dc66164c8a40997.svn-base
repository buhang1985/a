package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.en.aptidbyaptcode.d.AptIdByAptCodeDTO;
import iih.ei.std.d.v1.en.aptidbyaptcode.d.AptIdByAptCodeParamDTO;
import iih.ei.std.d.v1.en.aptidbyaptcode.d.AptIdByAptCodeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取患者预约列表BP
 * 
 * @author li.wm
 */
public class GetAptIdByAptCodeBP extends IIHServiceBaseBP<AptIdByAptCodeParamDTO, AptIdByAptCodeResultDTO>{
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(AptIdByAptCodeParamDTO param) throws BizException {
		
		if (param.getCode_apt_ex() == null) {
			throw new BizException("预约编码不能为空！");
		}
		
	}

	@Override
	protected AptIdByAptCodeResultDTO process(AptIdByAptCodeParamDTO param) throws BizException {
		AptIdByAptCodeResultDTO resultDTO = new AptIdByAptCodeResultDTO();
		
		SqlParam sqlParam = new SqlParam();
		String  sql = "SELECT ID_APT FROM SC_APT APT WHERE APT.CODE  = ?";
		sqlParam.addParam(param.getCode_apt_ex());
		
		List<AptIdByAptCodeDTO> list = this.findDataList(sql, sqlParam, AptIdByAptCodeDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		resultDTO.setAptidbyaptcode(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	
	
}
